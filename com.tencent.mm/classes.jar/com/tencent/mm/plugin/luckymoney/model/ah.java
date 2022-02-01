package com.tencent.mm.plugin.luckymoney.model;

import android.content.Context;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.ak.d.b;
import com.tencent.mm.ak.d.c;
import com.tencent.mm.ak.i;
import com.tencent.mm.g.a.ut;
import com.tencent.mm.network.s;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.cby;
import com.tencent.mm.protocal.protobuf.cbz;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.XmlParser;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.bv;
import com.tencent.mm.wallet_core.c.w;
import java.util.Arrays;
import java.util.Map;
import java.util.Set;
import org.json.JSONObject;

public abstract class ah
  extends w
{
  private i callback;
  public com.tencent.mm.wallet_core.c.m jumpRemind;
  d rr;
  public a yWK;
  
  public abstract String czD();
  
  public int czE()
  {
    return -1;
  }
  
  public int doScene(com.tencent.mm.network.g paramg, i parami)
  {
    this.callback = parami;
    if (this.yWK != null)
    {
      Log.i("MicroMsg.NetSceneLuckyMoneyBase", "do fack response: %s", new Object[] { czD() });
      return this.yWK.a(this.rr, this);
    }
    return dispatch(paramg, this.rr, this);
  }
  
  public int getCgicmdForKV()
  {
    return czE();
  }
  
  public final boolean isJumpRemind()
  {
    return this.jumpRemind != null;
  }
  
  public void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte, long paramLong)
  {
    Log.i("MicroMsg.NetSceneLuckyMoneyBase", "Cmd : " + czE() + ", errType = " + paramInt2 + ", errCode = " + paramInt3 + ", errMsg = " + paramString);
    params = (cbz)((d)params).iLL.iLR;
    int i;
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      paramInt1 = params.MhU;
      String str = com.tencent.mm.platformtools.z.b(params.MhT);
      if ((paramInt1 == 0) && (!Util.isNullOrNil(str)))
      {
        i = params.dGe;
        for (;;)
        {
          try
          {
            localJSONObject = new JSONObject(str);
            paramInt1 = localJSONObject.getInt("retcode");
            paramArrayOfByte = params.errorMsg;
            params = paramArrayOfByte;
            if (Util.isNullOrNil(paramArrayOfByte)) {
              params = localJSONObject.optString("retmsg");
            }
            this.jumpRemind = com.tencent.mm.wallet_core.c.m.cj(localJSONObject);
            if ((!localJSONObject.has("showmess")) || (paramInt1 == 268502454)) {
              continue;
            }
            Log.i("MicroMsg.NetSceneLuckyMoneyBase", "has alert item");
            params = ba.a(null, localJSONObject);
            paramArrayOfByte = new ut();
            paramArrayOfByte.eba.ebb = params;
            EventCenter.instance.publish(paramArrayOfByte);
          }
          catch (Exception paramString)
          {
            JSONObject localJSONObject;
            label270:
            Log.printErrStackTrace("MicroMsg.NetSceneLuckyMoneyBase", paramString, "", new Object[0]);
            paramInt2 = 1000;
            paramInt3 = 2;
            paramString = MMApplicationContext.getContext().getString(2131767667);
            continue;
            paramInt2 = 1000;
            if (i != 0) {
              break label486;
            }
          }
          Log.i("MicroMsg.NetSceneLuckyMoneyBase", "Cmd : " + czE() + ", tenpayErrType : " + i + ", resp = " + str);
          if (paramInt2 != 0) {
            Log.e("MicroMsg.NetSceneLuckyMoneyBase", "Cmd : " + czE() + ", errType = " + paramInt2 + ", errCode = " + paramInt3 + ", errMsg = " + paramString);
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
    label486:
    for (paramInt1 = -1000;; paramInt1 = i)
    {
      paramString = params;
      paramInt3 = paramInt1;
      break;
      paramInt2 = 1000;
      paramInt3 = 2;
      paramString = params.MhV;
      break label270;
      paramString = XmlParser.parseXml(paramString, "e", null);
      if (paramString != null)
      {
        Log.d("MicroMsg.NetSceneLuckyMoneyBase", "CDN error!");
        paramString = (String)paramString.get(".e.Content");
        break label270;
      }
      paramString = MMApplicationContext.getContext().getString(2131767667);
      break label270;
    }
  }
  
  public abstract void onGYNetEnd(int paramInt, String paramString, JSONObject paramJSONObject);
  
  public final void setRequestData(Map<String, String> paramMap)
  {
    Object localObject1 = com.tencent.mm.model.z.aTY();
    com.tencent.mm.kernel.g.aAi();
    localObject1 = ((l)com.tencent.mm.kernel.g.af(l.class)).aSN().Kn((String)localObject1);
    if (localObject1 != null)
    {
      paramMap.put("province", ((as)localObject1).gBR());
      paramMap.put("city", ((as)localObject1).getCityCode());
    }
    if (this.rr == null)
    {
      localObject1 = new d.a();
      ((d.a)localObject1).iLN = new cby();
      ((d.a)localObject1).iLO = new cbz();
      ((d.a)localObject1).uri = czD();
      ((d.a)localObject1).funcId = getType();
      ((d.a)localObject1).iLP = 0;
      ((d.a)localObject1).respCmdId = 0;
      this.rr = ((d.a)localObject1).aXF();
      this.rr.setIsUserCmd(true);
    }
    localObject1 = (cby)this.rr.iLK.iLR;
    ((cby)localObject1).MhQ = czE();
    ((cby)localObject1).MhR = 1;
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
    Log.i("MicroMsg.NetSceneLuckyMoneyBase", "Cmd : " + ((cby)localObject1).MhQ + ", req = " + localStringBuilder.toString());
    paramMap = localStringBuilder.toString().getBytes();
    ((cby)localObject1).MhS = new SKBuiltinBuffer_t().setBuffer(paramMap);
  }
  
  public static abstract interface a
  {
    public abstract int a(d paramd, com.tencent.mm.network.m paramm);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.model.ah
 * JD-Core Version:    0.7.0.1
 */