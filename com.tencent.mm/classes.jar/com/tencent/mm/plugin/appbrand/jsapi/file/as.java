package com.tencent.mm.plugin.appbrand.jsapi.file;

import android.content.Context;
import android.os.Bundle;
import android.os.Looper;
import android.webkit.ValueCallback;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.z.m;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.tbs.one.TBSOneManager;
import com.tencent.tbs.reader.ITbsReaderCallback;
import com.tencent.tbs.reader.ReaderEngine;
import com.tencent.xweb.f;
import com.tencent.xweb.f.a;
import java.util.HashMap;
import java.util.Map;

public final class as
{
  private static Map<String, Integer> kMT;
  
  static
  {
    AppMethodBeat.i(188351);
    kMT = new HashMap();
    AppMethodBeat.o(188351);
  }
  
  public static void a(int paramInt, final Context paramContext, final String paramString1, final String paramString2, final String paramString3, final boolean paramBoolean, final HashMap<String, String> paramHashMap, final ValueCallback<String> paramValueCallback, final ValueCallback<Integer> paramValueCallback1)
  {
    AppMethodBeat.i(188342);
    if (Looper.myLooper() != Looper.getMainLooper())
    {
      m.runOnUiThread(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(188339);
          as.c(this.kMU, paramContext, paramString1, paramString2, paramString3, paramBoolean, paramHashMap, paramValueCallback, paramValueCallback1);
          AppMethodBeat.o(188339);
        }
      });
      AppMethodBeat.o(188342);
      return;
    }
    b(paramInt, paramContext, paramString1, paramString2, paramString3, paramBoolean, paramHashMap, paramValueCallback, paramValueCallback1);
    AppMethodBeat.o(188342);
  }
  
  private static void a(at paramat, int paramInt, Context paramContext, String paramString1, String paramString2, String paramString3, boolean paramBoolean, Bundle paramBundle, ValueCallback<String> paramValueCallback, ValueCallback<Integer> paramValueCallback1)
  {
    AppMethodBeat.i(188346);
    int i = paramat.a(paramContext, paramBundle, new ITbsReaderCallback()
    {
      public final void onCallBackAction(Integer paramAnonymousInteger, Object paramAnonymousObject1, Object paramAnonymousObject2)
      {
        AppMethodBeat.i(188341);
        ad.i("MiniQbFileLoader", "code: %d", new Object[] { paramAnonymousInteger });
        if (10 == paramAnonymousInteger.intValue()) {
          this.kMZ.onReceiveValue("plugin success");
        }
        for (;;)
        {
          if ((13 == paramAnonymousInteger.intValue()) && (!paramAnonymousObject1.equals("fileReaderClosed"))) {
            this.kMZ.onReceiveValue((String)paramAnonymousObject1);
          }
          if ((15 == paramAnonymousInteger.intValue()) && ((paramAnonymousObject1 instanceof Bundle)) && (((Bundle)paramAnonymousObject1).getInt("typeId") == 1)) {
            this.kMZ.onReceiveValue("fileReaderClosed");
          }
          AppMethodBeat.o(188341);
          return;
          if (11 == paramAnonymousInteger.intValue()) {
            this.kMZ.onReceiveValue("plugin failed");
          }
        }
      }
    });
    kMT.put(paramString3 + paramString1, Integer.valueOf(i));
    ad.i("MiniQbFileLoader", "loadByMiniQB, ret = " + i + ", isSecondTime = " + String.valueOf(paramBoolean));
    a(paramString2, paramValueCallback1, i, paramInt);
    AppMethodBeat.o(188346);
  }
  
  private static void a(String paramString, ValueCallback<Integer> paramValueCallback, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(188347);
    f.b(paramString, paramInt1, false, paramInt2);
    paramValueCallback.onReceiveValue(Integer.valueOf(paramInt1));
    AppMethodBeat.o(188347);
  }
  
  private static void b(int paramInt, Context paramContext, String paramString1, String paramString2, String paramString3, boolean paramBoolean, HashMap<String, String> paramHashMap, ValueCallback<String> paramValueCallback, ValueCallback<Integer> paramValueCallback1)
  {
    AppMethodBeat.i(188344);
    if (TBSOneManager.getDefaultInstance(paramContext).isComponentInstalled("file"))
    {
      at localat = at.ds(paramContext);
      ReaderEngine.getInstance().initReaderEntry(paramContext);
      if ((bt.isNullOrNil(paramString1)) || (bt.isNullOrNil(paramString2)))
      {
        ad.e("MiniQbFileLoader", "open file without necessary param");
        b(paramString2, paramValueCallback1, -100001, paramInt);
        AppMethodBeat.o(188344);
        return;
      }
      Bundle localBundle = new Bundle();
      localBundle.putString("filePath", paramString1);
      localBundle.putString("fileExt", paramString2);
      localBundle.putString("token", paramString3);
      localBundle.putInt("style", 1);
      localBundle.putString("menuData", (String)paramHashMap.get("menuData"));
      localBundle.putString("update_menu_param", (String)paramHashMap.get("update_menu_param"));
      if (paramHashMap.get("hide_title_bar_right_button") == null)
      {
        paramHashMap = "true";
        localBundle.putBoolean("hide_title_bar_right_button", Boolean.parseBoolean(paramHashMap));
        ad.i("MiniQbFileLoader", "readFile by x5, fileExt: ".concat(String.valueOf(paramString2)));
        if (paramBoolean) {
          a(localat, paramInt, paramContext, paramString1, paramString2, paramString3, true, localBundle, paramValueCallback, paramValueCallback1);
        }
        f.mY(paramString2, f.a.Mpk.name());
        f.hh(paramString2, paramInt);
        if (paramString1.endsWith(".".concat(String.valueOf(paramString2)))) {
          break label326;
        }
      }
      label326:
      for (paramHashMap = paramString1 + "." + paramString2;; paramHashMap = paramString1)
      {
        paramBoolean = at.canOpenFile(paramHashMap);
        ad.i("MiniQbFileLoader", "canOpen=".concat(String.valueOf(paramBoolean)));
        if (paramBoolean) {
          break label332;
        }
        ad.e("MiniQbFileLoader", "miniqb sdk not support");
        b(paramString2, paramValueCallback1, -100002, paramInt);
        AppMethodBeat.o(188344);
        return;
        paramHashMap = (String)paramHashMap.get("hide_title_bar_right_button");
        break;
      }
      label332:
      a(localat, paramInt, paramContext, paramString1, paramString2, paramString3, false, localBundle, paramValueCallback, paramValueCallback1);
    }
    AppMethodBeat.o(188344);
  }
  
  private static void b(String paramString, ValueCallback<Integer> paramValueCallback, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(188348);
    f.b(paramString, paramInt1, true, paramInt2);
    paramValueCallback.onReceiveValue(Integer.valueOf(-102));
    AppMethodBeat.o(188348);
  }
  
  public static void p(Context paramContext, final String paramString1, final String paramString2)
  {
    AppMethodBeat.i(188343);
    if (Looper.myLooper() != Looper.getMainLooper())
    {
      m.runOnUiThread(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(188340);
          as.r(this.val$context, paramString1, paramString2);
          AppMethodBeat.o(188340);
        }
      });
      AppMethodBeat.o(188343);
      return;
    }
    q(paramContext, paramString1, paramString2);
    AppMethodBeat.o(188343);
  }
  
  private static void q(Context paramContext, String paramString1, String paramString2)
  {
    AppMethodBeat.i(188345);
    paramContext = at.ds(paramContext);
    try
    {
      Integer localInteger = (Integer)kMT.get(paramString1 + paramString2);
      if (localInteger == null)
      {
        ad.i("MiniQbFileLoader", "finishReadFile, can't find file open record");
        AppMethodBeat.o(188345);
        return;
      }
      kMT.remove(paramString1 + paramString2);
      if (localInteger.intValue() == 0)
      {
        ad.i("MiniQbFileLoader", "finishReadFile");
        paramContext.closeFileReader();
        AppMethodBeat.o(188345);
        return;
      }
    }
    catch (Exception paramContext)
    {
      ad.e("MiniQbFileLoader", "finishReadFile error: " + paramContext.getMessage());
      AppMethodBeat.o(188345);
      return;
    }
    ad.i("MiniQbFileLoader", "finishReadFile ret != 0, skip");
    AppMethodBeat.o(188345);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.file.as
 * JD-Core Version:    0.7.0.1
 */