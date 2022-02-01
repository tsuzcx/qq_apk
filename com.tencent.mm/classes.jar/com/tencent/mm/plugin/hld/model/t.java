package com.tencent.mm.plugin.hld.model;

import android.content.Context;
import android.content.res.AssetManager;
import com.google.a.b.j;
import com.google.a.e;
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
import kotlin.f.d;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/hld/model/WxImeKeyboardSelfDrawDataProvider;", "", "()V", "keyboardModeCache", "", "Lcom/tencent/mm/plugin/hld/keyboard/KeyboardType;", "", "Lcom/tencent/mm/plugin/hld/keyboard/selfdraw/bean/KeyboardData;", "originDataCache", "Lcom/tencent/mm/plugin/hld/keyboard/selfdraw/bean/KeyboardOriginData;", "fetchOriginData", "context", "Landroid/content/Context;", "path", "", "getKeyboardData", "type", "modeInt", "getPath", "plugin-hld_release"})
public final class t
{
  private static final Map<c, KeyboardOriginData> DER;
  private static final Map<c, Map<Integer, KeyboardData>> DES;
  public static final t DET;
  
  static
  {
    AppMethodBeat.i(211914);
    DET = new t();
    DER = (Map)new LinkedHashMap();
    DES = (Map)new LinkedHashMap();
    AppMethodBeat.o(211914);
  }
  
  public static KeyboardData a(Context paramContext, c paramc, int paramInt)
  {
    AppMethodBeat.i(211909);
    p.k(paramContext, "context");
    p.k(paramc, "type");
    Object localObject1 = (KeyboardOriginData)DER.get(paramc);
    if (localObject1 == null)
    {
      p.k(paramc, "type");
      switch (u.$EnumSwitchMapping$0[paramc.ordinal()])
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
          paramContext = j.w(KeyboardOriginData.class).cast(paramContext);
          p.j(paramContext, "Gson().fromJson(\n       …ata::class.java\n        )");
          paramContext = (KeyboardOriginData)paramContext;
          DER.put(paramc, paramContext);
        }
        break;
      }
    }
    for (;;)
    {
      localObject1 = (Map)DES.get(paramc);
      if (localObject1 == null)
      {
        localObject1 = (Map)new LinkedHashMap();
        DES.put(paramc, localObject1);
      }
      for (paramc = (c)localObject1;; paramc = (c)localObject1)
      {
        Object localObject2 = (KeyboardData)paramc.get(Integer.valueOf(paramInt));
        localObject1 = localObject2;
        if (localObject2 == null)
        {
          localObject1 = com.tencent.mm.plugin.hld.keyboard.selfdraw.bean.a.a(paramContext, paramInt);
          paramc.put(Integer.valueOf(paramInt), localObject1);
        }
        AppMethodBeat.o(211909);
        return localObject1;
        localObject1 = "keyboard/output/S1ChineseT9Keyboard.json";
        break;
        localObject1 = "keyboard/output/S2ChineseQwertyKeyboard.json";
        break;
        localObject1 = "keyboard/output/S3EnglishQwertyKeyboard.json";
        break;
        localObject1 = "keyboard/output/S4NumberKeyboard.json";
        break;
        localObject2 = new com.google.a.d.a(new StringReader(paramContext));
        ((com.google.a.d.a)localObject2).bLb = ((e)localObject1).bLb;
        paramContext = ((e)localObject1).a((com.google.a.d.a)localObject2, KeyboardOriginData.class);
        e.a(paramContext, (com.google.a.d.a)localObject2);
        break label135;
      }
      paramContext = (Context)localObject1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.hld.model.t
 * JD-Core Version:    0.7.0.1
 */