package com.tencent.mm.loader.h.a;

public final class a<T>
{
  protected b glK;
  protected T value;
  
  public a(c paramc)
  {
    this.value = paramc;
    this.glK = b.glO;
  }
  
  public a(String paramString)
  {
    this.value = paramString;
    this.glK = b.glO;
  }
  
  private a(String paramString, b paramb)
  {
    this.value = paramString;
    this.glK = paramb;
  }
  
  public static <T extends String> a<T> a(T paramT, b paramb)
  {
    return new a(paramT, paramb);
  }
  
  public final b ahO()
  {
    return this.glK;
  }
  
  public final String ahQ()
  {
    return this.value.toString();
  }
  
  public final boolean equals(Object paramObject)
  {
    if (this.value != null)
    {
      if (((this.value instanceof c)) && ((paramObject instanceof a)) && ((((a)paramObject).value instanceof c))) {
        return ((c)this.value).aaX().equals(((c)((a)paramObject).value).aaX());
      }
      if ((paramObject instanceof a)) {
        return this.value.equals(((a)paramObject).value);
      }
    }
    return super.equals(paramObject);
  }
  
  public final int hashCode()
  {
    if (this.value != null) {
      return this.value.hashCode();
    }
    return super.hashCode();
  }
  
  public final boolean isLegal()
  {
    return this.value != null;
  }
  
  public final String toString()
  {
    if (this.value == null) {
      return "";
    }
    if ((this.value instanceof c)) {
      return ((c)this.value).aaX();
    }
    return this.value.toString();
  }
  
  public final T value()
  {
    return this.value;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.loader.h.a.a
 * JD-Core Version:    0.7.0.1
 */