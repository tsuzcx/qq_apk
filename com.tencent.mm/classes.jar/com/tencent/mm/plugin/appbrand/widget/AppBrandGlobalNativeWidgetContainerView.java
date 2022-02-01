package com.tencent.mm.plugin.appbrand.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.AbsoluteLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.page.au;
import com.tencent.mm.plugin.appbrand.page.by;
import com.tencent.mm.plugin.appbrand.page.by.a;
import com.tencent.mm.plugin.appbrand.page.cc;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class AppBrandGlobalNativeWidgetContainerView
  extends AbsoluteLayout
  implements au, by, cc
{
  private final AbsoluteLayout rmo;
  private final List<by.a> rmp;
  
  public AppBrandGlobalNativeWidgetContainerView(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(245606);
    this.rmp = new LinkedList();
    this.rmo = this;
    AppMethodBeat.o(245606);
  }
  
  public AppBrandGlobalNativeWidgetContainerView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(245607);
    this.rmp = new LinkedList();
    this.rmo = this;
    AppMethodBeat.o(245607);
  }
  
  public AppBrandGlobalNativeWidgetContainerView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(245609);
    this.rmp = new LinkedList();
    this.rmo = this;
    AppMethodBeat.o(245609);
  }
  
  public final void a(by.a parama)
  {
    AppMethodBeat.i(245611);
    if (parama == null)
    {
      AppMethodBeat.o(245611);
      return;
    }
    if (this.rmp.contains(parama))
    {
      AppMethodBeat.o(245611);
      return;
    }
    this.rmp.add(parama);
    AppMethodBeat.o(245611);
  }
  
  public final void b(by.a parama)
  {
    AppMethodBeat.i(245612);
    if (parama == null)
    {
      AppMethodBeat.o(245612);
      return;
    }
    this.rmp.remove(parama);
    AppMethodBeat.o(245612);
  }
  
  public final boolean d(Canvas paramCanvas)
  {
    AppMethodBeat.i(245613);
    draw(paramCanvas);
    AppMethodBeat.o(245613);
    return true;
  }
  
  public final void onScrollChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4, View paramView)
  {
    AppMethodBeat.i(245610);
    Log.v("MicroMsg.AppBrandGlobalNativeWidgetContainerView", "onScrollChanged, left = %d, top = %d, oldLeft = %d, oldTop = %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), Integer.valueOf(paramInt4) });
    if (this.rmo != null)
    {
      paramInt3 = paramView.getWidth();
      paramInt4 = paramView.getHeight();
      if (this.rmo != null)
      {
        paramView = this.rmo.getLayoutParams();
        if (paramView != null) {
          break label157;
        }
        paramView = new ViewGroup.LayoutParams(paramInt3, paramInt4);
        this.rmo.setLayoutParams(paramView);
      }
    }
    for (;;)
    {
      this.rmo.scrollTo(paramInt1, paramInt2);
      paramView = this.rmp.iterator();
      while (paramView.hasNext()) {
        ((by.a)paramView.next()).eT(paramInt1, paramInt2);
      }
      label157:
      if ((paramInt3 != paramView.width) || (paramInt4 != paramView.height))
      {
        paramView.width = paramInt3;
        paramView.height = paramInt4;
        this.rmo.setLayoutParams(paramView);
      }
    }
    AppMethodBeat.o(245610);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.AppBrandGlobalNativeWidgetContainerView
 * JD-Core Version:    0.7.0.1
 */