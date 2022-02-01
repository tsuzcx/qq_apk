package com.tencent.mm.plugin.appbrand.ipc;

import android.os.Parcel;
import android.os.Parcelable;

public abstract class AppBrandProxyUIProcessTask$ProcessRequest
  implements Parcelable
{
  public AppBrandProxyUIProcessTask$ProcessRequest() {}
  
  public AppBrandProxyUIProcessTask$ProcessRequest(Parcel paramParcel)
  {
    j(paramParcel);
  }
  
  protected abstract Class<? extends AppBrandProxyUIProcessTask> bhv();
  
  protected boolean biA()
  {
    return false;
  }
  
  protected String biB()
  {
    return null;
  }
  
  protected int biC()
  {
    return -1;
  }
  
  protected boolean biD()
  {
    return false;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  protected void j(Parcel paramParcel) {}
  
  public void writeToParcel(Parcel paramParcel, int paramInt) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask.ProcessRequest
 * JD-Core Version:    0.7.0.1
 */