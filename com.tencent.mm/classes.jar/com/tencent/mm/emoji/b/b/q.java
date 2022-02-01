package com.tencent.mm.emoji.b.b;

import android.util.SparseArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashMap;
import java.util.Map;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/emoji/model/panel/ExternalPanelRegister;", "", "()V", "externalPanelGroupMap", "Ljava/util/HashMap;", "", "Lcom/tencent/mm/emoji/model/panel/ExternalPanelGroupViewProvider;", "Lkotlin/collections/HashMap;", "externalPanelItemList", "Landroid/util/SparseArray;", "Lcom/tencent/mm/emoji/model/panel/ExternalPanelItemViewProvider;", "addPanelGroup", "", "panelGroup", "addPanelItem", "externalPanelViewProvider", "findPanelGroup", "groupId", "findPanelItem", "viewType", "", "removePanelItem", "itemViewType", "plugin-emojisdk_release"})
public final class q
{
  private static final SparseArray<p> jJI;
  private static final HashMap<String, o> jJJ;
  public static final q jJK;
  
  static
  {
    AppMethodBeat.i(233948);
    jJK = new q();
    jJI = new SparseArray();
    jJJ = new HashMap();
    AppMethodBeat.o(233948);
  }
  
  public static o LL(String paramString)
  {
    AppMethodBeat.i(233944);
    kotlin.g.b.p.k(paramString, "groupId");
    paramString = (o)jJJ.get(paramString);
    AppMethodBeat.o(233944);
    return paramString;
  }
  
  public static void a(o paramo)
  {
    AppMethodBeat.i(233943);
    kotlin.g.b.p.k(paramo, "panelGroup");
    ((Map)jJJ).put(paramo.aCt(), paramo);
    AppMethodBeat.o(233943);
  }
  
  public static void a(p paramp)
  {
    AppMethodBeat.i(233936);
    kotlin.g.b.p.k(paramp, "externalPanelViewProvider");
    jJI.put(paramp.mg(), paramp);
    AppMethodBeat.o(233936);
  }
  
  public static void rC(int paramInt)
  {
    AppMethodBeat.i(233937);
    jJI.remove(paramInt);
    AppMethodBeat.o(233937);
  }
  
  public static p rD(int paramInt)
  {
    AppMethodBeat.i(233941);
    p localp = (p)jJI.get(paramInt);
    AppMethodBeat.o(233941);
    return localp;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.emoji.b.b.q
 * JD-Core Version:    0.7.0.1
 */