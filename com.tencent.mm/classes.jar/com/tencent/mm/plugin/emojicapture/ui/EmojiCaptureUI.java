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
import com.tencent.mm.g.a.jj;
import com.tencent.mm.plugin.emojicapture.api.EmojiCaptureReporter;
import com.tencent.mm.plugin.emojicapture.c.a.a;
import com.tencent.mm.plugin.emojicapture.c.b.a;
import com.tencent.mm.plugin.emojicapture.model.a.g;
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
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.p;
import d.y;

@com.tencent.mm.ui.base.a(3)
@d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/emojicapture/ui/EmojiCaptureUI;", "Lcom/tencent/mm/ui/MMActivity;", "()V", "TAG", "", "captureContainer", "Lcom/tencent/mm/plugin/emojicapture/ui/capture/CaptureContainer;", "capturePresenter", "Lcom/tencent/mm/plugin/emojicapture/contract/CaptureContract$IPresenter;", "captureReceiver", "Lcom/tencent/mm/plugin/emojicapture/proxy/EmojiCaptureReceiver;", "editorContainer", "Lcom/tencent/mm/plugin/emojicapture/ui/editor/CaptureEditorContainer;", "editorPresenter", "Lcom/tencent/mm/plugin/emojicapture/contract/EditorContract$IPresenter;", "hardCoderSystemEventListener", "com/tencent/mm/plugin/emojicapture/ui/EmojiCaptureUI$hardCoderSystemEventListener$1", "Lcom/tencent/mm/plugin/emojicapture/ui/EmojiCaptureUI$hardCoderSystemEventListener$1;", "reporter", "Lcom/tencent/mm/plugin/emojicapture/api/EmojiCaptureReporter;", "scene", "", "state", "stickerEnable", "", "talkerName", "timeEnter", "", "uiNavigation", "com/tencent/mm/plugin/emojicapture/ui/EmojiCaptureUI$uiNavigation$1", "Lcom/tencent/mm/plugin/emojicapture/ui/EmojiCaptureUI$uiNavigation$1;", "checkPermission", "", "finish", "getForceOrientation", "getLayoutId", "initOnCreateAfterConnected", "onBackPressed", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onKeyDown", "keyCode", "event", "Landroid/view/KeyEvent;", "onPause", "onResume", "Companion", "UINavigation", "plugin-emojicapture_release"})
public final class EmojiCaptureUI
  extends MMActivity
{
  public static final a oNx;
  private final String TAG;
  private String fPP;
  private long fSw;
  private final EmojiCaptureReporter oMm;
  private CaptureContainer oNp;
  private CaptureEditorContainer oNq;
  private a.a oNr;
  private b.a oNs;
  private boolean oNt;
  private EmojiCaptureReceiver oNu;
  private final f oNv;
  private final d oNw;
  private int scene;
  private int state;
  
  static
  {
    AppMethodBeat.i(473);
    oNx = new a((byte)0);
    AppMethodBeat.o(473);
  }
  
  public EmojiCaptureUI()
  {
    AppMethodBeat.i(472);
    this.TAG = "MicroMsg.EmojiCaptureUI";
    this.scene = 2;
    this.oMm = new EmojiCaptureReporter();
    this.oNv = new f(this);
    this.oNw = new d(this);
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
    EmojiCaptureProxy.a locala = EmojiCaptureProxy.oNd;
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
    b.a locala = this.oNs;
    if ((locala == null) || (locala.IL() != true)) {
      EmojiCaptureUI.b.a.a(this.oNv, false);
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
    this.fSw = getIntent().getLongExtra("key_enter_time", 0L);
    this.fPP = getIntent().getStringExtra("username");
    this.oMm.scene = this.scene;
    this.oMm.fSw = this.fSw;
    com.tencent.mm.plugin.mmsight.model.k.cPR();
    g.b.Oq();
    int i = getIntent().getIntExtra("key_capture_max_duration", 5);
    paramBundle = getIntent().getStringExtra("key_imitated_md5");
    d.a locala = com.tencent.mm.plugin.emojicapture.model.d.oJY;
    com.tencent.mm.plugin.emojicapture.model.d.AM(i);
    this.oMm.oJn = paramBundle;
    this.oNp = ((CaptureContainer)findViewById(2131297702));
    this.oNq = ((CaptureEditorContainer)findViewById(2131299286));
    final long l = bt.GC();
    paramBundle = EmojiCaptureProxy.oNd;
    EmojiCaptureProxy.a.aba();
    paramBundle = EmojiCaptureProxy.oNd;
    paramBundle = EmojiCaptureProxy.access$getInstance$cp().getServerProxy();
    if (paramBundle != null) {
      paramBundle.connect((Runnable)new e(this, l));
    }
    paramBundle = com.tencent.mm.plugin.emojicapture.model.e.oKa;
    com.tencent.mm.plugin.emojicapture.model.e.bXF();
    AppMethodBeat.o(464);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(470);
    com.tencent.mm.sdk.b.a.ESL.d((com.tencent.mm.sdk.b.c)this.oNw);
    super.onDestroy();
    Object localObject = this.oNr;
    if (localObject != null) {
      ((a.a)localObject).destroy();
    }
    localObject = this.oNp;
    if (localObject != null)
    {
      localObject = ((CaptureContainer)localObject).oOq;
      com.tencent.mm.sticker.loader.e locale = com.tencent.mm.sticker.loader.e.Fds;
      com.tencent.mm.sticker.loader.e.b((com.tencent.mm.loader.g.f)((EditorStickerView)localObject).oPk);
      g.destroy();
    }
    localObject = this.oNs;
    if (localObject != null) {
      ((b.a)localObject).destroy();
    }
    if (this.oNu != null) {
      unregisterReceiver((BroadcastReceiver)this.oNu);
    }
    localObject = EmojiCaptureProxy.oNd;
    EmojiCaptureProxy.a.bYs();
    localObject = com.tencent.mm.plugin.emojicapture.model.e.oKa;
    com.tencent.mm.plugin.emojicapture.model.e.bXG();
    com.tencent.mm.media.f.c.grn.ajW();
    AppMethodBeat.o(470);
  }
  
  public final boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(468);
    if ((ae.fFw.fAZ == 1) && (paramInt == 700))
    {
      CaptureContainer localCaptureContainer = this.oNp;
      if ((localCaptureContainer != null) && (localCaptureContainer.oOB == true))
      {
        localCaptureContainer = this.oNp;
        if (localCaptureContainer != null) {
          localCaptureContainer.amu();
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
      localObject = this.oNp;
      if (localObject != null)
      {
        ad.i(((CaptureContainer)localObject).TAG, "PauseCapture");
        CaptureDecoration localCaptureDecoration = ((CaptureContainer)localObject).getDecoration();
        localCaptureDecoration.oOH.pause();
        localCaptureDecoration.oOI.pause();
        ((CaptureContainer)localObject).oOA.stopPreview();
        AppMethodBeat.o(466);
        return;
      }
      AppMethodBeat.o(466);
      return;
    }
    Object localObject = this.oNs;
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
        localObject = this.oNp;
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
    Object localObject = this.oNs;
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
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/emojicapture/ui/EmojiCaptureUI$Companion;", "", "()V", "REQ_CODE_CHOOSE_IMAGE_FOR_EMOJI", "", "REQ_CODE_CROP_IMAGE_FOR_EMOJI", "REQ_CODE_SAVE_EMOJI_ALBUM", "REQ_CODE_SAVE_EMOJI_CAPTURE", "STATE_CAPTURE", "STATE_EDIT", "STATE_EDIT_PREPARE", "plugin-emojicapture_release"})
  public static final class a {}
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/emojicapture/ui/EmojiCaptureUI$UINavigation;", "", "dismissLoading", "", "exit", "success", "", "gifMd5", "", "go2Capture", "onEditorPrepared", "onVoiceFinished", "voiceText", "prepareEditor", "emojiCaptureInfo", "Lcom/tencent/mm/plugin/emojicapture/model/capture/EmojiCaptureInfo;", "showLoading", "context", "Landroid/content/Context;", "msg", "", "cancelAble", "style", "", "onCancelListener", "Landroid/content/DialogInterface$OnCancelListener;", "plugin-emojicapture_release"})
  public static abstract interface b
  {
    public abstract void Uw(String paramString);
    
    public abstract void a(Context paramContext, CharSequence paramCharSequence, boolean paramBoolean, DialogInterface.OnCancelListener paramOnCancelListener);
    
    public abstract void b(com.tencent.mm.plugin.emojicapture.model.a.b paramb);
    
    public abstract void bYt();
    
    public abstract void bYu();
    
    public abstract void bYv();
    
    public abstract void n(boolean paramBoolean, String paramString);
    
    @d.l(fvt={1, 1, 16})
    public static final class a {}
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "<anonymous parameter 0>", "", "<anonymous parameter 1>", "", "", "kotlin.jvm.PlatformType", "grantResults", "", "onRequestPermissionsResult", "(I[Ljava/lang/String;[I)V"})
  static final class c
    implements com.tencent.mm.pluginsdk.permission.c
  {
    c(EmojiCaptureUI paramEmojiCaptureUI) {}
    
    public final void s(int[] paramArrayOfInt)
    {
      int k = 1;
      AppMethodBeat.i(453);
      d.g.b.k.g(paramArrayOfInt, "grantResults");
      int m = paramArrayOfInt.length;
      int i = 0;
      int j;
      if (i < m) {
        if (paramArrayOfInt[i] != 0)
        {
          j = 1;
          label35:
          if (j == 0) {
            break label115;
          }
          i = k;
          label42:
          if (i != 0)
          {
            i = 2131761860;
            paramArrayOfInt = d.a.e.j(paramArrayOfInt, 0);
            if (paramArrayOfInt != null) {
              break label127;
            }
          }
        }
      }
      for (;;)
      {
        h.a((Context)this.oNy.getContext(), i, 2131761885, 2131760598, 2131755691, false, (DialogInterface.OnClickListener)new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            AppMethodBeat.i(451);
            d.g.b.k.h(paramAnonymousDialogInterface, "dialog");
            paramAnonymousDialogInterface.dismiss();
            paramAnonymousDialogInterface = this.oNz.oNy.getContext();
            Object localObject = new Intent("android.settings.MANAGE_APPLICATIONS_SETTINGS");
            localObject = new com.tencent.mm.hellhoundlib.b.a().bd(localObject);
            com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousDialogInterface, ((com.tencent.mm.hellhoundlib.b.a)localObject).adn(), "com/tencent/mm/plugin/emojicapture/ui/EmojiCaptureUI$checkPermission$1$2", "onClick", "(Landroid/content/DialogInterface;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            paramAnonymousDialogInterface.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).lS(0));
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
            this.oNz.oNy.finish();
            AppMethodBeat.o(452);
          }
        });
        AppMethodBeat.o(453);
        return;
        j = 0;
        break label35;
        label115:
        i += 1;
        break;
        i = 0;
        break label42;
        label127:
        if (paramArrayOfInt.intValue() == 0) {
          i = 2131761871;
        }
      }
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"com/tencent/mm/plugin/emojicapture/ui/EmojiCaptureUI$hardCoderSystemEventListener$1", "Lcom/tencent/mm/sdk/event/IListener;", "Lcom/tencent/mm/autogen/events/HardCoderSystemEvent;", "callback", "", "event", "plugin-emojicapture_release"})
  public static final class d
    extends com.tencent.mm.sdk.b.c<jj>
  {}
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "run"})
  static final class e
    implements Runnable
  {
    e(EmojiCaptureUI paramEmojiCaptureUI, long paramLong) {}
    
    public final void run()
    {
      AppMethodBeat.i(455);
      ad.i(EmojiCaptureUI.a(this.oNy), "connect cost " + bt.aS(l));
      EmojiCaptureUI.b(this.oNy);
      AppMethodBeat.o(455);
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"com/tencent/mm/plugin/emojicapture/ui/EmojiCaptureUI$uiNavigation$1", "Lcom/tencent/mm/plugin/emojicapture/ui/EmojiCaptureUI$UINavigation;", "loading", "Lcom/tencent/mm/ui/base/MMProgressDialog;", "dismissLoading", "", "exit", "success", "", "gifMd5", "", "go2Capture", "onEditorPrepared", "onVoiceFinished", "voiceText", "prepareEditor", "emojiCaptureInfo", "Lcom/tencent/mm/plugin/emojicapture/model/capture/EmojiCaptureInfo;", "showLoading", "context", "Landroid/content/Context;", "msg", "", "cancelAble", "style", "", "onCancelListener", "Landroid/content/DialogInterface$OnCancelListener;", "plugin-emojicapture_release"})
  public static final class f
    implements EmojiCaptureUI.b
  {
    p oJG;
    
    public final void Uw(String paramString)
    {
      AppMethodBeat.i(460);
      b.a locala = EmojiCaptureUI.d(this.oNy);
      if (locala != null)
      {
        locala.Us(paramString);
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
      com.tencent.mm.ad.c.g((d.g.a.a)new a(this, paramContext, paramCharSequence, paramBoolean, paramOnCancelListener));
      ad.i(EmojiCaptureUI.a(this.oNy), "showLoading: " + this.oJG);
      AppMethodBeat.o(461);
    }
    
    public final void b(com.tencent.mm.plugin.emojicapture.model.a.b paramb)
    {
      AppMethodBeat.i(457);
      d.g.b.k.h(paramb, "emojiCaptureInfo");
      ad.i(EmojiCaptureUI.a(this.oNy), "prepareEditor " + paramb.videoPath);
      Object localObject = com.tencent.mm.plugin.emojicapture.model.f.oKb;
      if (!com.tencent.mm.plugin.emojicapture.model.f.Uu(paramb.videoPath))
      {
        ad.i(EmojiCaptureUI.a(this.oNy), "prepareEditor: video invalid");
        EmojiCaptureReporter.AL(2);
        paramb = com.tencent.mm.plugin.emojicapture.model.e.oKa;
        com.tencent.mm.plugin.emojicapture.model.e.bXL();
        bYt();
        AppMethodBeat.o(457);
        return;
      }
      localObject = EmojiCaptureUI.c(this.oNy);
      if (localObject != null) {
        ((CaptureEditorContainer)localObject).setVisibility(0);
      }
      localObject = EmojiCaptureUI.c(this.oNy);
      if (localObject != null) {
        ((CaptureEditorContainer)localObject).setAlpha(0.0F);
      }
      localObject = EmojiCaptureUI.d(this.oNy);
      if (localObject != null) {
        ((b.a)localObject).a(paramb);
      }
      paramb = EmojiCaptureUI.e(this.oNy);
      if (paramb != null) {
        paramb.qP();
      }
      EmojiCaptureUI.a(this.oNy, 2);
      AppMethodBeat.o(457);
    }
    
    public final void bYt()
    {
      AppMethodBeat.i(458);
      ad.i(EmojiCaptureUI.a(this.oNy), "go2Capture");
      Object localObject = EmojiCaptureUI.g(this.oNy);
      if (localObject != null) {
        ((CaptureContainer)localObject).setVisibility(0);
      }
      localObject = EmojiCaptureUI.c(this.oNy);
      if (localObject != null) {
        ((CaptureEditorContainer)localObject).setVisibility(8);
      }
      localObject = EmojiCaptureUI.g(this.oNy);
      if (localObject != null) {
        ((CaptureContainer)localObject).onResume();
      }
      EmojiCaptureUI.a(this.oNy, 0);
      AppMethodBeat.o(458);
    }
    
    public final void bYu()
    {
      AppMethodBeat.i(459);
      ad.i(EmojiCaptureUI.a(this.oNy), "onEditorPrepared");
      if (EmojiCaptureUI.f(this.oNy) == 2)
      {
        Object localObject = EmojiCaptureUI.c(this.oNy);
        if (localObject != null) {
          ((CaptureEditorContainer)localObject).setAlpha(1.0F);
        }
        localObject = EmojiCaptureUI.g(this.oNy);
        if (localObject != null) {
          ((CaptureContainer)localObject).setVisibility(8);
        }
        bYv();
        EmojiCaptureUI.a(this.oNy, 1);
      }
      AppMethodBeat.o(459);
    }
    
    public final void bYv()
    {
      AppMethodBeat.i(462);
      p localp = this.oJG;
      if (localp != null) {
        localp.dismiss();
      }
      ad.i(EmojiCaptureUI.a(this.oNy), "dismissLoading: " + this.oJG);
      AppMethodBeat.o(462);
    }
    
    public final void n(boolean paramBoolean, String paramString)
    {
      AppMethodBeat.i(463);
      Intent localIntent = new Intent();
      if (paramBoolean)
      {
        localIntent.putExtra("key_enter_time", EmojiCaptureUI.h(this.oNy));
        localIntent.putExtra("gif_md5", paramString);
        this.oNy.setResult(-1, localIntent);
      }
      for (;;)
      {
        this.oNy.finish();
        AppMethodBeat.o(463);
        return;
        EmojiCaptureUI.i(this.oNy).cTt = (System.currentTimeMillis() - EmojiCaptureUI.i(this.oNy).fSw);
        EmojiCaptureReporter.a(6, EmojiCaptureUI.i(this.oNy).fSw, EmojiCaptureUI.i(this.oNy).cTt, 0L, 0L, 0L, 0, 0, EmojiCaptureUI.i(this.oNy).scene);
        this.oNy.setResult(0);
      }
    }
    
    @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "invoke"})
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.emojicapture.ui.EmojiCaptureUI
 * JD-Core Version:    0.7.0.1
 */