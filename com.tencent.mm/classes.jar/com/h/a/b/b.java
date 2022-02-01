package com.h.a.b;

import com.h.a.b.a.a;
import java.util.ArrayList;
import java.util.List;

public final class b
  extends i
{
  private final long eas;
  
  public b(long paramLong1, n paramn, long paramLong2)
  {
    super(paramLong1, paramn);
    this.eas = paramLong2;
  }
  
  public final List<a> getValues()
  {
    ArrayList localArrayList = new ArrayList();
    c localc = akV();
    alg().jdMethod_do(this.eas);
    while (localc != null)
    {
      d[] arrayOfd = localc.eax;
      int j = arrayOfd.length;
      int i = 0;
      while (i < j)
      {
        d locald = arrayOfd[i];
        localArrayList.add(new a(locald, a(locald.ear)));
        i += 1;
      }
      localc = localc.akX();
    }
    return localArrayList;
  }
  
  public final String toString()
  {
    return String.format("%s@%d (0x%x)", new Object[] { akV().mClassName, Long.valueOf(alf()), Long.valueOf(alf()) });
  }
  
  public static final class a
  {
    public d eat;
    public Object mValue;
    
    public a(d paramd, Object paramObject)
    {
      this.eat = paramd;
      this.mValue = paramObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.h.a.b.b
 * JD-Core Version:    0.7.0.1
 */