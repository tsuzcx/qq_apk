package com.tencent.mm.plugin.card.b;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.n;
import com.tencent.mm.al.q;
import com.tencent.mm.g.a.tm;
import com.tencent.mm.g.a.tm.a;
import com.tencent.mm.g.a.tm.b;
import com.tencent.mm.kernel.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.card.model.CardInfo;
import com.tencent.mm.plugin.card.model.am;
import com.tencent.mm.plugin.card.model.o;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ad;

public final class a
  extends c<tm>
  implements com.tencent.mm.al.f
{
  private tm ows;
  
  public a()
  {
    AppMethodBeat.i(161192);
    this.__eventId = tm.class.getName().hashCode();
    AppMethodBeat.o(161192);
  }
  
  private boolean a(tm paramtm)
  {
    AppMethodBeat.i(112570);
    if (!g.ajx())
    {
      ad.e("MicroMsg.AccessCardEventListener", "ShakeAcceptCouponCardEvent account is not ready");
      AppMethodBeat.o(112570);
      return false;
    }
    if ((paramtm instanceof tm))
    {
      this.ows = paramtm;
      paramtm = this.ows.dHV.dHX;
      String str = this.ows.dHV.dHY;
      int i = this.ows.dHV.dHZ;
      if (TextUtils.isEmpty(paramtm))
      {
        ad.e("MicroMsg.AccessCardEventListener", "ShakeAcceptCouponCardEvent card_id is empty");
        bTZ();
        AppMethodBeat.o(112570);
        return false;
      }
      g.ajB().gAO.a(1037, this);
      ad.i("MicroMsg.AccessCardEventListener", "ShakeAcceptCouponCardEvent doscene from scene ".concat(String.valueOf(i)));
      paramtm = new o(paramtm, i, "", str, "", "", 0, 0, null);
      g.ajB().gAO.a(paramtm, 0);
      AppMethodBeat.o(112570);
      return true;
    }
    AppMethodBeat.o(112570);
    return false;
  }
  
  private void bTZ()
  {
    AppMethodBeat.i(112572);
    if (this.ows.callback != null) {
      this.ows.callback.run();
    }
    this.ows = null;
    AppMethodBeat.o(112572);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(112571);
    tm.b localb;
    if ((paramn instanceof o))
    {
      localb = new tm.b();
      ad.i("MicroMsg.AccessCardEventListener", "NetSceneAcceptCardItem doscene return errcode " + paramInt2 + " errmsg" + paramString);
      if ((paramInt1 != 0) || (paramInt2 != 0)) {
        break label245;
      }
      ad.i("MicroMsg.AccessCardEventListener", "NetSceneAcceptCardItem doscene is success");
      paramn = (o)paramn;
      paramInt1 = paramn.ozR;
      paramString = paramn.ozQ;
      paramn = paramn.ozS;
      if (paramInt1 != 0) {
        break label205;
      }
      ad.i("MicroMsg.AccessCardEventListener", "NetSceneAcceptCardItem doscene return ok ");
      localb.dpX = true;
      paramn = new CardInfo();
      com.tencent.mm.plugin.card.d.f.a(paramn, paramString);
      if (TextUtils.isEmpty(paramn.field_card_id)) {
        break label188;
      }
      localb.dHX = paramn.field_card_id;
      am.bUS().putValue("key_accept_card_info", paramn);
    }
    for (;;)
    {
      g.ajB().gAO.b(1037, this);
      this.ows.dHW = localb;
      bTZ();
      AppMethodBeat.o(112571);
      return;
      label188:
      ad.i("MicroMsg.AccessCardEventListener", "NetSceneAcceptCardItem doscene return card_id is empty ");
      localb.dHX = "";
      break;
      label205:
      ad.i("MicroMsg.AccessCardEventListener", "NetSceneAcceptCardItem doscene return false, retCode " + paramInt1 + " retMsg" + paramn);
      localb.dpX = false;
      continue;
      label245:
      ad.i("MicroMsg.AccessCardEventListener", "NetSceneAcceptCardItem doscene is fail");
      localb.dpX = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.card.b.a
 * JD-Core Version:    0.7.0.1
 */