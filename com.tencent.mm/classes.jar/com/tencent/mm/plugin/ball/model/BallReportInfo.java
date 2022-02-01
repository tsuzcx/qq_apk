package com.tencent.mm.plugin.ball.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import org.json.JSONException;
import org.json.JSONObject;

public class BallReportInfo
  implements Parcelable
{
  public static final Parcelable.Creator<BallReportInfo> CREATOR;
  public String dyc;
  public String hSG;
  public int nLA;
  public int nLB;
  public int nLC;
  public String nLD;
  public int nLE;
  public String nLF;
  public String nLG;
  public int nLH;
  public int opType;
  
  static
  {
    AppMethodBeat.i(127554);
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(127554);
  }
  
  BallReportInfo() {}
  
  protected BallReportInfo(Parcel paramParcel)
  {
    AppMethodBeat.i(127550);
    this.nLA = paramParcel.readInt();
    this.nLB = paramParcel.readInt();
    this.nLC = paramParcel.readInt();
    this.dyc = paramParcel.readString();
    this.nLD = paramParcel.readString();
    this.hSG = paramParcel.readString();
    this.opType = paramParcel.readInt();
    this.nLF = paramParcel.readString();
    this.nLG = paramParcel.readString();
    this.nLH = paramParcel.readInt();
    this.nLE = paramParcel.readInt();
    AppMethodBeat.o(127550);
  }
  
  BallReportInfo(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(127553);
    this.nLF = paramJSONObject.optString("r_internal_sessionId", null);
    this.nLG = paramJSONObject.optString("r_internal_aggregationSessionId", null);
    this.nLH = paramJSONObject.optInt("r_internal_taskOrder", 1);
    AppMethodBeat.o(127553);
  }
  
  public final JSONObject bLo()
  {
    AppMethodBeat.i(127552);
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("r_internal_sessionId", this.nLF);
      localJSONObject.put("r_internal_aggregationSessionId", this.nLG);
      localJSONObject.put("r_internal_taskOrder", this.nLH);
      AppMethodBeat.o(127552);
      return localJSONObject;
    }
    catch (JSONException localJSONException)
    {
      AppMethodBeat.o(127552);
    }
    return localJSONObject;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String toString()
  {
    AppMethodBeat.i(200287);
    String str = "BallReportInfo{generateType=" + this.nLA + ", generateScene=" + this.nLB + ", bizScene=" + this.nLC + ", bizId='" + this.dyc + '\'' + ", bizSubId='" + this.nLD + '\'' + ", bizName='" + this.hSG + '\'' + ", opType=" + this.opType + ", internal_sessionId='" + this.nLF + '\'' + ", internal_aggregationSessionId='" + this.nLG + '\'' + ", internal_taskOrder=" + this.nLH + '}';
    AppMethodBeat.o(200287);
    return str;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(127551);
    paramParcel.writeInt(this.nLA);
    paramParcel.writeInt(this.nLB);
    paramParcel.writeInt(this.nLC);
    paramParcel.writeString(this.dyc);
    paramParcel.writeString(this.nLD);
    paramParcel.writeString(this.hSG);
    paramParcel.writeInt(this.opType);
    paramParcel.writeString(this.nLF);
    paramParcel.writeString(this.nLG);
    paramParcel.writeInt(this.nLH);
    paramParcel.writeInt(this.nLE);
    AppMethodBeat.o(127551);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.ball.model.BallReportInfo
 * JD-Core Version:    0.7.0.1
 */