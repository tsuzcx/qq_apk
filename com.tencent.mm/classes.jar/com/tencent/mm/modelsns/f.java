package com.tencent.mm.modelsns;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.c;
import java.util.Map;

public final class f
{
  public static int inq;
  public static f inr;
  
  static
  {
    AppMethodBeat.i(125681);
    inq = 0;
    inr = new f();
    AppMethodBeat.o(125681);
  }
  
  public static void aLl()
  {
    AppMethodBeat.i(125680);
    c localc = com.tencent.mm.model.c.d.aDs().wz("100024");
    ad.i("MicroMsg.StatisticsOplogAbTest", "test " + localc.field_rawXML + " " + localc.isValid());
    if (localc.isValid())
    {
      inq = bt.aRe((String)localc.foF().get("Switch"));
      ad.i("MicroMsg.StatisticsOplogAbTest", "switchVal " + inq);
    }
    AppMethodBeat.o(125680);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.modelsns.f
 * JD-Core Version:    0.7.0.1
 */