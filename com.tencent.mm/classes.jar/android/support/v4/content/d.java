package android.support.v4.content;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

public final class d
{
  private static final Object mLock = new Object();
  private static d zj;
  private final Handler mHandler;
  private final Context ze;
  private final HashMap<BroadcastReceiver, ArrayList<d.b>> zf = new HashMap();
  private final HashMap<String, ArrayList<d.b>> zg = new HashMap();
  private final ArrayList<a> zi = new ArrayList();
  
  private d(Context paramContext)
  {
    this.ze = paramContext;
    this.mHandler = new Handler(paramContext.getMainLooper())
    {
      public final void handleMessage(Message paramAnonymousMessage)
      {
        switch (paramAnonymousMessage.what)
        {
        default: 
          super.handleMessage(paramAnonymousMessage);
          return;
        }
        d.a(d.this);
      }
    };
  }
  
  public static d Q(Context paramContext)
  {
    synchronized (mLock)
    {
      if (zj == null) {
        zj = new d(paramContext.getApplicationContext());
      }
      paramContext = zj;
      return paramContext;
    }
  }
  
  public final void a(BroadcastReceiver paramBroadcastReceiver, IntentFilter paramIntentFilter)
  {
    synchronized (this.zf)
    {
      d.b localb = new d.b(paramIntentFilter, paramBroadcastReceiver);
      Object localObject2 = (ArrayList)this.zf.get(paramBroadcastReceiver);
      Object localObject1 = localObject2;
      if (localObject2 == null)
      {
        localObject1 = new ArrayList(1);
        this.zf.put(paramBroadcastReceiver, localObject1);
      }
      ((ArrayList)localObject1).add(localb);
      int i = 0;
      while (i < paramIntentFilter.countActions())
      {
        localObject2 = paramIntentFilter.getAction(i);
        localObject1 = (ArrayList)this.zg.get(localObject2);
        paramBroadcastReceiver = (BroadcastReceiver)localObject1;
        if (localObject1 == null)
        {
          paramBroadcastReceiver = new ArrayList(1);
          this.zg.put(localObject2, paramBroadcastReceiver);
        }
        paramBroadcastReceiver.add(localb);
        i += 1;
      }
      return;
    }
  }
  
  public final boolean a(Intent paramIntent)
  {
    for (;;)
    {
      synchronized (this.zf)
      {
        String str1 = paramIntent.getAction();
        String str2 = paramIntent.resolveTypeIfNeeded(this.ze.getContentResolver());
        Uri localUri = paramIntent.getData();
        String str3 = paramIntent.getScheme();
        Set localSet = paramIntent.getCategories();
        if ((paramIntent.getFlags() & 0x8) == 0) {
          break label387;
        }
        i = 1;
        if (i != 0) {
          new StringBuilder("Resolving type ").append(str2).append(" scheme ").append(str3).append(" of intent ").append(paramIntent);
        }
        ArrayList localArrayList2 = (ArrayList)this.zg.get(paramIntent.getAction());
        if (localArrayList2 == null) {
          break label361;
        }
        if (i == 0) {
          break label372;
        }
        new StringBuilder("Action list: ").append(localArrayList2);
        break label372;
        if (j < localArrayList2.size())
        {
          d.b localb = (d.b)localArrayList2.get(j);
          if (i != 0) {
            new StringBuilder("Matching against filter ").append(localb.filter);
          }
          if (localb.zn)
          {
            if (i == 0) {
              break label369;
            }
            break label380;
          }
          int k = localb.filter.match(str1, str2, str3, localUri, localSet, "LocalBroadcastManager");
          if (k < 0) {
            break label369;
          }
          if (i != 0) {
            new StringBuilder("  Filter matched!  match=0x").append(Integer.toHexString(k));
          }
          if (localArrayList1 != null) {
            break label366;
          }
          localArrayList1 = new ArrayList();
          localArrayList1.add(localb);
          localb.zn = true;
        }
      }
      if (localArrayList1 != null)
      {
        i = 0;
        while (i < localArrayList1.size())
        {
          ((d.b)localArrayList1.get(i)).zn = false;
          i += 1;
        }
        this.zi.add(new a(paramIntent, localArrayList1));
        if (!this.mHandler.hasMessages(1)) {
          this.mHandler.sendEmptyMessage(1);
        }
        return true;
      }
      label361:
      return false;
      label366:
      continue;
      label369:
      break label380;
      label372:
      ArrayList localArrayList1 = null;
      int j = 0;
      continue;
      label380:
      j += 1;
      continue;
      label387:
      int i = 0;
    }
  }
  
  public final void unregisterReceiver(BroadcastReceiver paramBroadcastReceiver)
  {
    for (;;)
    {
      int i;
      int j;
      int k;
      synchronized (this.zf)
      {
        ArrayList localArrayList1 = (ArrayList)this.zf.remove(paramBroadcastReceiver);
        if (localArrayList1 == null) {
          return;
        }
        i = localArrayList1.size() - 1;
        if (i >= 0)
        {
          d.b localb1 = (d.b)localArrayList1.get(i);
          localb1.zo = true;
          j = 0;
          if (j >= localb1.filter.countActions()) {
            break label203;
          }
          String str = localb1.filter.getAction(j);
          ArrayList localArrayList2 = (ArrayList)this.zg.get(str);
          if (localArrayList2 == null) {
            break label196;
          }
          k = localArrayList2.size() - 1;
          if (k >= 0)
          {
            d.b localb2 = (d.b)localArrayList2.get(k);
            if (localb2.zm == paramBroadcastReceiver)
            {
              localb2.zo = true;
              localArrayList2.remove(k);
            }
          }
          else
          {
            if (localArrayList2.size() > 0) {
              break label196;
            }
            this.zg.remove(str);
            break label196;
          }
        }
        else
        {
          return;
        }
      }
      k -= 1;
      continue;
      label196:
      j += 1;
      continue;
      label203:
      i -= 1;
    }
  }
  
  private static final class a
  {
    final Intent intent;
    final ArrayList<d.b> zl;
    
    a(Intent paramIntent, ArrayList<d.b> paramArrayList)
    {
      this.intent = paramIntent;
      this.zl = paramArrayList;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     android.support.v4.content.d
 * JD-Core Version:    0.7.0.1
 */