package com.tencent.mm.plugin.card.sharecard.model;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.b.b;
import com.tencent.mm.ai.b.c;
import com.tencent.mm.ai.m;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.bcl;
import com.tencent.mm.protocal.protobuf.bcm;
import com.tencent.mm.sdk.platformtools.ab;
import org.json.JSONException;
import org.json.JSONObject;

public final class f
  extends m
  implements k
{
  private com.tencent.mm.ai.f callback;
  public String klY;
  public int klZ;
  public String kma;
  public int kmb;
  public String kmc;
  public String kpQ;
  private final b rr;
  
  public f(String paramString, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(88030);
    this.klZ = 0;
    Object localObject = new b.a();
    ((b.a)localObject).fsX = new bcl();
    ((b.a)localObject).fsY = new bcm();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/marksharecard";
    ((b.a)localObject).funcId = 907;
    ((b.a)localObject).reqCmdId = 0;
    ((b.a)localObject).respCmdId = 0;
    this.rr = ((b.a)localObject).ado();
    localObject = (bcl)this.rr.fsV.fta;
    ((bcl)localObject).cHn = paramString;
    ((bcl)localObject).xrv = paramInt2;
    ((bcl)localObject).xru = paramInt1;
    ((bcl)localObject).scene = paramInt3;
    this.kpQ = paramString;
    AppMethodBeat.o(88030);
  }
  
  public final int doScene(e parame, com.tencent.mm.ai.f paramf)
  {
    AppMethodBeat.i(88032);
    this.callback = paramf;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(88032);
    return i;
  }
  
  public final int getType()
  {
    return 907;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(88031);
    ab.i("MicroMsg.NetSceneMarkShareCard", "onGYNetEnd, cmdType = %d, errType = %d, errCode = %d", new Object[] { Integer.valueOf(getType()), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      paramq = (bcm)this.rr.fsW.fta;
      ab.i("MicroMsg.NetSceneMarkShareCard", "json_ret:" + paramq.koi);
      paramq = paramq.koi;
      if (!TextUtils.isEmpty(paramq)) {
        break label130;
      }
      ab.e("MicroMsg.NetSceneMarkShareCard", "parseJson json_ret is empty!");
    }
    for (;;)
    {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(88031);
      return;
      try
      {
        label130:
        paramq = new JSONObject(paramq);
        this.klY = paramq.optString("mark_user");
        this.klZ = paramq.optInt("mark_succ", 0);
        this.kma = paramq.optString("mark_card_id");
        this.kmb = paramq.optInt("expire_time", 0);
        this.kmc = paramq.optString("pay_qrcode_wording");
      }
      catch (JSONException paramq)
      {
        ab.printErrStackTrace("MicroMsg.NetSceneMarkShareCard", paramq, "", new Object[0]);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.card.sharecard.model.f
 * JD-Core Version:    0.7.0.1
 */