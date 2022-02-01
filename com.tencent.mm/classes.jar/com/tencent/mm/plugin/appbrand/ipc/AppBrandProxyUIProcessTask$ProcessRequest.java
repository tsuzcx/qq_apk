package com.tencent.mm.plugin.appbrand.ipc;

import android.os.Parcel;
import android.os.Parcelable;

public abstract class AppBrandProxyUIProcessTask$ProcessRequest
  implements Parcelable
{
  public AppBrandProxyUIProcessTask$ProcessRequest() {}
  
  public AppBrandProxyUIProcessTask$ProcessRequest(Parcel paramParcel)
  {
    k(paramParcel);
  }
  
  protected abstract Class<? extends AppBrandProxyUIProcessTask> bOe();
  
  protected boolean bPn()
  {
    return false;
  }
  
  protected String bPo()
  {
    return null;
  }
  
  protected int bPp()
  {
    return -1;
  }
  
  protected boolean bPq()
  {
    return false;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  protected void k(Parcel paramParcel) {}
  
  public void writeToParcel(Parcel paramParcel, int paramInt) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask.ProcessRequest
 * JD-Core Version:    0.7.0.1
 */