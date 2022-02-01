package com.tencent.mm.plugin.appbrand.jsapi.fakenative;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.b;
import com.tencent.mm.ipcinvoker.type.IPCVoid;
import com.tencent.mm.plugin.appbrand.jsapi.a;
import com.tencent.mm.plugin.appbrand.service.c;
import d.g.b.p;
import d.l;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/appbrand/jsapi/fakenative/JsApiRemoveSplashScreenshot;", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandAsyncJsApi;", "Lcom/tencent/mm/plugin/appbrand/service/AppBrandServiceWC;", "()V", "invoke", "", "env", "data", "Lorg/json/JSONObject;", "callbackId", "", "Companion", "RemoveParams", "plugin-appbrand-integration_release"})
public final class JsApiRemoveSplashScreenshot
  extends a<c>
{
  public static final int CTRL_INDEX = -2;
  public static final String NAME = "removeSplashScreenshot";
  @Deprecated
  public static final a kMb;
  
  static
  {
    AppMethodBeat.i(189135);
    kMb = new a((byte)0);
    AppMethodBeat.o(189135);
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/appbrand/jsapi/fakenative/JsApiRemoveSplashScreenshot$RemoveParams;", "Landroid/os/Parcelable;", "appId", "", "versionType", "", "(Ljava/lang/String;I)V", "getAppId", "()Ljava/lang/String;", "getVersionType", "()I", "component1", "component2", "copy", "describeContents", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "plugin-appbrand-integration_release"})
  static final class RemoveParams
    implements Parcelable
  {
    public static final Parcelable.Creator CREATOR;
    final String appId;
    final int hQh;
    
    static
    {
      AppMethodBeat.i(189131);
      CREATOR = new a();
      AppMethodBeat.o(189131);
    }
    
    public RemoveParams(String paramString, int paramInt)
    {
      AppMethodBeat.i(189126);
      this.appId = paramString;
      this.hQh = paramInt;
      AppMethodBeat.o(189126);
    }
    
    public final int describeContents()
    {
      return 0;
    }
    
    public final boolean equals(Object paramObject)
    {
      AppMethodBeat.i(189129);
      if (this != paramObject)
      {
        if ((paramObject instanceof RemoveParams))
        {
          paramObject = (RemoveParams)paramObject;
          if ((!p.i(this.appId, paramObject.appId)) || (this.hQh != paramObject.hQh)) {}
        }
      }
      else
      {
        AppMethodBeat.o(189129);
        return true;
      }
      AppMethodBeat.o(189129);
      return false;
    }
    
    public final int hashCode()
    {
      AppMethodBeat.i(189128);
      String str = this.appId;
      if (str != null) {}
      for (int i = str.hashCode();; i = 0)
      {
        int j = this.hQh;
        AppMethodBeat.o(189128);
        return i * 31 + j;
      }
    }
    
    public final String toString()
    {
      AppMethodBeat.i(189127);
      String str = "RemoveParams(appId=" + this.appId + ", versionType=" + this.hQh + ")";
      AppMethodBeat.o(189127);
      return str;
    }
    
    public final void writeToParcel(Parcel paramParcel, int paramInt)
    {
      AppMethodBeat.i(189130);
      p.h(paramParcel, "parcel");
      paramParcel.writeString(this.appId);
      paramParcel.writeInt(this.hQh);
      AppMethodBeat.o(189130);
    }
    
    @l(gfx={1, 1, 16})
    public static final class a
      implements Parcelable.Creator
    {
      public final Object createFromParcel(Parcel paramParcel)
      {
        AppMethodBeat.i(189125);
        p.h(paramParcel, "in");
        paramParcel = new JsApiRemoveSplashScreenshot.RemoveParams(paramParcel.readString(), paramParcel.readInt());
        AppMethodBeat.o(189125);
        return paramParcel;
      }
      
      public final Object[] newArray(int paramInt)
      {
        return new JsApiRemoveSplashScreenshot.RemoveParams[paramInt];
      }
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/appbrand/jsapi/fakenative/JsApiRemoveSplashScreenshot$Companion;", "", "()V", "CTRL_INDEX", "", "NAME", "", "TAG", "plugin-appbrand-integration_release"})
  static final class a {}
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "params", "Lcom/tencent/mm/plugin/appbrand/jsapi/fakenative/JsApiRemoveSplashScreenshot$RemoveParams;", "callback", "Lcom/tencent/mm/ipcinvoker/IPCInvokeCallback;", "Lcom/tencent/mm/ipcinvoker/type/IPCVoid;", "invoke"})
  static final class b<InputType, ResultType>
    implements b<JsApiRemoveSplashScreenshot.RemoveParams, IPCVoid>
  {
    public static final b kMc;
    
    static
    {
      AppMethodBeat.i(189133);
      kMc = new b();
      AppMethodBeat.o(189133);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.fakenative.JsApiRemoveSplashScreenshot
 * JD-Core Version:    0.7.0.1
 */