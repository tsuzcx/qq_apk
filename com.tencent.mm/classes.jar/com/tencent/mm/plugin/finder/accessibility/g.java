package com.tencent.mm.plugin.finder.accessibility;

import android.content.Context;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.accessibility.base.MMBaseAccessibilityConfig.ConfigHelper;
import com.tencent.mm.accessibility.base.ViewSetter;
import com.tencent.mm.plugin.finder.accessibility.base.a;
import com.tencent.mm.plugin.finder.e.e;
import com.tencent.mm.plugin.finder.e.h;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import kotlin.Metadata;
import kotlin.g.a.b;
import kotlin.g.b.u;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/accessibility/FinderFeedItemAccessibility;", "Lcom/tencent/mm/plugin/finder/accessibility/base/MMFinderBaseAccessibility;", "Lcom/tencent/mm/plugin/finder/accessibility/IFinderFeedItemAccessibility;", "activity", "Landroidx/appcompat/app/AppCompatActivity;", "(Landroidx/appcompat/app/AppCompatActivity;)V", "initConfig", "", "Companion", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class g
  extends a
  implements x
{
  public static final a Ati;
  
  static
  {
    AppMethodBeat.i(334005);
    Ati = new a((byte)0);
    AppMethodBeat.o(334005);
  }
  
  public g(AppCompatActivity paramAppCompatActivity)
  {
    super(paramAppCompatActivity);
    AppMethodBeat.i(333993);
    AppMethodBeat.o(333993);
  }
  
  public final void initConfig()
  {
    AppMethodBeat.i(334023);
    final Context localContext = MMApplicationContext.getContext();
    MMBaseAccessibilityConfig.ConfigHelper localConfigHelper = root(e.e.feedHeaderBar);
    localConfigHelper.view(e.e.feed_header_content).clickAs(e.e.avatar_iv).disableChildren().desc((b)new b(this, localContext));
    localConfigHelper.view(e.e.nickname).disable();
    root(e.e.real_name_recommend_layout).view(e.e.real_name_recommend_list).desc((b)new c(this));
    root(e.e.footer_op_layout).view(e.e.awesome_icon_container).desc((b)new d(this, localContext));
    root(e.e.footer_op_layout).view(e.e.share_icon_container).desc((b)new e(this));
    root(e.e.footer_op_layout).view(e.e.comment_icon_container).desc((b)new f(this));
    root(e.e.footer_op_layout).view(e.e.star_icon_container).desc((b)new g(this));
    root(e.e.footer_op_layout).view(e.e.star_icon_container_first).desc((b)new h(this));
    root(e.e.content_text_container).view(e.e.text_content).desc((b)g.i.Atk);
    root(e.e.full_long_video_layout).view(e.e.video_float_ball_btn).desc(e.h.finder_minimize);
    AppMethodBeat.o(334023);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/accessibility/FinderFeedItemAccessibility$Companion;", "", "()V", "TAG", "", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "it", "Landroid/view/View;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends u
    implements b<View, String>
  {
    b(g paramg, Context paramContext)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "it", "Landroid/view/View;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class c
    extends u
    implements b<View, String>
  {
    c(g paramg)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "it", "Landroid/view/View;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class d
    extends u
    implements b<View, String>
  {
    d(g paramg, Context paramContext)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "it", "Landroid/view/View;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class e
    extends u
    implements b<View, String>
  {
    e(g paramg)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "it", "Landroid/view/View;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class f
    extends u
    implements b<View, String>
  {
    f(g paramg)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "it", "Landroid/view/View;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class g
    extends u
    implements b<View, String>
  {
    g(g paramg)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "it", "Landroid/view/View;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class h
    extends u
    implements b<View, String>
  {
    h(g paramg)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.accessibility.g
 * JD-Core Version:    0.7.0.1
 */