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
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.sdk.platformtools.i;

public final class ModularizingPkgRetrieverWC
  implements e, com.tencent.mm.vending.e.a
{
  final LoadParams lKH;
  volatile e.a lKI;
  transient com.tencent.mm.plugin.appbrand.jsapi.o.a lKJ;
  
  private ModularizingPkgRetrieverWC(String paramString1, int paramInt1, int paramInt2, String paramString2)
  {
    AppMethodBeat.i(47305);
    this.lKJ = new com.tencent.mm.plugin.appbrand.jsapi.o.a();
    this.lKH = new LoadParams(paramString1, paramInt1, paramInt2, paramString2, com.tencent.mm.plugin.appbrand.report.quality.a.Ut(paramString1), (byte)0);
    AppMethodBeat.o(47305);
  }
  
  public final void a(e.a parama)
  {
    this.lKI = parama;
  }
  
  public final void dead()
  {
    this.lKI = null;
  }
  
  public final void start()
  {
    AppMethodBeat.i(47306);
    ad.i("MicroMsg.AppBrand.ModularizingPkgRetrieverWC[modularizing]", "startLoad %s", new Object[] { this.lKH.toString() });
    this.lKJ.setName("loadPackage");
    this.lKJ.startTime = bt.flT();
    this.lKJ.r("packageName", this.lKH.coW);
    XIPCInvoker.a("com.tencent.mm", this.lKH, a.class, new d() {});
    AppMethodBeat.o(47306);
  }
  
  static final class LoadParams
    implements Parcelable
  {
    public static final Parcelable.Creator<LoadParams> CREATOR;
    public final String appId;
    public final String coW;
    public final int dtF;
    public final QualitySession lJc;
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
      this.dtF = paramParcel.readInt();
      this.pkgVersion = paramParcel.readInt();
      this.coW = paramParcel.readString();
      this.lJc = ((QualitySession)paramParcel.readParcelable(QualitySession.class.getClassLoader()));
      AppMethodBeat.o(47295);
    }
    
    private LoadParams(String paramString1, int paramInt1, int paramInt2, String paramString2, QualitySession paramQualitySession)
    {
      this.appId = paramString1;
      this.dtF = paramInt1;
      this.pkgVersion = paramInt2;
      this.coW = paramString2;
      this.lJc = paramQualitySession;
    }
    
    public final int describeContents()
    {
      return 0;
    }
    
    public final String toString()
    {
      AppMethodBeat.i(47296);
      String str = "LoadParams{appId='" + this.appId + '\'' + ", pkgType=" + this.dtF + ", pkgVersion=" + this.pkgVersion + ", moduleName='" + this.coW + '\'' + '}';
      AppMethodBeat.o(47296);
      return str;
    }
    
    public final void writeToParcel(Parcel paramParcel, int paramInt)
    {
      AppMethodBeat.i(47294);
      paramParcel.writeString(this.appId);
      paramParcel.writeInt(this.dtF);
      paramParcel.writeInt(this.pkgVersion);
      paramParcel.writeString(this.coW);
      paramParcel.writeParcelable(this.lJc, paramInt);
      AppMethodBeat.o(47294);
    }
  }
  
  static class WxaPkgResultProgressPair
    implements Parcelable
  {
    public static final Parcelable.Creator<WxaPkgResultProgressPair> CREATOR;
    WxaPkgWrappingInfo lKP;
    WxaPkgLoadProgress lKQ;
    private a lKR;
    
    static
    {
      AppMethodBeat.i(47304);
      CREATOR = new Parcelable.Creator() {};
      AppMethodBeat.o(47304);
    }
    
    WxaPkgResultProgressPair(Parcel paramParcel)
    {
      AppMethodBeat.i(47302);
      this.lKP = ((WxaPkgWrappingInfo)paramParcel.readParcelable(WxaPkgWrappingInfo.class.getClassLoader()));
      this.lKQ = ((WxaPkgLoadProgress)paramParcel.readParcelable(WxaPkgLoadProgress.class.getClassLoader()));
      this.lKR = ((a)paramParcel.readSerializable());
      AppMethodBeat.o(47302);
    }
    
    WxaPkgResultProgressPair(WxaPkgLoadProgress paramWxaPkgLoadProgress)
    {
      this.lKQ = paramWxaPkgLoadProgress;
      this.lKR = a.lKT;
    }
    
    WxaPkgResultProgressPair(WxaPkgWrappingInfo paramWxaPkgWrappingInfo)
    {
      this.lKP = paramWxaPkgWrappingInfo;
      this.lKR = a.lKS;
    }
    
    public int describeContents()
    {
      return 0;
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      AppMethodBeat.i(47303);
      paramParcel.writeParcelable(this.lKP, paramInt);
      paramParcel.writeParcelable(this.lKQ, paramInt);
      paramParcel.writeSerializable(this.lKR);
      AppMethodBeat.o(47303);
    }
    
    static enum a
    {
      static
      {
        AppMethodBeat.i(47301);
        lKS = new a("Finish", 0);
        lKT = new a("Progressing", 1);
        lKU = new a[] { lKS, lKT };
        AppMethodBeat.o(47301);
      }
      
      private a() {}
    }
  }
  
  static final class a
    implements com.tencent.mm.ipcinvoker.b<ModularizingPkgRetrieverWC.LoadParams, ModularizingPkgRetrieverWC.WxaPkgResultProgressPair>
  {
    private d<ModularizingPkgRetrieverWC.WxaPkgResultProgressPair> gxH = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.launching.ModularizingPkgRetrieverWC
 * JD-Core Version:    0.7.0.1
 */