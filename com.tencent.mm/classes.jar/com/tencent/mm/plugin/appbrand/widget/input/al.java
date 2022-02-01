package com.tencent.mm.plugin.appbrand.widget.input;

import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.page.ac;
import com.tencent.mm.plugin.appbrand.page.az;
import com.tencent.mm.plugin.appbrand.page.bb;
import com.tencent.mm.plugin.appbrand.page.bf;
import com.tencent.mm.plugin.appbrand.page.bf.a;

public final class al
  implements bf
{
  private static View.OnTouchListener ovB;
  private final ac cwK;
  private final g ovC;
  
  static
  {
    AppMethodBeat.i(177120);
    ovB = new al.1();
    AppMethodBeat.o(177120);
  }
  
  public al(ac paramac)
  {
    AppMethodBeat.i(136600);
    this.cwK = paramac;
    this.ovC = new g(paramac);
    AppMethodBeat.o(136600);
  }
  
  public final void a(az paramaz)
  {
    AppMethodBeat.i(136602);
    if ((paramaz == az.ntg) || (paramaz == az.nth)) {
      o.D(this.cwK);
    }
    AppMethodBeat.o(136602);
  }
  
  public final void a(bb parambb)
  {
    AppMethodBeat.i(177119);
    if (parambb.getContentView() == null)
    {
      AppMethodBeat.o(177119);
      return;
    }
    ((ViewGroup)parambb.getContentView()).setOnTouchListener(ovB);
    AppMethodBeat.o(177119);
  }
  
  public final void c(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(136605);
    this.ovC.c(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    AppMethodBeat.o(136605);
  }
  
  public final ViewGroup getContainer()
  {
    return this.ovC;
  }
  
  public final void hK(int paramInt)
  {
    AppMethodBeat.i(136603);
    this.ovC.setTranslationY(paramInt);
    AppMethodBeat.o(136603);
  }
  
  public final void onScrollChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4, View paramView)
  {
    AppMethodBeat.i(136604);
    this.ovC.onScrollChanged(paramInt1, paramInt2, paramInt3, paramInt4, paramView);
    AppMethodBeat.o(136604);
  }
  
  public final void setupWebViewTouchInterceptor(bb parambb)
  {
    AppMethodBeat.i(136601);
    parambb = (ViewGroup)parambb.getContentView();
    g localg = this.ovC;
    parambb.setOnTouchListener(new al.2(this, localg, new ah(localg)));
    AppMethodBeat.o(136601);
  }
  
  public static final class a
    implements bf.a
  {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.input.al
 * JD-Core Version:    0.7.0.1
 */