package com.tencent.mm.plugin.finder.view.manager;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.utils.w.c;
import com.tencent.mm.plugin.finder.view.FinderPostEditText;
import com.tencent.mm.ui.MMActivity;
import java.util.ArrayList;
import java.util.List;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/view/manager/FinderTopicSuggestManager;", "", "descTv", "Lcom/tencent/mm/plugin/finder/view/FinderPostEditText;", "activity", "Lcom/tencent/mm/ui/MMActivity;", "(Lcom/tencent/mm/plugin/finder/view/FinderPostEditText;Lcom/tencent/mm/ui/MMActivity;)V", "getActivity", "()Lcom/tencent/mm/ui/MMActivity;", "curTopicInfoList", "", "Lcom/tencent/mm/plugin/finder/utils/FinderTopicUtil$TopicStringInfo;", "getCurTopicInfoList", "()Ljava/util/List;", "getDescTv", "()Lcom/tencent/mm/plugin/finder/view/FinderPostEditText;", "extractTopicAndSetSpan", "", "curDesc", "", "s", "Landroid/text/Editable;", "atStringInfoList", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/finder/utils/FinderAtUtil$AtStringInfo;", "Lkotlin/collections/ArrayList;", "Companion", "plugin-finder_release"})
public final class e
{
  private static final String TAG = "Finder.FinderTopicSuggestManager";
  public static final a wtu;
  private final MMActivity activity;
  private final FinderPostEditText vQR;
  public final List<w.c> wtt;
  
  static
  {
    AppMethodBeat.i(168549);
    wtu = new a((byte)0);
    TAG = "Finder.FinderTopicSuggestManager";
    AppMethodBeat.o(168549);
  }
  
  public e(FinderPostEditText paramFinderPostEditText, MMActivity paramMMActivity)
  {
    AppMethodBeat.i(255289);
    this.vQR = paramFinderPostEditText;
    this.activity = paramMMActivity;
    this.wtt = ((List)new ArrayList());
    AppMethodBeat.o(255289);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/view/manager/FinderTopicSuggestManager$Companion;", "", "()V", "TAG", "", "plugin-finder_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.view.manager.e
 * JD-Core Version:    0.7.0.1
 */