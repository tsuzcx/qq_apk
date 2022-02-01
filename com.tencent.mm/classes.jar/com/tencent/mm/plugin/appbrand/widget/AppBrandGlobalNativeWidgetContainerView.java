package com.tencent.mm.plugin.appbrand.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.AbsoluteLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.page.aq;
import com.tencent.mm.plugin.appbrand.page.bq;
import com.tencent.mm.plugin.appbrand.page.bq.a;
import com.tencent.mm.sdk.platformtools.ad;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class AppBrandGlobalNativeWidgetContainerView
  extends AbsoluteLayout
  implements aq, bq
{
  private final AbsoluteLayout mRJ;
  private final List<bq.a> mRK;
  
  public AppBrandGlobalNativeWidgetContainerView(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(197451);
    this.mRK = new LinkedList();
    this.mRJ = this;
    AppMethodBeat.o(197451);
  }
  
  public AppBrandGlobalNativeWidgetContainerView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(197452);
    this.mRK = new LinkedList();
    this.mRJ = this;
    AppMethodBeat.o(197452);
  }
  
  public AppBrandGlobalNativeWidgetContainerView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(197453);
    this.mRK = new LinkedList();
    this.mRJ = this;
    AppMethodBeat.o(197453);
  }
  
  public final void a(bq.a parama)
  {
    AppMethodBeat.i(197455);
    if (parama == null)
    {
      AppMethodBeat.o(197455);
      return;
    }
    if (this.mRK.contains(parama))
    {
      AppMethodBeat.o(197455);
      return;
    }
    this.mRK.add(parama);
    AppMethodBeat.o(197455);
  }
  
  public final void b(bq.a parama)
  {
    AppMethodBeat.i(197456);
    if (parama == null)
    {
      AppMethodBeat.o(197456);
      return;
    }
    this.mRK.remove(parama);
    AppMethodBeat.o(197456);
  }
  
  public final void onScrollChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4, View paramView)
  {
    AppMethodBeat.i(197454);
    ad.v("MicroMsg.AppBrandGlobalNativeWidgetContainerView", "onScrollChanged, left = %d, top = %d, oldLeft = %d, oldTop = %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), Integer.valueOf(paramInt4) });
    if (this.mRJ != null)
    {
      paramInt3 = paramView.getWidth();
      paramInt4 = paramView.getHeight();
      if (this.mRJ != null)
      {
        paramView = this.mRJ.getLayoutParams();
        if (paramView != null) {
          break label157;
        }
        paramView = new ViewGroup.LayoutParams(paramInt3, paramInt4);
        this.mRJ.setLayoutParams(paramView);
      }
    }
    for (;;)
    {
      this.mRJ.scrollTo(paramInt1, paramInt2);
      paramView = this.mRK.iterator();
      while (paramView.hasNext()) {
        ((bq.a)paramView.next()).eg(paramInt1, paramInt2);
      }
      label157:
      if ((paramInt3 != paramView.width) || (paramInt4 != paramView.height))
      {
        paramView.width = paramInt3;
        paramView.height = paramInt4;
        this.mRJ.setLayoutParams(paramView);
      }
    }
    AppMethodBeat.o(197454);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.AppBrandGlobalNativeWidgetContainerView
 * JD-Core Version:    0.7.0.1
 */