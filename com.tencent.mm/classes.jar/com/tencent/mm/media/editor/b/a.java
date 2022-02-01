package com.tencent.mm.media.editor.b;

import android.content.Context;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import d.g.a.b;
import d.l;
import d.y;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/media/editor/panel/EditorEmojiPanel;", "Lcom/tencent/mm/emoji/view/EmojiPanelBottomSheet;", "Lcom/tencent/mm/media/editor/panel/IEditorPanel;", "context", "Landroid/content/Context;", "parent", "Landroid/view/ViewGroup;", "darkMode", "", "(Landroid/content/Context;Landroid/view/ViewGroup;Z)V", "visibleCallback", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "visible", "", "dismiss", "setOnVisibleChangeCallback", "callback", "setShow", "show", "plugin-mediaeditor_release"})
public final class a
  extends com.tencent.mm.emoji.view.a
{
  public b<? super Boolean, y> gPX;
  
  public a(Context paramContext, ViewGroup paramViewGroup)
  {
    super(paramContext, paramViewGroup);
    AppMethodBeat.i(93590);
    AppMethodBeat.o(93590);
  }
  
  public final void dismiss()
  {
    AppMethodBeat.i(93589);
    super.dismiss();
    b localb = this.gPX;
    if (localb != null)
    {
      localb.ay(Boolean.FALSE);
      AppMethodBeat.o(93589);
      return;
    }
    AppMethodBeat.o(93589);
  }
  
  public final void setShow(boolean paramBoolean)
  {
    AppMethodBeat.i(93587);
    if (paramBoolean)
    {
      show();
      AppMethodBeat.o(93587);
      return;
    }
    dismiss();
    AppMethodBeat.o(93587);
  }
  
  public final void show()
  {
    AppMethodBeat.i(93588);
    super.show();
    b localb = this.gPX;
    if (localb != null)
    {
      localb.ay(Boolean.TRUE);
      AppMethodBeat.o(93588);
      return;
    }
    AppMethodBeat.o(93588);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.media.editor.b.a
 * JD-Core Version:    0.7.0.1
 */