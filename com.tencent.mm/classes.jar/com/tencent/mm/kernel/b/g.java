package com.tencent.mm.kernel.b;

import android.app.Application;
import com.tencent.mm.kernel.a.a;

public abstract class g
{
  public Application bT;
  public String dIA;
  public a dKl;
  private Boolean dMT;
  
  public g(String paramString, Application paramApplication)
  {
    this.dIA = paramString;
    this.dKl = new a();
    this.bT = paramApplication;
  }
  
  public final boolean Ex()
  {
    if (this.dMT == null) {
      this.dMT = Boolean.valueOf(gn(""));
    }
    return this.dMT.booleanValue();
  }
  
  public abstract String getPackageName();
  
  public final boolean gn(String paramString)
  {
    return (this.dIA != null) && (this.dIA.equals(getPackageName() + paramString));
  }
  
  public String toString()
  {
    if (this.dIA != null) {
      return this.dIA;
    }
    return super.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.kernel.b.g
 * JD-Core Version:    0.7.0.1
 */