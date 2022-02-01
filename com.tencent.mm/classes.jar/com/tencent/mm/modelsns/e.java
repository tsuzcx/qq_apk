package com.tencent.mm.modelsns;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.c;
import java.util.Map;

public final class e
{
  public static int htt;
  public static e htu;
  
  static
  {
    AppMethodBeat.i(125681);
    htt = 0;
    htu = new e();
    AppMethodBeat.o(125681);
  }
  
  public static void aBk()
  {
    AppMethodBeat.i(125680);
    c localc = com.tencent.mm.model.c.d.aty().qu("100024");
    ad.i("MicroMsg.StatisticsOplogAbTest", "test " + localc.field_rawXML + " " + localc.isValid());
    if (localc.isValid())
    {
      htt = bt.aGh((String)localc.eJy().get("Switch"));
      ad.i("MicroMsg.StatisticsOplogAbTest", "switchVal " + htt);
    }
    AppMethodBeat.o(125680);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.modelsns.e
 * JD-Core Version:    0.7.0.1
 */