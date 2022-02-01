package com.tencent.mm.plugin.appbrand.keylogger.base;

public class e
  implements a, d
{
  private final String boM;
  private final String mDesc;
  private final String mName;
  private final String mProcessName;
  private final int mType;
  private final boolean sUS;
  private final boolean sUT;
  private final int sUU;
  private final int sUV;
  
  public e(String paramString1, String paramString2, boolean paramBoolean1, boolean paramBoolean2, String paramString3, int paramInt1, int paramInt2, int paramInt3, String paramString4)
  {
    this.mProcessName = paramString1;
    this.mName = paramString2;
    this.sUS = paramBoolean1;
    this.sUT = paramBoolean2;
    this.mDesc = paramString3;
    this.mType = paramInt1;
    this.sUU = paramInt2;
    this.sUV = paramInt3;
    this.boM = paramString4;
  }
  
  public final boolean ahk()
  {
    return this.sUT;
  }
  
  public final int czB()
  {
    return this.sUV;
  }
  
  public final int czC()
  {
    return this.sUU;
  }
  
  public final String czD()
  {
    return this.boM;
  }
  
  public final String czx()
  {
    return this.mProcessName;
  }
  
  public final boolean czy()
  {
    return this.sUS;
  }
  
  public final String czz()
  {
    return this.mDesc;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.keylogger.base.e
 * JD-Core Version:    0.7.0.1
 */