package com.tencent.mm.plugin.flutter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.flutter.a.c;
import com.tencent.mm.plugin.flutter.ui.MMFlutterActivity;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.UUID;

public final class b
  implements com.tencent.mm.plugin.flutter.a.a
{
  public final void a(Context paramContext, c paramc)
  {
    AppMethodBeat.i(148837);
    if (!((com.tencent.mm.plugin.flutter.a.b)g.ah(com.tencent.mm.plugin.flutter.a.b.class)).isInitFlutter())
    {
      AppMethodBeat.o(148837);
      return;
    }
    String str = UUID.randomUUID().toString();
    paramc.wJg = 2;
    paramc.wJf = new HashMap();
    paramc.wJf.put("fontScale", Float.valueOf(com.tencent.mm.cb.a.ez(MMApplicationContext.getContext())));
    paramc.wJf.put("layoutScale", Float.valueOf(com.tencent.mm.cb.a.jj(MMApplicationContext.getContext())));
    paramc.wJf.put("language", LocaleUtil.getApplicationLanguage());
    paramc.wJf.put("sessionId", str);
    boolean bool = ((PluginFlutter)g.ah(PluginFlutter.class)).getFlutterEngineMgr().a(paramc, "mmNative", (Activity)paramContext);
    Log.i("MicroMsg.Flutter.FlutterService", "startEmbeddingFlutterView firstCreate %b", new Object[] { Boolean.valueOf(bool) });
    paramc = new Intent(paramContext, MMFlutterActivity.class);
    paramc.putExtra("first_create", bool);
    if (!(paramContext instanceof Activity)) {
      paramc.addFlags(268435456);
    }
    paramc = new com.tencent.mm.hellhoundlib.b.a().bl(paramc);
    com.tencent.mm.hellhoundlib.a.a.a(paramContext, paramc.axQ(), "com/tencent/mm/plugin/flutter/FlutterService", "startFlutterPage", "(Landroid/content/Context;Lcom/tencent/mm/plugin/flutter/api/MMFlutterRoute;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    paramContext.startActivity((Intent)paramc.pG(0));
    com.tencent.mm.hellhoundlib.a.a.a(paramContext, "com/tencent/mm/plugin/flutter/FlutterService", "startFlutterPage", "(Landroid/content/Context;Lcom/tencent/mm/plugin/flutter/api/MMFlutterRoute;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    ((Activity)paramContext).overridePendingTransition(2130772059, 2130772060);
    AppMethodBeat.o(148837);
  }
  
  public final boolean a(Context paramContext, int paramInt, Bundle paramBundle)
  {
    AppMethodBeat.i(240926);
    Object localObject1 = new LinkedHashMap();
    Object localObject2 = paramBundle.getStringArrayList("pathList");
    ArrayList localArrayList = paramBundle.getStringArrayList("typeList");
    int i = 0;
    if (i < ((ArrayList)localObject2).size())
    {
      if (localArrayList.get(i) == "image") {
        ((LinkedHashMap)localObject1).put(((ArrayList)localObject2).get(i), "image");
      }
      for (;;)
      {
        i += 1;
        break;
        if (localArrayList.get(i) == "video") {
          ((LinkedHashMap)localObject1).put(((ArrayList)localObject2).get(i), "video");
        }
      }
    }
    ((LinkedHashMap)localObject1).put("startTime", Long.valueOf(System.currentTimeMillis()));
    localObject2 = new StringBuilder();
    g.aAf();
    ((LinkedHashMap)localObject1).put("editId", com.tencent.mm.kernel.a.ayV() + "_" + System.currentTimeMillis());
    ((LinkedHashMap)localObject1).put("postId", paramBundle.getString("postId"));
    paramBundle = UUID.randomUUID().toString();
    localObject1 = new c("emoticon", "store", (LinkedHashMap)localObject1);
    ((c)localObject1).wJg = 2;
    ((c)localObject1).wJf = new HashMap();
    ((c)localObject1).wJf.put("fontScale", Float.valueOf(com.tencent.mm.cb.a.ez(MMApplicationContext.getContext())));
    ((c)localObject1).wJf.put("layoutScale", Float.valueOf(com.tencent.mm.cb.a.jj(MMApplicationContext.getContext())));
    ((c)localObject1).wJf.put("language", LocaleUtil.getApplicationLanguage());
    ((c)localObject1).wJf.put("sessionId", paramBundle);
    boolean bool = ((PluginFlutter)g.ah(PluginFlutter.class)).getFlutterEngineMgr().a((c)localObject1, "mmNative", (Activity)paramContext);
    Log.i("MicroMsg.Flutter.FlutterService", "startEmbeddingFlutterView firstCreate %b", new Object[] { Boolean.valueOf(bool) });
    paramBundle = new Intent(paramContext, MMFlutterActivity.class);
    paramBundle.putExtra("videoEditor", true);
    paramBundle.putExtra("first_create", bool);
    if (!(paramContext instanceof Activity)) {
      paramBundle.addFlags(268435456);
    }
    ((Activity)paramContext).startActivityForResult(paramBundle, paramInt);
    ((Activity)paramContext).overridePendingTransition(2130771981, 2130771982);
    AppMethodBeat.o(240926);
    return false;
  }
  
  public final void dLp()
  {
    AppMethodBeat.i(240925);
    ((PluginFlutter)g.ah(PluginFlutter.class)).getFlutterEngineMgr().dLq();
    AppMethodBeat.o(240925);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.flutter.b
 * JD-Core Version:    0.7.0.1
 */