package com.tencent.mm.plugin.hp.b;

import android.util.Base64;
import com.tencent.f.h;
import com.tencent.f.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.ku;
import com.tencent.mm.g.a.ku.a;
import com.tencent.mm.plugin.hp.d.a;
import com.tencent.mm.plugin.hp.tinker.e;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;

public final class c
  extends IListener<ku>
{
  private static final String icT;
  private a ymw;
  
  static
  {
    AppMethodBeat.i(117414);
    icT = com.tencent.mm.loader.j.b.aKB() + "_temp.hp";
    AppMethodBeat.o(117414);
  }
  
  public c()
  {
    AppMethodBeat.i(161180);
    this.ymw = null;
    this.__eventId = ku.class.getName().hashCode();
    AppMethodBeat.o(161180);
  }
  
  private boolean a(ku paramku)
  {
    AppMethodBeat.i(117412);
    if (this.ymw != null)
    {
      Log.e("Tinker.HotPatchApplyService", "hp_apply processing busy, ignore new event");
      AppMethodBeat.o(117412);
      return false;
    }
    if (1 == paramku.dPP.dDe)
    {
      e.dZn();
      AppMethodBeat.o(117412);
      return false;
    }
    if (paramku.dPP.dPU != null)
    {
      aBG(paramku.dPP.dPU);
      AppMethodBeat.o(117412);
      return false;
    }
    b.Mg(1);
    if (paramku.dPP.dPS != null) {}
    try
    {
      byte[] arrayOfByte = Base64.decode(paramku.dPP.dPS, 0);
      paramku.dPP.dPS = new String(arrayOfByte);
      label115:
      if ((!Util.isNullOrNil(paramku.dPP.dPS)) && (!Util.isNullOrNil(paramku.dPP.dPT)))
      {
        Log.i("Tinker.HotPatchApplyService", "hp_apply request url=%s, signature=%s", new Object[] { paramku.dPP.dPS, paramku.dPP.dPT });
        this.ymw = new a(paramku.dPP.dPS, icT, paramku.dPP.dPT)
        {
          public final void av(Runnable paramAnonymousRunnable)
          {
            AppMethodBeat.i(184412);
            super.av(paramAnonymousRunnable);
            Log.d("Tinker.HotPatchApplyService", "hp_apply download url=%s, file=%s, failed=%b", new Object[] { c.a(c.this).url, c.a(c.this).ynt, Boolean.valueOf(c.a(c.this).aGI) });
            if (!c.a(c.this).aGI)
            {
              b.OP(1);
              c.aBG(c.a(c.this).ynt);
            }
            for (;;)
            {
              c.b(c.this);
              AppMethodBeat.o(184412);
              return;
              b.OQ(1);
            }
          }
        };
      }
      while ((!Util.isNullOrNil(paramku.dPP.dPQ)) && (!Util.isNullOrNil(paramku.dPP.dPR)))
      {
        h.RTc.b(this.ymw, "hp_apply_download");
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
  
  public static void aBG(String paramString)
  {
    AppMethodBeat.i(117410);
    Log.w("Tinker.HotPatchApplyService", "hp_apply from file %s", new Object[] { paramString });
    e.aBJ(paramString);
    AppMethodBeat.o(117410);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.hp.b.c
 * JD-Core Version:    0.7.0.1
 */