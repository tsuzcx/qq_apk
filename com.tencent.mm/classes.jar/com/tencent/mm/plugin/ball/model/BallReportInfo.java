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
  public String dlk;
  public String hxt;
  public int nfE;
  public int nfF;
  public int nfG;
  public String nfH;
  public String nfI;
  public String nfJ;
  public int nfK;
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
    this.nfE = paramParcel.readInt();
    this.nfF = paramParcel.readInt();
    this.nfG = paramParcel.readInt();
    this.dlk = paramParcel.readString();
    this.nfH = paramParcel.readString();
    this.hxt = paramParcel.readString();
    this.opType = paramParcel.readInt();
    this.nfI = paramParcel.readString();
    this.nfJ = paramParcel.readString();
    this.nfK = paramParcel.readInt();
    AppMethodBeat.o(127550);
  }
  
  BallReportInfo(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(127553);
    this.nfI = paramJSONObject.optString("r_internal_sessionId", null);
    this.nfJ = paramJSONObject.optString("r_internal_aggregationSessionId", null);
    this.nfK = paramJSONObject.optInt("r_internal_taskOrder", 1);
    AppMethodBeat.o(127553);
  }
  
  public final JSONObject bGg()
  {
    AppMethodBeat.i(127552);
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("r_internal_sessionId", this.nfI);
      localJSONObject.put("r_internal_aggregationSessionId", this.nfJ);
      localJSONObject.put("r_internal_taskOrder", this.nfK);
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
    AppMethodBeat.i(197152);
    String str = "BallReportInfo{generateType=" + this.nfE + ", generateScene=" + this.nfF + ", bizScene=" + this.nfG + ", bizId='" + this.dlk + '\'' + ", bizSubId='" + this.nfH + '\'' + ", bizName='" + this.hxt + '\'' + ", opType=" + this.opType + ", internal_sessionId='" + this.nfI + '\'' + ", internal_aggregationSessionId='" + this.nfJ + '\'' + ", internal_taskOrder=" + this.nfK + '}';
    AppMethodBeat.o(197152);
    return str;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(127551);
    paramParcel.writeInt(this.nfE);
    paramParcel.writeInt(this.nfF);
    paramParcel.writeInt(this.nfG);
    paramParcel.writeString(this.dlk);
    paramParcel.writeString(this.nfH);
    paramParcel.writeString(this.hxt);
    paramParcel.writeInt(this.opType);
    paramParcel.writeString(this.nfI);
    paramParcel.writeString(this.nfJ);
    paramParcel.writeInt(this.nfK);
    AppMethodBeat.o(127551);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.ball.model.BallReportInfo
 * JD-Core Version:    0.7.0.1
 */