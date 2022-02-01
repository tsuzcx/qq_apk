package com.tencent.mm.plugin.hld.f;

import android.content.Context;
import android.content.res.AssetManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.hld.model.o.a;
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
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import kotlin.Metadata;
import kotlin.g.b.c;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/hld/utils/ImeSymbolUtil;", "", "()V", "TAG", "", "englishSymbolList", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/hld/utils/WxImeSymbolData;", "Lkotlin/collections/ArrayList;", "pairSymbolList", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "symbolClassMap", "Lcom/tencent/mm/plugin/hld/symbol/SymbolType;", "getAllSymbolByType", "context", "Landroid/content/Context;", "typeName", "getDefaultSymbolGridType", "getDefaultSymbolType", "getPairSymbol", "symbol", "getSymbolType", "content", "fromLongClick", "", "isEnglishLetterSymbol", "isEnglishSymbol", "symbolData", "", "isNumberSymbol", "plugin-hld_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class b
{
  public static final b Jyf;
  private static final ArrayList<j> Jyg;
  private static final HashMap<String, String> Jyh;
  private static final HashMap<String, i> Jyi;
  
  static
  {
    AppMethodBeat.i(311608);
    Jyf = new b();
    Jyg = new ArrayList();
    Jyh = new HashMap();
    Jyi = new HashMap();
    AppMethodBeat.o(311608);
  }
  
  public static boolean a(j paramj)
  {
    AppMethodBeat.i(311558);
    s.u(paramj, "symbolData");
    boolean bool = Jyg.contains(paramj);
    AppMethodBeat.o(311558);
    return bool;
  }
  
  public static boolean aIw(String paramString)
  {
    AppMethodBeat.i(311565);
    s.u(paramString, "content");
    o.a locala = o.a.Jwr;
    boolean bool = o.a.fNi().matcher((CharSequence)paramString).find();
    AppMethodBeat.o(311565);
    return bool;
  }
  
  public static boolean aIx(String paramString)
  {
    AppMethodBeat.i(311573);
    s.u(paramString, "content");
    o.a locala = o.a.Jwr;
    boolean bool = o.a.fNh().matcher((CharSequence)paramString).find();
    AppMethodBeat.o(311573);
    return bool;
  }
  
  public static boolean ak(CharSequence paramCharSequence)
  {
    AppMethodBeat.i(311551);
    s.u(paramCharSequence, "symbol");
    boolean bool = a(new j(paramCharSequence.toString()));
    AppMethodBeat.o(311551);
    return bool;
  }
  
  public static String bf(Context paramContext, String paramString)
  {
    AppMethodBeat.i(311586);
    s.u(paramContext, "context");
    s.u(paramString, "symbol");
    if (Jyh.isEmpty())
    {
      paramContext = paramContext.getAssets().open("symbol/pair.txt");
      s.s(paramContext, "context.assets.open(WxIm…SSETS_SYMBOL_FILE_SUFFIX)");
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
            ((Map)Jyh).put(((List)localObject).get(0), ((List)localObject).get(1));
          }
          catch (Exception localException)
          {
            Log.e("WxIme.ImeSymbolUtil", s.X("getPairSymbol ", localException.getMessage()));
          }
        }
      }
      return null;
    }
    catch (IOException localIOException)
    {
      Log.e("WxIme.ImeSymbolUtil", s.X("getPairSymbol ", localIOException.getMessage()));
      try
      {
        paramContext.close();
        while (Jyh.containsKey(paramString))
        {
          paramContext = (String)Jyh.get(paramString);
          AppMethodBeat.o(311586);
          return paramContext;
          try
          {
            paramContext.close();
          }
          catch (IOException paramContext)
          {
            Log.e("WxIme.ImeSymbolUtil", s.X("getPairSymbol ", paramContext.getMessage()));
          }
        }
      }
      catch (IOException paramContext)
      {
        for (;;)
        {
          Log.e("WxIme.ImeSymbolUtil", s.X("getPairSymbol ", paramContext.getMessage()));
        }
      }
    }
    finally
    {
      try
      {
        paramContext.close();
        AppMethodBeat.o(311586);
        throw paramString;
      }
      catch (IOException paramContext)
      {
        for (;;)
        {
          Log.e("WxIme.ImeSymbolUtil", s.X("getPairSymbol ", paramContext.getMessage()));
        }
      }
      AppMethodBeat.o(311586);
    }
  }
  
  public static String fNN()
  {
    AppMethodBeat.i(311594);
    l locall = l.JyV;
    if (l.fKH())
    {
      AppMethodBeat.o(311594);
      return "emoji";
    }
    AppMethodBeat.o(311594);
    return "common";
  }
  
  public static String fNO()
  {
    AppMethodBeat.i(311601);
    l locall = l.JyV;
    if (l.fKH())
    {
      AppMethodBeat.o(311601);
      return "chinese";
    }
    AppMethodBeat.o(311601);
    return "common";
  }
  
  public final ArrayList<j> be(Context paramContext, String paramString)
  {
    AppMethodBeat.i(311623);
    s.u(paramContext, "context");
    if (s.p(paramString, "english"))
    {
      if (!((Collection)Jyg).isEmpty()) {}
      for (int i = 1; i != 0; i = 0)
      {
        paramContext = Jyg;
        AppMethodBeat.o(311623);
        return paramContext;
      }
    }
    if (s.p(paramString, "common"))
    {
      if (Jyg.isEmpty()) {
        Jyg.addAll((Collection)be(paramContext, "english"));
      }
      paramContext = com.tencent.mm.plugin.hld.model.n.JvW;
      Log.d("WxIme.WxEngineMgr", "getCommonSymbols");
      if (com.tencent.mm.plugin.hld.model.n.fNa()) {}
      for (paramContext = null;; paramContext = WxhldApi.get_most_commonly_used_punctuations(50))
      {
        paramString = new ArrayList();
        if (paramContext == null) {
          break;
        }
        paramContext = c.ao(paramContext);
        while (paramContext.hasNext())
        {
          localObject = (String)paramContext.next();
          if (!Util.isNullOrNil((String)localObject)) {
            paramString.add(new j((String)localObject));
          }
        }
      }
      paramString.add(new j(""));
      Log.d("WxIme.ImeSymbolUtil", s.X("getAllSymbolByType common symbol num: ", Integer.valueOf(paramString.size())));
      AppMethodBeat.o(311623);
      return paramString;
    }
    paramContext = paramContext.getAssets().open("symbol/" + paramString + ".txt");
    s.s(paramContext, "context.assets.open(WxIm…SSETS_SYMBOL_FILE_SUFFIX)");
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
        AppMethodBeat.o(311623);
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
          AppMethodBeat.o(311623);
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