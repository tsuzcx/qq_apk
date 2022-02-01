package com.tencent.mm.plugin.luckymoney.model;

import android.content.Context;
import com.tencent.mm.al.b;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.b.c;
import com.tencent.mm.al.f;
import com.tencent.mm.g.a.tu;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.u;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.boo;
import com.tencent.mm.protocal.protobuf.bop;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.sdk.platformtools.bw;
import com.tencent.mm.storage.am;
import com.tencent.mm.storage.bp;
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
  public a vpF;
  
  public abstract String cau();
  
  public int cav()
  {
    return -1;
  }
  
  public int doScene(e parame, f paramf)
  {
    this.callback = paramf;
    if (this.vpF != null)
    {
      ad.i("MicroMsg.NetSceneLuckyMoneyBase", "do fack response: %s", new Object[] { cau() });
      return this.vpF.a(this.rr, this);
    }
    return dispatch(parame, this.rr, this);
  }
  
  public int getCgicmdForKV()
  {
    return cav();
  }
  
  public final boolean isJumpRemind()
  {
    return this.jumpRemind != null;
  }
  
  public void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte, long paramLong)
  {
    ad.i("MicroMsg.NetSceneLuckyMoneyBase", "Cmd : " + cav() + ", errType = " + paramInt2 + ", errCode = " + paramInt3 + ", errMsg = " + paramString);
    paramq = (bop)((b)paramq).hNL.hNQ;
    int i;
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      paramInt1 = paramq.GJq;
      String str = z.b(paramq.GJp);
      if ((paramInt1 == 0) && (!bt.isNullOrNil(str)))
      {
        i = paramq.dnL;
        for (;;)
        {
          try
          {
            localJSONObject = new JSONObject(str);
            paramInt1 = localJSONObject.getInt("retcode");
            paramArrayOfByte = paramq.errorMsg;
            paramq = paramArrayOfByte;
            if (bt.isNullOrNil(paramArrayOfByte)) {
              paramq = localJSONObject.optString("retmsg");
            }
            this.jumpRemind = m.bJ(localJSONObject);
            if ((!localJSONObject.has("showmess")) || (paramInt1 == 268502454)) {
              continue;
            }
            ad.i("MicroMsg.NetSceneLuckyMoneyBase", "has alert item");
            paramq = aq.a(null, localJSONObject);
            paramArrayOfByte = new tu();
            paramArrayOfByte.dIj.dIk = paramq;
            a.IbL.l(paramArrayOfByte);
          }
          catch (Exception paramString)
          {
            JSONObject localJSONObject;
            label270:
            ad.printErrStackTrace("MicroMsg.NetSceneLuckyMoneyBase", paramString, "", new Object[0]);
            paramInt2 = 1000;
            paramInt3 = 2;
            paramString = aj.getContext().getString(2131765224);
            continue;
            paramInt2 = 1000;
            if (i != 0) {
              break label485;
            }
          }
          ad.i("MicroMsg.NetSceneLuckyMoneyBase", "Cmd : " + cav() + ", tenpayErrType : " + i + ", resp = " + str);
          if (paramInt2 != 0) {
            ad.e("MicroMsg.NetSceneLuckyMoneyBase", "Cmd : " + cav() + ", errType = " + paramInt2 + ", errCode = " + paramInt3 + ", errMsg = " + paramString);
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
      paramString = paramq.GJr;
      break label270;
      paramString = bw.M(paramString, "e");
      if (paramString != null)
      {
        ad.d("MicroMsg.NetSceneLuckyMoneyBase", "CDN error!");
        paramString = (String)paramString.get(".e.Content");
        break label270;
      }
      paramString = aj.getContext().getString(2131765224);
      break label270;
    }
  }
  
  public abstract void onGYNetEnd(int paramInt, String paramString, JSONObject paramJSONObject);
  
  public final void setRequestData(Map<String, String> paramMap)
  {
    Object localObject1 = u.aAm();
    g.ajD();
    localObject1 = ((l)g.ab(l.class)).azp().Bf((String)localObject1);
    if (localObject1 != null)
    {
      paramMap.put("province", ((am)localObject1).fql());
      paramMap.put("city", ((am)localObject1).getCityCode());
    }
    if (this.rr == null)
    {
      localObject1 = new b.a();
      ((b.a)localObject1).hNM = new boo();
      ((b.a)localObject1).hNN = new bop();
      ((b.a)localObject1).uri = cau();
      ((b.a)localObject1).funcId = getType();
      ((b.a)localObject1).hNO = 0;
      ((b.a)localObject1).respCmdId = 0;
      this.rr = ((b.a)localObject1).aDC();
      this.rr.setIsUserCmd(true);
    }
    localObject1 = (boo)this.rr.hNK.hNQ;
    ((boo)localObject1).GJm = cav();
    ((boo)localObject1).GJn = 1;
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
      if (!bt.isNullOrNil(str))
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
    ad.i("MicroMsg.NetSceneLuckyMoneyBase", "Cmd : " + ((boo)localObject1).GJm + ", req = " + localStringBuilder.toString());
    paramMap = localStringBuilder.toString().getBytes();
    ((boo)localObject1).GJo = new SKBuiltinBuffer_t().setBuffer(paramMap);
  }
  
  public static abstract interface a
  {
    public abstract int a(b paramb, k paramk);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.model.ab
 * JD-Core Version:    0.7.0.1
 */