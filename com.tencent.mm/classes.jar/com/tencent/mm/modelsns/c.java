package com.tencent.mm.modelsns;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.d;
import java.util.Map;

public final class c
{
  public static int fQM;
  public static c fQN;
  
  static
  {
    AppMethodBeat.i(94482);
    fQM = 0;
    fQN = new c();
    AppMethodBeat.o(94482);
  }
  
  public static void akf()
  {
    AppMethodBeat.i(94481);
    com.tencent.mm.storage.c localc = com.tencent.mm.model.c.c.abU().me("100024");
    ab.i("MicroMsg.StatisticsOplogAbTest", "test " + localc.field_rawXML + " " + localc.isValid());
    if (localc.isValid())
    {
      fQM = bo.apV((String)localc.dvN().get("Switch"));
      ab.i("MicroMsg.StatisticsOplogAbTest", "switchVal " + fQM);
    }
    AppMethodBeat.o(94481);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.modelsns.c
 * JD-Core Version:    0.7.0.1
 */