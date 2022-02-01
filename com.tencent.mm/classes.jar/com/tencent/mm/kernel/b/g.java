package com.tencent.mm.kernel.b;

import android.app.Application;
import com.tencent.mm.kernel.a.a;

public abstract class g
{
  public Application ca;
  public a gcO;
  private Boolean gfD;
  public a gfE = new a();
  public String mProcessName;
  
  public g(String paramString, Application paramApplication)
  {
    this.mProcessName = paramString;
    this.gcO = new a();
    this.ca = paramApplication;
  }
  
  public final a agt()
  {
    return this.gfE;
  }
  
  public final boolean agu()
  {
    if (this.gfD == null) {
      this.gfD = Boolean.valueOf(ra(""));
    }
    return this.gfD.booleanValue();
  }
  
  public abstract String getPackageName();
  
  public final String getProcessName()
  {
    return this.mProcessName;
  }
  
  public final boolean ra(String paramString)
  {
    return (this.mProcessName != null) && (this.mProcessName.equals(getPackageName() + paramString));
  }
  
  public final boolean rb(String paramString)
  {
    return (this.mProcessName != null) && (this.mProcessName.contains(getPackageName() + paramString));
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
    public long gfF;
    public long gfG;
    public long gfH;
    public long gfI;
    public long gfJ;
    public long gfK;
    public long gfL;
    public long gfM;
    public long gfN;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.kernel.b.g
 * JD-Core Version:    0.7.0.1
 */