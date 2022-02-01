package com.tencent.mm.plugin.appbrand.keylogger.base;

public class e
  implements a, d
{
  private final boolean lgn;
  private final boolean lgo;
  private final int lgp;
  private final int lgq;
  private final String mDesc;
  private final String mName;
  private final String mProcessName;
  private final int mType;
  
  public e(String paramString1, String paramString2, boolean paramBoolean1, boolean paramBoolean2, String paramString3, int paramInt1, int paramInt2, int paramInt3)
  {
    this.mProcessName = paramString1;
    this.mName = paramString2;
    this.lgn = paramBoolean1;
    this.lgo = paramBoolean2;
    this.mDesc = paramString3;
    this.mType = paramInt1;
    this.lgp = paramInt2;
    this.lgq = paramInt3;
  }
  
  public final String bmN()
  {
    return this.mProcessName;
  }
  
  public final boolean bmO()
  {
    return this.lgn;
  }
  
  public final boolean bmP()
  {
    return this.lgo;
  }
  
  public final String bmQ()
  {
    return this.mDesc;
  }
  
  public final int bmS()
  {
    return this.lgq;
  }
  
  public final int bmT()
  {
    return this.lgp;
  }
  
  public final int getType()
  {
    return this.mType;
  }
  
  public final String name()
  {
    return this.mName;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.keylogger.base.e
 * JD-Core Version:    0.7.0.1
 */