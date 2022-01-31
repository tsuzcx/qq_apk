package com.tencent.mm.plugin.emojicapture.ui.editor;

import a.l;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.emojicapture.api.EmojiCaptureReporter;
import com.tencent.mm.plugin.emojicapture.c.b.a;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
final class CaptureEditorContainer$1
  implements View.OnClickListener
{
  CaptureEditorContainer$1(CaptureEditorContainer paramCaptureEditorContainer) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(3025);
    EmojiCaptureReporter.a(10, CaptureEditorContainer.c(this.lzm).eyh, 0L, 0L, 0L, 0L, 0L, 0, 0, CaptureEditorContainer.c(this.lzm).scene);
    paramView = CaptureEditorContainer.d(this.lzm);
    Object localObject = this.lzm.getPresenter();
    boolean bool;
    if (localObject != null)
    {
      bool = ((b.a)localObject).bnA();
      paramView.setSelected(bool);
      localObject = CaptureEditorContainer.e(this.lzm);
      if (!CaptureEditorContainer.d(this.lzm).isSelected()) {
        break label116;
      }
    }
    label116:
    for (paramView = CaptureEditorContainer.f(this.lzm);; paramView = CaptureEditorContainer.g(this.lzm))
    {
      ((ImageView)localObject).setImageDrawable(paramView);
      AppMethodBeat.o(3025);
      return;
      bool = false;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.emojicapture.ui.editor.CaptureEditorContainer.1
 * JD-Core Version:    0.7.0.1
 */