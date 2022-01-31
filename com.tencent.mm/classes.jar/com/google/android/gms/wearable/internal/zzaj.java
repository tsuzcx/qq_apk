package com.google.android.gms.wearable.internal;

import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.data.zzc;
import com.google.android.gms.wearable.DataEvent;
import com.google.android.gms.wearable.DataItem;

public final class zzaj
  extends zzc
  implements DataEvent
{
  private final int zzaZk;
  
  public zzaj(DataHolder paramDataHolder, int paramInt1, int paramInt2)
  {
    super(paramDataHolder, paramInt1);
    this.zzaZk = paramInt2;
  }
  
  public final DataItem getDataItem()
  {
    return new zzaq(this.zzaBi, this.zzaDL, this.zzaZk);
  }
  
  public final int getType()
  {
    return getInteger("event_type");
  }
  
  public final String toString()
  {
    String str1;
    if (getType() == 1) {
      str1 = "changed";
    }
    for (;;)
    {
      String str2 = String.valueOf(getDataItem());
      return String.valueOf(str1).length() + 32 + String.valueOf(str2).length() + "DataEventRef{ type=" + str1 + ", dataitem=" + str2 + " }";
      if (getType() == 2) {
        str1 = "deleted";
      } else {
        str1 = "unknown";
      }
    }
  }
  
  public final DataEvent zzUu()
  {
    return new zzai(this);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.google.android.gms.wearable.internal.zzaj
 * JD-Core Version:    0.7.0.1
 */