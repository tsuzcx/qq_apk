package com.google.android.gms.wearable.internal;

import com.google.android.gms.wearable.CapabilityApi.CapabilityListener;
import com.google.android.gms.wearable.CapabilityInfo;

class zzn$zzb
  implements CapabilityApi.CapabilityListener
{
  final CapabilityApi.CapabilityListener zzbTP;
  final String zzbTQ;
  
  zzn$zzb(CapabilityApi.CapabilityListener paramCapabilityListener, String paramString)
  {
    this.zzbTP = paramCapabilityListener;
    this.zzbTQ = paramString;
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool2 = false;
    boolean bool1;
    if (this == paramObject) {
      bool1 = true;
    }
    do
    {
      do
      {
        do
        {
          return bool1;
          bool1 = bool2;
        } while (paramObject == null);
        bool1 = bool2;
      } while (getClass() != paramObject.getClass());
      paramObject = (zzb)paramObject;
      bool1 = bool2;
    } while (!this.zzbTP.equals(paramObject.zzbTP));
    return this.zzbTQ.equals(paramObject.zzbTQ);
  }
  
  public int hashCode()
  {
    return this.zzbTP.hashCode() * 31 + this.zzbTQ.hashCode();
  }
  
  public void onCapabilityChanged(CapabilityInfo paramCapabilityInfo)
  {
    this.zzbTP.onCapabilityChanged(paramCapabilityInfo);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.google.android.gms.wearable.internal.zzn.zzb
 * JD-Core Version:    0.7.0.1
 */