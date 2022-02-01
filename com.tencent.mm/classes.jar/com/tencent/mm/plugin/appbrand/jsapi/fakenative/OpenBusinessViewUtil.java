package com.tencent.mm.plugin.appbrand.jsapi.fakenative;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.g.a.ly;
import com.tencent.mm.g.a.lz;
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
import com.tencent.mm.protocal.protobuf.boq;
import com.tencent.mm.protocal.protobuf.bor;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bs;

public final class OpenBusinessViewUtil
{
  public static void A(String paramString1, String paramString2, int paramInt)
  {
    AppMethodBeat.i(46311);
    ac.i("MicroMsg.OpenBusinessViewUtil", "navigateBackH5, businessType:%s, errCode:%d", new Object[] { paramString1, Integer.valueOf(paramInt) });
    if (ai.ciE())
    {
      B(paramString1, paramString2, paramInt);
      AppMethodBeat.o(46311);
      return;
    }
    AppBrandMainProcessService.a(new NavigateBackH5Task(paramString1, paramString2, paramInt));
    AppMethodBeat.o(46311);
  }
  
  public static void B(String paramString1, String paramString2, int paramInt)
  {
    AppMethodBeat.i(46312);
    ly locally = new ly();
    locally.doa.businessType = paramString1;
    locally.doa.errCode = paramInt;
    locally.doa.dob = paramString2;
    a.GpY.l(locally);
    AppMethodBeat.o(46312);
  }
  
  public static void D(o paramo)
  {
    AppMethodBeat.i(174786);
    AppBrandLaunchReferrer localAppBrandLaunchReferrer = paramo.aTS().cce;
    if ((localAppBrandLaunchReferrer != null) && (!bs.isNullOrNil(localAppBrandLaunchReferrer.businessType)))
    {
      paramo = paramo.mAppId;
      n.Hs(paramo).jfX = localAppBrandLaunchReferrer.jDQ;
      n.Hs(paramo).jfW = localAppBrandLaunchReferrer.businessType;
      n.Hs(paramo).jfY = false;
      n.Hs(paramo).jga = false;
      n.Hs(paramo).jfZ = false;
      ac.i("MicroMsg.OpenBusinessViewUtil", "recordOpenBusinessViewInfo, app:%s, businessType:%s, launchScene:%s", new Object[] { paramo, localAppBrandLaunchReferrer.businessType, Integer.valueOf(localAppBrandLaunchReferrer.jDQ) });
      AppMethodBeat.o(174786);
      return;
    }
    ac.i("MicroMsg.OpenBusinessViewUtil", "recordOpenBusinessViewInfo, referrer businessType is null");
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
    int i = n.Hr(paramo.mAppId).jfX;
    String str = n.Hr(paramo.mAppId).jfW;
    ac.i("MicroMsg.OpenBusinessViewUtil", "navigateBackCancelResultIfNeed, appId:%s, businessType:%s, launchScene:%s", new Object[] { paramo.mAppId, str, Integer.valueOf(i) });
    if (!bs.isNullOrNil(str))
    {
      if (i == 2)
      {
        if (!n.Hr(paramo.mAppId).jfY)
        {
          ac.i("MicroMsg.OpenBusinessViewUtil", "navigateBackCancelResultIfNeed, return cancel to H5, businessType:%s", new Object[] { str });
          A(str, null, -3);
        }
        AppMethodBeat.o(174787);
        return;
      }
      if (i == 4)
      {
        if (!n.Hr(paramo.mAppId).jga)
        {
          ac.i("MicroMsg.OpenBusinessViewUtil", "navigateBackCancelResultIfNeed, return cancel to Application, businessType:%s", new Object[] { str });
          if ((paramo.aTS().cce != null) && (!bs.isNullOrNil(paramo.aTS().cce.appId))) {
            z(paramo.aTS().cce.appId, str, -2);
          }
        }
        AppMethodBeat.o(174787);
        return;
      }
      if ((i == 1) && (!n.Hr(paramo.mAppId).jfZ))
      {
        ac.i("MicroMsg.OpenBusinessViewUtil", "navigateBackCancelResultIfNeed, return cancel to MiniProgram, businessType:%s", new Object[] { str });
        p(str, g.kqP.errCode, null);
      }
    }
    AppMethodBeat.o(174787);
  }
  
  public static void a(int paramInt, String paramString1, String paramString2, String paramString3, String paramString4, a parama)
  {
    AppMethodBeat.i(46305);
    boq localboq = new boq();
    localboq.dbL = paramInt;
    localboq.FdR = paramString1;
    localboq.FdS = paramString3;
    localboq.FdT = paramString4;
    localboq.query = paramString2;
    paramString1 = new b.a();
    paramString1.funcId = 1268;
    paramString1.uri = "/cgi-bin/mmbiz-bin/wxabusiness/launchbizwxaapp";
    paramString1.hvt = localboq;
    paramString1.hvu = new bor();
    IPCRunCgi.a(paramString1.aAz(), new IPCRunCgi.a()
    {
      public final void a(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, b paramAnonymousb)
      {
        AppMethodBeat.i(46299);
        if ((paramAnonymousInt1 == 0) && (paramAnonymousInt2 == 0) && (paramAnonymousb != null) && (paramAnonymousb.hvs.hvw != null) && ((paramAnonymousb.hvs.hvw instanceof bor)))
        {
          paramAnonymousString = (bor)paramAnonymousb.hvs.hvw;
          ac.i("MicroMsg.OpenBusinessViewUtil", "transBusinessAppInfo, request success, appId:%s, path:%s", new Object[] { paramAnonymousString.djj, paramAnonymousString.FdU });
          if (this.kqT != null) {
            this.kqT.cY(paramAnonymousString.djj, paramAnonymousString.FdU);
          }
          AppMethodBeat.o(46299);
          return;
        }
        ac.e("MicroMsg.OpenBusinessViewUtil", "transBusinessAppInfo, request fail");
        if (this.kqT != null) {
          this.kqT.af(paramAnonymousInt2, paramAnonymousString);
        }
        AppMethodBeat.o(46299);
      }
    });
    AppMethodBeat.o(46305);
  }
  
  public static void p(String paramString1, int paramInt, String paramString2)
  {
    AppMethodBeat.i(46309);
    ac.i("MicroMsg.OpenBusinessViewUtil", "navigateBackMiniProgram, businessType:%s, errCode:%d", new Object[] { paramString1, Integer.valueOf(paramInt) });
    q(paramString1, paramInt, paramString2);
    AppMethodBeat.o(46309);
  }
  
  private static void q(String paramString1, int paramInt, String paramString2)
  {
    AppMethodBeat.i(46310);
    lz locallz = new lz();
    locallz.doc.errCode = paramInt;
    locallz.doc.businessType = paramString1;
    locallz.doc.dob = paramString2;
    a.GpY.l(locallz);
    AppMethodBeat.o(46310);
  }
  
  public static void z(String paramString1, String paramString2, int paramInt)
  {
    AppMethodBeat.i(46308);
    ac.i("MicroMsg.OpenBusinessViewUtil", "navigateBackApplication, appId:%s, businessType:%s, errCode:%d", new Object[] { paramString1, paramString2, Integer.valueOf(paramInt) });
    AppBrandMainProcessService.a(new JsApiNavigateBackApplication.NavigateBackAppTask(paramString1, bs.bG(null, "{}"), paramString2, paramInt));
    AppMethodBeat.o(46308);
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
    
    public final void aLq()
    {
      AppMethodBeat.i(46301);
      OpenBusinessViewUtil.B(this.businessType, this.extra, this.errCode);
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
    public abstract void af(int paramInt, String paramString);
    
    public abstract void cY(String paramString1, String paramString2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.fakenative.OpenBusinessViewUtil
 * JD-Core Version:    0.7.0.1
 */