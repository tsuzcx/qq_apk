package com.tencent.mm.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.e;
import com.tencent.mm.ai.e.a;
import com.tencent.mm.ai.e.b;
import com.tencent.mm.ai.e.c;
import com.tencent.mm.platformtools.aa;
import com.tencent.mm.protocal.protobuf.cm;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.br;
import com.tencent.mm.storage.z;
import java.util.Map;
import junit.framework.Assert;

public final class bs
  implements e
{
  public final void a(e.c paramc) {}
  
  public final e.b b(e.a parama)
  {
    boolean bool2 = true;
    AppMethodBeat.i(16347);
    parama = parama.eyJ;
    if (parama != null)
    {
      bool1 = true;
      Assert.assertTrue(bool1);
      if (parama.woR == null) {
        break label100;
      }
    }
    label100:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      Assert.assertTrue(bool1);
      parama = (String)br.F(aa.a(parama.woR), "tips").get(".tips.tip.url");
      ab.v("MicroMsg.SoftwareMsgExtension", "url:".concat(String.valueOf(parama)));
      aw.aaz();
      c.Ru().set(12308, parama);
      AppMethodBeat.o(16347);
      return null;
      bool1 = false;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.model.bs
 * JD-Core Version:    0.7.0.1
 */