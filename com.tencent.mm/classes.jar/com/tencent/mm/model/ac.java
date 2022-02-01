package com.tencent.mm.model;

public class ac
{
  private final String dDx;
  public final boolean enable;
  private final String fSM;
  private boolean hFJ;
  private final String name;
  private final String type;
  
  public ac()
  {
    this.type = "";
    this.name = "";
    this.dDx = "";
    this.fSM = "";
    this.enable = true;
  }
  
  public ac(String paramString1, String paramString2, String paramString3, String paramString4, boolean paramBoolean1, boolean paramBoolean2)
  {
    this.type = paramString1;
    this.name = paramString2;
    this.dDx = paramString3;
    this.fSM = paramString4;
    this.enable = paramBoolean1;
    this.hFJ = paramBoolean2;
  }
  
  public final String aBv()
  {
    if (this.fSM == null) {
      return "";
    }
    return this.fSM;
  }
  
  public final String adu()
  {
    if (this.dDx == null) {
      return "";
    }
    return this.dDx;
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
 * Qualified Name:     com.tencent.mm.model.ac
 * JD-Core Version:    0.7.0.1
 */