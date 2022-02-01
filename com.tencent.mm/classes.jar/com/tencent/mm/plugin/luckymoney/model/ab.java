package com.tencent.mm.plugin.luckymoney.model;

import android.content.Context;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.g.a.tc;
import com.tencent.mm.model.u;
import com.tencent.mm.network.e;
import com.tencent.mm.network.q;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.bke;
import com.tencent.mm.protocal.protobuf.bkf;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.sdk.platformtools.bv;
import com.tencent.mm.storage.bj;
import com.tencent.mm.wallet_core.c.m;
import com.tencent.mm.wallet_core.c.w;
import java.util.Arrays;
import java.util.Map;
import java.util.Set;
import org.json.JSONObject;

public abstract class ab
  extends w
{
  private com.tencent.mm.ak.g callback;
  public m jumpRemind;
  b rr;
  public a umZ;
  
  public abstract String bVR();
  
  public int bVS()
  {
    return -1;
  }
  
  public int doScene(e parame, com.tencent.mm.ak.g paramg)
  {
    this.callback = paramg;
    if (this.umZ != null)
    {
      ac.i("MicroMsg.NetSceneLuckyMoneyBase", "do fack response: %s", new Object[] { bVR() });
      return this.umZ.a(this.rr, this);
    }
    return dispatch(parame, this.rr, this);
  }
  
  public int getCgicmdForKV()
  {
    return bVS();
  }
  
  public final boolean isJumpRemind()
  {
    return this.jumpRemind != null;
  }
  
  public void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte, long paramLong)
  {
    ac.i("MicroMsg.NetSceneLuckyMoneyBase", "Cmd : " + bVS() + ", errType = " + paramInt2 + ", errCode = " + paramInt3 + ", errMsg = " + paramString);
    paramq = (bkf)((b)paramq).hvs.hvw;
    int i;
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      paramInt1 = paramq.EZR;
      String str = z.b(paramq.EZQ);
      if ((paramInt1 == 0) && (!bs.isNullOrNil(str)))
      {
        i = paramq.dcp;
        for (;;)
        {
          try
          {
            localJSONObject = new JSONObject(str);
            paramInt1 = localJSONObject.getInt("retcode");
            paramArrayOfByte = paramq.errorMsg;
            paramq = paramArrayOfByte;
            if (bs.isNullOrNil(paramArrayOfByte)) {
              paramq = localJSONObject.optString("retmsg");
            }
            this.jumpRemind = m.bA(localJSONObject);
            if ((!localJSONObject.has("showmess")) || (paramInt1 == 268502454)) {
              continue;
            }
            ac.i("MicroMsg.NetSceneLuckyMoneyBase", "has alert item");
            paramq = aq.a(null, localJSONObject);
            paramArrayOfByte = new tc();
            paramArrayOfByte.dvZ.dwa = paramq;
            a.GpY.l(paramArrayOfByte);
          }
          catch (Exception paramString)
          {
            JSONObject localJSONObject;
            label270:
            ac.printErrStackTrace("MicroMsg.NetSceneLuckyMoneyBase", paramString, "", new Object[0]);
            paramInt2 = 1000;
            paramInt3 = 2;
            paramString = com.tencent.mm.sdk.platformtools.ai.getContext().getString(2131765224);
            continue;
            paramInt2 = 1000;
            if (i != 0) {
              break label485;
            }
          }
          ac.i("MicroMsg.NetSceneLuckyMoneyBase", "Cmd : " + bVS() + ", tenpayErrType : " + i + ", resp = " + str);
          if (paramInt2 != 0) {
            ac.e("MicroMsg.NetSceneLuckyMoneyBase", "Cmd : " + bVS() + ", errType = " + paramInt2 + ", errCode = " + paramInt3 + ", errMsg = " + paramString);
          }
          this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
          return;
          if ((paramInt1 != 0) || (i != 0)) {
            continue;
          }
          onGYNetEnd(paramInt1, paramq, localJSONObject);
        }
      }
    }
    label485:
    for (paramInt1 = -1000;; paramInt1 = i)
    {
      paramString = paramq;
      paramInt3 = paramInt1;
      break;
      paramInt2 = 1000;
      paramInt3 = 2;
      paramString = paramq.EZS;
      break label270;
      paramString = bv.L(paramString, "e");
      if (paramString != null)
      {
        ac.d("MicroMsg.NetSceneLuckyMoneyBase", "CDN error!");
        paramString = (String)paramString.get(".e.Content");
        break label270;
      }
      paramString = com.tencent.mm.sdk.platformtools.ai.getContext().getString(2131765224);
      break label270;
    }
  }
  
  public abstract void onGYNetEnd(int paramInt, String paramString, JSONObject paramJSONObject);
  
  public final void setRequestData(Map<String, String> paramMap)
  {
    Object localObject1 = u.axw();
    com.tencent.mm.kernel.g.agS();
    localObject1 = ((com.tencent.mm.plugin.messenger.foundation.a.k)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).awB().aNt((String)localObject1);
    if (localObject1 != null)
    {
      paramMap.put("province", ((com.tencent.mm.storage.ai)localObject1).fai());
      paramMap.put("city", ((com.tencent.mm.storage.ai)localObject1).getCityCode());
    }
    if (this.rr == null)
    {
      localObject1 = new b.a();
      ((b.a)localObject1).hvt = new bke();
      ((b.a)localObject1).hvu = new bkf();
      ((b.a)localObject1).uri = bVR();
      ((b.a)localObject1).funcId = getType();
      ((b.a)localObject1).reqCmdId = 0;
      ((b.a)localObject1).respCmdId = 0;
      this.rr = ((b.a)localObject1).aAz();
      this.rr.setIsUserCmd(true);
    }
    localObject1 = (bke)this.rr.hvr.hvw;
    ((bke)localObject1).EZN = bVS();
    ((bke)localObject1).EZO = 1;
    Object[] arrayOfObject = paramMap.keySet().toArray();
    Arrays.sort(arrayOfObject);
    StringBuilder localStringBuilder = new StringBuilder();
    int i = 0;
    int k;
    for (int j = 0; i < arrayOfObject.length; j = k)
    {
      Object localObject2 = arrayOfObject[i];
      String str = (String)paramMap.get(localObject2);
      k = j;
      if (!bs.isNullOrNil(str))
      {
        if (j != 0) {
          localStringBuilder.append("&");
        }
        localStringBuilder.append(localObject2);
        localStringBuilder.append("=");
        localStringBuilder.append(str);
        k = 1;
      }
      i += 1;
    }
    ac.i("MicroMsg.NetSceneLuckyMoneyBase", "Cmd : " + ((bke)localObject1).EZN + ", req = " + localStringBuilder.toString());
    paramMap = localStringBuilder.toString().getBytes();
    ((bke)localObject1).EZP = new SKBuiltinBuffer_t().setBuffer(paramMap);
  }
  
  public static abstract interface a
  {
    public abstract int a(b paramb, com.tencent.mm.network.k paramk);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.model.ab
 * JD-Core Version:    0.7.0.1
 */