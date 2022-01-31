package com.tencent.mm.plugin.appbrand.q;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.au;
import com.tencent.mm.g.c.dd;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.t;
import com.tencent.mm.plugin.messenger.foundation.a.a.h;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.pointers.PString;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.sdk.platformtools.br;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.ak;
import com.tencent.mm.storage.bd;
import com.tencent.mm.storage.be;
import com.tencent.mm.storage.be.a;
import com.tencent.mm.storage.be.b;
import com.tencent.mm.storage.bi;
import java.util.Map;

public final class a
  implements be.a
{
  private static void a(ak paramak1, ak paramak2)
  {
    AppMethodBeat.i(132732);
    Object localObject = aLB();
    PString localPString1;
    PInt localPInt;
    if (localObject != null)
    {
      ab.e("MicroMsg.AppBrandConversionExtension", "The lastest app brand conversation username is %s", new Object[] { ((au)localObject).field_username });
      localObject = ((j)g.E(j.class)).bPQ().Tm(((au)localObject).field_username);
      if ((localObject == null) || (((dd)localObject).field_msgId <= 0L)) {
        break label316;
      }
      paramak2.aq((bi)localObject);
      paramak2.setContent(((dd)localObject).field_talker + ":" + ((dd)localObject).field_content);
      paramak2.jV(Integer.toString(((bi)localObject).getType()));
      be.b localb = ((j)g.E(j.class)).YF().BX();
      if (localb != null)
      {
        PString localPString2 = new PString();
        localPString1 = new PString();
        localPInt = new PInt();
        ((bi)localObject).kj(paramak1.field_parentRef);
        ((bi)localObject).setContent(paramak2.field_content);
        localb.a((bi)localObject, localPString2, localPString1, localPInt, true);
        paramak1 = ac(((bi)localObject).getType(), ((dd)localObject).field_content);
        localObject = bo.nullAsNil(localPString2.value);
        if (!bo.isNullOrNil(paramak1)) {
          break label293;
        }
      }
    }
    label293:
    for (paramak1 = "";; paramak1 = " " + bo.nullAsNil(paramak1))
    {
      paramak2.jW(((String)localObject).concat(paramak1));
      paramak2.jX(localPString1.value);
      paramak2.hM(localPInt.value);
      AppMethodBeat.o(132732);
      return;
      ab.e("MicroMsg.AppBrandConversionExtension", "The lastest app brand conversation is null");
      localObject = ((j)g.E(j.class)).bPQ().Tm(paramak1.field_username);
      break;
    }
    label316:
    ab.e("MicroMsg.AppBrandConversionExtension", "the last of msg is null'");
    paramak2.dxc();
    AppMethodBeat.o(132732);
  }
  
  private static ak aLB()
  {
    AppMethodBeat.i(132731);
    Cursor localCursor = ((j)g.E(j.class)).YF().c(t.fli, null, "appbrandcustomerservicemsg");
    ak localak;
    if (localCursor != null) {
      if ((localCursor.getCount() > 0) && (localCursor.moveToFirst()))
      {
        localak = new ak();
        localak.convertFrom(localCursor);
        localCursor.close();
      }
    }
    for (;;)
    {
      AppMethodBeat.o(132731);
      return localak;
      localak = null;
      break;
      localak = null;
    }
  }
  
  private static String ac(int paramInt, String paramString)
  {
    AppMethodBeat.i(132730);
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (!bo.isNullOrNil(paramString)) {
      switch (paramInt)
      {
      default: 
        localObject1 = localObject2;
      }
    }
    for (;;)
    {
      AppMethodBeat.o(132730);
      return localObject1;
      paramString = br.F(paramString, "msg");
      localObject1 = localObject2;
      if (paramString != null)
      {
        localObject1 = (String)paramString.get(".msg.appmsg.title");
        ab.d("MicroMsg.AppBrandConversionExtension", "[oneliang][parseConversationMsgContentTitle] title:%s", new Object[] { localObject1 });
      }
    }
  }
  
  public final void a(ak paramak, be parambe)
  {
    AppMethodBeat.i(132729);
    if ((paramak != null) && (!bo.isNullOrNil(paramak.field_username)))
    {
      parambe = paramak.field_username;
      ad localad = ((j)g.E(j.class)).YA().arw(parambe);
      if ((localad == null) || ((int)localad.euF == 0))
      {
        ab.e("MicroMsg.AppBrandConversionExtension", "contact is null or contactId is 0 for %s", new Object[] { parambe });
        AppMethodBeat.o(132729);
        return;
      }
      if ((ad.na(parambe)) && (!t.og(parambe)))
      {
        ab.i("MicroMsg.AppBrandConversionExtension", "this conversation is a app brand contact!");
        paramak.jY("appbrandcustomerservicemsg");
        parambe = ((j)g.E(j.class)).YF().arH("appbrandcustomerservicemsg");
        if (parambe == null)
        {
          ab.i("MicroMsg.AppBrandConversionExtension", "create parentConv");
          parambe = new ak("appbrandcustomerservicemsg");
          parambe.dxc();
          a(paramak, parambe);
          ((j)g.E(j.class)).YF().d(parambe);
          AppMethodBeat.o(132729);
          return;
        }
        ab.i("MicroMsg.AppBrandConversionExtension", "appBrandSuperConv is created");
        parambe.jY(null);
        a(paramak, parambe);
        ((j)g.E(j.class)).YF().a(parambe, "appbrandcustomerservicemsg");
        AppMethodBeat.o(132729);
        return;
      }
      if (t.oC(parambe))
      {
        ab.i("MicroMsg.AppBrandConversionExtension", "appBrandSuperConv is created");
        paramak.jY(null);
      }
    }
    AppMethodBeat.o(132729);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.q.a
 * JD-Core Version:    0.7.0.1
 */