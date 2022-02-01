package com.tencent.mm.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.e;
import com.tencent.mm.ak.e.a;
import com.tencent.mm.ak.e.b;
import com.tencent.mm.ak.e.c;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.protocal.protobuf.cv;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bx;
import com.tencent.mm.storage.aj;
import java.util.Map;
import junit.framework.Assert;

public final class by
  implements e
{
  public final e.b b(e.a parama)
  {
    boolean bool2 = true;
    AppMethodBeat.i(20393);
    parama = parama.gte;
    if (parama != null)
    {
      bool1 = true;
      Assert.assertTrue(bool1);
      if (parama.FNI == null) {
        break label100;
      }
    }
    label100:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      Assert.assertTrue(bool1);
      parama = (String)bx.M(z.a(parama.FNI), "tips").get(".tips.tip.url");
      ae.v("MicroMsg.SoftwareMsgExtension", "url:".concat(String.valueOf(parama)));
      bc.aCg();
      c.ajA().set(12308, parama);
      AppMethodBeat.o(20393);
      return null;
      bool1 = false;
      break;
    }
  }
  
  public final void b(e.c paramc) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.model.by
 * JD-Core Version:    0.7.0.1
 */