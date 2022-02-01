package com.tencent.mm.plugin.finder;

import androidx.appcompat.app.AppCompatActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.accessibility.base.MMBaseAccessibilityConfig.ConfigHelper;
import com.tencent.mm.accessibility.base.ViewSetter;
import com.tencent.mm.plugin.finder.accessibility.base.a;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/FinderPostAccessibility;", "Lcom/tencent/mm/plugin/finder/accessibility/base/MMFinderBaseAccessibility;", "activity", "Landroidx/appcompat/app/AppCompatActivity;", "(Landroidx/appcompat/app/AppCompatActivity;)V", "initConfig", "", "plugin-finder-publish_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class c
  extends a
{
  public c(AppCompatActivity paramAppCompatActivity)
  {
    super(paramAppCompatActivity);
    AppMethodBeat.i(329815);
    AppMethodBeat.o(329815);
  }
  
  public final void initConfig()
  {
    AppMethodBeat.i(329817);
    root(e.e.edt_container).view(e.e.edt_container).desc(e.h.finder_add_desc_area);
    root(e.e.post_media_close).view(e.e.post_media_close).desc(e.h.finder_delete_media_desc);
    AppMethodBeat.o(329817);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.c
 * JD-Core Version:    0.7.0.1
 */