package com.tencent.mm.plugin.appbrand.config;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.List;
import org.json.JSONObject;

public final class WxaAttributes$WxaVersionInfo
  implements Parcelable
{
  public static final Parcelable.Creator<WxaVersionInfo> CREATOR;
  public int appVersion;
  public boolean cCh;
  public int cwX;
  public List<WxaAttributes.WxaWidgetInfo> mcN;
  public List<WxaAttributes.WxaVersionModuleInfo> moduleList;
  public WxaAttributes.WxaVersionCoverImageInfo obA;
  public List<WxaAttributes.WxaPluginCodeInfo> obB;
  public int obC;
  public boolean obD;
  public String obE;
  public String obF;
  public String obG;
  public long obH;
  public String obI;
  public String obJ;
  public String obK;
  public String obL;
  public WxaAttributes.HalfPage obM;
  public long obN;
  public String oby;
  public String obz;
  
  static
  {
    AppMethodBeat.i(123509);
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(123509);
  }
  
  public WxaAttributes$WxaVersionInfo()
  {
    this.obI = "";
    this.obJ = "";
    this.obK = "";
    this.obL = "";
    this.cCh = false;
  }
  
  protected WxaAttributes$WxaVersionInfo(Parcel paramParcel)
  {
    AppMethodBeat.i(123508);
    this.obI = "";
    this.obJ = "";
    this.obK = "";
    this.obL = "";
    this.cCh = false;
    this.appVersion = paramParcel.readInt();
    this.cwX = paramParcel.readInt();
    this.oby = paramParcel.readString();
    this.obz = paramParcel.readString();
    this.obA = ((WxaAttributes.WxaVersionCoverImageInfo)paramParcel.readParcelable(WxaAttributes.WxaVersionCoverImageInfo.class.getClassLoader()));
    this.obB = paramParcel.createTypedArrayList(WxaAttributes.WxaPluginCodeInfo.CREATOR);
    this.obC = paramParcel.readInt();
    this.moduleList = paramParcel.createTypedArrayList(WxaAttributes.WxaVersionModuleInfo.CREATOR);
    if (paramParcel.readByte() != 0)
    {
      bool1 = true;
      this.obD = bool1;
      this.obE = paramParcel.readString();
      this.obF = paramParcel.readString();
      this.obG = paramParcel.readString();
      this.mcN = paramParcel.createTypedArrayList(WxaAttributes.WxaWidgetInfo.CREATOR);
      this.obI = paramParcel.readString();
      this.obJ = paramParcel.readString();
      this.obK = paramParcel.readString();
      this.obL = paramParcel.readString();
      if (paramParcel.readByte() <= 0) {
        break label248;
      }
    }
    label248:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      this.cCh = bool1;
      this.obN = paramParcel.readLong();
      this.obM = ((WxaAttributes.HalfPage)paramParcel.readParcelable(WxaAttributes.HalfPage.class.getClassLoader()));
      AppMethodBeat.o(123508);
      return;
      bool1 = false;
      break;
    }
  }
  
  public static WxaVersionInfo afv(String paramString)
  {
    AppMethodBeat.i(123506);
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(123506);
      return null;
    }
    l = Util.currentTicks();
    try
    {
      JSONObject localJSONObject1 = new JSONObject(paramString);
      WxaVersionInfo localWxaVersionInfo = new WxaVersionInfo();
      localWxaVersionInfo.appVersion = localJSONObject1.optInt("AppVersion", 0);
      localWxaVersionInfo.cwX = localJSONObject1.optInt("VersionState", -1);
      localWxaVersionInfo.oby = localJSONObject1.optString("VersionMD5");
      localWxaVersionInfo.obz = localJSONObject1.optString("device_orientation");
      localWxaVersionInfo.obF = localJSONObject1.optString("client_js_ext_info");
      localWxaVersionInfo.obC = localJSONObject1.optInt("code_size");
      JSONObject localJSONObject2 = localJSONObject1.optJSONObject("loading_image_info");
      if (localJSONObject2 != null)
      {
        localWxaVersionInfo.obA = new WxaAttributes.WxaVersionCoverImageInfo();
        localWxaVersionInfo.obA.obw = localJSONObject2.optString("url");
        localWxaVersionInfo.obA.obx = localJSONObject2.optString("progressbar_color");
      }
      JSONObject localJSONObject3 = localJSONObject1.optJSONObject("fake_native_loading_style_info");
      if (localJSONObject3 != null)
      {
        localJSONObject2 = localJSONObject3.optJSONObject("white_style");
        localJSONObject3 = localJSONObject3.optJSONObject("black_style");
        if (localJSONObject2 != null)
        {
          if (localJSONObject2.has("navigation_bar_text_color")) {
            localWxaVersionInfo.obI = localJSONObject2.optString("navigation_bar_text_color");
          }
          if (localJSONObject2.has("background_color")) {
            localWxaVersionInfo.obJ = localJSONObject2.optString("background_color");
          }
        }
        if (localJSONObject3 != null)
        {
          if (localJSONObject3.has("navigation_bar_text_color")) {
            localWxaVersionInfo.obK = localJSONObject3.optString("navigation_bar_text_color");
          }
          if (localJSONObject3.has("background_color")) {
            localWxaVersionInfo.obL = localJSONObject3.optString("background_color");
          }
        }
      }
      localWxaVersionInfo.moduleList = WxaAttributes.WxaVersionModuleInfo.l(localJSONObject1.optJSONArray("module_list"));
      localWxaVersionInfo.obD = localJSONObject1.optBoolean("UseModule", false);
      localWxaVersionInfo.obE = localJSONObject1.optString("EntranceModule");
      localWxaVersionInfo.obG = localJSONObject1.optString("without_lib_md5");
      localWxaVersionInfo.mcN = WxaAttributes.WxaWidgetInfo.m(localJSONObject1.optJSONArray("widget_list"));
      localWxaVersionInfo.obB = WxaAttributes.WxaPluginCodeInfo.a(localWxaVersionInfo.mcN, localJSONObject1.opt("separated_plugin_list"), 22);
      localWxaVersionInfo.obH = localJSONObject1.optLong("ForceSyncUpdateWhenLaunchLastInterval", -1L);
      localWxaVersionInfo.cCh = localJSONObject1.optBoolean("resizable", false);
      localJSONObject2 = localJSONObject1.optJSONObject("halfPage");
      localWxaVersionInfo.obM = new WxaAttributes.HalfPage();
      if (localJSONObject2 != null) {
        localWxaVersionInfo.obM.oaT = localJSONObject2.optString("firstPageNavigationStyle");
      }
      localWxaVersionInfo.obN = localJSONObject1.optLong("template_id", -1L);
      Log.i("MicroMsg.AppBrand.WxaAttributes", "|runProfiled| WxaVersionInfo.fromJson cost:%d, length:%d", new Object[] { Long.valueOf(Util.currentTicks() - l), Integer.valueOf(paramString.length()) });
      paramString = localWxaVersionInfo;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Log.i("MicroMsg.AppBrand.WxaAttributes", "|runProfiled| WxaVersionInfo.fromJson cost:%d, length:%d", new Object[] { Long.valueOf(Util.currentTicks() - l), Integer.valueOf(paramString.length()) });
        paramString = null;
      }
    }
    finally
    {
      Log.i("MicroMsg.AppBrand.WxaAttributes", "|runProfiled| WxaVersionInfo.fromJson cost:%d, length:%d", new Object[] { Long.valueOf(Util.currentTicks() - l), Integer.valueOf(paramString.length()) });
      AppMethodBeat.o(123506);
    }
    AppMethodBeat.o(123506);
    return paramString;
  }
  
  public final int describeContents()
  {
    return 0;
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    int i = 1;
    AppMethodBeat.i(123507);
    paramParcel.writeInt(this.appVersion);
    paramParcel.writeInt(this.cwX);
    paramParcel.writeString(this.oby);
    paramParcel.writeString(this.obz);
    paramParcel.writeParcelable(this.obA, paramInt);
    paramParcel.writeTypedList(this.obB);
    paramParcel.writeInt(this.obC);
    paramParcel.writeTypedList(this.moduleList);
    byte b;
    if (this.obD)
    {
      b = 1;
      paramParcel.writeByte(b);
      paramParcel.writeString(this.obE);
      paramParcel.writeString(this.obF);
      paramParcel.writeString(this.obG);
      paramParcel.writeTypedList(this.mcN);
      paramParcel.writeString(this.obI);
      paramParcel.writeString(this.obJ);
      paramParcel.writeString(this.obK);
      paramParcel.writeString(this.obL);
      if (!this.cCh) {
        break label195;
      }
    }
    for (;;)
    {
      paramParcel.writeByte((byte)i);
      paramParcel.writeLong(this.obN);
      paramParcel.writeParcelable(this.obM, paramInt);
      AppMethodBeat.o(123507);
      return;
      b = 0;
      break;
      label195:
      i = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.config.WxaAttributes.WxaVersionInfo
 * JD-Core Version:    0.7.0.1
 */