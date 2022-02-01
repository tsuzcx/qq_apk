package com.tencent.mm.plugin.card.sharecard.model;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.b.c;
import com.tencent.mm.al.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.byb;
import com.tencent.mm.protocal.protobuf.byc;
import com.tencent.mm.sdk.platformtools.ad;
import org.json.JSONException;
import org.json.JSONObject;

public final class f
  extends n
  implements k
{
  private com.tencent.mm.al.f callback;
  public String oBE;
  public int oxA;
  public String oxB;
  public int oxC;
  public String oxD;
  public String oxz;
  private final b rr;
  
  public f(String paramString, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(112969);
    this.oxA = 0;
    Object localObject = new b.a();
    ((b.a)localObject).hNM = new byb();
    ((b.a)localObject).hNN = new byc();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/marksharecard";
    ((b.a)localObject).funcId = 1078;
    ((b.a)localObject).hNO = 0;
    ((b.a)localObject).respCmdId = 0;
    this.rr = ((b.a)localObject).aDC();
    localObject = (byb)this.rr.hNK.hNQ;
    ((byb)localObject).dHX = paramString;
    ((byb)localObject).GRX = paramInt2;
    ((byb)localObject).GRW = paramInt1;
    ((byb)localObject).scene = paramInt3;
    this.oBE = paramString;
    AppMethodBeat.o(112969);
  }
  
  public final int doScene(e parame, com.tencent.mm.al.f paramf)
  {
    AppMethodBeat.i(112971);
    this.callback = paramf;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(112971);
    return i;
  }
  
  public final int getType()
  {
    return 1078;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(112970);
    ad.i("MicroMsg.NetSceneMarkShareCard", "onGYNetEnd, cmdType = %d, errType = %d, errCode = %d", new Object[] { Integer.valueOf(getType()), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      paramq = (byc)this.rr.hNL.hNQ;
      ad.i("MicroMsg.NetSceneMarkShareCard", "json_ret:" + paramq.ozQ);
      paramq = paramq.ozQ;
      if (!TextUtils.isEmpty(paramq)) {
        break label130;
      }
      ad.e("MicroMsg.NetSceneMarkShareCard", "parseJson json_ret is empty!");
    }
    for (;;)
    {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(112970);
      return;
      try
      {
        label130:
        paramq = new JSONObject(paramq);
        this.oxz = paramq.optString("mark_user");
        this.oxA = paramq.optInt("mark_succ", 0);
        this.oxB = paramq.optString("mark_card_id");
        this.oxC = paramq.optInt("expire_time", 0);
        this.oxD = paramq.optString("pay_qrcode_wording");
      }
      catch (JSONException paramq)
      {
        ad.printErrStackTrace("MicroMsg.NetSceneMarkShareCard", paramq, "", new Object[0]);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.card.sharecard.model.f
 * JD-Core Version:    0.7.0.1
 */