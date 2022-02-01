package com.tencent.mm.kernel.b;

import android.app.Application;
import com.tencent.mm.kernel.a.a;

public abstract class g
{
  public Application ca;
  public a hqy;
  private Boolean hto;
  public a htp = new a();
  public String mProcessName;
  
  public g(String paramString, Application paramApplication)
  {
    this.mProcessName = paramString;
    this.hqy = new a();
    this.ca = paramApplication;
  }
  
  public final boolean FY(String paramString)
  {
    return (this.mProcessName != null) && (this.mProcessName.equals(getPackageName() + paramString));
  }
  
  public final boolean FZ(String paramString)
  {
    return (this.mProcessName != null) && (this.mProcessName.contains(getPackageName() + paramString));
  }
  
  public final Application aAZ()
  {
    return this.ca;
  }
  
  public final a aBa()
  {
    return this.htp;
  }
  
  public final boolean aBb()
  {
    if (this.hto == null) {
      this.hto = Boolean.valueOf(FY(""));
    }
    return this.hto.booleanValue();
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
  
  public static final class a
  {
    public long htq;
    public long htr;
    public long hts;
    public long htt;
    public long htu;
    public long htv;
    public long htw;
    public long htx;
    public long hty;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.kernel.b.g
 * JD-Core Version:    0.7.0.1
 */