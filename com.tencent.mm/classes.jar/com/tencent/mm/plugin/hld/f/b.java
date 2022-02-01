package com.tencent.mm.plugin.hld.f;

import android.content.Context;
import android.content.res.AssetManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.hld.model.p.a;
import com.tencent.mm.plugin.hld.symbol.i;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.wxhld.WxhldApi;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import kotlin.g.b.p;

@kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/hld/utils/ImeSymbolUtil;", "", "()V", "TAG", "", "englishSymbolList", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/hld/utils/WxImeSymbolData;", "Lkotlin/collections/ArrayList;", "pairSymbolList", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "symbolClassMap", "Lcom/tencent/mm/plugin/hld/symbol/SymbolType;", "getAllSymbolByType", "context", "Landroid/content/Context;", "typeName", "getDefaultSymbolGridType", "getDefaultSymbolType", "getPairSymbol", "symbol", "getSymbolType", "content", "fromLongClick", "", "isEnglishLetterSymbol", "isEnglishSymbol", "symbolData", "", "isNumberSymbol", "plugin-hld_release"})
public final class b
{
  private static final ArrayList<j> DGI;
  private static final HashMap<String, String> DGJ;
  private static final HashMap<String, i> DGK;
  public static final b DGL;
  
  static
  {
    AppMethodBeat.i(217868);
    DGL = new b();
    DGI = new ArrayList();
    DGJ = new HashMap();
    DGK = new HashMap();
    AppMethodBeat.o(217868);
  }
  
  public static boolean a(j paramj)
  {
    AppMethodBeat.i(217850);
    p.k(paramj, "symbolData");
    boolean bool = DGI.contains(paramj);
    AppMethodBeat.o(217850);
    return bool;
  }
  
  public static boolean aLE(String paramString)
  {
    AppMethodBeat.i(217853);
    p.k(paramString, "content");
    p.a locala = p.a.DEN;
    boolean bool = p.a.eFr().matcher((CharSequence)paramString).find();
    AppMethodBeat.o(217853);
    return bool;
  }
  
  public static boolean aLF(String paramString)
  {
    AppMethodBeat.i(217855);
    p.k(paramString, "content");
    p.a locala = p.a.DEN;
    boolean bool = p.a.eFq().matcher((CharSequence)paramString).find();
    AppMethodBeat.o(217855);
    return bool;
  }
  
  public static boolean ab(CharSequence paramCharSequence)
  {
    AppMethodBeat.i(217847);
    p.k(paramCharSequence, "symbol");
    boolean bool = a(new j(paramCharSequence.toString()));
    AppMethodBeat.o(217847);
    return bool;
  }
  
  public static String bd(Context paramContext, String paramString)
  {
    AppMethodBeat.i(217859);
    p.k(paramContext, "context");
    p.k(paramString, "symbol");
    if (DGJ.isEmpty())
    {
      paramContext = paramContext.getAssets().open("symbol/pair.txt");
      p.j(paramContext, "context.assets.open(WxIm…SSETS_SYMBOL_FILE_SUFFIX)");
      paramContext = new BufferedReader((Reader)new InputStreamReader(paramContext));
    }
    try
    {
      for (;;)
      {
        Object localObject = paramContext.readLine();
        if (localObject == null) {
          break;
        }
        if (localObject != null) {
          try
          {
            localObject = kotlin.n.n.b((CharSequence)localObject, new String[] { " " });
            ((Map)DGJ).put(((List)localObject).get(0), ((List)localObject).get(1));
          }
          catch (Exception localException)
          {
            Log.e("WxIme.ImeSymbolUtil", "getPairSymbol " + localException.getMessage());
          }
        }
      }
      return null;
    }
    catch (IOException localIOException)
    {
      Log.e("WxIme.ImeSymbolUtil", "getPairSymbol " + localIOException.getMessage());
      try
      {
        paramContext.close();
        while (DGJ.containsKey(paramString))
        {
          paramContext = (String)DGJ.get(paramString);
          AppMethodBeat.o(217859);
          return paramContext;
          try
          {
            paramContext.close();
          }
          catch (IOException paramContext)
          {
            Log.e("WxIme.ImeSymbolUtil", "getPairSymbol " + paramContext.getMessage());
          }
        }
      }
      catch (IOException paramContext)
      {
        for (;;)
        {
          Log.e("WxIme.ImeSymbolUtil", "getPairSymbol " + paramContext.getMessage());
        }
      }
    }
    finally
    {
      try
      {
        paramContext.close();
        AppMethodBeat.o(217859);
        throw paramString;
      }
      catch (IOException paramContext)
      {
        for (;;)
        {
          Log.e("WxIme.ImeSymbolUtil", "getPairSymbol " + paramContext.getMessage());
        }
      }
      AppMethodBeat.o(217859);
    }
  }
  
  public static String eFU()
  {
    AppMethodBeat.i(217861);
    l locall = l.DHK;
    if (l.eCE())
    {
      AppMethodBeat.o(217861);
      return "emoji";
    }
    AppMethodBeat.o(217861);
    return "common";
  }
  
  public static String eFV()
  {
    AppMethodBeat.i(217864);
    l locall = l.DHK;
    if (l.eCE())
    {
      AppMethodBeat.o(217864);
      return "chinese";
    }
    AppMethodBeat.o(217864);
    return "common";
  }
  
  public final ArrayList<j> bc(Context paramContext, String paramString)
  {
    int j = 0;
    AppMethodBeat.i(217841);
    p.k(paramContext, "context");
    int i;
    if (p.h(paramString, "english"))
    {
      if (!((Collection)DGI).isEmpty()) {}
      for (i = 1; i != 0; i = 0)
      {
        paramContext = DGI;
        AppMethodBeat.o(217841);
        return paramContext;
      }
    }
    if (p.h(paramString, "common"))
    {
      if (DGI.isEmpty()) {
        DGI.addAll((Collection)bc(paramContext, "english"));
      }
      paramContext = com.tencent.mm.plugin.hld.model.n.DEn;
      Log.d("WxIme.WxEngineMgr", "getCommonSymbols");
      if (com.tencent.mm.plugin.hld.model.n.eEX()) {}
      for (paramContext = null;; paramContext = WxhldApi.get_most_commonly_used_punctuations(50))
      {
        paramString = new ArrayList();
        if (paramContext == null) {
          break;
        }
        int k = paramContext.length;
        i = j;
        while (i < k)
        {
          localObject = paramContext[i];
          if (!Util.isNullOrNil((String)localObject)) {
            paramString.add(new j((String)localObject));
          }
          i += 1;
        }
      }
      paramString.add(new j(""));
      Log.d("WxIme.ImeSymbolUtil", "getAllSymbolByType common symbol num: " + paramString.size());
      AppMethodBeat.o(217841);
      return paramString;
    }
    paramContext = paramContext.getAssets().open("symbol/" + paramString + ".txt");
    p.j(paramContext, "context.assets.open(WxIm…SSETS_SYMBOL_FILE_SUFFIX)");
    Object localObject = new BufferedReader((Reader)new InputStreamReader(paramContext));
    paramContext = new ArrayList();
    try
    {
      for (;;)
      {
        String str = ((BufferedReader)localObject).readLine();
        if (str == null) {
          break;
        }
        if (str != null) {
          paramContext.add(new j(str));
        }
      }
      try
      {
        localIOException2.close();
        AppMethodBeat.o(217841);
        throw paramContext;
      }
      catch (IOException localIOException3)
      {
        for (;;)
        {
          Log.e("WxIme.ImeSymbolUtil", "getAllSymbolByType " + paramString + ' ' + localIOException3.getMessage());
        }
      }
    }
    catch (IOException localIOException4)
    {
      localIOException4 = localIOException4;
      Log.e("WxIme.ImeSymbolUtil", "getAllSymbolByType " + paramString + ' ' + localIOException4.getMessage());
      try
      {
        ((BufferedReader)localObject).close();
        for (;;)
        {
          paramContext.add(new j(""));
          AppMethodBeat.o(217841);
          return paramContext;
          try
          {
            ((BufferedReader)localObject).close();
          }
          catch (IOException localIOException1)
          {
            Log.e("WxIme.ImeSymbolUtil", "getAllSymbolByType " + paramString + ' ' + localIOException1.getMessage());
          }
        }
      }
      catch (IOException localIOException2)
      {
        for (;;)
        {
          Log.e("WxIme.ImeSymbolUtil", "getAllSymbolByType " + paramString + ' ' + localIOException2.getMessage());
        }
      }
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.hld.f.b
 * JD-Core Version:    0.7.0.1
 */