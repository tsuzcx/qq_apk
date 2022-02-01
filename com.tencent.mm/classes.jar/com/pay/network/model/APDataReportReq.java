package com.pay.network.model;

import android.text.TextUtils;
import com.pay.http.APBaseHttpParam;
import com.pay.http.APHttpReqPost;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.midas.data.APPluginDataInterface;
import java.util.HashMap;

public class APDataReportReq
  extends APHttpReqPost
{
  public APDataReportReq()
  {
    AppMethodBeat.i(193299);
    String str = APPluginDataInterface.singleton().getOfferId();
    if (TextUtils.isEmpty(str))
    {
      AppMethodBeat.o(193299);
      return;
    }
    setReportUrl(String.format("/cgi-bin/log_data.fcg?offer_id=%s", new Object[] { str }), String.format("/cgi-bin/log_data.fcg?offer_id=%s", new Object[] { str }), String.format("/cgi-bin/log_data.fcg?offer_id=%s", new Object[] { str }));
    AppMethodBeat.o(193299);
  }
  
  public void startService(String paramString)
  {
    AppMethodBeat.i(193300);
    if (paramString.equals(""))
    {
      AppMethodBeat.o(193300);
      return;
    }
    if (TextUtils.isEmpty(APPluginDataInterface.singleton().getOfferId()))
    {
      AppMethodBeat.o(193300);
      return;
    }
    this.httpParam.reqParam.clear();
    this.httpParam.reqParam.put(paramString, "");
    startRequest();
    AppMethodBeat.o(193300);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.pay.network.model.APDataReportReq
 * JD-Core Version:    0.7.0.1
 */