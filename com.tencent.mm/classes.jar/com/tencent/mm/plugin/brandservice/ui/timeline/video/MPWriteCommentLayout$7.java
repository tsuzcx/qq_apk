package com.tencent.mm.plugin.brandservice.ui.timeline.video;

import a.f.b.j;
import a.l;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.Button;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.widget.MMEditText;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"com/tencent/mm/plugin/brandservice/ui/timeline/video/MPWriteCommentLayout$7", "Landroid/text/TextWatcher;", "afterTextChanged", "", "s", "Landroid/text/Editable;", "beforeTextChanged", "", "start", "", "count", "after", "onTextChanged", "before", "plugin-brandservice_release"})
public final class MPWriteCommentLayout$7
  implements TextWatcher
{
  public final void afterTextChanged(Editable paramEditable) {}
  
  public final void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public final void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(152899);
    paramCharSequence = MPWriteCommentLayout.h(this.khv);
    Editable localEditable = MPWriteCommentLayout.e(this.khv).getText();
    j.p(localEditable, "contentEt.text");
    if (((CharSequence)localEditable).length() > 0) {}
    for (boolean bool = true;; bool = false)
    {
      paramCharSequence.setEnabled(bool);
      AppMethodBeat.o(152899);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.video.MPWriteCommentLayout.7
 * JD-Core Version:    0.7.0.1
 */