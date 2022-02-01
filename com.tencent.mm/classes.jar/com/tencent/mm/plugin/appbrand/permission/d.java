package com.tencent.mm.plugin.appbrand.permission;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.jsapi.q.aa;
import com.tencent.mm.plugin.appbrand.page.ad;
import com.tencent.mm.plugin.appbrand.permission.a.a.c;
import com.tencent.mm.plugin.appbrand.permission.appidABTest.AppRuntimeAppidABTestPermissionBundle;
import com.tencent.mm.plugin.appbrand.v;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Vector;
import java.util.concurrent.ConcurrentHashMap;
import junit.framework.Assert;

public class d
{
  public static final String[] qzB;
  private static final Map<Class<? extends com.tencent.mm.plugin.appbrand.jsapi.d>, Integer> qzp;
  private static final Map<Class<? extends com.tencent.mm.plugin.appbrand.jsapi.d>, String> qzq;
  public final AppBrandRuntime nxs;
  public List<d.c> qzA;
  public final int qzr;
  private final boolean qzs;
  public final LinkedList<b> qzt;
  public final Object qzu;
  private AppRuntimeApiPermissionBundle qzv;
  private final byte[] qzw;
  private HashMap<String, AppRuntimeApiPermissionBundle> qzx;
  private final Object qzy;
  private HashMap<String, AppRuntimeAppidABTestPermissionBundle> qzz;
  
  static
  {
    AppMethodBeat.i(147660);
    qzp = new ConcurrentHashMap();
    qzq = new ConcurrentHashMap();
    qzB = new String[] { "createSocketTask", "createDownloadTask", "createRequestTask", "createUploadTask", "createUploadTaskAsync", "createRequestTaskAsync", "createUploadTaskAsync" };
    AppMethodBeat.o(147660);
  }
  
  public d(AppBrandRuntime paramAppBrandRuntime, int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(147654);
    this.qzt = new LinkedList();
    this.qzx = new HashMap();
    this.qzz = new HashMap();
    this.qzA = new ArrayList();
    this.nxs = paramAppBrandRuntime;
    this.qzu = new byte[0];
    this.qzw = new byte[0];
    this.qzy = new byte[0];
    this.qzr = paramInt;
    this.qzs = paramBoolean;
    AppRuntimeApiPermissionBundle localAppRuntimeApiPermissionBundle = (AppRuntimeApiPermissionBundle)paramAppBrandRuntime.d(AppRuntimeApiPermissionBundle.class, false);
    if (localAppRuntimeApiPermissionBundle == null) {
      Log.e("MicroMsg.AppRuntimeApiPermissionController[permission]", "<init> get NULL permission from runtime");
    }
    a(localAppRuntimeApiPermissionBundle);
    if ((e)paramAppBrandRuntime.d(e.class, false) != null)
    {
      this.qzx = ((e)paramAppBrandRuntime.d(e.class, false)).qzJ;
      if (this.qzx == null)
      {
        paramInt = 0;
        Log.i("MicroMsg.AppRuntimeApiPermissionController[permission]", "mPluginPermission size:%d", new Object[] { Integer.valueOf(paramInt) });
      }
    }
    else
    {
      paramAppBrandRuntime = (com.tencent.mm.plugin.appbrand.permission.appidABTest.a)paramAppBrandRuntime.d(com.tencent.mm.plugin.appbrand.permission.appidABTest.a.class, false);
      if (paramAppBrandRuntime != null)
      {
        this.qzz = paramAppBrandRuntime.qAb;
        if (this.qzz != null) {
          break label243;
        }
      }
    }
    label243:
    for (paramInt = 0;; paramInt = this.qzz.size())
    {
      Log.i("MicroMsg.AppRuntimeApiPermissionController[permission]", "mAppidPermission size:%d", new Object[] { Integer.valueOf(paramInt) });
      AppMethodBeat.o(147654);
      return;
      paramInt = this.qzx.size();
      break;
    }
  }
  
  private int a(com.tencent.mm.plugin.appbrand.jsapi.e parame, Class<? extends com.tencent.mm.plugin.appbrand.jsapi.d> paramClass, String paramString, int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(147648);
    int i = this.qzr;
    String str1 = parame.getAppId();
    if (i == -1)
    {
      Log.d("MicroMsg.AppRuntimeApiPermissionController[permission]", "getCtrlByte, appId = %s, ctrlIndex = %d, hard code perm on", new Object[] { str1, Integer.valueOf(paramInt) });
      AppMethodBeat.o(147648);
      return 1;
    }
    if (i == -2)
    {
      Log.d("MicroMsg.AppRuntimeApiPermissionController[permission]", "getCtrlByte, appId = %s, ctrlIndex = %d, hard code perm off", new Object[] { str1, Integer.valueOf(paramInt) });
      AppMethodBeat.o(147648);
      return 0;
    }
    if ((paramClass.isAssignableFrom(aa.class)) && ((parame instanceof ad)))
    {
      AppMethodBeat.o(147648);
      return 1;
    }
    String str2 = aE(paramClass);
    i = c.e(parame, str2, paramString);
    if (i != -2147483648)
    {
      AppMethodBeat.o(147648);
      return i;
    }
    paramString = new com.tencent.mm.plugin.appbrand.a.b[1];
    byte[] arrayOfByte = a(parame, paramString);
    int j = G(arrayOfByte, paramInt);
    if (paramBoolean)
    {
      parame = (k)parame.K(k.class);
      if ((parame != null) && (parame.aF(paramClass))) {
        break label270;
      }
    }
    label270:
    for (i = 1;; i = 0)
    {
      if (i != 0) {
        Log.i("MicroMsg.AppRuntimeApiPermissionController[permission]", "getCtrlByte, appId = %s, apiName = %s, state = %s, ctrlIndex = %d, ctrlIndexLength %d, checkRet %d", new Object[] { str1, str2, paramString[0], Integer.valueOf(paramInt), Integer.valueOf(arrayOfByte.length), Integer.valueOf(j) });
      }
      AppMethodBeat.o(147648);
      return j;
    }
  }
  
  private static int aD(Class<? extends com.tencent.mm.plugin.appbrand.jsapi.d> paramClass)
  {
    AppMethodBeat.i(147652);
    Integer localInteger = (Integer)qzp.get(paramClass);
    int i;
    if (localInteger != null)
    {
      i = localInteger.intValue();
      AppMethodBeat.o(147652);
      return i;
    }
    try
    {
      i = ((Integer)org.a.a.ce(paramClass).get("CTRL_INDEX")).intValue();
      qzp.put(paramClass, Integer.valueOf(i));
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
  
  private static String aE(Class<? extends com.tencent.mm.plugin.appbrand.jsapi.d> paramClass)
  {
    AppMethodBeat.i(147653);
    String str = (String)qzq.get(paramClass);
    if (!Util.isNullOrNil(str))
    {
      AppMethodBeat.o(147653);
      return str;
    }
    try
    {
      str = (String)org.a.a.ce(paramClass).get("NAME");
      qzq.put(paramClass, str);
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
    byte[] arrayOfByte = paramAppRuntimeApiPermissionBundle.qzm;
    paramAppRuntimeApiPermissionBundle = paramAppRuntimeApiPermissionBundle.qzn;
    int i = 0;
    while (i < this.qzA.size())
    {
      ((d.c)this.qzA.get(i)).g(arrayOfByte, paramAppRuntimeApiPermissionBundle);
      i += 1;
    }
    AppMethodBeat.o(147656);
  }
  
  private AppRuntimeApiPermissionBundle cga()
  {
    synchronized (this.qzu)
    {
      AppRuntimeApiPermissionBundle localAppRuntimeApiPermissionBundle = this.qzv;
      return localAppRuntimeApiPermissionBundle;
    }
  }
  
  public static void m(com.tencent.mm.plugin.appbrand.jsapi.e parame, String paramString)
  {
    AppMethodBeat.i(245684);
    if (parame == null) {}
    for (parame = null;; parame = (j)parame.K(j.class))
    {
      if (parame != null) {
        parame.amj(paramString);
      }
      AppMethodBeat.o(245684);
      return;
    }
  }
  
  public final int G(byte[] paramArrayOfByte, int paramInt)
  {
    int i = this.qzr;
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
    } while (this.qzs);
    return 0;
    if ((paramInt >= paramArrayOfByte.length) || (paramInt < 0)) {
      return 0;
    }
    return paramArrayOfByte[paramInt];
  }
  
  public final int a(com.tencent.mm.plugin.appbrand.jsapi.e parame, com.tencent.mm.plugin.appbrand.jsapi.d paramd, String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(147646);
    int i = a(parame, paramd.getClass(), paramString, aD(paramd.getClass()), paramBoolean);
    AppMethodBeat.o(147646);
    return i;
  }
  
  public final void a(AppRuntimeApiPermissionBundle paramAppRuntimeApiPermissionBundle)
  {
    AppMethodBeat.i(147655);
    if (paramAppRuntimeApiPermissionBundle == null)
    {
      AppMethodBeat.o(147655);
      return;
    }
    synchronized (this.qzu)
    {
      AppRuntimeApiPermissionBundle localAppRuntimeApiPermissionBundle = this.qzv;
      if ((localAppRuntimeApiPermissionBundle != null) && (localAppRuntimeApiPermissionBundle.qzm.length > paramAppRuntimeApiPermissionBundle.qzm.length))
      {
        Log.e("MicroMsg.AppRuntimeApiPermissionController[permission]", "updatePermission, old %s, new %s, ignore", new Object[] { localAppRuntimeApiPermissionBundle, paramAppRuntimeApiPermissionBundle });
        AppMethodBeat.o(147655);
        return;
      }
      this.qzv = paramAppRuntimeApiPermissionBundle;
      b(this.qzv);
      Log.i("MicroMsg.AppRuntimeApiPermissionController[permission]", "updatePermission old %s, updated %s", new Object[] { localAppRuntimeApiPermissionBundle, paramAppRuntimeApiPermissionBundle });
      AppMethodBeat.o(147655);
      return;
    }
  }
  
  public final boolean a(com.tencent.mm.plugin.appbrand.jsapi.e parame, Class<? extends com.tencent.mm.plugin.appbrand.jsapi.d> paramClass)
  {
    AppMethodBeat.i(147650);
    switch (a(parame, paramClass, null, aD(paramClass), false))
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
      m(parame, aE(paramClass));
      AppMethodBeat.o(147650);
      return false;
    case 7: 
      boolean bool = this.nxs.ntR.nKU.bIh();
      AppMethodBeat.o(147650);
      return bool;
    }
    AppMethodBeat.o(147650);
    return true;
  }
  
  public final byte[] a(com.tencent.mm.plugin.appbrand.jsapi.e parame, com.tencent.mm.plugin.appbrand.a.b[] paramArrayOfb)
  {
    AppMethodBeat.i(245672);
    int i = this.qzr;
    if (i == -1)
    {
      AppMethodBeat.o(245672);
      return new byte[] { 1 };
    }
    if (i == -2)
    {
      AppMethodBeat.o(245672);
      return new byte[] { 0 };
    }
    Object localObject = cga();
    if ((parame instanceof v))
    {
      parame = 2.nLn;
      com.tencent.mm.plugin.appbrand.a.b localb = this.nxs.ntR.nKU.bIg();
      switch (parame[localb.ordinal()])
      {
      default: 
        parame = ((AppRuntimeApiPermissionBundle)localObject).qzm;
        localObject = parame;
        if (paramArrayOfb != null)
        {
          localObject = parame;
          if (paramArrayOfb.length > 0) {
            paramArrayOfb[0] = localb;
          }
        }
        break;
      }
    }
    for (localObject = parame;; localObject = ((AppRuntimeApiPermissionBundle)localObject).qzm)
    {
      AppMethodBeat.o(245672);
      return localObject;
      parame = ((AppRuntimeApiPermissionBundle)localObject).qzn;
      break;
    }
  }
  
  public final AppRuntimeApiPermissionBundle amh(String paramString)
  {
    AppMethodBeat.i(245682);
    synchronized (this.qzw)
    {
      if (this.qzx == null)
      {
        AppMethodBeat.o(245682);
        return null;
      }
      paramString = (AppRuntimeApiPermissionBundle)this.qzx.get(paramString);
      AppMethodBeat.o(245682);
      return paramString;
    }
  }
  
  public final AppRuntimeAppidABTestPermissionBundle cC(String paramString, int paramInt)
  {
    AppMethodBeat.i(245683);
    synchronized (this.qzy)
    {
      if (this.qzz == null)
      {
        AppMethodBeat.o(245683);
        return null;
      }
      paramString = (AppRuntimeAppidABTestPermissionBundle)this.qzz.get(paramString + "_weApp" + paramInt);
      AppMethodBeat.o(245683);
      return paramString;
    }
  }
  
  public final Vector<byte[]> cfZ()
  {
    AppMethodBeat.i(147657);
    synchronized (this.qzu)
    {
      if (this.qzv == null)
      {
        AppMethodBeat.o(147657);
        return null;
      }
      byte[] arrayOfByte1 = this.qzv.qzm;
      byte[] arrayOfByte2 = this.qzv.qzn;
      byte[] arrayOfByte3 = this.qzv.qzo;
      ??? = new Vector(3);
      ((Vector)???).addElement(arrayOfByte1);
      ((Vector)???).addElement(arrayOfByte2);
      ((Vector)???).addElement(arrayOfByte3);
      AppMethodBeat.o(147657);
      return ???;
    }
  }
  
  public final void g(HashMap<String, AppRuntimeApiPermissionBundle> paramHashMap)
  {
    int i = 0;
    AppMethodBeat.i(245678);
    arrayOfByte = this.qzw;
    if (paramHashMap == null) {}
    for (;;)
    {
      try
      {
        Log.i("MicroMsg.AppRuntimeApiPermissionController[permission]", "updatePluginPermission size:%d", new Object[] { Integer.valueOf(i) });
        this.qzx = paramHashMap;
        return;
      }
      finally
      {
        AppMethodBeat.o(245678);
      }
      i = paramHashMap.size();
    }
  }
  
  public final void h(HashMap<String, AppRuntimeAppidABTestPermissionBundle> paramHashMap)
  {
    int i = 0;
    AppMethodBeat.i(245679);
    localObject = this.qzy;
    if (paramHashMap == null) {}
    for (;;)
    {
      try
      {
        Log.i("MicroMsg.AppRuntimeApiPermissionController[permission]", "updateAppidABTestPermission size:%d", new Object[] { Integer.valueOf(i) });
        this.qzz = paramHashMap;
        return;
      }
      finally
      {
        AppMethodBeat.o(245679);
      }
      i = paramHashMap.size();
    }
  }
  
  public static final class a
  {
    private static final a qzE;
    private static final a qzF;
    private static final a qzG;
    private static final a qzH;
    private static final a qzI;
    public final String msg;
    public final int ret;
    
    static
    {
      AppMethodBeat.i(147644);
      qzE = new a(-1, "fail:auth canceled");
      qzF = new a(-1, "fail:auth denied");
      qzG = new a(-2, "");
      qzH = new a(-1, "fail:access denied");
      qzI = new a(0, "");
      AppMethodBeat.o(147644);
    }
    
    public a(int paramInt, String paramString)
    {
      this.ret = paramInt;
      this.msg = paramString;
    }
  }
  
  public static abstract interface b
  {
    public abstract void a(d.a parama);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.permission.d
 * JD-Core Version:    0.7.0.1
 */