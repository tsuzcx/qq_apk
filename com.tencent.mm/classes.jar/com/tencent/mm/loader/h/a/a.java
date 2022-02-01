package com.tencent.mm.loader.h.a;

public final class a<T>
{
  protected b kQM;
  protected T value;
  
  public a(c paramc)
  {
    this.value = paramc;
    this.kQM = b.kQQ;
  }
  
  public a(String paramString)
  {
    this.value = paramString;
    this.kQM = b.kQQ;
  }
  
  private a(String paramString, b paramb)
  {
    this.value = paramString;
    this.kQM = paramb;
  }
  
  public static <T extends String> a<T> a(T paramT, b paramb)
  {
    return new a(paramT, paramb);
  }
  
  public static a aSv()
  {
    return new a("");
  }
  
  public final T aSr()
  {
    return this.value;
  }
  
  public final b aSt()
  {
    return this.kQM;
  }
  
  public final String aSu()
  {
    return this.value.toString();
  }
  
  public final boolean equals(Object paramObject)
  {
    if (this.value != null)
    {
      if (((this.value instanceof c)) && ((paramObject instanceof a)) && ((((a)paramObject).value instanceof c))) {
        return ((c)this.value).aBv().equals(((c)((a)paramObject).value).aBv());
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
      return ((c)this.value).aBv();
    }
    return this.value.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.loader.h.a.a
 * JD-Core Version:    0.7.0.1
 */