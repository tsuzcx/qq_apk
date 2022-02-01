package androidx.camera.core.impl.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

final class f
{
  static final Charset Oj = StandardCharsets.US_ASCII;
  static final String[] Ok = { "", "BYTE", "STRING", "USHORT", "ULONG", "URATIONAL", "SBYTE", "UNDEFINED", "SSHORT", "SLONG", "SRATIONAL", "SINGLE", "DOUBLE", "IFD" };
  static final int[] Ol = { 0, 1, 1, 2, 4, 8, 1, 1, 2, 4, 8, 4, 8, 1 };
  static final byte[] Om = { 65, 83, 67, 73, 73, 0, 0, 0 };
  public final int On;
  public final long Oo;
  public final byte[] Op;
  public final int format;
  
  private f(int paramInt1, int paramInt2, byte[] paramArrayOfByte)
  {
    this(paramInt1, paramInt2, paramArrayOfByte, (byte)0);
  }
  
  private f(int paramInt1, int paramInt2, byte[] paramArrayOfByte, byte paramByte)
  {
    this.format = paramInt1;
    this.On = paramInt2;
    this.Oo = -1L;
    this.Op = paramArrayOfByte;
  }
  
  public static f a(long paramLong, ByteOrder paramByteOrder)
  {
    AppMethodBeat.i(199004);
    paramByteOrder = a(new long[] { paramLong }, paramByteOrder);
    AppMethodBeat.o(199004);
    return paramByteOrder;
  }
  
  public static f a(double[] paramArrayOfDouble, ByteOrder paramByteOrder)
  {
    AppMethodBeat.i(199053);
    ByteBuffer localByteBuffer = ByteBuffer.wrap(new byte[Ol[12] * paramArrayOfDouble.length]);
    localByteBuffer.order(paramByteOrder);
    int j = paramArrayOfDouble.length;
    int i = 0;
    while (i < j)
    {
      localByteBuffer.putDouble(paramArrayOfDouble[i]);
      i += 1;
    }
    paramArrayOfDouble = new f(12, paramArrayOfDouble.length, localByteBuffer.array());
    AppMethodBeat.o(199053);
    return paramArrayOfDouble;
  }
  
  public static f a(int[] paramArrayOfInt, ByteOrder paramByteOrder)
  {
    AppMethodBeat.i(198993);
    ByteBuffer localByteBuffer = ByteBuffer.wrap(new byte[Ol[3] * paramArrayOfInt.length]);
    localByteBuffer.order(paramByteOrder);
    int j = paramArrayOfInt.length;
    int i = 0;
    while (i < j)
    {
      localByteBuffer.putShort((short)paramArrayOfInt[i]);
      i += 1;
    }
    paramArrayOfInt = new f(3, paramArrayOfInt.length, localByteBuffer.array());
    AppMethodBeat.o(198993);
    return paramArrayOfInt;
  }
  
  public static f a(long[] paramArrayOfLong, ByteOrder paramByteOrder)
  {
    AppMethodBeat.i(198998);
    ByteBuffer localByteBuffer = ByteBuffer.wrap(new byte[Ol[4] * paramArrayOfLong.length]);
    localByteBuffer.order(paramByteOrder);
    int j = paramArrayOfLong.length;
    int i = 0;
    while (i < j)
    {
      localByteBuffer.putInt((int)paramArrayOfLong[i]);
      i += 1;
    }
    paramArrayOfLong = new f(4, paramArrayOfLong.length, localByteBuffer.array());
    AppMethodBeat.o(198998);
    return paramArrayOfLong;
  }
  
  public static f a(j[] paramArrayOfj, ByteOrder paramByteOrder)
  {
    AppMethodBeat.i(199039);
    ByteBuffer localByteBuffer = ByteBuffer.wrap(new byte[Ol[5] * paramArrayOfj.length]);
    localByteBuffer.order(paramByteOrder);
    int j = paramArrayOfj.length;
    int i = 0;
    while (i < j)
    {
      paramByteOrder = paramArrayOfj[i];
      localByteBuffer.putInt((int)paramByteOrder.OW);
      localByteBuffer.putInt((int)paramByteOrder.OX);
      i += 1;
    }
    paramArrayOfj = new f(5, paramArrayOfj.length, localByteBuffer.array());
    AppMethodBeat.o(199039);
    return paramArrayOfj;
  }
  
  public static f ad(String paramString)
  {
    AppMethodBeat.i(199021);
    if ((paramString.length() == 1) && (paramString.charAt(0) >= '0') && (paramString.charAt(0) <= '1'))
    {
      paramString = new f(1, 1, new byte[] { (byte)(paramString.charAt(0) - '0') });
      AppMethodBeat.o(199021);
      return paramString;
    }
    paramString = paramString.getBytes(Oj);
    paramString = new f(1, paramString.length, paramString);
    AppMethodBeat.o(199021);
    return paramString;
  }
  
  public static f ae(String paramString)
  {
    AppMethodBeat.i(199028);
    paramString = (paramString + '\000').getBytes(Oj);
    paramString = new f(2, paramString.length, paramString);
    AppMethodBeat.o(199028);
    return paramString;
  }
  
  public static f b(int[] paramArrayOfInt, ByteOrder paramByteOrder)
  {
    AppMethodBeat.i(199012);
    ByteBuffer localByteBuffer = ByteBuffer.wrap(new byte[Ol[9] * paramArrayOfInt.length]);
    localByteBuffer.order(paramByteOrder);
    int j = paramArrayOfInt.length;
    int i = 0;
    while (i < j)
    {
      localByteBuffer.putInt(paramArrayOfInt[i]);
      i += 1;
    }
    paramArrayOfInt = new f(9, paramArrayOfInt.length, localByteBuffer.array());
    AppMethodBeat.o(199012);
    return paramArrayOfInt;
  }
  
  public static f b(j[] paramArrayOfj, ByteOrder paramByteOrder)
  {
    AppMethodBeat.i(199046);
    ByteBuffer localByteBuffer = ByteBuffer.wrap(new byte[Ol[10] * paramArrayOfj.length]);
    localByteBuffer.order(paramByteOrder);
    int j = paramArrayOfj.length;
    int i = 0;
    while (i < j)
    {
      paramByteOrder = paramArrayOfj[i];
      localByteBuffer.putInt((int)paramByteOrder.OW);
      localByteBuffer.putInt((int)paramByteOrder.OX);
      i += 1;
    }
    paramArrayOfj = new f(10, paramArrayOfj.length, localByteBuffer.array());
    AppMethodBeat.o(199046);
    return paramArrayOfj;
  }
  
  public final int size()
  {
    return Ol[this.format] * this.On;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(199068);
    String str = "(" + Ok[this.format] + ", data length:" + this.Op.length + ")";
    AppMethodBeat.o(199068);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     androidx.camera.core.impl.a.f
 * JD-Core Version:    0.7.0.1
 */