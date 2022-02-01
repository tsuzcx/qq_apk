package com.tencent.mm.plugin.choosemsgfile.b.b;

import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.choosemsgfile.b.c.g;

public class c
  extends a<l>
{
  private final long qnI;
  
  public c(g paramg, long paramLong)
  {
    super(paramg);
    this.qnI = paramLong;
  }
  
  public void a(l paraml, int paramInt, a parama)
  {
    AppMethodBeat.i(162325);
    if ((paramInt == this.qnE.getItemCount() - 1) || (com.tencent.mm.plugin.choosemsgfile.b.d.c.Cd(this.qnE.EM(paramInt + 1).getTimeStamp()) != com.tencent.mm.plugin.choosemsgfile.b.d.c.Cd(this.qnI)))
    {
      paraml.jUO.setVisibility(8);
      AppMethodBeat.o(162325);
      return;
    }
    paraml.jUO.setVisibility(0);
    paraml.jUO.setText(com.tencent.mm.plugin.choosemsgfile.b.d.c.Cc(this.qnI));
    if (this.qnE.cyD())
    {
      paraml.qoa.setVisibility(0);
      AppMethodBeat.o(162325);
      return;
    }
    paraml.qoa.setVisibility(8);
    AppMethodBeat.o(162325);
  }
  
  public final long getTimeStamp()
  {
    return this.qnI;
  }
  
  public final int getType()
  {
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.choosemsgfile.b.b.c
 * JD-Core Version:    0.7.0.1
 */