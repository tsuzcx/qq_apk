package midas.x;

import java.util.ArrayList;
import java.util.List;

public final class je
{
  public final he a;
  public final List<ie> b;
  
  public je(he paramhe)
  {
    this.a = paramhe;
    this.b = new ArrayList();
    this.b.add(new ie(paramhe, new int[] { 1 }));
  }
  
  public final ie a(int paramInt)
  {
    if (paramInt >= this.b.size())
    {
      Object localObject = this.b;
      localObject = (ie)((List)localObject).get(((List)localObject).size() - 1);
      int i = this.b.size();
      while (i <= paramInt)
      {
        he localhe = this.a;
        localObject = ((ie)localObject).c(new ie(localhe, new int[] { 1, localhe.a(i - 1 + localhe.a()) }));
        this.b.add(localObject);
        i += 1;
      }
    }
    return (ie)this.b.get(paramInt);
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
        localObject = new ie(this.a, arrayOfInt).a(paramInt, 1).b(localObject)[1].a();
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
    paramArrayOfInt = new IllegalArgumentException("No error correction bytes");
    for (;;)
    {
      throw paramArrayOfInt;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\assets\MidasPay_zip\MidasPay_1.7.9a_179010_92809280434fe4a46110cc442b537591.jar\classes.jar
 * Qualified Name:     midas.x.je
 * JD-Core Version:    0.7.0.1
 */