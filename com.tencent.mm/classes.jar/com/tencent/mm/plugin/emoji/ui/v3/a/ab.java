package com.tencent.mm.plugin.emoji.ui.v3.a;

import android.content.Context;
import android.content.res.Resources;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.emoji.h.c;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/emoji/ui/v3/model/SingleProductItemSizeResolver;", "Lcom/tencent/mm/plugin/emoji/ui/v3/model/EmojiStoreV3ItemSizeResolver;", "()V", "edgeSize", "", "getEdgeSize", "()F", "itemSize", "getItemSize", "minSpaceSize", "getMinSpaceSize", "plugin-emoji_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class ab
  extends k
{
  private final float mlh;
  private final float mli;
  private final float mlj;
  
  public ab()
  {
    AppMethodBeat.i(270600);
    Resources localResources = MMApplicationContext.getContext().getResources();
    this.mlh = localResources.getDimension(h.c.emoji_store_v3_single_product_item_size);
    this.mli = localResources.getDimension(h.c.Edge_2A);
    this.mlj = localResources.getDimension(h.c.Edge_A);
    this.mls = ((int)localResources.getDimension(h.c.emoji_store_v3_single_product_header_padding));
    this.spanCount = 4;
    updateSize();
    AppMethodBeat.o(270600);
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.ui.v3.a.ab
 * JD-Core Version:    0.7.0.1
 */