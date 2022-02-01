package com.e.a.b;

import com.e.a.b.a.a;
import java.util.ArrayList;
import java.util.List;

public final class b
  extends i
{
  private final long cdT;
  
  public b(long paramLong1, n paramn, long paramLong2)
  {
    super(paramLong1, paramn);
    this.cdT = paramLong2;
  }
  
  public final List<a> Bh()
  {
    ArrayList localArrayList = new ArrayList();
    c localc = Bg();
    Bs().aG(this.cdT);
    while (localc != null)
    {
      d[] arrayOfd = localc.cdY;
      int j = arrayOfd.length;
      int i = 0;
      while (i < j)
      {
        d locald = arrayOfd[i];
        localArrayList.add(new a(locald, a(locald.cdS)));
        i += 1;
      }
      localc = localc.Bj();
    }
    return localArrayList;
  }
  
  public final String toString()
  {
    return String.format("%s@%d (0x%x)", new Object[] { Bg().mClassName, Long.valueOf(Br()), Long.valueOf(Br()) });
  }
  
  public static final class a
  {
    public d cdU;
    public Object mValue;
    
    public a(d paramd, Object paramObject)
    {
      this.cdU = paramd;
      this.mValue = paramObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.e.a.b.b
 * JD-Core Version:    0.7.0.1
 */