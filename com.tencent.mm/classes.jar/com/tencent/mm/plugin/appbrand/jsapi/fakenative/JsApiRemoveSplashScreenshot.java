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

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/appbrand/jsapi/fakenative/JsApiRemoveSplashScreenshot;", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandAsyncJsApi;", "Lcom/tencent/mm/plugin/appbrand/service/AppBrandServiceWC;", "()V", "invoke", "", "env", "data", "Lorg/json/JSONObject;", "callbackId", "", "Companion", "RemoveParams", "plugin-appbrand-integration_release"})
public final class JsApiRemoveSplashScreenshot
  extends a<c>
{
  public static final int CTRL_INDEX = -2;
  public static final String NAME = "removeSplashScreenshot";
  @Deprecated
  public static final a jPT;
  
  static
  {
    AppMethodBeat.i(196322);
    jPT = new a((byte)0);
    AppMethodBeat.o(196322);
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/appbrand/jsapi/fakenative/JsApiRemoveSplashScreenshot$RemoveParams;", "Landroid/os/Parcelable;", "appId", "", "versionType", "", "(Ljava/lang/String;I)V", "getAppId", "()Ljava/lang/String;", "getVersionType", "()I", "component1", "component2", "copy", "describeContents", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "plugin-appbrand-integration_release"})
  static final class RemoveParams
    implements Parcelable
  {
    public static final Parcelable.Creator CREATOR;
    final String appId;
    final int gXn;
    
    static
    {
      AppMethodBeat.i(196318);
      CREATOR = new a();
      AppMethodBeat.o(196318);
    }
    
    public RemoveParams(String paramString, int paramInt)
    {
      AppMethodBeat.i(196313);
      this.appId = paramString;
      this.gXn = paramInt;
      AppMethodBeat.o(196313);
    }
    
    public final int describeContents()
    {
      return 0;
    }
    
    public final boolean equals(Object paramObject)
    {
      AppMethodBeat.i(196316);
      if (this != paramObject)
      {
        if ((paramObject instanceof RemoveParams))
        {
          paramObject = (RemoveParams)paramObject;
          if ((!k.g(this.appId, paramObject.appId)) || (this.gXn != paramObject.gXn)) {}
        }
      }
      else
      {
        AppMethodBeat.o(196316);
        return true;
      }
      AppMethodBeat.o(196316);
      return false;
    }
    
    public final int hashCode()
    {
      AppMethodBeat.i(196315);
      String str = this.appId;
      if (str != null) {}
      for (int i = str.hashCode();; i = 0)
      {
        int j = this.gXn;
        AppMethodBeat.o(196315);
        return i * 31 + j;
      }
    }
    
    public final String toString()
    {
      AppMethodBeat.i(196314);
      String str = "RemoveParams(appId=" + this.appId + ", versionType=" + this.gXn + ")";
      AppMethodBeat.o(196314);
      return str;
    }
    
    public final void writeToParcel(Parcel paramParcel, int paramInt)
    {
      AppMethodBeat.i(196317);
      k.h(paramParcel, "parcel");
      paramParcel.writeString(this.appId);
      paramParcel.writeInt(this.gXn);
      AppMethodBeat.o(196317);
    }
    
    @l(fvt={1, 1, 16})
    public static final class a
      implements Parcelable.Creator
    {
      public final Object createFromParcel(Parcel paramParcel)
      {
        AppMethodBeat.i(196312);
        k.h(paramParcel, "in");
        paramParcel = new JsApiRemoveSplashScreenshot.RemoveParams(paramParcel.readString(), paramParcel.readInt());
        AppMethodBeat.o(196312);
        return paramParcel;
      }
      
      public final Object[] newArray(int paramInt)
      {
        return new JsApiRemoveSplashScreenshot.RemoveParams[paramInt];
      }
    }
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/appbrand/jsapi/fakenative/JsApiRemoveSplashScreenshot$Companion;", "", "()V", "CTRL_INDEX", "", "NAME", "", "TAG", "plugin-appbrand-integration_release"})
  static final class a {}
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "params", "Lcom/tencent/mm/plugin/appbrand/jsapi/fakenative/JsApiRemoveSplashScreenshot$RemoveParams;", "callback", "Lcom/tencent/mm/ipcinvoker/IPCInvokeCallback;", "Lcom/tencent/mm/ipcinvoker/type/IPCVoid;", "invoke"})
  static final class b<InputType, ResultType>
    implements b<JsApiRemoveSplashScreenshot.RemoveParams, IPCVoid>
  {
    public static final b jPU;
    
    static
    {
      AppMethodBeat.i(196320);
      jPU = new b();
      AppMethodBeat.o(196320);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.fakenative.JsApiRemoveSplashScreenshot
 * JD-Core Version:    0.7.0.1
 */