package com.tencent.mm.plugin.appbrand.keylogger.base;

public class e
  implements a, d
{
  private final boolean kEU;
  private final boolean kEV;
  private final int kEW;
  private final int kEX;
  private final String mDesc;
  private final String mName;
  private final String mProcessName;
  private final int mType;
  
  public e(String paramString1, String paramString2, boolean paramBoolean1, boolean paramBoolean2, String paramString3, int paramInt1, int paramInt2, int paramInt3)
  {
    this.mProcessName = paramString1;
    this.mName = paramString2;
    this.kEU = paramBoolean1;
    this.kEV = paramBoolean2;
    this.mDesc = paramString3;
    this.mType = paramInt1;
    this.kEW = paramInt2;
    this.kEX = paramInt3;
  }
  
  public final String bfT()
  {
    return this.mProcessName;
  }
  
  public final boolean bfU()
  {
    return this.kEU;
  }
  
  public final boolean bfV()
  {
    return this.kEV;
  }
  
  public final String bfW()
  {
    return this.mDesc;
  }
  
  public final int bfY()
  {
    return this.kEX;
  }
  
  public final int bfZ()
  {
    return this.kEW;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.keylogger.base.e
 * JD-Core Version:    0.7.0.1
 */