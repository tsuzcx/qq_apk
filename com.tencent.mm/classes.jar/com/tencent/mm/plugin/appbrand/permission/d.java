package com.tencent.mm.plugin.appbrand.permission;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.jsapi.n.w;
import com.tencent.mm.plugin.appbrand.page.aa;
import com.tencent.mm.plugin.appbrand.permission.a.a.c;
import com.tencent.mm.plugin.appbrand.q;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
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
  private static final Map<Class<? extends com.tencent.mm.plugin.appbrand.jsapi.b>, Integer> mhP;
  private static final Map<Class<? extends com.tencent.mm.plugin.appbrand.jsapi.b>, String> mhQ;
  public static final String[] mhZ;
  public final AppBrandRuntime jzY;
  public final int mhR;
  private final boolean mhS;
  public final LinkedList<b> mhT;
  public final Object mhU;
  private AppRuntimeApiPermissionBundle mhV;
  private final byte[] mhW;
  private HashMap<String, AppRuntimeApiPermissionBundle> mhX;
  public List<c> mhY;
  
  static
  {
    AppMethodBeat.i(147660);
    mhP = new ConcurrentHashMap();
    mhQ = new ConcurrentHashMap();
    mhZ = new String[] { "createSocketTask", "createDownloadTask", "createRequestTask", "createUploadTask", "createUploadTaskAsync", "createRequestTaskAsync", "createUploadTaskAsync" };
    AppMethodBeat.o(147660);
  }
  
  public d(AppBrandRuntime paramAppBrandRuntime, int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(147654);
    this.mhT = new LinkedList();
    this.mhX = new HashMap();
    this.mhY = new ArrayList();
    this.jzY = paramAppBrandRuntime;
    this.mhU = new byte[0];
    this.mhW = new byte[0];
    this.mhR = paramInt;
    this.mhS = paramBoolean;
    AppRuntimeApiPermissionBundle localAppRuntimeApiPermissionBundle = (AppRuntimeApiPermissionBundle)paramAppBrandRuntime.c(AppRuntimeApiPermissionBundle.class, false);
    if (localAppRuntimeApiPermissionBundle == null) {
      ad.e("MicroMsg.AppRuntimeApiPermissionController[permission]", "<init> get NULL permission from runtime");
    }
    a(localAppRuntimeApiPermissionBundle);
    if ((e)paramAppBrandRuntime.c(e.class, false) != null)
    {
      this.mhX = ((e)paramAppBrandRuntime.c(e.class, false)).mih;
      if (this.mhX != null) {
        break label164;
      }
    }
    label164:
    for (paramInt = 0;; paramInt = this.mhX.size())
    {
      ad.i("MicroMsg.AppRuntimeApiPermissionController[permission]", "mPluginPermission size:%d", new Object[] { Integer.valueOf(paramInt) });
      AppMethodBeat.o(147654);
      return;
    }
  }
  
  private int a(com.tencent.mm.plugin.appbrand.jsapi.c paramc, Class<? extends com.tencent.mm.plugin.appbrand.jsapi.b> paramClass, String paramString, int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(147648);
    int i = this.mhR;
    String str1 = paramc.getAppId();
    if (i == -1)
    {
      ad.d("MicroMsg.AppRuntimeApiPermissionController[permission]", "getCtrlByte, appId = %s, ctrlIndex = %d, hard code perm on", new Object[] { str1, Integer.valueOf(paramInt) });
      AppMethodBeat.o(147648);
      return 1;
    }
    if (i == -2)
    {
      ad.d("MicroMsg.AppRuntimeApiPermissionController[permission]", "getCtrlByte, appId = %s, ctrlIndex = %d, hard code perm off", new Object[] { str1, Integer.valueOf(paramInt) });
      AppMethodBeat.o(147648);
      return 0;
    }
    if ((paramClass.isAssignableFrom(w.class)) && ((paramc instanceof aa)))
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
      paramc = (i)paramc.K(i.class);
      if ((paramc != null) && (paramc.aG(paramClass))) {
        break label270;
      }
    }
    label270:
    for (i = 1;; i = 0)
    {
      if (i != 0) {
        ad.i("MicroMsg.AppRuntimeApiPermissionController[permission]", "getCtrlByte, appId = %s, apiName = %s, state = %s, ctrlIndex = %d, ctrlIndexLength %d, checkRet %d", new Object[] { str1, str2, paramString[0], Integer.valueOf(paramInt), Integer.valueOf(arrayOfByte.length), Integer.valueOf(j) });
      }
      AppMethodBeat.o(147648);
      return j;
    }
  }
  
  private static int aE(Class<? extends com.tencent.mm.plugin.appbrand.jsapi.b> paramClass)
  {
    AppMethodBeat.i(147652);
    Integer localInteger = (Integer)mhP.get(paramClass);
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
      mhP.put(paramClass, Integer.valueOf(i));
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
    String str = (String)mhQ.get(paramClass);
    if (!bt.isNullOrNil(str))
    {
      AppMethodBeat.o(147653);
      return str;
    }
    try
    {
      str = (String)a.bF(paramClass).get("NAME");
      mhQ.put(paramClass, str);
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
    byte[] arrayOfByte = paramAppRuntimeApiPermissionBundle.mhM;
    paramAppRuntimeApiPermissionBundle = paramAppRuntimeApiPermissionBundle.mhN;
    int i = 0;
    while (i < this.mhY.size())
    {
      ((c)this.mhY.get(i)).g(arrayOfByte, paramAppRuntimeApiPermissionBundle);
      i += 1;
    }
    AppMethodBeat.o(147656);
  }
  
  private AppRuntimeApiPermissionBundle bvX()
  {
    synchronized (this.mhU)
    {
      AppRuntimeApiPermissionBundle localAppRuntimeApiPermissionBundle = this.mhV;
      return localAppRuntimeApiPermissionBundle;
    }
  }
  
  public static void k(com.tencent.mm.plugin.appbrand.jsapi.c paramc, String paramString)
  {
    AppMethodBeat.i(192286);
    if (paramc == null) {}
    for (paramc = null;; paramc = (h)paramc.K(h.class))
    {
      if (paramc != null) {
        paramc.TR(paramString);
      }
      AppMethodBeat.o(192286);
      return;
    }
  }
  
  public final int F(byte[] paramArrayOfByte, int paramInt)
  {
    int i = this.mhR;
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
    } while (this.mhS);
    return 0;
    if ((paramInt >= paramArrayOfByte.length) || (paramInt < 0)) {
      return 0;
    }
    return paramArrayOfByte[paramInt];
  }
  
  public final AppRuntimeApiPermissionBundle TQ(String paramString)
  {
    AppMethodBeat.i(192285);
    synchronized (this.mhW)
    {
      if (this.mhX == null)
      {
        AppMethodBeat.o(192285);
        return null;
      }
      paramString = (AppRuntimeApiPermissionBundle)this.mhX.get(paramString);
      AppMethodBeat.o(192285);
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
    synchronized (this.mhU)
    {
      AppRuntimeApiPermissionBundle localAppRuntimeApiPermissionBundle = this.mhV;
      if ((localAppRuntimeApiPermissionBundle != null) && (localAppRuntimeApiPermissionBundle.mhM.length > paramAppRuntimeApiPermissionBundle.mhM.length))
      {
        ad.e("MicroMsg.AppRuntimeApiPermissionController[permission]", "updatePermission, old %s, new %s, ignore", new Object[] { localAppRuntimeApiPermissionBundle, paramAppRuntimeApiPermissionBundle });
        AppMethodBeat.o(147655);
        return;
      }
      this.mhV = paramAppRuntimeApiPermissionBundle;
      b(this.mhV);
      ad.i("MicroMsg.AppRuntimeApiPermissionController[permission]", "updatePermission old %s, updated %s", new Object[] { localAppRuntimeApiPermissionBundle, paramAppRuntimeApiPermissionBundle });
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
      boolean bool = this.jzY.jwS.jKT.bbh();
      AppMethodBeat.o(147650);
      return bool;
    }
    AppMethodBeat.o(147650);
    return true;
  }
  
  public final byte[] a(com.tencent.mm.plugin.appbrand.jsapi.c paramc, com.tencent.mm.plugin.appbrand.a.b[] paramArrayOfb)
  {
    AppMethodBeat.i(192283);
    int i = this.mhR;
    if (i == -1)
    {
      AppMethodBeat.o(192283);
      return new byte[] { 1 };
    }
    if (i == -2)
    {
      AppMethodBeat.o(192283);
      return new byte[] { 0 };
    }
    Object localObject = bvX();
    if ((paramc instanceof q))
    {
      paramc = 2.jLm;
      com.tencent.mm.plugin.appbrand.a.b localb = this.jzY.jwS.jKT.bbg();
      switch (paramc[localb.ordinal()])
      {
      default: 
        paramc = ((AppRuntimeApiPermissionBundle)localObject).mhM;
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
    for (localObject = paramc;; localObject = ((AppRuntimeApiPermissionBundle)localObject).mhM)
    {
      AppMethodBeat.o(192283);
      return localObject;
      paramc = ((AppRuntimeApiPermissionBundle)localObject).mhN;
      break;
    }
  }
  
  public final Vector<byte[]> bvW()
  {
    AppMethodBeat.i(147657);
    synchronized (this.mhU)
    {
      if (this.mhV == null)
      {
        AppMethodBeat.o(147657);
        return null;
      }
      byte[] arrayOfByte1 = this.mhV.mhM;
      byte[] arrayOfByte2 = this.mhV.mhN;
      byte[] arrayOfByte3 = this.mhV.mhO;
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
    AppMethodBeat.i(192284);
    arrayOfByte = this.mhW;
    if (paramHashMap == null) {}
    for (;;)
    {
      try
      {
        ad.i("MicroMsg.AppRuntimeApiPermissionController[permission]", "updatePluginPermission size:%d", new Object[] { Integer.valueOf(i) });
        this.mhX = paramHashMap;
        return;
      }
      finally
      {
        AppMethodBeat.o(192284);
      }
      i = paramHashMap.size();
    }
  }
  
  public static final class a
  {
    private static final a mic;
    private static final a mid;
    private static final a mie;
    private static final a mif;
    private static final a mig;
    public final String msg;
    public final int ret;
    
    static
    {
      AppMethodBeat.i(147644);
      mic = new a(-1, "fail:auth canceled");
      mid = new a(-1, "fail:auth denied");
      mie = new a(-2, "");
      mif = new a(-1, "fail:access denied");
      mig = new a(0, "");
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.permission.d
 * JD-Core Version:    0.7.0.1
 */