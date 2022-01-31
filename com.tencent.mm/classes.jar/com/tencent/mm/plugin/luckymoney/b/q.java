package com.tencent.mm.plugin.luckymoney.b;

import android.content.Context;
import com.tencent.mm.ah.b.a;
import com.tencent.mm.ah.b.b;
import com.tencent.mm.ah.b.c;
import com.tencent.mm.ah.f;
import com.tencent.mm.h.a.pt;
import com.tencent.mm.kernel.g;
import com.tencent.mm.network.e;
import com.tencent.mm.platformtools.aa;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.protocal.c.api;
import com.tencent.mm.protocal.c.apj;
import com.tencent.mm.protocal.c.bmk;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.bn;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.bd;
import com.tencent.mm.wallet_core.c.i;
import com.tencent.mm.wallet_core.c.s;
import java.util.Arrays;
import java.util.Map;
import java.util.Set;
import org.json.JSONObject;

public abstract class q
  extends s
{
  com.tencent.mm.ah.b dmK;
  private f dmL;
  public i lQQ;
  
  public final void D(Map<String, String> paramMap)
  {
    Object localObject1 = com.tencent.mm.model.q.Gj();
    g.DQ();
    localObject1 = ((j)g.r(j.class)).Fw().abl((String)localObject1);
    if (localObject1 != null)
    {
      paramMap.put("province", ((ad)localObject1).cue());
      paramMap.put("city", ((ad)localObject1).getCityCode());
    }
    if (this.dmK == null)
    {
      localObject1 = new b.a();
      ((b.a)localObject1).ecH = new api();
      ((b.a)localObject1).ecI = new apj();
      ((b.a)localObject1).uri = aEz();
      ((b.a)localObject1).ecG = getType();
      ((b.a)localObject1).ecJ = 0;
      ((b.a)localObject1).ecK = 0;
      this.dmK = ((b.a)localObject1).Kt();
      this.dmK.ecZ = true;
    }
    localObject1 = (api)this.dmK.ecE.ecN;
    ((api)localObject1).tlp = aEA();
    ((api)localObject1).tlq = 1;
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
      if (!bk.bl(str))
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
    y.i("MicroMsg.NetSceneLuckyMoneyBase", "Cmd : " + ((api)localObject1).tlp + ", req = " + localStringBuilder.toString());
    paramMap = localStringBuilder.toString().getBytes();
    ((api)localObject1).tlr = new bmk().bs(paramMap);
  }
  
  public final int a(e parame, f paramf)
  {
    this.dmL = paramf;
    return a(parame, this.dmK, this);
  }
  
  public abstract void a(int paramInt, String paramString, JSONObject paramJSONObject);
  
  public int aEA()
  {
    return -1;
  }
  
  public abstract String aEz();
  
  public final int bfM()
  {
    return aEA();
  }
  
  public final void e(int paramInt1, int paramInt2, String paramString, com.tencent.mm.network.q paramq)
  {
    y.i("MicroMsg.NetSceneLuckyMoneyBase", "Cmd : " + aEA() + ", errType = " + paramInt1 + ", errCode = " + paramInt2 + ", errMsg = " + paramString);
    paramq = (apj)((com.tencent.mm.ah.b)paramq).ecF.ecN;
    int i;
    int j;
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      i = paramq.tlt;
      Object localObject = aa.b(paramq.tls);
      if ((i == 0) && (!bk.bl((String)localObject)))
      {
        i = paramq.bIC;
        for (;;)
        {
          try
          {
            JSONObject localJSONObject = new JSONObject((String)localObject);
            j = localJSONObject.getInt("retcode");
            localObject = paramq.errorMsg;
            paramq = (com.tencent.mm.network.q)localObject;
            if (bk.bl((String)localObject)) {
              paramq = localJSONObject.optString("retmsg");
            }
            this.lQQ = i.aB(localJSONObject);
            if (localJSONObject.has("showmess"))
            {
              y.i("MicroMsg.NetSceneLuckyMoneyBase", "has alert item");
              paramq = ae.W(localJSONObject);
              localObject = new pt();
              ((pt)localObject).bZn.bZo = paramq;
              a.udP.m((com.tencent.mm.sdk.b.b)localObject);
              if (paramInt1 != 0) {
                y.e("MicroMsg.NetSceneLuckyMoneyBase", "Cmd : " + aEA() + ", errType = " + paramInt1 + ", errCode = " + paramInt2 + ", errMsg = " + paramString);
              }
              this.dmL.onSceneEnd(paramInt1, paramInt2, paramString, this);
              return;
            }
            if ((j != 0) || (i != 0)) {
              break;
            }
            a(j, paramq, localJSONObject);
            continue;
            paramString = com.tencent.mm.sdk.platformtools.ae.getContext().getString(a.i.wallet_data_err);
          }
          catch (Exception paramString)
          {
            y.printErrStackTrace("MicroMsg.NetSceneLuckyMoneyBase", paramString, "", new Object[0]);
            i = 2;
            j = 1000;
          }
          label339:
          paramInt1 = j;
          paramInt2 = i;
        }
        if (i != 0) {
          break label436;
        }
      }
    }
    label436:
    for (paramInt1 = -1000;; paramInt1 = i)
    {
      paramString = paramq;
      paramInt2 = paramInt1;
      paramInt1 = 1000;
      break;
      paramString = paramq.tlu;
      paramInt2 = 2;
      paramInt1 = 1000;
      break;
      paramString = bn.s(paramString, "e");
      j = paramInt1;
      i = paramInt2;
      if (paramString == null) {
        break label339;
      }
      y.d("MicroMsg.NetSceneLuckyMoneyBase", "CDN error!");
      paramString = (String)paramString.get(".e.Content");
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.b.q
 * JD-Core Version:    0.7.0.1
 */