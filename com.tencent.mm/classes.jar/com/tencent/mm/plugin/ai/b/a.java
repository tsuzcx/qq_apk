package com.tencent.mm.plugin.ai.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.nio.ByteBuffer;
import java.nio.FloatBuffer;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public final class a
{
  private static SimpleDateFormat qoe = null;
  
  public static float a(float paramFloat, float[] paramArrayOfFloat)
  {
    AppMethodBeat.i(267381);
    if ((paramArrayOfFloat == null) || (paramArrayOfFloat.length <= 0))
    {
      paramArrayOfFloat = new RuntimeException("calc bucket but bucket is null.");
      AppMethodBeat.o(267381);
      throw paramArrayOfFloat;
    }
    int i = 0;
    while ((i < paramArrayOfFloat.length) && (paramFloat > paramArrayOfFloat[i])) {
      i += 1;
    }
    paramFloat = i * 1.0F / (paramArrayOfFloat.length + 1);
    AppMethodBeat.o(267381);
    return paramFloat;
  }
  
  public static boolean a(int paramInt, long paramLong, PInt paramPInt1, PInt paramPInt2)
  {
    AppMethodBeat.i(267418);
    long l = paramInt;
    String str1 = cav().format(new Date(paramLong));
    String str2 = cav().format(new Date(paramLong - l * 86400000L));
    String str3 = cav().format(new Date(paramLong - 86400000L));
    paramPInt1.value = Util.getInt(str2, -1);
    paramPInt2.value = Util.getInt(str3, -1);
    Log.i("MicroMsg.FeatureUtil", "to sql date [%d, %d] day[%d] timeMs[%s]", new Object[] { Integer.valueOf(paramPInt1.value), Integer.valueOf(paramPInt2.value), Integer.valueOf(paramInt), str1 });
    if ((paramPInt1.value != -1) && (paramPInt2.value != -1))
    {
      AppMethodBeat.o(267418);
      return true;
    }
    AppMethodBeat.o(267418);
    return false;
  }
  
  public static float[] aS(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(267395);
    if (paramArrayOfByte == null)
    {
      AppMethodBeat.o(267395);
      return null;
    }
    paramArrayOfByte = ByteBuffer.wrap(paramArrayOfByte).asFloatBuffer();
    float[] arrayOfFloat = new float[paramArrayOfByte.remaining()];
    paramArrayOfByte.get(arrayOfFloat);
    AppMethodBeat.o(267395);
    return arrayOfFloat;
  }
  
  public static SimpleDateFormat cav()
  {
    AppMethodBeat.i(267401);
    if (qoe == null) {
      qoe = new SimpleDateFormat("yyyyMMdd");
    }
    SimpleDateFormat localSimpleDateFormat = qoe;
    AppMethodBeat.o(267401);
    return localSimpleDateFormat;
  }
  
  public static int caw()
  {
    AppMethodBeat.i(267407);
    int i = jx(Util.nowMilliSecond());
    AppMethodBeat.o(267407);
    return i;
  }
  
  public static long cax()
  {
    AppMethodBeat.i(267422);
    Calendar localCalendar = Calendar.getInstance();
    localCalendar.set(13, 0);
    localCalendar.set(12, 0);
    localCalendar.set(11, 0);
    localCalendar.set(14, 0);
    long l = localCalendar.getTimeInMillis();
    AppMethodBeat.o(267422);
    return l;
  }
  
  public static float f(int paramInt, float[] paramArrayOfFloat)
  {
    AppMethodBeat.i(267373);
    if ((paramArrayOfFloat == null) || (paramArrayOfFloat.length <= 0))
    {
      paramArrayOfFloat = new RuntimeException("calc bucket but bucket is null.");
      AppMethodBeat.o(267373);
      throw paramArrayOfFloat;
    }
    int i = 0;
    while ((i < paramArrayOfFloat.length) && (paramInt > paramArrayOfFloat[i])) {
      i += 1;
    }
    float f = i * 1.0F / (paramArrayOfFloat.length + 1);
    AppMethodBeat.o(267373);
    return f;
  }
  
  public static int jv(long paramLong)
  {
    AppMethodBeat.i(267370);
    GregorianCalendar localGregorianCalendar = new GregorianCalendar();
    localGregorianCalendar.setTimeInMillis(paramLong);
    int i = localGregorianCalendar.get(11);
    AppMethodBeat.o(267370);
    return i;
  }
  
  public static int jw(long paramLong)
  {
    int i = 7;
    AppMethodBeat.i(267371);
    GregorianCalendar localGregorianCalendar = new GregorianCalendar();
    localGregorianCalendar.setTimeInMillis(paramLong);
    int j = localGregorianCalendar.get(7);
    if (j - 1 <= 0) {}
    for (;;)
    {
      AppMethodBeat.o(267371);
      return i;
      i = j - 1;
    }
  }
  
  public static int jx(long paramLong)
  {
    AppMethodBeat.i(267411);
    int i = Util.getInt(cav().format(Long.valueOf(paramLong)), -1);
    AppMethodBeat.o(267411);
    return i;
  }
  
  public static byte[] t(float[] paramArrayOfFloat)
  {
    AppMethodBeat.i(267390);
    FloatBuffer localFloatBuffer = FloatBuffer.wrap(paramArrayOfFloat);
    if (localFloatBuffer == null)
    {
      paramArrayOfFloat = null;
      paramArrayOfFloat = paramArrayOfFloat.array();
      AppMethodBeat.o(267390);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.ai.b.a
 * JD-Core Version:    0.7.0.1
 */