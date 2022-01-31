package com.tencent.mm.plugin.collect.b;

import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.z;
import com.tencent.mm.wallet_core.b.a.a;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class m
  extends a
{
  public long ceq;
  public String desc;
  public int iHA;
  public String iHB;
  public String iHC;
  public String iHD;
  public String iHE;
  public int iHF;
  public int iHq;
  public String iHr;
  public String iHs;
  public int iHt;
  public String iHu;
  public String iHv;
  public String iHw;
  public String iHx;
  public String iHy;
  public String iHz;
  
  public m(int paramInt)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("set_amount", "0");
    localHashMap.put("wallet_type", String.valueOf(paramInt));
    D(localHashMap);
    y.i("MicroMsg.NetSceneH5F2fTransferGetQrCode", "setAmount: %s, walletType: %s", new Object[] { Integer.valueOf(0), Integer.valueOf(paramInt) });
  }
  
  public m(long paramLong, String paramString, int paramInt)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("amount", String.valueOf(paramLong));
    localHashMap.put("set_amount", "1");
    try
    {
      if (!bk.bl(paramString)) {
        localHashMap.put("desc", URLEncoder.encode(paramString, "UTF-8"));
      }
      localHashMap.put("wallet_type", String.valueOf(paramInt));
      D(localHashMap);
      this.ceq = paramLong;
      this.desc = paramString;
      y.i("MicroMsg.NetSceneH5F2fTransferGetQrCode", "amount: %d, setAmount: %s, desc: %s, walletType: %s", new Object[] { Long.valueOf(paramLong), Integer.valueOf(1), paramString, Integer.valueOf(paramInt) });
      return;
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException)
    {
      for (;;)
      {
        y.printErrStackTrace("MicroMsg.NetSceneH5F2fTransferGetQrCode", localUnsupportedEncodingException, "", new Object[0]);
      }
    }
  }
  
  public final void a(int paramInt, String paramString, JSONObject paramJSONObject)
  {
    this.iHq = paramJSONObject.optInt("retcode", 0);
    this.iHr = paramJSONObject.optString("retmsg", "");
    this.iHs = paramJSONObject.optString("qrcode_url", "");
    this.iHt = paramJSONObject.optInt("alert_type", 0);
    this.iHu = paramJSONObject.optString("alert_title", "");
    this.iHv = paramJSONObject.optString("left_button_text", "");
    this.iHw = paramJSONObject.optString("right_button_text", "");
    this.iHx = paramJSONObject.optString("right_button_url", "");
    this.iHy = paramJSONObject.optString("bottom_text", "");
    this.iHz = paramJSONObject.optString("bottom_url", "");
    this.iHA = paramJSONObject.optInt("currency", 0);
    this.iHB = paramJSONObject.optString("currencyunit", "");
    this.iHC = paramJSONObject.optString("notice", "");
    this.iHD = paramJSONObject.optString("notice_url", "");
    this.iHE = paramJSONObject.optString("recv_realname", "");
    this.iHF = paramJSONObject.optInt("set_amount", 0);
    if (this.iHF == 0)
    {
      g.DQ();
      g.DP().Dz().c(ac.a.uwB, this.iHs);
      y.i("MicroMsg.NetSceneH5F2fTransferGetQrCode", "set payurl: %s", new Object[] { this.iHs });
    }
    y.d("MicroMsg.NetSceneH5F2fTransferGetQrCode", "url: %s, currency: %s", new Object[] { this.iHs, Integer.valueOf(this.iHA) });
  }
  
  public final int aEA()
  {
    return 1335;
  }
  
  public final boolean aEB()
  {
    return true;
  }
  
  public final String aEz()
  {
    return "/cgi-bin/mmpay-bin/h5f2ftransfergetqrcode";
  }
  
  public final int getType()
  {
    return 1335;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.collect.b.m
 * JD-Core Version:    0.7.0.1
 */