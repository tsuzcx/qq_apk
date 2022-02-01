package com.tencent.mm.plugin.byp;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.a.p;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/byp/BypConstants$BypBizSyncKeyType;", "", "()V", "BYP_GAME_LIFE_KEY", "", "BYP_MSG_AVATAR_KEY", "BYP_MSG_FINDER_KEY", "BYP_MSG_NEW_FINDER_KEY", "BYP_MSG_TEXT_STATUS_KEY", "SELECTOR_FINDER", "", "getSELECTOR_FINDER", "()Ljava/util/List;", "SELECTOR_GAME", "getSELECTOR_GAME", "SELECTOR_SUPPORTED", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "getSELECTOR_SUPPORTED", "()Ljava/util/ArrayList;", "SELECTOR_TEXT_STATUS", "getSELECTOR_TEXT_STATUS", "plugin-byp_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a$a
{
  public static final a wab;
  private static final List<Integer> wac;
  private static final List<Integer> wad;
  private static final List<Integer> wae;
  private static final ArrayList<Integer> waf;
  
  static
  {
    AppMethodBeat.i(271966);
    wab = new a();
    wac = p.listOf(new Integer[] { Integer.valueOf(1), Integer.valueOf(5) });
    wad = p.listOf(Integer.valueOf(3));
    wae = p.listOf(Integer.valueOf(4));
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(Integer.valueOf(3));
    localArrayList.add(Integer.valueOf(4));
    waf = localArrayList;
    AppMethodBeat.o(271966);
  }
  
  public static List<Integer> dih()
  {
    return wac;
  }
  
  public static ArrayList<Integer> dii()
  {
    return waf;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.byp.a.a
 * JD-Core Version:    0.7.0.1
 */