package com.tencent.mm.plugin.appbrand.appcache.predownload.export;

import android.content.ContentValues;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.d;
import com.tencent.mm.ipcinvoker.f;
import com.tencent.mm.ipcinvoker.type.IPCVoid;
import com.tencent.mm.ipcinvoker.wx_extension.b.a;
import com.tencent.mm.plugin.appbrand.service.u;
import com.tencent.mm.plugin.appbrand.service.u.a;
import com.tencent.mm.plugin.appbrand.service.u.b;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/appcache/predownload/export/WxaPkgDownloaderExportServiceIPC;", "Lcom/tencent/mm/plugin/appbrand/service/IWxaPkgDownloaderExportService;", "()V", "TAG", "", "registerPkgSpecs", "", "appUsername", "appId", "visitScene", "", "startDownloadPkg", "versionType", "onSuccess", "Lcom/tencent/mm/plugin/appbrand/service/IWxaPkgDownloaderExportService$OnDownloadSuccessListener;", "onError", "Lcom/tencent/mm/plugin/appbrand/service/IWxaPkgDownloaderExportService$OnDownloadErrorListener;", "DownloadPkgParam", "DownloadPkgResult", "RegisterPkgSpecs", "plugin-appbrand-integration_release"})
public final class WxaPkgDownloaderExportServiceIPC
  implements u
{
  public static final WxaPkgDownloaderExportServiceIPC nKf;
  
  static
  {
    AppMethodBeat.i(268393);
    nKf = new WxaPkgDownloaderExportServiceIPC();
    AppMethodBeat.o(268393);
  }
  
  public final void a(String paramString, int paramInt, u.b paramb, final u.a parama)
  {
    AppMethodBeat.i(268388);
    CharSequence localCharSequence = (CharSequence)paramString;
    if ((localCharSequence == null) || (localCharSequence.length() == 0)) {}
    for (int i = 1; i != 0; i = 0)
    {
      parama.onError(-1, "invalid appId");
      AppMethodBeat.o(268388);
      return;
    }
    a.a(new DownloadPkgParam(paramString, paramInt), (d)b.nKi, (f)new c(paramb, parama));
    AppMethodBeat.o(268388);
  }
  
  public final void u(String paramString1, String paramString2, int paramInt)
  {
    AppMethodBeat.i(268390);
    CharSequence localCharSequence = (CharSequence)paramString1;
    if ((localCharSequence == null) || (localCharSequence.length() == 0))
    {
      i = 1;
      if (i == 0)
      {
        localCharSequence = (CharSequence)paramString2;
        if ((localCharSequence != null) && (localCharSequence.length() != 0)) {
          break label75;
        }
      }
    }
    label75:
    for (int i = 1;; i = 0)
    {
      if (i == 0) {
        break label81;
      }
      AppMethodBeat.o(268390);
      return;
      i = 0;
      break;
    }
    label81:
    a.a(new RegisterPkgSpecs(paramString1, paramString2, paramInt), (d)a.nKh, null);
    AppMethodBeat.o(268390);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/appcache/predownload/export/WxaPkgDownloaderExportServiceIPC$DownloadPkgParam;", "Landroid/os/Parcelable;", "appId", "", "versionType", "", "(Ljava/lang/String;I)V", "getAppId", "()Ljava/lang/String;", "getVersionType", "()I", "component1", "component2", "copy", "describeContents", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "plugin-appbrand-integration_release"})
  public static final class DownloadPkgParam
    implements Parcelable
  {
    public static final Parcelable.Creator CREATOR;
    final String appId;
    final int cBU;
    
    static
    {
      AppMethodBeat.i(245824);
      CREATOR = new a();
      AppMethodBeat.o(245824);
    }
    
    public DownloadPkgParam(String paramString, int paramInt)
    {
      this.appId = paramString;
      this.cBU = paramInt;
    }
    
    public final int describeContents()
    {
      return 0;
    }
    
    public final boolean equals(Object paramObject)
    {
      AppMethodBeat.i(245822);
      if (this != paramObject)
      {
        if ((paramObject instanceof DownloadPkgParam))
        {
          paramObject = (DownloadPkgParam)paramObject;
          if ((!p.h(this.appId, paramObject.appId)) || (this.cBU != paramObject.cBU)) {}
        }
      }
      else
      {
        AppMethodBeat.o(245822);
        return true;
      }
      AppMethodBeat.o(245822);
      return false;
    }
    
    public final int hashCode()
    {
      AppMethodBeat.i(245821);
      String str = this.appId;
      if (str != null) {}
      for (int i = str.hashCode();; i = 0)
      {
        int j = this.cBU;
        AppMethodBeat.o(245821);
        return i * 31 + j;
      }
    }
    
    public final String toString()
    {
      AppMethodBeat.i(245820);
      String str = "DownloadPkgParam(appId=" + this.appId + ", versionType=" + this.cBU + ")";
      AppMethodBeat.o(245820);
      return str;
    }
    
    public final void writeToParcel(Parcel paramParcel, int paramInt)
    {
      AppMethodBeat.i(245823);
      p.k(paramParcel, "parcel");
      paramParcel.writeString(this.appId);
      paramParcel.writeInt(this.cBU);
      AppMethodBeat.o(245823);
    }
    
    @l(iBK={1, 1, 16})
    public static final class a
      implements Parcelable.Creator
    {
      public final Object createFromParcel(Parcel paramParcel)
      {
        AppMethodBeat.i(243322);
        p.k(paramParcel, "in");
        paramParcel = new WxaPkgDownloaderExportServiceIPC.DownloadPkgParam(paramParcel.readString(), paramParcel.readInt());
        AppMethodBeat.o(243322);
        return paramParcel;
      }
      
      public final Object[] newArray(int paramInt)
      {
        return new WxaPkgDownloaderExportServiceIPC.DownloadPkgParam[paramInt];
      }
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/appcache/predownload/export/WxaPkgDownloaderExportServiceIPC$DownloadPkgResult;", "Landroid/os/Parcelable;", "isSuccess", "", "recordContentValues", "Landroid/content/ContentValues;", "filePath", "", "errCode", "", "errMsg", "(ZLandroid/content/ContentValues;Ljava/lang/String;ILjava/lang/String;)V", "getErrCode", "()I", "getErrMsg", "()Ljava/lang/String;", "getFilePath", "()Z", "getRecordContentValues", "()Landroid/content/ContentValues;", "component1", "component2", "component3", "component4", "component5", "copy", "describeContents", "equals", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "plugin-appbrand-integration_release"})
  public static final class DownloadPkgResult
    implements Parcelable
  {
    public static final Parcelable.Creator CREATOR;
    final int errCode;
    final String errMsg;
    final String filePath;
    final boolean isSuccess;
    final ContentValues nKg;
    
    static
    {
      AppMethodBeat.i(277643);
      CREATOR = new a();
      AppMethodBeat.o(277643);
    }
    
    public DownloadPkgResult(boolean paramBoolean, ContentValues paramContentValues, String paramString1, int paramInt, String paramString2)
    {
      this.isSuccess = paramBoolean;
      this.nKg = paramContentValues;
      this.filePath = paramString1;
      this.errCode = paramInt;
      this.errMsg = paramString2;
    }
    
    public final int describeContents()
    {
      return 0;
    }
    
    public final boolean equals(Object paramObject)
    {
      AppMethodBeat.i(277638);
      if (this != paramObject)
      {
        if ((paramObject instanceof DownloadPkgResult))
        {
          paramObject = (DownloadPkgResult)paramObject;
          if ((this.isSuccess != paramObject.isSuccess) || (!p.h(this.nKg, paramObject.nKg)) || (!p.h(this.filePath, paramObject.filePath)) || (this.errCode != paramObject.errCode) || (!p.h(this.errMsg, paramObject.errMsg))) {}
        }
      }
      else
      {
        AppMethodBeat.o(277638);
        return true;
      }
      AppMethodBeat.o(277638);
      return false;
    }
    
    public final int hashCode()
    {
      throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
    }
    
    public final String toString()
    {
      AppMethodBeat.i(277636);
      String str = "DownloadPkgResult(isSuccess=" + this.isSuccess + ", recordContentValues=" + this.nKg + ", filePath=" + this.filePath + ", errCode=" + this.errCode + ", errMsg=" + this.errMsg + ")";
      AppMethodBeat.o(277636);
      return str;
    }
    
    public final void writeToParcel(Parcel paramParcel, int paramInt)
    {
      throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.provideAs(TypeTransformer.java:780)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.e1expr(TypeTransformer.java:496)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:713)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:698)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.s1stmt(TypeTransformer.java:810)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.sxStmt(TypeTransformer.java:840)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:206)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
    }
    
    @l(iBK={1, 1, 16})
    public static final class a
      implements Parcelable.Creator
    {
      public final Object createFromParcel(Parcel paramParcel)
      {
        AppMethodBeat.i(283773);
        p.k(paramParcel, "in");
        boolean bool;
        if (paramParcel.readInt() != 0)
        {
          bool = true;
          if (paramParcel.readInt() == 0) {
            break label74;
          }
        }
        label74:
        for (ContentValues localContentValues = (ContentValues)ContentValues.CREATOR.createFromParcel(paramParcel);; localContentValues = null)
        {
          paramParcel = new WxaPkgDownloaderExportServiceIPC.DownloadPkgResult(bool, localContentValues, paramParcel.readString(), paramParcel.readInt(), paramParcel.readString());
          AppMethodBeat.o(283773);
          return paramParcel;
          bool = false;
          break;
        }
      }
      
      public final Object[] newArray(int paramInt)
      {
        return new WxaPkgDownloaderExportServiceIPC.DownloadPkgResult[paramInt];
      }
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/appcache/predownload/export/WxaPkgDownloaderExportServiceIPC$RegisterPkgSpecs;", "Landroid/os/Parcelable;", "username", "", "appId", "scene", "", "(Ljava/lang/String;Ljava/lang/String;I)V", "getAppId", "()Ljava/lang/String;", "getScene", "()I", "getUsername", "component1", "component2", "component3", "copy", "describeContents", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "plugin-appbrand-integration_release"})
  public static final class RegisterPkgSpecs
    implements Parcelable
  {
    public static final Parcelable.Creator CREATOR;
    final String appId;
    final int scene;
    final String username;
    
    static
    {
      AppMethodBeat.i(280954);
      CREATOR = new a();
      AppMethodBeat.o(280954);
    }
    
    public RegisterPkgSpecs(String paramString1, String paramString2, int paramInt)
    {
      AppMethodBeat.i(280948);
      this.username = paramString1;
      this.appId = paramString2;
      this.scene = paramInt;
      AppMethodBeat.o(280948);
    }
    
    public final int describeContents()
    {
      return 0;
    }
    
    public final boolean equals(Object paramObject)
    {
      AppMethodBeat.i(280951);
      if (this != paramObject)
      {
        if ((paramObject instanceof RegisterPkgSpecs))
        {
          paramObject = (RegisterPkgSpecs)paramObject;
          if ((!p.h(this.username, paramObject.username)) || (!p.h(this.appId, paramObject.appId)) || (this.scene != paramObject.scene)) {}
        }
      }
      else
      {
        AppMethodBeat.o(280951);
        return true;
      }
      AppMethodBeat.o(280951);
      return false;
    }
    
    public final int hashCode()
    {
      int j = 0;
      AppMethodBeat.i(280950);
      String str = this.username;
      if (str != null) {}
      for (int i = str.hashCode();; i = 0)
      {
        str = this.appId;
        if (str != null) {
          j = str.hashCode();
        }
        int k = this.scene;
        AppMethodBeat.o(280950);
        return (i * 31 + j) * 31 + k;
      }
    }
    
    public final String toString()
    {
      AppMethodBeat.i(280949);
      String str = "RegisterPkgSpecs(username=" + this.username + ", appId=" + this.appId + ", scene=" + this.scene + ")";
      AppMethodBeat.o(280949);
      return str;
    }
    
    public final void writeToParcel(Parcel paramParcel, int paramInt)
    {
      AppMethodBeat.i(280953);
      p.k(paramParcel, "parcel");
      paramParcel.writeString(this.username);
      paramParcel.writeString(this.appId);
      paramParcel.writeInt(this.scene);
      AppMethodBeat.o(280953);
    }
    
    @l(iBK={1, 1, 16})
    public static final class a
      implements Parcelable.Creator
    {
      public final Object createFromParcel(Parcel paramParcel)
      {
        AppMethodBeat.i(277867);
        p.k(paramParcel, "in");
        paramParcel = new WxaPkgDownloaderExportServiceIPC.RegisterPkgSpecs(paramParcel.readString(), paramParcel.readString(), paramParcel.readInt());
        AppMethodBeat.o(277867);
        return paramParcel;
      }
      
      public final Object[] newArray(int paramInt)
      {
        return new WxaPkgDownloaderExportServiceIPC.RegisterPkgSpecs[paramInt];
      }
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "data", "Lcom/tencent/mm/plugin/appbrand/appcache/predownload/export/WxaPkgDownloaderExportServiceIPC$RegisterPkgSpecs;", "kotlin.jvm.PlatformType", "callback", "Lcom/tencent/mm/ipcinvoker/IPCInvokeCallback;", "Lcom/tencent/mm/ipcinvoker/type/IPCVoid;", "invoke"})
  static final class a<InputType, ResultType>
    implements d<WxaPkgDownloaderExportServiceIPC.RegisterPkgSpecs, IPCVoid>
  {
    public static final a nKh;
    
    static
    {
      AppMethodBeat.i(274955);
      nKh = new a();
      AppMethodBeat.o(274955);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "data", "Lcom/tencent/mm/plugin/appbrand/appcache/predownload/export/WxaPkgDownloaderExportServiceIPC$DownloadPkgParam;", "kotlin.jvm.PlatformType", "callback", "Lcom/tencent/mm/ipcinvoker/IPCInvokeCallback;", "Lcom/tencent/mm/plugin/appbrand/appcache/predownload/export/WxaPkgDownloaderExportServiceIPC$DownloadPkgResult;", "invoke"})
  static final class b<InputType, ResultType>
    implements d<WxaPkgDownloaderExportServiceIPC.DownloadPkgParam, WxaPkgDownloaderExportServiceIPC.DownloadPkgResult>
  {
    public static final b nKi;
    
    static
    {
      AppMethodBeat.i(275719);
      nKi = new b();
      AppMethodBeat.o(275719);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "result", "Lcom/tencent/mm/plugin/appbrand/appcache/predownload/export/WxaPkgDownloaderExportServiceIPC$DownloadPkgResult;", "kotlin.jvm.PlatformType", "onCallback"})
  static final class c<T>
    implements f<WxaPkgDownloaderExportServiceIPC.DownloadPkgResult>
  {
    c(u.b paramb, u.a parama) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appcache.predownload.export.WxaPkgDownloaderExportServiceIPC
 * JD-Core Version:    0.7.0.1
 */