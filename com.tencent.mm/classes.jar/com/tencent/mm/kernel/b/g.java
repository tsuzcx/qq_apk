package com.tencent.mm.kernel.b;

import android.app.Application;
import com.tencent.mm.kernel.a.a;

public abstract class g
{
  public Application bX;
  public a eHJ;
  private Boolean eKv;
  public a eKw = new a();
  public String mProcessName;
  
  public g(String paramString, Application paramApplication)
  {
    this.mProcessName = paramString;
    this.eHJ = new a();
    this.bX = paramApplication;
  }
  
  public final a SC()
  {
    return this.eKw;
  }
  
  public final boolean SD()
  {
    if (this.eKv == null) {
      this.eKv = Boolean.valueOf(mI(""));
    }
    return this.eKv.booleanValue();
  }
  
  public abstract String getPackageName();
  
  public final String getProcessName()
  {
    return this.mProcessName;
  }
  
  public final boolean mI(String paramString)
  {
    return (this.mProcessName != null) && (this.mProcessName.equals(getPackageName() + paramString));
  }
  
  public String toString()
  {
    if (this.mProcessName != null) {
      return this.mProcessName;
    }
    return super.toString();
  }
  
  public static final class a
  {
    public long eKA;
    public long eKB;
    public long eKC;
    public long eKD;
    public long eKE;
    public long eKF;
    public long eKx;
    public long eKy;
    public long eKz;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.kernel.b.g
 * JD-Core Version:    0.7.0.1
 */