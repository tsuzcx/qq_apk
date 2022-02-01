package com.tencent.mm.plugin.card.model;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.b.c;
import com.tencent.mm.al.f;
import com.tencent.mm.al.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.card.d.u;
import com.tencent.mm.protocal.protobuf.tl;
import com.tencent.mm.protocal.protobuf.tm;
import com.tencent.mm.protocal.protobuf.tn;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import java.util.ArrayList;

public final class v
  extends n
  implements k
{
  private f callback;
  public String ozX;
  public ArrayList<tl> ozY;
  private final b rr;
  
  public v(String paramString1, float paramFloat1, float paramFloat2, String paramString2)
  {
    AppMethodBeat.i(112821);
    this.ozX = paramString1;
    Object localObject = new b.a();
    ((b.a)localObject).hNM = new tm();
    ((b.a)localObject).hNN = new tn();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/cardshoplbs";
    ((b.a)localObject).funcId = 1058;
    ((b.a)localObject).hNO = 0;
    ((b.a)localObject).respCmdId = 0;
    this.rr = ((b.a)localObject).aDC();
    localObject = (tm)this.rr.hNK.hNQ;
    ((tm)localObject).oxM = paramString1;
    ((tm)localObject).dAp = paramFloat1;
    ((tm)localObject).dyz = paramFloat2;
    ((tm)localObject).dHX = paramString2;
    ad.d("MicroMsg.NetSceneCardShopLBS", "<init>, cardId = %s, longtitude = %f, latitude = %f, card_id = %s", new Object[] { paramString1, Float.valueOf(paramFloat1), Float.valueOf(paramFloat2), paramString2 });
    AppMethodBeat.o(112821);
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(112822);
    if (bt.isNullOrNil(((tm)this.rr.hNK.hNQ).oxM))
    {
      ad.e("MicroMsg.NetSceneCardShopLBS", "doScene fail, cardId is null");
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
    ad.i("MicroMsg.NetSceneCardShopLBS", "onGYNetEnd, errType = %d, errCode = %d", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      paramq = ((tn)this.rr.hNL.hNQ).ozQ;
      if (TextUtils.isEmpty(paramq)) {
        ad.e("MicroMsg.NetSceneCardShopLBS", "onGYNetEnd fail, json_ret is empty");
      }
      this.ozY = u.Zt(paramq);
      if (this.ozY != null) {
        ad.d("MicroMsg.NetSceneCardShopLBS", "onGYNetEnd, respList size = %d", new Object[] { Integer.valueOf(this.ozY.size()) });
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