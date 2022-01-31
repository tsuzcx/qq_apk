package com.tencent.mm.plugin.appbrand.jsapi.q;

import android.app.Activity;
import android.os.PowerManager;
import android.os.PowerManager.WakeLock;
import com.tencent.mm.plugin.appbrand.g;
import com.tencent.mm.plugin.appbrand.jsapi.a;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.sdk.platformtools.y;
import org.json.JSONObject;

public final class i
  extends a
{
  public static final int CTRL_INDEX = -2;
  public static final String NAME = "setKeepScreenOn";
  private static boolean gCk = false;
  private c ggu;
  PowerManager.WakeLock wakeLock;
  
  private boolean akb()
  {
    for (;;)
    {
      try
      {
        if (this.ggu.getContext() == null)
        {
          y.e("MicroMsg.JsApiSetKeepScreenOn", "acquire fail, server context is nul");
          bool = false;
          return bool;
        }
        y.e("MicroMsg.JsApiSetKeepScreenOn", "acquire ok");
        Activity localActivity = (Activity)this.ggu.getContext();
        if (this.wakeLock == null) {
          this.wakeLock = ((PowerManager)localActivity.getSystemService("power")).newWakeLock(536870922, "MicroMsg.JsApiSetKeepScreenOn");
        }
        if (!this.wakeLock.isHeld())
        {
          this.wakeLock.acquire();
          y.i("MicroMsg.JsApiSetKeepScreenOn", "wakeLock acquire");
        }
        else
        {
          y.i("MicroMsg.JsApiSetKeepScreenOn", "wakeLock has held ");
        }
      }
      finally {}
      boolean bool = true;
    }
  }
  
  /* Error */
  private boolean isHeld()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 57	com/tencent/mm/plugin/appbrand/jsapi/q/i:wakeLock	Landroid/os/PowerManager$WakeLock;
    //   6: ifnull +21 -> 27
    //   9: aload_0
    //   10: getfield 57	com/tencent/mm/plugin/appbrand/jsapi/q/i:wakeLock	Landroid/os/PowerManager$WakeLock;
    //   13: invokevirtual 73	android/os/PowerManager$WakeLock:isHeld	()Z
    //   16: istore_1
    //   17: iload_1
    //   18: ifeq +9 -> 27
    //   21: iconst_1
    //   22: istore_1
    //   23: aload_0
    //   24: monitorexit
    //   25: iload_1
    //   26: ireturn
    //   27: iconst_0
    //   28: istore_1
    //   29: goto -6 -> 23
    //   32: astore_2
    //   33: aload_0
    //   34: monitorexit
    //   35: aload_2
    //   36: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	37	0	this	i
    //   16	13	1	bool	boolean
    //   32	4	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	17	32	finally
  }
  
  /* Error */
  private boolean release()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc 43
    //   4: ldc 91
    //   6: invokestatic 51	com/tencent/mm/sdk/platformtools/y:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   9: aload_0
    //   10: getfield 57	com/tencent/mm/plugin/appbrand/jsapi/q/i:wakeLock	Landroid/os/PowerManager$WakeLock;
    //   13: ifnull +31 -> 44
    //   16: aload_0
    //   17: getfield 57	com/tencent/mm/plugin/appbrand/jsapi/q/i:wakeLock	Landroid/os/PowerManager$WakeLock;
    //   20: invokevirtual 73	android/os/PowerManager$WakeLock:isHeld	()Z
    //   23: ifeq +21 -> 44
    //   26: aload_0
    //   27: getfield 57	com/tencent/mm/plugin/appbrand/jsapi/q/i:wakeLock	Landroid/os/PowerManager$WakeLock;
    //   30: invokevirtual 93	android/os/PowerManager$WakeLock:release	()V
    //   33: aload_0
    //   34: aconst_null
    //   35: putfield 57	com/tencent/mm/plugin/appbrand/jsapi/q/i:wakeLock	Landroid/os/PowerManager$WakeLock;
    //   38: iconst_1
    //   39: istore_1
    //   40: aload_0
    //   41: monitorexit
    //   42: iload_1
    //   43: ireturn
    //   44: ldc 43
    //   46: ldc 95
    //   48: invokestatic 51	com/tencent/mm/sdk/platformtools/y:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   51: iconst_0
    //   52: istore_1
    //   53: goto -13 -> 40
    //   56: astore_2
    //   57: aload_0
    //   58: monitorexit
    //   59: aload_2
    //   60: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	61	0	this	i
    //   39	14	1	bool	boolean
    //   56	4	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	38	56	finally
    //   44	51	56	finally
  }
  
  public final void a(c paramc, JSONObject paramJSONObject, int paramInt)
  {
    if (paramJSONObject == null)
    {
      y.e("MicroMsg.JsApiSetKeepScreenOn", "setKeepScreenOn data is null");
      paramc.C(paramInt, h("fail:data is null", null));
      return;
    }
    if (paramc.getContext() == null)
    {
      y.e("MicroMsg.JsApiSetKeepScreenOn", "setKeepScreenOn, server context is nul");
      paramc.C(paramInt, h("fail:context is null", null));
      return;
    }
    if (!(paramc.getContext() instanceof Activity))
    {
      y.e("MicroMsg.JsApiSetKeepScreenOn", "setKeepScreenOn, server context is not activity, don't do invoke");
      paramc.C(paramInt, h("fail:context is null", null));
      return;
    }
    boolean bool = paramJSONObject.optBoolean("keepScreenOn", false);
    gCk = bool;
    y.i("MicroMsg.JsApiSetKeepScreenOn", "setKeepScreenOn, keepScreenOn:%b, appId:%s", new Object[] { Boolean.valueOf(bool), paramc.getAppId() });
    for (;;)
    {
      try
      {
        this.ggu = paramc;
        if (bool)
        {
          paramJSONObject = new i.1(this, paramc);
          g.a(paramc.getAppId(), paramJSONObject);
          bool = akb();
          if (!bool) {
            break;
          }
          y.i("MicroMsg.JsApiSetKeepScreenOn", "setKeepScreenOn ok");
          paramc.C(paramInt, h("ok", null));
          return;
        }
      }
      finally {}
      if (isHeld())
      {
        y.i("MicroMsg.JsApiSetKeepScreenOn", "reset screen off");
        bool = release();
      }
      else
      {
        y.e("MicroMsg.JsApiSetKeepScreenOn", "fail, has not set screen");
        paramc.C(paramInt, h("fail:has not set screen", null));
        return;
      }
    }
    y.e("MicroMsg.JsApiSetKeepScreenOn", "setKeepScreenOn fail");
    paramc.C(paramInt, h("fail", null));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.q.i
 * JD-Core Version:    0.7.0.1
 */