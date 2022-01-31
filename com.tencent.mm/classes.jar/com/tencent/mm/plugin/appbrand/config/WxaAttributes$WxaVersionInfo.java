package com.tencent.mm.plugin.appbrand.config;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.List;
import org.json.JSONObject;

public final class WxaAttributes$WxaVersionInfo
  implements Parcelable
{
  public static final Parcelable.Creator<WxaVersionInfo> CREATOR;
  public String bDb;
  public int bDc;
  public int bDd;
  public String hkd;
  public String hke;
  public WxaAttributes.WxaVersionCoverImageInfo hkf;
  public List<WxaAttributes.WxaCodeLibInfo> hkg;
  public int hkh;
  public boolean hki;
  public String hkj;
  public String hkk;
  public List<WxaAttributes.WxaVersionModuleInfo> moduleList;
  
  static
  {
    AppMethodBeat.i(140090);
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(140090);
  }
  
  public WxaAttributes$WxaVersionInfo() {}
  
  protected WxaAttributes$WxaVersionInfo(Parcel paramParcel)
  {
    AppMethodBeat.i(140089);
    this.bDc = paramParcel.readInt();
    this.bDd = paramParcel.readInt();
    this.hkd = paramParcel.readString();
    this.hke = paramParcel.readString();
    this.hkf = ((WxaAttributes.WxaVersionCoverImageInfo)paramParcel.readParcelable(WxaAttributes.WxaVersionCoverImageInfo.class.getClassLoader()));
    this.hkg = paramParcel.createTypedArrayList(WxaAttributes.WxaCodeLibInfo.CREATOR);
    this.hkh = paramParcel.readInt();
    this.moduleList = paramParcel.createTypedArrayList(WxaAttributes.WxaVersionModuleInfo.CREATOR);
    if (paramParcel.readByte() != 0) {}
    for (boolean bool = true;; bool = false)
    {
      this.hki = bool;
      this.hkj = paramParcel.readString();
      this.bDb = paramParcel.readString();
      this.hkk = paramParcel.readString();
      AppMethodBeat.o(140089);
      return;
    }
  }
  
  public static WxaVersionInfo AD(String paramString)
  {
    AppMethodBeat.i(96166);
    if (bo.isNullOrNil(paramString))
    {
      AppMethodBeat.o(96166);
      return null;
    }
    try
    {
      JSONObject localJSONObject1 = new JSONObject(paramString);
      paramString = new WxaVersionInfo();
      paramString.bDc = localJSONObject1.optInt("AppVersion", 0);
      paramString.bDd = localJSONObject1.optInt("VersionState", -1);
      paramString.hkd = localJSONObject1.optString("VersionMD5");
      paramString.hke = localJSONObject1.optString("device_orientation");
      paramString.bDb = localJSONObject1.optString("client_js_ext_info");
      paramString.hkh = localJSONObject1.optInt("code_size");
      JSONObject localJSONObject2 = localJSONObject1.optJSONObject("loading_image_info");
      if (localJSONObject2 != null)
      {
        paramString.hkf = new WxaAttributes.WxaVersionCoverImageInfo();
        paramString.hkf.hiF = localJSONObject2.optString("url");
        paramString.hkf.hiG = localJSONObject2.optString("progressbar_color");
      }
      paramString.moduleList = WxaAttributes.WxaVersionModuleInfo.AE(localJSONObject1.optString("module_list"));
      paramString.hkg = WxaAttributes.WxaCodeLibInfo.AC(localJSONObject1.optString("wxacode_lib_info_list"));
      paramString.hki = localJSONObject1.optBoolean("UseModule", false);
      paramString.hkj = localJSONObject1.optString("EntranceModule");
      paramString.hkk = localJSONObject1.optString("without_lib_md5");
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        paramString = null;
      }
    }
    AppMethodBeat.o(96166);
    return paramString;
  }
  
  public final int describeContents()
  {
    return 0;
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(140088);
    paramParcel.writeInt(this.bDc);
    paramParcel.writeInt(this.bDd);
    paramParcel.writeString(this.hkd);
    paramParcel.writeString(this.hke);
    paramParcel.writeParcelable(this.hkf, paramInt);
    paramParcel.writeTypedList(this.hkg);
    paramParcel.writeInt(this.hkh);
    paramParcel.writeTypedList(this.moduleList);
    if (this.hki) {}
    for (byte b = 1;; b = 0)
    {
      paramParcel.writeByte(b);
      paramParcel.writeString(this.hkj);
      paramParcel.writeString(this.bDb);
      paramParcel.writeString(this.hkk);
      AppMethodBeat.o(140088);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.config.WxaAttributes.WxaVersionInfo
 * JD-Core Version:    0.7.0.1
 */