package com.tencent.mm.plugin.appbrand.permission;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.appstorage.ICommLibReader;
import com.tencent.mm.plugin.appbrand.jsapi.f;
import com.tencent.mm.plugin.appbrand.jsapi.g.a.e;
import com.tencent.mm.plugin.appbrand.jsapi.t.aa;
import com.tencent.mm.plugin.appbrand.page.ad;
import com.tencent.mm.plugin.appbrand.permission.appidABTest.AppRuntimeAppidABTestPermissionBundle;
import com.tencent.mm.plugin.appbrand.y;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import junit.framework.Assert;
import org.apache.commons.c.i;
import org.json.JSONObject;

public class d
{
  private static final Map<Class<? extends com.tencent.mm.plugin.appbrand.jsapi.e>, Integer> tEm;
  private static final Map<Class<? extends com.tencent.mm.plugin.appbrand.jsapi.e>, String> tEn;
  public static final String[] tEz;
  public final AppBrandRuntime qwG;
  public final int tEo;
  private final boolean tEp;
  public final LinkedList<b> tEq;
  public final Object tEr;
  private AppRuntimeApiPermissionBundle tEs;
  private final byte[] tEt;
  private HashMap<String, AppRuntimeApiPermissionBundle> tEu;
  private final Object tEv;
  private HashMap<String, AppRuntimeAppidABTestPermissionBundle> tEw;
  public final List<c> tEx;
  public final boolean tEy;
  
  static
  {
    AppMethodBeat.i(147660);
    tEm = new ConcurrentHashMap();
    tEn = new ConcurrentHashMap();
    tEz = new String[] { "createSocketTask", "createDownloadTask", "createRequestTask", "createUploadTask", "createUploadTaskAsync", "createRequestTaskAsync", "createUploadTaskAsync" };
    AppMethodBeat.o(147660);
  }
  
  public d(com.tencent.luggage.sdk.e.d paramd, int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(318750);
    this.tEq = new LinkedList();
    this.tEw = new HashMap();
    this.tEx = new ArrayList();
    this.qwG = paramd;
    this.tEr = new byte[0];
    this.tEt = new byte[0];
    this.tEv = new byte[0];
    this.tEo = paramInt;
    this.tEp = paramBoolean;
    Object localObject = (AppRuntimeApiPermissionBundle)paramd.d(AppRuntimeApiPermissionBundle.class, false);
    if (localObject == null) {
      Log.e("MicroMsg.AppRuntimeApiPermissionController[permission]", "<init> get NULL permission from runtime");
    }
    a((AppRuntimeApiPermissionBundle)localObject);
    localObject = (e)paramd.d(e.class, false);
    if (localObject == null)
    {
      localObject = null;
      this.tEu = ((HashMap)localObject);
      if (this.tEu != null) {
        break label273;
      }
      paramInt = 0;
      label143:
      Log.i("MicroMsg.AppRuntimeApiPermissionController[permission]", "<init> mPluginPermission size:%d", new Object[] { Integer.valueOf(paramInt) });
      if ((this.tEu == null) || (this.tEu.size() <= 0)) {
        break label284;
      }
      this.tEy = Boolean.parseBoolean(((ICommLibReader)Objects.requireNonNull((ICommLibReader)paramd.ax(ICommLibReader.class))).UX("supportInvokeWithAppId"));
      label207:
      paramd = (com.tencent.mm.plugin.appbrand.permission.appidABTest.a)paramd.d(com.tencent.mm.plugin.appbrand.permission.appidABTest.a.class, false);
      if (paramd != null)
      {
        this.tEw = paramd.tFa;
        if (this.tEw != null) {
          break label292;
        }
      }
    }
    label273:
    label284:
    label292:
    for (paramInt = 0;; paramInt = this.tEw.size())
    {
      Log.i("MicroMsg.AppRuntimeApiPermissionController[permission]", "mAppidPermission size:%d", new Object[] { Integer.valueOf(paramInt) });
      AppMethodBeat.o(318750);
      return;
      localObject = ((e)localObject).tEI;
      break;
      paramInt = this.tEu.size();
      break label143;
      this.tEy = false;
      break label207;
    }
  }
  
  public static int aX(Class<? extends com.tencent.mm.plugin.appbrand.jsapi.e> paramClass)
  {
    AppMethodBeat.i(147652);
    Integer localInteger = (Integer)tEm.get(paramClass);
    int i;
    if (localInteger != null)
    {
      i = localInteger.intValue();
      AppMethodBeat.o(147652);
      return i;
    }
    try
    {
      i = ((Integer)org.a.a.cQ(paramClass).get("CTRL_INDEX")).intValue();
      tEm.put(paramClass, Integer.valueOf(i));
      AppMethodBeat.o(147652);
      return i;
    }
    catch (org.a.b localb)
    {
      for (;;)
      {
        Assert.assertTrue("Must declare CTRL_INDEX in JsApi Class: " + paramClass.getName(), true);
        i = -1;
      }
    }
  }
  
  private static String aY(Class<? extends com.tencent.mm.plugin.appbrand.jsapi.e> paramClass)
  {
    AppMethodBeat.i(147653);
    String str = (String)tEn.get(paramClass);
    if (!Util.isNullOrNil(str))
    {
      AppMethodBeat.o(147653);
      return str;
    }
    try
    {
      str = (String)org.a.a.cQ(paramClass).get("NAME");
      tEn.put(paramClass, str);
      AppMethodBeat.o(147653);
      return str;
    }
    catch (org.a.b localb)
    {
      Assert.assertTrue("Must declare NAME in JsApi Class: " + paramClass.getName(), true);
      paramClass = paramClass.getSimpleName();
      AppMethodBeat.o(147653);
    }
    return paramClass;
  }
  
  private void b(AppRuntimeApiPermissionBundle paramAppRuntimeApiPermissionBundle)
  {
    AppMethodBeat.i(147656);
    byte[] arrayOfByte = paramAppRuntimeApiPermissionBundle.tEj;
    paramAppRuntimeApiPermissionBundle = paramAppRuntimeApiPermissionBundle.tEk;
    int i = 0;
    while (i < this.tEx.size())
    {
      ((c)this.tEx.get(i)).g(arrayOfByte, paramAppRuntimeApiPermissionBundle);
      i += 1;
    }
    AppMethodBeat.o(147656);
  }
  
  private void cGL()
  {
    AppMethodBeat.i(318763);
    if (this.tEu == null)
    {
      Log.e("MicroMsg.AppRuntimeApiPermissionController[permission]", "pluginUpdateNotifyWxCommLib mPluginPermission null");
      AppMethodBeat.o(318763);
      return;
    }
    Log.i("MicroMsg.AppRuntimeApiPermissionController[permission]", "pluginUpdateNotifyWxCommLib");
    if (this.qwG.ari() == null)
    {
      Log.e("MicroMsg.AppRuntimeApiPermissionController[permission]", "pluginUpdateNotifyWxCommLib mRuntime.getService() null");
      AppMethodBeat.o(318763);
      return;
    }
    Object localObject = new HashMap();
    Iterator localIterator = this.tEu.keySet().iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      HashMap localHashMap = new HashMap();
      AppRuntimeApiPermissionBundle localAppRuntimeApiPermissionBundle = (AppRuntimeApiPermissionBundle)this.tEu.get(str);
      if (localAppRuntimeApiPermissionBundle != null)
      {
        localHashMap.put("fg", localAppRuntimeApiPermissionBundle.tEj);
        localHashMap.put("bg", localAppRuntimeApiPermissionBundle.tEk);
        localHashMap.put("sp", localAppRuntimeApiPermissionBundle.tEl);
        ((Map)localObject).put(str, localHashMap);
      }
    }
    com.tencent.luggage.l.d.k((Map)localObject);
    localObject = new JSONObject((Map)localObject);
    this.qwG.ari().cJ("onPluginPermissionUpdate", ((JSONObject)localObject).toString());
    AppMethodBeat.o(318763);
  }
  
  private void cGM()
  {
    AppMethodBeat.i(318765);
    if (this.tEu == null)
    {
      AppMethodBeat.o(318765);
      return;
    }
    Log.i("MicroMsg.AppRuntimeApiPermissionController[permission]", "notifyNodeOnPluginUpdate");
    int i = 0;
    while (i < this.tEx.size())
    {
      ((c)this.tEx.get(i)).h(this.tEu);
      i += 1;
    }
    AppMethodBeat.o(318765);
  }
  
  public static void l(f paramf, String paramString)
  {
    AppMethodBeat.i(318770);
    if (paramf == null) {}
    for (paramf = null;; paramf = (k)paramf.T(k.class))
    {
      if (paramf != null) {
        paramf.afr(paramString);
      }
      AppMethodBeat.o(318770);
      return;
    }
  }
  
  public final int F(byte[] paramArrayOfByte, int paramInt)
  {
    int i = this.tEo;
    if (i == -1) {}
    do
    {
      do
      {
        return 1;
        if (i == -2) {
          return 0;
        }
      } while (paramInt == -2);
      if (paramInt != -1) {
        break;
      }
    } while (this.tEp);
    return 0;
    if ((paramInt >= paramArrayOfByte.length) || (paramInt < 0)) {
      return 0;
    }
    return paramArrayOfByte[paramInt];
  }
  
  public final int a(f paramf, Class<? extends com.tencent.mm.plugin.appbrand.jsapi.e> paramClass, String paramString1, String paramString2, int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(318791);
    int i = this.tEo;
    String str1 = paramf.getAppId();
    if (i == -1)
    {
      Log.d("MicroMsg.AppRuntimeApiPermissionController[permission]", "getCtrlByte, appId = %s, ctrlIndex = %d, hard code perm on", new Object[] { str1, Integer.valueOf(paramInt) });
      AppMethodBeat.o(318791);
      return 1;
    }
    if (i == -2)
    {
      Log.d("MicroMsg.AppRuntimeApiPermissionController[permission]", "getCtrlByte, appId = %s, ctrlIndex = %d, hard code perm off", new Object[] { str1, Integer.valueOf(paramInt) });
      AppMethodBeat.o(318791);
      return 0;
    }
    if ((paramClass.isAssignableFrom(aa.class)) && ((paramf instanceof ad)))
    {
      AppMethodBeat.o(318791);
      return 1;
    }
    String str2 = aY(paramClass);
    i = c.e(paramf, str2, paramString1);
    if (i != -2147483648)
    {
      AppMethodBeat.o(318791);
      return i;
    }
    Object localObject = paramf.getAppId();
    paramString1 = (String)localObject;
    if (this.tEy)
    {
      paramString1 = (String)localObject;
      if (TextUtils.isEmpty(paramString2)) {}
    }
    label438:
    label444:
    for (;;)
    {
      try
      {
        paramString1 = new JSONObject(paramString2).optString("appId");
        paramString2 = paramString1;
        paramString1 = paramString2;
        if (!TextUtils.isEmpty(paramString2)) {
          break label444;
        }
        paramString1 = paramf.getAppId();
      }
      catch (Exception paramString1)
      {
        int j;
        Log.e("MicroMsg.AppRuntimeApiPermissionController[permission]", "getApiCtrlByte(appId:%s, api:%s, privateData:%s), parse invokeAppId failed %s", new Object[] { paramf.getAppId(), str2, paramString2, paramString1 });
        paramString1 = (String)localObject;
        if (!TextUtils.isEmpty((CharSequence)localObject)) {
          break label444;
        }
        paramString1 = paramf.getAppId();
        continue;
      }
      finally
      {
        if (!TextUtils.isEmpty((CharSequence)localObject)) {
          continue;
        }
        paramf.getAppId();
        AppMethodBeat.o(318791);
      }
      paramString2 = new com.tencent.mm.plugin.appbrand.b.b[1];
      localObject = a(paramf, paramString1, paramString2);
      j = F((byte[])localObject, paramInt);
      if (paramBoolean)
      {
        paramf = (l)paramf.T(l.class);
        if ((paramf != null) && (paramf.aZ(paramClass))) {
          break label438;
        }
        i = 1;
        if (i != 0) {
          Log.i("MicroMsg.AppRuntimeApiPermissionController[permission]", "getCtrlByte, appId = %s, invokeAppId = %s, apiName = %s, state = %s, ctrlIndex = %d, ctrlIndexLength %d, checkRet %d", new Object[] { str1, paramString1, str2, paramString2[0], Integer.valueOf(paramInt), Integer.valueOf(localObject.length), Integer.valueOf(j) });
        }
      }
      AppMethodBeat.o(318791);
      return j;
      i = 0;
    }
  }
  
  public final void a(AppRuntimeApiPermissionBundle paramAppRuntimeApiPermissionBundle)
  {
    AppMethodBeat.i(147655);
    if (paramAppRuntimeApiPermissionBundle == null)
    {
      AppMethodBeat.o(147655);
      return;
    }
    synchronized (this.tEr)
    {
      AppRuntimeApiPermissionBundle localAppRuntimeApiPermissionBundle = this.tEs;
      if ((localAppRuntimeApiPermissionBundle != null) && (localAppRuntimeApiPermissionBundle.tEj.length > paramAppRuntimeApiPermissionBundle.tEj.length))
      {
        Log.e("MicroMsg.AppRuntimeApiPermissionController[permission]", "updatePermission, old %s, new %s, ignore", new Object[] { localAppRuntimeApiPermissionBundle, paramAppRuntimeApiPermissionBundle });
        AppMethodBeat.o(147655);
        return;
      }
      this.tEs = paramAppRuntimeApiPermissionBundle;
      b(this.tEs);
      Log.i("MicroMsg.AppRuntimeApiPermissionController[permission]", "updatePermission old %s, updated %s", new Object[] { localAppRuntimeApiPermissionBundle, paramAppRuntimeApiPermissionBundle });
      AppMethodBeat.o(147655);
      return;
    }
  }
  
  public final boolean a(f paramf, Class<? extends com.tencent.mm.plugin.appbrand.jsapi.e> paramClass)
  {
    AppMethodBeat.i(147650);
    switch (a(paramf, paramClass, null, null, aX(paramClass), false))
    {
    case 2: 
    case 3: 
    case 5: 
    default: 
      AppMethodBeat.o(147650);
      return false;
    case 1: 
      AppMethodBeat.o(147650);
      return true;
    case 0: 
      AppMethodBeat.o(147650);
      return false;
    case 4: 
      AppMethodBeat.o(147650);
      return false;
    case 6: 
      l(paramf, aY(paramClass));
      AppMethodBeat.o(147650);
      return false;
    case 7: 
      boolean bool = this.qwG.qsB.qKC.chE();
      AppMethodBeat.o(147650);
      return bool;
    }
    AppMethodBeat.o(147650);
    return true;
  }
  
  public final byte[] a(f paramf, String paramString, com.tencent.mm.plugin.appbrand.b.b[] paramArrayOfb)
  {
    AppMethodBeat.i(318800);
    int i = this.tEo;
    if (i == -1)
    {
      AppMethodBeat.o(318800);
      return new byte[] { 1 };
    }
    if (i == -2)
    {
      AppMethodBeat.o(318800);
      return new byte[] { 0 };
    }
    if ((TextUtils.isEmpty(paramString)) || (i.qA(paramf.getAppId(), paramString))) {}
    for (AppRuntimeApiPermissionBundle localAppRuntimeApiPermissionBundle = cGN(); localAppRuntimeApiPermissionBundle == null; localAppRuntimeApiPermissionBundle = afp(paramString))
    {
      Log.e("MicroMsg.AppRuntimeApiPermissionController[permission]", "getCtrlBytes(appId:%s, invokeAppId:%s) get NULL bundle", new Object[] { paramf.getAppId(), paramString });
      AppMethodBeat.o(318800);
      return new byte[] { 0 };
    }
    if ((paramf instanceof y))
    {
      paramf = 3.qKW;
      com.tencent.mm.plugin.appbrand.b.b localb = this.qwG.qsB.qKC.chD();
      switch (paramf[localb.ordinal()])
      {
      default: 
        paramf = localAppRuntimeApiPermissionBundle.tEj;
        paramString = paramf;
        if (paramArrayOfb != null)
        {
          paramString = paramf;
          if (paramArrayOfb.length > 0) {
            paramArrayOfb[0] = localb;
          }
        }
        break;
      }
    }
    for (paramString = paramf;; paramString = localAppRuntimeApiPermissionBundle.tEj)
    {
      AppMethodBeat.o(318800);
      return paramString;
      paramf = localAppRuntimeApiPermissionBundle.tEk;
      break;
    }
  }
  
  public final AppRuntimeApiPermissionBundle afp(String paramString)
  {
    AppMethodBeat.i(318840);
    synchronized (this.tEt)
    {
      paramString = (AppRuntimeApiPermissionBundle)this.tEu.get(paramString);
      AppMethodBeat.o(318840);
      return paramString;
    }
  }
  
  public final AppRuntimeApiPermissionBundle cGN()
  {
    synchronized (this.tEr)
    {
      AppRuntimeApiPermissionBundle localAppRuntimeApiPermissionBundle = this.tEs;
      return localAppRuntimeApiPermissionBundle;
    }
  }
  
  public final Map<String, AppRuntimeApiPermissionBundle> cGO()
  {
    AppMethodBeat.i(318835);
    synchronized (this.tEt)
    {
      if ((this.tEu == null) || (this.tEu.isEmpty()))
      {
        AppMethodBeat.o(318835);
        return null;
      }
      HashMap local1 = new HashMap() {};
      AppMethodBeat.o(318835);
      return local1;
    }
  }
  
  public final AppRuntimeAppidABTestPermissionBundle dc(String paramString, int paramInt)
  {
    AppMethodBeat.i(318850);
    synchronized (this.tEv)
    {
      if (this.tEw == null)
      {
        AppMethodBeat.o(318850);
        return null;
      }
      paramString = (AppRuntimeAppidABTestPermissionBundle)this.tEw.get(paramString + "_weApp" + paramInt);
      AppMethodBeat.o(318850);
      return paramString;
    }
  }
  
  public final void i(HashMap<String, AppRuntimeApiPermissionBundle> paramHashMap)
  {
    int i = 0;
    AppMethodBeat.i(318819);
    arrayOfByte = this.tEt;
    if (paramHashMap == null) {}
    for (;;)
    {
      try
      {
        Log.i("MicroMsg.AppRuntimeApiPermissionController[permission]", "updatePluginPermission size:%d", new Object[] { Integer.valueOf(i) });
        this.tEu = paramHashMap;
        cGL();
        cGM();
        return;
      }
      finally
      {
        AppMethodBeat.o(318819);
      }
      i = paramHashMap.size();
    }
  }
  
  public final void j(HashMap<String, AppRuntimeAppidABTestPermissionBundle> paramHashMap)
  {
    int i = 0;
    AppMethodBeat.i(318826);
    localObject = this.tEv;
    if (paramHashMap == null) {}
    for (;;)
    {
      try
      {
        Log.i("MicroMsg.AppRuntimeApiPermissionController[permission]", "updateAppidABTestPermission size:%d", new Object[] { Integer.valueOf(i) });
        this.tEw = paramHashMap;
        return;
      }
      finally
      {
        AppMethodBeat.o(318826);
      }
      i = paramHashMap.size();
    }
  }
  
  public static final class a
  {
    private static final com.tencent.mm.plugin.appbrand.jsapi.g.a.d tEC;
    private static final a tED;
    private static final a tEE;
    private static final a tEF;
    private static final a tEG;
    private static final a tEH;
    public final String msg;
    public final com.tencent.mm.plugin.appbrand.jsapi.g.a.d rKn;
    public final int ret;
    
    static
    {
      AppMethodBeat.i(147644);
      tEC = new com.tencent.mm.plugin.appbrand.jsapi.g.a.d(-1, "");
      tED = new a(-1, "fail:auth canceled", a.e.rVC);
      tEE = new a(-1, "fail:auth denied", a.e.rVB);
      tEF = new a(-2, "", tEC);
      tEG = new a(-1, "fail:access denied", a.e.rVA);
      tEH = new a(0, "", a.e.rVt);
      AppMethodBeat.o(147644);
    }
    
    public a(int paramInt, String paramString, com.tencent.mm.plugin.appbrand.jsapi.g.a.d paramd)
    {
      this.ret = paramInt;
      this.msg = paramString;
      this.rKn = paramd;
    }
  }
  
  public static abstract interface b
  {
    public abstract void a(d.a parama);
    
    public abstract void yS(int paramInt);
  }
  
  public static abstract interface c
  {
    public abstract void g(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2);
    
    public abstract void h(HashMap<String, AppRuntimeApiPermissionBundle> paramHashMap);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.permission.d
 * JD-Core Version:    0.7.0.1
 */