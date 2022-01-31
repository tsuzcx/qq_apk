package com.tencent.mm.plugin.appbrand.s;

import android.database.Cursor;
import com.tencent.mm.h.c.as;
import com.tencent.mm.h.c.cs;
import com.tencent.mm.model.s;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.pointers.PString;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.bn;
import com.tencent.mm.sdk.platformtools.y;
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
    Object localObject2 = null;
    Object localObject3 = ((j)com.tencent.mm.kernel.g.r(j.class)).FB().c(s.dUZ, null, "appbrandcustomerservicemsg");
    Object localObject1;
    if (localObject3 != null) {
      if ((((Cursor)localObject3).getCount() > 0) && (((Cursor)localObject3).moveToFirst()))
      {
        localObject1 = new ak();
        ((ak)localObject1).d((Cursor)localObject3);
        ((Cursor)localObject3).close();
      }
    }
    for (;;)
    {
      PInt localPInt;
      if (localObject1 != null)
      {
        y.e("MicroMsg.AppBrandConversionExtension", "The lastest app brand conversation username is %s", new Object[] { ((as)localObject1).field_username });
        localObject1 = ((j)com.tencent.mm.kernel.g.r(j.class)).bhO().HA(((as)localObject1).field_username);
        if ((localObject1 == null) || (((cs)localObject1).field_msgId <= 0L)) {
          break label454;
        }
        paramak2.ai((bi)localObject1);
        paramak2.setContent(((cs)localObject1).field_talker + ":" + ((cs)localObject1).field_content);
        paramak2.dP(Integer.toString(((bi)localObject1).getType()));
        be.b localb = ((j)com.tencent.mm.kernel.g.r(j.class)).FB().tt();
        if (localb != null)
        {
          PString localPString = new PString();
          localObject3 = new PString();
          localPInt = new PInt();
          ((bi)localObject1).ec(paramak1.field_parentRef);
          ((bi)localObject1).setContent(paramak2.field_content);
          localb.a((bi)localObject1, localPString, (PString)localObject3, localPInt, true);
          int i = ((bi)localObject1).getType();
          localObject1 = ((cs)localObject1).field_content;
          paramak1 = localObject2;
          if (!bk.bl((String)localObject1)) {}
          switch (i)
          {
          default: 
            paramak1 = localObject2;
            label307:
            localObject1 = bk.pm(localPString.value);
            if (!bk.bl(paramak1)) {
              break;
            }
          }
        }
      }
      for (paramak1 = "";; paramak1 = " " + bk.pm(paramak1))
      {
        paramak2.dQ(((String)localObject1).concat(paramak1));
        paramak2.dR(((PString)localObject3).value);
        paramak2.fB(localPInt.value);
        return;
        y.e("MicroMsg.AppBrandConversionExtension", "The lastest app brand conversation is null");
        localObject1 = ((j)com.tencent.mm.kernel.g.r(j.class)).bhO().HA(paramak1.field_username);
        break;
        localObject1 = bn.s((String)localObject1, "msg");
        paramak1 = localObject2;
        if (localObject1 == null) {
          break label307;
        }
        paramak1 = (String)((Map)localObject1).get(".msg.appmsg.title");
        y.d("MicroMsg.AppBrandConversionExtension", "[oneliang][parseConversationMsgContentTitle] title:%s", new Object[] { paramak1 });
        break label307;
      }
      label454:
      y.e("MicroMsg.AppBrandConversionExtension", "the last of msg is null'");
      paramak2.cuB();
      return;
      localObject1 = null;
      break;
      localObject1 = null;
    }
  }
  
  public final void a(ak paramak, be parambe)
  {
    if ((paramak != null) && (!bk.bl(paramak.field_username)))
    {
      parambe = paramak.field_username;
      ad localad = ((j)com.tencent.mm.kernel.g.r(j.class)).Fw().abl(parambe);
      if ((localad != null) && ((int)localad.dBe != 0)) {
        break label67;
      }
      y.e("MicroMsg.AppBrandConversionExtension", "contact is null or contactId is 0 for %s", new Object[] { parambe });
    }
    label67:
    do
    {
      return;
      if ((ad.gr(parambe)) && (!s.hx(parambe)))
      {
        y.i("MicroMsg.AppBrandConversionExtension", "this conversation is a app brand contact!");
        paramak.dS("appbrandcustomerservicemsg");
        parambe = ((j)com.tencent.mm.kernel.g.r(j.class)).FB().abv("appbrandcustomerservicemsg");
        if (parambe == null)
        {
          y.i("MicroMsg.AppBrandConversionExtension", "create parentConv");
          parambe = new ak("appbrandcustomerservicemsg");
          parambe.cuB();
          a(paramak, parambe);
          ((j)com.tencent.mm.kernel.g.r(j.class)).FB().d(parambe);
          return;
        }
        y.i("MicroMsg.AppBrandConversionExtension", "appBrandSuperConv is created");
        parambe.dS(null);
        a(paramak, parambe);
        ((j)com.tencent.mm.kernel.g.r(j.class)).FB().a(parambe, "appbrandcustomerservicemsg");
        return;
      }
    } while (!s.hT(parambe));
    y.i("MicroMsg.AppBrandConversionExtension", "appBrandSuperConv is created");
    paramak.dS(null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.s.a
 * JD-Core Version:    0.7.0.1
 */