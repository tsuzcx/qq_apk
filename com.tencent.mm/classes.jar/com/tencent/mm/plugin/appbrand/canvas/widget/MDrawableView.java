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
  private final b qUB;
  private final Set<View.OnAttachStateChangeListener> qUC;
  
  public MDrawableView(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(145420);
    this.qUB = new b(this);
    this.qUC = new LinkedHashSet();
    setLayerType(1, null);
    AppMethodBeat.o(145420);
  }
  
  public MDrawableView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(145421);
    this.qUB = new b(this);
    this.qUC = new LinkedHashSet();
    setLayerType(1, null);
    AppMethodBeat.o(145421);
  }
  
  public MDrawableView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(145422);
    this.qUB = new b(this);
    this.qUC = new LinkedHashSet();
    setLayerType(1, null);
    AppMethodBeat.o(145422);
  }
  
  public final void a(DrawCanvasArg paramDrawCanvasArg, a.a parama)
  {
    AppMethodBeat.i(145433);
    this.qUB.a(paramDrawCanvasArg, parama);
    AppMethodBeat.o(145433);
  }
  
  public final void a(JSONArray paramJSONArray, a.a parama)
  {
    AppMethodBeat.i(145431);
    this.qUB.a(paramJSONArray, parama);
    AppMethodBeat.o(145431);
  }
  
  public final void ab(Runnable paramRunnable)
  {
    AppMethodBeat.i(145425);
    post(paramRunnable);
    AppMethodBeat.o(145425);
  }
  
  public void addOnAttachStateChangeListener(View.OnAttachStateChangeListener paramOnAttachStateChangeListener)
  {
    AppMethodBeat.i(145436);
    if (this.qUC.contains(paramOnAttachStateChangeListener))
    {
      AppMethodBeat.o(145436);
      return;
    }
    this.qUC.add(paramOnAttachStateChangeListener);
    super.addOnAttachStateChangeListener(paramOnAttachStateChangeListener);
    AppMethodBeat.o(145436);
  }
  
  public final void b(DrawCanvasArg paramDrawCanvasArg, a.a parama)
  {
    AppMethodBeat.i(145434);
    this.qUB.b(paramDrawCanvasArg, parama);
    AppMethodBeat.o(145434);
  }
  
  public final void b(JSONArray paramJSONArray, a.a parama)
  {
    AppMethodBeat.i(145432);
    this.qUB.b(paramJSONArray, parama);
    AppMethodBeat.o(145432);
  }
  
  public final void cjV()
  {
    AppMethodBeat.i(145424);
    postInvalidate();
    AppMethodBeat.o(145424);
  }
  
  public final void cjW()
  {
    AppMethodBeat.i(145435);
    this.qUB.cjW();
    AppMethodBeat.o(145435);
  }
  
  public final void cjX()
  {
    AppMethodBeat.i(145442);
    this.qUB.cjX();
    AppMethodBeat.o(145442);
  }
  
  public d getDrawContext()
  {
    AppMethodBeat.i(145426);
    d locald = this.qUB.getDrawContext();
    AppMethodBeat.o(145426);
    return locald;
  }
  
  public String getSessionId()
  {
    AppMethodBeat.i(145439);
    String str = this.qUB.getSessionId();
    AppMethodBeat.o(145439);
    return str;
  }
  
  public String getTraceId()
  {
    AppMethodBeat.i(145429);
    String str = this.qUB.getTraceId();
    AppMethodBeat.o(145429);
    return str;
  }
  
  public final boolean isPaused()
  {
    return this.qUB.mPause;
  }
  
  public final boolean l(Canvas paramCanvas)
  {
    AppMethodBeat.i(145430);
    boolean bool = this.qUB.l(paramCanvas);
    AppMethodBeat.o(145430);
    return bool;
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(145423);
    l(paramCanvas);
    AppMethodBeat.o(145423);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(145438);
    this.qUB.onResume();
    AppMethodBeat.o(145438);
  }
  
  public void removeOnAttachStateChangeListener(View.OnAttachStateChangeListener paramOnAttachStateChangeListener)
  {
    AppMethodBeat.i(145437);
    this.qUC.remove(paramOnAttachStateChangeListener);
    super.removeOnAttachStateChangeListener(paramOnAttachStateChangeListener);
    AppMethodBeat.o(145437);
  }
  
  public void setDrawActionReportable(com.tencent.mm.plugin.appbrand.canvas.c.a parama)
  {
    AppMethodBeat.i(145427);
    this.qUB.setDrawActionReportable(parama);
    AppMethodBeat.o(145427);
  }
  
  public void setSessionId(String paramString)
  {
    AppMethodBeat.i(145440);
    this.qUB.setSessionId(paramString);
    AppMethodBeat.o(145440);
  }
  
  public void setStartTime(long paramLong)
  {
    AppMethodBeat.i(145441);
    this.qUB.setStartTime(paramLong);
    AppMethodBeat.o(145441);
  }
  
  public void setTraceId(String paramString)
  {
    AppMethodBeat.i(145428);
    this.qUB.setTraceId(paramString);
    AppMethodBeat.o(145428);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.canvas.widget.MDrawableView
 * JD-Core Version:    0.7.0.1
 */