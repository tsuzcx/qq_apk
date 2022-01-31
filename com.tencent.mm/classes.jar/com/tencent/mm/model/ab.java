package com.tencent.mm.model;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.aq;
import com.tencent.mm.n.a;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.bd;
import com.tencent.mm.storage.be;

public final class ab
{
  private c flF;
  
  public ab(c paramc)
  {
    this.flF = paramc;
  }
  
  static int a(boolean paramBoolean1, String paramString, boolean paramBoolean2)
  {
    int i = 3;
    AppMethodBeat.i(16272);
    ad localad2 = c.YA().arw(paramString);
    ad localad1 = localad2;
    if (localad2 == null) {
      localad1 = new ad();
    }
    if ((int)localad1.euF == 0)
    {
      localad1.setUsername(paramString);
      localad1.Nx();
      y(localad1);
      if (paramBoolean2) {
        i = 4;
      }
      localad1.hx(i);
      localad1.NG();
      c.YA().Y(localad1);
      AppMethodBeat.o(16272);
      return 1;
    }
    if (paramBoolean1)
    {
      localad1.NG();
      c.YA().b(paramString, localad1);
      AppMethodBeat.o(16272);
      return 2;
    }
    AppMethodBeat.o(16272);
    return 3;
  }
  
  public static void x(ad paramad)
  {
    AppMethodBeat.i(16273);
    ad localad = paramad;
    if (paramad == null) {
      localad = new ad();
    }
    if ((int)localad.euF == 0)
    {
      localad.setUsername("filehelper");
      aw.aaz();
      if (c.YF().arH(localad.field_username) != null) {
        break label83;
      }
      localad.Ny();
    }
    for (;;)
    {
      localad.hx(3);
      aw.aaz();
      c.YA().X(localad);
      AppMethodBeat.o(16273);
      return;
      label83:
      localad.Nx();
    }
  }
  
  static void y(ad paramad)
  {
    AppMethodBeat.i(16274);
    String str = paramad.field_username;
    Context localContext = ah.getContext();
    if (str.equals("qqsync"))
    {
      paramad.jp(localContext.getString(2131300611));
      paramad.jq(localContext.getString(2131300612));
      paramad.jr(localContext.getString(2131300613));
    }
    if (str.equals("floatbottle"))
    {
      paramad.jp(localContext.getString(2131300560));
      paramad.jq(localContext.getString(2131300561));
      paramad.jr(localContext.getString(2131300562));
    }
    if (str.equals("shakeapp"))
    {
      paramad.jp(localContext.getString(2131300618));
      paramad.jq(localContext.getString(2131300619));
      paramad.jr(localContext.getString(2131300620));
    }
    if (str.equals("lbsapp"))
    {
      paramad.jp(localContext.getString(2131300583));
      paramad.jq(localContext.getString(2131300584));
      paramad.jr(localContext.getString(2131300585));
    }
    if (str.equals("medianote"))
    {
      paramad.jp(localContext.getString(2131300592));
      paramad.jq(localContext.getString(2131300593));
      paramad.jr(localContext.getString(2131300594));
    }
    if (str.equals("newsapp"))
    {
      paramad.jp(localContext.getString(2131300614));
      paramad.jq(localContext.getString(2131300615));
      paramad.jr(localContext.getString(2131300616));
    }
    if (str.equals("facebookapp"))
    {
      paramad.jp(localContext.getString(2131300569));
      paramad.jq(localContext.getString(2131300570));
      paramad.jr(localContext.getString(2131300571));
    }
    if (str.equals("qqfriend"))
    {
      paramad.jp(localContext.getString(2131300603));
      paramad.jq(localContext.getString(2131300604));
      paramad.jr(localContext.getString(2131300605));
    }
    if (str.equals("masssendapp"))
    {
      paramad.jp(localContext.getString(2131300589));
      paramad.jq(localContext.getString(2131300590));
      paramad.jr(localContext.getString(2131300591));
    }
    if (str.equals("feedsapp"))
    {
      paramad.jp(localContext.getString(2131300572));
      paramad.jq(localContext.getString(2131300573));
      paramad.jr(localContext.getString(2131300574));
    }
    if (str.equals("fmessage"))
    {
      paramad.jp(localContext.getString(2131300575));
      paramad.jq(localContext.getString(2131300576));
      paramad.jr(localContext.getString(2131300577));
    }
    if (str.equals("voipapp"))
    {
      paramad.jp(localContext.getString(2131300628));
      paramad.jq(localContext.getString(2131300629));
      paramad.jr(localContext.getString(2131300630));
    }
    if (str.equals("officialaccounts"))
    {
      paramad.jp(localContext.getString(2131300599));
      paramad.jq(localContext.getString(2131300600));
      paramad.jr(localContext.getString(2131300601));
    }
    if (str.equals("helper_entry"))
    {
      paramad.jp(localContext.getString(2131300580));
      paramad.jq(localContext.getString(2131300581));
      paramad.jr(localContext.getString(2131300582));
    }
    if (str.equals("cardpackage"))
    {
      paramad.jp(localContext.getString(2131300563));
      paramad.jq(localContext.getString(2131300564));
      paramad.jr(localContext.getString(2131300565));
    }
    if (str.equals("voicevoipapp"))
    {
      paramad.jp(localContext.getString(2131300631));
      paramad.jq(localContext.getString(2131300632));
      paramad.jr(localContext.getString(2131300633));
    }
    if (str.equals("voiceinputapp"))
    {
      paramad.jp(localContext.getString(2131300625));
      paramad.jq(localContext.getString(2131300626));
      paramad.jr(localContext.getString(2131300627));
    }
    if (str.equals("qqmail"))
    {
      paramad.jp(localContext.getString(2131300606));
      paramad.jq(localContext.getString(2131300607));
      paramad.jr(localContext.getString(2131300608));
    }
    if (str.equals("linkedinplugin"))
    {
      paramad.jp(localContext.getString(2131300586));
      paramad.jq(localContext.getString(2131300587));
      paramad.jr(localContext.getString(2131300588));
    }
    if (str.equals("notifymessage"))
    {
      paramad.jp(localContext.getString(2131300596));
      paramad.jq(localContext.getString(2131300597));
      paramad.jr(localContext.getString(2131300598));
    }
    if (str.equals("appbrandcustomerservicemsg"))
    {
      paramad.jp(localContext.getString(2131300557));
      paramad.jq(localContext.getString(2131300558));
      paramad.jr(localContext.getString(2131300559));
    }
    if (str.equals("downloaderapp"))
    {
      paramad.jp(localContext.getString(2131300566));
      paramad.jq(localContext.getString(2131300567));
      paramad.jr(localContext.getString(2131300568));
    }
    AppMethodBeat.o(16274);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.model.ab
 * JD-Core Version:    0.7.0.1
 */