package com.tencent.mm.plugin.card.model;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.d;
import com.tencent.mm.an.d.a;
import com.tencent.mm.an.d.b;
import com.tencent.mm.an.d.c;
import com.tencent.mm.an.i;
import com.tencent.mm.an.q;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.bru;
import com.tencent.mm.protocal.protobuf.brv;
import com.tencent.mm.protocal.protobuf.uo;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.LinkedList;
import org.json.JSONException;
import org.json.JSONObject;

public final class ab
  extends q
  implements m
{
  private i callback;
  private final d rr;
  public String tpZ;
  public int tqk;
  public String tql;
  public int tqm;
  public String tqn;
  
  public ab(LinkedList<uo> paramLinkedList, int paramInt1, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, int paramInt2)
  {
    AppMethodBeat.i(112840);
    Object localObject = new d.a();
    ((d.a)localObject).lBU = new bru();
    ((d.a)localObject).lBV = new brv();
    ((d.a)localObject).uri = "/cgi-bin/micromsg-bin/getcardlistfromapp";
    ((d.a)localObject).funcId = 1079;
    ((d.a)localObject).lBW = 0;
    ((d.a)localObject).respCmdId = 0;
    this.rr = ((d.a)localObject).bgN();
    localObject = (bru)d.b.b(this.rr.lBR);
    ((bru)localObject).REB = paramLinkedList;
    ((bru)localObject).fUN = paramInt1;
    ((bru)localObject).ufq = paramString1;
    ((bru)localObject).sign = paramString2;
    ((bru)localObject).REx = paramString3;
    ((bru)localObject).REw = paramString4;
    ((bru)localObject).Tcj = paramString5;
    ((bru)localObject).REy = paramInt2;
    AppMethodBeat.o(112840);
  }
  
  public final int doScene(g paramg, i parami)
  {
    AppMethodBeat.i(112841);
    this.callback = parami;
    int i = dispatch(paramg, this.rr, this);
    AppMethodBeat.o(112841);
    return i;
  }
  
  public final int getType()
  {
    return 1079;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(112842);
    Log.i("MicroMsg.NetSceneGetCardListFromApp", "onGYNetEnd, errType = " + paramInt2 + " errCode = " + paramInt3 + " netType = " + getType());
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      this.tpZ = ((brv)d.c.b(this.rr.lBS)).tpZ;
      if (!TextUtils.isEmpty(this.tpZ)) {
        break label112;
      }
      Log.e("MicroMsg.NetSceneGetCardListFromApp", "parseRespData json_ret is empty!");
    }
    for (;;)
    {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(112842);
      return;
      try
      {
        label112:
        params = new JSONObject(this.tpZ);
        this.tqk = params.optInt("accept_button_status", 0);
        this.tql = params.optString("accept_button_wording");
        this.tqm = params.optInt("private_status", 0);
        this.tqn = params.optString("private_wording");
      }
      catch (JSONException params)
      {
        Log.printErrStackTrace("MicroMsg.NetSceneGetCardListFromApp", params, "", new Object[0]);
        Log.e("MicroMsg.NetSceneGetCardListFromApp", "parseRespData:" + params.getMessage());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.card.model.ab
 * JD-Core Version:    0.7.0.1
 */