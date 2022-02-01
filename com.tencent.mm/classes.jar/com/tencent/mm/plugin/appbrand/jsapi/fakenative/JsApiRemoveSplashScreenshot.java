package com.tencent.mm.plugin.appbrand.jsapi.fakenative;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.b;
import com.tencent.mm.ipcinvoker.type.IPCVoid;
import com.tencent.mm.plugin.appbrand.jsapi.a;
import com.tencent.mm.plugin.appbrand.service.c;
import d.g.b.k;
import d.l;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/appbrand/jsapi/fakenative/JsApiRemoveSplashScreenshot;", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandAsyncJsApi;", "Lcom/tencent/mm/plugin/appbrand/service/AppBrandServiceWC;", "()V", "invoke", "", "env", "data", "Lorg/json/JSONObject;", "callbackId", "", "Companion", "RemoveParams", "plugin-appbrand-integration_release"})
public final class JsApiRemoveSplashScreenshot
  extends a<c>
{
  public static final int CTRL_INDEX = -2;
  public static final String NAME = "removeSplashScreenshot";
  @Deprecated
  public static final a kqF;
  
  static
  {
    AppMethodBeat.i(187202);
    kqF = new a((byte)0);
    AppMethodBeat.o(187202);
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/appbrand/jsapi/fakenative/JsApiRemoveSplashScreenshot$RemoveParams;", "Landroid/os/Parcelable;", "appId", "", "versionType", "", "(Ljava/lang/String;I)V", "getAppId", "()Ljava/lang/String;", "getVersionType", "()I", "component1", "component2", "copy", "describeContents", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "plugin-appbrand-integration_release"})
  static final class RemoveParams
    implements Parcelable
  {
    public static final Parcelable.Creator CREATOR;
    final String appId;
    final int hxM;
    
    static
    {
      AppMethodBeat.i(187198);
      CREATOR = new a();
      AppMethodBeat.o(187198);
    }
    
    public RemoveParams(String paramString, int paramInt)
    {
      AppMethodBeat.i(187193);
      this.appId = paramString;
      this.hxM = paramInt;
      AppMethodBeat.o(187193);
    }
    
    public final int describeContents()
    {
      return 0;
    }
    
    public final boolean equals(Object paramObject)
    {
      AppMethodBeat.i(187196);
      if (this != paramObject)
      {
        if ((paramObject instanceof RemoveParams))
        {
          paramObject = (RemoveParams)paramObject;
          if ((!k.g(this.appId, paramObject.appId)) || (this.hxM != paramObject.hxM)) {}
        }
      }
      else
      {
        AppMethodBeat.o(187196);
        return true;
      }
      AppMethodBeat.o(187196);
      return false;
    }
    
    public final int hashCode()
    {
      AppMethodBeat.i(187195);
      String str = this.appId;
      if (str != null) {}
      for (int i = str.hashCode();; i = 0)
      {
        int j = this.hxM;
        AppMethodBeat.o(187195);
        return i * 31 + j;
      }
    }
    
    public final String toString()
    {
      AppMethodBeat.i(187194);
      String str = "RemoveParams(appId=" + this.appId + ", versionType=" + this.hxM + ")";
      AppMethodBeat.o(187194);
      return str;
    }
    
    public final void writeToParcel(Parcel paramParcel, int paramInt)
    {
      AppMethodBeat.i(187197);
      k.h(paramParcel, "parcel");
      paramParcel.writeString(this.appId);
      paramParcel.writeInt(this.hxM);
      AppMethodBeat.o(187197);
    }
    
    @l(fNY={1, 1, 16})
    public static final class a
      implements Parcelable.Creator
    {
      public final Object createFromParcel(Parcel paramParcel)
      {
        AppMethodBeat.i(187192);
        k.h(paramParcel, "in");
        paramParcel = new JsApiRemoveSplashScreenshot.RemoveParams(paramParcel.readString(), paramParcel.readInt());
        AppMethodBeat.o(187192);
        return paramParcel;
      }
      
      public final Object[] newArray(int paramInt)
      {
        return new JsApiRemoveSplashScreenshot.RemoveParams[paramInt];
      }
    }
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/appbrand/jsapi/fakenative/JsApiRemoveSplashScreenshot$Companion;", "", "()V", "CTRL_INDEX", "", "NAME", "", "TAG", "plugin-appbrand-integration_release"})
  static final class a {}
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "params", "Lcom/tencent/mm/plugin/appbrand/jsapi/fakenative/JsApiRemoveSplashScreenshot$RemoveParams;", "callback", "Lcom/tencent/mm/ipcinvoker/IPCInvokeCallback;", "Lcom/tencent/mm/ipcinvoker/type/IPCVoid;", "invoke"})
  static final class b<InputType, ResultType>
    implements b<JsApiRemoveSplashScreenshot.RemoveParams, IPCVoid>
  {
    public static final b kqG;
    
    static
    {
      AppMethodBeat.i(187200);
      kqG = new b();
      AppMethodBeat.o(187200);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.fakenative.JsApiRemoveSplashScreenshot
 * JD-Core Version:    0.7.0.1
 */