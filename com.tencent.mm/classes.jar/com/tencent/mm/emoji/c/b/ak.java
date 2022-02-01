package com.tencent.mm.emoji.c.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.emoji.c.q;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/emoji/model/panel/SmileyItem;", "Lcom/tencent/mm/emoji/model/panel/PanelItem;", "smileyInfo", "Lcom/tencent/mm/emoji/model/SmileyInfo;", "isRecent", "", "reportPos", "", "(Lcom/tencent/mm/emoji/model/SmileyInfo;ZI)V", "()Z", "getReportPos", "()I", "getSmileyInfo", "()Lcom/tencent/mm/emoji/model/SmileyInfo;", "equals", "other", "", "plugin-emojisdk_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class ak
  extends ae
{
  public final q mjw;
  public final boolean mjx;
  public final int mjy;
  
  public ak(q paramq, boolean paramBoolean, int paramInt)
  {
    super(1);
    AppMethodBeat.i(105582);
    this.mjw = paramq;
    this.mjx = paramBoolean;
    this.mjy = paramInt;
    AppMethodBeat.o(105582);
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(105581);
    if ((super.equals(paramObject)) && ((paramObject instanceof ak)) && (((ak)paramObject).mjx == this.mjx) && (s.p(((ak)paramObject).mjw.key, this.mjw.key)))
    {
      AppMethodBeat.o(105581);
      return true;
    }
    AppMethodBeat.o(105581);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.emoji.c.b.ak
 * JD-Core Version:    0.7.0.1
 */