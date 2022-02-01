package com.tencent.mm.plugin.luckymoney.model;

import android.content.Context;
import com.tencent.mm.an.d;
import com.tencent.mm.an.d.a;
import com.tencent.mm.an.d.b;
import com.tencent.mm.an.d.c;
import com.tencent.mm.an.i;
import com.tencent.mm.f.a.vw;
import com.tencent.mm.network.g;
import com.tencent.mm.network.s;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.protocal.protobuf.ckb;
import com.tencent.mm.protocal.protobuf.ckc;
import com.tencent.mm.protocal.protobuf.eae;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.XmlParser;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.bv;
import com.tencent.mm.wallet_core.c.w;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import org.json.JSONObject;

public abstract class ai
  extends w
{
  public a EAO;
  private i callback;
  public com.tencent.mm.wallet_core.c.m jumpRemind;
  d rr;
  
  public void c(int paramInt, JSONObject paramJSONObject) {}
  
  public abstract String cOd();
  
  public int cOe()
  {
    return -1;
  }
  
  public int doScene(g paramg, i parami)
  {
    this.callback = parami;
    if (this.EAO != null)
    {
      Log.i("MicroMsg.NetSceneLuckyMoneyBase", "do fack response: %s", new Object[] { cOd() });
      return this.EAO.a(this.rr, this);
    }
    return dispatch(paramg, this.rr, this);
  }
  
  public int getCgicmdForKV()
  {
    return cOe();
  }
  
  public final boolean isJumpRemind()
  {
    return this.jumpRemind != null;
  }
  
  public void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte, long paramLong)
  {
    Log.i("MicroMsg.NetSceneLuckyMoneyBase", "Cmd : " + cOe() + ", errType = " + paramInt2 + ", errCode = " + paramInt3 + ", errMsg = " + paramString);
    paramArrayOfByte = (ckc)d.c.b(((d)params).lBS);
    int i;
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      paramInt1 = paramArrayOfByte.TrH;
      String str = com.tencent.mm.platformtools.z.b(paramArrayOfByte.TrG);
      if ((paramInt1 == 0) && (!Util.isNullOrNil(str)))
      {
        i = paramArrayOfByte.fyO;
        for (;;)
        {
          try
          {
            localJSONObject = new JSONObject(str);
            if ((!localJSONObject.has("retcode")) || (!localJSONObject.has("retmsg")))
            {
              Log.i("MicroMsg.NetSceneLuckyMoneyBase", params.getUri() + " no retcode,retmsg");
              com.tencent.mm.plugin.report.service.h.IzE.el(1698, 11);
            }
            paramInt1 = localJSONObject.getInt("retcode");
            paramArrayOfByte = paramArrayOfByte.errorMsg;
            params = paramArrayOfByte;
            if (Util.isNullOrNil(paramArrayOfByte)) {
              params = localJSONObject.optString("retmsg");
            }
            this.jumpRemind = com.tencent.mm.wallet_core.c.m.cu(localJSONObject);
            if ((!localJSONObject.has("showmess")) || (paramInt1 == 268502454)) {
              continue;
            }
            Log.i("MicroMsg.NetSceneLuckyMoneyBase", "has alert item");
            params = bb.a(null, localJSONObject);
            paramArrayOfByte = new vw();
            paramArrayOfByte.fUX.fUY = params;
            EventCenter.instance.publish(paramArrayOfByte);
          }
          catch (Exception paramString)
          {
            JSONObject localJSONObject;
            label331:
            Log.printErrStackTrace("MicroMsg.NetSceneLuckyMoneyBase", paramString, "", new Object[0]);
            paramInt2 = 1000;
            paramInt3 = 2;
            paramString = MMApplicationContext.getContext().getString(a.i.wallet_data_err);
            continue;
            c(paramInt1, localJSONObject);
            paramInt2 = 1000;
            if (i != 0) {
              break label558;
            }
          }
          Log.i("MicroMsg.NetSceneLuckyMoneyBase", "Cmd : " + cOe() + ", tenpayErrType : " + i + ", resp = " + str);
          if (paramInt2 != 0) {
            Log.e("MicroMsg.NetSceneLuckyMoneyBase", "Cmd : " + cOe() + ", errType = " + paramInt2 + ", errCode = " + paramInt3 + ", errMsg = " + paramString);
          }
          this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
          return;
          if ((paramInt1 != 0) || (i != 0)) {
            continue;
          }
          onGYNetEnd(paramInt1, params, localJSONObject);
        }
      }
    }
    label558:
    for (paramInt1 = -1000;; paramInt1 = i)
    {
      paramString = params;
      paramInt3 = paramInt1;
      break;
      paramInt2 = 1000;
      paramInt3 = 2;
      paramString = paramArrayOfByte.TrI;
      break label331;
      paramString = XmlParser.parseXml(paramString, "e", null);
      if (paramString != null)
      {
        Log.d("MicroMsg.NetSceneLuckyMoneyBase", "CDN error!");
        paramString = (String)paramString.get(".e.Content");
        break label331;
      }
      paramString = MMApplicationContext.getContext().getString(a.i.wallet_data_err);
      break label331;
    }
  }
  
  public abstract void onGYNetEnd(int paramInt, String paramString, JSONObject paramJSONObject);
  
  public final void setRequestData(Map<String, String> paramMap)
  {
    Object localObject1 = paramMap;
    if (paramMap == null) {
      localObject1 = new HashMap();
    }
    paramMap = com.tencent.mm.model.z.bcZ();
    com.tencent.mm.kernel.h.aHH();
    paramMap = ((n)com.tencent.mm.kernel.h.ae(n.class)).bbL().RG(paramMap);
    if (paramMap != null)
    {
      ((Map)localObject1).put("province", paramMap.hyc());
      ((Map)localObject1).put("city", paramMap.getCityCode());
    }
    if (this.rr == null)
    {
      paramMap = new d.a();
      paramMap.lBU = new ckb();
      paramMap.lBV = new ckc();
      paramMap.uri = cOd();
      paramMap.funcId = getType();
      paramMap.lBW = 0;
      paramMap.respCmdId = 0;
      this.rr = paramMap.bgN();
      this.rr.setIsUserCmd(true);
    }
    paramMap = (ckb)d.b.b(this.rr.lBR);
    paramMap.TrD = cOe();
    paramMap.TrE = 1;
    if (localObject1 != null)
    {
      Object[] arrayOfObject = ((Map)localObject1).keySet().toArray();
      Arrays.sort(arrayOfObject);
      StringBuilder localStringBuilder = new StringBuilder();
      int i = 0;
      int k;
      for (int j = 0; i < arrayOfObject.length; j = k)
      {
        Object localObject2 = arrayOfObject[i];
        String str = (String)((Map)localObject1).get(localObject2);
        k = j;
        if (!Util.isNullOrNil(str))
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
      Log.i("MicroMsg.NetSceneLuckyMoneyBase", "Cmd : " + paramMap.TrD + ", req = " + localStringBuilder.toString());
      localObject1 = localStringBuilder.toString().getBytes();
      paramMap.TrF = new eae().dc((byte[])localObject1);
    }
  }
  
  public static abstract interface a
  {
    public abstract int a(d paramd, com.tencent.mm.network.m paramm);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.model.ai
 * JD-Core Version:    0.7.0.1
 */