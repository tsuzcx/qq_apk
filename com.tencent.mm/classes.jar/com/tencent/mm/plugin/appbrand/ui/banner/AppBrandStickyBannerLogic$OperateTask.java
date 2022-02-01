package com.tencent.mm.plugin.appbrand.ui.banner;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;

final class AppBrandStickyBannerLogic$OperateTask
  extends MainProcessTask
{
  public static final Parcelable.Creator<OperateTask> CREATOR;
  boolean mNb;
  String mNc;
  int mNd;
  String mNe;
  int op = 0;
  
  static
  {
    AppMethodBeat.i(49023);
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(49023);
  }
  
  public final void aOX()
  {
    AppMethodBeat.i(49019);
    switch (this.op)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(49019);
      return;
      this.mNb = AppBrandStickyBannerLogic.b.bAX();
      biG();
      AppMethodBeat.o(49019);
      return;
      AppBrandStickyBannerLogic.b.bAZ();
      AppMethodBeat.o(49019);
      return;
      AppBrandStickyBannerLogic.b.b(this);
    }
  }
  
  public final void e(Parcel paramParcel)
  {
    AppMethodBeat.i(49022);
    this.op = paramParcel.readInt();
    if (paramParcel.readByte() != 0) {}
    for (boolean bool = true;; bool = false)
    {
      this.mNb = bool;
      this.mNc = paramParcel.readString();
      this.mNd = paramParcel.readInt();
      this.mNe = paramParcel.readString();
      AppMethodBeat.o(49022);
      return;
    }
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(49021);
    super.writeToParcel(paramParcel, paramInt);
    paramParcel.writeInt(this.op);
    if (this.mNb) {}
    for (byte b = 1;; b = 0)
    {
      paramParcel.writeByte(b);
      paramParcel.writeString(this.mNc);
      paramParcel.writeInt(this.mNd);
      paramParcel.writeString(this.mNe);
      AppMethodBeat.o(49021);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.banner.AppBrandStickyBannerLogic.OperateTask
 * JD-Core Version:    0.7.0.1
 */