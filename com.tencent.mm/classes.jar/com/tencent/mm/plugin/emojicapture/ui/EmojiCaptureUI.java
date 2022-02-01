package com.tencent.mm.plugin.emojicapture.ui;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.Window;
import androidx.lifecycle.q;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.audio.b.g.b;
import com.tencent.mm.autogen.a.ml;
import com.tencent.mm.compatible.deviceinfo.af;
import com.tencent.mm.modelcontrol.VideoTransPara;
import com.tencent.mm.plugin.emojicapture.a.f;
import com.tencent.mm.plugin.emojicapture.a.g;
import com.tencent.mm.plugin.emojicapture.a.i;
import com.tencent.mm.plugin.emojicapture.api.EmojiCaptureReporter;
import com.tencent.mm.plugin.emojicapture.c.a.b;
import com.tencent.mm.plugin.emojicapture.c.b.a;
import com.tencent.mm.plugin.emojicapture.c.b.b;
import com.tencent.mm.plugin.emojicapture.model.a.i;
import com.tencent.mm.plugin.emojicapture.model.d.a;
import com.tencent.mm.plugin.emojicapture.proxy.EmojiCaptureProxy;
import com.tencent.mm.plugin.emojicapture.proxy.EmojiCaptureProxy.a;
import com.tencent.mm.plugin.emojicapture.proxy.EmojiCaptureReceiver;
import com.tencent.mm.plugin.emojicapture.ui.capture.CaptureContainer;
import com.tencent.mm.plugin.emojicapture.ui.capture.CaptureDecoration;
import com.tencent.mm.plugin.emojicapture.ui.capture.EditorStickerView;
import com.tencent.mm.plugin.emojicapture.ui.editor.CaptureEditorContainer;
import com.tencent.mm.plugin.emojicapture.ui.editor.EditorItemContainer;
import com.tencent.mm.plugin.emojicapture.ui.editor.text.FontAnimTextView;
import com.tencent.mm.plugin.mmsight.model.j;
import com.tencent.mm.protocal.protobuf.dhn;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.w;
import kotlin.Metadata;
import kotlin.g.b.s;

@com.tencent.mm.ui.base.a(3)
@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/emojicapture/ui/EmojiCaptureUI;", "Lcom/tencent/mm/ui/MMActivity;", "()V", "TAG", "", "captureContainer", "Lcom/tencent/mm/plugin/emojicapture/ui/capture/CaptureContainer;", "capturePresenter", "Lcom/tencent/mm/plugin/emojicapture/contract/CaptureContract$IPresenter;", "captureReceiver", "Lcom/tencent/mm/plugin/emojicapture/proxy/EmojiCaptureReceiver;", "editorContainer", "Lcom/tencent/mm/plugin/emojicapture/ui/editor/CaptureEditorContainer;", "editorPresenter", "Lcom/tencent/mm/plugin/emojicapture/contract/EditorContract$IPresenter;", "hardCoderSystemEventListener", "com/tencent/mm/plugin/emojicapture/ui/EmojiCaptureUI$hardCoderSystemEventListener$1", "Lcom/tencent/mm/plugin/emojicapture/ui/EmojiCaptureUI$hardCoderSystemEventListener$1;", "reporter", "Lcom/tencent/mm/plugin/emojicapture/api/EmojiCaptureReporter;", "scene", "", "state", "stickerEnable", "", "talkerName", "timeEnter", "", "uiNavigation", "com/tencent/mm/plugin/emojicapture/ui/EmojiCaptureUI$uiNavigation$1", "Lcom/tencent/mm/plugin/emojicapture/ui/EmojiCaptureUI$uiNavigation$1;", "checkPermission", "", "finish", "getForceOrientation", "getLayoutId", "initOnCreateAfterConnected", "onBackPressed", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onKeyDown", "keyCode", "event", "Landroid/view/KeyEvent;", "onPause", "onResume", "Companion", "UINavigation", "plugin-emojicapture_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class EmojiCaptureUI
  extends MMActivity
{
  public static final EmojiCaptureUI.a yjM;
  private final String TAG;
  private String mkQ;
  private long mnX;
  private int scene;
  private int state;
  private final EmojiCaptureReporter yiI;
  private CaptureContainer yjN;
  private CaptureEditorContainer yjO;
  private com.tencent.mm.plugin.emojicapture.c.a.a yjP;
  private b.a yjQ;
  private boolean yjR;
  private EmojiCaptureReceiver yjS;
  private final c yjT;
  private final hardCoderSystemEventListener.1 yjU;
  
  static
  {
    AppMethodBeat.i(473);
    yjM = new EmojiCaptureUI.a((byte)0);
    AppMethodBeat.o(473);
  }
  
  public EmojiCaptureUI()
  {
    AppMethodBeat.i(472);
    this.TAG = "MicroMsg.EmojiCaptureUI";
    this.scene = 2;
    this.yiI = new EmojiCaptureReporter();
    this.yjT = new c(this);
    this.yjU = new IListener(com.tencent.mm.app.f.hfK) {};
    AppMethodBeat.o(472);
  }
  
  private static final void a(EmojiCaptureUI paramEmojiCaptureUI, int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    int j = 1;
    AppMethodBeat.i(269408);
    s.u(paramEmojiCaptureUI, "this$0");
    s.s(paramArrayOfInt, "grantResults");
    int k = paramArrayOfInt.length;
    paramInt = 0;
    int i;
    if (paramInt < k) {
      if (paramArrayOfInt[paramInt] != 0)
      {
        i = 1;
        label41:
        if (i == 0) {
          break label117;
        }
        paramInt = j;
        label49:
        if (paramInt != 0)
        {
          paramInt = a.i.permission_camera_request_again_msg;
          paramArrayOfString = kotlin.a.k.A(paramArrayOfInt, 0);
          if (paramArrayOfString != null) {
            break label129;
          }
        }
      }
    }
    for (;;)
    {
      com.tencent.mm.ui.base.k.a((Context)paramEmojiCaptureUI.getContext(), paramInt, a.i.permission_tips_title, a.i.jump_to_settings, a.i.app_cancel, false, new EmojiCaptureUI..ExternalSyntheticLambda1(paramEmojiCaptureUI), new EmojiCaptureUI..ExternalSyntheticLambda0(paramEmojiCaptureUI));
      AppMethodBeat.o(269408);
      return;
      i = 0;
      break label41;
      label117:
      paramInt += 1;
      break;
      paramInt = 0;
      break label49;
      label129:
      if (paramArrayOfString.intValue() == 0) {
        paramInt = a.i.permission_microphone_request_again_msg;
      }
    }
  }
  
  private static final void a(EmojiCaptureUI paramEmojiCaptureUI, long paramLong)
  {
    AppMethodBeat.i(269403);
    s.u(paramEmojiCaptureUI, "this$0");
    Log.i(paramEmojiCaptureUI.TAG, s.X("connect cost ", Long.valueOf(Util.ticksToNow(paramLong))));
    Object localObject1 = com.tencent.mm.plugin.emojicapture.model.d.ygM;
    com.tencent.mm.plugin.emojicapture.model.d.or(((com.tencent.mm.plugin.emoji.c.d)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.emoji.c.d.class)).getProvider().aUW());
    Object localObject2;
    Object localObject3;
    Object localObject4;
    label241:
    Object localObject6;
    label395:
    label451:
    int i;
    label475:
    label487:
    label508:
    int j;
    if (com.tencent.mm.modelemoji.b.bII().bIK())
    {
      com.tencent.mm.plugin.report.service.h.OAn.p(933L, 0L, 1L);
      com.tencent.mm.plugin.emojicapture.model.d.KP(((com.tencent.mm.plugin.emojicapture.b.a.a)com.tencent.mm.plugin.emojicapture.b.a.ygu.boF()).ygw);
      com.tencent.mm.plugin.emojicapture.model.d.KQ(((com.tencent.mm.plugin.emojicapture.api.a)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.emojicapture.api.a.class)).stickerRecommendCount());
      com.tencent.mm.plugin.emojicapture.b.a.ygu.init();
      boolean bool = ((com.tencent.mm.plugin.emojicapture.b.a.a)com.tencent.mm.plugin.emojicapture.b.a.ygu.boF()).nFT;
      Log.i(paramEmojiCaptureUI.TAG, s.X("onCreate useCpuCrop:", Boolean.valueOf(bool)));
      Object localObject5 = (VideoTransPara)paramEmojiCaptureUI.getIntent().getParcelableExtra("key_video_params");
      String str = paramEmojiCaptureUI.getIntent().getStringExtra("key_imitated_md5");
      localObject2 = paramEmojiCaptureUI.getIntent().getStringExtra("lens_id");
      localObject3 = ((com.tencent.mm.plugin.emoji.c.d)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.emoji.c.d.class)).getProvider().aof(str);
      paramEmojiCaptureUI.yjR = paramEmojiCaptureUI.getIntent().getBooleanExtra("sticker_enable", paramEmojiCaptureUI.yjR);
      localObject4 = paramEmojiCaptureUI.yiI;
      if (localObject3 != null) {
        break label921;
      }
      localObject1 = null;
      ((EmojiCaptureReporter)localObject4).ygn = ((String)localObject1);
      localObject1 = paramEmojiCaptureUI.yiI;
      localObject4 = com.tencent.mm.plugin.emojicapture.model.d.ygM;
      ((EmojiCaptureReporter)localObject1).ygt = com.tencent.mm.plugin.emojicapture.model.d.dDG();
      localObject4 = paramEmojiCaptureUI.yjN;
      if (localObject4 != null)
      {
        localObject1 = (Context)paramEmojiCaptureUI;
        localObject6 = (a.b)localObject4;
        s.checkNotNull(localObject5);
        paramEmojiCaptureUI.yjP = ((com.tencent.mm.plugin.emojicapture.c.a.a)new com.tencent.mm.plugin.emojicapture.e.a((Context)localObject1, (a.b)localObject6, (VideoTransPara)localObject5, (b)paramEmojiCaptureUI.yjT, paramEmojiCaptureUI.yiI));
        ((CaptureContainer)localObject4).setPresenter(paramEmojiCaptureUI.yjP);
        ((CaptureContainer)localObject4).setReporter(paramEmojiCaptureUI.yiI);
        bool = paramEmojiCaptureUI.yjR;
        localObject5 = paramEmojiCaptureUI.mkQ;
        localObject6 = ((CaptureContainer)localObject4).TAG;
        StringBuilder localStringBuilder = new StringBuilder("setup: ").append(bool).append(", ");
        if (localObject3 != null) {
          break label931;
        }
        localObject1 = null;
        Log.i((String)localObject6, localObject1 + ", " + localObject2);
        ((CaptureContainer)localObject4).yjR = bool;
        ((CaptureContainer)localObject4).ykK.setImitateEmoji((EmojiInfo)localObject3);
        if (!bool) {
          break label1036;
        }
        if (localObject3 != null) {
          break label941;
        }
        localObject1 = null;
        localObject1 = (CharSequence)localObject1;
        if ((localObject1 != null) && (((CharSequence)localObject1).length() != 0)) {
          break label951;
        }
        i = 1;
        if (i != 0) {
          break label966;
        }
        if (localObject3 != null) {
          break label956;
        }
        localObject1 = null;
        localObject2 = ((CaptureContainer)localObject4).ykI;
        localObject6 = ((CaptureContainer)localObject4).yiI;
        if (localObject6 != null) {
          break label973;
        }
        paramLong = 0L;
        if (localObject3 == null) {
          break label982;
        }
        i = 1;
        label515:
        Log.i(((EditorStickerView)localObject2).TAG, "setup: " + paramLong + ", " + localObject1);
        ((EditorStickerView)localObject2).mnX = paramLong;
        ((EditorStickerView)localObject2).ylg = ((String)localObject1);
        if (!Util.isNullOrNil((String)localObject5)) {
          break label987;
        }
        localObject3 = ((EditorStickerView)localObject2).yiI;
        if (localObject3 != null) {
          ((EmojiCaptureReporter)localObject3).ygs = 1;
        }
        label590:
        localObject3 = ((EditorStickerView)localObject2).yli;
        localObject6 = new dhn();
        ((dhn)localObject6).session_id = String.valueOf(paramLong);
        ((dhn)localObject6).wwH = ((String)localObject5);
        ((com.tencent.mm.plugin.emojicapture.model.a.f)localObject3).yhv = ((dhn)localObject6).toByteArray();
        if (!Util.isNullOrNil((String)localObject5)) {
          break label1008;
        }
        j = 0;
        label643:
        ((com.tencent.mm.plugin.emojicapture.model.a.f)localObject3).requestType = j;
        localObject3 = (CharSequence)localObject1;
        if ((localObject3 != null) && (((CharSequence)localObject3).length() != 0)) {
          break label1014;
        }
        j = 1;
        label675:
        if (j != 0) {
          break label1020;
        }
        ((EditorStickerView)localObject2).ylj.apm((String)localObject1);
        ((EditorStickerView)localObject2).yli.apl((String)localObject1);
        label700:
        localObject1 = com.tencent.mm.sticker.loader.e.acCJ;
        com.tencent.mm.sticker.loader.e.a((com.tencent.mm.loader.f.e)((EditorStickerView)localObject2).ylq);
        ((CaptureContainer)localObject4).ykI.setReporter(((CaptureContainer)localObject4).yiI);
        ((CaptureContainer)localObject4).ykI.setShow(true);
      }
      label738:
      localObject1 = paramEmojiCaptureUI.yjO;
      if (localObject1 != null)
      {
        paramEmojiCaptureUI.yjQ = ((b.a)new com.tencent.mm.plugin.emojicapture.e.c((Context)paramEmojiCaptureUI, (b.b)localObject1, (b)paramEmojiCaptureUI.yjT, str, paramEmojiCaptureUI.yiI));
        ((CaptureEditorContainer)localObject1).setPresenter(paramEmojiCaptureUI.yjQ);
        ((CaptureEditorContainer)localObject1).setReporter(paramEmojiCaptureUI.yiI);
      }
      if (!com.tencent.mm.pluginsdk.permission.b.g((Context)paramEmojiCaptureUI, new String[] { "android.permission.CAMERA", "android.permission.RECORD_AUDIO" })) {
        break label1057;
      }
      localObject1 = paramEmojiCaptureUI.yjN;
      if (localObject1 != null) {
        ((CaptureContainer)localObject1).onResume();
      }
    }
    for (;;)
    {
      paramEmojiCaptureUI.yjU.alive();
      paramEmojiCaptureUI.yjS = new EmojiCaptureReceiver();
      localObject1 = new IntentFilter("com.tencent.mm.Emoji_Capture_Res");
      ((IntentFilter)localObject1).addAction("com.tencent.mm.Emoji_Capture_Upload");
      paramEmojiCaptureUI.registerReceiver((BroadcastReceiver)paramEmojiCaptureUI.yjS, (IntentFilter)localObject1);
      EmojiCaptureReporter.KN(0);
      AppMethodBeat.o(269403);
      return;
      com.tencent.mm.plugin.report.service.h.OAn.p(933L, 1L, 1L);
      break;
      label921:
      localObject1 = ((EmojiInfo)localObject3).field_lensId;
      break label241;
      label931:
      localObject1 = ((EmojiInfo)localObject3).getMd5();
      break label395;
      label941:
      localObject1 = ((EmojiInfo)localObject3).field_lensId;
      break label451;
      label951:
      i = 0;
      break label475;
      label956:
      localObject1 = ((EmojiInfo)localObject3).field_lensId;
      break label487;
      label966:
      localObject1 = localObject2;
      break label487;
      label973:
      paramLong = ((EmojiCaptureReporter)localObject6).mnX;
      break label508;
      label982:
      i = 0;
      break label515;
      label987:
      localObject3 = ((EditorStickerView)localObject2).yiI;
      if (localObject3 == null) {
        break label590;
      }
      ((EmojiCaptureReporter)localObject3).ygs = 2;
      break label590;
      label1008:
      j = 1;
      break label643;
      label1014:
      j = 0;
      break label675;
      label1020:
      if (i == 0) {
        break label700;
      }
      ((EditorStickerView)localObject2).ylj.yhH = 0;
      break label700;
      label1036:
      ((CaptureContainer)localObject4).ykI.setShow(false);
      ((CaptureContainer)localObject4).ykK.setStickerInfo(null);
      break label738;
      label1057:
      com.tencent.mm.pluginsdk.permission.b.a(1001, new EmojiCaptureUI..ExternalSyntheticLambda2(paramEmojiCaptureUI), new String[] { "android.permission.CAMERA", "android.permission.RECORD_AUDIO" });
      Log.i(paramEmojiCaptureUI.TAG, "initOnCreateAfterConnected: no permission");
    }
  }
  
  private static final void a(EmojiCaptureUI paramEmojiCaptureUI, DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(269406);
    s.u(paramEmojiCaptureUI, "this$0");
    s.u(paramDialogInterface, "dialog");
    paramDialogInterface.dismiss();
    com.tencent.mm.pluginsdk.permission.b.lx((Context)paramEmojiCaptureUI.getContext());
    AppMethodBeat.o(269406);
  }
  
  private static final void b(EmojiCaptureUI paramEmojiCaptureUI, DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(269407);
    s.u(paramEmojiCaptureUI, "this$0");
    s.u(paramDialogInterface, "dialog");
    paramDialogInterface.dismiss();
    paramEmojiCaptureUI.finish();
    AppMethodBeat.o(269407);
  }
  
  public final void finish()
  {
    AppMethodBeat.i(471);
    super.finish();
    overridePendingTransition(-1, com.tencent.mm.plugin.emojicapture.a.a.ydP);
    AppMethodBeat.o(471);
  }
  
  public final int getForceOrientation()
  {
    AppMethodBeat.i(465);
    EmojiCaptureProxy.a locala = EmojiCaptureProxy.yjA;
    if (EmojiCaptureProxy.access$getInstance$cp().getEnableAutoRotate())
    {
      AppMethodBeat.o(465);
      return 7;
    }
    AppMethodBeat.o(465);
    return 1;
  }
  
  public final int getLayoutId()
  {
    return a.g.yfv;
  }
  
  public final void onBackPressed()
  {
    int i = 1;
    AppMethodBeat.i(469);
    b.a locala = this.yjQ;
    if ((locala != null) && (locala.aAx() == true)) {}
    for (;;)
    {
      if (i == 0) {
        EmojiCaptureUI.b.a.a((b)this.yjT, false);
      }
      AppMethodBeat.o(469);
      return;
      i = 0;
    }
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(464);
    Log.i(this.TAG, "onCreate");
    overridePendingTransition(com.tencent.mm.plugin.emojicapture.a.a.ydO, -1);
    supportRequestWindowFeature(1);
    setSelfNavigationBarVisible(8);
    super.onCreate(paramBundle);
    getWindow().addFlags(67109888);
    this.scene = getIntent().getIntExtra("enter_scene", this.scene);
    this.mnX = getIntent().getLongExtra("key_enter_time", 0L);
    this.mkQ = getIntent().getStringExtra("username");
    this.yiI.scene = this.scene;
    this.yiI.mnX = this.mnX;
    j.gci();
    g.b.aGY();
    int i = getIntent().getIntExtra("key_capture_max_duration", 5);
    paramBundle = getIntent().getStringExtra("key_imitated_md5");
    d.a locala = com.tencent.mm.plugin.emojicapture.model.d.ygM;
    com.tencent.mm.plugin.emojicapture.model.d.KO(i);
    this.yiI.ygm = paramBundle;
    this.yjN = ((CaptureContainer)findViewById(a.f.yel));
    this.yjO = ((CaptureEditorContainer)findViewById(a.f.yeq));
    long l = Util.currentTicks();
    paramBundle = EmojiCaptureProxy.yjA;
    EmojiCaptureProxy.a.dEz();
    paramBundle = EmojiCaptureProxy.yjA;
    paramBundle = EmojiCaptureProxy.access$getInstance$cp().getServerProxy();
    if (paramBundle != null) {
      paramBundle.connect(new EmojiCaptureUI..ExternalSyntheticLambda3(this, l));
    }
    paramBundle = com.tencent.mm.plugin.emojicapture.model.e.ygT;
    com.tencent.mm.plugin.emojicapture.model.e.dDM();
    AppMethodBeat.o(464);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(470);
    this.yjU.dead();
    super.onDestroy();
    Object localObject = this.yjP;
    if (localObject != null) {
      ((com.tencent.mm.plugin.emojicapture.c.a.a)localObject).destroy();
    }
    localObject = this.yjN;
    if (localObject != null)
    {
      localObject = ((CaptureContainer)localObject).ykI;
      com.tencent.mm.sticker.loader.e locale = com.tencent.mm.sticker.loader.e.acCJ;
      com.tencent.mm.sticker.loader.e.b((com.tencent.mm.loader.f.e)((EditorStickerView)localObject).ylq);
      com.tencent.mm.plugin.emojicapture.model.a.f.destroy();
    }
    localObject = this.yjQ;
    if (localObject != null) {
      ((b.a)localObject).destroy();
    }
    if (this.yjS != null) {
      unregisterReceiver((BroadcastReceiver)this.yjS);
    }
    localObject = EmojiCaptureProxy.yjA;
    EmojiCaptureProxy.a.dEA();
    localObject = com.tencent.mm.plugin.emojicapture.model.e.ygT;
    com.tencent.mm.plugin.emojicapture.model.e.dDN();
    com.tencent.mm.media.g.c.nAB.bpx();
    AppMethodBeat.o(470);
  }
  
  public final boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    int i = 1;
    AppMethodBeat.i(468);
    s.u(paramKeyEvent, "event");
    CaptureContainer localCaptureContainer;
    if ((af.lXY.lSU == 1) && (paramInt == 700))
    {
      localCaptureContainer = this.yjN;
      if ((localCaptureContainer == null) || (localCaptureContainer.ykT != true)) {
        break label90;
      }
    }
    for (;;)
    {
      if (i != 0)
      {
        localCaptureContainer = this.yjN;
        if (localCaptureContainer != null) {
          localCaptureContainer.bsC();
        }
      }
      boolean bool = super.onKeyDown(paramInt, paramKeyEvent);
      AppMethodBeat.o(468);
      return bool;
      label90:
      i = 0;
    }
  }
  
  public final void onPause()
  {
    AppMethodBeat.i(466);
    super.onPause();
    Object localObject;
    if (this.state == 0)
    {
      localObject = this.yjN;
      if (localObject != null)
      {
        Log.i(((CaptureContainer)localObject).TAG, "PauseCapture");
        CaptureDecoration localCaptureDecoration = ((CaptureContainer)localObject).getDecoration();
        localCaptureDecoration.ykW.pause();
        localCaptureDecoration.ykX.pause();
        ((CaptureContainer)localObject).ykS.auq();
        AppMethodBeat.o(466);
      }
    }
    else
    {
      localObject = this.yjQ;
      if (localObject != null) {
        ((b.a)localObject).pause();
      }
    }
    AppMethodBeat.o(466);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(467);
    super.onResume();
    Object localObject;
    if (this.state == 0)
    {
      if (com.tencent.mm.pluginsdk.permission.b.g((Context)this, new String[] { "android.permission.CAMERA", "android.permission.RECORD_AUDIO" }))
      {
        localObject = this.yjN;
        if (localObject != null)
        {
          ((CaptureContainer)localObject).onResume();
          AppMethodBeat.o(467);
        }
      }
      else
      {
        Log.i(this.TAG, "initOnCreateAfterConnected: no permission");
        AppMethodBeat.o(467);
      }
    }
    else
    {
      localObject = this.yjQ;
      if (localObject != null) {
        ((b.a)localObject).resume();
      }
    }
    AppMethodBeat.o(467);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/emojicapture/ui/EmojiCaptureUI$UINavigation;", "", "dismissLoading", "", "exit", "success", "", "gifMd5", "", "go2Capture", "onEditorPrepared", "onVoiceFinished", "voiceText", "prepareEditor", "emojiCaptureInfo", "Lcom/tencent/mm/plugin/emojicapture/model/capture/EmojiCaptureInfo;", "showLoading", "context", "Landroid/content/Context;", "msg", "", "cancelAble", "style", "", "onCancelListener", "Landroid/content/DialogInterface$OnCancelListener;", "plugin-emojicapture_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static abstract interface b
  {
    public abstract void K(boolean paramBoolean, String paramString);
    
    public abstract void a(Context paramContext, CharSequence paramCharSequence, boolean paramBoolean, DialogInterface.OnCancelListener paramOnCancelListener);
    
    public abstract void apn(String paramString);
    
    public abstract void b(com.tencent.mm.plugin.emojicapture.model.a.b paramb);
    
    public abstract void dEC();
    
    public abstract void dED();
    
    public abstract void dEE();
    
    @Metadata(k=3, mv={1, 5, 1}, xi=48)
    public static final class a {}
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/emojicapture/ui/EmojiCaptureUI$uiNavigation$1", "Lcom/tencent/mm/plugin/emojicapture/ui/EmojiCaptureUI$UINavigation;", "loading", "Lcom/tencent/mm/ui/base/MMProgressDialog;", "dismissLoading", "", "exit", "success", "", "gifMd5", "", "go2Capture", "onEditorPrepared", "onVoiceFinished", "voiceText", "prepareEditor", "emojiCaptureInfo", "Lcom/tencent/mm/plugin/emojicapture/model/capture/EmojiCaptureInfo;", "showLoading", "context", "Landroid/content/Context;", "msg", "", "cancelAble", "style", "", "onCancelListener", "Landroid/content/DialogInterface$OnCancelListener;", "plugin-emojicapture_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class c
    implements EmojiCaptureUI.b
  {
    w xEL;
    
    c(EmojiCaptureUI paramEmojiCaptureUI) {}
    
    public final void K(boolean paramBoolean, String paramString)
    {
      AppMethodBeat.i(463);
      Intent localIntent = new Intent();
      if (paramBoolean)
      {
        localIntent.putExtra("key_enter_time", EmojiCaptureUI.g(this.yjV));
        localIntent.putExtra("gif_md5", paramString);
        this.yjV.setResult(-1, localIntent);
      }
      for (;;)
      {
        this.yjV.finish();
        AppMethodBeat.o(463);
        return;
        EmojiCaptureUI.h(this.yjV).hqS = (System.currentTimeMillis() - EmojiCaptureUI.h(this.yjV).mnX);
        EmojiCaptureReporter.a(6, EmojiCaptureUI.h(this.yjV).mnX, EmojiCaptureUI.h(this.yjV).hqS, 0L, 0L, 0L, 0, 0, EmojiCaptureUI.h(this.yjV).scene);
        this.yjV.setResult(0);
      }
    }
    
    public final void a(Context paramContext, CharSequence paramCharSequence, boolean paramBoolean, DialogInterface.OnCancelListener paramOnCancelListener)
    {
      AppMethodBeat.i(461);
      s.u(paramContext, "context");
      s.u(paramCharSequence, "msg");
      com.tencent.mm.ae.d.uiThread((kotlin.g.a.a)new EmojiCaptureUI.c.a(this, paramContext, paramCharSequence, paramBoolean, 0, paramOnCancelListener));
      Log.i(EmojiCaptureUI.a(this.yjV), s.X("showLoading: ", this.xEL));
      AppMethodBeat.o(461);
    }
    
    public final void apn(String paramString)
    {
      AppMethodBeat.i(460);
      b.a locala = EmojiCaptureUI.c(this.yjV);
      if (locala != null) {
        locala.api(paramString);
      }
      AppMethodBeat.o(460);
    }
    
    public final void b(com.tencent.mm.plugin.emojicapture.model.a.b paramb)
    {
      AppMethodBeat.i(457);
      s.u(paramb, "emojiCaptureInfo");
      Log.i(EmojiCaptureUI.a(this.yjV), s.X("prepareEditor ", paramb.videoPath));
      Object localObject = com.tencent.mm.plugin.emojicapture.model.f.ygU;
      if (!com.tencent.mm.plugin.emojicapture.model.f.apk(paramb.videoPath))
      {
        Log.i(EmojiCaptureUI.a(this.yjV), "prepareEditor: video invalid");
        EmojiCaptureReporter.KN(2);
        paramb = com.tencent.mm.plugin.emojicapture.model.e.ygT;
        com.tencent.mm.plugin.emojicapture.model.e.dDS();
        dEC();
        AppMethodBeat.o(457);
        return;
      }
      localObject = EmojiCaptureUI.b(this.yjV);
      if (localObject != null) {
        ((CaptureEditorContainer)localObject).setVisibility(0);
      }
      localObject = EmojiCaptureUI.b(this.yjV);
      if (localObject != null) {
        ((CaptureEditorContainer)localObject).setAlpha(0.0F);
      }
      localObject = EmojiCaptureUI.c(this.yjV);
      if (localObject != null) {
        ((b.a)localObject).a(paramb);
      }
      paramb = EmojiCaptureUI.d(this.yjV);
      if (paramb != null) {
        paramb.Pz();
      }
      EmojiCaptureUI.a(this.yjV, 2);
      AppMethodBeat.o(457);
    }
    
    public final void dEC()
    {
      AppMethodBeat.i(458);
      Log.i(EmojiCaptureUI.a(this.yjV), "go2Capture");
      Object localObject = EmojiCaptureUI.e(this.yjV);
      if (localObject != null) {
        ((CaptureContainer)localObject).setVisibility(0);
      }
      localObject = EmojiCaptureUI.b(this.yjV);
      if (localObject != null) {
        ((CaptureEditorContainer)localObject).setVisibility(8);
      }
      localObject = EmojiCaptureUI.e(this.yjV);
      if (localObject != null) {
        ((CaptureContainer)localObject).onResume();
      }
      EmojiCaptureUI.a(this.yjV, 0);
      AppMethodBeat.o(458);
    }
    
    public final void dED()
    {
      AppMethodBeat.i(459);
      Log.i(EmojiCaptureUI.a(this.yjV), "onEditorPrepared");
      if (EmojiCaptureUI.f(this.yjV) == 2)
      {
        Object localObject = EmojiCaptureUI.b(this.yjV);
        if (localObject != null) {
          ((CaptureEditorContainer)localObject).setAlpha(1.0F);
        }
        localObject = EmojiCaptureUI.e(this.yjV);
        if (localObject != null) {
          ((CaptureContainer)localObject).setVisibility(8);
        }
        dEE();
        EmojiCaptureUI.a(this.yjV, 1);
      }
      AppMethodBeat.o(459);
    }
    
    public final void dEE()
    {
      AppMethodBeat.i(462);
      w localw = this.xEL;
      if (localw != null) {
        localw.dismiss();
      }
      Log.i(EmojiCaptureUI.a(this.yjV), s.X("dismissLoading: ", this.xEL));
      AppMethodBeat.o(462);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.emojicapture.ui.EmojiCaptureUI
 * JD-Core Version:    0.7.0.1
 */