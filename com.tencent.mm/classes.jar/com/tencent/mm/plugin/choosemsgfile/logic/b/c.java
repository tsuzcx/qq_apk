package com.tencent.mm.plugin.choosemsgfile.logic.b;

import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.choosemsgfile.logic.ui.g;

public class c
  extends a<l>
{
  private final long wPL;
  
  public c(g paramg, long paramLong)
  {
    super(paramg);
    this.wPL = paramLong;
  }
  
  public void a(l paraml, int paramInt, a parama)
  {
    AppMethodBeat.i(162325);
    if ((paramInt == dqr().getItemCount() - 1) || (com.tencent.mm.plugin.choosemsgfile.logic.c.c.kE(dqr().IW(paramInt + 1).getTimeStamp()) != com.tencent.mm.plugin.choosemsgfile.logic.c.c.kE(this.wPL)))
    {
      paraml.pIJ.setVisibility(8);
      AppMethodBeat.o(162325);
      return;
    }
    paraml.pIJ.setVisibility(0);
    paraml.pIJ.setText(com.tencent.mm.plugin.choosemsgfile.logic.c.c.kD(this.wPL));
    if (dqr().dqE())
    {
      paraml.wPY.setVisibility(0);
      AppMethodBeat.o(162325);
      return;
    }
    paraml.wPY.setVisibility(8);
    AppMethodBeat.o(162325);
  }
  
  public final long getTimeStamp()
  {
    return this.wPL;
  }
  
  public final int getType()
  {
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.choosemsgfile.logic.b.c
 * JD-Core Version:    0.7.0.1
 */