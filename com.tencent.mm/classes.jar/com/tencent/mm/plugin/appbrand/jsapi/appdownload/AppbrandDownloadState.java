package com.tencent.mm.plugin.appbrand.jsapi.appdownload;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import org.json.JSONException;
import org.json.JSONObject;

public class AppbrandDownloadState
  implements Parcelable
{
  public static final Parcelable.Creator<AppbrandDownloadState> CREATOR;
  public String appId;
  public long cmm;
  public long hAO;
  public float hAP;
  public long progress;
  public String state;
  
  static
  {
    AppMethodBeat.i(130637);
    CREATOR = new AppbrandDownloadState.1();
    AppMethodBeat.o(130637);
  }
  
  public AppbrandDownloadState() {}
  
  private AppbrandDownloadState(Parcel paramParcel)
  {
    AppMethodBeat.i(130635);
    this.state = paramParcel.readString();
    this.cmm = paramParcel.readLong();
    this.appId = paramParcel.readString();
    this.progress = paramParcel.readLong();
    this.hAO = paramParcel.readLong();
    this.hAP = paramParcel.readFloat();
    AppMethodBeat.o(130635);
  }
  
  public final JSONObject aBI()
  {
    AppMethodBeat.i(130636);
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("state", this.state);
      localJSONObject.put("downloadId", this.cmm);
      localJSONObject.put("appId", this.appId);
      localJSONObject.put("progress", this.progress);
      localJSONObject.put("taskSize", this.hAO);
      localJSONObject.put("progressFloat", this.hAP);
      AppMethodBeat.o(130636);
      return localJSONObject;
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        ab.e("MicroMsg.AppbrandDownloadState", "toJsonObject: " + localJSONException.getMessage());
      }
    }
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(130634);
    paramParcel.writeString(this.state);
    paramParcel.writeLong(this.cmm);
    paramParcel.writeString(this.appId);
    paramParcel.writeLong(this.progress);
    paramParcel.writeLong(this.hAO);
    paramParcel.writeFloat(this.hAP);
    AppMethodBeat.o(130634);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.appdownload.AppbrandDownloadState
 * JD-Core Version:    0.7.0.1
 */