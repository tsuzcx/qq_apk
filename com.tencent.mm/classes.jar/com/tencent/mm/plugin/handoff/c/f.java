package com.tencent.mm.plugin.handoff.c;

import android.os.Bundle;
import android.os.Parcelable;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.d;
import com.tencent.mm.ipcinvoker.j;
import com.tencent.mm.ipcinvoker.m;
import com.tencent.mm.ipcinvoker.type.IPCBoolean;
import com.tencent.mm.ipcinvoker.type.IPCString;
import com.tencent.mm.ipcinvoker.type.IPCVoid;
import com.tencent.mm.ipcinvoker.wx_extension.service.MainProcessIPCService;
import com.tencent.mm.plugin.appbrand.config.GetOnLineInfoInfoResult;
import com.tencent.mm.plugin.ball.model.BallInfo;
import com.tencent.mm.plugin.handoff.a.a;
import com.tencent.mm.plugin.handoff.model.HandOff;
import com.tencent.mm.plugin.multitask.model.MultiTaskInfo;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.List;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/handoff/service/HandOffServiceProxy;", "Lcom/tencent/mm/plugin/handoff/api/IHandOffService;", "()V", "currentWebViewUI", "Ljava/lang/ref/WeakReference;", "Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;", "onlineInfo", "Lcom/tencent/mm/plugin/appbrand/config/GetOnLineInfoInfoResult;", "add", "", "handOff", "Lcom/tencent/mm/plugin/handoff/model/HandOff;", "addHandOffFromBall", "ballInfo", "Lcom/tencent/mm/plugin/ball/model/BallInfo;", "addMultiTask", "multiTaskInfo", "Lcom/tencent/mm/plugin/multitask/model/MultiTaskInfo;", "addWindowFromBall", "allList", "cache", "cancelUpload", "id", "", "del", "key", "delAllFloatingWindow", "fixHandOffIfNeed", "getHandOffById", "getHandOffByKey", "isMac", "", "isPC", "isSupportOpenInComputer", "mod", "modFromBallInfo", "notifyUserStatusChange", "onAppBackground", "onAppForeground", "onFileCreate", "onFileDestroy", "onQBFileCreate", "onQBFileDestroy", "onQBFileUpdate", "onWebViewCreate", "onWebViewDestroy", "openMultiTask", "processRequest", "message", "registerWebViewUI", "webViewUI", "Lcom/tencent/mm/ui/MMActivity;", "removeMultiTask", "restoreFromBallInfoList", "ballInfoList", "", "restoreFromMultiTaskList", "multiTaskInfoList", "sendOpenRequest", "syncUserStatus", "tryEnterFloatBallInternal", "enterFloatBall", "updateMultiTask", "uploadFail", "arg", "uploadStart", "info", "Lcom/tencent/mm/pluginsdk/model/app/AppAttachInfo;", "uploadSuccess", "appId", "sdkVersion", "", "mediaId", "cdnURL", "aesKey", "uploading", "uploadedSize", "", "upsert", "AddHandOffFromBallTask", "AddTask", "AddWindowFromBallTask", "AllListTask", "CancelUploadTask", "Companion", "DelAllFloatingWindowTask", "DelTask", "FixHandOffTask", "GetCacheTask", "GetHandOffByIdTask", "GetHandOffByKeyTask", "ModFromBallInfoTask", "ModTask", "OnFileCreateTask", "OnFileDestroyTask", "OnWebViewCreateTask", "OnWebViewDestroyTask", "SendOpenRequestTask", "SetCacheTask", "SyncUserStatusTask", "UploadFail", "UploadSuccessCDNTask", "UploadSuccessCGITask", "UploadingTask", "UpsertTask", "plugin-handoff_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class f
  implements a
{
  public static final f.d Jmc;
  private GetOnLineInfoInfoResult JlP;
  
  static
  {
    AppMethodBeat.i(10428);
    Jmc = new f.d((byte)0);
    AppMethodBeat.o(10428);
  }
  
  public f()
  {
    AppMethodBeat.i(266208);
    this.JlP = new GetOnLineInfoInfoResult();
    fKd();
    AppMethodBeat.o(266208);
  }
  
  private static final void a(f paramf, GetOnLineInfoInfoResult paramGetOnLineInfoInfoResult)
  {
    AppMethodBeat.i(266223);
    s.u(paramf, "this$0");
    Log.i("HandOffServiceProxy", s.X("syncUserStatus: ", paramGetOnLineInfoInfoResult));
    s.s(paramGetOnLineInfoInfoResult, "onlineInfo");
    paramf.JlP = paramGetOnLineInfoInfoResult;
    AppMethodBeat.o(266223);
  }
  
  private final void fKd()
  {
    AppMethodBeat.i(266217);
    j.a(MainProcessIPCService.PROCESS_NAME, (Parcelable)new IPCVoid(), p.class, new f..ExternalSyntheticLambda0(this));
    AppMethodBeat.o(266217);
  }
  
  private static final void k(IPCVoid paramIPCVoid) {}
  
  private static final void l(IPCVoid paramIPCVoid) {}
  
  private static final void m(IPCVoid paramIPCVoid) {}
  
  private static final void n(IPCVoid paramIPCVoid) {}
  
  private static final void o(IPCVoid paramIPCVoid) {}
  
  private static final void p(IPCVoid paramIPCVoid) {}
  
  private static final void q(IPCVoid paramIPCVoid) {}
  
  private static final void r(IPCVoid paramIPCVoid) {}
  
  private static final void s(IPCVoid paramIPCVoid) {}
  
  private static final void t(IPCVoid paramIPCVoid) {}
  
  private static final void u(IPCVoid paramIPCVoid) {}
  
  private static final void v(IPCVoid paramIPCVoid) {}
  
  private static final void w(IPCVoid paramIPCVoid) {}
  
  private static final void x(IPCVoid paramIPCVoid) {}
  
  private static final void y(IPCVoid paramIPCVoid) {}
  
  public final void S(BallInfo paramBallInfo)
  {
    AppMethodBeat.i(10412);
    s.u(paramBallInfo, "ballInfo");
    j.a(MainProcessIPCService.PROCESS_NAME, (Parcelable)paramBallInfo, a.class, f..ExternalSyntheticLambda6.INSTANCE);
    AppMethodBeat.o(10412);
  }
  
  public final void a(GetOnLineInfoInfoResult paramGetOnLineInfoInfoResult)
  {
    AppMethodBeat.i(266333);
    s.u(paramGetOnLineInfoInfoResult, "onlineInfo");
    Log.i("HandOffServiceProxy", s.X("notifyUserStatusChange: ", paramGetOnLineInfoInfoResult));
    this.JlP = paramGetOnLineInfoInfoResult;
    AppMethodBeat.o(266333);
  }
  
  public final void a(HandOff paramHandOff)
  {
    AppMethodBeat.i(10407);
    s.u(paramHandOff, "handOff");
    j.a(MainProcessIPCService.PROCESS_NAME, (Parcelable)paramHandOff, l.class, f..ExternalSyntheticLambda13.INSTANCE);
    AppMethodBeat.o(10407);
  }
  
  public final boolean a(String paramString, com.tencent.mm.pluginsdk.model.app.c paramc)
  {
    AppMethodBeat.i(10417);
    s.u(paramString, "id");
    s.u(paramc, "info");
    Log.w("HandOffServiceProxy", "uploadStart should only be called in MM process!");
    AppMethodBeat.o(10417);
    return false;
  }
  
  public final HandOff aIc(String paramString)
  {
    AppMethodBeat.i(266323);
    s.u(paramString, "key");
    paramString = (HandOff)j.a(MainProcessIPCService.PROCESS_NAME, (Parcelable)new IPCString(paramString), i.class);
    AppMethodBeat.o(266323);
    return paramString;
  }
  
  public final HandOff aId(String paramString)
  {
    AppMethodBeat.i(10411);
    s.u(paramString, "id");
    paramString = (HandOff)j.a(MainProcessIPCService.PROCESS_NAME, (Parcelable)new IPCString(paramString), h.class);
    AppMethodBeat.o(10411);
    return paramString;
  }
  
  public final void aIe(String paramString)
  {
    AppMethodBeat.i(266330);
    s.u(paramString, "key");
    AppMethodBeat.o(266330);
  }
  
  public final void aIf(String paramString)
  {
    AppMethodBeat.i(10422);
    s.u(paramString, "id");
    j.a(MainProcessIPCService.PROCESS_NAME, (Parcelable)new IPCString(paramString), c.class, f..ExternalSyntheticLambda10.INSTANCE);
    AppMethodBeat.o(10422);
  }
  
  public final boolean aK(String paramString, long paramLong)
  {
    AppMethodBeat.i(10418);
    s.u(paramString, "id");
    paramString = b.jw("id", paramString);
    s.u("uploadedSize", "<this>");
    paramString = b.a(new c[] { paramString, new c((kotlin.g.a.b)new b.b("uploadedSize", paramLong)) });
    boolean bool = ((IPCBoolean)j.a(MainProcessIPCService.PROCESS_NAME, (Parcelable)paramString, t.class)).value;
    AppMethodBeat.o(10418);
    return bool;
  }
  
  public final void az(String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(10420);
    s.u(paramString1, "id");
    s.u(paramString2, "cdnURL");
    s.u(paramString3, "aesKey");
    paramString1 = b.a(new c[] { b.jw("id", paramString1), b.jw("cdnURL", paramString2), b.jw("aesKey", paramString3) });
    j.a(MainProcessIPCService.PROCESS_NAME, (Parcelable)paramString1, r.class, f..ExternalSyntheticLambda15.INSTANCE);
    AppMethodBeat.o(10420);
  }
  
  public final void b(HandOff paramHandOff)
  {
    AppMethodBeat.i(10408);
    s.u(paramHandOff, "handOff");
    j.a(MainProcessIPCService.PROCESS_NAME, (Parcelable)paramHandOff, m.class, f..ExternalSyntheticLambda4.INSTANCE);
    AppMethodBeat.o(10408);
  }
  
  public final void c(HandOff paramHandOff)
  {
    AppMethodBeat.i(10409);
    s.u(paramHandOff, "handOff");
    j.a(MainProcessIPCService.PROCESS_NAME, (Parcelable)paramHandOff, j.class, f..ExternalSyntheticLambda3.INSTANCE);
    AppMethodBeat.o(10409);
  }
  
  public final void d(HandOff paramHandOff)
  {
    AppMethodBeat.i(10410);
    s.u(paramHandOff, "handOff");
    j.a(MainProcessIPCService.PROCESS_NAME, (Parcelable)paramHandOff, k.class, f..ExternalSyntheticLambda11.INSTANCE);
    AppMethodBeat.o(10410);
  }
  
  public final void d(MultiTaskInfo paramMultiTaskInfo)
  {
    AppMethodBeat.i(266327);
    s.u(paramMultiTaskInfo, "multiTaskInfo");
    AppMethodBeat.o(266327);
  }
  
  public final void del(String paramString)
  {
    AppMethodBeat.i(10415);
    s.u(paramString, "key");
    j.a(MainProcessIPCService.PROCESS_NAME, (Parcelable)new IPCString(paramString), e.class, f..ExternalSyntheticLambda5.INSTANCE);
    AppMethodBeat.o(10415);
  }
  
  public final void e(HandOff paramHandOff)
  {
    AppMethodBeat.i(10414);
    s.u(paramHandOff, "handOff");
    j.a(MainProcessIPCService.PROCESS_NAME, (Parcelable)paramHandOff, u.class, f..ExternalSyntheticLambda12.INSTANCE);
    AppMethodBeat.o(10414);
  }
  
  public final void e(MultiTaskInfo paramMultiTaskInfo)
  {
    AppMethodBeat.i(266328);
    s.u(paramMultiTaskInfo, "multiTaskInfo");
    AppMethodBeat.o(266328);
  }
  
  public final void f(HandOff paramHandOff)
  {
    AppMethodBeat.i(266331);
    s.u(paramHandOff, "handOff");
    j.a(MainProcessIPCService.PROCESS_NAME, (Parcelable)paramHandOff, n.class, f..ExternalSyntheticLambda9.INSTANCE);
    AppMethodBeat.o(266331);
  }
  
  public final void f(String paramString1, String paramString2, int paramInt, String paramString3)
  {
    AppMethodBeat.i(10421);
    s.u(paramString1, "id");
    s.u(paramString2, "appId");
    s.u(paramString3, "mediaId");
    paramString1 = b.jw("id", paramString1);
    paramString2 = b.jw("appId", paramString2);
    s.u("sdkVersion", "<this>");
    paramString1 = b.a(new c[] { paramString1, paramString2, new c((kotlin.g.a.b)new b.a("sdkVersion", paramInt)), b.jw("mediaId", paramString3) });
    j.a(MainProcessIPCService.PROCESS_NAME, (Parcelable)paramString1, s.class, f..ExternalSyntheticLambda14.INSTANCE);
    AppMethodBeat.o(10421);
  }
  
  public final void fJJ()
  {
    AppMethodBeat.i(10405);
    j.a(MainProcessIPCService.PROCESS_NAME, (Parcelable)new IPCVoid(), f.class, f..ExternalSyntheticLambda7.INSTANCE);
    AppMethodBeat.o(10405);
  }
  
  public final void fJK()
  {
    AppMethodBeat.i(10416);
    j.a(MainProcessIPCService.PROCESS_NAME, (Parcelable)new IPCVoid(), b.class, f..ExternalSyntheticLambda2.INSTANCE);
    AppMethodBeat.o(10416);
  }
  
  public final boolean fJL()
  {
    AppMethodBeat.i(266335);
    if (this.JlP.qvp == 0) {
      fKd();
    }
    if (this.JlP.qvq)
    {
      if (this.JlP.qvo == 1)
      {
        i = 1;
        if ((i == 0) || (this.JlP.qvp < 1661009920)) {
          if (this.JlP.qvo != 2) {
            break label103;
          }
        }
      }
      label103:
      for (int i = 1;; i = 0)
      {
        if ((i == 0) || (this.JlP.qvp < 318898176)) {
          break label108;
        }
        AppMethodBeat.o(266335);
        return true;
        i = 0;
        break;
      }
    }
    label108:
    AppMethodBeat.o(266335);
    return false;
  }
  
  public final HandOff fJM()
  {
    AppMethodBeat.i(10424);
    HandOff localHandOff = (HandOff)j.a(MainProcessIPCService.PROCESS_NAME, (Parcelable)new IPCVoid(), g.class);
    AppMethodBeat.o(10424);
    return localHandOff;
  }
  
  public final void g(HandOff paramHandOff)
  {
    AppMethodBeat.i(10423);
    j.a(MainProcessIPCService.PROCESS_NAME, (Parcelable)paramHandOff, o.class, f..ExternalSyntheticLambda8.INSTANCE);
    AppMethodBeat.o(10423);
  }
  
  public final void h(HandOff paramHandOff)
  {
    AppMethodBeat.i(10425);
    s.u(paramHandOff, "handOff");
    AppMethodBeat.o(10425);
  }
  
  public final void i(HandOff paramHandOff)
  {
    AppMethodBeat.i(10426);
    s.u(paramHandOff, "handOff");
    AppMethodBeat.o(10426);
  }
  
  public final void iw(List<? extends BallInfo> paramList)
  {
    AppMethodBeat.i(10406);
    s.u(paramList, "ballInfoList");
    AppMethodBeat.o(10406);
  }
  
  public final void ix(List<? extends MultiTaskInfo> paramList)
  {
    AppMethodBeat.i(266319);
    s.u(paramList, "multiTaskInfoList");
    AppMethodBeat.o(266319);
  }
  
  public final void j(HandOff paramHandOff)
  {
    AppMethodBeat.i(10427);
    s.u(paramHandOff, "handOff");
    AppMethodBeat.o(10427);
  }
  
  public final void jv(String paramString1, String paramString2)
  {
    AppMethodBeat.i(10419);
    s.u(paramString1, "id");
    s.u(paramString2, "arg");
    paramString1 = b.a(new c[] { b.jw("id", paramString1), b.jw("arg", paramString2) });
    j.a(MainProcessIPCService.PROCESS_NAME, (Parcelable)paramString1, q.class, f..ExternalSyntheticLambda1.INSTANCE);
    AppMethodBeat.o(10419);
  }
  
  public final void processRequest(String paramString)
  {
    AppMethodBeat.i(266341);
    s.u(paramString, "message");
    AppMethodBeat.o(266341);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/handoff/service/HandOffServiceProxy$AddWindowFromBallTask;", "Lcom/tencent/mm/ipcinvoker/IPCAsyncInvokeTask;", "Lcom/tencent/mm/plugin/ball/model/BallInfo;", "Lcom/tencent/mm/ipcinvoker/type/IPCVoid;", "()V", "invoke", "", "ballInfo", "callback", "Lcom/tencent/mm/ipcinvoker/IPCInvokeCallback;", "plugin-handoff_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
    implements d<BallInfo, IPCVoid>
  {}
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/handoff/service/HandOffServiceProxy$AllListTask;", "Lcom/tencent/mm/ipcinvoker/IPCAsyncInvokeTask;", "Lcom/tencent/mm/ipcinvoker/type/IPCVoid;", "()V", "invoke", "", "data", "callback", "Lcom/tencent/mm/ipcinvoker/IPCInvokeCallback;", "plugin-handoff_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class b
    implements d<IPCVoid, IPCVoid>
  {}
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/handoff/service/HandOffServiceProxy$CancelUploadTask;", "Lcom/tencent/mm/ipcinvoker/IPCAsyncInvokeTask;", "Lcom/tencent/mm/ipcinvoker/type/IPCString;", "Lcom/tencent/mm/ipcinvoker/type/IPCVoid;", "()V", "invoke", "", "id", "callback", "Lcom/tencent/mm/ipcinvoker/IPCInvokeCallback;", "plugin-handoff_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class c
    implements d<IPCString, IPCVoid>
  {}
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/handoff/service/HandOffServiceProxy$DelTask;", "Lcom/tencent/mm/ipcinvoker/IPCAsyncInvokeTask;", "Lcom/tencent/mm/ipcinvoker/type/IPCString;", "Lcom/tencent/mm/ipcinvoker/type/IPCVoid;", "()V", "invoke", "", "key", "callback", "Lcom/tencent/mm/ipcinvoker/IPCInvokeCallback;", "plugin-handoff_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class e
    implements d<IPCString, IPCVoid>
  {}
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/handoff/service/HandOffServiceProxy$FixHandOffTask;", "Lcom/tencent/mm/ipcinvoker/IPCAsyncInvokeTask;", "Lcom/tencent/mm/ipcinvoker/type/IPCVoid;", "()V", "invoke", "", "data", "callback", "Lcom/tencent/mm/ipcinvoker/IPCInvokeCallback;", "plugin-handoff_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class f
    implements d<IPCVoid, IPCVoid>
  {}
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/handoff/service/HandOffServiceProxy$GetCacheTask;", "Lcom/tencent/mm/ipcinvoker/IPCSyncInvokeTask;", "Lcom/tencent/mm/ipcinvoker/type/IPCVoid;", "Lcom/tencent/mm/plugin/handoff/model/HandOff;", "()V", "invoke", "data", "plugin-handoff_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class g
    implements m<IPCVoid, HandOff>
  {}
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/handoff/service/HandOffServiceProxy$GetHandOffByIdTask;", "Lcom/tencent/mm/ipcinvoker/IPCSyncInvokeTask;", "Lcom/tencent/mm/ipcinvoker/type/IPCString;", "Lcom/tencent/mm/plugin/handoff/model/HandOff;", "()V", "invoke", "id", "plugin-handoff_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class h
    implements m<IPCString, HandOff>
  {}
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/handoff/service/HandOffServiceProxy$GetHandOffByKeyTask;", "Lcom/tencent/mm/ipcinvoker/IPCSyncInvokeTask;", "Lcom/tencent/mm/ipcinvoker/type/IPCString;", "Lcom/tencent/mm/plugin/handoff/model/HandOff;", "()V", "invoke", "key", "plugin-handoff_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class i
    implements m<IPCString, HandOff>
  {}
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/handoff/service/HandOffServiceProxy$OnFileCreateTask;", "Lcom/tencent/mm/ipcinvoker/IPCAsyncInvokeTask;", "Lcom/tencent/mm/plugin/handoff/model/HandOff;", "Lcom/tencent/mm/ipcinvoker/type/IPCVoid;", "()V", "invoke", "", "handOff", "callback", "Lcom/tencent/mm/ipcinvoker/IPCInvokeCallback;", "plugin-handoff_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class j
    implements d<HandOff, IPCVoid>
  {}
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/handoff/service/HandOffServiceProxy$OnFileDestroyTask;", "Lcom/tencent/mm/ipcinvoker/IPCAsyncInvokeTask;", "Lcom/tencent/mm/plugin/handoff/model/HandOff;", "Lcom/tencent/mm/ipcinvoker/type/IPCVoid;", "()V", "invoke", "", "handOff", "callback", "Lcom/tencent/mm/ipcinvoker/IPCInvokeCallback;", "plugin-handoff_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class k
    implements d<HandOff, IPCVoid>
  {}
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/handoff/service/HandOffServiceProxy$OnWebViewCreateTask;", "Lcom/tencent/mm/ipcinvoker/IPCAsyncInvokeTask;", "Lcom/tencent/mm/plugin/handoff/model/HandOff;", "Lcom/tencent/mm/ipcinvoker/type/IPCVoid;", "()V", "invoke", "", "handOff", "callback", "Lcom/tencent/mm/ipcinvoker/IPCInvokeCallback;", "plugin-handoff_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class l
    implements d<HandOff, IPCVoid>
  {}
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/handoff/service/HandOffServiceProxy$OnWebViewDestroyTask;", "Lcom/tencent/mm/ipcinvoker/IPCAsyncInvokeTask;", "Lcom/tencent/mm/plugin/handoff/model/HandOff;", "Lcom/tencent/mm/ipcinvoker/type/IPCVoid;", "()V", "invoke", "", "handOff", "callback", "Lcom/tencent/mm/ipcinvoker/IPCInvokeCallback;", "plugin-handoff_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class m
    implements d<HandOff, IPCVoid>
  {}
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/handoff/service/HandOffServiceProxy$SendOpenRequestTask;", "Lcom/tencent/mm/ipcinvoker/IPCAsyncInvokeTask;", "Lcom/tencent/mm/plugin/handoff/model/HandOff;", "Lcom/tencent/mm/ipcinvoker/type/IPCVoid;", "()V", "invoke", "", "handOff", "callback", "Lcom/tencent/mm/ipcinvoker/IPCInvokeCallback;", "plugin-handoff_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class n
    implements d<HandOff, IPCVoid>
  {}
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/handoff/service/HandOffServiceProxy$SetCacheTask;", "Lcom/tencent/mm/ipcinvoker/IPCAsyncInvokeTask;", "Lcom/tencent/mm/plugin/handoff/model/HandOff;", "Lcom/tencent/mm/ipcinvoker/type/IPCVoid;", "()V", "invoke", "", "handOff", "callback", "Lcom/tencent/mm/ipcinvoker/IPCInvokeCallback;", "plugin-handoff_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class o
    implements d<HandOff, IPCVoid>
  {}
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/handoff/service/HandOffServiceProxy$SyncUserStatusTask;", "Lcom/tencent/mm/ipcinvoker/IPCAsyncInvokeTask;", "Lcom/tencent/mm/ipcinvoker/type/IPCVoid;", "Lcom/tencent/mm/plugin/appbrand/config/GetOnLineInfoInfoResult;", "()V", "invoke", "", "data", "callback", "Lcom/tencent/mm/ipcinvoker/IPCInvokeCallback;", "plugin-handoff_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class p
    implements d<IPCVoid, GetOnLineInfoInfoResult>
  {}
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/handoff/service/HandOffServiceProxy$UploadFail;", "Lcom/tencent/mm/ipcinvoker/IPCAsyncInvokeTask;", "Landroid/os/Bundle;", "Lcom/tencent/mm/ipcinvoker/type/IPCVoid;", "()V", "invoke", "", "data", "callback", "Lcom/tencent/mm/ipcinvoker/IPCInvokeCallback;", "plugin-handoff_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class q
    implements d<Bundle, IPCVoid>
  {}
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/handoff/service/HandOffServiceProxy$UploadSuccessCDNTask;", "Lcom/tencent/mm/ipcinvoker/IPCAsyncInvokeTask;", "Landroid/os/Bundle;", "Lcom/tencent/mm/ipcinvoker/type/IPCVoid;", "()V", "invoke", "", "data", "callback", "Lcom/tencent/mm/ipcinvoker/IPCInvokeCallback;", "plugin-handoff_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class r
    implements d<Bundle, IPCVoid>
  {}
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/handoff/service/HandOffServiceProxy$UploadSuccessCGITask;", "Lcom/tencent/mm/ipcinvoker/IPCAsyncInvokeTask;", "Landroid/os/Bundle;", "Lcom/tencent/mm/ipcinvoker/type/IPCVoid;", "()V", "invoke", "", "data", "callback", "Lcom/tencent/mm/ipcinvoker/IPCInvokeCallback;", "plugin-handoff_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class s
    implements d<Bundle, IPCVoid>
  {}
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/handoff/service/HandOffServiceProxy$UploadingTask;", "Lcom/tencent/mm/ipcinvoker/IPCSyncInvokeTask;", "Landroid/os/Bundle;", "Lcom/tencent/mm/ipcinvoker/type/IPCBoolean;", "()V", "invoke", "data", "plugin-handoff_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class t
    implements m<Bundle, IPCBoolean>
  {}
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/handoff/service/HandOffServiceProxy$UpsertTask;", "Lcom/tencent/mm/ipcinvoker/IPCAsyncInvokeTask;", "Lcom/tencent/mm/plugin/handoff/model/HandOff;", "Lcom/tencent/mm/ipcinvoker/type/IPCVoid;", "()V", "invoke", "", "handOff", "callback", "Lcom/tencent/mm/ipcinvoker/IPCInvokeCallback;", "plugin-handoff_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class u
    implements d<HandOff, IPCVoid>
  {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.handoff.c.f
 * JD-Core Version:    0.7.0.1
 */