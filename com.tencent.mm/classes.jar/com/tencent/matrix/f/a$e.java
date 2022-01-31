package com.tencent.matrix.f;

public final class a$e
{
  boolean bQH;
  long bQI;
  String bQJ;
  String name;
  String stack;
  String state;
  long tid;
  
  public final boolean equals(Object paramObject)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if ((paramObject instanceof e))
    {
      paramObject = (e)paramObject;
      bool1 = bool2;
      if (this.tid == paramObject.tid) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public final int hashCode()
  {
    return (int)this.tid;
  }
  
  public final String toString()
  {
    return String.format("%s %s %s %s %s", new Object[] { this.name, Long.valueOf(this.tid), this.state, Long.valueOf(this.bQI), Boolean.valueOf(this.bQH) });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.matrix.f.a.e
 * JD-Core Version:    0.7.0.1
 */