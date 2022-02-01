package com.tencent.mm.plugin.appbrand.widget.input;

import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.page.ay;

public final class h
{
  private static final h ndl;
  private final a ndk;
  
  static
  {
    AppMethodBeat.i(136358);
    ndl = new h();
    AppMethodBeat.o(136358);
  }
  
  public h()
  {
    AppMethodBeat.i(136354);
    this.ndk = new a((byte)0);
    AppMethodBeat.o(136354);
  }
  
  public static h bDY()
  {
    return ndl;
  }
  
  final void c(ay paramay)
  {
    AppMethodBeat.i(136355);
    if (paramay == null)
    {
      AppMethodBeat.o(136355);
      return;
    }
    this.ndk.ndm.delete(paramay.hashCode());
    try
    {
      paramay.getWrapperView().setFocusable(true);
      paramay.getWrapperView().setFocusableInTouchMode(true);
      paramay.getContentView().setFocusable(true);
      paramay.getContentView().setFocusableInTouchMode(true);
      AppMethodBeat.o(136355);
      return;
    }
    catch (NullPointerException paramay)
    {
      AppMethodBeat.o(136355);
    }
  }
  
  public final void d(ay paramay)
  {
    AppMethodBeat.i(136356);
    if (paramay == null)
    {
      AppMethodBeat.o(136356);
      return;
    }
    int i = this.ndk.f(paramay);
    this.ndk.a(paramay, i + 1);
    try
    {
      paramay.getWrapperView().setFocusable(false);
      paramay.getWrapperView().setFocusableInTouchMode(false);
      paramay.getContentView().setFocusable(false);
      paramay.getContentView().setFocusableInTouchMode(false);
      if ((paramay.getWrapperView() instanceof ViewGroup)) {
        ((ViewGroup)paramay.getWrapperView()).setDescendantFocusability(393216);
      }
      AppMethodBeat.o(136356);
      return;
    }
    catch (NullPointerException paramay)
    {
      AppMethodBeat.o(136356);
    }
  }
  
  public final void e(ay paramay)
  {
    AppMethodBeat.i(136357);
    if (paramay == null)
    {
      AppMethodBeat.o(136357);
      return;
    }
    int i = this.ndk.f(paramay) - 1;
    if (i <= 0)
    {
      c(paramay);
      AppMethodBeat.o(136357);
      return;
    }
    this.ndk.a(paramay, i);
    AppMethodBeat.o(136357);
  }
  
  static final class a
  {
    final SparseIntArray ndm;
    
    private a()
    {
      AppMethodBeat.i(136351);
      this.ndm = new SparseIntArray();
      AppMethodBeat.o(136351);
    }
    
    final void a(ay paramay, int paramInt)
    {
      AppMethodBeat.i(136353);
      this.ndm.put(paramay.hashCode(), paramInt);
      AppMethodBeat.o(136353);
    }
    
    final int f(ay paramay)
    {
      AppMethodBeat.i(136352);
      int i = this.ndm.get(paramay.hashCode(), 0);
      AppMethodBeat.o(136352);
      return i;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.input.h
 * JD-Core Version:    0.7.0.1
 */