package com.tencent.mm.plugin.card.b;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.m;
import com.tencent.mm.ai.p;
import com.tencent.mm.g.a.qt;
import com.tencent.mm.g.a.qt.a;
import com.tencent.mm.g.a.qt.b;
import com.tencent.mm.kernel.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.card.model.CardInfo;
import com.tencent.mm.plugin.card.model.am;
import com.tencent.mm.plugin.card.model.o;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ab;

public final class a
  extends c<qt>
  implements com.tencent.mm.ai.f
{
  private qt kkS;
  
  public a()
  {
    AppMethodBeat.i(87625);
    this.__eventId = qt.class.getName().hashCode();
    AppMethodBeat.o(87625);
  }
  
  private boolean a(qt paramqt)
  {
    AppMethodBeat.i(87626);
    if (!g.RG())
    {
      ab.e("MicroMsg.AccessCardEventListener", "ShakeAcceptCouponCardEvent account is not ready");
      AppMethodBeat.o(87626);
      return false;
    }
    if ((paramqt instanceof qt))
    {
      this.kkS = paramqt;
      paramqt = this.kkS.cHl.cHn;
      String str = this.kkS.cHl.cHo;
      int i = this.kkS.cHl.cHp;
      if (TextUtils.isEmpty(paramqt))
      {
        ab.e("MicroMsg.AccessCardEventListener", "ShakeAcceptCouponCardEvent card_id is empty");
        bbp();
        AppMethodBeat.o(87626);
        return false;
      }
      g.RK().eHt.a(651, this);
      ab.i("MicroMsg.AccessCardEventListener", "ShakeAcceptCouponCardEvent doscene from scene ".concat(String.valueOf(i)));
      paramqt = new o(paramqt, i, "", str, "", "", 0, 0, null);
      g.RK().eHt.a(paramqt, 0);
      AppMethodBeat.o(87626);
      return true;
    }
    AppMethodBeat.o(87626);
    return false;
  }
  
  private void bbp()
  {
    AppMethodBeat.i(87628);
    if (this.kkS.callback != null) {
      this.kkS.callback.run();
    }
    this.kkS = null;
    AppMethodBeat.o(87628);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    AppMethodBeat.i(87627);
    qt.b localb;
    if ((paramm instanceof o))
    {
      localb = new qt.b();
      ab.i("MicroMsg.AccessCardEventListener", "NetSceneAcceptCardItem doscene return errcode " + paramInt2 + " errmsg" + paramString);
      if ((paramInt1 != 0) || (paramInt2 != 0)) {
        break label245;
      }
      ab.i("MicroMsg.AccessCardEventListener", "NetSceneAcceptCardItem doscene is success");
      paramm = (o)paramm;
      paramInt1 = paramm.koj;
      paramString = paramm.koi;
      paramm = paramm.kok;
      if (paramInt1 != 0) {
        break label205;
      }
      ab.i("MicroMsg.AccessCardEventListener", "NetSceneAcceptCardItem doscene return ok ");
      localb.csk = true;
      paramm = new CardInfo();
      com.tencent.mm.plugin.card.d.f.a(paramm, paramString);
      if (TextUtils.isEmpty(paramm.field_card_id)) {
        break label188;
      }
      localb.cHn = paramm.field_card_id;
      am.bci().putValue("key_accept_card_info", paramm);
    }
    for (;;)
    {
      g.RK().eHt.b(651, this);
      this.kkS.cHm = localb;
      bbp();
      AppMethodBeat.o(87627);
      return;
      label188:
      ab.i("MicroMsg.AccessCardEventListener", "NetSceneAcceptCardItem doscene return card_id is empty ");
      localb.cHn = "";
      break;
      label205:
      ab.i("MicroMsg.AccessCardEventListener", "NetSceneAcceptCardItem doscene return false, retCode " + paramInt1 + " retMsg" + paramm);
      localb.csk = false;
      continue;
      label245:
      ab.i("MicroMsg.AccessCardEventListener", "NetSceneAcceptCardItem doscene is fail");
      localb.csk = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.card.b.a
 * JD-Core Version:    0.7.0.1
 */