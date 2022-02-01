package com.tencent.mm.plugin.box;

import com.tencent.e.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.d;
import com.tencent.mm.al.d.b;
import com.tencent.mm.al.e.a;
import com.tencent.mm.al.e.b;
import com.tencent.mm.al.e.c;
import com.tencent.mm.bx.b;
import com.tencent.mm.plugin.messenger.foundation.a.q;
import com.tencent.mm.protocal.protobuf.qu;
import com.tencent.mm.sdk.platformtools.ad;
import java.util.Map;

public final class a
  implements d
{
  public final q nUM;
  
  public a()
  {
    AppMethodBeat.i(219084);
    this.nUM = new q()
    {
      public final void onNewXmlReceived(final String paramAnonymousString, Map<String, String> paramAnonymousMap, e.a paramAnonymousa)
      {
        AppMethodBeat.i(219083);
        if (paramAnonymousString.equals("functionmsg"))
        {
          paramAnonymousString = (String)paramAnonymousMap.get(".sysmsg.functionmsg.businessid");
          if ((paramAnonymousString != null) && (paramAnonymousString.equals("20002")) && (paramAnonymousa.hNZ != null))
          {
            paramAnonymousString = ((d.b)paramAnonymousa.hNZ).hNS.FMy.toByteArray();
            paramAnonymousMap = c.bEc();
            if (com.tencent.mm.vfs.i.fv(paramAnonymousMap)) {
              com.tencent.mm.vfs.i.deleteFile(paramAnonymousMap);
            }
            com.tencent.mm.vfs.i.aYs(paramAnonymousMap);
            com.tencent.mm.vfs.i.f(paramAnonymousMap, paramAnonymousString, paramAnonymousString.length);
            ad.i("MicroMsg.WebSearch.BlackWhiteWordsMsgExtension", "[onNewXmlReceived] bytesLen: %s", new Object[] { Integer.valueOf(paramAnonymousString.length) });
            h.LTJ.f(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(219082);
                c.aJ(paramAnonymousString);
                c.mv(false);
                c.WG(c.jk(false));
                AppMethodBeat.o(219082);
              }
            }, "box.HotWordSearchModel");
          }
        }
        AppMethodBeat.o(219083);
      }
    };
    AppMethodBeat.o(219084);
  }
  
  public final int adG()
  {
    return -1;
  }
  
  public final int adH()
  {
    return 20002;
  }
  
  public final e.b b(e.a parama)
  {
    return null;
  }
  
  public final void b(e.c paramc) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.box.a
 * JD-Core Version:    0.7.0.1
 */