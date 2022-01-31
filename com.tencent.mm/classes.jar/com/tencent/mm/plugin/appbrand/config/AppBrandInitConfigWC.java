package com.tencent.mm.plugin.appbrand.config;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.plugin.appbrand.report.quality.QualitySession;
import com.tencent.mm.sdk.platformtools.bk;
import org.json.JSONException;
import org.json.JSONObject;

public class AppBrandInitConfigWC
  extends AppBrandInitConfig
  implements Parcelable
{
  public static final Parcelable.Creator<AppBrandInitConfigWC> CREATOR = new AppBrandInitConfigWC.1();
  public int cau;
  public String dTX;
  public String dZN;
  public String extInfo;
  public String fJO;
  public String fPA;
  public int fPB;
  public QualitySession fPC;
  public boolean fPD = false;
  public transient AppBrandStatObject fPE;
  public boolean fPx;
  public boolean fPy;
  public boolean fPz;
  public long startTime;
  public int uin;
  public String username;
  
  AppBrandInitConfigWC() {}
  
  protected AppBrandInitConfigWC(Parcel paramParcel)
  {
    super(paramParcel);
    this.fJO = paramParcel.readString();
    this.username = paramParcel.readString();
    this.dZN = paramParcel.readString();
    this.dTX = paramParcel.readString();
    if (paramParcel.readByte() != 0)
    {
      bool1 = true;
      this.fPs = bool1;
      if (paramParcel.readByte() == 0) {
        break label184;
      }
      bool1 = true;
      label67:
      this.fPx = bool1;
      if (paramParcel.readByte() == 0) {
        break label189;
      }
      bool1 = true;
      label81:
      this.fPy = bool1;
      if (paramParcel.readByte() == 0) {
        break label194;
      }
      bool1 = true;
      label95:
      this.fPz = bool1;
      this.extInfo = paramParcel.readString();
      this.fPA = paramParcel.readString();
      this.startTime = paramParcel.readLong();
      this.cau = paramParcel.readInt();
      this.fPB = paramParcel.readInt();
      this.uin = paramParcel.readInt();
      this.fPC = ((QualitySession)paramParcel.readParcelable(QualitySession.class.getClassLoader()));
      if (paramParcel.readByte() == 0) {
        break label199;
      }
    }
    label184:
    label189:
    label194:
    label199:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      this.fPD = bool1;
      return;
      bool1 = false;
      break;
      bool1 = false;
      break label67;
      bool1 = false;
      break label81;
      bool1 = false;
      break label95;
    }
  }
  
  public final boolean ZH()
  {
    return this.bFB == 4;
  }
  
  public final void aee()
  {
    this.fJO = ("SessionId@" + hashCode() + "#" + bk.UY());
  }
  
  public final JSONObject aef()
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("shareKey", this.dTX);
      localJSONObject.put("shareName", this.dZN);
      if (localJSONObject.length() == 0) {
        return null;
      }
      return localJSONObject;
    }
    catch (JSONException localJSONException) {}
    return null;
  }
  
  public final JSONObject aeg()
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("appId", this.appId);
      localJSONObject.put("nickname", this.bJw);
      localJSONObject.put("icon", this.iconUrl);
      if (localJSONObject.length() == 0) {
        return null;
      }
      return localJSONObject;
    }
    catch (JSONException localJSONException) {}
    return null;
  }
  
  public final AppBrandInitConfigWC aeh()
  {
    Parcel localParcel = Parcel.obtain();
    localParcel.setDataPosition(0);
    writeToParcel(localParcel, 0);
    localParcel.setDataPosition(0);
    AppBrandInitConfigWC localAppBrandInitConfigWC = new AppBrandInitConfigWC(localParcel);
    localParcel.recycle();
    return localAppBrandInitConfigWC;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String toString()
  {
    return "AppBrandInitConfig{visitingSessionId='" + this.fJO + '\'' + ", username='" + this.username + '\'' + ", appId='" + this.appId + '\'' + ", brandName='" + this.bJw + '\'' + ", debugType=" + this.fEL + ", isPluginApp=" + this.fPs + ", preferRunInTools=" + this.fPy + ", orientation='" + this.fNK + '\'' + ", enterPath='" + this.fPq + '\'' + ", shareName='" + this.dZN + '\'' + ", shareKey='" + this.dTX + '\'' + ", startTime=" + this.startTime + ", attrsFromCgi=" + this.fPD + ", referrer=" + this.fPr + ", extInfo=" + this.extInfo + ", appVersion=" + this.cau + '}';
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    int i = 1;
    super.writeToParcel(paramParcel, paramInt);
    paramParcel.writeString(this.fJO);
    paramParcel.writeString(this.username);
    paramParcel.writeString(this.dZN);
    paramParcel.writeString(this.dTX);
    byte b;
    if (this.fPs)
    {
      b = 1;
      paramParcel.writeByte(b);
      if (!this.fPx) {
        break label176;
      }
      b = 1;
      label64:
      paramParcel.writeByte(b);
      if (!this.fPy) {
        break label181;
      }
      b = 1;
      label78:
      paramParcel.writeByte(b);
      if (!this.fPz) {
        break label186;
      }
      b = 1;
      label92:
      paramParcel.writeByte(b);
      paramParcel.writeString(this.extInfo);
      paramParcel.writeString(this.fPA);
      paramParcel.writeLong(this.startTime);
      paramParcel.writeInt(this.cau);
      paramParcel.writeInt(this.fPB);
      paramParcel.writeInt(this.uin);
      paramParcel.writeParcelable(this.fPC, paramInt);
      if (!this.fPD) {
        break label191;
      }
    }
    label176:
    label181:
    label186:
    label191:
    for (paramInt = i;; paramInt = 0)
    {
      paramParcel.writeByte((byte)paramInt);
      return;
      b = 0;
      break;
      b = 0;
      break label64;
      b = 0;
      break label78;
      b = 0;
      break label92;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.config.AppBrandInitConfigWC
 * JD-Core Version:    0.7.0.1
 */