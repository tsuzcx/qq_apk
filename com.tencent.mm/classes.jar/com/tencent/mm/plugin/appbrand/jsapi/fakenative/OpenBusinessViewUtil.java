package com.tencent.mm.plugin.appbrand.jsapi.fakenative;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.c;
import com.tencent.mm.g.a.mh;
import com.tencent.mm.g.a.mi;
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
import com.tencent.mm.protocal.protobuf.btd;
import com.tencent.mm.protocal.protobuf.bte;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bt;

public final class OpenBusinessViewUtil
{
  public static void A(String paramString1, String paramString2, int paramInt)
  {
    AppMethodBeat.i(46308);
    ad.i("MicroMsg.OpenBusinessViewUtil", "navigateBackApplication, appId:%s, businessType:%s, errCode:%d", new Object[] { paramString1, paramString2, Integer.valueOf(paramInt) });
    AppBrandMainProcessService.a(new JsApiNavigateBackApplication.NavigateBackAppTask(paramString1, bt.bI(null, "{}"), paramString2, paramInt));
    AppMethodBeat.o(46308);
  }
  
  public static void B(String paramString1, String paramString2, int paramInt)
  {
    AppMethodBeat.i(46311);
    ad.i("MicroMsg.OpenBusinessViewUtil", "navigateBackH5, businessType:%s, errCode:%d", new Object[] { paramString1, Integer.valueOf(paramInt) });
    if (aj.cnC())
    {
      C(paramString1, paramString2, paramInt);
      AppMethodBeat.o(46311);
      return;
    }
    AppBrandMainProcessService.a(new NavigateBackH5Task(paramString1, paramString2, paramInt));
    AppMethodBeat.o(46311);
  }
  
  public static void C(String paramString1, String paramString2, int paramInt)
  {
    AppMethodBeat.i(46312);
    mh localmh = new mh();
    localmh.dzO.businessType = paramString1;
    localmh.dzO.errCode = paramInt;
    localmh.dzO.dzP = paramString2;
    a.IbL.l(localmh);
    AppMethodBeat.o(46312);
  }
  
  public static void a(int paramInt, String paramString1, String paramString2, String paramString3, String paramString4, a parama)
  {
    AppMethodBeat.i(46305);
    btd localbtd = new btd();
    localbtd.dnh = paramInt;
    localbtd.GNv = paramString1;
    localbtd.GNw = paramString3;
    localbtd.GNx = paramString4;
    localbtd.query = paramString2;
    paramString1 = new b.a();
    paramString1.funcId = 1268;
    paramString1.uri = "/cgi-bin/mmbiz-bin/wxabusiness/launchbizwxaapp";
    paramString1.hNM = localbtd;
    paramString1.hNN = new bte();
    IPCRunCgi.a(paramString1.aDC(), new IPCRunCgi.a()
    {
      public final void a(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, b paramAnonymousb)
      {
        AppMethodBeat.i(46299);
        if ((paramAnonymousInt1 == 0) && (paramAnonymousInt2 == 0) && (paramAnonymousb != null) && (paramAnonymousb.hNL.hNQ != null) && ((paramAnonymousb.hNL.hNQ instanceof bte)))
        {
          paramAnonymousString = (bte)paramAnonymousb.hNL.hNQ;
          ad.i("MicroMsg.OpenBusinessViewUtil", "transBusinessAppInfo, request success, appId:%s, path:%s", new Object[] { paramAnonymousString.duW, paramAnonymousString.GNy });
          if (this.kMp != null) {
            this.kMp.da(paramAnonymousString.duW, paramAnonymousString.GNy);
          }
          AppMethodBeat.o(46299);
          return;
        }
        ad.e("MicroMsg.OpenBusinessViewUtil", "transBusinessAppInfo, request fail");
        if (this.kMp != null) {
          this.kMp.ah(paramAnonymousInt2, paramAnonymousString);
        }
        AppMethodBeat.o(46299);
      }
    });
    AppMethodBeat.o(46305);
  }
  
  public static void q(String paramString1, int paramInt, String paramString2)
  {
    AppMethodBeat.i(46309);
    ad.i("MicroMsg.OpenBusinessViewUtil", "navigateBackMiniProgram, businessType:%s, errCode:%d", new Object[] { paramString1, Integer.valueOf(paramInt) });
    r(paramString1, paramInt, paramString2);
    AppMethodBeat.o(46309);
  }
  
  private static void r(String paramString1, int paramInt, String paramString2)
  {
    AppMethodBeat.i(46310);
    mi localmi = new mi();
    localmi.dzQ.errCode = paramInt;
    localmi.dzQ.businessType = paramString1;
    localmi.dzQ.dzP = paramString2;
    a.IbL.l(localmi);
    AppMethodBeat.o(46310);
  }
  
  public static void u(o paramo)
  {
    AppMethodBeat.i(174786);
    AppBrandLaunchReferrer localAppBrandLaunchReferrer = paramo.aXc().cmv;
    if ((localAppBrandLaunchReferrer != null) && (!bt.isNullOrNil(localAppBrandLaunchReferrer.businessType)))
    {
      paramo = paramo.mAppId;
      n.KF(paramo).jzd = localAppBrandLaunchReferrer.jXR;
      n.KF(paramo).jzc = localAppBrandLaunchReferrer.businessType;
      n.KF(paramo).jze = false;
      n.KF(paramo).jzg = false;
      n.KF(paramo).jzf = false;
      ad.i("MicroMsg.OpenBusinessViewUtil", "recordOpenBusinessViewInfo, app:%s, businessType:%s, launchScene:%s", new Object[] { paramo, localAppBrandLaunchReferrer.businessType, Integer.valueOf(localAppBrandLaunchReferrer.jXR) });
      AppMethodBeat.o(174786);
      return;
    }
    ad.i("MicroMsg.OpenBusinessViewUtil", "recordOpenBusinessViewInfo, referrer businessType is null");
    AppMethodBeat.o(174786);
  }
  
  public static void v(o paramo)
  {
    AppMethodBeat.i(174787);
    if (paramo == null)
    {
      AppMethodBeat.o(174787);
      return;
    }
    int i = n.KE(paramo.mAppId).jzd;
    String str = n.KE(paramo.mAppId).jzc;
    ad.i("MicroMsg.OpenBusinessViewUtil", "navigateBackCancelResultIfNeed, appId:%s, businessType:%s, launchScene:%s", new Object[] { paramo.mAppId, str, Integer.valueOf(i) });
    if (!bt.isNullOrNil(str))
    {
      if (i == 2)
      {
        if (!n.KE(paramo.mAppId).jze)
        {
          ad.i("MicroMsg.OpenBusinessViewUtil", "navigateBackCancelResultIfNeed, return cancel to H5, businessType:%s", new Object[] { str });
          B(str, null, -3);
        }
        AppMethodBeat.o(174787);
        return;
      }
      if (i == 4)
      {
        if (!n.KE(paramo.mAppId).jzg)
        {
          ad.i("MicroMsg.OpenBusinessViewUtil", "navigateBackCancelResultIfNeed, return cancel to Application, businessType:%s", new Object[] { str });
          if ((paramo.aXc().cmv != null) && (!bt.isNullOrNil(paramo.aXc().cmv.appId))) {
            A(paramo.aXc().cmv.appId, str, -2);
          }
        }
        AppMethodBeat.o(174787);
        return;
      }
      if ((i == 1) && (!n.KE(paramo.mAppId).jzf))
      {
        ad.i("MicroMsg.OpenBusinessViewUtil", "navigateBackCancelResultIfNeed, return cancel to MiniProgram, businessType:%s", new Object[] { str });
        q(str, g.kMl.errCode, null);
      }
    }
    AppMethodBeat.o(174787);
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
    
    public final void aOA()
    {
      AppMethodBeat.i(46301);
      OpenBusinessViewUtil.C(this.businessType, this.extra, this.errCode);
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
    public abstract void ah(int paramInt, String paramString);
    
    public abstract void da(String paramString1, String paramString2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.fakenative.OpenBusinessViewUtil
 * JD-Core Version:    0.7.0.1
 */