package com.tencent.mm.plugin.appbrand;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/BindRemoteServiceResult;", "Landroid/os/Parcelable;", "errCode", "", "errMsg", "", "(ILjava/lang/String;)V", "getErrCode", "()I", "getErrMsg", "()Ljava/lang/String;", "component1", "component2", "copy", "describeContents", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "plugin-appbrand-integration_release"})
final class BindRemoteServiceResult
  implements Parcelable
{
  public static final Parcelable.Creator CREATOR;
  final int errCode;
  final String errMsg;
  
  static
  {
    AppMethodBeat.i(275081);
    CREATOR = new a();
    AppMethodBeat.o(275081);
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
    AppMethodBeat.i(275079);
    if (this != paramObject)
    {
      if ((paramObject instanceof BindRemoteServiceResult))
      {
        paramObject = (BindRemoteServiceResult)paramObject;
        if ((this.errCode != paramObject.errCode) || (!p.h(this.errMsg, paramObject.errMsg))) {}
      }
    }
    else
    {
      AppMethodBeat.o(275079);
      return true;
    }
    AppMethodBeat.o(275079);
    return false;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(275078);
    int j = this.errCode;
    String str = this.errMsg;
    if (str != null) {}
    for (int i = str.hashCode();; i = 0)
    {
      AppMethodBeat.o(275078);
      return i + j * 31;
    }
  }
  
  public final String toString()
  {
    AppMethodBeat.i(275077);
    String str = "BindRemoteServiceResult(errCode=" + this.errCode + ", errMsg=" + this.errMsg + ")";
    AppMethodBeat.o(275077);
    return str;
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(275080);
    p.k(paramParcel, "parcel");
    paramParcel.writeInt(this.errCode);
    paramParcel.writeString(this.errMsg);
    AppMethodBeat.o(275080);
  }
  
  @l(iBK={1, 1, 16})
  public static final class a
    implements Parcelable.Creator
  {
    public final Object createFromParcel(Parcel paramParcel)
    {
      AppMethodBeat.i(271645);
      p.k(paramParcel, "in");
      paramParcel = new BindRemoteServiceResult(paramParcel.readInt(), paramParcel.readString());
      AppMethodBeat.o(271645);
      return paramParcel;
    }
    
    public final Object[] newArray(int paramInt)
    {
      return new BindRemoteServiceResult[paramInt];
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.BindRemoteServiceResult
 * JD-Core Version:    0.7.0.1
 */