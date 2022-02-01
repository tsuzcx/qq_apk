package com.tencent.liteapp.report;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import org.json.JSONObject;

public class WxaLiteAppStartReport
  implements Parcelable
{
  public static final Parcelable.Creator<WxaLiteAppStartReport> CREATOR;
  public String appId;
  public boolean baY;
  public long egA;
  public long egB;
  public int egC;
  public long egD;
  public long egE;
  public long egF;
  public long egG;
  public String egj;
  public boolean egk;
  public boolean egm;
  public long egn;
  public long ego;
  public boolean egp;
  public boolean egq;
  public long egr;
  public long egs;
  public boolean egt;
  public long egu;
  public long egv;
  public boolean egw;
  public long egx;
  public long egy;
  public boolean egz;
  public String query;
  public long startTime;
  
  static
  {
    AppMethodBeat.i(219089);
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(219089);
  }
  
  public WxaLiteAppStartReport()
  {
    this.appId = "";
    this.query = "";
    this.egj = "";
    this.egk = false;
    this.baY = false;
    this.startTime = 0L;
    this.egm = false;
    this.egn = 0L;
    this.ego = 0L;
    this.egp = false;
    this.egq = false;
    this.egr = 0L;
    this.egs = 0L;
    this.egt = false;
    this.egu = 0L;
    this.egv = 0L;
    this.egw = false;
    this.egx = 0L;
    this.egy = 0L;
    this.egz = false;
    this.egA = 0L;
    this.egB = 0L;
    this.egC = 0;
    this.egD = 0L;
    this.egE = 0L;
    this.egF = 0L;
    this.egG = 0L;
  }
  
  protected WxaLiteAppStartReport(Parcel paramParcel)
  {
    AppMethodBeat.i(219083);
    this.appId = "";
    this.query = "";
    this.egj = "";
    this.egk = false;
    this.baY = false;
    this.startTime = 0L;
    this.egm = false;
    this.egn = 0L;
    this.ego = 0L;
    this.egp = false;
    this.egq = false;
    this.egr = 0L;
    this.egs = 0L;
    this.egt = false;
    this.egu = 0L;
    this.egv = 0L;
    this.egw = false;
    this.egx = 0L;
    this.egy = 0L;
    this.egz = false;
    this.egA = 0L;
    this.egB = 0L;
    this.egC = 0;
    this.egD = 0L;
    this.egE = 0L;
    this.egF = 0L;
    this.egG = 0L;
    this.appId = paramParcel.readString();
    this.query = paramParcel.readString();
    this.egj = paramParcel.readString();
    if (paramParcel.readByte() != 0)
    {
      bool1 = true;
      this.egk = bool1;
      if (paramParcel.readByte() == 0) {
        break label424;
      }
      bool1 = true;
      label196:
      this.baY = bool1;
      this.startTime = paramParcel.readLong();
      if (paramParcel.readByte() == 0) {
        break label429;
      }
      bool1 = true;
      label218:
      this.egm = bool1;
      this.egn = paramParcel.readLong();
      this.ego = paramParcel.readLong();
      if (paramParcel.readByte() == 0) {
        break label434;
      }
      bool1 = true;
      label248:
      this.egp = bool1;
      if (paramParcel.readByte() == 0) {
        break label439;
      }
      bool1 = true;
      label262:
      this.egq = bool1;
      this.egr = paramParcel.readLong();
      this.egs = paramParcel.readLong();
      if (paramParcel.readByte() == 0) {
        break label444;
      }
      bool1 = true;
      label292:
      this.egt = bool1;
      this.egu = paramParcel.readLong();
      this.egv = paramParcel.readLong();
      if (paramParcel.readByte() == 0) {
        break label449;
      }
      bool1 = true;
      label322:
      this.egw = bool1;
      this.egx = paramParcel.readLong();
      this.egy = paramParcel.readLong();
      if (paramParcel.readByte() == 0) {
        break label454;
      }
    }
    label424:
    label429:
    label434:
    label439:
    label444:
    label449:
    label454:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      this.egz = bool1;
      this.egA = paramParcel.readLong();
      this.egB = paramParcel.readLong();
      this.egC = paramParcel.readInt();
      this.egD = paramParcel.readLong();
      this.egE = paramParcel.readLong();
      this.egF = paramParcel.readLong();
      this.egG = paramParcel.readLong();
      AppMethodBeat.o(219083);
      return;
      bool1 = false;
      break;
      bool1 = false;
      break label196;
      bool1 = false;
      break label218;
      bool1 = false;
      break label248;
      bool1 = false;
      break label262;
      bool1 = false;
      break label292;
      bool1 = false;
      break label322;
    }
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public final String toJsonString()
  {
    AppMethodBeat.i(219099);
    Object localObject = new JSONObject();
    ((JSONObject)localObject).put("appId", this.appId);
    ((JSONObject)localObject).put("page", this.egj);
    ((JSONObject)localObject).put("query", this.query);
    ((JSONObject)localObject).put("preloadEngineCost", this.egv);
    ((JSONObject)localObject).put("preloadBaseLibCost", this.egy);
    ((JSONObject)localObject).put("showPageCost", this.egE);
    ((JSONObject)localObject).put("appCost", this.egF);
    ((JSONObject)localObject).put("renderPageCost", this.egG);
    ((JSONObject)localObject).put("showPageResult", this.egC);
    localObject = ((JSONObject)localObject).toString();
    AppMethodBeat.o(219099);
    return localObject;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    byte b2 = 1;
    AppMethodBeat.i(219115);
    paramParcel.writeString(this.appId);
    paramParcel.writeString(this.query);
    paramParcel.writeString(this.egj);
    if (this.egk)
    {
      b1 = 1;
      paramParcel.writeByte(b1);
      if (!this.baY) {
        break label284;
      }
      b1 = 1;
      label55:
      paramParcel.writeByte(b1);
      paramParcel.writeLong(this.startTime);
      if (!this.egm) {
        break label289;
      }
      b1 = 1;
      label77:
      paramParcel.writeByte(b1);
      paramParcel.writeLong(this.egn);
      paramParcel.writeLong(this.ego);
      if (!this.egp) {
        break label294;
      }
      b1 = 1;
      label107:
      paramParcel.writeByte(b1);
      if (!this.egq) {
        break label299;
      }
      b1 = 1;
      label121:
      paramParcel.writeByte(b1);
      paramParcel.writeLong(this.egr);
      paramParcel.writeLong(this.egs);
      if (!this.egt) {
        break label304;
      }
      b1 = 1;
      label151:
      paramParcel.writeByte(b1);
      paramParcel.writeLong(this.egu);
      paramParcel.writeLong(this.egv);
      if (!this.egw) {
        break label309;
      }
      b1 = 1;
      label181:
      paramParcel.writeByte(b1);
      paramParcel.writeLong(this.egx);
      paramParcel.writeLong(this.egy);
      if (!this.egz) {
        break label314;
      }
    }
    label284:
    label289:
    label294:
    label299:
    label304:
    label309:
    label314:
    for (byte b1 = b2;; b1 = 0)
    {
      paramParcel.writeByte(b1);
      paramParcel.writeLong(this.egA);
      paramParcel.writeLong(this.egB);
      paramParcel.writeInt(this.egC);
      paramParcel.writeLong(this.egD);
      paramParcel.writeLong(this.egE);
      paramParcel.writeLong(this.egF);
      paramParcel.writeLong(this.egG);
      AppMethodBeat.o(219115);
      return;
      b1 = 0;
      break;
      b1 = 0;
      break label55;
      b1 = 0;
      break label77;
      b1 = 0;
      break label107;
      b1 = 0;
      break label121;
      b1 = 0;
      break label151;
      b1 = 0;
      break label181;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.liteapp.report.WxaLiteAppStartReport
 * JD-Core Version:    0.7.0.1
 */