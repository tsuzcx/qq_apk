package com.tencent.mm.plugin.appbrand.keylogger.base;

public class e
  implements a, d
{
  private final boolean lDl;
  private final boolean lDm;
  private final int lDn;
  private final int lDo;
  private final String mDesc;
  private final String mName;
  private final String mProcessName;
  private final int mType;
  
  public e(String paramString1, String paramString2, boolean paramBoolean1, boolean paramBoolean2, String paramString3, int paramInt1, int paramInt2, int paramInt3)
  {
    this.mProcessName = paramString1;
    this.mName = paramString2;
    this.lDl = paramBoolean1;
    this.lDm = paramBoolean2;
    this.mDesc = paramString3;
    this.mType = paramInt1;
    this.lDn = paramInt2;
    this.lDo = paramInt3;
  }
  
  public final boolean bqA()
  {
    return this.lDm;
  }
  
  public final String bqB()
  {
    return this.mDesc;
  }
  
  public final int bqD()
  {
    return this.lDo;
  }
  
  public final int bqE()
  {
    return this.lDn;
  }
  
  public final String bqy()
  {
    return this.mProcessName;
  }
  
  public final boolean bqz()
  {
    return this.lDl;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.keylogger.base.e
 * JD-Core Version:    0.7.0.1
 */