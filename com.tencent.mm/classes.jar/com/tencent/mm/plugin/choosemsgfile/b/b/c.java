package com.tencent.mm.plugin.choosemsgfile.b.b;

import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.choosemsgfile.b.c.g;

public class c
  extends a<l>
{
  private final long nLM;
  
  public c(g paramg, long paramLong)
  {
    super(paramg);
    this.nLM = paramLong;
  }
  
  public void a(l paraml, int paramInt, a parama)
  {
    AppMethodBeat.i(162325);
    if ((paramInt == this.nLI.getItemCount() - 1) || (com.tencent.mm.plugin.choosemsgfile.b.d.c.nW(this.nLI.zs(paramInt + 1).getTimeStamp()) != com.tencent.mm.plugin.choosemsgfile.b.d.c.nW(this.nLM)))
    {
      paraml.ibF.setVisibility(8);
      AppMethodBeat.o(162325);
      return;
    }
    paraml.ibF.setVisibility(0);
    paraml.ibF.setText(com.tencent.mm.plugin.choosemsgfile.b.d.c.nV(this.nLM));
    if (this.nLI.bNI())
    {
      paraml.nMe.setVisibility(0);
      AppMethodBeat.o(162325);
      return;
    }
    paraml.nMe.setVisibility(8);
    AppMethodBeat.o(162325);
  }
  
  public final long getTimeStamp()
  {
    return this.nLM;
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