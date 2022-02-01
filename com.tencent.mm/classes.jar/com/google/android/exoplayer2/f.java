package com.google.android.exoplayer2;

import com.google.android.exoplayer2.source.k;

public abstract interface f
  extends q
{
  public abstract void a(k paramk);
  
  public abstract void a(c... paramVarArgs);
  
  public abstract void b(c... paramVarArgs);
  
  @Deprecated
  public static abstract interface a
    extends q.a
  {}
  
  public static abstract interface b
  {
    public abstract void c(int paramInt, Object paramObject);
  }
  
  public static final class c
  {
    public final f.b bbZ;
    public final int bca;
    public final Object bcb;
    
    public c(f.b paramb, int paramInt, Object paramObject)
    {
      this.bbZ = paramb;
      this.bca = paramInt;
      this.bcb = paramObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.google.android.exoplayer2.f
 * JD-Core Version:    0.7.0.1
 */