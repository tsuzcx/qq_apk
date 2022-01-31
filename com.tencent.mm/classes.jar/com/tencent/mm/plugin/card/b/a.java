package com.tencent.mm.plugin.card.b;

import android.text.TextUtils;
import com.tencent.mm.ah.m;
import com.tencent.mm.ah.p;
import com.tencent.mm.h.a.pm;
import com.tencent.mm.h.a.pm.a;
import com.tencent.mm.h.a.pm.b;
import com.tencent.mm.kernel.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.card.model.CardInfo;
import com.tencent.mm.plugin.card.model.am;
import com.tencent.mm.plugin.card.model.o;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.y;

public final class a
  extends c<pm>
  implements com.tencent.mm.ah.f
{
  private pm ijS;
  
  public a()
  {
    this.udX = pm.class.getName().hashCode();
  }
  
  private boolean a(pm parampm)
  {
    if (!g.DK()) {
      y.e("MicroMsg.AccessCardEventListener", "ShakeAcceptCouponCardEvent account is not ready");
    }
    while (!(parampm instanceof pm)) {
      return false;
    }
    this.ijS = parampm;
    parampm = this.ijS.bZa.bZc;
    String str = this.ijS.bZa.bZd;
    int i = this.ijS.bZa.bZe;
    if (TextUtils.isEmpty(parampm))
    {
      y.e("MicroMsg.AccessCardEventListener", "ShakeAcceptCouponCardEvent card_id is empty");
      azJ();
      return false;
    }
    g.DO().dJT.a(651, this);
    y.i("MicroMsg.AccessCardEventListener", "ShakeAcceptCouponCardEvent doscene from scene " + i);
    parampm = new o(parampm, i, "", str, "", "", 0, 0, null);
    g.DO().dJT.a(parampm, 0);
    return true;
  }
  
  private void azJ()
  {
    if (this.ijS.bFJ != null) {
      this.ijS.bFJ.run();
    }
    this.ijS = null;
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    pm.b localb;
    if ((paramm instanceof o))
    {
      localb = new pm.b();
      y.i("MicroMsg.AccessCardEventListener", "NetSceneAcceptCardItem doscene return errcode " + paramInt2 + " errmsg" + paramString);
      if ((paramInt1 != 0) || (paramInt2 != 0)) {
        break label235;
      }
      y.i("MicroMsg.AccessCardEventListener", "NetSceneAcceptCardItem doscene is success");
      paramm = (o)paramm;
      paramInt1 = paramm.ino;
      paramString = paramm.inn;
      paramm = paramm.inp;
      if (paramInt1 != 0) {
        break label195;
      }
      y.i("MicroMsg.AccessCardEventListener", "NetSceneAcceptCardItem doscene return ok ");
      localb.bKQ = true;
      paramm = new CardInfo();
      com.tencent.mm.plugin.card.d.f.a(paramm, paramString);
      if (TextUtils.isEmpty(paramm.field_card_id)) {
        break label178;
      }
      localb.bZc = paramm.field_card_id;
      am.aAx().putValue("key_accept_card_info", paramm);
    }
    for (;;)
    {
      g.DO().dJT.b(651, this);
      this.ijS.bZb = localb;
      azJ();
      return;
      label178:
      y.i("MicroMsg.AccessCardEventListener", "NetSceneAcceptCardItem doscene return card_id is empty ");
      localb.bZc = "";
      break;
      label195:
      y.i("MicroMsg.AccessCardEventListener", "NetSceneAcceptCardItem doscene return false, retCode " + paramInt1 + " retMsg" + paramm);
      localb.bKQ = false;
      continue;
      label235:
      y.i("MicroMsg.AccessCardEventListener", "NetSceneAcceptCardItem doscene is fail");
      localb.bKQ = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.card.b.a
 * JD-Core Version:    0.7.0.1
 */