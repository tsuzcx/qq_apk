package com.google.android.gms.wearable.internal;

import android.os.ParcelFileDescriptor;
import com.google.android.gms.common.api.Releasable;
import com.google.android.gms.wearable.DataApi.GetFdForAssetResult;
import com.google.android.gms.wearable.DataClient.GetFdForAssetResponse;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.InputStream;

final class zzcu
  extends DataClient.GetFdForAssetResponse
  implements Releasable
{
  private final DataApi.GetFdForAssetResult zzdj;
  
  zzcu(DataApi.GetFdForAssetResult paramGetFdForAssetResult)
  {
    this.zzdj = paramGetFdForAssetResult;
  }
  
  public final ParcelFileDescriptor getFdForAsset()
  {
    AppMethodBeat.i(101153);
    ParcelFileDescriptor localParcelFileDescriptor = this.zzdj.getFd();
    AppMethodBeat.o(101153);
    return localParcelFileDescriptor;
  }
  
  public final InputStream getInputStream()
  {
    AppMethodBeat.i(101154);
    InputStream localInputStream = this.zzdj.getInputStream();
    AppMethodBeat.o(101154);
    return localInputStream;
  }
  
  public final void release()
  {
    AppMethodBeat.i(101155);
    this.zzdj.release();
    AppMethodBeat.o(101155);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.google.android.gms.wearable.internal.zzcu
 * JD-Core Version:    0.7.0.1
 */