package com.tencent.mm.emoji.a.a;

import android.util.SparseArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import d.l;
import java.util.HashMap;
import java.util.Map;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/emoji/model/panel/ExternalPanelRegister;", "", "()V", "externalPanelGroupMap", "Ljava/util/HashMap;", "", "Lcom/tencent/mm/emoji/model/panel/ExternalPanelGroupViewProvider;", "Lkotlin/collections/HashMap;", "externalPanelItemList", "Landroid/util/SparseArray;", "Lcom/tencent/mm/emoji/model/panel/ExternalPanelItemViewProvider;", "addPanelGroup", "", "panelGroup", "addPanelItem", "externalPanelViewProvider", "findPanelGroup", "groupId", "findPanelItem", "viewType", "", "removePanelItem", "itemViewType", "plugin-emojisdk_release"})
public final class q
{
  private static final SparseArray<p> gls;
  private static final HashMap<String, o> glt;
  public static final q glu;
  
  static
  {
    AppMethodBeat.i(218951);
    glu = new q();
    gls = new SparseArray();
    glt = new HashMap();
    AppMethodBeat.o(218951);
  }
  
  public static void a(o paramo)
  {
    AppMethodBeat.i(218949);
    d.g.b.p.h(paramo, "panelGroup");
    ((Map)glt).put(paramo.afw(), paramo);
    AppMethodBeat.o(218949);
  }
  
  public static void a(p paramp)
  {
    AppMethodBeat.i(218947);
    d.g.b.p.h(paramp, "externalPanelViewProvider");
    gls.put(paramp.lQ(), paramp);
    AppMethodBeat.o(218947);
  }
  
  public static void ht(int paramInt)
  {
    AppMethodBeat.i(221216);
    gls.remove(paramInt);
    AppMethodBeat.o(221216);
  }
  
  public static p lZ(int paramInt)
  {
    AppMethodBeat.i(218948);
    p localp = (p)gls.get(paramInt);
    AppMethodBeat.o(218948);
    return localp;
  }
  
  public static o vW(String paramString)
  {
    AppMethodBeat.i(218950);
    d.g.b.p.h(paramString, "groupId");
    paramString = (o)glt.get(paramString);
    AppMethodBeat.o(218950);
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.emoji.a.a.q
 * JD-Core Version:    0.7.0.1
 */