package com.tencent.mm.plugin.flutter.voip.manager;

import android.app.Activity;
import android.content.Context;
import android.os.Build.VERSION;
import android.telephony.TelephonyManager;
import android.util.Size;
import android.view.KeyEvent;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.deviceinfo.af;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.flutter.voip.b.a.c;
import com.tencent.mm.plugin.flutter.voip.b.a.e;
import com.tencent.mm.plugin.flutter.voip.b.a.f;
import com.tencent.mm.plugin.voip.SubCoreVoip;
import com.tencent.mm.plugin.voip.b.g;
import com.tencent.mm.plugin.voip.f.d;
import com.tencent.mm.plugin.voip.f.i;
import com.tencent.mm.plugin.voip.f.i.a;
import com.tencent.mm.plugin.voip.f.k;
import com.tencent.mm.plugin.voip.model.NewVoipMgr;
import com.tencent.mm.plugin.voip.model.u;
import com.tencent.mm.plugin.voip.model.v;
import com.tencent.mm.plugin.voip.model.v2protocal;
import com.tencent.mm.plugin.voip.model.x;
import com.tencent.mm.plugin.voip.video.render.j;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.cc;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/flutter/voip/manager/FlutterVoipMgr;", "Lcom/tencent/mm/plugin/voip/model/NewVoipMgr;", "engineId", "", "(Ljava/lang/String;)V", "activity", "Landroid/app/Activity;", "getActivity", "()Landroid/app/Activity;", "setActivity", "(Landroid/app/Activity;)V", "getEngineId", "()Ljava/lang/String;", "glInit", "", "hardCoderSystemEventListener", "Lcom/tencent/mm/sdk/event/IListener;", "isInit", "isLocalAttached", "isRemoteAttached", "localSurfaceTexture", "Lcom/tencent/mm/plugin/flutter/voip/ui/FlutterVoipSurfaceTexture;", "mState", "", "remoteSurfaceTexture", "roomId", "roomKey", "", "acceptVoipCall", "addCameraRenderSurfaceTexture", "", "surfaceTexture", "addRemoteRenderSurfaceTexture", "addRenderSurfaceTexture", "renderMode", "cancelCall", "checkAddRenderSurfaceTexture", "checkInitVoIPRenderMgr", "Lcom/tencent/mm/plugin/voip/video/render/VoIPRenderMgr;", "finish", "getAudioDevice", "getCurrentStreamType", "getRoomId", "getRoomKey", "getSmallStreamSizeRatio", "", "isLocal", "hangUp", "init", "isFrontCamera", "isMuted", "isPlayingUseEarPiece", "minimizeVoip", "miniOnlyHideVoip", "onActivityAttached", "onActivityDetached", "onConnected", "onError", "errCode", "errMsg", "onKeyDown", "keyCode", "event", "Landroid/view/KeyEvent;", "onReject", "onRenderTextureSizeChanged", "size", "Landroid/util/Size;", "side", "onRoomReady", "onScreenStateChange", "isScreenOn", "onShutDown", "withTip", "onSlideOpen", "onVoIPUICreate", "onVoIPUIResume", "phoneInUse", "rejectVoip", "resumeCamera", "setMuted", "muted", "setSpeakerEnabled", "enabled", "switchCamera", "(Ljava/lang/Integer;)Z", "switchState", "action", "switchToVoiceCall", "Companion", "plugin-flutter-voip_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class b
  extends NewVoipMgr
{
  public static final b.a Hns;
  private long Hnt;
  private boolean Hnu;
  private boolean Hnv;
  private boolean Hnw;
  private com.tencent.mm.plugin.flutter.voip.d.a Hnx;
  private com.tencent.mm.plugin.flutter.voip.d.a Hny;
  private IListener<?> Hnz;
  public Activity activity;
  public final String engineId;
  private boolean isInit;
  private int mState;
  public int roomId;
  
  static
  {
    AppMethodBeat.i(263563);
    Hns = new b.a((byte)0);
    AppMethodBeat.o(263563);
  }
  
  public b(String paramString)
  {
    AppMethodBeat.i(263505);
    this.engineId = paramString;
    this.Hnz = ((IListener)new FlutterVoipMgr.hardCoderSystemEventListener.1(this, com.tencent.mm.app.f.hfK));
    AppMethodBeat.o(263505);
  }
  
  private static final void a(int paramInt, b paramb)
  {
    AppMethodBeat.i(263544);
    kotlin.g.b.s.u(paramb, "this$0");
    com.tencent.mm.plugin.flutter.voip.c.b localb = com.tencent.mm.plugin.flutter.voip.c.b.HnG;
    com.tencent.mm.plugin.flutter.voip.c.b.iT(paramInt, paramb.UwS.mState);
    AppMethodBeat.o(263544);
  }
  
  private final void a(com.tencent.mm.plugin.flutter.voip.d.a parama, int paramInt)
  {
    AppMethodBeat.i(263531);
    Log.i("MicroMsg.FlutterVoipMgr", "addRenderSurfaceTexture, renderMode:" + paramInt + ", mVoipRenderMgr:" + this.UwT);
    j localj = this.UwT;
    if (localj != null)
    {
      i.a locala = i.ULP;
      i.a.are(2);
      parama.a((com.tencent.mm.plugin.flutter.voip.d.a.a)new b.b(this, localj.a(parama.HnK, paramInt), paramInt, localj));
    }
    AppMethodBeat.o(263531);
  }
  
  private final boolean aU(Activity paramActivity)
  {
    AppMethodBeat.i(263519);
    if (this.isInit)
    {
      Log.i("MicroMsg.FlutterVoipMgr", "voipMgr is inited");
      this.luk = getUserName();
      this.Uxb = hVi();
      this.Uxc = hVh();
      this.mState = getState();
      AppMethodBeat.o(263519);
      return true;
    }
    this.luk = SubCoreVoip.hVp().UBE.toUser;
    this.Uxb = SubCoreVoip.hVp().UBE.OEa;
    this.Uxc = SubCoreVoip.hVp().UBE.UvH;
    this.roomId = SubCoreVoip.hVp().UBE.UvO.UyU.roomId;
    if (this.luk == null)
    {
      Log.e("MicroMsg.FlutterVoipMgr", "username is null, can't start voip");
      AppMethodBeat.o(263519);
      return false;
    }
    if (this.Uxb) {
      try
      {
        if (fwe())
        {
          com.tencent.mm.plugin.flutter.voip.c.b localb1 = com.tencent.mm.plugin.flutter.voip.c.b.HnG;
          com.tencent.mm.plugin.flutter.voip.c.b.a(a.f.HmS);
          Toast.makeText((Context)paramActivity, b.g.voip_in_phone_tip, 0).show();
          Log.i("MicroMsg.FlutterVoipMgr", "this phone is on a call");
          SubCoreVoip.hVp().unRegister();
          super.finish();
          AppMethodBeat.o(263519);
          return false;
        }
      }
      catch (Exception localException)
      {
        Log.e("MicroMsg.FlutterVoipMgr", "not ready now!");
      }
    }
    String str = hVj();
    if (str != null)
    {
      com.tencent.mm.plugin.flutter.voip.c.b localb2 = com.tencent.mm.plugin.flutter.voip.c.b.HnG;
      com.tencent.mm.plugin.flutter.voip.c.b.a(a.f.HmR, str);
    }
    if ((!this.Uxb) && (!SubCoreVoip.hVp().UBE.hWB()))
    {
      Log.e("MicroMsg.FlutterVoipMgr", "is out call, but kenerl is not working");
      str = this.luk;
      if (this.Uxc)
      {
        paramActivity = cc.adkp;
        if (!this.Uxb) {
          break label320;
        }
      }
      label320:
      for (int i = 1;; i = 0)
      {
        com.tencent.mm.plugin.voip.model.s.a(str, paramActivity, i, 4, MMApplicationContext.getContext().getString(b.g.voip_call_cancel_msg_from), false);
        AppMethodBeat.o(263519);
        return false;
        paramActivity = cc.adko;
        break;
      }
    }
    if (!this.Uxr)
    {
      paramActivity = (Context)paramActivity;
      str = this.luk;
      kotlin.g.b.s.checkNotNull(str);
      a(paramActivity, str, this.Uxb, this.Uxc, this.roomId);
    }
    this.isInit = true;
    AppMethodBeat.o(263519);
    return true;
  }
  
  private final void fwb()
  {
    AppMethodBeat.i(263525);
    if (this.Hnu)
    {
      com.tencent.mm.plugin.flutter.voip.d.a locala;
      if (!this.Hnv)
      {
        locala = this.Hnx;
        if (locala != null)
        {
          this.Hnv = true;
          a(locala, 0);
        }
      }
      if (!this.Hnw)
      {
        locala = this.Hny;
        if (locala != null)
        {
          this.Hnw = true;
          a(locala, 1);
        }
      }
    }
    AppMethodBeat.o(263525);
  }
  
  private static boolean fwe()
  {
    AppMethodBeat.i(263534);
    boolean bool;
    try
    {
      Object localObject = MMApplicationContext.getContext().getSystemService("phone");
      if (localObject != null) {
        break label69;
      }
      localObject = new NullPointerException("null cannot be cast to non-null type android.telephony.TelephonyManager");
      AppMethodBeat.o(263534);
      throw ((Throwable)localObject);
    }
    catch (Exception localException1)
    {
      bool = false;
    }
    Log.e("MicroMsg.FlutterVoipMgr", "get callState error , errMsg is %s", new Object[] { localException1.getLocalizedMessage() });
    AppMethodBeat.o(263534);
    return bool;
    label69:
    int i = ((TelephonyManager)localException1).getCallState();
    switch (i)
    {
    default: 
      bool = false;
    }
    for (;;)
    {
      try
      {
        Log.i("MicroMsg.FlutterVoipMgr", "TelephoneManager.callState is %d", new Object[] { Integer.valueOf(i) });
      }
      catch (Exception localException2) {}
      break;
      bool = false;
      continue;
      bool = true;
    }
  }
  
  private final int fwf()
  {
    AppMethodBeat.i(263538);
    Object localObject = com.tencent.mm.plugin.audio.c.a.uVi;
    int i;
    if (com.tencent.mm.plugin.audio.c.a.a.cTW().cTV())
    {
      localObject = com.tencent.mm.plugin.audio.c.a.uVi;
      i = com.tencent.mm.plugin.audio.c.a.a.cTW().cTR();
      AppMethodBeat.o(263538);
      return i;
    }
    if (!k.arj(getState()))
    {
      i = 2;
      if (this.Uxb) {
        if (!this.Uxc)
        {
          if (af.lXZ.lRC < 0) {
            break label242;
          }
          i = af.lXZ.lRC;
        }
      }
    }
    for (;;)
    {
      localObject = com.tencent.mm.plugin.audio.c.a.uVi;
      localObject = com.tencent.mm.plugin.audio.d.b.uVo;
      int j = i;
      if (!com.tencent.mm.plugin.audio.d.b.cTX())
      {
        j = i;
        if (af.lXZ.lRE < 0) {}
      }
      for (j = af.lXZ.lRE;; j = SubCoreVoip.hVp().UBE.UvO.gdZ())
      {
        Log.i("MicroMsg.FlutterVoipMgr", "Current StreamType:%d", new Object[] { Integer.valueOf(j) });
        AppMethodBeat.o(263538);
        return j;
        i = 3;
        localObject = com.tencent.mm.plugin.audio.c.a.uVi;
        if (com.tencent.mm.plugin.audio.c.a.a.cTW().cTQ())
        {
          if (af.lXZ.lRC < 0) {
            break label242;
          }
          i = af.lXZ.lRC;
          break;
        }
        if (af.lXZ.lRz < 0) {
          break;
        }
        i = af.lXZ.lRz;
        break;
        localObject = com.tencent.mm.plugin.audio.c.a.uVi;
        if (!com.tencent.mm.plugin.audio.c.a.a.cTW().cTQ()) {
          break;
        }
        if (af.lXZ.lRC < 0) {
          break label242;
        }
        i = af.lXZ.lRC;
        break;
      }
      label242:
      i = 0;
    }
  }
  
  private final void fwg()
  {
    AppMethodBeat.i(263542);
    if (!this.Uxb)
    {
      fvX();
      if ((SubCoreVoip.hVp().huY) && (this.Uxc)) {
        hVU();
      }
    }
    AppMethodBeat.o(263542);
  }
  
  public final void By(int paramInt)
  {
    AppMethodBeat.i(263573);
    super.By(paramInt);
    if (!(this.UwU instanceof com.tencent.mm.plugin.flutter.voip.d.b)) {
      this.qse.post(new b..ExternalSyntheticLambda0(paramInt, this));
    }
    AppMethodBeat.o(263573);
  }
  
  public final void a(com.tencent.mm.plugin.flutter.voip.d.a parama)
  {
    AppMethodBeat.i(263613);
    kotlin.g.b.s.u(parama, "surfaceTexture");
    Log.i("MicroMsg.FlutterVoipMgr", kotlin.g.b.s.X("addCameraRenderSurfaceTexture ", parama.HnK));
    this.Hnx = parama;
    this.Hnv = false;
    fwb();
    AppMethodBeat.o(263613);
  }
  
  public final boolean aT(Activity paramActivity)
  {
    AppMethodBeat.i(263581);
    kotlin.g.b.s.u(paramActivity, "activity");
    SubCoreVoip.hVp().a(MMApplicationContext.getContext(), (x)this);
    if (aU(paramActivity))
    {
      com.tencent.mm.plugin.ball.service.c.cYC().a(false, null);
      com.tencent.mm.plugin.voip.c.a.a.Uvh.hVt();
      if (this.UwU != null) {
        this.UwU.uninit();
      }
      this.UwU = ((com.tencent.mm.plugin.voip.ui.b)new com.tencent.mm.plugin.flutter.voip.d.b(this));
      a(this.UwU, 1);
      this.Hnz.alive();
      AppMethodBeat.o(263581);
      return true;
    }
    SubCoreVoip.hVp().b(MMApplicationContext.getContext(), (x)this);
    AppMethodBeat.o(263581);
    return false;
  }
  
  public final void b(Size paramSize, int paramInt)
  {
    AppMethodBeat.i(263589);
    kotlin.g.b.s.u(paramSize, "size");
    Object localObject;
    if (paramInt == 0)
    {
      localObject = this.Hnx;
      if (localObject != null)
      {
        localObject = ((com.tencent.mm.plugin.flutter.voip.d.a)localObject).HnM;
        if (localObject != null)
        {
          ((kotlin.g.a.b)localObject).invoke(paramSize);
          AppMethodBeat.o(263589);
        }
      }
    }
    else
    {
      localObject = this.Hny;
      if (localObject != null)
      {
        localObject = ((com.tencent.mm.plugin.flutter.voip.d.a)localObject).HnM;
        if (localObject != null) {
          ((kotlin.g.a.b)localObject).invoke(paramSize);
        }
      }
    }
    AppMethodBeat.o(263589);
  }
  
  public final void b(com.tencent.mm.plugin.flutter.voip.d.a parama)
  {
    AppMethodBeat.i(263619);
    kotlin.g.b.s.u(parama, "surfaceTexture");
    Log.i("MicroMsg.FlutterVoipMgr", kotlin.g.b.s.X("addCameraRenderSurfaceTexture ", parama.HnK));
    this.Hny = parama;
    this.Hnw = false;
    fwb();
    AppMethodBeat.o(263619);
  }
  
  public final void finish()
  {
    AppMethodBeat.i(263667);
    super.finish();
    Log.i("MicroMsg.FlutterVoipMgr", kotlin.g.b.s.X("finish: activity=", this.activity));
    if (this.activity == null)
    {
      localObject = com.tencent.mm.plugin.flutter.b.b.Hke;
      com.tencent.mm.plugin.flutter.b.b.clear(this.engineId);
    }
    Object localObject = com.tencent.mm.plugin.flutter.voip.c.b.HnG;
    com.tencent.mm.plugin.flutter.voip.c.b.dispose();
    this.Hnz.dead();
    AppMethodBeat.o(263667);
  }
  
  public final void fvU()
  {
    AppMethodBeat.i(263586);
    if ((this.UwU != null) && (this.PRF != 1)) {
      a(this.UwU, 1);
    }
    AppMethodBeat.o(263586);
  }
  
  public final boolean fvV()
  {
    AppMethodBeat.i(263595);
    if (this.Uxc)
    {
      bool = hVJ();
      AppMethodBeat.o(263595);
      return bool;
    }
    boolean bool = hVL();
    AppMethodBeat.o(263595);
    return bool;
  }
  
  public final void fvW()
  {
    AppMethodBeat.i(263599);
    super.fvW();
    if (!(this.UwU instanceof com.tencent.mm.plugin.flutter.voip.d.b))
    {
      com.tencent.mm.plugin.flutter.voip.c.b localb = com.tencent.mm.plugin.flutter.voip.c.b.HnG;
      com.tencent.mm.plugin.flutter.voip.c.b.a(a.c.Hmn);
    }
    AppMethodBeat.o(263599);
  }
  
  public final boolean fvX()
  {
    AppMethodBeat.i(263606);
    if (this.Uxc)
    {
      bool = hVK();
      AppMethodBeat.o(263606);
      return bool;
    }
    boolean bool = hVM();
    AppMethodBeat.o(263606);
    return bool;
  }
  
  public final boolean fvY()
  {
    AppMethodBeat.i(263610);
    if (this.Uxc)
    {
      bool = hVN();
      AppMethodBeat.o(263610);
      return bool;
    }
    boolean bool = hVO();
    AppMethodBeat.o(263610);
    return bool;
  }
  
  public final int fvZ()
  {
    AppMethodBeat.i(263623);
    d locald = this.UwR;
    if ((locald != null) && (locald.cTU() == true)) {}
    for (int i = 1; i != 0; i = 0)
    {
      AppMethodBeat.o(263623);
      return 1;
    }
    locald = this.UwR;
    if (locald == null)
    {
      AppMethodBeat.o(263623);
      return 2;
    }
    i = locald.Uxg;
    AppMethodBeat.o(263623);
    return i;
  }
  
  public final j fwa()
  {
    AppMethodBeat.i(263640);
    j localj = super.fwa();
    localj.UTv = ((kotlin.g.a.a)new b.c(this, localj));
    fwb();
    kotlin.g.b.s.s(localj, "super.checkInitVoIPRende…urfaceTexture()\n        }");
    AppMethodBeat.o(263640);
    return localj;
  }
  
  public final void fwc()
  {
    AppMethodBeat.i(263646);
    if (this.UwT != null) {
      this.UwT.idv();
    }
    AppMethodBeat.o(263646);
  }
  
  public final void fwd()
  {
    AppMethodBeat.i(263649);
    super.fwd();
    this.roomId = SubCoreVoip.hVp().UBE.UvO.UyU.roomId;
    this.Hnt = SubCoreVoip.hVp().UBE.UvO.UyU.Hnt;
    Log.i("MicroMsg.FlutterVoipMgr", "onRoomReady, roomId:" + this.roomId + ", roomKey:" + this.Hnt);
    AppMethodBeat.o(263649);
  }
  
  public final boolean isMuted()
  {
    return this.UwR.mIsMute;
  }
  
  public final void onConnected()
  {
    AppMethodBeat.i(263663);
    super.onConnected();
    Log.i("MicroMsg.FlutterVoipMgr", "onConnected");
    com.tencent.mm.plugin.flutter.voip.c.b localb = com.tencent.mm.plugin.flutter.voip.c.b.HnG;
    com.tencent.mm.plugin.flutter.voip.c.b.VU(SubCoreVoip.hVp().UBE.UvO.UyU.roomId);
    if (this.UwR.mIsMute) {
      vH(true);
    }
    AppMethodBeat.o(263663);
  }
  
  public final void onError(int paramInt, String paramString)
  {
    AppMethodBeat.i(263659);
    super.onError(paramInt, paramString);
    Log.i("MicroMsg.FlutterVoipMgr", "onError " + paramInt + ", " + paramString);
    paramString = com.tencent.mm.plugin.flutter.voip.c.b.HnG;
    paramString = a.e.HmC;
    switch (paramInt)
    {
    default: 
      paramString = a.e.HmD;
    }
    for (;;)
    {
      com.tencent.mm.plugin.flutter.voip.c.b.a(paramString);
      AppMethodBeat.o(263659);
      return;
      paramString = a.e.HmE;
      continue;
      paramString = a.e.HmI;
      continue;
      paramString = a.e.HmF;
      continue;
      paramString = a.e.HmG;
      continue;
      paramString = a.e.HmH;
      continue;
      paramString = a.e.HmJ;
      continue;
      paramString = a.e.HmK;
    }
  }
  
  public final boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(263676);
    kotlin.g.b.s.u(paramKeyEvent, "event");
    if (!com.tencent.mm.plugin.ringtone.c.gOk()) {
      switch (paramInt)
      {
      }
    }
    while ((af.lXY.lSU == 1) && (paramInt == 700))
    {
      fwg();
      AppMethodBeat.o(263676);
      return true;
      if (!SubCoreVoip.hVp().dro())
      {
        paramKeyEvent = com.tencent.mm.plugin.audio.c.a.uVi;
        if (com.tencent.mm.plugin.audio.c.a.a.cTW().cTV()) {
          paramKeyEvent = com.tencent.mm.plugin.audio.c.a.uVi;
        }
        for (paramInt = com.tencent.mm.plugin.audio.c.a.a.cTW().cTR();; paramInt = ((com.tencent.mm.plugin.ringtone.a)h.ax(com.tencent.mm.plugin.ringtone.a.class)).getStreamType())
        {
          paramKeyEvent = com.tencent.mm.plugin.audio.c.a.uVi;
          com.tencent.mm.plugin.audio.c.a.a.cTW().EZ(paramInt);
          AppMethodBeat.o(263676);
          return true;
        }
      }
      paramKeyEvent = com.tencent.mm.plugin.audio.c.a.uVi;
      if (com.tencent.mm.plugin.audio.c.a.a.cTW().cTV()) {
        paramKeyEvent = com.tencent.mm.plugin.audio.c.a.uVi;
      }
      for (paramInt = com.tencent.mm.plugin.audio.c.a.a.cTW().cTR();; paramInt = fwf())
      {
        paramKeyEvent = com.tencent.mm.plugin.audio.c.a.uVi;
        com.tencent.mm.plugin.audio.c.a.a.cTW().EZ(paramInt);
        break;
      }
      if (!SubCoreVoip.hVp().dro())
      {
        paramKeyEvent = com.tencent.mm.plugin.audio.c.a.uVi;
        if (com.tencent.mm.plugin.audio.c.a.a.cTW().cTV()) {
          paramKeyEvent = com.tencent.mm.plugin.audio.c.a.uVi;
        }
        for (paramInt = com.tencent.mm.plugin.audio.c.a.a.cTW().cTR();; paramInt = ((com.tencent.mm.plugin.ringtone.a)h.ax(com.tencent.mm.plugin.ringtone.a.class)).getStreamType())
        {
          paramKeyEvent = com.tencent.mm.plugin.audio.c.a.uVi;
          com.tencent.mm.plugin.audio.c.a.a.cTW().EY(paramInt);
          AppMethodBeat.o(263676);
          return true;
        }
      }
      paramKeyEvent = com.tencent.mm.plugin.audio.c.a.uVi;
      if (com.tencent.mm.plugin.audio.c.a.a.cTW().cTV()) {
        paramKeyEvent = com.tencent.mm.plugin.audio.c.a.uVi;
      }
      for (paramInt = com.tencent.mm.plugin.audio.c.a.a.cTW().cTR();; paramInt = fwf())
      {
        paramKeyEvent = com.tencent.mm.plugin.audio.c.a.uVi;
        com.tencent.mm.plugin.audio.c.a.a.cTW().EY(paramInt);
        break;
      }
      if (paramInt == 25)
      {
        if ((!SubCoreVoip.hVp().dro()) && (this.Uxb))
        {
          paramKeyEvent = com.tencent.mm.plugin.audio.c.a.uVi;
          if (com.tencent.mm.plugin.audio.c.a.a.cTW().cTV()) {
            paramKeyEvent = com.tencent.mm.plugin.audio.c.a.uVi;
          }
          for (paramInt = com.tencent.mm.plugin.audio.c.a.a.cTW().cTR();; paramInt = ((com.tencent.mm.plugin.ringtone.a)h.ax(com.tencent.mm.plugin.ringtone.a.class)).getStreamType())
          {
            paramKeyEvent = com.tencent.mm.plugin.audio.c.a.uVi;
            com.tencent.mm.plugin.audio.c.a.a.cTW().EZ(paramInt);
            AppMethodBeat.o(263676);
            return true;
          }
        }
      }
      else if ((paramInt == 24) && (this.Uxb) && (!SubCoreVoip.hVp().dro()))
      {
        paramKeyEvent = com.tencent.mm.plugin.audio.c.a.uVi;
        if (com.tencent.mm.plugin.audio.c.a.a.cTW().cTV()) {
          paramKeyEvent = com.tencent.mm.plugin.audio.c.a.uVi;
        }
        for (paramInt = com.tencent.mm.plugin.audio.c.a.a.cTW().cTR();; paramInt = ((com.tencent.mm.plugin.ringtone.a)h.ax(com.tencent.mm.plugin.ringtone.a.class)).getStreamType())
        {
          paramKeyEvent = com.tencent.mm.plugin.audio.c.a.uVi;
          com.tencent.mm.plugin.audio.c.a.a.cTW().EY(paramInt);
          AppMethodBeat.o(263676);
          return true;
        }
      }
    }
    AppMethodBeat.o(263676);
    return false;
  }
  
  public final void onScreenStateChange(boolean paramBoolean)
  {
    AppMethodBeat.i(263678);
    super.onScreenStateChange(paramBoolean);
    com.tencent.mm.plugin.flutter.voip.c.b localb = com.tencent.mm.plugin.flutter.voip.c.b.HnG;
    com.tencent.mm.plugin.flutter.voip.c.b.onScreenStateChange(paramBoolean);
    AppMethodBeat.o(263678);
  }
  
  public final void vF(boolean paramBoolean)
  {
    AppMethodBeat.i(263602);
    Log.i("MicroMsg.FlutterVoipMgr", "do minimizeVoip");
    if ((2 == this.PRF) && (Build.VERSION.SDK_INT < 24))
    {
      Log.e("MicroMsg.FlutterVoipMgr", "already is widget");
      AppMethodBeat.o(263602);
      return;
    }
    if ((262 == this.UwS.mState) || (8 == this.UwS.mState))
    {
      Log.e("MicroMsg.FlutterVoipMgr", "voip call has finished!，state is %s", new Object[] { Integer.valueOf(this.UwS.mState) });
      AppMethodBeat.o(263602);
      return;
    }
    if (this.UwU != null) {
      this.UwU.setScreenEnable(true);
    }
    this.PRF = 2;
    this.Uxi += 1;
    this.Uxs = new com.tencent.mm.plugin.voip.widget.b((com.tencent.mm.plugin.voip.ui.c)this, this.UwS.mState, this.Uxa, this.Uxc, this.Uxb, paramBoolean);
    if (((260 == this.UwS.mState) || (6 == this.UwS.mState)) && (1 != h.baE().ban().getInt(327948, 0))) {
      h.baE().ban().setInt(327948, 1);
    }
    if ((hVh()) && (this.UxR != null)) {
      this.UxR.ard(0);
    }
    hVY();
    SubCoreVoip.hVp().bp(true, paramBoolean);
    Object localObject = com.tencent.mm.plugin.flutter.voip.flutterplugin.b.HmV;
    Log.i("MicroMsg.FlutterVoIPReportAgent", "onMinimized");
    if (com.tencent.mm.plugin.flutter.voip.flutterplugin.b.HmY.teM > 0L)
    {
      localObject = com.tencent.mm.plugin.flutter.voip.flutterplugin.b.HmY;
      ((com.tencent.mm.plugin.flutter.voip.flutterplugin.b.a)localObject).duration += System.currentTimeMillis() - com.tencent.mm.plugin.flutter.voip.flutterplugin.b.HmY.teM;
    }
    com.tencent.mm.plugin.flutter.voip.flutterplugin.b.HmY.teM = -1L;
    com.tencent.mm.plugin.flutter.voip.flutterplugin.b.fvt();
    AppMethodBeat.o(263602);
  }
  
  public final boolean vG(boolean paramBoolean)
  {
    AppMethodBeat.i(263626);
    if (this.UwR != null)
    {
      d locald = this.UwR;
      if (locald != null) {
        locald.ee(paramBoolean);
      }
      AppMethodBeat.o(263626);
      return true;
    }
    AppMethodBeat.o(263626);
    return false;
  }
  
  public final void vH(boolean paramBoolean)
  {
    AppMethodBeat.i(263630);
    d locald = this.UwR;
    if (locald != null) {
      locald.GL(paramBoolean);
    }
    AppMethodBeat.o(263630);
  }
  
  public final void vI(boolean paramBoolean)
  {
    AppMethodBeat.i(263651);
    super.vI(paramBoolean);
    Log.i("MicroMsg.FlutterVoipMgr", kotlin.g.b.s.X("onShutdown withTip:", Boolean.valueOf(paramBoolean)));
    com.tencent.mm.plugin.flutter.voip.c.b localb = com.tencent.mm.plugin.flutter.voip.c.b.HnG;
    com.tencent.mm.plugin.flutter.voip.c.b.a(a.c.Hmp);
    AppMethodBeat.o(263651);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.flutter.voip.manager.b
 * JD-Core Version:    0.7.0.1
 */