package com.tencent.mm.plugin.finder.view.animation;

import androidx.recyclerview.widget.RecyclerView.v;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class a$a
{
  public RecyclerView.v bVc;
  public RecyclerView.v bVd;
  public int bVe;
  public int bVf;
  public int bVg;
  public int bVh;
  
  private a$a(RecyclerView.v paramv1, RecyclerView.v paramv2)
  {
    this.bVc = paramv1;
    this.bVd = paramv2;
  }
  
  a$a(RecyclerView.v paramv1, RecyclerView.v paramv2, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this(paramv1, paramv2);
    this.bVe = paramInt1;
    this.bVf = paramInt2;
    this.bVg = paramInt3;
    this.bVh = paramInt4;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(168661);
    String str = "ChangeInfo{oldHolder=" + this.bVc + ", newHolder=" + this.bVd + ", fromX=" + this.bVe + ", fromY=" + this.bVf + ", toX=" + this.bVg + ", toY=" + this.bVh + '}';
    AppMethodBeat.o(168661);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.view.animation.a.a
 * JD-Core Version:    0.7.0.1
 */