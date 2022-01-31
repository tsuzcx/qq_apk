package com.eclipsesource.a;

public final class e$b
{
  private final h arJ;
  private final String name;
  
  e$b(String paramString, h paramh)
  {
    this.name = paramString;
    this.arJ = paramh;
  }
  
  public final boolean equals(Object paramObject)
  {
    if (this == paramObject) {}
    do
    {
      return true;
      if (paramObject == null) {
        return false;
      }
      if (getClass() != paramObject.getClass()) {
        return false;
      }
      paramObject = (b)paramObject;
    } while ((this.name.equals(paramObject.name)) && (this.arJ.equals(paramObject.arJ)));
    return false;
  }
  
  public final int hashCode()
  {
    return (this.name.hashCode() + 31) * 31 + this.arJ.hashCode();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.eclipsesource.a.e.b
 * JD-Core Version:    0.7.0.1
 */