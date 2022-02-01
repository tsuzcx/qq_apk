package com.tencent.mm.plugin.appbrand.keylogger.base;

public class e
  implements a, d
{
  private final String HP;
  private final String mDesc;
  private final String mName;
  private final boolean mPA;
  private final int mPB;
  private final int mPC;
  private final String mProcessName;
  private final boolean mPz;
  private final int mType;
  
  public e(String paramString1, String paramString2, boolean paramBoolean1, boolean paramBoolean2, String paramString3, int paramInt1, int paramInt2, int paramInt3, String paramString4)
  {
    this.mProcessName = paramString1;
    this.mName = paramString2;
    this.mPz = paramBoolean1;
    this.mPA = paramBoolean2;
    this.mDesc = paramString3;
    this.mType = paramInt1;
    this.mPB = paramInt2;
    this.mPC = paramInt3;
    this.HP = paramString4;
  }
  
  public final boolean FI()
  {
    return this.mPA;
  }
  
  public final String bMU()
  {
    return this.mProcessName;
  }
  
  public final boolean bMV()
  {
    return this.mPz;
  }
  
  public final String bMW()
  {
    return this.mDesc;
  }
  
  public final int bMY()
  {
    return this.mPC;
  }
  
  public final int bMZ()
  {
    return this.mPB;
  }
  
  public final String category()
  {
    return this.HP;
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