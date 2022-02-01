package com.tencent.mm.plugin.hp.b;

import android.util.Base64;
import com.tencent.e.h;
import com.tencent.e.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.jo;
import com.tencent.mm.g.a.jo.a;
import com.tencent.mm.plugin.hp.c.a;
import com.tencent.mm.plugin.hp.tinker.e;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;

public final class c
  extends com.tencent.mm.sdk.b.c<jo>
{
  private static final String gmy;
  private a sxK;
  
  static
  {
    AppMethodBeat.i(117414);
    gmy = com.tencent.mm.loader.j.b.ahZ() + "_temp.hp";
    AppMethodBeat.o(117414);
  }
  
  public c()
  {
    AppMethodBeat.i(161180);
    this.sxK = null;
    this.__eventId = jo.class.getName().hashCode();
    AppMethodBeat.o(161180);
  }
  
  private boolean a(jo paramjo)
  {
    AppMethodBeat.i(117412);
    if (this.sxK != null)
    {
      ad.e("Tinker.HotPatchApplyService", "hp_apply processing busy, ignore new event");
      AppMethodBeat.o(117412);
      return false;
    }
    if (1 == paramjo.dnH.dbV)
    {
      e.cGh();
      AppMethodBeat.o(117412);
      return false;
    }
    if (paramjo.dnH.dnM != null)
    {
      adG(paramjo.dnH.dnM);
      AppMethodBeat.o(117412);
      return false;
    }
    b.EW(1);
    if (paramjo.dnH.dnK != null) {}
    try
    {
      byte[] arrayOfByte = Base64.decode(paramjo.dnH.dnK, 0);
      paramjo.dnH.dnK = new String(arrayOfByte);
      label115:
      if ((!bt.isNullOrNil(paramjo.dnH.dnK)) && (!bt.isNullOrNil(paramjo.dnH.dnL)))
      {
        ad.i("Tinker.HotPatchApplyService", "hp_apply request url=%s, signature=%s", new Object[] { paramjo.dnH.dnK, paramjo.dnH.dnL });
        this.sxK = new a(paramjo.dnH.dnK, gmy, paramjo.dnH.dnL)
        {
          public final void am(Runnable paramAnonymousRunnable)
          {
            AppMethodBeat.i(184412);
            super.am(paramAnonymousRunnable);
            ad.d("Tinker.HotPatchApplyService", "hp_apply download url=%s, file=%s, failed=%b", new Object[] { c.a(c.this).url, c.a(c.this).syC, Boolean.valueOf(c.a(c.this).aEj) });
            if (!c.a(c.this).aEj)
            {
              b.EX(1);
              c.adG(c.a(c.this).syC);
            }
            for (;;)
            {
              c.b(c.this);
              AppMethodBeat.o(184412);
              return;
              b.EY(1);
            }
          }
        };
      }
      while ((!bt.isNullOrNil(paramjo.dnH.dnI)) && (!bt.isNullOrNil(paramjo.dnH.dnJ)))
      {
        h.Iye.f(this.sxK, "hp_apply_download");
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
  
  public static void adG(String paramString)
  {
    AppMethodBeat.i(117410);
    ad.w("Tinker.HotPatchApplyService", "hp_apply from file %s", new Object[] { paramString });
    e.adJ(paramString);
    AppMethodBeat.o(117410);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.hp.b.c
 * JD-Core Version:    0.7.0.1
 */