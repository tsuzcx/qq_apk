package com.tencent.mm.plugin.emojicapture.ui;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.Window;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.audio.b.g.b;
import com.tencent.mm.compatible.deviceinfo.ae;
import com.tencent.mm.g.a.ko;
import com.tencent.mm.plugin.emojicapture.api.EmojiCaptureReporter;
import com.tencent.mm.plugin.emojicapture.c.a.a;
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
import com.tencent.mm.plugin.mmsight.model.k;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.x;

@com.tencent.mm.ui.base.a(3)
@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/emojicapture/ui/EmojiCaptureUI;", "Lcom/tencent/mm/ui/MMActivity;", "()V", "TAG", "", "captureContainer", "Lcom/tencent/mm/plugin/emojicapture/ui/capture/CaptureContainer;", "capturePresenter", "Lcom/tencent/mm/plugin/emojicapture/contract/CaptureContract$IPresenter;", "captureReceiver", "Lcom/tencent/mm/plugin/emojicapture/proxy/EmojiCaptureReceiver;", "editorContainer", "Lcom/tencent/mm/plugin/emojicapture/ui/editor/CaptureEditorContainer;", "editorPresenter", "Lcom/tencent/mm/plugin/emojicapture/contract/EditorContract$IPresenter;", "hardCoderSystemEventListener", "com/tencent/mm/plugin/emojicapture/ui/EmojiCaptureUI$hardCoderSystemEventListener$1", "Lcom/tencent/mm/plugin/emojicapture/ui/EmojiCaptureUI$hardCoderSystemEventListener$1;", "reporter", "Lcom/tencent/mm/plugin/emojicapture/api/EmojiCaptureReporter;", "scene", "", "state", "stickerEnable", "", "talkerName", "timeEnter", "", "uiNavigation", "com/tencent/mm/plugin/emojicapture/ui/EmojiCaptureUI$uiNavigation$1", "Lcom/tencent/mm/plugin/emojicapture/ui/EmojiCaptureUI$uiNavigation$1;", "checkPermission", "", "finish", "getForceOrientation", "getLayoutId", "initOnCreateAfterConnected", "onBackPressed", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onKeyDown", "keyCode", "event", "Landroid/view/KeyEvent;", "onPause", "onResume", "Companion", "UINavigation", "plugin-emojicapture_release"})
public final class EmojiCaptureUI
  extends MMActivity
{
  public static final EmojiCaptureUI.a rrZ;
  private final String TAG;
  private String haD;
  private long hdz;
  private final EmojiCaptureReporter rqJ;
  private CaptureContainer rrR;
  private CaptureEditorContainer rrS;
  private a.a rrT;
  private b.a rrU;
  private boolean rrV;
  private EmojiCaptureReceiver rrW;
  private final f rrX;
  private final d rrY;
  private int scene;
  private int state;
  
  static
  {
    AppMethodBeat.i(473);
    rrZ = new EmojiCaptureUI.a((byte)0);
    AppMethodBeat.o(473);
  }
  
  public EmojiCaptureUI()
  {
    AppMethodBeat.i(472);
    this.TAG = "MicroMsg.EmojiCaptureUI";
    this.scene = 2;
    this.rqJ = new EmojiCaptureReporter();
    this.rrX = new f(this);
    this.rrY = new d(this);
    AppMethodBeat.o(472);
  }
  
  public final void finish()
  {
    AppMethodBeat.i(471);
    super.finish();
    overridePendingTransition(-1, 2130771984);
    AppMethodBeat.o(471);
  }
  
  public final int getForceOrientation()
  {
    AppMethodBeat.i(465);
    EmojiCaptureProxy.a locala = EmojiCaptureProxy.rrF;
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
    return 2131493913;
  }
  
  public final void onBackPressed()
  {
    AppMethodBeat.i(469);
    b.a locala = this.rrU;
    if ((locala == null) || (locala.Ul() != true)) {
      EmojiCaptureUI.b.a.a(this.rrX, false);
    }
    AppMethodBeat.o(469);
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(464);
    Log.i(this.TAG, "onCreate");
    overridePendingTransition(2130771983, -1);
    supportRequestWindowFeature(1);
    setSelfNavigationBarVisible(8);
    super.onCreate(paramBundle);
    getWindow().addFlags(67109888);
    this.scene = getIntent().getIntExtra("enter_scene", this.scene);
    this.hdz = getIntent().getLongExtra("key_enter_time", 0L);
    this.haD = getIntent().getStringExtra("username");
    this.rqJ.scene = this.scene;
    this.rqJ.hdz = this.hdz;
    k.ejI();
    g.b.aao();
    int i = getIntent().getIntExtra("key_capture_max_duration", 5);
    paramBundle = getIntent().getStringExtra("key_imitated_md5");
    d.a locala = com.tencent.mm.plugin.emojicapture.model.d.roA;
    com.tencent.mm.plugin.emojicapture.model.d.Gj(i);
    this.rqJ.rnQ = paramBundle;
    this.rrR = ((CaptureContainer)findViewById(2131297997));
    this.rrS = ((CaptureEditorContainer)findViewById(2131299876));
    long l = Util.currentTicks();
    paramBundle = EmojiCaptureProxy.rrF;
    EmojiCaptureProxy.a.cJA();
    paramBundle = EmojiCaptureProxy.rrF;
    paramBundle = EmojiCaptureProxy.access$getInstance$cp().getServerProxy();
    if (paramBundle != null) {
      paramBundle.connect((Runnable)new EmojiCaptureUI.e(this, l));
    }
    paramBundle = com.tencent.mm.plugin.emojicapture.model.e.roB;
    com.tencent.mm.plugin.emojicapture.model.e.cIN();
    AppMethodBeat.o(464);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(470);
    EventCenter.instance.removeListener((IListener)this.rrY);
    super.onDestroy();
    Object localObject = this.rrT;
    if (localObject != null) {
      ((a.a)localObject).destroy();
    }
    localObject = this.rrR;
    if (localObject != null)
    {
      localObject = ((CaptureContainer)localObject).rsS;
      com.tencent.mm.sticker.loader.e locale = com.tencent.mm.sticker.loader.e.NNN;
      com.tencent.mm.sticker.loader.e.b((com.tencent.mm.loader.g.f)((EditorStickerView)localObject).rtF);
      com.tencent.mm.plugin.emojicapture.model.a.f.destroy();
    }
    localObject = this.rrU;
    if (localObject != null) {
      ((b.a)localObject).destroy();
    }
    if (this.rrW != null) {
      unregisterReceiver((BroadcastReceiver)this.rrW);
    }
    localObject = EmojiCaptureProxy.rrF;
    EmojiCaptureProxy.a.cJB();
    localObject = com.tencent.mm.plugin.emojicapture.model.e.roB;
    com.tencent.mm.plugin.emojicapture.model.e.cIO();
    com.tencent.mm.media.g.c.igu.aMA();
    AppMethodBeat.o(470);
  }
  
  public final boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(468);
    p.h(paramKeyEvent, "event");
    if ((ae.gKt.gFC == 1) && (paramInt == 700))
    {
      CaptureContainer localCaptureContainer = this.rrR;
      if ((localCaptureContainer != null) && (localCaptureContainer.rtd == true))
      {
        localCaptureContainer = this.rrR;
        if (localCaptureContainer != null) {
          localCaptureContainer.aPb();
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
      localObject = this.rrR;
      if (localObject != null)
      {
        Log.i(((CaptureContainer)localObject).TAG, "PauseCapture");
        CaptureDecoration localCaptureDecoration = ((CaptureContainer)localObject).getDecoration();
        localCaptureDecoration.rtj.pause();
        localCaptureDecoration.rtk.pause();
        ((CaptureContainer)localObject).rtc.stopPreview();
        AppMethodBeat.o(466);
        return;
      }
      AppMethodBeat.o(466);
      return;
    }
    Object localObject = this.rrU;
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
      if (com.tencent.mm.pluginsdk.permission.b.e((Context)this, new String[] { "android.permission.CAMERA", "android.permission.RECORD_AUDIO" }))
      {
        localObject = this.rrR;
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
    Object localObject = this.rrU;
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
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/emojicapture/ui/EmojiCaptureUI$UINavigation;", "", "dismissLoading", "", "exit", "success", "", "gifMd5", "", "go2Capture", "onEditorPrepared", "onVoiceFinished", "voiceText", "prepareEditor", "emojiCaptureInfo", "Lcom/tencent/mm/plugin/emojicapture/model/capture/EmojiCaptureInfo;", "showLoading", "context", "Landroid/content/Context;", "msg", "", "cancelAble", "style", "", "onCancelListener", "Landroid/content/DialogInterface$OnCancelListener;", "plugin-emojicapture_release"})
  public static abstract interface b
  {
    public abstract void a(Context paramContext, CharSequence paramCharSequence, boolean paramBoolean, DialogInterface.OnCancelListener paramOnCancelListener);
    
    public abstract void ano(String paramString);
    
    public abstract void b(com.tencent.mm.plugin.emojicapture.model.a.b paramb);
    
    public abstract void cJC();
    
    public abstract void cJD();
    
    public abstract void cJE();
    
    public abstract void s(boolean paramBoolean, String paramString);
    
    @l(hxD={1, 1, 16})
    public static final class a {}
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/emojicapture/ui/EmojiCaptureUI$hardCoderSystemEventListener$1", "Lcom/tencent/mm/sdk/event/IListener;", "Lcom/tencent/mm/autogen/events/HardCoderSystemEvent;", "callback", "", "event", "plugin-emojicapture_release"})
  public static final class d
    extends IListener<ko>
  {}
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/emojicapture/ui/EmojiCaptureUI$uiNavigation$1", "Lcom/tencent/mm/plugin/emojicapture/ui/EmojiCaptureUI$UINavigation;", "loading", "Lcom/tencent/mm/ui/base/MMProgressDialog;", "dismissLoading", "", "exit", "success", "", "gifMd5", "", "go2Capture", "onEditorPrepared", "onVoiceFinished", "voiceText", "prepareEditor", "emojiCaptureInfo", "Lcom/tencent/mm/plugin/emojicapture/model/capture/EmojiCaptureInfo;", "showLoading", "context", "Landroid/content/Context;", "msg", "", "cancelAble", "style", "", "onCancelListener", "Landroid/content/DialogInterface$OnCancelListener;", "plugin-emojicapture_release"})
  public static final class f
    implements EmojiCaptureUI.b
  {
    com.tencent.mm.ui.base.q qVq;
    
    public final void a(final Context paramContext, final CharSequence paramCharSequence, final boolean paramBoolean, final DialogInterface.OnCancelListener paramOnCancelListener)
    {
      AppMethodBeat.i(461);
      p.h(paramContext, "context");
      p.h(paramCharSequence, "msg");
      com.tencent.mm.ac.d.h((kotlin.g.a.a)new a(this, paramContext, paramCharSequence, paramBoolean, 0, paramOnCancelListener));
      Log.i(EmojiCaptureUI.a(this.rsa), "showLoading: " + this.qVq);
      AppMethodBeat.o(461);
    }
    
    public final void ano(String paramString)
    {
      AppMethodBeat.i(460);
      b.a locala = EmojiCaptureUI.d(this.rsa);
      if (locala != null)
      {
        locala.ank(paramString);
        AppMethodBeat.o(460);
        return;
      }
      AppMethodBeat.o(460);
    }
    
    public final void b(com.tencent.mm.plugin.emojicapture.model.a.b paramb)
    {
      AppMethodBeat.i(457);
      p.h(paramb, "emojiCaptureInfo");
      Log.i(EmojiCaptureUI.a(this.rsa), "prepareEditor " + paramb.videoPath);
      Object localObject = com.tencent.mm.plugin.emojicapture.model.f.roC;
      if (!com.tencent.mm.plugin.emojicapture.model.f.anm(paramb.videoPath))
      {
        Log.i(EmojiCaptureUI.a(this.rsa), "prepareEditor: video invalid");
        EmojiCaptureReporter.Gi(2);
        paramb = com.tencent.mm.plugin.emojicapture.model.e.roB;
        com.tencent.mm.plugin.emojicapture.model.e.cIT();
        cJC();
        AppMethodBeat.o(457);
        return;
      }
      localObject = EmojiCaptureUI.c(this.rsa);
      if (localObject != null) {
        ((CaptureEditorContainer)localObject).setVisibility(0);
      }
      localObject = EmojiCaptureUI.c(this.rsa);
      if (localObject != null) {
        ((CaptureEditorContainer)localObject).setAlpha(0.0F);
      }
      localObject = EmojiCaptureUI.d(this.rsa);
      if (localObject != null) {
        ((b.a)localObject).a(paramb);
      }
      paramb = EmojiCaptureUI.e(this.rsa);
      if (paramb != null) {
        paramb.sA();
      }
      EmojiCaptureUI.a(this.rsa, 2);
      AppMethodBeat.o(457);
    }
    
    public final void cJC()
    {
      AppMethodBeat.i(458);
      Log.i(EmojiCaptureUI.a(this.rsa), "go2Capture");
      Object localObject = EmojiCaptureUI.g(this.rsa);
      if (localObject != null) {
        ((CaptureContainer)localObject).setVisibility(0);
      }
      localObject = EmojiCaptureUI.c(this.rsa);
      if (localObject != null) {
        ((CaptureEditorContainer)localObject).setVisibility(8);
      }
      localObject = EmojiCaptureUI.g(this.rsa);
      if (localObject != null) {
        ((CaptureContainer)localObject).onResume();
      }
      EmojiCaptureUI.a(this.rsa, 0);
      AppMethodBeat.o(458);
    }
    
    public final void cJD()
    {
      AppMethodBeat.i(459);
      Log.i(EmojiCaptureUI.a(this.rsa), "onEditorPrepared");
      if (EmojiCaptureUI.f(this.rsa) == 2)
      {
        Object localObject = EmojiCaptureUI.c(this.rsa);
        if (localObject != null) {
          ((CaptureEditorContainer)localObject).setAlpha(1.0F);
        }
        localObject = EmojiCaptureUI.g(this.rsa);
        if (localObject != null) {
          ((CaptureContainer)localObject).setVisibility(8);
        }
        cJE();
        EmojiCaptureUI.a(this.rsa, 1);
      }
      AppMethodBeat.o(459);
    }
    
    public final void cJE()
    {
      AppMethodBeat.i(462);
      com.tencent.mm.ui.base.q localq = this.qVq;
      if (localq != null) {
        localq.dismiss();
      }
      Log.i(EmojiCaptureUI.a(this.rsa), "dismissLoading: " + this.qVq);
      AppMethodBeat.o(462);
    }
    
    public final void s(boolean paramBoolean, String paramString)
    {
      AppMethodBeat.i(463);
      Intent localIntent = new Intent();
      if (paramBoolean)
      {
        localIntent.putExtra("key_enter_time", EmojiCaptureUI.h(this.rsa));
        localIntent.putExtra("gif_md5", paramString);
        this.rsa.setResult(-1, localIntent);
      }
      for (;;)
      {
        this.rsa.finish();
        AppMethodBeat.o(463);
        return;
        EmojiCaptureUI.i(this.rsa).dtZ = (System.currentTimeMillis() - EmojiCaptureUI.i(this.rsa).hdz);
        EmojiCaptureReporter.a(6, EmojiCaptureUI.i(this.rsa).hdz, EmojiCaptureUI.i(this.rsa).dtZ, 0L, 0L, 0L, 0, 0, EmojiCaptureUI.i(this.rsa).scene);
        this.rsa.setResult(0);
      }
    }
    
    @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
    static final class a
      extends kotlin.g.b.q
      implements kotlin.g.a.a<x>
    {
      a(EmojiCaptureUI.f paramf, Context paramContext, CharSequence paramCharSequence, boolean paramBoolean, int paramInt, DialogInterface.OnCancelListener paramOnCancelListener)
      {
        super();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.emojicapture.ui.EmojiCaptureUI
 * JD-Core Version:    0.7.0.1
 */