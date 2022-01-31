package com.tencent.mm.plugin.appbrand.permission;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.i;
import com.tencent.mm.plugin.appbrand.jsapi.h;
import com.tencent.mm.plugin.appbrand.page.v;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.Vector;
import junit.framework.Assert;

public class e
{
  private static final HashMap<Class<? extends com.tencent.mm.plugin.appbrand.jsapi.b>, Integer> iBO;
  private static final HashMap<Class<? extends com.tencent.mm.plugin.appbrand.jsapi.b>, String> iBP;
  private static final String[] iBW;
  private final i gRG;
  private final int iBQ;
  private final boolean iBR;
  private final LinkedList<e.b> iBS;
  public final Object iBT;
  private AppRuntimeApiPermissionBundle iBU;
  public List<e.c> iBV;
  
  static
  {
    AppMethodBeat.i(102302);
    iBO = new HashMap();
    iBP = new HashMap();
    iBW = new String[] { "createSocketTask", "createDownloadTask", "createRequestTask", "createUploadTask" };
    AppMethodBeat.o(102302);
  }
  
  public e(i parami, int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(102294);
    this.iBS = new LinkedList();
    this.iBV = new ArrayList();
    this.gRG = parami;
    this.iBT = new byte[0];
    this.iBQ = paramInt;
    this.iBR = paramBoolean;
    a((AppRuntimeApiPermissionBundle)parami.U(AppRuntimeApiPermissionBundle.class));
    parami.gPL.a(new e.1(this));
    AppMethodBeat.o(102294);
  }
  
  private int a(com.tencent.mm.plugin.appbrand.jsapi.c paramc, com.tencent.mm.plugin.appbrand.jsapi.b paramb, String paramString)
  {
    AppMethodBeat.i(102285);
    int i = a(paramc, paramb, paramString, true);
    AppMethodBeat.o(102285);
    return i;
  }
  
  private int a(com.tencent.mm.plugin.appbrand.jsapi.c paramc, Class<? extends com.tencent.mm.plugin.appbrand.jsapi.b> paramClass)
  {
    AppMethodBeat.i(102287);
    int i = a(paramc, paramClass, null, ab(paramClass), true);
    AppMethodBeat.o(102287);
    return i;
  }
  
  private int a(com.tencent.mm.plugin.appbrand.jsapi.c paramc, Class<? extends com.tencent.mm.plugin.appbrand.jsapi.b> paramClass, String paramString, int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(102288);
    int i = this.iBQ;
    String str1 = paramc.getAppId();
    if (i == -1)
    {
      ab.d("MicroMsg.AppRuntimeApiPermissionController[permission]", "getCtrlByte, appId = %s, ctrlIndex = %d, hard code perm on", new Object[] { str1, Integer.valueOf(paramInt) });
      AppMethodBeat.o(102288);
      return 1;
    }
    if (i == -2)
    {
      ab.d("MicroMsg.AppRuntimeApiPermissionController[permission]", "getCtrlByte, appId = %s, ctrlIndex = %d, hard code perm off", new Object[] { str1, Integer.valueOf(paramInt) });
      AppMethodBeat.o(102288);
      return 0;
    }
    if ((paramClass.isAssignableFrom(com.tencent.mm.plugin.appbrand.jsapi.l.r.class)) && ((paramc instanceof v)))
    {
      AppMethodBeat.o(102288);
      return 1;
    }
    String str2 = ac(paramClass);
    i = c.c(paramc, str2, paramString);
    if (i != -2147483648)
    {
      AppMethodBeat.o(102288);
      return i;
    }
    paramString = B(paramc);
    int j = D(paramString, paramInt);
    if (paramBoolean)
    {
      paramc = (g)paramc.q(g.class);
      if ((paramc != null) && (paramc.ad(paramClass))) {
        break label254;
      }
    }
    label254:
    for (i = 1;; i = 0)
    {
      if (i != 0) {
        ab.i("MicroMsg.AppRuntimeApiPermissionController[permission]", "getCtrlByte, appId = %s, apiName = %s, ctrlIndex = %d, ctrlIndexLength %d, checkRet %d", new Object[] { str1, str2, Integer.valueOf(paramInt), Integer.valueOf(paramString.length), Integer.valueOf(j) });
      }
      AppMethodBeat.o(102288);
      return j;
    }
  }
  
  private void a(e.b paramb)
  {
    AppMethodBeat.i(102298);
    if (paramb == null)
    {
      AppMethodBeat.o(102298);
      return;
    }
    synchronized (this.iBS)
    {
      this.iBS.addLast(paramb);
      AppMethodBeat.o(102298);
      return;
    }
  }
  
  private AppRuntimeApiPermissionBundle aKz()
  {
    synchronized (this.iBT)
    {
      AppRuntimeApiPermissionBundle localAppRuntimeApiPermissionBundle = this.iBU;
      return localAppRuntimeApiPermissionBundle;
    }
  }
  
  private static int ab(Class<? extends com.tencent.mm.plugin.appbrand.jsapi.b> paramClass)
  {
    AppMethodBeat.i(102292);
    Integer localInteger = (Integer)iBO.get(paramClass);
    int i;
    if (localInteger != null)
    {
      i = localInteger.intValue();
      AppMethodBeat.o(102292);
      return i;
    }
    try
    {
      i = ((Integer)org.a.a.ba(paramClass).get("CTRL_INDEX")).intValue();
      iBO.put(paramClass, Integer.valueOf(i));
      AppMethodBeat.o(102292);
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
  
  private static String ac(Class<? extends com.tencent.mm.plugin.appbrand.jsapi.b> paramClass)
  {
    AppMethodBeat.i(102293);
    String str = (String)iBP.get(paramClass);
    if (!bo.isNullOrNil(str))
    {
      AppMethodBeat.o(102293);
      return str;
    }
    try
    {
      str = (String)org.a.a.ba(paramClass).get("NAME");
      iBP.put(paramClass, str);
      AppMethodBeat.o(102293);
      return str;
    }
    catch (org.a.b localb)
    {
      Assert.assertTrue("Must declare NAME in JsApi Class: " + paramClass.getName(), true);
      paramClass = paramClass.getSimpleName();
      AppMethodBeat.o(102293);
    }
    return paramClass;
  }
  
  private void b(AppRuntimeApiPermissionBundle paramAppRuntimeApiPermissionBundle)
  {
    AppMethodBeat.i(102296);
    byte[] arrayOfByte = paramAppRuntimeApiPermissionBundle.iBL;
    paramAppRuntimeApiPermissionBundle = paramAppRuntimeApiPermissionBundle.iBM;
    int i = 0;
    while (i < this.iBV.size())
    {
      ((e.c)this.iBV.get(i)).f(arrayOfByte, paramAppRuntimeApiPermissionBundle);
      i += 1;
    }
    AppMethodBeat.o(102296);
  }
  
  public final byte[] B(com.tencent.mm.plugin.appbrand.jsapi.c paramc)
  {
    AppMethodBeat.i(102289);
    int i = this.iBQ;
    if (i == -1)
    {
      AppMethodBeat.o(102289);
      return new byte[] { 1 };
    }
    if (i == -2)
    {
      AppMethodBeat.o(102289);
      return new byte[] { 0 };
    }
    AppRuntimeApiPermissionBundle localAppRuntimeApiPermissionBundle = aKz();
    if ((paramc instanceof com.tencent.mm.plugin.appbrand.r)) {
      switch (e.3.gYx[this.gRG.gPL.gYj.awr().ordinal()])
      {
      default: 
        paramc = localAppRuntimeApiPermissionBundle.iBL;
      }
    }
    for (;;)
    {
      AppMethodBeat.o(102289);
      return paramc;
      paramc = localAppRuntimeApiPermissionBundle.iBM;
      continue;
      paramc = localAppRuntimeApiPermissionBundle.iBL;
    }
  }
  
  public final int D(byte[] paramArrayOfByte, int paramInt)
  {
    int i = this.iBQ;
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
    } while (this.iBR);
    return 0;
    if ((paramInt >= paramArrayOfByte.length) || (paramInt < 0)) {
      return 0;
    }
    return paramArrayOfByte[paramInt];
  }
  
  public final int a(com.tencent.mm.plugin.appbrand.jsapi.c paramc, com.tencent.mm.plugin.appbrand.jsapi.b paramb, String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(102286);
    int i = a(paramc, paramb.getClass(), paramString, ab(paramb.getClass()), paramBoolean);
    AppMethodBeat.o(102286);
    return i;
  }
  
  public final e.a a(com.tencent.mm.plugin.appbrand.jsapi.c paramc, com.tencent.mm.plugin.appbrand.jsapi.b paramb, String paramString, final e.b paramb1)
  {
    AppMethodBeat.i(102299);
    if ((paramb == null) || (paramc == null))
    {
      paramc = e.a.aKB();
      AppMethodBeat.o(102299);
      return paramc;
    }
    com.tencent.mm.plugin.appbrand.b.b localb = this.gRG.gPL.gYj.awr();
    int i = a(paramc, paramb, paramString);
    paramString = paramc.getAppId();
    if (i == 6)
    {
      ((f)paramc.q(f.class)).Ez(paramb.getName());
      paramc = e.a.aKB();
      AppMethodBeat.o(102299);
      return paramc;
    }
    if (i == 1)
    {
      if (((paramc instanceof com.tencent.mm.plugin.appbrand.r)) && (localb == com.tencent.mm.plugin.appbrand.b.b.gYg) && (com.tencent.mm.compatible.loader.a.contains(iBW, paramb.getName())))
      {
        paramc = new e.a(-1, String.format(Locale.US, "fail: jsapi has no permission, event=%s, runningState=%s, permissionMsg=%s, detail=%s", new Object[] { paramb.getName(), localb.name().toLowerCase(), "permission ok", "network api interrupted in suspend state" }));
        AppMethodBeat.o(102299);
        return paramc;
      }
      paramc = e.a.aKA();
      AppMethodBeat.o(102299);
      return paramc;
    }
    if (i == 4)
    {
      if (d.cP(paramString, paramb.getName()))
      {
        paramc = e.a.aKA();
        AppMethodBeat.o(102299);
        return paramc;
      }
      if (d.a((h)paramc, paramb.getName()))
      {
        paramc = e.a.aKA();
        AppMethodBeat.o(102299);
        return paramc;
      }
      d.a((h)paramc, paramb.getName(), new d.c()
      {
        public final void Ec(String paramAnonymousString)
        {
          AppMethodBeat.i(102281);
          if (paramb1 != null)
          {
            if (TextUtils.isEmpty(paramAnonymousString))
            {
              paramb1.a(e.a.aKC());
              AppMethodBeat.o(102281);
              return;
            }
            paramb1.a(new e.a(-1, "fail ".concat(String.valueOf(paramAnonymousString))));
          }
          AppMethodBeat.o(102281);
        }
        
        public final void aID()
        {
          AppMethodBeat.i(102280);
          if (paramb1 != null) {
            paramb1.a(e.a.aKA());
          }
          AppMethodBeat.o(102280);
        }
        
        public final void onCancel()
        {
          AppMethodBeat.i(102282);
          if (paramb1 != null) {
            paramb1.a(e.a.aKD());
          }
          AppMethodBeat.o(102282);
        }
      });
      paramc = e.a.aKE();
      AppMethodBeat.o(102299);
      return paramc;
    }
    if (i == 7)
    {
      if (this.gRG.gPL.awp())
      {
        paramc = e.a.aKA();
        AppMethodBeat.o(102299);
        return paramc;
      }
      paramc = new e.a(-1, String.format(Locale.US, "fail: jsapi has no permission, event=%s, runningState=%s, permissionMsg=%s, detail=%s", new Object[] { paramb.getName(), localb.name().toLowerCase(), "permission ok", "jsapi permission required playing audio but current not playing audio in background state" }));
      AppMethodBeat.o(102299);
      return paramc;
    }
    if (i == 8)
    {
      a(paramb1);
      paramc = e.a.aKE();
      AppMethodBeat.o(102299);
      return paramc;
    }
    paramc = e.a.aKB();
    AppMethodBeat.o(102299);
    return paramc;
  }
  
  public final void a(AppRuntimeApiPermissionBundle paramAppRuntimeApiPermissionBundle)
  {
    AppMethodBeat.i(102295);
    if (paramAppRuntimeApiPermissionBundle == null)
    {
      AppMethodBeat.o(102295);
      return;
    }
    synchronized (this.iBT)
    {
      AppRuntimeApiPermissionBundle localAppRuntimeApiPermissionBundle = this.iBU;
      this.iBU = paramAppRuntimeApiPermissionBundle;
      b(this.iBU);
      ab.i("MicroMsg.AppRuntimeApiPermissionController[permission]", "updatePermission old %s, updated %s", new Object[] { localAppRuntimeApiPermissionBundle, paramAppRuntimeApiPermissionBundle });
      AppMethodBeat.o(102295);
      return;
    }
  }
  
  public final boolean a(com.tencent.mm.plugin.appbrand.jsapi.c paramc, com.tencent.mm.plugin.appbrand.jsapi.b paramb)
  {
    AppMethodBeat.i(102291);
    if (a(paramc, paramb, null, null).ret == 0)
    {
      AppMethodBeat.o(102291);
      return true;
    }
    AppMethodBeat.o(102291);
    return false;
  }
  
  public final Vector<byte[]> aKy()
  {
    AppMethodBeat.i(102297);
    synchronized (this.iBT)
    {
      if (this.iBU == null)
      {
        AppMethodBeat.o(102297);
        return null;
      }
      byte[] arrayOfByte1 = this.iBU.iBL;
      byte[] arrayOfByte2 = this.iBU.iBM;
      byte[] arrayOfByte3 = this.iBU.iBN;
      ??? = new Vector(3);
      ((Vector)???).addElement(arrayOfByte1);
      ((Vector)???).addElement(arrayOfByte2);
      ((Vector)???).addElement(arrayOfByte3);
      AppMethodBeat.o(102297);
      return ???;
    }
  }
  
  @Deprecated
  public final boolean b(com.tencent.mm.plugin.appbrand.jsapi.c paramc, Class<? extends com.tencent.mm.plugin.appbrand.jsapi.b> paramClass)
  {
    AppMethodBeat.i(102290);
    if (a(paramc, paramClass) == 1)
    {
      AppMethodBeat.o(102290);
      return true;
    }
    AppMethodBeat.o(102290);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.permission.e
 * JD-Core Version:    0.7.0.1
 */