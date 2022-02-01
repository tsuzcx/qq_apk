package com.tencent.mm.plugin.ai.b.a.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.aal;
import com.tencent.mm.g.a.aal.a;
import com.tencent.mm.g.a.uc;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.LinkedList;
import java.util.List;

public final class a
{
  private static a kwD;
  public IListener<uc> kvR;
  public IListener<aal> kvT;
  private List<b> kwB;
  long kwC;
  
  private a()
  {
    AppMethodBeat.i(238894);
    this.kvR = new a.1(this);
    this.kwC = 0L;
    this.kvT = new IListener()
    {
      private boolean a(aal paramAnonymousaal)
      {
        AppMethodBeat.i(238892);
        if ((paramAnonymousaal == null) || (paramAnonymousaal.ehk == null))
        {
          AppMethodBeat.o(238892);
          return false;
        }
        if (paramAnonymousaal.ehk.type == 7) {
          a.this.kwC = paramAnonymousaal.ehk.ehl;
        }
        if (paramAnonymousaal.ehk.type == 8)
        {
          a.this.kwC = 0L;
          a.a(a.this, "desktop", paramAnonymousaal.ehk.ehl);
        }
        Log.v("MicroMsg.AiSessionData", "wechat front back event [%d] [%s] [%d]", new Object[] { Integer.valueOf(paramAnonymousaal.ehk.type), paramAnonymousaal.ehk.activity, Long.valueOf(paramAnonymousaal.ehk.ehl) });
        AppMethodBeat.o(238892);
        return false;
      }
    };
    this.kwB = new LinkedList();
    AppMethodBeat.o(238894);
  }
  
  public static a bqv()
  {
    AppMethodBeat.i(238895);
    if (kwD == null) {
      kwD = new a();
    }
    a locala = kwD;
    AppMethodBeat.o(238895);
    return locala;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.ai.b.a.b.a
 * JD-Core Version:    0.7.0.1
 */