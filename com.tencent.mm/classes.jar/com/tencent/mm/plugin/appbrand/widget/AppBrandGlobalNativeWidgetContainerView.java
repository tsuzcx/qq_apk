package com.tencent.mm.plugin.appbrand.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.AbsoluteLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.page.au;
import com.tencent.mm.plugin.appbrand.page.bz;
import com.tencent.mm.plugin.appbrand.page.bz.a;
import com.tencent.mm.plugin.appbrand.page.cg;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class AppBrandGlobalNativeWidgetContainerView
  extends AbsoluteLayout
  implements au, bz, cg
{
  private final AbsoluteLayout uwg;
  private final List<bz.a> uwh;
  private a uwi;
  
  public AppBrandGlobalNativeWidgetContainerView(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(323922);
    this.uwh = new LinkedList();
    this.uwi = null;
    this.uwg = this;
    AppMethodBeat.o(323922);
  }
  
  public AppBrandGlobalNativeWidgetContainerView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(323925);
    this.uwh = new LinkedList();
    this.uwi = null;
    this.uwg = this;
    AppMethodBeat.o(323925);
  }
  
  public AppBrandGlobalNativeWidgetContainerView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(323928);
    this.uwh = new LinkedList();
    this.uwi = null;
    this.uwg = this;
    AppMethodBeat.o(323928);
  }
  
  public final void a(bz.a parama)
  {
    AppMethodBeat.i(323935);
    if (parama == null)
    {
      AppMethodBeat.o(323935);
      return;
    }
    if (this.uwh.contains(parama))
    {
      AppMethodBeat.o(323935);
      return;
    }
    this.uwh.add(parama);
    AppMethodBeat.o(323935);
  }
  
  public final void b(bz.a parama)
  {
    AppMethodBeat.i(323938);
    if (parama == null)
    {
      AppMethodBeat.o(323938);
      return;
    }
    this.uwh.remove(parama);
    AppMethodBeat.o(323938);
  }
  
  protected boolean drawChild(Canvas paramCanvas, View paramView, long paramLong)
  {
    AppMethodBeat.i(323947);
    if (this.uwi != null) {
      this.uwi.drawChild(paramCanvas, paramView);
    }
    boolean bool = super.drawChild(paramCanvas, paramView, paramLong);
    AppMethodBeat.o(323947);
    return bool;
  }
  
  public final boolean g(Canvas paramCanvas)
  {
    AppMethodBeat.i(323943);
    draw(paramCanvas);
    AppMethodBeat.o(323943);
    return true;
  }
  
  public final void onScrollChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4, View paramView)
  {
    AppMethodBeat.i(323932);
    Log.v("MicroMsg.AppBrandGlobalNativeWidgetContainerView", "onScrollChanged, left = %d, top = %d, oldLeft = %d, oldTop = %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), Integer.valueOf(paramInt4) });
    if (this.uwg != null)
    {
      paramInt3 = paramView.getWidth();
      paramInt4 = paramView.getHeight();
      if (this.uwg != null)
      {
        paramView = this.uwg.getLayoutParams();
        if (paramView != null) {
          break label157;
        }
        paramView = new ViewGroup.LayoutParams(paramInt3, paramInt4);
        this.uwg.setLayoutParams(paramView);
      }
    }
    for (;;)
    {
      this.uwg.scrollTo(paramInt1, paramInt2);
      paramView = this.uwh.iterator();
      while (paramView.hasNext()) {
        ((bz.a)paramView.next()).fM(paramInt1, paramInt2);
      }
      label157:
      if ((paramInt3 != paramView.width) || (paramInt4 != paramView.height))
      {
        paramView.width = paramInt3;
        paramView.height = paramInt4;
        this.uwg.setLayoutParams(paramView);
      }
    }
    AppMethodBeat.o(323932);
  }
  
  public void setCapsuleBarBackgroundRenderer(a parama)
  {
    AppMethodBeat.i(323951);
    if (this.uwi == parama)
    {
      AppMethodBeat.o(323951);
      return;
    }
    this.uwi = parama;
    invalidate();
    AppMethodBeat.o(323951);
  }
  
  public static abstract interface a
  {
    public abstract void drawChild(Canvas paramCanvas, View paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.AppBrandGlobalNativeWidgetContainerView
 * JD-Core Version:    0.7.0.1
 */