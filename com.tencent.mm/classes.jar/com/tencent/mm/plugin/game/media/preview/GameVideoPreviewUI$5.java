package com.tencent.mm.plugin.game.media.preview;

import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.b;

final class GameVideoPreviewUI$5
  implements View.OnClickListener
{
  GameVideoPreviewUI$5(GameVideoPreviewUI paramGameVideoPreviewUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(41240);
    Object localObject = new b();
    ((b)localObject).bm(paramView);
    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/game/media/preview/GameVideoPreviewUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject).axR());
    com.tencent.mm.game.report.b.a.a(GameVideoPreviewUI.e(this.xDg), 8768, 0, 2, GameVideoPreviewUI.g(this.xDg), com.tencent.mm.game.report.b.a.c(GameVideoPreviewUI.f(this.xDg), null));
    paramView = LayoutInflater.from(this.xDg.getContext()).inflate(2131494839, null, false);
    localObject = new android.support.design.widget.a(this.xDg.getContext());
    ((android.support.design.widget.a)localObject).setContentView(paramView);
    ((Button)paramView.findViewById(2131302006)).setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(41239);
        b localb = new b();
        localb.bm(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/game/media/preview/GameVideoPreviewUI$3$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
        this.xBJ.cancel();
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/game/media/preview/GameVideoPreviewUI$3$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(41239);
      }
    });
    ((android.support.design.widget.a)localObject).show();
    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/game/media/preview/GameVideoPreviewUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(41240);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.game.media.preview.GameVideoPreviewUI.5
 * JD-Core Version:    0.7.0.1
 */