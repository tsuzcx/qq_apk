package com.tencent.mm.plugin.appbrand.jsapi.ae;

import android.app.Activity;
import android.os.PowerManager;
import android.os.PowerManager.WakeLock;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.jsapi.f;
import com.tencent.mm.plugin.appbrand.k;
import com.tencent.mm.plugin.appbrand.k.c;
import com.tencent.mm.plugin.appbrand.k.d;
import com.tencent.mm.sdk.platformtools.Log;
import org.json.JSONObject;

public final class v
  extends c
{
  public static final int CTRL_INDEX = -2;
  public static final String NAME = "setKeepScreenOn";
  private static boolean sxf = false;
  private k.c rZq;
  private f rzi;
  PowerManager.WakeLock wakeLock;
  
  private boolean cuS()
  {
    for (;;)
    {
      try
      {
        AppMethodBeat.i(137678);
        boolean bool;
        if (this.rzi.getContext() == null)
        {
          Log.e("MicroMsg.JsApiSetKeepScreenOn", "acquire fail, server context is nul");
          bool = false;
          AppMethodBeat.o(137678);
          return bool;
        }
        Log.e("MicroMsg.JsApiSetKeepScreenOn", "acquire ok");
        Object localObject1 = (Activity)this.rzi.getContext();
        if (this.wakeLock == null) {
          this.wakeLock = ((PowerManager)((Activity)localObject1).getSystemService("power")).newWakeLock(536870922, "MicroMsg.JsApiSetKeepScreenOn");
        }
        if (!this.wakeLock.isHeld())
        {
          localObject1 = this.wakeLock;
          a.b(localObject1, "com/tencent/mm/plugin/appbrand/jsapi/system/JsApiSetKeepScreenOn", "acquire", "()Z", "android/os/PowerManager$WakeLock_EXEC_", "acquire", "()V");
          ((PowerManager.WakeLock)localObject1).acquire();
          a.c(localObject1, "com/tencent/mm/plugin/appbrand/jsapi/system/JsApiSetKeepScreenOn", "acquire", "()Z", "android/os/PowerManager$WakeLock_EXEC_", "acquire", "()V");
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
    //   2: ldc 121
    //   4: invokestatic 38	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   7: aload_0
    //   8: getfield 81	com/tencent/mm/plugin/appbrand/jsapi/ae/v:wakeLock	Landroid/os/PowerManager$WakeLock;
    //   11: ifnull +24 -> 35
    //   14: aload_0
    //   15: getfield 81	com/tencent/mm/plugin/appbrand/jsapi/ae/v:wakeLock	Landroid/os/PowerManager$WakeLock;
    //   18: invokevirtual 97	android/os/PowerManager$WakeLock:isHeld	()Z
    //   21: ifeq +14 -> 35
    //   24: iconst_1
    //   25: istore_1
    //   26: ldc 121
    //   28: invokestatic 45	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   31: aload_0
    //   32: monitorexit
    //   33: iload_1
    //   34: ireturn
    //   35: iconst_0
    //   36: istore_1
    //   37: ldc 121
    //   39: invokestatic 45	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   42: goto -11 -> 31
    //   45: astore_2
    //   46: aload_0
    //   47: monitorexit
    //   48: aload_2
    //   49: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	50	0	this	v
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
    //   2: ldc 122
    //   4: invokestatic 38	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   7: ldc 67
    //   9: ldc 123
    //   11: invokestatic 75	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   14: aload_0
    //   15: getfield 81	com/tencent/mm/plugin/appbrand/jsapi/ae/v:wakeLock	Landroid/os/PowerManager$WakeLock;
    //   18: ifnull +70 -> 88
    //   21: aload_0
    //   22: getfield 81	com/tencent/mm/plugin/appbrand/jsapi/ae/v:wakeLock	Landroid/os/PowerManager$WakeLock;
    //   25: invokevirtual 97	android/os/PowerManager$WakeLock:isHeld	()Z
    //   28: ifeq +60 -> 88
    //   31: aload_0
    //   32: getfield 81	com/tencent/mm/plugin/appbrand/jsapi/ae/v:wakeLock	Landroid/os/PowerManager$WakeLock;
    //   35: astore_2
    //   36: aload_2
    //   37: ldc 99
    //   39: ldc 123
    //   41: ldc 102
    //   43: ldc 104
    //   45: ldc 123
    //   47: ldc 105
    //   49: invokestatic 110	com/tencent/mm/hellhoundlib/a/a:b	(Ljava/lang/Object;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   52: aload_2
    //   53: invokevirtual 125	android/os/PowerManager$WakeLock:release	()V
    //   56: aload_2
    //   57: ldc 99
    //   59: ldc 123
    //   61: ldc 102
    //   63: ldc 104
    //   65: ldc 123
    //   67: ldc 105
    //   69: invokestatic 114	com/tencent/mm/hellhoundlib/a/a:c	(Ljava/lang/Object;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   72: aload_0
    //   73: aconst_null
    //   74: putfield 81	com/tencent/mm/plugin/appbrand/jsapi/ae/v:wakeLock	Landroid/os/PowerManager$WakeLock;
    //   77: iconst_1
    //   78: istore_1
    //   79: ldc 122
    //   81: invokestatic 45	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   84: aload_0
    //   85: monitorexit
    //   86: iload_1
    //   87: ireturn
    //   88: ldc 67
    //   90: ldc 127
    //   92: invokestatic 75	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   95: iconst_0
    //   96: istore_1
    //   97: ldc 122
    //   99: invokestatic 45	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   102: goto -18 -> 84
    //   105: astore_2
    //   106: aload_0
    //   107: monitorexit
    //   108: aload_2
    //   109: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	110	0	this	v
    //   78	19	1	bool	boolean
    //   35	22	2	localWakeLock	PowerManager.WakeLock
    //   105	4	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	77	105	finally
    //   79	84	105	finally
    //   88	95	105	finally
    //   97	102	105	finally
  }
  
  public final void a(final f paramf, JSONObject paramJSONObject, int paramInt)
  {
    AppMethodBeat.i(137677);
    if (paramJSONObject == null)
    {
      Log.e("MicroMsg.JsApiSetKeepScreenOn", "setKeepScreenOn data is null");
      paramf.callback(paramInt, ZP("fail:data is null"));
      AppMethodBeat.o(137677);
      return;
    }
    if (paramf.getContext() == null)
    {
      Log.e("MicroMsg.JsApiSetKeepScreenOn", "setKeepScreenOn, server context is nul");
      paramf.callback(paramInt, ZP("fail:context is null"));
      AppMethodBeat.o(137677);
      return;
    }
    if (!(paramf.getContext() instanceof Activity))
    {
      Log.e("MicroMsg.JsApiSetKeepScreenOn", "setKeepScreenOn, server context is not activity, don't do invoke");
      paramf.callback(paramInt, ZP("fail:context is null"));
      AppMethodBeat.o(137677);
      return;
    }
    boolean bool = paramJSONObject.optBoolean("keepScreenOn", false);
    sxf = bool;
    Log.i("MicroMsg.JsApiSetKeepScreenOn", "setKeepScreenOn, keepScreenOn:%b, appId:%s", new Object[] { Boolean.valueOf(bool), paramf.getAppId() });
    for (;;)
    {
      try
      {
        this.rzi = paramf;
        if (bool)
        {
          if (this.rZq == null) {
            this.rZq = new k.c()
            {
              public final void a(k.d paramAnonymousd)
              {
                AppMethodBeat.i(137675);
                Log.i("MicroMsg.JsApiSetKeepScreenOn", "onPause");
                if (v.a(v.this)) {
                  v.b(v.this);
                }
                AppMethodBeat.o(137675);
              }
              
              public final void onDestroy()
              {
                AppMethodBeat.i(137674);
                Log.i("MicroMsg.JsApiSetKeepScreenOn", "onDestroy");
                if (v.a(v.this)) {
                  v.b(v.this);
                }
                k.b(paramf.getAppId(), this);
                AppMethodBeat.o(137674);
              }
              
              public final void onResume()
              {
                AppMethodBeat.i(137676);
                Log.i("MicroMsg.JsApiSetKeepScreenOn", "onResume");
                if (v.ayB()) {
                  v.c(v.this);
                }
                AppMethodBeat.o(137676);
              }
            };
          }
          k.a(paramf.getAppId(), this.rZq);
          bool = cuS();
          if (!bool) {
            break;
          }
          Log.i("MicroMsg.JsApiSetKeepScreenOn", "setKeepScreenOn ok");
          paramf.callback(paramInt, ZP("ok"));
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
        paramf.callback(paramInt, ZP("fail:has not set screen"));
        AppMethodBeat.o(137677);
        return;
      }
    }
    Log.e("MicroMsg.JsApiSetKeepScreenOn", "setKeepScreenOn fail");
    paramf.callback(paramInt, ZP("fail"));
    AppMethodBeat.o(137677);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.ae.v
 * JD-Core Version:    0.7.0.1
 */