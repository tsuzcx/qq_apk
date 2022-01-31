package com.eclipsesource.a;

final class d
  extends h
{
  private final String string;
  
  d(String paramString)
  {
    if (paramString == null) {
      throw new NullPointerException("string is null");
    }
    this.string = paramString;
  }
  
  final void a(i parami)
  {
    parami.ac(this.string);
  }
  
  public final boolean equals(Object paramObject)
  {
    boolean bool2 = false;
    boolean bool1;
    if (this == paramObject) {
      bool1 = true;
    }
    do
    {
      do
      {
        return bool1;
        bool1 = bool2;
      } while (paramObject == null);
      bool1 = bool2;
    } while (getClass() != paramObject.getClass());
    paramObject = (d)paramObject;
    return this.string.equals(paramObject.string);
  }
  
  public final int hashCode()
  {
    return this.string.hashCode();
  }
  
  public final boolean isNumber()
  {
    return true;
  }
  
  public final int jP()
  {
    return Integer.parseInt(this.string, 10);
  }
  
  public final long jQ()
  {
    return Long.parseLong(this.string, 10);
  }
  
  public final double jR()
  {
    return Double.parseDouble(this.string);
  }
  
  public final String toString()
  {
    return this.string;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.eclipsesource.a.d
 * JD-Core Version:    0.7.0.1
 */