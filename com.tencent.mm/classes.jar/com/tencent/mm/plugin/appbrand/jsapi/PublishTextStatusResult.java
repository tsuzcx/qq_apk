package com.tencent.mm.plugin.appbrand.jsapi;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask.ProcessResult;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/jsapi/PublishTextStatusResult;", "Lcom/tencent/mm/plugin/appbrand/ipc/AppBrandProxyUIProcessTask$ProcessResult;", "()V", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "errMsg", "", "getErrMsg$plugin_appbrand_integration_release", "()Ljava/lang/String;", "setErrMsg$plugin_appbrand_integration_release", "(Ljava/lang/String;)V", "result", "", "getResult$plugin_appbrand_integration_release", "()I", "setResult$plugin_appbrand_integration_release", "(I)V", "resultInfoBytes", "", "getResultInfoBytes$plugin_appbrand_integration_release", "()[B", "setResultInfoBytes$plugin_appbrand_integration_release", "([B)V", "describeContents", "readParcel", "", "writeToParcel", "dest", "flags", "CREATOR", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class PublishTextStatusResult
  extends AppBrandProxyUIProcessTask.ProcessResult
{
  public static final a CREATOR;
  String errMsg;
  byte[] rBD;
  int result;
  
  static
  {
    AppMethodBeat.i(325699);
    CREATOR = new a((byte)0);
    AppMethodBeat.o(325699);
  }
  
  public PublishTextStatusResult()
  {
    this.errMsg = "";
  }
  
  public PublishTextStatusResult(Parcel paramParcel)
  {
    AppMethodBeat.i(325694);
    this.errMsg = "";
    readParcel(paramParcel);
    AppMethodBeat.o(325694);
  }
  
  public final int describeContents()
  {
    return 0;
  }
  
  public final void readParcel(Parcel paramParcel)
  {
    AppMethodBeat.i(325700);
    s.u(paramParcel, "parcel");
    this.result = paramParcel.readInt();
    this.errMsg = paramParcel.readString();
    int i = paramParcel.readInt();
    if (i != 0)
    {
      byte[] arrayOfByte = new byte[i];
      paramParcel.readByteArray(arrayOfByte);
      this.rBD = arrayOfByte;
      AppMethodBeat.o(325700);
      return;
    }
    this.rBD = null;
    AppMethodBeat.o(325700);
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(325703);
    s.u(paramParcel, "dest");
    paramParcel.writeInt(this.result);
    paramParcel.writeString(this.errMsg);
    byte[] arrayOfByte = this.rBD;
    if (arrayOfByte == null) {}
    for (paramInt = 0;; paramInt = arrayOfByte.length)
    {
      paramParcel.writeInt(paramInt);
      if (paramInt != 0) {
        paramParcel.writeByteArray(this.rBD);
      }
      AppMethodBeat.o(325703);
      return;
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/jsapi/PublishTextStatusResult$CREATOR;", "Landroid/os/Parcelable$Creator;", "Lcom/tencent/mm/plugin/appbrand/jsapi/PublishTextStatusResult;", "()V", "createFromParcel", "source", "Landroid/os/Parcel;", "newArray", "", "size", "", "(I)[Lcom/tencent/mm/plugin/appbrand/jsapi/PublishTextStatusResult;", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
    implements Parcelable.Creator<PublishTextStatusResult>
  {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.PublishTextStatusResult
 * JD-Core Version:    0.7.0.1
 */