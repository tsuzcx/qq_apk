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

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/appbrand/jsapi/fakenative/JsApiRemoveSplashScreenshot;", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandAsyncJsApi;", "Lcom/tencent/mm/plugin/appbrand/service/AppBrandServiceWC;", "()V", "invoke", "", "env", "data", "Lorg/json/JSONObject;", "callbackId", "", "Companion", "RemoveParams", "plugin-appbrand-integration_release"})
public final class JsApiRemoveSplashScreenshot
  extends a<c>
{
  public static final int CTRL_INDEX = -2;
  public static final String NAME = "removeSplashScreenshot";
  @Deprecated
  public static final a kPr;
  
  static
  {
    AppMethodBeat.i(223394);
    kPr = new a((byte)0);
    AppMethodBeat.o(223394);
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/appbrand/jsapi/fakenative/JsApiRemoveSplashScreenshot$RemoveParams;", "Landroid/os/Parcelable;", "appId", "", "versionType", "", "(Ljava/lang/String;I)V", "getAppId", "()Ljava/lang/String;", "getVersionType", "()I", "component1", "component2", "copy", "describeContents", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "plugin-appbrand-integration_release"})
  static final class RemoveParams
    implements Parcelable
  {
    public static final Parcelable.Creator CREATOR;
    final String appId;
    final int hSZ;
    
    static
    {
      AppMethodBeat.i(223390);
      CREATOR = new a();
      AppMethodBeat.o(223390);
    }
    
    public RemoveParams(String paramString, int paramInt)
    {
      AppMethodBeat.i(223385);
      this.appId = paramString;
      this.hSZ = paramInt;
      AppMethodBeat.o(223385);
    }
    
    public final int describeContents()
    {
      return 0;
    }
    
    public final boolean equals(Object paramObject)
    {
      AppMethodBeat.i(223388);
      if (this != paramObject)
      {
        if ((paramObject instanceof RemoveParams))
        {
          paramObject = (RemoveParams)paramObject;
          if ((!p.i(this.appId, paramObject.appId)) || (this.hSZ != paramObject.hSZ)) {}
        }
      }
      else
      {
        AppMethodBeat.o(223388);
        return true;
      }
      AppMethodBeat.o(223388);
      return false;
    }
    
    public final int hashCode()
    {
      AppMethodBeat.i(223387);
      String str = this.appId;
      if (str != null) {}
      for (int i = str.hashCode();; i = 0)
      {
        int j = this.hSZ;
        AppMethodBeat.o(223387);
        return i * 31 + j;
      }
    }
    
    public final String toString()
    {
      AppMethodBeat.i(223386);
      String str = "RemoveParams(appId=" + this.appId + ", versionType=" + this.hSZ + ")";
      AppMethodBeat.o(223386);
      return str;
    }
    
    public final void writeToParcel(Parcel paramParcel, int paramInt)
    {
      AppMethodBeat.i(223389);
      p.h(paramParcel, "parcel");
      paramParcel.writeString(this.appId);
      paramParcel.writeInt(this.hSZ);
      AppMethodBeat.o(223389);
    }
    
    @l(gjZ={1, 1, 16})
    public static final class a
      implements Parcelable.Creator
    {
      public final Object createFromParcel(Parcel paramParcel)
      {
        AppMethodBeat.i(223384);
        p.h(paramParcel, "in");
        paramParcel = new JsApiRemoveSplashScreenshot.RemoveParams(paramParcel.readString(), paramParcel.readInt());
        AppMethodBeat.o(223384);
        return paramParcel;
      }
      
      public final Object[] newArray(int paramInt)
      {
        return new JsApiRemoveSplashScreenshot.RemoveParams[paramInt];
      }
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/appbrand/jsapi/fakenative/JsApiRemoveSplashScreenshot$Companion;", "", "()V", "CTRL_INDEX", "", "NAME", "", "TAG", "plugin-appbrand-integration_release"})
  static final class a {}
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "params", "Lcom/tencent/mm/plugin/appbrand/jsapi/fakenative/JsApiRemoveSplashScreenshot$RemoveParams;", "callback", "Lcom/tencent/mm/ipcinvoker/IPCInvokeCallback;", "Lcom/tencent/mm/ipcinvoker/type/IPCVoid;", "invoke"})
  static final class b<InputType, ResultType>
    implements b<JsApiRemoveSplashScreenshot.RemoveParams, IPCVoid>
  {
    public static final b kPs;
    
    static
    {
      AppMethodBeat.i(223392);
      kPs = new b();
      AppMethodBeat.o(223392);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.fakenative.JsApiRemoveSplashScreenshot
 * JD-Core Version:    0.7.0.1
 */