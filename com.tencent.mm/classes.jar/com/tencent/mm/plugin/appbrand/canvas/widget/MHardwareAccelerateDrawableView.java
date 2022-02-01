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
  private final b jXK;
  private final Set<View.OnAttachStateChangeListener> jXL;
  
  public MHardwareAccelerateDrawableView(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(145444);
    this.jXK = new b(this);
    this.jXL = new LinkedHashSet();
    setLayerType(2, null);
    AppMethodBeat.o(145444);
  }
  
  public MHardwareAccelerateDrawableView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(145445);
    this.jXK = new b(this);
    this.jXL = new LinkedHashSet();
    setLayerType(2, null);
    AppMethodBeat.o(145445);
  }
  
  public MHardwareAccelerateDrawableView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(145446);
    this.jXK = new b(this);
    this.jXL = new LinkedHashSet();
    setLayerType(2, null);
    AppMethodBeat.o(145446);
  }
  
  public final void P(Runnable paramRunnable)
  {
    AppMethodBeat.i(145451);
    this.jXK.P(paramRunnable);
    AppMethodBeat.o(145451);
  }
  
  public final void a(DrawCanvasArg paramDrawCanvasArg, a.a parama)
  {
    AppMethodBeat.i(145457);
    this.jXK.a(paramDrawCanvasArg, parama);
    AppMethodBeat.o(145457);
  }
  
  public final void a(JSONArray paramJSONArray, a.a parama)
  {
    AppMethodBeat.i(145455);
    this.jXK.a(paramJSONArray, parama);
    AppMethodBeat.o(145455);
  }
  
  public void addOnAttachStateChangeListener(View.OnAttachStateChangeListener paramOnAttachStateChangeListener)
  {
    AppMethodBeat.i(145460);
    if (this.jXL.contains(paramOnAttachStateChangeListener))
    {
      AppMethodBeat.o(145460);
      return;
    }
    this.jXL.add(paramOnAttachStateChangeListener);
    super.addOnAttachStateChangeListener(paramOnAttachStateChangeListener);
    AppMethodBeat.o(145460);
  }
  
  public final void b(DrawCanvasArg paramDrawCanvasArg, a.a parama)
  {
    AppMethodBeat.i(145458);
    this.jXK.b(paramDrawCanvasArg, parama);
    AppMethodBeat.o(145458);
  }
  
  public final void b(JSONArray paramJSONArray, a.a parama)
  {
    AppMethodBeat.i(145456);
    this.jXK.b(paramJSONArray, parama);
    AppMethodBeat.o(145456);
  }
  
  public final void bdP()
  {
    AppMethodBeat.i(145450);
    postInvalidate();
    AppMethodBeat.o(145450);
  }
  
  public final void bdQ()
  {
    AppMethodBeat.i(145459);
    this.jXK.bdQ();
    AppMethodBeat.o(145459);
  }
  
  public final void bdR()
  {
    AppMethodBeat.i(145466);
    this.jXK.bdR();
    AppMethodBeat.o(145466);
  }
  
  public d getDrawContext()
  {
    AppMethodBeat.i(145452);
    d locald = this.jXK.getDrawContext();
    AppMethodBeat.o(145452);
    return locald;
  }
  
  public String getSessionId()
  {
    AppMethodBeat.i(145463);
    String str = this.jXK.getSessionId();
    AppMethodBeat.o(145463);
    return str;
  }
  
  public String getTraceId()
  {
    AppMethodBeat.i(145449);
    String str = this.jXK.getTraceId();
    AppMethodBeat.o(145449);
    return str;
  }
  
  public final boolean h(Canvas paramCanvas)
  {
    AppMethodBeat.i(145454);
    boolean bool = this.jXK.h(paramCanvas);
    AppMethodBeat.o(145454);
    return bool;
  }
  
  public final boolean isPaused()
  {
    return this.jXK.mPause;
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
    this.jXK.onResume();
    AppMethodBeat.o(145462);
  }
  
  public void removeOnAttachStateChangeListener(View.OnAttachStateChangeListener paramOnAttachStateChangeListener)
  {
    AppMethodBeat.i(145461);
    this.jXL.remove(paramOnAttachStateChangeListener);
    super.removeOnAttachStateChangeListener(paramOnAttachStateChangeListener);
    AppMethodBeat.o(145461);
  }
  
  public void setDrawActionReportable(com.tencent.mm.plugin.appbrand.canvas.c.a parama)
  {
    AppMethodBeat.i(145453);
    this.jXK.setDrawActionReportable(parama);
    AppMethodBeat.o(145453);
  }
  
  public void setSessionId(String paramString)
  {
    AppMethodBeat.i(145464);
    this.jXK.setSessionId(paramString);
    AppMethodBeat.o(145464);
  }
  
  public void setStartTime(long paramLong)
  {
    AppMethodBeat.i(145465);
    this.jXK.setStartTime(paramLong);
    AppMethodBeat.o(145465);
  }
  
  public void setTraceId(String paramString)
  {
    AppMethodBeat.i(145448);
    this.jXK.setTraceId(paramString);
    AppMethodBeat.o(145448);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.canvas.widget.MHardwareAccelerateDrawableView
 * JD-Core Version:    0.7.0.1
 */