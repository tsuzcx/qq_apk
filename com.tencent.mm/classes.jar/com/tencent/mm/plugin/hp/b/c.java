package com.tencent.mm.plugin.hp.b;

import android.util.Base64;
import com.tencent.e.h;
import com.tencent.e.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.jw;
import com.tencent.mm.g.a.jw.a;
import com.tencent.mm.plugin.hp.c.a;
import com.tencent.mm.plugin.hp.tinker.e;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;

public final class c
  extends com.tencent.mm.sdk.b.c<jw>
{
  private static final String gNl;
  private a tFz;
  
  static
  {
    AppMethodBeat.i(117414);
    gNl = com.tencent.mm.loader.j.b.aoZ() + "_temp.hp";
    AppMethodBeat.o(117414);
  }
  
  public c()
  {
    AppMethodBeat.i(161180);
    this.tFz = null;
    this.__eventId = jw.class.getName().hashCode();
    AppMethodBeat.o(161180);
  }
  
  private boolean a(jw paramjw)
  {
    AppMethodBeat.i(117412);
    if (this.tFz != null)
    {
      ac.e("Tinker.HotPatchApplyService", "hp_apply processing busy, ignore new event");
      AppMethodBeat.o(117412);
      return false;
    }
    if (1 == paramjw.dlq.cZu)
    {
      e.cTr();
      AppMethodBeat.o(117412);
      return false;
    }
    if (paramjw.dlq.dlv != null)
    {
      aiy(paramjw.dlq.dlv);
      AppMethodBeat.o(117412);
      return false;
    }
    b.EN(1);
    if (paramjw.dlq.dlt != null) {}
    try
    {
      byte[] arrayOfByte = Base64.decode(paramjw.dlq.dlt, 0);
      paramjw.dlq.dlt = new String(arrayOfByte);
      label115:
      if ((!bs.isNullOrNil(paramjw.dlq.dlt)) && (!bs.isNullOrNil(paramjw.dlq.dlu)))
      {
        ac.i("Tinker.HotPatchApplyService", "hp_apply request url=%s, signature=%s", new Object[] { paramjw.dlq.dlt, paramjw.dlq.dlu });
        this.tFz = new a(paramjw.dlq.dlt, gNl, paramjw.dlq.dlu)
        {
          public final void ao(Runnable paramAnonymousRunnable)
          {
            AppMethodBeat.i(184412);
            super.ao(paramAnonymousRunnable);
            ac.d("Tinker.HotPatchApplyService", "hp_apply download url=%s, file=%s, failed=%b", new Object[] { c.a(c.this).url, c.a(c.this).tGs, Boolean.valueOf(c.a(c.this).aEZ) });
            if (!c.a(c.this).aEZ)
            {
              b.GS(1);
              c.aiy(c.a(c.this).tGs);
            }
            for (;;)
            {
              c.b(c.this);
              AppMethodBeat.o(184412);
              return;
              b.GT(1);
            }
          }
        };
      }
      while ((!bs.isNullOrNil(paramjw.dlq.dlr)) && (!bs.isNullOrNil(paramjw.dlq.dls)))
      {
        h.JZN.f(this.tFz, "hp_apply_download");
        AppMethodBeat.o(117412);
        return false;
      }
      AppMethodBeat.o(117412);
      return false;
    }
    catch (Error localError)
    {
      break label115;
    }
  }
  
  public static void aiy(String paramString)
  {
    AppMethodBeat.i(117410);
    ac.w("Tinker.HotPatchApplyService", "hp_apply from file %s", new Object[] { paramString });
    e.aiB(paramString);
    AppMethodBeat.o(117410);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.hp.b.c
 * JD-Core Version:    0.7.0.1
 */