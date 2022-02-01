package com.tencent.mm.modelsns;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.c;
import java.util.Map;

public final class f
{
  public static int iqk;
  public static f iql;
  
  static
  {
    AppMethodBeat.i(125681);
    iqk = 0;
    iql = new f();
    AppMethodBeat.o(125681);
  }
  
  public static void aLI()
  {
    AppMethodBeat.i(125680);
    c localc = com.tencent.mm.model.c.d.aDI().xi("100024");
    ae.i("MicroMsg.StatisticsOplogAbTest", "test " + localc.field_rawXML + " " + localc.isValid());
    if (localc.isValid())
    {
      iqk = bu.aSB((String)localc.fsy().get("Switch"));
      ae.i("MicroMsg.StatisticsOplogAbTest", "switchVal " + iqk);
    }
    AppMethodBeat.o(125680);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.modelsns.f
 * JD-Core Version:    0.7.0.1
 */