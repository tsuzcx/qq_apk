package com.tencent.mm.plugin.appbrand.jsapi;

import java.util.Timer;
import java.util.TimerTask;

final class JsApiBatchGetContact$JsApiBatchGetContactTask$1$1
  extends TimerTask
{
  JsApiBatchGetContact$JsApiBatchGetContactTask$1$1(JsApiBatchGetContact.JsApiBatchGetContactTask.1 param1, boolean[] paramArrayOfBoolean, Timer paramTimer) {}
  
  /* Error */
  public final void run()
  {
    // Byte code:
    //   0: ldc 28
    //   2: monitorenter
    //   3: aload_0
    //   4: getfield 21	com/tencent/mm/plugin/appbrand/jsapi/JsApiBatchGetContact$JsApiBatchGetContactTask$1$1:gfJ	[Z
    //   7: iconst_0
    //   8: baload
    //   9: ifeq +26 -> 35
    //   12: ldc 30
    //   14: ldc 32
    //   16: invokestatic 38	com/tencent/mm/sdk/platformtools/y:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   19: ldc 28
    //   21: monitorexit
    //   22: aload_0
    //   23: invokevirtual 42	com/tencent/mm/plugin/appbrand/jsapi/JsApiBatchGetContact$JsApiBatchGetContactTask$1$1:cancel	()Z
    //   26: pop
    //   27: aload_0
    //   28: getfield 23	com/tencent/mm/plugin/appbrand/jsapi/JsApiBatchGetContact$JsApiBatchGetContactTask$1$1:gfK	Ljava/util/Timer;
    //   31: invokevirtual 46	java/util/Timer:cancel	()V
    //   34: return
    //   35: aload_0
    //   36: getfield 21	com/tencent/mm/plugin/appbrand/jsapi/JsApiBatchGetContact$JsApiBatchGetContactTask$1$1:gfJ	[Z
    //   39: iconst_0
    //   40: iconst_1
    //   41: bastore
    //   42: ldc 30
    //   44: ldc 48
    //   46: invokestatic 51	com/tencent/mm/sdk/platformtools/y:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   49: aload_0
    //   50: getfield 19	com/tencent/mm/plugin/appbrand/jsapi/JsApiBatchGetContact$JsApiBatchGetContactTask$1$1:gfL	Lcom/tencent/mm/plugin/appbrand/jsapi/JsApiBatchGetContact$JsApiBatchGetContactTask$1;
    //   53: getfield 55	com/tencent/mm/plugin/appbrand/jsapi/JsApiBatchGetContact$JsApiBatchGetContactTask$1:gfI	Lcom/tencent/mm/plugin/appbrand/jsapi/JsApiBatchGetContact$JsApiBatchGetContactTask;
    //   56: ldc 57
    //   58: invokestatic 63	com/tencent/mm/plugin/appbrand/jsapi/JsApiBatchGetContact$JsApiBatchGetContactTask:a	(Lcom/tencent/mm/plugin/appbrand/jsapi/JsApiBatchGetContact$JsApiBatchGetContactTask;Ljava/lang/String;)Ljava/lang/String;
    //   61: pop
    //   62: aload_0
    //   63: getfield 19	com/tencent/mm/plugin/appbrand/jsapi/JsApiBatchGetContact$JsApiBatchGetContactTask$1$1:gfL	Lcom/tencent/mm/plugin/appbrand/jsapi/JsApiBatchGetContact$JsApiBatchGetContactTask$1;
    //   66: getfield 55	com/tencent/mm/plugin/appbrand/jsapi/JsApiBatchGetContact$JsApiBatchGetContactTask$1:gfI	Lcom/tencent/mm/plugin/appbrand/jsapi/JsApiBatchGetContact$JsApiBatchGetContactTask;
    //   69: invokestatic 66	com/tencent/mm/plugin/appbrand/jsapi/JsApiBatchGetContact$JsApiBatchGetContactTask:a	(Lcom/tencent/mm/plugin/appbrand/jsapi/JsApiBatchGetContact$JsApiBatchGetContactTask;)Z
    //   72: pop
    //   73: goto -54 -> 19
    //   76: astore_1
    //   77: ldc 28
    //   79: monitorexit
    //   80: aload_1
    //   81: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	82	0	this	1
    //   76	5	1	localObject	java.lang.Object
    // Exception table:
    //   from	to	target	type
    //   3	19	76	finally
    //   19	22	76	finally
    //   35	73	76	finally
    //   77	80	76	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.JsApiBatchGetContact.JsApiBatchGetContactTask.1.1
 * JD-Core Version:    0.7.0.1
 */