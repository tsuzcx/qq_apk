package com.tencent.mm.plugin.emojicapture.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.Window;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.loader.g.f;
import com.tencent.mm.plugin.emojicapture.proxy.EmojiCaptureProxy;
import com.tencent.mm.plugin.emojicapture.proxy.EmojiCaptureProxy.a;
import com.tencent.mm.plugin.emojicapture.ui.preview.StickerPreviewView;
import com.tencent.mm.pluginsdk.permission.c;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sticker.loader.e;
import com.tencent.mm.ui.MMActivity;
import d.l;

@com.tencent.mm.ui.base.a(3)
@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/emojicapture/ui/StickerPreviewUI;", "Lcom/tencent/mm/ui/MMActivity;", "()V", "TAG", "", "stickerPreview", "Lcom/tencent/mm/plugin/emojicapture/ui/preview/StickerPreviewView;", "stickerUrl", "finish", "", "getLayoutId", "", "initOnCreateAfterConnected", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onPause", "onResume", "plugin-emojicapture_release"})
public final class StickerPreviewUI
  extends MMActivity
{
  private final String TAG = "MicroMsg.StickerPreviewUI";
  private String oNX;
  private StickerPreviewView oNY;
  
  public final void finish()
  {
    AppMethodBeat.i(516);
    super.finish();
    overridePendingTransition(-1, 2130771984);
    AppMethodBeat.o(516);
  }
  
  public final int getLayoutId()
  {
    return 2131495643;
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(512);
    overridePendingTransition(2130771983, -1);
    super.onCreate(paramBundle);
    paramBundle = getWindow();
    if (paramBundle != null) {
      paramBundle.addFlags(134217728);
    }
    setActionbarColor(0);
    updateBackBtn(getDrawable(2131689499));
    com.tencent.mm.ui.statusbar.d.b(getWindow());
    setBackBtn((MenuItem.OnMenuItemClickListener)new b(this));
    setMMTitle(2131764149);
    this.oNX = getIntent().getStringExtra("sticker_url");
    com.tencent.mm.plugin.mmsight.model.k.cPR();
    paramBundle = EmojiCaptureProxy.oNd;
    EmojiCaptureProxy.a.aba();
    paramBundle = EmojiCaptureProxy.oNd;
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
    StickerPreviewView localStickerPreviewView = this.oNY;
    if (localStickerPreviewView != null)
    {
      e locale = e.Fds;
      e.b((f)localStickerPreviewView.oSP);
      AppMethodBeat.o(515);
      return;
    }
    AppMethodBeat.o(515);
  }
  
  public final void onPause()
  {
    AppMethodBeat.i(513);
    super.onPause();
    StickerPreviewView localStickerPreviewView = this.oNY;
    if (localStickerPreviewView != null)
    {
      localStickerPreviewView.oOA.stopPreview();
      AppMethodBeat.o(513);
      return;
    }
    AppMethodBeat.o(513);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(514);
    super.onResume();
    StickerPreviewView localStickerPreviewView = this.oNY;
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
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "<anonymous parameter 0>", "", "<anonymous parameter 1>", "", "", "kotlin.jvm.PlatformType", "results", "", "onRequestPermissionsResult", "(I[Ljava/lang/String;[I)V"})
  static final class a
    implements c
  {
    a(StickerPreviewUI paramStickerPreviewUI) {}
    
    public final void s(int[] paramArrayOfInt)
    {
      int k = 1;
      AppMethodBeat.i(509);
      d.g.b.k.g(paramArrayOfInt, "results");
      int m = paramArrayOfInt.length;
      int i = 0;
      int j;
      if (i < m) {
        if (paramArrayOfInt[i] != 0)
        {
          j = 1;
          label35:
          if (j == 0) {
            break label77;
          }
        }
      }
      for (i = k;; i = 0)
      {
        if (i != 0)
        {
          ad.w(StickerPreviewUI.b(this.oNZ), "request permission: not granted");
          this.oNZ.finish();
        }
        AppMethodBeat.o(509);
        return;
        j = 0;
        break label35;
        label77:
        i += 1;
        break;
      }
    }
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "it", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "onMenuItemClick"})
  static final class b
    implements MenuItem.OnMenuItemClickListener
  {
    b(StickerPreviewUI paramStickerPreviewUI) {}
    
    public final boolean onMenuItemClick(MenuItem paramMenuItem)
    {
      AppMethodBeat.i(510);
      this.oNZ.finish();
      AppMethodBeat.o(510);
      return true;
    }
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "run"})
  static final class c
    implements Runnable
  {
    c(StickerPreviewUI paramStickerPreviewUI) {}
    
    public final void run()
    {
      AppMethodBeat.i(511);
      StickerPreviewUI.a(this.oNZ);
      AppMethodBeat.o(511);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.emojicapture.ui.StickerPreviewUI
 * JD-Core Version:    0.7.0.1
 */