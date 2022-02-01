package com.tencent.mm.plugin.appbrand.jsapi.auth;

import android.content.Intent;
import com.tencent.luggage.sdk.h.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.y;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/jsapi/auth/JsApiCreateVestUser;", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandAsyncJsApi;", "Lcom/tencent/mm/plugin/appbrand/AppBrandService;", "()V", "REQUEST_CODE", "", "callbackRet", "", "data", "Landroid/content/Intent;", "service", "callbackId", "resultCode", "goAddUserPage", "appId", "", "activity", "Landroid/app/Activity;", "defaultAvatarUrl", "defaultAvatarFileId", "invoke", "env", "Lorg/json/JSONObject;", "Companion", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class m
  extends c<y>
{
  private static final int CTRL_INDEX = 996;
  private static final String NAME = "createVestUser";
  public static final m.a rFI;
  private final int REQUEST_CODE;
  
  static
  {
    AppMethodBeat.i(326912);
    rFI = new m.a((byte)0);
    AppMethodBeat.o(326912);
  }
  
  public m()
  {
    AppMethodBeat.i(326893);
    this.REQUEST_CODE = a.ce(this);
    AppMethodBeat.o(326893);
  }
  
  private final void a(Intent paramIntent, y paramy, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(326897);
    if (paramIntent == null)
    {
      paramy.callback(paramInt1, ZP("fail"));
      AppMethodBeat.o(326897);
      return;
    }
    if (paramInt2 == 0)
    {
      paramy.callback(paramInt1, ZP("fail cancel"));
      AppMethodBeat.o(326897);
      return;
    }
    int i = paramIntent.getIntExtra("id", -1);
    String str = paramIntent.getStringExtra("desc");
    Object localObject1;
    if (str == null)
    {
      str = "";
      localObject2 = paramIntent.getStringExtra("nickname");
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = "";
      }
      localObject2 = paramIntent.getStringExtra("avatarurl");
      paramIntent = (Intent)localObject2;
      if (localObject2 == null) {
        paramIntent = "";
      }
      if (((CharSequence)localObject1).length() != 0) {
        break label175;
      }
      paramInt2 = 1;
      label130:
      if (paramInt2 == 0) {
        if (((CharSequence)paramIntent).length() != 0) {
          break label181;
        }
      }
    }
    label175:
    label181:
    for (paramInt2 = 1;; paramInt2 = 0)
    {
      if (paramInt2 == 0) {
        break label187;
      }
      paramy.callback(paramInt1, ZP("fail"));
      AppMethodBeat.o(326897);
      return;
      break;
      paramInt2 = 0;
      break label130;
    }
    label187:
    Object localObject2 = new HashMap();
    Map localMap = (Map)localObject2;
    HashMap localHashMap = new HashMap();
    ((Map)localHashMap).put("headImg", paramIntent);
    ((Map)localHashMap).put("nickname", localObject1);
    ((Map)localHashMap).put("id", Integer.valueOf(i));
    ((Map)localHashMap).put("desc", str);
    localMap.put("userInfo", localHashMap);
    paramy.callback(paramInt1, m("ok", (Map)localObject2));
    AppMethodBeat.o(326897);
  }
  
  private static final void a(m paramm, y paramy, int paramInt1, int paramInt2, int paramInt3, Intent paramIntent)
  {
    AppMethodBeat.i(326901);
    s.u(paramm, "this$0");
    s.u(paramy, "$service");
    if (paramm.REQUEST_CODE == paramInt2) {
      paramm.a(paramIntent, paramy, paramInt1, paramInt3);
    }
    AppMethodBeat.o(326901);
  }
  
  private static final boolean b(m paramm, y paramy, int paramInt1, int paramInt2, int paramInt3, Intent paramIntent)
  {
    AppMethodBeat.i(326908);
    s.u(paramm, "this$0");
    s.u(paramy, "$service");
    if (paramm.REQUEST_CODE == paramInt2)
    {
      paramm.a(paramIntent, paramy, paramInt1, paramInt3);
      AppMethodBeat.o(326908);
      return true;
    }
    AppMethodBeat.o(326908);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.auth.m
 * JD-Core Version:    0.7.0.1
 */