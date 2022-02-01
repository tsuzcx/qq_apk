package com.tencent.mm.plugin.hp.b;

import android.util.Base64;
import com.tencent.e.h;
import com.tencent.e.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.kf;
import com.tencent.mm.g.a.kf.a;
import com.tencent.mm.plugin.hp.d.a;
import com.tencent.mm.plugin.hp.tinker.e;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;

public final class c
  extends com.tencent.mm.sdk.b.c<kf>
{
  private static final String hjW;
  private a uTV;
  
  static
  {
    AppMethodBeat.i(117414);
    hjW = com.tencent.mm.loader.j.b.asb() + "_temp.hp";
    AppMethodBeat.o(117414);
  }
  
  public c()
  {
    AppMethodBeat.i(161180);
    this.uTV = null;
    this.__eventId = kf.class.getName().hashCode();
    AppMethodBeat.o(161180);
  }
  
  private boolean a(kf paramkf)
  {
    AppMethodBeat.i(117412);
    if (this.uTV != null)
    {
      ae.e("Tinker.HotPatchApplyService", "hp_apply processing busy, ignore new event");
      AppMethodBeat.o(117412);
      return false;
    }
    if (1 == paramkf.dyi.dlO)
    {
      e.dft();
      AppMethodBeat.o(117412);
      return false;
    }
    if (paramkf.dyi.dyn != null)
    {
      aon(paramkf.dyi.dyn);
      AppMethodBeat.o(117412);
      return false;
    }
    b.Gz(1);
    if (paramkf.dyi.dyl != null) {}
    try
    {
      byte[] arrayOfByte = Base64.decode(paramkf.dyi.dyl, 0);
      paramkf.dyi.dyl = new String(arrayOfByte);
      label115:
      if ((!bu.isNullOrNil(paramkf.dyi.dyl)) && (!bu.isNullOrNil(paramkf.dyi.dym)))
      {
        ae.i("Tinker.HotPatchApplyService", "hp_apply request url=%s, signature=%s", new Object[] { paramkf.dyi.dyl, paramkf.dyi.dym });
        this.uTV = new a(paramkf.dyi.dyl, hjW, paramkf.dyi.dym)
        {
          public final void al(Runnable paramAnonymousRunnable)
          {
            AppMethodBeat.i(184412);
            super.al(paramAnonymousRunnable);
            ae.d("Tinker.HotPatchApplyService", "hp_apply download url=%s, file=%s, failed=%b", new Object[] { c.a(c.this).url, c.a(c.this).uUS, Boolean.valueOf(c.a(c.this).aGQ) });
            if (!c.a(c.this).aGQ)
            {
              b.IM(1);
              c.aon(c.a(c.this).uUS);
            }
            for (;;)
            {
              c.b(c.this);
              AppMethodBeat.o(184412);
              return;
              b.IN(1);
            }
          }
        };
      }
      while ((!bu.isNullOrNil(paramkf.dyi.dyj)) && (!bu.isNullOrNil(paramkf.dyi.dyk)))
      {
        h.MqF.f(this.uTV, "hp_apply_download");
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
  
  public static void aon(String paramString)
  {
    AppMethodBeat.i(117410);
    ae.w("Tinker.HotPatchApplyService", "hp_apply from file %s", new Object[] { paramString });
    e.aoq(paramString);
    AppMethodBeat.o(117410);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.hp.b.c
 * JD-Core Version:    0.7.0.1
 */