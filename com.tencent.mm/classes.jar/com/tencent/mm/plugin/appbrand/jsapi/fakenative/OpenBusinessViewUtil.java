package com.tencent.mm.plugin.appbrand.jsapi.fakenative;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.d.a;
import com.tencent.mm.f.a.nr;
import com.tencent.mm.f.a.ns;
import com.tencent.mm.ipcinvoker.wx_extension.IPCRunCgi;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfigWC;
import com.tencent.mm.plugin.appbrand.config.AppBrandLaunchReferrer;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.appbrand.jsapi.JsApiNavigateBackApplication.NavigateBackAppTask;
import com.tencent.mm.plugin.appbrand.s;
import com.tencent.mm.plugin.appbrand.t;
import com.tencent.mm.protocal.protobuf.cpw;
import com.tencent.mm.protocal.protobuf.cpx;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;

public final class OpenBusinessViewUtil
{
  public static void A(t paramt)
  {
    AppMethodBeat.i(174786);
    AppBrandLaunchReferrer localAppBrandLaunchReferrer = paramt.bDy().cwV;
    if ((localAppBrandLaunchReferrer != null) && (!Util.isNullOrNil(localAppBrandLaunchReferrer.businessType)))
    {
      paramt = paramt.mAppId;
      s.abW(paramt).nwk = localAppBrandLaunchReferrer.nYB;
      s.abW(paramt).nwj = localAppBrandLaunchReferrer.businessType;
      s.abW(paramt).nwl = false;
      s.abW(paramt).nwn = false;
      s.abW(paramt).nwm = false;
      Log.i("MicroMsg.OpenBusinessViewUtil", "recordOpenBusinessViewInfo, app:%s, businessType:%s, launchScene:%s", new Object[] { paramt, localAppBrandLaunchReferrer.businessType, Integer.valueOf(localAppBrandLaunchReferrer.nYB) });
      AppMethodBeat.o(174786);
      return;
    }
    Log.i("MicroMsg.OpenBusinessViewUtil", "recordOpenBusinessViewInfo, referrer businessType is null");
    AppMethodBeat.o(174786);
  }
  
  public static void B(t paramt)
  {
    AppMethodBeat.i(174787);
    if (paramt == null)
    {
      AppMethodBeat.o(174787);
      return;
    }
    int i = s.abV(paramt.mAppId).nwk;
    String str = s.abV(paramt.mAppId).nwj;
    Log.i("MicroMsg.OpenBusinessViewUtil", "navigateBackCancelResultIfNeed, appId:%s, businessType:%s, launchScene:%s", new Object[] { paramt.mAppId, str, Integer.valueOf(i) });
    if (!Util.isNullOrNil(str))
    {
      if (i == 2)
      {
        if (!s.abV(paramt.mAppId).nwl)
        {
          Log.i("MicroMsg.OpenBusinessViewUtil", "navigateBackCancelResultIfNeed, return cancel to H5, businessType:%s", new Object[] { str });
          E(str, null, -3);
        }
        AppMethodBeat.o(174787);
        return;
      }
      if (i == 4)
      {
        if (!s.abV(paramt.mAppId).nwn)
        {
          Log.i("MicroMsg.OpenBusinessViewUtil", "navigateBackCancelResultIfNeed, return cancel to Application, businessType:%s", new Object[] { str });
          if ((paramt.bDy().cwV != null) && (!Util.isNullOrNil(paramt.bDy().cwV.appId))) {
            D(paramt.bDy().cwV.appId, str, -2);
          }
        }
        AppMethodBeat.o(174787);
        return;
      }
      if ((i == 1) && (!s.abV(paramt.mAppId).nwm))
      {
        Log.i("MicroMsg.OpenBusinessViewUtil", "navigateBackCancelResultIfNeed, return cancel to MiniProgram, businessType:%s", new Object[] { str });
        y(str, f.oRt.errCode, null);
      }
    }
    AppMethodBeat.o(174787);
  }
  
  public static void D(String paramString1, String paramString2, int paramInt)
  {
    AppMethodBeat.i(46308);
    Log.i("MicroMsg.OpenBusinessViewUtil", "navigateBackApplication, appId:%s, businessType:%s, errCode:%d", new Object[] { paramString1, paramString2, Integer.valueOf(paramInt) });
    new JsApiNavigateBackApplication.NavigateBackAppTask(paramString1, Util.nullAs(null, "{}"), paramString2, paramInt).bsM();
    AppMethodBeat.o(46308);
  }
  
  public static void E(String paramString1, String paramString2, int paramInt)
  {
    AppMethodBeat.i(46311);
    Log.i("MicroMsg.OpenBusinessViewUtil", "navigateBackH5, businessType:%s, errCode:%d", new Object[] { paramString1, Integer.valueOf(paramInt) });
    if (MMApplicationContext.isMMProcess())
    {
      F(paramString1, paramString2, paramInt);
      AppMethodBeat.o(46311);
      return;
    }
    new NavigateBackH5Task(paramString1, paramString2, paramInt).bsM();
    AppMethodBeat.o(46311);
  }
  
  public static void F(String paramString1, String paramString2, int paramInt)
  {
    AppMethodBeat.i(46312);
    nr localnr = new nr();
    localnr.fMg.businessType = paramString1;
    localnr.fMg.errCode = paramInt;
    localnr.fMg.fMh = paramString2;
    EventCenter.instance.publish(localnr);
    AppMethodBeat.o(46312);
  }
  
  public static void a(int paramInt, String paramString1, String paramString2, String paramString3, String paramString4, OpenBusinessViewUtil.a parama)
  {
    AppMethodBeat.i(46305);
    cpw localcpw = new cpw();
    localcpw.source = paramInt;
    localcpw.Txc = paramString1;
    localcpw.Txd = paramString3;
    localcpw.Txe = paramString4;
    localcpw.query = paramString2;
    paramString1 = new d.a();
    paramString1.funcId = 1268;
    paramString1.uri = "/cgi-bin/mmbiz-bin/wxabusiness/launchbizwxaapp";
    paramString1.lBU = localcpw;
    paramString1.lBV = new cpx();
    IPCRunCgi.a(paramString1.bgN(), new OpenBusinessViewUtil.1(parama));
    AppMethodBeat.o(46305);
  }
  
  public static void y(String paramString1, int paramInt, String paramString2)
  {
    AppMethodBeat.i(46309);
    Log.i("MicroMsg.OpenBusinessViewUtil", "navigateBackMiniProgram, businessType:%s, errCode:%d", new Object[] { paramString1, Integer.valueOf(paramInt) });
    z(paramString1, paramInt, paramString2);
    AppMethodBeat.o(46309);
  }
  
  private static void z(String paramString1, int paramInt, String paramString2)
  {
    AppMethodBeat.i(46310);
    ns localns = new ns();
    localns.fMi.errCode = paramInt;
    localns.fMi.businessType = paramString1;
    localns.fMi.fMh = paramString2;
    EventCenter.instance.publish(localns);
    AppMethodBeat.o(46310);
  }
  
  public static final class NavigateBackH5Task
    extends MainProcessTask
  {
    public static final Parcelable.Creator<NavigateBackH5Task> CREATOR;
    public String businessType;
    public int errCode;
    public String extra;
    
    static
    {
      AppMethodBeat.i(46304);
      CREATOR = new Parcelable.Creator() {};
      AppMethodBeat.o(46304);
    }
    
    public NavigateBackH5Task() {}
    
    public NavigateBackH5Task(String paramString1, String paramString2, int paramInt)
    {
      this.businessType = paramString1;
      this.extra = paramString2;
      this.errCode = paramInt;
    }
    
    public final void RW()
    {
      AppMethodBeat.i(46301);
      OpenBusinessViewUtil.F(this.businessType, this.extra, this.errCode);
      AppMethodBeat.o(46301);
    }
    
    public final void f(Parcel paramParcel)
    {
      AppMethodBeat.i(46303);
      this.businessType = paramParcel.readString();
      this.extra = paramParcel.readString();
      this.errCode = paramParcel.readInt();
      AppMethodBeat.o(46303);
    }
    
    public final void writeToParcel(Parcel paramParcel, int paramInt)
    {
      AppMethodBeat.i(46302);
      paramParcel.writeString(this.businessType);
      paramParcel.writeString(this.extra);
      paramParcel.writeInt(this.errCode);
      AppMethodBeat.o(46302);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.fakenative.OpenBusinessViewUtil
 * JD-Core Version:    0.7.0.1
 */