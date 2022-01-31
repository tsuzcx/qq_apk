package com.tencent.mm.plugin.appbrand.jsapi.fakenative;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;

public final class OpenBusinessViewUtil$NavigateBackH5Task
  extends MainProcessTask
{
  public static final Parcelable.Creator<NavigateBackH5Task> CREATOR;
  public String businessType;
  public int errCode;
  public String extra;
  
  static
  {
    AppMethodBeat.i(131049);
    CREATOR = new OpenBusinessViewUtil.NavigateBackH5Task.1();
    AppMethodBeat.o(131049);
  }
  
  public OpenBusinessViewUtil$NavigateBackH5Task() {}
  
  public OpenBusinessViewUtil$NavigateBackH5Task(String paramString1, String paramString2, int paramInt)
  {
    this.businessType = paramString1;
    this.extra = paramString2;
    this.errCode = paramInt;
  }
  
  public final void ata()
  {
    AppMethodBeat.i(131046);
    OpenBusinessViewUtil.u(this.businessType, this.extra, this.errCode);
    AppMethodBeat.o(131046);
  }
  
  public final void f(Parcel paramParcel)
  {
    AppMethodBeat.i(131048);
    this.businessType = paramParcel.readString();
    this.extra = paramParcel.readString();
    this.errCode = paramParcel.readInt();
    AppMethodBeat.o(131048);
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(131047);
    paramParcel.writeString(this.businessType);
    paramParcel.writeString(this.extra);
    paramParcel.writeInt(this.errCode);
    AppMethodBeat.o(131047);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.fakenative.OpenBusinessViewUtil.NavigateBackH5Task
 * JD-Core Version:    0.7.0.1
 */