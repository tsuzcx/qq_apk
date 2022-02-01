package com.tencent.mm.plugin.appbrand.dynamic;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bx.b;
import com.tencent.mm.g.b.a.ej;
import com.tencent.mm.g.b.a.jl;
import com.tencent.mm.ipcinvoker.h;
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
import com.tencent.mm.protocal.protobuf.efh;
import com.tencent.mm.protocal.protobuf.efj;
import com.tencent.mm.protocal.protobuf.xf;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.ay;
import com.tencent.mm.sdk.platformtools.bt;
import junit.framework.Assert;

public final class WxaWidgetInitializer
{
  static WxaWidgetContextImpl a(String paramString1, String paramString2, WxaPkgWrappingInfo paramWxaPkgWrappingInfo, d paramd)
  {
    i = 1;
    AppMethodBeat.i(121205);
    ad.i("MicroMsg.WxaWidgetInitializer", "prepare(%s)", new Object[] { paramString1 });
    u.i("MicroMsg.WxaWidgetInitializer", "prepare(%s)", new Object[] { paramString1 });
    WxaPkgWrappingInfo localWxaPkgWrappingInfo = WxaCommLibRuntimeReader.bak();
    if (localWxaPkgWrappingInfo == null)
    {
      ad.e("MicroMsg.WxaWidgetInitializer", "getLibPkgInfo return null.");
      AppMethodBeat.o(121205);
      return null;
    }
    paramWxaPkgWrappingInfo = new WxaWidgetContextImpl(localWxaPkgWrappingInfo, paramWxaPkgWrappingInfo);
    paramWxaPkgWrappingInfo.gaR = paramString1;
    paramWxaPkgWrappingInfo.mAppId = paramString2;
    paramWxaPkgWrappingInfo.kfy = paramd.kir;
    if (paramWxaPkgWrappingInfo.kfy == null) {
      paramWxaPkgWrappingInfo.kfy = new DebuggerInfo();
    }
    paramWxaPkgWrappingInfo.kfz = paramd.kis;
    paramWxaPkgWrappingInfo.kfA = paramd.kit;
    for (;;)
    {
      try
      {
        if ((paramd.kiv == null) || (paramd.kiv.FWI == null)) {
          continue;
        }
        paramString2 = paramd.kiv.FWI.toByteArray();
        paramWxaPkgWrappingInfo.kfw = paramString2;
      }
      catch (Exception paramString2)
      {
        ad.e("MicroMsg.WxaWidgetInitializer", bt.n(paramString2));
        continue;
        if (paramd.kiu == null) {
          continue;
        }
        i = paramd.kiu.FqN;
        paramWxaPkgWrappingInfo.kfx = i;
        continue;
      }
      if (!paramWxaPkgWrappingInfo.kfy.kgf) {
        continue;
      }
      paramWxaPkgWrappingInfo.kfx = 2;
      f.bfI().bx(paramString1, 2101);
      j.bfM().M(paramString1, 626, 5);
      AppMethodBeat.o(121205);
      return paramWxaPkgWrappingInfo;
      paramString2 = new byte[0];
    }
  }
  
  public static String cJ(String paramString1, String paramString2)
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
    String gaR;
    WidgetRuntimeConfig kfA;
    WxaPkgWrappingInfo kfu;
    WxaPkgWrappingInfo kfv;
    byte[] kfw;
    int kfx;
    DebuggerInfo kfy;
    WidgetSysConfig kfz;
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
      this.gaR = paramParcel.readString();
      this.mAppId = paramParcel.readString();
      this.kfv = ((WxaPkgWrappingInfo)paramParcel.readParcelable(localClassLoader));
      this.kfu = ((WxaPkgWrappingInfo)paramParcel.readParcelable(localClassLoader));
      this.kfw = paramParcel.createByteArray();
      this.kfx = paramParcel.readInt();
      this.kfy = ((DebuggerInfo)paramParcel.readParcelable(localClassLoader));
      this.kfz = ((WidgetSysConfig)paramParcel.readParcelable(localClassLoader));
      this.kfA = ((WidgetRuntimeConfig)paramParcel.readParcelable(localClassLoader));
      AppMethodBeat.o(121201);
    }
    
    public WxaWidgetContextImpl(WxaPkgWrappingInfo paramWxaPkgWrappingInfo1, WxaPkgWrappingInfo paramWxaPkgWrappingInfo2)
    {
      AppMethodBeat.i(121202);
      Assert.assertNotNull(paramWxaPkgWrappingInfo1);
      Assert.assertNotNull(paramWxaPkgWrappingInfo2);
      this.kfv = paramWxaPkgWrappingInfo1;
      this.kfu = paramWxaPkgWrappingInfo2;
      AppMethodBeat.o(121202);
    }
    
    public final int aZt()
    {
      if (this.kfu != null) {
        return this.kfu.jIU;
      }
      return 0;
    }
    
    public final WxaPkgWrappingInfo bfN()
    {
      return this.kfu;
    }
    
    public final WxaPkgWrappingInfo bfO()
    {
      return this.kfv;
    }
    
    public final int bfP()
    {
      if (this.kfu != null) {
        return this.kfu.pkgVersion;
      }
      return 0;
    }
    
    public final byte[] bfQ()
    {
      return this.kfw;
    }
    
    public final int bfR()
    {
      return this.kfx;
    }
    
    public final DebuggerInfo bfS()
    {
      return this.kfy;
    }
    
    public final WidgetSysConfig bfT()
    {
      return this.kfz;
    }
    
    public final WidgetRuntimeConfig bfU()
    {
      return this.kfA;
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
      return this.gaR;
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      AppMethodBeat.i(121203);
      paramParcel.writeString(this.gaR);
      paramParcel.writeString(this.mAppId);
      paramParcel.writeParcelable(this.kfv, paramInt);
      paramParcel.writeParcelable(this.kfu, paramInt);
      paramParcel.writeByteArray(this.kfw);
      paramParcel.writeInt(this.kfx);
      paramParcel.writeParcelable(this.kfy, paramInt);
      paramParcel.writeParcelable(this.kfz, paramInt);
      paramParcel.writeParcelable(this.kfA, paramInt);
      AppMethodBeat.o(121203);
    }
  }
  
  public static abstract interface a
  {
    public abstract void a(String paramString1, String paramString2, boolean paramBoolean, WxaWidgetContext paramWxaWidgetContext);
    
    public abstract void cG(String paramString1, String paramString2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.dynamic.WxaWidgetInitializer
 * JD-Core Version:    0.7.0.1
 */