package com.d.a.b;

import com.d.a.b.a.a;
import java.util.ArrayList;
import java.util.List;

public final class b
  extends i
{
  private final long cjX;
  
  public b(long paramLong1, n paramn, long paramLong2)
  {
    super(paramLong1, paramn);
    this.cjX = paramLong2;
  }
  
  public final List<a> getValues()
  {
    ArrayList localArrayList = new ArrayList();
    c localc = KU();
    Lf().aV(this.cjX);
    while (localc != null)
    {
      d[] arrayOfd = localc.ckc;
      int j = arrayOfd.length;
      int i = 0;
      while (i < j)
      {
        d locald = arrayOfd[i];
        localArrayList.add(new a(locald, a(locald.cjW)));
        i += 1;
      }
      localc = localc.KW();
    }
    return localArrayList;
  }
  
  public final String toString()
  {
    return String.format("%s@%d (0x%x)", new Object[] { KU().mClassName, Long.valueOf(Le()), Long.valueOf(Le()) });
  }
  
  public static final class a
  {
    public d cjY;
    public Object mValue;
    
    public a(d paramd, Object paramObject)
    {
      this.cjY = paramd;
      this.mValue = paramObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.d.a.b.b
 * JD-Core Version:    0.7.0.1
 */