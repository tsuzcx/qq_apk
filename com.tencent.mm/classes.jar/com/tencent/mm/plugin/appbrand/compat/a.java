package com.tencent.mm.plugin.appbrand.compat;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.af.j.b;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.w;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelappbrand.b;
import com.tencent.mm.plugin.appbrand.compat.a.a.a;
import com.tencent.mm.plugin.appbrand.s.r;
import com.tencent.mm.plugin.appbrand.ui.AppBrandNearbyWebViewUI;
import com.tencent.mm.plugin.appbrand.ui.AppBrandSearchUI;
import com.tencent.mm.pluginsdk.model.app.l;
import com.tencent.mm.protocal.GeneralControlWrapper;
import com.tencent.mm.protocal.JsapiPermissionWrapper;
import com.tencent.mm.protocal.protobuf.ask;
import com.tencent.mm.protocal.protobuf.asl;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.z;
import java.util.Map;

final class a
  implements com.tencent.mm.plugin.appbrand.compat.a.a
{
  public final Intent E(Context paramContext, int paramInt)
  {
    AppMethodBeat.i(17018);
    Intent localIntent = new Intent();
    localIntent.putExtra("hardcode_jspermission", JsapiPermissionWrapper.wib);
    localIntent.putExtra("hardcode_general_ctrl", GeneralControlWrapper.whX);
    localIntent.putExtra("neverGetA8Key", true);
    localIntent.setClass(paramContext, AppBrandSearchUI.class);
    localIntent.putExtra("key_trust_url", true);
    localIntent.putExtra("title", paramContext.getString(2131296652));
    localIntent.putExtra("searchbar_tips", paramContext.getString(2131296652));
    localIntent.putExtra("KRightBtn", true);
    localIntent.putExtra("ftsneedkeyboard", true);
    localIntent.putExtra("ftsType", 64);
    localIntent.putExtra("ftsbizscene", paramInt);
    Object localObject = r.d(paramInt, true, 64);
    String str = b.ach();
    ((Map)localObject).put("WASessionId", str);
    ((Map)localObject).put("sessionId", str);
    ((Map)localObject).put("subSessionId", str);
    localIntent.putExtra("rawUrl", r.F((Map)localObject));
    localIntent.putExtra("key_load_js_without_delay", true);
    localIntent.addFlags(67108864);
    localIntent.putExtra("key_session_id", str);
    localIntent.putExtra("sessionId", str);
    localIntent.putExtra("subSessionId", str);
    localObject = g.RL().Ru().get(ac.a.yEV, null);
    if ((localObject != null) && ((localObject instanceof String)))
    {
      localObject = (String)localObject;
      localIntent.putExtra("key_search_input_hint", (String)localObject);
      if ((paramContext instanceof Activity)) {
        break label327;
      }
    }
    label327:
    for (boolean bool = true;; bool = false)
    {
      localIntent.putExtra("key_alpha_in", bool);
      localIntent.putExtra("key_preload_biz", 5);
      AppMethodBeat.o(17018);
      return localIntent;
      localObject = "";
      break;
    }
  }
  
  public final void T(Context paramContext, String paramString)
  {
    AppMethodBeat.i(17016);
    paramString = new Intent(paramContext, AppBrandNearbyWebViewUI.class).putExtra("rawUrl", paramString);
    paramString.putExtra("title", paramContext.getString(2131296744));
    if (!(paramContext instanceof Activity)) {
      paramString.addFlags(268435456);
    }
    if ((paramContext instanceof Activity))
    {
      ((Activity)paramContext).startActivityForResult(paramString, 3);
      AppMethodBeat.o(17016);
      return;
    }
    paramContext.startActivity(paramString);
    AppMethodBeat.o(17016);
  }
  
  public final void U(Context paramContext, String paramString)
  {
    AppMethodBeat.i(17017);
    paramString = new Intent(paramContext, AppBrandNearbyWebViewUI.class).putExtra("rawUrl", paramString);
    paramString.putExtra("title", paramContext.getString(2131296714));
    if (!(paramContext instanceof Activity)) {
      paramString.addFlags(268435456);
    }
    if ((paramContext instanceof Activity))
    {
      ((Activity)paramContext).startActivityForResult(paramString, 4);
      AppMethodBeat.o(17017);
      return;
    }
    paramContext.startActivity(paramString);
    AppMethodBeat.o(17017);
  }
  
  public final void a(j.b paramb, String paramString1, String paramString2, String paramString3, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(17019);
    l.a(paramb, paramString1, paramString2, paramString3, null, paramArrayOfByte);
    AppMethodBeat.o(17019);
  }
  
  public final void a(a.a parama)
  {
    AppMethodBeat.i(17020);
    b.a locala = new b.a();
    locala.fsX = new ask();
    locala.fsY = new asl();
    locala.uri = "/cgi-bin/mmoc-bin/hardware/getwerunuserstate";
    locala.funcId = 1926;
    locala.reqCmdId = 0;
    locala.respCmdId = 0;
    w.a(locala.ado(), new a.1(this, parama), true);
    AppMethodBeat.o(17020);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.compat.a
 * JD-Core Version:    0.7.0.1
 */