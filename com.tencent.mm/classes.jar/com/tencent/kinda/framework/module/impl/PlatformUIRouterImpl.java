package com.tencent.kinda.framework.module.impl;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.tencent.kinda.framework.widget.tools.KindaContext;
import com.tencent.kinda.gen.ITransmitKvData;
import com.tencent.kinda.gen.KPlatformUIRouter;
import com.tencent.kinda.gen.VoidCallback;
import com.tencent.kinda.gen.VoidITransmitKvDataCallback;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.jd;
import com.tencent.mm.g.a.so;
import com.tencent.mm.g.a.so.a;
import com.tencent.mm.plugin.remittance.a.c;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.sdk.platformtools.br;
import com.tencent.mm.wallet_core.ui.e;
import java.net.URLDecoder;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class PlatformUIRouterImpl
  implements KPlatformUIRouter
{
  public static final int REQUEST_PAY = 1;
  public static final int REQUEST_TINYAPP = 3;
  public static final int REQUEST_WEBVIEW = 2;
  public static final String TAG = "MicroMsg.PlatformUIRouterImpl";
  private static HashMap<Context, HashMap<Integer, List<VoidCallback>>> requestCallBackWithoutData;
  private static HashMap<Context, HashMap<Integer, List<VoidITransmitKvDataCallback>>> requsetCallback;
  
  static
  {
    AppMethodBeat.i(144566);
    requsetCallback = new HashMap();
    requestCallBackWithoutData = new HashMap();
    AppMethodBeat.o(144566);
  }
  
  public static boolean hasWebViewCallbackInMap(Activity paramActivity)
  {
    boolean bool2 = false;
    AppMethodBeat.i(144564);
    if ((requsetCallback == null) || (!requsetCallback.containsKey(paramActivity)))
    {
      AppMethodBeat.o(144564);
      return false;
    }
    paramActivity = (HashMap)requsetCallback.get(paramActivity);
    boolean bool1 = bool2;
    if (paramActivity != null)
    {
      bool1 = bool2;
      if (paramActivity.size() > 0)
      {
        bool1 = bool2;
        if (paramActivity.containsKey(Integer.valueOf(2)))
        {
          paramActivity = (List)paramActivity.get(Integer.valueOf(2));
          if ((paramActivity == null) || (paramActivity.size() <= 0)) {
            break label103;
          }
        }
      }
    }
    label103:
    for (bool1 = true;; bool1 = false)
    {
      AppMethodBeat.o(144564);
      return bool1;
    }
  }
  
  @SuppressLint({"UseSparseArrays"})
  public static boolean processCallback(Context paramContext, int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(144562);
    if (paramInt1 == 3)
    {
      if (requestCallBackWithoutData.containsKey(paramContext)) {}
      for (paramContext = (HashMap)requestCallBackWithoutData.get(paramContext); paramContext == null; paramContext = new HashMap())
      {
        AppMethodBeat.o(144562);
        return false;
      }
      paramIntent = (List)paramContext.get(Integer.valueOf(paramInt1));
      if (paramIntent == null)
      {
        AppMethodBeat.o(144562);
        return false;
      }
      paramIntent = paramIntent.iterator();
      while (paramIntent.hasNext()) {
        ((VoidCallback)paramIntent.next()).call();
      }
      paramContext.put(Integer.valueOf(paramInt1), new LinkedList());
      AppMethodBeat.o(144562);
      return true;
    }
    if (requsetCallback.containsKey(paramContext)) {}
    for (paramContext = (HashMap)requsetCallback.get(paramContext); paramContext == null; paramContext = new HashMap())
    {
      AppMethodBeat.o(144562);
      return false;
    }
    paramIntent = (List)paramContext.get(Integer.valueOf(paramInt1));
    if (paramIntent == null)
    {
      AppMethodBeat.o(144562);
      return false;
    }
    paramIntent = paramIntent.iterator();
    while (paramIntent.hasNext()) {
      ((VoidITransmitKvDataCallback)paramIntent.next()).call(ITransmitKvData.create());
    }
    paramContext.put(Integer.valueOf(paramInt1), new LinkedList());
    AppMethodBeat.o(144562);
    return true;
  }
  
  public static void releaseContextRef(Activity paramActivity)
  {
    AppMethodBeat.i(144563);
    if (requestCallBackWithoutData != null) {
      requestCallBackWithoutData.remove(paramActivity);
    }
    if (requsetCallback != null) {
      requsetCallback.remove(paramActivity);
    }
    AppMethodBeat.o(144563);
  }
  
  private void saveRemittanceMsg(String paramString)
  {
    AppMethodBeat.i(144565);
    if (TextUtils.isEmpty(paramString))
    {
      com.tencent.mm.sdk.platformtools.ab.e("MicroMsg.PlatformUIRouterImpl", "msgxml is null");
      AppMethodBeat.o(144565);
      return;
    }
    paramString = URLDecoder.decode(paramString);
    com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.PlatformUIRouterImpl", "helios:".concat(String.valueOf(paramString)));
    String str = (String)br.F(paramString, "msg").get(".msg.appmsg.wcpayinfo.transcationid");
    if (TextUtils.isEmpty(str))
    {
      com.tencent.mm.sdk.platformtools.ab.e("MicroMsg.PlatformUIRouterImpl", "paymsgid count't be null in appmsg");
      AppMethodBeat.o(144565);
      return;
    }
    c.cgH().cgK().fX(str, paramString);
    AppMethodBeat.o(144565);
  }
  
  public void gotoExternApp(String paramString1, int paramInt, String paramString2)
  {
    AppMethodBeat.i(144561);
    jd localjd = new jd();
    localjd.cyB.csV = paramInt;
    localjd.cyB.returnKey = paramString2;
    localjd.cyB.cwc = paramString1;
    a.ymk.l(localjd);
    AppMethodBeat.o(144561);
  }
  
  public void openTinyApp(String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(144559);
    so localso = new so();
    localso.cIQ.userName = paramString1;
    localso.cIQ.cIS = bo.bf(paramString2, "");
    localso.cIQ.scene = 1034;
    localso.cIQ.cIT = 0;
    int i = bo.getInt(paramString3, 0);
    if (i > 0) {
      localso.cIQ.bDc = i;
    }
    localso.cIQ.context = KindaContext.get();
    a.ymk.l(localso);
    AppMethodBeat.o(144559);
  }
  
  public void openTinyAppImpl(String paramString1, String paramString2, String paramString3, VoidCallback paramVoidCallback)
  {
    AppMethodBeat.i(144560);
    if (requestCallBackWithoutData.containsKey(KindaContext.get())) {}
    for (HashMap localHashMap = (HashMap)requestCallBackWithoutData.get(KindaContext.get());; localHashMap = new HashMap())
    {
      List localList = (List)localHashMap.get(Integer.valueOf(3));
      Object localObject = localList;
      if (localList == null) {
        localObject = new LinkedList();
      }
      ((List)localObject).add(paramVoidCallback);
      localHashMap.put(Integer.valueOf(3), localObject);
      requestCallBackWithoutData.put(KindaContext.get(), localHashMap);
      paramVoidCallback = new so();
      paramVoidCallback.cIQ.userName = paramString1;
      paramVoidCallback.cIQ.cIS = bo.bf(paramString2, "");
      paramVoidCallback.cIQ.scene = 1034;
      paramVoidCallback.cIQ.cIT = 0;
      int i = bo.getInt(paramString3, 0);
      if (i > 0) {
        paramVoidCallback.cIQ.bDc = i;
      }
      paramVoidCallback.cIQ.context = KindaContext.get();
      paramVoidCallback.cIQ.cIY.bCY = "isFromKinda";
      paramVoidCallback.cIQ.cIY.bCZ = "true";
      a.ymk.l(paramVoidCallback);
      AppMethodBeat.o(144560);
      return;
    }
  }
  
  public void openUrlScheme(String paramString) {}
  
  public void openWeb(ITransmitKvData paramITransmitKvData)
  {
    boolean bool = true;
    AppMethodBeat.i(144557);
    String str = bo.bf(paramITransmitKvData.getString("content_url"), "");
    int i = paramITransmitKvData.getInt("canShare");
    paramITransmitKvData = KindaContext.get();
    if (i == 1) {}
    for (;;)
    {
      e.m(paramITransmitKvData, str, bool);
      AppMethodBeat.o(144557);
      return;
      bool = false;
    }
  }
  
  public void openWebImpl(ITransmitKvData paramITransmitKvData, VoidITransmitKvDataCallback paramVoidITransmitKvDataCallback)
  {
    AppMethodBeat.i(144558);
    String str = bo.bf(paramITransmitKvData.getString("content_url"), "");
    if ((str.startsWith("http://")) || (str.startsWith("https://"))) {
      if (!requsetCallback.containsKey(KindaContext.get())) {
        break label142;
      }
    }
    label142:
    for (paramITransmitKvData = (HashMap)requsetCallback.get(KindaContext.get());; paramITransmitKvData = new HashMap())
    {
      List localList = (List)paramITransmitKvData.get(Integer.valueOf(2));
      Object localObject = localList;
      if (localList == null) {
        localObject = new LinkedList();
      }
      ((List)localObject).add(paramVoidITransmitKvDataCallback);
      paramITransmitKvData.put(Integer.valueOf(2), localObject);
      requsetCallback.put(KindaContext.get(), paramITransmitKvData);
      e.a(KindaContext.get(), str, false, 2);
      AppMethodBeat.o(144558);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.kinda.framework.module.impl.PlatformUIRouterImpl
 * JD-Core Version:    0.7.0.1
 */