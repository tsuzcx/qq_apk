package com.google.android.gms.internal.measurement;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;

public final class zzzr
{
  private static final Charset ISO_8859_1;
  static final Charset UTF_8;
  public static final byte[] zzbsq;
  private static final ByteBuffer zzbsr;
  private static final zzze zzbss;
  
  static
  {
    AppMethodBeat.i(3587);
    UTF_8 = Charset.forName("UTF-8");
    ISO_8859_1 = Charset.forName("ISO-8859-1");
    byte[] arrayOfByte = new byte[0];
    zzbsq = arrayOfByte;
    zzbsr = ByteBuffer.wrap(arrayOfByte);
    arrayOfByte = zzbsq;
    zzbss = zzze.zza(arrayOfByte, 0, arrayOfByte.length, false);
    AppMethodBeat.o(3587);
  }
  
  static <T> T checkNotNull(T paramT)
  {
    AppMethodBeat.i(3585);
    if (paramT == null)
    {
      paramT = new NullPointerException();
      AppMethodBeat.o(3585);
      throw paramT;
    }
    AppMethodBeat.o(3585);
    return paramT;
  }
  
  static int zza(int paramInt1, byte[] paramArrayOfByte, int paramInt2, int paramInt3)
  {
    int i = paramInt2;
    while (i < paramInt2 + paramInt3)
    {
      paramInt1 = paramInt1 * 31 + paramArrayOfByte[i];
      i += 1;
    }
    return paramInt1;
  }
  
  static <T> T zza(T paramT, String paramString)
  {
    AppMethodBeat.i(3586);
    if (paramT == null)
    {
      paramT = new NullPointerException(paramString);
      AppMethodBeat.o(3586);
      throw paramT;
    }
    AppMethodBeat.o(3586);
    return paramT;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.google.android.gms.internal.measurement.zzzr
 * JD-Core Version:    0.7.0.1
 */