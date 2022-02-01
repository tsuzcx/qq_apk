package com.tencent.mm.plugin.gallery.picker;

import android.support.design.widget.AppBarLayout;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import d.l;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
final class GalleryPickerFragment$h
  implements View.OnClickListener
{
  GalleryPickerFragment$h(GalleryPickerFragment paramGalleryPickerFragment) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(164820);
    b localb = new b();
    localb.bd(paramView);
    a.b("com/tencent/mm/plugin/gallery/picker/GalleryPickerFragment$initPreviewContainer$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
    GalleryPickerFragment.h(this.tTe).bM();
    a.a(this, "com/tencent/mm/plugin/gallery/picker/GalleryPickerFragment$initPreviewContainer$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(164820);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.gallery.picker.GalleryPickerFragment.h
 * JD-Core Version:    0.7.0.1
 */