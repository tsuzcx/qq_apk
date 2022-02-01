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
  public String dnC;
  public String gWU;
  public String mDA;
  public String mDC;
  public String mDD;
  public int mDE;
  public int mDx;
  public int mDy;
  public int mDz;
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
    this.mDx = paramParcel.readInt();
    this.mDy = paramParcel.readInt();
    this.mDz = paramParcel.readInt();
    this.dnC = paramParcel.readString();
    this.mDA = paramParcel.readString();
    this.gWU = paramParcel.readString();
    this.opType = paramParcel.readInt();
    this.mDC = paramParcel.readString();
    this.mDD = paramParcel.readString();
    this.mDE = paramParcel.readInt();
    AppMethodBeat.o(127550);
  }
  
  BallReportInfo(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(127553);
    this.mDC = paramJSONObject.optString("r_internal_sessionId", null);
    this.mDD = paramJSONObject.optString("r_internal_aggregationSessionId", null);
    this.mDE = paramJSONObject.optInt("r_internal_taskOrder", 1);
    AppMethodBeat.o(127553);
  }
  
  public final JSONObject bzk()
  {
    AppMethodBeat.i(127552);
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("r_internal_sessionId", this.mDC);
      localJSONObject.put("r_internal_aggregationSessionId", this.mDD);
      localJSONObject.put("r_internal_taskOrder", this.mDE);
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
    AppMethodBeat.i(187815);
    String str = "BallReportInfo{generateType=" + this.mDx + ", generateScene=" + this.mDy + ", bizScene=" + this.mDz + ", bizId='" + this.dnC + '\'' + ", bizSubId='" + this.mDA + '\'' + ", bizName='" + this.gWU + '\'' + ", opType=" + this.opType + ", internal_sessionId='" + this.mDC + '\'' + ", internal_aggregationSessionId='" + this.mDD + '\'' + ", internal_taskOrder=" + this.mDE + '}';
    AppMethodBeat.o(187815);
    return str;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(127551);
    paramParcel.writeInt(this.mDx);
    paramParcel.writeInt(this.mDy);
    paramParcel.writeInt(this.mDz);
    paramParcel.writeString(this.dnC);
    paramParcel.writeString(this.mDA);
    paramParcel.writeString(this.gWU);
    paramParcel.writeInt(this.opType);
    paramParcel.writeString(this.mDC);
    paramParcel.writeString(this.mDD);
    paramParcel.writeInt(this.mDE);
    AppMethodBeat.o(127551);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.ball.model.BallReportInfo
 * JD-Core Version:    0.7.0.1
 */