package com.tencent.mm.kernel.b;

import android.app.Application;
import com.tencent.mm.kernel.a.a;

public abstract class g
{
  public Application ca;
  public a ghu;
  private Boolean gkj;
  public a gkk = new a();
  public String mProcessName;
  
  public g(String paramString, Application paramApplication)
  {
    this.mProcessName = paramString;
    this.ghu = new a();
    this.ca = paramApplication;
  }
  
  public final Application ahJ()
  {
    return this.ca;
  }
  
  public final a ahK()
  {
    return this.gkk;
  }
  
  public final boolean ahL()
  {
    if (this.gkj == null) {
      this.gkj = Boolean.valueOf(up(""));
    }
    return this.gkj.booleanValue();
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
  
  public final boolean up(String paramString)
  {
    return (this.mProcessName != null) && (this.mProcessName.equals(getPackageName() + paramString));
  }
  
  public final boolean uq(String paramString)
  {
    return (this.mProcessName != null) && (this.mProcessName.contains(getPackageName() + paramString));
  }
  
  public static final class a
  {
    public long gkl;
    public long gkm;
    public long gkn;
    public long gko;
    public long gkp;
    public long gkq;
    public long gkr;
    public long gks;
    public long gkt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.kernel.b.g
 * JD-Core Version:    0.7.0.1
 */