package com.tencent.mm.plugin.emojicapture.ui.editor;

import a.l;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.emojicapture.api.EmojiCaptureReporter;
import com.tencent.mm.plugin.emojicapture.c.b.a;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
final class CaptureEditorContainer$2
  implements View.OnClickListener
{
  CaptureEditorContainer$2(CaptureEditorContainer paramCaptureEditorContainer) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(3026);
    EmojiCaptureReporter.a(11, CaptureEditorContainer.c(this.lzm).eyh, 0L, 0L, 0L, 0L, 0L, 0, 0, CaptureEditorContainer.c(this.lzm).scene);
    paramView = CaptureEditorContainer.h(this.lzm);
    Object localObject = this.lzm.getPresenter();
    boolean bool;
    if (localObject != null)
    {
      bool = ((b.a)localObject).bnB();
      paramView.setSelected(bool);
      localObject = CaptureEditorContainer.i(this.lzm);
      if (!CaptureEditorContainer.h(this.lzm).isSelected()) {
        break label116;
      }
    }
    label116:
    for (paramView = CaptureEditorContainer.j(this.lzm);; paramView = CaptureEditorContainer.k(this.lzm))
    {
      ((ImageView)localObject).setImageDrawable(paramView);
      AppMethodBeat.o(3026);
      return;
      bool = false;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.emojicapture.ui.editor.CaptureEditorContainer.2
 * JD-Core Version:    0.7.0.1
 */