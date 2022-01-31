package com.tencent.mm.plugin.appbrand.dynamic.d.b.a;

import android.text.TextUtils;
import com.tencent.mm.modelappbrand.u;
import com.tencent.mm.plugin.appbrand.canvas.widget.DrawCanvasArg;
import com.tencent.mm.plugin.appbrand.dynamic.d.b.b;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import org.json.JSONObject;

public abstract class a
  implements e<DrawCanvasArg>
{
  protected DrawCanvasArg hpH;
  protected String hpI;
  protected BlockingQueue<b> hpJ = new LinkedBlockingQueue(100);
  protected BlockingQueue<Runnable> hpK = new LinkedBlockingQueue(100);
  protected volatile long hpL;
  protected volatile long hpM;
  protected int hpN;
  protected int hpO;
  protected boolean hpP;
  protected Thread workerThread = new Thread(new a.1(this), "DrawCanvasMgr-worker");
  
  public a()
  {
    this.workerThread.start();
  }
  
  public final boolean Bl(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    while ((this.hpI != null) && (this.hpI.hashCode() == paramString.hashCode())) {
      return false;
    }
    return true;
  }
  
  public final void E(Runnable paramRunnable)
  {
    try
    {
      this.hpK.put(paramRunnable);
      return;
    }
    catch (InterruptedException paramRunnable)
    {
      ab.printErrStackTrace("BaseDrawCanvasWithObj", paramRunnable, "", new Object[0]);
    }
  }
  
  public final void a(b paramb)
  {
    try
    {
      this.hpJ.put(paramb);
      this.hpM = paramb.hpw;
      this.hpO += 1;
      return;
    }
    catch (InterruptedException paramb)
    {
      ab.printErrStackTrace("BaseDrawCanvasWithObj", paramb, "", new Object[0]);
    }
  }
  
  public final void azT()
  {
    this.hpP = true;
  }
  
  public DrawCanvasArg c(JSONObject paramJSONObject, String paramString)
  {
    DrawCanvasArg localDrawCanvasArg2 = (DrawCanvasArg)com.tencent.mm.plugin.appbrand.canvas.action.arg.a.d.ayb().hfu.acquire();
    DrawCanvasArg localDrawCanvasArg1 = localDrawCanvasArg2;
    if (localDrawCanvasArg2 == null) {
      localDrawCanvasArg1 = new DrawCanvasArg();
    }
    localDrawCanvasArg1.hfP = paramJSONObject.optBoolean("reserve");
    localDrawCanvasArg1.hfQ = paramString;
    localDrawCanvasArg1.hfR = paramJSONObject.optLong("__invoke_jsapi_timestamp");
    return localDrawCanvasArg1;
  }
  
  public final void reset()
  {
    this.hpI = null;
    u.i("BaseDrawCanvasWithObj", "drop frame %d times, allFrame %d ", new Object[] { Integer.valueOf(this.hpN), Integer.valueOf(this.hpO) });
    this.hpO = 0;
    this.hpN = 0;
    this.hpL = 0L;
    this.workerThread.interrupt();
    for (Runnable localRunnable = (Runnable)this.hpK.poll(); localRunnable != null; localRunnable = (Runnable)this.hpK.poll()) {
      if (localRunnable != null) {
        localRunnable.run();
      }
    }
    this.hpK.clear();
    this.hpJ.clear();
    if (this.hpH != null)
    {
      this.hpH.reset();
      this.hpH = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.dynamic.d.b.a.a
 * JD-Core Version:    0.7.0.1
 */