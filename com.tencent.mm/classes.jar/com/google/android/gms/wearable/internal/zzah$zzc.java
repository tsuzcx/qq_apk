package com.google.android.gms.wearable.internal;

import android.os.ParcelFileDescriptor;
import android.os.ParcelFileDescriptor.AutoCloseInputStream;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.wearable.DataApi.GetFdForAssetResult;
import java.io.IOException;
import java.io.InputStream;

public class zzah$zzc
  implements DataApi.GetFdForAssetResult
{
  private volatile boolean mClosed = false;
  private final Status zzair;
  private volatile InputStream zzbUf;
  private volatile ParcelFileDescriptor zzbUu;
  
  public zzah$zzc(Status paramStatus, ParcelFileDescriptor paramParcelFileDescriptor)
  {
    this.zzair = paramStatus;
    this.zzbUu = paramParcelFileDescriptor;
  }
  
  public ParcelFileDescriptor getFd()
  {
    if (this.mClosed) {
      throw new IllegalStateException("Cannot access the file descriptor after release().");
    }
    return this.zzbUu;
  }
  
  public InputStream getInputStream()
  {
    if (this.mClosed) {
      throw new IllegalStateException("Cannot access the input stream after release().");
    }
    if (this.zzbUu == null) {
      return null;
    }
    if (this.zzbUf == null) {
      this.zzbUf = new ParcelFileDescriptor.AutoCloseInputStream(this.zzbUu);
    }
    return this.zzbUf;
  }
  
  public Status getStatus()
  {
    return this.zzair;
  }
  
  public void release()
  {
    if (this.zzbUu == null) {
      return;
    }
    if (this.mClosed) {
      throw new IllegalStateException("releasing an already released result.");
    }
    try
    {
      if (this.zzbUf != null) {
        this.zzbUf.close();
      }
      for (;;)
      {
        this.mClosed = true;
        this.zzbUu = null;
        this.zzbUf = null;
        return;
        this.zzbUu.close();
      }
      return;
    }
    catch (IOException localIOException) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.google.android.gms.wearable.internal.zzah.zzc
 * JD-Core Version:    0.7.0.1
 */