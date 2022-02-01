package midas.x;

import java.lang.reflect.Array;
import java.util.Arrays;

public final class pe
{
  public final byte[][] a;
  public final int b;
  public final int c;
  
  public pe(int paramInt1, int paramInt2)
  {
    this.a = ((byte[][])Array.newInstance(Byte.TYPE, new int[] { paramInt2, paramInt1 }));
    this.b = paramInt1;
    this.c = paramInt2;
  }
  
  public byte a(int paramInt1, int paramInt2)
  {
    return this.a[paramInt2][paramInt1];
  }
  
  public void a(byte paramByte)
  {
    byte[][] arrayOfByte = this.a;
    int j = arrayOfByte.length;
    int i = 0;
    while (i < j)
    {
      Arrays.fill(arrayOfByte[i], paramByte);
      i += 1;
    }
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3)
  {
    this.a[paramInt2][paramInt1] = ((byte)paramInt3);
  }
  
  public void a(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    this.a[paramInt2][paramInt1] = ((byte)paramBoolean);
  }
  
  public byte[][] a()
  {
    return this.a;
  }
  
  public int b()
  {
    return this.c;
  }
  
  public int c()
  {
    return this.b;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder(this.b * 2 * this.c + 2);
    int i = 0;
    while (i < this.c)
    {
      byte[] arrayOfByte = this.a[i];
      int j = 0;
      while (j < this.b)
      {
        int k = arrayOfByte[j];
        if (k != 0)
        {
          if (k != 1) {
            localStringBuilder.append("  ");
          } else {
            localStringBuilder.append(" 1");
          }
        }
        else {
          localStringBuilder.append(" 0");
        }
        j += 1;
      }
      localStringBuilder.append('\n');
      i += 1;
    }
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\assets\MidasPay_zip\MidasPay_1.7.9a_179010_92809280434fe4a46110cc442b537591.jar\classes.jar
 * Qualified Name:     midas.x.pe
 * JD-Core Version:    0.7.0.1
 */