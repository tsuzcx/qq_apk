package com.tencent.mm.emoji.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.emoji.a.o;
import d.g.b.k;
import d.l;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/emoji/model/panel/SmileyItem;", "Lcom/tencent/mm/emoji/model/panel/PanelItem;", "smileyInfo", "Lcom/tencent/mm/emoji/model/SmileyInfo;", "isRecent", "", "reportPos", "", "(Lcom/tencent/mm/emoji/model/SmileyInfo;ZI)V", "()Z", "getReportPos", "()I", "getSmileyInfo", "()Lcom/tencent/mm/emoji/model/SmileyInfo;", "equals", "other", "", "plugin-emojisdk_release"})
public final class ae
  extends y
{
  public final o fSm;
  public final boolean fSn;
  public final int fSo;
  
  public ae(o paramo, boolean paramBoolean, int paramInt)
  {
    super(1);
    AppMethodBeat.i(105582);
    this.fSm = paramo;
    this.fSn = paramBoolean;
    this.fSo = paramInt;
    AppMethodBeat.o(105582);
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(105581);
    if ((super.equals(paramObject)) && ((paramObject instanceof ae)) && (((ae)paramObject).fSn == this.fSn) && (k.g(((ae)paramObject).fSm.key, this.fSm.key)))
    {
      AppMethodBeat.o(105581);
      return true;
    }
    AppMethodBeat.o(105581);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.emoji.a.a.ae
 * JD-Core Version:    0.7.0.1
 */