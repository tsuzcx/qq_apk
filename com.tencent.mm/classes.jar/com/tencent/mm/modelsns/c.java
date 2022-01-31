package com.tencent.mm.modelsns;

import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.d;
import java.util.Map;

public final class c
{
  public static int eAT = 0;
  public static c eAU = new c();
  
  public static void QY()
  {
    com.tencent.mm.storage.c localc = com.tencent.mm.model.c.c.IX().fJ("100024");
    y.i("MicroMsg.StatisticsOplogAbTest", "test " + localc.field_rawXML + " " + localc.isValid());
    if (localc.isValid())
    {
      eAT = bk.ZR((String)localc.ctr().get("Switch"));
      y.i("MicroMsg.StatisticsOplogAbTest", "switchVal " + eAT);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.modelsns.c
 * JD-Core Version:    0.7.0.1
 */