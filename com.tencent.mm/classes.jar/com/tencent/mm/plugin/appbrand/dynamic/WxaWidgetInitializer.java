package com.tencent.mm.plugin.appbrand.dynamic;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.mmdata.rpt.mn;
import com.tencent.mm.autogen.mmdata.rpt.uf;
import com.tencent.mm.bx.b;
import com.tencent.mm.ipcinvoker.wx_extension.service.MainProcessIPCService;
import com.tencent.mm.modelappbrand.u;
import com.tencent.mm.modelappbrand.v;
import com.tencent.mm.plugin.appbrand.appcache.WxaCommLibRuntimeReader;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkgWrappingInfo;
import com.tencent.mm.plugin.appbrand.dynamic.debugger.DebuggerInfo;
import com.tencent.mm.plugin.appbrand.dynamic.j.a;
import com.tencent.mm.plugin.appbrand.dynamic.j.a.2;
import com.tencent.mm.plugin.appbrand.dynamic.j.a.d;
import com.tencent.mm.plugin.appbrand.dynamic.j.a.e;
import com.tencent.mm.plugin.appbrand.dynamic.j.d;
import com.tencent.mm.plugin.appbrand.dynamic.launching.WidgetRuntimeConfig;
import com.tencent.mm.plugin.appbrand.dynamic.launching.WidgetSysConfig;
import com.tencent.mm.protocal.protobuf.aat;
import com.tencent.mm.protocal.protobuf.giz;
import com.tencent.mm.protocal.protobuf.gjb;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import com.tencent.mm.sdk.platformtools.Util;
import junit.framework.Assert;

public final class WxaWidgetInitializer
{
  static WxaWidgetContextImpl a(String paramString1, String paramString2, WxaPkgWrappingInfo paramWxaPkgWrappingInfo, d paramd)
  {
    i = 1;
    AppMethodBeat.i(121205);
    Log.i("MicroMsg.WxaWidgetInitializer", "prepare(%s)", new Object[] { paramString1 });
    u.i("MicroMsg.WxaWidgetInitializer", "prepare(%s)", new Object[] { paramString1 });
    WxaPkgWrappingInfo localWxaPkgWrappingInfo = WxaCommLibRuntimeReader.cgB();
    if (localWxaPkgWrappingInfo == null)
    {
      Log.e("MicroMsg.WxaWidgetInitializer", "getLibPkgInfo return null.");
      AppMethodBeat.o(121205);
      return null;
    }
    paramWxaPkgWrappingInfo = new WxaWidgetContextImpl(localWxaPkgWrappingInfo, paramWxaPkgWrappingInfo);
    paramWxaPkgWrappingInfo.lWh = paramString1;
    paramWxaPkgWrappingInfo.mAppId = paramString2;
    paramWxaPkgWrappingInfo.rkM = paramd.rnE;
    if (paramWxaPkgWrappingInfo.rkM == null) {
      paramWxaPkgWrappingInfo.rkM = new DebuggerInfo();
    }
    paramWxaPkgWrappingInfo.rkN = paramd.rnF;
    paramWxaPkgWrappingInfo.rkO = paramd.rnG;
    for (;;)
    {
      try
      {
        if ((paramd.rnI == null) || (paramd.rnI.Zjj == null)) {
          continue;
        }
        paramString2 = paramd.rnI.Zjj.toByteArray();
        paramWxaPkgWrappingInfo.rkK = paramString2;
      }
      catch (Exception paramString2)
      {
        Log.e("MicroMsg.WxaWidgetInitializer", Util.stackTraceToString(paramString2));
        continue;
        if (paramd.rnH == null) {
          continue;
        }
        i = paramd.rnH.aamK;
        paramWxaPkgWrappingInfo.rkL = i;
        continue;
      }
      if (!paramWxaPkgWrappingInfo.rkM.rlr) {
        continue;
      }
      paramWxaPkgWrappingInfo.rkL = 2;
      f.cnu().cx(paramString1, 2101);
      j.cny().T(paramString1, 626, 5);
      AppMethodBeat.o(121205);
      return paramWxaPkgWrappingInfo;
      paramString2 = new byte[0];
    }
  }
  
  public static String dC(String paramString1, String paramString2)
  {
    AppMethodBeat.i(121206);
    paramString1 = paramString1 + "#" + paramString2 + "#" + System.currentTimeMillis();
    AppMethodBeat.o(121206);
    return paramString1;
  }
  
  static class WxaWidgetContextImpl
    implements WxaWidgetContext
  {
    public static final Parcelable.Creator<WxaWidgetContextImpl> CREATOR;
    String lWh;
    String mAppId;
    WxaPkgWrappingInfo rkI;
    WxaPkgWrappingInfo rkJ;
    byte[] rkK;
    int rkL;
    DebuggerInfo rkM;
    WidgetSysConfig rkN;
    WidgetRuntimeConfig rkO;
    
    static
    {
      AppMethodBeat.i(121204);
      CREATOR = new Parcelable.Creator() {};
      AppMethodBeat.o(121204);
    }
    
    public WxaWidgetContextImpl(Parcel paramParcel)
    {
      AppMethodBeat.i(121201);
      ClassLoader localClassLoader = getClass().getClassLoader();
      this.lWh = paramParcel.readString();
      this.mAppId = paramParcel.readString();
      this.rkJ = ((WxaPkgWrappingInfo)paramParcel.readParcelable(localClassLoader));
      this.rkI = ((WxaPkgWrappingInfo)paramParcel.readParcelable(localClassLoader));
      this.rkK = paramParcel.createByteArray();
      this.rkL = paramParcel.readInt();
      this.rkM = ((DebuggerInfo)paramParcel.readParcelable(localClassLoader));
      this.rkN = ((WidgetSysConfig)paramParcel.readParcelable(localClassLoader));
      this.rkO = ((WidgetRuntimeConfig)paramParcel.readParcelable(localClassLoader));
      AppMethodBeat.o(121201);
    }
    
    public WxaWidgetContextImpl(WxaPkgWrappingInfo paramWxaPkgWrappingInfo1, WxaPkgWrappingInfo paramWxaPkgWrappingInfo2)
    {
      AppMethodBeat.i(121202);
      Assert.assertNotNull(paramWxaPkgWrappingInfo1);
      Assert.assertNotNull(paramWxaPkgWrappingInfo2);
      this.rkJ = paramWxaPkgWrappingInfo1;
      this.rkI = paramWxaPkgWrappingInfo2;
      AppMethodBeat.o(121202);
    }
    
    public final int cfM()
    {
      if (this.rkI != null) {
        return this.rkI.qHO;
      }
      return 0;
    }
    
    public final WxaPkgWrappingInfo cnA()
    {
      return this.rkJ;
    }
    
    public final int cnB()
    {
      if (this.rkI != null) {
        return this.rkI.pkgVersion;
      }
      return 0;
    }
    
    public final byte[] cnC()
    {
      return this.rkK;
    }
    
    public final int cnD()
    {
      return this.rkL;
    }
    
    public final DebuggerInfo cnE()
    {
      return this.rkM;
    }
    
    public final WidgetSysConfig cnF()
    {
      return this.rkN;
    }
    
    public final WidgetRuntimeConfig cnG()
    {
      return this.rkO;
    }
    
    public final WxaPkgWrappingInfo cnz()
    {
      return this.rkI;
    }
    
    public int describeContents()
    {
      return 0;
    }
    
    public final String getAppId()
    {
      return this.mAppId;
    }
    
    public final String getId()
    {
      return this.lWh;
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      AppMethodBeat.i(121203);
      paramParcel.writeString(this.lWh);
      paramParcel.writeString(this.mAppId);
      paramParcel.writeParcelable(this.rkJ, paramInt);
      paramParcel.writeParcelable(this.rkI, paramInt);
      paramParcel.writeByteArray(this.rkK);
      paramParcel.writeInt(this.rkL);
      paramParcel.writeParcelable(this.rkM, paramInt);
      paramParcel.writeParcelable(this.rkN, paramInt);
      paramParcel.writeParcelable(this.rkO, paramInt);
      AppMethodBeat.o(121203);
    }
  }
  
  public static abstract interface a
  {
    public abstract void a(String paramString1, String paramString2, boolean paramBoolean, WxaWidgetContext paramWxaWidgetContext);
    
    public abstract void dz(String paramString1, String paramString2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.dynamic.WxaWidgetInitializer
 * JD-Core Version:    0.7.0.1
 */