package com.tencent.mm.plugin.appbrand.jsapi.appdownload;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import org.json.JSONException;
import org.json.JSONObject;

public class AppbrandDownloadState
  implements Parcelable
{
  public static final Parcelable.Creator<AppbrandDownloadState> CREATOR;
  public String appId;
  public long hQO;
  public long hyV;
  public long rCm;
  public float rCn;
  public String state;
  
  static
  {
    AppMethodBeat.i(45725);
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(45725);
  }
  
  public AppbrandDownloadState() {}
  
  private AppbrandDownloadState(Parcel paramParcel)
  {
    AppMethodBeat.i(45723);
    this.state = paramParcel.readString();
    this.hyV = paramParcel.readLong();
    this.appId = paramParcel.readString();
    this.hQO = paramParcel.readLong();
    this.rCm = paramParcel.readLong();
    this.rCn = paramParcel.readFloat();
    AppMethodBeat.o(45723);
  }
  
  public final JSONObject cqc()
  {
    AppMethodBeat.i(45724);
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("state", this.state);
      localJSONObject.put("downloadId", this.hyV);
      localJSONObject.put("appId", this.appId);
      localJSONObject.put("progress", this.hQO);
      localJSONObject.put("taskSize", this.rCm);
      localJSONObject.put("progressFloat", this.rCn);
      AppMethodBeat.o(45724);
      return localJSONObject;
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        Log.e("MicroMsg.AppbrandDownloadState", "toJsonObject: " + localJSONException.getMessage());
      }
    }
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(45722);
    paramParcel.writeString(this.state);
    paramParcel.writeLong(this.hyV);
    paramParcel.writeString(this.appId);
    paramParcel.writeLong(this.hQO);
    paramParcel.writeLong(this.rCm);
    paramParcel.writeFloat(this.rCn);
    AppMethodBeat.o(45722);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.appdownload.AppbrandDownloadState
 * JD-Core Version:    0.7.0.1
 */