package com.tencent.mm.plugin.finder.accessibility;

import androidx.appcompat.app.AppCompatActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.accessibility.base.MMBaseAccessibilityConfig.ConfigHelper;
import com.tencent.mm.accessibility.base.ViewSetter;
import com.tencent.mm.plugin.finder.accessibility.base.a;
import com.tencent.mm.plugin.finder.e.e;
import kotlin.Metadata;
import kotlin.g.a.b;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/accessibility/FinderWxMsgAccessibility;", "Lcom/tencent/mm/plugin/finder/accessibility/base/MMFinderBaseAccessibility;", "Lcom/tencent/mm/plugin/finder/accessibility/IFinderWxMsgAccessibility;", "activity", "Landroidx/appcompat/app/AppCompatActivity;", "(Landroidx/appcompat/app/AppCompatActivity;)V", "initConfig", "", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class u
  extends a
  implements y
{
  public u(AppCompatActivity paramAppCompatActivity)
  {
    super(paramAppCompatActivity);
    AppMethodBeat.i(334008);
    AppMethodBeat.o(334008);
  }
  
  public final void initConfig()
  {
    AppMethodBeat.i(334018);
    root(e.e.msg_item_of_like_container).view(e.e.msg_item_of_like_container).desc((b)new u.a(this));
    root(e.e.msg_item_of_friend_object_recommend_like_container).view(e.e.msg_item_of_friend_object_recommend_like_container).desc((b)new u.b(this));
    root(e.e.msg_item_of_comment_new_container).view(e.e.msg_item_of_comment_new_container).desc((b)new u.c(this));
    root(e.e.msg_item_of_comment_container).view(e.e.msg_item_of_comment_container).desc((b)new u.d(this));
    root(e.e.msg_item_of_follow_new_container).view(e.e.msg_item_of_follow_new_container).desc((b)new u.e(this));
    AppMethodBeat.o(334018);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes12.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.accessibility.u
 * JD-Core Version:    0.7.0.1
 */