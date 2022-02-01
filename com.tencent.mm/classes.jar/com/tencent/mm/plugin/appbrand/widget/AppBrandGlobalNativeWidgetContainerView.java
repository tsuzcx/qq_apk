package com.tencent.mm.plugin.appbrand.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.AbsoluteLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.page.as;
import com.tencent.mm.plugin.appbrand.page.bv;
import com.tencent.mm.plugin.appbrand.page.bv.a;
import com.tencent.mm.plugin.appbrand.page.bz;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class AppBrandGlobalNativeWidgetContainerView
  extends AbsoluteLayout
  implements as, bv, bz
{
  private final AbsoluteLayout ojW;
  private final List<bv.a> ojX;
  
  public AppBrandGlobalNativeWidgetContainerView(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(219596);
    this.ojX = new LinkedList();
    this.ojW = this;
    AppMethodBeat.o(219596);
  }
  
  public AppBrandGlobalNativeWidgetContainerView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(219597);
    this.ojX = new LinkedList();
    this.ojW = this;
    AppMethodBeat.o(219597);
  }
  
  public AppBrandGlobalNativeWidgetContainerView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(219598);
    this.ojX = new LinkedList();
    this.ojW = this;
    AppMethodBeat.o(219598);
  }
  
  public final void a(bv.a parama)
  {
    AppMethodBeat.i(219600);
    if (parama == null)
    {
      AppMethodBeat.o(219600);
      return;
    }
    if (this.ojX.contains(parama))
    {
      AppMethodBeat.o(219600);
      return;
    }
    this.ojX.add(parama);
    AppMethodBeat.o(219600);
  }
  
  public final void b(bv.a parama)
  {
    AppMethodBeat.i(219601);
    if (parama == null)
    {
      AppMethodBeat.o(219601);
      return;
    }
    this.ojX.remove(parama);
    AppMethodBeat.o(219601);
  }
  
  public final boolean c(Canvas paramCanvas)
  {
    AppMethodBeat.i(219602);
    draw(paramCanvas);
    AppMethodBeat.o(219602);
    return true;
  }
  
  public final void onScrollChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4, View paramView)
  {
    AppMethodBeat.i(219599);
    Log.v("MicroMsg.AppBrandGlobalNativeWidgetContainerView", "onScrollChanged, left = %d, top = %d, oldLeft = %d, oldTop = %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), Integer.valueOf(paramInt4) });
    if (this.ojW != null)
    {
      paramInt3 = paramView.getWidth();
      paramInt4 = paramView.getHeight();
      if (this.ojW != null)
      {
        paramView = this.ojW.getLayoutParams();
        if (paramView != null) {
          break label157;
        }
        paramView = new ViewGroup.LayoutParams(paramInt3, paramInt4);
        this.ojW.setLayoutParams(paramView);
      }
    }
    for (;;)
    {
      this.ojW.scrollTo(paramInt1, paramInt2);
      paramView = this.ojX.iterator();
      while (paramView.hasNext()) {
        ((bv.a)paramView.next()).eu(paramInt1, paramInt2);
      }
      label157:
      if ((paramInt3 != paramView.width) || (paramInt4 != paramView.height))
      {
        paramView.width = paramInt3;
        paramView.height = paramInt4;
        this.ojW.setLayoutParams(paramView);
      }
    }
    AppMethodBeat.o(219599);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.AppBrandGlobalNativeWidgetContainerView
 * JD-Core Version:    0.7.0.1
 */