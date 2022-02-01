package com.tencent.mm.kernel.b;

import android.app.Application;
import com.tencent.mm.kernel.a.a;

public abstract class g
{
  public Application bGP;
  public a mCB;
  private Boolean mFG;
  public a mFH = new a();
  public String mProcessName;
  
  public g(String paramString, Application paramApplication)
  {
    this.mProcessName = paramString;
    this.mCB = new a();
    this.bGP = paramApplication;
  }
  
  public final boolean FH(String paramString)
  {
    return (this.mProcessName != null) && (this.mProcessName.equals(getPackageName() + paramString));
  }
  
  public final boolean FI(String paramString)
  {
    return (this.mProcessName != null) && (this.mProcessName.contains(getPackageName() + paramString));
  }
  
  public final boolean bbA()
  {
    if (this.mFG == null) {
      this.mFG = Boolean.valueOf(FH(""));
    }
    return this.mFG.booleanValue();
  }
  
  public abstract String getPackageName();
  
  public String toString()
  {
    if (this.mProcessName != null) {
      return this.mProcessName;
    }
    return super.toString();
  }
  
  public static final class a
  {
    public long mFI;
    public long mFJ;
    public long mFK;
    public long mFL;
    public long mFM;
    public long mFN;
    public long mFO;
    public long mFP;
    public long mFQ;
    public long mFR;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.kernel.b.g
 * JD-Core Version:    0.7.0.1
 */