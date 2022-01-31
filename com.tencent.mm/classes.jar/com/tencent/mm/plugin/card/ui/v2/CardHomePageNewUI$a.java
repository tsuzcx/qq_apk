package com.tencent.mm.plugin.card.ui.v2;

import a.f.b.j;
import a.l;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.on;
import com.tencent.mm.protocal.protobuf.oq;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/plugin/card/ui/v2/CardHomePageNewUI$CardListModel;", "", "(Lcom/tencent/mm/plugin/card/ui/v2/CardHomePageNewUI;)V", "element", "Lcom/tencent/mm/protocal/protobuf/CardHomePageElement;", "getElement", "()Lcom/tencent/mm/protocal/protobuf/CardHomePageElement;", "setElement", "(Lcom/tencent/mm/protocal/protobuf/CardHomePageElement;)V", "expandState", "", "getExpandState", "()Z", "setExpandState", "(Z)V", "hasRender", "getHasRender", "setHasRender", "sectionTitle", "", "getSectionTitle", "()Ljava/lang/String;", "setSectionTitle", "(Ljava/lang/String;)V", "showDivider", "getShowDivider", "setShowDivider", "topElement", "Lcom/tencent/mm/protocal/protobuf/CardHomePageTopCell;", "getTopElement", "()Lcom/tencent/mm/protocal/protobuf/CardHomePageTopCell;", "setTopElement", "(Lcom/tencent/mm/protocal/protobuf/CardHomePageTopCell;)V", "type", "", "getType", "()I", "setType", "(I)V", "plugin-card_release"})
public final class CardHomePageNewUI$a
{
  on kzm;
  public String kzn;
  boolean kzo;
  boolean kzp;
  oq kzq;
  boolean kzr;
  int type;
  
  public final void Ij(String paramString)
  {
    AppMethodBeat.i(89179);
    j.q(paramString, "<set-?>");
    this.kzn = paramString;
    AppMethodBeat.o(89179);
  }
  
  public final String bfi()
  {
    AppMethodBeat.i(89178);
    String str = this.kzn;
    if (str == null) {
      j.ays("sectionTitle");
    }
    AppMethodBeat.o(89178);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.card.ui.v2.CardHomePageNewUI.a
 * JD-Core Version:    0.7.0.1
 */