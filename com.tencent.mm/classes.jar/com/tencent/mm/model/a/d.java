package com.tencent.mm.model.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.h;
import com.tencent.mm.ak.h.a;
import com.tencent.mm.ak.h.b;
import com.tencent.mm.ak.h.c;
import com.tencent.mm.kernel.e;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.protocal.protobuf.de;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ao;

public final class d
  implements h
{
  public final h.b b(h.a parama)
  {
    AppMethodBeat.i(153093);
    parama = parama.heO;
    if ((parama == null) || (parama.KHn == null))
    {
      Log.f("MicroMsg.abtest.AbTestMsgExtension", "[Abtest] AbTestMsgExtension failed, invalid cmdAM");
      AppMethodBeat.o(153093);
      return null;
    }
    String str = z.a(parama.KHn);
    com.tencent.mm.kernel.g.aAh().azQ().set(328193, str);
    parama = g.aWT();
    long l = System.currentTimeMillis();
    try
    {
      parama.KS(str);
      str = (String)com.tencent.mm.kernel.g.aAh().azQ().get(328197, null);
      if ((Util.isNullOrNil(str)) || ((parama.iGz != null) && (!str.equals(parama.iGz.iGw))))
      {
        com.tencent.mm.kernel.g.aAh().azQ().set(328197, parama.iGz.iGw);
        com.tencent.mm.kernel.g.aAh().azQ().set(328195, Boolean.FALSE);
        com.tencent.mm.kernel.g.aAh().azQ().set(328194, Boolean.FALSE);
        com.tencent.mm.kernel.g.aAh().azQ().set(328196, Boolean.FALSE);
        Log.i("MicroMsg.abtest.AbTestManager", "[cpan] new case id or new case id , reset click value.");
      }
    }
    catch (Exception parama)
    {
      for (;;)
      {
        Log.e("MicroMsg.abtest.AbTestManager", "[Abtest] updateAbTestCase exception:%s", new Object[] { parama.toString() });
      }
    }
    Log.i("MicroMsg.abtest.AbTestManager", "[Abtest] update use time:%d", new Object[] { Long.valueOf(System.currentTimeMillis() - l) });
    if (g.aWT().aWR()) {
      f.KU(g.aWT().iGz.iGw);
    }
    AppMethodBeat.o(153093);
    return null;
  }
  
  public final void b(h.c paramc) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.model.a.d
 * JD-Core Version:    0.7.0.1
 */