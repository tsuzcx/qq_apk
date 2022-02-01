package com.tencent.mm.model;

public class ab
{
  private final String dtU;
  public final boolean enable;
  private final String fvQ;
  private boolean gMR;
  private final String name;
  private final String type;
  
  public ab()
  {
    this.type = "";
    this.name = "";
    this.dtU = "";
    this.fvQ = "";
    this.enable = true;
  }
  
  public ab(String paramString1, String paramString2, String paramString3, String paramString4, boolean paramBoolean1, boolean paramBoolean2)
  {
    this.type = paramString1;
    this.name = paramString2;
    this.dtU = paramString3;
    this.fvQ = paramString4;
    this.enable = paramBoolean1;
    this.gMR = paramBoolean2;
  }
  
  public final String ZW()
  {
    if (this.dtU == null) {
      return "";
    }
    return this.dtU;
  }
  
  public final String arA()
  {
    if (this.fvQ == null) {
      return "";
    }
    return this.fvQ;
  }
  
  public final String getType()
  {
    if (this.type == null) {
      return "";
    }
    return this.type;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.model.ab
 * JD-Core Version:    0.7.0.1
 */