package com.tencent.mm.plugin.card.model;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.b.c;
import com.tencent.mm.al.f;
import com.tencent.mm.al.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.ayl;
import com.tencent.mm.protocal.protobuf.aym;
import com.tencent.mm.protocal.protobuf.tf;
import com.tencent.mm.sdk.platformtools.ad;
import java.util.LinkedList;
import org.json.JSONException;
import org.json.JSONObject;

public final class ab
  extends n
  implements k
{
  private f callback;
  public int oAb;
  public String oAc;
  public int oAd;
  public String oAe;
  public String ozQ;
  private final b rr;
  
  public ab(LinkedList<tf> paramLinkedList, int paramInt1, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, int paramInt2)
  {
    AppMethodBeat.i(112840);
    Object localObject = new b.a();
    ((b.a)localObject).hNM = new ayl();
    ((b.a)localObject).hNN = new aym();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/getcardlistfromapp";
    ((b.a)localObject).funcId = 1079;
    ((b.a)localObject).hNO = 0;
    ((b.a)localObject).respCmdId = 0;
    this.rr = ((b.a)localObject).aDC();
    localObject = (ayl)this.rr.hNK.hNQ;
    ((ayl)localObject).Fru = paramLinkedList;
    ((ayl)localObject).dHZ = paramInt1;
    ((ayl)localObject).pkf = paramString1;
    ((ayl)localObject).sign = paramString2;
    ((ayl)localObject).Frq = paramString3;
    ((ayl)localObject).Frp = paramString4;
    ((ayl)localObject).GvU = paramString5;
    ((ayl)localObject).Frr = paramInt2;
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
    ad.i("MicroMsg.NetSceneGetCardListFromApp", "onGYNetEnd, errType = " + paramInt2 + " errCode = " + paramInt3 + " netType = " + getType());
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      this.ozQ = ((aym)this.rr.hNL.hNQ).ozQ;
      if (!TextUtils.isEmpty(this.ozQ)) {
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
        paramq = new JSONObject(this.ozQ);
        this.oAb = paramq.optInt("accept_button_status", 0);
        this.oAc = paramq.optString("accept_button_wording");
        this.oAd = paramq.optInt("private_status", 0);
        this.oAe = paramq.optString("private_wording");
      }
      catch (JSONException paramq)
      {
        ad.printErrStackTrace("MicroMsg.NetSceneGetCardListFromApp", paramq, "", new Object[0]);
        ad.e("MicroMsg.NetSceneGetCardListFromApp", "parseRespData:" + paramq.getMessage());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.card.model.ab
 * JD-Core Version:    0.7.0.1
 */