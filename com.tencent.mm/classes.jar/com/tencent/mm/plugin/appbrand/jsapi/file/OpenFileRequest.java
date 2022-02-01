package com.tencent.mm.plugin.appbrand.jsapi.file;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.ba.i;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask.ProcessRequest;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask.ProcessResult;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;

public final class OpenFileRequest
  extends AppBrandProxyUIProcessTask.ProcessRequest
{
  public static final Parcelable.Creator<OpenFileRequest> CREATOR;
  public String appId;
  public String filePath;
  public String lPJ;
  public boolean rvh;
  
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
  
  public final int describeContents()
  {
    return 0;
  }
  
  public final Class<? extends AppBrandProxyUIProcessTask> getTaskClass()
  {
    return OpenFileRequest.a.class;
  }
  
  public final String getUIAlias()
  {
    return "QbDocumentReader";
  }
  
  public final void readParcel(Parcel paramParcel)
  {
    boolean bool = true;
    AppMethodBeat.i(174834);
    super.readParcel(paramParcel);
    this.filePath = paramParcel.readString();
    this.lPJ = paramParcel.readString();
    this.appId = paramParcel.readString();
    if (paramParcel.readInt() == 1) {}
    for (;;)
    {
      this.rvh = bool;
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
    paramParcel.writeString(this.lPJ);
    paramParcel.writeString(this.appId);
    if (this.rvh) {}
    for (paramInt = 1;; paramInt = 0)
    {
      paramParcel.writeInt(paramInt);
      AppMethodBeat.o(174835);
      return;
    }
  }
  
  static final class OpenResult
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
    
    OpenResult() {}
    
    OpenResult(Parcel paramParcel)
    {
      super();
    }
    
    public final int describeContents()
    {
      return 0;
    }
    
    public final void readParcel(Parcel paramParcel)
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.file.OpenFileRequest
 * JD-Core Version:    0.7.0.1
 */