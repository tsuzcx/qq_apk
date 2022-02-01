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
  private final b jal;
  private final Set<View.OnAttachStateChangeListener> jam;
  
  public MHardwareAccelerateDrawableView(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(145444);
    this.jal = new b(this);
    this.jam = new LinkedHashSet();
    setLayerType(2, null);
    AppMethodBeat.o(145444);
  }
  
  public MHardwareAccelerateDrawableView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(145445);
    this.jal = new b(this);
    this.jam = new LinkedHashSet();
    setLayerType(2, null);
    AppMethodBeat.o(145445);
  }
  
  public MHardwareAccelerateDrawableView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(145446);
    this.jal = new b(this);
    this.jam = new LinkedHashSet();
    setLayerType(2, null);
    AppMethodBeat.o(145446);
  }
  
  public final void Q(Runnable paramRunnable)
  {
    AppMethodBeat.i(145451);
    this.jal.Q(paramRunnable);
    AppMethodBeat.o(145451);
  }
  
  public final void a(DrawCanvasArg paramDrawCanvasArg, a.a parama)
  {
    AppMethodBeat.i(145457);
    this.jal.a(paramDrawCanvasArg, parama);
    AppMethodBeat.o(145457);
  }
  
  public final void a(JSONArray paramJSONArray, a.a parama)
  {
    AppMethodBeat.i(145455);
    this.jal.a(paramJSONArray, parama);
    AppMethodBeat.o(145455);
  }
  
  public final void aSM()
  {
    AppMethodBeat.i(145450);
    postInvalidate();
    AppMethodBeat.o(145450);
  }
  
  public final void aSN()
  {
    AppMethodBeat.i(145459);
    this.jal.aSN();
    AppMethodBeat.o(145459);
  }
  
  public final void aSO()
  {
    AppMethodBeat.i(145466);
    this.jal.aSO();
    AppMethodBeat.o(145466);
  }
  
  public void addOnAttachStateChangeListener(View.OnAttachStateChangeListener paramOnAttachStateChangeListener)
  {
    AppMethodBeat.i(145460);
    if (this.jam.contains(paramOnAttachStateChangeListener))
    {
      AppMethodBeat.o(145460);
      return;
    }
    this.jam.add(paramOnAttachStateChangeListener);
    super.addOnAttachStateChangeListener(paramOnAttachStateChangeListener);
    AppMethodBeat.o(145460);
  }
  
  public final void b(DrawCanvasArg paramDrawCanvasArg, a.a parama)
  {
    AppMethodBeat.i(145458);
    this.jal.b(paramDrawCanvasArg, parama);
    AppMethodBeat.o(145458);
  }
  
  public final void b(JSONArray paramJSONArray, a.a parama)
  {
    AppMethodBeat.i(145456);
    this.jal.b(paramJSONArray, parama);
    AppMethodBeat.o(145456);
  }
  
  public d getDrawContext()
  {
    AppMethodBeat.i(145452);
    d locald = this.jal.getDrawContext();
    AppMethodBeat.o(145452);
    return locald;
  }
  
  public String getSessionId()
  {
    AppMethodBeat.i(145463);
    String str = this.jal.getSessionId();
    AppMethodBeat.o(145463);
    return str;
  }
  
  public String getTraceId()
  {
    AppMethodBeat.i(145449);
    String str = this.jal.getTraceId();
    AppMethodBeat.o(145449);
    return str;
  }
  
  public final boolean h(Canvas paramCanvas)
  {
    AppMethodBeat.i(145454);
    boolean bool = this.jal.h(paramCanvas);
    AppMethodBeat.o(145454);
    return bool;
  }
  
  public final boolean isPaused()
  {
    return this.jal.mPause;
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(145447);
    h(paramCanvas);
    AppMethodBeat.o(145447);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(145462);
    this.jal.onResume();
    AppMethodBeat.o(145462);
  }
  
  public void removeOnAttachStateChangeListener(View.OnAttachStateChangeListener paramOnAttachStateChangeListener)
  {
    AppMethodBeat.i(145461);
    this.jam.remove(paramOnAttachStateChangeListener);
    super.removeOnAttachStateChangeListener(paramOnAttachStateChangeListener);
    AppMethodBeat.o(145461);
  }
  
  public void setDrawActionReportable(com.tencent.mm.plugin.appbrand.canvas.c.a parama)
  {
    AppMethodBeat.i(145453);
    this.jal.setDrawActionReportable(parama);
    AppMethodBeat.o(145453);
  }
  
  public void setSessionId(String paramString)
  {
    AppMethodBeat.i(145464);
    this.jal.setSessionId(paramString);
    AppMethodBeat.o(145464);
  }
  
  public void setStartTime(long paramLong)
  {
    AppMethodBeat.i(145465);
    this.jal.setStartTime(paramLong);
    AppMethodBeat.o(145465);
  }
  
  public void setTraceId(String paramString)
  {
    AppMethodBeat.i(145448);
    this.jal.setTraceId(paramString);
    AppMethodBeat.o(145448);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.canvas.widget.MHardwareAccelerateDrawableView
 * JD-Core Version:    0.7.0.1
 */