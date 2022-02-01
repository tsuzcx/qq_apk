package com.google.android.gms.internal.wearable;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class zzk
{
  private final byte[] buffer;
  private final int zzgr;
  private final int zzgs;
  private int zzgt;
  private int zzgu;
  private int zzgv;
  private int zzgw;
  private int zzgx;
  private int zzgy;
  private int zzgz;
  private int zzha;
  
  private zzk(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(100698);
    this.zzgx = 2147483647;
    this.zzgz = 64;
    this.zzha = 67108864;
    this.buffer = paramArrayOfByte;
    this.zzgr = paramInt1;
    paramInt2 = paramInt1 + paramInt2;
    this.zzgt = paramInt2;
    this.zzgs = paramInt2;
    this.zzgv = paramInt1;
    AppMethodBeat.o(100698);
  }
  
  public static zzk zza(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(100687);
    paramArrayOfByte = new zzk(paramArrayOfByte, 0, paramInt2);
    AppMethodBeat.o(100687);
    return paramArrayOfByte;
  }
  
  private final void zzh(int paramInt)
  {
    AppMethodBeat.i(100705);
    if (paramInt < 0)
    {
      localzzs = zzs.zzv();
      AppMethodBeat.o(100705);
      throw localzzs;
    }
    if (this.zzgv + paramInt > this.zzgx)
    {
      zzh(this.zzgx - this.zzgv);
      localzzs = zzs.zzu();
      AppMethodBeat.o(100705);
      throw localzzs;
    }
    if (paramInt <= this.zzgt - this.zzgv)
    {
      this.zzgv += paramInt;
      AppMethodBeat.o(100705);
      return;
    }
    zzs localzzs = zzs.zzu();
    AppMethodBeat.o(100705);
    throw localzzs;
  }
  
  private final void zzo()
  {
    this.zzgt += this.zzgu;
    int i = this.zzgt;
    if (i > this.zzgx)
    {
      this.zzgu = (i - this.zzgx);
      this.zzgt -= this.zzgu;
      return;
    }
    this.zzgu = 0;
  }
  
  private final byte zzq()
  {
    AppMethodBeat.i(100704);
    if (this.zzgv == this.zzgt)
    {
      localObject = zzs.zzu();
      AppMethodBeat.o(100704);
      throw ((Throwable)localObject);
    }
    Object localObject = this.buffer;
    int i = this.zzgv;
    this.zzgv = (i + 1);
    byte b = localObject[i];
    AppMethodBeat.o(100704);
    return b;
  }
  
  public final int getPosition()
  {
    return this.zzgv - this.zzgr;
  }
  
  public final byte[] readBytes()
  {
    AppMethodBeat.i(100693);
    int i = zzk();
    if (i < 0)
    {
      localObject = zzs.zzv();
      AppMethodBeat.o(100693);
      throw ((Throwable)localObject);
    }
    if (i == 0)
    {
      localObject = zzw.zzhy;
      AppMethodBeat.o(100693);
      return localObject;
    }
    if (i > this.zzgt - this.zzgv)
    {
      localObject = zzs.zzu();
      AppMethodBeat.o(100693);
      throw ((Throwable)localObject);
    }
    Object localObject = new byte[i];
    System.arraycopy(this.buffer, this.zzgv, localObject, 0, i);
    this.zzgv = (i + this.zzgv);
    AppMethodBeat.o(100693);
    return localObject;
  }
  
  public final String readString()
  {
    AppMethodBeat.i(100691);
    int i = zzk();
    if (i < 0)
    {
      localObject = zzs.zzv();
      AppMethodBeat.o(100691);
      throw ((Throwable)localObject);
    }
    if (i > this.zzgt - this.zzgv)
    {
      localObject = zzs.zzu();
      AppMethodBeat.o(100691);
      throw ((Throwable)localObject);
    }
    Object localObject = new String(this.buffer, this.zzgv, i, zzr.UTF_8);
    this.zzgv = (i + this.zzgv);
    AppMethodBeat.o(100691);
    return localObject;
  }
  
  public final void zza(zzt paramzzt)
  {
    AppMethodBeat.i(100692);
    int i = zzk();
    if (this.zzgy >= this.zzgz)
    {
      paramzzt = new zzs("Protocol message had too many levels of nesting.  May be malicious.  Use CodedInputStream.setRecursionLimit() to increase the depth limit.");
      AppMethodBeat.o(100692);
      throw paramzzt;
    }
    i = zze(i);
    this.zzgy += 1;
    paramzzt.zza(this);
    zzc(0);
    this.zzgy -= 1;
    zzf(i);
    AppMethodBeat.o(100692);
  }
  
  public final byte[] zzb(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(100701);
    if (paramInt2 == 0)
    {
      arrayOfByte = zzw.zzhy;
      AppMethodBeat.o(100701);
      return arrayOfByte;
    }
    byte[] arrayOfByte = new byte[paramInt2];
    int i = this.zzgr;
    System.arraycopy(this.buffer, i + paramInt1, arrayOfByte, 0, paramInt2);
    AppMethodBeat.o(100701);
    return arrayOfByte;
  }
  
  public final void zzc(int paramInt)
  {
    AppMethodBeat.i(100689);
    if (this.zzgw != paramInt)
    {
      zzs localzzs = new zzs("Protocol message end-group tag did not match expected tag.");
      AppMethodBeat.o(100689);
      throw localzzs;
    }
    AppMethodBeat.o(100689);
  }
  
  final void zzc(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(100703);
    IllegalArgumentException localIllegalArgumentException;
    if (paramInt1 > this.zzgv - this.zzgr)
    {
      paramInt2 = this.zzgv;
      int i = this.zzgr;
      localIllegalArgumentException = new IllegalArgumentException(50 + "Position " + paramInt1 + " is beyond current " + (paramInt2 - i));
      AppMethodBeat.o(100703);
      throw localIllegalArgumentException;
    }
    if (paramInt1 < 0)
    {
      localIllegalArgumentException = new IllegalArgumentException(24 + "Bad position " + paramInt1);
      AppMethodBeat.o(100703);
      throw localIllegalArgumentException;
    }
    this.zzgv = (this.zzgr + paramInt1);
    this.zzgw = paramInt2;
    AppMethodBeat.o(100703);
  }
  
  public final boolean zzd(int paramInt)
  {
    AppMethodBeat.i(100690);
    switch (paramInt & 0x7)
    {
    default: 
      zzs localzzs = new zzs("Protocol message tag had invalid wire type.");
      AppMethodBeat.o(100690);
      throw localzzs;
    case 0: 
      zzk();
      AppMethodBeat.o(100690);
      return true;
    case 1: 
      zzn();
      AppMethodBeat.o(100690);
      return true;
    case 2: 
      zzh(zzk());
      AppMethodBeat.o(100690);
      return true;
    case 3: 
      int i;
      do
      {
        i = zzj();
      } while ((i != 0) && (zzd(i)));
      zzc(paramInt >>> 3 << 3 | 0x4);
      AppMethodBeat.o(100690);
      return true;
    case 4: 
      AppMethodBeat.o(100690);
      return false;
    }
    zzm();
    AppMethodBeat.o(100690);
    return true;
  }
  
  public final int zze(int paramInt)
  {
    AppMethodBeat.i(100699);
    zzs localzzs;
    if (paramInt < 0)
    {
      localzzs = zzs.zzv();
      AppMethodBeat.o(100699);
      throw localzzs;
    }
    paramInt = this.zzgv + paramInt;
    int i = this.zzgx;
    if (paramInt > i)
    {
      localzzs = zzs.zzu();
      AppMethodBeat.o(100699);
      throw localzzs;
    }
    this.zzgx = paramInt;
    zzo();
    AppMethodBeat.o(100699);
    return i;
  }
  
  public final void zzf(int paramInt)
  {
    AppMethodBeat.i(100700);
    this.zzgx = paramInt;
    zzo();
    AppMethodBeat.o(100700);
  }
  
  public final void zzg(int paramInt)
  {
    AppMethodBeat.i(100702);
    zzc(paramInt, this.zzgw);
    AppMethodBeat.o(100702);
  }
  
  public final int zzj()
  {
    AppMethodBeat.i(100688);
    if (this.zzgv == this.zzgt)
    {
      this.zzgw = 0;
      AppMethodBeat.o(100688);
      return 0;
    }
    this.zzgw = zzk();
    if (this.zzgw == 0)
    {
      zzs localzzs = new zzs("Protocol message contained an invalid tag (zero).");
      AppMethodBeat.o(100688);
      throw localzzs;
    }
    int i = this.zzgw;
    AppMethodBeat.o(100688);
    return i;
  }
  
  public final int zzk()
  {
    AppMethodBeat.i(100694);
    int i = zzq();
    if (i >= 0)
    {
      AppMethodBeat.o(100694);
      return i;
    }
    i &= 0x7F;
    int j = zzq();
    if (j >= 0) {
      i |= j << 7;
    }
    int k;
    do
    {
      for (;;)
      {
        AppMethodBeat.o(100694);
        return i;
        i |= (j & 0x7F) << 7;
        j = zzq();
        if (j >= 0)
        {
          i |= j << 14;
        }
        else
        {
          i |= (j & 0x7F) << 14;
          j = zzq();
          if (j < 0) {
            break;
          }
          i |= j << 21;
        }
      }
      k = zzq();
      j = i | (j & 0x7F) << 21 | k << 28;
      i = j;
    } while (k >= 0);
    i = 0;
    while (i < 5)
    {
      if (zzq() >= 0)
      {
        AppMethodBeat.o(100694);
        return j;
      }
      i += 1;
    }
    zzs localzzs = zzs.zzw();
    AppMethodBeat.o(100694);
    throw localzzs;
  }
  
  public final long zzl()
  {
    AppMethodBeat.i(100695);
    int i = 0;
    long l = 0L;
    while (i < 64)
    {
      int j = zzq();
      l |= (j & 0x7F) << i;
      if ((j & 0x80) == 0)
      {
        AppMethodBeat.o(100695);
        return l;
      }
      i += 7;
    }
    zzs localzzs = zzs.zzw();
    AppMethodBeat.o(100695);
    throw localzzs;
  }
  
  public final int zzm()
  {
    AppMethodBeat.i(100696);
    int i = zzq();
    int j = zzq();
    int k = zzq();
    int m = zzq();
    AppMethodBeat.o(100696);
    return i & 0xFF | (j & 0xFF) << 8 | (k & 0xFF) << 16 | (m & 0xFF) << 24;
  }
  
  public final long zzn()
  {
    AppMethodBeat.i(100697);
    int i = zzq();
    int j = zzq();
    int k = zzq();
    int m = zzq();
    int n = zzq();
    int i1 = zzq();
    int i2 = zzq();
    int i3 = zzq();
    long l1 = i;
    long l2 = j;
    long l3 = k;
    long l4 = m;
    long l5 = n;
    long l6 = i1;
    long l7 = i2;
    long l8 = i3;
    AppMethodBeat.o(100697);
    return (l2 & 0xFF) << 8 | l1 & 0xFF | (l3 & 0xFF) << 16 | (l4 & 0xFF) << 24 | (l5 & 0xFF) << 32 | (l6 & 0xFF) << 40 | (l7 & 0xFF) << 48 | (l8 & 0xFF) << 56;
  }
  
  public final int zzp()
  {
    if (this.zzgx == 2147483647) {
      return -1;
    }
    int i = this.zzgv;
    return this.zzgx - i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.google.android.gms.internal.wearable.zzk
 * JD-Core Version:    0.7.0.1
 */