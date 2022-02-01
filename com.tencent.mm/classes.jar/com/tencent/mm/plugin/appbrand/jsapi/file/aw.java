package com.tencent.mm.plugin.appbrand.jsapi.file;

import android.content.Context;
import android.os.Bundle;
import android.os.Looper;
import android.webkit.ValueCallback;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.ac.m;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.tbs.one.TBSOneManager;
import com.tencent.tbs.reader.ITbsReaderCallback;
import com.tencent.tbs.reader.ReaderEngine;
import com.tencent.tbs.reader.TbsFileInterfaceImpl;
import com.tencent.xweb.f;
import com.tencent.xweb.f.a;
import java.util.HashMap;
import java.util.Map;

public final class aw
{
  private static Map<String, Integer> oSy;
  
  static
  {
    AppMethodBeat.i(271555);
    oSy = new HashMap();
    AppMethodBeat.o(271555);
  }
  
  public static void a(int paramInt, final Context paramContext, final String paramString1, final String paramString2, final String paramString3, final boolean paramBoolean, final HashMap<String, String> paramHashMap, final ValueCallback<String> paramValueCallback, final ValueCallback<Integer> paramValueCallback1)
  {
    AppMethodBeat.i(271546);
    if (Looper.myLooper() != Looper.getMainLooper())
    {
      m.runOnUiThread(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(272196);
          aw.c(this.oSz, paramContext, paramString1, paramString2, paramString3, paramBoolean, paramHashMap, paramValueCallback, paramValueCallback1);
          AppMethodBeat.o(272196);
        }
      });
      AppMethodBeat.o(271546);
      return;
    }
    b(paramInt, paramContext, paramString1, paramString2, paramString3, paramBoolean, paramHashMap, paramValueCallback, paramValueCallback1);
    AppMethodBeat.o(271546);
  }
  
  private static void a(ax paramax, int paramInt, Context paramContext, String paramString1, String paramString2, String paramString3, boolean paramBoolean, Bundle paramBundle, ValueCallback<String> paramValueCallback, ValueCallback<Integer> paramValueCallback1)
  {
    AppMethodBeat.i(271550);
    int i = paramax.a(paramContext, paramBundle, new ITbsReaderCallback()
    {
      public final void onCallBackAction(Integer paramAnonymousInteger, Object paramAnonymousObject1, Object paramAnonymousObject2)
      {
        AppMethodBeat.i(270529);
        Log.i("MiniQbFileLoader", "code: %d", new Object[] { paramAnonymousInteger });
        if (10 == paramAnonymousInteger.intValue()) {
          this.oSE.onReceiveValue("plugin success");
        }
        for (;;)
        {
          if ((13 == paramAnonymousInteger.intValue()) && (!paramAnonymousObject1.equals("fileReaderClosed"))) {
            this.oSE.onReceiveValue((String)paramAnonymousObject1);
          }
          if ((15 == paramAnonymousInteger.intValue()) && ((paramAnonymousObject1 instanceof Bundle)) && (((Bundle)paramAnonymousObject1).getInt("typeId") == 1)) {
            this.oSE.onReceiveValue("fileReaderClosed");
          }
          AppMethodBeat.o(270529);
          return;
          if (11 == paramAnonymousInteger.intValue()) {
            this.oSE.onReceiveValue("plugin failed");
          }
        }
      }
    });
    oSy.put(paramString3 + paramString1, Integer.valueOf(i));
    Log.i("MiniQbFileLoader", "loadByMiniQB, ret = " + i + ", isSecondTime = " + String.valueOf(paramBoolean));
    a(paramString2, paramValueCallback1, i, paramInt);
    AppMethodBeat.o(271550);
  }
  
  private static void a(String paramString, ValueCallback<Integer> paramValueCallback, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(271551);
    f.b(paramString, paramInt1, false, paramInt2);
    paramValueCallback.onReceiveValue(Integer.valueOf(paramInt1));
    AppMethodBeat.o(271551);
  }
  
  private static void b(int paramInt, Context paramContext, String paramString1, String paramString2, String paramString3, boolean paramBoolean, HashMap<String, String> paramHashMap, ValueCallback<String> paramValueCallback, ValueCallback<Integer> paramValueCallback1)
  {
    AppMethodBeat.i(271548);
    if (TBSOneManager.getDefaultInstance(paramContext).isComponentInstalled("file"))
    {
      ax localax = ax.dO(paramContext);
      ReaderEngine.getInstance().initReaderEntry(paramContext);
      if ((Util.isNullOrNil(paramString1)) || (Util.isNullOrNil(paramString2)))
      {
        Log.e("MiniQbFileLoader", "open file without necessary param");
        b(paramString2, paramValueCallback1, -100001, paramInt);
        AppMethodBeat.o(271548);
        return;
      }
      Bundle localBundle = new Bundle();
      localBundle.putString("filePath", paramString1);
      localBundle.putString("fileExt", paramString2);
      localBundle.putString("token", paramString3);
      localBundle.putInt("style", 1);
      localBundle.putString("menuData", (String)paramHashMap.get("menuData"));
      localBundle.putString("update_menu_param", (String)paramHashMap.get("update_menu_param"));
      if (paramHashMap.get("hide_title_bar_right_button") == null) {}
      for (paramHashMap = "true";; paramHashMap = (String)paramHashMap.get("hide_title_bar_right_button"))
      {
        localBundle.putBoolean("hide_title_bar_right_button", Boolean.parseBoolean(paramHashMap));
        Log.i("MiniQbFileLoader", "readFile by x5, fileExt: ".concat(String.valueOf(paramString2)));
        if (paramBoolean) {
          a(localax, paramInt, paramContext, paramString1, paramString2, paramString3, true, localBundle, paramValueCallback, paramValueCallback1);
        }
        f.oU(paramString2, f.a.ZZM.name());
        f.iv(paramString2, paramInt);
        if (!paramString1.endsWith(".".concat(String.valueOf(paramString2)))) {
          new StringBuilder().append(paramString1).append(".").append(paramString2);
        }
        paramBoolean = TbsFileInterfaceImpl.canOpenFile(paramString2);
        Log.i("MiniQbFileLoader", "canOpen=".concat(String.valueOf(paramBoolean)));
        if (paramBoolean) {
          break;
        }
        Log.e("MiniQbFileLoader", "miniqb sdk not support");
        b(paramString2, paramValueCallback1, -100002, paramInt);
        AppMethodBeat.o(271548);
        return;
      }
      a(localax, paramInt, paramContext, paramString1, paramString2, paramString3, false, localBundle, paramValueCallback, paramValueCallback1);
    }
    AppMethodBeat.o(271548);
  }
  
  private static void b(String paramString, ValueCallback<Integer> paramValueCallback, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(271552);
    f.b(paramString, paramInt1, true, paramInt2);
    paramValueCallback.onReceiveValue(Integer.valueOf(-102));
    AppMethodBeat.o(271552);
  }
  
  public static void r(Context paramContext, final String paramString1, final String paramString2)
  {
    AppMethodBeat.i(271547);
    if (Looper.myLooper() != Looper.getMainLooper())
    {
      m.runOnUiThread(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(276795);
          aw.t(this.val$context, paramString1, paramString2);
          AppMethodBeat.o(276795);
        }
      });
      AppMethodBeat.o(271547);
      return;
    }
    s(paramContext, paramString1, paramString2);
    AppMethodBeat.o(271547);
  }
  
  private static void s(Context paramContext, String paramString1, String paramString2)
  {
    AppMethodBeat.i(271549);
    paramContext = ax.dO(paramContext);
    try
    {
      Integer localInteger = (Integer)oSy.get(paramString1 + paramString2);
      if (localInteger == null)
      {
        Log.i("MiniQbFileLoader", "finishReadFile, can't find file open record");
        AppMethodBeat.o(271549);
        return;
      }
      oSy.remove(paramString1 + paramString2);
      if (localInteger.intValue() == 0)
      {
        Log.i("MiniQbFileLoader", "finishReadFile");
        paramContext.closeFileReader();
        AppMethodBeat.o(271549);
        return;
      }
    }
    catch (Exception paramContext)
    {
      Log.e("MiniQbFileLoader", "finishReadFile error: " + paramContext.getMessage());
      AppMethodBeat.o(271549);
      return;
    }
    Log.i("MiniQbFileLoader", "finishReadFile ret != 0, skip");
    AppMethodBeat.o(271549);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.file.aw
 * JD-Core Version:    0.7.0.1
 */