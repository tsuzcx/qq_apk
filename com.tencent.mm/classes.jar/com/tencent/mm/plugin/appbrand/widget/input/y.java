package com.tencent.mm.plugin.appbrand.widget.input;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.deviceinfo.q;
import com.tencent.mm.plugin.appbrand.page.ad;
import com.tencent.mm.plugin.appbrand.widget.input.e.h;
import com.tencent.mm.sdk.platformtools.Log;
import com.tenpay.miniapp.MiniAppSecureEditText;
import java.util.List;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"CODE_STUB", "", "KEY_CODE_STUB", "", "TAG", "", "getEncryptedData", "Lcom/tencent/mm/plugin/appbrand/widget/input/AppBrandSecureInputWidget;", "env", "Lcom/tencent/mm/plugin/appbrand/page/AppBrandPageView;", "inputParams", "Lcom/tencent/mm/plugin/appbrand/widget/input/params/UpdateParams;", "luggage-wxa-app-input-ext_release"}, k=2, mv={1, 5, 1}, xi=48)
public final class y
{
  public static final String a(x paramx, ad paramad, h paramh)
  {
    AppMethodBeat.i(324514);
    if ((paramx == null) || (paramad == null) || (paramh == null))
    {
      Log.e("MicroMsg.AppBrand.AppBrandSecureInputWidget", "getEncryptedData, this: " + paramx + ", env: " + paramad + ", inputParams: " + paramh);
      paramx = new IllegalStateException("env error");
      AppMethodBeat.o(324514);
      throw paramx;
    }
    String str1 = paramh.uMh;
    if (str1 == null)
    {
      paramx = new IllegalStateException("need certPath");
      AppMethodBeat.o(324514);
      throw paramx;
    }
    Object localObject = paramh.uMk;
    if (localObject == null)
    {
      paramx = new IllegalStateException("need timeStamp");
      AppMethodBeat.o(324514);
      throw paramx;
    }
    long l1 = ((Number)localObject).longValue();
    localObject = paramh.uMl;
    if (localObject == null)
    {
      paramx = new IllegalStateException("need nonce");
      AppMethodBeat.o(324514);
      throw paramx;
    }
    long l2 = ((Number)localObject).longValue();
    localObject = paramh.uMj;
    paramh = paramh.uMm;
    s.s(paramh, "inputParams.safePasswordCompatList");
    if ((localObject == null) && (paramh.isEmpty()))
    {
      paramx = new IllegalStateException("need salt or customHash");
      AppMethodBeat.o(324514);
      throw paramx;
    }
    String str2 = at.cRP();
    if (str2 == null)
    {
      Log.e(paramx.getMyTag$luggage_wxa_app_input_ext_release(), "getEncryptedData, rootPath is null");
      paramx = new IllegalStateException("env error");
      AppMethodBeat.o(324514);
      throw paramx;
    }
    paramad = paramx.b(paramad, str1);
    q.eD(true);
    if (!paramx.getSecureInputWidgetLogic$luggage_wxa_app_input_ext_release().setCertContext(paramad, str2, q.eD(true)))
    {
      Log.e(paramx.getMyTag$luggage_wxa_app_input_ext_release(), "getEncryptedData, setCertContext fail");
      paramx = new IllegalStateException(s.X("sdk error:", Integer.valueOf(paramx.getSecureInputWidgetLogic$luggage_wxa_app_input_ext_release().getLastError())));
      AppMethodBeat.o(324514);
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
      Log.d(paramx.getMyTag$luggage_wxa_app_input_ext_release(), s.X("getEncryptedData, encryptedData: ", paramad));
      if (paramad != null) {
        break;
      }
      paramx = new IllegalStateException(s.X("sdk error:", Integer.valueOf(paramx.getSecureInputWidgetLogic$luggage_wxa_app_input_ext_release().getLastError())));
      AppMethodBeat.o(324514);
      throw paramx;
      paramad = au.uJG;
    }
    AppMethodBeat.o(324514);
    return paramad;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.input.y
 * JD-Core Version:    0.7.0.1
 */