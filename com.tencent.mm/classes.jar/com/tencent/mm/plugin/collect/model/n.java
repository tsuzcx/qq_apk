package com.tencent.mm.plugin.collect.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ab;
import com.tencent.mm.storage.ae.a;
import com.tencent.mm.wallet_core.b.a.a;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class n
  extends a
{
  public long dEb;
  public int dcG;
  public String desc;
  public String iau;
  public String iav;
  public String nTK;
  public String nTL;
  public int nTM;
  public String nTN;
  public String nTO;
  public String nTP;
  public String nTQ;
  public String nTR;
  public String nTS;
  public int nTT;
  public String nTU;
  public String nTV;
  public int nTW;
  
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
      this.dEb = paramLong;
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
  
  public final String bOB()
  {
    return "/cgi-bin/mmpay-bin/h5f2ftransfergetqrcode";
  }
  
  public final int bOC()
  {
    return 1335;
  }
  
  public final boolean bOD()
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
    this.dcG = paramJSONObject.optInt("retcode", 0);
    this.nTK = paramJSONObject.optString("retmsg", "");
    this.nTL = paramJSONObject.optString("qrcode_url", "");
    this.nTM = paramJSONObject.optInt("alert_type", 0);
    this.nTN = paramJSONObject.optString("alert_title", "");
    this.nTO = paramJSONObject.optString("left_button_text", "");
    this.nTP = paramJSONObject.optString("right_button_text", "");
    this.nTQ = paramJSONObject.optString("right_button_url", "");
    this.nTR = paramJSONObject.optString("bottom_text", "");
    this.nTS = paramJSONObject.optString("bottom_url", "");
    this.nTT = paramJSONObject.optInt("currency", 0);
    this.nTU = paramJSONObject.optString("currencyunit", "");
    this.iau = paramJSONObject.optString("notice", "");
    this.iav = paramJSONObject.optString("notice_url", "");
    this.nTV = paramJSONObject.optString("recv_realname", "");
    this.nTW = paramJSONObject.optInt("set_amount", 0);
    if (this.nTW == 0)
    {
      g.afC();
      g.afB().afk().set(ae.a.Fpu, this.nTL);
      ad.i("MicroMsg.NetSceneH5F2fTransferGetQrCode", "set payurl: %s", new Object[] { this.nTL });
    }
    ad.d("MicroMsg.NetSceneH5F2fTransferGetQrCode", "url: %s, currency: %s", new Object[] { this.nTL, Integer.valueOf(this.nTT) });
    AppMethodBeat.o(63834);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.collect.model.n
 * JD-Core Version:    0.7.0.1
 */