package com.tencent.mm.plugin.card.model;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.b.c;
import com.tencent.mm.al.g;
import com.tencent.mm.al.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.arj;
import com.tencent.mm.protocal.protobuf.ark;
import com.tencent.mm.protocal.protobuf.rb;
import com.tencent.mm.sdk.platformtools.ad;
import java.util.LinkedList;
import org.json.JSONException;
import org.json.JSONObject;

public final class ab
  extends n
  implements k
{
  private g callback;
  public int ntH;
  public String ntI;
  public int ntJ;
  public String ntK;
  public String ntw;
  private final b rr;
  
  public ab(LinkedList<rb> paramLinkedList, int paramInt1, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, int paramInt2)
  {
    AppMethodBeat.i(112840);
    Object localObject = new b.a();
    ((b.a)localObject).gUU = new arj();
    ((b.a)localObject).gUV = new ark();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/getcardlistfromapp";
    ((b.a)localObject).funcId = 1079;
    ((b.a)localObject).reqCmdId = 0;
    ((b.a)localObject).respCmdId = 0;
    this.rr = ((b.a)localObject).atI();
    localObject = (arj)this.rr.gUS.gUX;
    ((arj)localObject).CtY = paramLinkedList;
    ((arj)localObject).dye = paramInt1;
    ((arj)localObject).odc = paramString1;
    ((arj)localObject).sign = paramString2;
    ((arj)localObject).CtU = paramString3;
    ((arj)localObject).CtT = paramString4;
    ((arj)localObject).DrO = paramString5;
    ((arj)localObject).CtV = paramInt2;
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
    ad.i("MicroMsg.NetSceneGetCardListFromApp", "onGYNetEnd, errType = " + paramInt2 + " errCode = " + paramInt3 + " netType = " + getType());
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      this.ntw = ((ark)this.rr.gUT.gUX).ntw;
      if (!TextUtils.isEmpty(this.ntw)) {
        break label112;
      }
      ad.e("MicroMsg.NetSceneGetCardListFromApp", "parseRespData json_ret is empty!");
    }
    for (;;)
    {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(112842);
      return;
      try
      {
        label112:
        paramq = new JSONObject(this.ntw);
        this.ntH = paramq.optInt("accept_button_status", 0);
        this.ntI = paramq.optString("accept_button_wording");
        this.ntJ = paramq.optInt("private_status", 0);
        this.ntK = paramq.optString("private_wording");
      }
      catch (JSONException paramq)
      {
        ad.printErrStackTrace("MicroMsg.NetSceneGetCardListFromApp", paramq, "", new Object[0]);
        ad.e("MicroMsg.NetSceneGetCardListFromApp", "parseRespData:" + paramq.getMessage());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.card.model.ab
 * JD-Core Version:    0.7.0.1
 */