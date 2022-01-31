package com.tencent.mm.plugin.emojicapture.ui.editor;

import a.f.b.j;
import a.l;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.api.k;
import com.tencent.mm.api.t.a;
import com.tencent.mm.plugin.emojicapture.c.b.a;
import com.tencent.mm.sdk.platformtools.ab;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"com/tencent/mm/plugin/emojicapture/ui/editor/CaptureEditorContainer$initSmileyPanel$1", "Lcom/tencent/mm/api/SmileyPanelCallbackWrapper$Callback;", "onHide", "", "onSelectedEmoji", "emojiInfo", "Lcom/tencent/mm/api/IEmojiInfo;", "plugin-emojicapture_release"})
public final class CaptureEditorContainer$a
  implements t.a
{
  public final void a(k paramk)
  {
    AppMethodBeat.i(3034);
    j.q(paramk, "emojiInfo");
    ab.i(CaptureEditorContainer.a(this.lzm), "[onSelectedEmoji] emojiInfo:%s", new Object[] { paramk });
    b.a locala = this.lzm.getPresenter();
    if (locala != null) {
      locala.c(paramk);
    }
    onHide();
    AppMethodBeat.o(3034);
  }
  
  public final void onHide()
  {
    AppMethodBeat.i(3035);
    this.lzm.gT(false);
    AppMethodBeat.o(3035);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.emojicapture.ui.editor.CaptureEditorContainer.a
 * JD-Core Version:    0.7.0.1
 */