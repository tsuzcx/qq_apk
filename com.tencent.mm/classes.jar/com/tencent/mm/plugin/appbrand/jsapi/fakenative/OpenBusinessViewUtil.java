package com.tencent.mm.plugin.appbrand.jsapi.fakenative;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c;
import com.tencent.mm.am.c.a;
import com.tencent.mm.am.c.c;
import com.tencent.mm.autogen.a.oz;
import com.tencent.mm.autogen.a.pa;
import com.tencent.mm.ipcinvoker.wx_extension.IPCRunCgi;
import com.tencent.mm.ipcinvoker.wx_extension.IPCRunCgi.a;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfigWC;
import com.tencent.mm.plugin.appbrand.config.AppBrandLaunchReferrer;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.appbrand.jsapi.JsApiNavigateBackApplication.NavigateBackAppTask;
import com.tencent.mm.plugin.appbrand.u;
import com.tencent.mm.plugin.appbrand.w;
import com.tencent.mm.protocal.protobuf.dgq;
import com.tencent.mm.protocal.protobuf.dgr;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;

public final class OpenBusinessViewUtil
{
  public static void A(String paramString1, int paramInt, String paramString2)
  {
    AppMethodBeat.i(46309);
    Log.i("MicroMsg.OpenBusinessViewUtil", "navigateBackMiniProgram, businessType:%s, errCode:%d", new Object[] { paramString1, Integer.valueOf(paramInt) });
    B(paramString1, paramInt, paramString2);
    AppMethodBeat.o(46309);
  }
  
  private static void B(String paramString1, int paramInt, String paramString2)
  {
    AppMethodBeat.i(46310);
    pa localpa = new pa();
    localpa.hRS.errCode = paramInt;
    localpa.hRS.businessType = paramString1;
    localpa.hRS.hRR = paramString2;
    localpa.publish();
    AppMethodBeat.o(46310);
  }
  
  public static void I(String paramString1, String paramString2, int paramInt)
  {
    AppMethodBeat.i(46308);
    Log.i("MicroMsg.OpenBusinessViewUtil", "navigateBackApplication, appId:%s, businessType:%s, errCode:%d", new Object[] { paramString1, paramString2, Integer.valueOf(paramInt) });
    new JsApiNavigateBackApplication.NavigateBackAppTask(paramString1, Util.nullAs(null, "{}"), paramString2, paramInt).bQt();
    AppMethodBeat.o(46308);
  }
  
  public static void J(String paramString1, String paramString2, int paramInt)
  {
    AppMethodBeat.i(46311);
    Log.i("MicroMsg.OpenBusinessViewUtil", "navigateBackH5, businessType:%s, errCode:%d", new Object[] { paramString1, Integer.valueOf(paramInt) });
    if (MMApplicationContext.isMMProcess())
    {
      K(paramString1, paramString2, paramInt);
      AppMethodBeat.o(46311);
      return;
    }
    new NavigateBackH5Task(paramString1, paramString2, paramInt).bQt();
    AppMethodBeat.o(46311);
  }
  
  public static void K(w paramw)
  {
    AppMethodBeat.i(174786);
    AppBrandLaunchReferrer localAppBrandLaunchReferrer = paramw.getInitConfig().eoV;
    if ((localAppBrandLaunchReferrer != null) && (!Util.isNullOrNil(localAppBrandLaunchReferrer.businessType)))
    {
      paramw = paramw.mAppId;
      u.Uy(paramw).qvh = localAppBrandLaunchReferrer.qYE;
      u.Uy(paramw).qvg = localAppBrandLaunchReferrer.businessType;
      u.Uy(paramw).qvi = false;
      u.Uy(paramw).qvk = false;
      u.Uy(paramw).qvj = false;
      Log.i("MicroMsg.OpenBusinessViewUtil", "recordOpenBusinessViewInfo, app:%s, businessType:%s, launchScene:%s", new Object[] { paramw, localAppBrandLaunchReferrer.businessType, Integer.valueOf(localAppBrandLaunchReferrer.qYE) });
      AppMethodBeat.o(174786);
      return;
    }
    Log.i("MicroMsg.OpenBusinessViewUtil", "recordOpenBusinessViewInfo, referrer businessType is null");
    AppMethodBeat.o(174786);
  }
  
  public static void K(String paramString1, String paramString2, int paramInt)
  {
    AppMethodBeat.i(46312);
    oz localoz = new oz();
    localoz.hRQ.businessType = paramString1;
    localoz.hRQ.errCode = paramInt;
    localoz.hRQ.hRR = paramString2;
    localoz.publish();
    AppMethodBeat.o(46312);
  }
  
  public static void L(w paramw)
  {
    AppMethodBeat.i(174787);
    if (paramw == null)
    {
      AppMethodBeat.o(174787);
      return;
    }
    int i = u.Ux(paramw.mAppId).qvh;
    String str = u.Ux(paramw.mAppId).qvg;
    Log.i("MicroMsg.OpenBusinessViewUtil", "navigateBackCancelResultIfNeed, appId:%s, businessType:%s, launchScene:%s", new Object[] { paramw.mAppId, str, Integer.valueOf(i) });
    if (!Util.isNullOrNil(str))
    {
      if (i == 2)
      {
        if (!u.Ux(paramw.mAppId).qvi)
        {
          Log.i("MicroMsg.OpenBusinessViewUtil", "navigateBackCancelResultIfNeed, return cancel to H5, businessType:%s", new Object[] { str });
          J(str, null, -3);
        }
        AppMethodBeat.o(174787);
        return;
      }
      if (i == 4)
      {
        if (!u.Ux(paramw.mAppId).qvk)
        {
          Log.i("MicroMsg.OpenBusinessViewUtil", "navigateBackCancelResultIfNeed, return cancel to Application, businessType:%s", new Object[] { str });
          if ((paramw.getInitConfig().eoV != null) && (!Util.isNullOrNil(paramw.getInitConfig().eoV.appId))) {
            I(paramw.getInitConfig().eoV.appId, str, -2);
          }
        }
        AppMethodBeat.o(174787);
        return;
      }
      if ((i == 1) && (!u.Ux(paramw.mAppId).qvj))
      {
        Log.i("MicroMsg.OpenBusinessViewUtil", "navigateBackCancelResultIfNeed, return cancel to MiniProgram, businessType:%s", new Object[] { str });
        A(str, f.rWT.errCode, null);
      }
    }
    AppMethodBeat.o(174787);
  }
  
  public static void a(int paramInt, String paramString1, String paramString2, String paramString3, String paramString4, a parama)
  {
    AppMethodBeat.i(46305);
    dgq localdgq = new dgq();
    localdgq.source = paramInt;
    localdgq.aaLH = paramString1;
    localdgq.aaLI = paramString3;
    localdgq.aaLJ = paramString4;
    localdgq.query = paramString2;
    paramString1 = new c.a();
    paramString1.funcId = 1268;
    paramString1.uri = "/cgi-bin/mmbiz-bin/wxabusiness/launchbizwxaapp";
    paramString1.otE = localdgq;
    paramString1.otF = new dgr();
    IPCRunCgi.a(paramString1.bEF(), new IPCRunCgi.a()
    {
      public final void callback(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, c paramAnonymousc)
      {
        AppMethodBeat.i(46299);
        if ((paramAnonymousInt1 == 0) && (paramAnonymousInt2 == 0) && (paramAnonymousc != null) && (c.c.b(paramAnonymousc.otC) != null) && ((c.c.b(paramAnonymousc.otC) instanceof dgr)))
        {
          paramAnonymousString = (dgr)c.c.b(paramAnonymousc.otC);
          Log.i("MicroMsg.OpenBusinessViewUtil", "transBusinessAppInfo, request success, appId:%s, path:%s", new Object[] { paramAnonymousString.appid, paramAnonymousString.aaLK });
          if (OpenBusinessViewUtil.this != null) {
            OpenBusinessViewUtil.this.br(paramAnonymousString.appid, paramAnonymousString.aaLK);
          }
          AppMethodBeat.o(46299);
          return;
        }
        Log.e("MicroMsg.OpenBusinessViewUtil", "transBusinessAppInfo, request fail");
        if (OpenBusinessViewUtil.this != null) {
          OpenBusinessViewUtil.this.aw(paramAnonymousInt2, paramAnonymousString);
        }
        AppMethodBeat.o(46299);
      }
    });
    AppMethodBeat.o(46305);
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
    
    public final void asn()
    {
      AppMethodBeat.i(46301);
      OpenBusinessViewUtil.K(this.businessType, this.extra, this.errCode);
      AppMethodBeat.o(46301);
    }
    
    public final void h(Parcel paramParcel)
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
  
  public static abstract interface a
  {
    public abstract void aw(int paramInt, String paramString);
    
    public abstract void br(String paramString1, String paramString2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.fakenative.OpenBusinessViewUtil
 * JD-Core Version:    0.7.0.1
 */