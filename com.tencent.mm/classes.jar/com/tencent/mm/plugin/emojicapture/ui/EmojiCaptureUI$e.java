package com.tencent.mm.plugin.emojicapture.ui;

import a.d.b.g;
import android.content.Context;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.mm.plugin.emojicapture.c.b.a;
import com.tencent.mm.plugin.emojicapture.f.a;
import com.tencent.mm.plugin.emojicapture.ui.capture.CaptureContainer;
import com.tencent.mm.plugin.emojicapture.ui.editor.CaptureEditorContainer;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.base.p;
import com.tencent.mm.vfs.e;

public final class EmojiCaptureUI$e
  implements EmojiCaptureUI.b
{
  private p jot;
  
  public final void Bn(String paramString)
  {
    EmojiCaptureUI.c(this.jos).Bi(paramString);
  }
  
  public final void a(Context paramContext, CharSequence paramCharSequence, DialogInterface.OnCancelListener paramOnCancelListener)
  {
    g.k(paramContext, "context");
    g.k(paramCharSequence, "msg");
    g.k(paramOnCancelListener, "onCancelListener");
    p localp = this.jot;
    if (localp != null) {
      localp.dismiss();
    }
    this.jot = p.b(paramContext, paramCharSequence, true, 0, paramOnCancelListener);
  }
  
  public final void aKK()
  {
    y.i(EmojiCaptureUI.a(this.jos), "go2Capture");
    EmojiCaptureUI.f(this.jos).setVisibility(0);
    EmojiCaptureUI.b(this.jos).setVisibility(8);
    EmojiCaptureUI.d(this.jos).aJN();
    EmojiCaptureUI.a(this.jos, 0);
  }
  
  public final void aKL()
  {
    y.i(EmojiCaptureUI.a(this.jos), "onEditorPrepared");
    if (EmojiCaptureUI.e(this.jos) == 2)
    {
      EmojiCaptureUI.b(this.jos).setAlpha(1.0F);
      EmojiCaptureUI.f(this.jos).setVisibility(8);
      p localp = this.jot;
      if (localp != null) {
        localp.dismiss();
      }
      EmojiCaptureUI.a(this.jos, 1);
    }
  }
  
  public final void ap(String paramString, boolean paramBoolean)
  {
    y.i(EmojiCaptureUI.a(this.jos), "prepareEditor " + paramString);
    if (e.aeQ(paramString) <= 0L)
    {
      paramString = a.jnW;
      com.tencent.mm.plugin.emojicapture.f.a.a.cG(2, 1);
      return;
    }
    EmojiCaptureUI.b(this.jos).setVisibility(0);
    EmojiCaptureUI.b(this.jos).setAlpha(0.0F);
    b.a locala = EmojiCaptureUI.c(this.jos);
    if (paramString == null) {
      g.cUk();
    }
    locala.ao(paramString, paramBoolean);
    EmojiCaptureUI.d(this.jos).aJM();
    EmojiCaptureUI.a(this.jos, 2);
  }
  
  public final void exit()
  {
    com.tencent.mm.plugin.emojicapture.f.a.a locala = a.jnW;
    long l = System.currentTimeMillis();
    locala = a.jnW;
    a.dE(l - a.aKo());
    locala = a.jnW;
    locala = a.jnW;
    com.tencent.mm.plugin.emojicapture.f.a.a.a(6, a.aKx(), 0L, 0L);
    this.jos.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.emojicapture.ui.EmojiCaptureUI.e
 * JD-Core Version:    0.7.0.1
 */