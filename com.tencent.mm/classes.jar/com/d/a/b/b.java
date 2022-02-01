package com.d.a.b;

import com.d.a.b.a.a;
import java.util.ArrayList;
import java.util.List;

public final class b
  extends i
{
  private final long bTG;
  
  public b(long paramLong1, n paramn, long paramLong2)
  {
    super(paramLong1, paramn);
    this.bTG = paramLong2;
  }
  
  public final String toString()
  {
    return String.format("%s@%d (0x%x)", new Object[] { zJ().mClassName, Long.valueOf(zU()), Long.valueOf(zU()) });
  }
  
  public final List<a> zK()
  {
    ArrayList localArrayList = new ArrayList();
    c localc = zJ();
    zV().aG(this.bTG);
    while (localc != null)
    {
      d[] arrayOfd = localc.bTL;
      int j = arrayOfd.length;
      int i = 0;
      while (i < j)
      {
        d locald = arrayOfd[i];
        localArrayList.add(new a(locald, a(locald.bTF)));
        i += 1;
      }
      localc = localc.zM();
    }
    return localArrayList;
  }
  
  public static final class a
  {
    public d bTH;
    public Object mValue;
    
    public a(d paramd, Object paramObject)
    {
      this.bTH = paramd;
      this.mValue = paramObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.d.a.b.b
 * JD-Core Version:    0.7.0.1
 */