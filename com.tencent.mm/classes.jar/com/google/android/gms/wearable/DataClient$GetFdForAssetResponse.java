package com.google.android.gms.wearable;

import android.os.ParcelFileDescriptor;
import com.google.android.gms.common.api.Releasable;
import java.io.InputStream;

public abstract class DataClient$GetFdForAssetResponse
  implements Releasable
{
  public abstract ParcelFileDescriptor getFdForAsset();
  
  public abstract InputStream getInputStream();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.google.android.gms.wearable.DataClient.GetFdForAssetResponse
 * JD-Core Version:    0.7.0.1
 */