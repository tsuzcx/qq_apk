package com.tencent.mm.plugin.finder.view.animation;

import android.support.v7.widget.RecyclerView.w;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class a$a
{
  public RecyclerView.w akE;
  public RecyclerView.w akF;
  public int akG;
  public int akH;
  public int akI;
  public int akJ;
  
  private a$a(RecyclerView.w paramw1, RecyclerView.w paramw2)
  {
    this.akE = paramw1;
    this.akF = paramw2;
  }
  
  a$a(RecyclerView.w paramw1, RecyclerView.w paramw2, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this(paramw1, paramw2);
    this.akG = paramInt1;
    this.akH = paramInt2;
    this.akI = paramInt3;
    this.akJ = paramInt4;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(168661);
    String str = "ChangeInfo{oldHolder=" + this.akE + ", newHolder=" + this.akF + ", fromX=" + this.akG + ", fromY=" + this.akH + ", toX=" + this.akI + ", toY=" + this.akJ + '}';
    AppMethodBeat.o(168661);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.view.animation.a.a
 * JD-Core Version:    0.7.0.1
 */