package com.tencent.mm.plugin.appbrand.canvas.widget;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.support.v4.view.t;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnAttachStateChangeListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.canvas.b;
import com.tencent.mm.plugin.appbrand.canvas.f;
import java.util.LinkedHashSet;
import java.util.Set;
import org.json.JSONArray;

public class MCanvasView
  extends View
  implements a
{
  private final b hga;
  private final Set<View.OnAttachStateChangeListener> hgb;
  private Bitmap mBitmap;
  
  public MCanvasView(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(103712);
    this.hga = new b(this);
    this.hgb = new LinkedHashSet();
    AppMethodBeat.o(103712);
  }
  
  public MCanvasView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(103713);
    this.hga = new b(this);
    this.hgb = new LinkedHashSet();
    AppMethodBeat.o(103713);
  }
  
  public MCanvasView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(103714);
    this.hga = new b(this);
    this.hgb = new LinkedHashSet();
    AppMethodBeat.o(103714);
  }
  
  public final void B(Runnable paramRunnable)
  {
    AppMethodBeat.i(103724);
    post(paramRunnable);
    AppMethodBeat.o(103724);
  }
  
  public final void a(DrawCanvasArg paramDrawCanvasArg, a.a parama)
  {
    AppMethodBeat.i(103721);
    this.hga.a(paramDrawCanvasArg, parama);
    AppMethodBeat.o(103721);
  }
  
  public final void a(JSONArray paramJSONArray, a.a parama)
  {
    AppMethodBeat.i(103719);
    this.hga.a(paramJSONArray, parama);
    AppMethodBeat.o(103719);
  }
  
  public void addOnAttachStateChangeListener(View.OnAttachStateChangeListener paramOnAttachStateChangeListener)
  {
    AppMethodBeat.i(103729);
    if (this.hgb.contains(paramOnAttachStateChangeListener))
    {
      AppMethodBeat.o(103729);
      return;
    }
    this.hgb.add(paramOnAttachStateChangeListener);
    super.addOnAttachStateChangeListener(paramOnAttachStateChangeListener);
    AppMethodBeat.o(103729);
  }
  
  public final void axT()
  {
    AppMethodBeat.i(103718);
    if (!t.as(this))
    {
      post(new MCanvasView.1(this));
      AppMethodBeat.o(103718);
      return;
    }
    postInvalidate();
    AppMethodBeat.o(103718);
  }
  
  public final void axU()
  {
    AppMethodBeat.i(103723);
    this.hga.axU();
    AppMethodBeat.o(103723);
  }
  
  public final void axV()
  {
    AppMethodBeat.i(103735);
    this.hga.axV();
    AppMethodBeat.o(103735);
  }
  
  public final void b(DrawCanvasArg paramDrawCanvasArg, a.a parama)
  {
    AppMethodBeat.i(103722);
    this.hga.b(paramDrawCanvasArg, parama);
    AppMethodBeat.o(103722);
  }
  
  public final void b(JSONArray paramJSONArray, a.a parama)
  {
    AppMethodBeat.i(103720);
    this.hga.b(paramJSONArray, parama);
    AppMethodBeat.o(103720);
  }
  
  public final boolean f(Canvas paramCanvas)
  {
    AppMethodBeat.i(103717);
    boolean bool = this.hga.f(paramCanvas);
    AppMethodBeat.o(103717);
    return bool;
  }
  
  public com.tencent.mm.plugin.appbrand.canvas.d getDrawContext()
  {
    AppMethodBeat.i(103725);
    com.tencent.mm.plugin.appbrand.canvas.d locald = this.hga.getDrawContext();
    AppMethodBeat.o(103725);
    return locald;
  }
  
  public String getSessionId()
  {
    AppMethodBeat.i(103732);
    String str = this.hga.getSessionId();
    AppMethodBeat.o(103732);
    return str;
  }
  
  public String getTraceId()
  {
    AppMethodBeat.i(103728);
    String str = this.hga.getTraceId();
    AppMethodBeat.o(103728);
    return str;
  }
  
  public final boolean isPaused()
  {
    return this.hga.mPause;
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(103715);
    int i = getMeasuredWidth();
    int j = getMeasuredHeight();
    if ((i <= 0) || (j <= 0))
    {
      AppMethodBeat.o(103715);
      return;
    }
    if ((this.mBitmap == null) || (this.mBitmap.isRecycled()) || (this.mBitmap.getWidth() != i) || (this.mBitmap.getHeight() != j))
    {
      if ((this.mBitmap != null) && (!this.mBitmap.isRecycled()))
      {
        com.tencent.luggage.g.d.i("MicroMsg.MCanvasView", "bitmap recycle %s", new Object[] { this.mBitmap });
        this.mBitmap.recycle();
      }
      this.mBitmap = Bitmap.createBitmap(i, j, Bitmap.Config.ARGB_8888);
      com.tencent.luggage.g.d.v("MicroMsg.MCanvasView", "create a new bitmap(id : %s, w : %s, h : %s)", new Object[] { Integer.valueOf(hashCode()), Integer.valueOf(i), Integer.valueOf(j) });
    }
    if (this.mBitmap == null)
    {
      com.tencent.luggage.g.d.d("MicroMsg.MCanvasView", "bitmap is null.");
      AppMethodBeat.o(103715);
      return;
    }
    this.mBitmap.eraseColor(0);
    f localf = new f(this.mBitmap);
    f(localf);
    try
    {
      paramCanvas.drawBitmap(localf.mBitmap, 0.0F, 0.0F, null);
      AppMethodBeat.o(103715);
      return;
    }
    catch (Exception localException)
    {
      com.tencent.luggage.g.d.printErrStackTrace("MicroMsg.MCanvasView", localException, "", new Object[0]);
      f(paramCanvas);
      AppMethodBeat.o(103715);
    }
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(103731);
    this.hga.onResume();
    AppMethodBeat.o(103731);
  }
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(103716);
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    if ((this.mBitmap != null) && (!this.mBitmap.isRecycled()))
    {
      com.tencent.luggage.g.d.i("MicroMsg.MCanvasView", "bitmap recycle %s", new Object[] { this.mBitmap });
      this.mBitmap.recycle();
    }
    paramInt1 = getMeasuredWidth();
    paramInt2 = getMeasuredHeight();
    if ((paramInt1 > 0) && (paramInt2 > 0))
    {
      this.mBitmap = Bitmap.createBitmap(paramInt1, paramInt2, Bitmap.Config.ARGB_8888);
      com.tencent.luggage.g.d.v("MicroMsg.MCanvasView", "onSizeChanged, create a new bitmap(id : %s, w : %s, h : %s)", new Object[] { Integer.valueOf(hashCode()), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    }
    AppMethodBeat.o(103716);
  }
  
  public void removeOnAttachStateChangeListener(View.OnAttachStateChangeListener paramOnAttachStateChangeListener)
  {
    AppMethodBeat.i(103730);
    this.hgb.remove(paramOnAttachStateChangeListener);
    super.removeOnAttachStateChangeListener(paramOnAttachStateChangeListener);
    AppMethodBeat.o(103730);
  }
  
  public void setDrawActionReportable(com.tencent.mm.plugin.appbrand.canvas.c.a parama)
  {
    AppMethodBeat.i(103726);
    this.hga.setDrawActionReportable(parama);
    AppMethodBeat.o(103726);
  }
  
  public void setSessionId(String paramString)
  {
    AppMethodBeat.i(103733);
    this.hga.setSessionId(paramString);
    AppMethodBeat.o(103733);
  }
  
  public void setStartTime(long paramLong)
  {
    AppMethodBeat.i(103734);
    this.hga.setStartTime(paramLong);
    AppMethodBeat.o(103734);
  }
  
  public void setTraceId(String paramString)
  {
    AppMethodBeat.i(103727);
    this.hga.setTraceId(paramString);
    AppMethodBeat.o(103727);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.canvas.widget.MCanvasView
 * JD-Core Version:    0.7.0.1
 */