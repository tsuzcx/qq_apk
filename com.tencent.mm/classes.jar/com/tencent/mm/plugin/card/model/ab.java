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
import com.tencent.mm.protocal.protobuf.cgn;
import com.tencent.mm.protocal.protobuf.cgo;
import com.tencent.mm.protocal.protobuf.wf;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.LinkedList;
import org.json.JSONException;
import org.json.JSONObject;

public final class ab
  extends p
  implements m
{
  private h callback;
  private final c rr;
  public int wuJ;
  public String wuK;
  public int wuL;
  public String wuM;
  public String wuy;
  
  public ab(LinkedList<wf> paramLinkedList, int paramInt1, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, int paramInt2)
  {
    AppMethodBeat.i(112840);
    Object localObject = new c.a();
    ((c.a)localObject).otE = new cgn();
    ((c.a)localObject).otF = new cgo();
    ((c.a)localObject).uri = "/cgi-bin/micromsg-bin/getcardlistfromapp";
    ((c.a)localObject).funcId = 1079;
    ((c.a)localObject).otG = 0;
    ((c.a)localObject).respCmdId = 0;
    this.rr = ((c.a)localObject).bEF();
    localObject = (cgn)c.b.b(this.rr.otB);
    ((cgn)localObject).YBg = paramLinkedList;
    ((cgn)localObject).iaK = paramInt1;
    ((cgn)localObject).xlr = paramString1;
    ((cgn)localObject).sign = paramString2;
    ((cgn)localObject).YBc = paramString3;
    ((cgn)localObject).YBb = paramString4;
    ((cgn)localObject).aapy = paramString5;
    ((cgn)localObject).YBd = paramInt2;
    AppMethodBeat.o(112840);
  }
  
  public final int doScene(g paramg, h paramh)
  {
    AppMethodBeat.i(112841);
    this.callback = paramh;
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
      this.wuy = ((cgo)c.c.b(this.rr.otC)).wuy;
      if (!TextUtils.isEmpty(this.wuy)) {
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
        params = new JSONObject(this.wuy);
        this.wuJ = params.optInt("accept_button_status", 0);
        this.wuK = params.optString("accept_button_wording");
        this.wuL = params.optInt("private_status", 0);
        this.wuM = params.optString("private_wording");
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