package com.tencent.mm.plugin.choosemsgfile.b.b;

import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.choosemsgfile.b.c.g;

public class c
  extends a<l>
{
  private final long tMv;
  
  public c(g paramg, long paramLong)
  {
    super(paramg);
    this.tMv = paramLong;
  }
  
  public void a(l paraml, int paramInt, a parama)
  {
    AppMethodBeat.i(162325);
    if ((paramInt == cMM().getItemCount() - 1) || (com.tencent.mm.plugin.choosemsgfile.b.d.c.Im(cMM().It(paramInt + 1).getTimeStamp()) != com.tencent.mm.plugin.choosemsgfile.b.d.c.Im(this.tMv)))
    {
      paraml.mMb.setVisibility(8);
      AppMethodBeat.o(162325);
      return;
    }
    paraml.mMb.setVisibility(0);
    paraml.mMb.setText(com.tencent.mm.plugin.choosemsgfile.b.d.c.Il(this.tMv));
    if (cMM().cMY())
    {
      paraml.tMI.setVisibility(0);
      AppMethodBeat.o(162325);
      return;
    }
    paraml.tMI.setVisibility(8);
    AppMethodBeat.o(162325);
  }
  
  public final long getTimeStamp()
  {
    return this.tMv;
  }
  
  public final int getType()
  {
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.choosemsgfile.b.b.c
 * JD-Core Version:    0.7.0.1
 */