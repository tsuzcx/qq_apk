package com.tencent.mm.plugin.emojicapture.e;

import a.f.b.u.d;
import a.l;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.emojicapture.api.EmojiCaptureReporter;
import com.tencent.mm.plugin.emojicapture.c.b.b;
import com.tencent.mm.plugin.emojicapture.ui.editor.TextEditorItemView;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
final class c$k
  implements View.OnClickListener
{
  c$k(c paramc, u.d paramd) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(2777);
    c.a(this.lww).a(true, ((TextEditorItemView)this.lwE.BNq).getText(), ((TextEditorItemView)this.lwE.BNq).getTextColor());
    EmojiCaptureReporter.a(13, c.j(this.lww).eyh, 0L, 0L, 0L, 0L, 0L, 0, 0, c.j(this.lww).scene);
    AppMethodBeat.o(2777);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.emojicapture.e.c.k
 * JD-Core Version:    0.7.0.1
 */