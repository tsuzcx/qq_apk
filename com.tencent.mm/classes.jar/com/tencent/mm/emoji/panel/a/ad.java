package com.tencent.mm.emoji.panel.a;

import android.content.Context;
import android.content.res.Resources;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.m.a.e;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/emoji/panel/adapter/SmileyPanelItemSizeResolver;", "Lcom/tencent/mm/emoji/panel/adapter/PanelSizeResolver;", "()V", "edgeSize", "", "getEdgeSize", "()F", "itemPadding", "getItemPadding", "itemSize", "getItemSize", "minSpaceSize", "getMinSpaceSize", "plugin-emojisdk_release"})
public final class ad
  extends q
{
  private final float jMc;
  private final float jMd;
  private final float jMe;
  private final float jMf;
  
  public ad()
  {
    AppMethodBeat.i(228267);
    Object localObject = MMApplicationContext.getContext();
    p.j(localObject, "context");
    localObject = ((Context)localObject).getResources();
    this.jMc = ((Resources)localObject).getDimension(a.e.emoji_panel_item_smiley_content_width);
    this.jMd = ((Resources)localObject).getDimension(a.e.Edge_2A);
    this.jMe = (((Resources)localObject).getDimension(a.e.Edge_2A) - 1.0F);
    this.jMf = ((Resources)localObject).getDimension(a.e.Edge_0_5_A);
    this.spanCount = 8;
    updateSize();
    AppMethodBeat.o(228267);
  }
  
  public final float aCP()
  {
    return this.jMc;
  }
  
  public final float aCQ()
  {
    return this.jMd;
  }
  
  public final float aCR()
  {
    return this.jMe;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.emoji.panel.a.ad
 * JD-Core Version:    0.7.0.1
 */