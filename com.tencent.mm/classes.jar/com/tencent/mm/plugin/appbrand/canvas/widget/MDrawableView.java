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

public class MDrawableView
  extends View
  implements a
{
  private final b hga;
  private final Set<View.OnAttachStateChangeListener> hgb;
  
  public MDrawableView(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(103736);
    this.hga = new b(this);
    this.hgb = new LinkedHashSet();
    setLayerType(1, null);
    AppMethodBeat.o(103736);
  }
  
  public MDrawableView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(103737);
    this.hga = new b(this);
    this.hgb = new LinkedHashSet();
    setLayerType(1, null);
    AppMethodBeat.o(103737);
  }
  
  public MDrawableView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(103738);
    this.hga = new b(this);
    this.hgb = new LinkedHashSet();
    setLayerType(1, null);
    AppMethodBeat.o(103738);
  }
  
  public final void B(Runnable paramRunnable)
  {
    AppMethodBeat.i(103741);
    post(paramRunnable);
    AppMethodBeat.o(103741);
  }
  
  public final void a(DrawCanvasArg paramDrawCanvasArg, a.a parama)
  {
    AppMethodBeat.i(103749);
    this.hga.a(paramDrawCanvasArg, parama);
    AppMethodBeat.o(103749);
  }
  
  public final void a(JSONArray paramJSONArray, a.a parama)
  {
    AppMethodBeat.i(103747);
    this.hga.a(paramJSONArray, parama);
    AppMethodBeat.o(103747);
  }
  
  public void addOnAttachStateChangeListener(View.OnAttachStateChangeListener paramOnAttachStateChangeListener)
  {
    AppMethodBeat.i(103752);
    if (this.hgb.contains(paramOnAttachStateChangeListener))
    {
      AppMethodBeat.o(103752);
      return;
    }
    this.hgb.add(paramOnAttachStateChangeListener);
    super.addOnAttachStateChangeListener(paramOnAttachStateChangeListener);
    AppMethodBeat.o(103752);
  }
  
  public final void axT()
  {
    AppMethodBeat.i(103740);
    postInvalidate();
    AppMethodBeat.o(103740);
  }
  
  public final void axU()
  {
    AppMethodBeat.i(103751);
    this.hga.axU();
    AppMethodBeat.o(103751);
  }
  
  public final void axV()
  {
    AppMethodBeat.i(103758);
    this.hga.axV();
    AppMethodBeat.o(103758);
  }
  
  public final void b(DrawCanvasArg paramDrawCanvasArg, a.a parama)
  {
    AppMethodBeat.i(103750);
    this.hga.b(paramDrawCanvasArg, parama);
    AppMethodBeat.o(103750);
  }
  
  public final void b(JSONArray paramJSONArray, a.a parama)
  {
    AppMethodBeat.i(103748);
    this.hga.b(paramJSONArray, parama);
    AppMethodBeat.o(103748);
  }
  
  public final boolean f(Canvas paramCanvas)
  {
    AppMethodBeat.i(103746);
    boolean bool = this.hga.f(paramCanvas);
    AppMethodBeat.o(103746);
    return bool;
  }
  
  public d getDrawContext()
  {
    AppMethodBeat.i(103742);
    d locald = this.hga.getDrawContext();
    AppMethodBeat.o(103742);
    return locald;
  }
  
  public String getSessionId()
  {
    AppMethodBeat.i(103755);
    String str = this.hga.getSessionId();
    AppMethodBeat.o(103755);
    return str;
  }
  
  public String getTraceId()
  {
    AppMethodBeat.i(103745);
    String str = this.hga.getTraceId();
    AppMethodBeat.o(103745);
    return str;
  }
  
  public final boolean isPaused()
  {
    return this.hga.mPause;
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(103739);
    f(paramCanvas);
    AppMethodBeat.o(103739);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(103754);
    this.hga.onResume();
    AppMethodBeat.o(103754);
  }
  
  public void removeOnAttachStateChangeListener(View.OnAttachStateChangeListener paramOnAttachStateChangeListener)
  {
    AppMethodBeat.i(103753);
    this.hgb.remove(paramOnAttachStateChangeListener);
    super.removeOnAttachStateChangeListener(paramOnAttachStateChangeListener);
    AppMethodBeat.o(103753);
  }
  
  public void setDrawActionReportable(com.tencent.mm.plugin.appbrand.canvas.c.a parama)
  {
    AppMethodBeat.i(103743);
    this.hga.setDrawActionReportable(parama);
    AppMethodBeat.o(103743);
  }
  
  public void setSessionId(String paramString)
  {
    AppMethodBeat.i(103756);
    this.hga.setSessionId(paramString);
    AppMethodBeat.o(103756);
  }
  
  public void setStartTime(long paramLong)
  {
    AppMethodBeat.i(103757);
    this.hga.setStartTime(paramLong);
    AppMethodBeat.o(103757);
  }
  
  public void setTraceId(String paramString)
  {
    AppMethodBeat.i(103744);
    this.hga.setTraceId(paramString);
    AppMethodBeat.o(103744);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.canvas.widget.MDrawableView
 * JD-Core Version:    0.7.0.1
 */