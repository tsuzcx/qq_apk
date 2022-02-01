package com.tencent.mm.emoji.a.b;

import android.util.SparseArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import d.l;
import java.util.HashMap;
import java.util.Map;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/emoji/model/panel/ExternalPanelRegister;", "", "()V", "externalPanelGroupMap", "Ljava/util/HashMap;", "", "Lcom/tencent/mm/emoji/model/panel/ExternalPanelGroupViewProvider;", "Lkotlin/collections/HashMap;", "externalPanelItemList", "Landroid/util/SparseArray;", "Lcom/tencent/mm/emoji/model/panel/ExternalPanelItemViewProvider;", "addPanelGroup", "", "panelGroup", "addPanelItem", "externalPanelViewProvider", "findPanelGroup", "groupId", "findPanelItem", "viewType", "", "removePanelItem", "itemViewType", "plugin-emojisdk_release"})
public final class q
{
  private static final SparseArray<p> gnN;
  private static final HashMap<String, o> gnO;
  public static final q gnP;
  
  static
  {
    AppMethodBeat.i(188565);
    gnP = new q();
    gnN = new SparseArray();
    gnO = new HashMap();
    AppMethodBeat.o(188565);
  }
  
  public static void a(o paramo)
  {
    AppMethodBeat.i(188563);
    d.g.b.p.h(paramo, "panelGroup");
    ((Map)gnO).put(paramo.afK(), paramo);
    AppMethodBeat.o(188563);
  }
  
  public static void a(p paramp)
  {
    AppMethodBeat.i(188560);
    d.g.b.p.h(paramp, "externalPanelViewProvider");
    gnN.put(paramp.lQ(), paramp);
    AppMethodBeat.o(188560);
  }
  
  public static void mb(int paramInt)
  {
    AppMethodBeat.i(188561);
    gnN.remove(paramInt);
    AppMethodBeat.o(188561);
  }
  
  public static p mc(int paramInt)
  {
    AppMethodBeat.i(188562);
    p localp = (p)gnN.get(paramInt);
    AppMethodBeat.o(188562);
    return localp;
  }
  
  public static o wD(String paramString)
  {
    AppMethodBeat.i(188564);
    d.g.b.p.h(paramString, "groupId");
    paramString = (o)gnO.get(paramString);
    AppMethodBeat.o(188564);
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.emoji.a.b.q
 * JD-Core Version:    0.7.0.1
 */