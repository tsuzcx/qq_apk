package com.tencent.mm.plugin.appbrand.jsapi.fakenative;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.g.a.mi;
import com.tencent.mm.g.a.mj;
import com.tencent.mm.ipcinvoker.wx_extension.IPCRunCgi;
import com.tencent.mm.ipcinvoker.wx_extension.IPCRunCgi.a;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfigWC;
import com.tencent.mm.plugin.appbrand.config.AppBrandLaunchReferrer;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.appbrand.jsapi.JsApiNavigateBackApplication.NavigateBackAppTask;
import com.tencent.mm.plugin.appbrand.o;
import com.tencent.mm.plugin.appbrand.p;
import com.tencent.mm.protocal.protobuf.btx;
import com.tencent.mm.protocal.protobuf.bty;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bu;

public final class OpenBusinessViewUtil
{
  public static void A(String paramString1, String paramString2, int paramInt)
  {
    AppMethodBeat.i(46308);
    ae.i("MicroMsg.OpenBusinessViewUtil", "navigateBackApplication, appId:%s, businessType:%s, errCode:%d", new Object[] { paramString1, paramString2, Integer.valueOf(paramInt) });
    AppBrandMainProcessService.a(new JsApiNavigateBackApplication.NavigateBackAppTask(paramString1, bu.bI(null, "{}"), paramString2, paramInt));
    AppMethodBeat.o(46308);
  }
  
  public static void B(String paramString1, String paramString2, int paramInt)
  {
    AppMethodBeat.i(46311);
    ae.i("MicroMsg.OpenBusinessViewUtil", "navigateBackH5, businessType:%s, errCode:%d", new Object[] { paramString1, Integer.valueOf(paramInt) });
    if (ak.cpe())
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
    mi localmi = new mi();
    localmi.dAT.businessType = paramString1;
    localmi.dAT.errCode = paramInt;
    localmi.dAT.dAU = paramString2;
    a.IvT.l(localmi);
    AppMethodBeat.o(46312);
  }
  
  public static void a(int paramInt, String paramString1, String paramString2, String paramString3, String paramString4, a parama)
  {
    AppMethodBeat.i(46305);
    btx localbtx = new btx();
    localbtx.doj = paramInt;
    localbtx.HgV = paramString1;
    localbtx.HgW = paramString3;
    localbtx.HgX = paramString4;
    localbtx.query = paramString2;
    paramString1 = new b.a();
    paramString1.funcId = 1268;
    paramString1.uri = "/cgi-bin/mmbiz-bin/wxabusiness/launchbizwxaapp";
    paramString1.hQF = localbtx;
    paramString1.hQG = new bty();
    IPCRunCgi.a(paramString1.aDS(), new IPCRunCgi.a()
    {
      public final void a(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, b paramAnonymousb)
      {
        AppMethodBeat.i(46299);
        if ((paramAnonymousInt1 == 0) && (paramAnonymousInt2 == 0) && (paramAnonymousb != null) && (paramAnonymousb.hQE.hQJ != null) && ((paramAnonymousb.hQE.hQJ instanceof bty)))
        {
          paramAnonymousString = (bty)paramAnonymousb.hQE.hQJ;
          ae.i("MicroMsg.OpenBusinessViewUtil", "transBusinessAppInfo, request success, appId:%s, path:%s", new Object[] { paramAnonymousString.dwb, paramAnonymousString.HgY });
          if (this.kPF != null) {
            this.kPF.dc(paramAnonymousString.dwb, paramAnonymousString.HgY);
          }
          AppMethodBeat.o(46299);
          return;
        }
        ae.e("MicroMsg.OpenBusinessViewUtil", "transBusinessAppInfo, request fail");
        if (this.kPF != null) {
          this.kPF.ah(paramAnonymousInt2, paramAnonymousString);
        }
        AppMethodBeat.o(46299);
      }
    });
    AppMethodBeat.o(46305);
  }
  
  public static void s(String paramString1, int paramInt, String paramString2)
  {
    AppMethodBeat.i(46309);
    ae.i("MicroMsg.OpenBusinessViewUtil", "navigateBackMiniProgram, businessType:%s, errCode:%d", new Object[] { paramString1, Integer.valueOf(paramInt) });
    t(paramString1, paramInt, paramString2);
    AppMethodBeat.o(46309);
  }
  
  private static void t(String paramString1, int paramInt, String paramString2)
  {
    AppMethodBeat.i(46310);
    mj localmj = new mj();
    localmj.dAV.errCode = paramInt;
    localmj.dAV.businessType = paramString1;
    localmj.dAV.dAU = paramString2;
    a.IvT.l(localmj);
    AppMethodBeat.o(46310);
  }
  
  public static void v(p paramp)
  {
    AppMethodBeat.i(174786);
    AppBrandLaunchReferrer localAppBrandLaunchReferrer = paramp.aXx().cmx;
    if ((localAppBrandLaunchReferrer != null) && (!bu.isNullOrNil(localAppBrandLaunchReferrer.businessType)))
    {
      paramp = paramp.mAppId;
      o.Le(paramp).jCd = localAppBrandLaunchReferrer.kbg;
      o.Le(paramp).jCc = localAppBrandLaunchReferrer.businessType;
      o.Le(paramp).jCe = false;
      o.Le(paramp).jCg = false;
      o.Le(paramp).jCf = false;
      ae.i("MicroMsg.OpenBusinessViewUtil", "recordOpenBusinessViewInfo, app:%s, businessType:%s, launchScene:%s", new Object[] { paramp, localAppBrandLaunchReferrer.businessType, Integer.valueOf(localAppBrandLaunchReferrer.kbg) });
      AppMethodBeat.o(174786);
      return;
    }
    ae.i("MicroMsg.OpenBusinessViewUtil", "recordOpenBusinessViewInfo, referrer businessType is null");
    AppMethodBeat.o(174786);
  }
  
  public static void w(p paramp)
  {
    AppMethodBeat.i(174787);
    if (paramp == null)
    {
      AppMethodBeat.o(174787);
      return;
    }
    int i = o.Ld(paramp.mAppId).jCd;
    String str = o.Ld(paramp.mAppId).jCc;
    ae.i("MicroMsg.OpenBusinessViewUtil", "navigateBackCancelResultIfNeed, appId:%s, businessType:%s, launchScene:%s", new Object[] { paramp.mAppId, str, Integer.valueOf(i) });
    if (!bu.isNullOrNil(str))
    {
      if (i == 2)
      {
        if (!o.Ld(paramp.mAppId).jCe)
        {
          ae.i("MicroMsg.OpenBusinessViewUtil", "navigateBackCancelResultIfNeed, return cancel to H5, businessType:%s", new Object[] { str });
          B(str, null, -3);
        }
        AppMethodBeat.o(174787);
        return;
      }
      if (i == 4)
      {
        if (!o.Ld(paramp.mAppId).jCg)
        {
          ae.i("MicroMsg.OpenBusinessViewUtil", "navigateBackCancelResultIfNeed, return cancel to Application, businessType:%s", new Object[] { str });
          if ((paramp.aXx().cmx != null) && (!bu.isNullOrNil(paramp.aXx().cmx.appId))) {
            A(paramp.aXx().cmx.appId, str, -2);
          }
        }
        AppMethodBeat.o(174787);
        return;
      }
      if ((i == 1) && (!o.Ld(paramp.mAppId).jCf))
      {
        ae.i("MicroMsg.OpenBusinessViewUtil", "navigateBackCancelResultIfNeed, return cancel to MiniProgram, businessType:%s", new Object[] { str });
        s(str, f.kPB.errCode, null);
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
    
    public final void aOX()
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
    
    public abstract void dc(String paramString1, String paramString2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.fakenative.OpenBusinessViewUtil
 * JD-Core Version:    0.7.0.1
 */