package com.google.android.gms.wearable;

import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.data.zzf;
import com.google.android.gms.wearable.internal.zzaj;

public class DataEventBuffer
  extends zzf<DataEvent>
  implements Result
{
  private final Status zzair;
  
  public DataEventBuffer(DataHolder paramDataHolder)
  {
    super(paramDataHolder);
    this.zzair = new Status(paramDataHolder.getStatusCode());
  }
  
  public Status getStatus()
  {
    return this.zzair;
  }
  
  protected DataEvent zzC(int paramInt1, int paramInt2)
  {
    return new zzaj(this.zzaBi, paramInt1, paramInt2);
  }
  
  protected String zzxn()
  {
    return "path";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.google.android.gms.wearable.DataEventBuffer
 * JD-Core Version:    0.7.0.1
 */