package com.tencent.mm.danmaku.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Comparator;

public final class g<T>
{
  public final a<T> gQB;
  public final b gQC;
  public final Comparator<T> mComparator;
  public int mSize;
  
  public g(Comparator<T> paramComparator, b<T> paramb)
  {
    AppMethodBeat.i(241753);
    this.mSize = 0;
    this.gQC = paramb;
    this.gQB = new a();
    this.mComparator = paramComparator;
    AppMethodBeat.o(241753);
  }
  
  public final void clear()
  {
    this.gQB.gQD = this.gQB;
    this.gQB.gQE = this.gQB;
    this.mSize = 0;
  }
  
  public final T peekFirst()
  {
    return this.gQB.gQD.mData;
  }
  
  public static final class a<T>
  {
    public a<T> gQD;
    public a<T> gQE;
    public final T mData;
    
    public a()
    {
      AppMethodBeat.i(241752);
      this.mData = null;
      this.gQD = this;
      this.gQE = this;
      AppMethodBeat.o(241752);
    }
    
    public a(T paramT, a<T> parama1, a<T> parama2)
    {
      this.mData = paramT;
      this.gQD = parama1;
      this.gQE = parama2;
    }
  }
  
  public static abstract interface b<T>
  {
    public abstract int m(T paramT, long paramLong);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.danmaku.d.g
 * JD-Core Version:    0.7.0.1
 */