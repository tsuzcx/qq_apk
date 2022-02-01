package com.tencent.mm.plugin.gallery.picker;

import android.content.Context;
import android.content.res.Resources;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.am;
import d.g.b.k;
import d.l;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
final class GalleryPickerFragment$e
  implements View.OnClickListener
{
  GalleryPickerFragment$e(GalleryPickerFragment paramGalleryPickerFragment, ImageView paramImageView) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(164817);
    if (GalleryPickerFragment.e(this.sLG).getVisibility() == 0)
    {
      GalleryPickerFragment.e(this.sLG).setVisibility(8);
      GalleryPickerFragment.f(this.sLG).setVisibility(0);
      paramView = this.sLM;
      localContext1 = this.sLG.getContext();
      localContext2 = this.sLG.getContext();
      if (localContext2 == null) {
        k.fOy();
      }
      k.g(localContext2, "context!!");
      paramView.setImageDrawable(am.k(localContext1, 2131689710, localContext2.getResources().getColor(2131100021)));
      AppMethodBeat.o(164817);
      return;
    }
    GalleryPickerFragment.e(this.sLG).setVisibility(0);
    GalleryPickerFragment.f(this.sLG).setVisibility(8);
    paramView = this.sLM;
    Context localContext1 = this.sLG.getContext();
    Context localContext2 = this.sLG.getContext();
    if (localContext2 == null) {
      k.fOy();
    }
    k.g(localContext2, "context!!");
    paramView.setImageDrawable(am.k(localContext1, 2131689707, localContext2.getResources().getColor(2131100021)));
    AppMethodBeat.o(164817);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.gallery.picker.GalleryPickerFragment.e
 * JD-Core Version:    0.7.0.1
 */