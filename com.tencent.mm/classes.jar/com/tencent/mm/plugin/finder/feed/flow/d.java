package com.tencent.mm.plugin.finder.feed.flow;

import android.graphics.Point;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.LayoutManager;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class d
{
  RecyclerView.LayoutManager BcY;
  RecyclerView mkw;
  
  public d(RecyclerView.LayoutManager paramLayoutManager, RecyclerView paramRecyclerView)
  {
    this.BcY = paramLayoutManager;
    this.mkw = paramRecyclerView;
  }
  
  public static boolean a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, c paramc)
  {
    AppMethodBeat.i(363598);
    if ((c(paramc.BcW)) && (paramc.BcX == paramc.BcW.BcV))
    {
      AppMethodBeat.o(363598);
      return true;
    }
    switch (1.BcS[paramc.BcW.BcU.ordinal()])
    {
    default: 
      if (paramInt1 + paramInt2 + paramInt5 > paramInt4)
      {
        AppMethodBeat.o(363598);
        return true;
      }
      break;
    case 1: 
      if (paramInt1 - paramInt2 - paramInt5 < paramInt3)
      {
        AppMethodBeat.o(363598);
        return true;
      }
      AppMethodBeat.o(363598);
      return false;
    }
    AppMethodBeat.o(363598);
    return false;
  }
  
  public static boolean c(b paramb)
  {
    return paramb.BcV > 0;
  }
  
  private int edo()
  {
    AppMethodBeat.i(363588);
    int i = this.BcY.getWidth();
    int j = this.BcY.getPaddingRight();
    AppMethodBeat.o(363588);
    return i - j;
  }
  
  public final Point a(c paramc)
  {
    AppMethodBeat.i(363615);
    switch (1.BcS[paramc.BcW.BcU.ordinal()])
    {
    default: 
      paramc = new Point(this.mkw.getPaddingLeft(), this.BcY.getPaddingTop());
      AppMethodBeat.o(363615);
      return paramc;
    }
    paramc = new Point(edo(), this.BcY.getPaddingTop());
    AppMethodBeat.o(363615);
    return paramc;
  }
  
  public final int edr()
  {
    AppMethodBeat.i(363605);
    int i = edo();
    int j = this.mkw.getPaddingLeft();
    AppMethodBeat.o(363605);
    return i - j;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.flow.d
 * JD-Core Version:    0.7.0.1
 */