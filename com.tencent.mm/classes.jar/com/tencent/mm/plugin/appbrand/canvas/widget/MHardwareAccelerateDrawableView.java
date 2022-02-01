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
  private final b nUR;
  private final Set<View.OnAttachStateChangeListener> nUS;
  
  public MHardwareAccelerateDrawableView(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(145444);
    this.nUR = new b(this);
    this.nUS = new LinkedHashSet();
    setLayerType(2, null);
    AppMethodBeat.o(145444);
  }
  
  public MHardwareAccelerateDrawableView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(145445);
    this.nUR = new b(this);
    this.nUS = new LinkedHashSet();
    setLayerType(2, null);
    AppMethodBeat.o(145445);
  }
  
  public MHardwareAccelerateDrawableView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(145446);
    this.nUR = new b(this);
    this.nUS = new LinkedHashSet();
    setLayerType(2, null);
    AppMethodBeat.o(145446);
  }
  
  public final void V(Runnable paramRunnable)
  {
    AppMethodBeat.i(145451);
    this.nUR.V(paramRunnable);
    AppMethodBeat.o(145451);
  }
  
  public final void a(DrawCanvasArg paramDrawCanvasArg, a.a parama)
  {
    AppMethodBeat.i(145457);
    this.nUR.a(paramDrawCanvasArg, parama);
    AppMethodBeat.o(145457);
  }
  
  public final void a(JSONArray paramJSONArray, a.a parama)
  {
    AppMethodBeat.i(145455);
    this.nUR.a(paramJSONArray, parama);
    AppMethodBeat.o(145455);
  }
  
  public void addOnAttachStateChangeListener(View.OnAttachStateChangeListener paramOnAttachStateChangeListener)
  {
    AppMethodBeat.i(145460);
    if (this.nUS.contains(paramOnAttachStateChangeListener))
    {
      AppMethodBeat.o(145460);
      return;
    }
    this.nUS.add(paramOnAttachStateChangeListener);
    super.addOnAttachStateChangeListener(paramOnAttachStateChangeListener);
    AppMethodBeat.o(145460);
  }
  
  public final void b(DrawCanvasArg paramDrawCanvasArg, a.a parama)
  {
    AppMethodBeat.i(145458);
    this.nUR.b(paramDrawCanvasArg, parama);
    AppMethodBeat.o(145458);
  }
  
  public final void b(JSONArray paramJSONArray, a.a parama)
  {
    AppMethodBeat.i(145456);
    this.nUR.b(paramJSONArray, parama);
    AppMethodBeat.o(145456);
  }
  
  public final void bKv()
  {
    AppMethodBeat.i(145450);
    postInvalidate();
    AppMethodBeat.o(145450);
  }
  
  public final void bKw()
  {
    AppMethodBeat.i(145459);
    this.nUR.bKw();
    AppMethodBeat.o(145459);
  }
  
  public final void bKx()
  {
    AppMethodBeat.i(145466);
    this.nUR.bKx();
    AppMethodBeat.o(145466);
  }
  
  public d getDrawContext()
  {
    AppMethodBeat.i(145452);
    d locald = this.nUR.getDrawContext();
    AppMethodBeat.o(145452);
    return locald;
  }
  
  public String getSessionId()
  {
    AppMethodBeat.i(145463);
    String str = this.nUR.getSessionId();
    AppMethodBeat.o(145463);
    return str;
  }
  
  public String getTraceId()
  {
    AppMethodBeat.i(145449);
    String str = this.nUR.getTraceId();
    AppMethodBeat.o(145449);
    return str;
  }
  
  public final boolean isPaused()
  {
    return this.nUR.mPause;
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(145447);
    q(paramCanvas);
    AppMethodBeat.o(145447);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(145462);
    this.nUR.onResume();
    AppMethodBeat.o(145462);
  }
  
  public final boolean q(Canvas paramCanvas)
  {
    AppMethodBeat.i(145454);
    boolean bool = this.nUR.q(paramCanvas);
    AppMethodBeat.o(145454);
    return bool;
  }
  
  public void removeOnAttachStateChangeListener(View.OnAttachStateChangeListener paramOnAttachStateChangeListener)
  {
    AppMethodBeat.i(145461);
    this.nUS.remove(paramOnAttachStateChangeListener);
    super.removeOnAttachStateChangeListener(paramOnAttachStateChangeListener);
    AppMethodBeat.o(145461);
  }
  
  public void setDrawActionReportable(com.tencent.mm.plugin.appbrand.canvas.c.a parama)
  {
    AppMethodBeat.i(145453);
    this.nUR.setDrawActionReportable(parama);
    AppMethodBeat.o(145453);
  }
  
  public void setSessionId(String paramString)
  {
    AppMethodBeat.i(145464);
    this.nUR.setSessionId(paramString);
    AppMethodBeat.o(145464);
  }
  
  public void setStartTime(long paramLong)
  {
    AppMethodBeat.i(145465);
    this.nUR.setStartTime(paramLong);
    AppMethodBeat.o(145465);
  }
  
  public void setTraceId(String paramString)
  {
    AppMethodBeat.i(145448);
    this.nUR.setTraceId(paramString);
    AppMethodBeat.o(145448);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.canvas.widget.MHardwareAccelerateDrawableView
 * JD-Core Version:    0.7.0.1
 */