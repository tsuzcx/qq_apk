package com.tencent.mm.plugin.fts.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;

final class FTSAddFriendUI$2
  implements View.OnClickListener
{
  FTSAddFriendUI$2(FTSAddFriendUI paramFTSAddFriendUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(111819);
    b localb = new b();
    localb.bn(paramView);
    a.c("com/tencent/mm/plugin/fts/ui/FTSAddFriendUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
    this.BMz.finish();
    a.a(this, "com/tencent/mm/plugin/fts/ui/FTSAddFriendUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(111819);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.ui.FTSAddFriendUI.2
 * JD-Core Version:    0.7.0.1
 */