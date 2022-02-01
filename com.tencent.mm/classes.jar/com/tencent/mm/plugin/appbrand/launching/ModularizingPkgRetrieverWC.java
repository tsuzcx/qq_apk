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
import com.tencent.mm.plugin.appbrand.m.e;
import com.tencent.mm.plugin.appbrand.m.e.a;
import com.tencent.mm.plugin.appbrand.m.e.c;
import com.tencent.mm.plugin.appbrand.report.quality.QualitySession;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.sdk.platformtools.bv;
import com.tencent.mm.sdk.platformtools.j;

public final class ModularizingPkgRetrieverWC
  implements e, com.tencent.mm.vending.e.a
{
  final LoadParams lPh;
  volatile e.a lPi;
  transient com.tencent.mm.plugin.appbrand.jsapi.o.a lPj;
  
  private ModularizingPkgRetrieverWC(String paramString1, int paramInt1, int paramInt2, String paramString2)
  {
    AppMethodBeat.i(47305);
    this.lPj = new com.tencent.mm.plugin.appbrand.jsapi.o.a();
    this.lPh = new LoadParams(paramString1, paramInt1, paramInt2, paramString2, com.tencent.mm.plugin.appbrand.report.quality.a.Ve(paramString1), (byte)0);
    AppMethodBeat.o(47305);
  }
  
  public final void a(e.a parama)
  {
    this.lPi = parama;
  }
  
  public final void dead()
  {
    this.lPi = null;
  }
  
  public final void start()
  {
    AppMethodBeat.i(47306);
    ae.i("MicroMsg.AppBrand.ModularizingPkgRetrieverWC[modularizing]", "startLoad %s", new Object[] { this.lPh.toString() });
    this.lPj.setName("loadPackage");
    this.lPj.startTime = bu.fpO();
    this.lPj.r("packageName", this.lPh.coY);
    XIPCInvoker.a("com.tencent.mm", this.lPh, a.class, new d() {});
    AppMethodBeat.o(47306);
  }
  
  static final class LoadParams
    implements Parcelable
  {
    public static final Parcelable.Creator<LoadParams> CREATOR;
    public final String appId;
    public final String coY;
    public final int duK;
    public final QualitySession lNC;
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
      this.duK = paramParcel.readInt();
      this.pkgVersion = paramParcel.readInt();
      this.coY = paramParcel.readString();
      this.lNC = ((QualitySession)paramParcel.readParcelable(QualitySession.class.getClassLoader()));
      AppMethodBeat.o(47295);
    }
    
    private LoadParams(String paramString1, int paramInt1, int paramInt2, String paramString2, QualitySession paramQualitySession)
    {
      this.appId = paramString1;
      this.duK = paramInt1;
      this.pkgVersion = paramInt2;
      this.coY = paramString2;
      this.lNC = paramQualitySession;
    }
    
    public final int describeContents()
    {
      return 0;
    }
    
    public final String toString()
    {
      AppMethodBeat.i(47296);
      String str = "LoadParams{appId='" + this.appId + '\'' + ", pkgType=" + this.duK + ", pkgVersion=" + this.pkgVersion + ", moduleName='" + this.coY + '\'' + '}';
      AppMethodBeat.o(47296);
      return str;
    }
    
    public final void writeToParcel(Parcel paramParcel, int paramInt)
    {
      AppMethodBeat.i(47294);
      paramParcel.writeString(this.appId);
      paramParcel.writeInt(this.duK);
      paramParcel.writeInt(this.pkgVersion);
      paramParcel.writeString(this.coY);
      paramParcel.writeParcelable(this.lNC, paramInt);
      AppMethodBeat.o(47294);
    }
  }
  
  static class WxaPkgResultProgressPair
    implements Parcelable
  {
    public static final Parcelable.Creator<WxaPkgResultProgressPair> CREATOR;
    WxaPkgWrappingInfo lPp;
    WxaPkgLoadProgress lPq;
    private a lPr;
    
    static
    {
      AppMethodBeat.i(47304);
      CREATOR = new Parcelable.Creator() {};
      AppMethodBeat.o(47304);
    }
    
    WxaPkgResultProgressPair(Parcel paramParcel)
    {
      AppMethodBeat.i(47302);
      this.lPp = ((WxaPkgWrappingInfo)paramParcel.readParcelable(WxaPkgWrappingInfo.class.getClassLoader()));
      this.lPq = ((WxaPkgLoadProgress)paramParcel.readParcelable(WxaPkgLoadProgress.class.getClassLoader()));
      this.lPr = ((a)paramParcel.readSerializable());
      AppMethodBeat.o(47302);
    }
    
    WxaPkgResultProgressPair(WxaPkgLoadProgress paramWxaPkgLoadProgress)
    {
      this.lPq = paramWxaPkgLoadProgress;
      this.lPr = a.lPt;
    }
    
    WxaPkgResultProgressPair(WxaPkgWrappingInfo paramWxaPkgWrappingInfo)
    {
      this.lPp = paramWxaPkgWrappingInfo;
      this.lPr = a.lPs;
    }
    
    public int describeContents()
    {
      return 0;
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      AppMethodBeat.i(47303);
      paramParcel.writeParcelable(this.lPp, paramInt);
      paramParcel.writeParcelable(this.lPq, paramInt);
      paramParcel.writeSerializable(this.lPr);
      AppMethodBeat.o(47303);
    }
    
    static enum a
    {
      static
      {
        AppMethodBeat.i(47301);
        lPs = new a("Finish", 0);
        lPt = new a("Progressing", 1);
        lPu = new a[] { lPs, lPt };
        AppMethodBeat.o(47301);
      }
      
      private a() {}
    }
  }
  
  static final class a
    implements com.tencent.mm.ipcinvoker.b<ModularizingPkgRetrieverWC.LoadParams, ModularizingPkgRetrieverWC.WxaPkgResultProgressPair>
  {
    private d<ModularizingPkgRetrieverWC.WxaPkgResultProgressPair> gAo = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.launching.ModularizingPkgRetrieverWC
 * JD-Core Version:    0.7.0.1
 */