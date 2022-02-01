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
import com.tencent.mm.g.a.jz;
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
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import d.g.b.q;
import d.l;
import d.z;

@com.tencent.mm.ui.base.a(3)
@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/emojicapture/ui/EmojiCaptureUI;", "Lcom/tencent/mm/ui/MMActivity;", "()V", "TAG", "", "captureContainer", "Lcom/tencent/mm/plugin/emojicapture/ui/capture/CaptureContainer;", "capturePresenter", "Lcom/tencent/mm/plugin/emojicapture/contract/CaptureContract$IPresenter;", "captureReceiver", "Lcom/tencent/mm/plugin/emojicapture/proxy/EmojiCaptureReceiver;", "editorContainer", "Lcom/tencent/mm/plugin/emojicapture/ui/editor/CaptureEditorContainer;", "editorPresenter", "Lcom/tencent/mm/plugin/emojicapture/contract/EditorContract$IPresenter;", "hardCoderSystemEventListener", "com/tencent/mm/plugin/emojicapture/ui/EmojiCaptureUI$hardCoderSystemEventListener$1", "Lcom/tencent/mm/plugin/emojicapture/ui/EmojiCaptureUI$hardCoderSystemEventListener$1;", "reporter", "Lcom/tencent/mm/plugin/emojicapture/api/EmojiCaptureReporter;", "scene", "", "state", "stickerEnable", "", "talkerName", "timeEnter", "", "uiNavigation", "com/tencent/mm/plugin/emojicapture/ui/EmojiCaptureUI$uiNavigation$1", "Lcom/tencent/mm/plugin/emojicapture/ui/EmojiCaptureUI$uiNavigation$1;", "checkPermission", "", "finish", "getForceOrientation", "getLayoutId", "initOnCreateAfterConnected", "onBackPressed", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onKeyDown", "keyCode", "event", "Landroid/view/KeyEvent;", "onPause", "onResume", "Companion", "UINavigation", "plugin-emojicapture_release"})
public final class EmojiCaptureUI
  extends MMActivity
{
  public static final EmojiCaptureUI.a qbc;
  private final String TAG;
  private String gpK;
  private long gsp;
  private final EmojiCaptureReporter pZM;
  private CaptureContainer qaU;
  private CaptureEditorContainer qaV;
  private a.a qaW;
  private b.a qaX;
  private boolean qaY;
  private EmojiCaptureReceiver qaZ;
  private final f qba;
  private final d qbb;
  private int scene;
  private int state;
  
  static
  {
    AppMethodBeat.i(473);
    qbc = new EmojiCaptureUI.a((byte)0);
    AppMethodBeat.o(473);
  }
  
  public EmojiCaptureUI()
  {
    AppMethodBeat.i(472);
    this.TAG = "MicroMsg.EmojiCaptureUI";
    this.scene = 2;
    this.pZM = new EmojiCaptureReporter();
    this.qba = new f(this);
    this.qbb = new d(this);
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
    EmojiCaptureProxy.a locala = EmojiCaptureProxy.qaI;
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
    b.a locala = this.qaX;
    if ((locala == null) || (locala.Kc() != true)) {
      EmojiCaptureUI.b.a.a(this.qba, false);
    }
    AppMethodBeat.o(469);
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(464);
    com.tencent.mm.sdk.platformtools.ae.i(this.TAG, "onCreate");
    overridePendingTransition(2130771983, -1);
    supportRequestWindowFeature(1);
    setSelfNavigationBarVisible(8);
    getWindow().addFlags(67109888);
    super.onCreate(paramBundle);
    this.scene = getIntent().getIntExtra("enter_scene", this.scene);
    this.gsp = getIntent().getLongExtra("key_enter_time", 0L);
    this.gpK = getIntent().getStringExtra("username");
    this.pZM.scene = this.scene;
    this.pZM.gsp = this.gsp;
    k.dpT();
    g.b.PU();
    int i = getIntent().getIntExtra("key_capture_max_duration", 5);
    paramBundle = getIntent().getStringExtra("key_imitated_md5");
    d.a locala = com.tencent.mm.plugin.emojicapture.model.d.pXB;
    com.tencent.mm.plugin.emojicapture.model.d.Cy(i);
    this.pZM.pWR = paramBundle;
    this.qaU = ((CaptureContainer)findViewById(2131297702));
    this.qaV = ((CaptureEditorContainer)findViewById(2131299286));
    final long l = bu.HQ();
    paramBundle = EmojiCaptureProxy.qaI;
    EmojiCaptureProxy.a.cly();
    paramBundle = EmojiCaptureProxy.qaI;
    paramBundle = EmojiCaptureProxy.access$getInstance$cp().getServerProxy();
    if (paramBundle != null) {
      paramBundle.connect((Runnable)new e(this, l));
    }
    paramBundle = com.tencent.mm.plugin.emojicapture.model.e.pXD;
    com.tencent.mm.plugin.emojicapture.model.e.ckL();
    AppMethodBeat.o(464);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(470);
    com.tencent.mm.sdk.b.a.IvT.d((com.tencent.mm.sdk.b.c)this.qbb);
    super.onDestroy();
    Object localObject = this.qaW;
    if (localObject != null) {
      ((a.a)localObject).destroy();
    }
    localObject = this.qaU;
    if (localObject != null)
    {
      localObject = ((CaptureContainer)localObject).qbV;
      com.tencent.mm.sticker.loader.e locale = com.tencent.mm.sticker.loader.e.IGU;
      com.tencent.mm.sticker.loader.e.b((com.tencent.mm.loader.g.f)((EditorStickerView)localObject).qcH);
      com.tencent.mm.plugin.emojicapture.model.a.f.destroy();
    }
    localObject = this.qaX;
    if (localObject != null) {
      ((b.a)localObject).destroy();
    }
    if (this.qaZ != null) {
      unregisterReceiver((BroadcastReceiver)this.qaZ);
    }
    localObject = EmojiCaptureProxy.qaI;
    EmojiCaptureProxy.a.clz();
    localObject = com.tencent.mm.plugin.emojicapture.model.e.pXD;
    com.tencent.mm.plugin.emojicapture.model.e.ckM();
    com.tencent.mm.media.g.c.hnb.atY();
    AppMethodBeat.o(470);
  }
  
  public final boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(468);
    if ((com.tencent.mm.compatible.deviceinfo.ae.geM.gal == 1) && (paramInt == 700))
    {
      CaptureContainer localCaptureContainer = this.qaU;
      if ((localCaptureContainer != null) && (localCaptureContainer.qcg == true))
      {
        localCaptureContainer = this.qaU;
        if (localCaptureContainer != null) {
          localCaptureContainer.awo();
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
      localObject = this.qaU;
      if (localObject != null)
      {
        com.tencent.mm.sdk.platformtools.ae.i(((CaptureContainer)localObject).TAG, "PauseCapture");
        CaptureDecoration localCaptureDecoration = ((CaptureContainer)localObject).getDecoration();
        localCaptureDecoration.qcm.pause();
        localCaptureDecoration.qcn.pause();
        ((CaptureContainer)localObject).qcf.stopPreview();
        AppMethodBeat.o(466);
        return;
      }
      AppMethodBeat.o(466);
      return;
    }
    Object localObject = this.qaX;
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
        localObject = this.qaU;
        if (localObject != null)
        {
          ((CaptureContainer)localObject).onResume();
          AppMethodBeat.o(467);
          return;
        }
        AppMethodBeat.o(467);
        return;
      }
      com.tencent.mm.sdk.platformtools.ae.i(this.TAG, "initOnCreateAfterConnected: no permission");
      AppMethodBeat.o(467);
      return;
    }
    Object localObject = this.qaX;
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
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/emojicapture/ui/EmojiCaptureUI$UINavigation;", "", "dismissLoading", "", "exit", "success", "", "gifMd5", "", "go2Capture", "onEditorPrepared", "onVoiceFinished", "voiceText", "prepareEditor", "emojiCaptureInfo", "Lcom/tencent/mm/plugin/emojicapture/model/capture/EmojiCaptureInfo;", "showLoading", "context", "Landroid/content/Context;", "msg", "", "cancelAble", "style", "", "onCancelListener", "Landroid/content/DialogInterface$OnCancelListener;", "plugin-emojicapture_release"})
  public static abstract interface b
  {
    public abstract void a(Context paramContext, CharSequence paramCharSequence, boolean paramBoolean, DialogInterface.OnCancelListener paramOnCancelListener);
    
    public abstract void adf(String paramString);
    
    public abstract void b(com.tencent.mm.plugin.emojicapture.model.a.b paramb);
    
    public abstract void clA();
    
    public abstract void clB();
    
    public abstract void clC();
    
    public abstract void s(boolean paramBoolean, String paramString);
    
    @l(gjZ={1, 1, 16})
    public static final class a {}
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "<anonymous parameter 0>", "", "<anonymous parameter 1>", "", "", "kotlin.jvm.PlatformType", "grantResults", "", "onRequestPermissionsResult", "(I[Ljava/lang/String;[I)V"})
  static final class c
    implements com.tencent.mm.pluginsdk.permission.c
  {
    c(EmojiCaptureUI paramEmojiCaptureUI) {}
    
    public final void b(int paramInt, int[] paramArrayOfInt)
    {
      int j = 1;
      AppMethodBeat.i(221766);
      d.g.b.p.g(paramArrayOfInt, "grantResults");
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
        h.a((Context)this.qbd.getContext(), paramInt, 2131761885, 2131760598, 2131755691, false, (DialogInterface.OnClickListener)new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            AppMethodBeat.i(451);
            d.g.b.p.h(paramAnonymousDialogInterface, "dialog");
            paramAnonymousDialogInterface.dismiss();
            paramAnonymousDialogInterface = this.qbe.qbd.getContext();
            Object localObject = new Intent("android.settings.MANAGE_APPLICATIONS_SETTINGS");
            localObject = new com.tencent.mm.hellhoundlib.b.a().bc(localObject);
            com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousDialogInterface, ((com.tencent.mm.hellhoundlib.b.a)localObject).ahE(), "com/tencent/mm/plugin/emojicapture/ui/EmojiCaptureUI$checkPermission$1$2", "onClick", "(Landroid/content/DialogInterface;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            paramAnonymousDialogInterface.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).mt(0));
            com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousDialogInterface, "com/tencent/mm/plugin/emojicapture/ui/EmojiCaptureUI$checkPermission$1$2", "onClick", "(Landroid/content/DialogInterface;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            AppMethodBeat.o(451);
          }
        }, (DialogInterface.OnClickListener)new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            AppMethodBeat.i(452);
            d.g.b.p.h(paramAnonymousDialogInterface, "dialog");
            paramAnonymousDialogInterface.dismiss();
            this.qbe.qbd.finish();
            AppMethodBeat.o(452);
          }
        });
        AppMethodBeat.o(221766);
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
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"com/tencent/mm/plugin/emojicapture/ui/EmojiCaptureUI$hardCoderSystemEventListener$1", "Lcom/tencent/mm/sdk/event/IListener;", "Lcom/tencent/mm/autogen/events/HardCoderSystemEvent;", "callback", "", "event", "plugin-emojicapture_release"})
  public static final class d
    extends com.tencent.mm.sdk.b.c<jz>
  {}
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "run"})
  static final class e
    implements Runnable
  {
    e(EmojiCaptureUI paramEmojiCaptureUI, long paramLong) {}
    
    public final void run()
    {
      AppMethodBeat.i(455);
      com.tencent.mm.sdk.platformtools.ae.i(EmojiCaptureUI.a(this.qbd), "connect cost " + bu.aO(l));
      EmojiCaptureUI.b(this.qbd);
      AppMethodBeat.o(455);
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"com/tencent/mm/plugin/emojicapture/ui/EmojiCaptureUI$uiNavigation$1", "Lcom/tencent/mm/plugin/emojicapture/ui/EmojiCaptureUI$UINavigation;", "loading", "Lcom/tencent/mm/ui/base/MMProgressDialog;", "dismissLoading", "", "exit", "success", "", "gifMd5", "", "go2Capture", "onEditorPrepared", "onVoiceFinished", "voiceText", "prepareEditor", "emojiCaptureInfo", "Lcom/tencent/mm/plugin/emojicapture/model/capture/EmojiCaptureInfo;", "showLoading", "context", "Landroid/content/Context;", "msg", "", "cancelAble", "style", "", "onCancelListener", "Landroid/content/DialogInterface$OnCancelListener;", "plugin-emojicapture_release"})
  public static final class f
    implements EmojiCaptureUI.b
  {
    com.tencent.mm.ui.base.p pXj;
    
    public final void a(final Context paramContext, final CharSequence paramCharSequence, final boolean paramBoolean, final DialogInterface.OnCancelListener paramOnCancelListener)
    {
      AppMethodBeat.i(461);
      d.g.b.p.h(paramContext, "context");
      d.g.b.p.h(paramCharSequence, "msg");
      com.tencent.mm.ac.c.h((d.g.a.a)new a(this, paramContext, paramCharSequence, paramBoolean, paramOnCancelListener));
      com.tencent.mm.sdk.platformtools.ae.i(EmojiCaptureUI.a(this.qbd), "showLoading: " + this.pXj);
      AppMethodBeat.o(461);
    }
    
    public final void adf(String paramString)
    {
      AppMethodBeat.i(460);
      b.a locala = EmojiCaptureUI.d(this.qbd);
      if (locala != null)
      {
        locala.adb(paramString);
        AppMethodBeat.o(460);
        return;
      }
      AppMethodBeat.o(460);
    }
    
    public final void b(com.tencent.mm.plugin.emojicapture.model.a.b paramb)
    {
      AppMethodBeat.i(457);
      d.g.b.p.h(paramb, "emojiCaptureInfo");
      com.tencent.mm.sdk.platformtools.ae.i(EmojiCaptureUI.a(this.qbd), "prepareEditor " + paramb.videoPath);
      Object localObject = com.tencent.mm.plugin.emojicapture.model.f.pXE;
      if (!com.tencent.mm.plugin.emojicapture.model.f.add(paramb.videoPath))
      {
        com.tencent.mm.sdk.platformtools.ae.i(EmojiCaptureUI.a(this.qbd), "prepareEditor: video invalid");
        EmojiCaptureReporter.Cx(2);
        paramb = com.tencent.mm.plugin.emojicapture.model.e.pXD;
        com.tencent.mm.plugin.emojicapture.model.e.ckR();
        clA();
        AppMethodBeat.o(457);
        return;
      }
      localObject = EmojiCaptureUI.c(this.qbd);
      if (localObject != null) {
        ((CaptureEditorContainer)localObject).setVisibility(0);
      }
      localObject = EmojiCaptureUI.c(this.qbd);
      if (localObject != null) {
        ((CaptureEditorContainer)localObject).setAlpha(0.0F);
      }
      localObject = EmojiCaptureUI.d(this.qbd);
      if (localObject != null) {
        ((b.a)localObject).a(paramb);
      }
      paramb = EmojiCaptureUI.e(this.qbd);
      if (paramb != null) {
        paramb.sx();
      }
      EmojiCaptureUI.a(this.qbd, 2);
      AppMethodBeat.o(457);
    }
    
    public final void clA()
    {
      AppMethodBeat.i(458);
      com.tencent.mm.sdk.platformtools.ae.i(EmojiCaptureUI.a(this.qbd), "go2Capture");
      Object localObject = EmojiCaptureUI.g(this.qbd);
      if (localObject != null) {
        ((CaptureContainer)localObject).setVisibility(0);
      }
      localObject = EmojiCaptureUI.c(this.qbd);
      if (localObject != null) {
        ((CaptureEditorContainer)localObject).setVisibility(8);
      }
      localObject = EmojiCaptureUI.g(this.qbd);
      if (localObject != null) {
        ((CaptureContainer)localObject).onResume();
      }
      EmojiCaptureUI.a(this.qbd, 0);
      AppMethodBeat.o(458);
    }
    
    public final void clB()
    {
      AppMethodBeat.i(459);
      com.tencent.mm.sdk.platformtools.ae.i(EmojiCaptureUI.a(this.qbd), "onEditorPrepared");
      if (EmojiCaptureUI.f(this.qbd) == 2)
      {
        Object localObject = EmojiCaptureUI.c(this.qbd);
        if (localObject != null) {
          ((CaptureEditorContainer)localObject).setAlpha(1.0F);
        }
        localObject = EmojiCaptureUI.g(this.qbd);
        if (localObject != null) {
          ((CaptureContainer)localObject).setVisibility(8);
        }
        clC();
        EmojiCaptureUI.a(this.qbd, 1);
      }
      AppMethodBeat.o(459);
    }
    
    public final void clC()
    {
      AppMethodBeat.i(462);
      com.tencent.mm.ui.base.p localp = this.pXj;
      if (localp != null) {
        localp.dismiss();
      }
      com.tencent.mm.sdk.platformtools.ae.i(EmojiCaptureUI.a(this.qbd), "dismissLoading: " + this.pXj);
      AppMethodBeat.o(462);
    }
    
    public final void s(boolean paramBoolean, String paramString)
    {
      AppMethodBeat.i(463);
      Intent localIntent = new Intent();
      if (paramBoolean)
      {
        localIntent.putExtra("key_enter_time", EmojiCaptureUI.h(this.qbd));
        localIntent.putExtra("gif_md5", paramString);
        this.qbd.setResult(-1, localIntent);
      }
      for (;;)
      {
        this.qbd.finish();
        AppMethodBeat.o(463);
        return;
        EmojiCaptureUI.i(this.qbd).ddi = (System.currentTimeMillis() - EmojiCaptureUI.i(this.qbd).gsp);
        EmojiCaptureReporter.a(6, EmojiCaptureUI.i(this.qbd).gsp, EmojiCaptureUI.i(this.qbd).ddi, 0L, 0L, 0L, 0, 0, EmojiCaptureUI.i(this.qbd).scene);
        this.qbd.setResult(0);
      }
    }
    
    @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "invoke"})
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.emojicapture.ui.EmojiCaptureUI
 * JD-Core Version:    0.7.0.1
 */