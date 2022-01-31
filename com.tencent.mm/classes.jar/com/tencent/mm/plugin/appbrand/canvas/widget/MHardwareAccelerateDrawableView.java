package com.tencent.mm.plugin.appbrand.canvas.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnAttachStateChangeListener;
import com.tencent.mm.plugin.appbrand.canvas.b;
import com.tencent.mm.plugin.appbrand.canvas.d;
import java.util.LinkedHashSet;
import java.util.Set;
import org.json.JSONArray;

public class MHardwareAccelerateDrawableView
  extends View
  implements a
{
  private final b fMQ = new b(this);
  private final Set<View.OnAttachStateChangeListener> fMR = new LinkedHashSet();
  
  public MHardwareAccelerateDrawableView(Context paramContext)
  {
    super(paramContext);
    setLayerType(2, null);
  }
  
  public MHardwareAccelerateDrawableView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    setLayerType(2, null);
  }
  
  public MHardwareAccelerateDrawableView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    setLayerType(2, null);
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
    postInvalidate();
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
  
  protected void onDraw(Canvas paramCanvas)
  {
    f(paramCanvas);
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
  
  public final void t(Runnable paramRunnable)
  {
    post(paramRunnable);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.canvas.widget.MHardwareAccelerateDrawableView
 * JD-Core Version:    0.7.0.1
 */