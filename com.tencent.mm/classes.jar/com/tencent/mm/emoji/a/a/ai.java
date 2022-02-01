package com.tencent.mm.emoji.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.emoji.a.o;
import d.g.b.p;
import d.l;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/emoji/model/panel/SmileyItem;", "Lcom/tencent/mm/emoji/model/panel/PanelItem;", "smileyInfo", "Lcom/tencent/mm/emoji/model/SmileyInfo;", "isRecent", "", "reportPos", "", "(Lcom/tencent/mm/emoji/model/SmileyInfo;ZI)V", "()Z", "getReportPos", "()I", "getSmileyInfo", "()Lcom/tencent/mm/emoji/model/SmileyInfo;", "equals", "other", "", "plugin-emojisdk_release"})
public final class ai
  extends ac
{
  public final o glQ;
  public final boolean glR;
  public final int glS;
  
  public ai(o paramo, boolean paramBoolean, int paramInt)
  {
    super(1);
    AppMethodBeat.i(105582);
    this.glQ = paramo;
    this.glR = paramBoolean;
    this.glS = paramInt;
    AppMethodBeat.o(105582);
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(105581);
    if ((super.equals(paramObject)) && ((paramObject instanceof ai)) && (((ai)paramObject).glR == this.glR) && (p.i(((ai)paramObject).glQ.key, this.glQ.key)))
    {
      AppMethodBeat.o(105581);
      return true;
    }
    AppMethodBeat.o(105581);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.emoji.a.a.ai
 * JD-Core Version:    0.7.0.1
 */