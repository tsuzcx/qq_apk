package com.tencent.mm.modelsns;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.c;
import java.util.Map;

public final class m
{
  public static int oUs;
  public static m oUt;
  
  static
  {
    AppMethodBeat.i(125681);
    oUs = 0;
    oUt = new m();
    AppMethodBeat.o(125681);
  }
  
  public static void bMI()
  {
    AppMethodBeat.i(125680);
    c localc = com.tencent.mm.model.newabtest.d.bEt().Fd("100024");
    if (localc == null)
    {
      Log.i("MicroMsg.StatisticsOplogAbTest", "abtest is null");
      AppMethodBeat.o(125680);
      return;
    }
    Log.i("MicroMsg.StatisticsOplogAbTest", "test " + localc.field_rawXML + " " + localc.isValid());
    if (localc.isValid())
    {
      oUs = Util.safeParseInt((String)localc.iWZ().get("Switch"));
      Log.i("MicroMsg.StatisticsOplogAbTest", "switchVal " + oUs);
    }
    AppMethodBeat.o(125680);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.modelsns.m
 * JD-Core Version:    0.7.0.1
 */