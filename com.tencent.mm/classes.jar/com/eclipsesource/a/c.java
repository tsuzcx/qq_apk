package com.eclipsesource.a;

final class c
  extends h
{
  private final boolean arA;
  private final boolean arB;
  private final boolean arC;
  private final String value;
  
  c(String paramString)
  {
    this.value = paramString;
    this.arA = "null".equals(paramString);
    this.arB = "true".equals(paramString);
    this.arC = "false".equals(paramString);
  }
  
  final void a(i parami)
  {
    parami.ab(this.value);
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
    paramObject = (c)paramObject;
    return this.value.equals(paramObject.value);
  }
  
  public final int hashCode()
  {
    return this.value.hashCode();
  }
  
  public final boolean isBoolean()
  {
    return (this.arB) || (this.arC);
  }
  
  public final boolean jO()
  {
    if (this.arA) {
      return super.jO();
    }
    return this.arB;
  }
  
  public final String toString()
  {
    return this.value;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.eclipsesource.a.c
 * JD-Core Version:    0.7.0.1
 */