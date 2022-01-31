package com.tencent.mm.modelsns;

public final class d
{
  StringBuffer eAV = new StringBuffer();
  StringBuffer eAW = new StringBuffer();
  private int index = 0;
  
  public final void i(String paramString, Object paramObject)
  {
    this.eAV.append(this.index + " " + paramString + "->" + paramObject + "\n");
    this.eAW.append(paramObject);
    this.index += 1;
  }
  
  public final void j(String paramString, Object paramObject)
  {
    this.eAV.append(paramString + "->" + paramObject + "\n");
    this.eAW.append(paramObject);
  }
  
  public final String toString()
  {
    return this.eAW.toString();
  }
  
  public final String uJ()
  {
    this.index = 0;
    this.eAV.append("--end--\n\n");
    return this.eAV.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.modelsns.d
 * JD-Core Version:    0.7.0.1
 */