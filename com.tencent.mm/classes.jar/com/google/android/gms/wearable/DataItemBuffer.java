package com.google.android.gms.wearable;

import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.data.EntityBuffer;
import com.google.android.gms.common.util.VisibleForTesting;
import com.tencent.matrix.trace.core.AppMethodBeat;

@VisibleForTesting
public class DataItemBuffer
  extends EntityBuffer<DataItem>
  implements Result
{
  private final Status zzp;
  
  public DataItemBuffer(DataHolder paramDataHolder)
  {
    super(paramDataHolder);
    AppMethodBeat.i(70801);
    this.zzp = new Status(paramDataHolder.getStatusCode());
    AppMethodBeat.o(70801);
  }
  
  public String getPrimaryDataMarkerColumn()
  {
    return "path";
  }
  
  public Status getStatus()
  {
    return this.zzp;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.google.android.gms.wearable.DataItemBuffer
 * JD-Core Version:    0.7.0.1
 */