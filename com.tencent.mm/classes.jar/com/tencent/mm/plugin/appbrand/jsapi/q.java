package com.tencent.mm.plugin.appbrand.jsapi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.appdownload.JsApiAddDownloadTask;
import com.tencent.mm.plugin.appbrand.jsapi.appdownload.JsApiAddDownloadTaskForNative;
import com.tencent.mm.plugin.appbrand.jsapi.appdownload.JsApiAddDownloadTaskStraight;
import com.tencent.mm.plugin.appbrand.jsapi.appdownload.JsApiCancelDownloadTask;
import com.tencent.mm.plugin.appbrand.jsapi.appdownload.JsApiCancelDownloadTaskForNative;
import com.tencent.mm.plugin.appbrand.jsapi.appdownload.JsApiGetInstallState;
import com.tencent.mm.plugin.appbrand.jsapi.appdownload.JsApiGetInstallStateForNative;
import com.tencent.mm.plugin.appbrand.jsapi.appdownload.JsApiInstallDownloadTask;
import com.tencent.mm.plugin.appbrand.jsapi.appdownload.JsApiInstallDownloadTaskForNative;
import com.tencent.mm.plugin.appbrand.jsapi.appdownload.JsApiJumpDownloaderWidgetForNative;
import com.tencent.mm.plugin.appbrand.jsapi.appdownload.JsApiLaunchApplicationForNative;
import com.tencent.mm.plugin.appbrand.jsapi.appdownload.JsApiPauseDownloadTask;
import com.tencent.mm.plugin.appbrand.jsapi.appdownload.JsApiPauseDownloadTaskForNative;
import com.tencent.mm.plugin.appbrand.jsapi.appdownload.JsApiQueryDownloadTask;
import com.tencent.mm.plugin.appbrand.jsapi.appdownload.JsApiQueryDownloadTaskForNative;
import com.tencent.mm.plugin.appbrand.jsapi.appdownload.JsApiResumeDownloadTaskForNative;
import com.tencent.mm.plugin.appbrand.jsapi.audio.JsApiGetBackgroundAudioState;
import com.tencent.mm.plugin.appbrand.jsapi.audio.JsApiGetMusicPlayerState;
import com.tencent.mm.plugin.appbrand.jsapi.audio.JsApiOperateMusicPlayer;
import com.tencent.mm.plugin.appbrand.jsapi.audio.JsApiPausePlayVoice;
import com.tencent.mm.plugin.appbrand.jsapi.audio.JsApiSetBackgroundAudioStateWC;
import com.tencent.mm.plugin.appbrand.jsapi.audio.JsApiStartPlayVoice;
import com.tencent.mm.plugin.appbrand.jsapi.audio.JsApiStartRecordVoice;
import com.tencent.mm.plugin.appbrand.jsapi.audio.JsApiStopPlayVoice;
import com.tencent.mm.plugin.appbrand.jsapi.audio.JsApiStopRecordVoice;
import com.tencent.mm.plugin.appbrand.jsapi.auth.JsApiAuthorize;
import com.tencent.mm.plugin.appbrand.jsapi.auth.JsApiLogin;
import com.tencent.mm.plugin.appbrand.jsapi.auth.JsApiOperateWXData;
import com.tencent.mm.plugin.appbrand.jsapi.backgroundfetch.JsApiSetBackgroundFetchToken;
import com.tencent.mm.plugin.appbrand.jsapi.backgroundfetch.JsApiTriggerBackgroundFetch;
import com.tencent.mm.plugin.appbrand.jsapi.bio.face.JsApiCheckIsSupportFaceDetect;
import com.tencent.mm.plugin.appbrand.jsapi.bio.soter.JsApiCheckBioEnrollment;
import com.tencent.mm.plugin.appbrand.jsapi.bio.soter.JsApiCheckIsSupportSoterAuthentication;
import com.tencent.mm.plugin.appbrand.jsapi.bizvideochannel.JsApiHandleMpChannelAction;
import com.tencent.mm.plugin.appbrand.jsapi.bizvideochannel.JsApiOpenWebViewUseFastLoad;
import com.tencent.mm.plugin.appbrand.jsapi.camera.AppBrandCameraView;
import com.tencent.mm.plugin.appbrand.jsapi.camera.SameLayerCameraView;
import com.tencent.mm.plugin.appbrand.jsapi.contact.JsApiChooseWeChatContact;
import com.tencent.mm.plugin.appbrand.jsapi.fakenative.JsApiRemoveSplashScreenshot;
import com.tencent.mm.plugin.appbrand.jsapi.file.ak;
import com.tencent.mm.plugin.appbrand.jsapi.file.am;
import com.tencent.mm.plugin.appbrand.jsapi.finder.JsApiDeleteFinderDataItem;
import com.tencent.mm.plugin.appbrand.jsapi.finder.JsApiFetchSendingAndFailProfileFeed;
import com.tencent.mm.plugin.appbrand.jsapi.finder.JsApiFinderEndorsementFinished;
import com.tencent.mm.plugin.appbrand.jsapi.finder.JsApiGetFinderAccount;
import com.tencent.mm.plugin.appbrand.jsapi.finder.JsApiPostFinderDataItem;
import com.tencent.mm.plugin.appbrand.jsapi.finder.JsApiResendProfileFeed;
import com.tencent.mm.plugin.appbrand.jsapi.lab.JsApiGetLabInfo;
import com.tencent.mm.plugin.appbrand.jsapi.lab.JsApiSetLabInfo;
import com.tencent.mm.plugin.appbrand.jsapi.media.JsApiChooseImage;
import com.tencent.mm.plugin.appbrand.jsapi.media.JsApiChooseMedia;
import com.tencent.mm.plugin.appbrand.jsapi.media.JsApiChooseMultiMedia;
import com.tencent.mm.plugin.appbrand.jsapi.media.JsApiUploadEncryptedFileToCDN;
import com.tencent.mm.plugin.appbrand.jsapi.miniprogram_navigator.JsApiNavigateToDevMiniProgram;
import com.tencent.mm.plugin.appbrand.jsapi.msgsubscription.JsApiRequestSubscribeMessage;
import com.tencent.mm.plugin.appbrand.jsapi.nfc.hce.HCEService;
import com.tencent.mm.plugin.appbrand.jsapi.rencentusage.JsApiGetRecentUsageList;
import com.tencent.mm.plugin.appbrand.jsapi.rencentusage.JsApiOperateRecentUsageList;
import com.tencent.mm.plugin.appbrand.jsapi.scanner.JsApiScanCode;
import com.tencent.mm.plugin.appbrand.jsapi.share.JsApiShowUpdatableMessageSubscribeButton;
import com.tencent.mm.plugin.appbrand.widget.input.panel.e.b;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;

public final class q
{
  private static final boolean jWx;
  private final Map<String, m> jWA;
  private final Map<String, m> jWB;
  private long jWy;
  private long jWz;
  
  static
  {
    AppMethodBeat.i(45430);
    com.tencent.mm.plugin.appbrand.u.a.bsU();
    com.tencent.mm.plugin.appbrand.jsapi.video.b.init();
    AppBrandCameraView.bga();
    SameLayerCameraView.bga();
    ck.beU();
    com.tencent.mm.plugin.appbrand.app.g.HI("com.tencent.mm.plugin.soter.PluginSoter");
    com.tencent.mm.plugin.appbrand.app.g.HI("com.tencent.mm.plugin.facedetect.PluginFace");
    com.tencent.luggage.a.e.a(com.tencent.mm.plugin.appbrand.p.o.class, new com.tencent.mm.plugin.appbrand.luggage.d.c());
    com.tencent.luggage.a.e.a(com.tencent.mm.plugin.appbrand.utils.b.a.class, new com.tencent.mm.plugin.appbrand.jsapi.d.s());
    com.tencent.luggage.a.e.a(com.tencent.luggage.c.a.a.class, new com.tencent.mm.plugin.appbrand.luggage.b.g());
    com.tencent.luggage.a.e.a(com.tencent.mm.plugin.appbrand.widget.input.a.b.class, com.tencent.mm.plugin.appbrand.luggage.b.d.lqF);
    com.tencent.luggage.a.e.a(e.b.class, new com.tencent.mm.plugin.appbrand.luggage.b.e());
    com.tencent.luggage.a.e.a(com.tencent.mm.plugin.appbrand.jsapi.t.a.class, new com.tencent.mm.plugin.appbrand.jsapi.t.j());
    com.tencent.luggage.a.e.a(ac.class, new com.tencent.mm.plugin.appbrand.luggage.b.a());
    com.tencent.luggage.a.e.a(com.tencent.mm.plugin.appbrand.jsapi.z.e.a.b.class, new com.tencent.mm.plugin.appbrand.utils.z());
    com.tencent.luggage.a.e.a(com.tencent.mm.plugin.appbrand.jsapi.f.a.c.class, new com.tencent.mm.plugin.appbrand.luggage.b.n());
    com.tencent.luggage.a.e.a(com.tencent.mm.plugin.appbrand.widget.b.b.class, new com.tencent.mm.plugin.appbrand.luggage.b.m());
    com.tencent.luggage.a.e.a(com.tencent.mm.plugin.appbrand.jsapi.z.e.a.c.class, new com.tencent.mm.plugin.appbrand.report.l());
    com.tencent.luggage.a.e.a(ad.class, new com.tencent.mm.plugin.appbrand.utils.af());
    com.tencent.luggage.a.e.a(com.tencent.mm.plugin.appbrand.jsapi.p.a.class, com.tencent.mm.plugin.appbrand.utils.ae.moV);
    com.tencent.luggage.a.e.a(com.tencent.mm.plugin.appbrand.jsapi.camera.e.class, new com.tencent.mm.plugin.appbrand.jsapi.z.a.b());
    if ((com.tencent.mm.sdk.platformtools.h.IS_FLAVOR_RED) || (com.tencent.mm.sdk.platformtools.h.IS_FLAVOR_PURPLE) || (!com.tencent.mm.protocal.d.DId) || (com.tencent.mm.sdk.platformtools.bt.eWo())) {}
    for (boolean bool = true;; bool = false)
    {
      jWx = bool;
      AppMethodBeat.o(45430);
      return;
    }
  }
  
  private q()
  {
    AppMethodBeat.i(45422);
    this.jWA = new HashMap()
    {
      public final String toString()
      {
        AppMethodBeat.i(45420);
        String str = String.format(Locale.ENGLISH, "ServiceAPIs[%d]", new Object[] { Integer.valueOf(size()) });
        AppMethodBeat.o(45420);
        return str;
      }
    };
    this.jWB = new HashMap()
    {
      public final String toString()
      {
        AppMethodBeat.i(45421);
        String str = String.format(Locale.ENGLISH, "PageAPIs[%d]", new Object[] { Integer.valueOf(size()) });
        AppMethodBeat.o(45421);
        return str;
      }
    };
    AppMethodBeat.o(45422);
  }
  
  private void a(m paramm)
  {
    AppMethodBeat.i(45428);
    long l = com.tencent.mm.sdk.platformtools.bs.Gn() - this.jWz;
    if (l > 1L) {
      com.tencent.mm.sdk.platformtools.ac.e("MicroMsg.AppBrandJsApiPool", "addToPagePool api[%s] use[%dms]", new Object[] { paramm.getName(), Long.valueOf(l) });
    }
    if ((m)this.jWB.put(paramm.getName(), paramm) != null)
    {
      paramm = new IllegalAccessError("Duplicated api instance " + c(paramm));
      AppMethodBeat.o(45428);
      throw paramm;
    }
    paramm.jWs = jWx;
    this.jWz = com.tencent.mm.sdk.platformtools.bs.Gn();
    AppMethodBeat.o(45428);
  }
  
  private void b(m paramm)
  {
    AppMethodBeat.i(45426);
    long l = com.tencent.mm.sdk.platformtools.bs.Gn() - this.jWy;
    if (l > 1L) {
      com.tencent.mm.sdk.platformtools.ac.e("MicroMsg.AppBrandJsApiPool", "addToServicePool api[%s] use[%dms]", new Object[] { paramm.getName(), Long.valueOf(l) });
    }
    if ((m)this.jWA.put(paramm.getName(), paramm) != null)
    {
      paramm = new IllegalAccessError("Duplicated api instance " + c(paramm));
      AppMethodBeat.o(45426);
      throw paramm;
    }
    paramm.jWs = jWx;
    this.jWy = com.tencent.mm.sdk.platformtools.bs.Gn();
    AppMethodBeat.o(45426);
  }
  
  public static Map<String, m> beH()
  {
    AppMethodBeat.i(45423);
    Object localObject = new q();
    ((q)localObject).jWy = com.tencent.mm.sdk.platformtools.bs.Gn();
    ((q)localObject).b(new com.tencent.mm.plugin.appbrand.ad.a.h());
    ((q)localObject).b(new com.tencent.mm.plugin.appbrand.ad.a.g());
    ((q)localObject).b(new com.tencent.mm.plugin.appbrand.ad.a.a());
    ((q)localObject).b(new com.tencent.mm.plugin.appbrand.ad.a.j());
    ((q)localObject).b(new com.tencent.mm.plugin.appbrand.ad.a.i());
    ((q)localObject).b(new com.tencent.mm.plugin.appbrand.jsapi.storage.a());
    ((q)localObject).b(new com.tencent.mm.plugin.appbrand.jsapi.storage.f());
    ((q)localObject).b(new com.tencent.mm.plugin.appbrand.jsapi.storage.n());
    ((q)localObject).b(new com.tencent.mm.plugin.appbrand.jsapi.storage.b());
    ((q)localObject).b(new com.tencent.mm.plugin.appbrand.jsapi.storage.i());
    ((q)localObject).b(new com.tencent.mm.plugin.appbrand.jsapi.storage.o());
    ((q)localObject).b(new JsApiLogin());
    ((q)localObject).b(new JsApiAuthorize());
    ((q)localObject).b(new JsApiOperateWXData());
    ((q)localObject).b(new com.tencent.mm.plugin.appbrand.jsapi.k.v());
    ((q)localObject).b(new com.tencent.mm.plugin.appbrand.jsapi.k.h());
    ((q)localObject).b(new com.tencent.mm.plugin.appbrand.jsapi.k.m());
    ((q)localObject).b(new com.tencent.mm.plugin.appbrand.jsapi.k.n());
    ((q)localObject).b(new com.tencent.mm.plugin.appbrand.jsapi.k.g());
    ((q)localObject).b(new br());
    ((q)localObject).b(new JsApiChooseImage());
    ((q)localObject).b(new com.tencent.mm.plugin.appbrand.jsapi.media.k());
    ((q)localObject).b(new com.tencent.mm.plugin.appbrand.jsapi.media.l());
    ((q)localObject).b(new com.tencent.mm.plugin.appbrand.jsapi.media.g());
    ((q)localObject).b(new com.tencent.mm.plugin.appbrand.jsapi.media.j());
    ((q)localObject).b(new com.tencent.mm.plugin.appbrand.jsapi.media.h());
    ((q)localObject).b(new com.tencent.mm.plugin.appbrand.jsapi.media.f());
    ((q)localObject).b(new JsApiStartRecordVoice());
    ((q)localObject).b(new JsApiStopRecordVoice());
    ((q)localObject).b(new JsApiStartPlayVoice());
    ((q)localObject).b(new JsApiPausePlayVoice());
    ((q)localObject).b(new JsApiStopPlayVoice());
    ((q)localObject).b(new com.tencent.mm.plugin.appbrand.jsapi.d.m());
    ((q)localObject).b(new com.tencent.mm.plugin.appbrand.jsapi.d.o());
    ((q)localObject).b(new com.tencent.mm.plugin.appbrand.jsapi.u.g());
    ((q)localObject).b(new JsApiGetMusicPlayerState());
    ((q)localObject).b(new JsApiOperateMusicPlayer());
    ((q)localObject).b(new JsApiScanCode());
    ((q)localObject).b(new com.tencent.mm.plugin.appbrand.jsapi.scanner.a());
    ((q)localObject).b(new com.tencent.mm.plugin.appbrand.jsapi.pay.n());
    ((q)localObject).b(new com.tencent.mm.plugin.appbrand.jsapi.pay.l());
    ((q)localObject).b(new be());
    ((q)localObject).b(new com.tencent.mm.plugin.appbrand.jsapi.r.d());
    ((q)localObject).b(new com.tencent.mm.plugin.appbrand.jsapi.pay.s());
    ((q)localObject).b(new com.tencent.mm.plugin.appbrand.jsapi.pay.b());
    ((q)localObject).b(new com.tencent.mm.plugin.appbrand.jsapi.contact.c());
    ((q)localObject).b(new com.tencent.mm.plugin.appbrand.jsapi.contact.g());
    ((q)localObject).b(new com.tencent.mm.plugin.appbrand.jsapi.k.af());
    ((q)localObject).b(new com.tencent.mm.plugin.appbrand.jsapi.pay.e());
    ((q)localObject).b(new com.tencent.mm.plugin.appbrand.jsapi.pay.h());
    ((q)localObject).b(new com.tencent.mm.plugin.appbrand.jsapi.k.ac());
    ((q)localObject).b(new com.tencent.mm.plugin.appbrand.jsapi.k.d());
    ((q)localObject).b(new com.tencent.mm.plugin.appbrand.jsapi.k.ab());
    ((q)localObject).b(new com.tencent.mm.plugin.appbrand.jsapi.k.c());
    ((q)localObject).b(new com.tencent.mm.plugin.appbrand.jsapi.a.f());
    ((q)localObject).b(new com.tencent.mm.plugin.appbrand.jsapi.share.d());
    ((q)localObject).b(new com.tencent.mm.plugin.appbrand.jsapi.u.j());
    ((q)localObject).b(new com.tencent.mm.plugin.appbrand.jsapi.r.e());
    ((q)localObject).b(new com.tencent.mm.plugin.appbrand.jsapi.r.g());
    ((q)localObject).b(new com.tencent.mm.plugin.appbrand.jsapi.r.f());
    ((q)localObject).b(new cb());
    ((q)localObject).b(new com.tencent.mm.plugin.appbrand.jsapi.c.g());
    ((q)localObject).b(new az());
    ((q)localObject).b(new com.tencent.mm.plugin.appbrand.jsapi.c.c());
    ((q)localObject).b(new com.tencent.mm.plugin.appbrand.jsapi.t.b());
    ((q)localObject).b(new com.tencent.mm.plugin.appbrand.jsapi.t.c());
    ((q)localObject).b(new com.tencent.mm.plugin.appbrand.jsapi.t.f());
    ((q)localObject).b(new com.tencent.mm.plugin.appbrand.jsapi.t.d());
    ((q)localObject).b(new com.tencent.mm.plugin.appbrand.jsapi.t.e());
    ((q)localObject).b(new com.tencent.mm.plugin.appbrand.jsapi.storage.k());
    ((q)localObject).b(new com.tencent.mm.plugin.appbrand.jsapi.storage.l());
    ((q)localObject).b(new com.tencent.mm.plugin.appbrand.jsapi.z.b.b.f());
    ((q)localObject).b(new com.tencent.mm.plugin.appbrand.jsapi.a.e());
    ((q)localObject).b(new com.tencent.mm.plugin.appbrand.jsapi.o.c());
    ((q)localObject).b(new com.tencent.mm.plugin.appbrand.jsapi.o.b());
    ((q)localObject).b(new com.tencent.mm.plugin.appbrand.jsapi.o.d());
    ((q)localObject).b(new com.tencent.mm.plugin.appbrand.jsapi.o.a());
    ((q)localObject).b(new at());
    ((q)localObject).b(new bb());
    ((q)localObject).b(new com.tencent.mm.plugin.appbrand.jsapi.storage.g());
    ((q)localObject).b(new com.tencent.mm.plugin.appbrand.jsapi.storage.h());
    ((q)localObject).b(new com.tencent.mm.plugin.appbrand.jsapi.d.c());
    ((q)localObject).b(new com.tencent.mm.plugin.appbrand.jsapi.media.i());
    ((q)localObject).b(new JsApiRefreshSession());
    ((q)localObject).b(new com.tencent.mm.plugin.appbrand.jsapi.k.ag());
    ((q)localObject).b(new com.tencent.mm.plugin.appbrand.jsapi.pay.o());
    ((q)localObject).b(new com.tencent.mm.plugin.appbrand.jsapi.share.k());
    ((q)localObject).b(new com.tencent.mm.plugin.appbrand.ab.h());
    ((q)localObject).b(new ah());
    ((q)localObject).b(new bf());
    ((q)localObject).b(new JsApiMakeVoIPCall());
    ((q)localObject).b(new com.tencent.mm.plugin.appbrand.jsapi.u.c());
    ((q)localObject).b(new com.tencent.mm.plugin.appbrand.jsapi.u.e());
    ((q)localObject).b(new JsApiSetClipboardDataWC());
    ((q)localObject).b(new com.tencent.mm.plugin.appbrand.jsapi.bluetooth.a.l());
    ((q)localObject).b(new com.tencent.mm.plugin.appbrand.jsapi.bluetooth.a.b());
    ((q)localObject).b(new com.tencent.mm.plugin.appbrand.jsapi.bluetooth.a.g());
    ((q)localObject).b(new com.tencent.mm.plugin.appbrand.jsapi.bluetooth.a.o());
    ((q)localObject).b(new com.tencent.mm.plugin.appbrand.jsapi.bluetooth.a.p());
    ((q)localObject).b(new com.tencent.mm.plugin.appbrand.jsapi.bluetooth.a.h());
    ((q)localObject).b(new com.tencent.mm.plugin.appbrand.jsapi.bluetooth.a.j());
    ((q)localObject).b(new com.tencent.mm.plugin.appbrand.jsapi.bluetooth.a.n());
    ((q)localObject).b(new com.tencent.mm.plugin.appbrand.jsapi.bluetooth.a.e());
    ((q)localObject).b(new com.tencent.mm.plugin.appbrand.jsapi.bluetooth.a.c());
    ((q)localObject).b(new com.tencent.mm.plugin.appbrand.jsapi.bluetooth.a.a());
    ((q)localObject).b(new com.tencent.mm.plugin.appbrand.jsapi.bluetooth.a.f());
    ((q)localObject).b(new com.tencent.mm.plugin.appbrand.jsapi.bluetooth.a.d());
    ((q)localObject).b(new com.tencent.mm.plugin.appbrand.jsapi.bluetooth.a.m());
    ((q)localObject).b(new com.tencent.mm.plugin.appbrand.jsapi.bluetooth.a.q());
    ((q)localObject).b(new com.tencent.mm.plugin.appbrand.jsapi.bluetooth.a.k());
    ((q)localObject).b(new com.tencent.mm.plugin.appbrand.jsapi.bluetooth.a.i());
    ((q)localObject).b(new com.tencent.mm.plugin.appbrand.jsapi.bluetooth.b.c());
    ((q)localObject).b(new com.tencent.mm.plugin.appbrand.jsapi.bluetooth.b.d());
    ((q)localObject).b(new com.tencent.mm.plugin.appbrand.jsapi.bluetooth.b.e());
    ((q)localObject).b(new com.tencent.mm.plugin.appbrand.jsapi.bluetooth.b.f());
    ((q)localObject).b(new com.tencent.mm.plugin.appbrand.jsapi.bluetooth.b.g());
    ((q)localObject).b(new com.tencent.mm.plugin.appbrand.jsapi.bluetooth.b.h());
    ((q)localObject).b(new com.tencent.mm.plugin.appbrand.jsapi.bluetooth.b.i());
    ((q)localObject).b(new com.tencent.mm.plugin.appbrand.jsapi.miniprogram_navigator.e());
    ((q)localObject).b(new com.tencent.mm.plugin.appbrand.jsapi.k.l());
    ((q)localObject).b(new bx());
    ((q)localObject).b(new as());
    ((q)localObject).b(new JsApiChooseWeChatContact());
    ((q)localObject).b(new JsApiChooseMedia());
    ((q)localObject).b(new JsApiUploadEncryptedFileToCDN());
    ((q)localObject).b(new com.tencent.mm.plugin.appbrand.jsapi.miniprogram_navigator.d());
    ((q)localObject).b(new bl());
    ((q)localObject).b(new cd());
    ((q)localObject).b(new JsApiGetBackgroundAudioState());
    ((q)localObject).b(new JsApiSetBackgroundAudioStateWC());
    ((q)localObject).b(new com.tencent.mm.plugin.appbrand.jsapi.audio.i());
    ((q)localObject).b(new com.tencent.mm.plugin.appbrand.jsapi.share.l());
    ((q)localObject).b(new com.tencent.mm.plugin.appbrand.jsapi.share.b());
    ((q)localObject).b(new bm());
    ((q)localObject).b(new com.tencent.mm.plugin.appbrand.jsapi.pay.r());
    ((q)localObject).b(new com.tencent.mm.plugin.appbrand.jsapi.contact.b());
    ((q)localObject).b(new JsApiOpenWeRunSetting());
    ((q)localObject).b(new JsApiUploadWeRunData());
    ((q)localObject).b(new ai());
    ((q)localObject).b(new com.tencent.mm.plugin.appbrand.jsapi.u.h());
    ((q)localObject).b(new com.tencent.mm.plugin.appbrand.jsapi.u.n());
    ((q)localObject).b(new com.tencent.mm.plugin.appbrand.jsapi.u.p());
    ((q)localObject).b(new com.tencent.mm.plugin.appbrand.jsapi.u.q());
    ((q)localObject).b(new com.tencent.mm.plugin.appbrand.jsapi.share.o());
    ((q)localObject).b(new com.tencent.mm.plugin.appbrand.jsapi.share.n());
    ((q)localObject).b(new com.tencent.mm.plugin.appbrand.jsapi.share.q());
    ((q)localObject).b(new JsApiShowUpdatableMessageSubscribeButton());
    ((q)localObject).b(new com.tencent.mm.plugin.appbrand.jsapi.b.b());
    ((q)localObject).b(new com.tencent.mm.plugin.appbrand.jsapi.b.c());
    ((q)localObject).b(new com.tencent.mm.plugin.appbrand.jsapi.b.d());
    ((q)localObject).b(new JsApiCheckIsSupportFaceDetect());
    ((q)localObject).b(new com.tencent.mm.plugin.appbrand.jsapi.bio.face.e());
    ((q)localObject).b(new com.tencent.mm.plugin.appbrand.jsapi.bio.face.d());
    ((q)localObject).b(new com.tencent.mm.plugin.appbrand.jsapi.bio.face.f());
    ((q)localObject).b(new com.tencent.mm.plugin.appbrand.jsapi.bio.face.b());
    ((q)localObject).b(new com.tencent.mm.plugin.appbrand.jsapi.bio.face.c());
    ((q)localObject).b(new com.tencent.mm.plugin.appbrand.jsapi.z.e.b.f());
    ((q)localObject).b(new com.tencent.mm.plugin.appbrand.jsapi.video.d.c());
    ((q)localObject).b(new com.tencent.mm.plugin.appbrand.jsapi.live.d());
    ((q)localObject).b(new com.tencent.mm.plugin.appbrand.jsapi.live.c());
    ((q)localObject).b(new com.tencent.mm.plugin.appbrand.jsapi.media.m());
    ((q)localObject).b(new com.tencent.mm.plugin.appbrand.jsapi.media.n());
    ((q)localObject).b(new ba());
    ((q)localObject).b(new bi());
    ((q)localObject).b(new com.tencent.mm.plugin.appbrand.jsapi.share.e());
    ((q)localObject).b(new com.tencent.mm.plugin.appbrand.jsapi.share.i());
    ((q)localObject).b(new com.tencent.mm.plugin.appbrand.jsapi.ui.b());
    ((q)localObject).b(new com.tencent.mm.plugin.appbrand.jsapi.share.g());
    ((q)localObject).b(new com.tencent.mm.plugin.appbrand.jsapi.u.m());
    ((q)localObject).b(new an());
    ((q)localObject).b(new com.tencent.mm.plugin.appbrand.jsapi.a.i());
    ((q)localObject).b(new com.tencent.mm.plugin.appbrand.jsapi.miniprogram_navigator.h());
    ((q)localObject).b(new com.tencent.mm.plugin.appbrand.jsapi.fakenative.c());
    ((q)localObject).b(new com.tencent.mm.plugin.appbrand.jsapi.fakenative.d());
    ((q)localObject).b(new com.tencent.mm.plugin.appbrand.jsapi.fakenative.b());
    ((q)localObject).b(new com.tencent.mm.plugin.appbrand.jsapi.op_report.b());
    ((q)localObject).b(new com.tencent.mm.plugin.appbrand.jsapi.k.u());
    ((q)localObject).b(new com.tencent.mm.plugin.appbrand.jsapi.k.ai());
    ((q)localObject).b(new ca());
    ((q)localObject).b(new com.tencent.mm.plugin.appbrand.jsapi.k.x());
    ((q)localObject).b(new cc());
    ((q)localObject).b(new com.tencent.mm.plugin.appbrand.jsapi.k.t());
    ((q)localObject).b(new JsApiCheckIsSupportSoterAuthentication());
    ((q)localObject).b(new com.tencent.mm.plugin.appbrand.jsapi.bio.soter.c());
    ((q)localObject).b(new ap());
    ((q)localObject).b(new ao());
    ((q)localObject).b(new com.tencent.mm.plugin.appbrand.jsapi.j.b.b(com.tencent.mm.plugin.appbrand.jsapi.j.b.a.kBb, com.tencent.mm.plugin.appbrand.aq.aUF()));
    ((q)localObject).b(new com.tencent.mm.plugin.appbrand.jsapi.j.b.c(com.tencent.mm.plugin.appbrand.jsapi.j.b.a.kBb, com.tencent.mm.plugin.appbrand.aq.aUF()));
    ((q)localObject).b(new com.tencent.mm.plugin.appbrand.jsapi.j.b.d());
    ((q)localObject).b(new com.tencent.mm.plugin.appbrand.jsapi.j.a.b(com.tencent.mm.plugin.appbrand.aq.aUG()));
    ((q)localObject).b(new com.tencent.mm.plugin.appbrand.jsapi.j.a.c(com.tencent.mm.plugin.appbrand.aq.aUG()));
    ((q)localObject).b(new com.tencent.mm.plugin.appbrand.jsapi.j.a.d());
    ((q)localObject).b(new com.tencent.mm.plugin.appbrand.jsapi.j.c.b());
    ((q)localObject).b(new com.tencent.mm.plugin.appbrand.jsapi.j.c.c());
    ((q)localObject).b(new com.tencent.mm.plugin.appbrand.jsapi.j.c.d());
    ((q)localObject).b(new cf());
    ((q)localObject).b(new aj());
    ((q)localObject).b(new com.tencent.mm.plugin.appbrand.jsapi.camera.n());
    ((q)localObject).b(new com.tencent.mm.plugin.appbrand.jsapi.k.ae());
    ((q)localObject).b(new com.tencent.mm.plugin.appbrand.jsapi.audio.j());
    ((q)localObject).b(new com.tencent.mm.plugin.appbrand.jsapi.x.a.d());
    ((q)localObject).b(new com.tencent.mm.plugin.appbrand.jsapi.audio.d());
    ((q)localObject).b(new com.tencent.mm.plugin.appbrand.jsapi.audio.e());
    ((q)localObject).b(new com.tencent.mm.plugin.appbrand.jsapi.audio.l());
    ((q)localObject).b(new com.tencent.mm.plugin.appbrand.jsapi.audio.g());
    ((q)localObject).b(new com.tencent.mm.plugin.appbrand.jsapi.audio.h());
    ((q)localObject).b(new com.tencent.mm.plugin.appbrand.jsapi.audio.f());
    ((q)localObject).b(new com.tencent.mm.plugin.appbrand.jsapi.audio.m());
    ((q)localObject).b(new JsApiNavigateBackApplication());
    ((q)localObject).b(new com.tencent.mm.plugin.appbrand.jsapi.d.j());
    ((q)localObject).b(new com.tencent.mm.plugin.appbrand.jsapi.d.h());
    ((q)localObject).b(new com.tencent.mm.plugin.appbrand.jsapi.d.e());
    ((q)localObject).b(new JsApiCheckBioEnrollment());
    ((q)localObject).b(new com.tencent.mm.plugin.appbrand.jsapi.wifi.d());
    ((q)localObject).b(new com.tencent.mm.plugin.appbrand.jsapi.wifi.e());
    ((q)localObject).b(new com.tencent.mm.plugin.appbrand.jsapi.wifi.c());
    ((q)localObject).b(new com.tencent.mm.plugin.appbrand.jsapi.wifi.b());
    ((q)localObject).b(new com.tencent.mm.plugin.appbrand.jsapi.wifi.a());
    ((q)localObject).b(new JsApiNavigateToDevMiniProgram());
    ((q)localObject).b(new com.tencent.mm.plugin.appbrand.jsapi.nfc.e(HCEService.class));
    ((q)localObject).b(new com.tencent.mm.plugin.appbrand.jsapi.nfc.f());
    ((q)localObject).b(new com.tencent.mm.plugin.appbrand.jsapi.nfc.d());
    ((q)localObject).b(new com.tencent.mm.plugin.appbrand.jsapi.nfc.b());
    ((q)localObject).b(new com.tencent.mm.plugin.appbrand.jsapi.nfc.c());
    ((q)localObject).b(new com.tencent.mm.plugin.appbrand.jsapi.nfc.a.i());
    ((q)localObject).b(new com.tencent.mm.plugin.appbrand.jsapi.nfc.a.l());
    ((q)localObject).b(new com.tencent.mm.plugin.appbrand.jsapi.nfc.a.f());
    ((q)localObject).b(new com.tencent.mm.plugin.appbrand.jsapi.nfc.a.e());
    ((q)localObject).b(new com.tencent.mm.plugin.appbrand.jsapi.nfc.a.d());
    ((q)localObject).b(new com.tencent.mm.plugin.appbrand.jsapi.nfc.a.k());
    ((q)localObject).b(new com.tencent.mm.plugin.appbrand.jsapi.nfc.a.m());
    ((q)localObject).b(new com.tencent.mm.plugin.appbrand.jsapi.nfc.a.n());
    ((q)localObject).b(new com.tencent.mm.plugin.appbrand.jsapi.nfc.a.o());
    ((q)localObject).b(new com.tencent.mm.plugin.appbrand.jsapi.nfc.a.g());
    ((q)localObject).b(new com.tencent.mm.plugin.appbrand.jsapi.nfc.a.j());
    ((q)localObject).b(new com.tencent.mm.plugin.appbrand.jsapi.nfc.a.h());
    ((q)localObject).b(new com.tencent.mm.plugin.appbrand.jsapi.k.y());
    ((q)localObject).b(new com.tencent.mm.plugin.appbrand.jsapi.k.aa());
    ((q)localObject).b(new com.tencent.mm.plugin.appbrand.jsapi.k.z());
    ((q)localObject).b(new com.tencent.mm.plugin.appbrand.jsapi.k.e());
    ((q)localObject).b(new com.tencent.mm.plugin.appbrand.jsapi.k.ad());
    ((q)localObject).b(new com.tencent.mm.plugin.appbrand.jsapi.ui.e());
    ((q)localObject).b(new com.tencent.mm.plugin.appbrand.jsapi.ui.c());
    ((q)localObject).b(new com.tencent.mm.plugin.appbrand.jsapi.ui.f());
    ((q)localObject).b(new com.tencent.mm.plugin.appbrand.jsapi.ui.d());
    ((q)localObject).b(new com.tencent.mm.plugin.appbrand.jsapi.u.k());
    ((q)localObject).b(new com.tencent.mm.plugin.appbrand.jsapi.u.o());
    ((q)localObject).b(new com.tencent.mm.plugin.appbrand.jsapi.k.ah());
    ((q)localObject).b(new com.tencent.mm.plugin.appbrand.jsapi.j.g(com.tencent.mm.plugin.appbrand.jsapi.j.g.kBb, com.tencent.mm.plugin.appbrand.aq.aUD()));
    ((q)localObject).b(new com.tencent.mm.plugin.appbrand.jsapi.j.i(com.tencent.mm.plugin.appbrand.aq.aUD()));
    ((q)localObject).b(new com.tencent.mm.plugin.appbrand.jsapi.pay.q());
    ((q)localObject).b(new com.tencent.mm.plugin.appbrand.jsapi.k.r());
    ((q)localObject).b(new com.tencent.mm.plugin.appbrand.jsapi.j.f());
    ((q)localObject).b(new ak());
    ((q)localObject).b(new com.tencent.mm.plugin.appbrand.jsapi.file.al());
    ((q)localObject).b(new com.tencent.mm.plugin.appbrand.jsapi.file.r());
    ((q)localObject).b(new com.tencent.mm.plugin.appbrand.jsapi.file.s());
    ((q)localObject).b(new com.tencent.mm.plugin.appbrand.jsapi.file.t());
    ((q)localObject).b(new com.tencent.mm.plugin.appbrand.jsapi.file.af());
    ((q)localObject).b(new com.tencent.mm.plugin.appbrand.jsapi.file.ae());
    ((q)localObject).b(new com.tencent.mm.plugin.appbrand.jsapi.file.aq());
    ((q)localObject).b(new com.tencent.mm.plugin.appbrand.jsapi.file.y());
    ((q)localObject).b(new com.tencent.mm.plugin.appbrand.jsapi.file.ac());
    ((q)localObject).b(new com.tencent.mm.plugin.appbrand.jsapi.file.aj());
    ((q)localObject).b(new com.tencent.mm.plugin.appbrand.jsapi.file.k());
    ((q)localObject).b(new com.tencent.mm.plugin.appbrand.jsapi.file.an());
    ((q)localObject).b(new com.tencent.mm.plugin.appbrand.jsapi.file.v());
    ((q)localObject).b(new com.tencent.mm.plugin.appbrand.jsapi.file.q());
    ((q)localObject).b(new com.tencent.mm.plugin.appbrand.jsapi.file.z());
    ((q)localObject).b(new com.tencent.mm.plugin.appbrand.jsapi.file.ad());
    ((q)localObject).b(new com.tencent.mm.plugin.appbrand.jsapi.file.ap());
    ((q)localObject).b(new com.tencent.mm.plugin.appbrand.jsapi.file.x());
    ((q)localObject).b(new com.tencent.mm.plugin.appbrand.jsapi.file.ab());
    ((q)localObject).b(new com.tencent.mm.plugin.appbrand.jsapi.file.ai());
    ((q)localObject).b(new com.tencent.mm.plugin.appbrand.jsapi.file.j());
    ((q)localObject).b(new am());
    ((q)localObject).b(new com.tencent.mm.plugin.appbrand.jsapi.file.u());
    ((q)localObject).b(new com.tencent.mm.plugin.appbrand.jsapi.file.p());
    ((q)localObject).b(new com.tencent.mm.plugin.appbrand.jsapi.file.ao());
    ((q)localObject).b(new com.tencent.mm.plugin.appbrand.jsapi.file.n());
    ((q)localObject).b(new com.tencent.mm.plugin.appbrand.jsapi.file.o());
    ((q)localObject).b(new com.tencent.mm.plugin.appbrand.jsapi.file.ag());
    ((q)localObject).b(new com.tencent.mm.plugin.appbrand.jsapi.file.ah());
    ((q)localObject).b(new com.tencent.mm.plugin.appbrand.jsapi.file.l());
    ((q)localObject).b(new com.tencent.mm.plugin.appbrand.jsapi.file.m());
    ((q)localObject).b(new JsApiGetLabInfo());
    ((q)localObject).b(new JsApiSetLabInfo());
    ((q)localObject).b(new com.tencent.mm.plugin.appbrand.jsapi.v.a());
    ((q)localObject).b(new com.tencent.mm.plugin.appbrand.jsapi.a.b());
    ((q)localObject).b(new com.tencent.mm.plugin.appbrand.jsapi.a.c());
    ((q)localObject).b(new bk());
    ((q)localObject).b(new bg());
    ((q)localObject).b(new bh());
    ((q)localObject).b(new bn());
    ((q)localObject).b(new bo());
    ((q)localObject).b(new bp());
    ((q)localObject).b(new bq());
    ((q)localObject).b(new bs());
    ((q)localObject).b(new com.tencent.mm.plugin.appbrand.jsapi.u.d());
    ((q)localObject).b(new JsApiLaunchApplication());
    ((q)localObject).b(new JsApiLaunchApplicationDirectly());
    ((q)localObject).b(new JsApiAddNativeDownloadTask());
    ((q)localObject).b(new com.tencent.mm.plugin.appbrand.jsapi.pay.m());
    ((q)localObject).b(new JsApiAddDownloadTask());
    ((q)localObject).b(new JsApiAddDownloadTaskStraight());
    ((q)localObject).b(new JsApiQueryDownloadTask());
    ((q)localObject).b(new JsApiInstallDownloadTask());
    ((q)localObject).b(new JsApiPauseDownloadTask());
    ((q)localObject).b(new JsApiResumeDownloadTask());
    ((q)localObject).b(new JsApiGetInstallState());
    ((q)localObject).b(new JsApiCancelDownloadTask());
    ((q)localObject).b(new JsApiWriteCommData());
    ((q)localObject).b(new com.tencent.mm.plugin.appbrand.jsapi.ui.a());
    ((q)localObject).b(new com.tencent.mm.plugin.appbrand.jsapi.k.p());
    ((q)localObject).b(new com.tencent.mm.plugin.appbrand.jsapi.k.q());
    ((q)localObject).b(new com.tencent.mm.plugin.appbrand.jsapi.e.a());
    ((q)localObject).b(new com.tencent.mm.plugin.appbrand.jsapi.e.b());
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(new com.tencent.mm.plugin.appbrand.jsapi.f.c());
    localArrayList.add(new com.tencent.mm.plugin.appbrand.jsapi.f.ac());
    localArrayList.add(new com.tencent.mm.plugin.appbrand.jsapi.f.g());
    localArrayList.add(new com.tencent.mm.plugin.appbrand.jsapi.f.w());
    localArrayList.add(new com.tencent.mm.plugin.appbrand.jsapi.f.f());
    localArrayList.add(new com.tencent.mm.plugin.appbrand.jsapi.f.v());
    localArrayList.add(new com.tencent.mm.plugin.appbrand.jsapi.f.d());
    localArrayList.add(new com.tencent.mm.plugin.appbrand.jsapi.f.h());
    localArrayList.add(new com.tencent.mm.plugin.appbrand.jsapi.f.j());
    localArrayList.add(new com.tencent.mm.plugin.appbrand.jsapi.f.s());
    localArrayList.add(new com.tencent.mm.plugin.appbrand.jsapi.f.aa());
    localArrayList.add(new com.tencent.mm.plugin.appbrand.jsapi.f.r());
    localArrayList.add(new com.tencent.mm.plugin.appbrand.jsapi.f.n());
    localArrayList.add(new com.tencent.mm.plugin.appbrand.jsapi.f.l());
    localArrayList.add(new com.tencent.mm.plugin.appbrand.jsapi.f.m());
    localArrayList.add(new com.tencent.mm.plugin.appbrand.jsapi.f.o());
    localArrayList.add(new com.tencent.mm.plugin.appbrand.jsapi.f.k());
    localArrayList.add(new com.tencent.mm.plugin.appbrand.jsapi.f.y());
    localArrayList.add(new com.tencent.mm.plugin.appbrand.jsapi.f.i());
    localArrayList.add(new com.tencent.mm.plugin.appbrand.jsapi.f.x());
    localArrayList.add(new com.tencent.mm.plugin.appbrand.jsapi.f.e());
    localArrayList.add(new com.tencent.mm.plugin.appbrand.jsapi.f.u());
    localArrayList.add(new com.tencent.mm.plugin.appbrand.jsapi.f.z());
    ((q)localObject).bf(localArrayList);
    ((q)localObject).b(new com.tencent.mm.plugin.appbrand.jsapi.h5_interact.b());
    ((q)localObject).b(new JsApiOpenAdCanvas());
    ((q)localObject).b(new aq());
    ((q)localObject).b(new com.tencent.mm.plugin.appbrand.jsapi.storage.c());
    ((q)localObject).b(new com.tencent.mm.plugin.appbrand.jsapi.profile.c());
    ((q)localObject).b(new com.tencent.mm.plugin.appbrand.jsapi.profile.a());
    ((q)localObject).b(new com.tencent.mm.plugin.appbrand.jsapi.profile.b());
    ((q)localObject).b(new com.tencent.mm.plugin.appbrand.jsapi.g.a());
    ((q)localObject).b(new aw());
    ((q)localObject).b(new ax());
    ((q)localObject).b(new com.tencent.mm.plugin.appbrand.jsapi.offlinevoice.b());
    ((q)localObject).b(new com.tencent.mm.plugin.appbrand.jsapi.offlinevoice.c());
    ((q)localObject).b(new com.tencent.mm.plugin.appbrand.jsapi.pay.d());
    ((q)localObject).b(new com.tencent.mm.plugin.appbrand.jsapi.pay.f());
    ((q)localObject).b(new com.tencent.mm.plugin.appbrand.jsapi.pay.k());
    ((q)localObject).b(new com.tencent.mm.plugin.appbrand.jsapi.pay.c());
    ((q)localObject).b(new com.tencent.mm.plugin.appbrand.jsapi.pay.p());
    ((q)localObject).b(new com.tencent.mm.plugin.appbrand.jsapi.pay.g());
    ((q)localObject).b(new com.tencent.mm.plugin.appbrand.jsapi.openvoice.a());
    ((q)localObject).b(new com.tencent.mm.plugin.appbrand.jsapi.openvoice.f());
    ((q)localObject).b(new com.tencent.mm.plugin.appbrand.jsapi.openvoice.c());
    ((q)localObject).b(new com.tencent.mm.plugin.appbrand.jsapi.openvoice.b());
    ((q)localObject).b(new com.tencent.mm.plugin.appbrand.jsapi.openvoice.e());
    ((q)localObject).b(new com.tencent.mm.plugin.appbrand.jsapi.openvoice.d());
    ((q)localObject).b(new com.tencent.mm.plugin.appbrand.jsapi.openvoice.g());
    ((q)localObject).b(new com.tencent.mm.plugin.appbrand.jsapi.openvoice.i());
    ((q)localObject).b(new com.tencent.mm.plugin.appbrand.jsapi.openvoice.j());
    ((q)localObject).b(new com.tencent.mm.plugin.appbrand.jsapi.j.j());
    ((q)localObject).b(new JsApiGetABTestConfig());
    ((q)localObject).b(new com.tencent.mm.plugin.appbrand.jsapi.j.h());
    ((q)localObject).b(new com.tencent.mm.plugin.appbrand.jsapi.s.c());
    ((q)localObject).b(new com.tencent.mm.plugin.appbrand.jsapi.s.d());
    ((q)localObject).b(new com.tencent.mm.plugin.appbrand.jsapi.s.a());
    ((q)localObject).b(new com.tencent.mm.plugin.appbrand.jsapi.coverview.g());
    ((q)localObject).b(new com.tencent.mm.plugin.appbrand.jsapi.coverview.o());
    ((q)localObject).b(new com.tencent.mm.plugin.appbrand.jsapi.coverview.k());
    ((q)localObject).b(new com.tencent.mm.plugin.appbrand.jsapi.coverview.e());
    ((q)localObject).b(new com.tencent.mm.plugin.appbrand.jsapi.coverview.m());
    ((q)localObject).b(new com.tencent.mm.plugin.appbrand.jsapi.coverview.i());
    ((q)localObject).b(new com.tencent.mm.plugin.appbrand.jsapi.coverview.f());
    ((q)localObject).b(new com.tencent.mm.plugin.appbrand.jsapi.coverview.n());
    ((q)localObject).b(new com.tencent.mm.plugin.appbrand.jsapi.coverview.j());
    ((q)localObject).b(new com.tencent.mm.plugin.appbrand.jsapi.coverview.c());
    ((q)localObject).b(new com.tencent.mm.plugin.appbrand.jsapi.video.d.a());
    ((q)localObject).b(new com.tencent.mm.plugin.appbrand.jsapi.video.d.e());
    ((q)localObject).b(new com.tencent.mm.plugin.appbrand.jsapi.video.d.d());
    ((q)localObject).b(new com.tencent.mm.plugin.appbrand.jsapi.video.d.b());
    ((q)localObject).b(new com.tencent.mm.plugin.appbrand.jsapi.z.e.b.e());
    ((q)localObject).b(new com.tencent.mm.plugin.appbrand.jsapi.z.e.b.i());
    ((q)localObject).b(new com.tencent.mm.plugin.appbrand.jsapi.z.e.b.h());
    ((q)localObject).b(new com.tencent.mm.plugin.appbrand.jsapi.z.e.b.g());
    ((q)localObject).b(new com.tencent.mm.plugin.appbrand.jsapi.z.c.a.a.e());
    ((q)localObject).b(new com.tencent.mm.plugin.appbrand.jsapi.z.c.a.a.i());
    ((q)localObject).b(new com.tencent.mm.plugin.appbrand.jsapi.z.c.a.a.f());
    ((q)localObject).b(new com.tencent.mm.plugin.appbrand.jsapi.z.c.a.a.h());
    ((q)localObject).b(new com.tencent.mm.plugin.appbrand.jsapi.z.c.a.a.g());
    ((q)localObject).b(new com.tencent.mm.plugin.appbrand.jsapi.z.c.b.a.b());
    ((q)localObject).b(new com.tencent.mm.plugin.appbrand.jsapi.z.c.b.a.e());
    ((q)localObject).b(new com.tencent.mm.plugin.appbrand.jsapi.z.c.b.a.c());
    ((q)localObject).b(new com.tencent.mm.plugin.appbrand.jsapi.z.c.b.a.d());
    ((q)localObject).b(new bu());
    ((q)localObject).b(new com.tencent.mm.plugin.appbrand.jsapi.file.aa());
    ((q)localObject).b(new JsApiPrivateAddContact());
    ((q)localObject).b(new ag());
    ((q)localObject).b(new com.tencent.mm.plugin.appbrand.jsapi.coverview.d());
    ((q)localObject).b(new com.tencent.mm.plugin.appbrand.jsapi.coverview.l());
    ((q)localObject).b(new com.tencent.mm.plugin.appbrand.jsapi.coverview.h());
    ((q)localObject).b(new com.tencent.mm.plugin.appbrand.jsapi.media.e());
    ((q)localObject).b(new com.tencent.mm.plugin.appbrand.jsapi.k.aj());
    ((q)localObject).b(new com.tencent.mm.plugin.appbrand.jsapi.k.w());
    ((q)localObject).b(new com.tencent.mm.plugin.appbrand.jsapi.share.f());
    ((q)localObject).b(new JsApiChooseMultiMedia());
    ((q)localObject).b(new JsApiRequestSubscribeMessage());
    ((q)localObject).b(new bc());
    ((q)localObject).b(new JsApiSetBackgroundFetchToken());
    ((q)localObject).b(new com.tencent.mm.plugin.appbrand.jsapi.backgroundfetch.a());
    ((q)localObject).b(new JsApiTriggerBackgroundFetch());
    ((q)localObject).b(new JsApiAddDownloadTaskForNative());
    ((q)localObject).b(new JsApiPauseDownloadTaskForNative());
    ((q)localObject).b(new JsApiResumeDownloadTaskForNative());
    ((q)localObject).b(new JsApiQueryDownloadTaskForNative());
    ((q)localObject).b(new JsApiInstallDownloadTaskForNative());
    ((q)localObject).b(new JsApiGetInstallStateForNative());
    ((q)localObject).b(new JsApiLaunchApplicationForNative());
    ((q)localObject).b(new JsApiCancelDownloadTaskForNative());
    ((q)localObject).b(new com.tencent.mm.plugin.appbrand.jsapi.appdownload.f());
    ((q)localObject).b(new JsApiJumpDownloaderWidgetForNative());
    ((q)localObject).b(new ci());
    ((q)localObject).b(new com.tencent.mm.plugin.appbrand.jsapi.i.a());
    ((q)localObject).b(new com.tencent.mm.plugin.appbrand.jsapi.r.c());
    ((q)localObject).b(new ce());
    ((q)localObject).bf(com.tencent.mm.plugin.appbrand.jsapi.ui.launcher.d.biW());
    ((q)localObject).b(new bt());
    ((q)localObject).b(new al());
    ((q)localObject).b(new JsApiGetFinderAccount());
    ((q)localObject).b(new com.tencent.mm.plugin.appbrand.jsapi.finder.b());
    ((q)localObject).b(new JsApiPostFinderDataItem());
    ((q)localObject).b(new JsApiDeleteFinderDataItem());
    ((q)localObject).b(new com.tencent.mm.plugin.appbrand.jsapi.finder.c());
    ((q)localObject).b(new com.tencent.mm.plugin.appbrand.jsapi.finder.f());
    ((q)localObject).b(new com.tencent.mm.plugin.appbrand.jsapi.finder.e());
    ((q)localObject).b(new com.tencent.mm.plugin.appbrand.jsapi.finder.g());
    ((q)localObject).b(new com.tencent.mm.plugin.appbrand.jsapi.finder.h());
    ((q)localObject).b(new com.tencent.mm.plugin.appbrand.jsapi.finder.i());
    ((q)localObject).b(new JsApiFetchSendingAndFailProfileFeed());
    ((q)localObject).b(new JsApiResendProfileFeed());
    ((q)localObject).b(new JsApiFinderEndorsementFinished());
    ((q)localObject).b(new com.tencent.mm.plugin.appbrand.jsapi.finder.d());
    ((q)localObject).b(new av());
    ((q)localObject).b(new bz());
    ((q)localObject).b(new bd());
    ((q)localObject).b(new com.tencent.mm.plugin.appbrand.jsapi.k.s());
    ((q)localObject).b(new com.tencent.mm.plugin.appbrand.jsapi.share.h());
    ((q)localObject).b(new by());
    ((q)localObject).b(new JsApiHandleMpChannelAction());
    ((q)localObject).b(new JsApiOpenWebViewUseFastLoad());
    ((q)localObject).b(new com.tencent.mm.plugin.appbrand.jsapi.camera.l());
    ((q)localObject).b(new com.tencent.mm.plugin.appbrand.jsapi.camera.p());
    ((q)localObject).b(new com.tencent.mm.plugin.appbrand.jsapi.camera.o());
    ((q)localObject).b(new JsApiAddToFavorites());
    ((q)localObject).b(new com.tencent.mm.plugin.appbrand.jsapi.share.j());
    ((q)localObject).b(new com.tencent.mm.plugin.appbrand.jsapi.share.m());
    ((q)localObject).b(new com.tencent.mm.plugin.appbrand.jsapi.share.c());
    ((q)localObject).b(new com.tencent.mm.plugin.appbrand.jsapi.share.p());
    ((q)localObject).b(new com.tencent.mm.plugin.appbrand.jsapi.fakenative.e());
    ((q)localObject).b(new com.tencent.mm.plugin.appbrand.jsapi.fakenative.a());
    ((q)localObject).b(new JsApiRemoveSplashScreenshot());
    ((q)localObject).b(new com.tencent.mm.plugin.appbrand.jsapi.pay.i());
    ((q)localObject).b(new JsApiOnWebPageUrlExposed());
    ((q)localObject).b(new JsApiGetRecentUsageList());
    ((q)localObject).b(new JsApiOperateRecentUsageList());
    localObject = ((q)localObject).jWA;
    AppMethodBeat.o(45423);
    return localObject;
  }
  
  public static Map<String, m> beI()
  {
    AppMethodBeat.i(45424);
    Object localObject = new q();
    ((q)localObject).jWz = com.tencent.mm.sdk.platformtools.bs.Gn();
    ((q)localObject).a(new com.tencent.mm.plugin.appbrand.jsapi.profile.c());
    ((q)localObject).a(new bj());
    ((q)localObject).a(new com.tencent.mm.plugin.appbrand.jsapi.u.j());
    ((q)localObject).a(new com.tencent.mm.plugin.appbrand.jsapi.c.h());
    ((q)localObject).a(new com.tencent.mm.plugin.appbrand.jsapi.c.c());
    ((q)localObject).a(new com.tencent.mm.plugin.appbrand.jsapi.c.b());
    ((q)localObject).a(new com.tencent.mm.plugin.appbrand.jsapi.c.i());
    ((q)localObject).a(new com.tencent.mm.plugin.appbrand.jsapi.c.d());
    ((q)localObject).a(new com.tencent.mm.plugin.appbrand.jsapi.c.j());
    ((q)localObject).a(new com.tencent.mm.plugin.appbrand.jsapi.c.e());
    ((q)localObject).a(new com.tencent.mm.plugin.appbrand.jsapi.c.f());
    ((q)localObject).a(new com.tencent.mm.plugin.appbrand.jsapi.k.k());
    ((q)localObject).a(new com.tencent.mm.plugin.appbrand.jsapi.r.d());
    ((q)localObject).a(new com.tencent.mm.plugin.appbrand.jsapi.r.e());
    ((q)localObject).a(new com.tencent.mm.plugin.appbrand.jsapi.r.g());
    ((q)localObject).a(new com.tencent.mm.plugin.appbrand.jsapi.r.f());
    ((q)localObject).a(new bw());
    ((q)localObject).a(new cb());
    ((q)localObject).a(new com.tencent.mm.plugin.appbrand.jsapi.m.f());
    ((q)localObject).a(new com.tencent.mm.plugin.appbrand.jsapi.m.h());
    ((q)localObject).a(new com.tencent.mm.plugin.appbrand.jsapi.k.b());
    ((q)localObject).a(new az());
    ((q)localObject).a(new com.tencent.mm.plugin.appbrand.jsapi.video.d.a());
    ((q)localObject).a(new com.tencent.mm.plugin.appbrand.jsapi.video.d.e());
    ((q)localObject).a(new com.tencent.mm.plugin.appbrand.jsapi.video.d.d());
    ((q)localObject).a(new com.tencent.mm.plugin.appbrand.jsapi.video.d.c());
    ((q)localObject).a(new com.tencent.mm.plugin.appbrand.jsapi.video.d.b());
    ((q)localObject).a(new com.tencent.mm.plugin.appbrand.jsapi.live.b());
    ((q)localObject).a(new com.tencent.mm.plugin.appbrand.jsapi.live.h());
    ((q)localObject).a(new com.tencent.mm.plugin.appbrand.jsapi.live.f());
    ((q)localObject).a(new com.tencent.mm.plugin.appbrand.jsapi.live.d());
    ((q)localObject).a(new com.tencent.mm.plugin.appbrand.jsapi.live.a());
    ((q)localObject).a(new com.tencent.mm.plugin.appbrand.jsapi.live.g());
    ((q)localObject).a(new com.tencent.mm.plugin.appbrand.jsapi.live.e());
    ((q)localObject).a(new com.tencent.mm.plugin.appbrand.jsapi.live.c());
    ((q)localObject).a(new com.tencent.mm.plugin.appbrand.jsapi.z.e.b.e());
    ((q)localObject).a(new com.tencent.mm.plugin.appbrand.jsapi.z.e.b.i());
    ((q)localObject).a(new com.tencent.mm.plugin.appbrand.jsapi.z.e.b.f());
    ((q)localObject).a(new com.tencent.mm.plugin.appbrand.jsapi.z.e.b.h());
    ((q)localObject).a(new com.tencent.mm.plugin.appbrand.jsapi.z.c.a.a.e());
    ((q)localObject).a(new com.tencent.mm.plugin.appbrand.jsapi.z.c.a.a.i());
    ((q)localObject).a(new com.tencent.mm.plugin.appbrand.jsapi.z.c.a.a.f());
    ((q)localObject).a(new com.tencent.mm.plugin.appbrand.jsapi.z.c.a.a.h());
    ((q)localObject).a(new com.tencent.mm.plugin.appbrand.jsapi.z.c.b.a.b());
    ((q)localObject).a(new com.tencent.mm.plugin.appbrand.jsapi.z.c.b.a.e());
    ((q)localObject).a(new com.tencent.mm.plugin.appbrand.jsapi.z.c.b.a.c());
    ((q)localObject).a(new com.tencent.mm.plugin.appbrand.jsapi.z.c.b.a.d());
    ((q)localObject).a(new com.tencent.mm.plugin.appbrand.jsapi.a.f());
    ((q)localObject).a(new com.tencent.mm.plugin.appbrand.jsapi.a.g());
    ((q)localObject).a(new com.tencent.mm.plugin.appbrand.jsapi.a.j());
    ((q)localObject).a(new com.tencent.mm.plugin.appbrand.jsapi.a.l());
    ((q)localObject).a(new com.tencent.mm.plugin.appbrand.jsapi.contact.e());
    ((q)localObject).a(new com.tencent.mm.plugin.appbrand.jsapi.contact.f());
    ((q)localObject).a(new JsApiPrivateAddContact());
    ((q)localObject).a(new bv());
    ((q)localObject).a(new com.tencent.mm.plugin.appbrand.jsapi.k.a());
    ((q)localObject).a(new com.tencent.mm.plugin.appbrand.jsapi.autofill.e());
    ((q)localObject).a(new com.tencent.mm.plugin.appbrand.jsapi.autofill.h());
    ((q)localObject).a(new com.tencent.mm.plugin.appbrand.jsapi.autofill.b());
    ((q)localObject).a(new com.tencent.mm.plugin.appbrand.jsapi.autofill.g());
    ((q)localObject).a(new cd());
    ((q)localObject).a(new com.tencent.mm.plugin.appbrand.jsapi.u.q());
    ((q)localObject).a(new com.tencent.mm.plugin.appbrand.jsapi.container.a());
    ((q)localObject).a(new com.tencent.mm.plugin.appbrand.jsapi.container.c());
    ((q)localObject).a(new com.tencent.mm.plugin.appbrand.jsapi.container.b());
    ((q)localObject).a(new com.tencent.mm.plugin.appbrand.jsapi.autofill.d());
    ((q)localObject).a(new com.tencent.mm.plugin.appbrand.jsapi.autofill.f());
    ((q)localObject).a(new com.tencent.mm.plugin.appbrand.jsapi.m.g());
    ((q)localObject).a(new com.tencent.mm.plugin.appbrand.jsapi.m.d());
    ((q)localObject).a(new com.tencent.mm.plugin.appbrand.jsapi.m.i());
    ((q)localObject).a(new cc());
    ((q)localObject).a(new com.tencent.mm.plugin.appbrand.jsapi.coverview.g());
    ((q)localObject).a(new com.tencent.mm.plugin.appbrand.jsapi.coverview.o());
    ((q)localObject).a(new com.tencent.mm.plugin.appbrand.jsapi.coverview.k());
    ((q)localObject).a(new com.tencent.mm.plugin.appbrand.jsapi.coverview.e());
    ((q)localObject).a(new com.tencent.mm.plugin.appbrand.jsapi.coverview.m());
    ((q)localObject).a(new com.tencent.mm.plugin.appbrand.jsapi.coverview.i());
    ((q)localObject).a(new com.tencent.mm.plugin.appbrand.jsapi.camera.l());
    ((q)localObject).a(new com.tencent.mm.plugin.appbrand.jsapi.camera.p());
    ((q)localObject).a(new com.tencent.mm.plugin.appbrand.jsapi.camera.o());
    ((q)localObject).a(new com.tencent.mm.plugin.appbrand.jsapi.openvoice.b());
    ((q)localObject).a(new com.tencent.mm.plugin.appbrand.jsapi.openvoice.e());
    ((q)localObject).a(new com.tencent.mm.plugin.appbrand.jsapi.openvoice.d());
    ((q)localObject).a(new com.tencent.mm.plugin.appbrand.debugger.e());
    ((q)localObject).a(new com.tencent.mm.plugin.appbrand.jsapi.coverview.c());
    ((q)localObject).a(new com.tencent.mm.plugin.appbrand.jsapi.y.g());
    ((q)localObject).a(new com.tencent.mm.plugin.appbrand.jsapi.y.i());
    ((q)localObject).a(new com.tencent.mm.plugin.appbrand.jsapi.y.h());
    ((q)localObject).a(new com.tencent.mm.plugin.appbrand.jsapi.coverview.d());
    ((q)localObject).a(new com.tencent.mm.plugin.appbrand.jsapi.coverview.l());
    ((q)localObject).a(new com.tencent.mm.plugin.appbrand.jsapi.coverview.h());
    ((q)localObject).a(new com.tencent.mm.plugin.appbrand.jsapi.a.h());
    ((q)localObject).a(new com.tencent.mm.plugin.appbrand.jsapi.a.m());
    ((q)localObject).a(new com.tencent.mm.plugin.appbrand.jsapi.a.k());
    ((q)localObject).a(new com.tencent.mm.plugin.appbrand.jsapi.a.a.a.b());
    ((q)localObject).a(new com.tencent.mm.plugin.appbrand.jsapi.a.a.a.d());
    ((q)localObject).a(new com.tencent.mm.plugin.appbrand.jsapi.a.a.a.c());
    ((q)localObject).a(new com.tencent.mm.plugin.appbrand.jsapi.k.o());
    ((q)localObject).a(new bu());
    ((q)localObject).a(new com.tencent.mm.plugin.appbrand.jsapi.file.aa());
    ((q)localObject).a(new ag());
    ((q)localObject).a(new com.tencent.mm.plugin.appbrand.jsapi.coverview.f());
    ((q)localObject).a(new com.tencent.mm.plugin.appbrand.jsapi.coverview.n());
    ((q)localObject).a(new com.tencent.mm.plugin.appbrand.jsapi.coverview.j());
    ((q)localObject).a(new com.tencent.mm.plugin.appbrand.jsapi.k.v());
    ((q)localObject).a(new com.tencent.mm.plugin.appbrand.jsapi.k.t());
    ((q)localObject).a(new com.tencent.mm.plugin.appbrand.jsapi.k.ac());
    ((q)localObject).a(new com.tencent.mm.plugin.appbrand.jsapi.k.d());
    ((q)localObject).a(new com.tencent.mm.plugin.appbrand.jsapi.k.q());
    ((q)localObject).a(new com.tencent.mm.plugin.appbrand.jsapi.k.p());
    ((q)localObject).bg(com.tencent.mm.plugin.appbrand.jsapi.f.ad.bhg());
    ((q)localObject).a(new com.tencent.mm.plugin.appbrand.jsapi.ui.e());
    ((q)localObject).a(new com.tencent.mm.plugin.appbrand.jsapi.ui.c());
    ((q)localObject).a(new com.tencent.mm.plugin.appbrand.jsapi.k.ab());
    ((q)localObject).a(new com.tencent.mm.plugin.appbrand.jsapi.k.c());
    ((q)localObject).a(new com.tencent.mm.plugin.appbrand.jsapi.ui.f());
    ((q)localObject).a(new com.tencent.mm.plugin.appbrand.jsapi.ui.d());
    ((q)localObject).a(new com.tencent.mm.plugin.appbrand.jsapi.ui.b());
    ((q)localObject).a(new com.tencent.mm.plugin.appbrand.jsapi.miniprogram_navigator.h());
    ((q)localObject).a(new com.tencent.mm.plugin.appbrand.jsapi.miniprogram_navigator.f());
    ((q)localObject).a(new com.tencent.mm.plugin.appbrand.jsapi.pay.n());
    ((q)localObject).a(new com.tencent.mm.plugin.appbrand.jsapi.pay.l());
    ((q)localObject).a(new com.tencent.mm.plugin.appbrand.jsapi.k.u());
    ((q)localObject).a(new com.tencent.mm.plugin.appbrand.ab.h());
    ((q)localObject).a(new JsApiOperateWXData());
    ((q)localObject).a(new JsApiLogin());
    ((q)localObject).a(new JsApiAuthorize());
    ((q)localObject).a(new com.tencent.mm.plugin.appbrand.jsapi.u.h());
    ((q)localObject).a(new com.tencent.mm.plugin.appbrand.jsapi.u.n());
    ((q)localObject).a(new com.tencent.mm.plugin.appbrand.jsapi.u.k());
    ((q)localObject).a(new com.tencent.mm.plugin.appbrand.jsapi.u.o());
    ((q)localObject).a(new com.tencent.mm.plugin.appbrand.jsapi.k.ah());
    ((q)localObject).a(new com.tencent.mm.plugin.appbrand.jsapi.storage.d());
    ((q)localObject).a(new com.tencent.mm.plugin.appbrand.jsapi.storage.j());
    ((q)localObject).a(new com.tencent.mm.plugin.appbrand.jsapi.storage.m());
    ((q)localObject).a(new com.tencent.mm.plugin.appbrand.jsapi.storage.e());
    ((q)localObject).a(new be());
    ((q)localObject).a(new com.tencent.mm.plugin.appbrand.jsapi.z.d.a.b());
    ((q)localObject).a(new com.tencent.mm.plugin.appbrand.jsapi.z.d.a.d());
    ((q)localObject).a(new com.tencent.mm.plugin.appbrand.jsapi.z.d.a.c());
    ((q)localObject).a(new JsApiShowImageOperateSheet());
    ((q)localObject).a(new com.tencent.mm.plugin.appbrand.jsapi.z.a.a.b());
    ((q)localObject).a(new com.tencent.mm.plugin.appbrand.jsapi.z.a.a.d());
    ((q)localObject).a(new com.tencent.mm.plugin.appbrand.jsapi.z.a.a.c());
    if (!com.tencent.mm.plugin.appbrand.xweb_ext.c.bBO()) {}
    for (boolean bool = true;; bool = false)
    {
      ((q)localObject).bg(com.tencent.mm.plugin.appbrand.jsapi.z.b.c.gO(bool));
      ((q)localObject).bg(com.tencent.mm.plugin.appbrand.jsapi.ui.launcher.d.biW());
      ((q)localObject).a(new com.tencent.mm.plugin.appbrand.jsapi.q.b());
      ((q)localObject).a(new bt());
      ((q)localObject).a(new av());
      ((q)localObject).a(new bz());
      ((q)localObject).a(new com.tencent.mm.plugin.appbrand.jsapi.file.w());
      ((q)localObject).a(new com.tencent.mm.plugin.appbrand.jsapi.k.aj());
      ((q)localObject).a(new com.tencent.mm.plugin.appbrand.jsapi.k.w());
      ((q)localObject).a(new com.tencent.mm.plugin.appbrand.jsapi.s.a());
      ((q)localObject).a(new JsApiOnWebPageUrlExposed());
      localObject = ((q)localObject).jWB;
      AppMethodBeat.o(45424);
      return localObject;
    }
  }
  
  private void bf(List<m> paramList)
  {
    AppMethodBeat.i(45425);
    if ((paramList == null) || (paramList.size() <= 0))
    {
      AppMethodBeat.o(45425);
      return;
    }
    paramList = paramList.iterator();
    while (paramList.hasNext()) {
      b((m)paramList.next());
    }
    AppMethodBeat.o(45425);
  }
  
  private void bg(List<m> paramList)
  {
    AppMethodBeat.i(45427);
    if ((paramList == null) || (paramList.size() <= 0))
    {
      AppMethodBeat.o(45427);
      return;
    }
    paramList = paramList.iterator();
    while (paramList.hasNext()) {
      a((m)paramList.next());
    }
    AppMethodBeat.o(45427);
  }
  
  private static String c(m paramm)
  {
    AppMethodBeat.i(45429);
    paramm = String.format(Locale.US, "[%s->%s]", new Object[] { paramm.getName(), paramm.getClass().getSimpleName() });
    AppMethodBeat.o(45429);
    return paramm;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.q
 * JD-Core Version:    0.7.0.1
 */