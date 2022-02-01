package com.tencent.mm.plugin.luckymoney.model;

import android.content.Context;
import com.tencent.mm.am.c;
import com.tencent.mm.am.c.a;
import com.tencent.mm.am.c.b;
import com.tencent.mm.am.c.c;
import com.tencent.mm.autogen.a.xm;
import com.tencent.mm.model.z;
import com.tencent.mm.network.g;
import com.tencent.mm.network.s;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.protocal.protobuf.dai;
import com.tencent.mm.protocal.protobuf.daj;
import com.tencent.mm.protocal.protobuf.gol;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.XmlParser;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.bx;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import org.json.JSONObject;

public abstract class aj
  extends com.tencent.mm.wallet_core.model.w
{
  public a KtL;
  private com.tencent.mm.am.h callback;
  public com.tencent.mm.wallet_core.model.m jumpRemind;
  c rr;
  
  public int doScene(g paramg, com.tencent.mm.am.h paramh)
  {
    this.callback = paramh;
    if ((this.KtL != null) && (this.KtL.fXc()))
    {
      Log.i("MicroMsg.NetSceneLuckyMoneyBase", "do fack response: %s", new Object[] { drI() });
      return this.KtL.a(this.rr, this);
    }
    return dispatch(paramg, this.rr, this);
  }
  
  public abstract String drI();
  
  public int drJ()
  {
    return -1;
  }
  
  public void e(int paramInt, JSONObject paramJSONObject) {}
  
  public int getCgicmdForKV()
  {
    return drJ();
  }
  
  public final boolean isJumpRemind()
  {
    return this.jumpRemind != null;
  }
  
  public void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte, long paramLong)
  {
    Log.i("MicroMsg.NetSceneLuckyMoneyBase", "Cmd : " + drJ() + ", errType = " + paramInt2 + ", errCode = " + paramInt3 + ", errMsg = " + paramString);
    paramArrayOfByte = (daj)c.c.b(((c)params).otC);
    int i;
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      paramInt1 = paramArrayOfByte.aaFT;
      String str = com.tencent.mm.platformtools.w.b(paramArrayOfByte.aaFS);
      if ((paramInt1 == 0) && (!Util.isNullOrNil(str)))
      {
        i = paramArrayOfByte.hDx;
        for (;;)
        {
          try
          {
            localJSONObject = new JSONObject(str);
            if ((!localJSONObject.has("retcode")) || (!localJSONObject.has("retmsg")))
            {
              Log.i("MicroMsg.NetSceneLuckyMoneyBase", params.getUri() + " no retcode,retmsg");
              com.tencent.mm.plugin.report.service.h.OAn.kJ(1698, 11);
            }
            paramInt1 = localJSONObject.getInt("retcode");
            paramArrayOfByte = paramArrayOfByte.errorMsg;
            params = paramArrayOfByte;
            if (Util.isNullOrNil(paramArrayOfByte)) {
              params = localJSONObject.optString("retmsg");
            }
            this.jumpRemind = com.tencent.mm.wallet_core.model.m.cP(localJSONObject);
            if ((!localJSONObject.has("showmess")) || (paramInt1 == 268502454)) {
              continue;
            }
            Log.i("MicroMsg.NetSceneLuckyMoneyBase", "has alert item");
            params = bc.a(null, localJSONObject);
            paramArrayOfByte = new xm();
            paramArrayOfByte.iaU.iaV = params;
            paramArrayOfByte.publish();
          }
          catch (Exception paramString)
          {
            JSONObject localJSONObject;
            label328:
            Log.printErrStackTrace("MicroMsg.NetSceneLuckyMoneyBase", paramString, "", new Object[0]);
            paramInt2 = 1000;
            paramInt3 = 2;
            paramString = MMApplicationContext.getContext().getString(a.i.wallet_data_err);
            continue;
            e(paramInt1, localJSONObject);
            paramInt2 = 1000;
            if (i != 0) {
              break label554;
            }
          }
          Log.i("MicroMsg.NetSceneLuckyMoneyBase", "Cmd : " + drJ() + ", tenpayErrType : " + i + ", resp = " + str);
          if (paramInt2 != 0) {
            Log.e("MicroMsg.NetSceneLuckyMoneyBase", "Cmd : " + drJ() + ", errType = " + paramInt2 + ", errCode = " + paramInt3 + ", errMsg = " + paramString);
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
    label554:
    for (paramInt1 = -1000;; paramInt1 = i)
    {
      paramString = params;
      paramInt3 = paramInt1;
      break;
      paramInt2 = 1000;
      paramInt3 = 2;
      paramString = paramArrayOfByte.aaFU;
      break label328;
      paramString = XmlParser.parseXml(paramString, "e", null);
      if (paramString != null)
      {
        Log.d("MicroMsg.NetSceneLuckyMoneyBase", "CDN error!");
        paramString = (String)paramString.get(".e.Content");
        break label328;
      }
      paramString = MMApplicationContext.getContext().getString(a.i.wallet_data_err);
      break label328;
    }
  }
  
  public abstract void onGYNetEnd(int paramInt, String paramString, JSONObject paramJSONObject);
  
  public final void setRequestData(Map<String, String> paramMap)
  {
    Object localObject1 = paramMap;
    if (paramMap == null) {
      localObject1 = new HashMap();
    }
    paramMap = z.bAM();
    com.tencent.mm.kernel.h.baF();
    paramMap = ((n)com.tencent.mm.kernel.h.ax(n.class)).bzA().JE(paramMap);
    if (paramMap != null)
    {
      ((Map)localObject1).put("province", paramMap.iZJ());
      ((Map)localObject1).put("city", paramMap.getCityCode());
    }
    if (this.rr == null)
    {
      paramMap = new c.a();
      paramMap.otE = new dai();
      paramMap.otF = new daj();
      paramMap.uri = drI();
      paramMap.funcId = getType();
      paramMap.otG = 0;
      paramMap.respCmdId = 0;
      this.rr = paramMap.bEF();
      this.rr.setIsUserCmd(true);
    }
    paramMap = (dai)c.b.b(this.rr.otB);
    paramMap.aaFP = drJ();
    paramMap.aaFQ = 1;
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
      Log.i("MicroMsg.NetSceneLuckyMoneyBase", "Cmd : " + paramMap.aaFP + ", req = " + localStringBuilder.toString());
      localObject1 = localStringBuilder.toString().getBytes();
      paramMap.aaFR = new gol().df((byte[])localObject1);
    }
  }
  
  public static abstract interface a
  {
    public abstract int a(c paramc, com.tencent.mm.network.m paramm);
    
    public abstract boolean fXc();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.model.aj
 * JD-Core Version:    0.7.0.1
 */