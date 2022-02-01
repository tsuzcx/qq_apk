package com.tencent.mm.plugin.card.sharecard.model;

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
import com.tencent.mm.protocal.protobuf.btn;
import com.tencent.mm.protocal.protobuf.bto;
import com.tencent.mm.sdk.platformtools.ac;
import org.json.JSONException;
import org.json.JSONObject;

public final class f
  extends n
  implements k
{
  private g callback;
  public String nUe;
  public int nUf;
  public String nUg;
  public int nUh;
  public String nUi;
  public String nYk;
  private final b rr;
  
  public f(String paramString, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(112969);
    this.nUf = 0;
    Object localObject = new b.a();
    ((b.a)localObject).hvt = new btn();
    ((b.a)localObject).hvu = new bto();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/marksharecard";
    ((b.a)localObject).funcId = 1078;
    ((b.a)localObject).reqCmdId = 0;
    ((b.a)localObject).respCmdId = 0;
    this.rr = ((b.a)localObject).aAz();
    localObject = (btn)this.rr.hvr.hvw;
    ((btn)localObject).dvO = paramString;
    ((btn)localObject).Fiw = paramInt2;
    ((btn)localObject).Fiv = paramInt1;
    ((btn)localObject).scene = paramInt3;
    this.nYk = paramString;
    AppMethodBeat.o(112969);
  }
  
  public final int doScene(e parame, g paramg)
  {
    AppMethodBeat.i(112971);
    this.callback = paramg;
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
    ac.i("MicroMsg.NetSceneMarkShareCard", "onGYNetEnd, cmdType = %d, errType = %d, errCode = %d", new Object[] { Integer.valueOf(getType()), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      paramq = (bto)this.rr.hvs.hvw;
      ac.i("MicroMsg.NetSceneMarkShareCard", "json_ret:" + paramq.nWw);
      paramq = paramq.nWw;
      if (!TextUtils.isEmpty(paramq)) {
        break label130;
      }
      ac.e("MicroMsg.NetSceneMarkShareCard", "parseJson json_ret is empty!");
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
        this.nUe = paramq.optString("mark_user");
        this.nUf = paramq.optInt("mark_succ", 0);
        this.nUg = paramq.optString("mark_card_id");
        this.nUh = paramq.optInt("expire_time", 0);
        this.nUi = paramq.optString("pay_qrcode_wording");
      }
      catch (JSONException paramq)
      {
        ac.printErrStackTrace("MicroMsg.NetSceneMarkShareCard", paramq, "", new Object[0]);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.card.sharecard.model.f
 * JD-Core Version:    0.7.0.1
 */