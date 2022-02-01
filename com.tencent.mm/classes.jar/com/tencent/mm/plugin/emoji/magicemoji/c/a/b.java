package com.tencent.mm.plugin.emoji.magicemoji.c.a;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build;
import android.os.Build.VERSION;
import android.util.DisplayMetrics;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.deviceinfo.q;
import com.tencent.mm.k.f;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.appbrand.af.i;
import com.tencent.mm.plugin.appbrand.jsapi.p;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.ChannelUtil;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/emoji/magicemoji/jsapi/api/JsApiGetSystemInfo;", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandJsApi;", "Lcom/tencent/mm/plugin/emoji/magicemoji/jsapi/IJsApiDefaultHandler;", "()V", "fontSize", "", "getFontSize", "invoke", "", "data", "Companion", "plugin-magic-emoji_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class b
  extends p
  implements com.tencent.mm.plugin.emoji.magicemoji.c.a
{
  private static final String NAME = "getSystemInfo";
  public static final a xJd;
  private int fontSize;
  
  static
  {
    AppMethodBeat.i(270281);
    xJd = new a((byte)0);
    AppMethodBeat.o(270281);
  }
  
  private final int getFontSize()
  {
    float f1 = 1.0F;
    AppMethodBeat.i(270274);
    if (this.fontSize >= 0)
    {
      i = this.fontSize;
      AppMethodBeat.o(270274);
      return i;
    }
    try
    {
      float f2 = MMApplicationContext.getContext().getSharedPreferences(MMApplicationContext.getDefaultPreferencePath(), 4).getFloat("text_size_scale_key", 1.0F);
      f1 = f2;
    }
    catch (Exception localException)
    {
      label47:
      break label47;
    }
    int i = kotlin.h.a.eH(f1 * 16.0F);
    AppMethodBeat.o(270274);
    return i;
  }
  
  public final String anU(String paramString)
  {
    AppMethodBeat.i(270293);
    s.u(paramString, "data");
    HashMap localHashMap = new HashMap();
    paramString = (Map)localHashMap;
    Object localObject = Build.BRAND;
    s.s(localObject, "BRAND");
    paramString.put("brand", localObject);
    paramString = (Map)localHashMap;
    localObject = q.aPo();
    s.s(localObject, "getModel()");
    paramString.put("model", localObject);
    paramString = (Map)localHashMap;
    localObject = Build.CPU_ABI;
    s.s(localObject, "CPU_ABI");
    paramString.put("abi", localObject);
    paramString = (Map)localHashMap;
    localObject = Build.VERSION.RELEASE;
    s.s(localObject, "RELEASE");
    paramString.put("system", localObject);
    paramString = MMApplicationContext.getContext().getResources();
    int i = paramString.getDisplayMetrics().widthPixels;
    int j = paramString.getDisplayMetrics().heightPixels;
    ((Map)localHashMap).put("windowWidth", Integer.valueOf(i.DA(i)));
    ((Map)localHashMap).put("windowHeight", Integer.valueOf(i.DA(j)));
    ((Map)localHashMap).put("pixelRatio", Float.valueOf(i.mn()));
    ((Map)localHashMap).put("screenWidth", Integer.valueOf(i.DA(i)));
    ((Map)localHashMap).put("screenHeight", Integer.valueOf(i.DA(j)));
    localObject = (Map)localHashMap;
    String str = LocaleUtil.getCurrentLanguage(MMApplicationContext.getContext());
    s.s(str, "getCurrentLanguage(MMApp…tionContext.getContext())");
    ((Map)localObject).put("language", str);
    localObject = (Map)localHashMap;
    str = ChannelUtil.formatVersion(null, BuildInfo.CLIENT_VERSION_INT);
    s.s(str, "formatVersion(null, BuildInfo.CLIENT_VERSION_INT)");
    ((Map)localObject).put("version", str);
    ((Map)localHashMap).put("benchmarkLevel", Integer.valueOf(((com.tencent.mm.plugin.zero.b.a)h.ax(com.tencent.mm.plugin.zero.b.a.class)).aRC().getInt("ClientBenchmarkLevel", -1)));
    i = paramString.getConfiguration().orientation;
    localObject = (Map)localHashMap;
    if (2 == i) {}
    for (paramString = "landscape";; paramString = "portrait")
    {
      ((Map)localObject).put("deviceOrientation", paramString);
      ((Map)localHashMap).put("fontSizeSetting", Integer.valueOf(getFontSize()));
      paramString = m("ok", (Map)localHashMap);
      s.s(paramString, "makeReturnJson(\"ok\", jMap)");
      AppMethodBeat.o(270293);
      return paramString;
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/emoji/magicemoji/jsapi/api/JsApiGetSystemInfo$Companion;", "", "()V", "NAME", "", "plugin-magic-emoji_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.magicemoji.c.a.b
 * JD-Core Version:    0.7.0.1
 */