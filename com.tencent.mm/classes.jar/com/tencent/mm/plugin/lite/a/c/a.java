package com.tencent.mm.plugin.lite.a.c;

import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.gdpr.c;
import com.tencent.mm.plugin.lite.api.e;
import com.tencent.mm.plugin.lite.api.e.a;
import com.tencent.mm.plugin.lite.ui.WxaLiteAppApiProxyUI;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.HashMap;
import org.json.JSONObject;

public class a
  extends e
{
  private void br(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(271620);
    Object localObject = paramJSONObject.optString("webtype");
    String str1 = paramJSONObject.optString("username");
    String str2 = paramJSONObject.optString("scene");
    String str3 = paramJSONObject.optString("scenenote");
    String str4 = paramJSONObject.optString("profileReportInfo");
    if ((localObject == null) || (((String)localObject).length() == 0) || (str1 == null) || (str1.length() == 0))
    {
      Log.e("LiteAppJsApiAddContact", "addContact fail, invalid arguments, webType = " + (String)localObject + ", username" + str1);
      this.JZj.aJV("addContact: fail");
      AppMethodBeat.o(271620);
      return;
    }
    int i = Util.getInt((String)localObject, -1);
    if (i == -1)
    {
      Log.e("LiteAppJsApiAddContact", "addContact fail, parseInt fail, str = ".concat(String.valueOf(localObject)));
      this.JZj.aJV("addContact: fail");
      AppMethodBeat.o(271620);
      return;
    }
    Log.i("LiteAppJsApiAddContact", "addContact scene = %s, sceneNote = %s", new Object[] { str2, str3 });
    paramJSONObject = new HashMap();
    paramJSONObject.put("webtype", localObject);
    paramJSONObject.put("username", str1);
    paramJSONObject.put("scene", str2);
    paramJSONObject.put("addscene", String.valueOf(i));
    paramJSONObject.put("scenenote", str3);
    paramJSONObject.put("profileReportInfo", str4);
    localObject = new Intent();
    ((Intent)localObject).addFlags(268435456);
    ((Intent)localObject).setClass(MMApplicationContext.getContext(), WxaLiteAppApiProxyUI.class);
    ((Intent)localObject).putExtra("proxyui_action_code_key", 2);
    ((Intent)localObject).putExtra("callback_id", com.tencent.mm.plugin.lite.a.b.c(this));
    ((Intent)localObject).putExtra("add_contact_params", paramJSONObject);
    paramJSONObject = MMApplicationContext.getContext();
    localObject = new com.tencent.mm.hellhoundlib.b.a().cG(localObject);
    com.tencent.mm.hellhoundlib.a.a.b(paramJSONObject, ((com.tencent.mm.hellhoundlib.b.a)localObject).aYi(), "com/tencent/mm/plugin/lite/jsapi/comms/LiteAppJsApiAddContact", "addContact", "(Ljava/lang/String;Lorg/json/JSONObject;Z)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    paramJSONObject.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).sb(0));
    com.tencent.mm.hellhoundlib.a.a.c(paramJSONObject, "com/tencent/mm/plugin/lite/jsapi/comms/LiteAppJsApiAddContact", "addContact", "(Ljava/lang/String;Lorg/json/JSONObject;Z)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    AppMethodBeat.o(271620);
  }
  
  public final void a(final String paramString, final JSONObject paramJSONObject, final boolean paramBoolean)
  {
    AppMethodBeat.i(271634);
    Log.d("LiteAppJsApiAddContact", "Invoke addContact");
    if (paramJSONObject == null)
    {
      this.JZj.aJV("data is null");
      AppMethodBeat.o(271634);
      return;
    }
    if (!c.bEh())
    {
      br(paramJSONObject);
      AppMethodBeat.o(271634);
      return;
    }
    String str = paramJSONObject.optString("username");
    if (!Util.isNullOrNil(str))
    {
      c.a(MMApplicationContext.getContext(), com.tencent.mm.model.gdpr.a.ooo, str, new com.tencent.mm.model.gdpr.b()
      {
        public final void onPermissionReturn(int paramAnonymousInt)
        {
          AppMethodBeat.i(271603);
          if (paramAnonymousInt == 0)
          {
            a.a(a.this, paramJSONObject);
            AppMethodBeat.o(271603);
            return;
          }
          Log.i("LiteAppJsApiAddContact", "EU user failed");
          a.a(a.this).aJV("addContact:fail  EU user failed");
          AppMethodBeat.o(271603);
        }
      });
      AppMethodBeat.o(271634);
      return;
    }
    this.JZj.aJV("username is null");
    AppMethodBeat.o(271634);
  }
  
  public final int fEx()
  {
    return 0;
  }
  
  public final void mi(int paramInt)
  {
    AppMethodBeat.i(271639);
    switch (paramInt)
    {
    default: 
      this.JZj.aJV("fail");
      AppMethodBeat.o(271639);
      return;
    case -2: 
    case 1: 
      this.JZj.fTW();
      AppMethodBeat.o(271639);
      return;
    case 0: 
      this.JZj.aJV("cancel");
      AppMethodBeat.o(271639);
      return;
    }
    this.JZj.aJV("fail");
    AppMethodBeat.o(271639);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.lite.a.c.a
 * JD-Core Version:    0.7.0.1
 */