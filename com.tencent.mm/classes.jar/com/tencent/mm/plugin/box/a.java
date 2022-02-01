package com.tencent.mm.plugin.box;

import com.tencent.e.h;
import com.tencent.e.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.d.b;
import com.tencent.mm.ak.e.a;
import com.tencent.mm.ak.e.b;
import com.tencent.mm.ak.e.c;
import com.tencent.mm.bw.b;
import com.tencent.mm.plugin.messenger.foundation.a.q;
import com.tencent.mm.protocal.protobuf.qw;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.vfs.o;
import java.util.Map;

public final class a
  implements d
{
  public final q oas;
  
  public a()
  {
    AppMethodBeat.i(208276);
    this.oas = new q()
    {
      public final void onNewXmlReceived(final String paramAnonymousString, Map<String, String> paramAnonymousMap, e.a paramAnonymousa)
      {
        AppMethodBeat.i(208275);
        if (paramAnonymousString.equals("functionmsg"))
        {
          paramAnonymousString = (String)paramAnonymousMap.get(".sysmsg.functionmsg.businessid");
          if ((paramAnonymousString != null) && (paramAnonymousString.equals("20002")) && (paramAnonymousa.hQS != null))
          {
            paramAnonymousString = ((d.b)paramAnonymousa.hQS).hQL.GeX.toByteArray();
            paramAnonymousMap = c.bNW();
            if (o.fB(paramAnonymousMap)) {
              o.deleteFile(paramAnonymousMap);
            }
            o.aZV(paramAnonymousMap);
            o.f(paramAnonymousMap, paramAnonymousString, paramAnonymousString.length);
            ae.i("MicroMsg.WebSearch.BlackWhiteWordsMsgExtension", "[onNewXmlReceived] bytesLen: %s", new Object[] { Integer.valueOf(paramAnonymousString.length) });
            h.MqF.f(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(208274);
                c.aJ(paramAnonymousString);
                c.ji(false);
                c.Xs(c.jj(false));
                AppMethodBeat.o(208274);
              }
            }, "box.HotWordSearchModel");
          }
        }
        AppMethodBeat.o(208275);
      }
    };
    AppMethodBeat.o(208276);
  }
  
  public final int adS()
  {
    return -1;
  }
  
  public final int adT()
  {
    return 20002;
  }
  
  public final e.b b(e.a parama)
  {
    return null;
  }
  
  public final void b(e.c paramc) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.box.a
 * JD-Core Version:    0.7.0.1
 */