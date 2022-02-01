package com.tencent.mm.plugin.appbrand.jsapi.v;

import android.app.Activity;
import android.os.PowerManager;
import android.os.PowerManager.WakeLock;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.g;
import com.tencent.mm.plugin.appbrand.g.c;
import com.tencent.mm.plugin.appbrand.g.d;
import com.tencent.mm.plugin.appbrand.jsapi.a;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.jsapi.m;
import com.tencent.mm.sdk.platformtools.ad;
import org.json.JSONObject;

public final class l
  extends a
{
  public static final int CTRL_INDEX = -2;
  public static final String NAME = "setKeepScreenOn";
  private static boolean klL = false;
  private c jyl;
  PowerManager.WakeLock wakeLock;
  
  private boolean bca()
  {
    for (;;)
    {
      try
      {
        AppMethodBeat.i(137678);
        boolean bool;
        if (this.jyl.getContext() == null)
        {
          ad.e("MicroMsg.JsApiSetKeepScreenOn", "acquire fail, server context is nul");
          bool = false;
          AppMethodBeat.o(137678);
          return bool;
        }
        ad.e("MicroMsg.JsApiSetKeepScreenOn", "acquire ok");
        Activity localActivity = (Activity)this.jyl.getContext();
        if (this.wakeLock == null) {
          this.wakeLock = ((PowerManager)localActivity.getSystemService("power")).newWakeLock(536870922, "MicroMsg.JsApiSetKeepScreenOn");
        }
        if (!this.wakeLock.isHeld())
        {
          this.wakeLock.acquire();
          ad.i("MicroMsg.JsApiSetKeepScreenOn", "wakeLock acquire");
          bool = true;
          AppMethodBeat.o(137678);
        }
        else
        {
          ad.i("MicroMsg.JsApiSetKeepScreenOn", "wakeLock has held ");
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
    //   2: ldc 105
    //   4: invokestatic 36	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   7: aload_0
    //   8: getfield 75	com/tencent/mm/plugin/appbrand/jsapi/v/l:wakeLock	Landroid/os/PowerManager$WakeLock;
    //   11: ifnull +24 -> 35
    //   14: aload_0
    //   15: getfield 75	com/tencent/mm/plugin/appbrand/jsapi/v/l:wakeLock	Landroid/os/PowerManager$WakeLock;
    //   18: invokevirtual 91	android/os/PowerManager$WakeLock:isHeld	()Z
    //   21: ifeq +14 -> 35
    //   24: iconst_1
    //   25: istore_1
    //   26: ldc 105
    //   28: invokestatic 43	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   31: aload_0
    //   32: monitorexit
    //   33: iload_1
    //   34: ireturn
    //   35: iconst_0
    //   36: istore_1
    //   37: ldc 105
    //   39: invokestatic 43	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   42: goto -11 -> 31
    //   45: astore_2
    //   46: aload_0
    //   47: monitorexit
    //   48: aload_2
    //   49: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	50	0	this	l
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
    //   2: ldc 106
    //   4: invokestatic 36	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   7: ldc 61
    //   9: ldc 107
    //   11: invokestatic 69	com/tencent/mm/sdk/platformtools/ad:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   14: aload_0
    //   15: getfield 75	com/tencent/mm/plugin/appbrand/jsapi/v/l:wakeLock	Landroid/os/PowerManager$WakeLock;
    //   18: ifnull +36 -> 54
    //   21: aload_0
    //   22: getfield 75	com/tencent/mm/plugin/appbrand/jsapi/v/l:wakeLock	Landroid/os/PowerManager$WakeLock;
    //   25: invokevirtual 91	android/os/PowerManager$WakeLock:isHeld	()Z
    //   28: ifeq +26 -> 54
    //   31: aload_0
    //   32: getfield 75	com/tencent/mm/plugin/appbrand/jsapi/v/l:wakeLock	Landroid/os/PowerManager$WakeLock;
    //   35: invokevirtual 109	android/os/PowerManager$WakeLock:release	()V
    //   38: aload_0
    //   39: aconst_null
    //   40: putfield 75	com/tencent/mm/plugin/appbrand/jsapi/v/l:wakeLock	Landroid/os/PowerManager$WakeLock;
    //   43: iconst_1
    //   44: istore_1
    //   45: ldc 106
    //   47: invokestatic 43	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   50: aload_0
    //   51: monitorexit
    //   52: iload_1
    //   53: ireturn
    //   54: ldc 61
    //   56: ldc 111
    //   58: invokestatic 69	com/tencent/mm/sdk/platformtools/ad:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   61: iconst_0
    //   62: istore_1
    //   63: ldc 106
    //   65: invokestatic 43	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   68: goto -18 -> 50
    //   71: astore_2
    //   72: aload_0
    //   73: monitorexit
    //   74: aload_2
    //   75: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	76	0	this	l
    //   44	19	1	bool	boolean
    //   71	4	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	43	71	finally
    //   45	50	71	finally
    //   54	61	71	finally
    //   63	68	71	finally
  }
  
  public final void a(final c paramc, JSONObject paramJSONObject, int paramInt)
  {
    AppMethodBeat.i(137677);
    if (paramJSONObject == null)
    {
      ad.e("MicroMsg.JsApiSetKeepScreenOn", "setKeepScreenOn data is null");
      paramc.h(paramInt, e("fail:data is null", null));
      AppMethodBeat.o(137677);
      return;
    }
    if (paramc.getContext() == null)
    {
      ad.e("MicroMsg.JsApiSetKeepScreenOn", "setKeepScreenOn, server context is nul");
      paramc.h(paramInt, e("fail:context is null", null));
      AppMethodBeat.o(137677);
      return;
    }
    if (!(paramc.getContext() instanceof Activity))
    {
      ad.e("MicroMsg.JsApiSetKeepScreenOn", "setKeepScreenOn, server context is not activity, don't do invoke");
      paramc.h(paramInt, e("fail:context is null", null));
      AppMethodBeat.o(137677);
      return;
    }
    boolean bool = paramJSONObject.optBoolean("keepScreenOn", false);
    klL = bool;
    ad.i("MicroMsg.JsApiSetKeepScreenOn", "setKeepScreenOn, keepScreenOn:%b, appId:%s", new Object[] { Boolean.valueOf(bool), paramc.getAppId() });
    for (;;)
    {
      try
      {
        this.jyl = paramc;
        if (bool)
        {
          paramJSONObject = new g.c()
          {
            public final void a(g.d paramAnonymousd)
            {
              AppMethodBeat.i(137675);
              ad.i("MicroMsg.JsApiSetKeepScreenOn", "onPause");
              if (l.a(l.this)) {
                l.b(l.this);
              }
              AppMethodBeat.o(137675);
            }
            
            public final void onDestroy()
            {
              AppMethodBeat.i(137674);
              ad.i("MicroMsg.JsApiSetKeepScreenOn", "onDestroy");
              if (l.a(l.this)) {
                l.b(l.this);
              }
              g.b(paramc.getAppId(), this);
              AppMethodBeat.o(137674);
            }
            
            public final void onResume()
            {
              AppMethodBeat.i(137676);
              ad.i("MicroMsg.JsApiSetKeepScreenOn", "onResume");
              if (l.klL) {
                l.c(l.this);
              }
              AppMethodBeat.o(137676);
            }
          };
          g.a(paramc.getAppId(), paramJSONObject);
          bool = bca();
          if (!bool) {
            break;
          }
          ad.i("MicroMsg.JsApiSetKeepScreenOn", "setKeepScreenOn ok");
          paramc.h(paramInt, e("ok", null));
          AppMethodBeat.o(137677);
          return;
        }
      }
      finally
      {
        AppMethodBeat.o(137677);
      }
      if (isHeld())
      {
        ad.i("MicroMsg.JsApiSetKeepScreenOn", "reset screen off");
        bool = release();
      }
      else
      {
        ad.e("MicroMsg.JsApiSetKeepScreenOn", "fail, has not set screen");
        paramc.h(paramInt, e("fail:has not set screen", null));
        AppMethodBeat.o(137677);
        return;
      }
    }
    ad.e("MicroMsg.JsApiSetKeepScreenOn", "setKeepScreenOn fail");
    paramc.h(paramInt, e("fail", null));
    AppMethodBeat.o(137677);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.v.l
 * JD-Core Version:    0.7.0.1
 */