package a.j.b.a.c.g;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;

public final class j
{
  public static final ByteBuffer CrL;
  public static final byte[] EMPTY_BYTE_ARRAY;
  
  static
  {
    AppMethodBeat.i(121530);
    byte[] arrayOfByte = new byte[0];
    EMPTY_BYTE_ARRAY = arrayOfByte;
    CrL = ByteBuffer.wrap(arrayOfByte);
    AppMethodBeat.o(121530);
  }
  
  public static boolean cE(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(121528);
    boolean bool = y.D(paramArrayOfByte, 0, paramArrayOfByte.length);
    AppMethodBeat.o(121528);
    return bool;
  }
  
  public static String cF(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(121529);
    try
    {
      paramArrayOfByte = new String(paramArrayOfByte, "UTF-8");
      AppMethodBeat.o(121529);
      return paramArrayOfByte;
    }
    catch (UnsupportedEncodingException paramArrayOfByte)
    {
      paramArrayOfByte = new RuntimeException("UTF-8 not supported?", paramArrayOfByte);
      AppMethodBeat.o(121529);
      throw paramArrayOfByte;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     a.j.b.a.c.g.j
 * JD-Core Version:    0.7.0.1
 */