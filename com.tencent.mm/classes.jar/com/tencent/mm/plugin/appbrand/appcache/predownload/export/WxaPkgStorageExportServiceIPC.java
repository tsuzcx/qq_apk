package com.tencent.mm.plugin.appbrand.appcache.predownload.export;

import android.content.ContentValues;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.b;
import com.tencent.mm.ipcinvoker.k;
import com.tencent.mm.ipcinvoker.type.IPCBoolean;
import com.tencent.mm.ipcinvoker.type.IPCVoid;
import com.tencent.mm.plugin.appbrand.appcache.bd;
import com.tencent.mm.plugin.appbrand.service.v;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/appbrand/appcache/predownload/export/WxaPkgStorageExportServiceIPC;", "Lcom/tencent/mm/plugin/appbrand/service/IWxaPkgStorageExportService;", "()V", "TAG", "", "getPkgRecord", "Lcom/tencent/mm/plugin/appbrand/appcache/WxaPkgManifestRecord;", "appId", "versionType", "", "version", "insertPkg", "", "filePath", "setPkgIsOccupied", "", "PkgParams", "plugin-appbrand-integration_release"})
public final class WxaPkgStorageExportServiceIPC
  implements v
{
  public static final WxaPkgStorageExportServiceIPC kQn;
  
  static
  {
    AppMethodBeat.i(228102);
    kQn = new WxaPkgStorageExportServiceIPC();
    AppMethodBeat.o(228102);
  }
  
  public final bd H(String paramString, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(228100);
    Object localObject = (CharSequence)paramString;
    if ((localObject == null) || (((CharSequence)localObject).length() == 0)) {}
    for (int i = 1; i != 0; i = 0)
    {
      AppMethodBeat.o(228100);
      return null;
    }
    paramString = (ContentValues)com.tencent.mm.ipcinvoker.wx_extension.b.a.a(new PkgParams(paramString, paramInt1, paramInt2, 8), (k)a.kQo);
    if (paramString != null)
    {
      localObject = new bd();
      a locala = a.kPZ;
      a.a((IAutoDBItem)localObject, paramString);
      AppMethodBeat.o(228100);
      return localObject;
    }
    AppMethodBeat.o(228100);
    return null;
  }
  
  public final bd VF(String paramString)
  {
    AppMethodBeat.i(228099);
    paramString = H(paramString, 0, 0);
    AppMethodBeat.o(228099);
    return paramString;
  }
  
  public final void bc(String paramString, int paramInt)
  {
    AppMethodBeat.i(228101);
    CharSequence localCharSequence = (CharSequence)paramString;
    if ((localCharSequence == null) || (localCharSequence.length() == 0)) {}
    for (int i = 1; i != 0; i = 0)
    {
      AppMethodBeat.o(228101);
      return;
    }
    com.tencent.mm.ipcinvoker.wx_extension.b.a.a(new PkgParams(paramString, 0, paramInt, 10), (b)c.kQq, null);
    AppMethodBeat.o(228101);
  }
  
  public final boolean s(String paramString1, int paramInt, String paramString2)
  {
    AppMethodBeat.i(228098);
    CharSequence localCharSequence = (CharSequence)paramString1;
    if ((localCharSequence == null) || (localCharSequence.length() == 0))
    {
      i = 1;
      if (i == 0)
      {
        localCharSequence = (CharSequence)paramString2;
        if ((localCharSequence != null) && (localCharSequence.length() != 0)) {
          break label115;
        }
      }
    }
    label115:
    for (int i = 1;; i = 0)
    {
      if (i == 0) {
        break label121;
      }
      Log.e("MicroMsg.WxaPkgStorageExportIPC", "insertPkg, invalid args: appId:" + paramString1 + ", version:" + paramInt + ", filePath:" + paramString2);
      AppMethodBeat.o(228098);
      return false;
      i = 0;
      break;
    }
    label121:
    paramString1 = (IPCBoolean)com.tencent.mm.ipcinvoker.wx_extension.b.a.a(new PkgParams(paramString1, 0, paramInt, paramString2), (k)b.kQp);
    if ((paramString1 != null) && (paramString1.value == true))
    {
      AppMethodBeat.o(228098);
      return true;
    }
    AppMethodBeat.o(228098);
    return false;
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/appbrand/appcache/predownload/export/WxaPkgStorageExportServiceIPC$PkgParams;", "Landroid/os/Parcelable;", "appId", "", "versionType", "", "version", "filePath", "(Ljava/lang/String;IILjava/lang/String;)V", "getAppId", "()Ljava/lang/String;", "getFilePath", "getVersion", "()I", "getVersionType", "component1", "component2", "component3", "component4", "copy", "describeContents", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "plugin-appbrand-integration_release"})
  static final class PkgParams
    implements Parcelable
  {
    public static final Parcelable.Creator CREATOR;
    final String appId;
    final String filePath;
    final int iOo;
    final int version;
    
    static
    {
      AppMethodBeat.i(228091);
      CREATOR = new a();
      AppMethodBeat.o(228091);
    }
    
    public PkgParams(String paramString1, int paramInt1, int paramInt2, String paramString2)
    {
      AppMethodBeat.i(228085);
      this.appId = paramString1;
      this.iOo = paramInt1;
      this.version = paramInt2;
      this.filePath = paramString2;
      AppMethodBeat.o(228085);
    }
    
    public final int describeContents()
    {
      return 0;
    }
    
    public final boolean equals(Object paramObject)
    {
      AppMethodBeat.i(228089);
      if (this != paramObject)
      {
        if ((paramObject instanceof PkgParams))
        {
          paramObject = (PkgParams)paramObject;
          if ((!p.j(this.appId, paramObject.appId)) || (this.iOo != paramObject.iOo) || (this.version != paramObject.version) || (!p.j(this.filePath, paramObject.filePath))) {}
        }
      }
      else
      {
        AppMethodBeat.o(228089);
        return true;
      }
      AppMethodBeat.o(228089);
      return false;
    }
    
    public final int hashCode()
    {
      int j = 0;
      AppMethodBeat.i(228088);
      String str = this.appId;
      if (str != null) {}
      for (int i = str.hashCode();; i = 0)
      {
        int k = this.iOo;
        int m = this.version;
        str = this.filePath;
        if (str != null) {
          j = str.hashCode();
        }
        AppMethodBeat.o(228088);
        return ((i * 31 + k) * 31 + m) * 31 + j;
      }
    }
    
    public final String toString()
    {
      AppMethodBeat.i(228087);
      String str = "PkgParams(appId=" + this.appId + ", versionType=" + this.iOo + ", version=" + this.version + ", filePath=" + this.filePath + ")";
      AppMethodBeat.o(228087);
      return str;
    }
    
    public final void writeToParcel(Parcel paramParcel, int paramInt)
    {
      AppMethodBeat.i(228090);
      p.h(paramParcel, "parcel");
      paramParcel.writeString(this.appId);
      paramParcel.writeInt(this.iOo);
      paramParcel.writeInt(this.version);
      paramParcel.writeString(this.filePath);
      AppMethodBeat.o(228090);
    }
    
    @l(hxD={1, 1, 16})
    public static final class a
      implements Parcelable.Creator
    {
      public final Object createFromParcel(Parcel paramParcel)
      {
        AppMethodBeat.i(228084);
        p.h(paramParcel, "in");
        paramParcel = new WxaPkgStorageExportServiceIPC.PkgParams(paramParcel.readString(), paramParcel.readInt(), paramParcel.readInt(), paramParcel.readString());
        AppMethodBeat.o(228084);
        return paramParcel;
      }
      
      public final Object[] newArray(int paramInt)
      {
        return new WxaPkgStorageExportServiceIPC.PkgParams[paramInt];
      }
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "Landroid/content/ContentValues;", "it", "Lcom/tencent/mm/plugin/appbrand/appcache/predownload/export/WxaPkgStorageExportServiceIPC$PkgParams;", "kotlin.jvm.PlatformType", "invoke"})
  static final class a<InputType, ResultType>
    implements k<WxaPkgStorageExportServiceIPC.PkgParams, ContentValues>
  {
    public static final a kQo;
    
    static
    {
      AppMethodBeat.i(228093);
      kQo = new a();
      AppMethodBeat.o(228093);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "Lcom/tencent/mm/ipcinvoker/type/IPCBoolean;", "it", "Lcom/tencent/mm/plugin/appbrand/appcache/predownload/export/WxaPkgStorageExportServiceIPC$PkgParams;", "kotlin.jvm.PlatformType", "invoke"})
  static final class b<InputType, ResultType>
    implements k<WxaPkgStorageExportServiceIPC.PkgParams, IPCBoolean>
  {
    public static final b kQp;
    
    static
    {
      AppMethodBeat.i(228095);
      kQp = new b();
      AppMethodBeat.o(228095);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "data", "Lcom/tencent/mm/plugin/appbrand/appcache/predownload/export/WxaPkgStorageExportServiceIPC$PkgParams;", "kotlin.jvm.PlatformType", "callback", "Lcom/tencent/mm/ipcinvoker/IPCInvokeCallback;", "Lcom/tencent/mm/ipcinvoker/type/IPCVoid;", "invoke"})
  static final class c<InputType, ResultType>
    implements b<WxaPkgStorageExportServiceIPC.PkgParams, IPCVoid>
  {
    public static final c kQq;
    
    static
    {
      AppMethodBeat.i(228097);
      kQq = new c();
      AppMethodBeat.o(228097);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appcache.predownload.export.WxaPkgStorageExportServiceIPC
 * JD-Core Version:    0.7.0.1
 */