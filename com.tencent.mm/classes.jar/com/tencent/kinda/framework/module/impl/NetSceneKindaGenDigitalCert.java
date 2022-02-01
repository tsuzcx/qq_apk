package com.tencent.kinda.framework.module.impl;

import com.tencent.kinda.gen.KGenDigitalCrtReq;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.b.p;
import com.tencent.mm.compatible.deviceinfo.q;
import com.tencent.mm.compatible.util.r;
import com.tencent.mm.kernel.h;
import com.tencent.mm.protocal.d;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MD5Util;
import com.tencent.mm.wallet_core.model.ae;
import com.tencent.mm.wallet_core.model.e;
import com.tencent.mm.wallet_core.model.y;
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
      localHashMap1.put("type", r.cg("1"));
      localHashMap1.put("id_no", r.cg(paramKGenDigitalCrtReq.getIdNo()));
      localHashMap1.put("id_type", r.cg(paramKGenDigitalCrtReq.getIdType()));
    }
    for (;;)
    {
      setRequestData(localHashMap1);
      setWXRequestData(localHashMap2);
      AppMethodBeat.o(18667);
      return;
      if (paramKGenDigitalCrtReq.mType == 2)
      {
        localHashMap1.put("type", r.cg("2"));
        localHashMap1.put("crt_sms", r.cg(paramKGenDigitalCrtReq.getVerifyCode()));
        localHashMap1.put("reqkey", r.cg(paramKGenDigitalCrtReq.getReqKey()));
      }
      else if (paramKGenDigitalCrtReq.mType == 3)
      {
        localHashMap1.put("type", r.cg("3"));
        localHashMap1.put("crt_token", r.cg(paramKGenDigitalCrtReq.getToken()));
      }
      else if (paramKGenDigitalCrtReq.mType == 4)
      {
        localHashMap1.put("type", r.cg("4"));
        localHashMap1.put("id_type", r.cg(paramKGenDigitalCrtReq.getIdType()));
        localHashMap1.put("cre_tail", r.cg(paramKGenDigitalCrtReq.getCreTail()));
        localHashMap1.put("reqkey", r.cg(paramKGenDigitalCrtReq.getReqKey()));
      }
      else
      {
        Log.e("kinda.NetSceneKindaGenDigitalCert", "KGenDigitalCrtReq.mType is illeagl.");
      }
    }
  }
  
  private void baseRequset(Map<String, String> paramMap)
  {
    int k = 0;
    AppMethodBeat.i(18666);
    h.baF();
    h.baC();
    Object localObject3 = p.getString(com.tencent.mm.kernel.b.getUin());
    String str1 = q.eD(false);
    byte[] arrayOfByte = new byte[16];
    Object localObject2 = y.jON().getBytes();
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
    localObject2 = MD5Util.getMD5String((String)localObject3 + str1);
    String str2 = MD5Util.getMD5String((String)localObject3 + (String)localObject2 + new String(arrayOfByte));
    Log.i("kinda.NetSceneKindaGenDigitalCert", "salt " + new String(arrayOfByte));
    Log.i("kinda.NetSceneKindaGenDigitalCert", "crt_csr uin: %s: devideid: %s crt: %s", new Object[] { localObject3, str1, str2 });
    localObject3 = com.tencent.mm.wallet_core.model.b.jOG();
    com.tencent.mm.wallet_core.b.jNX();
    i = k;
    if (com.tencent.mm.wallet_core.b.jOa()) {
      i = 1;
    }
    localObject3 = ((com.tencent.mm.wallet_core.model.b)localObject3).jm(str2, i);
    try
    {
      paramMap.put("sn_salt", r.cg((String)localObject1));
      paramMap.put("crt_csr", r.cg((String)localObject3));
      paramMap.put("crt_device_id", localObject2);
      paramMap.put("device_os", d.nsC);
      paramMap.put("device_name", d.Yxd);
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
    Log.i("kinda.NetSceneKindaGenDigitalCert", "errCode %d errMsg %s", new Object[] { Integer.valueOf(parame.errCode), parame.errMsg });
    for (;;)
    {
      try
      {
        String str = paramJSONObject.optString("crt_crt");
        paramJSONObject = paramJSONObject.optString("crt_no");
        if (parame.errCode == 0)
        {
          boolean bool = com.tencent.mm.wallet_core.model.b.jOG().importCert(paramJSONObject, str);
          ae.bEF(paramJSONObject);
          if (bool)
          {
            Log.i("kinda.NetSceneKindaGenDigitalCert", "importCert crt_crt success");
            Log.i("kinda.NetSceneKindaGenDigitalCert", "_crt_crt %s _crt_no %s", new Object[] { MD5Util.getMD5String(str), paramJSONObject });
            AppMethodBeat.o(18668);
            return;
          }
          Log.e("kinda.NetSceneKindaGenDigitalCert", "importCert crt_crt fail");
          continue;
        }
        com.tencent.mm.wallet_core.model.b.jOG().jOH();
      }
      catch (Exception parame)
      {
        Log.printErrStackTrace("kinda.NetSceneKindaGenDigitalCert", parame, "", new Object[0]);
        AppMethodBeat.o(18668);
        return;
      }
      Log.e("kinda.NetSceneKindaGenDigitalCert", " importCert crt_crt was not executed because of cgi resp error");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.kinda.framework.module.impl.NetSceneKindaGenDigitalCert
 * JD-Core Version:    0.7.0.1
 */