package com.tencent.mm.plugin.emojicapture.ui.preview;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.b;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
final class StickerPreviewView$3
  implements View.OnClickListener
{
  StickerPreviewView$3(StickerPreviewView paramStickerPreviewView) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(910);
    b localb = new b();
    localb.bm(paramView);
    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/emojicapture/ui/preview/StickerPreviewView$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
    com.tencent.mm.media.widget.camerarecordview.a.b(StickerPreviewView.f(this.rxi));
    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/emojicapture/ui/preview/StickerPreviewView$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(910);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.emojicapture.ui.preview.StickerPreviewView.3
 * JD-Core Version:    0.7.0.1
 */