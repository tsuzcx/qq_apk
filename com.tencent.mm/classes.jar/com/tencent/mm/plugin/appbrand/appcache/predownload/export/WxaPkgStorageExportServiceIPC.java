package com.tencent.mm.plugin.appbrand.appcache.predownload.export;

import android.content.ContentValues;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.d;
import com.tencent.mm.ipcinvoker.m;
import com.tencent.mm.ipcinvoker.type.IPCBoolean;
import com.tencent.mm.ipcinvoker.type.IPCInteger;
import com.tencent.mm.ipcinvoker.type.IPCVoid;
import com.tencent.mm.plugin.appbrand.appcache.bh;
import com.tencent.mm.plugin.appbrand.service.v;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/appcache/predownload/export/WxaPkgStorageExportServiceIPC;", "Lcom/tencent/mm/plugin/appbrand/service/IWxaPkgStorageExportService;", "()V", "TAG", "", "getPkgRecord", "Lcom/tencent/mm/plugin/appbrand/appcache/WxaPkgManifestRecord;", "appId", "versionType", "", "version", "getServerNotifiedReleaseVersion", "insertPkg", "", "filePath", "setPkgIsOccupied", "", "PkgParams", "plugin-appbrand-integration_release"})
public final class WxaPkgStorageExportServiceIPC
  implements v
{
  public static final WxaPkgStorageExportServiceIPC nKs;
  
  static
  {
    AppMethodBeat.i(270119);
    nKs = new WxaPkgStorageExportServiceIPC();
    AppMethodBeat.o(270119);
  }
  
  public final bh H(String paramString, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(270115);
    Object localObject = (CharSequence)paramString;
    if ((localObject == null) || (((CharSequence)localObject).length() == 0)) {}
    for (int i = 1; i != 0; i = 0)
    {
      AppMethodBeat.o(270115);
      return null;
    }
    paramString = (ContentValues)com.tencent.mm.ipcinvoker.wx_extension.b.a.a(new PkgParams(paramString, paramInt1, paramInt2, 8), (m)a.nKt);
    if (paramString != null)
    {
      localObject = new bh();
      a locala = a.nKe;
      a.a((IAutoDBItem)localObject, paramString);
      AppMethodBeat.o(270115);
      return localObject;
    }
    AppMethodBeat.o(270115);
    return null;
  }
  
  public final bh ado(String paramString)
  {
    AppMethodBeat.i(270114);
    paramString = H(paramString, 0, 0);
    AppMethodBeat.o(270114);
    return paramString;
  }
  
  public final int adp(String paramString)
  {
    AppMethodBeat.i(270118);
    CharSequence localCharSequence = (CharSequence)paramString;
    if ((localCharSequence == null) || (localCharSequence.length() == 0)) {}
    for (int i = 1; i != 0; i = 0)
    {
      AppMethodBeat.o(270118);
      return 0;
    }
    paramString = (IPCInteger)com.tencent.mm.ipcinvoker.wx_extension.b.a.a(new PkgParams(paramString, 0, 0, 14), (m)b.nKu);
    if (paramString != null)
    {
      i = paramString.value;
      AppMethodBeat.o(270118);
      return i;
    }
    AppMethodBeat.o(270118);
    return 0;
  }
  
  public final void bv(String paramString, int paramInt)
  {
    AppMethodBeat.i(270116);
    CharSequence localCharSequence = (CharSequence)paramString;
    if ((localCharSequence == null) || (localCharSequence.length() == 0)) {}
    for (int i = 1; i != 0; i = 0)
    {
      AppMethodBeat.o(270116);
      return;
    }
    com.tencent.mm.ipcinvoker.wx_extension.b.a.a(new PkgParams(paramString, 0, paramInt, 10), (d)d.nKw, null);
    AppMethodBeat.o(270116);
  }
  
  public final boolean t(String paramString1, int paramInt, String paramString2)
  {
    AppMethodBeat.i(270113);
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
      AppMethodBeat.o(270113);
      return false;
      i = 0;
      break;
    }
    label121:
    paramString1 = (IPCBoolean)com.tencent.mm.ipcinvoker.wx_extension.b.a.a(new PkgParams(paramString1, 0, paramInt, paramString2), (m)c.nKv);
    if ((paramString1 != null) && (paramString1.value == true))
    {
      AppMethodBeat.o(270113);
      return true;
    }
    AppMethodBeat.o(270113);
    return false;
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/appcache/predownload/export/WxaPkgStorageExportServiceIPC$PkgParams;", "Landroid/os/Parcelable;", "appId", "", "versionType", "", "version", "filePath", "(Ljava/lang/String;IILjava/lang/String;)V", "getAppId", "()Ljava/lang/String;", "getFilePath", "getVersion", "()I", "getVersionType", "component1", "component2", "component3", "component4", "copy", "describeContents", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "plugin-appbrand-integration_release"})
  static final class PkgParams
    implements Parcelable
  {
    public static final Parcelable.Creator CREATOR;
    final String appId;
    final int cBU;
    final String filePath;
    final int version;
    
    static
    {
      AppMethodBeat.i(280698);
      CREATOR = new a();
      AppMethodBeat.o(280698);
    }
    
    public PkgParams(String paramString1, int paramInt1, int paramInt2, String paramString2)
    {
      AppMethodBeat.i(280690);
      this.appId = paramString1;
      this.cBU = paramInt1;
      this.version = paramInt2;
      this.filePath = paramString2;
      AppMethodBeat.o(280690);
    }
    
    public final int describeContents()
    {
      return 0;
    }
    
    public final boolean equals(Object paramObject)
    {
      AppMethodBeat.i(280695);
      if (this != paramObject)
      {
        if ((paramObject instanceof PkgParams))
        {
          paramObject = (PkgParams)paramObject;
          if ((!p.h(this.appId, paramObject.appId)) || (this.cBU != paramObject.cBU) || (this.version != paramObject.version) || (!p.h(this.filePath, paramObject.filePath))) {}
        }
      }
      else
      {
        AppMethodBeat.o(280695);
        return true;
      }
      AppMethodBeat.o(280695);
      return false;
    }
    
    public final int hashCode()
    {
      int j = 0;
      AppMethodBeat.i(280694);
      String str = this.appId;
      if (str != null) {}
      for (int i = str.hashCode();; i = 0)
      {
        int k = this.cBU;
        int m = this.version;
        str = this.filePath;
        if (str != null) {
          j = str.hashCode();
        }
        AppMethodBeat.o(280694);
        return ((i * 31 + k) * 31 + m) * 31 + j;
      }
    }
    
    public final String toString()
    {
      AppMethodBeat.i(280693);
      String str = "PkgParams(appId=" + this.appId + ", versionType=" + this.cBU + ", version=" + this.version + ", filePath=" + this.filePath + ")";
      AppMethodBeat.o(280693);
      return str;
    }
    
    public final void writeToParcel(Parcel paramParcel, int paramInt)
    {
      AppMethodBeat.i(280697);
      p.k(paramParcel, "parcel");
      paramParcel.writeString(this.appId);
      paramParcel.writeInt(this.cBU);
      paramParcel.writeInt(this.version);
      paramParcel.writeString(this.filePath);
      AppMethodBeat.o(280697);
    }
    
    @l(iBK={1, 1, 16})
    public static final class a
      implements Parcelable.Creator
    {
      public final Object createFromParcel(Parcel paramParcel)
      {
        AppMethodBeat.i(276131);
        p.k(paramParcel, "in");
        paramParcel = new WxaPkgStorageExportServiceIPC.PkgParams(paramParcel.readString(), paramParcel.readInt(), paramParcel.readInt(), paramParcel.readString());
        AppMethodBeat.o(276131);
        return paramParcel;
      }
      
      public final Object[] newArray(int paramInt)
      {
        return new WxaPkgStorageExportServiceIPC.PkgParams[paramInt];
      }
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "Landroid/content/ContentValues;", "it", "Lcom/tencent/mm/plugin/appbrand/appcache/predownload/export/WxaPkgStorageExportServiceIPC$PkgParams;", "kotlin.jvm.PlatformType", "invoke"})
  static final class a<InputType, ResultType>
    implements m<WxaPkgStorageExportServiceIPC.PkgParams, ContentValues>
  {
    public static final a nKt;
    
    static
    {
      AppMethodBeat.i(282750);
      nKt = new a();
      AppMethodBeat.o(282750);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "Lcom/tencent/mm/ipcinvoker/type/IPCInteger;", "data", "Lcom/tencent/mm/plugin/appbrand/appcache/predownload/export/WxaPkgStorageExportServiceIPC$PkgParams;", "kotlin.jvm.PlatformType", "invoke"})
  static final class b<InputType, ResultType>
    implements m<WxaPkgStorageExportServiceIPC.PkgParams, IPCInteger>
  {
    public static final b nKu;
    
    static
    {
      AppMethodBeat.i(280880);
      nKu = new b();
      AppMethodBeat.o(280880);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "Lcom/tencent/mm/ipcinvoker/type/IPCBoolean;", "it", "Lcom/tencent/mm/plugin/appbrand/appcache/predownload/export/WxaPkgStorageExportServiceIPC$PkgParams;", "kotlin.jvm.PlatformType", "invoke"})
  static final class c<InputType, ResultType>
    implements m<WxaPkgStorageExportServiceIPC.PkgParams, IPCBoolean>
  {
    public static final c nKv;
    
    static
    {
      AppMethodBeat.i(265137);
      nKv = new c();
      AppMethodBeat.o(265137);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "data", "Lcom/tencent/mm/plugin/appbrand/appcache/predownload/export/WxaPkgStorageExportServiceIPC$PkgParams;", "kotlin.jvm.PlatformType", "callback", "Lcom/tencent/mm/ipcinvoker/IPCInvokeCallback;", "Lcom/tencent/mm/ipcinvoker/type/IPCVoid;", "invoke"})
  static final class d<InputType, ResultType>
    implements d<WxaPkgStorageExportServiceIPC.PkgParams, IPCVoid>
  {
    public static final d nKw;
    
    static
    {
      AppMethodBeat.i(274181);
      nKw = new d();
      AppMethodBeat.o(274181);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appcache.predownload.export.WxaPkgStorageExportServiceIPC
 * JD-Core Version:    0.7.0.1
 */