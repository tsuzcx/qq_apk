package com.tencent.mm.model;

public class x
{
  public final boolean bIU;
  private final String bVH;
  private boolean dVu;
  private final String drv;
  private final String name;
  private final String type;
  
  public x()
  {
    this.type = "";
    this.name = "";
    this.bVH = "";
    this.drv = "";
    this.bIU = true;
  }
  
  public x(String paramString1, String paramString2, String paramString3, String paramString4, boolean paramBoolean1, boolean paramBoolean2)
  {
    this.type = paramString1;
    this.name = paramString2;
    this.bVH = paramString3;
    this.drv = paramString4;
    this.bIU = paramBoolean1;
    this.dVu = paramBoolean2;
  }
  
  public final String Bp()
  {
    if (this.bVH == null) {
      return "";
    }
    return this.bVH;
  }
  
  public final String Hd()
  {
    if (this.drv == null) {
      return "";
    }
    return this.drv;
  }
  
  public final String getType()
  {
    if (this.type == null) {
      return "";
    }
    return this.type;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.model.x
 * JD-Core Version:    0.7.0.1
 */