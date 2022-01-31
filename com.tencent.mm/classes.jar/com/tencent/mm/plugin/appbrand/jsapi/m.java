package com.tencent.mm.plugin.appbrand.jsapi;

import com.tencent.mm.plugin.appbrand.jsapi.appdownload.JsApiAddDownloadTask;
import com.tencent.mm.plugin.appbrand.jsapi.appdownload.JsApiAddDownloadTaskStraight;
import com.tencent.mm.plugin.appbrand.jsapi.appdownload.JsApiCancelDownloadTask;
import com.tencent.mm.plugin.appbrand.jsapi.appdownload.JsApiGetInstallState;
import com.tencent.mm.plugin.appbrand.jsapi.appdownload.JsApiInstallDownloadTask;
import com.tencent.mm.plugin.appbrand.jsapi.appdownload.JsApiPauseDownloadTask;
import com.tencent.mm.plugin.appbrand.jsapi.appdownload.JsApiQueryDownloadTask;
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
import com.tencent.mm.plugin.appbrand.jsapi.bio.face.JsApiCheckIsSupportFaceDetect;
import com.tencent.mm.plugin.appbrand.jsapi.bio.soter.JsApiCheckBioEnrollment;
import com.tencent.mm.plugin.appbrand.jsapi.bio.soter.JsApiCheckIsSupportSoterAuthentication;
import com.tencent.mm.plugin.appbrand.jsapi.camera.AppBrandCameraView;
import com.tencent.mm.plugin.appbrand.jsapi.contact.JsApiChooseWeChatContact;
import com.tencent.mm.plugin.appbrand.jsapi.file.JsApiOpenDocument;
import com.tencent.mm.plugin.appbrand.jsapi.file.ac;
import com.tencent.mm.plugin.appbrand.jsapi.file.ai;
import com.tencent.mm.plugin.appbrand.jsapi.file.aj;
import com.tencent.mm.plugin.appbrand.jsapi.media.JsApiChooseImage;
import com.tencent.mm.plugin.appbrand.jsapi.media.JsApiChooseMedia;
import com.tencent.mm.plugin.appbrand.jsapi.media.JsApiChooseVideo;
import com.tencent.mm.plugin.appbrand.jsapi.media.JsApiUploadEncryptedFileToCDN;
import com.tencent.mm.plugin.appbrand.jsapi.miniprogram_navigator.JsApiLaunchMiniProgram;
import com.tencent.mm.plugin.appbrand.jsapi.miniprogram_navigator.JsApiNavigateToDevMiniProgram;
import com.tencent.mm.plugin.appbrand.jsapi.nfc.hce.HCEService;
import com.tencent.mm.plugin.appbrand.jsapi.nfc.hce.HCETransparentUI;
import com.tencent.mm.plugin.appbrand.jsapi.share.JsApiShowUpdatableMessageSubscribeButton;
import com.tencent.mm.plugin.appbrand.jsapi.version.JsApiUpdateApp;
import com.tencent.mm.plugin.appbrand.jsapi.video.AppBrandVideoWrapper;
import com.tencent.mm.sdk.platformtools.bk;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public final class m
{
  private static Map<String, i> gfi;
  private static Map<String, i> gfj;
  
  static
  {
    AppBrandVideoWrapper.aiE();
    AppBrandCameraView.aiE();
    bd.ahS();
  }
  
  private static void a(i parami)
  {
    if ((parami == null) || (bk.bl(parami.getName()))) {
      return;
    }
    gfi.put(parami.getName(), parami);
  }
  
  public static Map<String, i> ahO()
  {
    gfi = new HashMap();
    a(new com.tencent.mm.plugin.appbrand.jsapi.storage.a());
    a(new com.tencent.mm.plugin.appbrand.jsapi.storage.f());
    a(new com.tencent.mm.plugin.appbrand.jsapi.storage.n());
    a(new com.tencent.mm.plugin.appbrand.jsapi.storage.b());
    a(new com.tencent.mm.plugin.appbrand.jsapi.storage.i());
    a(new com.tencent.mm.plugin.appbrand.jsapi.storage.o());
    a(new JsApiLogin());
    a(new JsApiAuthorize());
    a(new JsApiOperateWXData());
    a(new com.tencent.mm.plugin.appbrand.jsapi.k.p());
    a(new com.tencent.mm.plugin.appbrand.jsapi.k.g());
    a(new com.tencent.mm.plugin.appbrand.jsapi.k.i());
    a(new com.tencent.mm.plugin.appbrand.jsapi.k.f());
    a(new at());
    a(new JsApiChooseImage());
    a(new com.tencent.mm.plugin.appbrand.jsapi.media.d());
    a(new com.tencent.mm.plugin.appbrand.jsapi.media.b());
    a(new JsApiChooseVideo());
    a(new JsApiStartRecordVoice());
    a(new JsApiStopRecordVoice());
    a(new JsApiStartPlayVoice());
    a(new JsApiPausePlayVoice());
    a(new JsApiStopPlayVoice());
    a(new com.tencent.mm.plugin.appbrand.jsapi.e.h());
    a(new com.tencent.mm.plugin.appbrand.jsapi.e.j());
    a(new com.tencent.mm.plugin.appbrand.jsapi.q.c());
    a(new JsApiGetMusicPlayerState());
    a(new JsApiOperateMusicPlayer());
    a(new JsApiScanCode());
    a(new aq());
    a(new com.tencent.mm.plugin.appbrand.jsapi.l.e());
    a(new al());
    a(new com.tencent.mm.plugin.appbrand.jsapi.o.a());
    a(new com.tencent.mm.plugin.appbrand.jsapi.l.i());
    a(new com.tencent.mm.plugin.appbrand.jsapi.l.c());
    a(new com.tencent.mm.plugin.appbrand.jsapi.contact.b());
    a(new com.tencent.mm.plugin.appbrand.jsapi.contact.d());
    a(new com.tencent.mm.plugin.appbrand.jsapi.k.x());
    a(new com.tencent.mm.plugin.appbrand.jsapi.k.u());
    a(new com.tencent.mm.plugin.appbrand.jsapi.k.c());
    a(new com.tencent.mm.plugin.appbrand.jsapi.b.e());
    a(new com.tencent.mm.plugin.appbrand.jsapi.share.c());
    a(new com.tencent.mm.plugin.appbrand.jsapi.share.e());
    a(new ah());
    a(new com.tencent.mm.plugin.appbrand.jsapi.o.b());
    a(new com.tencent.mm.plugin.appbrand.jsapi.o.d());
    a(new com.tencent.mm.plugin.appbrand.jsapi.o.c());
    a(new ay());
    a(new com.tencent.mm.plugin.appbrand.jsapi.d.e());
    a(new ag());
    a(new com.tencent.mm.plugin.appbrand.jsapi.d.b());
    a(new com.tencent.mm.plugin.appbrand.jsapi.p.a());
    a(new com.tencent.mm.plugin.appbrand.jsapi.p.b());
    a(new com.tencent.mm.plugin.appbrand.jsapi.p.e());
    a(new com.tencent.mm.plugin.appbrand.jsapi.p.c());
    a(new com.tencent.mm.plugin.appbrand.jsapi.p.d());
    a(new com.tencent.mm.plugin.appbrand.jsapi.storage.k());
    a(new com.tencent.mm.plugin.appbrand.jsapi.storage.l());
    a(new com.tencent.mm.plugin.appbrand.jsapi.b.c());
    a(new com.tencent.mm.plugin.appbrand.jsapi.b.d());
    a(new com.tencent.mm.plugin.appbrand.jsapi.n.c());
    a(new com.tencent.mm.plugin.appbrand.jsapi.n.b());
    a(new com.tencent.mm.plugin.appbrand.jsapi.n.d());
    a(new com.tencent.mm.plugin.appbrand.jsapi.n.a());
    a(new ad());
    a(new ak());
    a(new com.tencent.mm.plugin.appbrand.jsapi.storage.g());
    a(new com.tencent.mm.plugin.appbrand.jsapi.storage.h());
    a(new com.tencent.mm.plugin.appbrand.jsapi.e.c());
    a(new com.tencent.mm.plugin.appbrand.jsapi.media.c());
    a(new JsApiRefreshSession());
    a(new com.tencent.mm.plugin.appbrand.jsapi.k.y());
    a(new com.tencent.mm.plugin.appbrand.jsapi.l.f());
    a(new com.tencent.mm.plugin.appbrand.jsapi.share.f());
    a(new w());
    a(new am());
    a(new JsApiMakeVoIPCall());
    a(new com.tencent.mm.plugin.appbrand.jsapi.q.b());
    a(new JsApiSetClipboardDataWC());
    a(new com.tencent.mm.plugin.appbrand.jsapi.bluetooth.m());
    a(new com.tencent.mm.plugin.appbrand.jsapi.bluetooth.e());
    a(new com.tencent.mm.plugin.appbrand.jsapi.bluetooth.i());
    a(new com.tencent.mm.plugin.appbrand.jsapi.bluetooth.o());
    a(new com.tencent.mm.plugin.appbrand.jsapi.bluetooth.p());
    a(new com.tencent.mm.plugin.appbrand.jsapi.bluetooth.j());
    a(new com.tencent.mm.plugin.appbrand.jsapi.bluetooth.f());
    a(new com.tencent.mm.plugin.appbrand.jsapi.bluetooth.d());
    a(new com.tencent.mm.plugin.appbrand.jsapi.bluetooth.h());
    a(new com.tencent.mm.plugin.appbrand.jsapi.bluetooth.g());
    a(new com.tencent.mm.plugin.appbrand.jsapi.bluetooth.n());
    a(new com.tencent.mm.plugin.appbrand.jsapi.bluetooth.q());
    a(new com.tencent.mm.plugin.appbrand.jsapi.bluetooth.l());
    a(new com.tencent.mm.plugin.appbrand.jsapi.bluetooth.k());
    a(new JsApiLaunchMiniProgram());
    a(new com.tencent.mm.plugin.appbrand.jsapi.k.h());
    a(new JsApiChooseWeChatContact());
    a(new JsApiChooseMedia());
    a(new JsApiUploadEncryptedFileToCDN());
    a(new com.tencent.mm.plugin.appbrand.jsapi.miniprogram_navigator.b());
    a(new ar());
    a(new ba());
    a(new JsApiGetBackgroundAudioState());
    a(new JsApiSetBackgroundAudioStateWC());
    a(new com.tencent.mm.plugin.appbrand.jsapi.audio.i());
    a(new com.tencent.mm.plugin.appbrand.jsapi.share.g());
    a(new com.tencent.mm.plugin.appbrand.jsapi.share.b());
    a(new as());
    a(new com.tencent.mm.plugin.appbrand.jsapi.l.h());
    a(new com.tencent.mm.plugin.appbrand.jsapi.contact.a());
    a(new JsApiOpenWeRunSetting());
    a(new JsApiUploadWeRunData());
    a(new x());
    a(new com.tencent.mm.plugin.appbrand.jsapi.q.d());
    a(new com.tencent.mm.plugin.appbrand.jsapi.q.j());
    a(new com.tencent.mm.plugin.appbrand.jsapi.q.l());
    a(new com.tencent.mm.plugin.appbrand.jsapi.q.m());
    a(new com.tencent.mm.plugin.appbrand.jsapi.share.i());
    a(new com.tencent.mm.plugin.appbrand.jsapi.share.h());
    a(new com.tencent.mm.plugin.appbrand.jsapi.share.j());
    a(new JsApiShowUpdatableMessageSubscribeButton());
    a(new com.tencent.mm.plugin.appbrand.jsapi.c.b());
    a(new com.tencent.mm.plugin.appbrand.jsapi.c.c());
    a(new com.tencent.mm.plugin.appbrand.jsapi.c.d());
    a(new JsApiCheckIsSupportFaceDetect());
    a(new com.tencent.mm.plugin.appbrand.jsapi.bio.face.c());
    a(new com.tencent.mm.plugin.appbrand.jsapi.bio.face.b());
    a(new com.tencent.mm.plugin.appbrand.jsapi.bio.face.d());
    a(new com.tencent.mm.plugin.appbrand.jsapi.u.a.a.c());
    a(new com.tencent.mm.plugin.appbrand.jsapi.video.g());
    a(new com.tencent.mm.plugin.appbrand.jsapi.live.e());
    a(new com.tencent.mm.plugin.appbrand.jsapi.live.d());
    a(new com.tencent.mm.plugin.appbrand.jsapi.media.e());
    a(new com.tencent.mm.plugin.appbrand.jsapi.media.f());
    a(new JsApiGetSetting());
    a(new an());
    a(new com.tencent.mm.plugin.appbrand.jsapi.share.d());
    a(new com.tencent.mm.plugin.appbrand.jsapi.r.c());
    a(new com.tencent.mm.plugin.appbrand.jsapi.q.i());
    a(new z());
    a(new com.tencent.mm.plugin.appbrand.jsapi.b.g());
    a(new com.tencent.mm.plugin.appbrand.jsapi.miniprogram_navigator.d());
    a(new com.tencent.mm.plugin.appbrand.jsapi.miniprogram_navigator.c());
    a(new com.tencent.mm.plugin.appbrand.jsapi.op_report.b());
    a(new com.tencent.mm.plugin.appbrand.jsapi.k.o());
    a(new ax());
    a(new com.tencent.mm.plugin.appbrand.jsapi.k.q());
    a(new az());
    a(new com.tencent.mm.plugin.appbrand.jsapi.k.n());
    a(new JsApiCheckIsSupportSoterAuthentication());
    a(new com.tencent.mm.plugin.appbrand.jsapi.bio.soter.b());
    a(new ab());
    a(new aa());
    a(new com.tencent.mm.plugin.appbrand.jsapi.i.d());
    a(new com.tencent.mm.plugin.appbrand.jsapi.i.i());
    a(new com.tencent.mm.plugin.appbrand.jsapi.i.c());
    a(new com.tencent.mm.plugin.appbrand.jsapi.i.g());
    a(new com.tencent.mm.plugin.appbrand.jsapi.i.f());
    a(new com.tencent.mm.plugin.appbrand.jsapi.i.k());
    a(new bb());
    a(new JsApiBatchGetContact());
    a(new com.tencent.mm.plugin.appbrand.jsapi.camera.j());
    a(new com.tencent.mm.plugin.appbrand.jsapi.k.w());
    a(new com.tencent.mm.plugin.appbrand.jsapi.audio.j());
    a(new com.tencent.mm.plugin.appbrand.jsapi.audio.g());
    a(new com.tencent.mm.plugin.appbrand.jsapi.audio.d());
    a(new com.tencent.mm.plugin.appbrand.jsapi.audio.l());
    a(new com.tencent.mm.plugin.appbrand.jsapi.audio.f());
    a(new com.tencent.mm.plugin.appbrand.jsapi.audio.h());
    a(new com.tencent.mm.plugin.appbrand.jsapi.audio.e());
    a(new com.tencent.mm.plugin.appbrand.jsapi.audio.m());
    a(new JsApiNavigateBackApplication());
    a(new com.tencent.mm.plugin.appbrand.jsapi.e.e());
    a(new JsApiCheckBioEnrollment());
    a(new com.tencent.mm.plugin.appbrand.jsapi.wifi.d());
    a(new com.tencent.mm.plugin.appbrand.jsapi.wifi.e());
    a(new com.tencent.mm.plugin.appbrand.jsapi.wifi.c());
    a(new com.tencent.mm.plugin.appbrand.jsapi.wifi.b());
    a(new com.tencent.mm.plugin.appbrand.jsapi.wifi.a());
    a(new JsApiNavigateToDevMiniProgram());
    a(new com.tencent.mm.plugin.appbrand.jsapi.nfc.d(HCEService.class, HCETransparentUI.class));
    a(new com.tencent.mm.plugin.appbrand.jsapi.nfc.e());
    a(new com.tencent.mm.plugin.appbrand.jsapi.nfc.c());
    a(new com.tencent.mm.plugin.appbrand.jsapi.nfc.b());
    a(new com.tencent.mm.plugin.appbrand.jsapi.k.r());
    a(new com.tencent.mm.plugin.appbrand.jsapi.k.t());
    a(new com.tencent.mm.plugin.appbrand.jsapi.k.s());
    a(new com.tencent.mm.plugin.appbrand.jsapi.k.d());
    a(new com.tencent.mm.plugin.appbrand.jsapi.k.v());
    a(new com.tencent.mm.plugin.appbrand.jsapi.r.d());
    a(new com.tencent.mm.plugin.appbrand.jsapi.r.b());
    a(new com.tencent.mm.plugin.appbrand.jsapi.q.f());
    a(new com.tencent.mm.plugin.appbrand.jsapi.q.k());
    a(new com.tencent.mm.plugin.appbrand.jsapi.q.h());
    a(new com.tencent.mm.plugin.appbrand.jsapi.i.e());
    a(new com.tencent.mm.plugin.appbrand.jsapi.i.j());
    a(new com.tencent.mm.plugin.appbrand.jsapi.l.g());
    a(new com.tencent.mm.plugin.appbrand.jsapi.k.m());
    a(new com.tencent.mm.plugin.appbrand.jsapi.file.ae());
    a(new com.tencent.mm.plugin.appbrand.jsapi.file.af());
    a(new com.tencent.mm.plugin.appbrand.jsapi.file.o());
    a(new com.tencent.mm.plugin.appbrand.jsapi.file.p());
    a(new com.tencent.mm.plugin.appbrand.jsapi.file.q());
    a(new com.tencent.mm.plugin.appbrand.jsapi.file.z());
    a(new com.tencent.mm.plugin.appbrand.jsapi.file.y());
    a(new com.tencent.mm.plugin.appbrand.jsapi.file.ak());
    a(new com.tencent.mm.plugin.appbrand.jsapi.file.u());
    a(new com.tencent.mm.plugin.appbrand.jsapi.file.w());
    a(new com.tencent.mm.plugin.appbrand.jsapi.file.ad());
    a(new com.tencent.mm.plugin.appbrand.jsapi.file.h());
    a(new com.tencent.mm.plugin.appbrand.jsapi.file.ah());
    a(new com.tencent.mm.plugin.appbrand.jsapi.file.s());
    a(new com.tencent.mm.plugin.appbrand.jsapi.file.n());
    a(new JsApiOpenDocument());
    a(new com.tencent.mm.plugin.appbrand.jsapi.file.x());
    a(new aj());
    a(new com.tencent.mm.plugin.appbrand.jsapi.file.t());
    a(new com.tencent.mm.plugin.appbrand.jsapi.file.v());
    a(new ac());
    a(new com.tencent.mm.plugin.appbrand.jsapi.file.g());
    a(new com.tencent.mm.plugin.appbrand.jsapi.file.ag());
    a(new com.tencent.mm.plugin.appbrand.jsapi.file.r());
    a(new com.tencent.mm.plugin.appbrand.jsapi.file.m());
    a(new ai());
    a(new com.tencent.mm.plugin.appbrand.jsapi.file.k());
    a(new com.tencent.mm.plugin.appbrand.jsapi.file.l());
    a(new com.tencent.mm.plugin.appbrand.jsapi.file.aa());
    a(new com.tencent.mm.plugin.appbrand.jsapi.file.ab());
    a(new com.tencent.mm.plugin.appbrand.jsapi.file.i());
    a(new com.tencent.mm.plugin.appbrand.jsapi.file.j());
    a(new JsApiUpdateApp());
    a(new com.tencent.mm.plugin.appbrand.jsapi.b.a());
    a(new com.tencent.mm.plugin.appbrand.jsapi.b.b());
    a(new ap());
    a(new com.tencent.mm.plugin.appbrand.jsapi.q.a());
    a(new JsApiLaunchApplication());
    a(new JsApiAddNativeDownloadTask());
    a(new com.tencent.mm.plugin.appbrand.jsapi.l.d());
    a(new JsApiAddDownloadTask());
    a(new JsApiAddDownloadTaskStraight());
    a(new JsApiQueryDownloadTask());
    a(new JsApiInstallDownloadTask());
    a(new JsApiPauseDownloadTask());
    a(new JsApiResumeDownloadTask());
    a(new JsApiGetInstallState());
    a(new JsApiCancelDownloadTask());
    a(new JsApiWriteCommData());
    a(new ae());
    a(new com.tencent.mm.plugin.appbrand.jsapi.k.k());
    a(new com.tencent.mm.plugin.appbrand.jsapi.k.l());
    a(new com.tencent.mm.plugin.appbrand.jsapi.f.a());
    a(new com.tencent.mm.plugin.appbrand.jsapi.f.b());
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(new com.tencent.mm.plugin.appbrand.jsapi.g.f());
    localArrayList.add(new com.tencent.mm.plugin.appbrand.jsapi.g.k());
    localArrayList.add(new com.tencent.mm.plugin.appbrand.jsapi.g.n());
    localArrayList.add(new com.tencent.mm.plugin.appbrand.jsapi.g.h());
    localArrayList.add(new com.tencent.mm.plugin.appbrand.jsapi.g.g());
    aw(localArrayList);
    a(new com.tencent.mm.plugin.appbrand.jsapi.h5_interact.b());
    a(new JsApiOpenAdCanvas());
    a(new com.tencent.mm.plugin.appbrand.jsapi.storage.c());
    a(new com.tencent.mm.plugin.appbrand.jsapi.h.a());
    a(new af());
    a(new com.tencent.mm.plugin.appbrand.jsapi.j.a());
    a(new com.tencent.mm.plugin.appbrand.jsapi.j.c());
    a(new com.tencent.mm.plugin.appbrand.jsapi.j.b());
    a(new com.tencent.mm.plugin.appbrand.jsapi.i.l());
    a(new JsApiGetABTestConfig());
    a(new com.tencent.mm.plugin.appbrand.jsapi.i.h());
    return gfi;
  }
  
  public static Map<String, i> ahP()
  {
    gfj = new HashMap();
    b(new JsApiProfile());
    b(new ao());
    b(new com.tencent.mm.plugin.appbrand.jsapi.d.f());
    b(new com.tencent.mm.plugin.appbrand.jsapi.d.b());
    b(new com.tencent.mm.plugin.appbrand.jsapi.d.g());
    b(new com.tencent.mm.plugin.appbrand.jsapi.d.c());
    b(new com.tencent.mm.plugin.appbrand.jsapi.d.h());
    b(new com.tencent.mm.plugin.appbrand.jsapi.d.d());
    b(new com.tencent.mm.plugin.appbrand.jsapi.k.e());
    b(new com.tencent.mm.plugin.appbrand.jsapi.o.a());
    b(new com.tencent.mm.plugin.appbrand.jsapi.o.b());
    b(new com.tencent.mm.plugin.appbrand.jsapi.o.d());
    b(new com.tencent.mm.plugin.appbrand.jsapi.o.c());
    b(new aw());
    b(new ay());
    b(new com.tencent.mm.plugin.appbrand.jsapi.m.e());
    b(new com.tencent.mm.plugin.appbrand.jsapi.m.g());
    b(new com.tencent.mm.plugin.appbrand.jsapi.k.b());
    b(new ag());
    b(new com.tencent.mm.plugin.appbrand.jsapi.video.e());
    b(new com.tencent.mm.plugin.appbrand.jsapi.video.i());
    b(new com.tencent.mm.plugin.appbrand.jsapi.video.h());
    b(new com.tencent.mm.plugin.appbrand.jsapi.video.g());
    b(new com.tencent.mm.plugin.appbrand.jsapi.video.f());
    b(new com.tencent.mm.plugin.appbrand.jsapi.live.c());
    b(new com.tencent.mm.plugin.appbrand.jsapi.live.i());
    b(new com.tencent.mm.plugin.appbrand.jsapi.live.g());
    b(new com.tencent.mm.plugin.appbrand.jsapi.live.e());
    b(new com.tencent.mm.plugin.appbrand.jsapi.live.b());
    b(new com.tencent.mm.plugin.appbrand.jsapi.live.h());
    b(new com.tencent.mm.plugin.appbrand.jsapi.live.f());
    b(new com.tencent.mm.plugin.appbrand.jsapi.live.d());
    b(new com.tencent.mm.plugin.appbrand.jsapi.u.a.a.b());
    b(new com.tencent.mm.plugin.appbrand.jsapi.u.a.a.e());
    b(new com.tencent.mm.plugin.appbrand.jsapi.u.a.a.c());
    b(new com.tencent.mm.plugin.appbrand.jsapi.u.a.a.d());
    b(new com.tencent.mm.plugin.appbrand.jsapi.b.e());
    b(new com.tencent.mm.plugin.appbrand.jsapi.b.f());
    b(new com.tencent.mm.plugin.appbrand.jsapi.b.h());
    b(new com.tencent.mm.plugin.appbrand.jsapi.b.i());
    b(new com.tencent.mm.plugin.appbrand.jsapi.contact.c());
    b(new JsApiPrivateAddContact());
    b(new av());
    b(new com.tencent.mm.plugin.appbrand.jsapi.k.a());
    b(new com.tencent.mm.plugin.appbrand.jsapi.a.d());
    b(new com.tencent.mm.plugin.appbrand.jsapi.a.g());
    b(new com.tencent.mm.plugin.appbrand.jsapi.a.b());
    b(new com.tencent.mm.plugin.appbrand.jsapi.a.f());
    b(new ba());
    b(new com.tencent.mm.plugin.appbrand.jsapi.q.m());
    b(new com.tencent.mm.plugin.appbrand.jsapi.container.a());
    b(new com.tencent.mm.plugin.appbrand.jsapi.container.c());
    b(new com.tencent.mm.plugin.appbrand.jsapi.container.b());
    b(new com.tencent.mm.plugin.appbrand.jsapi.a.c());
    b(new com.tencent.mm.plugin.appbrand.jsapi.a.e());
    b(new com.tencent.mm.plugin.appbrand.jsapi.m.f());
    b(new com.tencent.mm.plugin.appbrand.jsapi.m.c());
    b(new com.tencent.mm.plugin.appbrand.jsapi.m.h());
    b(new az());
    b(new com.tencent.mm.plugin.appbrand.jsapi.coverview.e());
    b(new com.tencent.mm.plugin.appbrand.jsapi.coverview.k());
    b(new com.tencent.mm.plugin.appbrand.jsapi.coverview.h());
    b(new com.tencent.mm.plugin.appbrand.jsapi.coverview.c());
    b(new com.tencent.mm.plugin.appbrand.jsapi.coverview.i());
    b(new com.tencent.mm.plugin.appbrand.jsapi.coverview.f());
    b(new com.tencent.mm.plugin.appbrand.jsapi.camera.h());
    b(new com.tencent.mm.plugin.appbrand.jsapi.camera.l());
    b(new com.tencent.mm.plugin.appbrand.jsapi.camera.k());
    b(new com.tencent.mm.plugin.appbrand.debugger.e());
    b(new com.tencent.mm.plugin.appbrand.jsapi.coverview.b());
    b(new com.tencent.mm.plugin.appbrand.jsapi.t.f());
    b(new com.tencent.mm.plugin.appbrand.jsapi.t.h());
    b(new com.tencent.mm.plugin.appbrand.jsapi.t.g());
    b(new com.tencent.mm.plugin.appbrand.jsapi.k.j());
    b(new au());
    b(new v());
    b(new com.tencent.mm.plugin.appbrand.jsapi.coverview.d());
    b(new com.tencent.mm.plugin.appbrand.jsapi.coverview.j());
    b(new com.tencent.mm.plugin.appbrand.jsapi.coverview.g());
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(new com.tencent.mm.plugin.appbrand.jsapi.g.j());
    localArrayList.add(new com.tencent.mm.plugin.appbrand.jsapi.g.l());
    localArrayList.add(new com.tencent.mm.plugin.appbrand.jsapi.g.o());
    localArrayList.add(new com.tencent.mm.plugin.appbrand.jsapi.g.a());
    localArrayList.add(new com.tencent.mm.plugin.appbrand.jsapi.g.d());
    localArrayList.add(new com.tencent.mm.plugin.appbrand.jsapi.g.m());
    localArrayList.add(new com.tencent.mm.plugin.appbrand.jsapi.g.c());
    localArrayList.add(new com.tencent.mm.plugin.appbrand.jsapi.g.i());
    localArrayList.add(new com.tencent.mm.plugin.appbrand.jsapi.g.b());
    localArrayList.add(new com.tencent.mm.plugin.appbrand.jsapi.g.e());
    ax(localArrayList);
    b(new com.tencent.mm.plugin.appbrand.jsapi.r.d());
    b(new com.tencent.mm.plugin.appbrand.jsapi.r.b());
    b(new com.tencent.mm.plugin.appbrand.jsapi.miniprogram_navigator.d());
    b(new com.tencent.mm.plugin.appbrand.jsapi.miniprogram_navigator.c());
    b(new com.tencent.mm.plugin.appbrand.jsapi.l.e());
    b(new com.tencent.mm.plugin.appbrand.jsapi.k.o());
    b(new JsApiOperateWXData());
    b(new JsApiLogin());
    b(new JsApiAuthorize());
    b(new com.tencent.mm.plugin.appbrand.jsapi.q.d());
    b(new com.tencent.mm.plugin.appbrand.jsapi.q.j());
    b(new com.tencent.mm.plugin.appbrand.jsapi.q.f());
    b(new com.tencent.mm.plugin.appbrand.jsapi.q.k());
    b(new com.tencent.mm.plugin.appbrand.jsapi.q.h());
    b(new com.tencent.mm.plugin.appbrand.jsapi.storage.d());
    b(new com.tencent.mm.plugin.appbrand.jsapi.storage.j());
    b(new com.tencent.mm.plugin.appbrand.jsapi.storage.m());
    b(new com.tencent.mm.plugin.appbrand.jsapi.storage.e());
    b(new al());
    return gfj;
  }
  
  private static void aw(List<i> paramList)
  {
    if (paramList.size() <= 0) {}
    for (;;)
    {
      return;
      paramList = paramList.iterator();
      while (paramList.hasNext()) {
        a((i)paramList.next());
      }
    }
  }
  
  private static void ax(List<i> paramList)
  {
    if (paramList.size() <= 0) {}
    for (;;)
    {
      return;
      paramList = paramList.iterator();
      while (paramList.hasNext()) {
        b((i)paramList.next());
      }
    }
  }
  
  private static void b(i parami)
  {
    if ((parami == null) || (bk.bl(parami.getName()))) {
      return;
    }
    gfj.put(parami.getName(), parami);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.m
 * JD-Core Version:    0.7.0.1
 */