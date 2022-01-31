package com.tencent.mm.plugin.appbrand.ui.banner;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;

final class AppBrandStickyBannerLogic$OperateTask
  extends MainProcessTask
{
  public static final Parcelable.Creator<OperateTask> CREATOR = new AppBrandStickyBannerLogic.OperateTask.1();
  String gwN;
  boolean hfP;
  int hfQ;
  String hfR;
  int op = 0;
  
  static OperateTask o(String paramString1, int paramInt, String paramString2)
  {
    OperateTask localOperateTask = new OperateTask();
    localOperateTask.op = 2;
    localOperateTask.gwN = paramString1;
    localOperateTask.hfQ = paramInt;
    localOperateTask.hfR = paramString2;
    return localOperateTask;
  }
  
  public final void Zu()
  {
    switch (this.op)
    {
    default: 
      return;
    case 1: 
      this.hfP = AppBrandStickyBannerLogic.b.apw();
      ahI();
      return;
    case 3: 
      AppBrandStickyBannerLogic.b.apy();
      return;
    }
    AppBrandStickyBannerLogic.b.b(this);
  }
  
  public final void e(Parcel paramParcel)
  {
    this.op = paramParcel.readInt();
    if (paramParcel.readByte() != 0) {}
    for (boolean bool = true;; bool = false)
    {
      this.hfP = bool;
      this.gwN = paramParcel.readString();
      this.hfQ = paramParcel.readInt();
      this.hfR = paramParcel.readString();
      return;
    }
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    super.writeToParcel(paramParcel, paramInt);
    paramParcel.writeInt(this.op);
    if (this.hfP) {}
    for (byte b = 1;; b = 0)
    {
      paramParcel.writeByte(b);
      paramParcel.writeString(this.gwN);
      paramParcel.writeInt(this.hfQ);
      paramParcel.writeString(this.hfR);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.banner.AppBrandStickyBannerLogic.OperateTask
 * JD-Core Version:    0.7.0.1
 */