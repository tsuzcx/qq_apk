package com.tencent.mm.plugin.appbrand.dynamic;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.b;
import com.tencent.mm.g.b.a.hr;
import com.tencent.mm.g.b.a.nl;
import com.tencent.mm.ipcinvoker.h;
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
import com.tencent.mm.protocal.protobuf.fbo;
import com.tencent.mm.protocal.protobuf.fbq;
import com.tencent.mm.protocal.protobuf.ys;
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
    WxaPkgWrappingInfo localWxaPkgWrappingInfo = WxaCommLibRuntimeReader.bvX();
    if (localWxaPkgWrappingInfo == null)
    {
      Log.e("MicroMsg.WxaWidgetInitializer", "getLibPkgInfo return null.");
      AppMethodBeat.o(121205);
      return null;
    }
    paramWxaPkgWrappingInfo = new WxaWidgetContextImpl(localWxaPkgWrappingInfo, paramWxaPkgWrappingInfo);
    paramWxaPkgWrappingInfo.gIx = paramString1;
    paramWxaPkgWrappingInfo.mAppId = paramString2;
    paramWxaPkgWrappingInfo.lmw = paramd.lps;
    if (paramWxaPkgWrappingInfo.lmw == null) {
      paramWxaPkgWrappingInfo.lmw = new DebuggerInfo();
    }
    paramWxaPkgWrappingInfo.lmx = paramd.lpt;
    paramWxaPkgWrappingInfo.lmy = paramd.lpu;
    for (;;)
    {
      try
      {
        if ((paramd.lpw == null) || (paramd.lpw.LjS == null)) {
          continue;
        }
        paramString2 = paramd.lpw.LjS.toByteArray();
        paramWxaPkgWrappingInfo.lmu = paramString2;
      }
      catch (Exception paramString2)
      {
        Log.e("MicroMsg.WxaWidgetInitializer", Util.stackTraceToString(paramString2));
        continue;
        if (paramd.lpv == null) {
          continue;
        }
        i = paramd.lpv.KCD;
        paramWxaPkgWrappingInfo.lmv = i;
        continue;
      }
      if (!paramWxaPkgWrappingInfo.lmw.lnd) {
        continue;
      }
      paramWxaPkgWrappingInfo.lmv = 2;
      f.bBJ().bF(paramString1, 2101);
      j.bBN().P(paramString1, 626, 5);
      AppMethodBeat.o(121205);
      return paramWxaPkgWrappingInfo;
      paramString2 = new byte[0];
    }
  }
  
  public static String da(String paramString1, String paramString2)
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
    String gIx;
    WxaPkgWrappingInfo lms;
    WxaPkgWrappingInfo lmt;
    byte[] lmu;
    int lmv;
    DebuggerInfo lmw;
    WidgetSysConfig lmx;
    WidgetRuntimeConfig lmy;
    String mAppId;
    
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
      this.gIx = paramParcel.readString();
      this.mAppId = paramParcel.readString();
      this.lmt = ((WxaPkgWrappingInfo)paramParcel.readParcelable(localClassLoader));
      this.lms = ((WxaPkgWrappingInfo)paramParcel.readParcelable(localClassLoader));
      this.lmu = paramParcel.createByteArray();
      this.lmv = paramParcel.readInt();
      this.lmw = ((DebuggerInfo)paramParcel.readParcelable(localClassLoader));
      this.lmx = ((WidgetSysConfig)paramParcel.readParcelable(localClassLoader));
      this.lmy = ((WidgetRuntimeConfig)paramParcel.readParcelable(localClassLoader));
      AppMethodBeat.o(121201);
    }
    
    public WxaWidgetContextImpl(WxaPkgWrappingInfo paramWxaPkgWrappingInfo1, WxaPkgWrappingInfo paramWxaPkgWrappingInfo2)
    {
      AppMethodBeat.i(121202);
      Assert.assertNotNull(paramWxaPkgWrappingInfo1);
      Assert.assertNotNull(paramWxaPkgWrappingInfo2);
      this.lmt = paramWxaPkgWrappingInfo1;
      this.lms = paramWxaPkgWrappingInfo2;
      AppMethodBeat.o(121202);
    }
    
    public final WxaPkgWrappingInfo bBO()
    {
      return this.lms;
    }
    
    public final WxaPkgWrappingInfo bBP()
    {
      return this.lmt;
    }
    
    public final int bBQ()
    {
      if (this.lms != null) {
        return this.lms.pkgVersion;
      }
      return 0;
    }
    
    public final byte[] bBR()
    {
      return this.lmu;
    }
    
    public final int bBS()
    {
      return this.lmv;
    }
    
    public final DebuggerInfo bBT()
    {
      return this.lmw;
    }
    
    public final WidgetSysConfig bBU()
    {
      return this.lmx;
    }
    
    public final WidgetRuntimeConfig bBV()
    {
      return this.lmy;
    }
    
    public final int bvh()
    {
      if (this.lms != null) {
        return this.lms.kNW;
      }
      return 0;
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
      return this.gIx;
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      AppMethodBeat.i(121203);
      paramParcel.writeString(this.gIx);
      paramParcel.writeString(this.mAppId);
      paramParcel.writeParcelable(this.lmt, paramInt);
      paramParcel.writeParcelable(this.lms, paramInt);
      paramParcel.writeByteArray(this.lmu);
      paramParcel.writeInt(this.lmv);
      paramParcel.writeParcelable(this.lmw, paramInt);
      paramParcel.writeParcelable(this.lmx, paramInt);
      paramParcel.writeParcelable(this.lmy, paramInt);
      AppMethodBeat.o(121203);
    }
  }
  
  public static abstract interface a
  {
    public abstract void a(String paramString1, String paramString2, boolean paramBoolean, WxaWidgetContext paramWxaWidgetContext);
    
    public abstract void cX(String paramString1, String paramString2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.dynamic.WxaWidgetInitializer
 * JD-Core Version:    0.7.0.1
 */