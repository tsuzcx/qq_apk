package com.tencent.mm.plugin.card.model;

import android.text.TextUtils;
import com.tencent.mm.ah.b;
import com.tencent.mm.ah.b.a;
import com.tencent.mm.ah.b.b;
import com.tencent.mm.ah.b.c;
import com.tencent.mm.ah.f;
import com.tencent.mm.ah.m;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.adk;
import com.tencent.mm.protocal.c.adl;
import com.tencent.mm.protocal.c.lw;
import com.tencent.mm.sdk.platformtools.y;
import java.util.LinkedList;
import org.json.JSONException;
import org.json.JSONObject;

public final class ab
  extends m
  implements k
{
  private final b dmK;
  private f dmL;
  public int inA;
  public String inB;
  public int inC;
  public String inD;
  public String inn;
  
  public ab(LinkedList<lw> paramLinkedList, int paramInt1, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, int paramInt2)
  {
    Object localObject = new b.a();
    ((b.a)localObject).ecH = new adk();
    ((b.a)localObject).ecI = new adl();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/getcardlistfromapp";
    ((b.a)localObject).ecG = 690;
    ((b.a)localObject).ecJ = 0;
    ((b.a)localObject).ecK = 0;
    this.dmK = ((b.a)localObject).Kt();
    localObject = (adk)this.dmK.ecE.ecN;
    ((adk)localObject).stg = paramLinkedList;
    ((adk)localObject).bZe = paramInt1;
    ((adk)localObject).iQe = paramString1;
    ((adk)localObject).sign = paramString2;
    ((adk)localObject).stc = paramString3;
    ((adk)localObject).stb = paramString4;
    ((adk)localObject).tbG = paramString5;
    ((adk)localObject).std = paramInt2;
  }
  
  public final int a(e parame, f paramf)
  {
    this.dmL = paramf;
    return a(parame, this.dmK, this);
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    y.i("MicroMsg.NetSceneGetCardListFromApp", "onGYNetEnd, errType = " + paramInt2 + " errCode = " + paramInt3 + " netType = 690");
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      this.inn = ((adl)this.dmK.ecF.ecN).inn;
      if (!TextUtils.isEmpty(this.inn)) {
        break label95;
      }
      y.e("MicroMsg.NetSceneGetCardListFromApp", "parseRespData json_ret is empty!");
    }
    for (;;)
    {
      this.dmL.onSceneEnd(paramInt2, paramInt3, paramString, this);
      return;
      try
      {
        label95:
        paramq = new JSONObject(this.inn);
        this.inA = paramq.optInt("accept_button_status", 0);
        this.inB = paramq.optString("accept_button_wording");
        this.inC = paramq.optInt("private_status", 0);
        this.inD = paramq.optString("private_wording");
      }
      catch (JSONException paramq)
      {
        y.printErrStackTrace("MicroMsg.NetSceneGetCardListFromApp", paramq, "", new Object[0]);
        y.e("MicroMsg.NetSceneGetCardListFromApp", "parseRespData:" + paramq.getMessage());
      }
    }
  }
  
  public final int getType()
  {
    return 690;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.card.model.ab
 * JD-Core Version:    0.7.0.1
 */