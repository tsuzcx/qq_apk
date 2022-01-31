package com.tencent.mm.bv;

import java.io.UnsupportedEncodingException;

public final class b
{
  public byte[] oY;
  
  private b() {}
  
  public b(byte[] paramArrayOfByte)
  {
    this(paramArrayOfByte, 0, paramArrayOfByte.length);
  }
  
  public b(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    this.oY = new byte[paramInt2];
    System.arraycopy(paramArrayOfByte, paramInt1, this.oY, 0, paramInt2);
  }
  
  public static b Xp(String paramString)
  {
    try
    {
      b localb = new b();
      localb.oY = paramString.getBytes("UTF-8");
      return localb;
    }
    catch (UnsupportedEncodingException paramString)
    {
      throw new RuntimeException("UTF-8 not supported?", paramString);
    }
  }
  
  public static b bk(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte != null) {}
    for (;;)
    {
      return new b(paramArrayOfByte);
      paramArrayOfByte = new byte[0];
    }
  }
  
  public static b v(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    return new b(paramArrayOfByte, paramInt1, paramInt2);
  }
  
  public final b EB(int paramInt)
  {
    byte[] arrayOfByte = new byte[paramInt];
    if (this.oY.length >= paramInt)
    {
      System.arraycopy(this.oY, 0, arrayOfByte, 0, paramInt - 1);
      this.oY = arrayOfByte;
      return this;
    }
    System.arraycopy(this.oY, 0, arrayOfByte, 0, this.oY.length);
    this.oY = arrayOfByte;
    return this;
  }
  
  public final void bl(byte[] paramArrayOfByte)
  {
    System.arraycopy(this.oY, 0, paramArrayOfByte, 4, this.oY.length);
  }
  
  /* Error */
  public final String coM()
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_1
    //   2: iload_1
    //   3: aload_0
    //   4: getfield 17	com/tencent/mm/bv/b:oY	[B
    //   7: arraylength
    //   8: if_icmplt +19 -> 27
    //   11: new 32	java/lang/String
    //   14: dup
    //   15: aload_0
    //   16: getfield 17	com/tencent/mm/bv/b:oY	[B
    //   19: iconst_0
    //   20: iload_1
    //   21: ldc 30
    //   23: invokespecial 57	java/lang/String:<init>	([BIILjava/lang/String;)V
    //   26: areturn
    //   27: aload_0
    //   28: getfield 17	com/tencent/mm/bv/b:oY	[B
    //   31: iload_1
    //   32: baload
    //   33: istore_2
    //   34: iload_2
    //   35: ifeq -24 -> 11
    //   38: iload_1
    //   39: iconst_1
    //   40: iadd
    //   41: istore_1
    //   42: goto -40 -> 2
    //   45: astore_3
    //   46: new 38	java/lang/RuntimeException
    //   49: dup
    //   50: ldc 40
    //   52: invokespecial 60	java/lang/RuntimeException:<init>	(Ljava/lang/String;)V
    //   55: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	56	0	this	b
    //   1	41	1	i	int
    //   33	2	2	j	int
    //   45	1	3	localUnsupportedEncodingException	UnsupportedEncodingException
    // Exception table:
    //   from	to	target	type
    //   2	11	45	java/io/UnsupportedEncodingException
    //   11	27	45	java/io/UnsupportedEncodingException
    //   27	34	45	java/io/UnsupportedEncodingException
  }
  
  public final void f(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3)
  {
    System.arraycopy(this.oY, paramInt1, paramArrayOfByte, paramInt2, paramInt3);
  }
  
  public final byte[] toByteArray()
  {
    int i = this.oY.length;
    byte[] arrayOfByte = new byte[i];
    System.arraycopy(this.oY, 0, arrayOfByte, 0, i);
    return arrayOfByte;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.bv.b
 * JD-Core Version:    0.7.0.1
 */