package com.tencent.mm.plugin.card.ui.view;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.card.base.b;
import com.tencent.mm.plugin.card.d.r;
import com.tencent.mm.plugin.card.model.am;
import com.tencent.mm.plugin.card.model.i;
import com.tencent.mm.plugin.card.model.j;
import com.tencent.mm.plugin.card.model.k;
import com.tencent.mm.protocal.protobuf.qy;
import com.tencent.mm.protocal.protobuf.ry;
import com.tencent.mm.protocal.protobuf.yg;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.au;
import com.tencent.mm.sdk.platformtools.bs;

public final class m
  extends g
{
  public final ab bTS()
  {
    AppMethodBeat.i(113686);
    n localn = new n(this, this.nTt);
    AppMethodBeat.o(113686);
    return localn;
  }
  
  public final ab bTT()
  {
    AppMethodBeat.i(113687);
    f localf = new f(this, this.nTt);
    AppMethodBeat.o(113687);
    return localf;
  }
  
  public final ab bTU()
  {
    AppMethodBeat.i(113688);
    t localt = new t(this, this.nTt);
    AppMethodBeat.o(113688);
    return localt;
  }
  
  public final String e(com.tencent.mm.plugin.card.d.c paramc)
  {
    AppMethodBeat.i(113685);
    ac.i("MicroMsg.CarDynamicCodeView", "code from dynamic offline");
    com.tencent.mm.plugin.card.b.g localg = am.bQy();
    Object localObject2 = this.nTp;
    Object localObject1 = "";
    if (localObject2 == null)
    {
      ac.e("MicroMsg.CardDynamicQrcodeOfflineMgr", "get code is failure! cardInfo is null");
      paramc = (com.tencent.mm.plugin.card.d.c)localObject1;
    }
    for (;;)
    {
      AppMethodBeat.o(113685);
      return paramc;
      localg.bPB();
      localg.nTx = paramc;
      Object localObject3 = ((b)localObject2).bPm();
      localObject1 = am.bQw().db.rawQuery("select count(1) from CardQrCodeDataInfo where card_id =? AND status=0", new String[] { localObject3 });
      int i;
      if (localObject1 != null)
      {
        ((Cursor)localObject1).moveToFirst();
        i = ((Cursor)localObject1).getInt(0);
        ((Cursor)localObject1).close();
        if (i != 0) {
          break label169;
        }
        ac.e("MicroMsg.CardDynamicQrcodeOfflineMgr", "can not getFrom db！db is empty!");
        i = 0;
      }
      for (;;)
      {
        if (i != 0) {
          break label270;
        }
        ac.i("MicroMsg.CardDynamicQrcodeOfflineMgr", "can not getFrom db！ request doNetSceneGetDynamicQrcode!");
        localg.a((b)localObject2, r.oms);
        AppMethodBeat.o(113685);
        return "";
        i = 0;
        break;
        label169:
        localObject1 = am.bQx().UG((String)localObject3);
        if (localObject1 != null)
        {
          if (com.tencent.mm.plugin.card.b.g.a((i)localObject1))
          {
            localg.nTx = com.tencent.mm.plugin.card.d.c.olX;
            i = 0;
            continue;
          }
          if ((i < ((i)localObject1).field_lower_bound) && (com.tencent.mm.plugin.card.d.l.isNetworkAvailable(ai.getContext())))
          {
            ac.e("MicroMsg.CardDynamicQrcodeOfflineMgr", "can not getFrom db！ currentCodeSize < lower_bound,currentCodeSize =%d,lower_bound=%d", new Object[] { Integer.valueOf(i), Integer.valueOf(((i)localObject1).field_lower_bound) });
            localg.nTx = com.tencent.mm.plugin.card.d.c.omd;
            i = 0;
            continue;
          }
        }
        i = 1;
      }
      label270:
      localObject1 = am.bQw().UI(((b)localObject2).bPm());
      if (localObject1 == null)
      {
        ac.i("MicroMsg.CardDynamicQrcodeOfflineMgr", "get code is failure! db is  empty! doNetSceneGetDynamicQrcode! cardId= %s", new Object[] { ((b)localObject2).bPm() });
        localg.a((b)localObject2, r.oms);
        AppMethodBeat.o(113685);
        return "";
      }
      k localk = am.bQw().UJ((String)localObject3);
      if ((localk != null) && (am.bQw().eM((String)localObject3, localk.field_code_id))) {
        localg.a((String)localObject3, localk.field_code_id, paramc);
      }
      localg.fPc = 0;
      ac.i("MicroMsg.CardDynamicQrcodeOfflineMgr", "update current code showing! newQrCodeData cardId= %s,codeId=%s，refreshReason=%d", new Object[] { localObject3, ((k)localObject1).field_code_id, Integer.valueOf(paramc.action) });
      localObject3 = ((b)localObject2).bPm();
      if (localObject1 == null) {
        paramc = "";
      }
      while (bs.isNullOrNil(paramc))
      {
        localg.af(1, "");
        AppMethodBeat.o(113685);
        return "";
        paramc = com.tencent.mm.plugin.card.d.e.eS((String)localObject3, ((k)localObject1).field_code);
        localObject3 = am.bQx().UG((String)localObject3);
        if ((localObject3 != null) && (!bs.isNullOrNil(paramc)) && (((i)localObject3).field_need_insert_show_timestamp) && (!bs.isNullOrNil(((i)localObject3).field_show_timestamp_encrypt_key)))
        {
          ac.i("MicroMsg.CardDynamicQrcodeOfflineMgr", "getCodeData is need insert show timestamp! code signTimestamp!");
          paramc = com.tencent.mm.plugin.card.d.e.eU(paramc, ((i)localObject3).field_show_timestamp_encrypt_key);
        }
        else
        {
          ac.i("MicroMsg.CardDynamicQrcodeOfflineMgr", "getCodeData only decrypt qrcode!");
        }
      }
      ((k)localObject1).field_status = 1;
      if (!am.bQw().update((com.tencent.mm.sdk.e.c)localObject1, new String[] { "card_id", "code_id" })) {
        ac.e("MicroMsg.CardQrCodeDataInfoStorage", "update qrCodeData  failure! card_id = %s, code_id = %s ,status = %d", new Object[] { ((k)localObject1).field_card_id, ((k)localObject1).field_code_id, Integer.valueOf(((k)localObject1).field_status) });
      }
      for (;;)
      {
        localObject1 = am.bQy();
        localObject2 = ((b)localObject2).bPm();
        localObject2 = am.bQx().UG((String)localObject2);
        if (localObject2 != null) {
          break label690;
        }
        ac.e("MicroMsg.CardDynamicQrcodeOfflineMgr", "startRequestCodeTimer failure! CardQrCodeConfi is null!");
        break;
        ac.i("MicroMsg.CardQrCodeDataInfoStorage", "update qrCodeData  success! card_id = %s, code_id = %s ,status = %d", new Object[] { ((k)localObject1).field_card_id, ((k)localObject1).field_code_id, Integer.valueOf(((k)localObject1).field_status) });
      }
      label690:
      long l = ((i)localObject2).field_show_expire_interval * 1000;
      ac.i("MicroMsg.CardDynamicQrcodeOfflineMgr", "startRefreshCodeTimer refreshTime: ".concat(String.valueOf(l)));
      ((com.tencent.mm.plugin.card.b.g)localObject1).nTy.au(l, l);
    }
  }
  
  public final boolean f(b paramb)
  {
    AppMethodBeat.i(113684);
    if (this.nTp == null)
    {
      ac.i("MicroMsg.CarDynamicCodeView", "isNeedUpdateViewAgain mCardInfo is null！");
      AppMethodBeat.o(113684);
      return true;
    }
    if (paramb == null)
    {
      ac.i("MicroMsg.CarDynamicCodeView", "isNeedUpdateViewAgain false  newCardInfo null！");
      AppMethodBeat.o(113684);
      return false;
    }
    if (this.nTp.bPj().Eiu != paramb.bPj().Eiu)
    {
      ac.i("MicroMsg.CarDynamicCodeView", "isNeedUpdateViewAgain is_commom_card is different！");
      AppMethodBeat.o(113684);
      return true;
    }
    yg localyg1 = this.nTp.bPj().Eit;
    yg localyg2 = paramb.bPj().Eit;
    if (((localyg1 == null) && (localyg2 != null)) || ((localyg1 != null) && (localyg2 == null)))
    {
      ac.i("MicroMsg.CarDynamicCodeView", "isNeedUpdateViewAgain unavailable_qrcode_field is different！");
      AppMethodBeat.o(113684);
      return true;
    }
    if ((localyg1 != null) && (localyg2 != null) && (localyg1.title != null) && (localyg2.title != null) && (localyg1.title.equals(localyg2.title)))
    {
      ac.i("MicroMsg.CarDynamicCodeView", "isNeedUpdateViewAgain unavailable_qrcode_field title is different！");
      AppMethodBeat.o(113684);
      return true;
    }
    localyg1 = this.nTp.bPi().EkT;
    paramb = paramb.bPi().EkT;
    if (((localyg1 == null) && (paramb != null)) || ((localyg1 != null) && (paramb == null)))
    {
      ac.i("MicroMsg.CarDynamicCodeView", "isNeedUpdateViewAgain pay_and_qrcode_field  is diffrent！");
      AppMethodBeat.o(113684);
      return true;
    }
    if ((localyg1 != null) && (paramb != null) && (localyg1.title != null) && (paramb.title != null) && (!localyg1.title.equals(paramb.title)))
    {
      ac.i("MicroMsg.CarDynamicCodeView", "isNeedUpdateViewAgain pay_and_qrcode_field title is diffrent！");
      AppMethodBeat.o(113684);
      return true;
    }
    if ((localyg1 != null) && (paramb != null) && (localyg1.nUt != null) && (paramb.nUt != null) && (!localyg1.nUt.equals(paramb.nUt)))
    {
      ac.i("MicroMsg.CarDynamicCodeView", "isNeedUpdateViewAgain pay_and_qrcode_field aux_title  is diffrent！");
      AppMethodBeat.o(113684);
      return true;
    }
    AppMethodBeat.o(113684);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.card.ui.view.m
 * JD-Core Version:    0.7.0.1
 */