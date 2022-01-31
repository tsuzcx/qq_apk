package com.google.android.gms.wearable.internal;

import com.google.android.gms.wearable.DataEvent;
import com.google.android.gms.wearable.DataItem;

public class zzai
  implements DataEvent
{
  private int zzakD;
  private DataItem zzbUs;
  
  public zzai(DataEvent paramDataEvent)
  {
    this.zzakD = paramDataEvent.getType();
    this.zzbUs = ((DataItem)paramDataEvent.getDataItem().freeze());
  }
  
  public DataItem getDataItem()
  {
    return this.zzbUs;
  }
  
  public int getType()
  {
    return this.zzakD;
  }
  
  public boolean isDataValid()
  {
    return true;
  }
  
  public String toString()
  {
    String str1;
    if (getType() == 1) {
      str1 = "changed";
    }
    for (;;)
    {
      String str2 = String.valueOf(getDataItem());
      return String.valueOf(str1).length() + 35 + String.valueOf(str2).length() + "DataEventEntity{ type=" + str1 + ", dataitem=" + str2 + " }";
      if (getType() == 2) {
        str1 = "deleted";
      } else {
        str1 = "unknown";
      }
    }
  }
  
  public DataEvent zzUu()
  {
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.google.android.gms.wearable.internal.zzai
 * JD-Core Version:    0.7.0.1
 */