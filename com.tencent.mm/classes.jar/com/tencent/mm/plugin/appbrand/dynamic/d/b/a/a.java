package com.tencent.mm.plugin.appbrand.dynamic.d.b.a;

import android.text.TextUtils;
import com.tencent.mm.modelappbrand.u;
import com.tencent.mm.plugin.appbrand.canvas.action.arg.a.d;
import com.tencent.mm.plugin.appbrand.canvas.widget.DrawCanvasArg;
import com.tencent.mm.plugin.appbrand.dynamic.d.b.b;
import com.tencent.mm.sdk.SynchronizedPool;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import org.json.JSONObject;

public abstract class a
  implements e<DrawCanvasArg>
{
  protected DrawCanvasArg lon;
  protected String loo;
  protected BlockingQueue<b> lop = new LinkedBlockingQueue(100);
  protected BlockingQueue<Runnable> loq = new LinkedBlockingQueue(100);
  protected volatile long lor;
  protected volatile long los;
  protected int lot;
  protected int lou;
  protected boolean lov;
  protected Thread workerThread = new Thread(new Runnable()
  {
    /* Error */
    public final void run()
    {
      // Byte code:
      //   0: ldc 22
      //   2: invokestatic 28	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
      //   5: aload_0
      //   6: getfield 16	com/tencent/mm/plugin/appbrand/dynamic/d/b/a/a$1:low	Lcom/tencent/mm/plugin/appbrand/dynamic/d/b/a/a;
      //   9: getfield 32	com/tencent/mm/plugin/appbrand/dynamic/d/b/a/a:workerThread	Ljava/lang/Thread;
      //   12: invokevirtual 38	java/lang/Thread:isInterrupted	()Z
      //   15: ifeq +9 -> 24
      //   18: ldc 22
      //   20: invokestatic 41	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   23: return
      //   24: aload_0
      //   25: getfield 16	com/tencent/mm/plugin/appbrand/dynamic/d/b/a/a$1:low	Lcom/tencent/mm/plugin/appbrand/dynamic/d/b/a/a;
      //   28: getfield 45	com/tencent/mm/plugin/appbrand/dynamic/d/b/a/a:lop	Ljava/util/concurrent/BlockingQueue;
      //   31: invokeinterface 51 1 0
      //   36: checkcast 53	com/tencent/mm/plugin/appbrand/dynamic/d/b/b
      //   39: astore_1
      //   40: aload_1
      //   41: astore_2
      //   42: aload_0
      //   43: getfield 16	com/tencent/mm/plugin/appbrand/dynamic/d/b/a/a$1:low	Lcom/tencent/mm/plugin/appbrand/dynamic/d/b/a/a;
      //   46: getfield 45	com/tencent/mm/plugin/appbrand/dynamic/d/b/a/a:lop	Ljava/util/concurrent/BlockingQueue;
      //   49: invokeinterface 57 1 0
      //   54: iconst_2
      //   55: if_icmplt +82 -> 137
      //   58: aload_1
      //   59: astore_2
      //   60: aload_0
      //   61: getfield 16	com/tencent/mm/plugin/appbrand/dynamic/d/b/a/a$1:low	Lcom/tencent/mm/plugin/appbrand/dynamic/d/b/a/a;
      //   64: getfield 61	com/tencent/mm/plugin/appbrand/dynamic/d/b/a/a:lor	J
      //   67: lconst_0
      //   68: lcmp
      //   69: ifle +68 -> 137
      //   72: aload_1
      //   73: astore_2
      //   74: aload_1
      //   75: getfield 64	com/tencent/mm/plugin/appbrand/dynamic/d/b/b:loa	J
      //   78: aload_0
      //   79: getfield 16	com/tencent/mm/plugin/appbrand/dynamic/d/b/a/a$1:low	Lcom/tencent/mm/plugin/appbrand/dynamic/d/b/a/a;
      //   82: getfield 67	com/tencent/mm/plugin/appbrand/dynamic/d/b/a/a:los	J
      //   85: lcmp
      //   86: ifge +51 -> 137
      //   89: aload_0
      //   90: getfield 16	com/tencent/mm/plugin/appbrand/dynamic/d/b/a/a$1:low	Lcom/tencent/mm/plugin/appbrand/dynamic/d/b/a/a;
      //   93: astore_1
      //   94: aload_1
      //   95: aload_1
      //   96: getfield 71	com/tencent/mm/plugin/appbrand/dynamic/d/b/a/a:lot	I
      //   99: iconst_1
      //   100: iadd
      //   101: putfield 71	com/tencent/mm/plugin/appbrand/dynamic/d/b/a/a:lot	I
      //   104: aload_0
      //   105: getfield 16	com/tencent/mm/plugin/appbrand/dynamic/d/b/a/a$1:low	Lcom/tencent/mm/plugin/appbrand/dynamic/d/b/a/a;
      //   108: getfield 45	com/tencent/mm/plugin/appbrand/dynamic/d/b/a/a:lop	Ljava/util/concurrent/BlockingQueue;
      //   111: invokeinterface 74 1 0
      //   116: checkcast 53	com/tencent/mm/plugin/appbrand/dynamic/d/b/b
      //   119: astore_2
      //   120: aload_2
      //   121: astore_1
      //   122: aload_0
      //   123: getfield 16	com/tencent/mm/plugin/appbrand/dynamic/d/b/a/a$1:low	Lcom/tencent/mm/plugin/appbrand/dynamic/d/b/a/a;
      //   126: getfield 45	com/tencent/mm/plugin/appbrand/dynamic/d/b/a/a:lop	Ljava/util/concurrent/BlockingQueue;
      //   129: invokeinterface 57 1 0
      //   134: ifgt -62 -> 72
      //   137: aload_2
      //   138: ifnull +84 -> 222
      //   141: aload_2
      //   142: invokevirtual 76	com/tencent/mm/plugin/appbrand/dynamic/d/b/b:run	()V
      //   145: aload_0
      //   146: getfield 16	com/tencent/mm/plugin/appbrand/dynamic/d/b/a/a$1:low	Lcom/tencent/mm/plugin/appbrand/dynamic/d/b/a/a;
      //   149: aload_2
      //   150: getfield 64	com/tencent/mm/plugin/appbrand/dynamic/d/b/b:loa	J
      //   153: putfield 61	com/tencent/mm/plugin/appbrand/dynamic/d/b/a/a:lor	J
      //   156: aload_0
      //   157: getfield 16	com/tencent/mm/plugin/appbrand/dynamic/d/b/a/a$1:low	Lcom/tencent/mm/plugin/appbrand/dynamic/d/b/a/a;
      //   160: getfield 80	com/tencent/mm/plugin/appbrand/dynamic/d/b/a/a:lov	Z
      //   163: ifeq +59 -> 222
      //   166: ldc 82
      //   168: ldc 84
      //   170: iconst_0
      //   171: anewarray 4	java/lang/Object
      //   174: invokestatic 89	com/tencent/mm/modelappbrand/u:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
      //   177: aload_0
      //   178: getfield 16	com/tencent/mm/plugin/appbrand/dynamic/d/b/a/a$1:low	Lcom/tencent/mm/plugin/appbrand/dynamic/d/b/a/a;
      //   181: getfield 92	com/tencent/mm/plugin/appbrand/dynamic/d/b/a/a:loq	Ljava/util/concurrent/BlockingQueue;
      //   184: invokeinterface 51 1 0
      //   189: checkcast 6	java/lang/Runnable
      //   192: astore_1
      //   193: aload_1
      //   194: ifnull +9 -> 203
      //   197: aload_1
      //   198: invokeinterface 93 1 0
      //   203: aload_0
      //   204: getfield 16	com/tencent/mm/plugin/appbrand/dynamic/d/b/a/a$1:low	Lcom/tencent/mm/plugin/appbrand/dynamic/d/b/a/a;
      //   207: iconst_0
      //   208: putfield 80	com/tencent/mm/plugin/appbrand/dynamic/d/b/a/a:lov	Z
      //   211: ldc 82
      //   213: ldc 95
      //   215: iconst_0
      //   216: anewarray 4	java/lang/Object
      //   219: invokestatic 89	com/tencent/mm/modelappbrand/u:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
      //   222: aload_0
      //   223: getfield 16	com/tencent/mm/plugin/appbrand/dynamic/d/b/a/a$1:low	Lcom/tencent/mm/plugin/appbrand/dynamic/d/b/a/a;
      //   226: getfield 32	com/tencent/mm/plugin/appbrand/dynamic/d/b/a/a:workerThread	Ljava/lang/Thread;
      //   229: invokevirtual 38	java/lang/Thread:isInterrupted	()Z
      //   232: ifne +69 -> 301
      //   235: ldc2_w 96
      //   238: invokestatic 101	java/lang/Thread:sleep	(J)V
      //   241: goto -236 -> 5
      //   244: astore_1
      //   245: ldc 82
      //   247: aload_1
      //   248: ldc 103
      //   250: iconst_0
      //   251: anewarray 4	java/lang/Object
      //   254: invokestatic 109	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
      //   257: ldc 22
      //   259: invokestatic 41	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   262: return
      //   263: astore_1
      //   264: ldc 82
      //   266: aload_1
      //   267: ldc 103
      //   269: iconst_0
      //   270: anewarray 4	java/lang/Object
      //   273: invokestatic 109	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
      //   276: ldc 22
      //   278: invokestatic 41	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   281: return
      //   282: astore_1
      //   283: ldc 82
      //   285: aload_1
      //   286: ldc 103
      //   288: iconst_0
      //   289: anewarray 4	java/lang/Object
      //   292: invokestatic 109	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
      //   295: ldc 22
      //   297: invokestatic 41	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   300: return
      //   301: ldc 22
      //   303: invokestatic 41	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   306: return
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	307	0	this	1
      //   39	159	1	localObject1	Object
      //   244	4	1	localInterruptedException1	InterruptedException
      //   263	4	1	localInterruptedException2	InterruptedException
      //   282	4	1	localInterruptedException3	InterruptedException
      //   41	109	2	localObject2	Object
      // Exception table:
      //   from	to	target	type
      //   235	241	244	java/lang/InterruptedException
      //   24	40	263	java/lang/InterruptedException
      //   166	193	282	java/lang/InterruptedException
      //   197	203	282	java/lang/InterruptedException
      //   203	222	282	java/lang/InterruptedException
    }
  }, "DrawCanvasMgr-worker");
  
  public a()
  {
    this.workerThread.start();
  }
  
  public final void W(Runnable paramRunnable)
  {
    try
    {
      this.loq.put(paramRunnable);
      return;
    }
    catch (InterruptedException paramRunnable)
    {
      Log.printErrStackTrace("BaseDrawCanvasWithObj", paramRunnable, "", new Object[0]);
    }
  }
  
  public final boolean YA(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    while ((this.loo != null) && (this.loo.hashCode() == paramString.hashCode())) {
      return false;
    }
    return true;
  }
  
  public final void a(b paramb)
  {
    try
    {
      this.lop.put(paramb);
      this.los = paramb.loa;
      this.lou += 1;
      return;
    }
    catch (InterruptedException paramb)
    {
      Log.printErrStackTrace("BaseDrawCanvasWithObj", paramb, "", new Object[0]);
    }
  }
  
  public final void bCd()
  {
    this.lov = true;
  }
  
  public DrawCanvasArg c(JSONObject paramJSONObject, String paramString)
  {
    DrawCanvasArg localDrawCanvasArg2 = (DrawCanvasArg)d.bzo().laa.acquire();
    DrawCanvasArg localDrawCanvasArg1 = localDrawCanvasArg2;
    if (localDrawCanvasArg2 == null) {
      localDrawCanvasArg1 = new DrawCanvasArg();
    }
    localDrawCanvasArg1.lax = paramJSONObject.optBoolean("reserve");
    localDrawCanvasArg1.lay = paramString;
    localDrawCanvasArg1.laz = paramJSONObject.optLong("__invoke_jsapi_timestamp");
    return localDrawCanvasArg1;
  }
  
  public final void reset()
  {
    this.loo = null;
    u.i("BaseDrawCanvasWithObj", "drop frame %d times, allFrame %d ", new Object[] { Integer.valueOf(this.lot), Integer.valueOf(this.lou) });
    this.lou = 0;
    this.lot = 0;
    this.lor = 0L;
    this.workerThread.interrupt();
    for (Runnable localRunnable = (Runnable)this.loq.poll(); localRunnable != null; localRunnable = (Runnable)this.loq.poll()) {
      if (localRunnable != null) {
        localRunnable.run();
      }
    }
    this.loq.clear();
    this.lop.clear();
    if (this.lon != null)
    {
      this.lon.reset();
      this.lon = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.dynamic.d.b.a.a
 * JD-Core Version:    0.7.0.1
 */