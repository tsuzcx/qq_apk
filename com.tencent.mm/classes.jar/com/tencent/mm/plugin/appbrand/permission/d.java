package com.tencent.mm.plugin.appbrand.permission;

import com.tencent.mm.platformtools.ae;
import com.tencent.mm.plugin.appbrand.b.c.a;
import com.tencent.mm.plugin.appbrand.config.AppBrandSysConfigWC;
import com.tencent.mm.plugin.appbrand.i;
import com.tencent.mm.plugin.appbrand.ipc.MMToClientEvent;
import com.tencent.mm.plugin.appbrand.jsapi.f;
import com.tencent.mm.plugin.appbrand.jsapi.t;
import com.tencent.mm.plugin.appbrand.launching.ILaunchWxaAppInfoNotify.a.1;
import com.tencent.mm.plugin.appbrand.launching.ILaunchWxaAppInfoNotify.a.2;
import com.tencent.mm.plugin.appbrand.n;
import com.tencent.mm.plugin.appbrand.page.q;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Locale;
import junit.framework.Assert;

public final class d
{
  private static final int fWp = -bk.getInt(ae.eSK, 0);
  private static final HashMap<Class<? extends com.tencent.mm.plugin.appbrand.jsapi.b>, Integer> gWW = new HashMap();
  private static final HashMap<Class<? extends com.tencent.mm.plugin.appbrand.jsapi.b>, String> gWX = new HashMap();
  private final i fzT;
  private final LinkedList<d.b> gWY = new LinkedList();
  private final Object gWZ;
  private AppRuntimeApiPermissionBundle gXa;
  
  public d(n paramn)
  {
    this.fzT = paramn;
    this.gWZ = new byte[0];
    a(paramn.aaa().fPW);
    paramn.fyy.a(new c.a()
    {
      public final void a(String paramAnonymousString, com.tencent.mm.plugin.appbrand.b.b paramAnonymousb)
      {
        switch (d.3.fGc[paramAnonymousb.ordinal()])
        {
        case 3: 
        default: 
          return;
        case 4: 
          d.a(d.this);
          return;
        }
        d.b(d.this);
      }
    });
    if (!paramn.mFinished)
    {
      ILaunchWxaAppInfoNotify.a.1 local1 = new ILaunchWxaAppInfoNotify.a.1(paramn);
      MMToClientEvent.a(paramn.mAppId, local1);
      paramn.fyy.a(new ILaunchWxaAppInfoNotify.a.2(paramn, local1));
    }
  }
  
  public static int C(byte[] paramArrayOfByte, int paramInt)
  {
    if (paramInt == -2) {}
    for (;;)
    {
      return 1;
      if (paramInt != -1) {
        break;
      }
      if ((com.tencent.mm.protocal.d.spe) || ((com.tencent.mm.protocal.d.spa & 0xFF) <= 47)) {}
      for (paramInt = 1; paramInt == 0; paramInt = 0) {
        return 0;
      }
    }
    if ((paramInt >= paramArrayOfByte.length) || (paramInt < 0)) {
      return 0;
    }
    return paramArrayOfByte[paramInt];
  }
  
  private static int L(Class<? extends com.tencent.mm.plugin.appbrand.jsapi.b> paramClass)
  {
    Integer localInteger = (Integer)gWW.get(paramClass);
    if (localInteger != null) {
      return localInteger.intValue();
    }
    try
    {
      i = ((Integer)org.b.a.al(paramClass).get("CTRL_INDEX")).intValue();
      gWW.put(paramClass, Integer.valueOf(i));
      return i;
    }
    catch (org.b.b localb)
    {
      for (;;)
      {
        Assert.assertTrue("Must declare CTRL_INDEX in JsApi Class: " + paramClass.getName(), true);
        int i = -1;
      }
    }
  }
  
  private static String M(Class<? extends com.tencent.mm.plugin.appbrand.jsapi.b> paramClass)
  {
    String str = (String)gWX.get(paramClass);
    if (!bk.bl(str)) {
      return str;
    }
    try
    {
      str = (String)org.b.a.al(paramClass).get("NAME");
      gWX.put(paramClass, str);
      return str;
    }
    catch (org.b.b localb)
    {
      Assert.assertTrue("Must declare NAME in JsApi Class: " + paramClass.getName(), true);
    }
    return paramClass.getSimpleName();
  }
  
  private int a(com.tencent.mm.plugin.appbrand.jsapi.c paramc, Class<? extends com.tencent.mm.plugin.appbrand.jsapi.b> paramClass, String paramString, int paramInt, boolean paramBoolean)
  {
    int i = fWp;
    String str1 = paramc.getAppId();
    if (i == -1) {
      y.d("MicroMsg.AppRuntimeApiPermissionController", "getCtrlByte, appId = %s, ctrlIndex = %d, hard code perm on", new Object[] { str1, Integer.valueOf(paramInt) });
    }
    do
    {
      return 1;
      if (i == -2)
      {
        y.d("MicroMsg.AppRuntimeApiPermissionController", "getCtrlByte, appId = %s, ctrlIndex = %d, hard code perm off", new Object[] { str1, Integer.valueOf(paramInt) });
        return 0;
      }
    } while ((paramClass.isAssignableFrom(com.tencent.mm.plugin.appbrand.jsapi.k.o.class)) && ((paramc instanceof q)));
    String str2 = M(paramClass);
    i = b.g(paramc, str2, paramString);
    if (i != -2147483648) {
      return i;
    }
    paramc = r(paramc);
    int j = C(paramc, paramInt);
    if (paramBoolean) {
      if ((com.tencent.mm.compatible.loader.a.a(t.gfr, paramClass)) || (com.tencent.mm.compatible.loader.a.a(t.gfs, paramClass))) {
        break label215;
      }
    }
    label215:
    for (i = 1;; i = 0)
    {
      if (i != 0) {
        y.i("MicroMsg.AppRuntimeApiPermissionController", "getCtrlByte, appId = %s, apiName = %s, ctrlIndex = %d, ctrlIndexLength %d, checkRet %d", new Object[] { str1, str2, Integer.valueOf(paramInt), Integer.valueOf(paramc.length), Integer.valueOf(j) });
      }
      return j;
    }
  }
  
  private AppRuntimeApiPermissionBundle anO()
  {
    synchronized (this.gWZ)
    {
      AppRuntimeApiPermissionBundle localAppRuntimeApiPermissionBundle = this.gXa;
      return localAppRuntimeApiPermissionBundle;
    }
  }
  
  public final int a(com.tencent.mm.plugin.appbrand.jsapi.c paramc, com.tencent.mm.plugin.appbrand.jsapi.b paramb, String paramString, boolean paramBoolean)
  {
    return a(paramc, paramb.getClass(), paramString, L(paramb.getClass()), paramBoolean);
  }
  
  public final d.a a(com.tencent.mm.plugin.appbrand.jsapi.c arg1, com.tencent.mm.plugin.appbrand.jsapi.b paramb, String paramString, d.b paramb1)
  {
    if ((paramb == null) || (??? == null)) {
      return d.a.anQ();
    }
    com.tencent.mm.plugin.appbrand.b.b localb = ((f)???).getRuntime().fyy.fFN.acz();
    int i = a(???, paramb, paramString, true);
    paramString = ???.getAppId();
    if (i == 6)
    {
      a.a(this.fzT, paramb);
      return d.a.anQ();
    }
    if (i == 1)
    {
      if (((??? instanceof com.tencent.mm.plugin.appbrand.o)) && (localb == com.tencent.mm.plugin.appbrand.b.b.fFK) && (com.tencent.mm.compatible.loader.a.a(t.gft, paramb.getClass()))) {
        return new d.a(-1, String.format(Locale.US, "fail: jsapi has no permission, event=%s, runningState=%s, permissionMsg=%s, detail=%s", new Object[] { paramb.getName(), localb.name().toLowerCase(), "permission ok", "network api interrupted in suspend state" }));
      }
      return d.a.anP();
    }
    if (i == 4)
    {
      if (c.bZ(paramString, paramb.getName())) {
        return d.a.anP();
      }
      c.a(paramString, paramb.getName(), new d.2(this, paramb1));
      return d.a.anT();
    }
    if (i == 7)
    {
      if (this.fzT.fyy.acx()) {
        return d.a.anP();
      }
      return new d.a(-1, String.format(Locale.US, "fail: jsapi has no permission, event=%s, runningState=%s, permissionMsg=%s, detail=%s", new Object[] { paramb.getName(), localb.name().toLowerCase(), "permission ok", "jsapi permission required playing audio but current not playing audio in background state" }));
    }
    if (i == 8)
    {
      if (paramb1 != null) {}
      synchronized (this.gWY)
      {
        this.gWY.addLast(paramb1);
        return d.a.anT();
      }
    }
    return d.a.anQ();
  }
  
  public final void a(AppRuntimeApiPermissionBundle paramAppRuntimeApiPermissionBundle)
  {
    if (paramAppRuntimeApiPermissionBundle == null) {
      return;
    }
    synchronized (this.gWZ)
    {
      this.gXa = paramAppRuntimeApiPermissionBundle;
      return;
    }
  }
  
  public final boolean a(com.tencent.mm.plugin.appbrand.jsapi.c paramc, com.tencent.mm.plugin.appbrand.jsapi.b paramb)
  {
    return a(paramc, paramb, null, null).ret == 0;
  }
  
  public final boolean a(com.tencent.mm.plugin.appbrand.jsapi.c paramc, Class<? extends com.tencent.mm.plugin.appbrand.jsapi.b> paramClass)
  {
    return a(paramc, paramClass, null, L(paramClass), true) == 1;
  }
  
  public final byte[] r(com.tencent.mm.plugin.appbrand.jsapi.c paramc)
  {
    AppRuntimeApiPermissionBundle localAppRuntimeApiPermissionBundle = anO();
    if ((paramc instanceof com.tencent.mm.plugin.appbrand.o))
    {
      switch (d.3.fGc[this.fzT.fyy.fFN.acz().ordinal()])
      {
      default: 
        return localAppRuntimeApiPermissionBundle.gWT;
      }
      return localAppRuntimeApiPermissionBundle.gWU;
    }
    return localAppRuntimeApiPermissionBundle.gWT;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.permission.d
 * JD-Core Version:    0.7.0.1
 */