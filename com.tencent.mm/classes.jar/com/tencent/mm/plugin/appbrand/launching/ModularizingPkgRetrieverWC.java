package com.tencent.mm.plugin.appbrand.launching;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.d;
import com.tencent.mm.ipcinvoker.extension.XIPCInvoker;
import com.tencent.mm.ipcinvoker.wx_extension.service.MainProcessIPCService;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkgLoadProgress;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkgWrappingInfo;
import com.tencent.mm.plugin.appbrand.config.l;
import com.tencent.mm.plugin.appbrand.p.e;
import com.tencent.mm.plugin.appbrand.p.e.a;
import com.tencent.mm.plugin.appbrand.p.e.c;
import com.tencent.mm.plugin.appbrand.report.quality.QualitySession;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatEnvironment;

public final class ModularizingPkgRetrieverWC
  implements e, com.tencent.mm.vending.e.a
{
  final LoadParams mWs;
  volatile e.a mWt;
  transient com.tencent.mm.plugin.appbrand.jsapi.q.a mWu;
  
  private ModularizingPkgRetrieverWC(String paramString1, int paramInt1, int paramInt2, String paramString2)
  {
    AppMethodBeat.i(47305);
    this.mWu = new com.tencent.mm.plugin.appbrand.jsapi.q.a();
    this.mWs = new LoadParams(paramString1, paramInt1, paramInt2, paramString2, com.tencent.mm.plugin.appbrand.report.quality.b.aeU(paramString1), (byte)0);
    AppMethodBeat.o(47305);
  }
  
  public final void a(e.a parama)
  {
    this.mWt = parama;
  }
  
  public final void dead()
  {
    this.mWt = null;
  }
  
  public final void start()
  {
    AppMethodBeat.i(47306);
    Log.i("MicroMsg.AppBrand.ModularizingPkgRetrieverWC[modularizing]", "startLoad %s", new Object[] { this.mWs.toString() });
    this.mWu.setName("loadPackage");
    this.mWu.startTime = Util.nowMilliSecond();
    this.mWu.r("packageName", this.mWs.cBp);
    XIPCInvoker.a(MainProcessIPCService.dkO, this.mWs, a.class, new d() {});
    AppMethodBeat.o(47306);
  }
  
  static final class LoadParams
    implements Parcelable
  {
    public static final Parcelable.Creator<LoadParams> CREATOR;
    public final String appId;
    public final String cBp;
    public final int dMe;
    public final QualitySession mUY;
    public final int pkgVersion;
    
    static
    {
      AppMethodBeat.i(47297);
      CREATOR = new Parcelable.Creator() {};
      AppMethodBeat.o(47297);
    }
    
    LoadParams(Parcel paramParcel)
    {
      AppMethodBeat.i(47295);
      this.appId = paramParcel.readString();
      this.dMe = paramParcel.readInt();
      this.pkgVersion = paramParcel.readInt();
      this.cBp = paramParcel.readString();
      this.mUY = ((QualitySession)paramParcel.readParcelable(QualitySession.class.getClassLoader()));
      AppMethodBeat.o(47295);
    }
    
    private LoadParams(String paramString1, int paramInt1, int paramInt2, String paramString2, QualitySession paramQualitySession)
    {
      this.appId = paramString1;
      this.dMe = paramInt1;
      this.pkgVersion = paramInt2;
      this.cBp = paramString2;
      this.mUY = paramQualitySession;
    }
    
    public final int describeContents()
    {
      return 0;
    }
    
    public final String toString()
    {
      AppMethodBeat.i(47296);
      String str = "LoadParams{appId='" + this.appId + '\'' + ", pkgType=" + this.dMe + ", pkgVersion=" + this.pkgVersion + ", moduleName='" + this.cBp + '\'' + '}';
      AppMethodBeat.o(47296);
      return str;
    }
    
    public final void writeToParcel(Parcel paramParcel, int paramInt)
    {
      AppMethodBeat.i(47294);
      paramParcel.writeString(this.appId);
      paramParcel.writeInt(this.dMe);
      paramParcel.writeInt(this.pkgVersion);
      paramParcel.writeString(this.cBp);
      paramParcel.writeParcelable(this.mUY, paramInt);
      AppMethodBeat.o(47294);
    }
  }
  
  static class WxaPkgResultProgressPair
    implements Parcelable
  {
    public static final Parcelable.Creator<WxaPkgResultProgressPair> CREATOR;
    WxaPkgWrappingInfo mWA;
    WxaPkgLoadProgress mWB;
    private a mWC;
    
    static
    {
      AppMethodBeat.i(47304);
      CREATOR = new Parcelable.Creator() {};
      AppMethodBeat.o(47304);
    }
    
    WxaPkgResultProgressPair(Parcel paramParcel)
    {
      AppMethodBeat.i(47302);
      this.mWA = ((WxaPkgWrappingInfo)paramParcel.readParcelable(WxaPkgWrappingInfo.class.getClassLoader()));
      this.mWB = ((WxaPkgLoadProgress)paramParcel.readParcelable(WxaPkgLoadProgress.class.getClassLoader()));
      this.mWC = ((a)paramParcel.readSerializable());
      AppMethodBeat.o(47302);
    }
    
    WxaPkgResultProgressPair(WxaPkgLoadProgress paramWxaPkgLoadProgress)
    {
      this.mWB = paramWxaPkgLoadProgress;
      this.mWC = a.mWE;
    }
    
    WxaPkgResultProgressPair(WxaPkgWrappingInfo paramWxaPkgWrappingInfo)
    {
      this.mWA = paramWxaPkgWrappingInfo;
      this.mWC = a.mWD;
    }
    
    public int describeContents()
    {
      return 0;
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      AppMethodBeat.i(47303);
      paramParcel.writeParcelable(this.mWA, paramInt);
      paramParcel.writeParcelable(this.mWB, paramInt);
      paramParcel.writeSerializable(this.mWC);
      AppMethodBeat.o(47303);
    }
    
    static enum a
    {
      static
      {
        AppMethodBeat.i(47301);
        mWD = new a("Finish", 0);
        mWE = new a("Progressing", 1);
        mWF = new a[] { mWD, mWE };
        AppMethodBeat.o(47301);
      }
      
      private a() {}
    }
  }
  
  static final class a
    implements com.tencent.mm.ipcinvoker.b<ModularizingPkgRetrieverWC.LoadParams, ModularizingPkgRetrieverWC.WxaPkgResultProgressPair>
  {
    private d<ModularizingPkgRetrieverWC.WxaPkgResultProgressPair> hnd = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.launching.ModularizingPkgRetrieverWC
 * JD-Core Version:    0.7.0.1
 */