package com.tencent.mm.plugin.hp.b;

import android.util.Base64;
import com.tencent.e.h;
import com.tencent.e.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.f.a.ll;
import com.tencent.mm.f.a.ll.a;
import com.tencent.mm.plugin.hp.d.a;
import com.tencent.mm.plugin.hp.tinker.e;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;

public class c
  extends IListener<ll>
{
  private static final String kRA;
  private a DMy;
  
  static
  {
    AppMethodBeat.i(117414);
    kRA = com.tencent.mm.loader.j.b.aSD() + "_temp.hp";
    AppMethodBeat.o(117414);
  }
  
  public c()
  {
    AppMethodBeat.i(161180);
    this.DMy = null;
    this.__eventId = ll.class.getName().hashCode();
    AppMethodBeat.o(161180);
  }
  
  private boolean a(ll paramll)
  {
    AppMethodBeat.i(117412);
    if (this.DMy != null)
    {
      Log.e("Tinker.HotPatchApplyService", "hp_apply processing busy, ignore new event");
      AppMethodBeat.o(117412);
      return false;
    }
    if (1 == paramll.fJg.fvK)
    {
      e.eIk();
      AppMethodBeat.o(117412);
      return false;
    }
    if (paramll.fJg.fJl != null)
    {
      aLN(paramll.fJg.fJl);
      AppMethodBeat.o(117412);
      return false;
    }
    b.Rw(1);
    if (paramll.fJg.fJj != null) {}
    try
    {
      byte[] arrayOfByte = Base64.decode(paramll.fJg.fJj, 0);
      paramll.fJg.fJj = new String(arrayOfByte);
      label115:
      if ((!Util.isNullOrNil(paramll.fJg.fJj)) && (!Util.isNullOrNil(paramll.fJg.fJk)))
      {
        Log.i("Tinker.HotPatchApplyService", "hp_apply request url=%s, signature=%s", new Object[] { paramll.fJg.fJj, paramll.fJg.fJk });
        this.DMy = new a(paramll.fJg.fJj, kRA, paramll.fJg.fJk)
        {
          public final void aA(Runnable paramAnonymousRunnable)
          {
            AppMethodBeat.i(184412);
            super.aA(paramAnonymousRunnable);
            Log.d("Tinker.HotPatchApplyService", "hp_apply download url=%s, file=%s, failed=%b", new Object[] { c.a(c.this).url, c.a(c.this).DNv, Boolean.valueOf(c.a(c.this).lAQ) });
            if (!c.a(c.this).lAQ)
            {
              b.UX(1);
              c.aLN(c.a(c.this).DNv);
            }
            for (;;)
            {
              c.b(c.this);
              AppMethodBeat.o(184412);
              return;
              b.UY(1);
            }
          }
        };
      }
      while ((!Util.isNullOrNil(paramll.fJg.fJh)) && (!Util.isNullOrNil(paramll.fJg.fJi)))
      {
        h.ZvG.d(this.DMy, "hp_apply_download");
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
  
  public static void aLN(String paramString)
  {
    AppMethodBeat.i(117410);
    Log.w("Tinker.HotPatchApplyService", "hp_apply from file %s", new Object[] { paramString });
    e.aLQ(paramString);
    AppMethodBeat.o(117410);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.hp.b.c
 * JD-Core Version:    0.7.0.1
 */