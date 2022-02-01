package com.tencent.mm.plugin.appbrand.luggage.export.functionalpage;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.api.d;
import com.tencent.mm.sdk.platformtools.ad;
import d.g.b.p;
import d.l;
import org.json.JSONException;
import org.json.JSONObject;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/appbrand/luggage/export/functionalpage/WechatNativeExtraDataInvokeFunctionalPage;", "Landroid/os/Parcelable;", "Lcom/tencent/mm/plugin/appbrand/api/IWeAppOpenNativeExtraData;", "obj", "Lorg/json/JSONObject;", "(Lorg/json/JSONObject;)V", "invokeTicket", "", "apiName", "args", "jsapiType", "wxa_scene", "", "packageName", "callbackActivity", "transitiveData", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getApiName", "()Ljava/lang/String;", "setApiName", "(Ljava/lang/String;)V", "getArgs", "setArgs", "getCallbackActivity", "setCallbackActivity", "getInvokeTicket", "setInvokeTicket", "getJsapiType", "setJsapiType", "getPackageName", "setPackageName", "getTransitiveData", "setTransitiveData", "getWxa_scene", "()I", "setWxa_scene", "(I)V", "describeContents", "fromJson", "", "fromJsonString", "jsonString", "toJsonString", "writeToParcel", "parcel", "Landroid/os/Parcel;", "flags", "Companion", "plugin-appbrand-integration_release"})
public final class WechatNativeExtraDataInvokeFunctionalPage
  implements Parcelable, d
{
  public static final Parcelable.Creator CREATOR;
  @Deprecated
  public static final a lPb;
  public String callbackActivity;
  public String invokeTicket;
  String jXV;
  public String lOX;
  public String lOY;
  String lOZ;
  int lPa;
  public String packageName;
  
  static
  {
    AppMethodBeat.i(189408);
    lPb = new a((byte)0);
    CREATOR = new b();
    AppMethodBeat.o(189408);
  }
  
  public WechatNativeExtraDataInvokeFunctionalPage(String paramString1, String paramString2, String paramString3, String paramString4, int paramInt, String paramString5, String paramString6, String paramString7)
  {
    this.invokeTicket = paramString1;
    this.lOX = paramString2;
    this.lOY = paramString3;
    this.lOZ = paramString4;
    this.lPa = paramInt;
    this.packageName = paramString5;
    this.callbackActivity = paramString6;
    this.jXV = paramString7;
  }
  
  public WechatNativeExtraDataInvokeFunctionalPage(JSONObject paramJSONObject)
  {
    this();
    AppMethodBeat.i(189407);
    Z(paramJSONObject);
    AppMethodBeat.o(189407);
  }
  
  public final void Z(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(189405);
    p.h(paramJSONObject, "obj");
    this.invokeTicket = paramJSONObject.getString("invokeTicket");
    this.lOX = paramJSONObject.getString("name");
    this.packageName = paramJSONObject.getString("packageName");
    this.lOY = paramJSONObject.getString("args");
    this.lOZ = paramJSONObject.getString("jsapiType");
    this.lPa = paramJSONObject.getInt("wxa_scene");
    this.callbackActivity = paramJSONObject.getString("callbackActivity");
    this.jXV = paramJSONObject.optString("transitiveData");
    AppMethodBeat.o(189405);
  }
  
  public final String aYt()
  {
    AppMethodBeat.i(189406);
    try
    {
      Object localObject = new JSONObject();
      ((JSONObject)localObject).put("invokeTicket", this.invokeTicket);
      ((JSONObject)localObject).put("name", this.lOX);
      ((JSONObject)localObject).put("args", this.lOY);
      ((JSONObject)localObject).put("jsapiType", this.lOZ);
      ((JSONObject)localObject).put("wxa_scene", this.lPa);
      ((JSONObject)localObject).put("packageName", this.packageName);
      ((JSONObject)localObject).put("callbackActivity", this.callbackActivity);
      ((JSONObject)localObject).put("transitiveData", this.jXV);
      localObject = ((JSONObject)localObject).toString();
      p.g(localObject, "obj.toString()");
      AppMethodBeat.o(189406);
      return localObject;
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        ad.printErrStackTrace("MicroMsg.AppBrand.WechatNativeExtraDataInvokeFunctionalPage", (Throwable)localJSONException, "", new Object[0]);
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
    AppMethodBeat.i(189409);
    p.h(paramParcel, "parcel");
    paramParcel.writeString(this.invokeTicket);
    paramParcel.writeString(this.lOX);
    paramParcel.writeString(this.lOY);
    paramParcel.writeString(this.lOZ);
    paramParcel.writeInt(this.lPa);
    paramParcel.writeString(this.packageName);
    paramParcel.writeString(this.callbackActivity);
    paramParcel.writeString(this.jXV);
    AppMethodBeat.o(189409);
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/appbrand/luggage/export/functionalpage/WechatNativeExtraDataInvokeFunctionalPage$Companion;", "", "()V", "TAG", "", "plugin-appbrand-integration_release"})
  static final class a {}
  
  @l(gfx={1, 1, 16})
  public static final class b
    implements Parcelable.Creator
  {
    public final Object createFromParcel(Parcel paramParcel)
    {
      AppMethodBeat.i(189404);
      p.h(paramParcel, "in");
      paramParcel = new WechatNativeExtraDataInvokeFunctionalPage(paramParcel.readString(), paramParcel.readString(), paramParcel.readString(), paramParcel.readString(), paramParcel.readInt(), paramParcel.readString(), paramParcel.readString(), paramParcel.readString());
      AppMethodBeat.o(189404);
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