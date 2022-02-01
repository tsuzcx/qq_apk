package com.tencent.matrix.a.a.a;

public final class c$a
{
  public final long eQm;
  public final long eQn;
  public final long eQo;
  public final int eQp;
  public final long eQq;
  public final String stack;
  public final int type;
  
  public c$a(int paramInt1, long paramLong1, long paramLong2, long paramLong3, int paramInt2, String paramString)
  {
    this.type = paramInt1;
    this.eQm = paramLong1;
    this.eQn = paramLong2;
    this.eQo = paramLong3;
    this.eQp = paramInt2;
    this.eQq = System.currentTimeMillis();
    this.stack = paramString;
  }
  
  public final boolean equals(Object paramObject)
  {
    if (this == paramObject) {}
    do
    {
      return true;
      if ((paramObject == null) || (getClass() != paramObject.getClass())) {
        return false;
      }
      paramObject = (a)paramObject;
    } while (hashCode() == paramObject.hashCode());
    return false;
  }
  
  public final String toString()
  {
    return "AlarmRecord{type=" + this.type + ", triggerAtMillis=" + this.eQm + ", windowMillis=" + this.eQn + ", intervalMillis=" + this.eQo + ", flag=" + this.eQp + ", timeBgn=" + this.eQq + ", stack='" + this.stack + '\'' + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.matrix.a.a.a.c.a
 * JD-Core Version:    0.7.0.1
 */