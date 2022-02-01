package com.tencent.mm.plugin.appbrand.jsapi.fakenative;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.c;
import com.tencent.mm.g.a.lp;
import com.tencent.mm.g.a.lq;
import com.tencent.mm.ipcinvoker.wx_extension.IPCRunCgi;
import com.tencent.mm.ipcinvoker.wx_extension.IPCRunCgi.a;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfigWC;
import com.tencent.mm.plugin.appbrand.config.AppBrandLaunchReferrer;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.appbrand.jsapi.JsApiNavigateBackApplication.NavigateBackAppTask;
import com.tencent.mm.plugin.appbrand.n;
import com.tencent.mm.plugin.appbrand.o;
import com.tencent.mm.protocal.protobuf.bku;
import com.tencent.mm.protocal.protobuf.bkv;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bt;

public final class OpenBusinessViewUtil
{
  public static void A(String paramString1, String paramString2, int paramInt)
  {
    AppMethodBeat.i(46312);
    lp locallp = new lp();
    locallp.dqp.businessType = paramString1;
    locallp.dqp.errCode = paramInt;
    locallp.dqp.dqq = paramString2;
    a.ESL.l(locallp);
    AppMethodBeat.o(46312);
  }
  
  public static void D(o paramo)
  {
    AppMethodBeat.i(174786);
    AppBrandLaunchReferrer localAppBrandLaunchReferrer = paramo.aNc().cfi;
    if ((localAppBrandLaunchReferrer != null) && (!bt.isNullOrNil(localAppBrandLaunchReferrer.businessType)))
    {
      paramo = paramo.mAppId;
      n.Dp(paramo).iFV = localAppBrandLaunchReferrer.jdC;
      n.Dp(paramo).iFU = localAppBrandLaunchReferrer.businessType;
      n.Dp(paramo).iFW = false;
      n.Dp(paramo).iFY = false;
      n.Dp(paramo).iFX = false;
      ad.i("MicroMsg.OpenBusinessViewUtil", "recordOpenBusinessViewInfo, app:%s, businessType:%s, launchScene:%s", new Object[] { paramo, localAppBrandLaunchReferrer.businessType, Integer.valueOf(localAppBrandLaunchReferrer.jdC) });
      AppMethodBeat.o(174786);
      return;
    }
    ad.i("MicroMsg.OpenBusinessViewUtil", "recordOpenBusinessViewInfo, referrer businessType is null");
    AppMethodBeat.o(174786);
  }
  
  public static void E(o paramo)
  {
    AppMethodBeat.i(174787);
    if (paramo == null)
    {
      AppMethodBeat.o(174787);
      return;
    }
    int i = n.Do(paramo.mAppId).iFV;
    String str = n.Do(paramo.mAppId).iFU;
    ad.i("MicroMsg.OpenBusinessViewUtil", "navigateBackCancelResultIfNeed, appId:%s, businessType:%s, launchScene:%s", new Object[] { paramo.mAppId, str, Integer.valueOf(i) });
    if (!bt.isNullOrNil(str))
    {
      if (i == 2)
      {
        if (!n.Do(paramo.mAppId).iFW)
        {
          ad.i("MicroMsg.OpenBusinessViewUtil", "navigateBackCancelResultIfNeed, return cancel to H5, businessType:%s", new Object[] { str });
          z(str, null, -3);
        }
        AppMethodBeat.o(174787);
        return;
      }
      if (i == 4)
      {
        if (!n.Do(paramo.mAppId).iFY)
        {
          ad.i("MicroMsg.OpenBusinessViewUtil", "navigateBackCancelResultIfNeed, return cancel to Application, businessType:%s", new Object[] { str });
          if ((paramo.aNc().cfi != null) && (!bt.isNullOrNil(paramo.aNc().cfi.appId))) {
            y(paramo.aNc().cfi.appId, str, -2);
          }
        }
        AppMethodBeat.o(174787);
        return;
      }
      if ((i == 1) && (!n.Do(paramo.mAppId).iFX))
      {
        ad.i("MicroMsg.OpenBusinessViewUtil", "navigateBackCancelResultIfNeed, return cancel to MiniProgram, businessType:%s", new Object[] { str });
        p(str, g.jQd.errCode, null);
      }
    }
    AppMethodBeat.o(174787);
  }
  
  public static void a(int paramInt, String paramString1, String paramString2, String paramString3, String paramString4, a parama)
  {
    AppMethodBeat.i(46305);
    bku localbku = new bku();
    localbku.dep = paramInt;
    localbku.DIw = paramString1;
    localbku.DIx = paramString3;
    localbku.DIy = paramString4;
    localbku.query = paramString2;
    paramString1 = new b.a();
    paramString1.funcId = 1268;
    paramString1.uri = "/cgi-bin/mmbiz-bin/wxabusiness/launchbizwxaapp";
    paramString1.gUU = localbku;
    paramString1.gUV = new bkv();
    IPCRunCgi.a(paramString1.atI(), new IPCRunCgi.a()
    {
      public final void a(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, b paramAnonymousb)
      {
        AppMethodBeat.i(46299);
        if ((paramAnonymousInt1 == 0) && (paramAnonymousInt2 == 0) && (paramAnonymousb != null) && (paramAnonymousb.gUT.gUX != null) && ((paramAnonymousb.gUT.gUX instanceof bkv)))
        {
          paramAnonymousString = (bkv)paramAnonymousb.gUT.gUX;
          ad.i("MicroMsg.OpenBusinessViewUtil", "transBusinessAppInfo, request success, appId:%s, path:%s", new Object[] { paramAnonymousString.dlB, paramAnonymousString.DIz });
          if (this.jQh != null) {
            this.jQh.cN(paramAnonymousString.dlB, paramAnonymousString.DIz);
          }
          AppMethodBeat.o(46299);
          return;
        }
        ad.e("MicroMsg.OpenBusinessViewUtil", "transBusinessAppInfo, request fail");
        if (this.jQh != null) {
          this.jQh.ae(paramAnonymousInt2, paramAnonymousString);
        }
        AppMethodBeat.o(46299);
      }
    });
    AppMethodBeat.o(46305);
  }
  
  public static void p(String paramString1, int paramInt, String paramString2)
  {
    AppMethodBeat.i(46309);
    ad.i("MicroMsg.OpenBusinessViewUtil", "navigateBackMiniProgram, businessType:%s, errCode:%d", new Object[] { paramString1, Integer.valueOf(paramInt) });
    q(paramString1, paramInt, paramString2);
    AppMethodBeat.o(46309);
  }
  
  private static void q(String paramString1, int paramInt, String paramString2)
  {
    AppMethodBeat.i(46310);
    lq locallq = new lq();
    locallq.dqr.errCode = paramInt;
    locallq.dqr.businessType = paramString1;
    locallq.dqr.dqq = paramString2;
    a.ESL.l(locallq);
    AppMethodBeat.o(46310);
  }
  
  public static void y(String paramString1, String paramString2, int paramInt)
  {
    AppMethodBeat.i(46308);
    ad.i("MicroMsg.OpenBusinessViewUtil", "navigateBackApplication, appId:%s, businessType:%s, errCode:%d", new Object[] { paramString1, paramString2, Integer.valueOf(paramInt) });
    AppBrandMainProcessService.a(new JsApiNavigateBackApplication.NavigateBackAppTask(paramString1, bt.by(null, "{}"), paramString2, paramInt));
    AppMethodBeat.o(46308);
  }
  
  public static void z(String paramString1, String paramString2, int paramInt)
  {
    AppMethodBeat.i(46311);
    ad.i("MicroMsg.OpenBusinessViewUtil", "navigateBackH5, businessType:%s, errCode:%d", new Object[] { paramString1, Integer.valueOf(paramInt) });
    if (aj.cbv())
    {
      A(paramString1, paramString2, paramInt);
      AppMethodBeat.o(46311);
      return;
    }
    AppBrandMainProcessService.a(new NavigateBackH5Task(paramString1, paramString2, paramInt));
    AppMethodBeat.o(46311);
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
    
    public final void aEz()
    {
      AppMethodBeat.i(46301);
      OpenBusinessViewUtil.A(this.businessType, this.extra, this.errCode);
      AppMethodBeat.o(46301);
    }
    
    public final void e(Parcel paramParcel)
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
    public abstract void ae(int paramInt, String paramString);
    
    public abstract void cN(String paramString1, String paramString2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.fakenative.OpenBusinessViewUtil
 * JD-Core Version:    0.7.0.1
 */