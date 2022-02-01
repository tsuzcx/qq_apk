package com.tencent.mm.emoji.panel.a;

import android.content.Context;
import android.content.res.Resources;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.aj;
import d.g.b.p;
import d.l;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/emoji/panel/adapter/SmileyPanelSizeResolver;", "Lcom/tencent/mm/emoji/panel/adapter/PanelSizeResolver;", "()V", "edgeSize", "", "getEdgeSize", "()F", "itemPadding", "getItemPadding", "itemSize", "getItemSize", "minSpaceSize", "getMinSpaceSize", "plugin-emojisdk_release"})
public final class v
  extends o
{
  private static final float gnH;
  private static final float gnI;
  private static final float gnJ;
  private static final float gnK;
  public static final v gof;
  
  static
  {
    AppMethodBeat.i(105689);
    v localv = new v();
    gof = localv;
    Object localObject = aj.getContext();
    p.g(localObject, "context");
    localObject = ((Context)localObject).getResources();
    gnH = ((Resources)localObject).getDimension(2131166243);
    gnI = ((Resources)localObject).getDimension(2131165289);
    gnJ = ((Resources)localObject).getDimension(2131165289) - 1.0F;
    gnK = ((Resources)localObject).getDimension(2131165274);
    localv.atv = 8;
    localv.updateSize();
    AppMethodBeat.o(105689);
  }
  
  public final float afQ()
  {
    return gnH;
  }
  
  public final float afR()
  {
    return gnI;
  }
  
  public final float afS()
  {
    return gnJ;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.emoji.panel.a.v
 * JD-Core Version:    0.7.0.1
 */