package com.tencent.mm.plugin.choosemsgfile.b.b;

import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.choosemsgfile.b.c.g;

public class c
  extends a<l>
{
  private final long oYJ;
  
  public c(g paramg, long paramLong)
  {
    super(paramg);
    this.oYJ = paramLong;
  }
  
  public void a(l paraml, int paramInt, a parama)
  {
    AppMethodBeat.i(162325);
    if ((paramInt == this.oYF.getItemCount() - 1) || (com.tencent.mm.plugin.choosemsgfile.b.d.c.tY(this.oYF.Be(paramInt + 1).getTimeStamp()) != com.tencent.mm.plugin.choosemsgfile.b.d.c.tY(this.oYJ)))
    {
      paraml.iXP.setVisibility(8);
      AppMethodBeat.o(162325);
      return;
    }
    paraml.iXP.setVisibility(0);
    paraml.iXP.setText(com.tencent.mm.plugin.choosemsgfile.b.d.c.tX(this.oYJ));
    if (this.oYF.caN())
    {
      paraml.oZb.setVisibility(0);
      AppMethodBeat.o(162325);
      return;
    }
    paraml.oZb.setVisibility(8);
    AppMethodBeat.o(162325);
  }
  
  public final long getTimeStamp()
  {
    return this.oYJ;
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