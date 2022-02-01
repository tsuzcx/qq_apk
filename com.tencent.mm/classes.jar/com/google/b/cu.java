package com.google.b;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

final class cu
  implements bu
{
  private final boolean bYr;
  final bw bZW;
  final cj caQ;
  final int[] caR;
  final au[] caS;
  
  cu(cj paramcj, boolean paramBoolean, int[] paramArrayOfInt, au[] paramArrayOfau, Object paramObject)
  {
    this.caQ = paramcj;
    this.bYr = paramBoolean;
    this.caR = paramArrayOfInt;
    this.caS = paramArrayOfau;
    this.bZW = ((bw)be.c(paramObject, "defaultInstance"));
  }
  
  public static a hF(int paramInt)
  {
    return new a(paramInt);
  }
  
  public final cj IF()
  {
    return this.caQ;
  }
  
  public final boolean IG()
  {
    return this.bYr;
  }
  
  public final bw IH()
  {
    return this.bZW;
  }
  
  public static final class a
  {
    boolean bYr;
    private cj caQ;
    int[] caR = null;
    private final List<au> caT;
    private boolean caU;
    Object caV;
    
    public a()
    {
      this.caT = new ArrayList();
    }
    
    public a(int paramInt)
    {
      this.caT = new ArrayList(paramInt);
    }
    
    public final cu Jf()
    {
      if (this.caU) {
        throw new IllegalStateException("Builder can only build once");
      }
      if (this.caQ == null) {
        throw new IllegalStateException("Must specify a proto syntax");
      }
      this.caU = true;
      Collections.sort(this.caT);
      return new cu(this.caQ, this.bYr, this.caR, (au[])this.caT.toArray(new au[0]), this.caV);
    }
    
    public final void a(au paramau)
    {
      if (this.caU) {
        throw new IllegalStateException("Builder can only build once");
      }
      this.caT.add(paramau);
    }
    
    public final void a(cj paramcj)
    {
      this.caQ = ((cj)be.c(paramcj, "syntax"));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.google.b.cu
 * JD-Core Version:    0.7.0.1
 */