package com.tencent.mm.plugin.collect.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.f;
import com.tencent.mm.kernel.h;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;
import com.tencent.mm.wallet_core.b.a.a;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class o
  extends a
{
  public String desc;
  public int fwx;
  public long gbJ;
  public String mKL;
  public String mKM;
  public int tVA;
  public String tVo;
  public String tVp;
  public int tVq;
  public String tVr;
  public String tVs;
  public String tVt;
  public String tVu;
  public String tVv;
  public String tVw;
  public int tVx;
  public String tVy;
  public String tVz;
  
  public o(int paramInt)
  {
    AppMethodBeat.i(63832);
    HashMap localHashMap = new HashMap();
    localHashMap.put("set_amount", "0");
    localHashMap.put("wallet_type", String.valueOf(paramInt));
    setRequestData(localHashMap);
    Log.i("MicroMsg.NetSceneH5F2fTransferGetQrCode", "setAmount: %s, walletType: %s", new Object[] { Integer.valueOf(0), Integer.valueOf(paramInt) });
    AppMethodBeat.o(63832);
  }
  
  public o(long paramLong, String paramString, int paramInt)
  {
    AppMethodBeat.i(63833);
    HashMap localHashMap = new HashMap();
    localHashMap.put("amount", String.valueOf(paramLong));
    localHashMap.put("set_amount", "1");
    try
    {
      if (!Util.isNullOrNil(paramString)) {
        localHashMap.put("desc", URLEncoder.encode(paramString, "UTF-8"));
      }
      localHashMap.put("wallet_type", String.valueOf(paramInt));
      setRequestData(localHashMap);
      this.gbJ = paramLong;
      this.desc = paramString;
      Log.i("MicroMsg.NetSceneH5F2fTransferGetQrCode", "amount: %d, setAmount: %s, desc: %s, walletType: %s", new Object[] { Long.valueOf(paramLong), Integer.valueOf(1), paramString, Integer.valueOf(paramInt) });
      AppMethodBeat.o(63833);
      return;
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException)
    {
      for (;;)
      {
        Log.printErrStackTrace("MicroMsg.NetSceneH5F2fTransferGetQrCode", localUnsupportedEncodingException, "", new Object[0]);
      }
    }
  }
  
  public final String cOd()
  {
    return "/cgi-bin/mmpay-bin/h5f2ftransfergetqrcode";
  }
  
  public final int cOe()
  {
    return 1335;
  }
  
  public final boolean cOf()
  {
    return true;
  }
  
  public final int getType()
  {
    return 1335;
  }
  
  public final void onGYNetEnd(int paramInt, String paramString, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(63834);
    this.fwx = paramJSONObject.optInt("retcode", 0);
    this.tVo = paramJSONObject.optString("retmsg", "");
    this.tVp = paramJSONObject.optString("qrcode_url", "");
    this.tVq = paramJSONObject.optInt("alert_type", 0);
    this.tVr = paramJSONObject.optString("alert_title", "");
    this.tVs = paramJSONObject.optString("left_button_text", "");
    this.tVt = paramJSONObject.optString("right_button_text", "");
    this.tVu = paramJSONObject.optString("right_button_url", "");
    this.tVv = paramJSONObject.optString("bottom_text", "");
    this.tVw = paramJSONObject.optString("bottom_url", "");
    this.tVx = paramJSONObject.optInt("currency", 0);
    this.tVy = paramJSONObject.optString("currencyunit", "");
    this.mKL = paramJSONObject.optString("notice", "");
    this.mKM = paramJSONObject.optString("notice_url", "");
    this.tVz = paramJSONObject.optString("recv_realname", "");
    this.tVA = paramJSONObject.optInt("set_amount", 0);
    if (this.tVA == 0)
    {
      h.aHH();
      h.aHG().aHp().set(ar.a.Vqr, this.tVp);
      Log.i("MicroMsg.NetSceneH5F2fTransferGetQrCode", "set payurl: %s", new Object[] { this.tVp });
    }
    Log.d("MicroMsg.NetSceneH5F2fTransferGetQrCode", "url: %s, currency: %s", new Object[] { this.tVp, Integer.valueOf(this.tVx) });
    AppMethodBeat.o(63834);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.collect.model.o
 * JD-Core Version:    0.7.0.1
 */