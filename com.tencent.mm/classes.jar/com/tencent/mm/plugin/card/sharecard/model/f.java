package com.tencent.mm.plugin.card.sharecard.model;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.byv;
import com.tencent.mm.protocal.protobuf.byw;
import com.tencent.mm.sdk.platformtools.ae;
import org.json.JSONException;
import org.json.JSONObject;

public final class f
  extends n
  implements k
{
  private com.tencent.mm.ak.f callback;
  public String oEb;
  public int oEc;
  public String oEd;
  public int oEe;
  public String oEf;
  public String oIg;
  private final b rr;
  
  public f(String paramString, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(112969);
    this.oEc = 0;
    Object localObject = new b.a();
    ((b.a)localObject).hQF = new byv();
    ((b.a)localObject).hQG = new byw();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/marksharecard";
    ((b.a)localObject).funcId = 1078;
    ((b.a)localObject).hQH = 0;
    ((b.a)localObject).respCmdId = 0;
    this.rr = ((b.a)localObject).aDS();
    localObject = (byv)this.rr.hQD.hQJ;
    ((byv)localObject).dJb = paramString;
    ((byv)localObject).Hly = paramInt2;
    ((byv)localObject).Hlx = paramInt1;
    ((byv)localObject).scene = paramInt3;
    this.oIg = paramString;
    AppMethodBeat.o(112969);
  }
  
  public final int doScene(e parame, com.tencent.mm.ak.f paramf)
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
    ae.i("MicroMsg.NetSceneMarkShareCard", "onGYNetEnd, cmdType = %d, errType = %d, errCode = %d", new Object[] { Integer.valueOf(getType()), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      paramq = (byw)this.rr.hQE.hQJ;
      ae.i("MicroMsg.NetSceneMarkShareCard", "json_ret:" + paramq.oGs);
      paramq = paramq.oGs;
      if (!TextUtils.isEmpty(paramq)) {
        break label130;
      }
      ae.e("MicroMsg.NetSceneMarkShareCard", "parseJson json_ret is empty!");
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
        this.oEb = paramq.optString("mark_user");
        this.oEc = paramq.optInt("mark_succ", 0);
        this.oEd = paramq.optString("mark_card_id");
        this.oEe = paramq.optInt("expire_time", 0);
        this.oEf = paramq.optString("pay_qrcode_wording");
      }
      catch (JSONException paramq)
      {
        ae.printErrStackTrace("MicroMsg.NetSceneMarkShareCard", paramq, "", new Object[0]);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.card.sharecard.model.f
 * JD-Core Version:    0.7.0.1
 */