package com.tencent.mm.plugin.card.b;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.n;
import com.tencent.mm.ak.q;
import com.tencent.mm.g.a.sv;
import com.tencent.mm.g.a.sv.a;
import com.tencent.mm.g.a.sv.b;
import com.tencent.mm.kernel.b;
import com.tencent.mm.plugin.card.d.f;
import com.tencent.mm.plugin.card.model.CardInfo;
import com.tencent.mm.plugin.card.model.am;
import com.tencent.mm.plugin.card.model.o;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ac;

public final class a
  extends c<sv>
  implements com.tencent.mm.ak.g
{
  private sv nSX;
  
  public a()
  {
    AppMethodBeat.i(161192);
    this.__eventId = sv.class.getName().hashCode();
    AppMethodBeat.o(161192);
  }
  
  private boolean a(sv paramsv)
  {
    AppMethodBeat.i(112570);
    if (!com.tencent.mm.kernel.g.agM())
    {
      ac.e("MicroMsg.AccessCardEventListener", "ShakeAcceptCouponCardEvent account is not ready");
      AppMethodBeat.o(112570);
      return false;
    }
    if ((paramsv instanceof sv))
    {
      this.nSX = paramsv;
      paramsv = this.nSX.dvM.dvO;
      String str = this.nSX.dvM.dvP;
      int i = this.nSX.dvM.dvQ;
      if (TextUtils.isEmpty(paramsv))
      {
        ac.e("MicroMsg.AccessCardEventListener", "ShakeAcceptCouponCardEvent card_id is empty");
        bPu();
        AppMethodBeat.o(112570);
        return false;
      }
      com.tencent.mm.kernel.g.agQ().ghe.a(1037, this);
      ac.i("MicroMsg.AccessCardEventListener", "ShakeAcceptCouponCardEvent doscene from scene ".concat(String.valueOf(i)));
      paramsv = new o(paramsv, i, "", str, "", "", 0, 0, null);
      com.tencent.mm.kernel.g.agQ().ghe.a(paramsv, 0);
      AppMethodBeat.o(112570);
      return true;
    }
    AppMethodBeat.o(112570);
    return false;
  }
  
  private void bPu()
  {
    AppMethodBeat.i(112572);
    if (this.nSX.callback != null) {
      this.nSX.callback.run();
    }
    this.nSX = null;
    AppMethodBeat.o(112572);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(112571);
    sv.b localb;
    if ((paramn instanceof o))
    {
      localb = new sv.b();
      ac.i("MicroMsg.AccessCardEventListener", "NetSceneAcceptCardItem doscene return errcode " + paramInt2 + " errmsg" + paramString);
      if ((paramInt1 != 0) || (paramInt2 != 0)) {
        break label245;
      }
      ac.i("MicroMsg.AccessCardEventListener", "NetSceneAcceptCardItem doscene is success");
      paramn = (o)paramn;
      paramInt1 = paramn.nWx;
      paramString = paramn.nWw;
      paramn = paramn.nWy;
      if (paramInt1 != 0) {
        break label205;
      }
      ac.i("MicroMsg.AccessCardEventListener", "NetSceneAcceptCardItem doscene return ok ");
      localb.deB = true;
      paramn = new CardInfo();
      f.a(paramn, paramString);
      if (TextUtils.isEmpty(paramn.field_card_id)) {
        break label188;
      }
      localb.dvO = paramn.field_card_id;
      am.bQn().putValue("key_accept_card_info", paramn);
    }
    for (;;)
    {
      com.tencent.mm.kernel.g.agQ().ghe.b(1037, this);
      this.nSX.dvN = localb;
      bPu();
      AppMethodBeat.o(112571);
      return;
      label188:
      ac.i("MicroMsg.AccessCardEventListener", "NetSceneAcceptCardItem doscene return card_id is empty ");
      localb.dvO = "";
      break;
      label205:
      ac.i("MicroMsg.AccessCardEventListener", "NetSceneAcceptCardItem doscene return false, retCode " + paramInt1 + " retMsg" + paramn);
      localb.deB = false;
      continue;
      label245:
      ac.i("MicroMsg.AccessCardEventListener", "NetSceneAcceptCardItem doscene is fail");
      localb.deB = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.card.b.a
 * JD-Core Version:    0.7.0.1
 */