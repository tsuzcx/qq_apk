package com.tencent.mm.ai.a;

public class h$a
{
  private String bTJ;
  private String id;
  
  public h$a(String paramString1, String paramString2)
  {
    this.bTJ = paramString1;
    this.id = paramString2;
  }
  
  public boolean equals(Object paramObject)
  {
    if (paramObject.getClass() != a.class) {}
    do
    {
      return false;
      paramObject = (a)paramObject;
    } while (((this.bTJ != null) || (paramObject.bTJ != null)) && ((this.bTJ == null) || (!this.bTJ.equals(paramObject.bTJ)) || (((this.id != null) || (paramObject.id != null)) && ((this.id == null) || (!this.id.equals(paramObject.id))))));
    return true;
  }
  
  public int hashCode()
  {
    return this.bTJ.hashCode() + this.id.hashCode();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ai.a.h.a
 * JD-Core Version:    0.7.0.1
 */