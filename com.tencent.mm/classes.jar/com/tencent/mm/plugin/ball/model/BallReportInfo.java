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
  public String fIZ;
  public int kqY;
  public int kqZ;
  public String lEm;
  public int opType;
  public String rYA;
  public String rYB;
  public int rYC;
  public int rYx;
  public String rYy;
  public int rYz;
  
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
    this.kqY = paramParcel.readInt();
    this.rYx = paramParcel.readInt();
    this.kqZ = paramParcel.readInt();
    this.fIZ = paramParcel.readString();
    this.rYy = paramParcel.readString();
    this.lEm = paramParcel.readString();
    this.opType = paramParcel.readInt();
    this.rYA = paramParcel.readString();
    this.rYB = paramParcel.readString();
    this.rYC = paramParcel.readInt();
    this.rYz = paramParcel.readInt();
    AppMethodBeat.o(127550);
  }
  
  BallReportInfo(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(127553);
    this.rYA = paramJSONObject.optString("r_internal_sessionId", null);
    this.rYB = paramJSONObject.optString("r_internal_aggregationSessionId", null);
    this.rYC = paramJSONObject.optInt("r_internal_taskOrder", 1);
    AppMethodBeat.o(127553);
  }
  
  public final JSONObject cvu()
  {
    AppMethodBeat.i(127552);
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("r_internal_sessionId", this.rYA);
      localJSONObject.put("r_internal_aggregationSessionId", this.rYB);
      localJSONObject.put("r_internal_taskOrder", this.rYC);
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
    AppMethodBeat.i(191163);
    String str = "BallReportInfo{generateType=" + this.kqY + ", generateScene=" + this.rYx + ", bizScene=" + this.kqZ + ", bizId='" + this.fIZ + '\'' + ", bizSubId='" + this.rYy + '\'' + ", bizName='" + this.lEm + '\'' + ", opType=" + this.opType + ", internal_sessionId='" + this.rYA + '\'' + ", internal_aggregationSessionId='" + this.rYB + '\'' + ", internal_taskOrder=" + this.rYC + '}';
    AppMethodBeat.o(191163);
    return str;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(127551);
    paramParcel.writeInt(this.kqY);
    paramParcel.writeInt(this.rYx);
    paramParcel.writeInt(this.kqZ);
    paramParcel.writeString(this.fIZ);
    paramParcel.writeString(this.rYy);
    paramParcel.writeString(this.lEm);
    paramParcel.writeInt(this.opType);
    paramParcel.writeString(this.rYA);
    paramParcel.writeString(this.rYB);
    paramParcel.writeInt(this.rYC);
    paramParcel.writeInt(this.rYz);
    AppMethodBeat.o(127551);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.ball.model.BallReportInfo
 * JD-Core Version:    0.7.0.1
 */