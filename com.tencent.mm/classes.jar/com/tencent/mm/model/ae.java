package com.tencent.mm.model;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.au;
import com.tencent.mm.n.b;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.storage.af;
import com.tencent.mm.storage.bg;
import com.tencent.mm.storage.bh;

public final class ae
{
  private c gMT;
  
  public ae(c paramc)
  {
    this.gMT = paramc;
  }
  
  public static void D(af paramaf)
  {
    AppMethodBeat.i(20319);
    af localaf = paramaf;
    if (paramaf == null) {
      localaf = new af();
    }
    if ((int)localaf.fId == 0)
    {
      localaf.setUsername("filehelper");
      az.arV();
      if (c.apR().aIn(localaf.field_username) != null) {
        break label83;
      }
      localaf.Zl();
    }
    for (;;)
    {
      localaf.jI(3);
      az.arV();
      c.apM().ae(localaf);
      AppMethodBeat.o(20319);
      return;
      label83:
      localaf.Zk();
    }
  }
  
  static void E(af paramaf)
  {
    AppMethodBeat.i(20320);
    String str = paramaf.field_username;
    Context localContext = aj.getContext();
    if (str.equals("qqsync"))
    {
      paramaf.nd(localContext.getString(2131760205));
      paramaf.ne(localContext.getString(2131760206));
      paramaf.nf(localContext.getString(2131760207));
    }
    if (str.equals("floatbottle"))
    {
      paramaf.nd(localContext.getString(2131760154));
      paramaf.ne(localContext.getString(2131760155));
      paramaf.nf(localContext.getString(2131760156));
    }
    if (str.equals("shakeapp"))
    {
      paramaf.nd(localContext.getString(2131760212));
      paramaf.ne(localContext.getString(2131760213));
      paramaf.nf(localContext.getString(2131760214));
    }
    if (str.equals("lbsapp"))
    {
      paramaf.nd(localContext.getString(2131760177));
      paramaf.ne(localContext.getString(2131760178));
      paramaf.nf(localContext.getString(2131760179));
    }
    if (str.equals("medianote"))
    {
      paramaf.nd(localContext.getString(2131760186));
      paramaf.ne(localContext.getString(2131760187));
      paramaf.nf(localContext.getString(2131760188));
    }
    if (str.equals("newsapp"))
    {
      paramaf.nd(localContext.getString(2131760208));
      paramaf.ne(localContext.getString(2131760209));
      paramaf.nf(localContext.getString(2131760210));
    }
    if (str.equals("facebookapp"))
    {
      paramaf.nd(localContext.getString(2131760163));
      paramaf.ne(localContext.getString(2131760164));
      paramaf.nf(localContext.getString(2131760165));
    }
    if (str.equals("qqfriend"))
    {
      paramaf.nd(localContext.getString(2131760197));
      paramaf.ne(localContext.getString(2131760198));
      paramaf.nf(localContext.getString(2131760199));
    }
    if (str.equals("masssendapp"))
    {
      paramaf.nd(localContext.getString(2131760183));
      paramaf.ne(localContext.getString(2131760184));
      paramaf.nf(localContext.getString(2131760185));
    }
    if (str.equals("feedsapp"))
    {
      paramaf.nd(localContext.getString(2131760166));
      paramaf.ne(localContext.getString(2131760167));
      paramaf.nf(localContext.getString(2131760168));
    }
    if (str.equals("fmessage"))
    {
      paramaf.nd(localContext.getString(2131760169));
      paramaf.ne(localContext.getString(2131760170));
      paramaf.nf(localContext.getString(2131760171));
    }
    if (str.equals("voipapp"))
    {
      paramaf.nd(localContext.getString(2131760222));
      paramaf.ne(localContext.getString(2131760223));
      paramaf.nf(localContext.getString(2131760224));
    }
    if (str.equals("officialaccounts"))
    {
      paramaf.nd(localContext.getString(2131760193));
      paramaf.ne(localContext.getString(2131760194));
      paramaf.nf(localContext.getString(2131760195));
    }
    if (str.equals("helper_entry"))
    {
      paramaf.nd(localContext.getString(2131760174));
      paramaf.ne(localContext.getString(2131760175));
      paramaf.nf(localContext.getString(2131760176));
    }
    if (str.equals("cardpackage"))
    {
      paramaf.nd(localContext.getString(2131760157));
      paramaf.ne(localContext.getString(2131760158));
      paramaf.nf(localContext.getString(2131760159));
    }
    if (str.equals("voicevoipapp"))
    {
      paramaf.nd(localContext.getString(2131760225));
      paramaf.ne(localContext.getString(2131760226));
      paramaf.nf(localContext.getString(2131760227));
    }
    if (str.equals("voiceinputapp"))
    {
      paramaf.nd(localContext.getString(2131760219));
      paramaf.ne(localContext.getString(2131760220));
      paramaf.nf(localContext.getString(2131760221));
    }
    if (str.equals("qqmail"))
    {
      paramaf.nd(localContext.getString(2131760200));
      paramaf.ne(localContext.getString(2131760201));
      paramaf.nf(localContext.getString(2131760202));
    }
    if (str.equals("linkedinplugin"))
    {
      paramaf.nd(localContext.getString(2131760180));
      paramaf.ne(localContext.getString(2131760181));
      paramaf.nf(localContext.getString(2131760182));
    }
    if (str.equals("notifymessage"))
    {
      paramaf.nd(localContext.getString(2131760190));
      paramaf.ne(localContext.getString(2131760191));
      paramaf.nf(localContext.getString(2131760192));
    }
    if (str.equals("appbrandcustomerservicemsg"))
    {
      paramaf.nd(localContext.getString(2131760148));
      paramaf.ne(localContext.getString(2131760149));
      paramaf.nf(localContext.getString(2131760150));
    }
    if (str.equals("downloaderapp"))
    {
      paramaf.nd(localContext.getString(2131760160));
      paramaf.ne(localContext.getString(2131760161));
      paramaf.nf(localContext.getString(2131760162));
    }
    if (str.equals("appbrand_notify_message"))
    {
      paramaf.nd(localContext.getString(2131760151));
      paramaf.ne(localContext.getString(2131760152));
      paramaf.nf(localContext.getString(2131760153));
    }
    AppMethodBeat.o(20320);
  }
  
  static int a(boolean paramBoolean1, String paramString, boolean paramBoolean2)
  {
    int i = 3;
    AppMethodBeat.i(20318);
    af localaf2 = c.apM().aHY(paramString);
    af localaf1 = localaf2;
    if (localaf2 == null) {
      localaf1 = new af();
    }
    if ((int)localaf1.fId == 0)
    {
      localaf1.setUsername(paramString);
      localaf1.Zk();
      E(localaf1);
      if (paramBoolean2) {
        i = 4;
      }
      localaf1.jI(i);
      localaf1.Zt();
      c.apM().af(localaf1);
      AppMethodBeat.o(20318);
      return 1;
    }
    if (paramBoolean1)
    {
      localaf1.Zt();
      c.apM().c(paramString, localaf1);
      AppMethodBeat.o(20318);
      return 2;
    }
    AppMethodBeat.o(20318);
    return 3;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.model.ae
 * JD-Core Version:    0.7.0.1
 */