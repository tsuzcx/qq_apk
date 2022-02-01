package com.tencent.mm.plugin.emojicapture.ui;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.Window;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.emojicapture.a.a;
import com.tencent.mm.plugin.emojicapture.a.f;
import com.tencent.mm.plugin.emojicapture.a.g;
import com.tencent.mm.plugin.emojicapture.a.h;
import com.tencent.mm.plugin.emojicapture.a.i;
import com.tencent.mm.plugin.emojicapture.proxy.EmojiCaptureProxy;
import com.tencent.mm.plugin.emojicapture.proxy.EmojiCaptureProxy.a;
import com.tencent.mm.plugin.emojicapture.ui.preview.StickerPreviewView;
import com.tencent.mm.plugin.mmsight.model.j;
import com.tencent.mm.pluginsdk.permission.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.MMActivity;
import kotlin.Metadata;
import kotlin.g.b.s;

@com.tencent.mm.ui.base.a(3)
@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/emojicapture/ui/StickerPreviewUI;", "Lcom/tencent/mm/ui/MMActivity;", "()V", "TAG", "", "stickerPreview", "Lcom/tencent/mm/plugin/emojicapture/ui/preview/StickerPreviewView;", "stickerUrl", "finish", "", "getLayoutId", "", "initOnCreateAfterConnected", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onPause", "onResume", "plugin-emojicapture_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class StickerPreviewUI
  extends MMActivity
{
  private final String TAG = "MicroMsg.StickerPreviewUI";
  private String ykt;
  private StickerPreviewView yku;
  
  private static final void a(StickerPreviewUI paramStickerPreviewUI)
  {
    AppMethodBeat.i(269400);
    s.u(paramStickerPreviewUI, "this$0");
    paramStickerPreviewUI.yku = ((StickerPreviewView)paramStickerPreviewUI.findViewById(a.f.yeU));
    String str = paramStickerPreviewUI.ykt;
    if (str != null)
    {
      StickerPreviewView localStickerPreviewView = paramStickerPreviewUI.yku;
      if (localStickerPreviewView != null) {
        localStickerPreviewView.setStickerUrl(str);
      }
    }
    if (b.g((Context)paramStickerPreviewUI, new String[] { "android.permission.CAMERA" }))
    {
      paramStickerPreviewUI = paramStickerPreviewUI.yku;
      if (paramStickerPreviewUI != null)
      {
        paramStickerPreviewUI.onResume();
        AppMethodBeat.o(269400);
      }
    }
    else
    {
      Log.i(paramStickerPreviewUI.TAG, "initOnCreateAfterConnected: no permission");
      b.a(new StickerPreviewUI..ExternalSyntheticLambda1(paramStickerPreviewUI), "android.permission.CAMERA");
    }
    AppMethodBeat.o(269400);
  }
  
  private static final void a(StickerPreviewUI paramStickerPreviewUI, int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    int j = 1;
    AppMethodBeat.i(269401);
    s.u(paramStickerPreviewUI, "this$0");
    s.s(paramArrayOfInt, "results");
    int k = paramArrayOfInt.length;
    paramInt = 0;
    int i;
    if (paramInt < k) {
      if (paramArrayOfInt[paramInt] != 0)
      {
        i = 1;
        label41:
        if (i == 0) {
          break label78;
        }
      }
    }
    for (paramInt = j;; paramInt = 0)
    {
      if (paramInt != 0)
      {
        Log.w(paramStickerPreviewUI.TAG, "request permission: not granted");
        paramStickerPreviewUI.finish();
      }
      AppMethodBeat.o(269401);
      return;
      i = 0;
      break label41;
      label78:
      paramInt += 1;
      break;
    }
  }
  
  private static final boolean a(StickerPreviewUI paramStickerPreviewUI, MenuItem paramMenuItem)
  {
    AppMethodBeat.i(269398);
    s.u(paramStickerPreviewUI, "this$0");
    paramStickerPreviewUI.finish();
    AppMethodBeat.o(269398);
    return true;
  }
  
  public final void finish()
  {
    AppMethodBeat.i(516);
    super.finish();
    overridePendingTransition(-1, a.a.ydP);
    AppMethodBeat.o(516);
  }
  
  public final int getLayoutId()
  {
    return a.g.yfz;
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(512);
    overridePendingTransition(a.a.ydO, -1);
    super.onCreate(paramBundle);
    paramBundle = getWindow();
    if (paramBundle != null) {
      paramBundle.addFlags(134217728);
    }
    setActionbarColor(0);
    updateBackBtn(getDrawable(a.h.actionbar_icon_light_close));
    com.tencent.mm.ui.statusbar.d.g(getWindow());
    setBackBtn(new StickerPreviewUI..ExternalSyntheticLambda0(this));
    setMMTitle(a.i.yga);
    this.ykt = getIntent().getStringExtra("sticker_url");
    j.gci();
    paramBundle = EmojiCaptureProxy.yjA;
    EmojiCaptureProxy.a.dEz();
    paramBundle = EmojiCaptureProxy.yjA;
    paramBundle = EmojiCaptureProxy.access$getInstance$cp().getServerProxy();
    if (paramBundle != null) {
      paramBundle.connect(new StickerPreviewUI..ExternalSyntheticLambda2(this));
    }
    AppMethodBeat.o(512);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(515);
    super.onDestroy();
    StickerPreviewView localStickerPreviewView = this.yku;
    if (localStickerPreviewView != null)
    {
      com.tencent.mm.sticker.loader.e locale = com.tencent.mm.sticker.loader.e.acCJ;
      com.tencent.mm.sticker.loader.e.b((com.tencent.mm.loader.f.e)localStickerPreviewView.yoF);
    }
    AppMethodBeat.o(515);
  }
  
  public final void onPause()
  {
    AppMethodBeat.i(513);
    super.onPause();
    StickerPreviewView localStickerPreviewView = this.yku;
    if (localStickerPreviewView != null) {
      localStickerPreviewView.ykS.auq();
    }
    AppMethodBeat.o(513);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(514);
    super.onResume();
    StickerPreviewView localStickerPreviewView = this.yku;
    if (localStickerPreviewView != null) {
      localStickerPreviewView.onResume();
    }
    AppMethodBeat.o(514);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.emojicapture.ui.StickerPreviewUI
 * JD-Core Version:    0.7.0.1
 */