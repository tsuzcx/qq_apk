package com.tencent.mm.plugin.appbrand.ui.banner;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;

final class AppBrandStickyBannerLogic$OperateTask
  extends MainProcessTask
{
  public static final Parcelable.Creator<OperateTask> CREATOR;
  boolean oao;
  String oap;
  int oaq;
  String oar;
  int op = 0;
  
  static
  {
    AppMethodBeat.i(49023);
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(49023);
  }
  
  public final void bjj()
  {
    AppMethodBeat.i(49019);
    switch (this.op)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(49019);
      return;
      this.oao = AppBrandStickyBannerLogic.b.bYc();
      bDU();
      AppMethodBeat.o(49019);
      return;
      AppBrandStickyBannerLogic.b.cr(this.oap, this.oaq);
      AppMethodBeat.o(49019);
      return;
      AppBrandStickyBannerLogic.b.b(this);
    }
  }
  
  public final void f(Parcel paramParcel)
  {
    AppMethodBeat.i(49022);
    this.op = paramParcel.readInt();
    if (paramParcel.readByte() != 0) {}
    for (boolean bool = true;; bool = false)
    {
      this.oao = bool;
      this.oap = paramParcel.readString();
      this.oaq = paramParcel.readInt();
      this.oar = paramParcel.readString();
      AppMethodBeat.o(49022);
      return;
    }
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(49021);
    super.writeToParcel(paramParcel, paramInt);
    paramParcel.writeInt(this.op);
    if (this.oao) {}
    for (byte b = 1;; b = 0)
    {
      paramParcel.writeByte(b);
      paramParcel.writeString(this.oap);
      paramParcel.writeInt(this.oaq);
      paramParcel.writeString(this.oar);
      AppMethodBeat.o(49021);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.banner.AppBrandStickyBannerLogic.OperateTask
 * JD-Core Version:    0.7.0.1
 */