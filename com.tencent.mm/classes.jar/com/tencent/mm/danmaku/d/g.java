package com.tencent.mm.danmaku.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Comparator;

public final class g<T>
{
  public final a<T> jAU;
  public final b jAV;
  public final Comparator<T> mComparator;
  public int mSize;
  
  public g(Comparator<T> paramComparator, b<T> paramb)
  {
    AppMethodBeat.i(267391);
    this.mSize = 0;
    this.jAV = paramb;
    this.jAU = new a();
    this.mComparator = paramComparator;
    AppMethodBeat.o(267391);
  }
  
  public final T aAb()
  {
    return this.jAU.jAW.mData;
  }
  
  public final void clear()
  {
    this.jAU.jAW = this.jAU;
    this.jAU.jAX = this.jAU;
    this.mSize = 0;
  }
  
  public static final class a<T>
  {
    public a<T> jAW;
    public a<T> jAX;
    public final T mData;
    
    public a()
    {
      AppMethodBeat.i(275797);
      this.mData = null;
      this.jAW = this;
      this.jAX = this;
      AppMethodBeat.o(275797);
    }
    
    public a(T paramT, a<T> parama1, a<T> parama2)
    {
      this.mData = paramT;
      this.jAW = parama1;
      this.jAX = parama2;
    }
  }
  
  public static abstract interface b<T>
  {
    public abstract int j(T paramT, long paramLong);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.danmaku.d.g
 * JD-Core Version:    0.7.0.1
 */