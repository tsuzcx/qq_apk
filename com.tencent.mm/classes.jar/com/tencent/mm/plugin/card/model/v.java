package com.tencent.mm.plugin.card.model;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c;
import com.tencent.mm.am.c.a;
import com.tencent.mm.am.c.b;
import com.tencent.mm.am.c.c;
import com.tencent.mm.am.h;
import com.tencent.mm.am.p;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.plugin.card.c.u;
import com.tencent.mm.protocal.protobuf.wl;
import com.tencent.mm.protocal.protobuf.wm;
import com.tencent.mm.protocal.protobuf.wn;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.ArrayList;

public final class v
  extends p
  implements m
{
  private h callback;
  private final c rr;
  public String wuF;
  public ArrayList<wl> wuG;
  
  public v(String paramString1, float paramFloat1, float paramFloat2, String paramString2)
  {
    AppMethodBeat.i(112821);
    this.wuF = paramString1;
    Object localObject = new c.a();
    ((c.a)localObject).otE = new wm();
    ((c.a)localObject).otF = new wn();
    ((c.a)localObject).uri = "/cgi-bin/micromsg-bin/cardshoplbs";
    ((c.a)localObject).funcId = 1058;
    ((c.a)localObject).otG = 0;
    ((c.a)localObject).respCmdId = 0;
    this.rr = ((c.a)localObject).bEF();
    localObject = (wm)c.b.b(this.rr.otB);
    ((wm)localObject).wsy = paramString1;
    ((wm)localObject).longitude = paramFloat1;
    ((wm)localObject).latitude = paramFloat2;
    ((wm)localObject).iaI = paramString2;
    Log.d("MicroMsg.NetSceneCardShopLBS", "<init>, cardId = %s, longtitude = %f, latitude = %f, card_id = %s", new Object[] { paramString1, Float.valueOf(paramFloat1), Float.valueOf(paramFloat2), paramString2 });
    AppMethodBeat.o(112821);
  }
  
  public final int doScene(g paramg, h paramh)
  {
    AppMethodBeat.i(112822);
    if (Util.isNullOrNil(((wm)c.b.b(this.rr.otB)).wsy))
    {
      Log.e("MicroMsg.NetSceneCardShopLBS", "doScene fail, cardId is null");
      AppMethodBeat.o(112822);
      return -1;
    }
    this.callback = paramh;
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
      params = ((wn)c.c.b(this.rr.otC)).wuy;
      if (TextUtils.isEmpty(params)) {
        Log.e("MicroMsg.NetSceneCardShopLBS", "onGYNetEnd fail, json_ret is empty");
      }
      this.wuG = u.alH(params);
      if (this.wuG != null) {
        Log.d("MicroMsg.NetSceneCardShopLBS", "onGYNetEnd, respList size = %d", new Object[] { Integer.valueOf(this.wuG.size()) });
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