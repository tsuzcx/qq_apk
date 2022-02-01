package com.tencent.mm.plugin.emoji.ui.v3.a;

import android.content.Context;
import android.content.res.Resources;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.emoji.h.c;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/emoji/ui/v3/model/SingleProductAlbumHolderSizeResolver;", "Lcom/tencent/mm/plugin/emoji/ui/v3/model/EmojiStoreV3ItemSizeResolver;", "()V", "edgeSize", "", "getEdgeSize", "()F", "itemSize", "getItemSize", "maxSpanCount", "", "minSpaceSize", "getMinSpaceSize", "updateSize", "", "plugin-emoji_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class z
  extends k
{
  private final float mlh;
  private final float mli;
  private final float mlj;
  private final int ycQ;
  
  public z()
  {
    AppMethodBeat.i(270694);
    Resources localResources = MMApplicationContext.getContext().getResources();
    this.mlh = localResources.getDimension(h.c.emoji_store_v3_single_product_item_size);
    this.mli = localResources.getDimension(h.c.Edge_3A);
    this.mlj = localResources.getDimension(h.c.Edge_A);
    this.spanCount = 4;
    this.ycQ = 4;
    updateSize();
    AppMethodBeat.o(270694);
  }
  
  public final float aVN()
  {
    return this.mlh;
  }
  
  public final float aVO()
  {
    return this.mli;
  }
  
  public final float aVP()
  {
    return this.mlj;
  }
  
  public final void updateSize()
  {
    AppMethodBeat.i(270712);
    float f = wR() - this.mli * 2.0F;
    if (f < this.mlh * 2.0F)
    {
      this.spanCount = 1;
      AppMethodBeat.o(270712);
      return;
    }
    this.spanCount = kotlin.k.k.qv((int)((this.mlj + f) / (this.mlh + this.mlj)), this.ycQ);
    this.itemSpace = ((int)((f - this.mlh * this.spanCount) / (this.spanCount - 1)));
    KH((int)((wR() - this.mlh * this.spanCount - this.itemSpace * this.spanCount) / 2.0F));
    AppMethodBeat.o(270712);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.ui.v3.a.z
 * JD-Core Version:    0.7.0.1
 */