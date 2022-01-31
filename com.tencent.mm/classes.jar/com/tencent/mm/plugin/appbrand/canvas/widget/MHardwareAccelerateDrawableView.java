package com.tencent.mm.plugin.appbrand.canvas.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnAttachStateChangeListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.canvas.b;
import com.tencent.mm.plugin.appbrand.canvas.d;
import java.util.LinkedHashSet;
import java.util.Set;
import org.json.JSONArray;

public class MHardwareAccelerateDrawableView
  extends View
  implements a
{
  private final b hga;
  private final Set<View.OnAttachStateChangeListener> hgb;
  
  public MHardwareAccelerateDrawableView(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(103759);
    this.hga = new b(this);
    this.hgb = new LinkedHashSet();
    setLayerType(2, null);
    AppMethodBeat.o(103759);
  }
  
  public MHardwareAccelerateDrawableView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(103760);
    this.hga = new b(this);
    this.hgb = new LinkedHashSet();
    setLayerType(2, null);
    AppMethodBeat.o(103760);
  }
  
  public MHardwareAccelerateDrawableView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(103761);
    this.hga = new b(this);
    this.hgb = new LinkedHashSet();
    setLayerType(2, null);
    AppMethodBeat.o(103761);
  }
  
  public final void B(Runnable paramRunnable)
  {
    AppMethodBeat.i(103766);
    this.hga.B(paramRunnable);
    AppMethodBeat.o(103766);
  }
  
  public final void a(DrawCanvasArg paramDrawCanvasArg, a.a parama)
  {
    AppMethodBeat.i(103772);
    this.hga.a(paramDrawCanvasArg, parama);
    AppMethodBeat.o(103772);
  }
  
  public final void a(JSONArray paramJSONArray, a.a parama)
  {
    AppMethodBeat.i(103770);
    this.hga.a(paramJSONArray, parama);
    AppMethodBeat.o(103770);
  }
  
  public void addOnAttachStateChangeListener(View.OnAttachStateChangeListener paramOnAttachStateChangeListener)
  {
    AppMethodBeat.i(103775);
    if (this.hgb.contains(paramOnAttachStateChangeListener))
    {
      AppMethodBeat.o(103775);
      return;
    }
    this.hgb.add(paramOnAttachStateChangeListener);
    super.addOnAttachStateChangeListener(paramOnAttachStateChangeListener);
    AppMethodBeat.o(103775);
  }
  
  public final void axT()
  {
    AppMethodBeat.i(103765);
    postInvalidate();
    AppMethodBeat.o(103765);
  }
  
  public final void axU()
  {
    AppMethodBeat.i(103774);
    this.hga.axU();
    AppMethodBeat.o(103774);
  }
  
  public final void axV()
  {
    AppMethodBeat.i(103781);
    this.hga.axV();
    AppMethodBeat.o(103781);
  }
  
  public final void b(DrawCanvasArg paramDrawCanvasArg, a.a parama)
  {
    AppMethodBeat.i(103773);
    this.hga.b(paramDrawCanvasArg, parama);
    AppMethodBeat.o(103773);
  }
  
  public final void b(JSONArray paramJSONArray, a.a parama)
  {
    AppMethodBeat.i(103771);
    this.hga.b(paramJSONArray, parama);
    AppMethodBeat.o(103771);
  }
  
  public final boolean f(Canvas paramCanvas)
  {
    AppMethodBeat.i(103769);
    boolean bool = this.hga.f(paramCanvas);
    AppMethodBeat.o(103769);
    return bool;
  }
  
  public d getDrawContext()
  {
    AppMethodBeat.i(103767);
    d locald = this.hga.getDrawContext();
    AppMethodBeat.o(103767);
    return locald;
  }
  
  public String getSessionId()
  {
    AppMethodBeat.i(103778);
    String str = this.hga.getSessionId();
    AppMethodBeat.o(103778);
    return str;
  }
  
  public String getTraceId()
  {
    AppMethodBeat.i(103764);
    String str = this.hga.getTraceId();
    AppMethodBeat.o(103764);
    return str;
  }
  
  public final boolean isPaused()
  {
    return this.hga.mPause;
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(103762);
    f(paramCanvas);
    AppMethodBeat.o(103762);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(103777);
    this.hga.onResume();
    AppMethodBeat.o(103777);
  }
  
  public void removeOnAttachStateChangeListener(View.OnAttachStateChangeListener paramOnAttachStateChangeListener)
  {
    AppMethodBeat.i(103776);
    this.hgb.remove(paramOnAttachStateChangeListener);
    super.removeOnAttachStateChangeListener(paramOnAttachStateChangeListener);
    AppMethodBeat.o(103776);
  }
  
  public void setDrawActionReportable(com.tencent.mm.plugin.appbrand.canvas.c.a parama)
  {
    AppMethodBeat.i(103768);
    this.hga.setDrawActionReportable(parama);
    AppMethodBeat.o(103768);
  }
  
  public void setSessionId(String paramString)
  {
    AppMethodBeat.i(103779);
    this.hga.setSessionId(paramString);
    AppMethodBeat.o(103779);
  }
  
  public void setStartTime(long paramLong)
  {
    AppMethodBeat.i(103780);
    this.hga.setStartTime(paramLong);
    AppMethodBeat.o(103780);
  }
  
  public void setTraceId(String paramString)
  {
    AppMethodBeat.i(103763);
    this.hga.setTraceId(paramString);
    AppMethodBeat.o(103763);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.canvas.widget.MHardwareAccelerateDrawableView
 * JD-Core Version:    0.7.0.1
 */