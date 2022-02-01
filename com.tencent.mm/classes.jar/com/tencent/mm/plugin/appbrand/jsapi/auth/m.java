package com.tencent.mm.plugin.appbrand.jsapi.auth;

import android.content.Intent;
import com.tencent.luggage.k.f.c;
import com.tencent.luggage.sdk.h.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.v;
import com.tencent.mm.ui.MMActivity.a;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/jsapi/auth/JsApiCreateVestUser;", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandAsyncJsApi;", "Lcom/tencent/mm/plugin/appbrand/AppBrandService;", "()V", "REQUEST_CODE", "", "callbackRet", "", "data", "Landroid/content/Intent;", "service", "callbackId", "resultCode", "goAddUserPage", "appId", "", "activity", "Landroid/app/Activity;", "defaultAvatarUrl", "defaultAvatarFileId", "invoke", "env", "Lorg/json/JSONObject;", "Companion", "plugin-appbrand-integration_release"})
public final class m
  extends c<v>
{
  private static final int CTRL_INDEX = 996;
  private static final String NAME = "createVestUser";
  public static final m.a oCl;
  private final int REQUEST_CODE;
  
  static
  {
    AppMethodBeat.i(267568);
    oCl = new m.a((byte)0);
    AppMethodBeat.o(267568);
  }
  
  public m()
  {
    AppMethodBeat.i(267567);
    this.REQUEST_CODE = a.aI(this);
    AppMethodBeat.o(267567);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "requestCode", "", "resultCode", "data", "Landroid/content/Intent;", "kotlin.jvm.PlatformType", "mmOnActivityResult"})
  static final class b
    implements MMActivity.a
  {
    b(m paramm, v paramv, int paramInt) {}
    
    public final void d(int paramInt1, int paramInt2, Intent paramIntent)
    {
      AppMethodBeat.i(271521);
      if (m.a(this.oCm) == paramInt1) {
        m.a(this.oCm, paramIntent, this.oxW, this.otk, paramInt2);
      }
      AppMethodBeat.o(271521);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "requestCode", "", "resultCode", "data", "Landroid/content/Intent;", "kotlin.jvm.PlatformType", "onResult"})
  static final class c
    implements f.c
  {
    c(m paramm, v paramv, int paramInt) {}
    
    public final boolean c(int paramInt1, int paramInt2, Intent paramIntent)
    {
      AppMethodBeat.i(245729);
      if (m.a(this.oCm) == paramInt1)
      {
        m.a(this.oCm, paramIntent, this.oxW, this.otk, paramInt2);
        AppMethodBeat.o(245729);
        return true;
      }
      AppMethodBeat.o(245729);
      return false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.auth.m
 * JD-Core Version:    0.7.0.1
 */