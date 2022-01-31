package com.tencent.mm.plugin.luckymoney.model;

import android.content.Context;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.b.b;
import com.tencent.mm.ai.b.c;
import com.tencent.mm.ai.f;
import com.tencent.mm.g.a.ra;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.r;
import com.tencent.mm.network.e;
import com.tencent.mm.network.q;
import com.tencent.mm.platformtools.aa;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.avh;
import com.tencent.mm.protocal.protobuf.avi;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.sdk.platformtools.br;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.bd;
import com.tencent.mm.wallet_core.c.k;
import com.tencent.mm.wallet_core.c.u;
import java.util.Arrays;
import java.util.Map;
import java.util.Set;
import org.json.JSONObject;

public abstract class z
  extends u
{
  private f callback;
  public k jumpRemind;
  b rr;
  
  public abstract String bhG();
  
  public int bhH()
  {
    return -1;
  }
  
  public int doScene(e parame, f paramf)
  {
    this.callback = paramf;
    return dispatch(parame, this.rr, this);
  }
  
  public int getCgicmdForKV()
  {
    return bhH();
  }
  
  public final boolean isJumpRemind()
  {
    return this.jumpRemind != null;
  }
  
  public void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte, long paramLong)
  {
    ab.i("MicroMsg.NetSceneLuckyMoneyBase", "Cmd : " + bhH() + ", errType = " + paramInt2 + ", errCode = " + paramInt3 + ", errMsg = " + paramString);
    paramq = (avi)((b)paramq).fsW.fta;
    int i;
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      paramInt1 = paramq.xkM;
      String str = aa.b(paramq.xkL);
      if ((paramInt1 == 0) && (!bo.isNullOrNil(str)))
      {
        i = paramq.cpX;
        for (;;)
        {
          try
          {
            localJSONObject = new JSONObject(str);
            paramInt1 = localJSONObject.getInt("retcode");
            paramArrayOfByte = paramq.errorMsg;
            paramq = paramArrayOfByte;
            if (bo.isNullOrNil(paramArrayOfByte)) {
              paramq = localJSONObject.optString("retmsg");
            }
            this.jumpRemind = k.aX(localJSONObject);
            if ((!localJSONObject.has("showmess")) || (paramInt1 == 268502454)) {
              continue;
            }
            ab.i("MicroMsg.NetSceneLuckyMoneyBase", "has alert item");
            paramq = ao.a(null, localJSONObject);
            paramArrayOfByte = new ra();
            paramArrayOfByte.cHy.cHz = paramq;
            a.ymk.l(paramArrayOfByte);
          }
          catch (Exception paramString)
          {
            JSONObject localJSONObject;
            label270:
            ab.printErrStackTrace("MicroMsg.NetSceneLuckyMoneyBase", paramString, "", new Object[0]);
            paramInt2 = 1000;
            paramInt3 = 2;
            paramString = ah.getContext().getString(2131305032);
            continue;
            paramInt2 = 1000;
            if (i != 0) {
              break label485;
            }
          }
          ab.i("MicroMsg.NetSceneLuckyMoneyBase", "Cmd : " + bhH() + ", tenpayErrType : " + i + ", resp = " + str);
          if (paramInt2 != 0) {
            ab.e("MicroMsg.NetSceneLuckyMoneyBase", "Cmd : " + bhH() + ", errType = " + paramInt2 + ", errCode = " + paramInt3 + ", errMsg = " + paramString);
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
      paramString = paramq.xkN;
      break label270;
      paramString = br.F(paramString, "e");
      if (paramString != null)
      {
        ab.d("MicroMsg.NetSceneLuckyMoneyBase", "CDN error!");
        paramString = (String)paramString.get(".e.Content");
        break label270;
      }
      paramString = ah.getContext().getString(2131305032);
      break label270;
    }
  }
  
  public abstract void onGYNetEnd(int paramInt, String paramString, JSONObject paramJSONObject);
  
  public final void setRequestData(Map<String, String> paramMap)
  {
    Object localObject1 = r.Zn();
    g.RM();
    localObject1 = ((j)g.E(j.class)).YA().arw((String)localObject1);
    if (localObject1 != null)
    {
      paramMap.put("province", ((ad)localObject1).dwD());
      paramMap.put("city", ((ad)localObject1).getCityCode());
    }
    if (this.rr == null)
    {
      localObject1 = new b.a();
      ((b.a)localObject1).fsX = new avh();
      ((b.a)localObject1).fsY = new avi();
      ((b.a)localObject1).uri = bhG();
      ((b.a)localObject1).funcId = getType();
      ((b.a)localObject1).reqCmdId = 0;
      ((b.a)localObject1).respCmdId = 0;
      this.rr = ((b.a)localObject1).ado();
      this.rr.setIsUserCmd(true);
    }
    localObject1 = (avh)this.rr.fsV.fta;
    ((avh)localObject1).xkI = bhH();
    ((avh)localObject1).xkJ = 1;
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
      if (!bo.isNullOrNil(str))
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
    ab.i("MicroMsg.NetSceneLuckyMoneyBase", "Cmd : " + ((avh)localObject1).xkI + ", req = " + localStringBuilder.toString());
    paramMap = localStringBuilder.toString().getBytes();
    ((avh)localObject1).xkK = new SKBuiltinBuffer_t().setBuffer(paramMap);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.model.z
 * JD-Core Version:    0.7.0.1
 */