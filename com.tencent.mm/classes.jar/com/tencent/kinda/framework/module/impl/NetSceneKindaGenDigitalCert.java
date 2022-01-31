package com.tencent.kinda.framework.module.impl;

import com.tencent.kinda.gen.KGenDigitalCrtReq;
import com.tencent.kinda.gen.VoidCallback;
import com.tencent.kinda.gen.VoidStringCallback;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.a.p;
import com.tencent.mm.kernel.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.wallet_core.model.am;
import com.tencent.mm.plugin.wallet_core.model.t;
import com.tencent.mm.protocal.d;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.wallet_core.c.w;
import com.tencent.mm.wallet_core.tenpay.model.m;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public class NetSceneKindaGenDigitalCert
  extends m
{
  private final String TAG;
  private VoidStringCallback m_failCallback;
  private VoidCallback m_successCallback;
  
  public NetSceneKindaGenDigitalCert(KGenDigitalCrtReq paramKGenDigitalCrtReq, VoidCallback paramVoidCallback, VoidStringCallback paramVoidStringCallback)
  {
    AppMethodBeat.i(144550);
    this.TAG = "kinda.NetSceneKindaGenDigitalCert";
    this.m_successCallback = null;
    this.m_failCallback = null;
    this.m_successCallback = paramVoidCallback;
    this.m_failCallback = paramVoidStringCallback;
    paramVoidCallback = new HashMap();
    paramVoidStringCallback = new HashMap();
    baseRequset(paramVoidCallback);
    if (paramKGenDigitalCrtReq.mType == 1)
    {
      paramVoidCallback.put("type", com.tencent.mm.compatible.util.q.encode("1"));
      paramVoidCallback.put("true_name", com.tencent.mm.compatible.util.q.encode(t.cTN().getTrueName()));
      paramVoidCallback.put("id_no", com.tencent.mm.compatible.util.q.encode(paramKGenDigitalCrtReq.getIdNo()));
      paramVoidCallback.put("id_type", com.tencent.mm.compatible.util.q.encode(paramKGenDigitalCrtReq.getIdType()));
    }
    for (;;)
    {
      setRequestData(paramVoidCallback);
      setWXRequestData(paramVoidStringCallback);
      AppMethodBeat.o(144550);
      return;
      if (paramKGenDigitalCrtReq.mType == 2)
      {
        paramVoidCallback.put("type", com.tencent.mm.compatible.util.q.encode("2"));
        paramVoidCallback.put("crt_sms", com.tencent.mm.compatible.util.q.encode(paramKGenDigitalCrtReq.getVerifyCode()));
        paramVoidCallback.put("reqkey", com.tencent.mm.compatible.util.q.encode(paramKGenDigitalCrtReq.getReqKey()));
      }
      else if (paramKGenDigitalCrtReq.mType == 3)
      {
        paramVoidCallback.put("type", com.tencent.mm.compatible.util.q.encode("3"));
        paramVoidCallback.put("crt_token", com.tencent.mm.compatible.util.q.encode(paramKGenDigitalCrtReq.getToken()));
      }
      else if (paramKGenDigitalCrtReq.mType == 4)
      {
        paramVoidCallback.put("type", com.tencent.mm.compatible.util.q.encode("4"));
        paramVoidCallback.put("id_type", com.tencent.mm.compatible.util.q.encode(paramKGenDigitalCrtReq.getIdType()));
        paramVoidCallback.put("cre_tail", com.tencent.mm.compatible.util.q.encode(paramKGenDigitalCrtReq.getCreTail()));
        paramVoidCallback.put("reqkey", com.tencent.mm.compatible.util.q.encode(paramKGenDigitalCrtReq.getReqKey()));
      }
      else
      {
        com.tencent.mm.sdk.platformtools.ab.e("kinda.NetSceneKindaGenDigitalCert", "KGenDigitalCrtReq.mType is illeagl.");
      }
    }
  }
  
  private void baseRequset(Map<String, String> paramMap)
  {
    int k = 0;
    AppMethodBeat.i(144549);
    g.RM();
    g.RJ();
    Object localObject3 = p.getString(a.getUin());
    String str1 = com.tencent.mm.compatible.e.q.bP(false);
    byte[] arrayOfByte = new byte[16];
    Object localObject2 = w.dSo().getBytes();
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
    localObject2 = ag.cE((String)localObject3 + str1);
    String str2 = ag.cE((String)localObject3 + (String)localObject2 + new String(arrayOfByte));
    com.tencent.mm.sdk.platformtools.ab.i("kinda.NetSceneKindaGenDigitalCert", "salt " + new String(arrayOfByte));
    com.tencent.mm.sdk.platformtools.ab.i("kinda.NetSceneKindaGenDigitalCert", "crt_csr uin: %s: devideid: %s crt: %s", new Object[] { localObject3, str1, str2 });
    localObject3 = com.tencent.mm.wallet_core.c.b.dSi();
    com.tencent.mm.wallet_core.b.dRI();
    i = k;
    if (com.tencent.mm.wallet_core.b.dRL()) {
      i = 1;
    }
    localObject3 = ((com.tencent.mm.wallet_core.c.b)localObject3).eY(str2, i);
    try
    {
      paramMap.put("sn_salt", com.tencent.mm.compatible.util.q.encode((String)localObject1));
      paramMap.put("crt_csr", com.tencent.mm.compatible.util.q.encode((String)localObject3));
      paramMap.put("crt_device_id", localObject2);
      paramMap.put("device_os", d.eQs);
      paramMap.put("device_name", d.whE);
      AppMethodBeat.o(144549);
      return;
    }
    catch (Exception paramMap)
    {
      AppMethodBeat.o(144549);
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
  
  public void onGYNetEnd(int paramInt, String paramString, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(144551);
    com.tencent.mm.sdk.platformtools.ab.i("kinda.NetSceneKindaGenDigitalCert", "errCode %d errMsg %s", new Object[] { Integer.valueOf(paramInt), paramString });
    for (;;)
    {
      try
      {
        String str = paramJSONObject.optString("crt_crt");
        paramJSONObject = paramJSONObject.optString("crt_no");
        boolean bool = com.tencent.mm.wallet_core.c.b.dSi().importCert(paramJSONObject, str);
        com.tencent.mm.wallet_core.c.ab.avX(paramJSONObject);
        if (!bool) {
          continue;
        }
        com.tencent.mm.sdk.platformtools.ab.i("kinda.NetSceneKindaGenDigitalCert", "importCert crt_crt success");
        com.tencent.mm.sdk.platformtools.ab.i("kinda.NetSceneKindaGenDigitalCert", "_crt_crt %s _crt_no %s", new Object[] { ag.cE(str), paramJSONObject });
      }
      catch (Exception paramJSONObject)
      {
        com.tencent.mm.sdk.platformtools.ab.printErrStackTrace("kinda.NetSceneKindaGenDigitalCert", paramJSONObject, "", new Object[0]);
        continue;
        if (this.m_successCallback == null) {
          continue;
        }
        this.m_successCallback.call();
        AppMethodBeat.o(144551);
      }
      if (paramInt == 0) {
        continue;
      }
      if (this.m_failCallback != null) {
        this.m_failCallback.call(paramString);
      }
      AppMethodBeat.o(144551);
      return;
      com.tencent.mm.sdk.platformtools.ab.e("kinda.NetSceneKindaGenDigitalCert", "importCert crt_crt fail");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.kinda.framework.module.impl.NetSceneKindaGenDigitalCert
 * JD-Core Version:    0.7.0.1
 */