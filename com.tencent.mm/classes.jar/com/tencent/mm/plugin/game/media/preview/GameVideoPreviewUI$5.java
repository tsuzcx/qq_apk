package com.tencent.mm.plugin.game.media.preview;

import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.game.h.e;
import com.tencent.mm.plugin.game.h.f;

final class GameVideoPreviewUI$5
  implements View.OnClickListener
{
  GameVideoPreviewUI$5(GameVideoPreviewUI paramGameVideoPreviewUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(41240);
    Object localObject = new b();
    ((b)localObject).cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/game/media/preview/GameVideoPreviewUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject).aYj());
    com.tencent.mm.game.report.b.a.a(GameVideoPreviewUI.e(this.IBq), 8768, 0, 2, GameVideoPreviewUI.g(this.IBq), com.tencent.mm.game.report.b.a.a(GameVideoPreviewUI.f(this.IBq), null));
    paramView = LayoutInflater.from(this.IBq.getContext()).inflate(h.f.HYT, null, false);
    localObject = new com.google.android.material.bottomsheet.a(this.IBq.getContext());
    ((com.google.android.material.bottomsheet.a)localObject).setContentView(paramView);
    ((Button)paramView.findViewById(h.e.HVP)).setOnClickListener(new GameVideoPreviewUI.5.1(this, (com.google.android.material.bottomsheet.a)localObject));
    ((com.google.android.material.bottomsheet.a)localObject).show();
    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/game/media/preview/GameVideoPreviewUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(41240);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.game.media.preview.GameVideoPreviewUI.5
 * JD-Core Version:    0.7.0.1
 */