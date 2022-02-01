package com.tencent.mm.plugin.finder.accessibility;

import androidx.appcompat.app.AppCompatActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.accessibility.base.MMBaseAccessibilityConfig.GlobalFocusOrderHelper;
import com.tencent.mm.plugin.finder.accessibility.base.a;
import com.tencent.mm.plugin.finder.e.e;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/accessibility/FinderVideoEditAccessibility;", "Lcom/tencent/mm/plugin/finder/accessibility/base/MMFinderBaseAccessibility;", "activity", "Landroidx/appcompat/app/AppCompatActivity;", "(Landroidx/appcompat/app/AppCompatActivity;)V", "initConfig", "", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class t
  extends a
{
  public t(AppCompatActivity paramAppCompatActivity)
  {
    super(paramAppCompatActivity);
    AppMethodBeat.i(334011);
    AppMethodBeat.o(334011);
  }
  
  public final void initConfig()
  {
    AppMethodBeat.i(334017);
    focusFirst(16908290);
    focusOrder().next(e.e.vlog_editor_thumb_view).next(e.e.vlog_editor_video_status).next(e.e.vlog_thumb_recycler);
    focusOrder().next(e.e.story_editor_audio_search_edit).next(e.e.story_editor_audio_search_edit_clean);
    AppMethodBeat.o(334017);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.accessibility.t
 * JD-Core Version:    0.7.0.1
 */