package com.tencent.mm.plugin.gallery.picker;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import d.l;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
final class GalleryPickerFragment$f
  implements View.OnClickListener
{
  GalleryPickerFragment$f(GalleryPickerFragment paramGalleryPickerFragment) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(164818);
    b localb = new b();
    localb.bd(paramView);
    a.b("com/tencent/mm/plugin/gallery/picker/GalleryPickerFragment$initGalleryView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
    paramView = this.tIn;
    if (!GalleryPickerFragment.d(this.tIn)) {}
    for (boolean bool = true;; bool = false)
    {
      GalleryPickerFragment.a(paramView, bool);
      a.a(this, "com/tencent/mm/plugin/gallery/picker/GalleryPickerFragment$initGalleryView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(164818);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.gallery.picker.GalleryPickerFragment.f
 * JD-Core Version:    0.7.0.1
 */