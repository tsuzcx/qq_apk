package com.tencent.mm.plugin.brandservice.ui.timeline.offenread;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.aa.a;
import com.tencent.mm.an.q;
import com.tencent.mm.pluginsdk.model.b;
import com.tencent.mm.protocal.protobuf.ddx;
import com.tencent.mm.protocal.protobuf.dea;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.HashMap;
import java.util.LinkedList;

public class h
{
  static int sKd = 0;
  public HashMap<String, dea> sKb;
  public LinkedList<ddx> sKc;
  
  public h()
  {
    AppMethodBeat.i(6137);
    this.sKb = new HashMap();
    this.sKc = new LinkedList();
    AppMethodBeat.o(6137);
  }
  
  static int e(d paramd)
  {
    AppMethodBeat.i(262194);
    if (Util.isNullOrNil(paramd.RVp))
    {
      AppMethodBeat.o(262194);
      return 0;
    }
    if (b.QTJ.ng(paramd.RKL, paramd.RVp))
    {
      AppMethodBeat.o(262194);
      return 1;
    }
    AppMethodBeat.o(262194);
    return 2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.offenread.h
 * JD-Core Version:    0.7.0.1
 */