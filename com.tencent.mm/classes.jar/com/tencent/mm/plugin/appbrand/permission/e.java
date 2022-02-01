package com.tencent.mm.plugin.appbrand.permission;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.jsapi.k.u;
import com.tencent.mm.plugin.appbrand.page.aa;
import com.tencent.mm.plugin.appbrand.q;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
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
  private static final Map<Class<? extends com.tencent.mm.plugin.appbrand.jsapi.b>, Integer> lIC;
  private static final Map<Class<? extends com.tencent.mm.plugin.appbrand.jsapi.b>, String> lID;
  private static final String[] lIM;
  public final AppBrandRuntime jgY;
  public final int lIE;
  private final boolean lIF;
  public final LinkedList<b> lIG;
  public final Object lIH;
  private AppRuntimeApiPermissionBundle lII;
  private final byte[] lIJ;
  private HashMap<String, AppRuntimeApiPermissionBundle> lIK;
  public List<c> lIL;
  
  static
  {
    AppMethodBeat.i(147660);
    lIC = new ConcurrentHashMap();
    lID = new ConcurrentHashMap();
    lIM = new String[] { "createSocketTask", "createDownloadTask", "createRequestTask", "createUploadTask", "createUploadTaskAsync", "createRequestTaskAsync", "createUploadTaskAsync" };
    AppMethodBeat.o(147660);
  }
  
  public e(AppBrandRuntime paramAppBrandRuntime, int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(147654);
    this.lIG = new LinkedList();
    this.lIK = new HashMap();
    this.lIL = new ArrayList();
    this.jgY = paramAppBrandRuntime;
    this.lIH = new byte[0];
    this.lIJ = new byte[0];
    this.lIE = paramInt;
    this.lIF = paramBoolean;
    AppRuntimeApiPermissionBundle localAppRuntimeApiPermissionBundle = (AppRuntimeApiPermissionBundle)paramAppBrandRuntime.c(AppRuntimeApiPermissionBundle.class, false);
    if (localAppRuntimeApiPermissionBundle == null) {
      ac.e("MicroMsg.AppRuntimeApiPermissionController[permission]", "<init> get NULL permission from runtime");
    }
    a(localAppRuntimeApiPermissionBundle);
    if ((f)paramAppBrandRuntime.c(f.class, false) != null)
    {
      this.lIK = ((f)paramAppBrandRuntime.c(f.class, false)).lIU;
      if (this.lIK != null) {
        break label164;
      }
    }
    label164:
    for (paramInt = 0;; paramInt = this.lIK.size())
    {
      ac.i("MicroMsg.AppRuntimeApiPermissionController[permission]", "mPluginPermission size:%d", new Object[] { Integer.valueOf(paramInt) });
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
    int i = this.lIE;
    String str1 = paramc.getAppId();
    if (i == -1)
    {
      ac.d("MicroMsg.AppRuntimeApiPermissionController[permission]", "getCtrlByte, appId = %s, ctrlIndex = %d, hard code perm on", new Object[] { str1, Integer.valueOf(paramInt) });
      AppMethodBeat.o(147648);
      return 1;
    }
    if (i == -2)
    {
      ac.d("MicroMsg.AppRuntimeApiPermissionController[permission]", "getCtrlByte, appId = %s, ctrlIndex = %d, hard code perm off", new Object[] { str1, Integer.valueOf(paramInt) });
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
    paramString = new com.tencent.mm.plugin.appbrand.b.b[1];
    byte[] arrayOfByte = a(paramc, paramString);
    int j = F(arrayOfByte, paramInt);
    if (paramBoolean)
    {
      paramc = (h)paramc.K(h.class);
      if ((paramc != null) && (paramc.aG(paramClass))) {
        break label270;
      }
    }
    label270:
    for (i = 1;; i = 0)
    {
      if (i != 0) {
        ac.i("MicroMsg.AppRuntimeApiPermissionController[permission]", "getCtrlByte, appId = %s, apiName = %s, state = %s, ctrlIndex = %d, ctrlIndexLength %d, checkRet %d", new Object[] { str1, str2, paramString[0], Integer.valueOf(paramInt), Integer.valueOf(arrayOfByte.length), Integer.valueOf(j) });
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
    synchronized (this.lIG)
    {
      this.lIG.addLast(paramb);
      AppMethodBeat.o(147658);
      return;
    }
  }
  
  private static int aE(Class<? extends com.tencent.mm.plugin.appbrand.jsapi.b> paramClass)
  {
    AppMethodBeat.i(147652);
    Integer localInteger = (Integer)lIC.get(paramClass);
    int i;
    if (localInteger != null)
    {
      i = localInteger.intValue();
      AppMethodBeat.o(147652);
      return i;
    }
    try
    {
      i = ((Integer)org.a.a.bD(paramClass).get("CTRL_INDEX")).intValue();
      lIC.put(paramClass, Integer.valueOf(i));
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
    String str = (String)lID.get(paramClass);
    if (!bs.isNullOrNil(str))
    {
      AppMethodBeat.o(147653);
      return str;
    }
    try
    {
      str = (String)org.a.a.bD(paramClass).get("NAME");
      lID.put(paramClass, str);
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
    byte[] arrayOfByte = paramAppRuntimeApiPermissionBundle.lIz;
    paramAppRuntimeApiPermissionBundle = paramAppRuntimeApiPermissionBundle.lIA;
    int i = 0;
    while (i < this.lIL.size())
    {
      ((c)this.lIL.get(i)).g(arrayOfByte, paramAppRuntimeApiPermissionBundle);
      i += 1;
    }
    AppMethodBeat.o(147656);
  }
  
  private AppRuntimeApiPermissionBundle brZ()
  {
    synchronized (this.lIH)
    {
      AppRuntimeApiPermissionBundle localAppRuntimeApiPermissionBundle = this.lII;
      return localAppRuntimeApiPermissionBundle;
    }
  }
  
  public final int F(byte[] paramArrayOfByte, int paramInt)
  {
    int i = this.lIE;
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
    } while (this.lIF);
    return 0;
    if ((paramInt >= paramArrayOfByte.length) || (paramInt < 0)) {
      return 0;
    }
    return paramArrayOfByte[paramInt];
  }
  
  public final AppRuntimeApiPermissionBundle Qm(String paramString)
  {
    AppMethodBeat.i(206194);
    synchronized (this.lIJ)
    {
      if (this.lIK == null)
      {
        AppMethodBeat.o(206194);
        return null;
      }
      paramString = (AppRuntimeApiPermissionBundle)this.lIK.get(paramString);
      AppMethodBeat.o(206194);
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
      paramc = a.bsb();
      AppMethodBeat.o(147659);
      return paramc;
    }
    com.tencent.mm.plugin.appbrand.b.b localb = this.jgY.jdK.jqZ.aXJ();
    int i = a(paramc, paramb, paramString);
    paramString = paramc.getAppId();
    if (i == 6)
    {
      ((g)paramc.K(g.class)).Qn(paramb.getName());
      paramc = a.bsb();
      AppMethodBeat.o(147659);
      return paramc;
    }
    if (i == 1)
    {
      if (((paramc instanceof q)) && (localb == com.tencent.mm.plugin.appbrand.b.b.jqW) && (com.tencent.mm.compatible.loader.a.contains(lIM, paramb.getName())))
      {
        paramc = new a(-1, String.format(Locale.US, "fail: jsapi has no permission, event=%s, runningState=%s, permissionMsg=%s, detail=%s", new Object[] { paramb.getName(), localb.name().toLowerCase(), "permission ok", "network api interrupted in suspend state" }));
        AppMethodBeat.o(147659);
        return paramc;
      }
      paramc = a.bsa();
      AppMethodBeat.o(147659);
      return paramc;
    }
    if (i == 4)
    {
      if (d.ea(paramString, paramb.getName()))
      {
        paramc = a.bsa();
        AppMethodBeat.o(147659);
        return paramc;
      }
      if (d.a((com.tencent.mm.plugin.appbrand.jsapi.h)paramc, paramb.getName()))
      {
        paramc = a.bsa();
        AppMethodBeat.o(147659);
        return paramc;
      }
      d.a((com.tencent.mm.plugin.appbrand.jsapi.h)paramc, paramb.getName(), new d.c()
      {
        public final void Pt(String paramAnonymousString)
        {
          AppMethodBeat.i(147641);
          if (paramb1 != null)
          {
            if (TextUtils.isEmpty(paramAnonymousString))
            {
              paramb1.a(e.a.bsc());
              AppMethodBeat.o(147641);
              return;
            }
            paramb1.a(new e.a(-1, "fail ".concat(String.valueOf(paramAnonymousString))));
          }
          AppMethodBeat.o(147641);
        }
        
        public final void bpF()
        {
          AppMethodBeat.i(147640);
          if (paramb1 != null) {
            paramb1.a(e.a.bsa());
          }
          AppMethodBeat.o(147640);
        }
        
        public final void onCancel()
        {
          AppMethodBeat.i(147642);
          if (paramb1 != null) {
            paramb1.a(e.a.bsd());
          }
          AppMethodBeat.o(147642);
        }
      });
      paramc = a.bse();
      AppMethodBeat.o(147659);
      return paramc;
    }
    if (i == 7)
    {
      if (this.jgY.jdK.aXG())
      {
        paramc = a.bsa();
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
      paramc = a.bse();
      AppMethodBeat.o(147659);
      return paramc;
    }
    paramc = a.bsb();
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
    synchronized (this.lIH)
    {
      AppRuntimeApiPermissionBundle localAppRuntimeApiPermissionBundle = this.lII;
      if ((localAppRuntimeApiPermissionBundle != null) && (localAppRuntimeApiPermissionBundle.lIz.length > paramAppRuntimeApiPermissionBundle.lIz.length))
      {
        ac.e("MicroMsg.AppRuntimeApiPermissionController[permission]", "updatePermission, old %s, new %s, ignore", new Object[] { localAppRuntimeApiPermissionBundle, paramAppRuntimeApiPermissionBundle });
        AppMethodBeat.o(147655);
        return;
      }
      this.lII = paramAppRuntimeApiPermissionBundle;
      b(this.lII);
      ac.i("MicroMsg.AppRuntimeApiPermissionController[permission]", "updatePermission old %s, updated %s", new Object[] { localAppRuntimeApiPermissionBundle, paramAppRuntimeApiPermissionBundle });
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
  
  public final byte[] a(com.tencent.mm.plugin.appbrand.jsapi.c paramc, com.tencent.mm.plugin.appbrand.b.b[] paramArrayOfb)
  {
    AppMethodBeat.i(206192);
    int i = this.lIE;
    if (i == -1)
    {
      AppMethodBeat.o(206192);
      return new byte[] { 1 };
    }
    if (i == -2)
    {
      AppMethodBeat.o(206192);
      return new byte[] { 0 };
    }
    Object localObject = brZ();
    if ((paramc instanceof q))
    {
      paramc = 2.jrs;
      com.tencent.mm.plugin.appbrand.b.b localb = this.jgY.jdK.jqZ.aXJ();
      switch (paramc[localb.ordinal()])
      {
      default: 
        paramc = ((AppRuntimeApiPermissionBundle)localObject).lIz;
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
    for (localObject = paramc;; localObject = ((AppRuntimeApiPermissionBundle)localObject).lIz)
    {
      AppMethodBeat.o(206192);
      return localObject;
      paramc = ((AppRuntimeApiPermissionBundle)localObject).lIA;
      break;
    }
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
  
  public final Vector<byte[]> brY()
  {
    AppMethodBeat.i(147657);
    synchronized (this.lIH)
    {
      if (this.lII == null)
      {
        AppMethodBeat.o(147657);
        return null;
      }
      byte[] arrayOfByte1 = this.lII.lIz;
      byte[] arrayOfByte2 = this.lII.lIA;
      byte[] arrayOfByte3 = this.lII.lIB;
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
    AppMethodBeat.i(206193);
    arrayOfByte = this.lIJ;
    if (paramHashMap == null) {}
    for (;;)
    {
      try
      {
        ac.i("MicroMsg.AppRuntimeApiPermissionController[permission]", "updatePluginPermission size:%d", new Object[] { Integer.valueOf(i) });
        this.lIK = paramHashMap;
        return;
      }
      finally
      {
        AppMethodBeat.o(206193);
      }
      i = paramHashMap.size();
    }
  }
  
  public static final class a
  {
    private static final a lIP;
    private static final a lIQ;
    private static final a lIR;
    private static final a lIS;
    private static final a lIT;
    public final String bIO;
    public final int ret;
    
    static
    {
      AppMethodBeat.i(147644);
      lIP = new a(-1, "fail:auth canceled");
      lIQ = new a(-1, "fail:auth denied");
      lIR = new a(-2, "");
      lIS = new a(-1, "fail:access denied");
      lIT = new a(0, "");
      AppMethodBeat.o(147644);
    }
    
    public a(int paramInt, String paramString)
    {
      this.ret = paramInt;
      this.bIO = paramString;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.permission.e
 * JD-Core Version:    0.7.0.1
 */