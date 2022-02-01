package com.tencent.mm.plugin.byp;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.a.j;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/byp/BypConstants$BypBizSyncKeyType;", "", "()V", "BYP_GAME_LIFE_KEY", "", "BYP_MSG_AVATAR_KEY", "BYP_MSG_FINDER_KEY", "BYP_MSG_NEW_FINDER_KEY", "SELECTOR_FINDER", "", "getSELECTOR_FINDER", "()Ljava/util/List;", "SELECTOR_GAME", "getSELECTOR_GAME", "SELECTOR_SUPPORTED", "Ljava/util/ArrayList;", "kotlin.jvm.PlatformType", "Lkotlin/collections/ArrayList;", "getSELECTOR_SUPPORTED", "()Ljava/util/ArrayList;", "plugin-byp_release"})
public final class a$a
{
  private static final List<Integer> sVQ;
  private static final List<Integer> sVR;
  private static final ArrayList<Integer> sVS;
  public static final a sVT;
  
  static
  {
    AppMethodBeat.i(213467);
    sVT = new a();
    sVQ = j.listOf(new Integer[] { Integer.valueOf(1), Integer.valueOf(5) });
    sVR = j.listOf(Integer.valueOf(3));
    sVS = new ArrayList((Collection)sVR);
    AppMethodBeat.o(213467);
  }
  
  public static List<Integer> cEX()
  {
    return sVQ;
  }
  
  public static ArrayList<Integer> cEY()
  {
    return sVS;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.byp.a.a
 * JD-Core Version:    0.7.0.1
 */