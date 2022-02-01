package com.tencent.mm.plugin.card.model;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.g;
import com.tencent.mm.ak.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.card.d.u;
import com.tencent.mm.protocal.protobuf.rr;
import com.tencent.mm.protocal.protobuf.rs;
import com.tencent.mm.protocal.protobuf.rt;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import java.util.ArrayList;

public final class v
  extends n
  implements k
{
  private g callback;
  public String nWD;
  public ArrayList<rr> nWE;
  private final b rr;
  
  public v(String paramString1, float paramFloat1, float paramFloat2, String paramString2)
  {
    AppMethodBeat.i(112821);
    this.nWD = paramString1;
    Object localObject = new b.a();
    ((b.a)localObject).hvt = new rs();
    ((b.a)localObject).hvu = new rt();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/cardshoplbs";
    ((b.a)localObject).funcId = 1058;
    ((b.a)localObject).reqCmdId = 0;
    ((b.a)localObject).respCmdId = 0;
    this.rr = ((b.a)localObject).aAz();
    localObject = (rs)this.rr.hvr.hvw;
    ((rs)localObject).nUr = paramString1;
    ((rs)localObject).doB = paramFloat1;
    ((rs)localObject).dmL = paramFloat2;
    ((rs)localObject).dvO = paramString2;
    ac.d("MicroMsg.NetSceneCardShopLBS", "<init>, cardId = %s, longtitude = %f, latitude = %f, card_id = %s", new Object[] { paramString1, Float.valueOf(paramFloat1), Float.valueOf(paramFloat2), paramString2 });
    AppMethodBeat.o(112821);
  }
  
  public final int doScene(e parame, g paramg)
  {
    AppMethodBeat.i(112822);
    if (bs.isNullOrNil(((rs)this.rr.hvr.hvw).nUr))
    {
      ac.e("MicroMsg.NetSceneCardShopLBS", "doScene fail, cardId is null");
      AppMethodBeat.o(112822);
      return -1;
    }
    this.callback = paramg;
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
    ac.i("MicroMsg.NetSceneCardShopLBS", "onGYNetEnd, errType = %d, errCode = %d", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      paramq = ((rt)this.rr.hvs.hvw).nWw;
      if (TextUtils.isEmpty(paramq)) {
        ac.e("MicroMsg.NetSceneCardShopLBS", "onGYNetEnd fail, json_ret is empty");
      }
      this.nWE = u.VK(paramq);
      if (this.nWE != null) {
        ac.d("MicroMsg.NetSceneCardShopLBS", "onGYNetEnd, respList size = %d", new Object[] { Integer.valueOf(this.nWE.size()) });
      }
    }
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(112823);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.card.model.v
 * JD-Core Version:    0.7.0.1
 */