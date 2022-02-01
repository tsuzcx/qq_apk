package com.tencent.mm.plugin.ai.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.nio.ByteBuffer;
import java.nio.FloatBuffer;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;

public final class a
{
  private static SimpleDateFormat npz = null;
  
  public static int He(long paramLong)
  {
    AppMethodBeat.i(240517);
    GregorianCalendar localGregorianCalendar = new GregorianCalendar();
    localGregorianCalendar.setTimeInMillis(paramLong);
    int i = localGregorianCalendar.get(11);
    AppMethodBeat.o(240517);
    return i;
  }
  
  public static int Hf(long paramLong)
  {
    int i = 7;
    AppMethodBeat.i(240520);
    GregorianCalendar localGregorianCalendar = new GregorianCalendar();
    localGregorianCalendar.setTimeInMillis(paramLong);
    int j = localGregorianCalendar.get(7);
    if (j - 1 <= 0) {}
    for (;;)
    {
      AppMethodBeat.o(240520);
      return i;
      i = j - 1;
    }
  }
  
  public static int Hg(long paramLong)
  {
    AppMethodBeat.i(240536);
    int i = Util.getInt(bBg().format(Long.valueOf(paramLong)), -1);
    AppMethodBeat.o(240536);
    return i;
  }
  
  public static float a(float paramFloat, float[] paramArrayOfFloat)
  {
    AppMethodBeat.i(240525);
    if ((paramArrayOfFloat == null) || (paramArrayOfFloat.length <= 0))
    {
      paramArrayOfFloat = new RuntimeException("calc bucket but bucket is null.");
      AppMethodBeat.o(240525);
      throw paramArrayOfFloat;
    }
    int i = 0;
    while ((i < paramArrayOfFloat.length) && (paramFloat > paramArrayOfFloat[i])) {
      i += 1;
    }
    paramFloat = i * 1.0F / (paramArrayOfFloat.length + 1);
    AppMethodBeat.o(240525);
    return paramFloat;
  }
  
  public static boolean a(int paramInt, long paramLong, PInt paramPInt1, PInt paramPInt2)
  {
    AppMethodBeat.i(240538);
    long l = paramInt;
    String str1 = bBg().format(new Date(paramLong));
    String str2 = bBg().format(new Date(paramLong - l * 86400000L));
    String str3 = bBg().format(new Date(paramLong - 86400000L));
    paramPInt1.value = Util.getInt(str2, -1);
    paramPInt2.value = Util.getInt(str3, -1);
    Log.i("MicroMsg.FeatureUtil", "to sql date [%d, %d] day[%d] timeMs[%s]", new Object[] { Integer.valueOf(paramPInt1.value), Integer.valueOf(paramPInt2.value), Integer.valueOf(paramInt), str1 });
    if ((paramPInt1.value != -1) && (paramPInt2.value != -1))
    {
      AppMethodBeat.o(240538);
      return true;
    }
    AppMethodBeat.o(240538);
    return false;
  }
  
  public static float[] aS(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(240533);
    if (paramArrayOfByte == null)
    {
      AppMethodBeat.o(240533);
      return null;
    }
    paramArrayOfByte = ByteBuffer.wrap(paramArrayOfByte).asFloatBuffer();
    float[] arrayOfFloat = new float[paramArrayOfByte.remaining()];
    paramArrayOfByte.get(arrayOfFloat);
    AppMethodBeat.o(240533);
    return arrayOfFloat;
  }
  
  public static SimpleDateFormat bBg()
  {
    AppMethodBeat.i(240535);
    if (npz == null) {
      npz = new SimpleDateFormat("yyyyMMdd");
    }
    SimpleDateFormat localSimpleDateFormat = npz;
    AppMethodBeat.o(240535);
    return localSimpleDateFormat;
  }
  
  public static float f(int paramInt, float[] paramArrayOfFloat)
  {
    AppMethodBeat.i(240522);
    if ((paramArrayOfFloat == null) || (paramArrayOfFloat.length <= 0))
    {
      paramArrayOfFloat = new RuntimeException("calc bucket but bucket is null.");
      AppMethodBeat.o(240522);
      throw paramArrayOfFloat;
    }
    int i = 0;
    while ((i < paramArrayOfFloat.length) && (paramInt > paramArrayOfFloat[i])) {
      i += 1;
    }
    float f = i * 1.0F / (paramArrayOfFloat.length + 1);
    AppMethodBeat.o(240522);
    return f;
  }
  
  public static byte[] l(float[] paramArrayOfFloat)
  {
    AppMethodBeat.i(240529);
    FloatBuffer localFloatBuffer = FloatBuffer.wrap(paramArrayOfFloat);
    if (localFloatBuffer == null)
    {
      paramArrayOfFloat = null;
      paramArrayOfFloat = paramArrayOfFloat.array();
      AppMethodBeat.o(240529);
      return paramArrayOfFloat;
    }
    ByteBuffer localByteBuffer = ByteBuffer.allocate(localFloatBuffer.capacity() * 4);
    for (;;)
    {
      paramArrayOfFloat = localByteBuffer;
      if (!localFloatBuffer.hasRemaining()) {
        break;
      }
      localByteBuffer.putFloat(localFloatBuffer.get());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.ai.c.a
 * JD-Core Version:    0.7.0.1
 */