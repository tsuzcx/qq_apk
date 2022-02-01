package com.tencent.midas.comm.log.util.compressor;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.OutputStream;

public class CachedByteArrayStream
  extends OutputStream
{
  private final int BUFFER_SIZE;
  private final byte[] _bytes;
  protected byte[] buf;
  protected int count;
  
  public CachedByteArrayStream()
  {
    AppMethodBeat.i(193464);
    this.BUFFER_SIZE = 512;
    this._bytes = new byte[512];
    this.buf = this._bytes;
    AppMethodBeat.o(193464);
  }
  
  public CachedByteArrayStream(int paramInt)
  {
    AppMethodBeat.i(193465);
    this.BUFFER_SIZE = 512;
    this._bytes = new byte[512];
    if (paramInt >= 0)
    {
      this.buf = new byte[paramInt];
      AppMethodBeat.o(193465);
      return;
    }
    IllegalArgumentException localIllegalArgumentException = new IllegalArgumentException("size < 0");
    AppMethodBeat.o(193465);
    throw localIllegalArgumentException;
  }
  
  private static void checkOffsetAndCount(int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(193473);
    if (((paramInt2 | paramInt3) < 0) || (paramInt2 > paramInt1) || (paramInt1 - paramInt2 < paramInt3))
    {
      ArrayIndexOutOfBoundsException localArrayIndexOutOfBoundsException = new ArrayIndexOutOfBoundsException("arrayLength: " + paramInt1 + ", offset: " + paramInt2 + ", count: " + paramInt3);
      AppMethodBeat.o(193473);
      throw localArrayIndexOutOfBoundsException;
    }
    AppMethodBeat.o(193473);
  }
  
  private void expand(int paramInt)
  {
    AppMethodBeat.i(193467);
    if (this.count + paramInt <= this.buf.length)
    {
      AppMethodBeat.o(193467);
      return;
    }
    byte[] arrayOfByte = new byte[(this.count + paramInt) * 2];
    System.arraycopy(this.buf, 0, arrayOfByte, 0, this.count);
    this.buf = arrayOfByte;
    AppMethodBeat.o(193467);
  }
  
  public void close()
  {
    AppMethodBeat.i(193466);
    super.close();
    AppMethodBeat.o(193466);
  }
  
  public void reset()
  {
    try
    {
      this.buf = this._bytes;
      this.count = 0;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public int size()
  {
    return this.count;
  }
  
  public byte[] toByteArray()
  {
    try
    {
      AppMethodBeat.i(193468);
      byte[] arrayOfByte = new byte[this.count];
      System.arraycopy(this.buf, 0, arrayOfByte, 0, this.count);
      AppMethodBeat.o(193468);
      return arrayOfByte;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public String toString()
  {
    AppMethodBeat.i(193469);
    String str = new String(this.buf, 0, this.count);
    AppMethodBeat.o(193469);
    return str;
  }
  
  @Deprecated
  public String toString(int paramInt)
  {
    AppMethodBeat.i(193470);
    Object localObject = new char[size()];
    int i = 0;
    while (i < localObject.length)
    {
      localObject[i] = ((char)((paramInt & 0xFF) << 8 | this.buf[i] & 0xFF));
      i += 1;
    }
    localObject = new String((char[])localObject);
    AppMethodBeat.o(193470);
    return localObject;
  }
  
  public String toString(String paramString)
  {
    AppMethodBeat.i(193471);
    paramString = new String(this.buf, 0, this.count, paramString);
    AppMethodBeat.o(193471);
    return paramString;
  }
  
  public void write(int paramInt)
  {
    try
    {
      AppMethodBeat.i(193474);
      if (this.count == this.buf.length) {
        expand(1);
      }
      byte[] arrayOfByte = this.buf;
      int i = this.count;
      this.count = (i + 1);
      arrayOfByte[i] = ((byte)paramInt);
      AppMethodBeat.o(193474);
      return;
    }
    finally {}
  }
  
  /* Error */
  public void write(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc 110
    //   4: invokestatic 21	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   7: aload_1
    //   8: arraylength
    //   9: iload_2
    //   10: iload_3
    //   11: invokestatic 112	com/tencent/midas/comm/log/util/compressor/CachedByteArrayStream:checkOffsetAndCount	(III)V
    //   14: iload_3
    //   15: ifne +11 -> 26
    //   18: ldc 110
    //   20: invokestatic 30	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   23: aload_0
    //   24: monitorexit
    //   25: return
    //   26: aload_0
    //   27: iload_3
    //   28: invokespecial 109	com/tencent/midas/comm/log/util/compressor/CachedByteArrayStream:expand	(I)V
    //   31: aload_1
    //   32: iload_2
    //   33: aload_0
    //   34: getfield 27	com/tencent/midas/comm/log/util/compressor/CachedByteArrayStream:buf	[B
    //   37: aload_0
    //   38: getfield 69	com/tencent/midas/comm/log/util/compressor/CachedByteArrayStream:count	I
    //   41: iload_3
    //   42: invokestatic 75	java/lang/System:arraycopy	(Ljava/lang/Object;ILjava/lang/Object;II)V
    //   45: aload_0
    //   46: aload_0
    //   47: getfield 69	com/tencent/midas/comm/log/util/compressor/CachedByteArrayStream:count	I
    //   50: iload_3
    //   51: iadd
    //   52: putfield 69	com/tencent/midas/comm/log/util/compressor/CachedByteArrayStream:count	I
    //   55: ldc 110
    //   57: invokestatic 30	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   60: goto -37 -> 23
    //   63: astore_1
    //   64: aload_0
    //   65: monitorexit
    //   66: aload_1
    //   67: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	68	0	this	CachedByteArrayStream
    //   0	68	1	paramArrayOfByte	byte[]
    //   0	68	2	paramInt1	int
    //   0	68	3	paramInt2	int
    // Exception table:
    //   from	to	target	type
    //   2	14	63	finally
    //   18	23	63	finally
    //   26	60	63	finally
  }
  
  public void writeTo(OutputStream paramOutputStream)
  {
    try
    {
      AppMethodBeat.i(193475);
      paramOutputStream.write(this.buf, 0, this.count);
      AppMethodBeat.o(193475);
      return;
    }
    finally
    {
      paramOutputStream = finally;
      throw paramOutputStream;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.midas.comm.log.util.compressor.CachedByteArrayStream
 * JD-Core Version:    0.7.0.1
 */