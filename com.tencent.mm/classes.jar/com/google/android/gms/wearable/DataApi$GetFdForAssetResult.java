package com.google.android.gms.wearable;

import android.os.ParcelFileDescriptor;
import com.google.android.gms.common.api.Releasable;
import com.google.android.gms.common.api.Result;
import java.io.InputStream;

public abstract interface DataApi$GetFdForAssetResult
  extends Releasable, Result
{
  public abstract ParcelFileDescriptor getFd();
  
  public abstract InputStream getInputStream();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.google.android.gms.wearable.DataApi.GetFdForAssetResult
 * JD-Core Version:    0.7.0.1
 */