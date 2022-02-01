package com.tencent.mm.plugin.appbrand.canvas.widget;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.support.v4.view.t;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnAttachStateChangeListener;
import android.view.ViewParent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.canvas.b;
import com.tencent.mm.plugin.appbrand.canvas.d;
import com.tencent.mm.plugin.appbrand.canvas.f;
import com.tencent.mm.sdk.platformtools.ae;
import java.util.LinkedHashSet;
import java.util.Set;
import org.json.JSONArray;

public class MCanvasView
  extends View
  implements a
{
  public final b jXK;
  private final Set<View.OnAttachStateChangeListener> jXL;
  private Bitmap mBitmap;
  
  public MCanvasView(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(145395);
    this.jXK = new b(this);
    this.jXL = new LinkedHashSet();
    init();
    AppMethodBeat.o(145395);
  }
  
  public MCanvasView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(145396);
    this.jXK = new b(this);
    this.jXL = new LinkedHashSet();
    init();
    AppMethodBeat.o(145396);
  }
  
  public MCanvasView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(145397);
    this.jXK = new b(this);
    this.jXL = new LinkedHashSet();
    init();
    AppMethodBeat.o(145397);
  }
  
  private void init()
  {
    AppMethodBeat.i(161173);
    ae.v("MicroMsg.MCanvasView", "init %s", new Object[] { Integer.valueOf(hashCode()) });
    AppMethodBeat.o(161173);
  }
  
  public final void P(Runnable paramRunnable)
  {
    AppMethodBeat.i(145407);
    post(paramRunnable);
    AppMethodBeat.o(145407);
  }
  
  public final void a(DrawCanvasArg paramDrawCanvasArg, a.a parama)
  {
    AppMethodBeat.i(145404);
    this.jXK.a(paramDrawCanvasArg, parama);
    AppMethodBeat.o(145404);
  }
  
  public final void a(JSONArray paramJSONArray, a.a parama)
  {
    AppMethodBeat.i(145402);
    this.jXK.a(paramJSONArray, parama);
    AppMethodBeat.o(145402);
  }
  
  public void addOnAttachStateChangeListener(View.OnAttachStateChangeListener paramOnAttachStateChangeListener)
  {
    AppMethodBeat.i(145412);
    if (this.jXL.contains(paramOnAttachStateChangeListener))
    {
      AppMethodBeat.o(145412);
      return;
    }
    this.jXL.add(paramOnAttachStateChangeListener);
    super.addOnAttachStateChangeListener(paramOnAttachStateChangeListener);
    AppMethodBeat.o(145412);
  }
  
  public final void b(DrawCanvasArg paramDrawCanvasArg, a.a parama)
  {
    AppMethodBeat.i(145405);
    this.jXK.b(paramDrawCanvasArg, parama);
    AppMethodBeat.o(145405);
  }
  
  public final void b(JSONArray paramJSONArray, a.a parama)
  {
    AppMethodBeat.i(145403);
    this.jXK.b(paramJSONArray, parama);
    AppMethodBeat.o(145403);
  }
  
  public final void bdP()
  {
    AppMethodBeat.i(145401);
    if (!t.ay(this))
    {
      post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(145394);
          Object localObject = MCanvasView.this.getParent();
          ViewParent localViewParent;
          do
          {
            ((View)localObject).forceLayout();
            localViewParent = ((ViewParent)localObject).getParent();
            localObject = localViewParent;
          } while ((localViewParent instanceof View));
          if (localViewParent != null)
          {
            localViewParent.requestLayout();
            MCanvasView.this.invalidate();
          }
          AppMethodBeat.o(145394);
        }
      });
      AppMethodBeat.o(145401);
      return;
    }
    postInvalidate();
    AppMethodBeat.o(145401);
  }
  
  public final void bdQ()
  {
    AppMethodBeat.i(145406);
    this.jXK.bdQ();
    AppMethodBeat.o(145406);
  }
  
  public final void bdR()
  {
    AppMethodBeat.i(145418);
    this.jXK.bdR();
    AppMethodBeat.o(145418);
  }
  
  public final void beg()
  {
    AppMethodBeat.i(161175);
    if ((this.mBitmap != null) && (!this.mBitmap.isRecycled()))
    {
      ae.i("MicroMsg.MCanvasView", "bitmap recycle %s %s", new Object[] { Integer.valueOf(hashCode()), this.mBitmap });
      this.mBitmap.recycle();
    }
    AppMethodBeat.o(161175);
  }
  
  public d getDrawContext()
  {
    AppMethodBeat.i(145408);
    d locald = this.jXK.getDrawContext();
    AppMethodBeat.o(145408);
    return locald;
  }
  
  public String getSessionId()
  {
    AppMethodBeat.i(145415);
    String str = this.jXK.getSessionId();
    AppMethodBeat.o(145415);
    return str;
  }
  
  public String getTraceId()
  {
    AppMethodBeat.i(145411);
    String str = this.jXK.getTraceId();
    AppMethodBeat.o(145411);
    return str;
  }
  
  public final boolean h(Canvas paramCanvas)
  {
    AppMethodBeat.i(145400);
    boolean bool = this.jXK.h(paramCanvas);
    AppMethodBeat.o(145400);
    return bool;
  }
  
  public final boolean isPaused()
  {
    return this.jXK.mPause;
  }
  
  protected void onDetachedFromWindow()
  {
    AppMethodBeat.i(161174);
    super.onDetachedFromWindow();
    beg();
    AppMethodBeat.o(161174);
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(145398);
    int i = getMeasuredWidth();
    int j = getMeasuredHeight();
    if ((i <= 0) || (j <= 0))
    {
      AppMethodBeat.o(145398);
      return;
    }
    if ((this.mBitmap == null) || (this.mBitmap.isRecycled()) || (this.mBitmap.getWidth() != i) || (this.mBitmap.getHeight() != j)) {
      beg();
    }
    try
    {
      this.mBitmap = Bitmap.createBitmap(i, j, Bitmap.Config.ARGB_8888);
      ae.v("MicroMsg.MCanvasView", "create a new bitmap(id : %s, w : %s, h : %s)", new Object[] { Integer.valueOf(hashCode()), Integer.valueOf(i), Integer.valueOf(j) });
      if (this.mBitmap == null)
      {
        ae.d("MicroMsg.MCanvasView", "bitmap is null.");
        AppMethodBeat.o(145398);
        return;
      }
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      for (;;)
      {
        ae.e("MicroMsg.MCanvasView", "onDraw oom w:%d h:%d", new Object[] { Integer.valueOf(i), Integer.valueOf(j) });
        this.mBitmap = null;
      }
      this.mBitmap.eraseColor(0);
      f localf = new f(this.mBitmap);
      h(localf);
      try
      {
        paramCanvas.drawBitmap(localf.mBitmap, 0.0F, 0.0F, null);
        AppMethodBeat.o(145398);
        return;
      }
      catch (Exception localException)
      {
        ae.printErrStackTrace("MicroMsg.MCanvasView", localException, "", new Object[0]);
        h(paramCanvas);
        AppMethodBeat.o(145398);
      }
    }
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(145414);
    ae.v("MicroMsg.MCanvasView", "onResume :%s", new Object[] { Integer.valueOf(hashCode()) });
    this.jXK.onResume();
    AppMethodBeat.o(145414);
  }
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(145399);
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    beg();
    paramInt3 = getMeasuredWidth();
    paramInt4 = getMeasuredHeight();
    if ((paramInt3 > 0) && (paramInt4 > 0)) {}
    try
    {
      this.mBitmap = Bitmap.createBitmap(paramInt3, paramInt4, Bitmap.Config.ARGB_8888);
      ae.v("MicroMsg.MCanvasView", "onSizeChanged, create a new bitmap(id : %s, w : %s, h : %s)", new Object[] { Integer.valueOf(hashCode()), Integer.valueOf(paramInt3), Integer.valueOf(paramInt4) });
      AppMethodBeat.o(145399);
      return;
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      ae.e("MicroMsg.MCanvasView", "onSizeChanged oom w:%d h:%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
      this.mBitmap = null;
      AppMethodBeat.o(145399);
    }
  }
  
  public void removeOnAttachStateChangeListener(View.OnAttachStateChangeListener paramOnAttachStateChangeListener)
  {
    AppMethodBeat.i(145413);
    this.jXL.remove(paramOnAttachStateChangeListener);
    super.removeOnAttachStateChangeListener(paramOnAttachStateChangeListener);
    AppMethodBeat.o(145413);
  }
  
  public void setDrawActionReportable(com.tencent.mm.plugin.appbrand.canvas.c.a parama)
  {
    AppMethodBeat.i(145409);
    this.jXK.setDrawActionReportable(parama);
    AppMethodBeat.o(145409);
  }
  
  public void setSessionId(String paramString)
  {
    AppMethodBeat.i(145416);
    this.jXK.setSessionId(paramString);
    AppMethodBeat.o(145416);
  }
  
  public void setStartTime(long paramLong)
  {
    AppMethodBeat.i(145417);
    this.jXK.setStartTime(paramLong);
    AppMethodBeat.o(145417);
  }
  
  public void setTraceId(String paramString)
  {
    AppMethodBeat.i(145410);
    this.jXK.setTraceId(paramString);
    AppMethodBeat.o(145410);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.canvas.widget.MCanvasView
 * JD-Core Version:    0.7.0.1
 */