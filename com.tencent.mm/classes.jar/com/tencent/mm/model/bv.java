package com.tencent.mm.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.f;
import com.tencent.mm.al.f.a;
import com.tencent.mm.al.f.b;
import com.tencent.mm.al.f.c;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.protocal.protobuf.cs;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bw;
import com.tencent.mm.storage.ab;
import java.util.Map;
import junit.framework.Assert;

public final class bv
  implements f
{
  public final f.b b(f.a parama)
  {
    boolean bool2 = true;
    AppMethodBeat.i(20393);
    parama = parama.fTo;
    if (parama != null)
    {
      bool1 = true;
      Assert.assertTrue(bool1);
      if (parama.Cxz == null) {
        break label100;
      }
    }
    label100:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      Assert.assertTrue(bool1);
      parama = (String)bw.K(z.a(parama.Cxz), "tips").get(".tips.tip.url");
      ad.v("MicroMsg.SoftwareMsgExtension", "url:".concat(String.valueOf(parama)));
      az.arV();
      c.afk().set(12308, parama);
      AppMethodBeat.o(20393);
      return null;
      bool1 = false;
      break;
    }
  }
  
  public final void b(f.c paramc) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.model.bv
 * JD-Core Version:    0.7.0.1
 */