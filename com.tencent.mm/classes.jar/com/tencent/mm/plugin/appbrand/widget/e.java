package com.tencent.mm.plugin.appbrand.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.Path.Direction;
import android.graphics.Rect;
import android.graphics.RectF;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.utils.ao;
import com.tencent.mm.plugin.appbrand.x.a;
import com.tencent.threadpool.h;
import com.tencent.threadpool.i;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class e
  extends FrameLayout
{
  private final Set<Runnable> tuX;
  private final a uxm;
  private b uxn;
  private l uxo;
  public boolean uxp;
  public View uxq;
  
  public e(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(135389);
    this.uxn = new b();
    this.uxo = null;
    this.tuX = new HashSet();
    setWillNotDraw(false);
    this.uxm = ((a)com.tencent.luggage.a.e.V(a.class));
    AppMethodBeat.o(135389);
  }
  
  public final void ao(final Runnable paramRunnable)
  {
    AppMethodBeat.i(135391);
    if (paramRunnable == null)
    {
      AppMethodBeat.o(135391);
      return;
    }
    if (!ao.aoz())
    {
      h.ahAA.bk(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(135388);
          e.this.ao(paramRunnable);
          AppMethodBeat.o(135388);
        }
      });
      AppMethodBeat.o(135391);
      return;
    }
    if (getAnimation() == null)
    {
      paramRunnable.run();
      AppMethodBeat.o(135391);
      return;
    }
    this.tuX.add(paramRunnable);
    AppMethodBeat.o(135391);
  }
  
  protected void dispatchDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(135390);
    if (willNotDraw())
    {
      AppMethodBeat.o(135390);
      return;
    }
    try
    {
      super.dispatchDraw(paramCanvas);
      AppMethodBeat.o(135390);
      return;
    }
    catch (Exception paramCanvas)
    {
      com.tencent.mm.sdk.platformtools.Log.printErrStackTrace("Luggage.WXA.AppBrandRuntimeFrameLayout", paramCanvas, "", new Object[0]);
      if (!(paramCanvas instanceof NullPointerException)) {
        break label71;
      }
    }
    this.uxm.idkeyStat(1088L, 0L, 1L, false);
    for (;;)
    {
      AppMethodBeat.o(135390);
      throw paramCanvas;
      label71:
      this.uxm.idkeyStat(1088L, 1L, 1L, false);
    }
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(323970);
    if ((this.uxp) && (this.uxq != null))
    {
      bool = this.uxq.dispatchTouchEvent(paramMotionEvent);
      AppMethodBeat.o(323970);
      return bool;
    }
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    AppMethodBeat.o(323970);
    return bool;
  }
  
  protected FrameLayout.LayoutParams generateDefaultLayoutParams()
  {
    AppMethodBeat.i(323961);
    FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(-1, -1);
    AppMethodBeat.o(323961);
    return localLayoutParams;
  }
  
  protected void onAnimationEnd()
  {
    AppMethodBeat.i(135392);
    super.onAnimationEnd();
    Iterator localIterator = this.tuX.iterator();
    while (localIterator.hasNext()) {
      ((Runnable)localIterator.next()).run();
    }
    this.tuX.clear();
    AppMethodBeat.o(135392);
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(323965);
    b localb = this.uxn;
    Object localObject = getContext();
    if (localb.uxs != null)
    {
      localObject = localb.uxs.provide((Context)localObject);
      localb.rect.setEmpty();
      localb.uxr.getGlobalVisibleRect(localb.rect);
      RectF localRectF = new RectF(0.0F, 0.0F, localb.rect.right - localb.rect.left, localb.rect.bottom - localb.rect.top);
      localb.uxt.setEmpty();
      localb.uxt.left = 0.0F;
      localb.uxt.top = 0.0F;
      localb.uxt.right = (localb.rect.right - localb.rect.left);
      localb.uxt.bottom = (localb.rect.bottom - localb.rect.top);
      localb.path.rewind();
      localb.path.addRoundRect(localRectF, (float[])localObject, Path.Direction.CW);
      localb.path.close();
      paramCanvas.clipPath(localb.path);
    }
    super.onDraw(paramCanvas);
    AppMethodBeat.o(323965);
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(323968);
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    if (this.uxo != null) {
      this.uxo.I(paramInt1, paramInt2, paramInt3, paramInt4);
    }
    AppMethodBeat.o(323968);
  }
  
  public void onViewRemoved(View paramView)
  {
    AppMethodBeat.i(135393);
    super.onViewRemoved(paramView);
    com.tencent.mm.sdk.platformtools.Log.i("Luggage.WXA.AppBrandRuntimeFrameLayout", "onViewRemoved %s", new Object[] { paramView });
    AppMethodBeat.o(135393);
  }
  
  public void removeAllViews()
  {
    AppMethodBeat.i(135394);
    com.tencent.mm.sdk.platformtools.Log.d("Luggage.WXA.AppBrandRuntimeFrameLayout", "removeAllViews stack = %s", new Object[] { android.util.Log.getStackTraceString(new Throwable()) });
    super.removeAllViews();
    AppMethodBeat.o(135394);
  }
  
  public void setRoundCornerProvider(a parama)
  {
    this.uxn.uxs = parama;
  }
  
  public void setWxaHalfScreenGestureController(l paraml)
  {
    this.uxo = paraml;
  }
  
  public static abstract interface a
  {
    public abstract float[] provide(Context paramContext);
  }
  
  final class b
  {
    Path path;
    Rect rect;
    public e.a uxs;
    RectF uxt;
    
    public b()
    {
      AppMethodBeat.i(323919);
      this.uxs = null;
      this.rect = new Rect();
      this.uxt = new RectF();
      this.path = new Path();
      AppMethodBeat.o(323919);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.e
 * JD-Core Version:    0.7.0.1
 */