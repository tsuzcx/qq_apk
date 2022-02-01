package com.tencent.mm.loader.g.a;

public final class a<T>
{
  protected b nsp;
  protected T value;
  
  public a(c paramc)
  {
    this.value = paramc;
    this.nsp = b.nst;
  }
  
  public a(String paramString)
  {
    this.value = paramString;
    this.nsp = b.nst;
  }
  
  private a(String paramString, b paramb)
  {
    this.value = paramString;
    this.nsp = paramb;
  }
  
  public static <T extends String> a<T> a(T paramT, b paramb)
  {
    return new a(paramT, paramb);
  }
  
  public static a bmj()
  {
    return new a("");
  }
  
  public final T bmg()
  {
    return this.value;
  }
  
  public final b bmh()
  {
    return this.nsp;
  }
  
  public final String bmi()
  {
    return this.value.toString();
  }
  
  public final boolean equals(Object paramObject)
  {
    if (this.value != null)
    {
      if (((this.value instanceof c)) && ((paramObject instanceof a)) && ((((a)paramObject).value instanceof c))) {
        return ((c)this.value).aUt().equals(((c)((a)paramObject).value).aUt());
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
      return ((c)this.value).aUt();
    }
    return this.value.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.loader.g.a.a
 * JD-Core Version:    0.7.0.1
 */