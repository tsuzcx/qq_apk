package com.tencent.mm.plugin.appbrand.dynamic.d.b.a;

import android.text.TextUtils;
import com.tencent.mm.modelappbrand.u;
import com.tencent.mm.plugin.appbrand.canvas.action.arg.a.d;
import com.tencent.mm.plugin.appbrand.canvas.widget.DrawCanvasArg;
import com.tencent.mm.sdk.platformtools.y;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import org.json.JSONObject;

public abstract class a
  implements e<DrawCanvasArg>
{
  protected DrawCanvasArg fWe;
  protected String fWf;
  protected BlockingQueue<com.tencent.mm.plugin.appbrand.dynamic.d.b.b> fWg = new LinkedBlockingQueue(100);
  protected BlockingQueue<Runnable> fWh = new LinkedBlockingQueue(100);
  protected volatile long fWi;
  protected volatile long fWj;
  protected int fWk;
  protected int fWl;
  protected boolean fWm;
  protected Thread workerThread = new Thread(new a.1(this), "DrawCanvasMgr-worker");
  
  public a()
  {
    this.workerThread.start();
  }
  
  public final void a(com.tencent.mm.plugin.appbrand.dynamic.d.b.b paramb)
  {
    try
    {
      this.fWg.put(paramb);
      this.fWj = paramb.fVT;
      this.fWl += 1;
      return;
    }
    catch (InterruptedException paramb)
    {
      y.printErrStackTrace("BaseDrawCanvasWithObj", paramb, "", new Object[0]);
    }
  }
  
  public final void afo()
  {
    this.fWm = true;
  }
  
  public DrawCanvasArg e(JSONObject paramJSONObject, String paramString)
  {
    DrawCanvasArg localDrawCanvasArg2 = (DrawCanvasArg)d.adJ().fMk.de();
    DrawCanvasArg localDrawCanvasArg1 = localDrawCanvasArg2;
    if (localDrawCanvasArg2 == null) {
      localDrawCanvasArg1 = new DrawCanvasArg();
    }
    localDrawCanvasArg1.fMF = paramJSONObject.optBoolean("reserve");
    localDrawCanvasArg1.fMG = paramString;
    localDrawCanvasArg1.fMH = paramJSONObject.optLong("__invoke_jsapi_timestamp");
    return localDrawCanvasArg1;
  }
  
  public final void reset()
  {
    this.fWf = null;
    u.i("BaseDrawCanvasWithObj", "drop frame %d times, allFrame %d ", new Object[] { Integer.valueOf(this.fWk), Integer.valueOf(this.fWl) });
    this.fWl = 0;
    this.fWk = 0;
    this.fWi = 0L;
    this.workerThread.interrupt();
    for (Runnable localRunnable = (Runnable)this.fWh.poll(); localRunnable != null; localRunnable = (Runnable)this.fWh.poll()) {
      if (localRunnable != null) {
        localRunnable.run();
      }
    }
    this.fWh.clear();
    this.fWg.clear();
    if (this.fWe != null)
    {
      this.fWe.reset();
      this.fWe = null;
    }
  }
  
  public final boolean ti(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    while ((this.fWf != null) && (this.fWf.hashCode() == paramString.hashCode())) {
      return false;
    }
    return true;
  }
  
  public final void w(Runnable paramRunnable)
  {
    try
    {
      this.fWh.put(paramRunnable);
      return;
    }
    catch (InterruptedException paramRunnable)
    {
      y.printErrStackTrace("BaseDrawCanvasWithObj", paramRunnable, "", new Object[0]);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.dynamic.d.b.a.a
 * JD-Core Version:    0.7.0.1
 */