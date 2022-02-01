package com.tencent.mm.plugin.emojicapture.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.Window;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.loader.g.f;
import com.tencent.mm.plugin.emojicapture.a.a;
import com.tencent.mm.plugin.emojicapture.a.g;
import com.tencent.mm.plugin.emojicapture.a.h;
import com.tencent.mm.plugin.emojicapture.a.i;
import com.tencent.mm.plugin.emojicapture.proxy.EmojiCaptureProxy;
import com.tencent.mm.plugin.emojicapture.proxy.EmojiCaptureProxy.a;
import com.tencent.mm.plugin.emojicapture.ui.preview.StickerPreviewView;
import com.tencent.mm.plugin.mmsight.model.j;
import com.tencent.mm.pluginsdk.permission.c;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sticker.loader.e;
import com.tencent.mm.ui.MMActivity;
import kotlin.g.b.p;
import kotlin.l;

@com.tencent.mm.ui.base.a(3)
@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/emojicapture/ui/StickerPreviewUI;", "Lcom/tencent/mm/ui/MMActivity;", "()V", "TAG", "", "stickerPreview", "Lcom/tencent/mm/plugin/emojicapture/ui/preview/StickerPreviewView;", "stickerUrl", "finish", "", "getLayoutId", "", "initOnCreateAfterConnected", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onPause", "onResume", "plugin-emojicapture_release"})
public final class StickerPreviewUI
  extends MMActivity
{
  private final String TAG = "MicroMsg.StickerPreviewUI";
  private String uYf;
  private StickerPreviewView uYg;
  
  public final void finish()
  {
    AppMethodBeat.i(516);
    super.finish();
    overridePendingTransition(-1, a.a.uRb);
    AppMethodBeat.o(516);
  }
  
  public final int getLayoutId()
  {
    return a.g.uSL;
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(512);
    overridePendingTransition(a.a.uRa, -1);
    super.onCreate(paramBundle);
    paramBundle = getWindow();
    if (paramBundle != null) {
      paramBundle.addFlags(134217728);
    }
    setActionbarColor(0);
    updateBackBtn(getDrawable(a.h.actionbar_icon_light_close));
    com.tencent.mm.ui.statusbar.d.e(getWindow());
    setBackBtn((MenuItem.OnMenuItemClickListener)new b(this));
    setMMTitle(a.i.uTm);
    this.uYf = getIntent().getStringExtra("sticker_url");
    j.eTp();
    paramBundle = EmojiCaptureProxy.uXl;
    EmojiCaptureProxy.a.cYi();
    paramBundle = EmojiCaptureProxy.uXl;
    paramBundle = EmojiCaptureProxy.access$getInstance$cp().getServerProxy();
    if (paramBundle != null)
    {
      paramBundle.connect((Runnable)new c(this));
      AppMethodBeat.o(512);
      return;
    }
    AppMethodBeat.o(512);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(515);
    super.onDestroy();
    StickerPreviewView localStickerPreviewView = this.uYg;
    if (localStickerPreviewView != null)
    {
      e locale = e.Vbx;
      e.b((f)localStickerPreviewView.vcM);
      AppMethodBeat.o(515);
      return;
    }
    AppMethodBeat.o(515);
  }
  
  public final void onPause()
  {
    AppMethodBeat.i(513);
    super.onPause();
    StickerPreviewView localStickerPreviewView = this.uYg;
    if (localStickerPreviewView != null)
    {
      localStickerPreviewView.uYH.TL();
      AppMethodBeat.o(513);
      return;
    }
    AppMethodBeat.o(513);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(514);
    super.onResume();
    StickerPreviewView localStickerPreviewView = this.uYg;
    if (localStickerPreviewView != null)
    {
      localStickerPreviewView.onResume();
      AppMethodBeat.o(514);
      return;
    }
    AppMethodBeat.o(514);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "<anonymous parameter 0>", "", "<anonymous parameter 1>", "", "", "kotlin.jvm.PlatformType", "results", "", "onRequestPermissionsResult", "(I[Ljava/lang/String;[I)V"})
  static final class a
    implements c
  {
    a(StickerPreviewUI paramStickerPreviewUI) {}
    
    public final void b(int paramInt, int[] paramArrayOfInt)
    {
      int j = 1;
      AppMethodBeat.i(202088);
      p.j(paramArrayOfInt, "results");
      int k = paramArrayOfInt.length;
      paramInt = 0;
      int i;
      if (paramInt < k) {
        if (paramArrayOfInt[paramInt] != 0)
        {
          i = 1;
          label34:
          if (i == 0) {
            break label75;
          }
        }
      }
      for (paramInt = j;; paramInt = 0)
      {
        if (paramInt != 0)
        {
          Log.w(StickerPreviewUI.b(this.uYh), "request permission: not granted");
          this.uYh.finish();
        }
        AppMethodBeat.o(202088);
        return;
        i = 0;
        break label34;
        label75:
        paramInt += 1;
        break;
      }
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "onMenuItemClick"})
  static final class b
    implements MenuItem.OnMenuItemClickListener
  {
    b(StickerPreviewUI paramStickerPreviewUI) {}
    
    public final boolean onMenuItemClick(MenuItem paramMenuItem)
    {
      AppMethodBeat.i(510);
      this.uYh.finish();
      AppMethodBeat.o(510);
      return true;
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
  static final class c
    implements Runnable
  {
    c(StickerPreviewUI paramStickerPreviewUI) {}
    
    public final void run()
    {
      AppMethodBeat.i(511);
      StickerPreviewUI.a(this.uYh);
      AppMethodBeat.o(511);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.emojicapture.ui.StickerPreviewUI
 * JD-Core Version:    0.7.0.1
 */