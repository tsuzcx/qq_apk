package com.google.android.gms.internal;

import java.nio.BufferOverflowException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.ReadOnlyBufferException;

public final class zzbxm
{
  private final ByteBuffer zzcuz;
  
  private zzbxm(ByteBuffer paramByteBuffer)
  {
    this.zzcuz = paramByteBuffer;
    this.zzcuz.order(ByteOrder.LITTLE_ENDIAN);
  }
  
  private zzbxm(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    this(ByteBuffer.wrap(paramArrayOfByte, paramInt1, paramInt2));
  }
  
  public static int zzL(int paramInt1, int paramInt2)
  {
    return zzri(paramInt1) + zzrf(paramInt2);
  }
  
  public static int zzM(int paramInt1, int paramInt2)
  {
    return zzri(paramInt1) + zzrg(paramInt2);
  }
  
  private static int zza(CharSequence paramCharSequence, int paramInt)
  {
    int m = paramCharSequence.length();
    int i = 0;
    if (paramInt < m)
    {
      int n = paramCharSequence.charAt(paramInt);
      int j;
      if (n < 2048)
      {
        i += (127 - n >>> 31);
        j = paramInt;
      }
      for (;;)
      {
        paramInt = j + 1;
        break;
        int k = i + 2;
        i = k;
        j = paramInt;
        if (55296 <= n)
        {
          i = k;
          j = paramInt;
          if (n <= 57343)
          {
            if (Character.codePointAt(paramCharSequence, paramInt) < 65536) {
              throw new IllegalArgumentException(39 + "Unpaired surrogate at index " + paramInt);
            }
            j = paramInt + 1;
            i = k;
          }
        }
      }
    }
    return i;
  }
  
  private static int zza(CharSequence paramCharSequence, byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    int k = paramCharSequence.length();
    int j = 0;
    int m = paramInt1 + paramInt2;
    paramInt2 = j;
    while ((paramInt2 < k) && (paramInt2 + paramInt1 < m))
    {
      j = paramCharSequence.charAt(paramInt2);
      if (j >= 128) {
        break;
      }
      paramArrayOfByte[(paramInt1 + paramInt2)] = ((byte)j);
      paramInt2 += 1;
    }
    if (paramInt2 == k) {
      return paramInt1 + k;
    }
    paramInt1 += paramInt2;
    if (paramInt2 < k)
    {
      int i = paramCharSequence.charAt(paramInt2);
      if ((i < 128) && (paramInt1 < m))
      {
        j = paramInt1 + 1;
        paramArrayOfByte[paramInt1] = ((byte)i);
        paramInt1 = j;
      }
      for (;;)
      {
        paramInt2 += 1;
        break;
        if ((i < 2048) && (paramInt1 <= m - 2))
        {
          j = paramInt1 + 1;
          paramArrayOfByte[paramInt1] = ((byte)(i >>> 6 | 0x3C0));
          paramInt1 = j + 1;
          paramArrayOfByte[j] = ((byte)(i & 0x3F | 0x80));
        }
        else
        {
          int n;
          if (((i < 55296) || (57343 < i)) && (paramInt1 <= m - 3))
          {
            j = paramInt1 + 1;
            paramArrayOfByte[paramInt1] = ((byte)(i >>> 12 | 0x1E0));
            n = j + 1;
            paramArrayOfByte[j] = ((byte)(i >>> 6 & 0x3F | 0x80));
            paramInt1 = n + 1;
            paramArrayOfByte[n] = ((byte)(i & 0x3F | 0x80));
          }
          else
          {
            if (paramInt1 > m - 4) {
              break label444;
            }
            j = paramInt2;
            char c;
            if (paramInt2 + 1 != paramCharSequence.length())
            {
              paramInt2 += 1;
              c = paramCharSequence.charAt(paramInt2);
              if (!Character.isSurrogatePair(i, c)) {
                j = paramInt2;
              }
            }
            else
            {
              throw new IllegalArgumentException(39 + "Unpaired surrogate at index " + (j - 1));
            }
            j = Character.toCodePoint(i, c);
            n = paramInt1 + 1;
            paramArrayOfByte[paramInt1] = ((byte)(j >>> 18 | 0xF0));
            paramInt1 = n + 1;
            paramArrayOfByte[n] = ((byte)(j >>> 12 & 0x3F | 0x80));
            n = paramInt1 + 1;
            paramArrayOfByte[paramInt1] = ((byte)(j >>> 6 & 0x3F | 0x80));
            paramInt1 = n + 1;
            paramArrayOfByte[n] = ((byte)(j & 0x3F | 0x80));
          }
        }
      }
      label444:
      throw new ArrayIndexOutOfBoundsException(37 + "Failed writing " + i + " at index " + paramInt1);
    }
    return paramInt1;
  }
  
  private static void zza(CharSequence paramCharSequence, ByteBuffer paramByteBuffer)
  {
    if (paramByteBuffer.isReadOnly()) {
      throw new ReadOnlyBufferException();
    }
    if (paramByteBuffer.hasArray()) {
      try
      {
        paramByteBuffer.position(zza(paramCharSequence, paramByteBuffer.array(), paramByteBuffer.arrayOffset() + paramByteBuffer.position(), paramByteBuffer.remaining()) - paramByteBuffer.arrayOffset());
        return;
      }
      catch (ArrayIndexOutOfBoundsException paramCharSequence)
      {
        paramByteBuffer = new BufferOverflowException();
        paramByteBuffer.initCause(paramCharSequence);
        throw paramByteBuffer;
      }
    }
    zzb(paramCharSequence, paramByteBuffer);
  }
  
  public static zzbxm zzag(byte[] paramArrayOfByte)
  {
    return zzc(paramArrayOfByte, 0, paramArrayOfByte.length);
  }
  
  public static int zzai(byte[] paramArrayOfByte)
  {
    return zzrk(paramArrayOfByte.length) + paramArrayOfByte.length;
  }
  
  public static int zzb(int paramInt, double paramDouble)
  {
    return zzri(paramInt) + 8;
  }
  
  public static int zzb(int paramInt, zzbxt paramzzbxt)
  {
    return zzri(paramInt) * 2 + zzd(paramzzbxt);
  }
  
  private static int zzb(CharSequence paramCharSequence)
  {
    int m = paramCharSequence.length();
    int j = 0;
    while ((j < m) && (paramCharSequence.charAt(j) < '')) {
      j += 1;
    }
    for (;;)
    {
      int i;
      int k = i;
      if (j < m)
      {
        k = paramCharSequence.charAt(j);
        if (k < 2048)
        {
          i += (127 - k >>> 31);
          j += 1;
        }
        else
        {
          k = i + zza(paramCharSequence, j);
        }
      }
      else
      {
        if (k < m)
        {
          long l = k;
          throw new IllegalArgumentException(54 + "UTF-8 length does not fit in int: " + (l + 4294967296L));
        }
        return k;
        i = m;
      }
    }
  }
  
  private static void zzb(CharSequence paramCharSequence, ByteBuffer paramByteBuffer)
  {
    int m = paramCharSequence.length();
    int j = 0;
    if (j < m)
    {
      int i = paramCharSequence.charAt(j);
      if (i < 128) {
        paramByteBuffer.put((byte)i);
      }
      for (;;)
      {
        j += 1;
        break;
        if (i < 2048)
        {
          paramByteBuffer.put((byte)(i >>> 6 | 0x3C0));
          paramByteBuffer.put((byte)(i & 0x3F | 0x80));
        }
        else if ((i < 55296) || (57343 < i))
        {
          paramByteBuffer.put((byte)(i >>> 12 | 0x1E0));
          paramByteBuffer.put((byte)(i >>> 6 & 0x3F | 0x80));
          paramByteBuffer.put((byte)(i & 0x3F | 0x80));
        }
        else
        {
          int k = j;
          char c;
          if (j + 1 != paramCharSequence.length())
          {
            j += 1;
            c = paramCharSequence.charAt(j);
            if (!Character.isSurrogatePair(i, c)) {
              k = j;
            }
          }
          else
          {
            throw new IllegalArgumentException(39 + "Unpaired surrogate at index " + (k - 1));
          }
          k = Character.toCodePoint(i, c);
          paramByteBuffer.put((byte)(k >>> 18 | 0xF0));
          paramByteBuffer.put((byte)(k >>> 12 & 0x3F | 0x80));
          paramByteBuffer.put((byte)(k >>> 6 & 0x3F | 0x80));
          paramByteBuffer.put((byte)(k & 0x3F | 0x80));
        }
      }
    }
  }
  
  public static int zzbe(long paramLong)
  {
    return zzbi(paramLong);
  }
  
  public static int zzbf(long paramLong)
  {
    return zzbi(paramLong);
  }
  
  public static int zzbg(long paramLong)
  {
    return zzbi(zzbk(paramLong));
  }
  
  public static int zzbi(long paramLong)
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
  
  public static long zzbk(long paramLong)
  {
    return paramLong << 1 ^ paramLong >> 63;
  }
  
  public static int zzc(int paramInt, zzbxt paramzzbxt)
  {
    return zzri(paramInt) + zze(paramzzbxt);
  }
  
  public static int zzc(int paramInt, byte[] paramArrayOfByte)
  {
    return zzri(paramInt) + zzai(paramArrayOfByte);
  }
  
  public static zzbxm zzc(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    return new zzbxm(paramArrayOfByte, paramInt1, paramInt2);
  }
  
  public static int zzd(int paramInt, float paramFloat)
  {
    return zzri(paramInt) + 4;
  }
  
  public static int zzd(zzbxt paramzzbxt)
  {
    return paramzzbxt.zzaeS();
  }
  
  public static int zze(int paramInt, long paramLong)
  {
    return zzri(paramInt) + zzbe(paramLong);
  }
  
  public static int zze(zzbxt paramzzbxt)
  {
    int i = paramzzbxt.zzaeS();
    return i + zzrk(i);
  }
  
  public static int zzf(int paramInt, long paramLong)
  {
    return zzri(paramInt) + zzbf(paramLong);
  }
  
  public static int zzg(int paramInt, long paramLong)
  {
    return zzri(paramInt) + 8;
  }
  
  public static int zzh(int paramInt, long paramLong)
  {
    return zzri(paramInt) + zzbg(paramLong);
  }
  
  public static int zzh(int paramInt, boolean paramBoolean)
  {
    return zzri(paramInt) + 1;
  }
  
  public static int zzkb(String paramString)
  {
    int i = zzb(paramString);
    return i + zzrk(i);
  }
  
  public static int zzr(int paramInt, String paramString)
  {
    return zzri(paramInt) + zzkb(paramString);
  }
  
  public static int zzrf(int paramInt)
  {
    if (paramInt >= 0) {
      return zzrk(paramInt);
    }
    return 10;
  }
  
  public static int zzrg(int paramInt)
  {
    return zzrk(zzrm(paramInt));
  }
  
  public static int zzri(int paramInt)
  {
    return zzrk(zzbxw.zzO(paramInt, 0));
  }
  
  public static int zzrk(int paramInt)
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
  
  public static int zzrm(int paramInt)
  {
    return paramInt << 1 ^ paramInt >> 31;
  }
  
  public final void zzJ(int paramInt1, int paramInt2)
  {
    zzN(paramInt1, 0);
    zzrd(paramInt2);
  }
  
  public final void zzK(int paramInt1, int paramInt2)
  {
    zzN(paramInt1, 0);
    zzre(paramInt2);
  }
  
  public final void zzN(int paramInt1, int paramInt2)
  {
    zzrj(zzbxw.zzO(paramInt1, paramInt2));
  }
  
  public final void zza(int paramInt, double paramDouble)
  {
    zzN(paramInt, 1);
    zzn(paramDouble);
  }
  
  public final void zza(int paramInt, long paramLong)
  {
    zzN(paramInt, 0);
    zzba(paramLong);
  }
  
  public final void zza(int paramInt, zzbxt paramzzbxt)
  {
    zzN(paramInt, 2);
    zzc(paramzzbxt);
  }
  
  public final int zzaeE()
  {
    return this.zzcuz.remaining();
  }
  
  public final void zzaeF()
  {
    if (zzaeE() != 0) {
      throw new IllegalStateException("Did not write as much data as expected.");
    }
  }
  
  public final void zzah(byte[] paramArrayOfByte)
  {
    zzrj(paramArrayOfByte.length);
    zzaj(paramArrayOfByte);
  }
  
  public final void zzaj(byte[] paramArrayOfByte)
  {
    zzd(paramArrayOfByte, 0, paramArrayOfByte.length);
  }
  
  public final void zzb(int paramInt, long paramLong)
  {
    zzN(paramInt, 0);
    zzbb(paramLong);
  }
  
  public final void zzb(int paramInt, byte[] paramArrayOfByte)
  {
    zzN(paramInt, 2);
    zzah(paramArrayOfByte);
  }
  
  public final void zzb(zzbxt paramzzbxt)
  {
    paramzzbxt.zza(this);
  }
  
  public final void zzba(long paramLong)
  {
    zzbh(paramLong);
  }
  
  public final void zzbb(long paramLong)
  {
    zzbh(paramLong);
  }
  
  public final void zzbc(long paramLong)
  {
    zzbj(paramLong);
  }
  
  public final void zzbd(long paramLong)
  {
    zzbh(zzbk(paramLong));
  }
  
  public final void zzbh(long paramLong)
  {
    for (;;)
    {
      if ((0xFFFFFF80 & paramLong) == 0L)
      {
        zzrh((int)paramLong);
        return;
      }
      zzrh((int)paramLong & 0x7F | 0x80);
      paramLong >>>= 7;
    }
  }
  
  public final void zzbj(long paramLong)
  {
    if (this.zzcuz.remaining() < 8) {
      throw new zzbxm.zza(this.zzcuz.position(), this.zzcuz.limit());
    }
    this.zzcuz.putLong(paramLong);
  }
  
  public final void zzbq(boolean paramBoolean)
  {
    if (paramBoolean) {}
    for (int i = 1;; i = 0)
    {
      zzrh(i);
      return;
    }
  }
  
  public final void zzc(byte paramByte)
  {
    if (!this.zzcuz.hasRemaining()) {
      throw new zzbxm.zza(this.zzcuz.position(), this.zzcuz.limit());
    }
    this.zzcuz.put(paramByte);
  }
  
  public final void zzc(int paramInt, float paramFloat)
  {
    zzN(paramInt, 5);
    zzk(paramFloat);
  }
  
  public final void zzc(int paramInt, long paramLong)
  {
    zzN(paramInt, 1);
    zzbc(paramLong);
  }
  
  public final void zzc(zzbxt paramzzbxt)
  {
    zzrj(paramzzbxt.zzaeR());
    paramzzbxt.zza(this);
  }
  
  public final void zzd(int paramInt, long paramLong)
  {
    zzN(paramInt, 0);
    zzbd(paramLong);
  }
  
  public final void zzd(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    if (this.zzcuz.remaining() >= paramInt2)
    {
      this.zzcuz.put(paramArrayOfByte, paramInt1, paramInt2);
      return;
    }
    throw new zzbxm.zza(this.zzcuz.position(), this.zzcuz.limit());
  }
  
  public final void zzg(int paramInt, boolean paramBoolean)
  {
    zzN(paramInt, 0);
    zzbq(paramBoolean);
  }
  
  public final void zzk(float paramFloat)
  {
    zzrl(Float.floatToIntBits(paramFloat));
  }
  
  public final void zzka(String paramString)
  {
    int i;
    int j;
    try
    {
      i = zzrk(paramString.length());
      if (i != zzrk(paramString.length() * 3)) {
        break label150;
      }
      j = this.zzcuz.position();
      if (this.zzcuz.remaining() < i) {
        throw new zzbxm.zza(i + j, this.zzcuz.limit());
      }
    }
    catch (BufferOverflowException paramString)
    {
      zzbxm.zza localzza = new zzbxm.zza(this.zzcuz.position(), this.zzcuz.limit());
      localzza.initCause(paramString);
      throw localzza;
    }
    this.zzcuz.position(j + i);
    zza(paramString, this.zzcuz);
    int k = this.zzcuz.position();
    this.zzcuz.position(j);
    zzrj(k - j - i);
    this.zzcuz.position(k);
    return;
    label150:
    zzrj(zzb(paramString));
    zza(paramString, this.zzcuz);
  }
  
  public final void zzn(double paramDouble)
  {
    zzbj(Double.doubleToLongBits(paramDouble));
  }
  
  public final void zzq(int paramInt, String paramString)
  {
    zzN(paramInt, 2);
    zzka(paramString);
  }
  
  public final void zzrd(int paramInt)
  {
    if (paramInt >= 0)
    {
      zzrj(paramInt);
      return;
    }
    zzbh(paramInt);
  }
  
  public final void zzre(int paramInt)
  {
    zzrj(zzrm(paramInt));
  }
  
  public final void zzrh(int paramInt)
  {
    zzc((byte)paramInt);
  }
  
  public final void zzrj(int paramInt)
  {
    for (;;)
    {
      if ((paramInt & 0xFFFFFF80) == 0)
      {
        zzrh(paramInt);
        return;
      }
      zzrh(paramInt & 0x7F | 0x80);
      paramInt >>>= 7;
    }
  }
  
  public final void zzrl(int paramInt)
  {
    if (this.zzcuz.remaining() < 4) {
      throw new zzbxm.zza(this.zzcuz.position(), this.zzcuz.limit());
    }
    this.zzcuz.putInt(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.google.android.gms.internal.zzbxm
 * JD-Core Version:    0.7.0.1
 */