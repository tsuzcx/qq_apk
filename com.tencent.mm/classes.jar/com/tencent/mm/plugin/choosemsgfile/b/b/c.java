package com.tencent.mm.plugin.choosemsgfile.b.b;

import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.choosemsgfile.b.c.g;

public class c
  extends a<l>
{
  private final long ooM;
  
  public c(g paramg, long paramLong)
  {
    super(paramg);
    this.ooM = paramLong;
  }
  
  public void a(l paraml, int paramInt, a parama)
  {
    AppMethodBeat.i(162325);
    if ((paramInt == this.ooI.getItemCount() - 1) || (com.tencent.mm.plugin.choosemsgfile.b.d.c.rI(this.ooI.Aj(paramInt + 1).getTimeStamp()) != com.tencent.mm.plugin.choosemsgfile.b.d.c.rI(this.ooM)))
    {
      paraml.iBM.setVisibility(8);
      AppMethodBeat.o(162325);
      return;
    }
    paraml.iBM.setVisibility(0);
    paraml.iBM.setText(com.tencent.mm.plugin.choosemsgfile.b.d.c.rH(this.ooM));
    if (this.ooI.bUT())
    {
      paraml.ope.setVisibility(0);
      AppMethodBeat.o(162325);
      return;
    }
    paraml.ope.setVisibility(8);
    AppMethodBeat.o(162325);
  }
  
  public final long getTimeStamp()
  {
    return this.ooM;
  }
  
  public final int getType()
  {
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.choosemsgfile.b.b.c
 * JD-Core Version:    0.7.0.1
 */