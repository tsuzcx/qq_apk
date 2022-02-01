package com.tencent.mm.model;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.l;
import com.tencent.mm.contact.d;
import com.tencent.mm.f.c.ax;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.bv;
import com.tencent.mm.storage.bw;

public final class ak
{
  private c ltn;
  
  public ak(c paramc)
  {
    this.ltn = paramc;
  }
  
  public static void S(as paramas)
  {
    AppMethodBeat.i(20319);
    as localas = paramas;
    if (paramas == null) {
      localas = new as();
    }
    if ((int)localas.jxt == 0)
    {
      localas.setUsername("filehelper");
      bh.beI();
      if (c.bbR().bwx(localas.field_username) != null) {
        break label83;
      }
      localas.axl();
    }
    for (;;)
    {
      localas.pv(3);
      bh.beI();
      c.bbL().au(localas);
      AppMethodBeat.o(20319);
      return;
      label83:
      localas.axk();
    }
  }
  
  static void T(as paramas)
  {
    AppMethodBeat.i(20320);
    String str = paramas.field_username;
    Context localContext = MMApplicationContext.getContext();
    if (str.equals("qqsync"))
    {
      paramas.setNickname(localContext.getString(R.l.eHw));
      paramas.It(localContext.getString(R.l.eHx));
      paramas.Iu(localContext.getString(R.l.eHy));
    }
    if (str.equals("floatbottle"))
    {
      paramas.setNickname(localContext.getString(R.l.eGC));
      paramas.It(localContext.getString(R.l.eGD));
      paramas.Iu(localContext.getString(R.l.eGE));
    }
    if (str.equals("shakeapp"))
    {
      paramas.setNickname(localContext.getString(R.l.eHC));
      paramas.It(localContext.getString(R.l.eHD));
      paramas.Iu(localContext.getString(R.l.eHE));
    }
    if (str.equals("lbsapp"))
    {
      paramas.setNickname(localContext.getString(R.l.eGV));
      paramas.It(localContext.getString(R.l.eGW));
      paramas.Iu(localContext.getString(R.l.eGX));
    }
    if (str.equals("medianote"))
    {
      paramas.setNickname(localContext.getString(R.l.eHe));
      paramas.It(localContext.getString(R.l.eHf));
      paramas.Iu(localContext.getString(R.l.eHg));
    }
    if (str.equals("newsapp"))
    {
      paramas.setNickname(localContext.getString(R.l.eHz));
      paramas.It(localContext.getString(R.l.eHA));
      paramas.Iu(localContext.getString(R.l.eHB));
    }
    if (str.equals("facebookapp"))
    {
      paramas.setNickname(localContext.getString(R.l.hardcode_plugin_facebookapp_nick));
      paramas.It(localContext.getString(R.l.eGL));
      paramas.Iu(localContext.getString(R.l.eGM));
    }
    if (str.equals("qqfriend"))
    {
      paramas.setNickname(localContext.getString(R.l.hardcode_plugin_qqfriend_nick));
      paramas.It(localContext.getString(R.l.eHr));
      paramas.Iu(localContext.getString(R.l.eHs));
    }
    if (str.equals("masssendapp"))
    {
      paramas.setNickname(localContext.getString(R.l.eHb));
      paramas.It(localContext.getString(R.l.eHc));
      paramas.Iu(localContext.getString(R.l.eHd));
    }
    if (str.equals("feedsapp"))
    {
      paramas.setNickname(localContext.getString(R.l.hardcode_plugin_feedsapp_nick));
      paramas.It(localContext.getString(R.l.eGN));
      paramas.Iu(localContext.getString(R.l.eGO));
    }
    if (str.equals("fmessage"))
    {
      paramas.setNickname(localContext.getString(R.l.eGP));
      paramas.It(localContext.getString(R.l.eGQ));
      paramas.Iu(localContext.getString(R.l.eGR));
    }
    if (str.equals("voipapp"))
    {
      paramas.setNickname(localContext.getString(R.l.eHI));
      paramas.It(localContext.getString(R.l.eHJ));
      paramas.Iu(localContext.getString(R.l.eHK));
    }
    if (str.equals("officialaccounts"))
    {
      paramas.setNickname(localContext.getString(R.l.eHl));
      paramas.It(localContext.getString(R.l.eHm));
      paramas.Iu(localContext.getString(R.l.eHn));
    }
    if (str.equals("findersayhisessionholder"))
    {
      paramas.setNickname(localContext.getString(R.l.eHo));
      paramas.It(localContext.getString(R.l.eHp));
      paramas.Iu(localContext.getString(R.l.eHq));
    }
    if (str.equals("helper_entry"))
    {
      paramas.setNickname(localContext.getString(R.l.eGS));
      paramas.It(localContext.getString(R.l.eGT));
      paramas.Iu(localContext.getString(R.l.eGU));
    }
    if (str.equals("cardpackage"))
    {
      paramas.setNickname(localContext.getString(R.l.eGF));
      paramas.It(localContext.getString(R.l.eGG));
      paramas.Iu(localContext.getString(R.l.eGH));
    }
    if (str.equals("voicevoipapp"))
    {
      paramas.setNickname(localContext.getString(R.l.eHL));
      paramas.It(localContext.getString(R.l.eHM));
      paramas.Iu(localContext.getString(R.l.eHN));
    }
    if (str.equals("voiceinputapp"))
    {
      paramas.setNickname(localContext.getString(R.l.eHF));
      paramas.It(localContext.getString(R.l.eHG));
      paramas.Iu(localContext.getString(R.l.eHH));
    }
    if (str.equals("qqmail"))
    {
      paramas.setNickname(localContext.getString(R.l.eHt));
      paramas.It(localContext.getString(R.l.eHu));
      paramas.Iu(localContext.getString(R.l.eHv));
    }
    if (str.equals("linkedinplugin"))
    {
      paramas.setNickname(localContext.getString(R.l.eGY));
      paramas.It(localContext.getString(R.l.eGZ));
      paramas.Iu(localContext.getString(R.l.eHa));
    }
    if (str.equals("notifymessage"))
    {
      paramas.setNickname(localContext.getString(R.l.eHi));
      paramas.It(localContext.getString(R.l.eHj));
      paramas.Iu(localContext.getString(R.l.eHk));
    }
    if (str.equals("appbrandcustomerservicemsg"))
    {
      paramas.setNickname(localContext.getString(R.l.eGw));
      paramas.It(localContext.getString(R.l.eGx));
      paramas.Iu(localContext.getString(R.l.eGy));
    }
    if (str.equals("downloaderapp"))
    {
      paramas.setNickname(localContext.getString(R.l.eGI));
      paramas.It(localContext.getString(R.l.eGJ));
      paramas.Iu(localContext.getString(R.l.eGK));
    }
    if (str.equals("appbrand_notify_message"))
    {
      paramas.setNickname(localContext.getString(R.l.eGz));
      paramas.It(localContext.getString(R.l.eGA));
      paramas.Iu(localContext.getString(R.l.eGB));
    }
    AppMethodBeat.o(20320);
  }
  
  static int a(boolean paramBoolean1, String paramString, boolean paramBoolean2)
  {
    int i = 3;
    AppMethodBeat.i(20318);
    as localas2 = c.bbL().RG(paramString);
    as localas1 = localas2;
    if (localas2 == null) {
      localas1 = new as();
    }
    if ((int)localas1.jxt == 0)
    {
      localas1.setUsername(paramString);
      localas1.axk();
      T(localas1);
      if (paramBoolean2) {
        i = 4;
      }
      localas1.pv(i);
      localas1.axx();
      c.bbL().av(localas1);
      AppMethodBeat.o(20318);
      return 1;
    }
    if (paramBoolean1)
    {
      localas1.axx();
      c.bbL().c(paramString, localas1);
      AppMethodBeat.o(20318);
      return 2;
    }
    AppMethodBeat.o(20318);
    return 3;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.model.ak
 * JD-Core Version:    0.7.0.1
 */