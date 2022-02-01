package com.tencent.mm.emoji.panel.a;

import android.content.Context;
import android.content.res.Resources;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ak;
import d.g.b.p;
import d.l;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/emoji/panel/adapter/EmojiPanelSizeResolver;", "Lcom/tencent/mm/emoji/panel/adapter/PanelSizeResolver;", "()V", "edgeSize", "", "getEdgeSize", "()F", "itemPadding", "getItemPadding", "itemSize", "getItemSize", "minSpaceSize", "getMinSpaceSize", "plugin-emojisdk_release"})
public final class j
  extends o
{
  private static final float gqd;
  private static final float gqe;
  private static final float gqf;
  private static final float gqg;
  public static final j gqh;
  
  static
  {
    AppMethodBeat.i(105668);
    j localj = new j();
    gqh = localj;
    Object localObject = ak.getContext();
    p.g(localObject, "context");
    localObject = ((Context)localObject).getResources();
    gqd = ((Resources)localObject).getDimension(2131166241);
    gqe = ((Resources)localObject).getDimension(2131165289);
    gqf = ((Resources)localObject).getDimension(2131165284) - 1.0F;
    gqg = ((Resources)localObject).getDimension(2131165274);
    localj.atv = 5;
    localj.updateSize();
    AppMethodBeat.o(105668);
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
 * Qualified Name:     com.tencent.mm.emoji.panel.a.j
 * JD-Core Version:    0.7.0.1
 */