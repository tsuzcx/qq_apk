package com.tencent.mm.plugin.appbrand.luggage.export.functionalpage;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.api.d;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.g.b.p;
import kotlin.l;
import org.json.JSONException;
import org.json.JSONObject;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/appbrand/luggage/export/functionalpage/WechatNativeExtraDataInvokeFunctionalPage;", "Landroid/os/Parcelable;", "Lcom/tencent/mm/plugin/appbrand/api/IWeAppOpenNativeExtraData;", "obj", "Lorg/json/JSONObject;", "(Lorg/json/JSONObject;)V", "invokeTicket", "", "apiName", "args", "jsapiType", "isGame", "", "wxa_scene", "", "packageName", "callbackActivity", "transitiveData", "sessionId", "instanceId", "debugMode", "pageTitle", "currentH5Url", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;)V", "getApiName", "()Ljava/lang/String;", "setApiName", "(Ljava/lang/String;)V", "getArgs", "setArgs", "getCallbackActivity", "setCallbackActivity", "getCurrentH5Url", "setCurrentH5Url", "getDebugMode", "()I", "setDebugMode", "(I)V", "getInstanceId", "setInstanceId", "getInvokeTicket", "setInvokeTicket", "()Z", "setGame", "(Z)V", "getJsapiType", "setJsapiType", "getPackageName", "setPackageName", "getPageTitle", "setPageTitle", "getSessionId", "setSessionId", "getTransitiveData", "setTransitiveData", "getWxa_scene", "setWxa_scene", "describeContents", "fromJson", "", "fromJsonString", "jsonString", "toJsonString", "writeToParcel", "parcel", "Landroid/os/Parcel;", "flags", "Companion", "plugin-appbrand-integration_release"})
public final class WechatNativeExtraDataInvokeFunctionalPage
  implements Parcelable, d
{
  public static final Parcelable.Creator CREATOR;
  @Deprecated
  public static final a nbi;
  public String callbackActivity;
  boolean cuy;
  public String invokeTicket;
  private String kEY;
  String les;
  public String nbb;
  public String nbc;
  String nbd;
  int nbe;
  public int nbf;
  String nbg;
  String nbh;
  public String packageName;
  private String sessionId;
  
  static
  {
    AppMethodBeat.i(228887);
    nbi = new a((byte)0);
    CREATOR = new b();
    AppMethodBeat.o(228887);
  }
  
  public WechatNativeExtraDataInvokeFunctionalPage(String paramString1, String paramString2, String paramString3, String paramString4, boolean paramBoolean, int paramInt1, String paramString5, String paramString6, String paramString7, String paramString8, String paramString9, int paramInt2, String paramString10, String paramString11)
  {
    this.invokeTicket = paramString1;
    this.nbb = paramString2;
    this.nbc = paramString3;
    this.nbd = paramString4;
    this.cuy = paramBoolean;
    this.nbe = paramInt1;
    this.packageName = paramString5;
    this.callbackActivity = paramString6;
    this.les = paramString7;
    this.sessionId = paramString8;
    this.kEY = paramString9;
    this.nbf = paramInt2;
    this.nbg = paramString10;
    this.nbh = paramString11;
  }
  
  public WechatNativeExtraDataInvokeFunctionalPage(JSONObject paramJSONObject)
  {
    this();
    AppMethodBeat.i(228886);
    am(paramJSONObject);
    AppMethodBeat.o(228886);
  }
  
  public final void am(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(228884);
    p.h(paramJSONObject, "obj");
    this.invokeTicket = paramJSONObject.getString("invokeTicket");
    this.nbb = paramJSONObject.getString("name");
    this.packageName = paramJSONObject.getString("packageName");
    this.nbc = paramJSONObject.getString("args");
    this.nbd = paramJSONObject.getString("jsapiType");
    this.cuy = paramJSONObject.optBoolean("isGame");
    this.nbe = paramJSONObject.getInt("wxa_scene");
    this.callbackActivity = paramJSONObject.getString("callbackActivity");
    this.les = paramJSONObject.optString("transitiveData");
    this.sessionId = paramJSONObject.optString("sessionId");
    this.kEY = paramJSONObject.optString("instanceId");
    this.nbf = paramJSONObject.optInt("debugMode");
    this.nbg = paramJSONObject.optString("title");
    this.nbh = paramJSONObject.optString("currentH5Url");
    AppMethodBeat.o(228884);
  }
  
  public final String bua()
  {
    AppMethodBeat.i(228885);
    try
    {
      Object localObject = new JSONObject();
      ((JSONObject)localObject).put("invokeTicket", this.invokeTicket);
      ((JSONObject)localObject).put("name", this.nbb);
      ((JSONObject)localObject).put("args", this.nbc);
      ((JSONObject)localObject).put("jsapiType", this.nbd);
      ((JSONObject)localObject).put("isGame", this.cuy);
      ((JSONObject)localObject).put("wxa_scene", this.nbe);
      ((JSONObject)localObject).put("packageName", this.packageName);
      ((JSONObject)localObject).put("callbackActivity", this.callbackActivity);
      ((JSONObject)localObject).put("transitiveData", this.les);
      ((JSONObject)localObject).put("sessionId", this.sessionId);
      ((JSONObject)localObject).put("instanceId", this.kEY);
      ((JSONObject)localObject).put("debugMode", this.nbf);
      ((JSONObject)localObject).put("title", this.nbg);
      ((JSONObject)localObject).put("currentH5Url", this.nbh);
      localObject = ((JSONObject)localObject).toString();
      p.g(localObject, "obj.toString()");
      AppMethodBeat.o(228885);
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
  
  public final int describeContents()
  {
    return 0;
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.provideAs(TypeTransformer.java:780)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.e1expr(TypeTransformer.java:496)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:713)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:698)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.s1stmt(TypeTransformer.java:810)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.sxStmt(TypeTransformer.java:840)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:206)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/appbrand/luggage/export/functionalpage/WechatNativeExtraDataInvokeFunctionalPage$Companion;", "", "()V", "TAG", "", "plugin-appbrand-integration_release"})
  static final class a {}
  
  @l(hxD={1, 1, 16})
  public static final class b
    implements Parcelable.Creator
  {
    public final Object createFromParcel(Parcel paramParcel)
    {
      AppMethodBeat.i(228883);
      p.h(paramParcel, "in");
      String str1 = paramParcel.readString();
      String str2 = paramParcel.readString();
      String str3 = paramParcel.readString();
      String str4 = paramParcel.readString();
      if (paramParcel.readInt() != 0) {}
      for (boolean bool = true;; bool = false)
      {
        paramParcel = new WechatNativeExtraDataInvokeFunctionalPage(str1, str2, str3, str4, bool, paramParcel.readInt(), paramParcel.readString(), paramParcel.readString(), paramParcel.readString(), paramParcel.readString(), paramParcel.readString(), paramParcel.readInt(), paramParcel.readString(), paramParcel.readString());
        AppMethodBeat.o(228883);
        return paramParcel;
      }
    }
    
    public final Object[] newArray(int paramInt)
    {
      return new WechatNativeExtraDataInvokeFunctionalPage[paramInt];
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.luggage.export.functionalpage.WechatNativeExtraDataInvokeFunctionalPage
 * JD-Core Version:    0.7.0.1
 */