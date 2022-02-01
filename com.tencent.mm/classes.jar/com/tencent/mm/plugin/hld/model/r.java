package com.tencent.mm.plugin.hld.model;

import android.content.Context;
import android.content.res.AssetManager;
import com.google.c.b.j;
import com.google.c.e;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.hld.keyboard.c;
import com.tencent.mm.plugin.hld.keyboard.selfdraw.bean.KeyboardData;
import com.tencent.mm.plugin.hld.keyboard.selfdraw.bean.KeyboardOriginData;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.StringReader;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.f.d;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/hld/model/WxImeKeyboardSelfDrawDataProvider;", "", "()V", "keyboardModeCache", "", "Lcom/tencent/mm/plugin/hld/keyboard/KeyboardType;", "", "Lcom/tencent/mm/plugin/hld/keyboard/selfdraw/bean/KeyboardData;", "originDataCache", "Lcom/tencent/mm/plugin/hld/keyboard/selfdraw/bean/KeyboardOriginData;", "fetchOriginData", "context", "Landroid/content/Context;", "path", "", "getKeyboardData", "type", "modeInt", "getPath", "plugin-hld_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class r
{
  public static final r JwA;
  private static final Map<c, KeyboardOriginData> JwB;
  private static final Map<c, Map<Integer, KeyboardData>> JwC;
  
  static
  {
    AppMethodBeat.i(311967);
    JwA = new r();
    JwB = (Map)new LinkedHashMap();
    JwC = (Map)new LinkedHashMap();
    AppMethodBeat.o(311967);
  }
  
  public static KeyboardData a(Context paramContext, c paramc, int paramInt)
  {
    AppMethodBeat.i(311951);
    s.u(paramContext, "context");
    s.u(paramc, "type");
    Object localObject1 = (KeyboardOriginData)JwB.get(paramc);
    if (localObject1 == null)
    {
      s.u(paramc, "type");
      switch (a.$EnumSwitchMapping$0[paramc.ordinal()])
      {
      default: 
        localObject1 = "";
        localObject1 = new InputStreamReader(paramContext.getAssets().open((String)localObject1));
        paramContext = d.a((Reader)new BufferedReader((Reader)localObject1));
        ((InputStreamReader)localObject1).close();
        localObject1 = new e();
        if (paramContext == null)
        {
          paramContext = null;
          label135:
          paramContext = j.F(KeyboardOriginData.class).cast(paramContext);
          s.s(paramContext, "Gson().fromJson(\n       …ata::class.java\n        )");
          paramContext = (KeyboardOriginData)paramContext;
          JwB.put(paramc, paramContext);
        }
        break;
      }
    }
    for (;;)
    {
      Object localObject2 = (Map)JwC.get(paramc);
      localObject1 = localObject2;
      if (localObject2 == null)
      {
        localObject1 = (Map)new LinkedHashMap();
        JwC.put(paramc, localObject1);
      }
      paramc = (KeyboardData)((Map)localObject1).get(Integer.valueOf(paramInt));
      if (paramc != null) {
        break label327;
      }
      paramContext = com.tencent.mm.plugin.hld.keyboard.selfdraw.bean.a.a(paramContext, paramInt);
      ((Map)localObject1).put(Integer.valueOf(paramInt), paramContext);
      AppMethodBeat.o(311951);
      return paramContext;
      localObject1 = "keyboard/output/S1ChineseT9Keyboard.json";
      break;
      localObject1 = "keyboard/output/S2ChineseQwertyKeyboard.json";
      break;
      localObject1 = "keyboard/output/S3EnglishQwertyKeyboard.json";
      break;
      localObject1 = "keyboard/output/S4NumberKeyboard.json";
      break;
      localObject2 = new com.google.c.d.a(new StringReader(paramContext));
      ((com.google.c.d.a)localObject2).dEJ = ((e)localObject1).dEJ;
      paramContext = ((e)localObject1).a((com.google.c.d.a)localObject2, KeyboardOriginData.class);
      e.a(paramContext, (com.google.c.d.a)localObject2);
      break label135;
      paramContext = (Context)localObject1;
    }
    label327:
    AppMethodBeat.o(311951);
    return paramc;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.hld.model.r
 * JD-Core Version:    0.7.0.1
 */