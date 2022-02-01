package midas.x;

import java.util.ArrayList;
import java.util.List;

public final class ns
{
  private final nq a;
  private final List<nr> b;
  
  public ns(nq paramnq)
  {
    this.a = paramnq;
    this.b = new ArrayList();
    this.b.add(new nr(paramnq, new int[] { 1 }));
  }
  
  private nr a(int paramInt)
  {
    if (paramInt >= this.b.size())
    {
      nr localnr = (nr)this.b.get(this.b.size() - 1);
      int i = this.b.size();
      while (i <= paramInt)
      {
        localnr = localnr.b(new nr(this.a, new int[] { 1, this.a.a(i - 1 + this.a.b()) }));
        this.b.add(localnr);
        i += 1;
      }
    }
    return (nr)this.b.get(paramInt);
  }
  
  public void a(int[] paramArrayOfInt, int paramInt)
  {
    if (paramInt != 0)
    {
      int i = paramArrayOfInt.length - paramInt;
      if (i > 0)
      {
        Object localObject = a(paramInt);
        int[] arrayOfInt = new int[i];
        System.arraycopy(paramArrayOfInt, 0, arrayOfInt, 0, i);
        localObject = new nr(this.a, arrayOfInt).a(paramInt, 1).c(localObject)[1].a();
        int j = paramInt - localObject.length;
        paramInt = 0;
        while (paramInt < j)
        {
          paramArrayOfInt[(i + paramInt)] = 0;
          paramInt += 1;
        }
        System.arraycopy(localObject, 0, paramArrayOfInt, i + j, localObject.length);
        return;
      }
      throw new IllegalArgumentException("No data bytes provided");
    }
    throw new IllegalArgumentException("No error correction bytes");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\assets\MidasPay_zip\MidasPay_1.7.4_174000_ffc73a5761af8a4420a498dbcb93ff86.jar\classes.jar
 * Qualified Name:     midas.x.ns
 * JD-Core Version:    0.7.0.1
 */