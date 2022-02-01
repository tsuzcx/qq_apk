package com.tencent.mm.plugin.flutter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
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
  public final void a(Context paramContext, com.tencent.mm.plugin.flutter.a.c paramc)
  {
    AppMethodBeat.i(148837);
    if (!((com.tencent.mm.plugin.flutter.a.b)h.az(com.tencent.mm.plugin.flutter.a.b.class)).isInitFlutter())
    {
      AppMethodBeat.o(148837);
      return;
    }
    String str = UUID.randomUUID().toString();
    paramc.Hkb = 2;
    paramc.Hka = new HashMap();
    paramc.Hka.put("fontScale", Float.valueOf(com.tencent.mm.cd.a.getScaleSize(MMApplicationContext.getContext())));
    paramc.Hka.put("layoutScale", Float.valueOf(com.tencent.mm.cd.a.mo(MMApplicationContext.getContext())));
    paramc.Hka.put("language", LocaleUtil.getApplicationLanguage());
    paramc.Hka.put("sessionId", str);
    boolean bool = ((PluginFlutter)h.az(PluginFlutter.class)).getFlutterEngineMgr().a(paramc, "mmNative", (Activity)paramContext);
    Log.i("MicroMsg.Flutter.FlutterService", "startEmbeddingFlutterView firstCreate %b", new Object[] { Boolean.valueOf(bool) });
    paramc = new Intent(paramContext, MMFlutterActivity.class);
    paramc.putExtra("first_create", bool);
    if (!(paramContext instanceof Activity)) {
      paramc.addFlags(268435456);
    }
    paramc = new com.tencent.mm.hellhoundlib.b.a().cG(paramc);
    com.tencent.mm.hellhoundlib.a.a.b(paramContext, paramc.aYi(), "com/tencent/mm/plugin/flutter/FlutterService", "startFlutterPage", "(Landroid/content/Context;Lcom/tencent/mm/plugin/flutter/api/MMFlutterRoute;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    paramContext.startActivity((Intent)paramc.sb(0));
    com.tencent.mm.hellhoundlib.a.a.c(paramContext, "com/tencent/mm/plugin/flutter/FlutterService", "startFlutterPage", "(Landroid/content/Context;Lcom/tencent/mm/plugin/flutter/api/MMFlutterRoute;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    ((Activity)paramContext).overridePendingTransition(c.a.fast_faded_in, c.a.fast_faded_out);
    AppMethodBeat.o(148837);
  }
  
  public final void fuW()
  {
    AppMethodBeat.i(262968);
    ((PluginFlutter)h.az(PluginFlutter.class)).getFlutterEngineMgr().fuZ();
    AppMethodBeat.o(262968);
  }
  
  public final boolean h(Context paramContext, Bundle paramBundle)
  {
    AppMethodBeat.i(262994);
    Object localObject1 = new LinkedHashMap();
    Object localObject2 = paramBundle.getStringArrayList("pathList");
    ArrayList localArrayList = paramBundle.getStringArrayList("typeList");
    int i = 0;
    if (i < ((ArrayList)localObject2).size())
    {
      if (localArrayList.get(i) == "image") {
        ((LinkedHashMap)localObject1).put((String)((ArrayList)localObject2).get(i), "image");
      }
      for (;;)
      {
        i += 1;
        break;
        if (localArrayList.get(i) == "video") {
          ((LinkedHashMap)localObject1).put((String)((ArrayList)localObject2).get(i), "video");
        }
      }
    }
    ((LinkedHashMap)localObject1).put("startTime", Long.valueOf(System.currentTimeMillis()));
    localObject2 = new StringBuilder();
    h.baC();
    ((LinkedHashMap)localObject1).put("editId", com.tencent.mm.kernel.b.aZs() + "_" + System.currentTimeMillis());
    ((LinkedHashMap)localObject1).put("postId", paramBundle.getString("postId"));
    paramBundle = UUID.randomUUID().toString();
    localObject1 = new com.tencent.mm.plugin.flutter.a.c("emoticon", "store", (LinkedHashMap)localObject1);
    ((com.tencent.mm.plugin.flutter.a.c)localObject1).Hkb = 2;
    ((com.tencent.mm.plugin.flutter.a.c)localObject1).Hka = new HashMap();
    ((com.tencent.mm.plugin.flutter.a.c)localObject1).Hka.put("fontScale", Float.valueOf(com.tencent.mm.cd.a.getScaleSize(MMApplicationContext.getContext())));
    ((com.tencent.mm.plugin.flutter.a.c)localObject1).Hka.put("layoutScale", Float.valueOf(com.tencent.mm.cd.a.mo(MMApplicationContext.getContext())));
    ((com.tencent.mm.plugin.flutter.a.c)localObject1).Hka.put("language", LocaleUtil.getApplicationLanguage());
    ((com.tencent.mm.plugin.flutter.a.c)localObject1).Hka.put("sessionId", paramBundle);
    Log.i("MicroMsg.Flutter.FlutterService", "startEmbeddingFlutterView firstCreate %b", new Object[] { Boolean.valueOf(((PluginFlutter)h.az(PluginFlutter.class)).getFlutterEngineMgr().a((com.tencent.mm.plugin.flutter.a.c)localObject1, "mmNative", (Activity)paramContext)) });
    AppMethodBeat.o(262994);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.flutter.b
 * JD-Core Version:    0.7.0.1
 */