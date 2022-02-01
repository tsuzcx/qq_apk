package com.tencent.mm.plugin.card.sharecard.model;

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
import com.tencent.mm.protocal.protobuf.dml;
import com.tencent.mm.protocal.protobuf.dmm;
import com.tencent.mm.sdk.platformtools.Log;
import org.json.JSONException;
import org.json.JSONObject;

public final class f
  extends p
  implements m
{
  private h callback;
  private final c rr;
  public String wsl;
  public int wsm;
  public String wsn;
  public int wso;
  public String wsp;
  public String wwt;
  
  public f(String paramString, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(112969);
    this.wsm = 0;
    Object localObject = new c.a();
    ((c.a)localObject).otE = new dml();
    ((c.a)localObject).otF = new dmm();
    ((c.a)localObject).uri = "/cgi-bin/micromsg-bin/marksharecard";
    ((c.a)localObject).funcId = 1078;
    ((c.a)localObject).otG = 0;
    ((c.a)localObject).respCmdId = 0;
    this.rr = ((c.a)localObject).bEF();
    localObject = (dml)c.b.b(this.rr.otB);
    ((dml)localObject).iaI = paramString;
    ((dml)localObject).aaSz = paramInt2;
    ((dml)localObject).aaSy = paramInt1;
    ((dml)localObject).scene = paramInt3;
    this.wwt = paramString;
    AppMethodBeat.o(112969);
  }
  
  public final int doScene(g paramg, h paramh)
  {
    AppMethodBeat.i(112971);
    this.callback = paramh;
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
      params = (dmm)c.c.b(this.rr.otC);
      Log.i("MicroMsg.NetSceneMarkShareCard", "json_ret:" + params.wuy);
      params = params.wuy;
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
        this.wsl = params.optString("mark_user");
        this.wsm = params.optInt("mark_succ", 0);
        this.wsn = params.optString("mark_card_id");
        this.wso = params.optInt("expire_time", 0);
        this.wsp = params.optString("pay_qrcode_wording");
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