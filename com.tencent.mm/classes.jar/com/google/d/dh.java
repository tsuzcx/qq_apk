package com.google.d;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

final class dh
  implements cc
{
  private final boolean dSa;
  final ce dUe;
  final cu dVr;
  final int[] dVs;
  final ay[] dVt;
  
  dh(cu paramcu, boolean paramBoolean, int[] paramArrayOfInt, ay[] paramArrayOfay, Object paramObject)
  {
    this.dVr = paramcu;
    this.dSa = paramBoolean;
    this.dVs = paramArrayOfInt;
    this.dVt = paramArrayOfay;
    this.dUe = ((ce)bj.c(paramObject, "defaultInstance"));
  }
  
  public static a lv(int paramInt)
  {
    return new a(paramInt);
  }
  
  public final cu aiS()
  {
    return this.dVr;
  }
  
  public final boolean aiT()
  {
    return this.dSa;
  }
  
  public final ce aiU()
  {
    return this.dUe;
  }
  
  public static final class a
  {
    boolean dSa;
    private cu dVr;
    int[] dVs = null;
    private final List<ay> dVu;
    private boolean dVv;
    Object dVw;
    
    public a()
    {
      this.dVu = new ArrayList();
    }
    
    public a(int paramInt)
    {
      this.dVu = new ArrayList(paramInt);
    }
    
    public final void a(ay paramay)
    {
      if (this.dVv) {
        throw new IllegalStateException("Builder can only build once");
      }
      this.dVu.add(paramay);
    }
    
    public final void a(cu paramcu)
    {
      this.dVr = ((cu)bj.c(paramcu, "syntax"));
    }
    
    public final dh ajz()
    {
      if (this.dVv) {
        throw new IllegalStateException("Builder can only build once");
      }
      if (this.dVr == null) {
        throw new IllegalStateException("Must specify a proto syntax");
      }
      this.dVv = true;
      Collections.sort(this.dVu);
      return new dh(this.dVr, this.dSa, this.dVs, (ay[])this.dVu.toArray(new ay[0]), this.dVw);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.google.d.dh
 * JD-Core Version:    0.7.0.1
 */