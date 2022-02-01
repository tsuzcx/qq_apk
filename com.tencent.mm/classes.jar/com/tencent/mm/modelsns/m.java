package com.tencent.mm.modelsns;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.c;
import java.util.Map;

public final class m
{
  public static int mbx;
  public static m mby;
  
  static
  {
    AppMethodBeat.i(125681);
    mbx = 0;
    mby = new m();
    AppMethodBeat.o(125681);
  }
  
  public static void bpb()
  {
    AppMethodBeat.i(125680);
    c localc = com.tencent.mm.model.c.d.bgB().Mu("100024");
    Log.i("MicroMsg.StatisticsOplogAbTest", "test " + localc.field_rawXML + " " + localc.isValid());
    if (localc.isValid())
    {
      mbx = Util.safeParseInt((String)localc.hvz().get("Switch"));
      Log.i("MicroMsg.StatisticsOplogAbTest", "switchVal " + mbx);
    }
    AppMethodBeat.o(125680);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.modelsns.m
 * JD-Core Version:    0.7.0.1
 */