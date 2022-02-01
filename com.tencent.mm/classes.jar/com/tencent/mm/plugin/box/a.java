package com.tencent.mm.plugin.box;

import com.tencent.e.h;
import com.tencent.e.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.g;
import com.tencent.mm.an.g.b;
import com.tencent.mm.an.h.a;
import com.tencent.mm.an.h.b;
import com.tencent.mm.an.h.c;
import com.tencent.mm.cd.b;
import com.tencent.mm.plugin.messenger.foundation.a.t;
import com.tencent.mm.protocal.protobuf.rq;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.vfs.u;
import java.util.Map;

public final class a
  implements g
{
  public final t snx;
  
  public a()
  {
    AppMethodBeat.i(250317);
    this.snx = new t()
    {
      public final void onNewXmlReceived(final String paramAnonymousString, Map<String, String> paramAnonymousMap, h.a paramAnonymousa)
      {
        AppMethodBeat.i(250447);
        if (paramAnonymousString.equals("functionmsg"))
        {
          paramAnonymousString = (String)paramAnonymousMap.get(".sysmsg.functionmsg.businessid");
          if ((paramAnonymousString != null) && (paramAnonymousString.equals("20002")) && (paramAnonymousa.lCh != null))
          {
            paramAnonymousString = ((g.b)paramAnonymousa.lCh).lCa.Sax.toByteArray();
            paramAnonymousMap = c.cys();
            if (u.agG(paramAnonymousMap)) {
              u.deleteFile(paramAnonymousMap);
            }
            u.bBV(paramAnonymousMap);
            u.H(paramAnonymousMap, paramAnonymousString);
            Log.i("MicroMsg.WebSearch.BlackWhiteWordsMsgExtension", "[onNewXmlReceived] bytesLen: %s", new Object[] { Integer.valueOf(paramAnonymousString.length) });
            h.ZvG.d(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(250475);
                c.bn(paramAnonymousString);
                c.ls(false);
                c.aoU(c.lt(false));
                AppMethodBeat.o(250475);
              }
            }, "box.HotWordSearchModel");
          }
        }
        AppMethodBeat.o(250447);
      }
    };
    AppMethodBeat.o(250317);
  }
  
  public final void a(g.b paramb) {}
  
  public final int aAq()
  {
    return -1;
  }
  
  public final long aAr()
  {
    return 20002L;
  }
  
  public final void aAs() {}
  
  public final h.b b(h.a parama)
  {
    return null;
  }
  
  public final void b(h.c paramc) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.box.a
 * JD-Core Version:    0.7.0.1
 */