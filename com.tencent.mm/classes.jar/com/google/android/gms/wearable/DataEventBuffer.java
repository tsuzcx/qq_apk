package com.google.android.gms.wearable;

import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.data.EntityBuffer;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class DataEventBuffer
  extends EntityBuffer<DataEvent>
  implements Result
{
  private final Status zzp;
  
  public DataEventBuffer(DataHolder paramDataHolder)
  {
    super(paramDataHolder);
    AppMethodBeat.i(100782);
    this.zzp = new Status(paramDataHolder.getStatusCode());
    AppMethodBeat.o(100782);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.google.android.gms.wearable.DataEventBuffer
 * JD-Core Version:    0.7.0.1
 */