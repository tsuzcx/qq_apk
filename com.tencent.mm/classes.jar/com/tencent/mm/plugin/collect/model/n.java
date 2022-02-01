package com.tencent.mm.plugin.collect.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.aj;
import com.tencent.mm.storage.am.a;
import com.tencent.mm.wallet_core.b.a.a;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class n
  extends a
{
  public long dPq;
  public String desc;
  public int dmy;
  public String iWA;
  public String iWB;
  public String phe;
  public String phf;
  public int phg;
  public String phh;
  public String phi;
  public String phj;
  public String phk;
  public String phl;
  public String phm;
  public int phn;
  public String pho;
  public String php;
  public int phq;
  
  public n(int paramInt)
  {
    AppMethodBeat.i(63832);
    HashMap localHashMap = new HashMap();
    localHashMap.put("set_amount", "0");
    localHashMap.put("wallet_type", String.valueOf(paramInt));
    setRequestData(localHashMap);
    ae.i("MicroMsg.NetSceneH5F2fTransferGetQrCode", "setAmount: %s, walletType: %s", new Object[] { Integer.valueOf(0), Integer.valueOf(paramInt) });
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
      if (!bu.isNullOrNil(paramString)) {
        localHashMap.put("desc", URLEncoder.encode(paramString, "UTF-8"));
      }
      localHashMap.put("wallet_type", String.valueOf(paramInt));
      setRequestData(localHashMap);
      this.dPq = paramLong;
      this.desc = paramString;
      ae.i("MicroMsg.NetSceneH5F2fTransferGetQrCode", "amount: %d, setAmount: %s, desc: %s, walletType: %s", new Object[] { Long.valueOf(paramLong), Integer.valueOf(1), paramString, Integer.valueOf(paramInt) });
      AppMethodBeat.o(63833);
      return;
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException)
    {
      for (;;)
      {
        ae.printErrStackTrace("MicroMsg.NetSceneH5F2fTransferGetQrCode", localUnsupportedEncodingException, "", new Object[0]);
      }
    }
  }
  
  public final String cbJ()
  {
    return "/cgi-bin/mmpay-bin/h5f2ftransfergetqrcode";
  }
  
  public final int cbK()
  {
    return 1335;
  }
  
  public final boolean cbL()
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
    this.dmy = paramJSONObject.optInt("retcode", 0);
    this.phe = paramJSONObject.optString("retmsg", "");
    this.phf = paramJSONObject.optString("qrcode_url", "");
    this.phg = paramJSONObject.optInt("alert_type", 0);
    this.phh = paramJSONObject.optString("alert_title", "");
    this.phi = paramJSONObject.optString("left_button_text", "");
    this.phj = paramJSONObject.optString("right_button_text", "");
    this.phk = paramJSONObject.optString("right_button_url", "");
    this.phl = paramJSONObject.optString("bottom_text", "");
    this.phm = paramJSONObject.optString("bottom_url", "");
    this.phn = paramJSONObject.optInt("currency", 0);
    this.pho = paramJSONObject.optString("currencyunit", "");
    this.iWA = paramJSONObject.optString("notice", "");
    this.iWB = paramJSONObject.optString("notice_url", "");
    this.php = paramJSONObject.optString("recv_realname", "");
    this.phq = paramJSONObject.optInt("set_amount", 0);
    if (this.phq == 0)
    {
      g.ajS();
      g.ajR().ajA().set(am.a.IUa, this.phf);
      ae.i("MicroMsg.NetSceneH5F2fTransferGetQrCode", "set payurl: %s", new Object[] { this.phf });
    }
    ae.d("MicroMsg.NetSceneH5F2fTransferGetQrCode", "url: %s, currency: %s", new Object[] { this.phf, Integer.valueOf(this.phn) });
    AppMethodBeat.o(63834);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.collect.model.n
 * JD-Core Version:    0.7.0.1
 */