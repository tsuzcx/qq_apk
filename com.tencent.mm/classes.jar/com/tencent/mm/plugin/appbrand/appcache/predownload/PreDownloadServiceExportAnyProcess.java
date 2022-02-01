package com.tencent.mm.plugin.appbrand.appcache.predownload;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.d;
import com.tencent.mm.ipcinvoker.type.IPCVoid;
import com.tencent.mm.ipcinvoker.wx_extension.b.a;
import com.tencent.mm.plugin.appbrand.service.w;
import java.util.List;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/appcache/predownload/PreDownloadServiceExportAnyProcess;", "Lcom/tencent/mm/plugin/appbrand/service/IWxaPreDownloadServiceExport;", "()V", "triggerPreDownload", "", "username", "", "scene", "", "appId", "triggerPrefetchChattingItemAppBrandPiece", "triggerPrefetchChattingItemWeishiVideoFakeNative", "triggerPrefetchMallIndexWeAppLinks", "appLinks", "", "triggerPrefetchMallIndexWeAppV2", "appUsernames", "triggerPrefetchWeAppQRCode", "PreDownloadInvokeParams", "plugin-appbrand-integration_release"})
public final class PreDownloadServiceExportAnyProcess
  implements w
{
  public static final PreDownloadServiceExportAnyProcess nJc;
  
  static
  {
    AppMethodBeat.i(279983);
    nJc = new PreDownloadServiceExportAnyProcess();
    AppMethodBeat.o(279983);
  }
  
  public final void adj(String paramString) {}
  
  public final void bHS() {}
  
  public final void be(List<String> paramList) {}
  
  public final void bf(List<String> paramList) {}
  
  public final void bu(String paramString, int paramInt)
  {
    AppMethodBeat.i(279981);
    CharSequence localCharSequence = (CharSequence)paramString;
    if ((localCharSequence == null) || (localCharSequence.length() == 0)) {}
    for (int i = 1; i != 0; i = 0)
    {
      AppMethodBeat.o(279981);
      return;
    }
    a.a(new PreDownloadInvokeParams(paramString, paramInt), (d)a.nJd, null);
    AppMethodBeat.o(279981);
  }
  
  public final void t(String paramString1, String paramString2, int paramInt)
  {
    AppMethodBeat.i(279982);
    a.a(new PreDownloadInvokeParams(paramString1, paramInt, paramString2), (d)b.nJe, null);
    AppMethodBeat.o(279982);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/appcache/predownload/PreDownloadServiceExportAnyProcess$PreDownloadInvokeParams;", "Landroid/os/Parcelable;", "username", "", "scene", "", "appId", "(Ljava/lang/String;ILjava/lang/String;)V", "getAppId", "()Ljava/lang/String;", "getScene", "()I", "getUsername", "component1", "component2", "component3", "copy", "describeContents", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "plugin-appbrand-integration_release"})
  public static final class PreDownloadInvokeParams
    implements Parcelable
  {
    public static final Parcelable.Creator CREATOR;
    final String appId;
    final int scene;
    final String username;
    
    static
    {
      AppMethodBeat.i(243111);
      CREATOR = new a();
      AppMethodBeat.o(243111);
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
      AppMethodBeat.i(243108);
      if (this != paramObject)
      {
        if ((paramObject instanceof PreDownloadInvokeParams))
        {
          paramObject = (PreDownloadInvokeParams)paramObject;
          if ((!p.h(this.username, paramObject.username)) || (this.scene != paramObject.scene) || (!p.h(this.appId, paramObject.appId))) {}
        }
      }
      else
      {
        AppMethodBeat.o(243108);
        return true;
      }
      AppMethodBeat.o(243108);
      return false;
    }
    
    public final int hashCode()
    {
      int j = 0;
      AppMethodBeat.i(243107);
      String str = this.username;
      if (str != null) {}
      for (int i = str.hashCode();; i = 0)
      {
        int k = this.scene;
        str = this.appId;
        if (str != null) {
          j = str.hashCode();
        }
        AppMethodBeat.o(243107);
        return (i * 31 + k) * 31 + j;
      }
    }
    
    public final String toString()
    {
      AppMethodBeat.i(243106);
      String str = "PreDownloadInvokeParams(username=" + this.username + ", scene=" + this.scene + ", appId=" + this.appId + ")";
      AppMethodBeat.o(243106);
      return str;
    }
    
    public final void writeToParcel(Parcel paramParcel, int paramInt)
    {
      AppMethodBeat.i(243110);
      p.k(paramParcel, "parcel");
      paramParcel.writeString(this.username);
      paramParcel.writeInt(this.scene);
      paramParcel.writeString(this.appId);
      AppMethodBeat.o(243110);
    }
    
    @l(iBK={1, 1, 16})
    public static final class a
      implements Parcelable.Creator
    {
      public final Object createFromParcel(Parcel paramParcel)
      {
        AppMethodBeat.i(280120);
        p.k(paramParcel, "in");
        paramParcel = new PreDownloadServiceExportAnyProcess.PreDownloadInvokeParams(paramParcel.readString(), paramParcel.readInt(), paramParcel.readString());
        AppMethodBeat.o(280120);
        return paramParcel;
      }
      
      public final Object[] newArray(int paramInt)
      {
        return new PreDownloadServiceExportAnyProcess.PreDownloadInvokeParams[paramInt];
      }
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "data", "Lcom/tencent/mm/plugin/appbrand/appcache/predownload/PreDownloadServiceExportAnyProcess$PreDownloadInvokeParams;", "kotlin.jvm.PlatformType", "<anonymous parameter 1>", "Lcom/tencent/mm/ipcinvoker/IPCInvokeCallback;", "Lcom/tencent/mm/ipcinvoker/type/IPCVoid;", "invoke"})
  static final class a<InputType, ResultType>
    implements d<PreDownloadServiceExportAnyProcess.PreDownloadInvokeParams, IPCVoid>
  {
    public static final a nJd;
    
    static
    {
      AppMethodBeat.i(277210);
      nJd = new a();
      AppMethodBeat.o(277210);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "data", "Lcom/tencent/mm/plugin/appbrand/appcache/predownload/PreDownloadServiceExportAnyProcess$PreDownloadInvokeParams;", "kotlin.jvm.PlatformType", "callback", "Lcom/tencent/mm/ipcinvoker/IPCInvokeCallback;", "Lcom/tencent/mm/ipcinvoker/type/IPCVoid;", "invoke"})
  static final class b<InputType, ResultType>
    implements d<PreDownloadServiceExportAnyProcess.PreDownloadInvokeParams, IPCVoid>
  {
    public static final b nJe;
    
    static
    {
      AppMethodBeat.i(281428);
      nJe = new b();
      AppMethodBeat.o(281428);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appcache.predownload.PreDownloadServiceExportAnyProcess
 * JD-Core Version:    0.7.0.1
 */