package com.tencent.mm.plugin.finder.gallery;

import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.b.f;
import com.tencent.mm.plugin.finder.b.g;
import com.tencent.mm.view.recyclerview.e;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/gallery/FinderGalleryTabConvert;", "Lcom/tencent/mm/view/recyclerview/ItemConvert;", "Lcom/tencent/mm/plugin/finder/gallery/FinderGalleryTabFeed;", "forceDark", "", "(Z)V", "TAG", "", "getForceDark", "()Z", "getLayoutId", "", "onBindViewHolder", "", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "item", "position", "type", "isHotPatch", "payloads", "", "", "onCreateViewHolder", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "plugin-finder_release"})
public final class i
  extends e<k>
{
  private final String TAG;
  private final boolean xUe;
  
  public i(boolean paramBoolean)
  {
    this.xUe = paramBoolean;
    this.TAG = "Finder.FinderAlbumFilterConvert";
  }
  
  public final void a(RecyclerView paramRecyclerView, com.tencent.mm.view.recyclerview.i parami, int paramInt)
  {
    AppMethodBeat.i(286537);
    p.k(paramRecyclerView, "recyclerView");
    p.k(parami, "holder");
    paramRecyclerView = (TextView)parami.RD(b.f.topic_tv);
    if (paramRecyclerView != null)
    {
      paramRecyclerView.setTextSize(1, 12.0F);
      AppMethodBeat.o(286537);
      return;
    }
    AppMethodBeat.o(286537);
  }
  
  public final int getLayoutId()
  {
    return b.g.finder_gallery_tab_item;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.gallery.i
 * JD-Core Version:    0.7.0.1
 */