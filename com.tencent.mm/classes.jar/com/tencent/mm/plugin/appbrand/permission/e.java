package com.tencent.mm.plugin.appbrand.permission;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.jsapi.l.u;
import com.tencent.mm.plugin.appbrand.page.aa;
import com.tencent.mm.plugin.appbrand.q;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Vector;
import java.util.concurrent.ConcurrentHashMap;
import junit.framework.Assert;

public class e
{
  private static final Map<Class<? extends com.tencent.mm.plugin.appbrand.jsapi.b>, Integer> liK;
  private static final Map<Class<? extends com.tencent.mm.plugin.appbrand.jsapi.b>, String> liL;
  private static final String[] liU;
  public final AppBrandRuntime iGV;
  public final int liM;
  private final boolean liN;
  public final LinkedList<b> liO;
  public final Object liP;
  private AppRuntimeApiPermissionBundle liQ;
  private final byte[] liR;
  private HashMap<String, AppRuntimeApiPermissionBundle> liS;
  public List<c> liT;
  
  static
  {
    AppMethodBeat.i(147660);
    liK = new ConcurrentHashMap();
    liL = new ConcurrentHashMap();
    liU = new String[] { "createSocketTask", "createDownloadTask", "createRequestTask", "createUploadTask", "createUploadTaskAsync", "createRequestTaskAsync", "createUploadTaskAsync" };
    AppMethodBeat.o(147660);
  }
  
  public e(AppBrandRuntime paramAppBrandRuntime, int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(147654);
    this.liO = new LinkedList();
    this.liS = new HashMap();
    this.liT = new ArrayList();
    this.iGV = paramAppBrandRuntime;
    this.liP = new byte[0];
    this.liR = new byte[0];
    this.liM = paramInt;
    this.liN = paramBoolean;
    AppRuntimeApiPermissionBundle localAppRuntimeApiPermissionBundle = (AppRuntimeApiPermissionBundle)paramAppBrandRuntime.c(AppRuntimeApiPermissionBundle.class, false);
    if (localAppRuntimeApiPermissionBundle == null) {
      ad.e("MicroMsg.AppRuntimeApiPermissionController[permission]", "<init> get NULL permission from runtime");
    }
    a(localAppRuntimeApiPermissionBundle);
    if ((f)paramAppBrandRuntime.c(f.class, false) != null)
    {
      this.liS = ((f)paramAppBrandRuntime.c(f.class, false)).ljc;
      if (this.liS != null) {
        break label164;
      }
    }
    label164:
    for (paramInt = 0;; paramInt = this.liS.size())
    {
      ad.i("MicroMsg.AppRuntimeApiPermissionController[permission]", "mPluginPermission size:%d", new Object[] { Integer.valueOf(paramInt) });
      AppMethodBeat.o(147654);
      return;
    }
  }
  
  private int a(com.tencent.mm.plugin.appbrand.jsapi.c paramc, com.tencent.mm.plugin.appbrand.jsapi.b paramb, String paramString)
  {
    AppMethodBeat.i(147645);
    int i = a(paramc, paramb, paramString, true);
    AppMethodBeat.o(147645);
    return i;
  }
  
  private int a(com.tencent.mm.plugin.appbrand.jsapi.c paramc, Class<? extends com.tencent.mm.plugin.appbrand.jsapi.b> paramClass)
  {
    AppMethodBeat.i(147647);
    int i = a(paramc, paramClass, null, aE(paramClass), true);
    AppMethodBeat.o(147647);
    return i;
  }
  
  private int a(com.tencent.mm.plugin.appbrand.jsapi.c paramc, Class<? extends com.tencent.mm.plugin.appbrand.jsapi.b> paramClass, String paramString, int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(147648);
    int i = this.liM;
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
    if ((paramClass.isAssignableFrom(u.class)) && ((paramc instanceof aa)))
    {
      AppMethodBeat.o(147648);
      return 1;
    }
    String str2 = aF(paramClass);
    i = c.b(paramc, str2, paramString);
    if (i != -2147483648)
    {
      AppMethodBeat.o(147648);
      return i;
    }
    paramString = G(paramc);
    int j = H(paramString, paramInt);
    if (paramBoolean)
    {
      paramc = (h)paramc.K(h.class);
      if ((paramc != null) && (paramc.aG(paramClass))) {
        break label254;
      }
    }
    label254:
    for (i = 1;; i = 0)
    {
      if (i != 0) {
        ad.i("MicroMsg.AppRuntimeApiPermissionController[permission]", "getCtrlByte, appId = %s, apiName = %s, ctrlIndex = %d, ctrlIndexLength %d, checkRet %d", new Object[] { str1, str2, Integer.valueOf(paramInt), Integer.valueOf(paramString.length), Integer.valueOf(j) });
      }
      AppMethodBeat.o(147648);
      return j;
    }
  }
  
  private void a(b paramb)
  {
    AppMethodBeat.i(147658);
    if (paramb == null)
    {
      AppMethodBeat.o(147658);
      return;
    }
    synchronized (this.liO)
    {
      this.liO.addLast(paramb);
      AppMethodBeat.o(147658);
      return;
    }
  }
  
  private static int aE(Class<? extends com.tencent.mm.plugin.appbrand.jsapi.b> paramClass)
  {
    AppMethodBeat.i(147652);
    Integer localInteger = (Integer)liK.get(paramClass);
    int i;
    if (localInteger != null)
    {
      i = localInteger.intValue();
      AppMethodBeat.o(147652);
      return i;
    }
    try
    {
      i = ((Integer)org.a.a.bA(paramClass).get("CTRL_INDEX")).intValue();
      liK.put(paramClass, Integer.valueOf(i));
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
    String str = (String)liL.get(paramClass);
    if (!bt.isNullOrNil(str))
    {
      AppMethodBeat.o(147653);
      return str;
    }
    try
    {
      str = (String)org.a.a.bA(paramClass).get("NAME");
      liL.put(paramClass, str);
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
    byte[] arrayOfByte = paramAppRuntimeApiPermissionBundle.liH;
    paramAppRuntimeApiPermissionBundle = paramAppRuntimeApiPermissionBundle.liI;
    int i = 0;
    while (i < this.liT.size())
    {
      ((c)this.liT.get(i)).g(arrayOfByte, paramAppRuntimeApiPermissionBundle);
      i += 1;
    }
    AppMethodBeat.o(147656);
  }
  
  private AppRuntimeApiPermissionBundle blk()
  {
    synchronized (this.liP)
    {
      AppRuntimeApiPermissionBundle localAppRuntimeApiPermissionBundle = this.liQ;
      return localAppRuntimeApiPermissionBundle;
    }
  }
  
  public final byte[] G(com.tencent.mm.plugin.appbrand.jsapi.c paramc)
  {
    AppMethodBeat.i(147649);
    int i = this.liM;
    if (i == -1)
    {
      AppMethodBeat.o(147649);
      return new byte[] { 1 };
    }
    if (i == -2)
    {
      AppMethodBeat.o(147649);
      return new byte[] { 0 };
    }
    AppRuntimeApiPermissionBundle localAppRuntimeApiPermissionBundle = blk();
    if ((paramc instanceof q)) {
      switch (2.iRi[this.iGV.iDK.iQP.aQO().ordinal()])
      {
      default: 
        paramc = localAppRuntimeApiPermissionBundle.liH;
      }
    }
    for (;;)
    {
      AppMethodBeat.o(147649);
      return paramc;
      paramc = localAppRuntimeApiPermissionBundle.liI;
      continue;
      paramc = localAppRuntimeApiPermissionBundle.liH;
    }
  }
  
  public final int H(byte[] paramArrayOfByte, int paramInt)
  {
    int i = this.liM;
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
    } while (this.liN);
    return 0;
    if ((paramInt >= paramArrayOfByte.length) || (paramInt < 0)) {
      return 0;
    }
    return paramArrayOfByte[paramInt];
  }
  
  public final AppRuntimeApiPermissionBundle Mg(String paramString)
  {
    AppMethodBeat.i(186909);
    synchronized (this.liR)
    {
      if (this.liS == null)
      {
        AppMethodBeat.o(186909);
        return null;
      }
      paramString = (AppRuntimeApiPermissionBundle)this.liS.get(paramString);
      AppMethodBeat.o(186909);
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
  
  public final a a(com.tencent.mm.plugin.appbrand.jsapi.c paramc, com.tencent.mm.plugin.appbrand.jsapi.b paramb, String paramString, final b paramb1)
  {
    AppMethodBeat.i(147659);
    if ((paramb == null) || (paramc == null))
    {
      paramc = a.blm();
      AppMethodBeat.o(147659);
      return paramc;
    }
    com.tencent.mm.plugin.appbrand.b.b localb = this.iGV.iDK.iQP.aQO();
    int i = a(paramc, paramb, paramString);
    paramString = paramc.getAppId();
    if (i == 6)
    {
      ((g)paramc.K(g.class)).Mh(paramb.getName());
      paramc = a.blm();
      AppMethodBeat.o(147659);
      return paramc;
    }
    if (i == 1)
    {
      if (((paramc instanceof q)) && (localb == com.tencent.mm.plugin.appbrand.b.b.iQM) && (com.tencent.mm.compatible.loader.a.contains(liU, paramb.getName())))
      {
        paramc = new a(-1, String.format(Locale.US, "fail: jsapi has no permission, event=%s, runningState=%s, permissionMsg=%s, detail=%s", new Object[] { paramb.getName(), localb.name().toLowerCase(), "permission ok", "network api interrupted in suspend state" }));
        AppMethodBeat.o(147659);
        return paramc;
      }
      paramc = a.bll();
      AppMethodBeat.o(147659);
      return paramc;
    }
    if (i == 4)
    {
      if (d.dO(paramString, paramb.getName()))
      {
        paramc = a.bll();
        AppMethodBeat.o(147659);
        return paramc;
      }
      if (d.a((com.tencent.mm.plugin.appbrand.jsapi.h)paramc, paramb.getName()))
      {
        paramc = a.bll();
        AppMethodBeat.o(147659);
        return paramc;
      }
      d.a((com.tencent.mm.plugin.appbrand.jsapi.h)paramc, paramb.getName(), new d.c()
      {
        public final void Ll(String paramAnonymousString)
        {
          AppMethodBeat.i(147641);
          if (paramb1 != null)
          {
            if (TextUtils.isEmpty(paramAnonymousString))
            {
              paramb1.a(e.a.bln());
              AppMethodBeat.o(147641);
              return;
            }
            paramb1.a(new e.a(-1, "fail ".concat(String.valueOf(paramAnonymousString))));
          }
          AppMethodBeat.o(147641);
        }
        
        public final void biM()
        {
          AppMethodBeat.i(147640);
          if (paramb1 != null) {
            paramb1.a(e.a.bll());
          }
          AppMethodBeat.o(147640);
        }
        
        public final void onCancel()
        {
          AppMethodBeat.i(147642);
          if (paramb1 != null) {
            paramb1.a(e.a.blo());
          }
          AppMethodBeat.o(147642);
        }
      });
      paramc = a.blp();
      AppMethodBeat.o(147659);
      return paramc;
    }
    if (i == 7)
    {
      if (this.iGV.iDK.aQL())
      {
        paramc = a.bll();
        AppMethodBeat.o(147659);
        return paramc;
      }
      paramc = new a(-1, String.format(Locale.US, "fail: jsapi has no permission, event=%s, runningState=%s, permissionMsg=%s, detail=%s", new Object[] { paramb.getName(), localb.name().toLowerCase(), "permission ok", "jsapi permission required playing audio but current not playing audio in background state" }));
      AppMethodBeat.o(147659);
      return paramc;
    }
    if (i == 8)
    {
      a(paramb1);
      paramc = a.blp();
      AppMethodBeat.o(147659);
      return paramc;
    }
    paramc = a.blm();
    AppMethodBeat.o(147659);
    return paramc;
  }
  
  public final void a(AppRuntimeApiPermissionBundle paramAppRuntimeApiPermissionBundle)
  {
    AppMethodBeat.i(147655);
    if (paramAppRuntimeApiPermissionBundle == null)
    {
      AppMethodBeat.o(147655);
      return;
    }
    synchronized (this.liP)
    {
      AppRuntimeApiPermissionBundle localAppRuntimeApiPermissionBundle = this.liQ;
      if ((localAppRuntimeApiPermissionBundle != null) && (localAppRuntimeApiPermissionBundle.liH.length > paramAppRuntimeApiPermissionBundle.liH.length))
      {
        ad.e("MicroMsg.AppRuntimeApiPermissionController[permission]", "updatePermission, old %s, new %s, ignore", new Object[] { localAppRuntimeApiPermissionBundle, paramAppRuntimeApiPermissionBundle });
        AppMethodBeat.o(147655);
        return;
      }
      this.liQ = paramAppRuntimeApiPermissionBundle;
      b(this.liQ);
      ad.i("MicroMsg.AppRuntimeApiPermissionController[permission]", "updatePermission old %s, updated %s", new Object[] { localAppRuntimeApiPermissionBundle, paramAppRuntimeApiPermissionBundle });
      AppMethodBeat.o(147655);
      return;
    }
  }
  
  public final boolean a(com.tencent.mm.plugin.appbrand.jsapi.c paramc, com.tencent.mm.plugin.appbrand.jsapi.b paramb)
  {
    AppMethodBeat.i(147651);
    if (a(paramc, paramb, null, null).ret == 0)
    {
      AppMethodBeat.o(147651);
      return true;
    }
    AppMethodBeat.o(147651);
    return false;
  }
  
  @Deprecated
  public final boolean b(com.tencent.mm.plugin.appbrand.jsapi.c paramc, Class<? extends com.tencent.mm.plugin.appbrand.jsapi.b> paramClass)
  {
    AppMethodBeat.i(147650);
    if (a(paramc, paramClass) == 1)
    {
      AppMethodBeat.o(147650);
      return true;
    }
    AppMethodBeat.o(147650);
    return false;
  }
  
  public final Vector<byte[]> blj()
  {
    AppMethodBeat.i(147657);
    synchronized (this.liP)
    {
      if (this.liQ == null)
      {
        AppMethodBeat.o(147657);
        return null;
      }
      byte[] arrayOfByte1 = this.liQ.liH;
      byte[] arrayOfByte2 = this.liQ.liI;
      byte[] arrayOfByte3 = this.liQ.liJ;
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
    AppMethodBeat.i(186908);
    arrayOfByte = this.liR;
    if (paramHashMap == null) {}
    for (;;)
    {
      try
      {
        ad.i("MicroMsg.AppRuntimeApiPermissionController[permission]", "updatePluginPermission size:%d", new Object[] { Integer.valueOf(i) });
        this.liS = paramHashMap;
        return;
      }
      finally
      {
        AppMethodBeat.o(186908);
      }
      i = paramHashMap.size();
    }
  }
  
  public static final class a
  {
    private static final a liX;
    private static final a liY;
    private static final a liZ;
    private static final a lja;
    private static final a ljb;
    public final String bLg;
    public final int ret;
    
    static
    {
      AppMethodBeat.i(147644);
      liX = new a(-1, "fail:auth canceled");
      liY = new a(-1, "fail:auth denied");
      liZ = new a(-2, "");
      lja = new a(-1, "fail:access denied");
      ljb = new a(0, "");
      AppMethodBeat.o(147644);
    }
    
    public a(int paramInt, String paramString)
    {
      this.ret = paramInt;
      this.bLg = paramString;
    }
  }
  
  public static abstract interface b
  {
    public abstract void a(e.a parama);
  }
  
  public static abstract interface c
  {
    public abstract void g(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.permission.e
 * JD-Core Version:    0.7.0.1
 */