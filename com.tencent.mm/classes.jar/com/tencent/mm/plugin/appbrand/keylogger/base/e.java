package com.tencent.mm.plugin.appbrand.keylogger.base;

public class e
  implements a, d
{
  private final String IK;
  private final String mDesc;
  private final String mName;
  private final String mProcessName;
  private final int mType;
  private final boolean pQs;
  private final boolean pQt;
  private final int pQu;
  private final int pQv;
  
  public e(String paramString1, String paramString2, boolean paramBoolean1, boolean paramBoolean2, String paramString3, int paramInt1, int paramInt2, int paramInt3, String paramString4)
  {
    this.mProcessName = paramString1;
    this.mName = paramString2;
    this.pQs = paramBoolean1;
    this.pQt = paramBoolean2;
    this.mDesc = paramString3;
    this.mType = paramInt1;
    this.pQu = paramInt2;
    this.pQv = paramInt3;
    this.IK = paramString4;
  }
  
  public final boolean Ho()
  {
    return this.pQt;
  }
  
  public final String bZl()
  {
    return this.mProcessName;
  }
  
  public final boolean bZm()
  {
    return this.pQs;
  }
  
  public final String bZn()
  {
    return this.mDesc;
  }
  
  public final int bZp()
  {
    return this.pQv;
  }
  
  public final int bZq()
  {
    return this.pQu;
  }
  
  public final String bZr()
  {
    return this.IK;
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