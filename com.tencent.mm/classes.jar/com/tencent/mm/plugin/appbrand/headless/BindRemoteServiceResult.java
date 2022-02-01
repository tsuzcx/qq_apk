package com.tencent.mm.plugin.appbrand.headless;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/headless/BindRemoteServiceResult;", "Landroid/os/Parcelable;", "errCode", "", "errMsg", "", "(ILjava/lang/String;)V", "getErrCode", "()I", "getErrMsg", "()Ljava/lang/String;", "component1", "component2", "copy", "describeContents", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
final class BindRemoteServiceResult
  implements Parcelable
{
  public static final Parcelable.Creator<BindRemoteServiceResult> CREATOR;
  final int errCode;
  final String errMsg;
  
  static
  {
    AppMethodBeat.i(317552);
    CREATOR = (Parcelable.Creator)new a();
    AppMethodBeat.o(317552);
  }
  
  public BindRemoteServiceResult(int paramInt, String paramString)
  {
    this.errCode = paramInt;
    this.errMsg = paramString;
  }
  
  public final int describeContents()
  {
    return 0;
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(317571);
    if (this == paramObject)
    {
      AppMethodBeat.o(317571);
      return true;
    }
    if (!(paramObject instanceof BindRemoteServiceResult))
    {
      AppMethodBeat.o(317571);
      return false;
    }
    paramObject = (BindRemoteServiceResult)paramObject;
    if (this.errCode != paramObject.errCode)
    {
      AppMethodBeat.o(317571);
      return false;
    }
    if (!s.p(this.errMsg, paramObject.errMsg))
    {
      AppMethodBeat.o(317571);
      return false;
    }
    AppMethodBeat.o(317571);
    return true;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(317564);
    int j = this.errCode;
    if (this.errMsg == null) {}
    for (int i = 0;; i = this.errMsg.hashCode())
    {
      AppMethodBeat.o(317564);
      return i + j * 31;
    }
  }
  
  public final String toString()
  {
    AppMethodBeat.i(317559);
    String str = "BindRemoteServiceResult(errCode=" + this.errCode + ", errMsg=" + this.errMsg + ')';
    AppMethodBeat.o(317559);
    return str;
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(317585);
    s.u(paramParcel, "out");
    paramParcel.writeInt(this.errCode);
    paramParcel.writeString(this.errMsg);
    AppMethodBeat.o(317585);
  }
  
  @Metadata(k=3, mv={1, 5, 1}, xi=48)
  public static final class a
    implements Parcelable.Creator<BindRemoteServiceResult>
  {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.headless.BindRemoteServiceResult
 * JD-Core Version:    0.7.0.1
 */