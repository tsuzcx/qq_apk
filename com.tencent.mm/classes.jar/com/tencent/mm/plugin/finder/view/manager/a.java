package com.tencent.mm.plugin.finder.view.manager;

import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/view/manager/FinderActivityPostManager;", "", "()V", "activityBtn", "Landroid/view/View;", "getActivityBtn", "()Landroid/view/View;", "setActivityBtn", "(Landroid/view/View;)V", "activityDesc", "", "getActivityDesc", "()Ljava/lang/String;", "setActivityDesc", "(Ljava/lang/String;)V", "activityName", "getActivityName", "setActivityName", "eventTopicId", "", "getEventTopicId", "()J", "setEventTopicId", "(J)V", "isExistActivity", "", "()Z", "setExistActivity", "(Z)V", "spanContent", "getSpanContent", "setSpanContent", "extractTopicAndSetSpan", "", "curDesc", "s", "Landroid/text/Editable;", "onBeforeTextChanged", "Lcom/tencent/mm/plugin/finder/view/manager/FinderActivityPostManager$TextDeleteRecord;", "editText", "Lcom/tencent/mm/ui/widget/MMEditText;", "beforeText", "count", "", "setActivityContent", "nickName", "Companion", "TextDeleteRecord", "plugin-finder-publish_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a
{
  private static final char GHA;
  public static final a GHu;
  private static final String GHy;
  private static final String GHz;
  private static final String TAG;
  private String AtM = "";
  private String Ava = "";
  String GHv = "";
  View GHw;
  boolean GHx;
  
  static
  {
    AppMethodBeat.i(346126);
    GHu = new a((byte)0);
    TAG = "Finder.FinderActivityPostManager";
    GHy = "#@";
    GHz = ": ";
    GHA = ' ';
    AppMethodBeat.o(346126);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/view/manager/FinderActivityPostManager$Companion;", "", "()V", "ACTIVITY_PREFIX_SPLIT_STR", "", "getACTIVITY_PREFIX_SPLIT_STR", "()Ljava/lang/String;", "ACTIVITY_PREFIX_STR", "getACTIVITY_PREFIX_STR", "ACTIVITY_SURFIX_CHAR", "", "getACTIVITY_SURFIX_CHAR", "()C", "TAG", "getTAG", "plugin-finder-publish_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.view.manager.a
 * JD-Core Version:    0.7.0.1
 */