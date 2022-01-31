package com.tencent.mm.plugin.card.ui.view;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.card.base.b;
import com.tencent.mm.plugin.card.d.q;
import com.tencent.mm.plugin.card.model.am;
import com.tencent.mm.plugin.card.model.i;
import com.tencent.mm.plugin.card.model.j;
import com.tencent.mm.plugin.card.model.k;
import com.tencent.mm.protocal.protobuf.oj;
import com.tencent.mm.protocal.protobuf.pg;
import com.tencent.mm.protocal.protobuf.uo;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bo;

public final class m
  extends g
{
  public final ab bfw()
  {
    AppMethodBeat.i(88759);
    n localn = new n(this, this.jpX);
    AppMethodBeat.o(88759);
    return localn;
  }
  
  public final ab bfx()
  {
    AppMethodBeat.i(88760);
    f localf = new f(this, this.jpX);
    AppMethodBeat.o(88760);
    return localf;
  }
  
  public final ab bfy()
  {
    AppMethodBeat.i(88761);
    t localt = new t(this, this.jpX);
    AppMethodBeat.o(88761);
    return localt;
  }
  
  public final String e(com.tencent.mm.plugin.card.d.c paramc)
  {
    AppMethodBeat.i(88758);
    com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.CarDynamicCodeView", "code from dynamic offline");
    com.tencent.mm.plugin.card.b.g localg = am.bct();
    Object localObject2 = this.klk;
    Object localObject1 = "";
    if (localObject2 == null)
    {
      com.tencent.mm.sdk.platformtools.ab.e("MicroMsg.CardDynamicQrcodeOfflineMgr", "get code is failure! cardInfo is null");
      paramc = (com.tencent.mm.plugin.card.d.c)localObject1;
    }
    for (;;)
    {
      AppMethodBeat.o(88758);
      return paramc;
      localg.bbw();
      localg.klr = paramc;
      Object localObject3 = ((b)localObject2).bbh();
      localObject1 = am.bcr().db.rawQuery("select count(1) from CardQrCodeDataInfo where card_id =? AND status=0", new String[] { localObject3 });
      int i;
      if (localObject1 != null)
      {
        ((Cursor)localObject1).moveToFirst();
        i = ((Cursor)localObject1).getInt(0);
        ((Cursor)localObject1).close();
        if (i != 0) {
          break label169;
        }
        com.tencent.mm.sdk.platformtools.ab.e("MicroMsg.CardDynamicQrcodeOfflineMgr", "can not getFrom db！db is empty!");
        i = 0;
      }
      for (;;)
      {
        if (i != 0) {
          break label270;
        }
        com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.CardDynamicQrcodeOfflineMgr", "can not getFrom db！ request doNetSceneGetDynamicQrcode!");
        localg.a((b)localObject2, q.kCu);
        AppMethodBeat.o(88758);
        return "";
        i = 0;
        break;
        label169:
        localObject1 = am.bcs().HK((String)localObject3);
        if (localObject1 != null)
        {
          if (com.tencent.mm.plugin.card.b.g.a((i)localObject1))
          {
            localg.klr = com.tencent.mm.plugin.card.d.c.kBY;
            i = 0;
            continue;
          }
          if ((i < ((i)localObject1).field_lower_bound) && (com.tencent.mm.plugin.card.d.l.isNetworkAvailable(ah.getContext())))
          {
            com.tencent.mm.sdk.platformtools.ab.e("MicroMsg.CardDynamicQrcodeOfflineMgr", "can not getFrom db！ currentCodeSize < lower_bound,currentCodeSize =%d,lower_bound=%d", new Object[] { Integer.valueOf(i), Integer.valueOf(((i)localObject1).field_lower_bound) });
            localg.klr = com.tencent.mm.plugin.card.d.c.kCe;
            i = 0;
            continue;
          }
        }
        i = 1;
      }
      label270:
      localObject1 = am.bcr().HM(((b)localObject2).bbh());
      if (localObject1 == null)
      {
        com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.CardDynamicQrcodeOfflineMgr", "get code is failure! db is  empty! doNetSceneGetDynamicQrcode! cardId= %s", new Object[] { ((b)localObject2).bbh() });
        localg.a((b)localObject2, q.kCu);
        AppMethodBeat.o(88758);
        return "";
      }
      k localk = am.bcr().HN((String)localObject3);
      if ((localk != null) && (am.bcr().dp((String)localObject3, localk.field_code_id))) {
        localg.a((String)localObject3, localk.field_code_id, paramc);
      }
      localg.evn = 0;
      com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.CardDynamicQrcodeOfflineMgr", "update current code showing! newQrCodeData cardId= %s,codeId=%s，refreshReason=%d", new Object[] { localObject3, ((k)localObject1).field_code_id, Integer.valueOf(paramc.action) });
      localObject3 = ((b)localObject2).bbh();
      if (localObject1 == null) {
        paramc = "";
      }
      while (bo.isNullOrNil(paramc))
      {
        localg.S(1, "");
        AppMethodBeat.o(88758);
        return "";
        paramc = com.tencent.mm.plugin.card.d.e.dv((String)localObject3, ((k)localObject1).field_code);
        localObject3 = am.bcs().HK((String)localObject3);
        if ((localObject3 != null) && (!bo.isNullOrNil(paramc)) && (((i)localObject3).field_need_insert_show_timestamp) && (!bo.isNullOrNil(((i)localObject3).field_show_timestamp_encrypt_key)))
        {
          com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.CardDynamicQrcodeOfflineMgr", "getCodeData is need insert show timestamp! code signTimestamp!");
          paramc = com.tencent.mm.plugin.card.d.e.dx(paramc, ((i)localObject3).field_show_timestamp_encrypt_key);
        }
        else
        {
          com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.CardDynamicQrcodeOfflineMgr", "getCodeData only decrypt qrcode!");
        }
      }
      ((k)localObject1).field_status = 1;
      if (!am.bcr().update((com.tencent.mm.sdk.e.c)localObject1, new String[] { "card_id", "code_id" })) {
        com.tencent.mm.sdk.platformtools.ab.e("MicroMsg.CardQrCodeDataInfoStorage", "update qrCodeData  failure! card_id = %s, code_id = %s ,status = %d", new Object[] { ((k)localObject1).field_card_id, ((k)localObject1).field_code_id, Integer.valueOf(((k)localObject1).field_status) });
      }
      for (;;)
      {
        localObject1 = am.bct();
        localObject2 = ((b)localObject2).bbh();
        localObject2 = am.bcs().HK((String)localObject2);
        if (localObject2 != null) {
          break label690;
        }
        com.tencent.mm.sdk.platformtools.ab.e("MicroMsg.CardDynamicQrcodeOfflineMgr", "startRequestCodeTimer failure! CardQrCodeConfi is null!");
        break;
        com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.CardQrCodeDataInfoStorage", "update qrCodeData  success! card_id = %s, code_id = %s ,status = %d", new Object[] { ((k)localObject1).field_card_id, ((k)localObject1).field_code_id, Integer.valueOf(((k)localObject1).field_status) });
      }
      label690:
      long l = ((i)localObject2).field_show_expire_interval * 1000;
      com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.CardDynamicQrcodeOfflineMgr", "startRefreshCodeTimer refreshTime: ".concat(String.valueOf(l)));
      ((com.tencent.mm.plugin.card.b.g)localObject1).kls.ag(l, l);
    }
  }
  
  public final boolean f(b paramb)
  {
    AppMethodBeat.i(88757);
    if (this.klk == null)
    {
      com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.CarDynamicCodeView", "isNeedUpdateViewAgain mCardInfo is null！");
      AppMethodBeat.o(88757);
      return true;
    }
    if (paramb == null)
    {
      com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.CarDynamicCodeView", "isNeedUpdateViewAgain false  newCardInfo null！");
      AppMethodBeat.o(88757);
      return false;
    }
    if (this.klk.bbe().wEi != paramb.bbe().wEi)
    {
      com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.CarDynamicCodeView", "isNeedUpdateViewAgain is_commom_card is different！");
      AppMethodBeat.o(88757);
      return true;
    }
    uo localuo1 = this.klk.bbe().wEh;
    uo localuo2 = paramb.bbe().wEh;
    if (((localuo1 == null) && (localuo2 != null)) || ((localuo1 != null) && (localuo2 == null)))
    {
      com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.CarDynamicCodeView", "isNeedUpdateViewAgain unavailable_qrcode_field is different！");
      AppMethodBeat.o(88757);
      return true;
    }
    if ((localuo1 != null) && (localuo2 != null) && (localuo1.title != null) && (localuo2.title != null) && (localuo1.title.equals(localuo2.title)))
    {
      com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.CarDynamicCodeView", "isNeedUpdateViewAgain unavailable_qrcode_field title is different！");
      AppMethodBeat.o(88757);
      return true;
    }
    localuo1 = this.klk.bbd().wGD;
    paramb = paramb.bbd().wGD;
    if (((localuo1 == null) && (paramb != null)) || ((localuo1 != null) && (paramb == null)))
    {
      com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.CarDynamicCodeView", "isNeedUpdateViewAgain pay_and_qrcode_field  is diffrent！");
      AppMethodBeat.o(88757);
      return true;
    }
    if ((localuo1 != null) && (paramb != null) && (localuo1.title != null) && (paramb.title != null) && (!localuo1.title.equals(paramb.title)))
    {
      com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.CarDynamicCodeView", "isNeedUpdateViewAgain pay_and_qrcode_field title is diffrent！");
      AppMethodBeat.o(88757);
      return true;
    }
    if ((localuo1 != null) && (paramb != null) && (localuo1.kmo != null) && (paramb.kmo != null) && (!localuo1.kmo.equals(paramb.kmo)))
    {
      com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.CarDynamicCodeView", "isNeedUpdateViewAgain pay_and_qrcode_field aux_title  is diffrent！");
      AppMethodBeat.o(88757);
      return true;
    }
    AppMethodBeat.o(88757);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.card.ui.view.m
 * JD-Core Version:    0.7.0.1
 */