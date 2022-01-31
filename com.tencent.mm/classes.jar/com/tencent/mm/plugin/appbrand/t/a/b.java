package com.tencent.mm.plugin.appbrand.t.a;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build.VERSION;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;

final class b
  implements e
{
  private final IntentFilter bsJ;
  private final d iYo;
  Intent iYp;
  final e iYq;
  private b.a iYr;
  protected Context mContext;
  
  b()
  {
    AppMethodBeat.i(126653);
    this.bsJ = new IntentFilter("android.intent.action.BATTERY_CHANGED");
    this.iYo = new d();
    this.iYp = null;
    this.iYq = this;
    AppMethodBeat.o(126653);
  }
  
  public final c aOb()
  {
    boolean bool2 = true;
    int j = -1;
    Object localObject3;
    for (;;)
    {
      try
      {
        AppMethodBeat.i(126656);
        if (this.mContext == null)
        {
          ab.e("MicroMsg.AppBrandBatteryManagerImplBelow21", "getBatteryInfo no context");
          localObject1 = a.iYl;
          AppMethodBeat.o(126656);
          return localObject1;
        }
        Object localObject1 = this.mContext;
        if (this.iYp != null)
        {
          localObject1 = this.iYp;
          if (localObject1 != null) {
            break;
          }
          ab.e("MicroMsg.AppBrandBatteryManagerImplBelow21", "getBatteryInfo no intent got");
          localObject1 = a.iYl;
          AppMethodBeat.o(126656);
          continue;
        }
        this.iYr = new b.a(this, (byte)0);
      }
      finally {}
      localObject3 = localObject2.getApplicationContext().registerReceiver(this.iYr, this.bsJ);
      this.iYp = ((Intent)localObject3);
    }
    c localc = new c();
    int i;
    if (localObject3 == null)
    {
      i = j;
      label148:
      localc.iYu = i;
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
      localc.iYt = bool1;
      AppMethodBeat.o(126656);
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
  
  public final void init(Context paramContext)
  {
    try
    {
      AppMethodBeat.i(126654);
      this.iYp = null;
      this.mContext = paramContext.getApplicationContext();
      AppMethodBeat.o(126654);
      return;
    }
    finally
    {
      paramContext = finally;
      throw paramContext;
    }
  }
  
  public final void release()
  {
    try
    {
      AppMethodBeat.i(126655);
      if (this.mContext != null)
      {
        if (this.iYr != null) {
          this.mContext.unregisterReceiver(this.iYr);
        }
        this.mContext = null;
      }
      AppMethodBeat.o(126655);
      return;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.t.a.b
 * JD-Core Version:    0.7.0.1
 */