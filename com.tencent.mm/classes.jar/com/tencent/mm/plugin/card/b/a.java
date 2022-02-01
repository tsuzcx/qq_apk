package com.tencent.mm.plugin.card.b;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.n;
import com.tencent.mm.ak.q;
import com.tencent.mm.g.a.tn;
import com.tencent.mm.g.a.tn.a;
import com.tencent.mm.g.a.tn.b;
import com.tencent.mm.kernel.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.card.model.CardInfo;
import com.tencent.mm.plugin.card.model.am;
import com.tencent.mm.plugin.card.model.o;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ae;

public final class a
  extends c<tn>
  implements com.tencent.mm.ak.f
{
  private tn oCU;
  
  public a()
  {
    AppMethodBeat.i(161192);
    this.__eventId = tn.class.getName().hashCode();
    AppMethodBeat.o(161192);
  }
  
  private boolean a(tn paramtn)
  {
    AppMethodBeat.i(112570);
    if (!g.ajM())
    {
      ae.e("MicroMsg.AccessCardEventListener", "ShakeAcceptCouponCardEvent account is not ready");
      AppMethodBeat.o(112570);
      return false;
    }
    if ((paramtn instanceof tn))
    {
      this.oCU = paramtn;
      paramtn = this.oCU.dIZ.dJb;
      String str = this.oCU.dIZ.dJc;
      int i = this.oCU.dIZ.dJd;
      if (TextUtils.isEmpty(paramtn))
      {
        ae.e("MicroMsg.AccessCardEventListener", "ShakeAcceptCouponCardEvent card_id is empty");
        bVo();
        AppMethodBeat.o(112570);
        return false;
      }
      g.ajQ().gDv.a(1037, this);
      ae.i("MicroMsg.AccessCardEventListener", "ShakeAcceptCouponCardEvent doscene from scene ".concat(String.valueOf(i)));
      paramtn = new o(paramtn, i, "", str, "", "", 0, 0, null);
      g.ajQ().gDv.a(paramtn, 0);
      AppMethodBeat.o(112570);
      return true;
    }
    AppMethodBeat.o(112570);
    return false;
  }
  
  private void bVo()
  {
    AppMethodBeat.i(112572);
    if (this.oCU.callback != null) {
      this.oCU.callback.run();
    }
    this.oCU = null;
    AppMethodBeat.o(112572);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(112571);
    tn.b localb;
    if ((paramn instanceof o))
    {
      localb = new tn.b();
      ae.i("MicroMsg.AccessCardEventListener", "NetSceneAcceptCardItem doscene return errcode " + paramInt2 + " errmsg" + paramString);
      if ((paramInt1 != 0) || (paramInt2 != 0)) {
        break label245;
      }
      ae.i("MicroMsg.AccessCardEventListener", "NetSceneAcceptCardItem doscene is success");
      paramn = (o)paramn;
      paramInt1 = paramn.oGt;
      paramString = paramn.oGs;
      paramn = paramn.oGu;
      if (paramInt1 != 0) {
        break label205;
      }
      ae.i("MicroMsg.AccessCardEventListener", "NetSceneAcceptCardItem doscene return ok ");
      localb.drc = true;
      paramn = new CardInfo();
      com.tencent.mm.plugin.card.d.f.a(paramn, paramString);
      if (TextUtils.isEmpty(paramn.field_card_id)) {
        break label188;
      }
      localb.dJb = paramn.field_card_id;
      am.bWh().putValue("key_accept_card_info", paramn);
    }
    for (;;)
    {
      g.ajQ().gDv.b(1037, this);
      this.oCU.dJa = localb;
      bVo();
      AppMethodBeat.o(112571);
      return;
      label188:
      ae.i("MicroMsg.AccessCardEventListener", "NetSceneAcceptCardItem doscene return card_id is empty ");
      localb.dJb = "";
      break;
      label205:
      ae.i("MicroMsg.AccessCardEventListener", "NetSceneAcceptCardItem doscene return false, retCode " + paramInt1 + " retMsg" + paramn);
      localb.drc = false;
      continue;
      label245:
      ae.i("MicroMsg.AccessCardEventListener", "NetSceneAcceptCardItem doscene is fail");
      localb.drc = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.card.b.a
 * JD-Core Version:    0.7.0.1
 */