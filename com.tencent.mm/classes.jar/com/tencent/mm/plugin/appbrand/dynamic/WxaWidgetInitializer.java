package com.tencent.mm.plugin.appbrand.dynamic;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.b;
import com.tencent.mm.g.b.a.el;
import com.tencent.mm.g.b.a.jn;
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
import com.tencent.mm.protocal.protobuf.egy;
import com.tencent.mm.protocal.protobuf.eha;
import com.tencent.mm.protocal.protobuf.xi;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.az;
import com.tencent.mm.sdk.platformtools.bu;
import junit.framework.Assert;

public final class WxaWidgetInitializer
{
  static WxaWidgetContextImpl a(String paramString1, String paramString2, WxaPkgWrappingInfo paramWxaPkgWrappingInfo, d paramd)
  {
    i = 1;
    AppMethodBeat.i(121205);
    ae.i("MicroMsg.WxaWidgetInitializer", "prepare(%s)", new Object[] { paramString1 });
    u.i("MicroMsg.WxaWidgetInitializer", "prepare(%s)", new Object[] { paramString1 });
    WxaPkgWrappingInfo localWxaPkgWrappingInfo = WxaCommLibRuntimeReader.baJ();
    if (localWxaPkgWrappingInfo == null)
    {
      ae.e("MicroMsg.WxaWidgetInitializer", "getLibPkgInfo return null.");
      AppMethodBeat.o(121205);
      return null;
    }
    paramWxaPkgWrappingInfo = new WxaWidgetContextImpl(localWxaPkgWrappingInfo, paramWxaPkgWrappingInfo);
    paramWxaPkgWrappingInfo.gcZ = paramString1;
    paramWxaPkgWrappingInfo.mAppId = paramString2;
    paramWxaPkgWrappingInfo.kiO = paramd.klH;
    if (paramWxaPkgWrappingInfo.kiO == null) {
      paramWxaPkgWrappingInfo.kiO = new DebuggerInfo();
    }
    paramWxaPkgWrappingInfo.kiP = paramd.klI;
    paramWxaPkgWrappingInfo.kiQ = paramd.klJ;
    for (;;)
    {
      try
      {
        if ((paramd.klL == null) || (paramd.klL.Gph == null)) {
          continue;
        }
        paramString2 = paramd.klL.Gph.toByteArray();
        paramWxaPkgWrappingInfo.kiM = paramString2;
      }
      catch (Exception paramString2)
      {
        ae.e("MicroMsg.WxaWidgetInitializer", bu.o(paramString2));
        continue;
        if (paramd.klK == null) {
          continue;
        }
        i = paramd.klK.FJl;
        paramWxaPkgWrappingInfo.kiN = i;
        continue;
      }
      if (!paramWxaPkgWrappingInfo.kiO.kjv) {
        continue;
      }
      paramWxaPkgWrappingInfo.kiN = 2;
      f.bgq().bA(paramString1, 2101);
      j.bgu().M(paramString1, 626, 5);
      AppMethodBeat.o(121205);
      return paramWxaPkgWrappingInfo;
      paramString2 = new byte[0];
    }
  }
  
  public static String cL(String paramString1, String paramString2)
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
    String gcZ;
    WxaPkgWrappingInfo kiK;
    WxaPkgWrappingInfo kiL;
    byte[] kiM;
    int kiN;
    DebuggerInfo kiO;
    WidgetSysConfig kiP;
    WidgetRuntimeConfig kiQ;
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
      this.gcZ = paramParcel.readString();
      this.mAppId = paramParcel.readString();
      this.kiL = ((WxaPkgWrappingInfo)paramParcel.readParcelable(localClassLoader));
      this.kiK = ((WxaPkgWrappingInfo)paramParcel.readParcelable(localClassLoader));
      this.kiM = paramParcel.createByteArray();
      this.kiN = paramParcel.readInt();
      this.kiO = ((DebuggerInfo)paramParcel.readParcelable(localClassLoader));
      this.kiP = ((WidgetSysConfig)paramParcel.readParcelable(localClassLoader));
      this.kiQ = ((WidgetRuntimeConfig)paramParcel.readParcelable(localClassLoader));
      AppMethodBeat.o(121201);
    }
    
    public WxaWidgetContextImpl(WxaPkgWrappingInfo paramWxaPkgWrappingInfo1, WxaPkgWrappingInfo paramWxaPkgWrappingInfo2)
    {
      AppMethodBeat.i(121202);
      Assert.assertNotNull(paramWxaPkgWrappingInfo1);
      Assert.assertNotNull(paramWxaPkgWrappingInfo2);
      this.kiL = paramWxaPkgWrappingInfo1;
      this.kiK = paramWxaPkgWrappingInfo2;
      AppMethodBeat.o(121202);
    }
    
    public final int aZQ()
    {
      if (this.kiK != null) {
        return this.kiK.jLV;
      }
      return 0;
    }
    
    public final DebuggerInfo bgA()
    {
      return this.kiO;
    }
    
    public final WidgetSysConfig bgB()
    {
      return this.kiP;
    }
    
    public final WidgetRuntimeConfig bgC()
    {
      return this.kiQ;
    }
    
    public final WxaPkgWrappingInfo bgv()
    {
      return this.kiK;
    }
    
    public final WxaPkgWrappingInfo bgw()
    {
      return this.kiL;
    }
    
    public final int bgx()
    {
      if (this.kiK != null) {
        return this.kiK.pkgVersion;
      }
      return 0;
    }
    
    public final byte[] bgy()
    {
      return this.kiM;
    }
    
    public final int bgz()
    {
      return this.kiN;
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
      return this.gcZ;
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      AppMethodBeat.i(121203);
      paramParcel.writeString(this.gcZ);
      paramParcel.writeString(this.mAppId);
      paramParcel.writeParcelable(this.kiL, paramInt);
      paramParcel.writeParcelable(this.kiK, paramInt);
      paramParcel.writeByteArray(this.kiM);
      paramParcel.writeInt(this.kiN);
      paramParcel.writeParcelable(this.kiO, paramInt);
      paramParcel.writeParcelable(this.kiP, paramInt);
      paramParcel.writeParcelable(this.kiQ, paramInt);
      AppMethodBeat.o(121203);
    }
  }
  
  public static abstract interface a
  {
    public abstract void a(String paramString1, String paramString2, boolean paramBoolean, WxaWidgetContext paramWxaWidgetContext);
    
    public abstract void cI(String paramString1, String paramString2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.dynamic.WxaWidgetInitializer
 * JD-Core Version:    0.7.0.1
 */