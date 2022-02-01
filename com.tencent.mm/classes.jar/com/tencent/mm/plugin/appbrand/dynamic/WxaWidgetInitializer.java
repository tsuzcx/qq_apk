package com.tencent.mm.plugin.appbrand.dynamic;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bx.b;
import com.tencent.mm.g.b.a.ca;
import com.tencent.mm.g.b.a.gp;
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
import com.tencent.mm.protocal.protobuf.dto;
import com.tencent.mm.protocal.protobuf.dtq;
import com.tencent.mm.protocal.protobuf.uw;
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
    WxaPkgWrappingInfo localWxaPkgWrappingInfo = WxaCommLibRuntimeReader.aPV();
    if (localWxaPkgWrappingInfo == null)
    {
      ad.e("MicroMsg.WxaWidgetInitializer", "getLibPkgInfo return null.");
      AppMethodBeat.o(121205);
      return null;
    }
    paramWxaPkgWrappingInfo = new WxaWidgetContextImpl(localWxaPkgWrappingInfo, paramWxaPkgWrappingInfo);
    paramWxaPkgWrappingInfo.fDK = paramString1;
    paramWxaPkgWrappingInfo.mAppId = paramString2;
    paramWxaPkgWrappingInfo.jla = paramd.jnU;
    if (paramWxaPkgWrappingInfo.jla == null) {
      paramWxaPkgWrappingInfo.jla = new DebuggerInfo();
    }
    paramWxaPkgWrappingInfo.jlb = paramd.jnV;
    paramWxaPkgWrappingInfo.jlc = paramd.jnW;
    for (;;)
    {
      try
      {
        if ((paramd.jnY == null) || (paramd.jnY.CWN == null)) {
          continue;
        }
        paramString2 = paramd.jnY.CWN.toByteArray();
        paramWxaPkgWrappingInfo.jkY = paramString2;
      }
      catch (Exception paramString2)
      {
        ad.e("MicroMsg.WxaWidgetInitializer", bt.m(paramString2));
        continue;
        if (paramd.jnX == null) {
          continue;
        }
        i = paramd.jnX.Ctr;
        paramWxaPkgWrappingInfo.jkZ = i;
        continue;
      }
      if (!paramWxaPkgWrappingInfo.jla.jlH) {
        continue;
      }
      paramWxaPkgWrappingInfo.jkZ = 2;
      f.aVg().br(paramString1, 2101);
      j.aVk().L(paramString1, 626, 5);
      AppMethodBeat.o(121205);
      return paramWxaPkgWrappingInfo;
      paramString2 = new byte[0];
    }
  }
  
  public static String cx(String paramString1, String paramString2)
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
    String fDK;
    WxaPkgWrappingInfo jkW;
    WxaPkgWrappingInfo jkX;
    byte[] jkY;
    int jkZ;
    DebuggerInfo jla;
    WidgetSysConfig jlb;
    WidgetRuntimeConfig jlc;
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
      this.fDK = paramParcel.readString();
      this.mAppId = paramParcel.readString();
      this.jkX = ((WxaPkgWrappingInfo)paramParcel.readParcelable(localClassLoader));
      this.jkW = ((WxaPkgWrappingInfo)paramParcel.readParcelable(localClassLoader));
      this.jkY = paramParcel.createByteArray();
      this.jkZ = paramParcel.readInt();
      this.jla = ((DebuggerInfo)paramParcel.readParcelable(localClassLoader));
      this.jlb = ((WidgetSysConfig)paramParcel.readParcelable(localClassLoader));
      this.jlc = ((WidgetRuntimeConfig)paramParcel.readParcelable(localClassLoader));
      AppMethodBeat.o(121201);
    }
    
    public WxaWidgetContextImpl(WxaPkgWrappingInfo paramWxaPkgWrappingInfo1, WxaPkgWrappingInfo paramWxaPkgWrappingInfo2)
    {
      AppMethodBeat.i(121202);
      Assert.assertNotNull(paramWxaPkgWrappingInfo1);
      Assert.assertNotNull(paramWxaPkgWrappingInfo2);
      this.jkX = paramWxaPkgWrappingInfo1;
      this.jkW = paramWxaPkgWrappingInfo2;
      AppMethodBeat.o(121202);
    }
    
    public final int aPg()
    {
      if (this.jkW != null) {
        return this.jkW.iOQ;
      }
      return 0;
    }
    
    public final WxaPkgWrappingInfo aVl()
    {
      return this.jkW;
    }
    
    public final WxaPkgWrappingInfo aVm()
    {
      return this.jkX;
    }
    
    public final int aVn()
    {
      if (this.jkW != null) {
        return this.jkW.pkgVersion;
      }
      return 0;
    }
    
    public final byte[] aVo()
    {
      return this.jkY;
    }
    
    public final int aVp()
    {
      return this.jkZ;
    }
    
    public final DebuggerInfo aVq()
    {
      return this.jla;
    }
    
    public final WidgetSysConfig aVr()
    {
      return this.jlb;
    }
    
    public final WidgetRuntimeConfig aVs()
    {
      return this.jlc;
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
      return this.fDK;
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      AppMethodBeat.i(121203);
      paramParcel.writeString(this.fDK);
      paramParcel.writeString(this.mAppId);
      paramParcel.writeParcelable(this.jkX, paramInt);
      paramParcel.writeParcelable(this.jkW, paramInt);
      paramParcel.writeByteArray(this.jkY);
      paramParcel.writeInt(this.jkZ);
      paramParcel.writeParcelable(this.jla, paramInt);
      paramParcel.writeParcelable(this.jlb, paramInt);
      paramParcel.writeParcelable(this.jlc, paramInt);
      AppMethodBeat.o(121203);
    }
  }
  
  public static abstract interface a
  {
    public abstract void a(String paramString1, String paramString2, boolean paramBoolean, WxaWidgetContext paramWxaWidgetContext);
    
    public abstract void cu(String paramString1, String paramString2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.dynamic.WxaWidgetInitializer
 * JD-Core Version:    0.7.0.1
 */