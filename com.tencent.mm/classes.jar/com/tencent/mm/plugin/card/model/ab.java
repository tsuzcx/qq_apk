package com.tencent.mm.plugin.card.model;

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
import com.tencent.mm.protocal.protobuf.aun;
import com.tencent.mm.protocal.protobuf.auo;
import com.tencent.mm.protocal.protobuf.rl;
import com.tencent.mm.sdk.platformtools.ac;
import java.util.LinkedList;
import org.json.JSONException;
import org.json.JSONObject;

public final class ab
  extends n
  implements k
{
  private g callback;
  public int nWH;
  public String nWI;
  public int nWJ;
  public String nWK;
  public String nWw;
  private final b rr;
  
  public ab(LinkedList<rl> paramLinkedList, int paramInt1, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, int paramInt2)
  {
    AppMethodBeat.i(112840);
    Object localObject = new b.a();
    ((b.a)localObject).hvt = new aun();
    ((b.a)localObject).hvu = new auo();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/getcardlistfromapp";
    ((b.a)localObject).funcId = 1079;
    ((b.a)localObject).reqCmdId = 0;
    ((b.a)localObject).respCmdId = 0;
    this.rr = ((b.a)localObject).aAz();
    localObject = (aun)this.rr.hvr.hvw;
    ((aun)localObject).DMp = paramLinkedList;
    ((aun)localObject).dvQ = paramInt1;
    ((aun)localObject).oGB = paramString1;
    ((aun)localObject).sign = paramString2;
    ((aun)localObject).DMl = paramString3;
    ((aun)localObject).DMk = paramString4;
    ((aun)localObject).EMQ = paramString5;
    ((aun)localObject).DMm = paramInt2;
    AppMethodBeat.o(112840);
  }
  
  public final int doScene(e parame, g paramg)
  {
    AppMethodBeat.i(112841);
    this.callback = paramg;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(112841);
    return i;
  }
  
  public final int getType()
  {
    return 1079;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(112842);
    ac.i("MicroMsg.NetSceneGetCardListFromApp", "onGYNetEnd, errType = " + paramInt2 + " errCode = " + paramInt3 + " netType = " + getType());
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      this.nWw = ((auo)this.rr.hvs.hvw).nWw;
      if (!TextUtils.isEmpty(this.nWw)) {
        break label112;
      }
      ac.e("MicroMsg.NetSceneGetCardListFromApp", "parseRespData json_ret is empty!");
    }
    for (;;)
    {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(112842);
      return;
      try
      {
        label112:
        paramq = new JSONObject(this.nWw);
        this.nWH = paramq.optInt("accept_button_status", 0);
        this.nWI = paramq.optString("accept_button_wording");
        this.nWJ = paramq.optInt("private_status", 0);
        this.nWK = paramq.optString("private_wording");
      }
      catch (JSONException paramq)
      {
        ac.printErrStackTrace("MicroMsg.NetSceneGetCardListFromApp", paramq, "", new Object[0]);
        ac.e("MicroMsg.NetSceneGetCardListFromApp", "parseRespData:" + paramq.getMessage());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.card.model.ab
 * JD-Core Version:    0.7.0.1
 */