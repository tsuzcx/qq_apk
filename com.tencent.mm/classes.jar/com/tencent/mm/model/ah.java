package com.tencent.mm.model;

public class ah
{
  public final boolean enable;
  private final String fPU;
  private final String jkc;
  private boolean ltl;
  private final String name;
  private final String type;
  
  public ah()
  {
    this.type = "";
    this.name = "";
    this.fPU = "";
    this.jkc = "";
    this.enable = true;
  }
  
  public ah(String paramString1, String paramString2, String paramString3, String paramString4, boolean paramBoolean1, boolean paramBoolean2)
  {
    this.type = paramString1;
    this.name = paramString2;
    this.fPU = paramString3;
    this.jkc = paramString4;
    this.enable = paramBoolean1;
    this.ltl = paramBoolean2;
  }
  
  public final String ayr()
  {
    if (this.fPU == null) {
      return "";
    }
    return this.fPU;
  }
  
  public final String bem()
  {
    if (this.jkc == null) {
      return "";
    }
    return this.jkc;
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