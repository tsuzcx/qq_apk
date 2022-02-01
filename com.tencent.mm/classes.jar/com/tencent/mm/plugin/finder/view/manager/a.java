package com.tencent.mm.plugin.finder.view.manager;

import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/view/manager/FinderActivityPostManager;", "", "()V", "activityBtn", "Landroid/view/View;", "getActivityBtn", "()Landroid/view/View;", "setActivityBtn", "(Landroid/view/View;)V", "activityDesc", "", "getActivityDesc", "()Ljava/lang/String;", "setActivityDesc", "(Ljava/lang/String;)V", "activityName", "getActivityName", "setActivityName", "eventTopicId", "", "getEventTopicId", "()J", "setEventTopicId", "(J)V", "isExistActivity", "", "()Z", "setExistActivity", "(Z)V", "spanContent", "getSpanContent", "setSpanContent", "extractTopicAndSetSpan", "", "curDesc", "s", "Landroid/text/Editable;", "onBeforeTextChanged", "Lcom/tencent/mm/plugin/finder/view/manager/FinderActivityPostManager$TextDeleteRecord;", "editText", "Lcom/tencent/mm/ui/widget/MMEditText;", "beforeText", "count", "", "setActivityContent", "nickName", "Companion", "TextDeleteRecord", "plugin-finder_release"})
public final class a
{
  private static final String TAG = "Finder.FinderActivityPostManager";
  private static final String wsC = "#@";
  private static final String wsD = ": ";
  private static final char wsE = ' ';
  public static final a wsF;
  private String activityName = "";
  private String trk = "";
  View wsA;
  boolean wsB;
  String wsz = "";
  
  static
  {
    AppMethodBeat.i(255246);
    wsF = new a((byte)0);
    TAG = "Finder.FinderActivityPostManager";
    wsC = "#@";
    wsD = ": ";
    wsE = ' ';
    AppMethodBeat.o(255246);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/view/manager/FinderActivityPostManager$Companion;", "", "()V", "ACTIVITY_PREFIX_SPLIT_STR", "", "getACTIVITY_PREFIX_SPLIT_STR", "()Ljava/lang/String;", "ACTIVITY_PREFIX_STR", "getACTIVITY_PREFIX_STR", "ACTIVITY_SURFIX_CHAR", "", "getACTIVITY_SURFIX_CHAR", "()C", "TAG", "getTAG", "plugin-finder_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.view.manager.a
 * JD-Core Version:    0.7.0.1
 */