package com.google.android.gms.internal.wearable;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.nio.BufferOverflowException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.ReadOnlyBufferException;

public final class zzl
{
  private final ByteBuffer zzhb;
  
  private zzl(ByteBuffer paramByteBuffer)
  {
    AppMethodBeat.i(70724);
    this.zzhb = paramByteBuffer;
    this.zzhb.order(ByteOrder.LITTLE_ENDIAN);
    AppMethodBeat.o(70724);
  }
  
  private zzl(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    this(ByteBuffer.wrap(paramArrayOfByte, paramInt1, paramInt2));
    AppMethodBeat.i(70723);
    AppMethodBeat.o(70723);
  }
  
  private static int zza(CharSequence paramCharSequence)
  {
    int k = 0;
    AppMethodBeat.i(70732);
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
                    AppMethodBeat.o(70732);
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
            AppMethodBeat.o(70732);
            throw paramCharSequence;
          }
          AppMethodBeat.o(70732);
          return i;
        }
        i = n;
      }
    }
  }
  
  private final void zza(long paramLong)
  {
    AppMethodBeat.i(70747);
    for (;;)
    {
      if ((0xFFFFFF80 & paramLong) == 0L)
      {
        zzj((int)paramLong);
        AppMethodBeat.o(70747);
        return;
      }
      zzj((int)paramLong & 0x7F | 0x80);
      paramLong >>>= 7;
    }
  }
  
  private static void zza(CharSequence paramCharSequence, ByteBuffer paramByteBuffer)
  {
    int m = 0;
    AppMethodBeat.i(70733);
    if (paramByteBuffer.isReadOnly())
    {
      paramCharSequence = new ReadOnlyBufferException();
      AppMethodBeat.o(70733);
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
        AppMethodBeat.o(70733);
        return;
      }
      catch (ArrayIndexOutOfBoundsException paramCharSequence)
      {
        label155:
        paramByteBuffer = new BufferOverflowException();
        paramByteBuffer.initCause(paramCharSequence);
        AppMethodBeat.o(70733);
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
              AppMethodBeat.o(70733);
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
            AppMethodBeat.o(70733);
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
                AppMethodBeat.o(70733);
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
        AppMethodBeat.o(70733);
        return;
        if (n != i2) {
          break label155;
        }
        m += i2;
        break;
      }
      n += 1;
    }
  }
  
  public static int zzb(int paramInt, long paramLong)
  {
    AppMethodBeat.i(70734);
    int i = zzk(paramInt);
    if ((0xFFFFFF80 & paramLong) == 0L) {
      paramInt = 1;
    }
    for (;;)
    {
      AppMethodBeat.o(70734);
      return paramInt + i;
      if ((0xFFFFC000 & paramLong) == 0L) {
        paramInt = 2;
      } else if ((0xFFE00000 & paramLong) == 0L) {
        paramInt = 3;
      } else if ((0xF0000000 & paramLong) == 0L) {
        paramInt = 4;
      } else if ((0x0 & paramLong) == 0L) {
        paramInt = 5;
      } else if ((0x0 & paramLong) == 0L) {
        paramInt = 6;
      } else if ((0x0 & paramLong) == 0L) {
        paramInt = 7;
      } else if ((0x0 & paramLong) == 0L) {
        paramInt = 8;
      } else if ((0x0 & paramLong) == 0L) {
        paramInt = 9;
      } else {
        paramInt = 10;
      }
    }
  }
  
  public static int zzb(int paramInt, zzt paramzzt)
  {
    AppMethodBeat.i(70737);
    paramInt = zzk(paramInt);
    int i = paramzzt.zzx();
    int j = zzm(i);
    AppMethodBeat.o(70737);
    return paramInt + (i + j);
  }
  
  public static int zzb(int paramInt, String paramString)
  {
    AppMethodBeat.i(70736);
    paramInt = zzk(paramInt);
    int i = zzg(paramString);
    AppMethodBeat.o(70736);
    return paramInt + i;
  }
  
  public static zzl zzb(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(70725);
    paramArrayOfByte = zzb(paramArrayOfByte, 0, paramArrayOfByte.length);
    AppMethodBeat.o(70725);
    return paramArrayOfByte;
  }
  
  public static zzl zzb(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(70726);
    paramArrayOfByte = new zzl(paramArrayOfByte, 0, paramInt2);
    AppMethodBeat.o(70726);
    return paramArrayOfByte;
  }
  
  public static int zze(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(70735);
    paramInt1 = zzk(paramInt1);
    paramInt2 = zzi(paramInt2);
    AppMethodBeat.o(70735);
    return paramInt1 + paramInt2;
  }
  
  public static int zzg(String paramString)
  {
    AppMethodBeat.i(70739);
    int i = zza(paramString);
    int j = zzm(i);
    AppMethodBeat.o(70739);
    return i + j;
  }
  
  public static int zzi(int paramInt)
  {
    AppMethodBeat.i(70738);
    if (paramInt >= 0)
    {
      paramInt = zzm(paramInt);
      AppMethodBeat.o(70738);
      return paramInt;
    }
    AppMethodBeat.o(70738);
    return 10;
  }
  
  private final void zzj(int paramInt)
  {
    AppMethodBeat.i(70742);
    byte b = (byte)paramInt;
    if (!this.zzhb.hasRemaining())
    {
      zzm localzzm = new zzm(this.zzhb.position(), this.zzhb.limit());
      AppMethodBeat.o(70742);
      throw localzzm;
    }
    this.zzhb.put(b);
    AppMethodBeat.o(70742);
  }
  
  public static int zzk(int paramInt)
  {
    AppMethodBeat.i(70745);
    paramInt = zzm(paramInt << 3);
    AppMethodBeat.o(70745);
    return paramInt;
  }
  
  public static int zzm(int paramInt)
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
  
  public static int zzn(int paramInt)
  {
    return paramInt << 1 ^ paramInt >> 31;
  }
  
  public final void zza(byte paramByte)
  {
    AppMethodBeat.i(70741);
    if (!this.zzhb.hasRemaining())
    {
      zzm localzzm = new zzm(this.zzhb.position(), this.zzhb.limit());
      AppMethodBeat.o(70741);
      throw localzzm;
    }
    this.zzhb.put(paramByte);
    AppMethodBeat.o(70741);
  }
  
  public final void zza(int paramInt, float paramFloat)
  {
    AppMethodBeat.i(70727);
    zzf(paramInt, 5);
    paramInt = Float.floatToIntBits(paramFloat);
    if (this.zzhb.remaining() < 4)
    {
      zzm localzzm = new zzm(this.zzhb.position(), this.zzhb.limit());
      AppMethodBeat.o(70727);
      throw localzzm;
    }
    this.zzhb.putInt(paramInt);
    AppMethodBeat.o(70727);
  }
  
  public final void zza(int paramInt, long paramLong)
  {
    AppMethodBeat.i(70728);
    zzf(paramInt, 0);
    zza(paramLong);
    AppMethodBeat.o(70728);
  }
  
  public final void zza(int paramInt, zzt paramzzt)
  {
    AppMethodBeat.i(70731);
    zzf(paramInt, 2);
    if (paramzzt.zzhl < 0) {
      paramzzt.zzx();
    }
    zzl(paramzzt.zzhl);
    paramzzt.zza(this);
    AppMethodBeat.o(70731);
  }
  
  public final void zza(int paramInt, String paramString)
  {
    AppMethodBeat.i(70730);
    zzf(paramInt, 2);
    int i;
    try
    {
      paramInt = zzm(paramString.length());
      if (paramInt != zzm(paramString.length() * 3)) {
        break label182;
      }
      i = this.zzhb.position();
      if (this.zzhb.remaining() < paramInt)
      {
        paramString = new zzm(paramInt + i, this.zzhb.limit());
        AppMethodBeat.o(70730);
        throw paramString;
      }
    }
    catch (BufferOverflowException paramString)
    {
      zzm localzzm = new zzm(this.zzhb.position(), this.zzhb.limit());
      localzzm.initCause(paramString);
      AppMethodBeat.o(70730);
      throw localzzm;
    }
    this.zzhb.position(i + paramInt);
    zza(paramString, this.zzhb);
    int j = this.zzhb.position();
    this.zzhb.position(i);
    zzl(j - i - paramInt);
    this.zzhb.position(j);
    AppMethodBeat.o(70730);
    return;
    label182:
    zzl(zza(paramString));
    zza(paramString, this.zzhb);
    AppMethodBeat.o(70730);
  }
  
  public final void zzb(long paramLong)
  {
    AppMethodBeat.i(70748);
    if (this.zzhb.remaining() < 8)
    {
      zzm localzzm = new zzm(this.zzhb.position(), this.zzhb.limit());
      AppMethodBeat.o(70748);
      throw localzzm;
    }
    this.zzhb.putLong(paramLong);
    AppMethodBeat.o(70748);
  }
  
  public final void zzc(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(70743);
    int i = paramArrayOfByte.length;
    if (this.zzhb.remaining() >= i)
    {
      this.zzhb.put(paramArrayOfByte, 0, i);
      AppMethodBeat.o(70743);
      return;
    }
    paramArrayOfByte = new zzm(this.zzhb.position(), this.zzhb.limit());
    AppMethodBeat.o(70743);
    throw paramArrayOfByte;
  }
  
  public final void zzd(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(70729);
    zzf(paramInt1, 0);
    if (paramInt2 >= 0)
    {
      zzl(paramInt2);
      AppMethodBeat.o(70729);
      return;
    }
    zza(paramInt2);
    AppMethodBeat.o(70729);
  }
  
  public final void zzf(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(70744);
    zzl(paramInt1 << 3 | paramInt2);
    AppMethodBeat.o(70744);
  }
  
  public final void zzl(int paramInt)
  {
    AppMethodBeat.i(70746);
    for (;;)
    {
      if ((paramInt & 0xFFFFFF80) == 0)
      {
        zzj(paramInt);
        AppMethodBeat.o(70746);
        return;
      }
      zzj(paramInt & 0x7F | 0x80);
      paramInt >>>= 7;
    }
  }
  
  public final void zzr()
  {
    AppMethodBeat.i(70740);
    if (this.zzhb.remaining() != 0)
    {
      IllegalStateException localIllegalStateException = new IllegalStateException(String.format("Did not write as much data as expected, %s bytes remaining.", new Object[] { Integer.valueOf(this.zzhb.remaining()) }));
      AppMethodBeat.o(70740);
      throw localIllegalStateException;
    }
    AppMethodBeat.o(70740);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.google.android.gms.internal.wearable.zzl
 * JD-Core Version:    0.7.0.1
 */