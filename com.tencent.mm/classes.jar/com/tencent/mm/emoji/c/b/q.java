package com.tencent.mm.emoji.c.b;

import android.util.SparseArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/emoji/model/panel/ExternalPanelRegister;", "", "()V", "externalPanelGroupMap", "Ljava/util/HashMap;", "", "Lcom/tencent/mm/emoji/model/panel/ExternalPanelGroupViewProvider;", "Lkotlin/collections/HashMap;", "externalPanelItemList", "Landroid/util/SparseArray;", "Lcom/tencent/mm/emoji/model/panel/ExternalPanelItemViewProvider;", "addPanelGroup", "", "panelGroup", "addPanelItem", "externalPanelViewProvider", "findPanelGroup", "groupId", "findPanelItem", "viewType", "", "removePanelItem", "itemViewType", "plugin-emojisdk_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class q
{
  public static final q mja;
  private static final SparseArray<p> mjb;
  private static final HashMap<String, o> mjc;
  
  static
  {
    AppMethodBeat.i(242724);
    mja = new q();
    mjb = new SparseArray();
    mjc = new HashMap();
    AppMethodBeat.o(242724);
  }
  
  public static o Eq(String paramString)
  {
    AppMethodBeat.i(242723);
    s.u(paramString, "groupId");
    paramString = (o)mjc.get(paramString);
    AppMethodBeat.o(242723);
    return paramString;
  }
  
  public static void a(o paramo)
  {
    AppMethodBeat.i(242722);
    s.u(paramo, "panelGroup");
    ((Map)mjc).put(paramo.aVp(), paramo);
    AppMethodBeat.o(242722);
  }
  
  public static void a(p paramp)
  {
    AppMethodBeat.i(242719);
    s.u(paramp, "externalPanelViewProvider");
    mjb.put(paramp.aVs(), paramp);
    AppMethodBeat.o(242719);
  }
  
  public static void rE(int paramInt)
  {
    AppMethodBeat.i(242720);
    mjb.remove(paramInt);
    AppMethodBeat.o(242720);
  }
  
  public static p rF(int paramInt)
  {
    AppMethodBeat.i(242721);
    p localp = (p)mjb.get(paramInt);
    AppMethodBeat.o(242721);
    return localp;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.emoji.c.b.q
 * JD-Core Version:    0.7.0.1
 */