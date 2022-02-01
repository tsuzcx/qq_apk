package com.tencent.mm.emoji.panel.a;

import android.content.Context;
import android.content.res.Resources;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.aj;
import d.g.b.k;
import d.l;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/emoji/panel/adapter/EmojiPanelSizeResolver;", "Lcom/tencent/mm/emoji/panel/adapter/PanelSizeResolver;", "()V", "edgeSize", "", "getEdgeSize", "()F", "itemPadding", "getItemPadding", "itemSize", "getItemSize", "minSpaceSize", "getMinSpaceSize", "plugin-emojisdk_release"})
public final class j
  extends o
{
  private static final float fQk;
  private static final float fQl;
  private static final float fQm;
  private static final float fQn;
  public static final j fQo;
  
  static
  {
    AppMethodBeat.i(105668);
    j localj = new j();
    fQo = localj;
    Object localObject = aj.getContext();
    k.g(localObject, "context");
    localObject = ((Context)localObject).getResources();
    fQk = ((Resources)localObject).getDimension(2131166241);
    fQl = ((Resources)localObject).getDimension(2131165289);
    fQm = ((Resources)localObject).getDimension(2131165284) - 1.0F;
    fQn = ((Resources)localObject).getDimension(2131165274);
    localj.aqI = 5;
    localj.ach();
    AppMethodBeat.o(105668);
  }
  
  public final float ace()
  {
    return fQk;
  }
  
  public final float acf()
  {
    return fQl;
  }
  
  public final float acg()
  {
    return fQm;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.emoji.panel.a.j
 * JD-Core Version:    0.7.0.1
 */