package com.tencent.kinda.framework.module.impl;

import com.tencent.kinda.gen.KGenDigitalCrtReq;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.b.p;
import com.tencent.mm.kernel.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.wallet_core.model.an;
import com.tencent.mm.plugin.wallet_core.model.t;
import com.tencent.mm.protocal.d;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.wallet_core.c.ad;
import com.tencent.mm.wallet_core.c.e;
import com.tencent.mm.wallet_core.c.y;
import com.tencent.mm.wallet_core.tenpay.model.m;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public class NetSceneKindaGenDigitalCert
  extends m
{
  private final String TAG;
  
  public NetSceneKindaGenDigitalCert(KGenDigitalCrtReq paramKGenDigitalCrtReq)
  {
    AppMethodBeat.i(18667);
    this.TAG = "kinda.NetSceneKindaGenDigitalCert";
    HashMap localHashMap1 = new HashMap();
    HashMap localHashMap2 = new HashMap();
    baseRequset(localHashMap1);
    if (paramKGenDigitalCrtReq.mType == 1)
    {
      localHashMap1.put("type", com.tencent.mm.compatible.util.q.encode("1"));
      localHashMap1.put("true_name", com.tencent.mm.compatible.util.q.encode(t.eJf().getTrueName()));
      localHashMap1.put("id_no", com.tencent.mm.compatible.util.q.encode(paramKGenDigitalCrtReq.getIdNo()));
      localHashMap1.put("id_type", com.tencent.mm.compatible.util.q.encode(paramKGenDigitalCrtReq.getIdType()));
    }
    for (;;)
    {
      setRequestData(localHashMap1);
      setWXRequestData(localHashMap2);
      AppMethodBeat.o(18667);
      return;
      if (paramKGenDigitalCrtReq.mType == 2)
      {
        localHashMap1.put("type", com.tencent.mm.compatible.util.q.encode("2"));
        localHashMap1.put("crt_sms", com.tencent.mm.compatible.util.q.encode(paramKGenDigitalCrtReq.getVerifyCode()));
        localHashMap1.put("reqkey", com.tencent.mm.compatible.util.q.encode(paramKGenDigitalCrtReq.getReqKey()));
      }
      else if (paramKGenDigitalCrtReq.mType == 3)
      {
        localHashMap1.put("type", com.tencent.mm.compatible.util.q.encode("3"));
        localHashMap1.put("crt_token", com.tencent.mm.compatible.util.q.encode(paramKGenDigitalCrtReq.getToken()));
      }
      else if (paramKGenDigitalCrtReq.mType == 4)
      {
        localHashMap1.put("type", com.tencent.mm.compatible.util.q.encode("4"));
        localHashMap1.put("id_type", com.tencent.mm.compatible.util.q.encode(paramKGenDigitalCrtReq.getIdType()));
        localHashMap1.put("cre_tail", com.tencent.mm.compatible.util.q.encode(paramKGenDigitalCrtReq.getCreTail()));
        localHashMap1.put("reqkey", com.tencent.mm.compatible.util.q.encode(paramKGenDigitalCrtReq.getReqKey()));
      }
      else
      {
        ae.e("kinda.NetSceneKindaGenDigitalCert", "KGenDigitalCrtReq.mType is illeagl.");
      }
    }
  }
  
  private void baseRequset(Map<String, String> paramMap)
  {
    int k = 0;
    AppMethodBeat.i(18666);
    g.ajS();
    g.ajP();
    Object localObject3 = p.getString(a.getUin());
    String str1 = com.tencent.mm.compatible.deviceinfo.q.cH(false);
    byte[] arrayOfByte = new byte[16];
    Object localObject2 = y.fVS().getBytes();
    if (localObject2 != null)
    {
      localObject1 = localObject2;
      if (localObject2.length > 0) {}
    }
    else
    {
      localObject1 = System.currentTimeMillis().getBytes();
    }
    int j = 0;
    int i = 0;
    int m;
    do
    {
      arrayOfByte[i] = localObject1[j];
      m = i + 1;
      j += 1;
      i = j;
      if (j >= localObject1.length) {
        i = 0;
      }
      j = i;
      i = m;
    } while (m < 16);
    Object localObject1 = new String(arrayOfByte);
    localObject2 = aj.ej((String)localObject3 + str1);
    String str2 = aj.ej((String)localObject3 + (String)localObject2 + new String(arrayOfByte));
    ae.i("kinda.NetSceneKindaGenDigitalCert", "salt " + new String(arrayOfByte));
    ae.i("kinda.NetSceneKindaGenDigitalCert", "crt_csr uin: %s: devideid: %s crt: %s", new Object[] { localObject3, str1, str2 });
    localObject3 = com.tencent.mm.wallet_core.c.b.fVM();
    com.tencent.mm.wallet_core.b.fVf();
    i = k;
    if (com.tencent.mm.wallet_core.b.fVi()) {
      i = 1;
    }
    localObject3 = ((com.tencent.mm.wallet_core.c.b)localObject3).gW(str2, i);
    try
    {
      paramMap.put("sn_salt", com.tencent.mm.compatible.util.q.encode((String)localObject1));
      paramMap.put("crt_csr", com.tencent.mm.compatible.util.q.encode((String)localObject3));
      paramMap.put("crt_device_id", localObject2);
      paramMap.put("device_os", d.hjv);
      paramMap.put("device_name", d.FFE);
      AppMethodBeat.o(18666);
      return;
    }
    catch (Exception paramMap)
    {
      AppMethodBeat.o(18666);
    }
  }
  
  public int getFuncId()
  {
    return 1580;
  }
  
  public int getTenpayCgicmd()
  {
    return 1580;
  }
  
  public int getType()
  {
    return 1580;
  }
  
  public String getUri()
  {
    return "/cgi-bin/mmpay-bin/tenpay/gendigitalcert";
  }
  
  public void onGYNetEnd(int paramInt, String paramString, JSONObject paramJSONObject) {}
  
  public void onGYNetEnd2(e parame, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(18668);
    super.onGYNetEnd2(parame, paramJSONObject);
    ae.i("kinda.NetSceneKindaGenDigitalCert", "errCode %d errMsg %s", new Object[] { Integer.valueOf(parame.errCode), parame.errMsg });
    for (;;)
    {
      try
      {
        String str = paramJSONObject.optString("crt_crt");
        paramJSONObject = paramJSONObject.optString("crt_no");
        if (parame.errCode == 0)
        {
          boolean bool = com.tencent.mm.wallet_core.c.b.fVM().importCert(paramJSONObject, str);
          ad.baf(paramJSONObject);
          if (bool)
          {
            ae.i("kinda.NetSceneKindaGenDigitalCert", "importCert crt_crt success");
            ae.i("kinda.NetSceneKindaGenDigitalCert", "_crt_crt %s _crt_no %s", new Object[] { aj.ej(str), paramJSONObject });
            AppMethodBeat.o(18668);
            return;
          }
          ae.e("kinda.NetSceneKindaGenDigitalCert", "importCert crt_crt fail");
          continue;
        }
        com.tencent.mm.wallet_core.c.b.fVM().fVN();
      }
      catch (Exception parame)
      {
        ae.printErrStackTrace("kinda.NetSceneKindaGenDigitalCert", parame, "", new Object[0]);
        AppMethodBeat.o(18668);
        return;
      }
      ae.e("kinda.NetSceneKindaGenDigitalCert", " importCert crt_crt was not executed because of cgi resp error");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.kinda.framework.module.impl.NetSceneKindaGenDigitalCert
 * JD-Core Version:    0.7.0.1
 */