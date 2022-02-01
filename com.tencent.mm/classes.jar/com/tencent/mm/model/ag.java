package com.tencent.mm.model;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.aw;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.storage.an;
import com.tencent.mm.storage.bq;
import com.tencent.mm.storage.br;

public final class ag
{
  private c hID;
  
  public ag(c paramc)
  {
    this.hID = paramc;
  }
  
  public static void L(an paraman)
  {
    AppMethodBeat.i(20319);
    an localan = paraman;
    if (paraman == null) {
      localan = new an();
    }
    if ((int)localan.ght == 0)
    {
      localan.setUsername("filehelper");
      bc.aCg();
      if (c.azL().aVa(localan.field_username) != null) {
        break label83;
      }
      localan.acT();
    }
    for (;;)
    {
      localan.kg(3);
      bc.aCg();
      c.azF().am(localan);
      AppMethodBeat.o(20319);
      return;
      label83:
      localan.acS();
    }
  }
  
  static void M(an paraman)
  {
    AppMethodBeat.i(20320);
    String str = paraman.field_username;
    Context localContext = ak.getContext();
    if (str.equals("qqsync"))
    {
      paraman.to(localContext.getString(2131760205));
      paraman.tp(localContext.getString(2131760206));
      paraman.tq(localContext.getString(2131760207));
    }
    if (str.equals("floatbottle"))
    {
      paraman.to(localContext.getString(2131760154));
      paraman.tp(localContext.getString(2131760155));
      paraman.tq(localContext.getString(2131760156));
    }
    if (str.equals("shakeapp"))
    {
      paraman.to(localContext.getString(2131760212));
      paraman.tp(localContext.getString(2131760213));
      paraman.tq(localContext.getString(2131760214));
    }
    if (str.equals("lbsapp"))
    {
      paraman.to(localContext.getString(2131760177));
      paraman.tp(localContext.getString(2131760178));
      paraman.tq(localContext.getString(2131760179));
    }
    if (str.equals("medianote"))
    {
      paraman.to(localContext.getString(2131760186));
      paraman.tp(localContext.getString(2131760187));
      paraman.tq(localContext.getString(2131760188));
    }
    if (str.equals("newsapp"))
    {
      paraman.to(localContext.getString(2131760208));
      paraman.tp(localContext.getString(2131760209));
      paraman.tq(localContext.getString(2131760210));
    }
    if (str.equals("facebookapp"))
    {
      paraman.to(localContext.getString(2131760163));
      paraman.tp(localContext.getString(2131760164));
      paraman.tq(localContext.getString(2131760165));
    }
    if (str.equals("qqfriend"))
    {
      paraman.to(localContext.getString(2131760197));
      paraman.tp(localContext.getString(2131760198));
      paraman.tq(localContext.getString(2131760199));
    }
    if (str.equals("masssendapp"))
    {
      paraman.to(localContext.getString(2131760183));
      paraman.tp(localContext.getString(2131760184));
      paraman.tq(localContext.getString(2131760185));
    }
    if (str.equals("feedsapp"))
    {
      paraman.to(localContext.getString(2131760166));
      paraman.tp(localContext.getString(2131760167));
      paraman.tq(localContext.getString(2131760168));
    }
    if (str.equals("fmessage"))
    {
      paraman.to(localContext.getString(2131760169));
      paraman.tp(localContext.getString(2131760170));
      paraman.tq(localContext.getString(2131760171));
    }
    if (str.equals("voipapp"))
    {
      paraman.to(localContext.getString(2131760222));
      paraman.tp(localContext.getString(2131760223));
      paraman.tq(localContext.getString(2131760224));
    }
    if (str.equals("officialaccounts"))
    {
      paraman.to(localContext.getString(2131760193));
      paraman.tp(localContext.getString(2131760194));
      paraman.tq(localContext.getString(2131760195));
    }
    if (str.equals("findersayhisessionholder"))
    {
      paraman.to(localContext.getString(2131766907));
      paraman.tp(localContext.getString(2131766908));
      paraman.tq(localContext.getString(2131766909));
    }
    if (str.equals("helper_entry"))
    {
      paraman.to(localContext.getString(2131760174));
      paraman.tp(localContext.getString(2131760175));
      paraman.tq(localContext.getString(2131760176));
    }
    if (str.equals("cardpackage"))
    {
      paraman.to(localContext.getString(2131760157));
      paraman.tp(localContext.getString(2131760158));
      paraman.tq(localContext.getString(2131760159));
    }
    if (str.equals("voicevoipapp"))
    {
      paraman.to(localContext.getString(2131760225));
      paraman.tp(localContext.getString(2131760226));
      paraman.tq(localContext.getString(2131760227));
    }
    if (str.equals("voiceinputapp"))
    {
      paraman.to(localContext.getString(2131760219));
      paraman.tp(localContext.getString(2131760220));
      paraman.tq(localContext.getString(2131760221));
    }
    if (str.equals("qqmail"))
    {
      paraman.to(localContext.getString(2131760200));
      paraman.tp(localContext.getString(2131760201));
      paraman.tq(localContext.getString(2131760202));
    }
    if (str.equals("linkedinplugin"))
    {
      paraman.to(localContext.getString(2131760180));
      paraman.tp(localContext.getString(2131760181));
      paraman.tq(localContext.getString(2131760182));
    }
    if (str.equals("notifymessage"))
    {
      paraman.to(localContext.getString(2131760190));
      paraman.tp(localContext.getString(2131760191));
      paraman.tq(localContext.getString(2131760192));
    }
    if (str.equals("appbrandcustomerservicemsg"))
    {
      paraman.to(localContext.getString(2131760148));
      paraman.tp(localContext.getString(2131760149));
      paraman.tq(localContext.getString(2131760150));
    }
    if (str.equals("downloaderapp"))
    {
      paraman.to(localContext.getString(2131760160));
      paraman.tp(localContext.getString(2131760161));
      paraman.tq(localContext.getString(2131760162));
    }
    if (str.equals("appbrand_notify_message"))
    {
      paraman.to(localContext.getString(2131760151));
      paraman.tp(localContext.getString(2131760152));
      paraman.tq(localContext.getString(2131760153));
    }
    AppMethodBeat.o(20320);
  }
  
  static int a(boolean paramBoolean1, String paramString, boolean paramBoolean2)
  {
    int i = 3;
    AppMethodBeat.i(20318);
    an localan2 = c.azF().BH(paramString);
    an localan1 = localan2;
    if (localan2 == null) {
      localan1 = new an();
    }
    if ((int)localan1.ght == 0)
    {
      localan1.setUsername(paramString);
      localan1.acS();
      M(localan1);
      if (paramBoolean2) {
        i = 4;
      }
      localan1.kg(i);
      localan1.adb();
      c.azF().an(localan1);
      AppMethodBeat.o(20318);
      return 1;
    }
    if (paramBoolean1)
    {
      localan1.adb();
      c.azF().c(paramString, localan1);
      AppMethodBeat.o(20318);
      return 2;
    }
    AppMethodBeat.o(20318);
    return 3;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.model.ag
 * JD-Core Version:    0.7.0.1
 */