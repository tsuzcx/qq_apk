package com.tencent.mm.emoji.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.emoji.a.n;
import d.g.b.k;
import d.l;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/emoji/model/panel/SmileyItem;", "Lcom/tencent/mm/emoji/model/panel/PanelItem;", "smileyInfo", "Lcom/tencent/mm/emoji/model/SmileyInfo;", "isRecent", "", "reportPos", "", "(Lcom/tencent/mm/emoji/model/SmileyInfo;ZI)V", "()Z", "getReportPos", "()I", "getSmileyInfo", "()Lcom/tencent/mm/emoji/model/SmileyInfo;", "equals", "other", "", "plugin-emojisdk_release"})
public final class ae
  extends y
{
  public final n fOB;
  public final boolean fOC;
  public final int fOD;
  
  public ae(n paramn, boolean paramBoolean, int paramInt)
  {
    super(1);
    AppMethodBeat.i(105582);
    this.fOB = paramn;
    this.fOC = paramBoolean;
    this.fOD = paramInt;
    AppMethodBeat.o(105582);
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(105581);
    if ((super.equals(paramObject)) && ((paramObject instanceof ae)) && (((ae)paramObject).fOC == this.fOC) && (k.g(((ae)paramObject).fOB.key, this.fOB.key)))
    {
      AppMethodBeat.o(105581);
      return true;
    }
    AppMethodBeat.o(105581);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.emoji.a.a.ae
 * JD-Core Version:    0.7.0.1
 */