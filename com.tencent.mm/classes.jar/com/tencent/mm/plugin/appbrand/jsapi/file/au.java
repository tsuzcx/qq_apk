package com.tencent.mm.plugin.appbrand.jsapi.file;

import android.content.Context;
import android.os.Bundle;
import android.os.Looper;
import android.webkit.ValueCallback;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.y.m;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.tbs.one.TBSOneManager;
import com.tencent.tbs.reader.ITbsReaderCallback;
import com.tencent.tbs.reader.ReaderEngine;
import com.tencent.xweb.f;
import com.tencent.xweb.f.a;
import java.util.HashMap;
import java.util.Map;

public final class au
{
  private static Map<String, Integer> kQq;
  
  static
  {
    AppMethodBeat.i(222478);
    kQq = new HashMap();
    AppMethodBeat.o(222478);
  }
  
  public static void a(int paramInt, final Context paramContext, final String paramString1, final String paramString2, final String paramString3, final boolean paramBoolean, final HashMap<String, String> paramHashMap, final ValueCallback<String> paramValueCallback, final ValueCallback<Integer> paramValueCallback1)
  {
    AppMethodBeat.i(222469);
    if (Looper.myLooper() != Looper.getMainLooper())
    {
      m.runOnUiThread(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(222466);
          au.c(this.kQr, paramContext, paramString1, paramString2, paramString3, paramBoolean, paramHashMap, paramValueCallback, paramValueCallback1);
          AppMethodBeat.o(222466);
        }
      });
      AppMethodBeat.o(222469);
      return;
    }
    b(paramInt, paramContext, paramString1, paramString2, paramString3, paramBoolean, paramHashMap, paramValueCallback, paramValueCallback1);
    AppMethodBeat.o(222469);
  }
  
  private static void a(av paramav, int paramInt, Context paramContext, String paramString1, String paramString2, String paramString3, boolean paramBoolean, Bundle paramBundle, ValueCallback<String> paramValueCallback, ValueCallback<Integer> paramValueCallback1)
  {
    AppMethodBeat.i(222473);
    int i = paramav.a(paramContext, paramBundle, new ITbsReaderCallback()
    {
      public final void onCallBackAction(Integer paramAnonymousInteger, Object paramAnonymousObject1, Object paramAnonymousObject2)
      {
        AppMethodBeat.i(222468);
        ae.i("MiniQbFileLoader", "code: %d", new Object[] { paramAnonymousInteger });
        if (10 == paramAnonymousInteger.intValue()) {
          this.kQw.onReceiveValue("plugin success");
        }
        for (;;)
        {
          if ((13 == paramAnonymousInteger.intValue()) && (!paramAnonymousObject1.equals("fileReaderClosed"))) {
            this.kQw.onReceiveValue((String)paramAnonymousObject1);
          }
          if ((15 == paramAnonymousInteger.intValue()) && ((paramAnonymousObject1 instanceof Bundle)) && (((Bundle)paramAnonymousObject1).getInt("typeId") == 1)) {
            this.kQw.onReceiveValue("fileReaderClosed");
          }
          AppMethodBeat.o(222468);
          return;
          if (11 == paramAnonymousInteger.intValue()) {
            this.kQw.onReceiveValue("plugin failed");
          }
        }
      }
    });
    kQq.put(paramString3 + paramString1, Integer.valueOf(i));
    ae.i("MiniQbFileLoader", "loadByMiniQB, ret = " + i + ", isSecondTime = " + String.valueOf(paramBoolean));
    a(paramString2, paramValueCallback1, i, paramInt);
    AppMethodBeat.o(222473);
  }
  
  private static void a(String paramString, ValueCallback<Integer> paramValueCallback, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(222474);
    f.b(paramString, paramInt1, false, paramInt2);
    paramValueCallback.onReceiveValue(Integer.valueOf(paramInt1));
    AppMethodBeat.o(222474);
  }
  
  private static void b(int paramInt, Context paramContext, String paramString1, String paramString2, String paramString3, boolean paramBoolean, HashMap<String, String> paramHashMap, ValueCallback<String> paramValueCallback, ValueCallback<Integer> paramValueCallback1)
  {
    AppMethodBeat.i(222471);
    if (TBSOneManager.getDefaultInstance(paramContext).isComponentInstalled("file"))
    {
      av localav = av.du(paramContext);
      ReaderEngine.getInstance().initReaderEntry(paramContext);
      if ((bu.isNullOrNil(paramString1)) || (bu.isNullOrNil(paramString2)))
      {
        ae.e("MiniQbFileLoader", "open file without necessary param");
        b(paramString2, paramValueCallback1, -100001, paramInt);
        AppMethodBeat.o(222471);
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
        ae.i("MiniQbFileLoader", "readFile by x5, fileExt: ".concat(String.valueOf(paramString2)));
        if (paramBoolean) {
          a(localav, paramInt, paramContext, paramString1, paramString2, paramString3, true, localBundle, paramValueCallback, paramValueCallback1);
        }
        f.ne(paramString2, f.a.MMg.name());
        f.hq(paramString2, paramInt);
        if (paramString1.endsWith(".".concat(String.valueOf(paramString2)))) {
          break label326;
        }
      }
      label326:
      for (paramHashMap = paramString1 + "." + paramString2;; paramHashMap = paramString1)
      {
        paramBoolean = av.canOpenFile(paramHashMap);
        ae.i("MiniQbFileLoader", "canOpen=".concat(String.valueOf(paramBoolean)));
        if (paramBoolean) {
          break label332;
        }
        ae.e("MiniQbFileLoader", "miniqb sdk not support");
        b(paramString2, paramValueCallback1, -100002, paramInt);
        AppMethodBeat.o(222471);
        return;
        paramHashMap = (String)paramHashMap.get("hide_title_bar_right_button");
        break;
      }
      label332:
      a(localav, paramInt, paramContext, paramString1, paramString2, paramString3, false, localBundle, paramValueCallback, paramValueCallback1);
    }
    AppMethodBeat.o(222471);
  }
  
  private static void b(String paramString, ValueCallback<Integer> paramValueCallback, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(222475);
    f.b(paramString, paramInt1, true, paramInt2);
    paramValueCallback.onReceiveValue(Integer.valueOf(-102));
    AppMethodBeat.o(222475);
  }
  
  public static void p(Context paramContext, final String paramString1, final String paramString2)
  {
    AppMethodBeat.i(222470);
    if (Looper.myLooper() != Looper.getMainLooper())
    {
      m.runOnUiThread(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(222467);
          au.r(this.val$context, paramString1, paramString2);
          AppMethodBeat.o(222467);
        }
      });
      AppMethodBeat.o(222470);
      return;
    }
    q(paramContext, paramString1, paramString2);
    AppMethodBeat.o(222470);
  }
  
  private static void q(Context paramContext, String paramString1, String paramString2)
  {
    AppMethodBeat.i(222472);
    paramContext = av.du(paramContext);
    try
    {
      Integer localInteger = (Integer)kQq.get(paramString1 + paramString2);
      if (localInteger == null)
      {
        ae.i("MiniQbFileLoader", "finishReadFile, can't find file open record");
        AppMethodBeat.o(222472);
        return;
      }
      kQq.remove(paramString1 + paramString2);
      if (localInteger.intValue() == 0)
      {
        ae.i("MiniQbFileLoader", "finishReadFile");
        paramContext.closeFileReader();
        AppMethodBeat.o(222472);
        return;
      }
    }
    catch (Exception paramContext)
    {
      ae.e("MiniQbFileLoader", "finishReadFile error: " + paramContext.getMessage());
      AppMethodBeat.o(222472);
      return;
    }
    ae.i("MiniQbFileLoader", "finishReadFile ret != 0, skip");
    AppMethodBeat.o(222472);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.file.au
 * JD-Core Version:    0.7.0.1
 */