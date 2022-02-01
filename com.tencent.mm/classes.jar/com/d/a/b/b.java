package com.d.a.b;

import com.d.a.b.a.a;
import java.util.ArrayList;
import java.util.List;

public final class b
  extends i
{
  private final long bVY;
  
  public b(long paramLong1, n paramn, long paramLong2)
  {
    super(paramLong1, paramn);
    this.bVY = paramLong2;
  }
  
  public final String toString()
  {
    return String.format("%s@%d (0x%x)", new Object[] { zW().mClassName, Long.valueOf(Ah()), Long.valueOf(Ah()) });
  }
  
  public final List<a> zX()
  {
    ArrayList localArrayList = new ArrayList();
    c localc = zW();
    Ai().aK(this.bVY);
    while (localc != null)
    {
      d[] arrayOfd = localc.bWd;
      int j = arrayOfd.length;
      int i = 0;
      while (i < j)
      {
        d locald = arrayOfd[i];
        localArrayList.add(new a(locald, a(locald.bVX)));
        i += 1;
      }
      localc = localc.zZ();
    }
    return localArrayList;
  }
  
  public static final class a
  {
    public d bVZ;
    public Object mValue;
    
    public a(d paramd, Object paramObject)
    {
      this.bVZ = paramd;
      this.mValue = paramObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.d.a.b.b
 * JD-Core Version:    0.7.0.1
 */