package com.tencent.mm.plugin.game.media;

import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;

final class k$4
  implements View.OnClickListener
{
  k$4(k paramk) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(195616);
    b localb = new b();
    localb.bd(paramView);
    a.b("com/tencent/mm/plugin/game/media/GamePublishGalleryView$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
    paramView = new Intent();
    paramView.putExtra("key_game_haowan_text", true);
    ((Activity)this.ujd.getContext()).setResult(-1, paramView);
    ((Activity)this.ujd.getContext()).finish();
    a.a(this, "com/tencent/mm/plugin/game/media/GamePublishGalleryView$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(195616);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.game.media.k.4
 * JD-Core Version:    0.7.0.1
 */