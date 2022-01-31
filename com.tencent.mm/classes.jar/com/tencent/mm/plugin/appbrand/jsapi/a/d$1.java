package com.tencent.mm.plugin.appbrand.jsapi.a;

import android.text.TextUtils;
import com.tencent.mm.ah.b;
import com.tencent.mm.ah.b.c;
import com.tencent.mm.ipcinvoker.wx_extension.b.a;
import com.tencent.mm.plugin.appbrand.page.q;
import com.tencent.mm.protocal.c.alr;
import com.tencent.mm.sdk.platformtools.y;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import org.json.JSONArray;

final class d$1
  implements b.a
{
  d$1(d paramd, q paramq, int paramInt) {}
  
  public final void a(int paramInt1, int paramInt2, String paramString, b paramb)
  {
    HashMap localHashMap = new HashMap();
    if ((paramInt1 != 0) || (paramInt2 != 0) || (paramb.ecF.ecN == null))
    {
      y.e("MicroMsg.JsApiGetUserAutoFillData", "getUserAutoFillData cgi failed, errType = %d, errCode = %d, errMsg = %s, rr.resp = %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString, paramb.ecF.ecN });
      localHashMap.put("ret", Integer.valueOf(paramInt2));
      if (!TextUtils.isEmpty(paramString))
      {
        this.gkf.C(this.dIS, this.gkL.h("fail: ErrMsg:" + paramString, localHashMap));
        return;
      }
      this.gkf.C(this.dIS, this.gkL.h("fail: ErrMsg: cgi fail", localHashMap));
      return;
    }
    Object localObject = (alr)paramb.ecF.ecN;
    y.i("MicroMsg.JsApiGetUserAutoFillData", "getUserAutoFillData success");
    paramString = "";
    if (!TextUtils.isEmpty(((alr)localObject).thG)) {
      paramString = ((alr)localObject).thG;
    }
    paramb = "";
    if (!TextUtils.isEmpty(((alr)localObject).thH)) {
      paramb = ((alr)localObject).thH;
    }
    paramInt1 = ((alr)localObject).syA;
    localObject = ((alr)localObject).thI;
    y.i("MicroMsg.JsApiGetUserAutoFillData", "auth_info:%s, auth_status:%d", new Object[] { paramb, Integer.valueOf(paramInt1) });
    y.i("MicroMsg.JsApiGetUserAutoFillData", "user_info_json:%s", new Object[] { paramString });
    localHashMap.put("userData", paramString);
    localHashMap.put("authStatus", Integer.valueOf(paramInt1));
    localHashMap.put("authInfo", paramb);
    if ((localObject != null) && (((LinkedList)localObject).size() > 0))
    {
      localHashMap.put("authGroupList", new JSONArray((Collection)localObject));
      y.i("MicroMsg.JsApiGetUserAutoFillData", "authGroupList:%s", new Object[] { new JSONArray((Collection)localObject).toString() });
    }
    this.gkf.C(this.dIS, this.gkL.h("ok", localHashMap));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.a.d.1
 * JD-Core Version:    0.7.0.1
 */