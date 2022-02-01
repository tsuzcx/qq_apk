package com.google.android.exoplayer2;

import com.google.android.exoplayer2.source.j;

public abstract interface f
  extends q
{
  public abstract void a(j paramj);
  
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
    public final f.b aQM;
    public final int aQN;
    public final Object aQO;
    
    public c(f.b paramb, int paramInt, Object paramObject)
    {
      this.aQM = paramb;
      this.aQN = paramInt;
      this.aQO = paramObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.google.android.exoplayer2.f
 * JD-Core Version:    0.7.0.1
 */