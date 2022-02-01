package com.tencent.mm.plugin.flutter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
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
    if (!((com.tencent.mm.plugin.flutter.a.b)h.ag(com.tencent.mm.plugin.flutter.a.b.class)).isInitFlutter())
    {
      AppMethodBeat.o(148837);
      return;
    }
    String str = UUID.randomUUID().toString();
    paramc.BCv = 2;
    paramc.BCu = new HashMap();
    paramc.BCu.put("fontScale", Float.valueOf(com.tencent.mm.ci.a.ez(MMApplicationContext.getContext())));
    paramc.BCu.put("layoutScale", Float.valueOf(com.tencent.mm.ci.a.kn(MMApplicationContext.getContext())));
    paramc.BCu.put("language", LocaleUtil.getApplicationLanguage());
    paramc.BCu.put("sessionId", str);
    boolean bool = ((PluginFlutter)h.ag(PluginFlutter.class)).getFlutterEngineMgr().a(paramc, "mmNative", (Activity)paramContext);
    Log.i("MicroMsg.Flutter.FlutterService", "startEmbeddingFlutterView firstCreate %b", new Object[] { Boolean.valueOf(bool) });
    paramc = new Intent(paramContext, MMFlutterActivity.class);
    paramc.putExtra("first_create", bool);
    if (!(paramContext instanceof Activity)) {
      paramc.addFlags(268435456);
    }
    paramc = new com.tencent.mm.hellhoundlib.b.a().bm(paramc);
    com.tencent.mm.hellhoundlib.a.a.b(paramContext, paramc.aFh(), "com/tencent/mm/plugin/flutter/FlutterService", "startFlutterPage", "(Landroid/content/Context;Lcom/tencent/mm/plugin/flutter/api/MMFlutterRoute;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    paramContext.startActivity((Intent)paramc.sf(0));
    com.tencent.mm.hellhoundlib.a.a.c(paramContext, "com/tencent/mm/plugin/flutter/FlutterService", "startFlutterPage", "(Landroid/content/Context;Lcom/tencent/mm/plugin/flutter/api/MMFlutterRoute;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    ((Activity)paramContext).overridePendingTransition(c.a.fast_faded_in, c.a.fast_faded_out);
    AppMethodBeat.o(148837);
  }
  
  public final boolean a(Context paramContext, int paramInt, Bundle paramBundle)
  {
    AppMethodBeat.i(221014);
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
    h.aHE();
    ((LinkedHashMap)localObject1).put("editId", com.tencent.mm.kernel.b.aGq() + "_" + System.currentTimeMillis());
    ((LinkedHashMap)localObject1).put("postId", paramBundle.getString("postId"));
    paramBundle = UUID.randomUUID().toString();
    localObject1 = new c("emoticon", "store", (LinkedHashMap)localObject1);
    ((c)localObject1).BCv = 2;
    ((c)localObject1).BCu = new HashMap();
    ((c)localObject1).BCu.put("fontScale", Float.valueOf(com.tencent.mm.ci.a.ez(MMApplicationContext.getContext())));
    ((c)localObject1).BCu.put("layoutScale", Float.valueOf(com.tencent.mm.ci.a.kn(MMApplicationContext.getContext())));
    ((c)localObject1).BCu.put("language", LocaleUtil.getApplicationLanguage());
    ((c)localObject1).BCu.put("sessionId", paramBundle);
    boolean bool = ((PluginFlutter)h.ag(PluginFlutter.class)).getFlutterEngineMgr().a((c)localObject1, "mmNative", (Activity)paramContext);
    Log.i("MicroMsg.Flutter.FlutterService", "startEmbeddingFlutterView firstCreate %b", new Object[] { Boolean.valueOf(bool) });
    paramBundle = new Intent(paramContext, MMFlutterActivity.class);
    paramBundle.putExtra("videoEditor", true);
    paramBundle.putExtra("first_create", bool);
    if (!(paramContext instanceof Activity)) {
      paramBundle.addFlags(268435456);
    }
    ((Activity)paramContext).startActivityForResult(paramBundle, paramInt);
    ((Activity)paramContext).overridePendingTransition(c.a.alpha_in, c.a.alpha_out);
    AppMethodBeat.o(221014);
    return false;
  }
  
  public final void epU()
  {
    AppMethodBeat.i(220994);
    ((PluginFlutter)h.ag(PluginFlutter.class)).getFlutterEngineMgr().epV();
    AppMethodBeat.o(220994);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.flutter.b
 * JD-Core Version:    0.7.0.1
 */