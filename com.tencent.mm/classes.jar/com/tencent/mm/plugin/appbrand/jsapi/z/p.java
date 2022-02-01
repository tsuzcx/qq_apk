package com.tencent.mm.plugin.appbrand.jsapi.z;

import android.app.Activity;
import android.os.PowerManager;
import android.os.PowerManager.WakeLock;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.h;
import com.tencent.mm.plugin.appbrand.h.c;
import com.tencent.mm.plugin.appbrand.h.d;
import com.tencent.mm.plugin.appbrand.jsapi.d;
import com.tencent.mm.plugin.appbrand.jsapi.f;
import com.tencent.mm.sdk.platformtools.Log;
import org.json.JSONObject;

public final class p
  extends d
{
  public static final int CTRL_INDEX = -2;
  public static final String NAME = "setKeepScreenOn";
  private static boolean mub = false;
  private f lAx;
  private h.c lLT;
  PowerManager.WakeLock wakeLock;
  
  private boolean bIU()
  {
    for (;;)
    {
      try
      {
        AppMethodBeat.i(137678);
        boolean bool;
        if (this.lAx.getContext() == null)
        {
          Log.e("MicroMsg.JsApiSetKeepScreenOn", "acquire fail, server context is nul");
          bool = false;
          AppMethodBeat.o(137678);
          return bool;
        }
        Log.e("MicroMsg.JsApiSetKeepScreenOn", "acquire ok");
        Activity localActivity = (Activity)this.lAx.getContext();
        if (this.wakeLock == null) {
          this.wakeLock = ((PowerManager)localActivity.getSystemService("power")).newWakeLock(536870922, "MicroMsg.JsApiSetKeepScreenOn");
        }
        if (!this.wakeLock.isHeld())
        {
          this.wakeLock.acquire();
          Log.i("MicroMsg.JsApiSetKeepScreenOn", "wakeLock acquire");
          bool = true;
          AppMethodBeat.o(137678);
        }
        else
        {
          Log.i("MicroMsg.JsApiSetKeepScreenOn", "wakeLock has held ");
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
    //   2: ldc 107
    //   4: invokestatic 38	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   7: aload_0
    //   8: getfield 77	com/tencent/mm/plugin/appbrand/jsapi/z/p:wakeLock	Landroid/os/PowerManager$WakeLock;
    //   11: ifnull +24 -> 35
    //   14: aload_0
    //   15: getfield 77	com/tencent/mm/plugin/appbrand/jsapi/z/p:wakeLock	Landroid/os/PowerManager$WakeLock;
    //   18: invokevirtual 93	android/os/PowerManager$WakeLock:isHeld	()Z
    //   21: ifeq +14 -> 35
    //   24: iconst_1
    //   25: istore_1
    //   26: ldc 107
    //   28: invokestatic 45	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   31: aload_0
    //   32: monitorexit
    //   33: iload_1
    //   34: ireturn
    //   35: iconst_0
    //   36: istore_1
    //   37: ldc 107
    //   39: invokestatic 45	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   42: goto -11 -> 31
    //   45: astore_2
    //   46: aload_0
    //   47: monitorexit
    //   48: aload_2
    //   49: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	50	0	this	p
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
    //   2: ldc 108
    //   4: invokestatic 38	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   7: ldc 63
    //   9: ldc 109
    //   11: invokestatic 71	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   14: aload_0
    //   15: getfield 77	com/tencent/mm/plugin/appbrand/jsapi/z/p:wakeLock	Landroid/os/PowerManager$WakeLock;
    //   18: ifnull +36 -> 54
    //   21: aload_0
    //   22: getfield 77	com/tencent/mm/plugin/appbrand/jsapi/z/p:wakeLock	Landroid/os/PowerManager$WakeLock;
    //   25: invokevirtual 93	android/os/PowerManager$WakeLock:isHeld	()Z
    //   28: ifeq +26 -> 54
    //   31: aload_0
    //   32: getfield 77	com/tencent/mm/plugin/appbrand/jsapi/z/p:wakeLock	Landroid/os/PowerManager$WakeLock;
    //   35: invokevirtual 111	android/os/PowerManager$WakeLock:release	()V
    //   38: aload_0
    //   39: aconst_null
    //   40: putfield 77	com/tencent/mm/plugin/appbrand/jsapi/z/p:wakeLock	Landroid/os/PowerManager$WakeLock;
    //   43: iconst_1
    //   44: istore_1
    //   45: ldc 108
    //   47: invokestatic 45	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   50: aload_0
    //   51: monitorexit
    //   52: iload_1
    //   53: ireturn
    //   54: ldc 63
    //   56: ldc 113
    //   58: invokestatic 71	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   61: iconst_0
    //   62: istore_1
    //   63: ldc 108
    //   65: invokestatic 45	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   68: goto -18 -> 50
    //   71: astore_2
    //   72: aload_0
    //   73: monitorexit
    //   74: aload_2
    //   75: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	76	0	this	p
    //   44	19	1	bool	boolean
    //   71	4	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	43	71	finally
    //   45	50	71	finally
    //   54	61	71	finally
    //   63	68	71	finally
  }
  
  public final void a(final f paramf, JSONObject paramJSONObject, int paramInt)
  {
    AppMethodBeat.i(137677);
    if (paramJSONObject == null)
    {
      Log.e("MicroMsg.JsApiSetKeepScreenOn", "setKeepScreenOn data is null");
      paramf.i(paramInt, h("fail:data is null", null));
      AppMethodBeat.o(137677);
      return;
    }
    if (paramf.getContext() == null)
    {
      Log.e("MicroMsg.JsApiSetKeepScreenOn", "setKeepScreenOn, server context is nul");
      paramf.i(paramInt, h("fail:context is null", null));
      AppMethodBeat.o(137677);
      return;
    }
    if (!(paramf.getContext() instanceof Activity))
    {
      Log.e("MicroMsg.JsApiSetKeepScreenOn", "setKeepScreenOn, server context is not activity, don't do invoke");
      paramf.i(paramInt, h("fail:context is null", null));
      AppMethodBeat.o(137677);
      return;
    }
    boolean bool = paramJSONObject.optBoolean("keepScreenOn", false);
    mub = bool;
    Log.i("MicroMsg.JsApiSetKeepScreenOn", "setKeepScreenOn, keepScreenOn:%b, appId:%s", new Object[] { Boolean.valueOf(bool), paramf.getAppId() });
    for (;;)
    {
      try
      {
        this.lAx = paramf;
        if (bool)
        {
          if (this.lLT == null) {
            this.lLT = new h.c()
            {
              public final void a(h.d paramAnonymousd)
              {
                AppMethodBeat.i(137675);
                Log.i("MicroMsg.JsApiSetKeepScreenOn", "onPause");
                if (p.a(p.this)) {
                  p.b(p.this);
                }
                AppMethodBeat.o(137675);
              }
              
              public final void onDestroy()
              {
                AppMethodBeat.i(137674);
                Log.i("MicroMsg.JsApiSetKeepScreenOn", "onDestroy");
                if (p.a(p.this)) {
                  p.b(p.this);
                }
                h.b(paramf.getAppId(), this);
                AppMethodBeat.o(137674);
              }
              
              public final void onResume()
              {
                AppMethodBeat.i(137676);
                Log.i("MicroMsg.JsApiSetKeepScreenOn", "onResume");
                if (p.mub) {
                  p.c(p.this);
                }
                AppMethodBeat.o(137676);
              }
            };
          }
          h.a(paramf.getAppId(), this.lLT);
          bool = bIU();
          if (!bool) {
            break;
          }
          Log.i("MicroMsg.JsApiSetKeepScreenOn", "setKeepScreenOn ok");
          paramf.i(paramInt, h("ok", null));
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
        Log.i("MicroMsg.JsApiSetKeepScreenOn", "reset screen off");
        bool = release();
      }
      else
      {
        Log.e("MicroMsg.JsApiSetKeepScreenOn", "fail, has not set screen");
        paramf.i(paramInt, h("fail:has not set screen", null));
        AppMethodBeat.o(137677);
        return;
      }
    }
    Log.e("MicroMsg.JsApiSetKeepScreenOn", "setKeepScreenOn fail");
    paramf.i(paramInt, h("fail", null));
    AppMethodBeat.o(137677);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.z.p
 * JD-Core Version:    0.7.0.1
 */