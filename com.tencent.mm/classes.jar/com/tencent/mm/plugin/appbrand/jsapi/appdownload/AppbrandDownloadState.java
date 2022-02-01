package com.tencent.mm.plugin.appbrand.jsapi.appdownload;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ac;
import org.json.JSONException;
import org.json.JSONObject;

public class AppbrandDownloadState
  implements Parcelable
{
  public static final Parcelable.Creator<AppbrandDownloadState> CREATOR;
  public String appId;
  public long cYu;
  public long kaO;
  public float kaP;
  public long progress;
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
    this.cYu = paramParcel.readLong();
    this.appId = paramParcel.readString();
    this.progress = paramParcel.readLong();
    this.kaO = paramParcel.readLong();
    this.kaP = paramParcel.readFloat();
    AppMethodBeat.o(45723);
  }
  
  public final JSONObject beV()
  {
    AppMethodBeat.i(45724);
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("state", this.state);
      localJSONObject.put("downloadId", this.cYu);
      localJSONObject.put("appId", this.appId);
      localJSONObject.put("progress", this.progress);
      localJSONObject.put("taskSize", this.kaO);
      localJSONObject.put("progressFloat", this.kaP);
      AppMethodBeat.o(45724);
      return localJSONObject;
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        ac.e("MicroMsg.AppbrandDownloadState", "toJsonObject: " + localJSONException.getMessage());
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
    paramParcel.writeLong(this.cYu);
    paramParcel.writeString(this.appId);
    paramParcel.writeLong(this.progress);
    paramParcel.writeLong(this.kaO);
    paramParcel.writeFloat(this.kaP);
    AppMethodBeat.o(45722);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.appdownload.AppbrandDownloadState
 * JD-Core Version:    0.7.0.1
 */