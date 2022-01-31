package com.tencent.mm.plugin.appbrand.widget.recyclerview;

import android.support.v7.widget.RecyclerView.a;
import android.support.v7.widget.RecyclerView.b;
import android.support.v7.widget.RecyclerView.c;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.List;

final class a$1
  extends RecyclerView.c
{
  a$1(a parama) {}
  
  public final void ar(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(77457);
    if (a.a(this.jwm).isEmpty()) {}
    for (int i = 0;; i = 1)
    {
      this.jwm.an(i + paramInt1, paramInt2);
      AppMethodBeat.o(77457);
      return;
    }
  }
  
  public final void as(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(77459);
    if (a.a(this.jwm).isEmpty()) {}
    for (int i = 0;; i = 1)
    {
      this.jwm.ap(i + paramInt1, paramInt2);
      AppMethodBeat.o(77459);
      return;
    }
  }
  
  public final void at(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(77460);
    if (a.a(this.jwm).isEmpty()) {}
    for (int i = 0;; i = 1)
    {
      this.jwm.aq(i + paramInt1, paramInt2);
      AppMethodBeat.o(77460);
      return;
    }
  }
  
  public final void au(int paramInt1, int paramInt2)
  {
    int j = 0;
    AppMethodBeat.i(77461);
    a locala = this.jwm;
    int i;
    if (a.a(locala).isEmpty())
    {
      i = 0;
      if (!a.a(this.jwm).isEmpty()) {
        break label67;
      }
    }
    for (;;)
    {
      locala.ao(i + paramInt1, j + paramInt2);
      AppMethodBeat.o(77461);
      return;
      i = 1;
      break;
      label67:
      j = 1;
    }
  }
  
  public final void f(int paramInt1, int paramInt2, Object paramObject)
  {
    AppMethodBeat.i(77458);
    if (a.a(this.jwm).isEmpty()) {}
    for (int i = 0;; i = 1)
    {
      this.jwm.e(i + paramInt1, paramInt2, paramObject);
      AppMethodBeat.o(77458);
      return;
    }
  }
  
  public final void onChanged()
  {
    AppMethodBeat.i(77456);
    this.jwm.ajb.notifyChanged();
    AppMethodBeat.o(77456);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.recyclerview.a.1
 * JD-Core Version:    0.7.0.1
 */