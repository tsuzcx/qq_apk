package com.tencent.mm.plugin.byp;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.List;
import kotlin.a.j;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/byp/BypConstants$BypBizSyncKeyType;", "", "()V", "BYP_GAME_LIFE_KEY", "", "BYP_MSG_AVATAR_KEY", "BYP_MSG_FINDER_KEY", "SELECTOR_SUPPORTED", "", "getSELECTOR_SUPPORTED", "()Ljava/util/List;", "plugin-byp_release"})
public final class a$a
{
  private static final List<Integer> pOU;
  public static final a pOV;
  
  static
  {
    AppMethodBeat.i(199083);
    pOV = new a();
    pOU = j.listOf(new Integer[] { Integer.valueOf(1), Integer.valueOf(3) });
    AppMethodBeat.o(199083);
  }
  
  public static List<Integer> crQ()
  {
    return pOU;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.byp.a.a
 * JD-Core Version:    0.7.0.1
 */