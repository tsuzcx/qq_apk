package com.tencent.mm.plugin.card.b;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.ak.t;
import com.tencent.mm.g.a.ul;
import com.tencent.mm.g.a.ul.a;
import com.tencent.mm.g.a.ul.b;
import com.tencent.mm.kernel.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.card.d.f;
import com.tencent.mm.plugin.card.model.CardInfo;
import com.tencent.mm.plugin.card.model.am;
import com.tencent.mm.plugin.card.model.o;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;

public final class a
  extends IListener<ul>
  implements i
{
  private ul pQD;
  
  public a()
  {
    AppMethodBeat.i(161192);
    this.__eventId = ul.class.getName().hashCode();
    AppMethodBeat.o(161192);
  }
  
  private boolean a(ul paramul)
  {
    AppMethodBeat.i(112570);
    if (!g.aAc())
    {
      Log.e("MicroMsg.AccessCardEventListener", "ShakeAcceptCouponCardEvent account is not ready");
      AppMethodBeat.o(112570);
      return false;
    }
    if ((paramul instanceof ul))
    {
      this.pQD = paramul;
      paramul = this.pQD.eaM.eaO;
      String str = this.pQD.eaM.eaP;
      int i = this.pQD.eaM.eaQ;
      if (TextUtils.isEmpty(paramul))
      {
        Log.e("MicroMsg.AccessCardEventListener", "ShakeAcceptCouponCardEvent card_id is empty");
        ctc();
        AppMethodBeat.o(112570);
        return false;
      }
      g.aAg().hqi.a(1037, this);
      Log.i("MicroMsg.AccessCardEventListener", "ShakeAcceptCouponCardEvent doscene from scene ".concat(String.valueOf(i)));
      paramul = new o(paramul, i, "", str, "", "", 0, 0, null);
      g.aAg().hqi.a(paramul, 0);
      AppMethodBeat.o(112570);
      return true;
    }
    AppMethodBeat.o(112570);
    return false;
  }
  
  private void ctc()
  {
    AppMethodBeat.i(112572);
    if (this.pQD.callback != null) {
      this.pQD.callback.run();
    }
    this.pQD = null;
    AppMethodBeat.o(112572);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    AppMethodBeat.i(112571);
    ul.b localb;
    if ((paramq instanceof o))
    {
      localb = new ul.b();
      Log.i("MicroMsg.AccessCardEventListener", "NetSceneAcceptCardItem doscene return errcode " + paramInt2 + " errmsg" + paramString);
      if ((paramInt1 != 0) || (paramInt2 != 0)) {
        break label245;
      }
      Log.i("MicroMsg.AccessCardEventListener", "NetSceneAcceptCardItem doscene is success");
      paramq = (o)paramq;
      paramInt1 = paramq.pTZ;
      paramString = paramq.pTY;
      paramq = paramq.pUa;
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
      localb.eaO = paramq.field_card_id;
      am.ctV().putValue("key_accept_card_info", paramq);
    }
    for (;;)
    {
      g.aAg().hqi.b(1037, this);
      this.pQD.eaN = localb;
      ctc();
      AppMethodBeat.o(112571);
      return;
      label188:
      Log.i("MicroMsg.AccessCardEventListener", "NetSceneAcceptCardItem doscene return card_id is empty ");
      localb.eaO = "";
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