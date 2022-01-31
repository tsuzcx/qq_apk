package com.tencent.mm.plugin.appbrand.appusage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.z;
import java.util.Arrays;

public final class r$d
{
  public final String[] hca;
  
  public r$d()
  {
    AppMethodBeat.i(129628);
    this.hca = new String[9];
    Arrays.fill(this.hca, "0");
    this.hca[0] = ((String)g.RL().Ru().get(ac.a.yCS, ""));
    this.hca[1] = String.valueOf(g.RL().Ru().get(ac.a.yCT, Long.valueOf(0L)));
    this.hca[2] = String.valueOf(bo.aox());
    AppMethodBeat.o(129628);
  }
  
  public final void axr()
  {
    this.hca[3] = "1";
  }
  
  public final void axs()
  {
    this.hca[5] = "1";
  }
  
  public final void axt()
  {
    this.hca[8] = "1";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appusage.r.d
 * JD-Core Version:    0.7.0.1
 */