package com.tencent.mm.plugin.appbrand.permission;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.jsapi.f;
import com.tencent.mm.plugin.appbrand.jsapi.p.aa;
import com.tencent.mm.plugin.appbrand.page.ac;
import com.tencent.mm.plugin.appbrand.permission.a.a.c;
import com.tencent.mm.plugin.appbrand.s;
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
import org.a.a;

public class d
{
  private static final Map<Class<? extends com.tencent.mm.plugin.appbrand.jsapi.e>, Integer> nxn;
  private static final Map<Class<? extends com.tencent.mm.plugin.appbrand.jsapi.e>, String> nxo;
  public static final String[] nxx;
  public final AppBrandRuntime kEc;
  public final int nxp;
  private final boolean nxq;
  public final LinkedList<b> nxr;
  public final Object nxs;
  private AppRuntimeApiPermissionBundle nxt;
  private final byte[] nxu;
  private HashMap<String, AppRuntimeApiPermissionBundle> nxv;
  public List<c> nxw;
  
  static
  {
    AppMethodBeat.i(147660);
    nxn = new ConcurrentHashMap();
    nxo = new ConcurrentHashMap();
    nxx = new String[] { "createSocketTask", "createDownloadTask", "createRequestTask", "createUploadTask", "createUploadTaskAsync", "createRequestTaskAsync", "createUploadTaskAsync" };
    AppMethodBeat.o(147660);
  }
  
  public d(AppBrandRuntime paramAppBrandRuntime, int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(147654);
    this.nxr = new LinkedList();
    this.nxv = new HashMap();
    this.nxw = new ArrayList();
    this.kEc = paramAppBrandRuntime;
    this.nxs = new byte[0];
    this.nxu = new byte[0];
    this.nxp = paramInt;
    this.nxq = paramBoolean;
    AppRuntimeApiPermissionBundle localAppRuntimeApiPermissionBundle = (AppRuntimeApiPermissionBundle)paramAppBrandRuntime.d(AppRuntimeApiPermissionBundle.class, false);
    if (localAppRuntimeApiPermissionBundle == null) {
      Log.e("MicroMsg.AppRuntimeApiPermissionController[permission]", "<init> get NULL permission from runtime");
    }
    a(localAppRuntimeApiPermissionBundle);
    if ((e)paramAppBrandRuntime.d(e.class, false) != null)
    {
      this.nxv = ((e)paramAppBrandRuntime.d(e.class, false)).nxF;
      if (this.nxv != null) {
        break label164;
      }
    }
    label164:
    for (paramInt = 0;; paramInt = this.nxv.size())
    {
      Log.i("MicroMsg.AppRuntimeApiPermissionController[permission]", "mPluginPermission size:%d", new Object[] { Integer.valueOf(paramInt) });
      AppMethodBeat.o(147654);
      return;
    }
  }
  
  private int a(f paramf, Class<? extends com.tencent.mm.plugin.appbrand.jsapi.e> paramClass, String paramString, int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(147648);
    int i = this.nxp;
    String str1 = paramf.getAppId();
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
    if ((paramClass.isAssignableFrom(aa.class)) && ((paramf instanceof ac)))
    {
      AppMethodBeat.o(147648);
      return 1;
    }
    String str2 = aF(paramClass);
    i = c.e(paramf, str2, paramString);
    if (i != -2147483648)
    {
      AppMethodBeat.o(147648);
      return i;
    }
    paramString = new com.tencent.mm.plugin.appbrand.a.b[1];
    byte[] arrayOfByte = a(paramf, paramString);
    int j = H(arrayOfByte, paramInt);
    if (paramBoolean)
    {
      paramf = (k)paramf.M(k.class);
      if ((paramf != null) && (paramf.aG(paramClass))) {
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
  
  private static int aE(Class<? extends com.tencent.mm.plugin.appbrand.jsapi.e> paramClass)
  {
    AppMethodBeat.i(147652);
    Integer localInteger = (Integer)nxn.get(paramClass);
    int i;
    if (localInteger != null)
    {
      i = localInteger.intValue();
      AppMethodBeat.o(147652);
      return i;
    }
    try
    {
      i = ((Integer)a.bF(paramClass).get("CTRL_INDEX")).intValue();
      nxn.put(paramClass, Integer.valueOf(i));
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
  
  private static String aF(Class<? extends com.tencent.mm.plugin.appbrand.jsapi.e> paramClass)
  {
    AppMethodBeat.i(147653);
    String str = (String)nxo.get(paramClass);
    if (!Util.isNullOrNil(str))
    {
      AppMethodBeat.o(147653);
      return str;
    }
    try
    {
      str = (String)a.bF(paramClass).get("NAME");
      nxo.put(paramClass, str);
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
    byte[] arrayOfByte = paramAppRuntimeApiPermissionBundle.nxk;
    paramAppRuntimeApiPermissionBundle = paramAppRuntimeApiPermissionBundle.nxl;
    int i = 0;
    while (i < this.nxw.size())
    {
      ((c)this.nxw.get(i)).g(arrayOfByte, paramAppRuntimeApiPermissionBundle);
      i += 1;
    }
    AppMethodBeat.o(147656);
  }
  
  private AppRuntimeApiPermissionBundle bSX()
  {
    synchronized (this.nxs)
    {
      AppRuntimeApiPermissionBundle localAppRuntimeApiPermissionBundle = this.nxt;
      return localAppRuntimeApiPermissionBundle;
    }
  }
  
  public static void l(f paramf, String paramString)
  {
    AppMethodBeat.i(229968);
    if (paramf == null) {}
    for (paramf = null;; paramf = (j)paramf.M(j.class))
    {
      if (paramf != null) {
        paramf.aep(paramString);
      }
      AppMethodBeat.o(229968);
      return;
    }
  }
  
  public final int H(byte[] paramArrayOfByte, int paramInt)
  {
    int i = this.nxp;
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
    } while (this.nxq);
    return 0;
    if ((paramInt >= paramArrayOfByte.length) || (paramInt < 0)) {
      return 0;
    }
    return paramArrayOfByte[paramInt];
  }
  
  public final int a(f paramf, com.tencent.mm.plugin.appbrand.jsapi.e parame, String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(147646);
    int i = a(paramf, parame.getClass(), paramString, aE(parame.getClass()), paramBoolean);
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
    synchronized (this.nxs)
    {
      AppRuntimeApiPermissionBundle localAppRuntimeApiPermissionBundle = this.nxt;
      if ((localAppRuntimeApiPermissionBundle != null) && (localAppRuntimeApiPermissionBundle.nxk.length > paramAppRuntimeApiPermissionBundle.nxk.length))
      {
        Log.e("MicroMsg.AppRuntimeApiPermissionController[permission]", "updatePermission, old %s, new %s, ignore", new Object[] { localAppRuntimeApiPermissionBundle, paramAppRuntimeApiPermissionBundle });
        AppMethodBeat.o(147655);
        return;
      }
      this.nxt = paramAppRuntimeApiPermissionBundle;
      b(this.nxt);
      Log.i("MicroMsg.AppRuntimeApiPermissionController[permission]", "updatePermission old %s, updated %s", new Object[] { localAppRuntimeApiPermissionBundle, paramAppRuntimeApiPermissionBundle });
      AppMethodBeat.o(147655);
      return;
    }
  }
  
  public final boolean a(f paramf, Class<? extends com.tencent.mm.plugin.appbrand.jsapi.e> paramClass)
  {
    AppMethodBeat.i(147650);
    switch (a(paramf, paramClass, null, aE(paramClass), false))
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
      l(paramf, aF(paramClass));
      AppMethodBeat.o(147650);
      return false;
    case 7: 
      boolean bool = this.kEc.kAH.kQM.bwZ();
      AppMethodBeat.o(147650);
      return bool;
    }
    AppMethodBeat.o(147650);
    return true;
  }
  
  public final byte[] a(f paramf, com.tencent.mm.plugin.appbrand.a.b[] paramArrayOfb)
  {
    AppMethodBeat.i(229965);
    int i = this.nxp;
    if (i == -1)
    {
      AppMethodBeat.o(229965);
      return new byte[] { 1 };
    }
    if (i == -2)
    {
      AppMethodBeat.o(229965);
      return new byte[] { 0 };
    }
    Object localObject = bSX();
    if ((paramf instanceof s))
    {
      paramf = 2.kRf;
      com.tencent.mm.plugin.appbrand.a.b localb = this.kEc.kAH.kQM.bwY();
      switch (paramf[localb.ordinal()])
      {
      default: 
        paramf = ((AppRuntimeApiPermissionBundle)localObject).nxk;
        localObject = paramf;
        if (paramArrayOfb != null)
        {
          localObject = paramf;
          if (paramArrayOfb.length > 0) {
            paramArrayOfb[0] = localb;
          }
        }
        break;
      }
    }
    for (localObject = paramf;; localObject = ((AppRuntimeApiPermissionBundle)localObject).nxk)
    {
      AppMethodBeat.o(229965);
      return localObject;
      paramf = ((AppRuntimeApiPermissionBundle)localObject).nxl;
      break;
    }
  }
  
  public final AppRuntimeApiPermissionBundle aen(String paramString)
  {
    AppMethodBeat.i(229967);
    synchronized (this.nxu)
    {
      if (this.nxv == null)
      {
        AppMethodBeat.o(229967);
        return null;
      }
      paramString = (AppRuntimeApiPermissionBundle)this.nxv.get(paramString);
      AppMethodBeat.o(229967);
      return paramString;
    }
  }
  
  public final Vector<byte[]> bSW()
  {
    AppMethodBeat.i(147657);
    synchronized (this.nxs)
    {
      if (this.nxt == null)
      {
        AppMethodBeat.o(147657);
        return null;
      }
      byte[] arrayOfByte1 = this.nxt.nxk;
      byte[] arrayOfByte2 = this.nxt.nxl;
      byte[] arrayOfByte3 = this.nxt.nxm;
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
    AppMethodBeat.i(229966);
    arrayOfByte = this.nxu;
    if (paramHashMap == null) {}
    for (;;)
    {
      try
      {
        Log.i("MicroMsg.AppRuntimeApiPermissionController[permission]", "updatePluginPermission size:%d", new Object[] { Integer.valueOf(i) });
        this.nxv = paramHashMap;
        return;
      }
      finally
      {
        AppMethodBeat.o(229966);
      }
      i = paramHashMap.size();
    }
  }
  
  public static final class a
  {
    private static final a nxA;
    private static final a nxB;
    private static final a nxC;
    private static final a nxD;
    private static final a nxE;
    public final String msg;
    public final int ret;
    
    static
    {
      AppMethodBeat.i(147644);
      nxA = new a(-1, "fail:auth canceled");
      nxB = new a(-1, "fail:auth denied");
      nxC = new a(-2, "");
      nxD = new a(-1, "fail:access denied");
      nxE = new a(0, "");
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
  
  public static abstract interface c
  {
    public abstract void g(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.permission.d
 * JD-Core Version:    0.7.0.1
 */