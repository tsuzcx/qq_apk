package com.tencent.mm.kernel.b;

import android.app.Application;
import com.tencent.mm.kernel.a.a;

public abstract class g
{
  public Application ca;
  public a gDL;
  private Boolean gGA;
  public a gGB = new a();
  public String mProcessName;
  
  public g(String paramString, Application paramApplication)
  {
    this.mProcessName = paramString;
    this.gDL = new a();
    this.ca = paramApplication;
  }
  
  public final Application akJ()
  {
    return this.ca;
  }
  
  public final a akK()
  {
    return this.gGB;
  }
  
  public final boolean akL()
  {
    if (this.gGA == null) {
      this.gGA = Boolean.valueOf(xO(""));
    }
    return this.gGA.booleanValue();
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
  
  public final boolean xO(String paramString)
  {
    return (this.mProcessName != null) && (this.mProcessName.equals(getPackageName() + paramString));
  }
  
  public final boolean xP(String paramString)
  {
    return (this.mProcessName != null) && (this.mProcessName.contains(getPackageName() + paramString));
  }
  
  public static final class a
  {
    public long gGC;
    public long gGD;
    public long gGE;
    public long gGF;
    public long gGG;
    public long gGH;
    public long gGI;
    public long gGJ;
    public long gGK;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.kernel.b.g
 * JD-Core Version:    0.7.0.1
 */