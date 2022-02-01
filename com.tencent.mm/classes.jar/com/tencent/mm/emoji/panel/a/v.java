package com.tencent.mm.emoji.panel.a;

import android.content.Context;
import android.content.res.Resources;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ai;
import d.g.b.k;
import d.l;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/emoji/panel/adapter/SmileyPanelSizeResolver;", "Lcom/tencent/mm/emoji/panel/adapter/PanelSizeResolver;", "()V", "edgeSize", "", "getEdgeSize", "()F", "itemPadding", "getItemPadding", "itemSize", "getItemSize", "minSpaceSize", "getMinSpaceSize", "plugin-emojisdk_release"})
public final class v
  extends o
{
  public static final v fUD;
  private static final float fUf;
  private static final float fUg;
  private static final float fUh;
  private static final float fUi;
  
  static
  {
    AppMethodBeat.i(105689);
    v localv = new v();
    fUD = localv;
    Object localObject = ai.getContext();
    k.g(localObject, "context");
    localObject = ((Context)localObject).getResources();
    fUf = ((Resources)localObject).getDimension(2131166243);
    fUg = ((Resources)localObject).getDimension(2131165289);
    fUh = ((Resources)localObject).getDimension(2131165289) - 1.0F;
    fUi = ((Resources)localObject).getDimension(2131165274);
    localv.arE = 8;
    localv.adn();
    AppMethodBeat.o(105689);
  }
  
  public final float adk()
  {
    return fUf;
  }
  
  public final float adl()
  {
    return fUg;
  }
  
  public final float adm()
  {
    return fUh;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.emoji.panel.a.v
 * JD-Core Version:    0.7.0.1
 */