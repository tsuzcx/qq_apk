package com.tencent.mm.model;

public class ah
{
  private final String dWp;
  public final boolean enable;
  private final String gzZ;
  private boolean iDl;
  private final String name;
  private final String type;
  
  public ah()
  {
    this.type = "";
    this.name = "";
    this.dWp = "";
    this.gzZ = "";
    this.enable = true;
  }
  
  public ah(String paramString1, String paramString2, String paramString3, String paramString4, boolean paramBoolean1, boolean paramBoolean2)
  {
    this.type = paramString1;
    this.name = paramString2;
    this.dWp = paramString3;
    this.gzZ = paramString4;
    this.enable = paramBoolean1;
    this.iDl = paramBoolean2;
  }
  
  public final String aVj()
  {
    if (this.gzZ == null) {
      return "";
    }
    return this.gzZ;
  }
  
  public final String arI()
  {
    if (this.dWp == null) {
      return "";
    }
    return this.dWp;
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