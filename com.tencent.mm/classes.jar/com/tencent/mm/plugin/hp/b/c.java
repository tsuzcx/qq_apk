package com.tencent.mm.plugin.hp.b;

import android.util.Base64;
import com.tencent.e.h;
import com.tencent.e.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.ke;
import com.tencent.mm.g.a.ke.a;
import com.tencent.mm.plugin.hp.d.a;
import com.tencent.mm.plugin.hp.tinker.e;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;

public final class c
  extends com.tencent.mm.sdk.b.c<ke>
{
  private static final String hhi;
  private a uIi;
  
  static
  {
    AppMethodBeat.i(117414);
    hhi = com.tencent.mm.loader.j.b.arM() + "_temp.hp";
    AppMethodBeat.o(117414);
  }
  
  public c()
  {
    AppMethodBeat.i(161180);
    this.uIi = null;
    this.__eventId = ke.class.getName().hashCode();
    AppMethodBeat.o(161180);
  }
  
  private boolean a(ke paramke)
  {
    AppMethodBeat.i(117412);
    if (this.uIi != null)
    {
      ad.e("Tinker.HotPatchApplyService", "hp_apply processing busy, ignore new event");
      AppMethodBeat.o(117412);
      return false;
    }
    if (1 == paramke.dxd.dkM)
    {
      e.dcB();
      AppMethodBeat.o(117412);
      return false;
    }
    if (paramke.dxd.dxi != null)
    {
      anl(paramke.dxd.dxi);
      AppMethodBeat.o(117412);
      return false;
    }
    b.FZ(1);
    if (paramke.dxd.dxg != null) {}
    try
    {
      byte[] arrayOfByte = Base64.decode(paramke.dxd.dxg, 0);
      paramke.dxd.dxg = new String(arrayOfByte);
      label115:
      if ((!bt.isNullOrNil(paramke.dxd.dxg)) && (!bt.isNullOrNil(paramke.dxd.dxh)))
      {
        ad.i("Tinker.HotPatchApplyService", "hp_apply request url=%s, signature=%s", new Object[] { paramke.dxd.dxg, paramke.dxd.dxh });
        this.uIi = new a(paramke.dxd.dxg, hhi, paramke.dxd.dxh)
        {
          public final void an(Runnable paramAnonymousRunnable)
          {
            AppMethodBeat.i(184412);
            super.an(paramAnonymousRunnable);
            ad.d("Tinker.HotPatchApplyService", "hp_apply download url=%s, file=%s, failed=%b", new Object[] { c.a(c.this).url, c.a(c.this).uJf, Boolean.valueOf(c.a(c.this).aGQ) });
            if (!c.a(c.this).aGQ)
            {
              b.Io(1);
              c.anl(c.a(c.this).uJf);
            }
            for (;;)
            {
              c.b(c.this);
              AppMethodBeat.o(184412);
              return;
              b.Ip(1);
            }
          }
        };
      }
      while ((!bt.isNullOrNil(paramke.dxd.dxe)) && (!bt.isNullOrNil(paramke.dxd.dxf)))
      {
        h.LTJ.f(this.uIi, "hp_apply_download");
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
  
  public static void anl(String paramString)
  {
    AppMethodBeat.i(117410);
    ad.w("Tinker.HotPatchApplyService", "hp_apply from file %s", new Object[] { paramString });
    e.ano(paramString);
    AppMethodBeat.o(117410);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.hp.b.c
 * JD-Core Version:    0.7.0.1
 */