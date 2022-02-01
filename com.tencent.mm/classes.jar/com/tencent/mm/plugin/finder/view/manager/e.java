package com.tencent.mm.plugin.finder.view.manager;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.utils.bo;
import com.tencent.mm.plugin.finder.view.FinderPostEditText;
import com.tencent.mm.ui.MMActivity;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/view/manager/FinderTopicSuggestManager;", "", "descTv", "Lcom/tencent/mm/plugin/finder/view/FinderPostEditText;", "activity", "Lcom/tencent/mm/ui/MMActivity;", "(Lcom/tencent/mm/plugin/finder/view/FinderPostEditText;Lcom/tencent/mm/ui/MMActivity;)V", "getActivity", "()Lcom/tencent/mm/ui/MMActivity;", "curTopicInfoList", "", "Lcom/tencent/mm/plugin/finder/utils/TopicStringInfo;", "getCurTopicInfoList", "()Ljava/util/List;", "getDescTv", "()Lcom/tencent/mm/plugin/finder/view/FinderPostEditText;", "extractTopicAndSetSpan", "", "curDesc", "", "s", "Landroid/text/Editable;", "atStringInfoList", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/finder/utils/FinderAtUtil$AtStringInfo;", "Lkotlin/collections/ArrayList;", "Companion", "plugin-finder-publish_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class e
{
  public static final a GIc;
  private static final String TAG;
  private final FinderPostEditText ESV;
  public final List<bo> GId;
  private final MMActivity activity;
  
  static
  {
    AppMethodBeat.i(168549);
    GIc = new a((byte)0);
    TAG = "Finder.FinderTopicSuggestManager";
    AppMethodBeat.o(168549);
  }
  
  public e(FinderPostEditText paramFinderPostEditText, MMActivity paramMMActivity)
  {
    AppMethodBeat.i(346107);
    this.ESV = paramFinderPostEditText;
    this.activity = paramMMActivity;
    this.GId = ((List)new ArrayList());
    AppMethodBeat.o(346107);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/view/manager/FinderTopicSuggestManager$Companion;", "", "()V", "TAG", "", "plugin-finder-publish_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.view.manager.e
 * JD-Core Version:    0.7.0.1
 */