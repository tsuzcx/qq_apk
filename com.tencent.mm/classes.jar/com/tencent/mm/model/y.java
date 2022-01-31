package com.tencent.mm.model;

public class y
{
  private final String cDs;
  private final String ejd;
  public final boolean enable;
  private boolean flD;
  private final String name;
  private final String type;
  
  public y()
  {
    this.type = "";
    this.name = "";
    this.cDs = "";
    this.ejd = "";
    this.enable = true;
  }
  
  public y(String paramString1, String paramString2, String paramString3, String paramString4, boolean paramBoolean1, boolean paramBoolean2)
  {
    this.type = paramString1;
    this.name = paramString2;
    this.cDs = paramString3;
    this.ejd = paramString4;
    this.enable = paramBoolean1;
    this.flD = paramBoolean2;
  }
  
  public final String Oe()
  {
    if (this.cDs == null) {
      return "";
    }
    return this.cDs;
  }
  
  public final String aaf()
  {
    if (this.ejd == null) {
      return "";
    }
    return this.ejd;
  }
  
  public final String getType()
  {
    if (this.type == null) {
      return "";
    }
    return this.type;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.model.y
 * JD-Core Version:    0.7.0.1
 */