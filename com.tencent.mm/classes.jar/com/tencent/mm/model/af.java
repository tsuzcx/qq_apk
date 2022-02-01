package com.tencent.mm.model;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.aw;
import com.tencent.mm.o.b;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.storage.am;
import com.tencent.mm.storage.bp;
import com.tencent.mm.storage.bq;

public final class af
{
  private c hFL;
  
  public af(c paramc)
  {
    this.hFL = paramc;
  }
  
  public static void E(am paramam)
  {
    AppMethodBeat.i(20319);
    am localam = paramam;
    if (paramam == null) {
      localam = new am();
    }
    if ((int)localam.gfj == 0)
    {
      localam.setUsername("filehelper");
      ba.aBQ();
      if (c.azv().aTz(localam.field_username) != null) {
        break label83;
      }
      localam.acI();
    }
    for (;;)
    {
      localam.ke(3);
      ba.aBQ();
      c.azp().af(localam);
      AppMethodBeat.o(20319);
      return;
      label83:
      localam.acH();
    }
  }
  
  static void F(am paramam)
  {
    AppMethodBeat.i(20320);
    String str = paramam.field_username;
    Context localContext = aj.getContext();
    if (str.equals("qqsync"))
    {
      paramam.sT(localContext.getString(2131760205));
      paramam.sU(localContext.getString(2131760206));
      paramam.sV(localContext.getString(2131760207));
    }
    if (str.equals("floatbottle"))
    {
      paramam.sT(localContext.getString(2131760154));
      paramam.sU(localContext.getString(2131760155));
      paramam.sV(localContext.getString(2131760156));
    }
    if (str.equals("shakeapp"))
    {
      paramam.sT(localContext.getString(2131760212));
      paramam.sU(localContext.getString(2131760213));
      paramam.sV(localContext.getString(2131760214));
    }
    if (str.equals("lbsapp"))
    {
      paramam.sT(localContext.getString(2131760177));
      paramam.sU(localContext.getString(2131760178));
      paramam.sV(localContext.getString(2131760179));
    }
    if (str.equals("medianote"))
    {
      paramam.sT(localContext.getString(2131760186));
      paramam.sU(localContext.getString(2131760187));
      paramam.sV(localContext.getString(2131760188));
    }
    if (str.equals("newsapp"))
    {
      paramam.sT(localContext.getString(2131760208));
      paramam.sU(localContext.getString(2131760209));
      paramam.sV(localContext.getString(2131760210));
    }
    if (str.equals("facebookapp"))
    {
      paramam.sT(localContext.getString(2131760163));
      paramam.sU(localContext.getString(2131760164));
      paramam.sV(localContext.getString(2131760165));
    }
    if (str.equals("qqfriend"))
    {
      paramam.sT(localContext.getString(2131760197));
      paramam.sU(localContext.getString(2131760198));
      paramam.sV(localContext.getString(2131760199));
    }
    if (str.equals("masssendapp"))
    {
      paramam.sT(localContext.getString(2131760183));
      paramam.sU(localContext.getString(2131760184));
      paramam.sV(localContext.getString(2131760185));
    }
    if (str.equals("feedsapp"))
    {
      paramam.sT(localContext.getString(2131760166));
      paramam.sU(localContext.getString(2131760167));
      paramam.sV(localContext.getString(2131760168));
    }
    if (str.equals("fmessage"))
    {
      paramam.sT(localContext.getString(2131760169));
      paramam.sU(localContext.getString(2131760170));
      paramam.sV(localContext.getString(2131760171));
    }
    if (str.equals("voipapp"))
    {
      paramam.sT(localContext.getString(2131760222));
      paramam.sU(localContext.getString(2131760223));
      paramam.sV(localContext.getString(2131760224));
    }
    if (str.equals("officialaccounts"))
    {
      paramam.sT(localContext.getString(2131760193));
      paramam.sU(localContext.getString(2131760194));
      paramam.sV(localContext.getString(2131760195));
    }
    if (str.equals("findersayhisessionholder"))
    {
      paramam.sT(localContext.getString(2131766907));
      paramam.sU(localContext.getString(2131766908));
      paramam.sV(localContext.getString(2131766909));
    }
    if (str.equals("helper_entry"))
    {
      paramam.sT(localContext.getString(2131760174));
      paramam.sU(localContext.getString(2131760175));
      paramam.sV(localContext.getString(2131760176));
    }
    if (str.equals("cardpackage"))
    {
      paramam.sT(localContext.getString(2131760157));
      paramam.sU(localContext.getString(2131760158));
      paramam.sV(localContext.getString(2131760159));
    }
    if (str.equals("voicevoipapp"))
    {
      paramam.sT(localContext.getString(2131760225));
      paramam.sU(localContext.getString(2131760226));
      paramam.sV(localContext.getString(2131760227));
    }
    if (str.equals("voiceinputapp"))
    {
      paramam.sT(localContext.getString(2131760219));
      paramam.sU(localContext.getString(2131760220));
      paramam.sV(localContext.getString(2131760221));
    }
    if (str.equals("qqmail"))
    {
      paramam.sT(localContext.getString(2131760200));
      paramam.sU(localContext.getString(2131760201));
      paramam.sV(localContext.getString(2131760202));
    }
    if (str.equals("linkedinplugin"))
    {
      paramam.sT(localContext.getString(2131760180));
      paramam.sU(localContext.getString(2131760181));
      paramam.sV(localContext.getString(2131760182));
    }
    if (str.equals("notifymessage"))
    {
      paramam.sT(localContext.getString(2131760190));
      paramam.sU(localContext.getString(2131760191));
      paramam.sV(localContext.getString(2131760192));
    }
    if (str.equals("appbrandcustomerservicemsg"))
    {
      paramam.sT(localContext.getString(2131760148));
      paramam.sU(localContext.getString(2131760149));
      paramam.sV(localContext.getString(2131760150));
    }
    if (str.equals("downloaderapp"))
    {
      paramam.sT(localContext.getString(2131760160));
      paramam.sU(localContext.getString(2131760161));
      paramam.sV(localContext.getString(2131760162));
    }
    if (str.equals("appbrand_notify_message"))
    {
      paramam.sT(localContext.getString(2131760151));
      paramam.sU(localContext.getString(2131760152));
      paramam.sV(localContext.getString(2131760153));
    }
    AppMethodBeat.o(20320);
  }
  
  static int a(boolean paramBoolean1, String paramString, boolean paramBoolean2)
  {
    int i = 3;
    AppMethodBeat.i(20318);
    am localam2 = c.azp().Bf(paramString);
    am localam1 = localam2;
    if (localam2 == null) {
      localam1 = new am();
    }
    if ((int)localam1.gfj == 0)
    {
      localam1.setUsername(paramString);
      localam1.acH();
      F(localam1);
      if (paramBoolean2) {
        i = 4;
      }
      localam1.ke(i);
      localam1.acQ();
      c.azp().ag(localam1);
      AppMethodBeat.o(20318);
      return 1;
    }
    if (paramBoolean1)
    {
      localam1.acQ();
      c.azp().c(paramString, localam1);
      AppMethodBeat.o(20318);
      return 2;
    }
    AppMethodBeat.o(20318);
    return 3;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.model.af
 * JD-Core Version:    0.7.0.1
 */