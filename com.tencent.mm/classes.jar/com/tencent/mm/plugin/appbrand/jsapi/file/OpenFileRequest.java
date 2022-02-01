package com.tencent.mm.plugin.appbrand.jsapi.file;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask.ProcessRequest;

public final class OpenFileRequest
  extends AppBrandProxyUIProcessTask.ProcessRequest
{
  public static final Parcelable.Creator<OpenFileRequest> CREATOR;
  public String appId;
  public String filePath;
  public String gCr;
  public boolean lwF;
  
  static
  {
    AppMethodBeat.i(174836);
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(174836);
  }
  
  public OpenFileRequest() {}
  
  OpenFileRequest(Parcel paramParcel)
  {
    super(paramParcel);
  }
  
  public final Class<? extends AppBrandProxyUIProcessTask> bCJ()
  {
    return OpenFileRequest.a.class;
  }
  
  public final String bDO()
  {
    return "QbDocumentReader";
  }
  
  public final int describeContents()
  {
    return 0;
  }
  
  public final void k(Parcel paramParcel)
  {
    boolean bool = true;
    AppMethodBeat.i(174834);
    super.k(paramParcel);
    this.filePath = paramParcel.readString();
    this.gCr = paramParcel.readString();
    this.appId = paramParcel.readString();
    if (paramParcel.readInt() == 1) {}
    for (;;)
    {
      this.lwF = bool;
      AppMethodBeat.o(174834);
      return;
      bool = false;
    }
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(174835);
    super.writeToParcel(paramParcel, paramInt);
    paramParcel.writeString(this.filePath);
    paramParcel.writeString(this.gCr);
    paramParcel.writeString(this.appId);
    if (this.lwF) {}
    for (paramInt = 1;; paramInt = 0)
    {
      paramParcel.writeInt(paramInt);
      AppMethodBeat.o(174835);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.file.OpenFileRequest
 * JD-Core Version:    0.7.0.1
 */