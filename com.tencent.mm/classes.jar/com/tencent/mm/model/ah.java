package com.tencent.mm.model;

public class ah
{
  public final boolean enable;
  private final String hVP;
  private final String lMG;
  private final String name;
  private boolean okL;
  private final String type;
  
  public ah()
  {
    this.type = "";
    this.name = "";
    this.hVP = "";
    this.lMG = "";
    this.enable = true;
  }
  
  public ah(String paramString1, String paramString2, String paramString3, String paramString4, boolean paramBoolean1, boolean paramBoolean2)
  {
    this.type = paramString1;
    this.name = paramString2;
    this.hVP = paramString3;
    this.lMG = paramString4;
    this.enable = paramBoolean1;
    this.okL = paramBoolean2;
  }
  
  public final String aSU()
  {
    if (this.hVP == null) {
      return "";
    }
    return this.hVP;
  }
  
  public final String bCf()
  {
    if (this.lMG == null) {
      return "";
    }
    return this.lMG;
  }
  
  public final String getType()
  {
    if (this.type == null) {
      return "";
    }
    return this.type;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.model.ah
 * JD-Core Version:    0.7.0.1
 */