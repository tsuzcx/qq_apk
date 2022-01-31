package com.google.android.gms.internal.measurement;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class zzabv
{
  private final byte[] buffer;
  private int zzbrd;
  private int zzbre;
  private int zzbri;
  private int zzbrk;
  private final int zzbwp;
  private final int zzbwq;
  private int zzbwr;
  private int zzbws;
  private int zzbwt;
  private int zzbwu;
  
  private zzabv(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(3444);
    this.zzbrk = 2147483647;
    this.zzbrd = 64;
    this.zzbre = 67108864;
    this.buffer = paramArrayOfByte;
    this.zzbwp = paramInt1;
    paramInt2 = paramInt1 + paramInt2;
    this.zzbwr = paramInt2;
    this.zzbwq = paramInt2;
    this.zzbws = paramInt1;
    AppMethodBeat.o(3444);
  }
  
  public static zzabv zza(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(3432);
    paramArrayOfByte = new zzabv(paramArrayOfByte, 0, paramInt2);
    AppMethodBeat.o(3432);
    return paramArrayOfByte;
  }
  
  private final void zzan(int paramInt)
  {
    AppMethodBeat.i(3451);
    if (paramInt < 0)
    {
      localzzacd = zzacd.zzvi();
      AppMethodBeat.o(3451);
      throw localzzacd;
    }
    if (this.zzbws + paramInt > this.zzbrk)
    {
      zzan(this.zzbrk - this.zzbws);
      localzzacd = zzacd.zzvh();
      AppMethodBeat.o(3451);
      throw localzzacd;
    }
    if (paramInt <= this.zzbwr - this.zzbws)
    {
      this.zzbws += paramInt;
      AppMethodBeat.o(3451);
      return;
    }
    zzacd localzzacd = zzacd.zzvh();
    AppMethodBeat.o(3451);
    throw localzzacd;
  }
  
  public static zzabv zzi(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(3431);
    paramArrayOfByte = zza(paramArrayOfByte, 0, paramArrayOfByte.length);
    AppMethodBeat.o(3431);
    return paramArrayOfByte;
  }
  
  private final void zzta()
  {
    this.zzbwr += this.zzbri;
    int i = this.zzbwr;
    if (i > this.zzbrk)
    {
      this.zzbri = (i - this.zzbrk);
      this.zzbwr -= this.zzbri;
      return;
    }
    this.zzbri = 0;
  }
  
  private final byte zzvd()
  {
    AppMethodBeat.i(3450);
    if (this.zzbws == this.zzbwr)
    {
      localObject = zzacd.zzvh();
      AppMethodBeat.o(3450);
      throw ((Throwable)localObject);
    }
    Object localObject = this.buffer;
    int i = this.zzbws;
    this.zzbws = (i + 1);
    byte b = localObject[i];
    AppMethodBeat.o(3450);
    return b;
  }
  
  public final int getPosition()
  {
    return this.zzbws - this.zzbwp;
  }
  
  public final String readString()
  {
    AppMethodBeat.i(3437);
    int i = zzuy();
    if (i < 0)
    {
      localObject = zzacd.zzvi();
      AppMethodBeat.o(3437);
      throw ((Throwable)localObject);
    }
    if (i > this.zzbwr - this.zzbws)
    {
      localObject = zzacd.zzvh();
      AppMethodBeat.o(3437);
      throw ((Throwable)localObject);
    }
    Object localObject = new String(this.buffer, this.zzbws, i, zzacc.UTF_8);
    this.zzbws = (i + this.zzbws);
    AppMethodBeat.o(3437);
    return localObject;
  }
  
  public final void zza(zzace paramzzace)
  {
    AppMethodBeat.i(3439);
    int i = zzuy();
    if (this.zzbwu >= this.zzbrd)
    {
      paramzzace = zzacd.zzvk();
      AppMethodBeat.o(3439);
      throw paramzzace;
    }
    i = zzaf(i);
    this.zzbwu += 1;
    paramzzace.zzb(this);
    zzaj(0);
    this.zzbwu -= 1;
    zzal(i);
    AppMethodBeat.o(3439);
  }
  
  public final void zza(zzace paramzzace, int paramInt)
  {
    AppMethodBeat.i(3438);
    if (this.zzbwu >= this.zzbrd)
    {
      paramzzace = zzacd.zzvk();
      AppMethodBeat.o(3438);
      throw paramzzace;
    }
    this.zzbwu += 1;
    paramzzace.zzb(this);
    zzaj(paramInt << 3 | 0x4);
    this.zzbwu -= 1;
    AppMethodBeat.o(3438);
  }
  
  public final int zzaf(int paramInt)
  {
    AppMethodBeat.i(3445);
    zzacd localzzacd;
    if (paramInt < 0)
    {
      localzzacd = zzacd.zzvi();
      AppMethodBeat.o(3445);
      throw localzzacd;
    }
    paramInt = this.zzbws + paramInt;
    int i = this.zzbrk;
    if (paramInt > i)
    {
      localzzacd = zzacd.zzvh();
      AppMethodBeat.o(3445);
      throw localzzacd;
    }
    this.zzbrk = paramInt;
    zzta();
    AppMethodBeat.o(3445);
    return i;
  }
  
  public final void zzaj(int paramInt)
  {
    AppMethodBeat.i(3434);
    if (this.zzbwt != paramInt)
    {
      zzacd localzzacd = new zzacd("Protocol message end-group tag did not match expected tag.");
      AppMethodBeat.o(3434);
      throw localzzacd;
    }
    AppMethodBeat.o(3434);
  }
  
  public final boolean zzak(int paramInt)
  {
    AppMethodBeat.i(3435);
    switch (paramInt & 0x7)
    {
    default: 
      zzacd localzzacd = new zzacd("Protocol message tag had invalid wire type.");
      AppMethodBeat.o(3435);
      throw localzzacd;
    case 0: 
      zzuy();
      AppMethodBeat.o(3435);
      return true;
    case 1: 
      zzvb();
      AppMethodBeat.o(3435);
      return true;
    case 2: 
      zzan(zzuy());
      AppMethodBeat.o(3435);
      return true;
    case 3: 
      int i;
      do
      {
        i = zzuw();
      } while ((i != 0) && (zzak(i)));
      zzaj(paramInt >>> 3 << 3 | 0x4);
      AppMethodBeat.o(3435);
      return true;
    case 4: 
      AppMethodBeat.o(3435);
      return false;
    }
    zzva();
    AppMethodBeat.o(3435);
    return true;
  }
  
  public final void zzal(int paramInt)
  {
    AppMethodBeat.i(3446);
    this.zzbrk = paramInt;
    zzta();
    AppMethodBeat.o(3446);
  }
  
  public final void zzam(int paramInt)
  {
    AppMethodBeat.i(3448);
    zzd(paramInt, this.zzbwt);
    AppMethodBeat.o(3448);
  }
  
  public final byte[] zzc(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(3447);
    if (paramInt2 == 0)
    {
      arrayOfByte = zzach.zzbxs;
      AppMethodBeat.o(3447);
      return arrayOfByte;
    }
    byte[] arrayOfByte = new byte[paramInt2];
    int i = this.zzbwp;
    System.arraycopy(this.buffer, i + paramInt1, arrayOfByte, 0, paramInt2);
    AppMethodBeat.o(3447);
    return arrayOfByte;
  }
  
  final void zzd(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(3449);
    IllegalArgumentException localIllegalArgumentException;
    if (paramInt1 > this.zzbws - this.zzbwp)
    {
      paramInt2 = this.zzbws;
      int i = this.zzbwp;
      localIllegalArgumentException = new IllegalArgumentException(50 + "Position " + paramInt1 + " is beyond current " + (paramInt2 - i));
      AppMethodBeat.o(3449);
      throw localIllegalArgumentException;
    }
    if (paramInt1 < 0)
    {
      localIllegalArgumentException = new IllegalArgumentException(24 + "Bad position " + paramInt1);
      AppMethodBeat.o(3449);
      throw localIllegalArgumentException;
    }
    this.zzbws = (this.zzbwp + paramInt1);
    this.zzbwt = paramInt2;
    AppMethodBeat.o(3449);
  }
  
  public final int zzuw()
  {
    AppMethodBeat.i(3433);
    if (this.zzbws == this.zzbwr)
    {
      this.zzbwt = 0;
      AppMethodBeat.o(3433);
      return 0;
    }
    this.zzbwt = zzuy();
    if (this.zzbwt == 0)
    {
      zzacd localzzacd = new zzacd("Protocol message contained an invalid tag (zero).");
      AppMethodBeat.o(3433);
      throw localzzacd;
    }
    int i = this.zzbwt;
    AppMethodBeat.o(3433);
    return i;
  }
  
  public final boolean zzux()
  {
    AppMethodBeat.i(3436);
    if (zzuy() != 0)
    {
      AppMethodBeat.o(3436);
      return true;
    }
    AppMethodBeat.o(3436);
    return false;
  }
  
  public final int zzuy()
  {
    AppMethodBeat.i(3440);
    int i = zzvd();
    if (i >= 0)
    {
      AppMethodBeat.o(3440);
      return i;
    }
    i &= 0x7F;
    int j = zzvd();
    if (j >= 0) {
      i |= j << 7;
    }
    int k;
    do
    {
      for (;;)
      {
        AppMethodBeat.o(3440);
        return i;
        i |= (j & 0x7F) << 7;
        j = zzvd();
        if (j >= 0)
        {
          i |= j << 14;
        }
        else
        {
          i |= (j & 0x7F) << 14;
          j = zzvd();
          if (j < 0) {
            break;
          }
          i |= j << 21;
        }
      }
      k = zzvd();
      j = i | (j & 0x7F) << 21 | k << 28;
      i = j;
    } while (k >= 0);
    i = 0;
    while (i < 5)
    {
      if (zzvd() >= 0)
      {
        AppMethodBeat.o(3440);
        return j;
      }
      i += 1;
    }
    zzacd localzzacd = zzacd.zzvj();
    AppMethodBeat.o(3440);
    throw localzzacd;
  }
  
  public final long zzuz()
  {
    AppMethodBeat.i(3441);
    int i = 0;
    long l = 0L;
    while (i < 64)
    {
      int j = zzvd();
      l |= (j & 0x7F) << i;
      if ((j & 0x80) == 0)
      {
        AppMethodBeat.o(3441);
        return l;
      }
      i += 7;
    }
    zzacd localzzacd = zzacd.zzvj();
    AppMethodBeat.o(3441);
    throw localzzacd;
  }
  
  public final int zzva()
  {
    AppMethodBeat.i(3442);
    int i = zzvd();
    int j = zzvd();
    int k = zzvd();
    int m = zzvd();
    AppMethodBeat.o(3442);
    return i & 0xFF | (j & 0xFF) << 8 | (k & 0xFF) << 16 | (m & 0xFF) << 24;
  }
  
  public final long zzvb()
  {
    AppMethodBeat.i(3443);
    int i = zzvd();
    int j = zzvd();
    int k = zzvd();
    int m = zzvd();
    int n = zzvd();
    int i1 = zzvd();
    int i2 = zzvd();
    int i3 = zzvd();
    long l1 = i;
    long l2 = j;
    long l3 = k;
    long l4 = m;
    long l5 = n;
    long l6 = i1;
    long l7 = i2;
    long l8 = i3;
    AppMethodBeat.o(3443);
    return (l2 & 0xFF) << 8 | l1 & 0xFF | (l3 & 0xFF) << 16 | (l4 & 0xFF) << 24 | (l5 & 0xFF) << 32 | (l6 & 0xFF) << 40 | (l7 & 0xFF) << 48 | (l8 & 0xFF) << 56;
  }
  
  public final int zzvc()
  {
    if (this.zzbrk == 2147483647) {
      return -1;
    }
    int i = this.zzbws;
    return this.zzbrk - i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.google.android.gms.internal.measurement.zzabv
 * JD-Core Version:    0.7.0.1
 */