package com.google.android.gms.wearable.internal;

import com.google.android.gms.common.data.DataBufferRef;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.wearable.DataEvent;
import com.google.android.gms.wearable.DataItem;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class zzcy
  extends DataBufferRef
  implements DataEvent
{
  private final int zzdl;
  
  public zzcy(DataHolder paramDataHolder, int paramInt1, int paramInt2)
  {
    super(paramDataHolder, paramInt1);
    this.zzdl = paramInt2;
  }
  
  public final DataItem getDataItem()
  {
    AppMethodBeat.i(101160);
    zzdf localzzdf = new zzdf(this.mDataHolder, this.mDataRow, this.zzdl);
    AppMethodBeat.o(101160);
    return localzzdf;
  }
  
  public final int getType()
  {
    AppMethodBeat.i(101161);
    int i = getInteger("event_type");
    AppMethodBeat.o(101161);
    return i;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(101162);
    String str1;
    if (getType() == 1) {
      str1 = "changed";
    }
    for (;;)
    {
      String str2 = String.valueOf(getDataItem());
      str1 = String.valueOf(str1).length() + 32 + String.valueOf(str2).length() + "DataEventRef{ type=" + str1 + ", dataitem=" + str2 + " }";
      AppMethodBeat.o(101162);
      return str1;
      if (getType() == 2) {
        str1 = "deleted";
      } else {
        str1 = "unknown";
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.google.android.gms.wearable.internal.zzcy
 * JD-Core Version:    0.7.0.1
 */