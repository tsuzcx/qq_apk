package com.tencent.mm.plugin.gallery.ui;

import android.view.View;
import android.view.View.OnLongClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.gallery.b.e;
import com.tencent.mm.plugin.gallery.model.GalleryItem.MediaItem;
import com.tencent.mm.sdk.platformtools.ClipboardHelper;

final class a$1
  implements View.OnLongClickListener
{
  a$1(a parama) {}
  
  public final boolean onLongClick(View paramView)
  {
    AppMethodBeat.i(111387);
    b localb = new b();
    localb.bn(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/gallery/ui/AlbumAdapter$1", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z", this, localb.aFi());
    paramView = paramView.getTag(b.e.item_position);
    if ((paramView instanceof Integer))
    {
      int i = ((Integer)paramView).intValue();
      paramView = this.BZP.SY(i);
      if (paramView != null) {
        ClipboardHelper.setText(a.a(this.BZP), "media info", paramView.toString());
      }
    }
    com.tencent.mm.hellhoundlib.a.a.a(true, this, "com/tencent/mm/plugin/gallery/ui/AlbumAdapter$1", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
    AppMethodBeat.o(111387);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.gallery.ui.a.1
 * JD-Core Version:    0.7.0.1
 */