package midas.x;

import java.util.ArrayList;
import java.util.List;

public final class mh
{
  private final mf a;
  private final List<mg> b;
  
  public mh(mf parammf)
  {
    this.a = parammf;
    this.b = new ArrayList();
    this.b.add(new mg(parammf, new int[] { 1 }));
  }
  
  private mg a(int paramInt)
  {
    if (paramInt >= this.b.size())
    {
      mg localmg = (mg)this.b.get(this.b.size() - 1);
      int i = this.b.size();
      while (i <= paramInt)
      {
        localmg = localmg.b(new mg(this.a, new int[] { 1, this.a.a(i - 1 + this.a.b()) }));
        this.b.add(localmg);
        i += 1;
      }
    }
    return (mg)this.b.get(paramInt);
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
        localObject = new mg(this.a, arrayOfInt).a(paramInt, 1).c(localObject)[1].a();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\assets\MidasPay_zip\MidasPay_1.7.1f_171060_ba4e988cc9e36ab96c2103acb9510bd4.jar\classes.jar
 * Qualified Name:     midas.x.mh
 * JD-Core Version:    0.7.0.1
 */