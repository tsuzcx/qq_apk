package com.tencent.mm.plugin.finder.ui;

import android.view.View;
import android.view.View.OnLongClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.storage.as;
import kotlin.g.a.q;
import kotlin.g.b.aa.f;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onLongClick"})
final class c$b
  implements View.OnLongClickListener
{
  c$b(c paramc, aa.f paramf, as paramas) {}
  
  public final boolean onLongClick(View paramView)
  {
    AppMethodBeat.i(286309);
    Object localObject = new b();
    ((b)localObject).bn(paramView);
    a.c("com/tencent/mm/plugin/finder/ui/FinderFriendBlackListAdapter$getView$1", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z", this, ((b)localObject).aFi());
    paramView = this.AqX.AqW;
    String str;
    if (paramView != null)
    {
      localObject = (View)this.uXh.aaBC;
      str = this.AqY.getUsername();
      p.j(str, "blackUser.username");
      if (this.AqY.apt() != 1) {
        break label120;
      }
    }
    label120:
    for (boolean bool = true;; bool = false)
    {
      paramView.c(localObject, str, Boolean.valueOf(bool));
      a.a(true, this, "com/tencent/mm/plugin/finder/ui/FinderFriendBlackListAdapter$getView$1", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
      AppMethodBeat.o(286309);
      return true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.ui.c.b
 * JD-Core Version:    0.7.0.1
 */