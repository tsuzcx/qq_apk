package com.tencent.mm.plugin.finder.view.manager;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.utils.ax;
import com.tencent.mm.plugin.finder.view.FinderPostEditText;
import com.tencent.mm.ui.MMActivity;
import java.util.ArrayList;
import java.util.List;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/view/manager/FinderTopicSuggestManager;", "", "descTv", "Lcom/tencent/mm/plugin/finder/view/FinderPostEditText;", "activity", "Lcom/tencent/mm/ui/MMActivity;", "(Lcom/tencent/mm/plugin/finder/view/FinderPostEditText;Lcom/tencent/mm/ui/MMActivity;)V", "getActivity", "()Lcom/tencent/mm/ui/MMActivity;", "curTopicInfoList", "", "Lcom/tencent/mm/plugin/finder/utils/TopicStringInfo;", "getCurTopicInfoList", "()Ljava/util/List;", "getDescTv", "()Lcom/tencent/mm/plugin/finder/view/FinderPostEditText;", "extractTopicAndSetSpan", "", "curDesc", "", "s", "Landroid/text/Editable;", "atStringInfoList", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/finder/utils/FinderAtUtil$AtStringInfo;", "Lkotlin/collections/ArrayList;", "Companion", "plugin-finder_release"})
public final class e
{
  public static final a BfL;
  private static final String TAG = "Finder.FinderTopicSuggestManager";
  public final List<ax> BfK;
  private final MMActivity activity;
  private final FinderPostEditText yOz;
  
  static
  {
    AppMethodBeat.i(168549);
    BfL = new a((byte)0);
    TAG = "Finder.FinderTopicSuggestManager";
    AppMethodBeat.o(168549);
  }
  
  public e(FinderPostEditText paramFinderPostEditText, MMActivity paramMMActivity)
  {
    AppMethodBeat.i(290707);
    this.yOz = paramFinderPostEditText;
    this.activity = paramMMActivity;
    this.BfK = ((List)new ArrayList());
    AppMethodBeat.o(290707);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/view/manager/FinderTopicSuggestManager$Companion;", "", "()V", "TAG", "", "plugin-finder_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.view.manager.e
 * JD-Core Version:    0.7.0.1
 */