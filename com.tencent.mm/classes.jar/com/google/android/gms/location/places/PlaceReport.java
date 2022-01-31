package com.google.android.gms.location.places;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.zzaa;
import com.google.android.gms.common.internal.zzaa.zza;
import com.google.android.gms.common.internal.zzac;

public class PlaceReport
  extends zza
  implements ReflectedParcelable
{
  public static final Parcelable.Creator<PlaceReport> CREATOR = new zzl();
  private final String mTag;
  private final String zzacO;
  final int zzaiI;
  private final String zzblI;
  
  PlaceReport(int paramInt, String paramString1, String paramString2, String paramString3)
  {
    this.zzaiI = paramInt;
    this.zzblI = paramString1;
    this.mTag = paramString2;
    this.zzacO = paramString3;
  }
  
  public static PlaceReport create(String paramString1, String paramString2)
  {
    return zzj(paramString1, paramString2, "unknown");
  }
  
  private static boolean zzeU(String paramString)
  {
    boolean bool = true;
    int i = -1;
    switch (paramString.hashCode())
    {
    }
    for (;;)
    {
      switch (i)
      {
      default: 
        bool = false;
      }
      return bool;
      if (paramString.equals("unknown"))
      {
        i = 0;
        continue;
        if (paramString.equals("userReported"))
        {
          i = 1;
          continue;
          if (paramString.equals("inferredGeofencing"))
          {
            i = 2;
            continue;
            if (paramString.equals("inferredRadioSignals"))
            {
              i = 3;
              continue;
              if (paramString.equals("inferredReverseGeocoding"))
              {
                i = 4;
                continue;
                if (paramString.equals("inferredSnappedToRoad")) {
                  i = 5;
                }
              }
            }
          }
        }
      }
    }
  }
  
  public static PlaceReport zzj(String paramString1, String paramString2, String paramString3)
  {
    zzac.zzw(paramString1);
    zzac.zzdr(paramString2);
    zzac.zzdr(paramString3);
    zzac.zzb(zzeU(paramString3), "Invalid source");
    return new PlaceReport(1, paramString1, paramString2, paramString3);
  }
  
  public boolean equals(Object paramObject)
  {
    if (!(paramObject instanceof PlaceReport)) {}
    do
    {
      return false;
      paramObject = (PlaceReport)paramObject;
    } while ((!zzaa.equal(this.zzblI, paramObject.zzblI)) || (!zzaa.equal(this.mTag, paramObject.mTag)) || (!zzaa.equal(this.zzacO, paramObject.zzacO)));
    return true;
  }
  
  public String getPlaceId()
  {
    return this.zzblI;
  }
  
  public String getSource()
  {
    return this.zzacO;
  }
  
  public String getTag()
  {
    return this.mTag;
  }
  
  public int hashCode()
  {
    return zzaa.hashCode(new Object[] { this.zzblI, this.mTag, this.zzacO });
  }
  
  public String toString()
  {
    zzaa.zza localzza = zzaa.zzv(this);
    localzza.zzg("placeId", this.zzblI);
    localzza.zzg("tag", this.mTag);
    if (!"unknown".equals(this.zzacO)) {
      localzza.zzg("source", this.zzacO);
    }
    return localzza.toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzl.zza(this, paramParcel, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.google.android.gms.location.places.PlaceReport
 * JD-Core Version:    0.7.0.1
 */