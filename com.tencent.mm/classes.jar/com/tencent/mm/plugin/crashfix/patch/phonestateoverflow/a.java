package com.tencent.mm.plugin.crashfix.patch.phonestateoverflow;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.telephony.CellInfo;
import android.telephony.CellLocation;
import android.telephony.PhoneStateListener;
import android.telephony.ServiceState;
import android.telephony.SignalStrength;
import android.telephony.TelephonyManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.app.f;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.crashfix.patch.b;
import com.tencent.mm.plugin.expt.b.c.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class a
  implements b
{
  private final String TAG;
  Handler mH;
  List<c> xfu;
  private List<a> xfv;
  
  public a()
  {
    AppMethodBeat.i(261559);
    this.TAG = "MicroMsg.PhoneStateOverflow";
    this.xfu = new ArrayList();
    this.xfv = new ArrayList();
    this.mH = new Handler(Looper.getMainLooper());
    AppMethodBeat.o(261559);
  }
  
  private int Jt(int paramInt)
  {
    for (;;)
    {
      try
      {
        AppMethodBeat.i(261564);
        int i = 0;
        Iterator localIterator = this.xfu.iterator();
        if (localIterator.hasNext())
        {
          if (((c)localIterator.next()).eventId == paramInt) {
            i += 1;
          }
        }
        else
        {
          AppMethodBeat.o(261564);
          return i;
        }
      }
      finally {}
    }
  }
  
  public final boolean Js(int paramInt)
  {
    AppMethodBeat.i(261569);
    if ((paramInt >= 30) && (((com.tencent.mm.plugin.expt.b.c)h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(c.a.ztL, 1) == 1))
    {
      AppMethodBeat.o(261569);
      return true;
    }
    AppMethodBeat.o(261569);
    return false;
  }
  
  final void Ju(int paramInt)
  {
    for (;;)
    {
      try
      {
        AppMethodBeat.i(261588);
        Log.i("MicroMsg.PhoneStateOverflow", "add inner:  event id = %d", new Object[] { Integer.valueOf(paramInt) });
        Object localObject1 = this.xfv.iterator();
        if (((Iterator)localObject1).hasNext())
        {
          Object localObject3 = (a)((Iterator)localObject1).next();
          if (((a)localObject3).eventId != paramInt) {
            continue;
          }
          ((a)localObject3).count = Jt(paramInt);
          i = 1;
          if (i == 0)
          {
            Log.i("MicroMsg.PhoneStateOverflow", "create inner:  event id = %d", new Object[] { Integer.valueOf(paramInt) });
            localObject3 = new a((byte)0);
            ((a)localObject3).eventId = paramInt;
            ((a)localObject3).ies = new b((a)localObject3);
            ((a)localObject3).count = 1;
            this.xfv.add(localObject3);
            localObject1 = (TelephonyManager)MMApplicationContext.getContext().getSystemService("phone");
            localObject3 = ((a)localObject3).ies;
            localObject3 = com.tencent.mm.hellhoundlib.b.c.a(paramInt, new com.tencent.mm.hellhoundlib.b.a()).cG(localObject3);
            com.tencent.mm.hellhoundlib.a.a.b(localObject1, ((com.tencent.mm.hellhoundlib.b.a)localObject3).aYi(), "com/tencent/mm/plugin/crashfix/patch/phonestateoverflow/PhoneStateOverflow", "initInnerListener", "(I)V", "android/telephony/TelephonyManager_EXEC_", "listen", "(Landroid/telephony/PhoneStateListener;I)V");
            ((TelephonyManager)localObject1).listen((PhoneStateListener)((com.tencent.mm.hellhoundlib.b.a)localObject3).sb(0), ((Integer)((com.tencent.mm.hellhoundlib.b.a)localObject3).sb(1)).intValue());
            com.tencent.mm.hellhoundlib.a.a.c(localObject1, "com/tencent/mm/plugin/crashfix/patch/phonestateoverflow/PhoneStateOverflow", "initInnerListener", "(I)V", "android/telephony/TelephonyManager_EXEC_", "listen", "(Landroid/telephony/PhoneStateListener;I)V");
          }
          AppMethodBeat.o(261588);
          return;
        }
      }
      finally {}
      int i = 0;
    }
  }
  
  final void a(PhoneStateListener paramPhoneStateListener)
  {
    for (;;)
    {
      Iterator localIterator;
      c localc;
      PhoneStateListener localPhoneStateListener;
      try
      {
        AppMethodBeat.i(261581);
        localIterator = this.xfu.iterator();
        if (!localIterator.hasNext()) {
          break;
        }
        localc = (c)localIterator.next();
        localPhoneStateListener = (PhoneStateListener)localc.xfC.get();
        if (localPhoneStateListener == null)
        {
          localIterator.remove();
          continue;
        }
        if (localc == null) {
          continue;
        }
      }
      finally {}
      if (localPhoneStateListener == paramPhoneStateListener)
      {
        localIterator.remove();
        Log.i("MicroMsg.PhoneStateOverflow", "remove outter %d", new Object[] { Integer.valueOf(localc.eventId) });
      }
    }
    AppMethodBeat.o(261581);
  }
  
  /* Error */
  final boolean a(int paramInt, PhoneStateListener paramPhoneStateListener, String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc 228
    //   4: invokestatic 39	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   7: ldc 41
    //   9: ldc 230
    //   11: iconst_3
    //   12: anewarray 4	java/lang/Object
    //   15: dup
    //   16: iconst_0
    //   17: iload_1
    //   18: invokestatic 120	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   21: aastore
    //   22: dup
    //   23: iconst_1
    //   24: aload_2
    //   25: invokevirtual 233	java/lang/Object:hashCode	()I
    //   28: invokestatic 120	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   31: aastore
    //   32: dup
    //   33: iconst_2
    //   34: aload_3
    //   35: aastore
    //   36: invokestatic 125	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   39: aload_0
    //   40: getfield 48	com/tencent/mm/plugin/crashfix/patch/phonestateoverflow/a:xfu	Ljava/util/List;
    //   43: invokeinterface 76 1 0
    //   48: astore_3
    //   49: aload_3
    //   50: invokeinterface 82 1 0
    //   55: ifeq +86 -> 141
    //   58: aload_3
    //   59: invokeinterface 86 1 0
    //   64: checkcast 18	com/tencent/mm/plugin/crashfix/patch/phonestateoverflow/a$c
    //   67: astore 5
    //   69: aload 5
    //   71: getfield 216	com/tencent/mm/plugin/crashfix/patch/phonestateoverflow/a$c:xfC	Ljava/lang/ref/WeakReference;
    //   74: invokevirtual 221	java/lang/ref/WeakReference:get	()Ljava/lang/Object;
    //   77: checkcast 201	android/telephony/PhoneStateListener
    //   80: astore 6
    //   82: aload 6
    //   84: ifnull -35 -> 49
    //   87: aload 6
    //   89: aload_2
    //   90: if_acmpne -41 -> 49
    //   93: ldc 41
    //   95: ldc 235
    //   97: iconst_2
    //   98: anewarray 4	java/lang/Object
    //   101: dup
    //   102: iconst_0
    //   103: aload 5
    //   105: getfield 90	com/tencent/mm/plugin/crashfix/patch/phonestateoverflow/a$c:eventId	I
    //   108: invokestatic 120	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   111: aastore
    //   112: dup
    //   113: iconst_1
    //   114: iload_1
    //   115: invokestatic 120	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   118: aastore
    //   119: invokestatic 125	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   122: aload 5
    //   124: iload_1
    //   125: putfield 90	com/tencent/mm/plugin/crashfix/patch/phonestateoverflow/a$c:eventId	I
    //   128: ldc 228
    //   130: invokestatic 66	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   133: iconst_0
    //   134: istore 4
    //   136: aload_0
    //   137: monitorexit
    //   138: iload 4
    //   140: ireturn
    //   141: new 18	com/tencent/mm/plugin/crashfix/patch/phonestateoverflow/a$c
    //   144: dup
    //   145: aload_0
    //   146: iconst_0
    //   147: invokespecial 236	com/tencent/mm/plugin/crashfix/patch/phonestateoverflow/a$c:<init>	(Lcom/tencent/mm/plugin/crashfix/patch/phonestateoverflow/a;B)V
    //   150: astore_3
    //   151: aload_3
    //   152: iload_1
    //   153: putfield 90	com/tencent/mm/plugin/crashfix/patch/phonestateoverflow/a$c:eventId	I
    //   156: aload_3
    //   157: new 218	java/lang/ref/WeakReference
    //   160: dup
    //   161: aload_2
    //   162: invokespecial 239	java/lang/ref/WeakReference:<init>	(Ljava/lang/Object;)V
    //   165: putfield 216	com/tencent/mm/plugin/crashfix/patch/phonestateoverflow/a$c:xfC	Ljava/lang/ref/WeakReference;
    //   168: aload_0
    //   169: getfield 48	com/tencent/mm/plugin/crashfix/patch/phonestateoverflow/a:xfu	Ljava/util/List;
    //   172: aload_3
    //   173: invokeinterface 147 2 0
    //   178: pop
    //   179: ldc 228
    //   181: invokestatic 66	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   184: iconst_1
    //   185: istore 4
    //   187: goto -51 -> 136
    //   190: astore_2
    //   191: aload_0
    //   192: monitorexit
    //   193: aload_2
    //   194: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	195	0	this	a
    //   0	195	1	paramInt	int
    //   0	195	2	paramPhoneStateListener	PhoneStateListener
    //   0	195	3	paramString	String
    //   134	52	4	bool	boolean
    //   67	56	5	localc	c
    //   80	8	6	localPhoneStateListener	PhoneStateListener
    // Exception table:
    //   from	to	target	type
    //   2	49	190	finally
    //   49	82	190	finally
    //   93	133	190	finally
    //   141	184	190	finally
  }
  
  public final boolean dtc()
  {
    AppMethodBeat.i(261575);
    new PhoneStateOverflow.1(this, f.hfK).alive();
    AppMethodBeat.o(261575);
    return true;
  }
  
  final class a
  {
    int count = 0;
    int eventId;
    PhoneStateListener ies;
    
    private a() {}
  }
  
  final class b
    extends PhoneStateListener
  {
    a.a xfB;
    
    b(a.a parama)
    {
      this.xfB = parama;
    }
    
    public final void onCallForwardingIndicatorChanged(boolean paramBoolean)
    {
      AppMethodBeat.i(261570);
      super.onCallForwardingIndicatorChanged(paramBoolean);
      synchronized (a.this)
      {
        Iterator localIterator = a.this.xfu.iterator();
        while (localIterator.hasNext())
        {
          Object localObject2 = (a.c)localIterator.next();
          if (((a.c)localObject2).eventId == this.xfB.eventId)
          {
            localObject2 = (PhoneStateListener)((a.c)localObject2).xfC.get();
            if (localObject2 != null)
            {
              Log.i("MicroMsg.PhoneStateOverflow", "onCallForwardingIndicatorChanged %d %d", new Object[] { Integer.valueOf(this.xfB.eventId), Integer.valueOf(localObject2.hashCode()) });
              ((PhoneStateListener)localObject2).onCallForwardingIndicatorChanged(paramBoolean);
            }
          }
        }
      }
      AppMethodBeat.o(261570);
    }
    
    public final void onCallStateChanged(int paramInt, String paramString)
    {
      AppMethodBeat.i(261562);
      super.onCallStateChanged(paramInt, paramString);
      synchronized (a.this)
      {
        Iterator localIterator = a.this.xfu.iterator();
        while (localIterator.hasNext())
        {
          Object localObject = (a.c)localIterator.next();
          if (((a.c)localObject).eventId == this.xfB.eventId)
          {
            localObject = (PhoneStateListener)((a.c)localObject).xfC.get();
            if (localObject != null)
            {
              Log.i("MicroMsg.PhoneStateOverflow", "onCallStateChanged %d %d", new Object[] { Integer.valueOf(this.xfB.eventId), Integer.valueOf(localObject.hashCode()) });
              ((PhoneStateListener)localObject).onCallStateChanged(paramInt, paramString);
            }
          }
        }
      }
      AppMethodBeat.o(261562);
    }
    
    public final void onCellInfoChanged(List<CellInfo> paramList)
    {
      AppMethodBeat.i(261577);
      super.onCellInfoChanged(paramList);
      synchronized (a.this)
      {
        Iterator localIterator = a.this.xfu.iterator();
        while (localIterator.hasNext())
        {
          Object localObject = (a.c)localIterator.next();
          if (((a.c)localObject).eventId == this.xfB.eventId)
          {
            localObject = (PhoneStateListener)((a.c)localObject).xfC.get();
            if (localObject != null)
            {
              Log.i("MicroMsg.PhoneStateOverflow", "onCellInfoChanged %d %d", new Object[] { Integer.valueOf(this.xfB.eventId), Integer.valueOf(localObject.hashCode()) });
              ((PhoneStateListener)localObject).onCellInfoChanged(paramList);
            }
          }
        }
      }
      AppMethodBeat.o(261577);
    }
    
    public final void onCellLocationChanged(CellLocation paramCellLocation)
    {
      AppMethodBeat.i(261582);
      super.onCellLocationChanged(paramCellLocation);
      synchronized (a.this)
      {
        Iterator localIterator = a.this.xfu.iterator();
        while (localIterator.hasNext())
        {
          Object localObject = (a.c)localIterator.next();
          if (((a.c)localObject).eventId == this.xfB.eventId)
          {
            localObject = (PhoneStateListener)((a.c)localObject).xfC.get();
            if (localObject != null)
            {
              Log.i("MicroMsg.PhoneStateOverflow", "onCellLocationChanged %d %d", new Object[] { Integer.valueOf(this.xfB.eventId), Integer.valueOf(localObject.hashCode()) });
              ((PhoneStateListener)localObject).onCellLocationChanged(paramCellLocation);
            }
          }
        }
      }
      AppMethodBeat.o(261582);
    }
    
    public final void onDataActivity(int paramInt)
    {
      AppMethodBeat.i(261586);
      super.onDataActivity(paramInt);
      synchronized (a.this)
      {
        Iterator localIterator = a.this.xfu.iterator();
        while (localIterator.hasNext())
        {
          Object localObject2 = (a.c)localIterator.next();
          if (((a.c)localObject2).eventId == this.xfB.eventId)
          {
            localObject2 = (PhoneStateListener)((a.c)localObject2).xfC.get();
            if (localObject2 != null)
            {
              Log.i("MicroMsg.PhoneStateOverflow", "onDataActivity %d %d", new Object[] { Integer.valueOf(this.xfB.eventId), Integer.valueOf(localObject2.hashCode()) });
              ((PhoneStateListener)localObject2).onDataActivity(paramInt);
            }
          }
        }
      }
      AppMethodBeat.o(261586);
    }
    
    public final void onDataConnectionStateChanged(int paramInt)
    {
      AppMethodBeat.i(261590);
      super.onDataConnectionStateChanged(paramInt);
      synchronized (a.this)
      {
        Iterator localIterator = a.this.xfu.iterator();
        while (localIterator.hasNext())
        {
          Object localObject2 = (a.c)localIterator.next();
          if (((a.c)localObject2).eventId == this.xfB.eventId)
          {
            localObject2 = (PhoneStateListener)((a.c)localObject2).xfC.get();
            if (localObject2 != null)
            {
              Log.i("MicroMsg.PhoneStateOverflow", "onDataConnectionStateChanged %d %d", new Object[] { Integer.valueOf(this.xfB.eventId), Integer.valueOf(localObject2.hashCode()) });
              ((PhoneStateListener)localObject2).onDataConnectionStateChanged(paramInt);
            }
          }
        }
      }
      AppMethodBeat.o(261590);
    }
    
    public final void onDataConnectionStateChanged(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(261594);
      super.onDataConnectionStateChanged(paramInt1, paramInt2);
      synchronized (a.this)
      {
        Iterator localIterator = a.this.xfu.iterator();
        while (localIterator.hasNext())
        {
          Object localObject2 = (a.c)localIterator.next();
          if (((a.c)localObject2).eventId == this.xfB.eventId)
          {
            localObject2 = (PhoneStateListener)((a.c)localObject2).xfC.get();
            if (localObject2 != null)
            {
              Log.i("MicroMsg.PhoneStateOverflow", "onDataConnectionStateChanged2 %d %d", new Object[] { Integer.valueOf(this.xfB.eventId), Integer.valueOf(localObject2.hashCode()) });
              ((PhoneStateListener)localObject2).onDataConnectionStateChanged(paramInt1, paramInt2);
            }
          }
        }
      }
      AppMethodBeat.o(261594);
    }
    
    public final void onMessageWaitingIndicatorChanged(boolean paramBoolean)
    {
      AppMethodBeat.i(261595);
      super.onMessageWaitingIndicatorChanged(paramBoolean);
      synchronized (a.this)
      {
        Iterator localIterator = a.this.xfu.iterator();
        while (localIterator.hasNext())
        {
          Object localObject2 = (a.c)localIterator.next();
          if (((a.c)localObject2).eventId == this.xfB.eventId)
          {
            localObject2 = (PhoneStateListener)((a.c)localObject2).xfC.get();
            if (localObject2 != null)
            {
              Log.i("MicroMsg.PhoneStateOverflow", "onMessageWaitingIndicatorChanged %d %d", new Object[] { Integer.valueOf(this.xfB.eventId), Integer.valueOf(localObject2.hashCode()) });
              ((PhoneStateListener)localObject2).onMessageWaitingIndicatorChanged(paramBoolean);
            }
          }
        }
      }
      AppMethodBeat.o(261595);
    }
    
    public final void onServiceStateChanged(ServiceState paramServiceState)
    {
      AppMethodBeat.i(261596);
      super.onServiceStateChanged(paramServiceState);
      synchronized (a.this)
      {
        Iterator localIterator = a.this.xfu.iterator();
        while (localIterator.hasNext())
        {
          Object localObject = (a.c)localIterator.next();
          if (((a.c)localObject).eventId == this.xfB.eventId)
          {
            localObject = (PhoneStateListener)((a.c)localObject).xfC.get();
            if (localObject != null)
            {
              Log.i("MicroMsg.PhoneStateOverflow", "onServiceStateChanged %d %d", new Object[] { Integer.valueOf(this.xfB.eventId), Integer.valueOf(localObject.hashCode()) });
              ((PhoneStateListener)localObject).onServiceStateChanged(paramServiceState);
            }
          }
        }
      }
      AppMethodBeat.o(261596);
    }
    
    public final void onSignalStrengthChanged(int paramInt)
    {
      AppMethodBeat.i(261600);
      super.onSignalStrengthChanged(paramInt);
      synchronized (a.this)
      {
        Iterator localIterator = a.this.xfu.iterator();
        while (localIterator.hasNext())
        {
          Object localObject2 = (a.c)localIterator.next();
          if (((a.c)localObject2).eventId == this.xfB.eventId)
          {
            localObject2 = (PhoneStateListener)((a.c)localObject2).xfC.get();
            if (localObject2 != null)
            {
              Log.i("MicroMsg.PhoneStateOverflow", "onSignalStrengthChanged %d %d", new Object[] { Integer.valueOf(this.xfB.eventId), Integer.valueOf(localObject2.hashCode()) });
              ((PhoneStateListener)localObject2).onSignalStrengthChanged(paramInt);
            }
          }
        }
      }
      AppMethodBeat.o(261600);
    }
    
    public final void onSignalStrengthsChanged(SignalStrength paramSignalStrength)
    {
      AppMethodBeat.i(261597);
      super.onSignalStrengthsChanged(paramSignalStrength);
      Log.e("MicroMsg.PhoneStateOverflow", "onSignalStrengthsChanged call! ");
      synchronized (a.this)
      {
        Iterator localIterator = a.this.xfu.iterator();
        while (localIterator.hasNext())
        {
          Object localObject = (a.c)localIterator.next();
          if (((a.c)localObject).eventId == this.xfB.eventId)
          {
            localObject = (PhoneStateListener)((a.c)localObject).xfC.get();
            if (localObject != null)
            {
              Log.i("MicroMsg.PhoneStateOverflow", "onSignalStrengthsChanged %d %d", new Object[] { Integer.valueOf(this.xfB.eventId), Integer.valueOf(localObject.hashCode()) });
              ((PhoneStateListener)localObject).onSignalStrengthsChanged(paramSignalStrength);
            }
          }
        }
      }
      AppMethodBeat.o(261597);
    }
    
    public final void onUserMobileDataStateChanged(boolean paramBoolean)
    {
      AppMethodBeat.i(261598);
      super.onUserMobileDataStateChanged(paramBoolean);
      synchronized (a.this)
      {
        Iterator localIterator = a.this.xfu.iterator();
        while (localIterator.hasNext())
        {
          Object localObject2 = (a.c)localIterator.next();
          if (((a.c)localObject2).eventId == this.xfB.eventId)
          {
            localObject2 = (PhoneStateListener)((a.c)localObject2).xfC.get();
            if (localObject2 != null)
            {
              Log.i("MicroMsg.PhoneStateOverflow", "onUserMobileDataStateChanged %d %d", new Object[] { Integer.valueOf(this.xfB.eventId), Integer.valueOf(localObject2.hashCode()) });
              ((PhoneStateListener)localObject2).onUserMobileDataStateChanged(paramBoolean);
            }
          }
        }
      }
      AppMethodBeat.o(261598);
    }
  }
  
  final class c
  {
    int eventId;
    WeakReference<PhoneStateListener> xfC;
    
    private c() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.crashfix.patch.phonestateoverflow.a
 * JD-Core Version:    0.7.0.1
 */