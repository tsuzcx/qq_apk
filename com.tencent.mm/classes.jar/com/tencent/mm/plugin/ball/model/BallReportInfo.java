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
  public String hOH;
  public int mUT;
  public int mUU;
  public int opType;
  public String ovT;
  public int vjN;
  public String vjO;
  public int vjP;
  public String vjQ;
  public String vjR;
  public int vjS;
  
  static
  {
    AppMethodBeat.i(127554);
    CREATOR = new BallReportInfo.1();
    AppMethodBeat.o(127554);
  }
  
  BallReportInfo() {}
  
  protected BallReportInfo(Parcel paramParcel)
  {
    AppMethodBeat.i(127550);
    this.mUT = paramParcel.readInt();
    this.vjN = paramParcel.readInt();
    this.mUU = paramParcel.readInt();
    this.hOH = paramParcel.readString();
    this.vjO = paramParcel.readString();
    this.ovT = paramParcel.readString();
    this.opType = paramParcel.readInt();
    this.vjQ = paramParcel.readString();
    this.vjR = paramParcel.readString();
    this.vjS = paramParcel.readInt();
    this.vjP = paramParcel.readInt();
    AppMethodBeat.o(127550);
  }
  
  BallReportInfo(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(127553);
    this.vjQ = paramJSONObject.optString("r_internal_sessionId", null);
    this.vjR = paramJSONObject.optString("r_internal_aggregationSessionId", null);
    this.vjS = paramJSONObject.optInt("r_internal_taskOrder", 1);
    AppMethodBeat.o(127553);
  }
  
  public final JSONObject cYf()
  {
    AppMethodBeat.i(127552);
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("r_internal_sessionId", this.vjQ);
      localJSONObject.put("r_internal_aggregationSessionId", this.vjR);
      localJSONObject.put("r_internal_taskOrder", this.vjS);
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
    AppMethodBeat.i(288360);
    String str = "BallReportInfo{generateType=" + this.mUT + ", generateScene=" + this.vjN + ", bizScene=" + this.mUU + ", bizId='" + this.hOH + '\'' + ", bizSubId='" + this.vjO + '\'' + ", bizName='" + this.ovT + '\'' + ", opType=" + this.opType + ", internal_sessionId='" + this.vjQ + '\'' + ", internal_aggregationSessionId='" + this.vjR + '\'' + ", internal_taskOrder=" + this.vjS + '}';
    AppMethodBeat.o(288360);
    return str;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(127551);
    paramParcel.writeInt(this.mUT);
    paramParcel.writeInt(this.vjN);
    paramParcel.writeInt(this.mUU);
    paramParcel.writeString(this.hOH);
    paramParcel.writeString(this.vjO);
    paramParcel.writeString(this.ovT);
    paramParcel.writeInt(this.opType);
    paramParcel.writeString(this.vjQ);
    paramParcel.writeString(this.vjR);
    paramParcel.writeInt(this.vjS);
    paramParcel.writeInt(this.vjP);
    AppMethodBeat.o(127551);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.ball.model.BallReportInfo
 * JD-Core Version:    0.7.0.1
 */