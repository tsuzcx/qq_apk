package com.tencent.mm.plugin.byp;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.a.j;
import d.l;
import java.util.List;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/byp/BypConstants$BypBizSyncKeyType;", "", "()V", "BYP_GAME_LIFE_KEY", "", "BYP_MSG_AVATAR_KEY", "BYP_MSG_FINDER_KEY", "SELECTOR_SUPPORTED", "", "getSELECTOR_SUPPORTED", "()Ljava/util/List;", "plugin-byp_release"})
public final class a$a
{
  public static final a ouK;
  private static final List<Integer> vJJ;
  
  static
  {
    AppMethodBeat.i(219193);
    ouK = new a();
    vJJ = j.listOf(new Integer[] { Integer.valueOf(1), Integer.valueOf(3) });
    AppMethodBeat.o(219193);
  }
  
  public static List<Integer> bEd()
  {
    return vJJ;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.byp.a.a
 * JD-Core Version:    0.7.0.1
 */