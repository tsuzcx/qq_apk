package com.tencent.mm.plugin.emojicapture.ui;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.view.Window;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.audio.b.g.b;
import com.tencent.mm.compatible.deviceinfo.ae;
import com.tencent.mm.g.a.jq;
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
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.p;
import d.y;

@com.tencent.mm.ui.base.a(3)
@d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/emojicapture/ui/EmojiCaptureUI;", "Lcom/tencent/mm/ui/MMActivity;", "()V", "TAG", "", "captureContainer", "Lcom/tencent/mm/plugin/emojicapture/ui/capture/CaptureContainer;", "capturePresenter", "Lcom/tencent/mm/plugin/emojicapture/contract/CaptureContract$IPresenter;", "captureReceiver", "Lcom/tencent/mm/plugin/emojicapture/proxy/EmojiCaptureReceiver;", "editorContainer", "Lcom/tencent/mm/plugin/emojicapture/ui/editor/CaptureEditorContainer;", "editorPresenter", "Lcom/tencent/mm/plugin/emojicapture/contract/EditorContract$IPresenter;", "hardCoderSystemEventListener", "com/tencent/mm/plugin/emojicapture/ui/EmojiCaptureUI$hardCoderSystemEventListener$1", "Lcom/tencent/mm/plugin/emojicapture/ui/EmojiCaptureUI$hardCoderSystemEventListener$1;", "reporter", "Lcom/tencent/mm/plugin/emojicapture/api/EmojiCaptureReporter;", "scene", "", "state", "stickerEnable", "", "talkerName", "timeEnter", "", "uiNavigation", "com/tencent/mm/plugin/emojicapture/ui/EmojiCaptureUI$uiNavigation$1", "Lcom/tencent/mm/plugin/emojicapture/ui/EmojiCaptureUI$uiNavigation$1;", "checkPermission", "", "finish", "getForceOrientation", "getLayoutId", "initOnCreateAfterConnected", "onBackPressed", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onKeyDown", "keyCode", "event", "Landroid/view/KeyEvent;", "onPause", "onResume", "Companion", "UINavigation", "plugin-emojicapture_release"})
public final class EmojiCaptureUI
  extends MMActivity
{
  public static final EmojiCaptureUI.a pqR;
  private final String TAG;
  private String fTK;
  private long fWr;
  private final EmojiCaptureReporter ppG;
  private CaptureContainer pqJ;
  private CaptureEditorContainer pqK;
  private a.a pqL;
  private b.a pqM;
  private boolean pqN;
  private EmojiCaptureReceiver pqO;
  private final f pqP;
  private final d pqQ;
  private int scene;
  private int state;
  
  static
  {
    AppMethodBeat.i(473);
    pqR = new EmojiCaptureUI.a((byte)0);
    AppMethodBeat.o(473);
  }
  
  public EmojiCaptureUI()
  {
    AppMethodBeat.i(472);
    this.TAG = "MicroMsg.EmojiCaptureUI";
    this.scene = 2;
    this.ppG = new EmojiCaptureReporter();
    this.pqP = new f(this);
    this.pqQ = new d(this);
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
    EmojiCaptureProxy.a locala = EmojiCaptureProxy.pqx;
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
    b.a locala = this.pqM;
    if ((locala == null) || (locala.Iu() != true)) {
      EmojiCaptureUI.b.a.a(this.pqP, false);
    }
    AppMethodBeat.o(469);
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(464);
    ac.i(this.TAG, "onCreate");
    overridePendingTransition(2130771983, -1);
    supportRequestWindowFeature(1);
    setSelfNavigationBarVisible(8);
    getWindow().addFlags(67109888);
    super.onCreate(paramBundle);
    this.scene = getIntent().getIntExtra("enter_scene", this.scene);
    this.fWr = getIntent().getLongExtra("key_enter_time", 0L);
    this.fTK = getIntent().getStringExtra("username");
    this.ppG.scene = this.scene;
    this.ppG.fWr = this.fWr;
    com.tencent.mm.plugin.mmsight.model.k.ddz();
    g.b.Om();
    int i = getIntent().getIntExtra("key_capture_max_duration", 5);
    paramBundle = getIntent().getStringExtra("key_imitated_md5");
    d.a locala = com.tencent.mm.plugin.emojicapture.model.d.pnw;
    com.tencent.mm.plugin.emojicapture.model.d.BE(i);
    this.ppG.pmM = paramBundle;
    this.pqJ = ((CaptureContainer)findViewById(2131297702));
    this.pqK = ((CaptureEditorContainer)findViewById(2131299286));
    final long l = bs.Gn();
    paramBundle = EmojiCaptureProxy.pqx;
    EmojiCaptureProxy.a.cfF();
    paramBundle = EmojiCaptureProxy.pqx;
    paramBundle = EmojiCaptureProxy.access$getInstance$cp().getServerProxy();
    if (paramBundle != null) {
      paramBundle.connect((Runnable)new e(this, l));
    }
    paramBundle = com.tencent.mm.plugin.emojicapture.model.e.pny;
    com.tencent.mm.plugin.emojicapture.model.e.ceS();
    AppMethodBeat.o(464);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(470);
    com.tencent.mm.sdk.b.a.GpY.d((com.tencent.mm.sdk.b.c)this.pqQ);
    super.onDestroy();
    Object localObject = this.pqL;
    if (localObject != null) {
      ((a.a)localObject).destroy();
    }
    localObject = this.pqJ;
    if (localObject != null)
    {
      localObject = ((CaptureContainer)localObject).prK;
      com.tencent.mm.sticker.loader.e locale = com.tencent.mm.sticker.loader.e.GAP;
      com.tencent.mm.sticker.loader.e.b((com.tencent.mm.loader.g.f)((EditorStickerView)localObject).psw);
      com.tencent.mm.plugin.emojicapture.model.a.f.destroy();
    }
    localObject = this.pqM;
    if (localObject != null) {
      ((b.a)localObject).destroy();
    }
    if (this.pqO != null) {
      unregisterReceiver((BroadcastReceiver)this.pqO);
    }
    localObject = EmojiCaptureProxy.pqx;
    EmojiCaptureProxy.a.cfG();
    localObject = com.tencent.mm.plugin.emojicapture.model.e.pny;
    com.tencent.mm.plugin.emojicapture.model.e.ceT();
    com.tencent.mm.media.f.c.gRV.aqV();
    AppMethodBeat.o(470);
  }
  
  public final boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(468);
    if ((ae.fJd.fEG == 1) && (paramInt == 700))
    {
      CaptureContainer localCaptureContainer = this.pqJ;
      if ((localCaptureContainer != null) && (localCaptureContainer.prV == true))
      {
        localCaptureContainer = this.pqJ;
        if (localCaptureContainer != null) {
          localCaptureContainer.atm();
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
      localObject = this.pqJ;
      if (localObject != null)
      {
        ac.i(((CaptureContainer)localObject).TAG, "PauseCapture");
        CaptureDecoration localCaptureDecoration = ((CaptureContainer)localObject).getDecoration();
        localCaptureDecoration.psb.pause();
        localCaptureDecoration.psc.pause();
        ((CaptureContainer)localObject).prU.stopPreview();
        AppMethodBeat.o(466);
        return;
      }
      AppMethodBeat.o(466);
      return;
    }
    Object localObject = this.pqM;
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
        localObject = this.pqJ;
        if (localObject != null)
        {
          ((CaptureContainer)localObject).onResume();
          AppMethodBeat.o(467);
          return;
        }
        AppMethodBeat.o(467);
        return;
      }
      ac.i(this.TAG, "initOnCreateAfterConnected: no permission");
      AppMethodBeat.o(467);
      return;
    }
    Object localObject = this.pqM;
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
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/emojicapture/ui/EmojiCaptureUI$UINavigation;", "", "dismissLoading", "", "exit", "success", "", "gifMd5", "", "go2Capture", "onEditorPrepared", "onVoiceFinished", "voiceText", "prepareEditor", "emojiCaptureInfo", "Lcom/tencent/mm/plugin/emojicapture/model/capture/EmojiCaptureInfo;", "showLoading", "context", "Landroid/content/Context;", "msg", "", "cancelAble", "style", "", "onCancelListener", "Landroid/content/DialogInterface$OnCancelListener;", "plugin-emojicapture_release"})
  public static abstract interface b
  {
    public abstract void YI(String paramString);
    
    public abstract void a(Context paramContext, CharSequence paramCharSequence, boolean paramBoolean, DialogInterface.OnCancelListener paramOnCancelListener);
    
    public abstract void b(com.tencent.mm.plugin.emojicapture.model.a.b paramb);
    
    public abstract void cfH();
    
    public abstract void cfI();
    
    public abstract void cfJ();
    
    public abstract void o(boolean paramBoolean, String paramString);
    
    @d.l(fNY={1, 1, 16})
    public static final class a {}
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "<anonymous parameter 0>", "", "<anonymous parameter 1>", "", "", "kotlin.jvm.PlatformType", "grantResults", "", "onRequestPermissionsResult", "(I[Ljava/lang/String;[I)V"})
  static final class c
    implements com.tencent.mm.pluginsdk.permission.c
  {
    c(EmojiCaptureUI paramEmojiCaptureUI) {}
    
    public final void b(int paramInt, int[] paramArrayOfInt)
    {
      int j = 1;
      AppMethodBeat.i(195158);
      d.g.b.k.g(paramArrayOfInt, "grantResults");
      int k = paramArrayOfInt.length;
      paramInt = 0;
      int i;
      if (paramInt < k) {
        if (paramArrayOfInt[paramInt] != 0)
        {
          i = 1;
          label34:
          if (i == 0) {
            break label113;
          }
          paramInt = j;
          label41:
          if (paramInt != 0)
          {
            paramInt = 2131761860;
            paramArrayOfInt = d.a.e.m(paramArrayOfInt, 0);
            if (paramArrayOfInt != null) {
              break label125;
            }
          }
        }
      }
      for (;;)
      {
        h.a((Context)this.pqS.getContext(), paramInt, 2131761885, 2131760598, 2131755691, false, (DialogInterface.OnClickListener)new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            AppMethodBeat.i(451);
            d.g.b.k.h(paramAnonymousDialogInterface, "dialog");
            paramAnonymousDialogInterface.dismiss();
            paramAnonymousDialogInterface = this.pqT.pqS.getContext();
            Object localObject = new Intent("android.settings.MANAGE_APPLICATIONS_SETTINGS");
            localObject = new com.tencent.mm.hellhoundlib.b.a().ba(localObject);
            com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousDialogInterface, ((com.tencent.mm.hellhoundlib.b.a)localObject).aeD(), "com/tencent/mm/plugin/emojicapture/ui/EmojiCaptureUI$checkPermission$1$2", "onClick", "(Landroid/content/DialogInterface;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            paramAnonymousDialogInterface.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).lR(0));
            com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousDialogInterface, "com/tencent/mm/plugin/emojicapture/ui/EmojiCaptureUI$checkPermission$1$2", "onClick", "(Landroid/content/DialogInterface;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            AppMethodBeat.o(451);
          }
        }, (DialogInterface.OnClickListener)new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            AppMethodBeat.i(452);
            d.g.b.k.h(paramAnonymousDialogInterface, "dialog");
            paramAnonymousDialogInterface.dismiss();
            this.pqT.pqS.finish();
            AppMethodBeat.o(452);
          }
        });
        AppMethodBeat.o(195158);
        return;
        i = 0;
        break label34;
        label113:
        paramInt += 1;
        break;
        paramInt = 0;
        break label41;
        label125:
        if (paramArrayOfInt.intValue() == 0) {
          paramInt = 2131761871;
        }
      }
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"com/tencent/mm/plugin/emojicapture/ui/EmojiCaptureUI$hardCoderSystemEventListener$1", "Lcom/tencent/mm/sdk/event/IListener;", "Lcom/tencent/mm/autogen/events/HardCoderSystemEvent;", "callback", "", "event", "plugin-emojicapture_release"})
  public static final class d
    extends com.tencent.mm.sdk.b.c<jq>
  {}
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "run"})
  static final class e
    implements Runnable
  {
    e(EmojiCaptureUI paramEmojiCaptureUI, long paramLong) {}
    
    public final void run()
    {
      AppMethodBeat.i(455);
      ac.i(EmojiCaptureUI.a(this.pqS), "connect cost " + bs.aO(l));
      EmojiCaptureUI.b(this.pqS);
      AppMethodBeat.o(455);
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"com/tencent/mm/plugin/emojicapture/ui/EmojiCaptureUI$uiNavigation$1", "Lcom/tencent/mm/plugin/emojicapture/ui/EmojiCaptureUI$UINavigation;", "loading", "Lcom/tencent/mm/ui/base/MMProgressDialog;", "dismissLoading", "", "exit", "success", "", "gifMd5", "", "go2Capture", "onEditorPrepared", "onVoiceFinished", "voiceText", "prepareEditor", "emojiCaptureInfo", "Lcom/tencent/mm/plugin/emojicapture/model/capture/EmojiCaptureInfo;", "showLoading", "context", "Landroid/content/Context;", "msg", "", "cancelAble", "style", "", "onCancelListener", "Landroid/content/DialogInterface$OnCancelListener;", "plugin-emojicapture_release"})
  public static final class f
    implements EmojiCaptureUI.b
  {
    p pne;
    
    public final void YI(String paramString)
    {
      AppMethodBeat.i(460);
      b.a locala = EmojiCaptureUI.d(this.pqS);
      if (locala != null)
      {
        locala.YE(paramString);
        AppMethodBeat.o(460);
        return;
      }
      AppMethodBeat.o(460);
    }
    
    public final void a(final Context paramContext, final CharSequence paramCharSequence, final boolean paramBoolean, final DialogInterface.OnCancelListener paramOnCancelListener)
    {
      AppMethodBeat.i(461);
      d.g.b.k.h(paramContext, "context");
      d.g.b.k.h(paramCharSequence, "msg");
      com.tencent.mm.ac.c.g((d.g.a.a)new a(this, paramContext, paramCharSequence, paramBoolean, paramOnCancelListener));
      ac.i(EmojiCaptureUI.a(this.pqS), "showLoading: " + this.pne);
      AppMethodBeat.o(461);
    }
    
    public final void b(com.tencent.mm.plugin.emojicapture.model.a.b paramb)
    {
      AppMethodBeat.i(457);
      d.g.b.k.h(paramb, "emojiCaptureInfo");
      ac.i(EmojiCaptureUI.a(this.pqS), "prepareEditor " + paramb.videoPath);
      Object localObject = com.tencent.mm.plugin.emojicapture.model.f.pnz;
      if (!com.tencent.mm.plugin.emojicapture.model.f.YG(paramb.videoPath))
      {
        ac.i(EmojiCaptureUI.a(this.pqS), "prepareEditor: video invalid");
        EmojiCaptureReporter.BD(2);
        paramb = com.tencent.mm.plugin.emojicapture.model.e.pny;
        com.tencent.mm.plugin.emojicapture.model.e.ceY();
        cfH();
        AppMethodBeat.o(457);
        return;
      }
      localObject = EmojiCaptureUI.c(this.pqS);
      if (localObject != null) {
        ((CaptureEditorContainer)localObject).setVisibility(0);
      }
      localObject = EmojiCaptureUI.c(this.pqS);
      if (localObject != null) {
        ((CaptureEditorContainer)localObject).setAlpha(0.0F);
      }
      localObject = EmojiCaptureUI.d(this.pqS);
      if (localObject != null) {
        ((b.a)localObject).a(paramb);
      }
      paramb = EmojiCaptureUI.e(this.pqS);
      if (paramb != null) {
        paramb.qZ();
      }
      EmojiCaptureUI.a(this.pqS, 2);
      AppMethodBeat.o(457);
    }
    
    public final void cfH()
    {
      AppMethodBeat.i(458);
      ac.i(EmojiCaptureUI.a(this.pqS), "go2Capture");
      Object localObject = EmojiCaptureUI.g(this.pqS);
      if (localObject != null) {
        ((CaptureContainer)localObject).setVisibility(0);
      }
      localObject = EmojiCaptureUI.c(this.pqS);
      if (localObject != null) {
        ((CaptureEditorContainer)localObject).setVisibility(8);
      }
      localObject = EmojiCaptureUI.g(this.pqS);
      if (localObject != null) {
        ((CaptureContainer)localObject).onResume();
      }
      EmojiCaptureUI.a(this.pqS, 0);
      AppMethodBeat.o(458);
    }
    
    public final void cfI()
    {
      AppMethodBeat.i(459);
      ac.i(EmojiCaptureUI.a(this.pqS), "onEditorPrepared");
      if (EmojiCaptureUI.f(this.pqS) == 2)
      {
        Object localObject = EmojiCaptureUI.c(this.pqS);
        if (localObject != null) {
          ((CaptureEditorContainer)localObject).setAlpha(1.0F);
        }
        localObject = EmojiCaptureUI.g(this.pqS);
        if (localObject != null) {
          ((CaptureContainer)localObject).setVisibility(8);
        }
        cfJ();
        EmojiCaptureUI.a(this.pqS, 1);
      }
      AppMethodBeat.o(459);
    }
    
    public final void cfJ()
    {
      AppMethodBeat.i(462);
      p localp = this.pne;
      if (localp != null) {
        localp.dismiss();
      }
      ac.i(EmojiCaptureUI.a(this.pqS), "dismissLoading: " + this.pne);
      AppMethodBeat.o(462);
    }
    
    public final void o(boolean paramBoolean, String paramString)
    {
      AppMethodBeat.i(463);
      Intent localIntent = new Intent();
      if (paramBoolean)
      {
        localIntent.putExtra("key_enter_time", EmojiCaptureUI.h(this.pqS));
        localIntent.putExtra("gif_md5", paramString);
        this.pqS.setResult(-1, localIntent);
      }
      for (;;)
      {
        this.pqS.finish();
        AppMethodBeat.o(463);
        return;
        EmojiCaptureUI.i(this.pqS).cQQ = (System.currentTimeMillis() - EmojiCaptureUI.i(this.pqS).fWr);
        EmojiCaptureReporter.a(6, EmojiCaptureUI.i(this.pqS).fWr, EmojiCaptureUI.i(this.pqS).cQQ, 0L, 0L, 0L, 0, 0, EmojiCaptureUI.i(this.pqS).scene);
        this.pqS.setResult(0);
      }
    }
    
    @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "invoke"})
    static final class a
      extends d.g.b.l
      implements d.g.a.a<y>
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