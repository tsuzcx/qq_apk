package androidx.h.a;

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
  private static a abB;
  private static final Object mLock;
  final ArrayList<a> abA;
  final HashMap<BroadcastReceiver, ArrayList<b>> aby;
  private final HashMap<String, ArrayList<b>> abz;
  final Context mAppContext;
  private final Handler mHandler;
  
  static
  {
    AppMethodBeat.i(257936);
    mLock = new Object();
    AppMethodBeat.o(257936);
  }
  
  private a(Context paramContext)
  {
    AppMethodBeat.i(257932);
    this.aby = new HashMap();
    this.abz = new HashMap();
    this.abA = new ArrayList();
    this.mAppContext = paramContext;
    this.mHandler = new Handler(paramContext.getMainLooper())
    {
      public final void handleMessage(Message paramAnonymousMessage)
      {
        AppMethodBeat.i(257918);
        switch (paramAnonymousMessage.what)
        {
        default: 
          super.handleMessage(paramAnonymousMessage);
          AppMethodBeat.o(257918);
          return;
        }
        paramAnonymousMessage = a.this;
        for (;;)
        {
          int i;
          synchronized (paramAnonymousMessage.aby)
          {
            i = paramAnonymousMessage.abA.size();
            if (i <= 0)
            {
              AppMethodBeat.o(257918);
              return;
            }
            a.a[] arrayOfa = new a.a[i];
            paramAnonymousMessage.abA.toArray(arrayOfa);
            paramAnonymousMessage.abA.clear();
            i = 0;
            if (i >= arrayOfa.length) {
              continue;
            }
            ??? = arrayOfa[i];
            int k = ???.abD.size();
            int j = 0;
            if (j < k)
            {
              a.b localb = (a.b)???.abD.get(j);
              if (!localb.abF) {
                localb.receiver.onReceive(paramAnonymousMessage.mAppContext, ???.intent);
              }
              j += 1;
            }
          }
          i += 1;
        }
      }
    };
    AppMethodBeat.o(257932);
  }
  
  public static a V(Context paramContext)
  {
    AppMethodBeat.i(257931);
    synchronized (mLock)
    {
      if (abB == null) {
        abB = new a(paramContext.getApplicationContext());
      }
      paramContext = abB;
      AppMethodBeat.o(257931);
      return paramContext;
    }
  }
  
  public final void a(BroadcastReceiver paramBroadcastReceiver, IntentFilter paramIntentFilter)
  {
    AppMethodBeat.i(257933);
    synchronized (this.aby)
    {
      b localb = new b(paramIntentFilter, paramBroadcastReceiver);
      Object localObject2 = (ArrayList)this.aby.get(paramBroadcastReceiver);
      Object localObject1 = localObject2;
      if (localObject2 == null)
      {
        localObject1 = new ArrayList(1);
        this.aby.put(paramBroadcastReceiver, localObject1);
      }
      ((ArrayList)localObject1).add(localb);
      int i = 0;
      while (i < paramIntentFilter.countActions())
      {
        localObject2 = paramIntentFilter.getAction(i);
        localObject1 = (ArrayList)this.abz.get(localObject2);
        paramBroadcastReceiver = (BroadcastReceiver)localObject1;
        if (localObject1 == null)
        {
          paramBroadcastReceiver = new ArrayList(1);
          this.abz.put(localObject2, paramBroadcastReceiver);
        }
        paramBroadcastReceiver.add(localb);
        i += 1;
      }
      AppMethodBeat.o(257933);
      return;
    }
  }
  
  public final boolean c(Intent paramIntent)
  {
    AppMethodBeat.i(257935);
    for (;;)
    {
      synchronized (this.aby)
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
        ArrayList localArrayList2 = (ArrayList)this.abz.get(paramIntent.getAction());
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
          if (localb.abE)
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
          localb.abE = true;
        }
      }
      if (localArrayList1 != null)
      {
        i = 0;
        while (i < localArrayList1.size())
        {
          ((b)localArrayList1.get(i)).abE = false;
          i += 1;
        }
        this.abA.add(new a(paramIntent, localArrayList1));
        if (!this.mHandler.hasMessages(1)) {
          this.mHandler.sendEmptyMessage(1);
        }
        AppMethodBeat.o(257935);
        return true;
      }
      label376:
      AppMethodBeat.o(257935);
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
    AppMethodBeat.i(257934);
    for (;;)
    {
      int i;
      int j;
      int k;
      synchronized (this.aby)
      {
        ArrayList localArrayList1 = (ArrayList)this.aby.remove(paramBroadcastReceiver);
        if (localArrayList1 == null)
        {
          AppMethodBeat.o(257934);
          return;
        }
        i = localArrayList1.size() - 1;
        if (i >= 0)
        {
          b localb1 = (b)localArrayList1.get(i);
          localb1.abF = true;
          j = 0;
          if (j >= localb1.filter.countActions()) {
            break label223;
          }
          String str = localb1.filter.getAction(j);
          ArrayList localArrayList2 = (ArrayList)this.abz.get(str);
          if (localArrayList2 == null) {
            break label216;
          }
          k = localArrayList2.size() - 1;
          if (k >= 0)
          {
            b localb2 = (b)localArrayList2.get(k);
            if (localb2.receiver == paramBroadcastReceiver)
            {
              localb2.abF = true;
              localArrayList2.remove(k);
            }
          }
          else
          {
            if (localArrayList2.size() > 0) {
              break label216;
            }
            this.abz.remove(str);
            break label216;
          }
        }
        else
        {
          AppMethodBeat.o(257934);
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
    final ArrayList<a.b> abD;
    final Intent intent;
    
    a(Intent paramIntent, ArrayList<a.b> paramArrayList)
    {
      this.intent = paramIntent;
      this.abD = paramArrayList;
    }
  }
  
  static final class b
  {
    boolean abE;
    boolean abF;
    final IntentFilter filter;
    final BroadcastReceiver receiver;
    
    b(IntentFilter paramIntentFilter, BroadcastReceiver paramBroadcastReceiver)
    {
      this.filter = paramIntentFilter;
      this.receiver = paramBroadcastReceiver;
    }
    
    public final String toString()
    {
      AppMethodBeat.i(257926);
      Object localObject = new StringBuilder(128);
      ((StringBuilder)localObject).append("Receiver{");
      ((StringBuilder)localObject).append(this.receiver);
      ((StringBuilder)localObject).append(" filter=");
      ((StringBuilder)localObject).append(this.filter);
      if (this.abF) {
        ((StringBuilder)localObject).append(" DEAD");
      }
      ((StringBuilder)localObject).append("}");
      localObject = ((StringBuilder)localObject).toString();
      AppMethodBeat.o(257926);
      return localObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     androidx.h.a.a
 * JD-Core Version:    0.7.0.1
 */