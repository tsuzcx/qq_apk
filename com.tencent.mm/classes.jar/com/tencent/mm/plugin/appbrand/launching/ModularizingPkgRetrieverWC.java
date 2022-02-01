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
import com.tencent.mm.plugin.appbrand.n.e;
import com.tencent.mm.plugin.appbrand.n.e.a;
import com.tencent.mm.plugin.appbrand.n.e.c;
import com.tencent.mm.plugin.appbrand.report.quality.QualitySession;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.sdk.platformtools.h;

public final class ModularizingPkgRetrieverWC
  implements e, com.tencent.mm.vending.e.a
{
  final LoadParams lnp;
  volatile e.a lnq;
  transient com.tencent.mm.plugin.appbrand.jsapi.l.a lnr;
  
  private ModularizingPkgRetrieverWC(String paramString1, int paramInt1, int paramInt2, String paramString2)
  {
    AppMethodBeat.i(47305);
    this.lnr = new com.tencent.mm.plugin.appbrand.jsapi.l.a();
    this.lnp = new LoadParams(paramString1, paramInt1, paramInt2, paramString2, com.tencent.mm.plugin.appbrand.report.quality.a.QN(paramString1), (byte)0);
    AppMethodBeat.o(47305);
  }
  
  public final void a(e.a parama)
  {
    this.lnq = parama;
  }
  
  public final void dead()
  {
    this.lnq = null;
  }
  
  public final void start()
  {
    AppMethodBeat.i(47306);
    ac.i("MicroMsg.AppBrand.ModularizingPkgRetrieverWC[modularizing]", "startLoad %s", new Object[] { this.lnp.toString() });
    this.lnr.setName("loadPackage");
    this.lnr.startTime = bs.eWj();
    this.lnr.s("packageName", this.lnp.ceF);
    XIPCInvoker.a("com.tencent.mm", this.lnp, a.class, new d() {});
    AppMethodBeat.o(47306);
  }
  
  static final class LoadParams
    implements Parcelable
  {
    public static final Parcelable.Creator<LoadParams> CREATOR;
    public final String appId;
    public final String ceF;
    public final int dib;
    public final QualitySession llU;
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
      this.dib = paramParcel.readInt();
      this.pkgVersion = paramParcel.readInt();
      this.ceF = paramParcel.readString();
      this.llU = ((QualitySession)paramParcel.readParcelable(QualitySession.class.getClassLoader()));
      AppMethodBeat.o(47295);
    }
    
    private LoadParams(String paramString1, int paramInt1, int paramInt2, String paramString2, QualitySession paramQualitySession)
    {
      this.appId = paramString1;
      this.dib = paramInt1;
      this.pkgVersion = paramInt2;
      this.ceF = paramString2;
      this.llU = paramQualitySession;
    }
    
    public final int describeContents()
    {
      return 0;
    }
    
    public final String toString()
    {
      AppMethodBeat.i(47296);
      String str = "LoadParams{appId='" + this.appId + '\'' + ", pkgType=" + this.dib + ", pkgVersion=" + this.pkgVersion + ", moduleName='" + this.ceF + '\'' + '}';
      AppMethodBeat.o(47296);
      return str;
    }
    
    public final void writeToParcel(Parcel paramParcel, int paramInt)
    {
      AppMethodBeat.i(47294);
      paramParcel.writeString(this.appId);
      paramParcel.writeInt(this.dib);
      paramParcel.writeInt(this.pkgVersion);
      paramParcel.writeString(this.ceF);
      paramParcel.writeParcelable(this.llU, paramInt);
      AppMethodBeat.o(47294);
    }
  }
  
  static class WxaPkgResultProgressPair
    implements Parcelable
  {
    public static final Parcelable.Creator<WxaPkgResultProgressPair> CREATOR;
    WxaPkgWrappingInfo lnx;
    WxaPkgLoadProgress lny;
    private a lnz;
    
    static
    {
      AppMethodBeat.i(47304);
      CREATOR = new Parcelable.Creator() {};
      AppMethodBeat.o(47304);
    }
    
    WxaPkgResultProgressPair(Parcel paramParcel)
    {
      AppMethodBeat.i(47302);
      this.lnx = ((WxaPkgWrappingInfo)paramParcel.readParcelable(WxaPkgWrappingInfo.class.getClassLoader()));
      this.lny = ((WxaPkgLoadProgress)paramParcel.readParcelable(WxaPkgLoadProgress.class.getClassLoader()));
      this.lnz = ((a)paramParcel.readSerializable());
      AppMethodBeat.o(47302);
    }
    
    WxaPkgResultProgressPair(WxaPkgLoadProgress paramWxaPkgLoadProgress)
    {
      this.lny = paramWxaPkgLoadProgress;
      this.lnz = a.lnB;
    }
    
    WxaPkgResultProgressPair(WxaPkgWrappingInfo paramWxaPkgWrappingInfo)
    {
      this.lnx = paramWxaPkgWrappingInfo;
      this.lnz = a.lnA;
    }
    
    public int describeContents()
    {
      return 0;
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      AppMethodBeat.i(47303);
      paramParcel.writeParcelable(this.lnx, paramInt);
      paramParcel.writeParcelable(this.lny, paramInt);
      paramParcel.writeSerializable(this.lnz);
      AppMethodBeat.o(47303);
    }
    
    static enum a
    {
      static
      {
        AppMethodBeat.i(47301);
        lnA = new a("Finish", 0);
        lnB = new a("Progressing", 1);
        lnC = new a[] { lnA, lnB };
        AppMethodBeat.o(47301);
      }
      
      private a() {}
    }
  }
  
  static final class a
    implements com.tencent.mm.ipcinvoker.b<ModularizingPkgRetrieverWC.LoadParams, ModularizingPkgRetrieverWC.WxaPkgResultProgressPair>
  {
    private d<ModularizingPkgRetrieverWC.WxaPkgResultProgressPair> gdX = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.launching.ModularizingPkgRetrieverWC
 * JD-Core Version:    0.7.0.1
 */