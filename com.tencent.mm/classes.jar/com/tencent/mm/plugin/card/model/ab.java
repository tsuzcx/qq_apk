package com.tencent.mm.plugin.card.model;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.f;
import com.tencent.mm.ak.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.azb;
import com.tencent.mm.protocal.protobuf.azc;
import com.tencent.mm.protocal.protobuf.th;
import com.tencent.mm.sdk.platformtools.ae;
import java.util.LinkedList;
import org.json.JSONException;
import org.json.JSONObject;

public final class ab
  extends n
  implements k
{
  private f callback;
  public int oGD;
  public String oGE;
  public int oGF;
  public String oGG;
  public String oGs;
  private final b rr;
  
  public ab(LinkedList<th> paramLinkedList, int paramInt1, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, int paramInt2)
  {
    AppMethodBeat.i(112840);
    Object localObject = new b.a();
    ((b.a)localObject).hQF = new azb();
    ((b.a)localObject).hQG = new azc();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/getcardlistfromapp";
    ((b.a)localObject).funcId = 1079;
    ((b.a)localObject).hQH = 0;
    ((b.a)localObject).respCmdId = 0;
    this.rr = ((b.a)localObject).aDS();
    localObject = (azb)this.rr.hQD.hQJ;
    ((azb)localObject).FJS = paramLinkedList;
    ((azb)localObject).dJd = paramInt1;
    ((azb)localObject).pqK = paramString1;
    ((azb)localObject).sign = paramString2;
    ((azb)localObject).FJO = paramString3;
    ((azb)localObject).FJN = paramString4;
    ((azb)localObject).GPt = paramString5;
    ((azb)localObject).FJP = paramInt2;
    AppMethodBeat.o(112840);
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(112841);
    this.callback = paramf;
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
    ae.i("MicroMsg.NetSceneGetCardListFromApp", "onGYNetEnd, errType = " + paramInt2 + " errCode = " + paramInt3 + " netType = " + getType());
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      this.oGs = ((azc)this.rr.hQE.hQJ).oGs;
      if (!TextUtils.isEmpty(this.oGs)) {
        break label112;
      }
      ae.e("MicroMsg.NetSceneGetCardListFromApp", "parseRespData json_ret is empty!");
    }
    for (;;)
    {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(112842);
      return;
      try
      {
        label112:
        paramq = new JSONObject(this.oGs);
        this.oGD = paramq.optInt("accept_button_status", 0);
        this.oGE = paramq.optString("accept_button_wording");
        this.oGF = paramq.optInt("private_status", 0);
        this.oGG = paramq.optString("private_wording");
      }
      catch (JSONException paramq)
      {
        ae.printErrStackTrace("MicroMsg.NetSceneGetCardListFromApp", paramq, "", new Object[0]);
        ae.e("MicroMsg.NetSceneGetCardListFromApp", "parseRespData:" + paramq.getMessage());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.card.model.ab
 * JD-Core Version:    0.7.0.1
 */