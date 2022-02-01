package com.tencent.mm.plugin.box;

import com.tencent.f.h;
import com.tencent.f.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.g;
import com.tencent.mm.ak.g.b;
import com.tencent.mm.ak.h.a;
import com.tencent.mm.ak.h.b;
import com.tencent.mm.ak.h.c;
import com.tencent.mm.bw.b;
import com.tencent.mm.plugin.messenger.foundation.a.q;
import com.tencent.mm.protocal.protobuf.rx;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.vfs.s;
import java.util.Map;

public final class a
  implements g
{
  public final q plo;
  
  public a()
  {
    AppMethodBeat.i(196183);
    this.plo = new q()
    {
      public final void onNewXmlReceived(final String paramAnonymousString, Map<String, String> paramAnonymousMap, h.a paramAnonymousa)
      {
        AppMethodBeat.i(196182);
        if (paramAnonymousString.equals("functionmsg"))
        {
          paramAnonymousString = (String)paramAnonymousMap.get(".sysmsg.functionmsg.businessid");
          if ((paramAnonymousString != null) && (paramAnonymousString.equals("20002")) && (paramAnonymousa.iMa != null))
          {
            paramAnonymousString = ((g.b)paramAnonymousa.iMa).iLT.KZo.toByteArray();
            paramAnonymousMap = c.ckW();
            if (s.YS(paramAnonymousMap)) {
              s.deleteFile(paramAnonymousMap);
            }
            s.bpa(paramAnonymousMap);
            s.f(paramAnonymousMap, paramAnonymousString, paramAnonymousString.length);
            Log.i("MicroMsg.WebSearch.BlackWhiteWordsMsgExtension", "[onNewXmlReceived] bytesLen: %s", new Object[] { Integer.valueOf(paramAnonymousString.length) });
            h.RTc.b(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(196181);
                c.ba(paramAnonymousString);
                c.kh(false);
                c.aho(c.ki(false));
                AppMethodBeat.o(196181);
              }
            }, "box.HotWordSearchModel");
          }
        }
        AppMethodBeat.o(196182);
      }
    };
    AppMethodBeat.o(196183);
  }
  
  public final int atA()
  {
    return 20002;
  }
  
  public final int atz()
  {
    return -1;
  }
  
  public final h.b b(h.a parama)
  {
    return null;
  }
  
  public final void b(h.c paramc) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.box.a
 * JD-Core Version:    0.7.0.1
 */