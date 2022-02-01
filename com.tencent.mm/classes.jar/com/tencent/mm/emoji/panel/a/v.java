package com.tencent.mm.emoji.panel.a;

import android.content.Context;
import android.content.res.Resources;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ak;
import d.g.b.p;
import d.l;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/emoji/panel/adapter/SmileyPanelSizeResolver;", "Lcom/tencent/mm/emoji/panel/adapter/PanelSizeResolver;", "()V", "edgeSize", "", "getEdgeSize", "()F", "itemPadding", "getItemPadding", "itemSize", "getItemSize", "minSpaceSize", "getMinSpaceSize", "plugin-emojisdk_release"})
public final class v
  extends o
{
  public static final v gqB;
  private static final float gqd;
  private static final float gqe;
  private static final float gqf;
  private static final float gqg;
  
  static
  {
    AppMethodBeat.i(105689);
    v localv = new v();
    gqB = localv;
    Object localObject = ak.getContext();
    p.g(localObject, "context");
    localObject = ((Context)localObject).getResources();
    gqd = ((Resources)localObject).getDimension(2131166243);
    gqe = ((Resources)localObject).getDimension(2131165289);
    gqf = ((Resources)localObject).getDimension(2131165289) - 1.0F;
    gqg = ((Resources)localObject).getDimension(2131165274);
    localv.atv = 8;
    localv.updateSize();
    AppMethodBeat.o(105689);
  }
  
  public final float age()
  {
    return gqd;
  }
  
  public final float agf()
  {
    return gqe;
  }
  
  public final float agg()
  {
    return gqf;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.emoji.panel.a.v
 * JD-Core Version:    0.7.0.1
 */