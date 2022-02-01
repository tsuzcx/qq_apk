package com.tencent.mm.plugin.card.sharecard.model;

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
import com.tencent.mm.protocal.protobuf.cmn;
import com.tencent.mm.protocal.protobuf.cmo;
import com.tencent.mm.sdk.platformtools.Log;
import org.json.JSONException;
import org.json.JSONObject;

public final class f
  extends q
  implements m
{
  private i callback;
  public String pRK;
  public int pRL;
  public String pRM;
  public int pRN;
  public String pRO;
  public String pVU;
  private final d rr;
  
  public f(String paramString, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(112969);
    this.pRL = 0;
    Object localObject = new d.a();
    ((d.a)localObject).iLN = new cmn();
    ((d.a)localObject).iLO = new cmo();
    ((d.a)localObject).uri = "/cgi-bin/micromsg-bin/marksharecard";
    ((d.a)localObject).funcId = 1078;
    ((d.a)localObject).iLP = 0;
    ((d.a)localObject).respCmdId = 0;
    this.rr = ((d.a)localObject).aXF();
    localObject = (cmn)this.rr.iLK.iLR;
    ((cmn)localObject).eaO = paramString;
    ((cmn)localObject).MrL = paramInt2;
    ((cmn)localObject).MrK = paramInt1;
    ((cmn)localObject).scene = paramInt3;
    this.pVU = paramString;
    AppMethodBeat.o(112969);
  }
  
  public final int doScene(g paramg, i parami)
  {
    AppMethodBeat.i(112971);
    this.callback = parami;
    int i = dispatch(paramg, this.rr, this);
    AppMethodBeat.o(112971);
    return i;
  }
  
  public final int getType()
  {
    return 1078;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(112970);
    Log.i("MicroMsg.NetSceneMarkShareCard", "onGYNetEnd, cmdType = %d, errType = %d, errCode = %d", new Object[] { Integer.valueOf(getType()), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      params = (cmo)this.rr.iLL.iLR;
      Log.i("MicroMsg.NetSceneMarkShareCard", "json_ret:" + params.pTY);
      params = params.pTY;
      if (!TextUtils.isEmpty(params)) {
        break label130;
      }
      Log.e("MicroMsg.NetSceneMarkShareCard", "parseJson json_ret is empty!");
    }
    for (;;)
    {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(112970);
      return;
      try
      {
        label130:
        params = new JSONObject(params);
        this.pRK = params.optString("mark_user");
        this.pRL = params.optInt("mark_succ", 0);
        this.pRM = params.optString("mark_card_id");
        this.pRN = params.optInt("expire_time", 0);
        this.pRO = params.optString("pay_qrcode_wording");
      }
      catch (JSONException params)
      {
        Log.printErrStackTrace("MicroMsg.NetSceneMarkShareCard", params, "", new Object[0]);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.card.sharecard.model.f
 * JD-Core Version:    0.7.0.1
 */