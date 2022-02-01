package com.tencent.mm.plugin.gallery.picker.view;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.CheckBox;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "T", "Lcom/tencent/mm/plugin/gallery/model/GalleryItem$MediaItem;", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
public final class MediaItemView$f
  implements View.OnClickListener
{
  public MediaItemView$f(CheckBox paramCheckBox) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(164952);
    Object localObject = new b();
    ((b)localObject).bn(paramView);
    a.c("com/tencent/mm/plugin/gallery/picker/view/MediaItemView$onCreateView$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject).aFi());
    paramView = this.BZk;
    p.j(paramView, "mediaSelectBox");
    localObject = this.BZk;
    p.j(localObject, "mediaSelectBox");
    if (!((CheckBox)localObject).isChecked()) {}
    for (boolean bool = true;; bool = false)
    {
      paramView.setChecked(bool);
      a.a(this, "com/tencent/mm/plugin/gallery/picker/view/MediaItemView$onCreateView$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(164952);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.gallery.picker.view.MediaItemView.f
 * JD-Core Version:    0.7.0.1
 */