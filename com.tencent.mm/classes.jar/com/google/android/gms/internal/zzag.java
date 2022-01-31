package com.google.android.gms.internal;

public abstract interface zzag
{
  public static final class zzf
    extends zzbxn<zzf>
  {
    public byte[][] zzcA = zzbxw.zzcuU;
    public Integer zzcB = null;
    public Integer zzcC = null;
    public byte[] zzcv = null;
    
    public zzf()
    {
      this.zzcuJ = -1;
    }
    
    public final void zza(zzbxm paramzzbxm)
    {
      if ((this.zzcA != null) && (this.zzcA.length > 0))
      {
        int i = 0;
        while (i < this.zzcA.length)
        {
          byte[] arrayOfByte = this.zzcA[i];
          if (arrayOfByte != null) {
            paramzzbxm.zzb(1, arrayOfByte);
          }
          i += 1;
        }
      }
      if (this.zzcv != null) {
        paramzzbxm.zzb(2, this.zzcv);
      }
      if (this.zzcB != null) {
        paramzzbxm.zzJ(3, this.zzcB.intValue());
      }
      if (this.zzcC != null) {
        paramzzbxm.zzJ(4, this.zzcC.intValue());
      }
      super.zza(paramzzbxm);
    }
    
    public final zzf zzm(zzbxl paramzzbxl)
    {
      for (;;)
      {
        int i = paramzzbxl.zzaen();
        switch (i)
        {
        default: 
          if (super.zza(paramzzbxl, i)) {
            continue;
          }
        case 0: 
          return this;
        case 10: 
          int j = zzbxw.zzb(paramzzbxl, 10);
          if (this.zzcA == null) {}
          byte[][] arrayOfByte;
          for (i = 0;; i = this.zzcA.length)
          {
            arrayOfByte = new byte[j + i][];
            j = i;
            if (i != 0)
            {
              System.arraycopy(this.zzcA, 0, arrayOfByte, 0, i);
              j = i;
            }
            while (j < arrayOfByte.length - 1)
            {
              arrayOfByte[j] = paramzzbxl.readBytes();
              paramzzbxl.zzaen();
              j += 1;
            }
          }
          arrayOfByte[j] = paramzzbxl.readBytes();
          this.zzcA = arrayOfByte;
          break;
        case 18: 
          this.zzcv = paramzzbxl.readBytes();
          break;
        case 24: 
          i = paramzzbxl.zzaer();
          switch (i)
          {
          default: 
            break;
          }
          this.zzcB = Integer.valueOf(i);
          break;
        }
        i = paramzzbxl.zzaer();
        switch (i)
        {
        default: 
          break;
        }
        this.zzcC = Integer.valueOf(i);
      }
    }
    
    protected final int zzu()
    {
      int m = super.zzu();
      int i;
      int k;
      if ((this.zzcA != null) && (this.zzcA.length > 0))
      {
        j = 0;
        i = 0;
        k = 0;
        while (j < this.zzcA.length)
        {
          byte[] arrayOfByte = this.zzcA[j];
          if (arrayOfByte == null) {
            break label145;
          }
          k += 1;
          i = zzbxm.zzai(arrayOfByte) + i;
          j += 1;
        }
      }
      for (int j = m + i + k * 1;; j = m)
      {
        i = j;
        if (this.zzcv != null) {
          i = j + zzbxm.zzc(2, this.zzcv);
        }
        j = i;
        if (this.zzcB != null) {
          j = i + zzbxm.zzL(3, this.zzcB.intValue());
        }
        i = j;
        if (this.zzcC != null) {
          i = j + zzbxm.zzL(4, this.zzcC.intValue());
        }
        return i;
        label145:
        break;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.google.android.gms.internal.zzag
 * JD-Core Version:    0.7.0.1
 */