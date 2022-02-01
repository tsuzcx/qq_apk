package com.tencent.mm.plugin.emojicapture.ui.preview;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import d.l;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
final class StickerPreviewView$2
  implements View.OnClickListener
{
  StickerPreviewView$2(StickerPreviewView paramStickerPreviewView, Context paramContext) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(909);
    Object localObject = new com.tencent.mm.hellhoundlib.b.b();
    ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramView);
    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/emojicapture/ui/preview/StickerPreviewView$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahF());
    paramView = new android.support.design.widget.a(this.crf);
    localObject = new StickerPreviewChangeMode(this.crf);
    ((StickerPreviewChangeMode)localObject).setBackgroundResource(2131232016);
    ((StickerPreviewChangeMode)localObject).setOnModeSelected((d.g.a.b)new StickerPreviewView.2.1(this, paramView));
    paramView.setContentView((View)localObject);
    paramView.show();
    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/emojicapture/ui/preview/StickerPreviewView$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(909);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.emojicapture.ui.preview.StickerPreviewView.2
 * JD-Core Version:    0.7.0.1
 */