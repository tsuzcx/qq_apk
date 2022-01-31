package com.google.android.gms.internal;

public final class zzabh$zzb<L>
{
  private final L mListener;
  private final String zzaDa;
  
  zzabh$zzb(L paramL, String paramString)
  {
    this.mListener = paramL;
    this.zzaDa = paramString;
  }
  
  public final boolean equals(Object paramObject)
  {
    if (this == paramObject) {}
    do
    {
      return true;
      if (!(paramObject instanceof zzb)) {
        return false;
      }
      paramObject = (zzb)paramObject;
    } while ((this.mListener == paramObject.mListener) && (this.zzaDa.equals(paramObject.zzaDa)));
    return false;
  }
  
  public final int hashCode()
  {
    return System.identityHashCode(this.mListener) * 31 + this.zzaDa.hashCode();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.google.android.gms.internal.zzabh.zzb
 * JD-Core Version:    0.7.0.1
 */