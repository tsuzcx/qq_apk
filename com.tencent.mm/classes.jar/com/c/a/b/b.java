package com.c.a.b;

import com.c.a.b.a.a;
import java.util.ArrayList;
import java.util.List;

public final class b
  extends i
{
  private final long cox;
  
  public b(long paramLong1, n paramn, long paramLong2)
  {
    super(paramLong1, paramn);
    this.cox = paramLong2;
  }
  
  public final List<a> Kb()
  {
    ArrayList localArrayList = new ArrayList();
    c localc = Ka();
    Kl().aT(this.cox);
    while (localc != null)
    {
      d[] arrayOfd = localc.coC;
      int j = arrayOfd.length;
      int i = 0;
      while (i < j)
      {
        d locald = arrayOfd[i];
        localArrayList.add(new a(locald, a(locald.cow)));
        i += 1;
      }
      localc = localc.Kd();
    }
    return localArrayList;
  }
  
  public final String toString()
  {
    return String.format("%s@%d (0x%x)", new Object[] { Ka().mClassName, Long.valueOf(getUniqueId()), Long.valueOf(getUniqueId()) });
  }
  
  public static final class a
  {
    public d coy;
    public Object mValue;
    
    public a(d paramd, Object paramObject)
    {
      this.coy = paramd;
      this.mValue = paramObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.c.a.b.b
 * JD-Core Version:    0.7.0.1
 */