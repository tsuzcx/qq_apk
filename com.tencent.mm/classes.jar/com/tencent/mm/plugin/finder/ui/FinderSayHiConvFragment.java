package com.tencent.mm.plugin.finder.ui;

import androidx.fragment.app.FragmentActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.chatting.BasePrivateMsgConvListFragment.a;
import com.tencent.mm.plugin.finder.conv.b;
import java.util.List;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/ui/FinderSayHiConvFragment;", "Lcom/tencent/mm/plugin/finder/ui/FinderBaseConversationFragment;", "()V", "isLastHiSession", "", "onExitChattingUI", "", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class FinderSayHiConvFragment
  extends FinderBaseConversationFragment
{
  public final void faI()
  {
    AppMethodBeat.i(346607);
    if ((aNG().getDataList().size() == 1) && (((b)aNG().getDataList().get(0)).field_type != 1)) {}
    for (int i = 1;; i = 0)
    {
      if (i != 0)
      {
        FragmentActivity localFragmentActivity = getActivity();
        if (localFragmentActivity != null) {
          localFragmentActivity.setResult(1);
        }
        localFragmentActivity = getActivity();
        if (localFragmentActivity != null) {
          localFragmentActivity.finish();
        }
        localFragmentActivity = getActivity();
        if (localFragmentActivity != null) {
          localFragmentActivity.overridePendingTransition(0, 0);
        }
      }
      AppMethodBeat.o(346607);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.ui.FinderSayHiConvFragment
 * JD-Core Version:    0.7.0.1
 */