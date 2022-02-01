package com.tencent.mm.plugin.appbrand.jsapi.file;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask.ProcessResult;

final class OpenFileRequest$OpenResult
  extends AppBrandProxyUIProcessTask.ProcessResult
{
  public static final Parcelable.Creator<OpenResult> CREATOR;
  public int ret;
  
  static
  {
    AppMethodBeat.i(174833);
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(174833);
  }
  
  OpenFileRequest$OpenResult() {}
  
  OpenFileRequest$OpenResult(Parcel paramParcel)
  {
    super(paramParcel);
  }
  
  public final int describeContents()
  {
    return 0;
  }
  
  public final void j(Parcel paramParcel)
  {
    AppMethodBeat.i(174831);
    this.ret = paramParcel.readInt();
    AppMethodBeat.o(174831);
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(174832);
    paramParcel.writeInt(this.ret);
    AppMethodBeat.o(174832);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.file.OpenFileRequest.OpenResult
 * JD-Core Version:    0.7.0.1
 */