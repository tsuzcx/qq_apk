package com.tencent.mm.plugin.emojicapture.ui;

import a.f.b.j;
import a.l;
import android.content.Context;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.emojicapture.api.EmojiCaptureReporter;
import com.tencent.mm.plugin.emojicapture.c.a.a;
import com.tencent.mm.plugin.emojicapture.c.b.a;
import com.tencent.mm.plugin.emojicapture.model.a.a;
import com.tencent.mm.plugin.emojicapture.model.d;
import com.tencent.mm.plugin.emojicapture.model.e;
import com.tencent.mm.plugin.emojicapture.ui.capture.CaptureContainer;
import com.tencent.mm.plugin.emojicapture.ui.editor.CaptureEditorContainer;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.base.p;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"com/tencent/mm/plugin/emojicapture/ui/EmojiCaptureUI$uiNavigation$1", "Lcom/tencent/mm/plugin/emojicapture/ui/EmojiCaptureUI$UINavigation;", "loading", "Lcom/tencent/mm/ui/base/MMProgressDialog;", "dismissLoading", "", "exit", "success", "", "gifMd5", "", "go2Capture", "onEditorPrepared", "onVoiceFinished", "voiceText", "prepareEditor", "emojiCaptureInfo", "Lcom/tencent/mm/plugin/emojicapture/model/capture/EmojiCaptureInfo;", "showLoading", "context", "Landroid/content/Context;", "msg", "", "cancelAble", "style", "", "onCancelListener", "Landroid/content/DialogInterface$OnCancelListener;", "plugin-emojicapture_release"})
public final class EmojiCaptureUI$f
  implements EmojiCaptureUI.b
{
  private p lxi;
  
  public final void Lp(String paramString)
  {
    AppMethodBeat.i(2872);
    b.a locala = EmojiCaptureUI.d(this.lxg);
    if (locala != null)
    {
      locala.Lm(paramString);
      AppMethodBeat.o(2872);
      return;
    }
    AppMethodBeat.o(2872);
  }
  
  public final void a(Context paramContext, CharSequence paramCharSequence, boolean paramBoolean, DialogInterface.OnCancelListener paramOnCancelListener)
  {
    AppMethodBeat.i(2873);
    j.q(paramContext, "context");
    j.q(paramCharSequence, "msg");
    p localp = this.lxi;
    if (localp != null) {
      localp.dismiss();
    }
    this.lxi = p.b(paramContext, paramCharSequence, paramBoolean, paramOnCancelListener);
    ab.i(EmojiCaptureUI.a(this.lxg), "showLoading: " + this.lxi);
    AppMethodBeat.o(2873);
  }
  
  public final void boQ()
  {
    AppMethodBeat.i(2870);
    ab.i(EmojiCaptureUI.a(this.lxg), "go2Capture");
    Object localObject = EmojiCaptureUI.g(this.lxg);
    if (localObject != null) {
      ((CaptureContainer)localObject).setVisibility(0);
    }
    localObject = EmojiCaptureUI.c(this.lxg);
    if (localObject != null) {
      ((CaptureEditorContainer)localObject).setVisibility(8);
    }
    localObject = EmojiCaptureUI.g(this.lxg);
    if (localObject != null) {
      ((CaptureContainer)localObject).onResume();
    }
    EmojiCaptureUI.a(this.lxg, 0);
    AppMethodBeat.o(2870);
  }
  
  public final void boR()
  {
    AppMethodBeat.i(2871);
    ab.i(EmojiCaptureUI.a(this.lxg), "onEditorPrepared");
    if (EmojiCaptureUI.f(this.lxg) == 2)
    {
      Object localObject = EmojiCaptureUI.c(this.lxg);
      if (localObject != null) {
        ((CaptureEditorContainer)localObject).setAlpha(1.0F);
      }
      localObject = EmojiCaptureUI.g(this.lxg);
      if (localObject != null) {
        ((CaptureContainer)localObject).setVisibility(8);
      }
      boS();
      EmojiCaptureUI.a(this.lxg, 1);
    }
    AppMethodBeat.o(2871);
  }
  
  public final void boS()
  {
    AppMethodBeat.i(2874);
    p localp = this.lxi;
    if (localp != null) {
      localp.dismiss();
    }
    ab.i(EmojiCaptureUI.a(this.lxg), "dismissLoading: " + this.lxi);
    AppMethodBeat.o(2874);
  }
  
  public final void c(a parama)
  {
    AppMethodBeat.i(2869);
    j.q(parama, "emojiCaptureInfo");
    ab.i(EmojiCaptureUI.a(this.lxg), "prepareEditor " + parama.videoPath);
    Object localObject = e.lty;
    if (!e.Lo(parama.videoPath))
    {
      EmojiCaptureReporter.uB(2);
      parama = d.ltx;
      d.bnY();
      AppMethodBeat.o(2869);
      return;
    }
    localObject = EmojiCaptureUI.c(this.lxg);
    if (localObject != null) {
      ((CaptureEditorContainer)localObject).setVisibility(0);
    }
    localObject = EmojiCaptureUI.c(this.lxg);
    if (localObject != null) {
      ((CaptureEditorContainer)localObject).setAlpha(0.0F);
    }
    localObject = EmojiCaptureUI.d(this.lxg);
    if (localObject != null) {
      ((b.a)localObject).b(parama);
    }
    parama = EmojiCaptureUI.e(this.lxg);
    if (parama != null) {
      parama.me();
    }
    EmojiCaptureUI.a(this.lxg, 2);
    AppMethodBeat.o(2869);
  }
  
  public final void m(boolean paramBoolean, String paramString)
  {
    AppMethodBeat.i(2875);
    Intent localIntent = new Intent();
    if (paramBoolean)
    {
      localIntent.putExtra("key_enter_time", EmojiCaptureUI.h(this.lxg));
      localIntent.putExtra("gif_md5", paramString);
      this.lxg.setResult(-1, localIntent);
    }
    for (;;)
    {
      this.lxg.finish();
      AppMethodBeat.o(2875);
      return;
      EmojiCaptureUI.i(this.lxg).cew = (System.currentTimeMillis() - EmojiCaptureUI.i(this.lxg).eyh);
      EmojiCaptureReporter.a(6, EmojiCaptureUI.i(this.lxg).eyh, EmojiCaptureUI.i(this.lxg).cew, 0L, 0L, 0L, 0L, 0, 0, EmojiCaptureUI.i(this.lxg).scene);
      this.lxg.setResult(0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.emojicapture.ui.EmojiCaptureUI.f
 * JD-Core Version:    0.7.0.1
 */