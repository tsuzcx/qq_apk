package com.tencent.mm.plugin.card.model;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.f;
import com.tencent.mm.ak.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.card.d.u;
import com.tencent.mm.protocal.protobuf.tn;
import com.tencent.mm.protocal.protobuf.to;
import com.tencent.mm.protocal.protobuf.tp;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import java.util.ArrayList;

public final class v
  extends n
  implements k
{
  private f callback;
  public ArrayList<tn> oGA;
  public String oGz;
  private final b rr;
  
  public v(String paramString1, float paramFloat1, float paramFloat2, String paramString2)
  {
    AppMethodBeat.i(112821);
    this.oGz = paramString1;
    Object localObject = new b.a();
    ((b.a)localObject).hQF = new to();
    ((b.a)localObject).hQG = new tp();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/cardshoplbs";
    ((b.a)localObject).funcId = 1058;
    ((b.a)localObject).hQH = 0;
    ((b.a)localObject).respCmdId = 0;
    this.rr = ((b.a)localObject).aDS();
    localObject = (to)this.rr.hQD.hQJ;
    ((to)localObject).oEo = paramString1;
    ((to)localObject).dBu = paramFloat1;
    ((to)localObject).dzE = paramFloat2;
    ((to)localObject).dJb = paramString2;
    ae.d("MicroMsg.NetSceneCardShopLBS", "<init>, cardId = %s, longtitude = %f, latitude = %f, card_id = %s", new Object[] { paramString1, Float.valueOf(paramFloat1), Float.valueOf(paramFloat2), paramString2 });
    AppMethodBeat.o(112821);
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(112822);
    if (bu.isNullOrNil(((to)this.rr.hQD.hQJ).oEo))
    {
      ae.e("MicroMsg.NetSceneCardShopLBS", "doScene fail, cardId is null");
      AppMethodBeat.o(112822);
      return -1;
    }
    this.callback = paramf;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(112822);
    return i;
  }
  
  public final int getType()
  {
    return 1058;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(112823);
    ae.i("MicroMsg.NetSceneCardShopLBS", "onGYNetEnd, errType = %d, errCode = %d", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      paramq = ((tp)this.rr.hQE.hQJ).oGs;
      if (TextUtils.isEmpty(paramq)) {
        ae.e("MicroMsg.NetSceneCardShopLBS", "onGYNetEnd fail, json_ret is empty");
      }
      this.oGA = u.aak(paramq);
      if (this.oGA != null) {
        ae.d("MicroMsg.NetSceneCardShopLBS", "onGYNetEnd, respList size = %d", new Object[] { Integer.valueOf(this.oGA.size()) });
      }
    }
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(112823);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.card.model.v
 * JD-Core Version:    0.7.0.1
 */