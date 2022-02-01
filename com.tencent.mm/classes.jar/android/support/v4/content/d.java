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
  private static d Gd;
  private static final Object mLock = new Object();
  final Context FZ;
  final HashMap<BroadcastReceiver, ArrayList<b>> Ga = new HashMap();
  private final HashMap<String, ArrayList<b>> Gb = new HashMap();
  final ArrayList<a> Gc = new ArrayList();
  private final Handler mHandler;
  
  private d(Context paramContext)
  {
    this.FZ = paramContext;
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
        paramAnonymousMessage = d.this;
        for (;;)
        {
          synchronized (paramAnonymousMessage.Ga)
          {
            i = paramAnonymousMessage.Gc.size();
            if (i <= 0) {
              return;
            }
          }
          d.a[] arrayOfa = new d.a[i];
          paramAnonymousMessage.Gc.toArray(arrayOfa);
          paramAnonymousMessage.Gc.clear();
          int i = 0;
          while (i < arrayOfa.length)
          {
            ??? = arrayOfa[i];
            int k = ???.Gf.size();
            int j = 0;
            while (j < k)
            {
              d.b localb = (d.b)???.Gf.get(j);
              if (!localb.Gh) {
                localb.receiver.onReceive(paramAnonymousMessage.FZ, ???.intent);
              }
              j += 1;
            }
            i += 1;
          }
        }
      }
    };
  }
  
  public static d T(Context paramContext)
  {
    synchronized (mLock)
    {
      if (Gd == null) {
        Gd = new d(paramContext.getApplicationContext());
      }
      paramContext = Gd;
      return paramContext;
    }
  }
  
  public final void a(BroadcastReceiver paramBroadcastReceiver, IntentFilter paramIntentFilter)
  {
    synchronized (this.Ga)
    {
      b localb = new b(paramIntentFilter, paramBroadcastReceiver);
      Object localObject2 = (ArrayList)this.Ga.get(paramBroadcastReceiver);
      Object localObject1 = localObject2;
      if (localObject2 == null)
      {
        localObject1 = new ArrayList(1);
        this.Ga.put(paramBroadcastReceiver, localObject1);
      }
      ((ArrayList)localObject1).add(localb);
      int i = 0;
      while (i < paramIntentFilter.countActions())
      {
        localObject2 = paramIntentFilter.getAction(i);
        localObject1 = (ArrayList)this.Gb.get(localObject2);
        paramBroadcastReceiver = (BroadcastReceiver)localObject1;
        if (localObject1 == null)
        {
          paramBroadcastReceiver = new ArrayList(1);
          this.Gb.put(localObject2, paramBroadcastReceiver);
        }
        paramBroadcastReceiver.add(localb);
        i += 1;
      }
      return;
    }
  }
  
  public final boolean b(Intent paramIntent)
  {
    for (;;)
    {
      synchronized (this.Ga)
      {
        String str1 = paramIntent.getAction();
        String str2 = paramIntent.resolveTypeIfNeeded(this.FZ.getContentResolver());
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
        ArrayList localArrayList2 = (ArrayList)this.Gb.get(paramIntent.getAction());
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
          b localb = (b)localArrayList2.get(j);
          if (i != 0) {
            new StringBuilder("Matching against filter ").append(localb.filter);
          }
          if (localb.Gg)
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
          localb.Gg = true;
        }
      }
      if (localArrayList1 != null)
      {
        i = 0;
        while (i < localArrayList1.size())
        {
          ((b)localArrayList1.get(i)).Gg = false;
          i += 1;
        }
        this.Gc.add(new a(paramIntent, localArrayList1));
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
      synchronized (this.Ga)
      {
        ArrayList localArrayList1 = (ArrayList)this.Ga.remove(paramBroadcastReceiver);
        if (localArrayList1 == null) {
          return;
        }
        i = localArrayList1.size() - 1;
        if (i >= 0)
        {
          b localb1 = (b)localArrayList1.get(i);
          localb1.Gh = true;
          j = 0;
          if (j >= localb1.filter.countActions()) {
            break label203;
          }
          String str = localb1.filter.getAction(j);
          ArrayList localArrayList2 = (ArrayList)this.Gb.get(str);
          if (localArrayList2 == null) {
            break label196;
          }
          k = localArrayList2.size() - 1;
          if (k >= 0)
          {
            b localb2 = (b)localArrayList2.get(k);
            if (localb2.receiver == paramBroadcastReceiver)
            {
              localb2.Gh = true;
              localArrayList2.remove(k);
            }
          }
          else
          {
            if (localArrayList2.size() > 0) {
              break label196;
            }
            this.Gb.remove(str);
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
  
  static final class a
  {
    final ArrayList<d.b> Gf;
    final Intent intent;
    
    a(Intent paramIntent, ArrayList<d.b> paramArrayList)
    {
      this.intent = paramIntent;
      this.Gf = paramArrayList;
    }
  }
  
  static final class b
  {
    boolean Gg;
    boolean Gh;
    final IntentFilter filter;
    final BroadcastReceiver receiver;
    
    b(IntentFilter paramIntentFilter, BroadcastReceiver paramBroadcastReceiver)
    {
      this.filter = paramIntentFilter;
      this.receiver = paramBroadcastReceiver;
    }
    
    public final String toString()
    {
      StringBuilder localStringBuilder = new StringBuilder(128);
      localStringBuilder.append("Receiver{");
      localStringBuilder.append(this.receiver);
      localStringBuilder.append(" filter=");
      localStringBuilder.append(this.filter);
      if (this.Gh) {
        localStringBuilder.append(" DEAD");
      }
      localStringBuilder.append("}");
      return localStringBuilder.toString();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     android.support.v4.content.d
 * JD-Core Version:    0.7.0.1
 */