package com.tencent.mm.plugin.collect.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.al.a;
import com.tencent.mm.wallet_core.b.a.a;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class n
  extends a
{
  public long dOa;
  public String desc;
  public int dlw;
  public String iTH;
  public String iTI;
  public String paA;
  public String paB;
  public int paC;
  public String paD;
  public String paE;
  public String paF;
  public String paG;
  public String paH;
  public String paI;
  public int paJ;
  public String paK;
  public String paL;
  public int paM;
  
  public n(int paramInt)
  {
    AppMethodBeat.i(63832);
    HashMap localHashMap = new HashMap();
    localHashMap.put("set_amount", "0");
    localHashMap.put("wallet_type", String.valueOf(paramInt));
    setRequestData(localHashMap);
    ad.i("MicroMsg.NetSceneH5F2fTransferGetQrCode", "setAmount: %s, walletType: %s", new Object[] { Integer.valueOf(0), Integer.valueOf(paramInt) });
    AppMethodBeat.o(63832);
  }
  
  public n(long paramLong, String paramString, int paramInt)
  {
    AppMethodBeat.i(63833);
    HashMap localHashMap = new HashMap();
    localHashMap.put("amount", String.valueOf(paramLong));
    localHashMap.put("set_amount", "1");
    try
    {
      if (!bt.isNullOrNil(paramString)) {
        localHashMap.put("desc", URLEncoder.encode(paramString, "UTF-8"));
      }
      localHashMap.put("wallet_type", String.valueOf(paramInt));
      setRequestData(localHashMap);
      this.dOa = paramLong;
      this.desc = paramString;
      ad.i("MicroMsg.NetSceneH5F2fTransferGetQrCode", "amount: %d, setAmount: %s, desc: %s, walletType: %s", new Object[] { Long.valueOf(paramLong), Integer.valueOf(1), paramString, Integer.valueOf(paramInt) });
      AppMethodBeat.o(63833);
      return;
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException)
    {
      for (;;)
      {
        ad.printErrStackTrace("MicroMsg.NetSceneH5F2fTransferGetQrCode", localUnsupportedEncodingException, "", new Object[0]);
      }
    }
  }
  
  public final String cau()
  {
    return "/cgi-bin/mmpay-bin/h5f2ftransfergetqrcode";
  }
  
  public final int cav()
  {
    return 1335;
  }
  
  public final boolean caw()
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
    this.dlw = paramJSONObject.optInt("retcode", 0);
    this.paA = paramJSONObject.optString("retmsg", "");
    this.paB = paramJSONObject.optString("qrcode_url", "");
    this.paC = paramJSONObject.optInt("alert_type", 0);
    this.paD = paramJSONObject.optString("alert_title", "");
    this.paE = paramJSONObject.optString("left_button_text", "");
    this.paF = paramJSONObject.optString("right_button_text", "");
    this.paG = paramJSONObject.optString("right_button_url", "");
    this.paH = paramJSONObject.optString("bottom_text", "");
    this.paI = paramJSONObject.optString("bottom_url", "");
    this.paJ = paramJSONObject.optInt("currency", 0);
    this.paK = paramJSONObject.optString("currencyunit", "");
    this.iTH = paramJSONObject.optString("notice", "");
    this.iTI = paramJSONObject.optString("notice_url", "");
    this.paL = paramJSONObject.optString("recv_realname", "");
    this.paM = paramJSONObject.optInt("set_amount", 0);
    if (this.paM == 0)
    {
      g.ajD();
      g.ajC().ajl().set(al.a.IzB, this.paB);
      ad.i("MicroMsg.NetSceneH5F2fTransferGetQrCode", "set payurl: %s", new Object[] { this.paB });
    }
    ad.d("MicroMsg.NetSceneH5F2fTransferGetQrCode", "url: %s, currency: %s", new Object[] { this.paB, Integer.valueOf(this.paJ) });
    AppMethodBeat.o(63834);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.collect.model.n
 * JD-Core Version:    0.7.0.1
 */