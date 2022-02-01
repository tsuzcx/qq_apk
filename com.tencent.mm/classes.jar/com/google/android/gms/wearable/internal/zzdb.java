package com.google.android.gms.wearable.internal;

import com.google.android.gms.common.data.DataBufferRef;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.wearable.DataItemAsset;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class zzdb
  extends DataBufferRef
  implements DataItemAsset
{
  public zzdb(DataHolder paramDataHolder, int paramInt)
  {
    super(paramDataHolder, paramInt);
  }
  
  public final String getDataItemKey()
  {
    AppMethodBeat.i(101172);
    String str = getString("asset_key");
    AppMethodBeat.o(101172);
    return str;
  }
  
  public final String getId()
  {
    AppMethodBeat.i(101171);
    String str = getString("asset_id");
    AppMethodBeat.o(101171);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.google.android.gms.wearable.internal.zzdb
 * JD-Core Version:    0.7.0.1
 */