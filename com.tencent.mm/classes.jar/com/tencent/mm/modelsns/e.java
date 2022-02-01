package com.tencent.mm.modelsns;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.c;
import java.util.Map;

public final class e
{
  public static int hTV;
  public static e hTW;
  
  static
  {
    AppMethodBeat.i(125681);
    hTV = 0;
    hTW = new e();
    AppMethodBeat.o(125681);
  }
  
  public static void aIa()
  {
    AppMethodBeat.i(125680);
    c localc = com.tencent.mm.model.c.d.aAp().tJ("100024");
    ac.i("MicroMsg.StatisticsOplogAbTest", "test " + localc.field_rawXML + " " + localc.isValid());
    if (localc.isValid())
    {
      hTV = bs.aLy((String)localc.eYV().get("Switch"));
      ac.i("MicroMsg.StatisticsOplogAbTest", "switchVal " + hTV);
    }
    AppMethodBeat.o(125680);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.modelsns.e
 * JD-Core Version:    0.7.0.1
 */