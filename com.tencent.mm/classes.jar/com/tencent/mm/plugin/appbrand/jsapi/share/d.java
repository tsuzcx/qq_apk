package com.tencent.mm.plugin.appbrand.jsapi.share;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.y.b;
import com.tencent.mm.plugin.appbrand.menu.p;
import com.tencent.mm.plugin.appbrand.menu.q;
import com.tencent.mm.plugin.appbrand.page.ae;
import com.tencent.mm.plugin.appbrand.report.h;
import com.tencent.mm.plugin.appbrand.service.c;
import com.tencent.mm.sdk.platformtools.bt;
import org.json.JSONObject;

public final class d
  extends JsApiShareAppMessageBase<JsApiShareAppMessageBase.d>
{
  public static final int CTRL_INDEX = 73;
  public static final String NAME = "shareAppMessage";
  
  private static void a(String paramString1, String paramString2, int paramInt1, String paramString3, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(174889);
    h.a(paramString1, paramString2, paramInt1, paramString3, bt.aGK(), paramInt2, paramInt3);
    AppMethodBeat.o(174889);
  }
  
  protected final JsApiShareAppMessageBase.d a(c paramc, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(174884);
    paramc = super.a(paramc, paramJSONObject);
    paramJSONObject = paramc.kjS.ts(q.kSb.ordinal()).jBF;
    if (!paramJSONObject.tE("user_clicked_share_btn"))
    {
      paramc = new JsApiShareAppMessageBase.c("not allow to share");
      AppMethodBeat.o(174884);
      throw paramc;
    }
    paramJSONObject.F("user_clicked_share_btn", false);
    AppMethodBeat.o(174884);
    return paramc;
  }
  
  protected final void a(JsApiShareAppMessageBase.d paramd)
  {
    AppMethodBeat.i(174886);
    super.a(paramd);
    if (paramd.withShareTicket) {}
    for (int i = 16;; i = 2)
    {
      a(paramd.appId, paramd.dbu, i, "", 2, -1);
      AppMethodBeat.o(174886);
      return;
    }
  }
  
  protected final void a(JsApiShareAppMessageBase.d paramd, int paramInt)
  {
    AppMethodBeat.i(174885);
    super.a(paramd, paramInt);
    String str1 = paramd.appId;
    String str2 = paramd.dbu;
    if (paramd.withShareTicket) {}
    for (int i = 16;; i = 2)
    {
      a(str1, str2, i, "", 3, paramInt);
      AppMethodBeat.o(174885);
      return;
    }
  }
  
  protected final void a(boolean paramBoolean, JsApiShareAppMessageBase.d paramd, String paramString)
  {
    AppMethodBeat.i(174887);
    super.a(paramBoolean, paramd, paramString);
    int i;
    if (paramBoolean)
    {
      i = 16;
      String str = paramString + ":";
      if (paramString.toLowerCase().endsWith("@chatroom")) {
        i = 15;
      }
      a(paramd.appId, paramd.dbu, i, str, 1, -1);
    }
    for (;;)
    {
      paramd.kjV.b(paramd);
      AppMethodBeat.o(174887);
      return;
      i = 2;
      if (paramString.toLowerCase().endsWith("@chatroom")) {
        i = 9;
      }
      a(paramd.appId, paramd.dbu, i, "", 1, -1);
    }
  }
  
  protected final JsApiShareAppMessageBase.d bbS()
  {
    AppMethodBeat.i(174888);
    JsApiShareAppMessageBase.d locald = new JsApiShareAppMessageBase.d();
    AppMethodBeat.o(174888);
    return locald;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.share.d
 * JD-Core Version:    0.7.0.1
 */