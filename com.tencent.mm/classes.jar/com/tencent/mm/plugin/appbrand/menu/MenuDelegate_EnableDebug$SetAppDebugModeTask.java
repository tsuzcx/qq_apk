package com.tencent.mm.plugin.appbrand.menu;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mm.plugin.appbrand.app.e;
import com.tencent.mm.plugin.appbrand.config.c;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.sdk.platformtools.bk;

class MenuDelegate_EnableDebug$SetAppDebugModeTask
  extends MainProcessTask
{
  public static final Parcelable.Creator<SetAppDebugModeTask> CREATOR = new MenuDelegate_EnableDebug.SetAppDebugModeTask.1();
  public String appId;
  public boolean bIU;
  
  public final void Zu()
  {
    String str = this.appId;
    boolean bool = this.bIU;
    if ((bk.bl(str)) || (e.aaY() == null)) {
      return;
    }
    e.aaY().bi(str + "_AppDebugEnabled", String.valueOf(bool));
  }
  
  public final void e(Parcel paramParcel)
  {
    this.appId = paramParcel.readString();
    if (paramParcel.readByte() != 0) {}
    for (boolean bool = true;; bool = false)
    {
      this.bIU = bool;
      return;
    }
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.appId);
    if (this.bIU) {}
    for (byte b = 1;; b = 0)
    {
      paramParcel.writeByte(b);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.menu.MenuDelegate_EnableDebug.SetAppDebugModeTask
 * JD-Core Version:    0.7.0.1
 */