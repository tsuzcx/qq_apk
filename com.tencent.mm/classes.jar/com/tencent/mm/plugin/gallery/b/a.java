package com.tencent.mm.plugin.gallery.b;

import androidx.appcompat.app.AppCompatActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.accessibility.base.MMBaseAccessibilityConfig;
import com.tencent.mm.accessibility.base.MMBaseAccessibilityConfig.ConfigHelper;
import com.tencent.mm.accessibility.base.ViewSetter;
import com.tencent.mm.plugin.gallery.b.e;
import com.tencent.mm.plugin.gallery.b.f;
import com.tencent.mm.plugin.gallery.b.i;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/gallery/utils/AlbumAccessibility;", "Lcom/tencent/mm/accessibility/base/MMBaseAccessibilityConfig;", "activity", "Landroidx/appcompat/app/AppCompatActivity;", "(Landroidx/appcompat/app/AppCompatActivity;)V", "initConfig", "", "plugin-gallery_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a
  extends MMBaseAccessibilityConfig
{
  public a(AppCompatActivity paramAppCompatActivity)
  {
    super(paramAppCompatActivity);
    AppMethodBeat.i(289269);
    AppMethodBeat.o(289269);
  }
  
  public final void initConfig()
  {
    AppMethodBeat.i(289272);
    root(b.f.action_option_view).view(b.e.album_smart_gallery_entry).desc(b.i.aging_album_action_bar_search);
    AppMethodBeat.o(289272);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.gallery.b.a
 * JD-Core Version:    0.7.0.1
 */