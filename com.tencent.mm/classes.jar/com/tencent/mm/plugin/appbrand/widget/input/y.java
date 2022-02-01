package com.tencent.mm.plugin.appbrand.widget.input;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.deviceinfo.q;
import com.tencent.mm.plugin.appbrand.page.ad;
import com.tencent.mm.plugin.appbrand.widget.input.e.h;
import com.tencent.mm.sdk.platformtools.Log;
import com.tenpay.miniapp.MiniAppSecureEditText;
import java.util.List;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"CODE_STUB", "", "KEY_CODE_STUB", "", "TAG", "", "getEncryptedData", "Lcom/tencent/mm/plugin/appbrand/widget/input/AppBrandSecureInputWidget;", "env", "Lcom/tencent/mm/plugin/appbrand/page/AppBrandPageView;", "inputParams", "Lcom/tencent/mm/plugin/appbrand/widget/input/params/UpdateParams;", "luggage-wxa-app-input-ext_release"})
public final class y
{
  public static final String a(x paramx, ad paramad, h paramh)
  {
    AppMethodBeat.i(213861);
    if ((paramx == null) || (paramad == null) || (paramh == null))
    {
      Log.e("MicroMsg.AppBrand.AppBrandSecureInputWidget", "getEncryptedData, this: " + paramx + ", env: " + paramad + ", inputParams: " + paramh);
      paramx = (Throwable)new IllegalStateException("env error");
      AppMethodBeat.o(213861);
      throw paramx;
    }
    String str1 = paramh.rAR;
    if (str1 == null)
    {
      paramx = (Throwable)new IllegalStateException("need certPath");
      AppMethodBeat.o(213861);
      throw paramx;
    }
    p.j(str1, "inputParams.safePassword…D_ERR_MSG_NEED_CERT_PATH)");
    Object localObject = paramh.rAU;
    if (localObject == null)
    {
      paramx = (Throwable)new IllegalStateException("need timeStamp");
      AppMethodBeat.o(213861);
      throw paramx;
    }
    p.j(localObject, "inputParams.safePassword…_ERR_MSG_NEED_TIME_STAMP)");
    long l1 = ((Long)localObject).longValue();
    localObject = paramh.rAV;
    if (localObject == null)
    {
      paramx = (Throwable)new IllegalStateException("need nonce");
      AppMethodBeat.o(213861);
      throw paramx;
    }
    p.j(localObject, "inputParams.safePassword…SWORD_ERR_MSG_NEED_NONCE)");
    long l2 = ((Long)localObject).longValue();
    localObject = paramh.rAT;
    paramh = paramh.rAW;
    p.j(paramh, "inputParams.safePasswordCompatList");
    if ((localObject == null) && (paramh.isEmpty()))
    {
      paramx = (Throwable)new IllegalStateException("need salt or customHash");
      AppMethodBeat.o(213861);
      throw paramx;
    }
    String str2 = at.cpm();
    if (str2 == null)
    {
      Log.e(paramx.getMyTag$luggage_wxa_app_input_ext_release(), "getEncryptedData, rootPath is null");
      paramx = (Throwable)new IllegalStateException("env error");
      AppMethodBeat.o(213861);
      throw paramx;
    }
    paramad = paramx.a(paramad, str1);
    q.dR(true);
    if (!paramx.getSecureInputWidgetLogic$luggage_wxa_app_input_ext_release().setCertContext(paramad, str2, q.dR(true)))
    {
      Log.e(paramx.getMyTag$luggage_wxa_app_input_ext_release(), "getEncryptedData, setCertContext fail");
      paramx = (Throwable)new IllegalStateException("sdk error:" + paramx.getSecureInputWidgetLogic$luggage_wxa_app_input_ext_release().getLastError());
      AppMethodBeat.o(213861);
      throw paramx;
    }
    if (paramh.isEmpty())
    {
      paramad = paramx.getSecureInputWidgetLogic$luggage_wxa_app_input_ext_release();
      paramad.setSalt((String)localObject);
      paramad.setTimeStamp(l1);
      paramad.setNonce(l2);
    }
    for (paramad = paramad.getEncryptedData();; paramad = au.a(paramx.getSecureInputWidgetLogic$luggage_wxa_app_input_ext_release(), paramh, l1, l2))
    {
      Log.d(paramx.getMyTag$luggage_wxa_app_input_ext_release(), "getEncryptedData, encryptedData: ".concat(String.valueOf(paramad)));
      if (paramad != null) {
        break;
      }
      paramx = (Throwable)new IllegalStateException("sdk error:" + paramx.getSecureInputWidgetLogic$luggage_wxa_app_input_ext_release().getLastError());
      AppMethodBeat.o(213861);
      throw paramx;
      paramad = au.ryC;
    }
    AppMethodBeat.o(213861);
    return paramad;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.input.y
 * JD-Core Version:    0.7.0.1
 */