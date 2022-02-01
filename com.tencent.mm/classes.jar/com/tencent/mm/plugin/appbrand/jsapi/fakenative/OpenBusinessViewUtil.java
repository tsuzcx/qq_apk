package com.tencent.mm.plugin.appbrand.jsapi.fakenative;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.ak.d.c;
import com.tencent.mm.g.a.mz;
import com.tencent.mm.g.a.na;
import com.tencent.mm.ipcinvoker.wx_extension.IPCRunCgi;
import com.tencent.mm.ipcinvoker.wx_extension.IPCRunCgi.a;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfigWC;
import com.tencent.mm.plugin.appbrand.config.AppBrandLaunchReferrer;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.appbrand.jsapi.JsApiNavigateBackApplication.NavigateBackAppTask;
import com.tencent.mm.plugin.appbrand.p;
import com.tencent.mm.plugin.appbrand.q;
import com.tencent.mm.protocal.protobuf.cha;
import com.tencent.mm.protocal.protobuf.chb;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;

public final class OpenBusinessViewUtil
{
  public static void A(q paramq)
  {
    AppMethodBeat.i(174787);
    if (paramq == null)
    {
      AppMethodBeat.o(174787);
      return;
    }
    int i = p.Um(paramq.mAppId).kCZ;
    String str = p.Um(paramq.mAppId).kCY;
    Log.i("MicroMsg.OpenBusinessViewUtil", "navigateBackCancelResultIfNeed, appId:%s, businessType:%s, launchScene:%s", new Object[] { paramq.mAppId, str, Integer.valueOf(i) });
    if (!Util.isNullOrNil(str))
    {
      if (i == 2)
      {
        if (!p.Um(paramq.mAppId).kDa)
        {
          Log.i("MicroMsg.OpenBusinessViewUtil", "navigateBackCancelResultIfNeed, return cancel to H5, businessType:%s", new Object[] { str });
          B(str, null, -3);
        }
        AppMethodBeat.o(174787);
        return;
      }
      if (i == 4)
      {
        if (!p.Um(paramq.mAppId).kDc)
        {
          Log.i("MicroMsg.OpenBusinessViewUtil", "navigateBackCancelResultIfNeed, return cancel to Application, businessType:%s", new Object[] { str });
          if ((paramq.bsC().cys != null) && (!Util.isNullOrNil(paramq.bsC().cys.appId))) {
            A(paramq.bsC().cys.appId, str, -2);
          }
        }
        AppMethodBeat.o(174787);
        return;
      }
      if ((i == 1) && (!p.Um(paramq.mAppId).kDb))
      {
        Log.i("MicroMsg.OpenBusinessViewUtil", "navigateBackCancelResultIfNeed, return cancel to MiniProgram, businessType:%s", new Object[] { str });
        x(str, f.lUz.errCode, null);
      }
    }
    AppMethodBeat.o(174787);
  }
  
  public static void A(String paramString1, String paramString2, int paramInt)
  {
    AppMethodBeat.i(46308);
    Log.i("MicroMsg.OpenBusinessViewUtil", "navigateBackApplication, appId:%s, businessType:%s, errCode:%d", new Object[] { paramString1, paramString2, Integer.valueOf(paramInt) });
    AppBrandMainProcessService.a(new JsApiNavigateBackApplication.NavigateBackAppTask(paramString1, Util.nullAs(null, "{}"), paramString2, paramInt));
    AppMethodBeat.o(46308);
  }
  
  public static void B(String paramString1, String paramString2, int paramInt)
  {
    AppMethodBeat.i(46311);
    Log.i("MicroMsg.OpenBusinessViewUtil", "navigateBackH5, businessType:%s, errCode:%d", new Object[] { paramString1, Integer.valueOf(paramInt) });
    if (MMApplicationContext.isMMProcess())
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
    mz localmz = new mz();
    localmz.dSI.businessType = paramString1;
    localmz.dSI.errCode = paramInt;
    localmz.dSI.dSJ = paramString2;
    EventCenter.instance.publish(localmz);
    AppMethodBeat.o(46312);
  }
  
  public static void a(int paramInt, String paramString1, String paramString2, String paramString3, String paramString4, a parama)
  {
    AppMethodBeat.i(46305);
    cha localcha = new cha();
    localcha.source = paramInt;
    localcha.Mmi = paramString1;
    localcha.Mmj = paramString3;
    localcha.Mmk = paramString4;
    localcha.query = paramString2;
    paramString1 = new d.a();
    paramString1.funcId = 1268;
    paramString1.uri = "/cgi-bin/mmbiz-bin/wxabusiness/launchbizwxaapp";
    paramString1.iLN = localcha;
    paramString1.iLO = new chb();
    IPCRunCgi.a(paramString1.aXF(), new IPCRunCgi.a()
    {
      public final void a(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, d paramAnonymousd)
      {
        AppMethodBeat.i(46299);
        if ((paramAnonymousInt1 == 0) && (paramAnonymousInt2 == 0) && (paramAnonymousd != null) && (paramAnonymousd.iLL.iLR != null) && ((paramAnonymousd.iLL.iLR instanceof chb)))
        {
          paramAnonymousString = (chb)paramAnonymousd.iLL.iLR;
          Log.i("MicroMsg.OpenBusinessViewUtil", "transBusinessAppInfo, request success, appId:%s, path:%s", new Object[] { paramAnonymousString.dNI, paramAnonymousString.Mml });
          if (this.lUD != null) {
            this.lUD.ds(paramAnonymousString.dNI, paramAnonymousString.Mml);
          }
          AppMethodBeat.o(46299);
          return;
        }
        Log.e("MicroMsg.OpenBusinessViewUtil", "transBusinessAppInfo, request fail");
        if (this.lUD != null) {
          this.lUD.ak(paramAnonymousInt2, paramAnonymousString);
        }
        AppMethodBeat.o(46299);
      }
    });
    AppMethodBeat.o(46305);
  }
  
  public static void x(String paramString1, int paramInt, String paramString2)
  {
    AppMethodBeat.i(46309);
    Log.i("MicroMsg.OpenBusinessViewUtil", "navigateBackMiniProgram, businessType:%s, errCode:%d", new Object[] { paramString1, Integer.valueOf(paramInt) });
    y(paramString1, paramInt, paramString2);
    AppMethodBeat.o(46309);
  }
  
  private static void y(String paramString1, int paramInt, String paramString2)
  {
    AppMethodBeat.i(46310);
    na localna = new na();
    localna.dSK.errCode = paramInt;
    localna.dSK.businessType = paramString1;
    localna.dSK.dSJ = paramString2;
    EventCenter.instance.publish(localna);
    AppMethodBeat.o(46310);
  }
  
  public static void z(q paramq)
  {
    AppMethodBeat.i(174786);
    AppBrandLaunchReferrer localAppBrandLaunchReferrer = paramq.bsC().cys;
    if ((localAppBrandLaunchReferrer != null) && (!Util.isNullOrNil(localAppBrandLaunchReferrer.businessType)))
    {
      paramq = paramq.mAppId;
      p.Un(paramq).kCZ = localAppBrandLaunchReferrer.leo;
      p.Un(paramq).kCY = localAppBrandLaunchReferrer.businessType;
      p.Un(paramq).kDa = false;
      p.Un(paramq).kDc = false;
      p.Un(paramq).kDb = false;
      Log.i("MicroMsg.OpenBusinessViewUtil", "recordOpenBusinessViewInfo, app:%s, businessType:%s, launchScene:%s", new Object[] { paramq, localAppBrandLaunchReferrer.businessType, Integer.valueOf(localAppBrandLaunchReferrer.leo) });
      AppMethodBeat.o(174786);
      return;
    }
    Log.i("MicroMsg.OpenBusinessViewUtil", "recordOpenBusinessViewInfo, referrer businessType is null");
    AppMethodBeat.o(174786);
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
    
    public final void bjj()
    {
      AppMethodBeat.i(46301);
      OpenBusinessViewUtil.C(this.businessType, this.extra, this.errCode);
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
  
  public static abstract interface a
  {
    public abstract void ak(int paramInt, String paramString);
    
    public abstract void ds(String paramString1, String paramString2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.fakenative.OpenBusinessViewUtil
 * JD-Core Version:    0.7.0.1
 */