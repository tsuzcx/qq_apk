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
import com.tencent.mm.g.a.jy;
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
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.MMActivity;
import d.g.b.q;
import d.l;
import d.z;

@com.tencent.mm.ui.base.a(3)
@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/emojicapture/ui/EmojiCaptureUI;", "Lcom/tencent/mm/ui/MMActivity;", "()V", "TAG", "", "captureContainer", "Lcom/tencent/mm/plugin/emojicapture/ui/capture/CaptureContainer;", "capturePresenter", "Lcom/tencent/mm/plugin/emojicapture/contract/CaptureContract$IPresenter;", "captureReceiver", "Lcom/tencent/mm/plugin/emojicapture/proxy/EmojiCaptureReceiver;", "editorContainer", "Lcom/tencent/mm/plugin/emojicapture/ui/editor/CaptureEditorContainer;", "editorPresenter", "Lcom/tencent/mm/plugin/emojicapture/contract/EditorContract$IPresenter;", "hardCoderSystemEventListener", "com/tencent/mm/plugin/emojicapture/ui/EmojiCaptureUI$hardCoderSystemEventListener$1", "Lcom/tencent/mm/plugin/emojicapture/ui/EmojiCaptureUI$hardCoderSystemEventListener$1;", "reporter", "Lcom/tencent/mm/plugin/emojicapture/api/EmojiCaptureReporter;", "scene", "", "state", "stickerEnable", "", "talkerName", "timeEnter", "", "uiNavigation", "com/tencent/mm/plugin/emojicapture/ui/EmojiCaptureUI$uiNavigation$1", "Lcom/tencent/mm/plugin/emojicapture/ui/EmojiCaptureUI$uiNavigation$1;", "checkPermission", "", "finish", "getForceOrientation", "getLayoutId", "initOnCreateAfterConnected", "onBackPressed", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onKeyDown", "keyCode", "event", "Landroid/view/KeyEvent;", "onPause", "onResume", "Companion", "UINavigation", "plugin-emojicapture_release"})
public final class EmojiCaptureUI
  extends MMActivity
{
  public static final EmojiCaptureUI.a pUx;
  private final String TAG;
  private String gno;
  private long gpU;
  private final EmojiCaptureReporter pTh;
  private CaptureContainer pUp;
  private CaptureEditorContainer pUq;
  private a.a pUr;
  private b.a pUs;
  private boolean pUt;
  private EmojiCaptureReceiver pUu;
  private final f pUv;
  private final d pUw;
  private int scene;
  private int state;
  
  static
  {
    AppMethodBeat.i(473);
    pUx = new EmojiCaptureUI.a((byte)0);
    AppMethodBeat.o(473);
  }
  
  public EmojiCaptureUI()
  {
    AppMethodBeat.i(472);
    this.TAG = "MicroMsg.EmojiCaptureUI";
    this.scene = 2;
    this.pTh = new EmojiCaptureReporter();
    this.pUv = new f(this);
    this.pUw = new d(this);
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
    EmojiCaptureProxy.a locala = EmojiCaptureProxy.pUd;
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
    return 2131493764;
  }
  
  public final void onBackPressed()
  {
    AppMethodBeat.i(469);
    b.a locala = this.pUs;
    if ((locala == null) || (locala.JU() != true)) {
      EmojiCaptureUI.b.a.a(this.pUv, false);
    }
    AppMethodBeat.o(469);
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(464);
    ad.i(this.TAG, "onCreate");
    overridePendingTransition(2130771983, -1);
    supportRequestWindowFeature(1);
    setSelfNavigationBarVisible(8);
    getWindow().addFlags(67109888);
    super.onCreate(paramBundle);
    this.scene = getIntent().getIntExtra("enter_scene", this.scene);
    this.gpU = getIntent().getLongExtra("key_enter_time", 0L);
    this.gno = getIntent().getStringExtra("username");
    this.pTh.scene = this.scene;
    this.pTh.gpU = this.gpU;
    k.dmV();
    g.b.PV();
    int i = getIntent().getIntExtra("key_capture_max_duration", 5);
    paramBundle = getIntent().getStringExtra("key_imitated_md5");
    d.a locala = com.tencent.mm.plugin.emojicapture.model.d.pQW;
    com.tencent.mm.plugin.emojicapture.model.d.Cm(i);
    this.pTh.pQm = paramBundle;
    this.pUp = ((CaptureContainer)findViewById(2131297702));
    this.pUq = ((CaptureEditorContainer)findViewById(2131299286));
    final long l = bt.HI();
    paramBundle = EmojiCaptureProxy.pUd;
    EmojiCaptureProxy.a.cki();
    paramBundle = EmojiCaptureProxy.pUd;
    paramBundle = EmojiCaptureProxy.access$getInstance$cp().getServerProxy();
    if (paramBundle != null) {
      paramBundle.connect((Runnable)new e(this, l));
    }
    paramBundle = com.tencent.mm.plugin.emojicapture.model.e.pQY;
    com.tencent.mm.plugin.emojicapture.model.e.cjv();
    AppMethodBeat.o(464);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(470);
    com.tencent.mm.sdk.b.a.IbL.d((com.tencent.mm.sdk.b.c)this.pUw);
    super.onDestroy();
    Object localObject = this.pUr;
    if (localObject != null) {
      ((a.a)localObject).destroy();
    }
    localObject = this.pUp;
    if (localObject != null)
    {
      localObject = ((CaptureContainer)localObject).pVq;
      com.tencent.mm.sticker.loader.e locale = com.tencent.mm.sticker.loader.e.ImJ;
      com.tencent.mm.sticker.loader.e.b((com.tencent.mm.loader.g.f)((EditorStickerView)localObject).pWc);
      com.tencent.mm.plugin.emojicapture.model.a.f.destroy();
    }
    localObject = this.pUs;
    if (localObject != null) {
      ((b.a)localObject).destroy();
    }
    if (this.pUu != null) {
      unregisterReceiver((BroadcastReceiver)this.pUu);
    }
    localObject = EmojiCaptureProxy.pUd;
    EmojiCaptureProxy.a.ckj();
    localObject = com.tencent.mm.plugin.emojicapture.model.e.pQY;
    com.tencent.mm.plugin.emojicapture.model.e.cjw();
    com.tencent.mm.media.g.c.hkn.atJ();
    AppMethodBeat.o(470);
  }
  
  public final boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(468);
    if ((ae.gcE.fYf == 1) && (paramInt == 700))
    {
      CaptureContainer localCaptureContainer = this.pUp;
      if ((localCaptureContainer != null) && (localCaptureContainer.pVB == true))
      {
        localCaptureContainer = this.pUp;
        if (localCaptureContainer != null) {
          localCaptureContainer.avZ();
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
      localObject = this.pUp;
      if (localObject != null)
      {
        ad.i(((CaptureContainer)localObject).TAG, "PauseCapture");
        CaptureDecoration localCaptureDecoration = ((CaptureContainer)localObject).getDecoration();
        localCaptureDecoration.pVH.pause();
        localCaptureDecoration.pVI.pause();
        ((CaptureContainer)localObject).pVA.stopPreview();
        AppMethodBeat.o(466);
        return;
      }
      AppMethodBeat.o(466);
      return;
    }
    Object localObject = this.pUs;
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
        localObject = this.pUp;
        if (localObject != null)
        {
          ((CaptureContainer)localObject).onResume();
          AppMethodBeat.o(467);
          return;
        }
        AppMethodBeat.o(467);
        return;
      }
      ad.i(this.TAG, "initOnCreateAfterConnected: no permission");
      AppMethodBeat.o(467);
      return;
    }
    Object localObject = this.pUs;
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
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/emojicapture/ui/EmojiCaptureUI$UINavigation;", "", "dismissLoading", "", "exit", "success", "", "gifMd5", "", "go2Capture", "onEditorPrepared", "onVoiceFinished", "voiceText", "prepareEditor", "emojiCaptureInfo", "Lcom/tencent/mm/plugin/emojicapture/model/capture/EmojiCaptureInfo;", "showLoading", "context", "Landroid/content/Context;", "msg", "", "cancelAble", "style", "", "onCancelListener", "Landroid/content/DialogInterface$OnCancelListener;", "plugin-emojicapture_release"})
  public static abstract interface b
  {
    public abstract void a(Context paramContext, CharSequence paramCharSequence, boolean paramBoolean, DialogInterface.OnCancelListener paramOnCancelListener);
    
    public abstract void aco(String paramString);
    
    public abstract void b(com.tencent.mm.plugin.emojicapture.model.a.b paramb);
    
    public abstract void ckk();
    
    public abstract void ckl();
    
    public abstract void ckm();
    
    public abstract void r(boolean paramBoolean, String paramString);
    
    @l(gfx={1, 1, 16})
    public static final class a {}
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"com/tencent/mm/plugin/emojicapture/ui/EmojiCaptureUI$hardCoderSystemEventListener$1", "Lcom/tencent/mm/sdk/event/IListener;", "Lcom/tencent/mm/autogen/events/HardCoderSystemEvent;", "callback", "", "event", "plugin-emojicapture_release"})
  public static final class d
    extends com.tencent.mm.sdk.b.c<jy>
  {}
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "run"})
  static final class e
    implements Runnable
  {
    e(EmojiCaptureUI paramEmojiCaptureUI, long paramLong) {}
    
    public final void run()
    {
      AppMethodBeat.i(455);
      ad.i(EmojiCaptureUI.a(this.pUy), "connect cost " + bt.aO(l));
      EmojiCaptureUI.b(this.pUy);
      AppMethodBeat.o(455);
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"com/tencent/mm/plugin/emojicapture/ui/EmojiCaptureUI$uiNavigation$1", "Lcom/tencent/mm/plugin/emojicapture/ui/EmojiCaptureUI$UINavigation;", "loading", "Lcom/tencent/mm/ui/base/MMProgressDialog;", "dismissLoading", "", "exit", "success", "", "gifMd5", "", "go2Capture", "onEditorPrepared", "onVoiceFinished", "voiceText", "prepareEditor", "emojiCaptureInfo", "Lcom/tencent/mm/plugin/emojicapture/model/capture/EmojiCaptureInfo;", "showLoading", "context", "Landroid/content/Context;", "msg", "", "cancelAble", "style", "", "onCancelListener", "Landroid/content/DialogInterface$OnCancelListener;", "plugin-emojicapture_release"})
  public static final class f
    implements EmojiCaptureUI.b
  {
    com.tencent.mm.ui.base.p pQE;
    
    public final void a(final Context paramContext, final CharSequence paramCharSequence, final boolean paramBoolean, final DialogInterface.OnCancelListener paramOnCancelListener)
    {
      AppMethodBeat.i(461);
      d.g.b.p.h(paramContext, "context");
      d.g.b.p.h(paramCharSequence, "msg");
      com.tencent.mm.ad.c.g((d.g.a.a)new a(this, paramContext, paramCharSequence, paramBoolean, paramOnCancelListener));
      ad.i(EmojiCaptureUI.a(this.pUy), "showLoading: " + this.pQE);
      AppMethodBeat.o(461);
    }
    
    public final void aco(String paramString)
    {
      AppMethodBeat.i(460);
      b.a locala = EmojiCaptureUI.d(this.pUy);
      if (locala != null)
      {
        locala.ack(paramString);
        AppMethodBeat.o(460);
        return;
      }
      AppMethodBeat.o(460);
    }
    
    public final void b(com.tencent.mm.plugin.emojicapture.model.a.b paramb)
    {
      AppMethodBeat.i(457);
      d.g.b.p.h(paramb, "emojiCaptureInfo");
      ad.i(EmojiCaptureUI.a(this.pUy), "prepareEditor " + paramb.videoPath);
      Object localObject = com.tencent.mm.plugin.emojicapture.model.f.pQZ;
      if (!com.tencent.mm.plugin.emojicapture.model.f.acm(paramb.videoPath))
      {
        ad.i(EmojiCaptureUI.a(this.pUy), "prepareEditor: video invalid");
        EmojiCaptureReporter.Cl(2);
        paramb = com.tencent.mm.plugin.emojicapture.model.e.pQY;
        com.tencent.mm.plugin.emojicapture.model.e.cjB();
        ckk();
        AppMethodBeat.o(457);
        return;
      }
      localObject = EmojiCaptureUI.c(this.pUy);
      if (localObject != null) {
        ((CaptureEditorContainer)localObject).setVisibility(0);
      }
      localObject = EmojiCaptureUI.c(this.pUy);
      if (localObject != null) {
        ((CaptureEditorContainer)localObject).setAlpha(0.0F);
      }
      localObject = EmojiCaptureUI.d(this.pUy);
      if (localObject != null) {
        ((b.a)localObject).a(paramb);
      }
      paramb = EmojiCaptureUI.e(this.pUy);
      if (paramb != null) {
        paramb.sx();
      }
      EmojiCaptureUI.a(this.pUy, 2);
      AppMethodBeat.o(457);
    }
    
    public final void ckk()
    {
      AppMethodBeat.i(458);
      ad.i(EmojiCaptureUI.a(this.pUy), "go2Capture");
      Object localObject = EmojiCaptureUI.g(this.pUy);
      if (localObject != null) {
        ((CaptureContainer)localObject).setVisibility(0);
      }
      localObject = EmojiCaptureUI.c(this.pUy);
      if (localObject != null) {
        ((CaptureEditorContainer)localObject).setVisibility(8);
      }
      localObject = EmojiCaptureUI.g(this.pUy);
      if (localObject != null) {
        ((CaptureContainer)localObject).onResume();
      }
      EmojiCaptureUI.a(this.pUy, 0);
      AppMethodBeat.o(458);
    }
    
    public final void ckl()
    {
      AppMethodBeat.i(459);
      ad.i(EmojiCaptureUI.a(this.pUy), "onEditorPrepared");
      if (EmojiCaptureUI.f(this.pUy) == 2)
      {
        Object localObject = EmojiCaptureUI.c(this.pUy);
        if (localObject != null) {
          ((CaptureEditorContainer)localObject).setAlpha(1.0F);
        }
        localObject = EmojiCaptureUI.g(this.pUy);
        if (localObject != null) {
          ((CaptureContainer)localObject).setVisibility(8);
        }
        ckm();
        EmojiCaptureUI.a(this.pUy, 1);
      }
      AppMethodBeat.o(459);
    }
    
    public final void ckm()
    {
      AppMethodBeat.i(462);
      com.tencent.mm.ui.base.p localp = this.pQE;
      if (localp != null) {
        localp.dismiss();
      }
      ad.i(EmojiCaptureUI.a(this.pUy), "dismissLoading: " + this.pQE);
      AppMethodBeat.o(462);
    }
    
    public final void r(boolean paramBoolean, String paramString)
    {
      AppMethodBeat.i(463);
      Intent localIntent = new Intent();
      if (paramBoolean)
      {
        localIntent.putExtra("key_enter_time", EmojiCaptureUI.h(this.pUy));
        localIntent.putExtra("gif_md5", paramString);
        this.pUy.setResult(-1, localIntent);
      }
      for (;;)
      {
        this.pUy.finish();
        AppMethodBeat.o(463);
        return;
        EmojiCaptureUI.i(this.pUy).dcg = (System.currentTimeMillis() - EmojiCaptureUI.i(this.pUy).gpU);
        EmojiCaptureReporter.a(6, EmojiCaptureUI.i(this.pUy).gpU, EmojiCaptureUI.i(this.pUy).dcg, 0L, 0L, 0L, 0, 0, EmojiCaptureUI.i(this.pUy).scene);
        this.pUy.setResult(0);
      }
    }
    
    @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "invoke"})
    static final class a
      extends q
      implements d.g.a.a<z>
    {
      a(EmojiCaptureUI.f paramf, Context paramContext, CharSequence paramCharSequence, boolean paramBoolean, DialogInterface.OnCancelListener paramOnCancelListener)
      {
        super();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.emojicapture.ui.EmojiCaptureUI
 * JD-Core Version:    0.7.0.1
 */