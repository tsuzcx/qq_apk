package com.google.d;

abstract class dm<T, B>
{
  private void b(B paramB, cz paramcz)
  {
    while ((paramcz.aaD() != 2147483647) && (a(paramB, paramcz))) {}
  }
  
  abstract void a(B paramB, int paramInt, long paramLong);
  
  abstract void a(B paramB, int paramInt, h paramh);
  
  abstract void a(B paramB, int paramInt, T paramT);
  
  abstract void a(T paramT, dv paramdv);
  
  abstract boolean a(cz paramcz);
  
  final boolean a(B paramB, cz paramcz)
  {
    int j = paramcz.getTag();
    int i = du.lE(j);
    switch (du.lD(j))
    {
    default: 
      throw bk.aio();
    case 0: 
      a(paramB, i, paramcz.aae());
      return true;
    case 5: 
      d(paramB, i, paramcz.aah());
      return true;
    case 1: 
      b(paramB, i, paramcz.aag());
      return true;
    case 2: 
      a(paramB, i, paramcz.aak());
      return true;
    case 3: 
      Object localObject = ajD();
      j = du.cU(i, 4);
      b(localObject, paramcz);
      if (j != paramcz.getTag()) {
        throw bk.ain();
      }
      a(paramB, i, bE(localObject));
      return true;
    }
    return false;
  }
  
  abstract B ajD();
  
  abstract void b(B paramB, int paramInt, long paramLong);
  
  abstract T bE(B paramB);
  
  abstract int bH(T paramT);
  
  abstract T bL(Object paramObject);
  
  abstract B bM(Object paramObject);
  
  abstract int bN(T paramT);
  
  abstract void bu(Object paramObject);
  
  abstract void c(T paramT, dv paramdv);
  
  abstract void d(B paramB, int paramInt1, int paramInt2);
  
  abstract void u(Object paramObject, B paramB);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.google.d.dm
 * JD-Core Version:    0.7.0.1
 */