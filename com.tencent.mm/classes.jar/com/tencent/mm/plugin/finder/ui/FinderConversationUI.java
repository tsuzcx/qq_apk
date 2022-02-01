package com.tencent.mm.plugin.finder.ui;

import androidx.fragment.app.Fragment;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.e.h;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/ui/FinderConversationUI;", "Lcom/tencent/mm/plugin/finder/ui/FinderConversationParentUI;", "()V", "getFragment", "Landroidx/fragment/app/Fragment;", "getTitleResId", "", "Companion", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class FinderConversationUI
  extends FinderConversationParentUI
{
  public static final a FPb;
  
  static
  {
    AppMethodBeat.i(346384);
    FPb = new a((byte)0);
    AppMethodBeat.o(346384);
  }
  
  public final void _$_clearFindViewByIdCache() {}
  
  public final String eeH()
  {
    AppMethodBeat.i(346393);
    String str = getString(e.h.finder_conversation_finder_message_title);
    s.s(str, "this.getString(R.string.…ion_finder_message_title)");
    AppMethodBeat.o(346393);
    return str;
  }
  
  public final Fragment getFragment()
  {
    AppMethodBeat.i(346406);
    Fragment localFragment = (Fragment)new FinderConversationFragment();
    AppMethodBeat.o(346406);
    return localFragment;
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/ui/FinderConversationUI$Companion;", "", "()V", "REQUEST_CODE_HI_BOX", "", "RESULT_CODE_REMOVE_HI_BOX", "TAG", "", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.ui.FinderConversationUI
 * JD-Core Version:    0.7.0.1
 */