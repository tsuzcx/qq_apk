package com.tencent.mm.plugin.emojicapture.ui;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.Window;
import androidx.appcompat.app.AppCompatActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.audio.b.g.b;
import com.tencent.mm.compatible.deviceinfo.af;
import com.tencent.mm.f.a.lf;
import com.tencent.mm.plugin.emojicapture.a.f;
import com.tencent.mm.plugin.emojicapture.a.g;
import com.tencent.mm.plugin.emojicapture.a.i;
import com.tencent.mm.plugin.emojicapture.api.EmojiCaptureReporter;
import com.tencent.mm.plugin.emojicapture.c.b.a;
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
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.s;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.x;

@com.tencent.mm.ui.base.a(3)
@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/emojicapture/ui/EmojiCaptureUI;", "Lcom/tencent/mm/ui/MMActivity;", "()V", "TAG", "", "captureContainer", "Lcom/tencent/mm/plugin/emojicapture/ui/capture/CaptureContainer;", "capturePresenter", "Lcom/tencent/mm/plugin/emojicapture/contract/CaptureContract$IPresenter;", "captureReceiver", "Lcom/tencent/mm/plugin/emojicapture/proxy/EmojiCaptureReceiver;", "editorContainer", "Lcom/tencent/mm/plugin/emojicapture/ui/editor/CaptureEditorContainer;", "editorPresenter", "Lcom/tencent/mm/plugin/emojicapture/contract/EditorContract$IPresenter;", "hardCoderSystemEventListener", "com/tencent/mm/plugin/emojicapture/ui/EmojiCaptureUI$hardCoderSystemEventListener$1", "Lcom/tencent/mm/plugin/emojicapture/ui/EmojiCaptureUI$hardCoderSystemEventListener$1;", "reporter", "Lcom/tencent/mm/plugin/emojicapture/api/EmojiCaptureReporter;", "scene", "", "state", "stickerEnable", "", "talkerName", "timeEnter", "", "uiNavigation", "com/tencent/mm/plugin/emojicapture/ui/EmojiCaptureUI$uiNavigation$1", "Lcom/tencent/mm/plugin/emojicapture/ui/EmojiCaptureUI$uiNavigation$1;", "checkPermission", "", "finish", "getForceOrientation", "getLayoutId", "initOnCreateAfterConnected", "onBackPressed", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onKeyDown", "keyCode", "event", "Landroid/view/KeyEvent;", "onPause", "onResume", "Companion", "UINavigation", "plugin-emojicapture_release"})
public final class EmojiCaptureUI
  extends MMActivity
{
  public static final a uXF;
  private final String TAG;
  private String jLI;
  private long jPf;
  private int scene;
  private int state;
  private final EmojiCaptureReporter uWp;
  private b.a uXA;
  private boolean uXB;
  private EmojiCaptureReceiver uXC;
  private final f uXD;
  private final d uXE;
  private CaptureContainer uXx;
  private CaptureEditorContainer uXy;
  private com.tencent.mm.plugin.emojicapture.c.a.a uXz;
  
  static
  {
    AppMethodBeat.i(473);
    uXF = new a((byte)0);
    AppMethodBeat.o(473);
  }
  
  public EmojiCaptureUI()
  {
    AppMethodBeat.i(472);
    this.TAG = "MicroMsg.EmojiCaptureUI";
    this.scene = 2;
    this.uWp = new EmojiCaptureReporter();
    this.uXD = new f(this);
    this.uXE = new d(this);
    AppMethodBeat.o(472);
  }
  
  public final void finish()
  {
    AppMethodBeat.i(471);
    super.finish();
    overridePendingTransition(-1, com.tencent.mm.plugin.emojicapture.a.a.uRb);
    AppMethodBeat.o(471);
  }
  
  public final int getForceOrientation()
  {
    AppMethodBeat.i(465);
    EmojiCaptureProxy.a locala = EmojiCaptureProxy.uXl;
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
    return a.g.uSH;
  }
  
  public final void onBackPressed()
  {
    AppMethodBeat.i(469);
    b.a locala = this.uXA;
    if ((locala == null) || (locala.YD() != true)) {
      EmojiCaptureUI.b.a.a(this.uXD, false);
    }
    AppMethodBeat.o(469);
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(464);
    Log.i(this.TAG, "onCreate");
    overridePendingTransition(com.tencent.mm.plugin.emojicapture.a.a.uRa, -1);
    supportRequestWindowFeature(1);
    setSelfNavigationBarVisible(8);
    super.onCreate(paramBundle);
    getWindow().addFlags(67109888);
    this.scene = getIntent().getIntExtra("enter_scene", this.scene);
    this.jPf = getIntent().getLongExtra("key_enter_time", 0L);
    this.jLI = getIntent().getStringExtra("username");
    this.uWp.scene = this.scene;
    this.uWp.jPf = this.jPf;
    j.eTp();
    g.b.afa();
    int i = getIntent().getIntExtra("key_capture_max_duration", 5);
    paramBundle = getIntent().getStringExtra("key_imitated_md5");
    d.a locala = com.tencent.mm.plugin.emojicapture.model.d.uUg;
    com.tencent.mm.plugin.emojicapture.model.d.JQ(i);
    this.uWp.uTx = paramBundle;
    this.uXx = ((CaptureContainer)findViewById(a.f.uRx));
    this.uXy = ((CaptureEditorContainer)findViewById(a.f.uRC));
    final long l = Util.currentTicks();
    paramBundle = EmojiCaptureProxy.uXl;
    EmojiCaptureProxy.a.cYi();
    paramBundle = EmojiCaptureProxy.uXl;
    paramBundle = EmojiCaptureProxy.access$getInstance$cp().getServerProxy();
    if (paramBundle != null) {
      paramBundle.connect((Runnable)new e(this, l));
    }
    paramBundle = com.tencent.mm.plugin.emojicapture.model.e.uUh;
    com.tencent.mm.plugin.emojicapture.model.e.cXw();
    AppMethodBeat.o(464);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(470);
    EventCenter.instance.removeListener((IListener)this.uXE);
    super.onDestroy();
    Object localObject = this.uXz;
    if (localObject != null) {
      ((com.tencent.mm.plugin.emojicapture.c.a.a)localObject).destroy();
    }
    localObject = this.uXx;
    if (localObject != null)
    {
      localObject = ((CaptureContainer)localObject).uYx;
      com.tencent.mm.sticker.loader.e locale = com.tencent.mm.sticker.loader.e.Vbx;
      com.tencent.mm.sticker.loader.e.b((com.tencent.mm.loader.g.f)((EditorStickerView)localObject).uZk);
      com.tencent.mm.plugin.emojicapture.model.a.f.destroy();
    }
    localObject = this.uXA;
    if (localObject != null) {
      ((b.a)localObject).destroy();
    }
    if (this.uXC != null) {
      unregisterReceiver((BroadcastReceiver)this.uXC);
    }
    localObject = EmojiCaptureProxy.uXl;
    EmojiCaptureProxy.a.cYj();
    localObject = com.tencent.mm.plugin.emojicapture.model.e.uUh;
    com.tencent.mm.plugin.emojicapture.model.e.cXx();
    com.tencent.mm.media.g.c.kVi.aUQ();
    AppMethodBeat.o(470);
  }
  
  public final boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(468);
    p.k(paramKeyEvent, "event");
    if ((af.juH.jpM == 1) && (paramInt == 700))
    {
      CaptureContainer localCaptureContainer = this.uXx;
      if ((localCaptureContainer != null) && (localCaptureContainer.uYI == true))
      {
        localCaptureContainer = this.uXx;
        if (localCaptureContainer != null) {
          localCaptureContainer.aXP();
        }
      }
    }
    boolean bool = super.onKeyDown(paramInt, paramKeyEvent);
    AppMethodBeat.o(468);
    return bool;
  }
  
  public final void onPause()
  {
    AppMethodBeat.i(466);
    super.onPause();
    if (this.state == 0)
    {
      localObject = this.uXx;
      if (localObject != null)
      {
        Log.i(((CaptureContainer)localObject).TAG, "PauseCapture");
        CaptureDecoration localCaptureDecoration = ((CaptureContainer)localObject).getDecoration();
        localCaptureDecoration.uYO.pause();
        localCaptureDecoration.uYP.pause();
        ((CaptureContainer)localObject).uYH.TL();
        AppMethodBeat.o(466);
        return;
      }
      AppMethodBeat.o(466);
      return;
    }
    Object localObject = this.uXA;
    if (localObject != null)
    {
      ((b.a)localObject).pause();
      AppMethodBeat.o(466);
      return;
    }
    AppMethodBeat.o(466);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(467);
    super.onResume();
    if (this.state == 0)
    {
      if (com.tencent.mm.pluginsdk.permission.b.f((Context)this, new String[] { "android.permission.CAMERA", "android.permission.RECORD_AUDIO" }))
      {
        localObject = this.uXx;
        if (localObject != null)
        {
          ((CaptureContainer)localObject).onResume();
          AppMethodBeat.o(467);
          return;
        }
        AppMethodBeat.o(467);
        return;
      }
      Log.i(this.TAG, "initOnCreateAfterConnected: no permission");
      AppMethodBeat.o(467);
      return;
    }
    Object localObject = this.uXA;
    if (localObject != null)
    {
      ((b.a)localObject).resume();
      AppMethodBeat.o(467);
      return;
    }
    AppMethodBeat.o(467);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/emojicapture/ui/EmojiCaptureUI$Companion;", "", "()V", "REQ_CODE_CHOOSE_IMAGE_FOR_EMOJI", "", "REQ_CODE_CROP_IMAGE_FOR_EMOJI", "REQ_CODE_SAVE_EMOJI_ALBUM", "REQ_CODE_SAVE_EMOJI_CAPTURE", "STATE_CAPTURE", "STATE_EDIT", "STATE_EDIT_PREPARE", "plugin-emojicapture_release"})
  public static final class a {}
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/emojicapture/ui/EmojiCaptureUI$UINavigation;", "", "dismissLoading", "", "exit", "success", "", "gifMd5", "", "go2Capture", "onEditorPrepared", "onVoiceFinished", "voiceText", "prepareEditor", "emojiCaptureInfo", "Lcom/tencent/mm/plugin/emojicapture/model/capture/EmojiCaptureInfo;", "showLoading", "context", "Landroid/content/Context;", "msg", "", "cancelAble", "style", "", "onCancelListener", "Landroid/content/DialogInterface$OnCancelListener;", "plugin-emojicapture_release"})
  public static abstract interface b
  {
    public abstract void a(Context paramContext, CharSequence paramCharSequence, boolean paramBoolean, DialogInterface.OnCancelListener paramOnCancelListener);
    
    public abstract void avn(String paramString);
    
    public abstract void b(com.tencent.mm.plugin.emojicapture.model.a.b paramb);
    
    public abstract void cYk();
    
    public abstract void cYl();
    
    public abstract void cYm();
    
    public abstract void w(boolean paramBoolean, String paramString);
    
    @l(iBK={1, 1, 16})
    public static final class a {}
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "<anonymous parameter 0>", "", "<anonymous parameter 1>", "", "", "kotlin.jvm.PlatformType", "grantResults", "", "onRequestPermissionsResult", "(I[Ljava/lang/String;[I)V"})
  static final class c
    implements com.tencent.mm.pluginsdk.permission.c
  {
    c(EmojiCaptureUI paramEmojiCaptureUI) {}
    
    public final void b(int paramInt, int[] paramArrayOfInt)
    {
      int j = 1;
      AppMethodBeat.i(201355);
      p.j(paramArrayOfInt, "grantResults");
      int k = paramArrayOfInt.length;
      paramInt = 0;
      int i;
      if (paramInt < k) {
        if (paramArrayOfInt[paramInt] != 0)
        {
          i = 1;
          label34:
          if (i == 0) {
            break label117;
          }
          paramInt = j;
          label41:
          if (paramInt != 0)
          {
            paramInt = a.i.permission_camera_request_again_msg;
            paramArrayOfInt = kotlin.a.e.m(paramArrayOfInt, 0);
            if (paramArrayOfInt != null) {
              break label129;
            }
          }
        }
      }
      for (;;)
      {
        h.a((Context)this.uXG.getContext(), paramInt, a.i.permission_tips_title, a.i.jump_to_settings, a.i.app_cancel, false, (DialogInterface.OnClickListener)new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            AppMethodBeat.i(451);
            p.k(paramAnonymousDialogInterface, "dialog");
            paramAnonymousDialogInterface.dismiss();
            paramAnonymousDialogInterface = this.uXH.uXG.getContext();
            Object localObject = new Intent("android.settings.MANAGE_APPLICATIONS_SETTINGS");
            localObject = new com.tencent.mm.hellhoundlib.b.a().bm(localObject);
            com.tencent.mm.hellhoundlib.a.a.b(paramAnonymousDialogInterface, ((com.tencent.mm.hellhoundlib.b.a)localObject).aFh(), "com/tencent/mm/plugin/emojicapture/ui/EmojiCaptureUI$checkPermission$1$2", "onClick", "(Landroid/content/DialogInterface;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            paramAnonymousDialogInterface.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).sf(0));
            com.tencent.mm.hellhoundlib.a.a.c(paramAnonymousDialogInterface, "com/tencent/mm/plugin/emojicapture/ui/EmojiCaptureUI$checkPermission$1$2", "onClick", "(Landroid/content/DialogInterface;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            AppMethodBeat.o(451);
          }
        }, (DialogInterface.OnClickListener)new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            AppMethodBeat.i(452);
            p.k(paramAnonymousDialogInterface, "dialog");
            paramAnonymousDialogInterface.dismiss();
            this.uXH.uXG.finish();
            AppMethodBeat.o(452);
          }
        });
        AppMethodBeat.o(201355);
        return;
        i = 0;
        break label34;
        label117:
        paramInt += 1;
        break;
        paramInt = 0;
        break label41;
        label129:
        if (paramArrayOfInt.intValue() == 0) {
          paramInt = a.i.permission_microphone_request_again_msg;
        }
      }
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/emojicapture/ui/EmojiCaptureUI$hardCoderSystemEventListener$1", "Lcom/tencent/mm/sdk/event/IListener;", "Lcom/tencent/mm/autogen/events/HardCoderSystemEvent;", "callback", "", "event", "plugin-emojicapture_release"})
  public static final class d
    extends IListener<lf>
  {}
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
  static final class e
    implements Runnable
  {
    e(EmojiCaptureUI paramEmojiCaptureUI, long paramLong) {}
    
    public final void run()
    {
      AppMethodBeat.i(455);
      Log.i(EmojiCaptureUI.a(this.uXG), "connect cost " + Util.ticksToNow(l));
      EmojiCaptureUI.b(this.uXG);
      AppMethodBeat.o(455);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/emojicapture/ui/EmojiCaptureUI$uiNavigation$1", "Lcom/tencent/mm/plugin/emojicapture/ui/EmojiCaptureUI$UINavigation;", "loading", "Lcom/tencent/mm/ui/base/MMProgressDialog;", "dismissLoading", "", "exit", "success", "", "gifMd5", "", "go2Capture", "onEditorPrepared", "onVoiceFinished", "voiceText", "prepareEditor", "emojiCaptureInfo", "Lcom/tencent/mm/plugin/emojicapture/model/capture/EmojiCaptureInfo;", "showLoading", "context", "Landroid/content/Context;", "msg", "", "cancelAble", "style", "", "onCancelListener", "Landroid/content/DialogInterface$OnCancelListener;", "plugin-emojicapture_release"})
  public static final class f
    implements EmojiCaptureUI.b
  {
    s uya;
    
    public final void a(final Context paramContext, final CharSequence paramCharSequence, final boolean paramBoolean, final DialogInterface.OnCancelListener paramOnCancelListener)
    {
      AppMethodBeat.i(461);
      p.k(paramContext, "context");
      p.k(paramCharSequence, "msg");
      com.tencent.mm.ae.d.uiThread((kotlin.g.a.a)new a(this, paramContext, paramCharSequence, paramBoolean, 0, paramOnCancelListener));
      Log.i(EmojiCaptureUI.a(this.uXG), "showLoading: " + this.uya);
      AppMethodBeat.o(461);
    }
    
    public final void avn(String paramString)
    {
      AppMethodBeat.i(460);
      b.a locala = EmojiCaptureUI.d(this.uXG);
      if (locala != null)
      {
        locala.avi(paramString);
        AppMethodBeat.o(460);
        return;
      }
      AppMethodBeat.o(460);
    }
    
    public final void b(com.tencent.mm.plugin.emojicapture.model.a.b paramb)
    {
      AppMethodBeat.i(457);
      p.k(paramb, "emojiCaptureInfo");
      Log.i(EmojiCaptureUI.a(this.uXG), "prepareEditor " + paramb.videoPath);
      Object localObject = com.tencent.mm.plugin.emojicapture.model.f.uUi;
      if (!com.tencent.mm.plugin.emojicapture.model.f.avk(paramb.videoPath))
      {
        Log.i(EmojiCaptureUI.a(this.uXG), "prepareEditor: video invalid");
        EmojiCaptureReporter.JP(2);
        paramb = com.tencent.mm.plugin.emojicapture.model.e.uUh;
        com.tencent.mm.plugin.emojicapture.model.e.cXC();
        cYk();
        AppMethodBeat.o(457);
        return;
      }
      localObject = EmojiCaptureUI.c(this.uXG);
      if (localObject != null) {
        ((CaptureEditorContainer)localObject).setVisibility(0);
      }
      localObject = EmojiCaptureUI.c(this.uXG);
      if (localObject != null) {
        ((CaptureEditorContainer)localObject).setAlpha(0.0F);
      }
      localObject = EmojiCaptureUI.d(this.uXG);
      if (localObject != null) {
        ((b.a)localObject).a(paramb);
      }
      paramb = EmojiCaptureUI.e(this.uXG);
      if (paramb != null) {
        paramb.qo();
      }
      EmojiCaptureUI.a(this.uXG, 2);
      AppMethodBeat.o(457);
    }
    
    public final void cYk()
    {
      AppMethodBeat.i(458);
      Log.i(EmojiCaptureUI.a(this.uXG), "go2Capture");
      Object localObject = EmojiCaptureUI.g(this.uXG);
      if (localObject != null) {
        ((CaptureContainer)localObject).setVisibility(0);
      }
      localObject = EmojiCaptureUI.c(this.uXG);
      if (localObject != null) {
        ((CaptureEditorContainer)localObject).setVisibility(8);
      }
      localObject = EmojiCaptureUI.g(this.uXG);
      if (localObject != null) {
        ((CaptureContainer)localObject).onResume();
      }
      EmojiCaptureUI.a(this.uXG, 0);
      AppMethodBeat.o(458);
    }
    
    public final void cYl()
    {
      AppMethodBeat.i(459);
      Log.i(EmojiCaptureUI.a(this.uXG), "onEditorPrepared");
      if (EmojiCaptureUI.f(this.uXG) == 2)
      {
        Object localObject = EmojiCaptureUI.c(this.uXG);
        if (localObject != null) {
          ((CaptureEditorContainer)localObject).setAlpha(1.0F);
        }
        localObject = EmojiCaptureUI.g(this.uXG);
        if (localObject != null) {
          ((CaptureContainer)localObject).setVisibility(8);
        }
        cYm();
        EmojiCaptureUI.a(this.uXG, 1);
      }
      AppMethodBeat.o(459);
    }
    
    public final void cYm()
    {
      AppMethodBeat.i(462);
      s locals = this.uya;
      if (locals != null) {
        locals.dismiss();
      }
      Log.i(EmojiCaptureUI.a(this.uXG), "dismissLoading: " + this.uya);
      AppMethodBeat.o(462);
    }
    
    public final void w(boolean paramBoolean, String paramString)
    {
      AppMethodBeat.i(463);
      Intent localIntent = new Intent();
      if (paramBoolean)
      {
        localIntent.putExtra("key_enter_time", EmojiCaptureUI.h(this.uXG));
        localIntent.putExtra("gif_md5", paramString);
        this.uXG.setResult(-1, localIntent);
      }
      for (;;)
      {
        this.uXG.finish();
        AppMethodBeat.o(463);
        return;
        EmojiCaptureUI.i(this.uXG).fmH = (System.currentTimeMillis() - EmojiCaptureUI.i(this.uXG).jPf);
        EmojiCaptureReporter.a(6, EmojiCaptureUI.i(this.uXG).jPf, EmojiCaptureUI.i(this.uXG).fmH, 0L, 0L, 0L, 0, 0, EmojiCaptureUI.i(this.uXG).scene);
        this.uXG.setResult(0);
      }
    }
    
    @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
    static final class a
      extends q
      implements kotlin.g.a.a<x>
    {
      a(EmojiCaptureUI.f paramf, Context paramContext, CharSequence paramCharSequence, boolean paramBoolean, int paramInt, DialogInterface.OnCancelListener paramOnCancelListener)
      {
        super();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.emojicapture.ui.EmojiCaptureUI
 * JD-Core Version:    0.7.0.1
 */