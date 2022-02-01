package com.tencent.mm.plugin.appbrand.utils.a;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build.VERSION;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;

final class b
  implements e
{
  private final IntentFilter ccZ;
  protected Context mContext;
  private final d mPG;
  Intent mPH;
  final e mPI;
  private a mPJ;
  
  b()
  {
    AppMethodBeat.i(137931);
    this.ccZ = new IntentFilter("android.intent.action.BATTERY_CHANGED");
    this.mPG = new d();
    this.mPH = null;
    this.mPI = this;
    AppMethodBeat.o(137931);
  }
  
  public final c bBz()
  {
    boolean bool2 = true;
    int j = -1;
    Object localObject3;
    for (;;)
    {
      try
      {
        AppMethodBeat.i(137934);
        if (this.mContext == null)
        {
          ad.e("MicroMsg.AppBrandBatteryManagerImplBelow21", "getBatteryInfo no context");
          localObject1 = a.mPC;
          AppMethodBeat.o(137934);
          return localObject1;
        }
        Object localObject1 = this.mContext;
        if (this.mPH != null)
        {
          localObject1 = this.mPH;
          if (localObject1 != null) {
            break;
          }
          ad.e("MicroMsg.AppBrandBatteryManagerImplBelow21", "getBatteryInfo no intent got");
          localObject1 = a.mPC;
          AppMethodBeat.o(137934);
          continue;
        }
        this.mPJ = new a((byte)0);
      }
      finally {}
      localObject3 = localObject2.getApplicationContext().registerReceiver(this.mPJ, this.ccZ);
      this.mPH = ((Intent)localObject3);
    }
    c localc = new c();
    int i;
    if (localObject3 == null)
    {
      i = j;
      label148:
      localc.mPM = i;
      if (localObject3 == null) {
        break label299;
      }
      i = ((Intent)localObject3).getIntExtra("status", -1);
      j = ((Intent)localObject3).getIntExtra("plugged", 0);
      bool1 = bool2;
      if (i != 2)
      {
        bool1 = bool2;
        if (j != 1)
        {
          bool1 = bool2;
          if (j != 2) {
            if ((Build.VERSION.SDK_INT < 17) || (j != 4)) {
              break label299;
            }
          }
        }
      }
    }
    label299:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      localc.mPL = bool1;
      AppMethodBeat.o(137934);
      localObject3 = localc;
      break;
      int k = ((Intent)localObject3).getIntExtra("level", -1);
      int m = ((Intent)localObject3).getIntExtra("scale", -1);
      i = j;
      if (m <= 0) {
        break label148;
      }
      i = j;
      if (k < 0) {
        break label148;
      }
      i = Math.min(Math.max((int)Math.floor(k * 100.0F / m), 0), 100);
      break label148;
    }
  }
  
  /* Error */
  public final void init(Context paramContext)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc 139
    //   4: invokestatic 32	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   7: aload_0
    //   8: aconst_null
    //   9: putfield 48	com/tencent/mm/plugin/appbrand/utils/a/b:mPH	Landroid/content/Intent;
    //   12: aload_1
    //   13: invokevirtual 88	android/content/Context:getApplicationContext	()Landroid/content/Context;
    //   16: ifnonnull +16 -> 32
    //   19: aload_0
    //   20: aload_1
    //   21: putfield 59	com/tencent/mm/plugin/appbrand/utils/a/b:mContext	Landroid/content/Context;
    //   24: ldc 139
    //   26: invokestatic 53	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   29: aload_0
    //   30: monitorexit
    //   31: return
    //   32: aload_1
    //   33: invokevirtual 88	android/content/Context:getApplicationContext	()Landroid/content/Context;
    //   36: astore_1
    //   37: goto -18 -> 19
    //   40: astore_1
    //   41: aload_0
    //   42: monitorexit
    //   43: aload_1
    //   44: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	45	0	this	b
    //   0	45	1	paramContext	Context
    // Exception table:
    //   from	to	target	type
    //   2	19	40	finally
    //   19	29	40	finally
    //   32	37	40	finally
  }
  
  public final void release()
  {
    try
    {
      AppMethodBeat.i(137933);
      if (this.mContext != null)
      {
        if (this.mPJ != null) {
          this.mContext.unregisterReceiver(this.mPJ);
        }
        this.mContext = null;
      }
      AppMethodBeat.o(137933);
      return;
    }
    finally {}
  }
  
  final class a
    extends BroadcastReceiver
  {
    private a() {}
    
    public final void onReceive(Context arg1, Intent paramIntent)
    {
      synchronized (b.this.mPI)
      {
        b.this.mPH = paramIntent;
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.utils.a.b
 * JD-Core Version:    0.7.0.1
 */