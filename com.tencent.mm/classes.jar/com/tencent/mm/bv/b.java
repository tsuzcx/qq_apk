package com.tencent.mm.bv;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.UnsupportedEncodingException;

public final class b
{
  public byte[] pW;
  
  private b() {}
  
  public b(byte[] paramArrayOfByte)
  {
    this(paramArrayOfByte, 0, paramArrayOfByte.length);
    AppMethodBeat.i(51823);
    AppMethodBeat.o(51823);
  }
  
  public b(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(51824);
    this.pW = new byte[paramInt2];
    System.arraycopy(paramArrayOfByte, paramInt1, this.pW, 0, paramInt2);
    AppMethodBeat.o(51824);
  }
  
  public static b ank(String paramString)
  {
    AppMethodBeat.i(51827);
    try
    {
      b localb = new b();
      localb.pW = paramString.getBytes("UTF-8");
      AppMethodBeat.o(51827);
      return localb;
    }
    catch (UnsupportedEncodingException paramString)
    {
      paramString = new RuntimeException("UTF-8 not supported?", paramString);
      AppMethodBeat.o(51827);
      throw paramString;
    }
  }
  
  public static b bL(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(51826);
    if (paramArrayOfByte != null) {}
    for (;;)
    {
      paramArrayOfByte = new b(paramArrayOfByte);
      AppMethodBeat.o(51826);
      return paramArrayOfByte;
      paramArrayOfByte = new byte[0];
    }
  }
  
  public static b z(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(51825);
    paramArrayOfByte = new b(paramArrayOfByte, paramInt1, paramInt2);
    AppMethodBeat.o(51825);
    return paramArrayOfByte;
  }
  
  public final b Mz(int paramInt)
  {
    AppMethodBeat.i(51828);
    byte[] arrayOfByte = new byte[paramInt];
    if (this.pW.length >= paramInt) {
      System.arraycopy(this.pW, 0, arrayOfByte, 0, paramInt - 1);
    }
    for (this.pW = arrayOfByte;; this.pW = arrayOfByte)
    {
      AppMethodBeat.o(51828);
      return this;
      System.arraycopy(this.pW, 0, arrayOfByte, 0, this.pW.length);
    }
  }
  
  public final void bM(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(51829);
    System.arraycopy(this.pW, 0, paramArrayOfByte, 4, this.pW.length);
    AppMethodBeat.o(51829);
  }
  
  /* Error */
  public final String dqj()
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_1
    //   2: ldc 71
    //   4: invokestatic 22	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   7: iload_1
    //   8: aload_0
    //   9: getfield 28	com/tencent/mm/bv/b:pW	[B
    //   12: arraylength
    //   13: if_icmplt +26 -> 39
    //   16: new 44	java/lang/String
    //   19: dup
    //   20: aload_0
    //   21: getfield 28	com/tencent/mm/bv/b:pW	[B
    //   24: iconst_0
    //   25: iload_1
    //   26: ldc 42
    //   28: invokespecial 74	java/lang/String:<init>	([BIILjava/lang/String;)V
    //   31: astore_3
    //   32: ldc 71
    //   34: invokestatic 25	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   37: aload_3
    //   38: areturn
    //   39: aload_0
    //   40: getfield 28	com/tencent/mm/bv/b:pW	[B
    //   43: iload_1
    //   44: baload
    //   45: istore_2
    //   46: iload_2
    //   47: ifeq -31 -> 16
    //   50: iload_1
    //   51: iconst_1
    //   52: iadd
    //   53: istore_1
    //   54: goto -47 -> 7
    //   57: astore_3
    //   58: new 50	java/lang/RuntimeException
    //   61: dup
    //   62: ldc 52
    //   64: invokespecial 77	java/lang/RuntimeException:<init>	(Ljava/lang/String;)V
    //   67: astore_3
    //   68: ldc 71
    //   70: invokestatic 25	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   73: aload_3
    //   74: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	75	0	this	b
    //   1	53	1	i	int
    //   45	2	2	j	int
    //   31	7	3	str	String
    //   57	1	3	localUnsupportedEncodingException	UnsupportedEncodingException
    //   67	7	3	localRuntimeException	RuntimeException
    // Exception table:
    //   from	to	target	type
    //   7	16	57	java/io/UnsupportedEncodingException
    //   16	32	57	java/io/UnsupportedEncodingException
    //   39	46	57	java/io/UnsupportedEncodingException
  }
  
  public final byte[] getBytes()
  {
    return this.pW;
  }
  
  public final void h(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(51830);
    System.arraycopy(this.pW, paramInt1, paramArrayOfByte, paramInt2, paramInt3);
    AppMethodBeat.o(51830);
  }
  
  public final byte[] toByteArray()
  {
    AppMethodBeat.i(51831);
    int i = this.pW.length;
    byte[] arrayOfByte = new byte[i];
    System.arraycopy(this.pW, 0, arrayOfByte, 0, i);
    AppMethodBeat.o(51831);
    return arrayOfByte;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.bv.b
 * JD-Core Version:    0.7.0.1
 */