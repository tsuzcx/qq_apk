package com.tencent.mm.plugin.appbrand.widget.input;

import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.page.bb;

public final class h
{
  private static final h osc;
  private final a osb;
  
  static
  {
    AppMethodBeat.i(136358);
    osc = new h();
    AppMethodBeat.o(136358);
  }
  
  public h()
  {
    AppMethodBeat.i(136354);
    this.osb = new a((byte)0);
    AppMethodBeat.o(136354);
  }
  
  public static h cbe()
  {
    return osc;
  }
  
  final void c(bb parambb)
  {
    AppMethodBeat.i(136355);
    if (parambb == null)
    {
      AppMethodBeat.o(136355);
      return;
    }
    this.osb.osd.delete(parambb.hashCode());
    try
    {
      parambb.getWrapperView().setFocusable(true);
      parambb.getWrapperView().setFocusableInTouchMode(true);
      parambb.getContentView().setFocusable(true);
      parambb.getContentView().setFocusableInTouchMode(true);
      AppMethodBeat.o(136355);
      return;
    }
    catch (NullPointerException parambb)
    {
      AppMethodBeat.o(136355);
    }
  }
  
  public final void d(bb parambb)
  {
    AppMethodBeat.i(136356);
    if (parambb == null)
    {
      AppMethodBeat.o(136356);
      return;
    }
    int i = this.osb.f(parambb);
    this.osb.a(parambb, i + 1);
    try
    {
      parambb.getWrapperView().setFocusable(false);
      parambb.getWrapperView().setFocusableInTouchMode(false);
      parambb.getContentView().setFocusable(false);
      parambb.getContentView().setFocusableInTouchMode(false);
      if ((parambb.getWrapperView() instanceof ViewGroup)) {
        ((ViewGroup)parambb.getWrapperView()).setDescendantFocusability(393216);
      }
      AppMethodBeat.o(136356);
      return;
    }
    catch (NullPointerException parambb)
    {
      AppMethodBeat.o(136356);
    }
  }
  
  public final void e(bb parambb)
  {
    AppMethodBeat.i(136357);
    if (parambb == null)
    {
      AppMethodBeat.o(136357);
      return;
    }
    int i = this.osb.f(parambb) - 1;
    if (i <= 0)
    {
      c(parambb);
      AppMethodBeat.o(136357);
      return;
    }
    this.osb.a(parambb, i);
    AppMethodBeat.o(136357);
  }
  
  static final class a
  {
    final SparseIntArray osd;
    
    private a()
    {
      AppMethodBeat.i(136351);
      this.osd = new SparseIntArray();
      AppMethodBeat.o(136351);
    }
    
    final void a(bb parambb, int paramInt)
    {
      AppMethodBeat.i(136353);
      this.osd.put(parambb.hashCode(), paramInt);
      AppMethodBeat.o(136353);
    }
    
    final int f(bb parambb)
    {
      AppMethodBeat.i(136352);
      int i = this.osd.get(parambb.hashCode(), 0);
      AppMethodBeat.o(136352);
      return i;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.input.h
 * JD-Core Version:    0.7.0.1
 */