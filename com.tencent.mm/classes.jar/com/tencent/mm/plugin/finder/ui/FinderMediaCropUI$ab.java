package com.tencent.mm.plugin.finder.ui;

import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.v;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.CheckBox;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.gallery.model.GalleryItem.MediaItem;
import d.g.b.k;
import d.l;
import java.util.ArrayList;
import java.util.List;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
final class FinderMediaCropUI$ab
  implements View.OnClickListener
{
  FinderMediaCropUI$ab(FinderMediaCropUI paramFinderMediaCropUI, FinderMediaCropUI.b paramb) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(199254);
    paramView = this.qMY;
    Object localObject1 = this.qMY.fVx();
    k.g(localObject1, "switchVLogCheckbox");
    FinderMediaCropUI.a(paramView, ((CheckBox)localObject1).isChecked());
    if (FinderMediaCropUI.k(this.qMY))
    {
      this.KYG.setItems((List)this.qMY.crc());
      localObject1 = this.qMY;
      paramView = this.qMY.crf().ci(0);
      if (paramView == null) {
        break label132;
      }
    }
    label132:
    for (paramView = paramView.arI;; paramView = null)
    {
      if (paramView == null) {
        k.fvU();
      }
      k.g(paramView, "previewRecyclerView.find…utPosition(0)?.itemView!!");
      Object localObject2 = this.qMY.crc().get(0);
      k.g(localObject2, "selectPathList[0]");
      ((FinderMediaCropUI)localObject1).a(0, paramView, (GalleryItem.MediaItem)localObject2);
      AppMethodBeat.o(199254);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.ui.FinderMediaCropUI.ab
 * JD-Core Version:    0.7.0.1
 */