package com.tencent.mm.model;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.av;
import com.tencent.mm.n.b;
import com.tencent.mm.storage.bj;
import com.tencent.mm.storage.bk;

public final class ae
{
  private c hnt;
  
  public ae(c paramc)
  {
    this.hnt = paramc;
  }
  
  public static void E(com.tencent.mm.storage.ai paramai)
  {
    AppMethodBeat.i(20319);
    com.tencent.mm.storage.ai localai = paramai;
    if (paramai == null) {
      localai = new com.tencent.mm.storage.ai();
    }
    if ((int)localai.fLJ == 0)
    {
      localai.setUsername("filehelper");
      az.ayM();
      if (c.awG().aNI(localai.field_username) != null) {
        break label83;
      }
      localai.aag();
    }
    for (;;)
    {
      localai.jG(3);
      az.ayM();
      c.awB().af(localai);
      AppMethodBeat.o(20319);
      return;
      label83:
      localai.aaf();
    }
  }
  
  static void F(com.tencent.mm.storage.ai paramai)
  {
    AppMethodBeat.i(20320);
    String str = paramai.field_username;
    Context localContext = com.tencent.mm.sdk.platformtools.ai.getContext();
    if (str.equals("qqsync"))
    {
      paramai.qj(localContext.getString(2131760205));
      paramai.qk(localContext.getString(2131760206));
      paramai.ql(localContext.getString(2131760207));
    }
    if (str.equals("floatbottle"))
    {
      paramai.qj(localContext.getString(2131760154));
      paramai.qk(localContext.getString(2131760155));
      paramai.ql(localContext.getString(2131760156));
    }
    if (str.equals("shakeapp"))
    {
      paramai.qj(localContext.getString(2131760212));
      paramai.qk(localContext.getString(2131760213));
      paramai.ql(localContext.getString(2131760214));
    }
    if (str.equals("lbsapp"))
    {
      paramai.qj(localContext.getString(2131760177));
      paramai.qk(localContext.getString(2131760178));
      paramai.ql(localContext.getString(2131760179));
    }
    if (str.equals("medianote"))
    {
      paramai.qj(localContext.getString(2131760186));
      paramai.qk(localContext.getString(2131760187));
      paramai.ql(localContext.getString(2131760188));
    }
    if (str.equals("newsapp"))
    {
      paramai.qj(localContext.getString(2131760208));
      paramai.qk(localContext.getString(2131760209));
      paramai.ql(localContext.getString(2131760210));
    }
    if (str.equals("facebookapp"))
    {
      paramai.qj(localContext.getString(2131760163));
      paramai.qk(localContext.getString(2131760164));
      paramai.ql(localContext.getString(2131760165));
    }
    if (str.equals("qqfriend"))
    {
      paramai.qj(localContext.getString(2131760197));
      paramai.qk(localContext.getString(2131760198));
      paramai.ql(localContext.getString(2131760199));
    }
    if (str.equals("masssendapp"))
    {
      paramai.qj(localContext.getString(2131760183));
      paramai.qk(localContext.getString(2131760184));
      paramai.ql(localContext.getString(2131760185));
    }
    if (str.equals("feedsapp"))
    {
      paramai.qj(localContext.getString(2131760166));
      paramai.qk(localContext.getString(2131760167));
      paramai.ql(localContext.getString(2131760168));
    }
    if (str.equals("fmessage"))
    {
      paramai.qj(localContext.getString(2131760169));
      paramai.qk(localContext.getString(2131760170));
      paramai.ql(localContext.getString(2131760171));
    }
    if (str.equals("voipapp"))
    {
      paramai.qj(localContext.getString(2131760222));
      paramai.qk(localContext.getString(2131760223));
      paramai.ql(localContext.getString(2131760224));
    }
    if (str.equals("officialaccounts"))
    {
      paramai.qj(localContext.getString(2131760193));
      paramai.qk(localContext.getString(2131760194));
      paramai.ql(localContext.getString(2131760195));
    }
    if (str.equals("helper_entry"))
    {
      paramai.qj(localContext.getString(2131760174));
      paramai.qk(localContext.getString(2131760175));
      paramai.ql(localContext.getString(2131760176));
    }
    if (str.equals("cardpackage"))
    {
      paramai.qj(localContext.getString(2131760157));
      paramai.qk(localContext.getString(2131760158));
      paramai.ql(localContext.getString(2131760159));
    }
    if (str.equals("voicevoipapp"))
    {
      paramai.qj(localContext.getString(2131760225));
      paramai.qk(localContext.getString(2131760226));
      paramai.ql(localContext.getString(2131760227));
    }
    if (str.equals("voiceinputapp"))
    {
      paramai.qj(localContext.getString(2131760219));
      paramai.qk(localContext.getString(2131760220));
      paramai.ql(localContext.getString(2131760221));
    }
    if (str.equals("qqmail"))
    {
      paramai.qj(localContext.getString(2131760200));
      paramai.qk(localContext.getString(2131760201));
      paramai.ql(localContext.getString(2131760202));
    }
    if (str.equals("linkedinplugin"))
    {
      paramai.qj(localContext.getString(2131760180));
      paramai.qk(localContext.getString(2131760181));
      paramai.ql(localContext.getString(2131760182));
    }
    if (str.equals("notifymessage"))
    {
      paramai.qj(localContext.getString(2131760190));
      paramai.qk(localContext.getString(2131760191));
      paramai.ql(localContext.getString(2131760192));
    }
    if (str.equals("appbrandcustomerservicemsg"))
    {
      paramai.qj(localContext.getString(2131760148));
      paramai.qk(localContext.getString(2131760149));
      paramai.ql(localContext.getString(2131760150));
    }
    if (str.equals("downloaderapp"))
    {
      paramai.qj(localContext.getString(2131760160));
      paramai.qk(localContext.getString(2131760161));
      paramai.ql(localContext.getString(2131760162));
    }
    if (str.equals("appbrand_notify_message"))
    {
      paramai.qj(localContext.getString(2131760151));
      paramai.qk(localContext.getString(2131760152));
      paramai.ql(localContext.getString(2131760153));
    }
    AppMethodBeat.o(20320);
  }
  
  static int a(boolean paramBoolean1, String paramString, boolean paramBoolean2)
  {
    int i = 3;
    AppMethodBeat.i(20318);
    com.tencent.mm.storage.ai localai2 = c.awB().aNt(paramString);
    com.tencent.mm.storage.ai localai1 = localai2;
    if (localai2 == null) {
      localai1 = new com.tencent.mm.storage.ai();
    }
    if ((int)localai1.fLJ == 0)
    {
      localai1.setUsername(paramString);
      localai1.aaf();
      F(localai1);
      if (paramBoolean2) {
        i = 4;
      }
      localai1.jG(i);
      localai1.aao();
      c.awB().ag(localai1);
      AppMethodBeat.o(20318);
      return 1;
    }
    if (paramBoolean1)
    {
      localai1.aao();
      c.awB().c(paramString, localai1);
      AppMethodBeat.o(20318);
      return 2;
    }
    AppMethodBeat.o(20318);
    return 3;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.model.ae
 * JD-Core Version:    0.7.0.1
 */