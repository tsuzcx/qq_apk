package com.tencent.mm.plugin.card.ui.view;

import android.database.Cursor;
import com.tencent.mm.plugin.card.base.b;
import com.tencent.mm.plugin.card.d.q;
import com.tencent.mm.plugin.card.model.i;
import com.tencent.mm.plugin.card.model.j;
import com.tencent.mm.plugin.card.model.k;
import com.tencent.mm.protocal.c.lv;
import com.tencent.mm.protocal.c.mg;
import com.tencent.mm.protocal.c.ra;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;

public final class m
  extends g
{
  public final ab aCZ()
  {
    return new n(this, this.hxN);
  }
  
  public final ab aDa()
  {
    return new f(this, this.hxN);
  }
  
  public final ab aDb()
  {
    return new t(this, this.hxN);
  }
  
  public final String e(com.tencent.mm.plugin.card.d.c paramc)
  {
    y.i("MicroMsg.CarDynamicCodeView", "code from dynamic offline");
    com.tencent.mm.plugin.card.b.g localg = com.tencent.mm.plugin.card.model.am.aAI();
    Object localObject1 = this.ikk;
    if (localObject1 == null)
    {
      y.e("MicroMsg.CardDynamicQrcodeOfflineMgr", "get code is failure! cardInfo is null");
      return "";
    }
    localg.azO();
    localg.ikr = paramc;
    Object localObject3 = ((b)localObject1).azB();
    Object localObject2 = com.tencent.mm.plugin.card.model.am.aAG().dXw.rawQuery("select count(1) from CardQrCodeDataInfo where card_id =? AND status=0", new String[] { localObject3 });
    int i;
    if (localObject2 != null)
    {
      ((Cursor)localObject2).moveToFirst();
      i = ((Cursor)localObject2).getInt(0);
      ((Cursor)localObject2).close();
      if (i != 0) {
        break label148;
      }
      y.e("MicroMsg.CardDynamicQrcodeOfflineMgr", "can not getFrom db！db is empty!");
      i = 0;
    }
    for (;;)
    {
      if (i != 0) {
        break label249;
      }
      y.i("MicroMsg.CardDynamicQrcodeOfflineMgr", "can not getFrom db！ request doNetSceneGetDynamicQrcode!");
      localg.a((b)localObject1, q.izn);
      return "";
      i = 0;
      break;
      label148:
      localObject2 = com.tencent.mm.plugin.card.model.am.aAH().yj((String)localObject3);
      if (localObject2 != null)
      {
        if (com.tencent.mm.plugin.card.b.g.a((i)localObject2))
        {
          localg.ikr = com.tencent.mm.plugin.card.d.c.iyR;
          i = 0;
          continue;
        }
        if ((i < ((i)localObject2).field_lower_bound) && (com.tencent.mm.plugin.card.d.l.isNetworkAvailable(ae.getContext())))
        {
          y.e("MicroMsg.CardDynamicQrcodeOfflineMgr", "can not getFrom db！ currentCodeSize < lower_bound,currentCodeSize =%d,lower_bound=%d", new Object[] { Integer.valueOf(i), Integer.valueOf(((i)localObject2).field_lower_bound) });
          localg.ikr = com.tencent.mm.plugin.card.d.c.iyX;
          i = 0;
          continue;
        }
      }
      i = 1;
    }
    label249:
    localObject2 = com.tencent.mm.plugin.card.model.am.aAG().yl(((b)localObject1).azB());
    if (localObject2 == null)
    {
      y.i("MicroMsg.CardDynamicQrcodeOfflineMgr", "get code is failure! db is  empty! doNetSceneGetDynamicQrcode! cardId= %s", new Object[] { ((b)localObject1).azB() });
      localg.a((b)localObject1, q.izn);
      return "";
    }
    k localk = com.tencent.mm.plugin.card.model.am.aAG().ym((String)localObject3);
    if ((localk != null) && (com.tencent.mm.plugin.card.model.am.aAG().cs((String)localObject3, localk.field_code_id))) {
      localg.a((String)localObject3, localk.field_code_id, paramc);
    }
    localg.iks = 0;
    y.i("MicroMsg.CardDynamicQrcodeOfflineMgr", "update current code showing! newQrCodeData cardId= %s,codeId=%s，refreshReason=%d", new Object[] { localObject3, ((k)localObject2).field_code_id, Integer.valueOf(paramc.action) });
    localObject3 = ((b)localObject1).azB();
    if (localObject2 == null) {
      paramc = "";
    }
    while (bk.bl(paramc))
    {
      localg.U(1, "");
      return "";
      paramc = com.tencent.mm.plugin.card.d.e.cy((String)localObject3, ((k)localObject2).field_code);
      localObject3 = com.tencent.mm.plugin.card.model.am.aAH().yj((String)localObject3);
      if ((localObject3 != null) && (!bk.bl(paramc)) && (((i)localObject3).field_need_insert_show_timestamp) && (!bk.bl(((i)localObject3).field_show_timestamp_encrypt_key)))
      {
        y.i("MicroMsg.CardDynamicQrcodeOfflineMgr", "getCodeData is need insert show timestamp! code signTimestamp!");
        paramc = com.tencent.mm.plugin.card.d.e.cA(paramc, ((i)localObject3).field_show_timestamp_encrypt_key);
      }
      else
      {
        y.i("MicroMsg.CardDynamicQrcodeOfflineMgr", "getCodeData only decrypt qrcode!");
      }
    }
    ((k)localObject2).field_status = 1;
    if (!com.tencent.mm.plugin.card.model.am.aAG().c((com.tencent.mm.sdk.e.c)localObject2, new String[] { "card_id", "code_id" })) {
      y.e("MicroMsg.CardQrCodeDataInfoStorage", "update qrCodeData  failure! card_id = %s, code_id = %s ,status = %d", new Object[] { ((k)localObject2).field_card_id, ((k)localObject2).field_code_id, Integer.valueOf(((k)localObject2).field_status) });
    }
    for (;;)
    {
      localg = com.tencent.mm.plugin.card.model.am.aAI();
      localObject1 = ((b)localObject1).azB();
      localObject1 = com.tencent.mm.plugin.card.model.am.aAH().yj((String)localObject1);
      if (localObject1 != null) {
        break;
      }
      y.e("MicroMsg.CardDynamicQrcodeOfflineMgr", "startRequestCodeTimer failure! CardQrCodeConfi is null!");
      return paramc;
      y.i("MicroMsg.CardQrCodeDataInfoStorage", "update qrCodeData  success! card_id = %s, code_id = %s ,status = %d", new Object[] { ((k)localObject2).field_card_id, ((k)localObject2).field_code_id, Integer.valueOf(((k)localObject2).field_status) });
    }
    long l = ((i)localObject1).field_show_expire_interval * 1000;
    y.i("MicroMsg.CardDynamicQrcodeOfflineMgr", "startRefreshCodeTimer refreshTime: " + l);
    localg.ikt.S(l, l);
    return paramc;
  }
  
  public final boolean f(b paramb)
  {
    if (this.ikk == null)
    {
      y.i("MicroMsg.CarDynamicCodeView", "isNeedUpdateViewAgain mCardInfo is null！");
      return true;
    }
    if (paramb == null)
    {
      y.i("MicroMsg.CarDynamicCodeView", "isNeedUpdateViewAgain false  newCardInfo null！");
      return false;
    }
    if (this.ikk.azy().sHM != paramb.azy().sHM)
    {
      y.i("MicroMsg.CarDynamicCodeView", "isNeedUpdateViewAgain is_commom_card is different！");
      return true;
    }
    ra localra1 = this.ikk.azy().sHL;
    ra localra2 = paramb.azy().sHL;
    if (((localra1 == null) && (localra2 != null)) || ((localra1 != null) && (localra2 == null)))
    {
      y.i("MicroMsg.CarDynamicCodeView", "isNeedUpdateViewAgain unavailable_qrcode_field is different！");
      return true;
    }
    if ((localra1 != null) && (localra2 != null) && (localra1.title != null) && (localra2.title != null) && (localra1.title.equals(localra2.title)))
    {
      y.i("MicroMsg.CarDynamicCodeView", "isNeedUpdateViewAgain unavailable_qrcode_field title is different！");
      return true;
    }
    localra1 = this.ikk.azx().sIU;
    paramb = paramb.azx().sIU;
    if (((localra1 == null) && (paramb != null)) || ((localra1 != null) && (paramb == null)))
    {
      y.i("MicroMsg.CarDynamicCodeView", "isNeedUpdateViewAgain pay_and_qrcode_field  is diffrent！");
      return true;
    }
    if ((localra1 != null) && (paramb != null) && (localra1.title != null) && (paramb.title != null) && (!localra1.title.equals(paramb.title)))
    {
      y.i("MicroMsg.CarDynamicCodeView", "isNeedUpdateViewAgain pay_and_qrcode_field title is diffrent！");
      return true;
    }
    if ((localra1 != null) && (paramb != null) && (localra1.ilr != null) && (paramb.ilr != null) && (!localra1.ilr.equals(paramb.ilr)))
    {
      y.i("MicroMsg.CarDynamicCodeView", "isNeedUpdateViewAgain pay_and_qrcode_field aux_title  is diffrent！");
      return true;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.card.ui.view.m
 * JD-Core Version:    0.7.0.1
 */