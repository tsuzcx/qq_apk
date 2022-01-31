package com.tencent.map.lib.element;

class e$a
{
  public int a;
  public int b;
  
  public e$a(e parame, int paramInt1, int paramInt2)
  {
    this.b = paramInt1;
    this.a = paramInt2;
  }
  
  public boolean equals(Object paramObject)
  {
    if (paramObject == null) {}
    do
    {
      return false;
      if (paramObject == this) {
        return true;
      }
      paramObject = (a)paramObject;
    } while ((paramObject.a != this.a) || (paramObject.b != this.b));
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.map.lib.element.e.a
 * JD-Core Version:    0.7.0.1
 */