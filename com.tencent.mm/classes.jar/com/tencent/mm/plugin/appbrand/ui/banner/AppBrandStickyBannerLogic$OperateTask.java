package com.tencent.mm.plugin.appbrand.ui.banner;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;

final class AppBrandStickyBannerLogic$OperateTask
  extends MainProcessTask
{
  public static final Parcelable.Creator<OperateTask> CREATOR;
  String hSW;
  boolean iRd;
  int iRe;
  String iRf;
  int op = 0;
  
  static
  {
    AppMethodBeat.i(133304);
    CREATOR = new AppBrandStickyBannerLogic.OperateTask.1();
    AppMethodBeat.o(133304);
  }
  
  static OperateTask o(String paramString1, int paramInt, String paramString2)
  {
    AppMethodBeat.i(133301);
    OperateTask localOperateTask = new OperateTask();
    localOperateTask.op = 2;
    localOperateTask.hSW = paramString1;
    localOperateTask.iRe = paramInt;
    localOperateTask.iRf = paramString2;
    AppMethodBeat.o(133301);
    return localOperateTask;
  }
  
  public final void ata()
  {
    AppMethodBeat.i(133300);
    switch (this.op)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(133300);
      return;
      this.iRd = AppBrandStickyBannerLogic.b.aMM();
      aBp();
      AppMethodBeat.o(133300);
      return;
      AppBrandStickyBannerLogic.b.aMO();
      AppMethodBeat.o(133300);
      return;
      AppBrandStickyBannerLogic.b.b(this);
    }
  }
  
  public final void f(Parcel paramParcel)
  {
    AppMethodBeat.i(133303);
    this.op = paramParcel.readInt();
    if (paramParcel.readByte() != 0) {}
    for (boolean bool = true;; bool = false)
    {
      this.iRd = bool;
      this.hSW = paramParcel.readString();
      this.iRe = paramParcel.readInt();
      this.iRf = paramParcel.readString();
      AppMethodBeat.o(133303);
      return;
    }
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(133302);
    super.writeToParcel(paramParcel, paramInt);
    paramParcel.writeInt(this.op);
    if (this.iRd) {}
    for (byte b = 1;; b = 0)
    {
      paramParcel.writeByte(b);
      paramParcel.writeString(this.hSW);
      paramParcel.writeInt(this.iRe);
      paramParcel.writeString(this.iRf);
      AppMethodBeat.o(133302);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.banner.AppBrandStickyBannerLogic.OperateTask
 * JD-Core Version:    0.7.0.1
 */