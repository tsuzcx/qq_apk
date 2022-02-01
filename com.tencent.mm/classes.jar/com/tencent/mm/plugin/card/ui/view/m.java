package com.tencent.mm.plugin.card.ui.view;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.card.base.b;
import com.tencent.mm.plugin.card.d.r;
import com.tencent.mm.plugin.card.model.am;
import com.tencent.mm.plugin.card.model.i;
import com.tencent.mm.plugin.card.model.j;
import com.tencent.mm.plugin.card.model.k;
import com.tencent.mm.protocal.protobuf.aai;
import com.tencent.mm.protocal.protobuf.st;
import com.tencent.mm.protocal.protobuf.tu;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.aw;
import com.tencent.mm.sdk.platformtools.bu;

public final class m
  extends g
{
  public final ab bZM()
  {
    AppMethodBeat.i(113686);
    n localn = new n(this, this.oDq);
    AppMethodBeat.o(113686);
    return localn;
  }
  
  public final ab bZN()
  {
    AppMethodBeat.i(113687);
    f localf = new f(this, this.oDq);
    AppMethodBeat.o(113687);
    return localf;
  }
  
  public final ab bZO()
  {
    AppMethodBeat.i(113688);
    t localt = new t(this, this.oDq);
    AppMethodBeat.o(113688);
    return localt;
  }
  
  public final String e(com.tencent.mm.plugin.card.d.c paramc)
  {
    AppMethodBeat.i(113685);
    ae.i("MicroMsg.CarDynamicCodeView", "code from dynamic offline");
    com.tencent.mm.plugin.card.b.g localg = am.bWs();
    Object localObject2 = this.oDm;
    Object localObject1 = "";
    if (localObject2 == null)
    {
      ae.e("MicroMsg.CardDynamicQrcodeOfflineMgr", "get code is failure! cardInfo is null");
      paramc = (com.tencent.mm.plugin.card.d.c)localObject1;
    }
    for (;;)
    {
      AppMethodBeat.o(113685);
      return paramc;
      localg.bVv();
      localg.oDu = paramc;
      Object localObject3 = ((b)localObject2).bVg();
      localObject1 = am.bWq().db.rawQuery("select count(1) from CardQrCodeDataInfo where card_id =? AND status=0", new String[] { localObject3 });
      int i;
      if (localObject1 != null)
      {
        ((Cursor)localObject1).moveToFirst();
        i = ((Cursor)localObject1).getInt(0);
        ((Cursor)localObject1).close();
        if (i != 0) {
          break label169;
        }
        ae.e("MicroMsg.CardDynamicQrcodeOfflineMgr", "can not getFrom db！db is empty!");
        i = 0;
      }
      for (;;)
      {
        if (i != 0) {
          break label270;
        }
        ae.i("MicroMsg.CardDynamicQrcodeOfflineMgr", "can not getFrom db！ request doNetSceneGetDynamicQrcode!");
        localg.a((b)localObject2, r.oWp);
        AppMethodBeat.o(113685);
        return "";
        i = 0;
        break;
        label169:
        localObject1 = am.bWr().Zg((String)localObject3);
        if (localObject1 != null)
        {
          if (com.tencent.mm.plugin.card.b.g.a((i)localObject1))
          {
            localg.oDu = com.tencent.mm.plugin.card.d.c.oVU;
            i = 0;
            continue;
          }
          if ((i < ((i)localObject1).field_lower_bound) && (com.tencent.mm.plugin.card.d.l.isNetworkAvailable(ak.getContext())))
          {
            ae.e("MicroMsg.CardDynamicQrcodeOfflineMgr", "can not getFrom db！ currentCodeSize < lower_bound,currentCodeSize =%d,lower_bound=%d", new Object[] { Integer.valueOf(i), Integer.valueOf(((i)localObject1).field_lower_bound) });
            localg.oDu = com.tencent.mm.plugin.card.d.c.oWa;
            i = 0;
            continue;
          }
        }
        i = 1;
      }
      label270:
      localObject1 = am.bWq().Zi(((b)localObject2).bVg());
      if (localObject1 == null)
      {
        ae.i("MicroMsg.CardDynamicQrcodeOfflineMgr", "get code is failure! db is  empty! doNetSceneGetDynamicQrcode! cardId= %s", new Object[] { ((b)localObject2).bVg() });
        localg.a((b)localObject2, r.oWp);
        AppMethodBeat.o(113685);
        return "";
      }
      k localk = am.bWq().Zj((String)localObject3);
      if ((localk != null) && (am.bWq().fa((String)localObject3, localk.field_code_id))) {
        localg.a((String)localObject3, localk.field_code_id, paramc);
      }
      localg.gkU = 0;
      ae.i("MicroMsg.CardDynamicQrcodeOfflineMgr", "update current code showing! newQrCodeData cardId= %s,codeId=%s，refreshReason=%d", new Object[] { localObject3, ((k)localObject1).field_code_id, Integer.valueOf(paramc.action) });
      localObject3 = ((b)localObject2).bVg();
      if (localObject1 == null) {
        paramc = "";
      }
      while (bu.isNullOrNil(paramc))
      {
        localg.ah(1, "");
        AppMethodBeat.o(113685);
        return "";
        paramc = com.tencent.mm.plugin.card.d.e.fg((String)localObject3, ((k)localObject1).field_code);
        localObject3 = am.bWr().Zg((String)localObject3);
        if ((localObject3 != null) && (!bu.isNullOrNil(paramc)) && (((i)localObject3).field_need_insert_show_timestamp) && (!bu.isNullOrNil(((i)localObject3).field_show_timestamp_encrypt_key)))
        {
          ae.i("MicroMsg.CardDynamicQrcodeOfflineMgr", "getCodeData is need insert show timestamp! code signTimestamp!");
          paramc = com.tencent.mm.plugin.card.d.e.fi(paramc, ((i)localObject3).field_show_timestamp_encrypt_key);
        }
        else
        {
          ae.i("MicroMsg.CardDynamicQrcodeOfflineMgr", "getCodeData only decrypt qrcode!");
        }
      }
      ((k)localObject1).field_status = 1;
      if (!am.bWq().update((com.tencent.mm.sdk.e.c)localObject1, new String[] { "card_id", "code_id" })) {
        ae.e("MicroMsg.CardQrCodeDataInfoStorage", "update qrCodeData  failure! card_id = %s, code_id = %s ,status = %d", new Object[] { ((k)localObject1).field_card_id, ((k)localObject1).field_code_id, Integer.valueOf(((k)localObject1).field_status) });
      }
      for (;;)
      {
        localObject1 = am.bWs();
        localObject2 = ((b)localObject2).bVg();
        localObject2 = am.bWr().Zg((String)localObject2);
        if (localObject2 != null) {
          break label690;
        }
        ae.e("MicroMsg.CardDynamicQrcodeOfflineMgr", "startRequestCodeTimer failure! CardQrCodeConfi is null!");
        break;
        ae.i("MicroMsg.CardQrCodeDataInfoStorage", "update qrCodeData  success! card_id = %s, code_id = %s ,status = %d", new Object[] { ((k)localObject1).field_card_id, ((k)localObject1).field_code_id, Integer.valueOf(((k)localObject1).field_status) });
      }
      label690:
      long l = ((i)localObject2).field_show_expire_interval * 1000;
      ae.i("MicroMsg.CardDynamicQrcodeOfflineMgr", "startRefreshCodeTimer refreshTime: ".concat(String.valueOf(l)));
      ((com.tencent.mm.plugin.card.b.g)localObject1).oDv.ay(l, l);
    }
  }
  
  public final boolean f(b paramb)
  {
    AppMethodBeat.i(113684);
    if (this.oDm == null)
    {
      ae.i("MicroMsg.CarDynamicCodeView", "isNeedUpdateViewAgain mCardInfo is null！");
      AppMethodBeat.o(113684);
      return true;
    }
    if (paramb == null)
    {
      ae.i("MicroMsg.CarDynamicCodeView", "isNeedUpdateViewAgain false  newCardInfo null！");
      AppMethodBeat.o(113684);
      return false;
    }
    if (this.oDm.bVd().Gid != paramb.bVd().Gid)
    {
      ae.i("MicroMsg.CarDynamicCodeView", "isNeedUpdateViewAgain is_commom_card is different！");
      AppMethodBeat.o(113684);
      return true;
    }
    aai localaai1 = this.oDm.bVd().Gic;
    aai localaai2 = paramb.bVd().Gic;
    if (((localaai1 == null) && (localaai2 != null)) || ((localaai1 != null) && (localaai2 == null)))
    {
      ae.i("MicroMsg.CarDynamicCodeView", "isNeedUpdateViewAgain unavailable_qrcode_field is different！");
      AppMethodBeat.o(113684);
      return true;
    }
    if ((localaai1 != null) && (localaai2 != null) && (localaai1.title != null) && (localaai2.title != null) && (localaai1.title.equals(localaai2.title)))
    {
      ae.i("MicroMsg.CarDynamicCodeView", "isNeedUpdateViewAgain unavailable_qrcode_field title is different！");
      AppMethodBeat.o(113684);
      return true;
    }
    localaai1 = this.oDm.bVc().GkB;
    paramb = paramb.bVc().GkB;
    if (((localaai1 == null) && (paramb != null)) || ((localaai1 != null) && (paramb == null)))
    {
      ae.i("MicroMsg.CarDynamicCodeView", "isNeedUpdateViewAgain pay_and_qrcode_field  is diffrent！");
      AppMethodBeat.o(113684);
      return true;
    }
    if ((localaai1 != null) && (paramb != null) && (localaai1.title != null) && (paramb.title != null) && (!localaai1.title.equals(paramb.title)))
    {
      ae.i("MicroMsg.CarDynamicCodeView", "isNeedUpdateViewAgain pay_and_qrcode_field title is diffrent！");
      AppMethodBeat.o(113684);
      return true;
    }
    if ((localaai1 != null) && (paramb != null) && (localaai1.oEq != null) && (paramb.oEq != null) && (!localaai1.oEq.equals(paramb.oEq)))
    {
      ae.i("MicroMsg.CarDynamicCodeView", "isNeedUpdateViewAgain pay_and_qrcode_field aux_title  is diffrent！");
      AppMethodBeat.o(113684);
      return true;
    }
    AppMethodBeat.o(113684);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.card.ui.view.m
 * JD-Core Version:    0.7.0.1
 */