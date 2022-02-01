package com.tencent.mm.plugin.appbrand.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.AbsoluteLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.page.ap;
import com.tencent.mm.plugin.appbrand.page.bp;
import com.tencent.mm.plugin.appbrand.page.bp.a;
import com.tencent.mm.sdk.platformtools.ae;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class AppBrandGlobalNativeWidgetContainerView
  extends AbsoluteLayout
  implements ap, bp
{
  private final AbsoluteLayout mWT;
  private final List<bp.a> mWU;
  
  public AppBrandGlobalNativeWidgetContainerView(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(207992);
    this.mWU = new LinkedList();
    this.mWT = this;
    AppMethodBeat.o(207992);
  }
  
  public AppBrandGlobalNativeWidgetContainerView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(207993);
    this.mWU = new LinkedList();
    this.mWT = this;
    AppMethodBeat.o(207993);
  }
  
  public AppBrandGlobalNativeWidgetContainerView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(207994);
    this.mWU = new LinkedList();
    this.mWT = this;
    AppMethodBeat.o(207994);
  }
  
  public final void a(bp.a parama)
  {
    AppMethodBeat.i(207996);
    if (parama == null)
    {
      AppMethodBeat.o(207996);
      return;
    }
    if (this.mWU.contains(parama))
    {
      AppMethodBeat.o(207996);
      return;
    }
    this.mWU.add(parama);
    AppMethodBeat.o(207996);
  }
  
  public final void b(bp.a parama)
  {
    AppMethodBeat.i(207997);
    if (parama == null)
    {
      AppMethodBeat.o(207997);
      return;
    }
    this.mWU.remove(parama);
    AppMethodBeat.o(207997);
  }
  
  public final void onScrollChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4, View paramView)
  {
    AppMethodBeat.i(207995);
    ae.v("MicroMsg.AppBrandGlobalNativeWidgetContainerView", "onScrollChanged, left = %d, top = %d, oldLeft = %d, oldTop = %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), Integer.valueOf(paramInt4) });
    if (this.mWT != null)
    {
      paramInt3 = paramView.getWidth();
      paramInt4 = paramView.getHeight();
      if (this.mWT != null)
      {
        paramView = this.mWT.getLayoutParams();
        if (paramView != null) {
          break label157;
        }
        paramView = new ViewGroup.LayoutParams(paramInt3, paramInt4);
        this.mWT.setLayoutParams(paramView);
      }
    }
    for (;;)
    {
      this.mWT.scrollTo(paramInt1, paramInt2);
      paramView = this.mWU.iterator();
      while (paramView.hasNext()) {
        ((bp.a)paramView.next()).eg(paramInt1, paramInt2);
      }
      label157:
      if ((paramInt3 != paramView.width) || (paramInt4 != paramView.height))
      {
        paramView.width = paramInt3;
        paramView.height = paramInt4;
        this.mWT.setLayoutParams(paramView);
      }
    }
    AppMethodBeat.o(207995);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.AppBrandGlobalNativeWidgetContainerView
 * JD-Core Version:    0.7.0.1
 */