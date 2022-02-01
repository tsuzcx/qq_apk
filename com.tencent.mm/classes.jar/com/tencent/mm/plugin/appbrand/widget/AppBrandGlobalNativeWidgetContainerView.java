package com.tencent.mm.plugin.appbrand.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.AbsoluteLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.page.aq;
import com.tencent.mm.plugin.appbrand.page.br;
import com.tencent.mm.plugin.appbrand.page.br.a;
import com.tencent.mm.sdk.platformtools.ac;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class AppBrandGlobalNativeWidgetContainerView
  extends AbsoluteLayout
  implements aq, br
{
  private final AbsoluteLayout mre;
  private final List<br.a> mrf;
  
  public AppBrandGlobalNativeWidgetContainerView(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(193530);
    this.mrf = new LinkedList();
    this.mre = this;
    AppMethodBeat.o(193530);
  }
  
  public AppBrandGlobalNativeWidgetContainerView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(193531);
    this.mrf = new LinkedList();
    this.mre = this;
    AppMethodBeat.o(193531);
  }
  
  public AppBrandGlobalNativeWidgetContainerView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(193532);
    this.mrf = new LinkedList();
    this.mre = this;
    AppMethodBeat.o(193532);
  }
  
  public final void a(br.a parama)
  {
    AppMethodBeat.i(193534);
    if (parama == null)
    {
      AppMethodBeat.o(193534);
      return;
    }
    if (this.mrf.contains(parama))
    {
      AppMethodBeat.o(193534);
      return;
    }
    this.mrf.add(parama);
    AppMethodBeat.o(193534);
  }
  
  public final void b(br.a parama)
  {
    AppMethodBeat.i(193535);
    if (parama == null)
    {
      AppMethodBeat.o(193535);
      return;
    }
    this.mrf.remove(parama);
    AppMethodBeat.o(193535);
  }
  
  public final void onScrollChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4, View paramView)
  {
    AppMethodBeat.i(193533);
    ac.v("MicroMsg.AppBrandGlobalNativeWidgetContainerView", "onScrollChanged, left = %d, top = %d, oldLeft = %d, oldTop = %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), Integer.valueOf(paramInt4) });
    if (this.mre != null)
    {
      paramInt3 = paramView.getWidth();
      paramInt4 = paramView.getHeight();
      if (this.mre != null)
      {
        paramView = this.mre.getLayoutParams();
        if (paramView != null) {
          break label157;
        }
        paramView = new ViewGroup.LayoutParams(paramInt3, paramInt4);
        this.mre.setLayoutParams(paramView);
      }
    }
    for (;;)
    {
      this.mre.scrollTo(paramInt1, paramInt2);
      paramView = this.mrf.iterator();
      while (paramView.hasNext()) {
        ((br.a)paramView.next()).ee(paramInt1, paramInt2);
      }
      label157:
      if ((paramInt3 != paramView.width) || (paramInt4 != paramView.height))
      {
        paramView.width = paramInt3;
        paramView.height = paramInt4;
        this.mre.setLayoutParams(paramView);
      }
    }
    AppMethodBeat.o(193533);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.AppBrandGlobalNativeWidgetContainerView
 * JD-Core Version:    0.7.0.1
 */