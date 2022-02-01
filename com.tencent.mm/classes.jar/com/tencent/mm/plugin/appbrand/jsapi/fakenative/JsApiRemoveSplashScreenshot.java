package com.tencent.mm.plugin.appbrand.jsapi.fakenative;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.b;
import com.tencent.mm.ipcinvoker.type.IPCVoid;
import com.tencent.mm.plugin.appbrand.jsapi.d;
import com.tencent.mm.plugin.appbrand.service.c;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/appbrand/jsapi/fakenative/JsApiRemoveSplashScreenshot;", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandAsyncJsApi;", "Lcom/tencent/mm/plugin/appbrand/service/AppBrandServiceWC;", "()V", "invoke", "", "env", "data", "Lorg/json/JSONObject;", "callbackId", "", "Companion", "RemoveParams", "plugin-appbrand-integration_release"})
public final class JsApiRemoveSplashScreenshot
  extends d<c>
{
  public static final int CTRL_INDEX = -2;
  public static final String NAME = "removeSplashScreenshot";
  @Deprecated
  public static final a lUp;
  
  static
  {
    AppMethodBeat.i(228409);
    lUp = new a((byte)0);
    AppMethodBeat.o(228409);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/appbrand/jsapi/fakenative/JsApiRemoveSplashScreenshot$RemoveParams;", "Landroid/os/Parcelable;", "appId", "", "versionType", "", "(Ljava/lang/String;I)V", "getAppId", "()Ljava/lang/String;", "getVersionType", "()I", "component1", "component2", "copy", "describeContents", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "plugin-appbrand-integration_release"})
  static final class RemoveParams
    implements Parcelable
  {
    public static final Parcelable.Creator CREATOR;
    final String appId;
    final int iOo;
    
    static
    {
      AppMethodBeat.i(228405);
      CREATOR = new a();
      AppMethodBeat.o(228405);
    }
    
    public RemoveParams(String paramString, int paramInt)
    {
      AppMethodBeat.i(228400);
      this.appId = paramString;
      this.iOo = paramInt;
      AppMethodBeat.o(228400);
    }
    
    public final int describeContents()
    {
      return 0;
    }
    
    public final boolean equals(Object paramObject)
    {
      AppMethodBeat.i(228403);
      if (this != paramObject)
      {
        if ((paramObject instanceof RemoveParams))
        {
          paramObject = (RemoveParams)paramObject;
          if ((!p.j(this.appId, paramObject.appId)) || (this.iOo != paramObject.iOo)) {}
        }
      }
      else
      {
        AppMethodBeat.o(228403);
        return true;
      }
      AppMethodBeat.o(228403);
      return false;
    }
    
    public final int hashCode()
    {
      AppMethodBeat.i(228402);
      String str = this.appId;
      if (str != null) {}
      for (int i = str.hashCode();; i = 0)
      {
        int j = this.iOo;
        AppMethodBeat.o(228402);
        return i * 31 + j;
      }
    }
    
    public final String toString()
    {
      AppMethodBeat.i(228401);
      String str = "RemoveParams(appId=" + this.appId + ", versionType=" + this.iOo + ")";
      AppMethodBeat.o(228401);
      return str;
    }
    
    public final void writeToParcel(Parcel paramParcel, int paramInt)
    {
      AppMethodBeat.i(228404);
      p.h(paramParcel, "parcel");
      paramParcel.writeString(this.appId);
      paramParcel.writeInt(this.iOo);
      AppMethodBeat.o(228404);
    }
    
    @l(hxD={1, 1, 16})
    public static final class a
      implements Parcelable.Creator
    {
      public final Object createFromParcel(Parcel paramParcel)
      {
        AppMethodBeat.i(228399);
        p.h(paramParcel, "in");
        paramParcel = new JsApiRemoveSplashScreenshot.RemoveParams(paramParcel.readString(), paramParcel.readInt());
        AppMethodBeat.o(228399);
        return paramParcel;
      }
      
      public final Object[] newArray(int paramInt)
      {
        return new JsApiRemoveSplashScreenshot.RemoveParams[paramInt];
      }
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/appbrand/jsapi/fakenative/JsApiRemoveSplashScreenshot$Companion;", "", "()V", "CTRL_INDEX", "", "NAME", "", "TAG", "plugin-appbrand-integration_release"})
  static final class a {}
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "params", "Lcom/tencent/mm/plugin/appbrand/jsapi/fakenative/JsApiRemoveSplashScreenshot$RemoveParams;", "callback", "Lcom/tencent/mm/ipcinvoker/IPCInvokeCallback;", "Lcom/tencent/mm/ipcinvoker/type/IPCVoid;", "invoke"})
  static final class b<InputType, ResultType>
    implements b<JsApiRemoveSplashScreenshot.RemoveParams, IPCVoid>
  {
    public static final b lUq;
    
    static
    {
      AppMethodBeat.i(228407);
      lUq = new b();
      AppMethodBeat.o(228407);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.fakenative.JsApiRemoveSplashScreenshot
 * JD-Core Version:    0.7.0.1
 */