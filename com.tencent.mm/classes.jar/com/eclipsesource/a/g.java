package com.eclipsesource.a;

final class g
  extends h
{
  private final String string;
  
  g(String paramString)
  {
    if (paramString == null) {
      throw new NullPointerException("string is null");
    }
    this.string = paramString;
  }
  
  final void a(i parami)
  {
    parami.writeString(this.string);
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
    paramObject = (g)paramObject;
    return this.string.equals(paramObject.string);
  }
  
  public final int hashCode()
  {
    return this.string.hashCode();
  }
  
  public final boolean isString()
  {
    return true;
  }
  
  public final String kb()
  {
    return this.string;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.eclipsesource.a.g
 * JD-Core Version:    0.7.0.1
 */