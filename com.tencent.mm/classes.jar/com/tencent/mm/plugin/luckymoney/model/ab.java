package com.tencent.mm.plugin.luckymoney.model;

import android.content.Context;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.f;
import com.tencent.mm.g.a.tv;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.v;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.bpg;
import com.tencent.mm.protocal.protobuf.bph;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.sdk.platformtools.bx;
import com.tencent.mm.storage.an;
import com.tencent.mm.storage.bq;
import com.tencent.mm.wallet_core.c.m;
import com.tencent.mm.wallet_core.c.w;
import java.util.Arrays;
import java.util.Map;
import java.util.Set;
import org.json.JSONObject;

public abstract class ab
  extends w
{
  private f callback;
  public m jumpRemind;
  b rr;
  public a vBK;
  
  public abstract String cbJ();
  
  public int cbK()
  {
    return -1;
  }
  
  public int doScene(e parame, f paramf)
  {
    this.callback = paramf;
    if (this.vBK != null)
    {
      ae.i("MicroMsg.NetSceneLuckyMoneyBase", "do fack response: %s", new Object[] { cbJ() });
      return this.vBK.a(this.rr, this);
    }
    return dispatch(parame, this.rr, this);
  }
  
  public int getCgicmdForKV()
  {
    return cbK();
  }
  
  public final boolean isJumpRemind()
  {
    return this.jumpRemind != null;
  }
  
  public void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte, long paramLong)
  {
    ae.i("MicroMsg.NetSceneLuckyMoneyBase", "Cmd : " + cbK() + ", errType = " + paramInt2 + ", errCode = " + paramInt3 + ", errMsg = " + paramString);
    paramq = (bph)((b)paramq).hQE.hQJ;
    int i;
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      paramInt1 = paramq.HcR;
      String str = z.b(paramq.HcQ);
      if ((paramInt1 == 0) && (!bu.isNullOrNil(str)))
      {
        i = paramq.doQ;
        for (;;)
        {
          try
          {
            localJSONObject = new JSONObject(str);
            paramInt1 = localJSONObject.getInt("retcode");
            paramArrayOfByte = paramq.errorMsg;
            paramq = paramArrayOfByte;
            if (bu.isNullOrNil(paramArrayOfByte)) {
              paramq = localJSONObject.optString("retmsg");
            }
            this.jumpRemind = m.bJ(localJSONObject);
            if ((!localJSONObject.has("showmess")) || (paramInt1 == 268502454)) {
              continue;
            }
            ae.i("MicroMsg.NetSceneLuckyMoneyBase", "has alert item");
            paramq = aq.a(null, localJSONObject);
            paramArrayOfByte = new tv();
            paramArrayOfByte.dJn.dJo = paramq;
            a.IvT.l(paramArrayOfByte);
          }
          catch (Exception paramString)
          {
            JSONObject localJSONObject;
            label270:
            ae.printErrStackTrace("MicroMsg.NetSceneLuckyMoneyBase", paramString, "", new Object[0]);
            paramInt2 = 1000;
            paramInt3 = 2;
            paramString = ak.getContext().getString(2131765224);
            continue;
            paramInt2 = 1000;
            if (i != 0) {
              break label485;
            }
          }
          ae.i("MicroMsg.NetSceneLuckyMoneyBase", "Cmd : " + cbK() + ", tenpayErrType : " + i + ", resp = " + str);
          if (paramInt2 != 0) {
            ae.e("MicroMsg.NetSceneLuckyMoneyBase", "Cmd : " + cbK() + ", errType = " + paramInt2 + ", errCode = " + paramInt3 + ", errMsg = " + paramString);
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
      paramString = paramq.HcS;
      break label270;
      paramString = bx.M(paramString, "e");
      if (paramString != null)
      {
        ae.d("MicroMsg.NetSceneLuckyMoneyBase", "CDN error!");
        paramString = (String)paramString.get(".e.Content");
        break label270;
      }
      paramString = ak.getContext().getString(2131765224);
      break label270;
    }
  }
  
  public abstract void onGYNetEnd(int paramInt, String paramString, JSONObject paramJSONObject);
  
  public final void setRequestData(Map<String, String> paramMap)
  {
    Object localObject1 = v.aAC();
    g.ajS();
    localObject1 = ((l)g.ab(l.class)).azF().BH((String)localObject1);
    if (localObject1 != null)
    {
      paramMap.put("province", ((an)localObject1).ful());
      paramMap.put("city", ((an)localObject1).getCityCode());
    }
    if (this.rr == null)
    {
      localObject1 = new b.a();
      ((b.a)localObject1).hQF = new bpg();
      ((b.a)localObject1).hQG = new bph();
      ((b.a)localObject1).uri = cbJ();
      ((b.a)localObject1).funcId = getType();
      ((b.a)localObject1).hQH = 0;
      ((b.a)localObject1).respCmdId = 0;
      this.rr = ((b.a)localObject1).aDS();
      this.rr.setIsUserCmd(true);
    }
    localObject1 = (bpg)this.rr.hQD.hQJ;
    ((bpg)localObject1).HcN = cbK();
    ((bpg)localObject1).HcO = 1;
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
      if (!bu.isNullOrNil(str))
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
    ae.i("MicroMsg.NetSceneLuckyMoneyBase", "Cmd : " + ((bpg)localObject1).HcN + ", req = " + localStringBuilder.toString());
    paramMap = localStringBuilder.toString().getBytes();
    ((bpg)localObject1).HcP = new SKBuiltinBuffer_t().setBuffer(paramMap);
  }
  
  public static abstract interface a
  {
    public abstract int a(b paramb, k paramk);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.model.ab
 * JD-Core Version:    0.7.0.1
 */