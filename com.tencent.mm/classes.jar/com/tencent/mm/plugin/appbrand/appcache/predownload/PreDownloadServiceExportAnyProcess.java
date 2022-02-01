package com.tencent.mm.plugin.appbrand.appcache.predownload;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.b;
import com.tencent.mm.ipcinvoker.type.IPCVoid;
import com.tencent.mm.ipcinvoker.wx_extension.b.a;
import com.tencent.mm.plugin.appbrand.service.w;
import java.util.List;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/appbrand/appcache/predownload/PreDownloadServiceExportAnyProcess;", "Lcom/tencent/mm/plugin/appbrand/service/IWxaPreDownloadServiceExport;", "()V", "triggerPreDownload", "", "username", "", "scene", "", "appId", "triggerPrefetchChattingItemAppBrandPiece", "triggerPrefetchChattingItemWeishiVideoFakeNative", "triggerPrefetchMallIndexWeAppLinks", "appLinks", "", "triggerPrefetchMallIndexWeAppV2", "appUsernames", "triggerPrefetchWeAppQRCode", "PreDownloadInvokeParams", "plugin-appbrand-integration_release"})
public final class PreDownloadServiceExportAnyProcess
  implements w
{
  public static final PreDownloadServiceExportAnyProcess kOX;
  
  static
  {
    AppMethodBeat.i(228004);
    kOX = new PreDownloadServiceExportAnyProcess();
    AppMethodBeat.o(228004);
  }
  
  public final void VA(String paramString) {}
  
  public final void bb(String paramString, int paramInt)
  {
    AppMethodBeat.i(228003);
    CharSequence localCharSequence = (CharSequence)paramString;
    if ((localCharSequence == null) || (localCharSequence.length() == 0)) {}
    for (int i = 1; i != 0; i = 0)
    {
      AppMethodBeat.o(228003);
      return;
    }
    a.a(new PreDownloadInvokeParams(paramString, paramInt), (b)a.kOY, null);
    AppMethodBeat.o(228003);
  }
  
  public final void bg(List<String> paramList) {}
  
  public final void bh(List<String> paramList) {}
  
  public final void bwL() {}
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/appbrand/appcache/predownload/PreDownloadServiceExportAnyProcess$PreDownloadInvokeParams;", "Landroid/os/Parcelable;", "username", "", "scene", "", "appId", "(Ljava/lang/String;ILjava/lang/String;)V", "getAppId", "()Ljava/lang/String;", "getScene", "()I", "getUsername", "component1", "component2", "component3", "copy", "describeContents", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "plugin-appbrand-integration_release"})
  public static final class PreDownloadInvokeParams
    implements Parcelable
  {
    public static final Parcelable.Creator CREATOR;
    private final String appId;
    final int scene;
    final String username;
    
    static
    {
      AppMethodBeat.i(228000);
      CREATOR = new a();
      AppMethodBeat.o(228000);
    }
    
    public PreDownloadInvokeParams(String paramString1, int paramInt, String paramString2)
    {
      this.username = paramString1;
      this.scene = paramInt;
      this.appId = paramString2;
    }
    
    public final int describeContents()
    {
      return 0;
    }
    
    public final boolean equals(Object paramObject)
    {
      AppMethodBeat.i(227998);
      if (this != paramObject)
      {
        if ((paramObject instanceof PreDownloadInvokeParams))
        {
          paramObject = (PreDownloadInvokeParams)paramObject;
          if ((!p.j(this.username, paramObject.username)) || (this.scene != paramObject.scene) || (!p.j(this.appId, paramObject.appId))) {}
        }
      }
      else
      {
        AppMethodBeat.o(227998);
        return true;
      }
      AppMethodBeat.o(227998);
      return false;
    }
    
    public final int hashCode()
    {
      int j = 0;
      AppMethodBeat.i(227997);
      String str = this.username;
      if (str != null) {}
      for (int i = str.hashCode();; i = 0)
      {
        int k = this.scene;
        str = this.appId;
        if (str != null) {
          j = str.hashCode();
        }
        AppMethodBeat.o(227997);
        return (i * 31 + k) * 31 + j;
      }
    }
    
    public final String toString()
    {
      AppMethodBeat.i(227996);
      String str = "PreDownloadInvokeParams(username=" + this.username + ", scene=" + this.scene + ", appId=" + this.appId + ")";
      AppMethodBeat.o(227996);
      return str;
    }
    
    public final void writeToParcel(Parcel paramParcel, int paramInt)
    {
      AppMethodBeat.i(227999);
      p.h(paramParcel, "parcel");
      paramParcel.writeString(this.username);
      paramParcel.writeInt(this.scene);
      paramParcel.writeString(this.appId);
      AppMethodBeat.o(227999);
    }
    
    @l(hxD={1, 1, 16})
    public static final class a
      implements Parcelable.Creator
    {
      public final Object createFromParcel(Parcel paramParcel)
      {
        AppMethodBeat.i(227995);
        p.h(paramParcel, "in");
        paramParcel = new PreDownloadServiceExportAnyProcess.PreDownloadInvokeParams(paramParcel.readString(), paramParcel.readInt(), paramParcel.readString());
        AppMethodBeat.o(227995);
        return paramParcel;
      }
      
      public final Object[] newArray(int paramInt)
      {
        return new PreDownloadServiceExportAnyProcess.PreDownloadInvokeParams[paramInt];
      }
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "data", "Lcom/tencent/mm/plugin/appbrand/appcache/predownload/PreDownloadServiceExportAnyProcess$PreDownloadInvokeParams;", "kotlin.jvm.PlatformType", "<anonymous parameter 1>", "Lcom/tencent/mm/ipcinvoker/IPCInvokeCallback;", "Lcom/tencent/mm/ipcinvoker/type/IPCVoid;", "invoke"})
  static final class a<InputType, ResultType>
    implements b<PreDownloadServiceExportAnyProcess.PreDownloadInvokeParams, IPCVoid>
  {
    public static final a kOY;
    
    static
    {
      AppMethodBeat.i(228002);
      kOY = new a();
      AppMethodBeat.o(228002);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appcache.predownload.PreDownloadServiceExportAnyProcess
 * JD-Core Version:    0.7.0.1
 */