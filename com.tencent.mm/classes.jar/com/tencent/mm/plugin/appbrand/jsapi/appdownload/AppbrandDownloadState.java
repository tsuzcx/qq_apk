package com.tencent.mm.plugin.appbrand.jsapi.appdownload;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.mm.sdk.platformtools.y;
import org.json.JSONException;
import org.json.JSONObject;

public class AppbrandDownloadState
  implements Parcelable
{
  public static final Parcelable.Creator<AppbrandDownloadState> CREATOR = new AppbrandDownloadState.1();
  public String appId;
  public long bFb;
  public long bRL;
  public long ghK;
  public String state;
  
  public AppbrandDownloadState() {}
  
  private AppbrandDownloadState(Parcel paramParcel)
  {
    this.state = paramParcel.readString();
    this.bFb = paramParcel.readLong();
    this.appId = paramParcel.readString();
    this.bRL = paramParcel.readLong();
    this.ghK = paramParcel.readLong();
  }
  
  public final JSONObject ahT()
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("state", this.state);
      localJSONObject.put("downloadId", this.bFb);
      localJSONObject.put("appId", this.appId);
      localJSONObject.put("progress", this.bRL);
      localJSONObject.put("taskSize", this.ghK);
      return localJSONObject;
    }
    catch (JSONException localJSONException)
    {
      y.e("MicroMsg.AppbrandDownloadState", "toJsonObject: " + localJSONException.getMessage());
    }
    return localJSONObject;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.state);
    paramParcel.writeLong(this.bFb);
    paramParcel.writeString(this.appId);
    paramParcel.writeLong(this.bRL);
    paramParcel.writeLong(this.ghK);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.appdownload.AppbrandDownloadState
 * JD-Core Version:    0.7.0.1
 */