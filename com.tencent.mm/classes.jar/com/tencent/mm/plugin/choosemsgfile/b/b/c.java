package com.tencent.mm.plugin.choosemsgfile.b.b;

import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.choosemsgfile.b.c.g;

public class c
  extends a<l>
{
  private final long oSh;
  
  public c(g paramg, long paramLong)
  {
    super(paramg);
    this.oSh = paramLong;
  }
  
  public void a(l paraml, int paramInt, a parama)
  {
    AppMethodBeat.i(162325);
    if ((paramInt == this.oSd.getItemCount() - 1) || (com.tencent.mm.plugin.choosemsgfile.b.d.c.tH(this.oSd.AS(paramInt + 1).getTimeStamp()) != com.tencent.mm.plugin.choosemsgfile.b.d.c.tH(this.oSh)))
    {
      paraml.iUW.setVisibility(8);
      AppMethodBeat.o(162325);
      return;
    }
    paraml.iUW.setVisibility(0);
    paraml.iUW.setText(com.tencent.mm.plugin.choosemsgfile.b.d.c.tG(this.oSh));
    if (this.oSd.bZy())
    {
      paraml.oSz.setVisibility(0);
      AppMethodBeat.o(162325);
      return;
    }
    paraml.oSz.setVisibility(8);
    AppMethodBeat.o(162325);
  }
  
  public final long getTimeStamp()
  {
    return this.oSh;
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