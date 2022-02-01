package com.tencent.mm.plugin.byp;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.a.j;
import d.l;
import java.util.List;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/byp/BypConstants$BypBizSyncKeyType;", "", "()V", "BYP_GAME_LIFE_KEY", "", "BYP_MSG_AVATAR_KEY", "BYP_MSG_FINDER_KEY", "SELECTOR_SUPPORTED", "", "getSELECTOR_SUPPORTED", "()Ljava/util/List;", "plugin-byp_release"})
public final class a$a
{
  private static final List<Integer> oBj;
  public static final a oBk;
  
  static
  {
    AppMethodBeat.i(218308);
    oBk = new a();
    oBj = j.listOf(new Integer[] { Integer.valueOf(1), Integer.valueOf(3) });
    AppMethodBeat.o(218308);
  }
  
  public static List<Integer> bUd()
  {
    return oBj;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.byp.a.a
 * JD-Core Version:    0.7.0.1
 */