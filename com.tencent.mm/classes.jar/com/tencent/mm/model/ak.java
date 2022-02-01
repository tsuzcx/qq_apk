package com.tencent.mm.model;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.ax;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.bv;
import com.tencent.mm.storage.bw;

public final class ak
{
  private c iDn;
  
  public ak(c paramc)
  {
    this.iDn = paramc;
  }
  
  public static void L(as paramas)
  {
    AppMethodBeat.i(20319);
    as localas = paramas;
    if (paramas == null) {
      localas = new as();
    }
    if ((int)localas.gMZ == 0)
    {
      localas.setUsername("filehelper");
      bg.aVF();
      if (c.aST().bjY(localas.field_username) != null) {
        break label83;
      }
      localas.aqR();
    }
    for (;;)
    {
      localas.ni(3);
      bg.aVF();
      c.aSN().ao(localas);
      AppMethodBeat.o(20319);
      return;
      label83:
      localas.aqQ();
    }
  }
  
  static void M(as paramas)
  {
    AppMethodBeat.i(20320);
    String str = paramas.field_username;
    Context localContext = MMApplicationContext.getContext();
    if (str.equals("qqsync"))
    {
      paramas.setNickname(localContext.getString(2131761591));
      paramas.BF(localContext.getString(2131761592));
      paramas.BG(localContext.getString(2131761593));
    }
    if (str.equals("floatbottle"))
    {
      paramas.setNickname(localContext.getString(2131761536));
      paramas.BF(localContext.getString(2131761537));
      paramas.BG(localContext.getString(2131761538));
    }
    if (str.equals("shakeapp"))
    {
      paramas.setNickname(localContext.getString(2131761598));
      paramas.BF(localContext.getString(2131761599));
      paramas.BG(localContext.getString(2131761600));
    }
    if (str.equals("lbsapp"))
    {
      paramas.setNickname(localContext.getString(2131761559));
      paramas.BF(localContext.getString(2131761560));
      paramas.BG(localContext.getString(2131761561));
    }
    if (str.equals("medianote"))
    {
      paramas.setNickname(localContext.getString(2131761568));
      paramas.BF(localContext.getString(2131761569));
      paramas.BG(localContext.getString(2131761570));
    }
    if (str.equals("newsapp"))
    {
      paramas.setNickname(localContext.getString(2131761594));
      paramas.BF(localContext.getString(2131761595));
      paramas.BG(localContext.getString(2131761596));
    }
    if (str.equals("facebookapp"))
    {
      paramas.setNickname(localContext.getString(2131761545));
      paramas.BF(localContext.getString(2131761546));
      paramas.BG(localContext.getString(2131761547));
    }
    if (str.equals("qqfriend"))
    {
      paramas.setNickname(localContext.getString(2131761583));
      paramas.BF(localContext.getString(2131761584));
      paramas.BG(localContext.getString(2131761585));
    }
    if (str.equals("masssendapp"))
    {
      paramas.setNickname(localContext.getString(2131761565));
      paramas.BF(localContext.getString(2131761566));
      paramas.BG(localContext.getString(2131761567));
    }
    if (str.equals("feedsapp"))
    {
      paramas.setNickname(localContext.getString(2131761548));
      paramas.BF(localContext.getString(2131761549));
      paramas.BG(localContext.getString(2131761550));
    }
    if (str.equals("fmessage"))
    {
      paramas.setNickname(localContext.getString(2131761551));
      paramas.BF(localContext.getString(2131761552));
      paramas.BG(localContext.getString(2131761553));
    }
    if (str.equals("voipapp"))
    {
      paramas.setNickname(localContext.getString(2131761608));
      paramas.BF(localContext.getString(2131761609));
      paramas.BG(localContext.getString(2131761610));
    }
    if (str.equals("officialaccounts"))
    {
      paramas.setNickname(localContext.getString(2131761576));
      paramas.BF(localContext.getString(2131761577));
      paramas.BG(localContext.getString(2131761578));
    }
    if (str.equals("findersayhisessionholder"))
    {
      paramas.setNickname(localContext.getString(2131761579));
      paramas.BF(localContext.getString(2131761580));
      paramas.BG(localContext.getString(2131761581));
    }
    if (str.equals("helper_entry"))
    {
      paramas.setNickname(localContext.getString(2131761556));
      paramas.BF(localContext.getString(2131761557));
      paramas.BG(localContext.getString(2131761558));
    }
    if (str.equals("cardpackage"))
    {
      paramas.setNickname(localContext.getString(2131761539));
      paramas.BF(localContext.getString(2131761540));
      paramas.BG(localContext.getString(2131761541));
    }
    if (str.equals("voicevoipapp"))
    {
      paramas.setNickname(localContext.getString(2131761611));
      paramas.BF(localContext.getString(2131761612));
      paramas.BG(localContext.getString(2131761613));
    }
    if (str.equals("voiceinputapp"))
    {
      paramas.setNickname(localContext.getString(2131761605));
      paramas.BF(localContext.getString(2131761606));
      paramas.BG(localContext.getString(2131761607));
    }
    if (str.equals("qqmail"))
    {
      paramas.setNickname(localContext.getString(2131761586));
      paramas.BF(localContext.getString(2131761587));
      paramas.BG(localContext.getString(2131761588));
    }
    if (str.equals("linkedinplugin"))
    {
      paramas.setNickname(localContext.getString(2131761562));
      paramas.BF(localContext.getString(2131761563));
      paramas.BG(localContext.getString(2131761564));
    }
    if (str.equals("notifymessage"))
    {
      paramas.setNickname(localContext.getString(2131761573));
      paramas.BF(localContext.getString(2131761574));
      paramas.BG(localContext.getString(2131761575));
    }
    if (str.equals("appbrandcustomerservicemsg"))
    {
      paramas.setNickname(localContext.getString(2131761530));
      paramas.BF(localContext.getString(2131761531));
      paramas.BG(localContext.getString(2131761532));
    }
    if (str.equals("downloaderapp"))
    {
      paramas.setNickname(localContext.getString(2131761542));
      paramas.BF(localContext.getString(2131761543));
      paramas.BG(localContext.getString(2131761544));
    }
    if (str.equals("appbrand_notify_message"))
    {
      paramas.setNickname(localContext.getString(2131761533));
      paramas.BF(localContext.getString(2131761534));
      paramas.BG(localContext.getString(2131761535));
    }
    AppMethodBeat.o(20320);
  }
  
  static int a(boolean paramBoolean1, String paramString, boolean paramBoolean2)
  {
    int i = 3;
    AppMethodBeat.i(20318);
    as localas2 = c.aSN().Kn(paramString);
    as localas1 = localas2;
    if (localas2 == null) {
      localas1 = new as();
    }
    if ((int)localas1.gMZ == 0)
    {
      localas1.setUsername(paramString);
      localas1.aqQ();
      M(localas1);
      if (paramBoolean2) {
        i = 4;
      }
      localas1.ni(i);
      localas1.aqZ();
      c.aSN().ap(localas1);
      AppMethodBeat.o(20318);
      return 1;
    }
    if (paramBoolean1)
    {
      localas1.aqZ();
      c.aSN().c(paramString, localas1);
      AppMethodBeat.o(20318);
      return 2;
    }
    AppMethodBeat.o(20318);
    return 3;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.model.ak
 * JD-Core Version:    0.7.0.1
 */