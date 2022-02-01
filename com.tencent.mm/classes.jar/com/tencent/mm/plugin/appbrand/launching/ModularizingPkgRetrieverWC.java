package com.tencent.mm.plugin.appbrand.launching;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.d;
import com.tencent.mm.ipcinvoker.extension.XIPCInvoker;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkgLoadProgress;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkgWrappingInfo;
import com.tencent.mm.plugin.appbrand.config.k;
import com.tencent.mm.plugin.appbrand.o.e;
import com.tencent.mm.plugin.appbrand.o.e.a;
import com.tencent.mm.plugin.appbrand.o.e.c;
import com.tencent.mm.plugin.appbrand.report.quality.QualitySession;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.sdk.platformtools.h;

public final class ModularizingPkgRetrieverWC
  implements e, com.tencent.mm.vending.e.a
{
  final LoadParams kLS;
  volatile e.a kLT;
  transient com.tencent.mm.plugin.appbrand.jsapi.m.a kLU;
  
  private ModularizingPkgRetrieverWC(String paramString1, int paramInt1, int paramInt2, String paramString2)
  {
    AppMethodBeat.i(47305);
    this.kLU = new com.tencent.mm.plugin.appbrand.jsapi.m.a();
    this.kLS = new LoadParams(paramString1, paramInt1, paramInt2, paramString2, com.tencent.mm.plugin.appbrand.report.quality.a.ME(paramString1), (byte)0);
    AppMethodBeat.o(47305);
  }
  
  public final void a(e.a parama)
  {
    this.kLT = parama;
  }
  
  public final void dead()
  {
    this.kLT = null;
  }
  
  public final void start()
  {
    AppMethodBeat.i(47306);
    ad.i("MicroMsg.AppBrand.ModularizingPkgRetrieverWC[modularizing]", "startLoad %s", new Object[] { this.kLS.toString() });
    this.kLU.setName("loadPackage");
    this.kLU.startTime = bt.eGO();
    this.kLU.t("packageName", this.kLS.chK);
    XIPCInvoker.a("com.tencent.mm", this.kLS, a.class, new d() {});
    AppMethodBeat.o(47306);
  }
  
  static final class LoadParams
    implements Parcelable
  {
    public static final Parcelable.Creator<LoadParams> CREATOR;
    public final String appId;
    public final String chK;
    public final int dkC;
    public final QualitySession kKy;
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
      this.dkC = paramParcel.readInt();
      this.pkgVersion = paramParcel.readInt();
      this.chK = paramParcel.readString();
      this.kKy = ((QualitySession)paramParcel.readParcelable(QualitySession.class.getClassLoader()));
      AppMethodBeat.o(47295);
    }
    
    private LoadParams(String paramString1, int paramInt1, int paramInt2, String paramString2, QualitySession paramQualitySession)
    {
      this.appId = paramString1;
      this.dkC = paramInt1;
      this.pkgVersion = paramInt2;
      this.chK = paramString2;
      this.kKy = paramQualitySession;
    }
    
    public final int describeContents()
    {
      return 0;
    }
    
    public final String toString()
    {
      AppMethodBeat.i(47296);
      String str = "LoadParams{appId='" + this.appId + '\'' + ", pkgType=" + this.dkC + ", pkgVersion=" + this.pkgVersion + ", moduleName='" + this.chK + '\'' + '}';
      AppMethodBeat.o(47296);
      return str;
    }
    
    public final void writeToParcel(Parcel paramParcel, int paramInt)
    {
      AppMethodBeat.i(47294);
      paramParcel.writeString(this.appId);
      paramParcel.writeInt(this.dkC);
      paramParcel.writeInt(this.pkgVersion);
      paramParcel.writeString(this.chK);
      paramParcel.writeParcelable(this.kKy, paramInt);
      AppMethodBeat.o(47294);
    }
  }
  
  static class WxaPkgResultProgressPair
    implements Parcelable
  {
    public static final Parcelable.Creator<WxaPkgResultProgressPair> CREATOR;
    WxaPkgWrappingInfo kMa;
    WxaPkgLoadProgress kMb;
    private a kMc;
    
    static
    {
      AppMethodBeat.i(47304);
      CREATOR = new Parcelable.Creator() {};
      AppMethodBeat.o(47304);
    }
    
    WxaPkgResultProgressPair(Parcel paramParcel)
    {
      AppMethodBeat.i(47302);
      this.kMa = ((WxaPkgWrappingInfo)paramParcel.readParcelable(WxaPkgWrappingInfo.class.getClassLoader()));
      this.kMb = ((WxaPkgLoadProgress)paramParcel.readParcelable(WxaPkgLoadProgress.class.getClassLoader()));
      this.kMc = ((a)paramParcel.readSerializable());
      AppMethodBeat.o(47302);
    }
    
    WxaPkgResultProgressPair(WxaPkgLoadProgress paramWxaPkgLoadProgress)
    {
      this.kMb = paramWxaPkgLoadProgress;
      this.kMc = a.kMe;
    }
    
    WxaPkgResultProgressPair(WxaPkgWrappingInfo paramWxaPkgWrappingInfo)
    {
      this.kMa = paramWxaPkgWrappingInfo;
      this.kMc = a.kMd;
    }
    
    public int describeContents()
    {
      return 0;
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      AppMethodBeat.i(47303);
      paramParcel.writeParcelable(this.kMa, paramInt);
      paramParcel.writeParcelable(this.kMb, paramInt);
      paramParcel.writeSerializable(this.kMc);
      AppMethodBeat.o(47303);
    }
    
    static enum a
    {
      static
      {
        AppMethodBeat.i(47301);
        kMd = new a("Finish", 0);
        kMe = new a("Progressing", 1);
        kMf = new a[] { kMd, kMe };
        AppMethodBeat.o(47301);
      }
      
      private a() {}
    }
  }
  
  static final class a
    implements com.tencent.mm.ipcinvoker.b<ModularizingPkgRetrieverWC.LoadParams, ModularizingPkgRetrieverWC.WxaPkgResultProgressPair>
  {
    private d<ModularizingPkgRetrieverWC.WxaPkgResultProgressPair> fZr = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.launching.ModularizingPkgRetrieverWC
 * JD-Core Version:    0.7.0.1
 */