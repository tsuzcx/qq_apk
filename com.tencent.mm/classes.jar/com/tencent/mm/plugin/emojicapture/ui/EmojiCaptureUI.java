package com.tencent.mm.plugin.emojicapture.ui;

import a.l;
import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.Window;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.audio.b.g.b;
import com.tencent.mm.compatible.e.ac;
import com.tencent.mm.emoji.view.BaseEmojiView;
import com.tencent.mm.plugin.emojicapture.api.EmojiCaptureReporter;
import com.tencent.mm.plugin.emojicapture.c.a.a;
import com.tencent.mm.plugin.emojicapture.c.b.a;
import com.tencent.mm.plugin.emojicapture.model.c.a;
import com.tencent.mm.plugin.emojicapture.proxy.EmojiCaptureProxy;
import com.tencent.mm.plugin.emojicapture.proxy.EmojiCaptureProxy.a;
import com.tencent.mm.plugin.emojicapture.proxy.EmojiCaptureReceiver;
import com.tencent.mm.plugin.emojicapture.ui.b.f;
import com.tencent.mm.plugin.emojicapture.ui.b.h;
import com.tencent.mm.plugin.emojicapture.ui.capture.CaptureContainer;
import com.tencent.mm.plugin.emojicapture.ui.capture.CaptureDecoration;
import com.tencent.mm.plugin.emojicapture.ui.editor.CaptureEditorContainer;
import com.tencent.mm.plugin.emojicapture.ui.editor.TextEditorItemView;
import com.tencent.mm.pluginsdk.permission.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.MMActivity;
import com.tencent.ttpic.cache.VideoMemoryManager;
import com.tencent.ttpic.util.VideoGlobalContext;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/plugin/emojicapture/ui/EmojiCaptureUI;", "Lcom/tencent/mm/ui/MMActivity;", "()V", "TAG", "", "captureContainer", "Lcom/tencent/mm/plugin/emojicapture/ui/capture/CaptureContainer;", "capturePresenter", "Lcom/tencent/mm/plugin/emojicapture/contract/CaptureContract$IPresenter;", "captureReceiver", "Lcom/tencent/mm/plugin/emojicapture/proxy/EmojiCaptureReceiver;", "editorContainer", "Lcom/tencent/mm/plugin/emojicapture/ui/editor/CaptureEditorContainer;", "editorPresenter", "Lcom/tencent/mm/plugin/emojicapture/contract/EditorContract$IPresenter;", "hardCoderSystemEventListener", "com/tencent/mm/plugin/emojicapture/ui/EmojiCaptureUI$hardCoderSystemEventListener$1", "Lcom/tencent/mm/plugin/emojicapture/ui/EmojiCaptureUI$hardCoderSystemEventListener$1;", "reporter", "Lcom/tencent/mm/plugin/emojicapture/api/EmojiCaptureReporter;", "scene", "", "state", "timeEnter", "", "uiNavigation", "com/tencent/mm/plugin/emojicapture/ui/EmojiCaptureUI$uiNavigation$1", "Lcom/tencent/mm/plugin/emojicapture/ui/EmojiCaptureUI$uiNavigation$1;", "checkPermission", "", "finish", "getForceOrientation", "getLayoutId", "initOnCreateAfterConnected", "onBackPressed", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onKeyDown", "", "keyCode", "event", "Landroid/view/KeyEvent;", "onPause", "onResume", "Companion", "UINavigation", "plugin-emojicapture_release"})
@com.tencent.mm.ui.base.a(3)
public final class EmojiCaptureUI
  extends MMActivity
{
  public static final EmojiCaptureUI.a lxf;
  private final String TAG;
  private long eyh;
  private final EmojiCaptureReporter lsY;
  private CaptureContainer lwY;
  private CaptureEditorContainer lwZ;
  private a.a lxa;
  private b.a lxb;
  private EmojiCaptureReceiver lxc;
  private final EmojiCaptureUI.f lxd;
  private final EmojiCaptureUI.d lxe;
  private int scene;
  private int state;
  
  static
  {
    AppMethodBeat.i(2885);
    lxf = new EmojiCaptureUI.a((byte)0);
    AppMethodBeat.o(2885);
  }
  
  public EmojiCaptureUI()
  {
    AppMethodBeat.i(2884);
    this.TAG = "MicroMsg.EmojiCaptureUI";
    this.scene = 2;
    this.lsY = new EmojiCaptureReporter();
    this.lxd = new EmojiCaptureUI.f(this);
    this.lxe = new EmojiCaptureUI.d(this);
    AppMethodBeat.o(2884);
  }
  
  public final void finish()
  {
    AppMethodBeat.i(2883);
    super.finish();
    overridePendingTransition(-1, 2131034128);
    AppMethodBeat.o(2883);
  }
  
  public final int getForceOrientation()
  {
    AppMethodBeat.i(2877);
    EmojiCaptureProxy.a locala = EmojiCaptureProxy.lwI;
    if (EmojiCaptureProxy.access$getInstance$cp().getEnableAutoRotate())
    {
      AppMethodBeat.o(2877);
      return 7;
    }
    AppMethodBeat.o(2877);
    return 1;
  }
  
  public final int getLayoutId()
  {
    return 2130969364;
  }
  
  public final void onBackPressed()
  {
    AppMethodBeat.i(2881);
    b.a locala = this.lxb;
    if ((locala == null) || (locala.zY() != true)) {
      EmojiCaptureUI.b.a.a(this.lxd, false);
    }
    AppMethodBeat.o(2881);
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(2876);
    ab.i(this.TAG, "onCreate");
    overridePendingTransition(2131034127, -1);
    supportRequestWindowFeature(1);
    setSelfNavigationBarVisible(8);
    getWindow().addFlags(67109888);
    super.onCreate(paramBundle);
    VideoGlobalContext.setContext(ah.getContext());
    this.scene = getIntent().getIntExtra("enter_scene", this.scene);
    this.eyh = getIntent().getLongExtra("key_enter_time", 0L);
    this.lsY.scene = this.scene;
    this.lsY.eyh = this.eyh;
    com.tencent.mm.plugin.mmsight.model.j.bQW();
    g.b.EI();
    int i = getIntent().getIntExtra("key_capture_max_duration", 5);
    paramBundle = getIntent().getStringExtra("key_imitated_md5");
    c.a locala = com.tencent.mm.plugin.emojicapture.model.c.ltu;
    com.tencent.mm.plugin.emojicapture.model.c.uC(i);
    this.lsY.lsU = paramBundle;
    this.lwY = ((CaptureContainer)findViewById(2131823559));
    this.lwZ = ((CaptureEditorContainer)findViewById(2131823560));
    long l = bo.yB();
    paramBundle = EmojiCaptureProxy.lwI;
    EmojiCaptureProxy.a.boO();
    paramBundle = EmojiCaptureProxy.lwI;
    paramBundle = EmojiCaptureProxy.access$getInstance$cp().getServerProxy();
    if (paramBundle != null) {
      paramBundle.connect((Runnable)new EmojiCaptureUI.e(this, l));
    }
    paramBundle = com.tencent.mm.plugin.emojicapture.model.d.ltx;
    com.tencent.mm.plugin.emojicapture.model.d.bnS();
    paramBundle = VideoMemoryManager.getInstance();
    a.f.b.j.p(paramBundle, "VideoMemoryManager.getInstance()");
    paramBundle.setSampleSize(2);
    AppMethodBeat.o(2876);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(2882);
    com.tencent.mm.sdk.b.a.ymk.d((com.tencent.mm.sdk.b.c)this.lxe);
    super.onDestroy();
    Object localObject = this.lxa;
    if (localObject != null) {
      ((a.a)localObject).destroy();
    }
    localObject = this.lwY;
    if (localObject != null)
    {
      localObject = ((CaptureContainer)localObject).lya.eXY;
      if (localObject != null)
      {
        if (!(localObject instanceof com.tencent.mm.plugin.emojicapture.ui.b.a)) {
          break label138;
        }
        ((com.tencent.mm.plugin.emojicapture.ui.b.a)localObject).lAF.destroy();
      }
    }
    for (;;)
    {
      localObject = this.lxb;
      if (localObject != null) {
        ((b.a)localObject).destroy();
      }
      if (this.lxc != null) {
        unregisterReceiver((BroadcastReceiver)this.lxc);
      }
      localObject = com.tencent.mm.plugin.emojicapture.model.a.c.ltQ;
      com.tencent.mm.plugin.emojicapture.model.a.c.destroy();
      localObject = EmojiCaptureProxy.lwI;
      EmojiCaptureProxy.a.boP();
      localObject = com.tencent.mm.plugin.emojicapture.model.d.ltx;
      com.tencent.mm.plugin.emojicapture.model.d.bnT();
      AppMethodBeat.o(2882);
      return;
      label138:
      if ((localObject instanceof f)) {
        ((f)localObject).lAF.destroy();
      }
    }
  }
  
  public final boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(2880);
    if ((ac.eru.enT == 1) && (paramInt == 700))
    {
      CaptureContainer localCaptureContainer = this.lwY;
      if ((localCaptureContainer != null) && (localCaptureContainer.lyo == true))
      {
        localCaptureContainer = this.lwY;
        if (localCaptureContainer != null) {
          localCaptureContainer.WN();
        }
      }
    }
    boolean bool = super.onKeyDown(paramInt, paramKeyEvent);
    AppMethodBeat.o(2880);
    return bool;
  }
  
  public final void onPause()
  {
    AppMethodBeat.i(2878);
    super.onPause();
    if (this.state == 0)
    {
      localObject = this.lwY;
      if (localObject != null)
      {
        ab.i(((CaptureContainer)localObject).TAG, "PauseCapture");
        CaptureDecoration localCaptureDecoration = ((CaptureContainer)localObject).getDecoration();
        localCaptureDecoration.lyv.pause();
        localCaptureDecoration.lyw.pause();
        ((CaptureContainer)localObject).lyn.stopPreview();
        AppMethodBeat.o(2878);
        return;
      }
      AppMethodBeat.o(2878);
      return;
    }
    Object localObject = this.lxb;
    if (localObject != null)
    {
      ((b.a)localObject).pause();
      AppMethodBeat.o(2878);
      return;
    }
    AppMethodBeat.o(2878);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(2879);
    super.onResume();
    if (this.state == 0)
    {
      if (b.e((Context)this, new String[] { "android.permission.CAMERA", "android.permission.RECORD_AUDIO" }))
      {
        localObject = this.lwY;
        if (localObject != null)
        {
          ((CaptureContainer)localObject).onResume();
          AppMethodBeat.o(2879);
          return;
        }
        AppMethodBeat.o(2879);
        return;
      }
      ab.i(this.TAG, "initOnCreateAfterConnected: no permission");
      AppMethodBeat.o(2879);
      return;
    }
    Object localObject = this.lxb;
    if (localObject != null)
    {
      ((b.a)localObject).resume();
      AppMethodBeat.o(2879);
      return;
    }
    AppMethodBeat.o(2879);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.emojicapture.ui.EmojiCaptureUI
 * JD-Core Version:    0.7.0.1
 */