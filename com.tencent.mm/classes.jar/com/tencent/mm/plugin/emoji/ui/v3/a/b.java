package com.tencent.mm.plugin.emoji.ui.v3.a;

import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.emoji.h.c;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/emoji/ui/v3/model/BannerItemSizeResolver;", "Lcom/tencent/mm/plugin/emoji/ui/v3/model/EmojiStoreV3ItemSizeResolver;", "()V", "edgeSize", "", "getEdgeSize", "()F", "itemSize", "getItemSize", "minSpaceSize", "getMinSpaceSize", "updateSize", "", "plugin-emoji_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class b
  extends k
{
  private final float mlh;
  private final float mli;
  private final float mlj;
  
  public b()
  {
    AppMethodBeat.i(270639);
    Resources localResources = MMApplicationContext.getContext().getResources();
    this.mlh = localResources.getDimension(h.c.emoji_store_v3_banner_item_width);
    this.mli = 0.0F;
    this.mlj = localResources.getDimension(h.c.Edge_1_5_A);
    updateSize();
    AppMethodBeat.o(270639);
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
    AppMethodBeat.i(270661);
    this.spanCount = ((int)((MMApplicationContext.getResources().getDisplayMetrics().widthPixels - 2.0F * this.mli) / (this.mlh + this.mlj)));
    AppMethodBeat.o(270661);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.ui.v3.a.b
 * JD-Core Version:    0.7.0.1
 */