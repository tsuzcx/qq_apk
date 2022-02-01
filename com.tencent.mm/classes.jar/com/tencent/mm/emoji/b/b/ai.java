package com.tencent.mm.emoji.b.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/emoji/model/panel/SmileyItem;", "Lcom/tencent/mm/emoji/model/panel/PanelItem;", "smileyInfo", "Lcom/tencent/mm/emoji/model/SmileyInfo;", "isRecent", "", "reportPos", "", "(Lcom/tencent/mm/emoji/model/SmileyInfo;ZI)V", "()Z", "getReportPos", "()I", "getSmileyInfo", "()Lcom/tencent/mm/emoji/model/SmileyInfo;", "equals", "other", "", "plugin-emojisdk_release"})
public final class ai
  extends ac
{
  public final com.tencent.mm.emoji.b.p gZf;
  public final boolean gZg;
  public final int gZh;
  
  public ai(com.tencent.mm.emoji.b.p paramp, boolean paramBoolean, int paramInt)
  {
    super(1);
    AppMethodBeat.i(105582);
    this.gZf = paramp;
    this.gZg = paramBoolean;
    this.gZh = paramInt;
    AppMethodBeat.o(105582);
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(105581);
    if ((super.equals(paramObject)) && ((paramObject instanceof ai)) && (((ai)paramObject).gZg == this.gZg) && (kotlin.g.b.p.j(((ai)paramObject).gZf.key, this.gZf.key)))
    {
      AppMethodBeat.o(105581);
      return true;
    }
    AppMethodBeat.o(105581);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.emoji.b.b.ai
 * JD-Core Version:    0.7.0.1
 */