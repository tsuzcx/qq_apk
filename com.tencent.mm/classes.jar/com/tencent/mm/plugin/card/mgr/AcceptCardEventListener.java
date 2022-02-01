package com.tencent.mm.plugin.card.mgr;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.p;
import com.tencent.mm.am.s;
import com.tencent.mm.autogen.a.xe;
import com.tencent.mm.autogen.a.xe.a;
import com.tencent.mm.autogen.a.xe.b;
import com.tencent.mm.kernel.c;
import com.tencent.mm.plugin.card.model.CardInfo;
import com.tencent.mm.plugin.card.model.am;
import com.tencent.mm.plugin.card.model.o;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;

public class AcceptCardEventListener
  extends IListener<xe>
  implements com.tencent.mm.am.h
{
  private xe wrd;
  
  public AcceptCardEventListener()
  {
    super(com.tencent.mm.app.f.hfK);
    AppMethodBeat.i(161192);
    this.__eventId = xe.class.getName().hashCode();
    AppMethodBeat.o(161192);
  }
  
  private boolean a(xe paramxe)
  {
    AppMethodBeat.i(112570);
    if (!com.tencent.mm.kernel.h.baz())
    {
      Log.e("MicroMsg.AccessCardEventListener", "ShakeAcceptCouponCardEvent account is not ready");
      AppMethodBeat.o(112570);
      return false;
    }
    if ((paramxe instanceof xe))
    {
      this.wrd = paramxe;
      paramxe = this.wrd.iaG.iaI;
      String str = this.wrd.iaG.iaJ;
      int i = this.wrd.iaG.iaK;
      if (TextUtils.isEmpty(paramxe))
      {
        Log.e("MicroMsg.AccessCardEventListener", "ShakeAcceptCouponCardEvent card_id is empty");
        djV();
        AppMethodBeat.o(112570);
        return false;
      }
      com.tencent.mm.kernel.h.baD().mCm.a(1037, this);
      Log.i("MicroMsg.AccessCardEventListener", "ShakeAcceptCouponCardEvent doscene from scene ".concat(String.valueOf(i)));
      paramxe = new o(paramxe, i, "", str, "", "", 0, 0, null);
      com.tencent.mm.kernel.h.baD().mCm.a(paramxe, 0);
      AppMethodBeat.o(112570);
      return true;
    }
    AppMethodBeat.o(112570);
    return false;
  }
  
  private void djV()
  {
    AppMethodBeat.i(112572);
    if (this.wrd.callback != null) {
      this.wrd.callback.run();
    }
    this.wrd = null;
    AppMethodBeat.o(112572);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, p paramp)
  {
    AppMethodBeat.i(112571);
    xe.b localb;
    if ((paramp instanceof o))
    {
      localb = new xe.b();
      Log.i("MicroMsg.AccessCardEventListener", "NetSceneAcceptCardItem doscene return errcode " + paramInt2 + " errmsg" + paramString);
      if ((paramInt1 != 0) || (paramInt2 != 0)) {
        break label245;
      }
      Log.i("MicroMsg.AccessCardEventListener", "NetSceneAcceptCardItem doscene is success");
      paramp = (o)paramp;
      paramInt1 = paramp.wuz;
      paramString = paramp.wuy;
      paramp = paramp.wuA;
      if (paramInt1 != 0) {
        break label205;
      }
      Log.i("MicroMsg.AccessCardEventListener", "NetSceneAcceptCardItem doscene return ok ");
      localb.isSuccess = true;
      paramp = new CardInfo();
      com.tencent.mm.plugin.card.c.f.a(paramp, paramString);
      if (TextUtils.isEmpty(paramp.field_card_id)) {
        break label188;
      }
      localb.iaI = paramp.field_card_id;
      am.dkO().z("key_accept_card_info", paramp);
    }
    for (;;)
    {
      com.tencent.mm.kernel.h.baD().mCm.b(1037, this);
      this.wrd.iaH = localb;
      djV();
      AppMethodBeat.o(112571);
      return;
      label188:
      Log.i("MicroMsg.AccessCardEventListener", "NetSceneAcceptCardItem doscene return card_id is empty ");
      localb.iaI = "";
      break;
      label205:
      Log.i("MicroMsg.AccessCardEventListener", "NetSceneAcceptCardItem doscene return false, retCode " + paramInt1 + " retMsg" + paramp);
      localb.isSuccess = false;
      continue;
      label245:
      Log.i("MicroMsg.AccessCardEventListener", "NetSceneAcceptCardItem doscene is fail");
      localb.isSuccess = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.card.mgr.AcceptCardEventListener
 * JD-Core Version:    0.7.0.1
 */