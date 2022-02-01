package com.tencent.mm.bx;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.UnsupportedEncodingException;

public final class b
{
  public byte[] wA;
  
  private b() {}
  
  public b(byte[] paramArrayOfByte)
  {
    this(paramArrayOfByte, 0, paramArrayOfByte.length);
    AppMethodBeat.i(2357);
    AppMethodBeat.o(2357);
  }
  
  public b(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(2358);
    this.wA = new byte[paramInt2];
    System.arraycopy(paramArrayOfByte, paramInt1, this.wA, 0, paramInt2);
    AppMethodBeat.o(2358);
  }
  
  public static b F(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(2359);
    paramArrayOfByte = new b(paramArrayOfByte, paramInt1, paramInt2);
    AppMethodBeat.o(2359);
    return paramArrayOfByte;
  }
  
  public static b aDf(String paramString)
  {
    AppMethodBeat.i(2361);
    try
    {
      b localb = new b();
      localb.wA = paramString.getBytes("UTF-8");
      AppMethodBeat.o(2361);
      return localb;
    }
    catch (UnsupportedEncodingException paramString)
    {
      paramString = new RuntimeException("UTF-8 not supported?", paramString);
      AppMethodBeat.o(2361);
      throw paramString;
    }
  }
  
  public static b cd(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(2360);
    if (paramArrayOfByte != null) {}
    for (;;)
    {
      paramArrayOfByte = new b(paramArrayOfByte);
      AppMethodBeat.o(2360);
      return paramArrayOfByte;
      paramArrayOfByte = new byte[0];
    }
  }
  
  public final b Vu(int paramInt)
  {
    AppMethodBeat.i(2362);
    byte[] arrayOfByte = new byte[paramInt];
    if (this.wA.length >= paramInt) {
      System.arraycopy(this.wA, 0, arrayOfByte, 0, paramInt - 1);
    }
    for (this.wA = arrayOfByte;; this.wA = arrayOfByte)
    {
      AppMethodBeat.o(2362);
      return this;
      System.arraycopy(this.wA, 0, arrayOfByte, 0, this.wA.length);
    }
  }
  
  public final void ce(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(2363);
    System.arraycopy(this.wA, 0, paramArrayOfByte, 4, this.wA.length);
    AppMethodBeat.o(2363);
  }
  
  /* Error */
  public final String eBA()
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_1
    //   2: sipush 2366
    //   5: invokestatic 21	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: iload_1
    //   9: aload_0
    //   10: getfield 26	com/tencent/mm/bx/b:wA	[B
    //   13: arraylength
    //   14: if_icmplt +27 -> 41
    //   17: new 43	java/lang/String
    //   20: dup
    //   21: aload_0
    //   22: getfield 26	com/tencent/mm/bx/b:wA	[B
    //   25: iconst_0
    //   26: iload_1
    //   27: ldc 41
    //   29: invokespecial 66	java/lang/String:<init>	([BIILjava/lang/String;)V
    //   32: astore_3
    //   33: sipush 2366
    //   36: invokestatic 24	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   39: aload_3
    //   40: areturn
    //   41: aload_0
    //   42: getfield 26	com/tencent/mm/bx/b:wA	[B
    //   45: iload_1
    //   46: baload
    //   47: istore_2
    //   48: iload_2
    //   49: ifeq -32 -> 17
    //   52: iload_1
    //   53: iconst_1
    //   54: iadd
    //   55: istore_1
    //   56: goto -48 -> 8
    //   59: astore_3
    //   60: new 49	java/lang/RuntimeException
    //   63: dup
    //   64: ldc 51
    //   66: invokespecial 69	java/lang/RuntimeException:<init>	(Ljava/lang/String;)V
    //   69: astore_3
    //   70: sipush 2366
    //   73: invokestatic 24	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   76: aload_3
    //   77: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	78	0	this	b
    //   1	55	1	i	int
    //   47	2	2	j	int
    //   32	8	3	str	String
    //   59	1	3	localUnsupportedEncodingException	UnsupportedEncodingException
    //   69	8	3	localRuntimeException	RuntimeException
    // Exception table:
    //   from	to	target	type
    //   8	17	59	java/io/UnsupportedEncodingException
    //   17	33	59	java/io/UnsupportedEncodingException
    //   41	48	59	java/io/UnsupportedEncodingException
  }
  
  public final byte[] getBytes()
  {
    return this.wA;
  }
  
  public final void h(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(2364);
    System.arraycopy(this.wA, paramInt1, paramArrayOfByte, paramInt2, paramInt3);
    AppMethodBeat.o(2364);
  }
  
  public final byte[] toByteArray()
  {
    AppMethodBeat.i(2365);
    int i = this.wA.length;
    byte[] arrayOfByte = new byte[i];
    System.arraycopy(this.wA, 0, arrayOfByte, 0, i);
    AppMethodBeat.o(2365);
    return arrayOfByte;
  }
  
  public final String toString(String paramString)
  {
    AppMethodBeat.i(205058);
    paramString = new String(this.wA, paramString);
    AppMethodBeat.o(205058);
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.bx.b
 * JD-Core Version:    0.7.0.1
 */