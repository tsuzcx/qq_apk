package com.google.android.gms.internal;

public final class zzbxl
{
  private final byte[] buffer;
  private int zzcuq;
  private int zzcur;
  private int zzcus;
  private int zzcut;
  private int zzcuu;
  private int zzcuv = 2147483647;
  private int zzcuw;
  private int zzcux = 64;
  private int zzcuy = 67108864;
  
  private zzbxl(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    this.buffer = paramArrayOfByte;
    this.zzcuq = paramInt1;
    this.zzcur = (paramInt1 + paramInt2);
    this.zzcut = paramInt1;
  }
  
  public static long zzaZ(long paramLong)
  {
    return paramLong >>> 1 ^ -(1L & paramLong);
  }
  
  private void zzaeA()
  {
    this.zzcur += this.zzcus;
    int i = this.zzcur;
    if (i > this.zzcuv)
    {
      this.zzcus = (i - this.zzcuv);
      this.zzcur -= this.zzcus;
      return;
    }
    this.zzcus = 0;
  }
  
  public static zzbxl zzaf(byte[] paramArrayOfByte)
  {
    return zzb(paramArrayOfByte, 0, paramArrayOfByte.length);
  }
  
  public static zzbxl zzb(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    return new zzbxl(paramArrayOfByte, paramInt1, paramInt2);
  }
  
  public static int zzqY(int paramInt)
  {
    return paramInt >>> 1 ^ -(paramInt & 0x1);
  }
  
  public final int getPosition()
  {
    return this.zzcut - this.zzcuq;
  }
  
  public final byte[] readBytes()
  {
    int i = zzaew();
    if (i < 0) {
      throw zzbxs.zzaeL();
    }
    if (i == 0) {
      return zzbxw.zzcuV;
    }
    if (i > this.zzcur - this.zzcut) {
      throw zzbxs.zzaeK();
    }
    byte[] arrayOfByte = new byte[i];
    System.arraycopy(this.buffer, this.zzcut, arrayOfByte, 0, i);
    this.zzcut = (i + this.zzcut);
    return arrayOfByte;
  }
  
  public final double readDouble()
  {
    return Double.longBitsToDouble(zzaez());
  }
  
  public final float readFloat()
  {
    return Float.intBitsToFloat(zzaey());
  }
  
  public final String readString()
  {
    int i = zzaew();
    if (i < 0) {
      throw zzbxs.zzaeL();
    }
    if (i > this.zzcur - this.zzcut) {
      throw zzbxs.zzaeK();
    }
    String str = new String(this.buffer, this.zzcut, i, zzbxr.UTF_8);
    this.zzcut = (i + this.zzcut);
    return str;
  }
  
  public final byte[] zzI(int paramInt1, int paramInt2)
  {
    if (paramInt2 == 0) {
      return zzbxw.zzcuV;
    }
    byte[] arrayOfByte = new byte[paramInt2];
    int i = this.zzcuq;
    System.arraycopy(this.buffer, i + paramInt1, arrayOfByte, 0, paramInt2);
    return arrayOfByte;
  }
  
  public final void zza(zzbxt paramzzbxt)
  {
    int i = zzaew();
    if (this.zzcuw >= this.zzcux) {
      throw zzbxs.zzaeQ();
    }
    i = zzqZ(i);
    this.zzcuw += 1;
    paramzzbxt.zzb(this);
    zzqW(0);
    this.zzcuw -= 1;
    zzra(i);
  }
  
  public final void zza(zzbxt paramzzbxt, int paramInt)
  {
    if (this.zzcuw >= this.zzcux) {
      throw zzbxs.zzaeQ();
    }
    this.zzcuw += 1;
    paramzzbxt.zzb(this);
    zzqW(zzbxw.zzO(paramInt, 4));
    this.zzcuw -= 1;
  }
  
  public final int zzaeB()
  {
    if (this.zzcuv == 2147483647) {
      return -1;
    }
    int i = this.zzcut;
    return this.zzcuv - i;
  }
  
  public final boolean zzaeC()
  {
    return this.zzcut == this.zzcur;
  }
  
  public final byte zzaeD()
  {
    if (this.zzcut == this.zzcur) {
      throw zzbxs.zzaeK();
    }
    byte[] arrayOfByte = this.buffer;
    int i = this.zzcut;
    this.zzcut = (i + 1);
    return arrayOfByte[i];
  }
  
  public final int zzaen()
  {
    if (zzaeC())
    {
      this.zzcuu = 0;
      return 0;
    }
    this.zzcuu = zzaew();
    if (this.zzcuu == 0) {
      throw zzbxs.zzaeN();
    }
    return this.zzcuu;
  }
  
  public final void zzaeo()
  {
    int i;
    do
    {
      i = zzaen();
    } while ((i != 0) && (zzqX(i)));
  }
  
  public final long zzaep()
  {
    return zzaex();
  }
  
  public final long zzaeq()
  {
    return zzaex();
  }
  
  public final int zzaer()
  {
    return zzaew();
  }
  
  public final long zzaes()
  {
    return zzaez();
  }
  
  public final boolean zzaet()
  {
    return zzaew() != 0;
  }
  
  public final int zzaeu()
  {
    return zzqY(zzaew());
  }
  
  public final long zzaev()
  {
    return zzaZ(zzaex());
  }
  
  public final int zzaew()
  {
    int i = zzaeD();
    if (i >= 0) {}
    int k;
    do
    {
      return i;
      i &= 0x7F;
      j = zzaeD();
      if (j >= 0) {
        return i | j << 7;
      }
      i |= (j & 0x7F) << 7;
      j = zzaeD();
      if (j >= 0) {
        return i | j << 14;
      }
      i |= (j & 0x7F) << 14;
      k = zzaeD();
      if (k >= 0) {
        return i | k << 21;
      }
      j = zzaeD();
      k = i | (k & 0x7F) << 21 | j << 28;
      i = k;
    } while (j >= 0);
    int j = 0;
    for (;;)
    {
      if (j >= 5) {
        break label133;
      }
      i = k;
      if (zzaeD() >= 0) {
        break;
      }
      j += 1;
    }
    label133:
    throw zzbxs.zzaeM();
  }
  
  public final long zzaex()
  {
    int i = 0;
    long l = 0L;
    while (i < 64)
    {
      int j = zzaeD();
      l |= (j & 0x7F) << i;
      if ((j & 0x80) == 0) {
        return l;
      }
      i += 7;
    }
    throw zzbxs.zzaeM();
  }
  
  public final int zzaey()
  {
    return zzaeD() & 0xFF | (zzaeD() & 0xFF) << 8 | (zzaeD() & 0xFF) << 16 | (zzaeD() & 0xFF) << 24;
  }
  
  public final long zzaez()
  {
    int i = zzaeD();
    int j = zzaeD();
    int k = zzaeD();
    int m = zzaeD();
    int n = zzaeD();
    int i1 = zzaeD();
    int i2 = zzaeD();
    int i3 = zzaeD();
    long l = i;
    return (j & 0xFF) << 8 | l & 0xFF | (k & 0xFF) << 16 | (m & 0xFF) << 24 | (n & 0xFF) << 32 | (i1 & 0xFF) << 40 | (i2 & 0xFF) << 48 | (i3 & 0xFF) << 56;
  }
  
  public final void zzqW(int paramInt)
  {
    if (this.zzcuu != paramInt) {
      throw zzbxs.zzaeO();
    }
  }
  
  public final boolean zzqX(int paramInt)
  {
    switch (zzbxw.zzrq(paramInt))
    {
    default: 
      throw zzbxs.zzaeP();
    case 0: 
      zzaer();
      return true;
    case 1: 
      zzaez();
      return true;
    case 2: 
      zzrc(zzaew());
      return true;
    case 3: 
      zzaeo();
      zzqW(zzbxw.zzO(zzbxw.zzrr(paramInt), 4));
      return true;
    case 4: 
      return false;
    }
    zzaey();
    return true;
  }
  
  public final int zzqZ(int paramInt)
  {
    if (paramInt < 0) {
      throw zzbxs.zzaeL();
    }
    paramInt = this.zzcut + paramInt;
    int i = this.zzcuv;
    if (paramInt > i) {
      throw zzbxs.zzaeK();
    }
    this.zzcuv = paramInt;
    zzaeA();
    return i;
  }
  
  public final void zzra(int paramInt)
  {
    this.zzcuv = paramInt;
    zzaeA();
  }
  
  public final void zzrb(int paramInt)
  {
    if (paramInt > this.zzcut - this.zzcuq)
    {
      int i = this.zzcut;
      int j = this.zzcuq;
      throw new IllegalArgumentException(50 + "Position " + paramInt + " is beyond current " + (i - j));
    }
    if (paramInt < 0) {
      throw new IllegalArgumentException(24 + "Bad position " + paramInt);
    }
    this.zzcut = (this.zzcuq + paramInt);
  }
  
  public final void zzrc(int paramInt)
  {
    if (paramInt < 0) {
      throw zzbxs.zzaeL();
    }
    if (this.zzcut + paramInt > this.zzcuv)
    {
      zzrc(this.zzcuv - this.zzcut);
      throw zzbxs.zzaeK();
    }
    if (paramInt <= this.zzcur - this.zzcut)
    {
      this.zzcut += paramInt;
      return;
    }
    throw zzbxs.zzaeK();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.google.android.gms.internal.zzbxl
 * JD-Core Version:    0.7.0.1
 */