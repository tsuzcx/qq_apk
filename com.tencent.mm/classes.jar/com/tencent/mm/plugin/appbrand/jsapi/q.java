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
import com.tencent.mm.plugin.appbrand.jsapi.bio.face.JsApiCheckIsSupportFaceDetect;
import com.tencent.mm.plugin.appbrand.jsapi.bio.soter.JsApiCheckBioEnrollment;
import com.tencent.mm.plugin.appbrand.jsapi.bio.soter.JsApiCheckIsSupportSoterAuthentication;
import com.tencent.mm.plugin.appbrand.jsapi.camera.AppBrandCameraView;
import com.tencent.mm.plugin.appbrand.jsapi.contact.JsApiChooseWeChatContact;
import com.tencent.mm.plugin.appbrand.jsapi.file.JsApiOpenDocument;
import com.tencent.mm.plugin.appbrand.jsapi.file.ai;
import com.tencent.mm.plugin.appbrand.jsapi.file.ak;
import com.tencent.mm.plugin.appbrand.jsapi.file.am;
import com.tencent.mm.plugin.appbrand.jsapi.lab.JsApiGetLabInfo;
import com.tencent.mm.plugin.appbrand.jsapi.lab.JsApiSetLabInfo;
import com.tencent.mm.plugin.appbrand.jsapi.media.JsApiChooseImage;
import com.tencent.mm.plugin.appbrand.jsapi.media.JsApiChooseMedia;
import com.tencent.mm.plugin.appbrand.jsapi.media.JsApiChooseMultiMedia;
import com.tencent.mm.plugin.appbrand.jsapi.media.JsApiUploadEncryptedFileToCDN;
import com.tencent.mm.plugin.appbrand.jsapi.miniprogram_navigator.JsApiLaunchMiniProgram;
import com.tencent.mm.plugin.appbrand.jsapi.miniprogram_navigator.JsApiNavigateToDevMiniProgram;
import com.tencent.mm.plugin.appbrand.jsapi.nfc.hce.HCEService;
import com.tencent.mm.plugin.appbrand.jsapi.share.JsApiShowUpdatableMessageSubscribeButton;
import com.tencent.mm.plugin.appbrand.jsapi.version.JsApiUpdateApp;
import com.tencent.mm.plugin.appbrand.jsapi.video.AppBrandVideoWrapper;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;

public final class q
{
  private final Map<String, m> hxe;
  private final Map<String, m> hxf;
  
  static
  {
    AppMethodBeat.i(130370);
    AppBrandVideoWrapper.aCz();
    AppBrandCameraView.aCz();
    bv.aBH();
    AppMethodBeat.o(130370);
  }
  
  private q()
  {
    AppMethodBeat.i(130362);
    this.hxe = new HashMap();
    this.hxf = new HashMap();
    AppMethodBeat.o(130362);
  }
  
  private void a(m paramm)
  {
    AppMethodBeat.i(130366);
    if ((paramm == null) || (com.tencent.mm.sdk.platformtools.bo.isNullOrNil(paramm.getName())))
    {
      AppMethodBeat.o(130366);
      return;
    }
    if ((m)this.hxe.put(paramm.getName(), paramm) != null)
    {
      paramm = new IllegalAccessError("Duplicated api instance " + c(paramm));
      AppMethodBeat.o(130366);
      throw paramm;
    }
    AppMethodBeat.o(130366);
  }
  
  public static Map<String, m> aBx()
  {
    AppMethodBeat.i(130363);
    Object localObject = new q();
    ((q)localObject).a(new com.tencent.mm.plugin.appbrand.jsapi.storage.a());
    ((q)localObject).a(new com.tencent.mm.plugin.appbrand.jsapi.storage.f());
    ((q)localObject).a(new com.tencent.mm.plugin.appbrand.jsapi.storage.n());
    ((q)localObject).a(new com.tencent.mm.plugin.appbrand.jsapi.storage.b());
    ((q)localObject).a(new com.tencent.mm.plugin.appbrand.jsapi.storage.i());
    ((q)localObject).a(new com.tencent.mm.plugin.appbrand.jsapi.storage.o());
    ((q)localObject).a(new JsApiLogin());
    ((q)localObject).a(new JsApiAuthorize());
    ((q)localObject).a(new JsApiOperateWXData());
    ((q)localObject).a(new com.tencent.mm.plugin.appbrand.jsapi.l.s());
    ((q)localObject).a(new com.tencent.mm.plugin.appbrand.jsapi.l.h());
    ((q)localObject).a(new com.tencent.mm.plugin.appbrand.jsapi.l.l());
    ((q)localObject).a(new com.tencent.mm.plugin.appbrand.jsapi.l.g());
    ((q)localObject).a(new bj());
    ((q)localObject).a(new JsApiChooseImage());
    ((q)localObject).a(new com.tencent.mm.plugin.appbrand.jsapi.media.i());
    ((q)localObject).a(new com.tencent.mm.plugin.appbrand.jsapi.media.g());
    ((q)localObject).a(new com.tencent.mm.plugin.appbrand.jsapi.media.f());
    ((q)localObject).a(new JsApiStartRecordVoice());
    ((q)localObject).a(new JsApiStopRecordVoice());
    ((q)localObject).a(new JsApiStartPlayVoice());
    ((q)localObject).a(new JsApiPausePlayVoice());
    ((q)localObject).a(new JsApiStopPlayVoice());
    ((q)localObject).a(new com.tencent.mm.plugin.appbrand.jsapi.e.h());
    ((q)localObject).a(new com.tencent.mm.plugin.appbrand.jsapi.e.j());
    ((q)localObject).a(new com.tencent.mm.plugin.appbrand.jsapi.r.e());
    ((q)localObject).a(new JsApiGetMusicPlayerState());
    ((q)localObject).a(new JsApiOperateMusicPlayer());
    ((q)localObject).a(new JsApiScanCode());
    ((q)localObject).a(new bc());
    ((q)localObject).a(new com.tencent.mm.plugin.appbrand.jsapi.m.e());
    ((q)localObject).a(new av());
    ((q)localObject).a(new com.tencent.mm.plugin.appbrand.jsapi.p.e());
    ((q)localObject).a(new com.tencent.mm.plugin.appbrand.jsapi.m.i());
    ((q)localObject).a(new com.tencent.mm.plugin.appbrand.jsapi.m.c());
    ((q)localObject).a(new com.tencent.mm.plugin.appbrand.jsapi.contact.c());
    ((q)localObject).a(new com.tencent.mm.plugin.appbrand.jsapi.contact.g());
    ((q)localObject).a(new com.tencent.mm.plugin.appbrand.jsapi.l.ac());
    ((q)localObject).a(new com.tencent.mm.plugin.appbrand.jsapi.l.z());
    ((q)localObject).a(new com.tencent.mm.plugin.appbrand.jsapi.l.d());
    ((q)localObject).a(new com.tencent.mm.plugin.appbrand.jsapi.l.y());
    ((q)localObject).a(new com.tencent.mm.plugin.appbrand.jsapi.l.c());
    ((q)localObject).a(new com.tencent.mm.plugin.appbrand.jsapi.b.e());
    ((q)localObject).a(new com.tencent.mm.plugin.appbrand.jsapi.share.c());
    ((q)localObject).a(new com.tencent.mm.plugin.appbrand.jsapi.share.f());
    ((q)localObject).a(new com.tencent.luggage.game.e.e());
    ((q)localObject).a(new com.tencent.mm.plugin.appbrand.jsapi.p.f());
    ((q)localObject).a(new com.tencent.mm.plugin.appbrand.jsapi.p.h());
    ((q)localObject).a(new com.tencent.mm.plugin.appbrand.jsapi.p.g());
    ((q)localObject).a(new bo());
    ((q)localObject).a(new com.tencent.mm.plugin.appbrand.jsapi.d.g());
    ((q)localObject).a(new ap());
    ((q)localObject).a(new com.tencent.mm.plugin.appbrand.jsapi.d.c());
    ((q)localObject).a(new com.tencent.mm.plugin.appbrand.jsapi.q.b());
    ((q)localObject).a(new com.tencent.mm.plugin.appbrand.jsapi.q.c());
    ((q)localObject).a(new com.tencent.mm.plugin.appbrand.jsapi.q.f());
    ((q)localObject).a(new com.tencent.mm.plugin.appbrand.jsapi.q.d());
    ((q)localObject).a(new com.tencent.mm.plugin.appbrand.jsapi.q.e());
    ((q)localObject).a(new com.tencent.mm.plugin.appbrand.jsapi.storage.k());
    ((q)localObject).a(new com.tencent.mm.plugin.appbrand.jsapi.storage.l());
    ((q)localObject).a(new com.tencent.mm.plugin.appbrand.jsapi.v.a.a.f());
    ((q)localObject).a(new com.tencent.mm.plugin.appbrand.jsapi.b.d());
    ((q)localObject).a(new com.tencent.mm.plugin.appbrand.jsapi.o.c());
    ((q)localObject).a(new com.tencent.mm.plugin.appbrand.jsapi.o.b());
    ((q)localObject).a(new com.tencent.mm.plugin.appbrand.jsapi.o.d());
    ((q)localObject).a(new com.tencent.mm.plugin.appbrand.jsapi.o.a());
    ((q)localObject).a(new aj());
    ((q)localObject).a(new at());
    ((q)localObject).a(new com.tencent.mm.plugin.appbrand.jsapi.storage.g());
    ((q)localObject).a(new com.tencent.mm.plugin.appbrand.jsapi.storage.h());
    ((q)localObject).a(new com.tencent.mm.plugin.appbrand.jsapi.e.c());
    ((q)localObject).a(new com.tencent.mm.plugin.appbrand.jsapi.media.h());
    ((q)localObject).a(new JsApiRefreshSession());
    ((q)localObject).a(new com.tencent.mm.plugin.appbrand.jsapi.l.ad());
    ((q)localObject).a(new com.tencent.mm.plugin.appbrand.jsapi.m.f());
    ((q)localObject).a(new com.tencent.mm.plugin.appbrand.jsapi.share.g());
    ((q)localObject).a(new com.tencent.mm.plugin.appbrand.weishi.h());
    ((q)localObject).a(new ab());
    ((q)localObject).a(new aw());
    ((q)localObject).a(new JsApiMakeVoIPCall());
    ((q)localObject).a(new com.tencent.mm.plugin.appbrand.jsapi.r.c());
    ((q)localObject).a(new JsApiSetClipboardDataWC());
    ((q)localObject).a(new com.tencent.mm.plugin.appbrand.jsapi.bluetooth.m());
    ((q)localObject).a(new com.tencent.mm.plugin.appbrand.jsapi.bluetooth.e());
    ((q)localObject).a(new com.tencent.mm.plugin.appbrand.jsapi.bluetooth.i());
    ((q)localObject).a(new com.tencent.mm.plugin.appbrand.jsapi.bluetooth.o());
    ((q)localObject).a(new com.tencent.mm.plugin.appbrand.jsapi.bluetooth.p());
    ((q)localObject).a(new com.tencent.mm.plugin.appbrand.jsapi.bluetooth.j());
    ((q)localObject).a(new com.tencent.mm.plugin.appbrand.jsapi.bluetooth.f());
    ((q)localObject).a(new com.tencent.mm.plugin.appbrand.jsapi.bluetooth.d());
    ((q)localObject).a(new com.tencent.mm.plugin.appbrand.jsapi.bluetooth.h());
    ((q)localObject).a(new com.tencent.mm.plugin.appbrand.jsapi.bluetooth.g());
    ((q)localObject).a(new com.tencent.mm.plugin.appbrand.jsapi.bluetooth.n());
    ((q)localObject).a(new com.tencent.mm.plugin.appbrand.jsapi.bluetooth.q());
    ((q)localObject).a(new com.tencent.mm.plugin.appbrand.jsapi.bluetooth.l());
    ((q)localObject).a(new com.tencent.mm.plugin.appbrand.jsapi.bluetooth.k());
    ((q)localObject).a(new JsApiLaunchMiniProgram());
    ((q)localObject).a(new com.tencent.mm.plugin.appbrand.jsapi.l.k());
    ((q)localObject).a(new JsApiChooseWeChatContact());
    ((q)localObject).a(new JsApiChooseMedia());
    ((q)localObject).a(new JsApiUploadEncryptedFileToCDN());
    ((q)localObject).a(new com.tencent.mm.plugin.appbrand.jsapi.miniprogram_navigator.d());
    ((q)localObject).a(new bd());
    ((q)localObject).a(new bq());
    ((q)localObject).a(new JsApiGetBackgroundAudioState());
    ((q)localObject).a(new JsApiSetBackgroundAudioStateWC());
    ((q)localObject).a(new com.tencent.mm.plugin.appbrand.jsapi.audio.h());
    ((q)localObject).a(new com.tencent.mm.plugin.appbrand.jsapi.share.h());
    ((q)localObject).a(new com.tencent.mm.plugin.appbrand.jsapi.share.b());
    ((q)localObject).a(new be());
    ((q)localObject).a(new com.tencent.mm.plugin.appbrand.jsapi.m.h());
    ((q)localObject).a(new com.tencent.mm.plugin.appbrand.jsapi.contact.b());
    ((q)localObject).a(new JsApiOpenWeRunSetting());
    ((q)localObject).a(new JsApiUploadWeRunData());
    ((q)localObject).a(new ac());
    ((q)localObject).a(new com.tencent.mm.plugin.appbrand.jsapi.r.f());
    ((q)localObject).a(new com.tencent.mm.plugin.appbrand.jsapi.r.k());
    ((q)localObject).a(new com.tencent.mm.plugin.appbrand.jsapi.r.m());
    ((q)localObject).a(new com.tencent.mm.plugin.appbrand.jsapi.r.n());
    ((q)localObject).a(new com.tencent.mm.plugin.appbrand.jsapi.share.j());
    ((q)localObject).a(new com.tencent.mm.plugin.appbrand.jsapi.share.i());
    ((q)localObject).a(new com.tencent.mm.plugin.appbrand.jsapi.share.k());
    ((q)localObject).a(new JsApiShowUpdatableMessageSubscribeButton());
    ((q)localObject).a(new com.tencent.mm.plugin.appbrand.jsapi.c.b());
    ((q)localObject).a(new com.tencent.mm.plugin.appbrand.jsapi.c.c());
    ((q)localObject).a(new com.tencent.mm.plugin.appbrand.jsapi.c.d());
    ((q)localObject).a(new JsApiCheckIsSupportFaceDetect());
    ((q)localObject).a(new com.tencent.mm.plugin.appbrand.jsapi.bio.face.e());
    ((q)localObject).a(new com.tencent.mm.plugin.appbrand.jsapi.bio.face.d());
    ((q)localObject).a(new com.tencent.mm.plugin.appbrand.jsapi.bio.face.f());
    ((q)localObject).a(new com.tencent.mm.plugin.appbrand.jsapi.bio.face.b());
    ((q)localObject).a(new com.tencent.mm.plugin.appbrand.jsapi.bio.face.c());
    ((q)localObject).a(new com.tencent.mm.plugin.appbrand.jsapi.v.d.a.c());
    ((q)localObject).a(new com.tencent.mm.plugin.appbrand.jsapi.video.h());
    ((q)localObject).a(new com.tencent.mm.plugin.appbrand.jsapi.live.d());
    ((q)localObject).a(new com.tencent.mm.plugin.appbrand.jsapi.live.c());
    ((q)localObject).a(new com.tencent.mm.plugin.appbrand.jsapi.media.j());
    ((q)localObject).a(new com.tencent.mm.plugin.appbrand.jsapi.media.k());
    ((q)localObject).a(new aq());
    ((q)localObject).a(new az());
    ((q)localObject).a(new com.tencent.mm.plugin.appbrand.jsapi.share.d());
    ((q)localObject).a(new com.tencent.mm.plugin.appbrand.jsapi.ui.c());
    ((q)localObject).a(new com.tencent.mm.plugin.appbrand.jsapi.r.j());
    ((q)localObject).a(new ae());
    ((q)localObject).a(new com.tencent.mm.plugin.appbrand.jsapi.b.h());
    ((q)localObject).a(new com.tencent.mm.plugin.appbrand.jsapi.miniprogram_navigator.g());
    ((q)localObject).a(new com.tencent.mm.plugin.appbrand.jsapi.fakenative.b());
    ((q)localObject).a(new com.tencent.mm.plugin.appbrand.jsapi.fakenative.c());
    ((q)localObject).a(new com.tencent.mm.plugin.appbrand.jsapi.fakenative.a());
    ((q)localObject).a(new com.tencent.mm.plugin.appbrand.jsapi.op_report.b());
    ((q)localObject).a(new com.tencent.mm.plugin.appbrand.jsapi.l.r());
    ((q)localObject).a(new com.tencent.mm.plugin.appbrand.jsapi.l.af());
    ((q)localObject).a(new bn());
    ((q)localObject).a(new com.tencent.mm.plugin.appbrand.jsapi.l.u());
    ((q)localObject).a(new bp());
    ((q)localObject).a(new com.tencent.mm.plugin.appbrand.jsapi.l.q());
    ((q)localObject).a(new JsApiCheckIsSupportSoterAuthentication());
    ((q)localObject).a(new com.tencent.mm.plugin.appbrand.jsapi.bio.soter.c());
    ((q)localObject).a(new ag());
    ((q)localObject).a(new af());
    ((q)localObject).a(new com.tencent.mm.plugin.appbrand.jsapi.j.e());
    ((q)localObject).a(new com.tencent.mm.plugin.appbrand.jsapi.j.j());
    ((q)localObject).a(new com.tencent.mm.plugin.appbrand.jsapi.j.d());
    ((q)localObject).a(new com.tencent.mm.plugin.appbrand.jsapi.j.h());
    ((q)localObject).a(new com.tencent.mm.plugin.appbrand.jsapi.j.g());
    ((q)localObject).a(new com.tencent.mm.plugin.appbrand.jsapi.j.l());
    ((q)localObject).a(new br());
    ((q)localObject).a(new JsApiBatchGetContact());
    ((q)localObject).a(new com.tencent.mm.plugin.appbrand.jsapi.camera.l());
    ((q)localObject).a(new com.tencent.mm.plugin.appbrand.jsapi.l.ab());
    ((q)localObject).a(new com.tencent.mm.plugin.appbrand.jsapi.audio.i());
    ((q)localObject).a(new com.tencent.mm.plugin.appbrand.jsapi.t.a.f());
    ((q)localObject).a(new com.tencent.mm.plugin.appbrand.jsapi.audio.d());
    ((q)localObject).a(new com.tencent.mm.plugin.appbrand.jsapi.audio.k());
    ((q)localObject).a(new com.tencent.mm.plugin.appbrand.jsapi.audio.f());
    ((q)localObject).a(new com.tencent.mm.plugin.appbrand.jsapi.audio.g());
    ((q)localObject).a(new com.tencent.mm.plugin.appbrand.jsapi.audio.e());
    ((q)localObject).a(new com.tencent.mm.plugin.appbrand.jsapi.audio.l());
    ((q)localObject).a(new JsApiNavigateBackApplication());
    ((q)localObject).a(new com.tencent.mm.plugin.appbrand.jsapi.e.e());
    ((q)localObject).a(new JsApiCheckBioEnrollment());
    ((q)localObject).a(new com.tencent.mm.plugin.appbrand.jsapi.wifi.d());
    ((q)localObject).a(new com.tencent.mm.plugin.appbrand.jsapi.wifi.e());
    ((q)localObject).a(new com.tencent.mm.plugin.appbrand.jsapi.wifi.c());
    ((q)localObject).a(new com.tencent.mm.plugin.appbrand.jsapi.wifi.b());
    ((q)localObject).a(new com.tencent.mm.plugin.appbrand.jsapi.wifi.a());
    ((q)localObject).a(new JsApiNavigateToDevMiniProgram());
    ((q)localObject).a(new com.tencent.mm.plugin.appbrand.jsapi.nfc.d(HCEService.class));
    ((q)localObject).a(new com.tencent.mm.plugin.appbrand.jsapi.nfc.e());
    ((q)localObject).a(new com.tencent.mm.plugin.appbrand.jsapi.nfc.c());
    ((q)localObject).a(new com.tencent.mm.plugin.appbrand.jsapi.nfc.b());
    ((q)localObject).a(new com.tencent.mm.plugin.appbrand.jsapi.l.v());
    ((q)localObject).a(new com.tencent.mm.plugin.appbrand.jsapi.l.x());
    ((q)localObject).a(new com.tencent.mm.plugin.appbrand.jsapi.l.w());
    ((q)localObject).a(new com.tencent.mm.plugin.appbrand.jsapi.l.e());
    ((q)localObject).a(new com.tencent.mm.plugin.appbrand.jsapi.l.aa());
    ((q)localObject).a(new com.tencent.mm.plugin.appbrand.jsapi.ui.d());
    ((q)localObject).a(new com.tencent.mm.plugin.appbrand.jsapi.ui.a());
    ((q)localObject).a(new com.tencent.mm.plugin.appbrand.jsapi.ui.e());
    ((q)localObject).a(new com.tencent.mm.plugin.appbrand.jsapi.ui.b());
    ((q)localObject).a(new com.tencent.mm.plugin.appbrand.jsapi.r.h());
    ((q)localObject).a(new com.tencent.mm.plugin.appbrand.jsapi.r.l());
    ((q)localObject).a(new com.tencent.mm.plugin.appbrand.jsapi.l.ae());
    ((q)localObject).a(new com.tencent.mm.plugin.appbrand.jsapi.j.f(com.tencent.mm.plugin.appbrand.jsapi.j.f.hTT, com.tencent.mm.plugin.appbrand.ah.aun()));
    ((q)localObject).a(new com.tencent.mm.plugin.appbrand.jsapi.j.k(com.tencent.mm.plugin.appbrand.ah.aun()));
    ((q)localObject).a(new com.tencent.mm.plugin.appbrand.jsapi.m.g());
    ((q)localObject).a(new com.tencent.mm.plugin.appbrand.jsapi.l.p());
    ((q)localObject).a(new com.tencent.mm.plugin.appbrand.jsapi.j.c());
    ((q)localObject).a(new com.tencent.mm.plugin.appbrand.jsapi.file.ag());
    ((q)localObject).a(new com.tencent.mm.plugin.appbrand.jsapi.file.ah());
    ((q)localObject).a(new com.tencent.mm.plugin.appbrand.jsapi.file.q());
    ((q)localObject).a(new com.tencent.mm.plugin.appbrand.jsapi.file.r());
    ((q)localObject).a(new com.tencent.mm.plugin.appbrand.jsapi.file.s());
    ((q)localObject).a(new com.tencent.mm.plugin.appbrand.jsapi.file.ab());
    ((q)localObject).a(new com.tencent.mm.plugin.appbrand.jsapi.file.aa());
    ((q)localObject).a(new am());
    ((q)localObject).a(new com.tencent.mm.plugin.appbrand.jsapi.file.w());
    ((q)localObject).a(new com.tencent.mm.plugin.appbrand.jsapi.file.y());
    ((q)localObject).a(new com.tencent.mm.plugin.appbrand.jsapi.file.af());
    ((q)localObject).a(new com.tencent.mm.plugin.appbrand.jsapi.file.j());
    ((q)localObject).a(new com.tencent.mm.plugin.appbrand.jsapi.file.aj());
    ((q)localObject).a(new com.tencent.mm.plugin.appbrand.jsapi.file.u());
    ((q)localObject).a(new com.tencent.mm.plugin.appbrand.jsapi.file.p());
    ((q)localObject).a(new JsApiOpenDocument());
    ((q)localObject).a(new com.tencent.mm.plugin.appbrand.jsapi.file.z());
    ((q)localObject).a(new com.tencent.mm.plugin.appbrand.jsapi.file.al());
    ((q)localObject).a(new com.tencent.mm.plugin.appbrand.jsapi.file.v());
    ((q)localObject).a(new com.tencent.mm.plugin.appbrand.jsapi.file.x());
    ((q)localObject).a(new com.tencent.mm.plugin.appbrand.jsapi.file.ae());
    ((q)localObject).a(new com.tencent.mm.plugin.appbrand.jsapi.file.i());
    ((q)localObject).a(new ai());
    ((q)localObject).a(new com.tencent.mm.plugin.appbrand.jsapi.file.t());
    ((q)localObject).a(new com.tencent.mm.plugin.appbrand.jsapi.file.o());
    ((q)localObject).a(new ak());
    ((q)localObject).a(new com.tencent.mm.plugin.appbrand.jsapi.file.m());
    ((q)localObject).a(new com.tencent.mm.plugin.appbrand.jsapi.file.n());
    ((q)localObject).a(new com.tencent.mm.plugin.appbrand.jsapi.file.ac());
    ((q)localObject).a(new com.tencent.mm.plugin.appbrand.jsapi.file.ad());
    ((q)localObject).a(new com.tencent.mm.plugin.appbrand.jsapi.file.k());
    ((q)localObject).a(new com.tencent.mm.plugin.appbrand.jsapi.file.l());
    ((q)localObject).a(new JsApiGetLabInfo());
    ((q)localObject).a(new JsApiSetLabInfo());
    ((q)localObject).a(new JsApiUpdateApp());
    ((q)localObject).a(new com.tencent.mm.plugin.appbrand.jsapi.b.a());
    ((q)localObject).a(new com.tencent.mm.plugin.appbrand.jsapi.b.b());
    ((q)localObject).a(new bb());
    ((q)localObject).a(new ax());
    ((q)localObject).a(new ay());
    ((q)localObject).a(new bf());
    ((q)localObject).a(new bg());
    ((q)localObject).a(new bh());
    ((q)localObject).a(new bi());
    ((q)localObject).a(new com.tencent.mm.plugin.appbrand.jsapi.r.b());
    ((q)localObject).a(new JsApiLaunchApplication());
    ((q)localObject).a(new JsApiLaunchApplicationDirectly());
    ((q)localObject).a(new JsApiAddNativeDownloadTask());
    ((q)localObject).a(new com.tencent.mm.plugin.appbrand.jsapi.m.d());
    ((q)localObject).a(new JsApiAddDownloadTask());
    ((q)localObject).a(new JsApiAddDownloadTaskStraight());
    ((q)localObject).a(new JsApiQueryDownloadTask());
    ((q)localObject).a(new JsApiInstallDownloadTask());
    ((q)localObject).a(new JsApiPauseDownloadTask());
    ((q)localObject).a(new JsApiResumeDownloadTask());
    ((q)localObject).a(new JsApiGetInstallState());
    ((q)localObject).a(new JsApiCancelDownloadTask());
    ((q)localObject).a(new JsApiWriteCommData());
    ((q)localObject).a(new al());
    ((q)localObject).a(new com.tencent.mm.plugin.appbrand.jsapi.l.n());
    ((q)localObject).a(new com.tencent.mm.plugin.appbrand.jsapi.l.o());
    ((q)localObject).a(new com.tencent.mm.plugin.appbrand.jsapi.f.a());
    ((q)localObject).a(new com.tencent.mm.plugin.appbrand.jsapi.f.b());
    ((q)localObject).aG(com.tencent.mm.plugin.appbrand.jsapi.g.w.aDp());
    ((q)localObject).a(new com.tencent.mm.plugin.appbrand.jsapi.h5_interact.b());
    ((q)localObject).a(new JsApiOpenAdCanvas());
    ((q)localObject).a(new ah());
    ((q)localObject).a(new com.tencent.mm.plugin.appbrand.jsapi.storage.c());
    ((q)localObject).a(new com.tencent.mm.plugin.appbrand.jsapi.profile.c());
    ((q)localObject).a(new com.tencent.mm.plugin.appbrand.jsapi.profile.a());
    ((q)localObject).a(new com.tencent.mm.plugin.appbrand.jsapi.profile.b());
    ((q)localObject).a(new com.tencent.mm.plugin.appbrand.jsapi.h.a());
    ((q)localObject).a(new an());
    ((q)localObject).a(new com.tencent.mm.plugin.appbrand.jsapi.offlinevoice.b());
    ((q)localObject).a(new com.tencent.mm.plugin.appbrand.jsapi.offlinevoice.c());
    ((q)localObject).a(new com.tencent.mm.plugin.appbrand.jsapi.k.a());
    ((q)localObject).a(new com.tencent.mm.plugin.appbrand.jsapi.k.f());
    ((q)localObject).a(new com.tencent.mm.plugin.appbrand.jsapi.k.c());
    ((q)localObject).a(new com.tencent.mm.plugin.appbrand.jsapi.k.b());
    ((q)localObject).a(new com.tencent.mm.plugin.appbrand.jsapi.k.e());
    ((q)localObject).a(new com.tencent.mm.plugin.appbrand.jsapi.k.d());
    ((q)localObject).a(new com.tencent.mm.plugin.appbrand.jsapi.j.m());
    ((q)localObject).a(new JsApiGetABTestConfig());
    ((q)localObject).a(new com.tencent.mm.plugin.appbrand.jsapi.j.i());
    ((q)localObject).a(new com.tencent.mm.plugin.appbrand.jsapi.coverview.e());
    ((q)localObject).a(new com.tencent.mm.plugin.appbrand.jsapi.coverview.k());
    ((q)localObject).a(new com.tencent.mm.plugin.appbrand.jsapi.coverview.h());
    ((q)localObject).a(new com.tencent.mm.plugin.appbrand.jsapi.coverview.c());
    ((q)localObject).a(new com.tencent.mm.plugin.appbrand.jsapi.coverview.i());
    ((q)localObject).a(new com.tencent.mm.plugin.appbrand.jsapi.coverview.f());
    ((q)localObject).a(new com.tencent.mm.plugin.appbrand.jsapi.coverview.d());
    ((q)localObject).a(new com.tencent.mm.plugin.appbrand.jsapi.coverview.j());
    ((q)localObject).a(new com.tencent.mm.plugin.appbrand.jsapi.coverview.g());
    ((q)localObject).a(new com.tencent.mm.plugin.appbrand.jsapi.coverview.b());
    ((q)localObject).a(new com.tencent.mm.plugin.appbrand.jsapi.video.f());
    ((q)localObject).a(new com.tencent.mm.plugin.appbrand.jsapi.video.j());
    ((q)localObject).a(new com.tencent.mm.plugin.appbrand.jsapi.video.i());
    ((q)localObject).a(new com.tencent.mm.plugin.appbrand.jsapi.video.g());
    ((q)localObject).a(new com.tencent.mm.plugin.appbrand.jsapi.v.d.a.b());
    ((q)localObject).a(new com.tencent.mm.plugin.appbrand.jsapi.v.d.a.e());
    ((q)localObject).a(new com.tencent.mm.plugin.appbrand.jsapi.v.d.a.d());
    ((q)localObject).a(new com.tencent.mm.plugin.appbrand.jsapi.v.b.a.a.b());
    ((q)localObject).a(new com.tencent.mm.plugin.appbrand.jsapi.v.b.a.a.e());
    ((q)localObject).a(new com.tencent.mm.plugin.appbrand.jsapi.v.b.a.a.c());
    ((q)localObject).a(new com.tencent.mm.plugin.appbrand.jsapi.v.b.a.a.d());
    ((q)localObject).a(new com.tencent.mm.plugin.appbrand.jsapi.v.b.b.a.b());
    ((q)localObject).a(new com.tencent.mm.plugin.appbrand.jsapi.v.b.b.a.e());
    ((q)localObject).a(new com.tencent.mm.plugin.appbrand.jsapi.v.b.b.a.c());
    ((q)localObject).a(new com.tencent.mm.plugin.appbrand.jsapi.v.b.b.a.d());
    ((q)localObject).a(new bk());
    ((q)localObject).a(new JsApiPrivateAddContact());
    ((q)localObject).a(new aa());
    ((q)localObject).a(new com.tencent.mm.plugin.appbrand.jsapi.media.e());
    ((q)localObject).a(new com.tencent.mm.plugin.appbrand.jsapi.l.ag());
    ((q)localObject).a(new com.tencent.mm.plugin.appbrand.jsapi.l.t());
    ((q)localObject).a(new com.tencent.mm.plugin.appbrand.jsapi.share.e());
    ((q)localObject).a(new JsApiChooseMultiMedia());
    ((q)localObject).a(new au());
    ((q)localObject).a(new JsApiSetBackgroundFetchToken());
    ((q)localObject).a(new com.tencent.mm.plugin.appbrand.jsapi.backgroundfetch.a());
    ((q)localObject).a(new JsApiAddDownloadTaskForNative());
    ((q)localObject).a(new JsApiPauseDownloadTaskForNative());
    ((q)localObject).a(new JsApiResumeDownloadTaskForNative());
    ((q)localObject).a(new JsApiQueryDownloadTaskForNative());
    ((q)localObject).a(new JsApiInstallDownloadTaskForNative());
    ((q)localObject).a(new JsApiGetInstallStateForNative());
    ((q)localObject).a(new JsApiLaunchApplicationForNative());
    ((q)localObject).a(new JsApiCancelDownloadTaskForNative());
    ((q)localObject).a(new com.tencent.mm.plugin.appbrand.jsapi.appdownload.f());
    ((q)localObject).a(new JsApiJumpDownloaderWidgetForNative());
    ((q)localObject).a(new bu());
    ((q)localObject).a(new com.tencent.mm.plugin.appbrand.jsapi.i.a());
    ((q)localObject).a(new com.tencent.mm.plugin.appbrand.jsapi.p.d());
    ((q)localObject).aG(com.tencent.mm.plugin.appbrand.jsapi.ui.launcher.d.aEK());
    localObject = ((q)localObject).hxe;
    AppMethodBeat.o(130363);
    return localObject;
  }
  
  public static Map<String, m> aBy()
  {
    AppMethodBeat.i(130364);
    Object localObject = new q();
    ((q)localObject).b(new com.tencent.mm.plugin.appbrand.jsapi.profile.c());
    ((q)localObject).b(new ba());
    ((q)localObject).b(new com.tencent.mm.plugin.appbrand.jsapi.d.h());
    ((q)localObject).b(new com.tencent.mm.plugin.appbrand.jsapi.d.c());
    ((q)localObject).b(new com.tencent.mm.plugin.appbrand.jsapi.d.b());
    ((q)localObject).b(new com.tencent.mm.plugin.appbrand.jsapi.d.i());
    ((q)localObject).b(new com.tencent.mm.plugin.appbrand.jsapi.d.d());
    ((q)localObject).b(new com.tencent.mm.plugin.appbrand.jsapi.d.j());
    ((q)localObject).b(new com.tencent.mm.plugin.appbrand.jsapi.d.e());
    ((q)localObject).b(new com.tencent.mm.plugin.appbrand.jsapi.d.f());
    ((q)localObject).b(new com.tencent.mm.plugin.appbrand.jsapi.l.f());
    ((q)localObject).b(new com.tencent.mm.plugin.appbrand.jsapi.p.e());
    ((q)localObject).b(new com.tencent.mm.plugin.appbrand.jsapi.p.f());
    ((q)localObject).b(new com.tencent.mm.plugin.appbrand.jsapi.p.h());
    ((q)localObject).b(new com.tencent.mm.plugin.appbrand.jsapi.p.g());
    ((q)localObject).b(new bm());
    ((q)localObject).b(new bo());
    ((q)localObject).b(new com.tencent.mm.plugin.appbrand.jsapi.n.e());
    ((q)localObject).b(new com.tencent.mm.plugin.appbrand.jsapi.n.g());
    ((q)localObject).b(new com.tencent.mm.plugin.appbrand.jsapi.l.b());
    ((q)localObject).b(new ap());
    ((q)localObject).b(new com.tencent.mm.plugin.appbrand.jsapi.video.f());
    ((q)localObject).b(new com.tencent.mm.plugin.appbrand.jsapi.video.j());
    ((q)localObject).b(new com.tencent.mm.plugin.appbrand.jsapi.video.i());
    ((q)localObject).b(new com.tencent.mm.plugin.appbrand.jsapi.video.h());
    ((q)localObject).b(new com.tencent.mm.plugin.appbrand.jsapi.video.g());
    ((q)localObject).b(new com.tencent.mm.plugin.appbrand.jsapi.live.b());
    ((q)localObject).b(new com.tencent.mm.plugin.appbrand.jsapi.live.h());
    ((q)localObject).b(new com.tencent.mm.plugin.appbrand.jsapi.live.f());
    ((q)localObject).b(new com.tencent.mm.plugin.appbrand.jsapi.live.d());
    ((q)localObject).b(new com.tencent.mm.plugin.appbrand.jsapi.live.a());
    ((q)localObject).b(new com.tencent.mm.plugin.appbrand.jsapi.live.g());
    ((q)localObject).b(new com.tencent.mm.plugin.appbrand.jsapi.live.e());
    ((q)localObject).b(new com.tencent.mm.plugin.appbrand.jsapi.live.c());
    ((q)localObject).b(new com.tencent.mm.plugin.appbrand.jsapi.v.d.a.b());
    ((q)localObject).b(new com.tencent.mm.plugin.appbrand.jsapi.v.d.a.e());
    ((q)localObject).b(new com.tencent.mm.plugin.appbrand.jsapi.v.d.a.c());
    ((q)localObject).b(new com.tencent.mm.plugin.appbrand.jsapi.v.d.a.d());
    ((q)localObject).b(new com.tencent.mm.plugin.appbrand.jsapi.v.b.a.a.b());
    ((q)localObject).b(new com.tencent.mm.plugin.appbrand.jsapi.v.b.a.a.e());
    ((q)localObject).b(new com.tencent.mm.plugin.appbrand.jsapi.v.b.a.a.c());
    ((q)localObject).b(new com.tencent.mm.plugin.appbrand.jsapi.v.b.a.a.d());
    ((q)localObject).b(new com.tencent.mm.plugin.appbrand.jsapi.v.b.b.a.b());
    ((q)localObject).b(new com.tencent.mm.plugin.appbrand.jsapi.v.b.b.a.e());
    ((q)localObject).b(new com.tencent.mm.plugin.appbrand.jsapi.v.b.b.a.c());
    ((q)localObject).b(new com.tencent.mm.plugin.appbrand.jsapi.v.b.b.a.d());
    ((q)localObject).b(new com.tencent.mm.plugin.appbrand.jsapi.b.e());
    ((q)localObject).b(new com.tencent.mm.plugin.appbrand.jsapi.b.f());
    ((q)localObject).b(new com.tencent.mm.plugin.appbrand.jsapi.b.i());
    ((q)localObject).b(new com.tencent.mm.plugin.appbrand.jsapi.b.k());
    ((q)localObject).b(new com.tencent.mm.plugin.appbrand.jsapi.contact.e());
    ((q)localObject).b(new com.tencent.mm.plugin.appbrand.jsapi.contact.f());
    ((q)localObject).b(new JsApiPrivateAddContact());
    ((q)localObject).b(new bl());
    ((q)localObject).b(new com.tencent.mm.plugin.appbrand.jsapi.l.a());
    ((q)localObject).b(new com.tencent.mm.plugin.appbrand.jsapi.a.d());
    ((q)localObject).b(new com.tencent.mm.plugin.appbrand.jsapi.a.g());
    ((q)localObject).b(new com.tencent.mm.plugin.appbrand.jsapi.a.b());
    ((q)localObject).b(new com.tencent.mm.plugin.appbrand.jsapi.a.f());
    ((q)localObject).b(new bq());
    ((q)localObject).b(new com.tencent.mm.plugin.appbrand.jsapi.r.n());
    ((q)localObject).b(new com.tencent.mm.plugin.appbrand.jsapi.container.a());
    ((q)localObject).b(new com.tencent.mm.plugin.appbrand.jsapi.container.c());
    ((q)localObject).b(new com.tencent.mm.plugin.appbrand.jsapi.container.b());
    ((q)localObject).b(new com.tencent.mm.plugin.appbrand.jsapi.a.c());
    ((q)localObject).b(new com.tencent.mm.plugin.appbrand.jsapi.a.e());
    ((q)localObject).b(new com.tencent.mm.plugin.appbrand.jsapi.n.f());
    ((q)localObject).b(new com.tencent.mm.plugin.appbrand.jsapi.n.c());
    ((q)localObject).b(new com.tencent.mm.plugin.appbrand.jsapi.n.h());
    ((q)localObject).b(new bp());
    ((q)localObject).b(new com.tencent.mm.plugin.appbrand.jsapi.coverview.e());
    ((q)localObject).b(new com.tencent.mm.plugin.appbrand.jsapi.coverview.k());
    ((q)localObject).b(new com.tencent.mm.plugin.appbrand.jsapi.coverview.h());
    ((q)localObject).b(new com.tencent.mm.plugin.appbrand.jsapi.coverview.c());
    ((q)localObject).b(new com.tencent.mm.plugin.appbrand.jsapi.coverview.i());
    ((q)localObject).b(new com.tencent.mm.plugin.appbrand.jsapi.coverview.f());
    ((q)localObject).b(new com.tencent.mm.plugin.appbrand.jsapi.camera.j());
    ((q)localObject).b(new com.tencent.mm.plugin.appbrand.jsapi.camera.n());
    ((q)localObject).b(new com.tencent.mm.plugin.appbrand.jsapi.camera.m());
    ((q)localObject).b(new com.tencent.mm.plugin.appbrand.jsapi.k.b());
    ((q)localObject).b(new com.tencent.mm.plugin.appbrand.jsapi.k.e());
    ((q)localObject).b(new com.tencent.mm.plugin.appbrand.jsapi.k.d());
    ((q)localObject).b(new com.tencent.mm.plugin.appbrand.debugger.e());
    ((q)localObject).b(new com.tencent.mm.plugin.appbrand.jsapi.coverview.b());
    ((q)localObject).b(new com.tencent.mm.plugin.appbrand.jsapi.u.f());
    ((q)localObject).b(new com.tencent.mm.plugin.appbrand.jsapi.u.h());
    ((q)localObject).b(new com.tencent.mm.plugin.appbrand.jsapi.u.g());
    ((q)localObject).b(new com.tencent.mm.plugin.appbrand.jsapi.b.g());
    ((q)localObject).b(new com.tencent.mm.plugin.appbrand.jsapi.b.l());
    ((q)localObject).b(new com.tencent.mm.plugin.appbrand.jsapi.b.j());
    ((q)localObject).b(new com.tencent.mm.plugin.appbrand.jsapi.l.m());
    ((q)localObject).b(new bk());
    ((q)localObject).b(new aa());
    ((q)localObject).b(new com.tencent.mm.plugin.appbrand.jsapi.coverview.d());
    ((q)localObject).b(new com.tencent.mm.plugin.appbrand.jsapi.coverview.j());
    ((q)localObject).b(new com.tencent.mm.plugin.appbrand.jsapi.coverview.g());
    ((q)localObject).b(new com.tencent.mm.plugin.appbrand.jsapi.l.s());
    ((q)localObject).b(new com.tencent.mm.plugin.appbrand.jsapi.l.q());
    ((q)localObject).b(new com.tencent.mm.plugin.appbrand.jsapi.l.z());
    ((q)localObject).b(new com.tencent.mm.plugin.appbrand.jsapi.l.d());
    ((q)localObject).b(new com.tencent.mm.plugin.appbrand.jsapi.l.o());
    ((q)localObject).b(new com.tencent.mm.plugin.appbrand.jsapi.l.n());
    ((q)localObject).aH(com.tencent.mm.plugin.appbrand.jsapi.g.w.aDo());
    ((q)localObject).b(new com.tencent.mm.plugin.appbrand.jsapi.ui.d());
    ((q)localObject).b(new com.tencent.mm.plugin.appbrand.jsapi.ui.a());
    ((q)localObject).b(new com.tencent.mm.plugin.appbrand.jsapi.l.y());
    ((q)localObject).b(new com.tencent.mm.plugin.appbrand.jsapi.l.c());
    ((q)localObject).b(new com.tencent.mm.plugin.appbrand.jsapi.ui.e());
    ((q)localObject).b(new com.tencent.mm.plugin.appbrand.jsapi.ui.b());
    ((q)localObject).b(new com.tencent.mm.plugin.appbrand.jsapi.miniprogram_navigator.g());
    ((q)localObject).b(new com.tencent.mm.plugin.appbrand.jsapi.miniprogram_navigator.e());
    ((q)localObject).b(new com.tencent.mm.plugin.appbrand.jsapi.m.e());
    ((q)localObject).b(new com.tencent.mm.plugin.appbrand.jsapi.l.r());
    ((q)localObject).b(new com.tencent.mm.plugin.appbrand.weishi.h());
    ((q)localObject).b(new JsApiOperateWXData());
    ((q)localObject).b(new JsApiLogin());
    ((q)localObject).b(new JsApiAuthorize());
    ((q)localObject).b(new com.tencent.mm.plugin.appbrand.jsapi.r.f());
    ((q)localObject).b(new com.tencent.mm.plugin.appbrand.jsapi.r.k());
    ((q)localObject).b(new com.tencent.mm.plugin.appbrand.jsapi.r.h());
    ((q)localObject).b(new com.tencent.mm.plugin.appbrand.jsapi.r.l());
    ((q)localObject).b(new com.tencent.mm.plugin.appbrand.jsapi.l.ae());
    ((q)localObject).b(new com.tencent.mm.plugin.appbrand.jsapi.storage.d());
    ((q)localObject).b(new com.tencent.mm.plugin.appbrand.jsapi.storage.j());
    ((q)localObject).b(new com.tencent.mm.plugin.appbrand.jsapi.storage.m());
    ((q)localObject).b(new com.tencent.mm.plugin.appbrand.jsapi.storage.e());
    ((q)localObject).b(new av());
    ((q)localObject).b(new com.tencent.mm.plugin.appbrand.jsapi.v.c.a.b());
    ((q)localObject).b(new com.tencent.mm.plugin.appbrand.jsapi.v.c.a.d());
    ((q)localObject).b(new com.tencent.mm.plugin.appbrand.jsapi.v.c.a.c());
    ((q)localObject).b(new JsApiShowImageOperateSheet());
    ((q)localObject).b(new com.tencent.mm.plugin.appbrand.jsapi.v.a.a.b());
    ((q)localObject).b(new com.tencent.mm.plugin.appbrand.jsapi.v.a.a.d());
    ((q)localObject).b(new com.tencent.mm.plugin.appbrand.jsapi.v.a.a.e());
    ((q)localObject).aH(com.tencent.mm.plugin.appbrand.jsapi.ui.launcher.d.aEK());
    localObject = ((q)localObject).hxf;
    AppMethodBeat.o(130364);
    return localObject;
  }
  
  private void aG(List<m> paramList)
  {
    AppMethodBeat.i(130365);
    if ((paramList == null) || (paramList.size() <= 0))
    {
      AppMethodBeat.o(130365);
      return;
    }
    paramList = paramList.iterator();
    while (paramList.hasNext()) {
      a((m)paramList.next());
    }
    AppMethodBeat.o(130365);
  }
  
  private void aH(List<m> paramList)
  {
    AppMethodBeat.i(130367);
    if ((paramList == null) || (paramList.size() <= 0))
    {
      AppMethodBeat.o(130367);
      return;
    }
    paramList = paramList.iterator();
    while (paramList.hasNext()) {
      b((m)paramList.next());
    }
    AppMethodBeat.o(130367);
  }
  
  private void b(m paramm)
  {
    AppMethodBeat.i(130368);
    if ((paramm == null) || (com.tencent.mm.sdk.platformtools.bo.isNullOrNil(paramm.getName())))
    {
      AppMethodBeat.o(130368);
      return;
    }
    if ((m)this.hxf.put(paramm.getName(), paramm) != null)
    {
      paramm = new IllegalAccessError("Duplicated api instance " + c(paramm));
      AppMethodBeat.o(130368);
      throw paramm;
    }
    AppMethodBeat.o(130368);
  }
  
  private static String c(m paramm)
  {
    AppMethodBeat.i(130369);
    paramm = String.format(Locale.US, "[%s->%s]", new Object[] { paramm.getName(), paramm.getClass().getSimpleName() });
    AppMethodBeat.o(130369);
    return paramm;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.q
 * JD-Core Version:    0.7.0.1
 */