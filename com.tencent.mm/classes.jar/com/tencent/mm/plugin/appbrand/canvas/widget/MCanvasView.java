package com.tencent.mm.plugin.appbrand.canvas.widget;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.support.v4.view.q;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnAttachStateChangeListener;
import com.tencent.luggage.j.c;
import com.tencent.mm.plugin.appbrand.canvas.b;
import com.tencent.mm.plugin.appbrand.canvas.d;
import com.tencent.mm.plugin.appbrand.canvas.f;
import java.util.LinkedHashSet;
import java.util.Set;
import org.json.JSONArray;

public class MCanvasView
  extends View
  implements a
{
  private final b fMQ = new b(this);
  private final Set<View.OnAttachStateChangeListener> fMR = new LinkedHashSet();
  private Bitmap mBitmap;
  
  public MCanvasView(Context paramContext)
  {
    super(paramContext);
  }
  
  public MCanvasView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public MCanvasView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
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
    if (!q.al(this))
    {
      post(new MCanvasView.1(this));
      return;
    }
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
    int i = getMeasuredWidth();
    int j = getMeasuredHeight();
    if ((i <= 0) || (j <= 0)) {
      return;
    }
    if ((this.mBitmap == null) || (this.mBitmap.isRecycled()) || (this.mBitmap.getWidth() != i) || (this.mBitmap.getHeight() != j))
    {
      if ((this.mBitmap != null) && (!this.mBitmap.isRecycled())) {
        this.mBitmap.recycle();
      }
      this.mBitmap = Bitmap.createBitmap(i, j, Bitmap.Config.ARGB_8888);
      c.v("MicroMsg.MCanvasView", "create a new bitmap(id : %s, w : %s, h : %s)", new Object[] { Integer.valueOf(hashCode()), Integer.valueOf(i), Integer.valueOf(j) });
    }
    if (this.mBitmap == null)
    {
      c.d("MicroMsg.MCanvasView", "bitmap is null.");
      return;
    }
    this.mBitmap.eraseColor(0);
    f localf = new f(this.mBitmap);
    f(localf);
    try
    {
      paramCanvas.drawBitmap(localf.mBitmap, 0.0F, 0.0F, null);
      return;
    }
    catch (Exception localException)
    {
      c.printErrStackTrace("MicroMsg.MCanvasView", localException, "", new Object[0]);
      f(paramCanvas);
    }
  }
  
  public final void onPause()
  {
    this.fMQ.onPause();
  }
  
  public final void onResume()
  {
    this.fMQ.onResume();
  }
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    if ((this.mBitmap != null) && (!this.mBitmap.isRecycled())) {
      this.mBitmap.recycle();
    }
    paramInt1 = getMeasuredWidth();
    paramInt2 = getMeasuredHeight();
    if ((paramInt1 > 0) && (paramInt2 > 0))
    {
      this.mBitmap = Bitmap.createBitmap(paramInt1, paramInt2, Bitmap.Config.ARGB_8888);
      c.v("MicroMsg.MCanvasView", "onSizeChanged, create a new bitmap(id : %s, w : %s, h : %s)", new Object[] { Integer.valueOf(hashCode()), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    }
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
 * Qualified Name:     com.tencent.mm.plugin.appbrand.canvas.widget.MCanvasView
 * JD-Core Version:    0.7.0.1
 */