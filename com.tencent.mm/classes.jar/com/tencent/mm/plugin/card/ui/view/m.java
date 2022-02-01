package com.tencent.mm.plugin.card.ui.view;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.card.base.b;
import com.tencent.mm.plugin.card.d.c;
import com.tencent.mm.plugin.card.d.e;
import com.tencent.mm.plugin.card.d.r;
import com.tencent.mm.plugin.card.model.am;
import com.tencent.mm.plugin.card.model.i;
import com.tencent.mm.plugin.card.model.j;
import com.tencent.mm.plugin.card.model.k;
import com.tencent.mm.protocal.protobuf.abz;
import com.tencent.mm.protocal.protobuf.ty;
import com.tencent.mm.protocal.protobuf.uz;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import com.tencent.mm.sdk.storage.ISQLiteDatabase;

public final class m
  extends g
{
  public final ab cxB()
  {
    AppMethodBeat.i(113686);
    n localn = new n(this, this.pQZ);
    AppMethodBeat.o(113686);
    return localn;
  }
  
  public final ab cxC()
  {
    AppMethodBeat.i(113687);
    f localf = new f(this, this.pQZ);
    AppMethodBeat.o(113687);
    return localf;
  }
  
  public final ab cxD()
  {
    AppMethodBeat.i(113688);
    t localt = new t(this, this.pQZ);
    AppMethodBeat.o(113688);
    return localt;
  }
  
  public final String e(c paramc)
  {
    AppMethodBeat.i(113685);
    Log.i("MicroMsg.CarDynamicCodeView", "code from dynamic offline");
    com.tencent.mm.plugin.card.b.g localg = am.cug();
    Object localObject2 = this.pQV;
    Object localObject1 = "";
    if (localObject2 == null)
    {
      Log.e("MicroMsg.CardDynamicQrcodeOfflineMgr", "get code is failure! cardInfo is null");
      paramc = (c)localObject1;
    }
    for (;;)
    {
      AppMethodBeat.o(113685);
      return paramc;
      localg.ctj();
      localg.pRd = paramc;
      Object localObject3 = ((b)localObject2).csU();
      localObject1 = am.cue().db.rawQuery("select count(1) from CardQrCodeDataInfo where card_id =? AND status=0", new String[] { localObject3 });
      int i;
      if (localObject1 != null)
      {
        ((Cursor)localObject1).moveToFirst();
        i = ((Cursor)localObject1).getInt(0);
        ((Cursor)localObject1).close();
        if (i != 0) {
          break label169;
        }
        Log.e("MicroMsg.CardDynamicQrcodeOfflineMgr", "can not getFrom db！db is empty!");
        i = 0;
      }
      for (;;)
      {
        if (i != 0) {
          break label270;
        }
        Log.i("MicroMsg.CardDynamicQrcodeOfflineMgr", "can not getFrom db！ request doNetSceneGetDynamicQrcode!");
        localg.a((b)localObject2, r.qlj);
        AppMethodBeat.o(113685);
        return "";
        i = 0;
        break;
        label169:
        localObject1 = am.cuf().ajl((String)localObject3);
        if (localObject1 != null)
        {
          if (com.tencent.mm.plugin.card.b.g.a((i)localObject1))
          {
            localg.pRd = c.qkO;
            i = 0;
            continue;
          }
          if ((i < ((i)localObject1).field_lower_bound) && (com.tencent.mm.plugin.card.d.l.isNetworkAvailable(MMApplicationContext.getContext())))
          {
            Log.e("MicroMsg.CardDynamicQrcodeOfflineMgr", "can not getFrom db！ currentCodeSize < lower_bound,currentCodeSize =%d,lower_bound=%d", new Object[] { Integer.valueOf(i), Integer.valueOf(((i)localObject1).field_lower_bound) });
            localg.pRd = c.qkU;
            i = 0;
            continue;
          }
        }
        i = 1;
      }
      label270:
      localObject1 = am.cue().ajn(((b)localObject2).csU());
      if (localObject1 == null)
      {
        Log.i("MicroMsg.CardDynamicQrcodeOfflineMgr", "get code is failure! db is  empty! doNetSceneGetDynamicQrcode! cardId= %s", new Object[] { ((b)localObject2).csU() });
        localg.a((b)localObject2, r.qlj);
        AppMethodBeat.o(113685);
        return "";
      }
      k localk = am.cue().ajo((String)localObject3);
      if ((localk != null) && (am.cue().fr((String)localObject3, localk.field_code_id))) {
        localg.a((String)localObject3, localk.field_code_id, paramc);
      }
      localg.gVP = 0;
      Log.i("MicroMsg.CardDynamicQrcodeOfflineMgr", "update current code showing! newQrCodeData cardId= %s,codeId=%s，refreshReason=%d", new Object[] { localObject3, ((k)localObject1).field_code_id, Integer.valueOf(paramc.action) });
      localObject3 = ((b)localObject2).csU();
      if (localObject1 == null) {
        paramc = "";
      }
      while (Util.isNullOrNil(paramc))
      {
        localg.ak(1, "");
        AppMethodBeat.o(113685);
        return "";
        paramc = e.fx((String)localObject3, ((k)localObject1).field_code);
        localObject3 = am.cuf().ajl((String)localObject3);
        if ((localObject3 != null) && (!Util.isNullOrNil(paramc)) && (((i)localObject3).field_need_insert_show_timestamp) && (!Util.isNullOrNil(((i)localObject3).field_show_timestamp_encrypt_key)))
        {
          Log.i("MicroMsg.CardDynamicQrcodeOfflineMgr", "getCodeData is need insert show timestamp! code signTimestamp!");
          paramc = e.fz(paramc, ((i)localObject3).field_show_timestamp_encrypt_key);
        }
        else
        {
          Log.i("MicroMsg.CardDynamicQrcodeOfflineMgr", "getCodeData only decrypt qrcode!");
        }
      }
      ((k)localObject1).field_status = 1;
      if (!am.cue().update((IAutoDBItem)localObject1, new String[] { "card_id", "code_id" })) {
        Log.e("MicroMsg.CardQrCodeDataInfoStorage", "update qrCodeData  failure! card_id = %s, code_id = %s ,status = %d", new Object[] { ((k)localObject1).field_card_id, ((k)localObject1).field_code_id, Integer.valueOf(((k)localObject1).field_status) });
      }
      for (;;)
      {
        localObject1 = am.cug();
        localObject2 = ((b)localObject2).csU();
        localObject2 = am.cuf().ajl((String)localObject2);
        if (localObject2 != null) {
          break label690;
        }
        Log.e("MicroMsg.CardDynamicQrcodeOfflineMgr", "startRequestCodeTimer failure! CardQrCodeConfi is null!");
        break;
        Log.i("MicroMsg.CardQrCodeDataInfoStorage", "update qrCodeData  success! card_id = %s, code_id = %s ,status = %d", new Object[] { ((k)localObject1).field_card_id, ((k)localObject1).field_code_id, Integer.valueOf(((k)localObject1).field_status) });
      }
      label690:
      long l = ((i)localObject2).field_show_expire_interval * 1000;
      Log.i("MicroMsg.CardDynamicQrcodeOfflineMgr", "startRefreshCodeTimer refreshTime: ".concat(String.valueOf(l)));
      ((com.tencent.mm.plugin.card.b.g)localObject1).pRe.startTimer(l);
    }
  }
  
  public final boolean f(b paramb)
  {
    AppMethodBeat.i(113684);
    if (this.pQV == null)
    {
      Log.i("MicroMsg.CarDynamicCodeView", "isNeedUpdateViewAgain mCardInfo is null！");
      AppMethodBeat.o(113684);
      return true;
    }
    if (paramb == null)
    {
      Log.i("MicroMsg.CarDynamicCodeView", "isNeedUpdateViewAgain false  newCardInfo null！");
      AppMethodBeat.o(113684);
      return false;
    }
    if (this.pQV.csR().LcG != paramb.csR().LcG)
    {
      Log.i("MicroMsg.CarDynamicCodeView", "isNeedUpdateViewAgain is_commom_card is different！");
      AppMethodBeat.o(113684);
      return true;
    }
    abz localabz1 = this.pQV.csR().LcF;
    abz localabz2 = paramb.csR().LcF;
    if (((localabz1 == null) && (localabz2 != null)) || ((localabz1 != null) && (localabz2 == null)))
    {
      Log.i("MicroMsg.CarDynamicCodeView", "isNeedUpdateViewAgain unavailable_qrcode_field is different！");
      AppMethodBeat.o(113684);
      return true;
    }
    if ((localabz1 != null) && (localabz2 != null) && (localabz1.title != null) && (localabz2.title != null) && (localabz1.title.equals(localabz2.title)))
    {
      Log.i("MicroMsg.CarDynamicCodeView", "isNeedUpdateViewAgain unavailable_qrcode_field title is different！");
      AppMethodBeat.o(113684);
      return true;
    }
    localabz1 = this.pQV.csQ().Lfe;
    paramb = paramb.csQ().Lfe;
    if (((localabz1 == null) && (paramb != null)) || ((localabz1 != null) && (paramb == null)))
    {
      Log.i("MicroMsg.CarDynamicCodeView", "isNeedUpdateViewAgain pay_and_qrcode_field  is diffrent！");
      AppMethodBeat.o(113684);
      return true;
    }
    if ((localabz1 != null) && (paramb != null) && (localabz1.title != null) && (paramb.title != null) && (!localabz1.title.equals(paramb.title)))
    {
      Log.i("MicroMsg.CarDynamicCodeView", "isNeedUpdateViewAgain pay_and_qrcode_field title is diffrent！");
      AppMethodBeat.o(113684);
      return true;
    }
    if ((localabz1 != null) && (paramb != null) && (localabz1.pRZ != null) && (paramb.pRZ != null) && (!localabz1.pRZ.equals(paramb.pRZ)))
    {
      Log.i("MicroMsg.CarDynamicCodeView", "isNeedUpdateViewAgain pay_and_qrcode_field aux_title  is diffrent！");
      AppMethodBeat.o(113684);
      return true;
    }
    AppMethodBeat.o(113684);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.card.ui.view.m
 * JD-Core Version:    0.7.0.1
 */