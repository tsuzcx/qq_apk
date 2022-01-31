package com.tencent.mm.plugin.appbrand.canvas.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff.Mode;
import android.os.HandlerThread;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.SurfaceHolder;
import android.view.SurfaceHolder.Callback;
import android.view.SurfaceView;
import android.view.View.OnAttachStateChangeListener;
import com.tencent.luggage.j.c;
import com.tencent.mm.plugin.appbrand.canvas.b;
import com.tencent.mm.plugin.appbrand.canvas.d;
import com.tencent.mm.sdk.f.e;
import com.tencent.mm.sdk.platformtools.ah;
import java.util.LinkedHashSet;
import java.util.Set;
import org.json.JSONArray;

public class MSurfaceView
  extends SurfaceView
  implements SurfaceHolder.Callback, a
{
  private final b fMQ = new b(this);
  private final Set<View.OnAttachStateChangeListener> fMR = new LinkedHashSet();
  private SurfaceHolder fMT;
  private ah fMU;
  private Runnable fMV = new MSurfaceView.1(this);
  private volatile boolean vF;
  
  public MSurfaceView(Context paramContext)
  {
    super(paramContext);
    init();
  }
  
  public MSurfaceView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    init();
  }
  
  public MSurfaceView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    init();
  }
  
  private void init()
  {
    this.fMT = getHolder();
    this.fMT.addCallback(this);
    this.fMT.setFormat(-3);
    Paint localPaint = new Paint();
    localPaint.setColor(-1);
    this.fMQ.getDrawContext().fLu = localPaint;
  }
  
  public final void a(DrawCanvasArg paramDrawCanvasArg, a.a parama)
  {
    this.fMQ.a(paramDrawCanvasArg, parama);
  }
  
  public final void a(JSONArray paramJSONArray, a.a parama)
  {
    this.fMQ.a(paramJSONArray, parama);
  }
  
  public final void adB()
  {
    t(new MSurfaceView.2(this));
  }
  
  public final void adC()
  {
    this.fMQ.adC();
  }
  
  public final void adD()
  {
    this.fMQ.adD();
  }
  
  public void addOnAttachStateChangeListener(View.OnAttachStateChangeListener paramOnAttachStateChangeListener)
  {
    if (this.fMR.contains(paramOnAttachStateChangeListener)) {
      return;
    }
    this.fMR.add(paramOnAttachStateChangeListener);
    super.addOnAttachStateChangeListener(paramOnAttachStateChangeListener);
  }
  
  public final void b(DrawCanvasArg paramDrawCanvasArg, a.a parama)
  {
    this.fMQ.b(paramDrawCanvasArg, parama);
  }
  
  public final void b(JSONArray paramJSONArray, a.a parama)
  {
    this.fMQ.b(paramJSONArray, parama);
  }
  
  public void draw(Canvas paramCanvas)
  {
    c.i("MicroMsg.MSurfaceView", "draw(%s)", new Object[] { Integer.valueOf(hashCode()) });
    paramCanvas.drawColor(0, PorterDuff.Mode.CLEAR);
    super.draw(paramCanvas);
  }
  
  public final boolean f(Canvas paramCanvas)
  {
    return this.fMQ.f(paramCanvas);
  }
  
  public d getDrawContext()
  {
    return this.fMQ.getDrawContext();
  }
  
  public String getSessionId()
  {
    return this.fMQ.getSessionId();
  }
  
  public String getTraceId()
  {
    return this.fMQ.getTraceId();
  }
  
  public final boolean isPaused()
  {
    return this.fMQ.fKW;
  }
  
  public final void onPause()
  {
    this.fMQ.onPause();
  }
  
  public final void onResume()
  {
    this.fMQ.onResume();
  }
  
  public void removeOnAttachStateChangeListener(View.OnAttachStateChangeListener paramOnAttachStateChangeListener)
  {
    this.fMR.remove(paramOnAttachStateChangeListener);
    super.removeOnAttachStateChangeListener(paramOnAttachStateChangeListener);
  }
  
  public void setDrawActionReportable(com.tencent.mm.plugin.appbrand.canvas.c.a parama)
  {
    this.fMQ.setDrawActionReportable(parama);
  }
  
  public void setSessionId(String paramString)
  {
    this.fMQ.setSessionId(paramString);
  }
  
  public void setStartTime(long paramLong)
  {
    this.fMQ.setStartTime(paramLong);
  }
  
  public void setTraceId(String paramString)
  {
    this.fMQ.setTraceId(paramString);
  }
  
  public void surfaceChanged(SurfaceHolder paramSurfaceHolder, int paramInt1, int paramInt2, int paramInt3)
  {
    c.i("MicroMsg.MSurfaceView", "surfaceChanged(%s)", new Object[] { Integer.valueOf(hashCode()) });
  }
  
  public void surfaceCreated(SurfaceHolder paramSurfaceHolder)
  {
    c.i("MicroMsg.MSurfaceView", "surfaceCreated(%s)", new Object[] { Integer.valueOf(hashCode()) });
    this.vF = false;
    if (this.fMU == null)
    {
      paramSurfaceHolder = e.ds("MSurfaceView#Rending-Thread", -19);
      paramSurfaceHolder.start();
      this.fMU = new ah(paramSurfaceHolder.getLooper());
    }
  }
  
  public void surfaceDestroyed(SurfaceHolder paramSurfaceHolder)
  {
    c.i("MicroMsg.MSurfaceView", "surfaceDestroyed(%s)", new Object[] { Integer.valueOf(hashCode()) });
    this.vF = true;
    this.fMU.getLooper().quit();
    this.fMU = null;
  }
  
  public final void t(Runnable paramRunnable)
  {
    if (this.fMU == null) {
      return;
    }
    this.fMU.post(paramRunnable);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.canvas.widget.MSurfaceView
 * JD-Core Version:    0.7.0.1
 */