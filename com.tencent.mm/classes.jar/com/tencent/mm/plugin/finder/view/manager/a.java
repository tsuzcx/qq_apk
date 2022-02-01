package com.tencent.mm.plugin.finder.view.manager;

import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/view/manager/FinderActivityPostManager;", "", "()V", "activityBtn", "Landroid/view/View;", "getActivityBtn", "()Landroid/view/View;", "setActivityBtn", "(Landroid/view/View;)V", "activityDesc", "", "getActivityDesc", "()Ljava/lang/String;", "setActivityDesc", "(Ljava/lang/String;)V", "activityName", "getActivityName", "setActivityName", "eventTopicId", "", "getEventTopicId", "()J", "setEventTopicId", "(J)V", "isExistActivity", "", "()Z", "setExistActivity", "(Z)V", "spanContent", "getSpanContent", "setSpanContent", "extractTopicAndSetSpan", "", "curDesc", "s", "Landroid/text/Editable;", "onBeforeTextChanged", "Lcom/tencent/mm/plugin/finder/view/manager/FinderActivityPostManager$TextDeleteRecord;", "editText", "Lcom/tencent/mm/ui/widget/MMEditText;", "beforeText", "count", "", "setActivityContent", "nickName", "Companion", "TextDeleteRecord", "plugin-finder_release"})
public final class a
{
  private static final String BeT = "#@";
  private static final String BeU = ": ";
  private static final char BeV = ' ';
  public static final a BeW;
  private static final String TAG = "Finder.FinderActivityPostManager";
  String BeQ = "";
  View BeR;
  boolean BeS;
  private String activityName = "";
  private String wYd = "";
  
  static
  {
    AppMethodBeat.i(271036);
    BeW = new a((byte)0);
    TAG = "Finder.FinderActivityPostManager";
    BeT = "#@";
    BeU = ": ";
    BeV = ' ';
    AppMethodBeat.o(271036);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/view/manager/FinderActivityPostManager$Companion;", "", "()V", "ACTIVITY_PREFIX_SPLIT_STR", "", "getACTIVITY_PREFIX_SPLIT_STR", "()Ljava/lang/String;", "ACTIVITY_PREFIX_STR", "getACTIVITY_PREFIX_STR", "ACTIVITY_SURFIX_CHAR", "", "getACTIVITY_SURFIX_CHAR", "()C", "TAG", "getTAG", "plugin-finder_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.view.manager.a
 * JD-Core Version:    0.7.0.1
 */