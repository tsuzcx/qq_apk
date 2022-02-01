package com.tencent.mm.plugin.gallery.picker;

import android.content.Context;
import android.content.res.Resources;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.ui.ao;
import d.g.b.p;
import d.l;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
final class GalleryPickerFragment$e
  implements View.OnClickListener
{
  GalleryPickerFragment$e(GalleryPickerFragment paramGalleryPickerFragment, ImageView paramImageView) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(164817);
    Object localObject = new b();
    ((b)localObject).bd(paramView);
    a.b("com/tencent/mm/plugin/gallery/picker/GalleryPickerFragment$initFolderSelectLayout$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject).ahq());
    Context localContext;
    if (GalleryPickerFragment.e(this.tIn).getVisibility() == 0)
    {
      GalleryPickerFragment.e(this.tIn).setVisibility(8);
      GalleryPickerFragment.f(this.tIn).setVisibility(0);
      paramView = this.tIt;
      localObject = this.tIn.getContext();
      localContext = this.tIn.getContext();
      if (localContext == null) {
        p.gfZ();
      }
      p.g(localContext, "context!!");
      paramView.setImageDrawable(ao.k((Context)localObject, 2131689710, localContext.getResources().getColor(2131100021)));
    }
    for (;;)
    {
      a.a(this, "com/tencent/mm/plugin/gallery/picker/GalleryPickerFragment$initFolderSelectLayout$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(164817);
      return;
      GalleryPickerFragment.e(this.tIn).setVisibility(0);
      GalleryPickerFragment.f(this.tIn).setVisibility(8);
      paramView = this.tIt;
      localObject = this.tIn.getContext();
      localContext = this.tIn.getContext();
      if (localContext == null) {
        p.gfZ();
      }
      p.g(localContext, "context!!");
      paramView.setImageDrawable(ao.k((Context)localObject, 2131689707, localContext.getResources().getColor(2131100021)));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.gallery.picker.GalleryPickerFragment.e
 * JD-Core Version:    0.7.0.1
 */