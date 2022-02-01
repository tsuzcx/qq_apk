package com.tencent.mm.plugin.box;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.f;
import com.tencent.mm.am.f.b;
import com.tencent.mm.am.g.a;
import com.tencent.mm.am.g.b;
import com.tencent.mm.am.g.c;
import com.tencent.mm.bx.b;
import com.tencent.mm.plugin.messenger.foundation.a.t;
import com.tencent.mm.protocal.protobuf.tb;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.vfs.y;
import com.tencent.threadpool.h;
import com.tencent.threadpool.i;
import java.util.Map;

public final class a
  implements f
{
  public final t vzv;
  
  public a()
  {
    AppMethodBeat.i(278704);
    this.vzv = new t()
    {
      public final void onNewXmlReceived(final String paramAnonymousString, Map<String, String> paramAnonymousMap, g.a paramAnonymousa)
      {
        AppMethodBeat.i(278686);
        if (paramAnonymousString.equals("functionmsg"))
        {
          paramAnonymousString = (String)paramAnonymousMap.get(".sysmsg.functionmsg.businessid");
          if ((paramAnonymousString != null) && (paramAnonymousString.equals("20002")) && (paramAnonymousa.extra != null))
          {
            paramAnonymousString = ((f.b)paramAnonymousa.extra).otK.YYw.toByteArray();
            paramAnonymousMap = c.dbj();
            if (y.ZC(paramAnonymousMap)) {
              y.deleteFile(paramAnonymousMap);
            }
            y.bEp(paramAnonymousMap);
            y.f(paramAnonymousMap, paramAnonymousString, paramAnonymousString.length);
            Log.i("MicroMsg.WebSearch.BlackWhiteWordsMsgExtension", "[onNewXmlReceived] bytesLen: %s", new Object[] { Integer.valueOf(paramAnonymousString.length) });
            h.ahAA.g(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(278694);
                c.bn(paramAnonymousString);
                c.mK(false);
                c.aiq(c.mL(false));
                AppMethodBeat.o(278694);
              }
            }, "box.HotWordSearchModel");
          }
        }
        AppMethodBeat.o(278686);
      }
    };
    AppMethodBeat.o(278704);
  }
  
  public final void a(f.b paramb) {}
  
  public final int aTl()
  {
    return -1;
  }
  
  public final long aTm()
  {
    return 20002L;
  }
  
  public final void aTn() {}
  
  public final g.b b(g.a parama)
  {
    return null;
  }
  
  public final void b(g.c paramc) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.box.a
 * JD-Core Version:    0.7.0.1
 */