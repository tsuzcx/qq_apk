package com.tencent.mm.media.editor.b;

import a.f.a.b;
import a.l;
import a.y;
import android.content.Context;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/media/editor/panel/EditorEmojiPanel;", "Lcom/tencent/mm/emoji/view/EmojiPanelBottomSheet;", "Lcom/tencent/mm/media/editor/panel/IEditorPanel;", "context", "Landroid/content/Context;", "parent", "Landroid/view/ViewGroup;", "darkMode", "", "(Landroid/content/Context;Landroid/view/ViewGroup;Z)V", "visibleCallback", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "visible", "", "dismiss", "setOnVisibleChangeCallback", "callback", "setShow", "show", "plugin-mediaeditor_release"})
public final class a
  extends com.tencent.mm.emoji.view.a
{
  public b<? super Boolean, y> eTl;
  
  public a(Context paramContext, ViewGroup paramViewGroup)
  {
    super(paramContext, paramViewGroup);
    AppMethodBeat.i(12899);
    AppMethodBeat.o(12899);
  }
  
  public final void dismiss()
  {
    AppMethodBeat.i(12898);
    super.dismiss();
    b localb = this.eTl;
    if (localb != null)
    {
      localb.S(Boolean.FALSE);
      AppMethodBeat.o(12898);
      return;
    }
    AppMethodBeat.o(12898);
  }
  
  public final void setShow(boolean paramBoolean)
  {
    AppMethodBeat.i(12896);
    if (paramBoolean)
    {
      show();
      AppMethodBeat.o(12896);
      return;
    }
    dismiss();
    AppMethodBeat.o(12896);
  }
  
  public final void show()
  {
    AppMethodBeat.i(12897);
    super.show();
    b localb = this.eTl;
    if (localb != null)
    {
      localb.S(Boolean.TRUE);
      AppMethodBeat.o(12897);
      return;
    }
    AppMethodBeat.o(12897);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.media.editor.b.a
 * JD-Core Version:    0.7.0.1
 */