package com.tencent.mm.emoji.panel.a;

import android.content.Context;
import android.content.res.Resources;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.m.a.e;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/emoji/panel/adapter/EmojiPanelItemSizeResolver;", "Lcom/tencent/mm/emoji/panel/adapter/PanelSizeResolver;", "()V", "edgeSize", "", "getEdgeSize", "()F", "itemPadding", "getItemPadding", "itemSize", "getItemSize", "minSpaceSize", "getMinSpaceSize", "plugin-emojisdk_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class i
  extends o
{
  private final float mlh;
  private final float mli;
  private final float mlj;
  private final float mlk;
  
  public i()
  {
    AppMethodBeat.i(242416);
    Resources localResources = MMApplicationContext.getContext().getResources();
    this.mlh = localResources.getDimension(a.e.emoji_panel_item_emoji_content_width);
    this.mli = localResources.getDimension(a.e.Edge_2A);
    this.mlj = (localResources.getDimension(a.e.Edge_1_5_A) - 1.0F);
    this.mlk = localResources.getDimension(a.e.Edge_0_5_A);
    this.spanCount = 5;
    updateSize();
    AppMethodBeat.o(242416);
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
 * Qualified Name:     com.tencent.mm.emoji.panel.a.i
 * JD-Core Version:    0.7.0.1
 */