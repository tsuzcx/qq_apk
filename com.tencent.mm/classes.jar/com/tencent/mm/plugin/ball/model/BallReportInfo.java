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
  public String dwX;
  public String hPO;
  public int nGa;
  public int nGb;
  public int nGc;
  public String nGd;
  public String nGe;
  public String nGf;
  public int nGg;
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
    this.nGa = paramParcel.readInt();
    this.nGb = paramParcel.readInt();
    this.nGc = paramParcel.readInt();
    this.dwX = paramParcel.readString();
    this.nGd = paramParcel.readString();
    this.hPO = paramParcel.readString();
    this.opType = paramParcel.readInt();
    this.nGe = paramParcel.readString();
    this.nGf = paramParcel.readString();
    this.nGg = paramParcel.readInt();
    AppMethodBeat.o(127550);
  }
  
  BallReportInfo(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(127553);
    this.nGe = paramJSONObject.optString("r_internal_sessionId", null);
    this.nGf = paramJSONObject.optString("r_internal_aggregationSessionId", null);
    this.nGg = paramJSONObject.optInt("r_internal_taskOrder", 1);
    AppMethodBeat.o(127553);
  }
  
  public final JSONObject bKr()
  {
    AppMethodBeat.i(127552);
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("r_internal_sessionId", this.nGe);
      localJSONObject.put("r_internal_aggregationSessionId", this.nGf);
      localJSONObject.put("r_internal_taskOrder", this.nGg);
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
    AppMethodBeat.i(189771);
    String str = "BallReportInfo{generateType=" + this.nGa + ", generateScene=" + this.nGb + ", bizScene=" + this.nGc + ", bizId='" + this.dwX + '\'' + ", bizSubId='" + this.nGd + '\'' + ", bizName='" + this.hPO + '\'' + ", opType=" + this.opType + ", internal_sessionId='" + this.nGe + '\'' + ", internal_aggregationSessionId='" + this.nGf + '\'' + ", internal_taskOrder=" + this.nGg + '}';
    AppMethodBeat.o(189771);
    return str;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(127551);
    paramParcel.writeInt(this.nGa);
    paramParcel.writeInt(this.nGb);
    paramParcel.writeInt(this.nGc);
    paramParcel.writeString(this.dwX);
    paramParcel.writeString(this.nGd);
    paramParcel.writeString(this.hPO);
    paramParcel.writeInt(this.opType);
    paramParcel.writeString(this.nGe);
    paramParcel.writeString(this.nGf);
    paramParcel.writeInt(this.nGg);
    AppMethodBeat.o(127551);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.ball.model.BallReportInfo
 * JD-Core Version:    0.7.0.1
 */