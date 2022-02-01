package com.tencent.mm.plugin.appbrand.ipc;

import android.os.Parcel;
import android.os.Parcelable;

public abstract class AppBrandProxyUIProcessTask$ProcessResult
  implements Parcelable
{
  public AppBrandProxyUIProcessTask$ProcessResult() {}
  
  public AppBrandProxyUIProcessTask$ProcessResult(Parcel paramParcel)
  {
    readParcel(paramParcel);
  }
  
  protected abstract void readParcel(Parcel paramParcel);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask.ProcessResult
 * JD-Core Version:    0.7.0.1
 */