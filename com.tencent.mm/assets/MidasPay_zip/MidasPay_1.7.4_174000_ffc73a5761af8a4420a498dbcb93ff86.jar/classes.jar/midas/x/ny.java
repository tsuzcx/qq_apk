package midas.x;

import java.lang.reflect.Array;
import java.util.Arrays;

public final class ny
{
  private final byte[][] a;
  private final int b;
  private final int c;
  
  public ny(int paramInt1, int paramInt2)
  {
    this.a = ((byte[][])Array.newInstance(Byte.TYPE, new int[] { paramInt2, paramInt1 }));
    this.b = paramInt1;
    this.c = paramInt2;
  }
  
  public byte a(int paramInt1, int paramInt2)
  {
    return this.a[paramInt2][paramInt1];
  }
  
  public int a()
  {
    return this.c;
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
  
  public int b()
  {
    return this.b;
  }
  
  public byte[][] c()
  {
    return this.a;
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
        switch (arrayOfByte[j])
        {
        default: 
          localStringBuilder.append("  ");
          break;
        case 1: 
          localStringBuilder.append(" 1");
          break;
        case 0: 
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\assets\MidasPay_zip\MidasPay_1.7.4_174000_ffc73a5761af8a4420a498dbcb93ff86.jar\classes.jar
 * Qualified Name:     midas.x.ny
 * JD-Core Version:    0.7.0.1
 */