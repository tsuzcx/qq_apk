package com.tencent.mm.plugin.appbrand.permission;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.jsapi.n.w;
import com.tencent.mm.plugin.appbrand.page.z;
import com.tencent.mm.plugin.appbrand.permission.a.a.c;
import com.tencent.mm.plugin.appbrand.r;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
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
  private static final Map<Class<? extends com.tencent.mm.plugin.appbrand.jsapi.b>, Integer> mmN;
  private static final Map<Class<? extends com.tencent.mm.plugin.appbrand.jsapi.b>, String> mmO;
  public static final String[] mmX;
  public final AppBrandRuntime jDb;
  public final int mmP;
  private final boolean mmQ;
  public final LinkedList<b> mmR;
  public final Object mmS;
  private AppRuntimeApiPermissionBundle mmT;
  private final byte[] mmU;
  private HashMap<String, AppRuntimeApiPermissionBundle> mmV;
  public List<c> mmW;
  
  static
  {
    AppMethodBeat.i(147660);
    mmN = new ConcurrentHashMap();
    mmO = new ConcurrentHashMap();
    mmX = new String[] { "createSocketTask", "createDownloadTask", "createRequestTask", "createUploadTask", "createUploadTaskAsync", "createRequestTaskAsync", "createUploadTaskAsync" };
    AppMethodBeat.o(147660);
  }
  
  public d(AppBrandRuntime paramAppBrandRuntime, int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(147654);
    this.mmR = new LinkedList();
    this.mmV = new HashMap();
    this.mmW = new ArrayList();
    this.jDb = paramAppBrandRuntime;
    this.mmS = new byte[0];
    this.mmU = new byte[0];
    this.mmP = paramInt;
    this.mmQ = paramBoolean;
    AppRuntimeApiPermissionBundle localAppRuntimeApiPermissionBundle = (AppRuntimeApiPermissionBundle)paramAppBrandRuntime.c(AppRuntimeApiPermissionBundle.class, false);
    if (localAppRuntimeApiPermissionBundle == null) {
      ae.e("MicroMsg.AppRuntimeApiPermissionController[permission]", "<init> get NULL permission from runtime");
    }
    a(localAppRuntimeApiPermissionBundle);
    if ((e)paramAppBrandRuntime.c(e.class, false) != null)
    {
      this.mmV = ((e)paramAppBrandRuntime.c(e.class, false)).mnf;
      if (this.mmV != null) {
        break label164;
      }
    }
    label164:
    for (paramInt = 0;; paramInt = this.mmV.size())
    {
      ae.i("MicroMsg.AppRuntimeApiPermissionController[permission]", "mPluginPermission size:%d", new Object[] { Integer.valueOf(paramInt) });
      AppMethodBeat.o(147654);
      return;
    }
  }
  
  private int a(com.tencent.mm.plugin.appbrand.jsapi.c paramc, Class<? extends com.tencent.mm.plugin.appbrand.jsapi.b> paramClass, String paramString, int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(147648);
    int i = this.mmP;
    String str1 = paramc.getAppId();
    if (i == -1)
    {
      ae.d("MicroMsg.AppRuntimeApiPermissionController[permission]", "getCtrlByte, appId = %s, ctrlIndex = %d, hard code perm on", new Object[] { str1, Integer.valueOf(paramInt) });
      AppMethodBeat.o(147648);
      return 1;
    }
    if (i == -2)
    {
      ae.d("MicroMsg.AppRuntimeApiPermissionController[permission]", "getCtrlByte, appId = %s, ctrlIndex = %d, hard code perm off", new Object[] { str1, Integer.valueOf(paramInt) });
      AppMethodBeat.o(147648);
      return 0;
    }
    if ((paramClass.isAssignableFrom(w.class)) && ((paramc instanceof z)))
    {
      AppMethodBeat.o(147648);
      return 1;
    }
    String str2 = aF(paramClass);
    i = c.c(paramc, str2, paramString);
    if (i != -2147483648)
    {
      AppMethodBeat.o(147648);
      return i;
    }
    paramString = new com.tencent.mm.plugin.appbrand.a.b[1];
    byte[] arrayOfByte = a(paramc, paramString);
    int j = F(arrayOfByte, paramInt);
    if (paramBoolean)
    {
      paramc = (k)paramc.K(k.class);
      if ((paramc != null) && (paramc.aG(paramClass))) {
        break label270;
      }
    }
    label270:
    for (i = 1;; i = 0)
    {
      if (i != 0) {
        ae.i("MicroMsg.AppRuntimeApiPermissionController[permission]", "getCtrlByte, appId = %s, apiName = %s, state = %s, ctrlIndex = %d, ctrlIndexLength %d, checkRet %d", new Object[] { str1, str2, paramString[0], Integer.valueOf(paramInt), Integer.valueOf(arrayOfByte.length), Integer.valueOf(j) });
      }
      AppMethodBeat.o(147648);
      return j;
    }
  }
  
  private static int aE(Class<? extends com.tencent.mm.plugin.appbrand.jsapi.b> paramClass)
  {
    AppMethodBeat.i(147652);
    Integer localInteger = (Integer)mmN.get(paramClass);
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
      mmN.put(paramClass, Integer.valueOf(i));
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
  
  private static String aF(Class<? extends com.tencent.mm.plugin.appbrand.jsapi.b> paramClass)
  {
    AppMethodBeat.i(147653);
    String str = (String)mmO.get(paramClass);
    if (!bu.isNullOrNil(str))
    {
      AppMethodBeat.o(147653);
      return str;
    }
    try
    {
      str = (String)a.bF(paramClass).get("NAME");
      mmO.put(paramClass, str);
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
    byte[] arrayOfByte = paramAppRuntimeApiPermissionBundle.mmK;
    paramAppRuntimeApiPermissionBundle = paramAppRuntimeApiPermissionBundle.mmL;
    int i = 0;
    while (i < this.mmW.size())
    {
      ((c)this.mmW.get(i)).g(arrayOfByte, paramAppRuntimeApiPermissionBundle);
      i += 1;
    }
    AppMethodBeat.o(147656);
  }
  
  private AppRuntimeApiPermissionBundle bwO()
  {
    synchronized (this.mmS)
    {
      AppRuntimeApiPermissionBundle localAppRuntimeApiPermissionBundle = this.mmT;
      return localAppRuntimeApiPermissionBundle;
    }
  }
  
  public static void k(com.tencent.mm.plugin.appbrand.jsapi.c paramc, String paramString)
  {
    AppMethodBeat.i(220861);
    if (paramc == null) {}
    for (paramc = null;; paramc = (j)paramc.K(j.class))
    {
      if (paramc != null) {
        paramc.UB(paramString);
      }
      AppMethodBeat.o(220861);
      return;
    }
  }
  
  public final int F(byte[] paramArrayOfByte, int paramInt)
  {
    int i = this.mmP;
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
    } while (this.mmQ);
    return 0;
    if ((paramInt >= paramArrayOfByte.length) || (paramInt < 0)) {
      return 0;
    }
    return paramArrayOfByte[paramInt];
  }
  
  public final AppRuntimeApiPermissionBundle Uz(String paramString)
  {
    AppMethodBeat.i(220860);
    synchronized (this.mmU)
    {
      if (this.mmV == null)
      {
        AppMethodBeat.o(220860);
        return null;
      }
      paramString = (AppRuntimeApiPermissionBundle)this.mmV.get(paramString);
      AppMethodBeat.o(220860);
      return paramString;
    }
  }
  
  public final int a(com.tencent.mm.plugin.appbrand.jsapi.c paramc, com.tencent.mm.plugin.appbrand.jsapi.b paramb, String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(147646);
    int i = a(paramc, paramb.getClass(), paramString, aE(paramb.getClass()), paramBoolean);
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
    synchronized (this.mmS)
    {
      AppRuntimeApiPermissionBundle localAppRuntimeApiPermissionBundle = this.mmT;
      if ((localAppRuntimeApiPermissionBundle != null) && (localAppRuntimeApiPermissionBundle.mmK.length > paramAppRuntimeApiPermissionBundle.mmK.length))
      {
        ae.e("MicroMsg.AppRuntimeApiPermissionController[permission]", "updatePermission, old %s, new %s, ignore", new Object[] { localAppRuntimeApiPermissionBundle, paramAppRuntimeApiPermissionBundle });
        AppMethodBeat.o(147655);
        return;
      }
      this.mmT = paramAppRuntimeApiPermissionBundle;
      b(this.mmT);
      ae.i("MicroMsg.AppRuntimeApiPermissionController[permission]", "updatePermission old %s, updated %s", new Object[] { localAppRuntimeApiPermissionBundle, paramAppRuntimeApiPermissionBundle });
      AppMethodBeat.o(147655);
      return;
    }
  }
  
  public final boolean a(com.tencent.mm.plugin.appbrand.jsapi.c paramc, Class<? extends com.tencent.mm.plugin.appbrand.jsapi.b> paramClass)
  {
    AppMethodBeat.i(147650);
    switch (a(paramc, paramClass, null, aE(paramClass), false))
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
      k(paramc, aF(paramClass));
      AppMethodBeat.o(147650);
      return false;
    case 7: 
      boolean bool = this.jDb.jzQ.jOf.bbJ();
      AppMethodBeat.o(147650);
      return bool;
    }
    AppMethodBeat.o(147650);
    return true;
  }
  
  public final byte[] a(com.tencent.mm.plugin.appbrand.jsapi.c paramc, com.tencent.mm.plugin.appbrand.a.b[] paramArrayOfb)
  {
    AppMethodBeat.i(220858);
    int i = this.mmP;
    if (i == -1)
    {
      AppMethodBeat.o(220858);
      return new byte[] { 1 };
    }
    if (i == -2)
    {
      AppMethodBeat.o(220858);
      return new byte[] { 0 };
    }
    Object localObject = bwO();
    if ((paramc instanceof r))
    {
      paramc = 2.jOy;
      com.tencent.mm.plugin.appbrand.a.b localb = this.jDb.jzQ.jOf.bbI();
      switch (paramc[localb.ordinal()])
      {
      default: 
        paramc = ((AppRuntimeApiPermissionBundle)localObject).mmK;
        localObject = paramc;
        if (paramArrayOfb != null)
        {
          localObject = paramc;
          if (paramArrayOfb.length > 0) {
            paramArrayOfb[0] = localb;
          }
        }
        break;
      }
    }
    for (localObject = paramc;; localObject = ((AppRuntimeApiPermissionBundle)localObject).mmK)
    {
      AppMethodBeat.o(220858);
      return localObject;
      paramc = ((AppRuntimeApiPermissionBundle)localObject).mmL;
      break;
    }
  }
  
  public final Vector<byte[]> bwN()
  {
    AppMethodBeat.i(147657);
    synchronized (this.mmS)
    {
      if (this.mmT == null)
      {
        AppMethodBeat.o(147657);
        return null;
      }
      byte[] arrayOfByte1 = this.mmT.mmK;
      byte[] arrayOfByte2 = this.mmT.mmL;
      byte[] arrayOfByte3 = this.mmT.mmM;
      ??? = new Vector(3);
      ((Vector)???).addElement(arrayOfByte1);
      ((Vector)???).addElement(arrayOfByte2);
      ((Vector)???).addElement(arrayOfByte3);
      AppMethodBeat.o(147657);
      return ???;
    }
  }
  
  public final void f(HashMap<String, AppRuntimeApiPermissionBundle> paramHashMap)
  {
    int i = 0;
    AppMethodBeat.i(220859);
    arrayOfByte = this.mmU;
    if (paramHashMap == null) {}
    for (;;)
    {
      try
      {
        ae.i("MicroMsg.AppRuntimeApiPermissionController[permission]", "updatePluginPermission size:%d", new Object[] { Integer.valueOf(i) });
        this.mmV = paramHashMap;
        return;
      }
      finally
      {
        AppMethodBeat.o(220859);
      }
      i = paramHashMap.size();
    }
  }
  
  public static final class a
  {
    private static final a mna;
    private static final a mnb;
    private static final a mnc;
    private static final a mnd;
    private static final a mne;
    public final String msg;
    public final int ret;
    
    static
    {
      AppMethodBeat.i(147644);
      mna = new a(-1, "fail:auth canceled");
      mnb = new a(-1, "fail:auth denied");
      mnc = new a(-2, "");
      mnd = new a(-1, "fail:access denied");
      mne = new a(0, "");
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.permission.d
 * JD-Core Version:    0.7.0.1
 */