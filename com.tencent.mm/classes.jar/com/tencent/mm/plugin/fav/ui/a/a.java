package com.tencent.mm.plugin.fav.ui.a;

import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.accessibility.base.MMBaseAccessibilityConfig;
import com.tencent.mm.accessibility.base.MMBaseAccessibilityConfig.ConfigHelper;
import com.tencent.mm.accessibility.base.ViewSetter;
import com.tencent.mm.accessibility.type.ViewType;
import com.tencent.mm.plugin.fav.ui.q.e;
import com.tencent.mm.plugin.fav.ui.q.f;
import kotlin.Metadata;
import kotlin.g.a.b;
import kotlin.g.b.u;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/fav/ui/accessibility/FavoriteIndexUIAccessibility;", "Lcom/tencent/mm/accessibility/base/MMBaseAccessibilityConfig;", "activity", "Landroidx/appcompat/app/AppCompatActivity;", "(Landroidx/appcompat/app/AppCompatActivity;)V", "initConfig", "", "ui-fav_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a
  extends MMBaseAccessibilityConfig
{
  public a(AppCompatActivity paramAppCompatActivity)
  {
    super(paramAppCompatActivity);
    AppMethodBeat.i(274538);
    AppMethodBeat.o(274538);
  }
  
  public final void initConfig()
  {
    AppMethodBeat.i(274547);
    int i = q.e.action_option_icon;
    view(i, i).type(ViewType.Button).desc((b)new a(this));
    root(q.f.actionbar_custom_menu_item_new);
    i = q.e.action_option_icon;
    view(i, i).type(ViewType.Button).desc((b)new b(this));
    MMBaseAccessibilityConfig.ConfigHelper localConfigHelper = root(q.e.top_fav_container);
    localConfigHelper.view(q.e.fav_sub_url_tv).desc((b)new c(this)).type(ViewType.Button);
    localConfigHelper.view(q.e.fav_sub_image_tv).desc((b)new d(this)).type(ViewType.Button);
    localConfigHelper.view(q.e.fav_sub_voice_tv).desc((b)new e(this)).type(ViewType.Button);
    localConfigHelper.view(q.e.fav_sub_music_tv).desc((b)new f(this)).type(ViewType.Button);
    localConfigHelper.view(q.e.fav_sub_location_tv).desc((b)new g(this)).type(ViewType.Button);
    localConfigHelper.view(q.e.fav_sub_file_tv).desc((b)new h(this)).type(ViewType.Button);
    localConfigHelper.view(q.e.fav_sub_record_tv).desc((b)new i(this)).type(ViewType.Button);
    localConfigHelper.view(q.e.fav_sub_note_tv).desc((b)new j(this)).type(ViewType.Button);
    localConfigHelper.view(q.e.fav_sub_recently_used_tv).desc((b)new k(this)).type(ViewType.Button);
    AppMethodBeat.o(274547);
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "it", "Landroid/view/View;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class a
    extends u
    implements b<View, String>
  {
    a(a parama)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "it", "Landroid/view/View;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends u
    implements b<View, String>
  {
    b(a parama)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "it", "Landroid/view/View;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class c
    extends u
    implements b<View, String>
  {
    c(a parama)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "it", "Landroid/view/View;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class d
    extends u
    implements b<View, String>
  {
    d(a parama)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "it", "Landroid/view/View;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class e
    extends u
    implements b<View, String>
  {
    e(a parama)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "it", "Landroid/view/View;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class f
    extends u
    implements b<View, String>
  {
    f(a parama)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "it", "Landroid/view/View;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class g
    extends u
    implements b<View, String>
  {
    g(a parama)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "it", "Landroid/view/View;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class h
    extends u
    implements b<View, String>
  {
    h(a parama)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "it", "Landroid/view/View;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class i
    extends u
    implements b<View, String>
  {
    i(a parama)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "it", "Landroid/view/View;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class j
    extends u
    implements b<View, String>
  {
    j(a parama)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "it", "Landroid/view/View;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class k
    extends u
    implements b<View, String>
  {
    k(a parama)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.ui.a.a
 * JD-Core Version:    0.7.0.1
 */