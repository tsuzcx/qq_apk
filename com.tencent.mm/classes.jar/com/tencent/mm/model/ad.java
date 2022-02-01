package com.tencent.mm.model;

public class ad
{
  private final String dEC;
  public final boolean enable;
  private final String fUS;
  private boolean hIB;
  private final String name;
  private final String type;
  
  public ad()
  {
    this.type = "";
    this.name = "";
    this.dEC = "";
    this.fUS = "";
    this.enable = true;
  }
  
  public ad(String paramString1, String paramString2, String paramString3, String paramString4, boolean paramBoolean1, boolean paramBoolean2)
  {
    this.type = paramString1;
    this.name = paramString2;
    this.dEC = paramString3;
    this.fUS = paramString4;
    this.enable = paramBoolean1;
    this.hIB = paramBoolean2;
  }
  
  public final String aBL()
  {
    if (this.fUS == null) {
      return "";
    }
    return this.fUS;
  }
  
  public final String adF()
  {
    if (this.dEC == null) {
      return "";
    }
    return this.dEC;
  }
  
  public final String getType()
  {
    if (this.type == null) {
      return "";
    }
    return this.type;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.model.ad
 * JD-Core Version:    0.7.0.1
 */