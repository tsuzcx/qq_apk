package com.tencent.mm.kernel.b;

import android.app.Application;
import com.tencent.mm.kernel.a.a;

public abstract class g
{
  public Application ca;
  public a gBe;
  private Boolean gDT;
  public a gDU = new a();
  public String mProcessName;
  
  public g(String paramString, Application paramApplication)
  {
    this.mProcessName = paramString;
    this.gBe = new a();
    this.ca = paramApplication;
  }
  
  public final Application aku()
  {
    return this.ca;
  }
  
  public final a akv()
  {
    return this.gDU;
  }
  
  public final boolean akw()
  {
    if (this.gDT == null) {
      this.gDT = Boolean.valueOf(xf(""));
    }
    return this.gDT.booleanValue();
  }
  
  public abstract String getPackageName();
  
  public final String getProcessName()
  {
    return this.mProcessName;
  }
  
  public String toString()
  {
    if (this.mProcessName != null) {
      return this.mProcessName;
    }
    return super.toString();
  }
  
  public final boolean xf(String paramString)
  {
    return (this.mProcessName != null) && (this.mProcessName.equals(getPackageName() + paramString));
  }
  
  public final boolean xg(String paramString)
  {
    return (this.mProcessName != null) && (this.mProcessName.contains(getPackageName() + paramString));
  }
  
  public static final class a
  {
    public long gDV;
    public long gDW;
    public long gDX;
    public long gDY;
    public long gDZ;
    public long gEa;
    public long gEb;
    public long gEc;
    public long gEd;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.kernel.b.g
 * JD-Core Version:    0.7.0.1
 */