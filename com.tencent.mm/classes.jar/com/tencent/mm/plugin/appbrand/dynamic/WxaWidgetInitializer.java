package com.tencent.mm.plugin.appbrand.dynamic;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.b;
import com.tencent.mm.g.b.a.do;
import com.tencent.mm.g.b.a.ih;
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
import com.tencent.mm.protocal.protobuf.dzf;
import com.tencent.mm.protocal.protobuf.dzh;
import com.tencent.mm.protocal.protobuf.vg;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.ax;
import com.tencent.mm.sdk.platformtools.bs;
import junit.framework.Assert;

public final class WxaWidgetInitializer
{
  static WxaWidgetContextImpl a(String paramString1, String paramString2, WxaPkgWrappingInfo paramWxaPkgWrappingInfo, d paramd)
  {
    i = 1;
    AppMethodBeat.i(121205);
    ac.i("MicroMsg.WxaWidgetInitializer", "prepare(%s)", new Object[] { paramString1 });
    u.i("MicroMsg.WxaWidgetInitializer", "prepare(%s)", new Object[] { paramString1 });
    WxaPkgWrappingInfo localWxaPkgWrappingInfo = WxaCommLibRuntimeReader.aWN();
    if (localWxaPkgWrappingInfo == null)
    {
      ac.e("MicroMsg.WxaWidgetInitializer", "getLibPkgInfo return null.");
      AppMethodBeat.o(121205);
      return null;
    }
    paramWxaPkgWrappingInfo = new WxaWidgetContextImpl(localWxaPkgWrappingInfo, paramWxaPkgWrappingInfo);
    paramWxaPkgWrappingInfo.fHr = paramString1;
    paramWxaPkgWrappingInfo.mAppId = paramString2;
    paramWxaPkgWrappingInfo.jLn = paramd.jOg;
    if (paramWxaPkgWrappingInfo.jLn == null) {
      paramWxaPkgWrappingInfo.jLn = new DebuggerInfo();
    }
    paramWxaPkgWrappingInfo.jLo = paramd.jOh;
    paramWxaPkgWrappingInfo.jLp = paramd.jOi;
    for (;;)
    {
      try
      {
        if ((paramd.jOk == null) || (paramd.jOk.Epw == null)) {
          continue;
        }
        paramString2 = paramd.jOk.Epw.toByteArray();
        paramWxaPkgWrappingInfo.jLl = paramString2;
      }
      catch (Exception paramString2)
      {
        ac.e("MicroMsg.WxaWidgetInitializer", bs.m(paramString2));
        continue;
        if (paramd.jOj == null) {
          continue;
        }
        i = paramd.jOj.DLI;
        paramWxaPkgWrappingInfo.jLm = i;
        continue;
      }
      if (!paramWxaPkgWrappingInfo.jLn.jLU) {
        continue;
      }
      paramWxaPkgWrappingInfo.jLm = 2;
      f.bce().bv(paramString1, 2101);
      j.bci().K(paramString1, 626, 5);
      AppMethodBeat.o(121205);
      return paramWxaPkgWrappingInfo;
      paramString2 = new byte[0];
    }
  }
  
  public static String cH(String paramString1, String paramString2)
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
    String fHr;
    WxaPkgWrappingInfo jLj;
    WxaPkgWrappingInfo jLk;
    byte[] jLl;
    int jLm;
    DebuggerInfo jLn;
    WidgetSysConfig jLo;
    WidgetRuntimeConfig jLp;
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
      this.fHr = paramParcel.readString();
      this.mAppId = paramParcel.readString();
      this.jLk = ((WxaPkgWrappingInfo)paramParcel.readParcelable(localClassLoader));
      this.jLj = ((WxaPkgWrappingInfo)paramParcel.readParcelable(localClassLoader));
      this.jLl = paramParcel.createByteArray();
      this.jLm = paramParcel.readInt();
      this.jLn = ((DebuggerInfo)paramParcel.readParcelable(localClassLoader));
      this.jLo = ((WidgetSysConfig)paramParcel.readParcelable(localClassLoader));
      this.jLp = ((WidgetRuntimeConfig)paramParcel.readParcelable(localClassLoader));
      AppMethodBeat.o(121201);
    }
    
    public WxaWidgetContextImpl(WxaPkgWrappingInfo paramWxaPkgWrappingInfo1, WxaPkgWrappingInfo paramWxaPkgWrappingInfo2)
    {
      AppMethodBeat.i(121202);
      Assert.assertNotNull(paramWxaPkgWrappingInfo1);
      Assert.assertNotNull(paramWxaPkgWrappingInfo2);
      this.jLk = paramWxaPkgWrappingInfo1;
      this.jLj = paramWxaPkgWrappingInfo2;
      AppMethodBeat.o(121202);
    }
    
    public final int aVY()
    {
      if (this.jLj != null) {
        return this.jLj.jpa;
      }
      return 0;
    }
    
    public final WxaPkgWrappingInfo bcj()
    {
      return this.jLj;
    }
    
    public final WxaPkgWrappingInfo bck()
    {
      return this.jLk;
    }
    
    public final int bcl()
    {
      if (this.jLj != null) {
        return this.jLj.pkgVersion;
      }
      return 0;
    }
    
    public final byte[] bcm()
    {
      return this.jLl;
    }
    
    public final int bcn()
    {
      return this.jLm;
    }
    
    public final DebuggerInfo bco()
    {
      return this.jLn;
    }
    
    public final WidgetSysConfig bcp()
    {
      return this.jLo;
    }
    
    public final WidgetRuntimeConfig bcq()
    {
      return this.jLp;
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
      return this.fHr;
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      AppMethodBeat.i(121203);
      paramParcel.writeString(this.fHr);
      paramParcel.writeString(this.mAppId);
      paramParcel.writeParcelable(this.jLk, paramInt);
      paramParcel.writeParcelable(this.jLj, paramInt);
      paramParcel.writeByteArray(this.jLl);
      paramParcel.writeInt(this.jLm);
      paramParcel.writeParcelable(this.jLn, paramInt);
      paramParcel.writeParcelable(this.jLo, paramInt);
      paramParcel.writeParcelable(this.jLp, paramInt);
      AppMethodBeat.o(121203);
    }
  }
  
  public static abstract interface a
  {
    public abstract void a(String paramString1, String paramString2, boolean paramBoolean, WxaWidgetContext paramWxaWidgetContext);
    
    public abstract void cE(String paramString1, String paramString2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.dynamic.WxaWidgetInitializer
 * JD-Core Version:    0.7.0.1
 */