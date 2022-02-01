package com.tencent.mm.model;

public class ab
{
  private final String drF;
  public final boolean enable;
  private final String fzx;
  private boolean hnr;
  private final String name;
  private final String type;
  
  public ab()
  {
    this.type = "";
    this.name = "";
    this.drF = "";
    this.fzx = "";
    this.enable = true;
  }
  
  public ab(String paramString1, String paramString2, String paramString3, String paramString4, boolean paramBoolean1, boolean paramBoolean2)
  {
    this.type = paramString1;
    this.name = paramString2;
    this.drF = paramString3;
    this.fzx = paramString4;
    this.enable = paramBoolean1;
    this.hnr = paramBoolean2;
  }
  
  public final String aaR()
  {
    if (this.drF == null) {
      return "";
    }
    return this.drF;
  }
  
  public final String ayr()
  {
    if (this.fzx == null) {
      return "";
    }
    return this.fzx;
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
 * Qualified Name:     com.tencent.mm.model.ab
 * JD-Core Version:    0.7.0.1
 */