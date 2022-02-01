package com.tencent.mm.modelsns;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.c;
import java.util.Map;

public final class l
{
  public static int jlv;
  public static l jlw;
  
  static
  {
    AppMethodBeat.i(125681);
    jlv = 0;
    jlw = new l();
    AppMethodBeat.o(125681);
  }
  
  public static void bfL()
  {
    AppMethodBeat.i(125680);
    c localc = com.tencent.mm.model.c.d.aXu().Fu("100024");
    Log.i("MicroMsg.StatisticsOplogAbTest", "test " + localc.field_rawXML + " " + localc.isValid());
    if (localc.isValid())
    {
      jlv = Util.safeParseInt((String)localc.gzz().get("Switch"));
      Log.i("MicroMsg.StatisticsOplogAbTest", "switchVal " + jlv);
    }
    AppMethodBeat.o(125680);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.modelsns.l
 * JD-Core Version:    0.7.0.1
 */