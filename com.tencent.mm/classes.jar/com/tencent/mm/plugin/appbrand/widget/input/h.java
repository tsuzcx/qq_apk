package com.tencent.mm.plugin.appbrand.widget.input;

import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.page.bd;

public final class h
{
  private static final h uFq;
  private final a uFp;
  
  static
  {
    AppMethodBeat.i(136358);
    uFq = new h();
    AppMethodBeat.o(136358);
  }
  
  public h()
  {
    AppMethodBeat.i(136354);
    this.uFp = new a((byte)0);
    AppMethodBeat.o(136354);
  }
  
  public static h cQR()
  {
    return uFq;
  }
  
  final void c(bd parambd)
  {
    AppMethodBeat.i(136355);
    if (parambd == null)
    {
      AppMethodBeat.o(136355);
      return;
    }
    this.uFp.uFr.delete(parambd.hashCode());
    try
    {
      parambd.getWrapperView().setFocusable(true);
      parambd.getWrapperView().setFocusableInTouchMode(true);
      parambd.getContentView().setFocusable(true);
      parambd.getContentView().setFocusableInTouchMode(true);
      AppMethodBeat.o(136355);
      return;
    }
    catch (NullPointerException parambd)
    {
      AppMethodBeat.o(136355);
    }
  }
  
  public final void d(bd parambd)
  {
    AppMethodBeat.i(136356);
    if (parambd == null)
    {
      AppMethodBeat.o(136356);
      return;
    }
    int i = this.uFp.f(parambd);
    this.uFp.a(parambd, i + 1);
    try
    {
      parambd.getWrapperView().setFocusable(false);
      parambd.getWrapperView().setFocusableInTouchMode(false);
      parambd.getContentView().setFocusable(false);
      parambd.getContentView().setFocusableInTouchMode(false);
      if ((parambd.getWrapperView() instanceof ViewGroup)) {
        ((ViewGroup)parambd.getWrapperView()).setDescendantFocusability(393216);
      }
      AppMethodBeat.o(136356);
      return;
    }
    catch (NullPointerException parambd)
    {
      AppMethodBeat.o(136356);
    }
  }
  
  public final void e(bd parambd)
  {
    AppMethodBeat.i(136357);
    if (parambd == null)
    {
      AppMethodBeat.o(136357);
      return;
    }
    int i = this.uFp.f(parambd) - 1;
    if (i <= 0)
    {
      c(parambd);
      AppMethodBeat.o(136357);
      return;
    }
    this.uFp.a(parambd, i);
    AppMethodBeat.o(136357);
  }
  
  static final class a
  {
    final SparseIntArray uFr;
    
    private a()
    {
      AppMethodBeat.i(136351);
      this.uFr = new SparseIntArray();
      AppMethodBeat.o(136351);
    }
    
    final void a(bd parambd, int paramInt)
    {
      AppMethodBeat.i(136353);
      this.uFr.put(parambd.hashCode(), paramInt);
      AppMethodBeat.o(136353);
    }
    
    final int f(bd parambd)
    {
      AppMethodBeat.i(136352);
      int i = this.uFr.get(parambd.hashCode(), 0);
      AppMethodBeat.o(136352);
      return i;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.input.h
 * JD-Core Version:    0.7.0.1
 */