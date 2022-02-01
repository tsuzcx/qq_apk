package com.tencent.mm.plugin.finder.ui;

import androidx.fragment.app.Fragment;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.e.h;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/ui/FinderConversationXXUI;", "Lcom/tencent/mm/plugin/finder/ui/FinderConversationParentUI;", "()V", "getFragment", "Landroidx/fragment/app/Fragment;", "getTitleResId", "", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class FinderConversationXXUI
  extends FinderConversationParentUI
{
  public final void _$_clearFindViewByIdCache() {}
  
  public final String eeH()
  {
    AppMethodBeat.i(346416);
    String str = getString(e.h.finder_conversation_hello_message_title);
    s.s(str, "this.getString(R.string.…tion_hello_message_title)");
    AppMethodBeat.o(346416);
    return str;
  }
  
  public final Fragment getFragment()
  {
    AppMethodBeat.i(346422);
    Fragment localFragment = (Fragment)new FinderSayHiConvFragment();
    AppMethodBeat.o(346422);
    return localFragment;
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.ui.FinderConversationXXUI
 * JD-Core Version:    0.7.0.1
 */