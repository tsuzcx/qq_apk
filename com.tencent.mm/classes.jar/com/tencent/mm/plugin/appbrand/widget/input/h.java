package com.tencent.mm.plugin.appbrand.widget.input;

import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.page.ap;

public final class h
{
  private static final h jkZ;
  private final h.a jkY;
  
  static
  {
    AppMethodBeat.i(123626);
    jkZ = new h();
    AppMethodBeat.o(123626);
  }
  
  public h()
  {
    AppMethodBeat.i(123622);
    this.jkY = new h.a((byte)0);
    AppMethodBeat.o(123622);
  }
  
  public static h aQF()
  {
    return jkZ;
  }
  
  final void b(ap paramap)
  {
    AppMethodBeat.i(123623);
    if (paramap == null)
    {
      AppMethodBeat.o(123623);
      return;
    }
    this.jkY.jla.delete(paramap.hashCode());
    try
    {
      paramap.getWrapperView().setFocusable(true);
      paramap.getWrapperView().setFocusableInTouchMode(true);
      paramap.getContentView().setFocusable(true);
      paramap.getContentView().setFocusableInTouchMode(true);
      AppMethodBeat.o(123623);
      return;
    }
    catch (NullPointerException paramap)
    {
      AppMethodBeat.o(123623);
    }
  }
  
  public final void c(ap paramap)
  {
    AppMethodBeat.i(123624);
    if (paramap == null)
    {
      AppMethodBeat.o(123624);
      return;
    }
    int i = this.jkY.e(paramap);
    this.jkY.a(paramap, i + 1);
    try
    {
      paramap.getWrapperView().setFocusable(false);
      paramap.getWrapperView().setFocusableInTouchMode(false);
      paramap.getContentView().setFocusable(false);
      paramap.getContentView().setFocusableInTouchMode(false);
      if ((paramap.getWrapperView() instanceof ViewGroup)) {
        ((ViewGroup)paramap.getWrapperView()).setDescendantFocusability(393216);
      }
      AppMethodBeat.o(123624);
      return;
    }
    catch (NullPointerException paramap)
    {
      AppMethodBeat.o(123624);
    }
  }
  
  public final void d(ap paramap)
  {
    AppMethodBeat.i(123625);
    if (paramap == null)
    {
      AppMethodBeat.o(123625);
      return;
    }
    int i = this.jkY.e(paramap) - 1;
    if (i <= 0)
    {
      b(paramap);
      AppMethodBeat.o(123625);
      return;
    }
    this.jkY.a(paramap, i);
    AppMethodBeat.o(123625);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.input.h
 * JD-Core Version:    0.7.0.1
 */