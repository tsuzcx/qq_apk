package com.google.a;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

final class bw
  implements au
{
  private final boolean bWz;
  final aw bXE;
  final bl bZn;
  final int[] bZo;
  final w[] bZp;
  
  bw(bl parambl, boolean paramBoolean, int[] paramArrayOfInt, w[] paramArrayOfw, Object paramObject)
  {
    this.bZn = parambl;
    this.bWz = paramBoolean;
    this.bZo = paramArrayOfInt;
    this.bZp = paramArrayOfw;
    this.bXE = ((aw)ae.checkNotNull(paramObject, "defaultInstance"));
  }
  
  public static a gO(int paramInt)
  {
    return new a(paramInt);
  }
  
  public final bl He()
  {
    return this.bZn;
  }
  
  public final boolean Hf()
  {
    return this.bWz;
  }
  
  public final aw Hg()
  {
    return this.bXE;
  }
  
  public static final class a
  {
    boolean bWz;
    private bl bZn;
    int[] bZo = null;
    private final List<w> bZq;
    private boolean bZr;
    Object bZs;
    
    public a()
    {
      this.bZq = new ArrayList();
    }
    
    public a(int paramInt)
    {
      this.bZq = new ArrayList(paramInt);
    }
    
    public final bw HF()
    {
      if (this.bZr) {
        throw new IllegalStateException("Builder can only build once");
      }
      if (this.bZn == null) {
        throw new IllegalStateException("Must specify a proto syntax");
      }
      this.bZr = true;
      Collections.sort(this.bZq);
      return new bw(this.bZn, this.bWz, this.bZo, (w[])this.bZq.toArray(new w[0]), this.bZs);
    }
    
    public final void a(bl parambl)
    {
      this.bZn = ((bl)ae.checkNotNull(parambl, "syntax"));
    }
    
    public final void a(w paramw)
    {
      if (this.bZr) {
        throw new IllegalStateException("Builder can only build once");
      }
      this.bZq.add(paramw);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.google.a.bw
 * JD-Core Version:    0.7.0.1
 */