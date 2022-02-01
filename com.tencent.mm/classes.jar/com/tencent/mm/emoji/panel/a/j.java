package com.tencent.mm.emoji.panel.a;

import android.content.Context;
import android.content.res.Resources;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/emoji/panel/adapter/EmojiPanelItemSizeResolver;", "Lcom/tencent/mm/emoji/panel/adapter/PanelSizeResolver;", "()V", "edgeSize", "", "getEdgeSize", "()F", "itemPadding", "getItemPadding", "itemSize", "getItemSize", "minSpaceSize", "getMinSpaceSize", "plugin-emojisdk_release"})
public final class j
  extends o
{
  private final float haX;
  private final float haY;
  private final float haZ;
  private final float hba;
  
  public j()
  {
    AppMethodBeat.i(199968);
    Object localObject = MMApplicationContext.getContext();
    p.g(localObject, "context");
    localObject = ((Context)localObject).getResources();
    this.haX = ((Resources)localObject).getDimension(2131166284);
    this.haY = ((Resources)localObject).getDimension(2131165296);
    this.haZ = (((Resources)localObject).getDimension(2131165289) - 1.0F);
    this.hba = ((Resources)localObject).getDimension(2131165277);
    this.att = 5;
    updateSize();
    AppMethodBeat.o(199968);
  }
  
  public final float avS()
  {
    return this.haX;
  }
  
  public final float avT()
  {
    return this.haY;
  }
  
  public final float avU()
  {
    return this.haZ;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.emoji.panel.a.j
 * JD-Core Version:    0.7.0.1
 */