package com.tencent.mm.plugin.appbrand.luggage.export.functionalpage;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.api.d;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.Metadata;
import kotlin.g.b.s;
import org.json.JSONException;
import org.json.JSONObject;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/luggage/export/functionalpage/WechatNativeExtraDataInvokeFunctionalPage;", "Landroid/os/Parcelable;", "Lcom/tencent/mm/plugin/appbrand/api/IWeAppOpenNativeExtraData;", "obj", "Lorg/json/JSONObject;", "(Lorg/json/JSONObject;)V", "invokeTicket", "", "apiName", "args", "jsapiType", "isGame", "", "wxa_scene", "", "packageName", "callbackActivity", "transitiveData", "sessionId", "instanceId", "debugMode", "pageTitle", "currentH5Url", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;)V", "getApiName", "()Ljava/lang/String;", "setApiName", "(Ljava/lang/String;)V", "getArgs", "setArgs", "getCallbackActivity", "setCallbackActivity", "getCurrentH5Url", "setCurrentH5Url", "getDebugMode", "()I", "setDebugMode", "(I)V", "getInstanceId", "setInstanceId", "getInvokeTicket", "setInvokeTicket", "()Z", "setGame", "(Z)V", "getJsapiType", "setJsapiType", "getPackageName", "setPackageName", "getPageTitle", "setPageTitle", "getSessionId", "setSessionId", "getTransitiveData", "setTransitiveData", "getWxa_scene", "setWxa_scene", "describeContents", "fromJson", "", "fromJsonString", "jsonString", "toJsonString", "writeToParcel", "parcel", "Landroid/os/Parcel;", "flags", "Companion", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class WechatNativeExtraDataInvokeFunctionalPage
  implements Parcelable, d
{
  public static final Parcelable.Creator<WechatNativeExtraDataInvokeFunctionalPage> CREATOR;
  private static final WechatNativeExtraDataInvokeFunctionalPage.a tgr;
  public String callbackActivity;
  public String efV;
  boolean ekt;
  private String eup;
  public String invokeTicket;
  public String packageName;
  String qYI;
  private String sessionId;
  public String tgs;
  String tgt;
  int tgu;
  public int tgv;
  String tgw;
  String tgx;
  
  static
  {
    AppMethodBeat.i(320159);
    tgr = new WechatNativeExtraDataInvokeFunctionalPage.a((byte)0);
    CREATOR = (Parcelable.Creator)new b();
    AppMethodBeat.o(320159);
  }
  
  private WechatNativeExtraDataInvokeFunctionalPage(byte paramByte)
  {
    this();
  }
  
  public WechatNativeExtraDataInvokeFunctionalPage(String paramString1, String paramString2, String paramString3, String paramString4, boolean paramBoolean, int paramInt1, String paramString5, String paramString6, String paramString7, String paramString8, String paramString9, int paramInt2, String paramString10, String paramString11)
  {
    this.invokeTicket = paramString1;
    this.efV = paramString2;
    this.tgs = paramString3;
    this.tgt = paramString4;
    this.ekt = paramBoolean;
    this.tgu = paramInt1;
    this.packageName = paramString5;
    this.callbackActivity = paramString6;
    this.qYI = paramString7;
    this.sessionId = paramString8;
    this.eup = paramString9;
    this.tgv = paramInt2;
    this.tgw = paramString10;
    this.tgx = paramString11;
  }
  
  public WechatNativeExtraDataInvokeFunctionalPage(JSONObject paramJSONObject)
  {
    this();
    AppMethodBeat.i(320152);
    aA(paramJSONObject);
    AppMethodBeat.o(320152);
  }
  
  public final void aA(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(320166);
    s.u(paramJSONObject, "obj");
    this.invokeTicket = paramJSONObject.getString("invokeTicket");
    this.efV = paramJSONObject.getString("name");
    this.packageName = paramJSONObject.getString("packageName");
    this.tgs = paramJSONObject.getString("args");
    this.tgt = paramJSONObject.getString("jsapiType");
    this.ekt = paramJSONObject.optBoolean("isGame");
    this.tgu = paramJSONObject.getInt("wxa_scene");
    this.callbackActivity = paramJSONObject.getString("callbackActivity");
    this.qYI = paramJSONObject.optString("transitiveData");
    this.sessionId = paramJSONObject.optString("sessionId");
    this.eup = paramJSONObject.optString("instanceId");
    this.tgv = paramJSONObject.optInt("debugMode");
    this.tgw = paramJSONObject.optString("title");
    this.tgx = paramJSONObject.optString("currentH5Url");
    AppMethodBeat.o(320166);
  }
  
  public final int describeContents()
  {
    return 0;
  }
  
  public final String toJsonString()
  {
    AppMethodBeat.i(320173);
    try
    {
      Object localObject = new JSONObject();
      ((JSONObject)localObject).put("invokeTicket", this.invokeTicket);
      ((JSONObject)localObject).put("name", this.efV);
      ((JSONObject)localObject).put("args", this.tgs);
      ((JSONObject)localObject).put("jsapiType", this.tgt);
      ((JSONObject)localObject).put("isGame", this.ekt);
      ((JSONObject)localObject).put("wxa_scene", this.tgu);
      ((JSONObject)localObject).put("packageName", this.packageName);
      ((JSONObject)localObject).put("callbackActivity", this.callbackActivity);
      ((JSONObject)localObject).put("transitiveData", this.qYI);
      ((JSONObject)localObject).put("sessionId", this.sessionId);
      ((JSONObject)localObject).put("instanceId", this.eup);
      ((JSONObject)localObject).put("debugMode", this.tgv);
      ((JSONObject)localObject).put("title", this.tgw);
      ((JSONObject)localObject).put("currentH5Url", this.tgx);
      localObject = ((JSONObject)localObject).toString();
      s.s(localObject, "{\n            val obj = … obj.toString()\n        }");
      AppMethodBeat.o(320173);
      return localObject;
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        Log.printErrStackTrace("MicroMsg.AppBrand.WechatNativeExtraDataInvokeFunctionalPage", (Throwable)localJSONException, "", new Object[0]);
        String str = "{}";
      }
    }
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(320184);
    s.u(paramParcel, "out");
    paramParcel.writeString(this.invokeTicket);
    paramParcel.writeString(this.efV);
    paramParcel.writeString(this.tgs);
    paramParcel.writeString(this.tgt);
    if (this.ekt) {}
    for (paramInt = 1;; paramInt = 0)
    {
      paramParcel.writeInt(paramInt);
      paramParcel.writeInt(this.tgu);
      paramParcel.writeString(this.packageName);
      paramParcel.writeString(this.callbackActivity);
      paramParcel.writeString(this.qYI);
      paramParcel.writeString(this.sessionId);
      paramParcel.writeString(this.eup);
      paramParcel.writeInt(this.tgv);
      paramParcel.writeString(this.tgw);
      paramParcel.writeString(this.tgx);
      AppMethodBeat.o(320184);
      return;
    }
  }
  
  @Metadata(k=3, mv={1, 5, 1}, xi=48)
  public static final class b
    implements Parcelable.Creator<WechatNativeExtraDataInvokeFunctionalPage>
  {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.luggage.export.functionalpage.WechatNativeExtraDataInvokeFunctionalPage
 * JD-Core Version:    0.7.0.1
 */