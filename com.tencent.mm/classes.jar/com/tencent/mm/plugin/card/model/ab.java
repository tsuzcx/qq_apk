package com.tencent.mm.plugin.card.model;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.b.b;
import com.tencent.mm.ai.b.c;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.aic;
import com.tencent.mm.protocal.protobuf.aid;
import com.tencent.mm.protocal.protobuf.ot;
import java.util.LinkedList;
import org.json.JSONException;
import org.json.JSONObject;

public final class ab
  extends m
  implements k
{
  private f callback;
  public String koi;
  public int kou;
  public String kov;
  public int kow;
  public String kox;
  private final b rr;
  
  public ab(LinkedList<ot> paramLinkedList, int paramInt1, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, int paramInt2)
  {
    AppMethodBeat.i(87898);
    Object localObject = new b.a();
    ((b.a)localObject).fsX = new aic();
    ((b.a)localObject).fsY = new aid();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/getcardlistfromapp";
    ((b.a)localObject).funcId = 690;
    ((b.a)localObject).reqCmdId = 0;
    ((b.a)localObject).respCmdId = 0;
    this.rr = ((b.a)localObject).ado();
    localObject = (aic)this.rr.fsV.fta;
    ((aic)localObject).wlK = paramLinkedList;
    ((aic)localObject).cHp = paramInt1;
    ((aic)localObject).kWn = paramString1;
    ((aic)localObject).sign = paramString2;
    ((aic)localObject).wlG = paramString3;
    ((aic)localObject).wlF = paramString4;
    ((aic)localObject).wZY = paramString5;
    ((aic)localObject).wlH = paramInt2;
    AppMethodBeat.o(87898);
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(87899);
    this.callback = paramf;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(87899);
    return i;
  }
  
  public final int getType()
  {
    return 690;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(87900);
    com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.NetSceneGetCardListFromApp", "onGYNetEnd, errType = " + paramInt2 + " errCode = " + paramInt3 + " netType = " + getType());
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      this.koi = ((aid)this.rr.fsW.fta).koi;
      if (!TextUtils.isEmpty(this.koi)) {
        break label112;
      }
      com.tencent.mm.sdk.platformtools.ab.e("MicroMsg.NetSceneGetCardListFromApp", "parseRespData json_ret is empty!");
    }
    for (;;)
    {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(87900);
      return;
      try
      {
        label112:
        paramq = new JSONObject(this.koi);
        this.kou = paramq.optInt("accept_button_status", 0);
        this.kov = paramq.optString("accept_button_wording");
        this.kow = paramq.optInt("private_status", 0);
        this.kox = paramq.optString("private_wording");
      }
      catch (JSONException paramq)
      {
        com.tencent.mm.sdk.platformtools.ab.printErrStackTrace("MicroMsg.NetSceneGetCardListFromApp", paramq, "", new Object[0]);
        com.tencent.mm.sdk.platformtools.ab.e("MicroMsg.NetSceneGetCardListFromApp", "parseRespData:" + paramq.getMessage());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.card.model.ab
 * JD-Core Version:    0.7.0.1
 */