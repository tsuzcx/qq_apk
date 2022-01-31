package com.google.android.gms.wearable;

import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.data.zzf;
import com.google.android.gms.wearable.internal.zzaq;

public class DataItemBuffer
  extends zzf<DataItem>
  implements Result
{
  private final Status zzair;
  
  public DataItemBuffer(DataHolder paramDataHolder)
  {
    super(paramDataHolder);
    this.zzair = new Status(paramDataHolder.getStatusCode());
  }
  
  public Status getStatus()
  {
    return this.zzair;
  }
  
  protected DataItem zzD(int paramInt1, int paramInt2)
  {
    return new zzaq(this.zzaBi, paramInt1, paramInt2);
  }
  
  protected String zzxn()
  {
    return "path";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.google.android.gms.wearable.DataItemBuffer
 * JD-Core Version:    0.7.0.1
 */