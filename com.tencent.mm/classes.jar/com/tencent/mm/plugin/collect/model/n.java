package com.tencent.mm.plugin.collect.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.ae;
import com.tencent.mm.storage.ah.a;
import com.tencent.mm.wallet_core.b.a.a;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class n
  extends a
{
  public long dBN;
  public int dae;
  public String desc;
  public String iAx;
  public String iAy;
  public String oxf;
  public String oxg;
  public int oxh;
  public String oxi;
  public String oxj;
  public String oxk;
  public String oxl;
  public String oxm;
  public String oxn;
  public int oxo;
  public String oxp;
  public String oxq;
  public int oxr;
  
  public n(int paramInt)
  {
    AppMethodBeat.i(63832);
    HashMap localHashMap = new HashMap();
    localHashMap.put("set_amount", "0");
    localHashMap.put("wallet_type", String.valueOf(paramInt));
    setRequestData(localHashMap);
    ac.i("MicroMsg.NetSceneH5F2fTransferGetQrCode", "setAmount: %s, walletType: %s", new Object[] { Integer.valueOf(0), Integer.valueOf(paramInt) });
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
      if (!bs.isNullOrNil(paramString)) {
        localHashMap.put("desc", URLEncoder.encode(paramString, "UTF-8"));
      }
      localHashMap.put("wallet_type", String.valueOf(paramInt));
      setRequestData(localHashMap);
      this.dBN = paramLong;
      this.desc = paramString;
      ac.i("MicroMsg.NetSceneH5F2fTransferGetQrCode", "amount: %d, setAmount: %s, desc: %s, walletType: %s", new Object[] { Long.valueOf(paramLong), Integer.valueOf(1), paramString, Integer.valueOf(paramInt) });
      AppMethodBeat.o(63833);
      return;
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException)
    {
      for (;;)
      {
        ac.printErrStackTrace("MicroMsg.NetSceneH5F2fTransferGetQrCode", localUnsupportedEncodingException, "", new Object[0]);
      }
    }
  }
  
  public final String bVR()
  {
    return "/cgi-bin/mmpay-bin/h5f2ftransfergetqrcode";
  }
  
  public final int bVS()
  {
    return 1335;
  }
  
  public final boolean bVT()
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
    this.dae = paramJSONObject.optInt("retcode", 0);
    this.oxf = paramJSONObject.optString("retmsg", "");
    this.oxg = paramJSONObject.optString("qrcode_url", "");
    this.oxh = paramJSONObject.optInt("alert_type", 0);
    this.oxi = paramJSONObject.optString("alert_title", "");
    this.oxj = paramJSONObject.optString("left_button_text", "");
    this.oxk = paramJSONObject.optString("right_button_text", "");
    this.oxl = paramJSONObject.optString("right_button_url", "");
    this.oxm = paramJSONObject.optString("bottom_text", "");
    this.oxn = paramJSONObject.optString("bottom_url", "");
    this.oxo = paramJSONObject.optInt("currency", 0);
    this.oxp = paramJSONObject.optString("currencyunit", "");
    this.iAx = paramJSONObject.optString("notice", "");
    this.iAy = paramJSONObject.optString("notice_url", "");
    this.oxq = paramJSONObject.optString("recv_realname", "");
    this.oxr = paramJSONObject.optInt("set_amount", 0);
    if (this.oxr == 0)
    {
      g.agS();
      g.agR().agA().set(ah.a.GNk, this.oxg);
      ac.i("MicroMsg.NetSceneH5F2fTransferGetQrCode", "set payurl: %s", new Object[] { this.oxg });
    }
    ac.d("MicroMsg.NetSceneH5F2fTransferGetQrCode", "url: %s, currency: %s", new Object[] { this.oxg, Integer.valueOf(this.oxo) });
    AppMethodBeat.o(63834);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.collect.model.n
 * JD-Core Version:    0.7.0.1
 */