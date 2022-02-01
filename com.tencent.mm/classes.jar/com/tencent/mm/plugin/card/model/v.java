package com.tencent.mm.plugin.card.model;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.ak.d.b;
import com.tencent.mm.ak.d.c;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.plugin.card.d.u;
import com.tencent.mm.protocal.protobuf.us;
import com.tencent.mm.protocal.protobuf.ut;
import com.tencent.mm.protocal.protobuf.uu;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.ArrayList;

public final class v
  extends q
  implements m
{
  private i callback;
  public String pUf;
  public ArrayList<us> pUg;
  private final d rr;
  
  public v(String paramString1, float paramFloat1, float paramFloat2, String paramString2)
  {
    AppMethodBeat.i(112821);
    this.pUf = paramString1;
    Object localObject = new d.a();
    ((d.a)localObject).iLN = new ut();
    ((d.a)localObject).iLO = new uu();
    ((d.a)localObject).uri = "/cgi-bin/micromsg-bin/cardshoplbs";
    ((d.a)localObject).funcId = 1058;
    ((d.a)localObject).iLP = 0;
    ((d.a)localObject).respCmdId = 0;
    this.rr = ((d.a)localObject).aXF();
    localObject = (ut)this.rr.iLK.iLR;
    ((ut)localObject).pRX = paramString1;
    ((ut)localObject).dTj = paramFloat1;
    ((ut)localObject).latitude = paramFloat2;
    ((ut)localObject).eaO = paramString2;
    Log.d("MicroMsg.NetSceneCardShopLBS", "<init>, cardId = %s, longtitude = %f, latitude = %f, card_id = %s", new Object[] { paramString1, Float.valueOf(paramFloat1), Float.valueOf(paramFloat2), paramString2 });
    AppMethodBeat.o(112821);
  }
  
  public final int doScene(g paramg, i parami)
  {
    AppMethodBeat.i(112822);
    if (Util.isNullOrNil(((ut)this.rr.iLK.iLR).pRX))
    {
      Log.e("MicroMsg.NetSceneCardShopLBS", "doScene fail, cardId is null");
      AppMethodBeat.o(112822);
      return -1;
    }
    this.callback = parami;
    int i = dispatch(paramg, this.rr, this);
    AppMethodBeat.o(112822);
    return i;
  }
  
  public final int getType()
  {
    return 1058;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(112823);
    Log.i("MicroMsg.NetSceneCardShopLBS", "onGYNetEnd, errType = %d, errCode = %d", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      params = ((uu)this.rr.iLL.iLR).pTY;
      if (TextUtils.isEmpty(params)) {
        Log.e("MicroMsg.NetSceneCardShopLBS", "onGYNetEnd fail, json_ret is empty");
      }
      this.pUg = u.akq(params);
      if (this.pUg != null) {
        Log.d("MicroMsg.NetSceneCardShopLBS", "onGYNetEnd, respList size = %d", new Object[] { Integer.valueOf(this.pUg.size()) });
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