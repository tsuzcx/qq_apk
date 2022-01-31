package com.tencent.mm.plugin.collect.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
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
  public long cNd;
  public int cnK;
  public String desc;
  public String kNA;
  public String kNB;
  public String kNC;
  public String kND;
  public int kNE;
  public String kNF;
  public String kNG;
  public String kNH;
  public String kNI;
  public int kNJ;
  public String kNv;
  public String kNw;
  public int kNx;
  public String kNy;
  public String kNz;
  
  public m(int paramInt)
  {
    AppMethodBeat.i(40980);
    HashMap localHashMap = new HashMap();
    localHashMap.put("set_amount", "0");
    localHashMap.put("wallet_type", String.valueOf(paramInt));
    setRequestData(localHashMap);
    ab.i("MicroMsg.NetSceneH5F2fTransferGetQrCode", "setAmount: %s, walletType: %s", new Object[] { Integer.valueOf(0), Integer.valueOf(paramInt) });
    AppMethodBeat.o(40980);
  }
  
  public m(long paramLong, String paramString, int paramInt)
  {
    AppMethodBeat.i(40981);
    HashMap localHashMap = new HashMap();
    localHashMap.put("amount", String.valueOf(paramLong));
    localHashMap.put("set_amount", "1");
    try
    {
      if (!bo.isNullOrNil(paramString)) {
        localHashMap.put("desc", URLEncoder.encode(paramString, "UTF-8"));
      }
      localHashMap.put("wallet_type", String.valueOf(paramInt));
      setRequestData(localHashMap);
      this.cNd = paramLong;
      this.desc = paramString;
      ab.i("MicroMsg.NetSceneH5F2fTransferGetQrCode", "amount: %d, setAmount: %s, desc: %s, walletType: %s", new Object[] { Long.valueOf(paramLong), Integer.valueOf(1), paramString, Integer.valueOf(paramInt) });
      AppMethodBeat.o(40981);
      return;
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException)
    {
      for (;;)
      {
        ab.printErrStackTrace("MicroMsg.NetSceneH5F2fTransferGetQrCode", localUnsupportedEncodingException, "", new Object[0]);
      }
    }
  }
  
  public final String bhG()
  {
    return "/cgi-bin/mmpay-bin/h5f2ftransfergetqrcode";
  }
  
  public final int bhH()
  {
    return 1335;
  }
  
  public final boolean bhI()
  {
    return true;
  }
  
  public final int getType()
  {
    return 1335;
  }
  
  public final void onGYNetEnd(int paramInt, String paramString, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(40982);
    this.cnK = paramJSONObject.optInt("retcode", 0);
    this.kNv = paramJSONObject.optString("retmsg", "");
    this.kNw = paramJSONObject.optString("qrcode_url", "");
    this.kNx = paramJSONObject.optInt("alert_type", 0);
    this.kNy = paramJSONObject.optString("alert_title", "");
    this.kNz = paramJSONObject.optString("left_button_text", "");
    this.kNA = paramJSONObject.optString("right_button_text", "");
    this.kNB = paramJSONObject.optString("right_button_url", "");
    this.kNC = paramJSONObject.optString("bottom_text", "");
    this.kND = paramJSONObject.optString("bottom_url", "");
    this.kNE = paramJSONObject.optInt("currency", 0);
    this.kNF = paramJSONObject.optString("currencyunit", "");
    this.kNG = paramJSONObject.optString("notice", "");
    this.kNH = paramJSONObject.optString("notice_url", "");
    this.kNI = paramJSONObject.optString("recv_realname", "");
    this.kNJ = paramJSONObject.optInt("set_amount", 0);
    if (this.kNJ == 0)
    {
      g.RM();
      g.RL().Ru().set(ac.a.yGJ, this.kNw);
      ab.i("MicroMsg.NetSceneH5F2fTransferGetQrCode", "set payurl: %s", new Object[] { this.kNw });
    }
    ab.d("MicroMsg.NetSceneH5F2fTransferGetQrCode", "url: %s, currency: %s", new Object[] { this.kNw, Integer.valueOf(this.kNE) });
    AppMethodBeat.o(40982);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.collect.model.m
 * JD-Core Version:    0.7.0.1
 */