package com.tencent.mm.plugin.finder.view;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.ui.MMActivity;
import d.l;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
public final class FinderPostFooter$d
  implements View.OnClickListener
{
  public FinderPostFooter$d(MMActivity paramMMActivity, int paramInt) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(205802);
    Object localObject = new b();
    ((b)localObject).bd(paramView);
    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/view/FinderPostFooter$initView$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject).ahF());
    paramView = new Intent();
    paramView.putExtra("key_scene", 1);
    localObject = com.tencent.mm.plugin.finder.utils.a.sVQ;
    com.tencent.mm.plugin.finder.utils.a.d(this.lTT, paramView, this.tgB);
    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/view/FinderPostFooter$initView$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(205802);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.view.FinderPostFooter.d
 * JD-Core Version:    0.7.0.1
 */