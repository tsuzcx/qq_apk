package com.tencent.mm.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.e;
import com.tencent.mm.al.e.a;
import com.tencent.mm.al.e.b;
import com.tencent.mm.al.e.c;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.protocal.protobuf.cv;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.storage.ai;
import java.util.Map;
import junit.framework.Assert;

public final class bw
  implements e
{
  public final e.b b(e.a parama)
  {
    boolean bool2 = true;
    AppMethodBeat.i(20393);
    parama = parama.gqE;
    if (parama != null)
    {
      bool1 = true;
      Assert.assertTrue(bool1);
      if (parama.Fvk == null) {
        break label100;
      }
    }
    label100:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      Assert.assertTrue(bool1);
      parama = (String)com.tencent.mm.sdk.platformtools.bw.M(z.a(parama.Fvk), "tips").get(".tips.tip.url");
      ad.v("MicroMsg.SoftwareMsgExtension", "url:".concat(String.valueOf(parama)));
      ba.aBQ();
      c.ajl().set(12308, parama);
      AppMethodBeat.o(20393);
      return null;
      bool1 = false;
      break;
    }
  }
  
  public final void b(e.c paramc) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.model.bw
 * JD-Core Version:    0.7.0.1
 */