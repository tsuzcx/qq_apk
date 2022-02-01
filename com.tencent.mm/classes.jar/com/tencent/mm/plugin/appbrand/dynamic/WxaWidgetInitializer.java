package com.tencent.mm.plugin.appbrand.dynamic;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cd.b;
import com.tencent.mm.f.b.a.jw;
import com.tencent.mm.f.b.a.ql;
import com.tencent.mm.ipcinvoker.wx_extension.service.MainProcessIPCService;
import com.tencent.mm.modelappbrand.u;
import com.tencent.mm.modelappbrand.v;
import com.tencent.mm.plugin.appbrand.appcache.WxaCommLibRuntimeReader;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkgWrappingInfo;
import com.tencent.mm.plugin.appbrand.appstorage.ICommLibReader;
import com.tencent.mm.plugin.appbrand.dynamic.debugger.DebuggerInfo;
import com.tencent.mm.plugin.appbrand.dynamic.j.a;
import com.tencent.mm.plugin.appbrand.dynamic.j.a.2;
import com.tencent.mm.plugin.appbrand.dynamic.j.a.d;
import com.tencent.mm.plugin.appbrand.dynamic.j.a.e;
import com.tencent.mm.plugin.appbrand.dynamic.j.d;
import com.tencent.mm.plugin.appbrand.dynamic.launching.WidgetRuntimeConfig;
import com.tencent.mm.plugin.appbrand.dynamic.launching.WidgetSysConfig;
import com.tencent.mm.protocal.protobuf.fmh;
import com.tencent.mm.protocal.protobuf.fmj;
import com.tencent.mm.protocal.protobuf.yw;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import com.tencent.mm.sdk.platformtools.Util;
import junit.framework.Assert;

public final class WxaWidgetInitializer
{
  static WxaWidgetContextImpl a(String paramString1, String paramString2, WxaPkgWrappingInfo paramWxaPkgWrappingInfo, d paramd)
  {
    AppMethodBeat.i(121205);
    Log.i("MicroMsg.WxaWidgetInitializer", "prepare(%s)", new Object[] { paramString1 });
    u.i("MicroMsg.WxaWidgetInitializer", "prepare(%s)", new Object[] { paramString1 });
    WxaPkgWrappingInfo localWxaPkgWrappingInfo = (WxaPkgWrappingInfo)WxaCommLibRuntimeReader.bHe().bGj();
    if (localWxaPkgWrappingInfo == null)
    {
      Log.e("MicroMsg.WxaWidgetInitializer", "getLibPkgInfo return null.");
      AppMethodBeat.o(121205);
      return null;
    }
    paramWxaPkgWrappingInfo = new WxaWidgetContextImpl(localWxaPkgWrappingInfo, paramWxaPkgWrappingInfo);
    paramWxaPkgWrappingInfo.jsP = paramString1;
    paramWxaPkgWrappingInfo.mAppId = paramString2;
    paramWxaPkgWrappingInfo.ohi = paramd.okc;
    if (paramWxaPkgWrappingInfo.ohi == null) {
      paramWxaPkgWrappingInfo.ohi = new DebuggerInfo();
    }
    paramWxaPkgWrappingInfo.ohj = paramd.okd;
    paramWxaPkgWrappingInfo.ohk = paramd.oke;
    for (;;)
    {
      try
      {
        if ((paramd.okg == null) || (paramd.okg.SkZ == null)) {
          continue;
        }
        paramString2 = paramd.okg.SkZ.toByteArray();
        paramWxaPkgWrappingInfo.ohg = paramString2;
      }
      catch (Exception paramString2)
      {
        Log.e("MicroMsg.WxaWidgetInitializer", Util.stackTraceToString(paramString2));
        continue;
      }
      if (!paramWxaPkgWrappingInfo.ohi.ohP) {
        break label227;
      }
      paramWxaPkgWrappingInfo.ohh = 2;
      f.bNf().ca(paramString1, 2101);
      j.bNj().P(paramString1, 626, 5);
      AppMethodBeat.o(121205);
      return paramWxaPkgWrappingInfo;
      paramString2 = new byte[0];
    }
    label227:
    if (paramd.okf != null) {}
    for (int i = paramd.okf.SZN;; i = 1)
    {
      paramWxaPkgWrappingInfo.ohh = i;
      break;
    }
  }
  
  public static String dj(String paramString1, String paramString2)
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
    String jsP;
    String mAppId;
    WxaPkgWrappingInfo ohe;
    WxaPkgWrappingInfo ohf;
    byte[] ohg;
    int ohh;
    DebuggerInfo ohi;
    WidgetSysConfig ohj;
    WidgetRuntimeConfig ohk;
    
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
      this.jsP = paramParcel.readString();
      this.mAppId = paramParcel.readString();
      this.ohf = ((WxaPkgWrappingInfo)paramParcel.readParcelable(localClassLoader));
      this.ohe = ((WxaPkgWrappingInfo)paramParcel.readParcelable(localClassLoader));
      this.ohg = paramParcel.createByteArray();
      this.ohh = paramParcel.readInt();
      this.ohi = ((DebuggerInfo)paramParcel.readParcelable(localClassLoader));
      this.ohj = ((WidgetSysConfig)paramParcel.readParcelable(localClassLoader));
      this.ohk = ((WidgetRuntimeConfig)paramParcel.readParcelable(localClassLoader));
      AppMethodBeat.o(121201);
    }
    
    public WxaWidgetContextImpl(WxaPkgWrappingInfo paramWxaPkgWrappingInfo1, WxaPkgWrappingInfo paramWxaPkgWrappingInfo2)
    {
      AppMethodBeat.i(121202);
      Assert.assertNotNull(paramWxaPkgWrappingInfo1);
      Assert.assertNotNull(paramWxaPkgWrappingInfo2);
      this.ohf = paramWxaPkgWrappingInfo1;
      this.ohe = paramWxaPkgWrappingInfo2;
      AppMethodBeat.o(121202);
    }
    
    public final int bGn()
    {
      if (this.ohe != null) {
        return this.ohe.nHY;
      }
      return 0;
    }
    
    public final WxaPkgWrappingInfo bNk()
    {
      return this.ohe;
    }
    
    public final WxaPkgWrappingInfo bNl()
    {
      return this.ohf;
    }
    
    public final int bNm()
    {
      if (this.ohe != null) {
        return this.ohe.pkgVersion;
      }
      return 0;
    }
    
    public final byte[] bNn()
    {
      return this.ohg;
    }
    
    public final int bNo()
    {
      return this.ohh;
    }
    
    public final DebuggerInfo bNp()
    {
      return this.ohi;
    }
    
    public final WidgetSysConfig bNq()
    {
      return this.ohj;
    }
    
    public final WidgetRuntimeConfig bNr()
    {
      return this.ohk;
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
      return this.jsP;
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      AppMethodBeat.i(121203);
      paramParcel.writeString(this.jsP);
      paramParcel.writeString(this.mAppId);
      paramParcel.writeParcelable(this.ohf, paramInt);
      paramParcel.writeParcelable(this.ohe, paramInt);
      paramParcel.writeByteArray(this.ohg);
      paramParcel.writeInt(this.ohh);
      paramParcel.writeParcelable(this.ohi, paramInt);
      paramParcel.writeParcelable(this.ohj, paramInt);
      paramParcel.writeParcelable(this.ohk, paramInt);
      AppMethodBeat.o(121203);
    }
  }
  
  public static abstract interface a
  {
    public abstract void a(String paramString1, String paramString2, boolean paramBoolean, WxaWidgetContext paramWxaWidgetContext);
    
    public abstract void dg(String paramString1, String paramString2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.dynamic.WxaWidgetInitializer
 * JD-Core Version:    0.7.0.1
 */