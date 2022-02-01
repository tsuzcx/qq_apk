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
  public String dPJ;
  public int hCZ;
  public int hDa;
  public String iNV;
  public String oWA;
  public String oWB;
  public int oWC;
  public int oWx;
  public String oWy;
  public int oWz;
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
    this.hCZ = paramParcel.readInt();
    this.oWx = paramParcel.readInt();
    this.hDa = paramParcel.readInt();
    this.dPJ = paramParcel.readString();
    this.oWy = paramParcel.readString();
    this.iNV = paramParcel.readString();
    this.opType = paramParcel.readInt();
    this.oWA = paramParcel.readString();
    this.oWB = paramParcel.readString();
    this.oWC = paramParcel.readInt();
    this.oWz = paramParcel.readInt();
    AppMethodBeat.o(127550);
  }
  
  BallReportInfo(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(127553);
    this.oWA = paramJSONObject.optString("r_internal_sessionId", null);
    this.oWB = paramJSONObject.optString("r_internal_aggregationSessionId", null);
    this.oWC = paramJSONObject.optInt("r_internal_taskOrder", 1);
    AppMethodBeat.o(127553);
  }
  
  public final JSONObject cii()
  {
    AppMethodBeat.i(127552);
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("r_internal_sessionId", this.oWA);
      localJSONObject.put("r_internal_aggregationSessionId", this.oWB);
      localJSONObject.put("r_internal_taskOrder", this.oWC);
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
    AppMethodBeat.i(188577);
    String str = "BallReportInfo{generateType=" + this.hCZ + ", generateScene=" + this.oWx + ", bizScene=" + this.hDa + ", bizId='" + this.dPJ + '\'' + ", bizSubId='" + this.oWy + '\'' + ", bizName='" + this.iNV + '\'' + ", opType=" + this.opType + ", internal_sessionId='" + this.oWA + '\'' + ", internal_aggregationSessionId='" + this.oWB + '\'' + ", internal_taskOrder=" + this.oWC + '}';
    AppMethodBeat.o(188577);
    return str;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(127551);
    paramParcel.writeInt(this.hCZ);
    paramParcel.writeInt(this.oWx);
    paramParcel.writeInt(this.hDa);
    paramParcel.writeString(this.dPJ);
    paramParcel.writeString(this.oWy);
    paramParcel.writeString(this.iNV);
    paramParcel.writeInt(this.opType);
    paramParcel.writeString(this.oWA);
    paramParcel.writeString(this.oWB);
    paramParcel.writeInt(this.oWC);
    paramParcel.writeInt(this.oWz);
    AppMethodBeat.o(127551);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.ball.model.BallReportInfo
 * JD-Core Version:    0.7.0.1
 */