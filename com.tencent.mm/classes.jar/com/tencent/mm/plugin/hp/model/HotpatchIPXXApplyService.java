package com.tencent.mm.plugin.hp.model;

import android.util.Base64;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.app.f;
import com.tencent.mm.autogen.a.mr;
import com.tencent.mm.autogen.a.mr.a;
import com.tencent.mm.loader.i.b;
import com.tencent.mm.plugin.hp.b.a;
import com.tencent.mm.plugin.hp.tinker.e;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.threadpool.h;
import com.tencent.threadpool.i;

public class HotpatchIPXXApplyService
  extends IListener<mr>
{
  private static final String ntb;
  private a JDM;
  
  static
  {
    AppMethodBeat.i(117414);
    ntb = b.bmr() + "_temp.hp";
    AppMethodBeat.o(117414);
  }
  
  public HotpatchIPXXApplyService()
  {
    super(f.hfK);
    AppMethodBeat.i(161180);
    this.JDM = null;
    this.__eventId = mr.class.getName().hashCode();
    AppMethodBeat.o(161180);
  }
  
  private boolean a(mr parammr)
  {
    AppMethodBeat.i(117412);
    if (this.JDM != null)
    {
      Log.e("Tinker.HotPatchApplyService", "hp_apply processing busy, ignore new event");
      AppMethodBeat.o(117412);
      return false;
    }
    if (1 == parammr.hON.hAf)
    {
      e.fQd();
      AppMethodBeat.o(117412);
      return false;
    }
    if (parammr.hON.hOS != null)
    {
      aIH(parammr.hON.hOS);
      AppMethodBeat.o(117412);
      return false;
    }
    c.UA(1);
    if (parammr.hON.hOQ != null) {}
    try
    {
      byte[] arrayOfByte = Base64.decode(parammr.hON.hOQ, 0);
      parammr.hON.hOQ = new String(arrayOfByte);
      label115:
      if ((!Util.isNullOrNil(parammr.hON.hOQ)) && (!Util.isNullOrNil(parammr.hON.hOR)))
      {
        Log.i("Tinker.HotPatchApplyService", "hp_apply request url=%s, signature=%s", new Object[] { parammr.hON.hOQ, parammr.hON.hOR });
        this.JDM = new a(parammr.hON.hOQ, ntb, parammr.hON.hOR)
        {
          public final void aJ(Runnable paramAnonymousRunnable)
          {
            AppMethodBeat.i(184412);
            super.aJ(paramAnonymousRunnable);
            Log.d("Tinker.HotPatchApplyService", "hp_apply download url=%s, file=%s, failed=%b", new Object[] { HotpatchIPXXApplyService.a(HotpatchIPXXApplyService.this).url, HotpatchIPXXApplyService.a(HotpatchIPXXApplyService.this).JEJ, Boolean.valueOf(HotpatchIPXXApplyService.a(HotpatchIPXXApplyService.this).oss) });
            if (!HotpatchIPXXApplyService.a(HotpatchIPXXApplyService.this).oss)
            {
              c.YS(1);
              HotpatchIPXXApplyService.aIH(HotpatchIPXXApplyService.a(HotpatchIPXXApplyService.this).JEJ);
            }
            for (;;)
            {
              HotpatchIPXXApplyService.b(HotpatchIPXXApplyService.this);
              AppMethodBeat.o(184412);
              return;
              c.YT(1);
            }
          }
        };
      }
      while ((!Util.isNullOrNil(parammr.hON.hOO)) && (!Util.isNullOrNil(parammr.hON.hOP)))
      {
        h.ahAA.g(this.JDM, "hp_apply_download");
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
  
  public static void aIH(String paramString)
  {
    AppMethodBeat.i(117410);
    Log.w("Tinker.HotPatchApplyService", "hp_apply from file %s", new Object[] { paramString });
    e.aIK(paramString);
    AppMethodBeat.o(117410);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.hp.model.HotpatchIPXXApplyService
 * JD-Core Version:    0.7.0.1
 */