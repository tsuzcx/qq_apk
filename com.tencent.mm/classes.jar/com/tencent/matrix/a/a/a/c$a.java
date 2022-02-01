package com.tencent.matrix.a.a.a;

public final class c$a
{
  public final long cUM;
  public final long cUN;
  public final long cUO;
  public final int cUP;
  public final long cUQ;
  public final String stack;
  public final int type;
  
  public c$a(int paramInt1, long paramLong1, long paramLong2, long paramLong3, int paramInt2, String paramString)
  {
    this.type = paramInt1;
    this.cUM = paramLong1;
    this.cUN = paramLong2;
    this.cUO = paramLong3;
    this.cUP = paramInt2;
    this.cUQ = System.currentTimeMillis();
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
    return "AlarmRecord{type=" + this.type + ", triggerAtMillis=" + this.cUM + ", windowMillis=" + this.cUN + ", intervalMillis=" + this.cUO + ", flag=" + this.cUP + ", timeBgn=" + this.cUQ + ", stack='" + this.stack + '\'' + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.matrix.a.a.a.c.a
 * JD-Core Version:    0.7.0.1
 */