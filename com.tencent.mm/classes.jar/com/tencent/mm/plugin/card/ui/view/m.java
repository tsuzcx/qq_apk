package com.tencent.mm.plugin.card.ui.view;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.card.base.b;
import com.tencent.mm.plugin.card.d.r;
import com.tencent.mm.plugin.card.model.am;
import com.tencent.mm.plugin.card.model.i;
import com.tencent.mm.plugin.card.model.j;
import com.tencent.mm.plugin.card.model.k;
import com.tencent.mm.protocal.protobuf.aaf;
import com.tencent.mm.protocal.protobuf.sr;
import com.tencent.mm.protocal.protobuf.ts;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.av;
import com.tencent.mm.sdk.platformtools.bt;

public final class m
  extends g
{
  public final ab bYx()
  {
    AppMethodBeat.i(113686);
    n localn = new n(this, this.owO);
    AppMethodBeat.o(113686);
    return localn;
  }
  
  public final ab bYy()
  {
    AppMethodBeat.i(113687);
    f localf = new f(this, this.owO);
    AppMethodBeat.o(113687);
    return localf;
  }
  
  public final ab bYz()
  {
    AppMethodBeat.i(113688);
    t localt = new t(this, this.owO);
    AppMethodBeat.o(113688);
    return localt;
  }
  
  public final String e(com.tencent.mm.plugin.card.d.c paramc)
  {
    AppMethodBeat.i(113685);
    ad.i("MicroMsg.CarDynamicCodeView", "code from dynamic offline");
    com.tencent.mm.plugin.card.b.g localg = am.bVd();
    Object localObject2 = this.owK;
    Object localObject1 = "";
    if (localObject2 == null)
    {
      ad.e("MicroMsg.CardDynamicQrcodeOfflineMgr", "get code is failure! cardInfo is null");
      paramc = (com.tencent.mm.plugin.card.d.c)localObject1;
    }
    for (;;)
    {
      AppMethodBeat.o(113685);
      return paramc;
      localg.bUg();
      localg.owS = paramc;
      Object localObject3 = ((b)localObject2).bTR();
      localObject1 = am.bVb().db.rawQuery("select count(1) from CardQrCodeDataInfo where card_id =? AND status=0", new String[] { localObject3 });
      int i;
      if (localObject1 != null)
      {
        ((Cursor)localObject1).moveToFirst();
        i = ((Cursor)localObject1).getInt(0);
        ((Cursor)localObject1).close();
        if (i != 0) {
          break label169;
        }
        ad.e("MicroMsg.CardDynamicQrcodeOfflineMgr", "can not getFrom db！db is empty!");
        i = 0;
      }
      for (;;)
      {
        if (i != 0) {
          break label270;
        }
        ad.i("MicroMsg.CardDynamicQrcodeOfflineMgr", "can not getFrom db！ request doNetSceneGetDynamicQrcode!");
        localg.a((b)localObject2, r.oPN);
        AppMethodBeat.o(113685);
        return "";
        i = 0;
        break;
        label169:
        localObject1 = am.bVc().Yp((String)localObject3);
        if (localObject1 != null)
        {
          if (com.tencent.mm.plugin.card.b.g.a((i)localObject1))
          {
            localg.owS = com.tencent.mm.plugin.card.d.c.oPs;
            i = 0;
            continue;
          }
          if ((i < ((i)localObject1).field_lower_bound) && (com.tencent.mm.plugin.card.d.l.isNetworkAvailable(aj.getContext())))
          {
            ad.e("MicroMsg.CardDynamicQrcodeOfflineMgr", "can not getFrom db！ currentCodeSize < lower_bound,currentCodeSize =%d,lower_bound=%d", new Object[] { Integer.valueOf(i), Integer.valueOf(((i)localObject1).field_lower_bound) });
            localg.owS = com.tencent.mm.plugin.card.d.c.oPy;
            i = 0;
            continue;
          }
        }
        i = 1;
      }
      label270:
      localObject1 = am.bVb().Yr(((b)localObject2).bTR());
      if (localObject1 == null)
      {
        ad.i("MicroMsg.CardDynamicQrcodeOfflineMgr", "get code is failure! db is  empty! doNetSceneGetDynamicQrcode! cardId= %s", new Object[] { ((b)localObject2).bTR() });
        localg.a((b)localObject2, r.oPN);
        AppMethodBeat.o(113685);
        return "";
      }
      k localk = am.bVb().Ys((String)localObject3);
      if ((localk != null) && (am.bVb().eW((String)localObject3, localk.field_code_id))) {
        localg.a((String)localObject3, localk.field_code_id, paramc);
      }
      localg.giC = 0;
      ad.i("MicroMsg.CardDynamicQrcodeOfflineMgr", "update current code showing! newQrCodeData cardId= %s,codeId=%s，refreshReason=%d", new Object[] { localObject3, ((k)localObject1).field_code_id, Integer.valueOf(paramc.action) });
      localObject3 = ((b)localObject2).bTR();
      if (localObject1 == null) {
        paramc = "";
      }
      while (bt.isNullOrNil(paramc))
      {
        localg.ah(1, "");
        AppMethodBeat.o(113685);
        return "";
        paramc = com.tencent.mm.plugin.card.d.e.fc((String)localObject3, ((k)localObject1).field_code);
        localObject3 = am.bVc().Yp((String)localObject3);
        if ((localObject3 != null) && (!bt.isNullOrNil(paramc)) && (((i)localObject3).field_need_insert_show_timestamp) && (!bt.isNullOrNil(((i)localObject3).field_show_timestamp_encrypt_key)))
        {
          ad.i("MicroMsg.CardDynamicQrcodeOfflineMgr", "getCodeData is need insert show timestamp! code signTimestamp!");
          paramc = com.tencent.mm.plugin.card.d.e.fe(paramc, ((i)localObject3).field_show_timestamp_encrypt_key);
        }
        else
        {
          ad.i("MicroMsg.CardDynamicQrcodeOfflineMgr", "getCodeData only decrypt qrcode!");
        }
      }
      ((k)localObject1).field_status = 1;
      if (!am.bVb().update((com.tencent.mm.sdk.e.c)localObject1, new String[] { "card_id", "code_id" })) {
        ad.e("MicroMsg.CardQrCodeDataInfoStorage", "update qrCodeData  failure! card_id = %s, code_id = %s ,status = %d", new Object[] { ((k)localObject1).field_card_id, ((k)localObject1).field_code_id, Integer.valueOf(((k)localObject1).field_status) });
      }
      for (;;)
      {
        localObject1 = am.bVd();
        localObject2 = ((b)localObject2).bTR();
        localObject2 = am.bVc().Yp((String)localObject2);
        if (localObject2 != null) {
          break label690;
        }
        ad.e("MicroMsg.CardDynamicQrcodeOfflineMgr", "startRequestCodeTimer failure! CardQrCodeConfi is null!");
        break;
        ad.i("MicroMsg.CardQrCodeDataInfoStorage", "update qrCodeData  success! card_id = %s, code_id = %s ,status = %d", new Object[] { ((k)localObject1).field_card_id, ((k)localObject1).field_code_id, Integer.valueOf(((k)localObject1).field_status) });
      }
      label690:
      long l = ((i)localObject2).field_show_expire_interval * 1000;
      ad.i("MicroMsg.CardDynamicQrcodeOfflineMgr", "startRefreshCodeTimer refreshTime: ".concat(String.valueOf(l)));
      ((com.tencent.mm.plugin.card.b.g)localObject1).owT.az(l, l);
    }
  }
  
  public final boolean f(b paramb)
  {
    AppMethodBeat.i(113684);
    if (this.owK == null)
    {
      ad.i("MicroMsg.CarDynamicCodeView", "isNeedUpdateViewAgain mCardInfo is null！");
      AppMethodBeat.o(113684);
      return true;
    }
    if (paramb == null)
    {
      ad.i("MicroMsg.CarDynamicCodeView", "isNeedUpdateViewAgain false  newCardInfo null！");
      AppMethodBeat.o(113684);
      return false;
    }
    if (this.owK.bTO().FPE != paramb.bTO().FPE)
    {
      ad.i("MicroMsg.CarDynamicCodeView", "isNeedUpdateViewAgain is_commom_card is different！");
      AppMethodBeat.o(113684);
      return true;
    }
    aaf localaaf1 = this.owK.bTO().FPD;
    aaf localaaf2 = paramb.bTO().FPD;
    if (((localaaf1 == null) && (localaaf2 != null)) || ((localaaf1 != null) && (localaaf2 == null)))
    {
      ad.i("MicroMsg.CarDynamicCodeView", "isNeedUpdateViewAgain unavailable_qrcode_field is different！");
      AppMethodBeat.o(113684);
      return true;
    }
    if ((localaaf1 != null) && (localaaf2 != null) && (localaaf1.title != null) && (localaaf2.title != null) && (localaaf1.title.equals(localaaf2.title)))
    {
      ad.i("MicroMsg.CarDynamicCodeView", "isNeedUpdateViewAgain unavailable_qrcode_field title is different！");
      AppMethodBeat.o(113684);
      return true;
    }
    localaaf1 = this.owK.bTN().FSc;
    paramb = paramb.bTN().FSc;
    if (((localaaf1 == null) && (paramb != null)) || ((localaaf1 != null) && (paramb == null)))
    {
      ad.i("MicroMsg.CarDynamicCodeView", "isNeedUpdateViewAgain pay_and_qrcode_field  is diffrent！");
      AppMethodBeat.o(113684);
      return true;
    }
    if ((localaaf1 != null) && (paramb != null) && (localaaf1.title != null) && (paramb.title != null) && (!localaaf1.title.equals(paramb.title)))
    {
      ad.i("MicroMsg.CarDynamicCodeView", "isNeedUpdateViewAgain pay_and_qrcode_field title is diffrent！");
      AppMethodBeat.o(113684);
      return true;
    }
    if ((localaaf1 != null) && (paramb != null) && (localaaf1.oxO != null) && (paramb.oxO != null) && (!localaaf1.oxO.equals(paramb.oxO)))
    {
      ad.i("MicroMsg.CarDynamicCodeView", "isNeedUpdateViewAgain pay_and_qrcode_field aux_title  is diffrent！");
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