package com.google.android.exoplayer2.c.b;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

final class a$a
  extends a
{
  public final List<a.b> aBA;
  public final List<a> aBB;
  public final long aBz;
  
  public a$a(int paramInt, long paramLong)
  {
    super(paramInt);
    this.aBz = paramLong;
    this.aBA = new ArrayList();
    this.aBB = new ArrayList();
  }
  
  public final a.b cW(int paramInt)
  {
    int j = this.aBA.size();
    int i = 0;
    while (i < j)
    {
      a.b localb = (a.b)this.aBA.get(i);
      if (localb.type == paramInt) {
        return localb;
      }
      i += 1;
    }
    return null;
  }
  
  public final a cX(int paramInt)
  {
    int j = this.aBB.size();
    int i = 0;
    while (i < j)
    {
      a locala = (a)this.aBB.get(i);
      if (locala.type == paramInt) {
        return locala;
      }
      i += 1;
    }
    return null;
  }
  
  public final String toString()
  {
    return cV(this.type) + " leaves: " + Arrays.toString(this.aBA.toArray()) + " containers: " + Arrays.toString(this.aBB.toArray());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.google.android.exoplayer2.c.b.a.a
 * JD-Core Version:    0.7.0.1
 */