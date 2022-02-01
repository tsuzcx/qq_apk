package com.tencent.mm.plugin.card.b;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.i;
import com.tencent.mm.an.q;
import com.tencent.mm.an.t;
import com.tencent.mm.f.a.vo;
import com.tencent.mm.f.a.vo.a;
import com.tencent.mm.f.a.vo.b;
import com.tencent.mm.kernel.c;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.card.d.f;
import com.tencent.mm.plugin.card.model.CardInfo;
import com.tencent.mm.plugin.card.model.am;
import com.tencent.mm.plugin.card.model.o;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;

public final class a
  extends IListener<vo>
  implements i
{
  private vo tmD;
  
  public a()
  {
    AppMethodBeat.i(161192);
    this.__eventId = vo.class.getName().hashCode();
    AppMethodBeat.o(161192);
  }
  
  private boolean a(vo paramvo)
  {
    AppMethodBeat.i(112570);
    if (!h.aHB())
    {
      Log.e("MicroMsg.AccessCardEventListener", "ShakeAcceptCouponCardEvent account is not ready");
      AppMethodBeat.o(112570);
      return false;
    }
    if ((paramvo instanceof vo))
    {
      this.tmD = paramvo;
      paramvo = this.tmD.fUJ.fUL;
      String str = this.tmD.fUJ.fUM;
      int i = this.tmD.fUJ.fUN;
      if (TextUtils.isEmpty(paramvo))
      {
        Log.e("MicroMsg.AccessCardEventListener", "ShakeAcceptCouponCardEvent card_id is empty");
        cGE();
        AppMethodBeat.o(112570);
        return false;
      }
      h.aHF().kcd.a(1037, this);
      Log.i("MicroMsg.AccessCardEventListener", "ShakeAcceptCouponCardEvent doscene from scene ".concat(String.valueOf(i)));
      paramvo = new o(paramvo, i, "", str, "", "", 0, 0, null);
      h.aHF().kcd.a(paramvo, 0);
      AppMethodBeat.o(112570);
      return true;
    }
    AppMethodBeat.o(112570);
    return false;
  }
  
  private void cGE()
  {
    AppMethodBeat.i(112572);
    if (this.tmD.callback != null) {
      this.tmD.callback.run();
    }
    this.tmD = null;
    AppMethodBeat.o(112572);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    AppMethodBeat.i(112571);
    vo.b localb;
    if ((paramq instanceof o))
    {
      localb = new vo.b();
      Log.i("MicroMsg.AccessCardEventListener", "NetSceneAcceptCardItem doscene return errcode " + paramInt2 + " errmsg" + paramString);
      if ((paramInt1 != 0) || (paramInt2 != 0)) {
        break label245;
      }
      Log.i("MicroMsg.AccessCardEventListener", "NetSceneAcceptCardItem doscene is success");
      paramq = (o)paramq;
      paramInt1 = paramq.tqa;
      paramString = paramq.tpZ;
      paramq = paramq.tqb;
      if (paramInt1 != 0) {
        break label205;
      }
      Log.i("MicroMsg.AccessCardEventListener", "NetSceneAcceptCardItem doscene return ok ");
      localb.isSuccess = true;
      paramq = new CardInfo();
      f.a(paramq, paramString);
      if (TextUtils.isEmpty(paramq.field_card_id)) {
        break label188;
      }
      localb.fUL = paramq.field_card_id;
      am.cHx().r("key_accept_card_info", paramq);
    }
    for (;;)
    {
      h.aHF().kcd.b(1037, this);
      this.tmD.fUK = localb;
      cGE();
      AppMethodBeat.o(112571);
      return;
      label188:
      Log.i("MicroMsg.AccessCardEventListener", "NetSceneAcceptCardItem doscene return card_id is empty ");
      localb.fUL = "";
      break;
      label205:
      Log.i("MicroMsg.AccessCardEventListener", "NetSceneAcceptCardItem doscene return false, retCode " + paramInt1 + " retMsg" + paramq);
      localb.isSuccess = false;
      continue;
      label245:
      Log.i("MicroMsg.AccessCardEventListener", "NetSceneAcceptCardItem doscene is fail");
      localb.isSuccess = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.card.b.a
 * JD-Core Version:    0.7.0.1
 */