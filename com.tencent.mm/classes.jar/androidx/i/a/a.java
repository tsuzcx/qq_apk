package androidx.i.a;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

public final class a
{
  private static a bJj;
  private static final Object mLock;
  final HashMap<BroadcastReceiver, ArrayList<b>> bJg;
  private final HashMap<String, ArrayList<b>> bJh;
  final ArrayList<a> bJi;
  final Context mAppContext;
  private final Handler mHandler;
  
  static
  {
    AppMethodBeat.i(196475);
    mLock = new Object();
    AppMethodBeat.o(196475);
  }
  
  private a(Context paramContext)
  {
    AppMethodBeat.i(196464);
    this.bJg = new HashMap();
    this.bJh = new HashMap();
    this.bJi = new ArrayList();
    this.mAppContext = paramContext;
    this.mHandler = new Handler(paramContext.getMainLooper())
    {
      public final void handleMessage(Message paramAnonymousMessage)
      {
        AppMethodBeat.i(196465);
        switch (paramAnonymousMessage.what)
        {
        default: 
          super.handleMessage(paramAnonymousMessage);
          AppMethodBeat.o(196465);
          return;
        }
        paramAnonymousMessage = a.this;
        for (;;)
        {
          int i;
          synchronized (paramAnonymousMessage.bJg)
          {
            i = paramAnonymousMessage.bJi.size();
            if (i <= 0)
            {
              AppMethodBeat.o(196465);
              return;
            }
            a.a[] arrayOfa = new a.a[i];
            paramAnonymousMessage.bJi.toArray(arrayOfa);
            paramAnonymousMessage.bJi.clear();
            i = 0;
            if (i >= arrayOfa.length) {
              continue;
            }
            ??? = arrayOfa[i];
            int k = ???.bJl.size();
            int j = 0;
            if (j < k)
            {
              a.b localb = (a.b)???.bJl.get(j);
              if (!localb.bJo) {
                localb.bJm.onReceive(paramAnonymousMessage.mAppContext, ???.intent);
              }
              j += 1;
            }
          }
          i += 1;
        }
      }
    };
    AppMethodBeat.o(196464);
  }
  
  public static a al(Context paramContext)
  {
    AppMethodBeat.i(196459);
    synchronized (mLock)
    {
      if (bJj == null) {
        bJj = new a(paramContext.getApplicationContext());
      }
      paramContext = bJj;
      AppMethodBeat.o(196459);
      return paramContext;
    }
  }
  
  public final void a(BroadcastReceiver paramBroadcastReceiver, IntentFilter paramIntentFilter)
  {
    AppMethodBeat.i(196484);
    synchronized (this.bJg)
    {
      b localb = new b(paramIntentFilter, paramBroadcastReceiver);
      Object localObject2 = (ArrayList)this.bJg.get(paramBroadcastReceiver);
      Object localObject1 = localObject2;
      if (localObject2 == null)
      {
        localObject1 = new ArrayList(1);
        this.bJg.put(paramBroadcastReceiver, localObject1);
      }
      ((ArrayList)localObject1).add(localb);
      int i = 0;
      while (i < paramIntentFilter.countActions())
      {
        localObject2 = paramIntentFilter.getAction(i);
        localObject1 = (ArrayList)this.bJh.get(localObject2);
        paramBroadcastReceiver = (BroadcastReceiver)localObject1;
        if (localObject1 == null)
        {
          paramBroadcastReceiver = new ArrayList(1);
          this.bJh.put(localObject2, paramBroadcastReceiver);
        }
        paramBroadcastReceiver.add(localb);
        i += 1;
      }
      AppMethodBeat.o(196484);
      return;
    }
  }
  
  public final boolean d(Intent paramIntent)
  {
    AppMethodBeat.i(196508);
    for (;;)
    {
      synchronized (this.bJg)
      {
        String str1 = paramIntent.getAction();
        String str2 = paramIntent.resolveTypeIfNeeded(this.mAppContext.getContentResolver());
        Uri localUri = paramIntent.getData();
        String str3 = paramIntent.getScheme();
        Set localSet = paramIntent.getCategories();
        if ((paramIntent.getFlags() & 0x8) == 0) {
          break label407;
        }
        i = 1;
        if (i != 0) {
          new StringBuilder("Resolving type ").append(str2).append(" scheme ").append(str3).append(" of intent ").append(paramIntent);
        }
        ArrayList localArrayList2 = (ArrayList)this.bJh.get(paramIntent.getAction());
        if (localArrayList2 == null) {
          break label376;
        }
        if (i == 0) {
          break label392;
        }
        new StringBuilder("Action list: ").append(localArrayList2);
        break label392;
        if (j < localArrayList2.size())
        {
          b localb = (b)localArrayList2.get(j);
          if (i != 0) {
            new StringBuilder("Matching against filter ").append(localb.filter);
          }
          if (localb.bJn)
          {
            if (i == 0) {
              break label389;
            }
            break label400;
          }
          int k = localb.filter.match(str1, str2, str3, localUri, localSet, "LocalBroadcastManager");
          if (k < 0) {
            break label389;
          }
          if (i != 0) {
            new StringBuilder("  Filter matched!  match=0x").append(Integer.toHexString(k));
          }
          if (localArrayList1 != null) {
            break label386;
          }
          localArrayList1 = new ArrayList();
          localArrayList1.add(localb);
          localb.bJn = true;
        }
      }
      if (localArrayList1 != null)
      {
        i = 0;
        while (i < localArrayList1.size())
        {
          ((b)localArrayList1.get(i)).bJn = false;
          i += 1;
        }
        this.bJi.add(new a(paramIntent, localArrayList1));
        if (!this.mHandler.hasMessages(1)) {
          this.mHandler.sendEmptyMessage(1);
        }
        AppMethodBeat.o(196508);
        return true;
      }
      label376:
      AppMethodBeat.o(196508);
      return false;
      label386:
      continue;
      label389:
      break label400;
      label392:
      ArrayList localArrayList1 = null;
      int j = 0;
      continue;
      label400:
      j += 1;
      continue;
      label407:
      int i = 0;
    }
  }
  
  public final void unregisterReceiver(BroadcastReceiver paramBroadcastReceiver)
  {
    AppMethodBeat.i(196494);
    for (;;)
    {
      int i;
      int j;
      int k;
      synchronized (this.bJg)
      {
        ArrayList localArrayList1 = (ArrayList)this.bJg.remove(paramBroadcastReceiver);
        if (localArrayList1 == null)
        {
          AppMethodBeat.o(196494);
          return;
        }
        i = localArrayList1.size() - 1;
        if (i >= 0)
        {
          b localb1 = (b)localArrayList1.get(i);
          localb1.bJo = true;
          j = 0;
          if (j >= localb1.filter.countActions()) {
            break label223;
          }
          String str = localb1.filter.getAction(j);
          ArrayList localArrayList2 = (ArrayList)this.bJh.get(str);
          if (localArrayList2 == null) {
            break label216;
          }
          k = localArrayList2.size() - 1;
          if (k >= 0)
          {
            b localb2 = (b)localArrayList2.get(k);
            if (localb2.bJm == paramBroadcastReceiver)
            {
              localb2.bJo = true;
              localArrayList2.remove(k);
            }
          }
          else
          {
            if (localArrayList2.size() > 0) {
              break label216;
            }
            this.bJh.remove(str);
            break label216;
          }
        }
        else
        {
          AppMethodBeat.o(196494);
          return;
        }
      }
      k -= 1;
      continue;
      label216:
      j += 1;
      continue;
      label223:
      i -= 1;
    }
  }
  
  static final class a
  {
    final ArrayList<a.b> bJl;
    final Intent intent;
    
    a(Intent paramIntent, ArrayList<a.b> paramArrayList)
    {
      this.intent = paramIntent;
      this.bJl = paramArrayList;
    }
  }
  
  static final class b
  {
    final BroadcastReceiver bJm;
    boolean bJn;
    boolean bJo;
    final IntentFilter filter;
    
    b(IntentFilter paramIntentFilter, BroadcastReceiver paramBroadcastReceiver)
    {
      this.filter = paramIntentFilter;
      this.bJm = paramBroadcastReceiver;
    }
    
    public final String toString()
    {
      AppMethodBeat.i(196472);
      Object localObject = new StringBuilder(128);
      ((StringBuilder)localObject).append("Receiver{");
      ((StringBuilder)localObject).append(this.bJm);
      ((StringBuilder)localObject).append(" filter=");
      ((StringBuilder)localObject).append(this.filter);
      if (this.bJo) {
        ((StringBuilder)localObject).append(" DEAD");
      }
      ((StringBuilder)localObject).append("}");
      localObject = ((StringBuilder)localObject).toString();
      AppMethodBeat.o(196472);
      return localObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     androidx.i.a.a
 * JD-Core Version:    0.7.0.1
 */