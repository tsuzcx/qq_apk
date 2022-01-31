package com.google.android.gms.common.data;

import android.database.CharArrayBuffer;
import android.net.Uri;
import com.google.android.gms.common.internal.zzaa;
import com.google.android.gms.common.internal.zzac;

public abstract class zzc
{
  public final DataHolder zzaBi;
  public int zzaDL;
  private int zzaDM;
  
  public zzc(DataHolder paramDataHolder, int paramInt)
  {
    this.zzaBi = ((DataHolder)zzac.zzw(paramDataHolder));
    zzcG(paramInt);
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if ((paramObject instanceof zzc))
    {
      paramObject = (zzc)paramObject;
      bool1 = bool2;
      if (zzaa.equal(Integer.valueOf(paramObject.zzaDL), Integer.valueOf(this.zzaDL)))
      {
        bool1 = bool2;
        if (zzaa.equal(Integer.valueOf(paramObject.zzaDM), Integer.valueOf(this.zzaDM)))
        {
          bool1 = bool2;
          if (paramObject.zzaBi == this.zzaBi) {
            bool1 = true;
          }
        }
      }
    }
    return bool1;
  }
  
  protected boolean getBoolean(String paramString)
  {
    return this.zzaBi.zze(paramString, this.zzaDL, this.zzaDM);
  }
  
  public byte[] getByteArray(String paramString)
  {
    return this.zzaBi.zzg(paramString, this.zzaDL, this.zzaDM);
  }
  
  protected float getFloat(String paramString)
  {
    return this.zzaBi.zzf(paramString, this.zzaDL, this.zzaDM);
  }
  
  public int getInteger(String paramString)
  {
    return this.zzaBi.zzc(paramString, this.zzaDL, this.zzaDM);
  }
  
  protected long getLong(String paramString)
  {
    return this.zzaBi.zzb(paramString, this.zzaDL, this.zzaDM);
  }
  
  public String getString(String paramString)
  {
    return this.zzaBi.zzd(paramString, this.zzaDL, this.zzaDM);
  }
  
  public int hashCode()
  {
    return zzaa.hashCode(new Object[] { Integer.valueOf(this.zzaDL), Integer.valueOf(this.zzaDM), this.zzaBi });
  }
  
  public boolean isDataValid()
  {
    return !this.zzaBi.isClosed();
  }
  
  protected void zza(String paramString, CharArrayBuffer paramCharArrayBuffer)
  {
    this.zzaBi.zza(paramString, this.zzaDL, this.zzaDM, paramCharArrayBuffer);
  }
  
  protected void zzcG(int paramInt)
  {
    if ((paramInt >= 0) && (paramInt < this.zzaBi.getCount())) {}
    for (boolean bool = true;; bool = false)
    {
      zzac.zzaw(bool);
      this.zzaDL = paramInt;
      this.zzaDM = this.zzaBi.zzcI(this.zzaDL);
      return;
    }
  }
  
  public boolean zzdf(String paramString)
  {
    return this.zzaBi.zzdf(paramString);
  }
  
  protected Uri zzdg(String paramString)
  {
    return this.zzaBi.zzh(paramString, this.zzaDL, this.zzaDM);
  }
  
  protected boolean zzdh(String paramString)
  {
    return this.zzaBi.zzi(paramString, this.zzaDL, this.zzaDM);
  }
  
  protected int zzxi()
  {
    return this.zzaDL;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.google.android.gms.common.data.zzc
 * JD-Core Version:    0.7.0.1
 */