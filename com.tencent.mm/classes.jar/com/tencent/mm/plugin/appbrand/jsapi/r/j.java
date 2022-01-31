package com.tencent.mm.plugin.appbrand.jsapi.r;

import android.app.Activity;
import android.os.PowerManager;
import android.os.PowerManager.WakeLock;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.e;
import com.tencent.mm.plugin.appbrand.jsapi.a;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.jsapi.m;
import com.tencent.mm.sdk.platformtools.ab;
import org.json.JSONObject;

public final class j
  extends a
{
  public static final int CTRL_INDEX = -2;
  public static final String NAME = "setKeepScreenOn";
  private static boolean iaT = false;
  private c hyO;
  PowerManager.WakeLock wakeLock;
  
  private boolean aEJ()
  {
    for (;;)
    {
      try
      {
        AppMethodBeat.i(126423);
        boolean bool;
        if (this.hyO.getContext() == null)
        {
          ab.e("MicroMsg.JsApiSetKeepScreenOn", "acquire fail, server context is nul");
          bool = false;
          AppMethodBeat.o(126423);
          return bool;
        }
        ab.e("MicroMsg.JsApiSetKeepScreenOn", "acquire ok");
        Activity localActivity = (Activity)this.hyO.getContext();
        if (this.wakeLock == null) {
          this.wakeLock = ((PowerManager)localActivity.getSystemService("power")).newWakeLock(536870922, "MicroMsg.JsApiSetKeepScreenOn");
        }
        if (!this.wakeLock.isHeld())
        {
          this.wakeLock.acquire();
          ab.i("MicroMsg.JsApiSetKeepScreenOn", "wakeLock acquire");
          bool = true;
          AppMethodBeat.o(126423);
        }
        else
        {
          ab.i("MicroMsg.JsApiSetKeepScreenOn", "wakeLock has held ");
        }
      }
      finally {}
    }
  }
  
  /* Error */
  private boolean isHeld()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc 103
    //   4: invokestatic 34	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   7: aload_0
    //   8: getfield 67	com/tencent/mm/plugin/appbrand/jsapi/r/j:wakeLock	Landroid/os/PowerManager$WakeLock;
    //   11: ifnull +24 -> 35
    //   14: aload_0
    //   15: getfield 67	com/tencent/mm/plugin/appbrand/jsapi/r/j:wakeLock	Landroid/os/PowerManager$WakeLock;
    //   18: invokevirtual 83	android/os/PowerManager$WakeLock:isHeld	()Z
    //   21: ifeq +14 -> 35
    //   24: iconst_1
    //   25: istore_1
    //   26: ldc 103
    //   28: invokestatic 41	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   31: aload_0
    //   32: monitorexit
    //   33: iload_1
    //   34: ireturn
    //   35: iconst_0
    //   36: istore_1
    //   37: ldc 103
    //   39: invokestatic 41	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   42: goto -11 -> 31
    //   45: astore_2
    //   46: aload_0
    //   47: monitorexit
    //   48: aload_2
    //   49: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	50	0	this	j
    //   25	12	1	bool	boolean
    //   45	4	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	24	45	finally
    //   26	31	45	finally
    //   37	42	45	finally
  }
  
  /* Error */
  private boolean release()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc 104
    //   4: invokestatic 34	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   7: ldc 53
    //   9: ldc 105
    //   11: invokestatic 61	com/tencent/mm/sdk/platformtools/ab:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   14: aload_0
    //   15: getfield 67	com/tencent/mm/plugin/appbrand/jsapi/r/j:wakeLock	Landroid/os/PowerManager$WakeLock;
    //   18: ifnull +36 -> 54
    //   21: aload_0
    //   22: getfield 67	com/tencent/mm/plugin/appbrand/jsapi/r/j:wakeLock	Landroid/os/PowerManager$WakeLock;
    //   25: invokevirtual 83	android/os/PowerManager$WakeLock:isHeld	()Z
    //   28: ifeq +26 -> 54
    //   31: aload_0
    //   32: getfield 67	com/tencent/mm/plugin/appbrand/jsapi/r/j:wakeLock	Landroid/os/PowerManager$WakeLock;
    //   35: invokevirtual 107	android/os/PowerManager$WakeLock:release	()V
    //   38: aload_0
    //   39: aconst_null
    //   40: putfield 67	com/tencent/mm/plugin/appbrand/jsapi/r/j:wakeLock	Landroid/os/PowerManager$WakeLock;
    //   43: iconst_1
    //   44: istore_1
    //   45: ldc 104
    //   47: invokestatic 41	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   50: aload_0
    //   51: monitorexit
    //   52: iload_1
    //   53: ireturn
    //   54: ldc 53
    //   56: ldc 109
    //   58: invokestatic 61	com/tencent/mm/sdk/platformtools/ab:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   61: iconst_0
    //   62: istore_1
    //   63: ldc 104
    //   65: invokestatic 41	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   68: goto -18 -> 50
    //   71: astore_2
    //   72: aload_0
    //   73: monitorexit
    //   74: aload_2
    //   75: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	76	0	this	j
    //   44	19	1	bool	boolean
    //   71	4	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	43	71	finally
    //   45	50	71	finally
    //   54	61	71	finally
    //   63	68	71	finally
  }
  
  public final void a(c paramc, JSONObject paramJSONObject, int paramInt)
  {
    AppMethodBeat.i(126422);
    if (paramJSONObject == null)
    {
      ab.e("MicroMsg.JsApiSetKeepScreenOn", "setKeepScreenOn data is null");
      paramc.h(paramInt, j("fail:data is null", null));
      AppMethodBeat.o(126422);
      return;
    }
    if (paramc.getContext() == null)
    {
      ab.e("MicroMsg.JsApiSetKeepScreenOn", "setKeepScreenOn, server context is nul");
      paramc.h(paramInt, j("fail:context is null", null));
      AppMethodBeat.o(126422);
      return;
    }
    if (!(paramc.getContext() instanceof Activity))
    {
      ab.e("MicroMsg.JsApiSetKeepScreenOn", "setKeepScreenOn, server context is not activity, don't do invoke");
      paramc.h(paramInt, j("fail:context is null", null));
      AppMethodBeat.o(126422);
      return;
    }
    boolean bool = paramJSONObject.optBoolean("keepScreenOn", false);
    iaT = bool;
    ab.i("MicroMsg.JsApiSetKeepScreenOn", "setKeepScreenOn, keepScreenOn:%b, appId:%s", new Object[] { Boolean.valueOf(bool), paramc.getAppId() });
    for (;;)
    {
      try
      {
        this.hyO = paramc;
        if (bool)
        {
          paramJSONObject = new j.1(this, paramc);
          e.a(paramc.getAppId(), paramJSONObject);
          bool = aEJ();
          if (!bool) {
            break;
          }
          ab.i("MicroMsg.JsApiSetKeepScreenOn", "setKeepScreenOn ok");
          paramc.h(paramInt, j("ok", null));
          AppMethodBeat.o(126422);
          return;
        }
      }
      finally
      {
        AppMethodBeat.o(126422);
      }
      if (isHeld())
      {
        ab.i("MicroMsg.JsApiSetKeepScreenOn", "reset screen off");
        bool = release();
      }
      else
      {
        ab.e("MicroMsg.JsApiSetKeepScreenOn", "fail, has not set screen");
        paramc.h(paramInt, j("fail:has not set screen", null));
        AppMethodBeat.o(126422);
        return;
      }
    }
    ab.e("MicroMsg.JsApiSetKeepScreenOn", "setKeepScreenOn fail");
    paramc.h(paramInt, j("fail", null));
    AppMethodBeat.o(126422);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.r.j
 * JD-Core Version:    0.7.0.1
 */