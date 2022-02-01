package com.google.android.gms.wearable.internal;

import com.google.android.gms.wearable.DataEvent;
import com.google.android.gms.wearable.DataItem;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class zzcx
  implements DataEvent
{
  private int type;
  private DataItem zzdg;
  
  public zzcx(DataEvent paramDataEvent)
  {
    AppMethodBeat.i(101158);
    this.type = paramDataEvent.getType();
    this.zzdg = ((DataItem)paramDataEvent.getDataItem().freeze());
    AppMethodBeat.o(101158);
  }
  
  public final DataItem getDataItem()
  {
    return this.zzdg;
  }
  
  public final int getType()
  {
    return this.type;
  }
  
  public final boolean isDataValid()
  {
    return true;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(101159);
    String str1;
    if (getType() == 1) {
      str1 = "changed";
    }
    for (;;)
    {
      String str2 = String.valueOf(getDataItem());
      str1 = String.valueOf(str1).length() + 35 + String.valueOf(str2).length() + "DataEventEntity{ type=" + str1 + ", dataitem=" + str2 + " }";
      AppMethodBeat.o(101159);
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
 * Qualified Name:     com.google.android.gms.wearable.internal.zzcx
 * JD-Core Version:    0.7.0.1
 */