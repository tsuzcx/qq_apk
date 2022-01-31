package com.tencent.mm.plugin.choosemsgfile.b.b;

import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.choosemsgfile.b.c.g;
import com.tencent.mm.plugin.choosemsgfile.b.d.b;

public class c
  extends a<l>
{
  private final long mTimeStamp;
  
  public c(g paramg, long paramLong)
  {
    super(paramg);
    this.mTimeStamp = paramLong;
  }
  
  public void a(l paraml, int paramInt)
  {
    AppMethodBeat.i(54292);
    if ((paramInt == this.kEI.getItemCount() - 1) || (b.io(this.kEI.ty(paramInt + 1).getTimeStamp()) != b.io(this.mTimeStamp)))
    {
      paraml.gpp.setVisibility(8);
      AppMethodBeat.o(54292);
      return;
    }
    paraml.gpp.setVisibility(0);
    paraml.gpp.setText(b.in(this.mTimeStamp));
    if (this.kEI.bgx())
    {
      paraml.kFd.setVisibility(0);
      AppMethodBeat.o(54292);
      return;
    }
    paraml.kFd.setVisibility(8);
    AppMethodBeat.o(54292);
  }
  
  public final long getTimeStamp()
  {
    return this.mTimeStamp;
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