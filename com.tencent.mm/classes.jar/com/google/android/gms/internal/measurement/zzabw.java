package com.google.android.gms.internal.measurement;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.nio.BufferOverflowException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.ReadOnlyBufferException;

public final class zzabw
{
  private final ByteBuffer zzbwv;
  
  private zzabw(ByteBuffer paramByteBuffer)
  {
    AppMethodBeat.i(3453);
    this.zzbwv = paramByteBuffer;
    this.zzbwv.order(ByteOrder.LITTLE_ENDIAN);
    AppMethodBeat.o(3453);
  }
  
  private zzabw(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    this(ByteBuffer.wrap(paramArrayOfByte, paramInt1, paramInt2));
    AppMethodBeat.i(3452);
    AppMethodBeat.o(3452);
  }
  
  private static int zza(CharSequence paramCharSequence)
  {
    int k = 0;
    AppMethodBeat.i(3464);
    int n = paramCharSequence.length();
    int j = 0;
    while ((j < n) && (paramCharSequence.charAt(j) < '')) {
      j += 1;
    }
    for (;;)
    {
      int i;
      if (j < n)
      {
        int m = paramCharSequence.charAt(j);
        if (m < 2048)
        {
          i += (127 - m >>> 31);
          j += 1;
        }
        else
        {
          int i2 = paramCharSequence.length();
          if (j < i2)
          {
            int i3 = paramCharSequence.charAt(j);
            if (i3 < 2048)
            {
              k += (127 - i3 >>> 31);
              m = j;
            }
            for (;;)
            {
              j = m + 1;
              break;
              int i1 = k + 2;
              k = i1;
              m = j;
              if (55296 <= i3)
              {
                k = i1;
                m = j;
                if (i3 <= 57343)
                {
                  if (Character.codePointAt(paramCharSequence, j) < 65536)
                  {
                    paramCharSequence = new IllegalArgumentException(39 + "Unpaired surrogate at index " + j);
                    AppMethodBeat.o(3464);
                    throw paramCharSequence;
                  }
                  m = j + 1;
                  k = i1;
                }
              }
            }
          }
          i = k + i;
        }
      }
      else
      {
        for (;;)
        {
          if (i < n)
          {
            long l = i;
            paramCharSequence = new IllegalArgumentException(54 + "UTF-8 length does not fit in int: " + (l + 4294967296L));
            AppMethodBeat.o(3464);
            throw paramCharSequence;
          }
          AppMethodBeat.o(3464);
          return i;
        }
        i = n;
      }
    }
  }
  
  private static void zza(CharSequence paramCharSequence, ByteBuffer paramByteBuffer)
  {
    int m = 0;
    AppMethodBeat.i(3465);
    if (paramByteBuffer.isReadOnly())
    {
      paramCharSequence = new ReadOnlyBufferException();
      AppMethodBeat.o(3465);
      throw paramCharSequence;
    }
    byte[] arrayOfByte;
    int n;
    int i2;
    int i3;
    int i1;
    if (paramByteBuffer.hasArray())
    {
      try
      {
        arrayOfByte = paramByteBuffer.array();
        m = paramByteBuffer.arrayOffset();
        m = paramByteBuffer.position() + m;
        n = paramByteBuffer.remaining();
        i2 = paramCharSequence.length();
        i3 = m + n;
        n = 0;
        while ((n < i2) && (n + m < i3))
        {
          i1 = paramCharSequence.charAt(n);
          if (i1 >= 128) {
            break;
          }
          arrayOfByte[(m + n)] = ((byte)i1);
          n += 1;
        }
        paramByteBuffer.position(m - paramByteBuffer.arrayOffset());
        AppMethodBeat.o(3465);
        return;
      }
      catch (ArrayIndexOutOfBoundsException paramCharSequence)
      {
        label158:
        paramByteBuffer = new BufferOverflowException();
        paramByteBuffer.initCause(paramCharSequence);
        AppMethodBeat.o(3465);
        throw paramByteBuffer;
      }
      m += n;
    }
    for (;;)
    {
      char c;
      if (n < i2)
      {
        int j = paramCharSequence.charAt(n);
        if ((j < 128) && (m < i3))
        {
          i1 = m + 1;
          arrayOfByte[m] = ((byte)j);
          m = i1;
        }
        else if ((j < 2048) && (m <= i3 - 2))
        {
          i1 = m + 1;
          arrayOfByte[m] = ((byte)(j >>> 6 | 0x3C0));
          m = i1 + 1;
          arrayOfByte[i1] = ((byte)(j & 0x3F | 0x80));
        }
        else
        {
          int i4;
          if (((j < 55296) || (57343 < j)) && (m <= i3 - 3))
          {
            i1 = m + 1;
            int i = (byte)(j >>> 12 | 0x1E0);
            arrayOfByte[m] = i;
            i4 = i1 + 1;
            arrayOfByte[i1] = ((byte)(j >>> 6 & 0x3F | 0x80));
            m = i4 + 1;
            arrayOfByte[i4] = ((byte)(j & 0x3F | 0x80));
          }
          else if (m <= i3 - 4)
          {
            i1 = n;
            if (n + 1 != paramCharSequence.length())
            {
              n += 1;
              c = paramCharSequence.charAt(n);
              if (!Character.isSurrogatePair(j, c)) {
                i1 = n;
              }
            }
            else
            {
              paramCharSequence = new IllegalArgumentException(39 + "Unpaired surrogate at index " + (i1 - 1));
              AppMethodBeat.o(3465);
              throw paramCharSequence;
            }
            i1 = Character.toCodePoint(j, c);
            i4 = m + 1;
            arrayOfByte[m] = ((byte)(i1 >>> 18 | 0xF0));
            m = i4 + 1;
            arrayOfByte[i4] = ((byte)(i1 >>> 12 & 0x3F | 0x80));
            i4 = m + 1;
            arrayOfByte[m] = ((byte)(i1 >>> 6 & 0x3F | 0x80));
            m = i4 + 1;
            arrayOfByte[i4] = ((byte)(i1 & 0x3F | 0x80));
          }
          else
          {
            paramCharSequence = new ArrayIndexOutOfBoundsException(37 + "Failed writing " + j + " at index " + m);
            AppMethodBeat.o(3465);
            throw paramCharSequence;
          }
        }
      }
      else
      {
        break;
        i1 = paramCharSequence.length();
        if (m < i1)
        {
          int k = paramCharSequence.charAt(m);
          if (k < 128) {
            paramByteBuffer.put((byte)k);
          }
          for (;;)
          {
            m += 1;
            break;
            if (k < 2048)
            {
              paramByteBuffer.put((byte)(k >>> 6 | 0x3C0));
              paramByteBuffer.put((byte)(k & 0x3F | 0x80));
            }
            else if ((k < 55296) || (57343 < k))
            {
              paramByteBuffer.put((byte)(k >>> 12 | 0x1E0));
              paramByteBuffer.put((byte)(k >>> 6 & 0x3F | 0x80));
              paramByteBuffer.put((byte)(k & 0x3F | 0x80));
            }
            else
            {
              n = m;
              if (m + 1 != paramCharSequence.length())
              {
                m += 1;
                c = paramCharSequence.charAt(m);
                if (!Character.isSurrogatePair(k, c)) {
                  n = m;
                }
              }
              else
              {
                paramCharSequence = new IllegalArgumentException(39 + "Unpaired surrogate at index " + (n - 1));
                AppMethodBeat.o(3465);
                throw paramCharSequence;
              }
              n = Character.toCodePoint(k, c);
              paramByteBuffer.put((byte)(n >>> 18 | 0xF0));
              paramByteBuffer.put((byte)(n >>> 12 & 0x3F | 0x80));
              paramByteBuffer.put((byte)(n >>> 6 & 0x3F | 0x80));
              paramByteBuffer.put((byte)(n & 0x3F | 0x80));
            }
          }
        }
        AppMethodBeat.o(3465);
        return;
        if (n != i2) {
          break label158;
        }
        m += i2;
        break;
      }
      n += 1;
    }
  }
  
  private final void zzan(long paramLong)
  {
    AppMethodBeat.i(3479);
    for (;;)
    {
      if ((0xFFFFFF80 & paramLong) == 0L)
      {
        zzap((int)paramLong);
        AppMethodBeat.o(3479);
        return;
      }
      zzap((int)paramLong & 0x7F | 0x80);
      paramLong >>>= 7;
    }
  }
  
  public static int zzao(int paramInt)
  {
    AppMethodBeat.i(3471);
    if (paramInt >= 0)
    {
      paramInt = zzas(paramInt);
      AppMethodBeat.o(3471);
      return paramInt;
    }
    AppMethodBeat.o(3471);
    return 10;
  }
  
  public static int zzao(long paramLong)
  {
    if ((0xFFFFFF80 & paramLong) == 0L) {
      return 1;
    }
    if ((0xFFFFC000 & paramLong) == 0L) {
      return 2;
    }
    if ((0xFFE00000 & paramLong) == 0L) {
      return 3;
    }
    if ((0xF0000000 & paramLong) == 0L) {
      return 4;
    }
    if ((0x0 & paramLong) == 0L) {
      return 5;
    }
    if ((0x0 & paramLong) == 0L) {
      return 6;
    }
    if ((0x0 & paramLong) == 0L) {
      return 7;
    }
    if ((0x0 & paramLong) == 0L) {
      return 8;
    }
    if ((0x0 & paramLong) == 0L) {
      return 9;
    }
    return 10;
  }
  
  private final void zzap(int paramInt)
  {
    AppMethodBeat.i(3474);
    byte b = (byte)paramInt;
    if (!this.zzbwv.hasRemaining())
    {
      zzabx localzzabx = new zzabx(this.zzbwv.position(), this.zzbwv.limit());
      AppMethodBeat.o(3474);
      throw localzzabx;
    }
    this.zzbwv.put(b);
    AppMethodBeat.o(3474);
  }
  
  public static int zzaq(int paramInt)
  {
    AppMethodBeat.i(3477);
    paramInt = zzas(paramInt << 3);
    AppMethodBeat.o(3477);
    return paramInt;
  }
  
  public static int zzas(int paramInt)
  {
    if ((paramInt & 0xFFFFFF80) == 0) {
      return 1;
    }
    if ((paramInt & 0xFFFFC000) == 0) {
      return 2;
    }
    if ((0xFFE00000 & paramInt) == 0) {
      return 3;
    }
    if ((0xF0000000 & paramInt) == 0) {
      return 4;
    }
    return 5;
  }
  
  public static int zzb(int paramInt, zzace paramzzace)
  {
    AppMethodBeat.i(3470);
    paramInt = zzaq(paramInt);
    int i = paramzzace.zzvm();
    int j = zzas(i);
    AppMethodBeat.o(3470);
    return paramInt + (i + j);
  }
  
  public static zzabw zzb(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(3455);
    paramArrayOfByte = new zzabw(paramArrayOfByte, 0, paramInt2);
    AppMethodBeat.o(3455);
    return paramArrayOfByte;
  }
  
  public static int zzc(int paramInt, long paramLong)
  {
    AppMethodBeat.i(3467);
    paramInt = zzaq(paramInt);
    int i = zzao(paramLong);
    AppMethodBeat.o(3467);
    return paramInt + i;
  }
  
  public static int zzc(int paramInt, String paramString)
  {
    AppMethodBeat.i(3469);
    paramInt = zzaq(paramInt);
    int i = zzfm(paramString);
    AppMethodBeat.o(3469);
    return paramInt + i;
  }
  
  public static int zzf(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(3468);
    paramInt1 = zzaq(paramInt1);
    paramInt2 = zzao(paramInt2);
    AppMethodBeat.o(3468);
    return paramInt1 + paramInt2;
  }
  
  public static int zzfm(String paramString)
  {
    AppMethodBeat.i(3472);
    int i = zza(paramString);
    int j = zzas(i);
    AppMethodBeat.o(3472);
    return i + j;
  }
  
  public static zzabw zzj(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(3454);
    paramArrayOfByte = zzb(paramArrayOfByte, 0, paramArrayOfByte.length);
    AppMethodBeat.o(3454);
    return paramArrayOfByte;
  }
  
  public final void zza(int paramInt, double paramDouble)
  {
    AppMethodBeat.i(3456);
    zzg(paramInt, 1);
    long l = Double.doubleToLongBits(paramDouble);
    if (this.zzbwv.remaining() < 8)
    {
      zzabx localzzabx = new zzabx(this.zzbwv.position(), this.zzbwv.limit());
      AppMethodBeat.o(3456);
      throw localzzabx;
    }
    this.zzbwv.putLong(l);
    AppMethodBeat.o(3456);
  }
  
  public final void zza(int paramInt, float paramFloat)
  {
    AppMethodBeat.i(3457);
    zzg(paramInt, 5);
    paramInt = Float.floatToIntBits(paramFloat);
    if (this.zzbwv.remaining() < 4)
    {
      zzabx localzzabx = new zzabx(this.zzbwv.position(), this.zzbwv.limit());
      AppMethodBeat.o(3457);
      throw localzzabx;
    }
    this.zzbwv.putInt(paramInt);
    AppMethodBeat.o(3457);
  }
  
  public final void zza(int paramInt, long paramLong)
  {
    AppMethodBeat.i(3458);
    zzg(paramInt, 0);
    zzan(paramLong);
    AppMethodBeat.o(3458);
  }
  
  public final void zza(int paramInt, zzace paramzzace)
  {
    AppMethodBeat.i(3463);
    zzg(paramInt, 2);
    zzb(paramzzace);
    AppMethodBeat.o(3463);
  }
  
  public final void zza(int paramInt, boolean paramBoolean)
  {
    int i = 0;
    AppMethodBeat.i(3461);
    zzg(paramInt, 0);
    paramInt = i;
    if (paramBoolean) {
      paramInt = 1;
    }
    byte b = (byte)paramInt;
    if (!this.zzbwv.hasRemaining())
    {
      zzabx localzzabx = new zzabx(this.zzbwv.position(), this.zzbwv.limit());
      AppMethodBeat.o(3461);
      throw localzzabx;
    }
    this.zzbwv.put(b);
    AppMethodBeat.o(3461);
  }
  
  public final void zzar(int paramInt)
  {
    AppMethodBeat.i(3478);
    for (;;)
    {
      if ((paramInt & 0xFFFFFF80) == 0)
      {
        zzap(paramInt);
        AppMethodBeat.o(3478);
        return;
      }
      zzap(paramInt & 0x7F | 0x80);
      paramInt >>>= 7;
    }
  }
  
  public final void zzb(int paramInt, long paramLong)
  {
    AppMethodBeat.i(3459);
    zzg(paramInt, 0);
    zzan(paramLong);
    AppMethodBeat.o(3459);
  }
  
  public final void zzb(int paramInt, String paramString)
  {
    AppMethodBeat.i(3462);
    zzg(paramInt, 2);
    int i;
    try
    {
      paramInt = zzas(paramString.length());
      if (paramInt != zzas(paramString.length() * 3)) {
        break label182;
      }
      i = this.zzbwv.position();
      if (this.zzbwv.remaining() < paramInt)
      {
        paramString = new zzabx(paramInt + i, this.zzbwv.limit());
        AppMethodBeat.o(3462);
        throw paramString;
      }
    }
    catch (BufferOverflowException paramString)
    {
      zzabx localzzabx = new zzabx(this.zzbwv.position(), this.zzbwv.limit());
      localzzabx.initCause(paramString);
      AppMethodBeat.o(3462);
      throw localzzabx;
    }
    this.zzbwv.position(i + paramInt);
    zza(paramString, this.zzbwv);
    int j = this.zzbwv.position();
    this.zzbwv.position(i);
    zzar(j - i - paramInt);
    this.zzbwv.position(j);
    AppMethodBeat.o(3462);
    return;
    label182:
    zzar(zza(paramString));
    zza(paramString, this.zzbwv);
    AppMethodBeat.o(3462);
  }
  
  public final void zzb(zzace paramzzace)
  {
    AppMethodBeat.i(3466);
    zzar(paramzzace.zzvl());
    paramzzace.zza(this);
    AppMethodBeat.o(3466);
  }
  
  public final void zze(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(3460);
    zzg(paramInt1, 0);
    if (paramInt2 >= 0)
    {
      zzar(paramInt2);
      AppMethodBeat.o(3460);
      return;
    }
    zzan(paramInt2);
    AppMethodBeat.o(3460);
  }
  
  public final void zzg(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(3476);
    zzar(paramInt1 << 3 | paramInt2);
    AppMethodBeat.o(3476);
  }
  
  public final void zzk(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(3475);
    int i = paramArrayOfByte.length;
    if (this.zzbwv.remaining() >= i)
    {
      this.zzbwv.put(paramArrayOfByte, 0, i);
      AppMethodBeat.o(3475);
      return;
    }
    paramArrayOfByte = new zzabx(this.zzbwv.position(), this.zzbwv.limit());
    AppMethodBeat.o(3475);
    throw paramArrayOfByte;
  }
  
  public final void zzve()
  {
    AppMethodBeat.i(3473);
    if (this.zzbwv.remaining() != 0)
    {
      IllegalStateException localIllegalStateException = new IllegalStateException(String.format("Did not write as much data as expected, %s bytes remaining.", new Object[] { Integer.valueOf(this.zzbwv.remaining()) }));
      AppMethodBeat.o(3473);
      throw localIllegalStateException;
    }
    AppMethodBeat.o(3473);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.google.android.gms.internal.measurement.zzabw
 * JD-Core Version:    0.7.0.1
 */