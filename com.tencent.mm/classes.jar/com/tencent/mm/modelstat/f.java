package com.tencent.mm.modelstat;

public final class f
{
  private static f eDt = null;
  public com.tencent.mm.a.f<String, Long> eDu = new com.tencent.mm.a.f(10);
  public String eDv;
  
  public static f Rs()
  {
    if (eDt == null) {
      eDt = new f();
    }
    return eDt;
  }
  
  public final void s(String paramString, long paramLong)
  {
    if (this.eDu != null)
    {
      this.eDv = paramString;
      this.eDu.put(paramString, Long.valueOf(paramLong));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.modelstat.f
 * JD-Core Version:    0.7.0.1
 */