package com.tencent.mm.plugin.card.model;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.b.b;
import com.tencent.mm.ai.b.c;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.card.d.t;
import com.tencent.mm.protocal.protobuf.oz;
import com.tencent.mm.protocal.protobuf.pa;
import com.tencent.mm.protocal.protobuf.pb;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.ArrayList;

public final class v
  extends m
  implements k
{
  private f callback;
  public String koq;
  public ArrayList<oz> kor;
  private final b rr;
  
  public v(String paramString1, float paramFloat1, float paramFloat2, String paramString2)
  {
    AppMethodBeat.i(87879);
    this.koq = paramString1;
    Object localObject = new b.a();
    ((b.a)localObject).fsX = new pa();
    ((b.a)localObject).fsY = new pb();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/cardshoplbs";
    ((b.a)localObject).funcId = 563;
    ((b.a)localObject).reqCmdId = 0;
    ((b.a)localObject).respCmdId = 0;
    this.rr = ((b.a)localObject).ado();
    localObject = (pa)this.rr.fsV.fta;
    ((pa)localObject).kml = paramString1;
    ((pa)localObject).cAH = paramFloat1;
    ((pa)localObject).cyV = paramFloat2;
    ((pa)localObject).cHn = paramString2;
    ab.d("MicroMsg.NetSceneCardShopLBS", "<init>, cardId = %s, longtitude = %f, latitude = %f, card_id = %s", new Object[] { paramString1, Float.valueOf(paramFloat1), Float.valueOf(paramFloat2), paramString2 });
    AppMethodBeat.o(87879);
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(87880);
    if (bo.isNullOrNil(((pa)this.rr.fsV.fta).kml))
    {
      ab.e("MicroMsg.NetSceneCardShopLBS", "doScene fail, cardId is null");
      AppMethodBeat.o(87880);
      return -1;
    }
    this.callback = paramf;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(87880);
    return i;
  }
  
  public final int getType()
  {
    return 563;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(87881);
    ab.i("MicroMsg.NetSceneCardShopLBS", "onGYNetEnd, errType = %d, errCode = %d", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      paramq = ((pb)this.rr.fsW.fta).koi;
      if (TextUtils.isEmpty(paramq)) {
        ab.e("MicroMsg.NetSceneCardShopLBS", "onGYNetEnd fail, json_ret is empty");
      }
      this.kor = t.IN(paramq);
      if (this.kor != null) {
        ab.d("MicroMsg.NetSceneCardShopLBS", "onGYNetEnd, respList size = %d", new Object[] { Integer.valueOf(this.kor.size()) });
      }
    }
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(87881);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.card.model.v
 * JD-Core Version:    0.7.0.1
 */