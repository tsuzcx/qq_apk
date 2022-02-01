package com.tencent.mm.plugin.card.model;

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
import com.tencent.mm.protocal.protobuf.bkl;
import com.tencent.mm.protocal.protobuf.bkm;
import com.tencent.mm.protocal.protobuf.um;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.LinkedList;
import org.json.JSONException;
import org.json.JSONObject;

public final class ab
  extends q
  implements m
{
  private i callback;
  public String pTY;
  public int pUj;
  public String pUk;
  public int pUl;
  public String pUm;
  private final d rr;
  
  public ab(LinkedList<um> paramLinkedList, int paramInt1, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, int paramInt2)
  {
    AppMethodBeat.i(112840);
    Object localObject = new d.a();
    ((d.a)localObject).iLN = new bkl();
    ((d.a)localObject).iLO = new bkm();
    ((d.a)localObject).uri = "/cgi-bin/micromsg-bin/getcardlistfromapp";
    ((d.a)localObject).funcId = 1079;
    ((d.a)localObject).iLP = 0;
    ((d.a)localObject).respCmdId = 0;
    this.rr = ((d.a)localObject).aXF();
    localObject = (bkl)this.rr.iLK.iLR;
    ((bkl)localObject).KDk = paramLinkedList;
    ((bkl)localObject).eaQ = paramInt1;
    ((bkl)localObject).qGp = paramString1;
    ((bkl)localObject).sign = paramString2;
    ((bkl)localObject).KDg = paramString3;
    ((bkl)localObject).KDf = paramString4;
    ((bkl)localObject).LTz = paramString5;
    ((bkl)localObject).KDh = paramInt2;
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
      this.pTY = ((bkm)this.rr.iLL.iLR).pTY;
      if (!TextUtils.isEmpty(this.pTY)) {
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
        params = new JSONObject(this.pTY);
        this.pUj = params.optInt("accept_button_status", 0);
        this.pUk = params.optString("accept_button_wording");
        this.pUl = params.optInt("private_status", 0);
        this.pUm = params.optString("private_wording");
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