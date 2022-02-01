package com.tencent.mm.emoji.b.b;

import android.util.SparseArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashMap;
import java.util.Map;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/emoji/model/panel/ExternalPanelRegister;", "", "()V", "externalPanelGroupMap", "Ljava/util/HashMap;", "", "Lcom/tencent/mm/emoji/model/panel/ExternalPanelGroupViewProvider;", "Lkotlin/collections/HashMap;", "externalPanelItemList", "Landroid/util/SparseArray;", "Lcom/tencent/mm/emoji/model/panel/ExternalPanelItemViewProvider;", "addPanelGroup", "", "panelGroup", "addPanelItem", "externalPanelViewProvider", "findPanelGroup", "groupId", "findPanelItem", "viewType", "", "removePanelItem", "itemViewType", "plugin-emojisdk_release"})
public final class q
{
  private static final SparseArray<p> gYI;
  private static final HashMap<String, o> gYJ;
  public static final q gYK;
  
  static
  {
    AppMethodBeat.i(199922);
    gYK = new q();
    gYI = new SparseArray();
    gYJ = new HashMap();
    AppMethodBeat.o(199922);
  }
  
  public static o ES(String paramString)
  {
    AppMethodBeat.i(199921);
    kotlin.g.b.p.h(paramString, "groupId");
    paramString = (o)gYJ.get(paramString);
    AppMethodBeat.o(199921);
    return paramString;
  }
  
  public static void a(o paramo)
  {
    AppMethodBeat.i(199920);
    kotlin.g.b.p.h(paramo, "panelGroup");
    ((Map)gYJ).put(paramo.avy(), paramo);
    AppMethodBeat.o(199920);
  }
  
  public static void a(p paramp)
  {
    AppMethodBeat.i(199917);
    kotlin.g.b.p.h(paramp, "externalPanelViewProvider");
    gYI.put(paramp.lU(), paramp);
    AppMethodBeat.o(199917);
  }
  
  public static void pj(int paramInt)
  {
    AppMethodBeat.i(199918);
    gYI.remove(paramInt);
    AppMethodBeat.o(199918);
  }
  
  public static p pk(int paramInt)
  {
    AppMethodBeat.i(199919);
    p localp = (p)gYI.get(paramInt);
    AppMethodBeat.o(199919);
    return localp;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.emoji.b.b.q
 * JD-Core Version:    0.7.0.1
 */