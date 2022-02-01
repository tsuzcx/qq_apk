package com.tencent.mm.plugin.appbrand.luggage.export.functionalpage;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.api.d;
import com.tencent.mm.sdk.platformtools.ae;
import d.g.b.p;
import d.l;
import org.json.JSONException;
import org.json.JSONObject;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/appbrand/luggage/export/functionalpage/WechatNativeExtraDataInvokeFunctionalPage;", "Landroid/os/Parcelable;", "Lcom/tencent/mm/plugin/appbrand/api/IWeAppOpenNativeExtraData;", "obj", "Lorg/json/JSONObject;", "(Lorg/json/JSONObject;)V", "invokeTicket", "", "apiName", "args", "jsapiType", "wxa_scene", "", "packageName", "callbackActivity", "transitiveData", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getApiName", "()Ljava/lang/String;", "setApiName", "(Ljava/lang/String;)V", "getArgs", "setArgs", "getCallbackActivity", "setCallbackActivity", "getInvokeTicket", "setInvokeTicket", "getJsapiType", "setJsapiType", "getPackageName", "setPackageName", "getTransitiveData", "setTransitiveData", "getWxa_scene", "()I", "setWxa_scene", "(I)V", "describeContents", "fromJson", "", "fromJsonString", "jsonString", "toJsonString", "writeToParcel", "parcel", "Landroid/os/Parcel;", "flags", "Companion", "plugin-appbrand-integration_release"})
public final class WechatNativeExtraDataInvokeFunctionalPage
  implements Parcelable, d
{
  public static final Parcelable.Creator CREATOR;
  @Deprecated
  public static final a lTC;
  public String callbackActivity;
  public String invokeTicket;
  String kbk;
  String lTA;
  int lTB;
  public String lTy;
  public String lTz;
  public String packageName;
  
  static
  {
    AppMethodBeat.i(223668);
    lTC = new a((byte)0);
    CREATOR = new b();
    AppMethodBeat.o(223668);
  }
  
  public WechatNativeExtraDataInvokeFunctionalPage(String paramString1, String paramString2, String paramString3, String paramString4, int paramInt, String paramString5, String paramString6, String paramString7)
  {
    this.invokeTicket = paramString1;
    this.lTy = paramString2;
    this.lTz = paramString3;
    this.lTA = paramString4;
    this.lTB = paramInt;
    this.packageName = paramString5;
    this.callbackActivity = paramString6;
    this.kbk = paramString7;
  }
  
  public WechatNativeExtraDataInvokeFunctionalPage(JSONObject paramJSONObject)
  {
    this();
    AppMethodBeat.i(223667);
    Z(paramJSONObject);
    AppMethodBeat.o(223667);
  }
  
  public final void Z(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(223665);
    p.h(paramJSONObject, "obj");
    this.invokeTicket = paramJSONObject.getString("invokeTicket");
    this.lTy = paramJSONObject.getString("name");
    this.packageName = paramJSONObject.getString("packageName");
    this.lTz = paramJSONObject.getString("args");
    this.lTA = paramJSONObject.getString("jsapiType");
    this.lTB = paramJSONObject.getInt("wxa_scene");
    this.callbackActivity = paramJSONObject.getString("callbackActivity");
    this.kbk = paramJSONObject.optString("transitiveData");
    AppMethodBeat.o(223665);
  }
  
  public final String aYO()
  {
    AppMethodBeat.i(223666);
    try
    {
      Object localObject = new JSONObject();
      ((JSONObject)localObject).put("invokeTicket", this.invokeTicket);
      ((JSONObject)localObject).put("name", this.lTy);
      ((JSONObject)localObject).put("args", this.lTz);
      ((JSONObject)localObject).put("jsapiType", this.lTA);
      ((JSONObject)localObject).put("wxa_scene", this.lTB);
      ((JSONObject)localObject).put("packageName", this.packageName);
      ((JSONObject)localObject).put("callbackActivity", this.callbackActivity);
      ((JSONObject)localObject).put("transitiveData", this.kbk);
      localObject = ((JSONObject)localObject).toString();
      p.g(localObject, "obj.toString()");
      AppMethodBeat.o(223666);
      return localObject;
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        ae.printErrStackTrace("MicroMsg.AppBrand.WechatNativeExtraDataInvokeFunctionalPage", (Throwable)localJSONException, "", new Object[0]);
        String str = "{}";
      }
    }
  }
  
  public final int describeContents()
  {
    return 0;
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(223669);
    p.h(paramParcel, "parcel");
    paramParcel.writeString(this.invokeTicket);
    paramParcel.writeString(this.lTy);
    paramParcel.writeString(this.lTz);
    paramParcel.writeString(this.lTA);
    paramParcel.writeInt(this.lTB);
    paramParcel.writeString(this.packageName);
    paramParcel.writeString(this.callbackActivity);
    paramParcel.writeString(this.kbk);
    AppMethodBeat.o(223669);
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/appbrand/luggage/export/functionalpage/WechatNativeExtraDataInvokeFunctionalPage$Companion;", "", "()V", "TAG", "", "plugin-appbrand-integration_release"})
  static final class a {}
  
  @l(gjZ={1, 1, 16})
  public static final class b
    implements Parcelable.Creator
  {
    public final Object createFromParcel(Parcel paramParcel)
    {
      AppMethodBeat.i(223664);
      p.h(paramParcel, "in");
      paramParcel = new WechatNativeExtraDataInvokeFunctionalPage(paramParcel.readString(), paramParcel.readString(), paramParcel.readString(), paramParcel.readString(), paramParcel.readInt(), paramParcel.readString(), paramParcel.readString(), paramParcel.readString());
      AppMethodBeat.o(223664);
      return paramParcel;
    }
    
    public final Object[] newArray(int paramInt)
    {
      return new WechatNativeExtraDataInvokeFunctionalPage[paramInt];
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.luggage.export.functionalpage.WechatNativeExtraDataInvokeFunctionalPage
 * JD-Core Version:    0.7.0.1
 */