package com.google.android.gms.internal.measurement;

import com.tencent.matrix.trace.core.AppMethodBeat;

class zzzc
  extends zzzb
{
  protected final byte[] zzbrc;
  
  zzzc(byte[] paramArrayOfByte)
  {
    this.zzbrc = paramArrayOfByte;
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(40345);
    if (paramObject == this)
    {
      AppMethodBeat.o(40345);
      return true;
    }
    if (!(paramObject instanceof zzyw))
    {
      AppMethodBeat.o(40345);
      return false;
    }
    if (size() != ((zzyw)paramObject).size())
    {
      AppMethodBeat.o(40345);
      return false;
    }
    if (size() == 0)
    {
      AppMethodBeat.o(40345);
      return true;
    }
    if ((paramObject instanceof zzzc))
    {
      zzzc localzzzc = (zzzc)paramObject;
      int i = zzsx();
      int j = localzzzc.zzsx();
      if ((i != 0) && (j != 0) && (i != j))
      {
        AppMethodBeat.o(40345);
        return false;
      }
      bool = zza((zzzc)paramObject, 0, size());
      AppMethodBeat.o(40345);
      return bool;
    }
    boolean bool = paramObject.equals(this);
    AppMethodBeat.o(40345);
    return bool;
  }
  
  public int size()
  {
    return this.zzbrc.length;
  }
  
  protected final int zza(int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(40347);
    paramInt1 = zzzr.zza(paramInt1, this.zzbrc, zzsy(), paramInt3);
    AppMethodBeat.o(40347);
    return paramInt1;
  }
  
  final boolean zza(zzyw paramzzyw, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(40346);
    if (paramInt2 > paramzzyw.size())
    {
      paramInt1 = size();
      paramzzyw = new IllegalArgumentException(40 + "Length too large: " + paramInt2 + paramInt1);
      AppMethodBeat.o(40346);
      throw paramzzyw;
    }
    if (paramInt2 > paramzzyw.size())
    {
      paramInt1 = paramzzyw.size();
      paramzzyw = new IllegalArgumentException(59 + "Ran off end of other: 0, " + paramInt2 + ", " + paramInt1);
      AppMethodBeat.o(40346);
      throw paramzzyw;
    }
    if ((paramzzyw instanceof zzzc))
    {
      paramzzyw = (zzzc)paramzzyw;
      byte[] arrayOfByte1 = this.zzbrc;
      byte[] arrayOfByte2 = paramzzyw.zzbrc;
      int j = zzsy();
      int i = zzsy();
      paramInt1 = paramzzyw.zzsy();
      while (i < j + paramInt2)
      {
        if (arrayOfByte1[i] != arrayOfByte2[paramInt1])
        {
          AppMethodBeat.o(40346);
          return false;
        }
        i += 1;
        paramInt1 += 1;
      }
      AppMethodBeat.o(40346);
      return true;
    }
    boolean bool = paramzzyw.zzb(0, paramInt2).equals(zzb(0, paramInt2));
    AppMethodBeat.o(40346);
    return bool;
  }
  
  public byte zzae(int paramInt)
  {
    return this.zzbrc[paramInt];
  }
  
  public final zzyw zzb(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(40344);
    paramInt1 = zzb(0, paramInt2, size());
    if (paramInt1 == 0)
    {
      localObject = zzyw.zzbqx;
      AppMethodBeat.o(40344);
      return localObject;
    }
    Object localObject = new zzyz(this.zzbrc, zzsy(), paramInt1);
    AppMethodBeat.o(40344);
    return localObject;
  }
  
  protected int zzsy()
  {
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.google.android.gms.internal.measurement.zzzc
 * JD-Core Version:    0.7.0.1
 */