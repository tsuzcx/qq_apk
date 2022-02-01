package com.tencent.mm.plugin.appbrand.widget.input;

import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.page.ay;

public final class h
{
  private static final h mCL;
  private final a mCK;
  
  static
  {
    AppMethodBeat.i(136358);
    mCL = new h();
    AppMethodBeat.o(136358);
  }
  
  public h()
  {
    AppMethodBeat.i(136354);
    this.mCK = new a((byte)0);
    AppMethodBeat.o(136354);
  }
  
  public static h bzW()
  {
    return mCL;
  }
  
  final void c(ay paramay)
  {
    AppMethodBeat.i(136355);
    if (paramay == null)
    {
      AppMethodBeat.o(136355);
      return;
    }
    this.mCK.mCM.delete(paramay.hashCode());
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
    int i = this.mCK.f(paramay);
    this.mCK.a(paramay, i + 1);
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
    int i = this.mCK.f(paramay) - 1;
    if (i <= 0)
    {
      c(paramay);
      AppMethodBeat.o(136357);
      return;
    }
    this.mCK.a(paramay, i);
    AppMethodBeat.o(136357);
  }
  
  static final class a
  {
    final SparseIntArray mCM;
    
    private a()
    {
      AppMethodBeat.i(136351);
      this.mCM = new SparseIntArray();
      AppMethodBeat.o(136351);
    }
    
    final void a(ay paramay, int paramInt)
    {
      AppMethodBeat.i(136353);
      this.mCM.put(paramay.hashCode(), paramInt);
      AppMethodBeat.o(136353);
    }
    
    final int f(ay paramay)
    {
      AppMethodBeat.i(136352);
      int i = this.mCM.get(paramay.hashCode(), 0);
      AppMethodBeat.o(136352);
      return i;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.input.h
 * JD-Core Version:    0.7.0.1
 */