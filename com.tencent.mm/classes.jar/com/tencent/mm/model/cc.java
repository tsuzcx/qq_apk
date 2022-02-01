package com.tencent.mm.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.h;
import com.tencent.mm.ak.h.a;
import com.tencent.mm.ak.h.b;
import com.tencent.mm.ak.h.c;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.protocal.protobuf.de;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.XmlParser;
import com.tencent.mm.storage.ao;
import java.util.Map;
import junit.framework.Assert;

public final class cc
  implements h
{
  public final h.b b(h.a parama)
  {
    boolean bool2 = true;
    AppMethodBeat.i(20393);
    parama = parama.heO;
    if (parama != null)
    {
      bool1 = true;
      Assert.assertTrue(bool1);
      if (parama.KHn == null) {
        break label101;
      }
    }
    label101:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      Assert.assertTrue(bool1);
      parama = (String)XmlParser.parseXml(z.a(parama.KHn), "tips", null).get(".tips.tip.url");
      Log.v("MicroMsg.SoftwareMsgExtension", "url:".concat(String.valueOf(parama)));
      bg.aVF();
      c.azQ().set(12308, parama);
      AppMethodBeat.o(20393);
      return null;
      bool1 = false;
      break;
    }
  }
  
  public final void b(h.c paramc) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.model.cc
 * JD-Core Version:    0.7.0.1
 */