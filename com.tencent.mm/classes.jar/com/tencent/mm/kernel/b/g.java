package com.tencent.mm.kernel.b;

import android.app.Application;
import com.tencent.mm.kernel.a.a;

public abstract class g
{
  public Application Zw;
  public a kct;
  private Boolean kfj;
  public g.a kfk = new g.a();
  public String mProcessName;
  
  public g(String paramString, Application paramApplication)
  {
    this.mProcessName = paramString;
    this.kct = new a();
    this.Zw = paramApplication;
  }
  
  public final boolean MY(String paramString)
  {
    return (this.mProcessName != null) && (this.mProcessName.equals(getPackageName() + paramString));
  }
  
  public final boolean MZ(String paramString)
  {
    return (this.mProcessName != null) && (this.mProcessName.contains(getPackageName() + paramString));
  }
  
  public final Application aIC()
  {
    return this.Zw;
  }
  
  public final g.a aID()
  {
    return this.kfk;
  }
  
  public final boolean aIE()
  {
    if (this.kfj == null) {
      this.kfj = Boolean.valueOf(MY(""));
    }
    return this.kfj.booleanValue();
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.kernel.b.g
 * JD-Core Version:    0.7.0.1
 */