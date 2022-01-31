package com.tencent.mm.plugin.appbrand.menu;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.appbrand.l.f;

public class WxaMenuHelper$GetCopyPathMenuExpireTimeTask
  extends MainProcessTask
{
  public static final Parcelable.Creator<GetCopyPathMenuExpireTimeTask> CREATOR = new WxaMenuHelper.GetCopyPathMenuExpireTimeTask.1();
  private long gPC = 0L;
  private String mAppId;
  
  public WxaMenuHelper$GetCopyPathMenuExpireTimeTask(Parcel paramParcel)
  {
    e(paramParcel);
  }
  
  public WxaMenuHelper$GetCopyPathMenuExpireTimeTask(String paramString)
  {
    this.mAppId = paramString;
  }
  
  public final void Zu()
  {
    Object localObject = f.gPZ;
    localObject = f.bU(this.mAppId, "copypath");
    if (localObject == null)
    {
      this.gPC = 0L;
      return;
    }
    this.gPC = ((Long)localObject).longValue();
  }
  
  public final void e(Parcel paramParcel)
  {
    this.gPC = paramParcel.readLong();
    this.mAppId = paramParcel.readString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeLong(this.gPC);
    paramParcel.writeString(this.mAppId);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.menu.WxaMenuHelper.GetCopyPathMenuExpireTimeTask
 * JD-Core Version:    0.7.0.1
 */