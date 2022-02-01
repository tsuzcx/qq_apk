package com.tencent.mm.plugin.appbrand.keylogger.base;

public class e
  implements a, d
{
  private final boolean lHK;
  private final boolean lHL;
  private final int lHM;
  private final int lHN;
  private final String mDesc;
  private final String mName;
  private final String mProcessName;
  private final int mType;
  
  public e(String paramString1, String paramString2, boolean paramBoolean1, boolean paramBoolean2, String paramString3, int paramInt1, int paramInt2, int paramInt3)
  {
    this.mProcessName = paramString1;
    this.mName = paramString2;
    this.lHK = paramBoolean1;
    this.lHL = paramBoolean2;
    this.mDesc = paramString3;
    this.mType = paramInt1;
    this.lHM = paramInt2;
    this.lHN = paramInt3;
  }
  
  public final String bri()
  {
    return this.mProcessName;
  }
  
  public final boolean brj()
  {
    return this.lHK;
  }
  
  public final boolean brk()
  {
    return this.lHL;
  }
  
  public final String brl()
  {
    return this.mDesc;
  }
  
  public final int brn()
  {
    return this.lHN;
  }
  
  public final int bro()
  {
    return this.lHM;
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