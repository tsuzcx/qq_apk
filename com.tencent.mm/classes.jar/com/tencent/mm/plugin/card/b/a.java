package com.tencent.mm.plugin.card.b;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.n;
import com.tencent.mm.al.q;
import com.tencent.mm.g.a.sm;
import com.tencent.mm.g.a.sm.a;
import com.tencent.mm.g.a.sm.b;
import com.tencent.mm.kernel.b;
import com.tencent.mm.plugin.card.d.f;
import com.tencent.mm.plugin.card.model.CardInfo;
import com.tencent.mm.plugin.card.model.am;
import com.tencent.mm.plugin.card.model.o;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ad;

public final class a
  extends c<sm>
  implements com.tencent.mm.al.g
{
  private sm npX;
  
  public a()
  {
    AppMethodBeat.i(161192);
    this.__eventId = sm.class.getName().hashCode();
    AppMethodBeat.o(161192);
  }
  
  private boolean a(sm paramsm)
  {
    AppMethodBeat.i(112570);
    if (!com.tencent.mm.kernel.g.afw())
    {
      ad.e("MicroMsg.AccessCardEventListener", "ShakeAcceptCouponCardEvent account is not ready");
      AppMethodBeat.o(112570);
      return false;
    }
    if ((paramsm instanceof sm))
    {
      this.npX = paramsm;
      paramsm = this.npX.dya.dyc;
      String str = this.npX.dya.dyd;
      int i = this.npX.dya.dye;
      if (TextUtils.isEmpty(paramsm))
      {
        ad.e("MicroMsg.AccessCardEventListener", "ShakeAcceptCouponCardEvent card_id is empty");
        bIh();
        AppMethodBeat.o(112570);
        return false;
      }
      com.tencent.mm.kernel.g.afA().gcy.a(1037, this);
      ad.i("MicroMsg.AccessCardEventListener", "ShakeAcceptCouponCardEvent doscene from scene ".concat(String.valueOf(i)));
      paramsm = new o(paramsm, i, "", str, "", "", 0, 0, null);
      com.tencent.mm.kernel.g.afA().gcy.a(paramsm, 0);
      AppMethodBeat.o(112570);
      return true;
    }
    AppMethodBeat.o(112570);
    return false;
  }
  
  private void bIh()
  {
    AppMethodBeat.i(112572);
    if (this.npX.callback != null) {
      this.npX.callback.run();
    }
    this.npX = null;
    AppMethodBeat.o(112572);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(112571);
    sm.b localb;
    if ((paramn instanceof o))
    {
      localb = new sm.b();
      ad.i("MicroMsg.AccessCardEventListener", "NetSceneAcceptCardItem doscene return errcode " + paramInt2 + " errmsg" + paramString);
      if ((paramInt1 != 0) || (paramInt2 != 0)) {
        break label245;
      }
      ad.i("MicroMsg.AccessCardEventListener", "NetSceneAcceptCardItem doscene is success");
      paramn = (o)paramn;
      paramInt1 = paramn.ntx;
      paramString = paramn.ntw;
      paramn = paramn.nty;
      if (paramInt1 != 0) {
        break label205;
      }
      ad.i("MicroMsg.AccessCardEventListener", "NetSceneAcceptCardItem doscene return ok ");
      localb.dhg = true;
      paramn = new CardInfo();
      f.a(paramn, paramString);
      if (TextUtils.isEmpty(paramn.field_card_id)) {
        break label188;
      }
      localb.dyc = paramn.field_card_id;
      am.bJa().putValue("key_accept_card_info", paramn);
    }
    for (;;)
    {
      com.tencent.mm.kernel.g.afA().gcy.b(1037, this);
      this.npX.dyb = localb;
      bIh();
      AppMethodBeat.o(112571);
      return;
      label188:
      ad.i("MicroMsg.AccessCardEventListener", "NetSceneAcceptCardItem doscene return card_id is empty ");
      localb.dyc = "";
      break;
      label205:
      ad.i("MicroMsg.AccessCardEventListener", "NetSceneAcceptCardItem doscene return false, retCode " + paramInt1 + " retMsg" + paramn);
      localb.dhg = false;
      continue;
      label245:
      ad.i("MicroMsg.AccessCardEventListener", "NetSceneAcceptCardItem doscene is fail");
      localb.dhg = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.card.b.a
 * JD-Core Version:    0.7.0.1
 */