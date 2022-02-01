package com.tencent.mm.plugin.appbrand.widget.input;

import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.page.ax;

public final class h
{
  private static final h niu;
  private final a nit;
  
  static
  {
    AppMethodBeat.i(136358);
    niu = new h();
    AppMethodBeat.o(136358);
  }
  
  public h()
  {
    AppMethodBeat.i(136354);
    this.nit = new a((byte)0);
    AppMethodBeat.o(136354);
  }
  
  public static h bEQ()
  {
    return niu;
  }
  
  final void c(ax paramax)
  {
    AppMethodBeat.i(136355);
    if (paramax == null)
    {
      AppMethodBeat.o(136355);
      return;
    }
    this.nit.niv.delete(paramax.hashCode());
    try
    {
      paramax.getWrapperView().setFocusable(true);
      paramax.getWrapperView().setFocusableInTouchMode(true);
      paramax.getContentView().setFocusable(true);
      paramax.getContentView().setFocusableInTouchMode(true);
      AppMethodBeat.o(136355);
      return;
    }
    catch (NullPointerException paramax)
    {
      AppMethodBeat.o(136355);
    }
  }
  
  public final void d(ax paramax)
  {
    AppMethodBeat.i(136356);
    if (paramax == null)
    {
      AppMethodBeat.o(136356);
      return;
    }
    int i = this.nit.f(paramax);
    this.nit.a(paramax, i + 1);
    try
    {
      paramax.getWrapperView().setFocusable(false);
      paramax.getWrapperView().setFocusableInTouchMode(false);
      paramax.getContentView().setFocusable(false);
      paramax.getContentView().setFocusableInTouchMode(false);
      if ((paramax.getWrapperView() instanceof ViewGroup)) {
        ((ViewGroup)paramax.getWrapperView()).setDescendantFocusability(393216);
      }
      AppMethodBeat.o(136356);
      return;
    }
    catch (NullPointerException paramax)
    {
      AppMethodBeat.o(136356);
    }
  }
  
  public final void e(ax paramax)
  {
    AppMethodBeat.i(136357);
    if (paramax == null)
    {
      AppMethodBeat.o(136357);
      return;
    }
    int i = this.nit.f(paramax) - 1;
    if (i <= 0)
    {
      c(paramax);
      AppMethodBeat.o(136357);
      return;
    }
    this.nit.a(paramax, i);
    AppMethodBeat.o(136357);
  }
  
  static final class a
  {
    final SparseIntArray niv;
    
    private a()
    {
      AppMethodBeat.i(136351);
      this.niv = new SparseIntArray();
      AppMethodBeat.o(136351);
    }
    
    final void a(ax paramax, int paramInt)
    {
      AppMethodBeat.i(136353);
      this.niv.put(paramax.hashCode(), paramInt);
      AppMethodBeat.o(136353);
    }
    
    final int f(ax paramax)
    {
      AppMethodBeat.i(136352);
      int i = this.niv.get(paramax.hashCode(), 0);
      AppMethodBeat.o(136352);
      return i;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.input.h
 * JD-Core Version:    0.7.0.1
 */