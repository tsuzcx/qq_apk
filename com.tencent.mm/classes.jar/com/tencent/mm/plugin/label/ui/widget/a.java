package com.tencent.mm.plugin.label.ui.widget;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.v;
import androidx.recyclerview.widget.k.a;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class a
  extends k.a
{
  private a JVA;
  boolean JYj = false;
  private boolean JYk = false;
  
  public a(a parama)
  {
    this.JVA = parama;
  }
  
  public final boolean Ji()
  {
    return this.JYj;
  }
  
  public final boolean Jj()
  {
    return this.JYk;
  }
  
  public final int a(RecyclerView paramRecyclerView, RecyclerView.v paramv)
  {
    AppMethodBeat.i(268759);
    paramRecyclerView = paramRecyclerView.getLayoutManager();
    int i;
    int j;
    if ((paramRecyclerView instanceof LinearLayoutManager))
    {
      i = ((LinearLayoutManager)paramRecyclerView).getOrientation();
      if (i == 0)
      {
        i = 3;
        j = 12;
      }
    }
    for (;;)
    {
      i = bk(j, i);
      AppMethodBeat.o(268759);
      return i;
      if (i == 1)
      {
        i = 12;
        j = 3;
        continue;
        AppMethodBeat.o(268759);
        return 0;
      }
      else
      {
        i = 0;
        j = 0;
      }
    }
  }
  
  public final boolean a(RecyclerView paramRecyclerView, RecyclerView.v paramv1, RecyclerView.v paramv2)
  {
    AppMethodBeat.i(268763);
    if (this.JVA != null)
    {
      boolean bool = this.JVA.onMove(paramv1.KJ(), paramv2.KJ());
      AppMethodBeat.o(268763);
      return bool;
    }
    AppMethodBeat.o(268763);
    return false;
  }
  
  public final void b(RecyclerView.v paramv, int paramInt)
  {
    AppMethodBeat.i(268766);
    if (paramInt != 0)
    {
      if ((paramv instanceof d)) {
        ((d)paramv).fTB();
      }
      if (this.JVA != null) {
        this.JVA.onItemSelected(paramv.KJ());
      }
    }
    super.b(paramv, paramInt);
    AppMethodBeat.o(268766);
  }
  
  public final void d(RecyclerView paramRecyclerView, RecyclerView.v paramv)
  {
    AppMethodBeat.i(268761);
    if ((paramv instanceof d)) {
      ((d)paramv).fTs();
    }
    if (this.JVA != null) {
      this.JVA.fTs();
    }
    super.d(paramRecyclerView, paramv);
    AppMethodBeat.o(268761);
  }
  
  public final void h(RecyclerView.v paramv)
  {
    AppMethodBeat.i(268767);
    if (this.JVA != null) {
      paramv.KJ();
    }
    AppMethodBeat.o(268767);
  }
  
  public static abstract interface a
  {
    public abstract void fTs();
    
    public abstract void onItemSelected(int paramInt);
    
    public abstract boolean onMove(int paramInt1, int paramInt2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.label.ui.widget.a
 * JD-Core Version:    0.7.0.1
 */