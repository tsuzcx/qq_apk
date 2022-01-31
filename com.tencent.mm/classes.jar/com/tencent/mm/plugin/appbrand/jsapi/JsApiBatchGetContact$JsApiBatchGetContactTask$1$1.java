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
    //   0: ldc 27
    //   2: invokestatic 33	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: ldc 35
    //   7: monitorenter
    //   8: aload_0
    //   9: getfield 21	com/tencent/mm/plugin/appbrand/jsapi/JsApiBatchGetContact$JsApiBatchGetContactTask$1$1:hxv	[Z
    //   12: iconst_0
    //   13: baload
    //   14: ifeq +31 -> 45
    //   17: ldc 37
    //   19: ldc 39
    //   21: invokestatic 44	com/tencent/mm/sdk/platformtools/ab:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   24: ldc 35
    //   26: monitorexit
    //   27: aload_0
    //   28: invokevirtual 48	com/tencent/mm/plugin/appbrand/jsapi/JsApiBatchGetContact$JsApiBatchGetContactTask$1$1:cancel	()Z
    //   31: pop
    //   32: aload_0
    //   33: getfield 23	com/tencent/mm/plugin/appbrand/jsapi/JsApiBatchGetContact$JsApiBatchGetContactTask$1$1:hxw	Ljava/util/Timer;
    //   36: invokevirtual 52	java/util/Timer:cancel	()V
    //   39: ldc 27
    //   41: invokestatic 55	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   44: return
    //   45: aload_0
    //   46: getfield 21	com/tencent/mm/plugin/appbrand/jsapi/JsApiBatchGetContact$JsApiBatchGetContactTask$1$1:hxv	[Z
    //   49: iconst_0
    //   50: iconst_1
    //   51: bastore
    //   52: ldc 37
    //   54: ldc 57
    //   56: invokestatic 60	com/tencent/mm/sdk/platformtools/ab:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   59: aload_0
    //   60: getfield 19	com/tencent/mm/plugin/appbrand/jsapi/JsApiBatchGetContact$JsApiBatchGetContactTask$1$1:hxx	Lcom/tencent/mm/plugin/appbrand/jsapi/JsApiBatchGetContact$JsApiBatchGetContactTask$1;
    //   63: getfield 64	com/tencent/mm/plugin/appbrand/jsapi/JsApiBatchGetContact$JsApiBatchGetContactTask$1:hxu	Lcom/tencent/mm/plugin/appbrand/jsapi/JsApiBatchGetContact$JsApiBatchGetContactTask;
    //   66: ldc 66
    //   68: invokestatic 72	com/tencent/mm/plugin/appbrand/jsapi/JsApiBatchGetContact$JsApiBatchGetContactTask:a	(Lcom/tencent/mm/plugin/appbrand/jsapi/JsApiBatchGetContact$JsApiBatchGetContactTask;Ljava/lang/String;)Ljava/lang/String;
    //   71: pop
    //   72: aload_0
    //   73: getfield 19	com/tencent/mm/plugin/appbrand/jsapi/JsApiBatchGetContact$JsApiBatchGetContactTask$1$1:hxx	Lcom/tencent/mm/plugin/appbrand/jsapi/JsApiBatchGetContact$JsApiBatchGetContactTask$1;
    //   76: getfield 64	com/tencent/mm/plugin/appbrand/jsapi/JsApiBatchGetContact$JsApiBatchGetContactTask$1:hxu	Lcom/tencent/mm/plugin/appbrand/jsapi/JsApiBatchGetContact$JsApiBatchGetContactTask;
    //   79: invokestatic 75	com/tencent/mm/plugin/appbrand/jsapi/JsApiBatchGetContact$JsApiBatchGetContactTask:a	(Lcom/tencent/mm/plugin/appbrand/jsapi/JsApiBatchGetContact$JsApiBatchGetContactTask;)Z
    //   82: pop
    //   83: goto -59 -> 24
    //   86: astore_1
    //   87: ldc 35
    //   89: monitorexit
    //   90: ldc 27
    //   92: invokestatic 55	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   95: aload_1
    //   96: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	97	0	this	1
    //   86	10	1	localObject	java.lang.Object
    // Exception table:
    //   from	to	target	type
    //   8	24	86	finally
    //   24	27	86	finally
    //   45	83	86	finally
    //   87	90	86	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.JsApiBatchGetContact.JsApiBatchGetContactTask.1.1
 * JD-Core Version:    0.7.0.1
 */