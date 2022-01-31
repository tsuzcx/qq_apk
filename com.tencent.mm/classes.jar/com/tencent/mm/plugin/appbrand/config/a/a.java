package com.tencent.mm.plugin.appbrand.config.a;

import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.database.ContentObserver;
import android.provider.Settings.System;
import android.util.SparseArray;
import android.view.Display;
import android.view.WindowManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfig;
import com.tencent.mm.plugin.appbrand.i;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class a
{
  public static final SparseArray<a> hks;
  private b hkA;
  public a.d hkt;
  public a.d hku;
  private WeakReference<Activity> hkv;
  public ContentObserver hkw;
  public a.b hkx;
  private boolean hky;
  public int hkz;
  public boolean mFinished;
  
  static
  {
    AppMethodBeat.i(86929);
    hks = new SparseArray();
    AppMethodBeat.o(86929);
  }
  
  private a(Activity paramActivity)
  {
    AppMethodBeat.i(86913);
    this.mFinished = false;
    this.hkw = null;
    this.hkx = null;
    this.hkA = null;
    ab.i("MicroMsg.AppBrandDeviceOrientationHandler", "AppBrandDeviceOrientationHandler construct");
    this.hkz = paramActivity.getResources().getConfiguration().orientation;
    this.hkv = new WeakReference(paramActivity);
    this.hky = ayK();
    paramActivity.setRequestedOrientation(dQ(this.hky).hkJ);
    AppMethodBeat.o(86913);
  }
  
  public static a.b a(com.tencent.mm.plugin.appbrand.config.a parama, com.tencent.mm.plugin.appbrand.config.a.d paramd)
  {
    AppMethodBeat.i(86924);
    a.b localb = null;
    if (paramd != null) {
      localb = com.tencent.mm.plugin.appbrand.config.a.d.zX(paramd.hhw);
    }
    paramd = localb;
    if (localb == null)
    {
      paramd = localb;
      if (parama != null) {
        paramd = zX(parama.hgQ.hha);
      }
    }
    parama = paramd;
    if (paramd == null) {
      parama = a.b.hkD;
    }
    AppMethodBeat.o(86924);
    return parama;
  }
  
  private static void a(a.a parama, a.b paramb, boolean paramBoolean)
  {
    AppMethodBeat.i(86921);
    if (parama == null)
    {
      AppMethodBeat.o(86921);
      return;
    }
    parama.a(paramb, paramBoolean);
    AppMethodBeat.o(86921);
  }
  
  private void a(a.b paramb, List<a.c> paramList)
  {
    AppMethodBeat.i(86919);
    if (paramb == this.hku.hkM)
    {
      if (this.hku.hkL != null) {
        paramList.add(new a.c(this.hku.hkL, paramb, true, "PendingRequest.Listener orientation equal direct", (byte)0));
      }
      this.hku = null;
      AppMethodBeat.o(86919);
      return;
    }
    if ((Activity)this.hkv.get() == null)
    {
      ab.e("MicroMsg.AppBrandDeviceOrientationHandler", "No Activity when handle pending request");
      if (this.hku.hkL != null) {
        paramList.add(new a.c(this.hku.hkL, paramb, false, "PendingRequest.Listener activity == null", (byte)0));
      }
      AppMethodBeat.o(86919);
      return;
    }
    this.hkt = this.hku;
    this.hku = null;
    a(this.hkt);
    AppMethodBeat.o(86919);
  }
  
  private void a(a.d paramd)
  {
    AppMethodBeat.i(86916);
    ab.i("MicroMsg.AppBrandDeviceOrientationHandler", "AppBrandDeviceOrientationConfig.requestDeviceOrientationImpl setRequestOrientation [%s]", new Object[] { paramd });
    Activity localActivity = (Activity)this.hkv.get();
    if (localActivity == null)
    {
      ab.w("MicroMsg.AppBrandDeviceOrientationHandler", "hy: ui already released!");
      if (paramd.hkL != null) {
        paramd.hkL.a(paramd.hkM, false);
      }
      AppMethodBeat.o(86916);
      return;
    }
    localActivity.setRequestedOrientation(paramd.hkM.hkJ);
    this.hky = ayK();
    if (b(paramd))
    {
      a(paramd.hkM);
      AppMethodBeat.o(86916);
      return;
    }
    if (this.hkA == null) {
      this.hkA = new b();
    }
    this.hkA.a(new a.2(this, paramd, localActivity));
    AppMethodBeat.o(86916);
  }
  
  public static boolean ayK()
  {
    AppMethodBeat.i(86915);
    int i = Settings.System.getInt(ah.getContext().getContentResolver(), "accelerometer_rotation", 0);
    ab.i("MicroMsg.AppBrandDeviceOrientationHandler", "hy: systenm orientation %d", new Object[] { Integer.valueOf(i) });
    if (i == 1)
    {
      AppMethodBeat.o(86915);
      return false;
    }
    AppMethodBeat.o(86915);
    return true;
  }
  
  private boolean b(a.d paramd)
  {
    AppMethodBeat.i(86917);
    ab.i("MicroMsg.AppBrandDeviceOrientationHandler", "current orientation=" + this.hkz + "  request orientation=" + paramd.hkM);
    if ((this.hkz == 2) && ((paramd.hkM.c(a.b.hkF)) || (paramd.hkM.c(a.b.hkH)) || (paramd.hkM.c(a.b.hkI))))
    {
      ab.d("MicroMsg.AppBrandDeviceOrientationHandler", "hy: same landscape");
      AppMethodBeat.o(86917);
      return true;
    }
    if ((this.hkz == 1) && (paramd.hkM.c(a.b.hkD)))
    {
      ab.d("MicroMsg.AppBrandDeviceOrientationHandler", "hy: same portrait");
      AppMethodBeat.o(86917);
      return true;
    }
    if (this.hkz == 0)
    {
      ab.d("MicroMsg.AppBrandDeviceOrientationHandler", "hy: former is undefined, always return immediately");
      AppMethodBeat.o(86917);
      return true;
    }
    if (paramd.hkM == a.b.hkE)
    {
      ab.d("MicroMsg.AppBrandDeviceOrientationHandler", "hy: request is UNSPECIFIED, return true");
      AppMethodBeat.o(86917);
      return true;
    }
    AppMethodBeat.o(86917);
    return false;
  }
  
  public static a.b j(AppBrandInitConfig paramAppBrandInitConfig)
  {
    AppMethodBeat.i(86923);
    a.b localb = null;
    if (paramAppBrandInitConfig != null) {
      localb = zX(paramAppBrandInitConfig.hha);
    }
    paramAppBrandInitConfig = localb;
    if (localb == null) {
      paramAppBrandInitConfig = a.b.hkD;
    }
    AppMethodBeat.o(86923);
    return paramAppBrandInitConfig;
  }
  
  public static a s(Activity paramActivity)
  {
    AppMethodBeat.i(86912);
    synchronized (hks)
    {
      a locala2 = (a)hks.get(paramActivity.hashCode());
      a locala1 = locala2;
      if (locala2 == null)
      {
        locala1 = new a(paramActivity);
        hks.put(paramActivity.hashCode(), locala1);
      }
      AppMethodBeat.o(86912);
      return locala1;
    }
  }
  
  public static boolean t(i parami)
  {
    AppMethodBeat.i(86925);
    boolean bool1;
    switch (((WindowManager)ah.getContext().getSystemService("window")).getDefaultDisplay().getRotation())
    {
    default: 
      bool1 = true;
      if (a(parami.getAppConfig(), null) != a.b.hkD) {
        break;
      }
    }
    for (boolean bool2 = true;; bool2 = false)
    {
      ab.i("MicroMsg.AppBrandDeviceOrientationHandler", "[alex] isCurrentPortrait %b, isGameShouldPortrait %b", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool2) });
      if (bool1 != bool2) {
        break label138;
      }
      AppMethodBeat.o(86925);
      return true;
      bool1 = true;
      break;
      bool1 = false;
      break;
      bool1 = true;
      break;
      bool1 = false;
      break;
    }
    label138:
    AppMethodBeat.o(86925);
    return false;
  }
  
  public static a.b zX(String paramString)
  {
    AppMethodBeat.i(86922);
    if ("landscape".equals(paramString))
    {
      paramString = a.b.hkF;
      AppMethodBeat.o(86922);
      return paramString;
    }
    if ("portrait".equals(paramString))
    {
      paramString = a.b.hkD;
      AppMethodBeat.o(86922);
      return paramString;
    }
    if ("landscapeLeft".equals(paramString))
    {
      paramString = a.b.hkH;
      AppMethodBeat.o(86922);
      return paramString;
    }
    if ("landscapeRight".equals(paramString))
    {
      paramString = a.b.hkI;
      AppMethodBeat.o(86922);
      return paramString;
    }
    if ("auto".equals(paramString))
    {
      paramString = a.b.hkE;
      AppMethodBeat.o(86922);
      return paramString;
    }
    AppMethodBeat.o(86922);
    return null;
  }
  
  public final a.b G(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(86926);
    a.b localb;
    if (paramInt == 2)
    {
      ab.d("MicroMsg.AppBrandDeviceOrientationHandler", "parseConfiguration configuration == landscape ");
      if (paramBoolean)
      {
        ab.d("MicroMsg.AppBrandDeviceOrientationHandler", "hy: parseConfiguration configuration == landscape but screen locked");
        localb = a.b.hkG;
        AppMethodBeat.o(86926);
        return localb;
      }
      if (this.hkx == a.b.hkH)
      {
        localb = a.b.hkH;
        AppMethodBeat.o(86926);
        return localb;
      }
      if (this.hkx == a.b.hkI)
      {
        localb = a.b.hkI;
        AppMethodBeat.o(86926);
        return localb;
      }
      localb = a.b.hkF;
      AppMethodBeat.o(86926);
      return localb;
    }
    if (paramInt == 1)
    {
      ab.d("MicroMsg.AppBrandDeviceOrientationHandler", "parseConfiguration configuration == portrait ");
      localb = a.b.hkD;
      AppMethodBeat.o(86926);
      return localb;
    }
    ab.i("MicroMsg.AppBrandDeviceOrientationHandler", "parseConfiguration configuration == %d", new Object[] { Integer.valueOf(paramInt) });
    AppMethodBeat.o(86926);
    return null;
  }
  
  public final void a(a.b paramb)
  {
    boolean bool3 = false;
    AppMethodBeat.i(86918);
    Object localObject1 = (Activity)this.hkv.get();
    Object localObject2;
    boolean bool1;
    if ((localObject1 == null) || (paramb == null))
    {
      localObject2 = new RuntimeException();
      if (localObject1 != null) {
        break label115;
      }
      bool1 = true;
    }
    for (;;)
    {
      boolean bool2;
      if (paramb == null)
      {
        bool2 = true;
        label52:
        ab.printErrStackTrace("MicroMsg.AppBrandDeviceOrientationHandler", (Throwable)localObject2, "onConfigurationChanged activity[isNull ? %b] newConfig[isNull ? %b]", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool2) });
        localObject2 = new LinkedList();
      }
      try
      {
        if (this.mFinished)
        {
          ab.i("MicroMsg.AppBrandDeviceOrientationHandler", "onConfigurationChanged Finished = true");
          return;
          label115:
          bool1 = false;
          continue;
          bool2 = false;
          break label52;
        }
        else
        {
          if (this.hkt == null)
          {
            ab.d("MicroMsg.AppBrandDeviceOrientationHandler", "No current request..., dismiss");
            return;
          }
          if (paramb == null) {}
          for (localObject1 = "null";; localObject1 = paramb.name())
          {
            ab.i("MicroMsg.AppBrandDeviceOrientationHandler", "AppBrandDeviceOrientationConfig.onConfigurationChanged [%s]", new Object[] { localObject1 });
            if (this.hkt.hkL != null)
            {
              localObject1 = this.hkt.hkL;
              bool1 = bool3;
              if (paramb != null)
              {
                bool1 = bool3;
                if (paramb.c(this.hkt.hkM)) {
                  bool1 = true;
                }
              }
              ((List)localObject2).add(new a.c((a.a)localObject1, paramb, bool1, "CurrentRequest.listener result received", (byte)0));
            }
            this.hkt = null;
            if (this.hku != null) {
              a(paramb, (List)localObject2);
            }
            paramb = ((List)localObject2).iterator();
            while (paramb.hasNext()) {
              ((a.c)paramb.next()).execute();
            }
          }
          AppMethodBeat.o(86918);
        }
      }
      finally
      {
        AppMethodBeat.o(86918);
      }
    }
  }
  
  /* Error */
  public final void a(a.b paramb, a.a parama)
  {
    // Byte code:
    //   0: ldc_w 435
    //   3: invokestatic 41	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_0
    //   7: getfield 98	com/tencent/mm/plugin/appbrand/config/a/a:hkv	Ljava/lang/ref/WeakReference;
    //   10: invokevirtual 174	java/lang/ref/WeakReference:get	()Ljava/lang/Object;
    //   13: checkcast 74	android/app/Activity
    //   16: astore 4
    //   18: aload_0
    //   19: aload_0
    //   20: getfield 104	com/tencent/mm/plugin/appbrand/config/a/a:hky	Z
    //   23: invokevirtual 108	com/tencent/mm/plugin/appbrand/config/a/a:dQ	(Z)Lcom/tencent/mm/plugin/appbrand/config/a/a$b;
    //   26: astore 6
    //   28: ldc 65
    //   30: ldc_w 437
    //   33: iconst_4
    //   34: anewarray 4	java/lang/Object
    //   37: dup
    //   38: iconst_0
    //   39: aload_1
    //   40: aastore
    //   41: dup
    //   42: iconst_1
    //   43: aload_2
    //   44: aastore
    //   45: dup
    //   46: iconst_2
    //   47: aload 6
    //   49: aastore
    //   50: dup
    //   51: iconst_3
    //   52: aload_0
    //   53: getfield 61	com/tencent/mm/plugin/appbrand/config/a/a:hkx	Lcom/tencent/mm/plugin/appbrand/config/a/a$b;
    //   56: aastore
    //   57: invokestatic 439	com/tencent/mm/sdk/platformtools/ab:b	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   60: aload 4
    //   62: ifnonnull +41 -> 103
    //   65: ldc 65
    //   67: new 393	java/lang/RuntimeException
    //   70: dup
    //   71: invokespecial 394	java/lang/RuntimeException:<init>	()V
    //   74: ldc_w 441
    //   77: iconst_0
    //   78: anewarray 4	java/lang/Object
    //   81: invokestatic 400	com/tencent/mm/sdk/platformtools/ab:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   84: aload_2
    //   85: aload 6
    //   87: iconst_0
    //   88: invokestatic 443	com/tencent/mm/plugin/appbrand/config/a/a:a	(Lcom/tencent/mm/plugin/appbrand/config/a/a$a;Lcom/tencent/mm/plugin/appbrand/config/a/a$b;Z)V
    //   91: aload_0
    //   92: aload_1
    //   93: putfield 61	com/tencent/mm/plugin/appbrand/config/a/a:hkx	Lcom/tencent/mm/plugin/appbrand/config/a/a$b;
    //   96: ldc_w 435
    //   99: invokestatic 51	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   102: return
    //   103: aload_1
    //   104: ifnonnull +30 -> 134
    //   107: ldc 65
    //   109: ldc_w 445
    //   112: invokestatic 199	com/tencent/mm/sdk/platformtools/ab:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   115: aload_2
    //   116: aload 6
    //   118: iconst_0
    //   119: invokestatic 443	com/tencent/mm/plugin/appbrand/config/a/a:a	(Lcom/tencent/mm/plugin/appbrand/config/a/a$a;Lcom/tencent/mm/plugin/appbrand/config/a/a$b;Z)V
    //   122: aload_0
    //   123: aload_1
    //   124: putfield 61	com/tencent/mm/plugin/appbrand/config/a/a:hkx	Lcom/tencent/mm/plugin/appbrand/config/a/a$b;
    //   127: ldc_w 435
    //   130: invokestatic 51	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   133: return
    //   134: getstatic 450	android/os/Build$VERSION:SDK_INT	I
    //   137: bipush 24
    //   139: if_icmplt +81 -> 220
    //   142: aload 4
    //   144: invokevirtual 453	android/app/Activity:isInMultiWindowMode	()Z
    //   147: ifeq +73 -> 220
    //   150: ldc 65
    //   152: ldc_w 455
    //   155: iconst_2
    //   156: anewarray 4	java/lang/Object
    //   159: dup
    //   160: iconst_0
    //   161: aload 4
    //   163: invokevirtual 458	android/app/Activity:getLocalClassName	()Ljava/lang/String;
    //   166: aastore
    //   167: dup
    //   168: iconst_1
    //   169: aload_1
    //   170: aastore
    //   171: invokestatic 194	com/tencent/mm/sdk/platformtools/ab:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   174: aload_0
    //   175: invokevirtual 461	com/tencent/mm/plugin/appbrand/config/a/a:ayL	()V
    //   178: aload 4
    //   180: aload_1
    //   181: getfield 111	com/tencent/mm/plugin/appbrand/config/a/a$b:hkJ	I
    //   184: invokevirtual 114	android/app/Activity:setRequestedOrientation	(I)V
    //   187: aload_2
    //   188: ifnull +20 -> 208
    //   191: aload 6
    //   193: aload_1
    //   194: if_acmpne +21 -> 215
    //   197: iconst_1
    //   198: istore_3
    //   199: aload_2
    //   200: aload 6
    //   202: iload_3
    //   203: invokeinterface 148 3 0
    //   208: ldc_w 435
    //   211: invokestatic 51	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   214: return
    //   215: iconst_0
    //   216: istore_3
    //   217: goto -18 -> 199
    //   220: aload_1
    //   221: aload 6
    //   223: if_acmpne +60 -> 283
    //   226: aload_0
    //   227: getfield 61	com/tencent/mm/plugin/appbrand/config/a/a:hkx	Lcom/tencent/mm/plugin/appbrand/config/a/a$b;
    //   230: getstatic 251	com/tencent/mm/plugin/appbrand/config/a/a$b:hkE	Lcom/tencent/mm/plugin/appbrand/config/a/a$b;
    //   233: if_acmpeq +50 -> 283
    //   236: ldc 65
    //   238: ldc_w 463
    //   241: iconst_1
    //   242: anewarray 4	java/lang/Object
    //   245: dup
    //   246: iconst_0
    //   247: aload_1
    //   248: aastore
    //   249: invokestatic 194	com/tencent/mm/sdk/platformtools/ab:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   252: aload_2
    //   253: aload_1
    //   254: iconst_1
    //   255: invokestatic 443	com/tencent/mm/plugin/appbrand/config/a/a:a	(Lcom/tencent/mm/plugin/appbrand/config/a/a$a;Lcom/tencent/mm/plugin/appbrand/config/a/a$b;Z)V
    //   258: aload_0
    //   259: aload_1
    //   260: putfield 61	com/tencent/mm/plugin/appbrand/config/a/a:hkx	Lcom/tencent/mm/plugin/appbrand/config/a/a$b;
    //   263: aload_0
    //   264: invokevirtual 461	com/tencent/mm/plugin/appbrand/config/a/a:ayL	()V
    //   267: aload 4
    //   269: aload_1
    //   270: getfield 111	com/tencent/mm/plugin/appbrand/config/a/a$b:hkJ	I
    //   273: invokevirtual 114	android/app/Activity:setRequestedOrientation	(I)V
    //   276: ldc_w 435
    //   279: invokestatic 51	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   282: return
    //   283: aconst_null
    //   284: astore 5
    //   286: aconst_null
    //   287: astore 4
    //   289: aload_0
    //   290: monitorenter
    //   291: aload_0
    //   292: getfield 57	com/tencent/mm/plugin/appbrand/config/a/a:mFinished	Z
    //   295: ifeq +25 -> 320
    //   298: ldc 65
    //   300: ldc_w 465
    //   303: invokestatic 72	com/tencent/mm/sdk/platformtools/ab:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   306: aload_0
    //   307: aload_1
    //   308: putfield 61	com/tencent/mm/plugin/appbrand/config/a/a:hkx	Lcom/tencent/mm/plugin/appbrand/config/a/a$b;
    //   311: aload_0
    //   312: monitorexit
    //   313: ldc_w 435
    //   316: invokestatic 51	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   319: return
    //   320: aload_0
    //   321: getfield 183	com/tencent/mm/plugin/appbrand/config/a/a:hkt	Lcom/tencent/mm/plugin/appbrand/config/a/a$d;
    //   324: ifnonnull +64 -> 388
    //   327: aload_0
    //   328: new 12	com/tencent/mm/plugin/appbrand/config/a/a$d
    //   331: dup
    //   332: aload_0
    //   333: aload_1
    //   334: aload_2
    //   335: iconst_0
    //   336: invokespecial 468	com/tencent/mm/plugin/appbrand/config/a/a$d:<init>	(Lcom/tencent/mm/plugin/appbrand/config/a/a;Lcom/tencent/mm/plugin/appbrand/config/a/a$b;Lcom/tencent/mm/plugin/appbrand/config/a/a$a;B)V
    //   339: putfield 183	com/tencent/mm/plugin/appbrand/config/a/a:hkt	Lcom/tencent/mm/plugin/appbrand/config/a/a$d;
    //   342: aload_0
    //   343: aload_0
    //   344: getfield 183	com/tencent/mm/plugin/appbrand/config/a/a:hkt	Lcom/tencent/mm/plugin/appbrand/config/a/a$d;
    //   347: invokespecial 186	com/tencent/mm/plugin/appbrand/config/a/a:a	(Lcom/tencent/mm/plugin/appbrand/config/a/a$d;)V
    //   350: aload_0
    //   351: monitorexit
    //   352: aload 4
    //   354: ifnull +22 -> 376
    //   357: ldc 65
    //   359: ldc_w 470
    //   362: invokestatic 72	com/tencent/mm/sdk/platformtools/ab:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   365: aload 4
    //   367: getfield 159	com/tencent/mm/plugin/appbrand/config/a/a$d:hkL	Lcom/tencent/mm/plugin/appbrand/config/a/a$a;
    //   370: aload 6
    //   372: iconst_0
    //   373: invokestatic 443	com/tencent/mm/plugin/appbrand/config/a/a:a	(Lcom/tencent/mm/plugin/appbrand/config/a/a$a;Lcom/tencent/mm/plugin/appbrand/config/a/a$b;Z)V
    //   376: aload_0
    //   377: aload_1
    //   378: putfield 61	com/tencent/mm/plugin/appbrand/config/a/a:hkx	Lcom/tencent/mm/plugin/appbrand/config/a/a$b;
    //   381: ldc_w 435
    //   384: invokestatic 51	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   387: return
    //   388: aload 5
    //   390: astore 4
    //   392: aload_0
    //   393: getfield 152	com/tencent/mm/plugin/appbrand/config/a/a:hku	Lcom/tencent/mm/plugin/appbrand/config/a/a$d;
    //   396: ifnull +9 -> 405
    //   399: aload_0
    //   400: getfield 152	com/tencent/mm/plugin/appbrand/config/a/a:hku	Lcom/tencent/mm/plugin/appbrand/config/a/a$d;
    //   403: astore 4
    //   405: aload_0
    //   406: new 12	com/tencent/mm/plugin/appbrand/config/a/a$d
    //   409: dup
    //   410: aload_0
    //   411: aload_1
    //   412: aload_2
    //   413: iconst_0
    //   414: invokespecial 468	com/tencent/mm/plugin/appbrand/config/a/a$d:<init>	(Lcom/tencent/mm/plugin/appbrand/config/a/a;Lcom/tencent/mm/plugin/appbrand/config/a/a$b;Lcom/tencent/mm/plugin/appbrand/config/a/a$a;B)V
    //   417: putfield 152	com/tencent/mm/plugin/appbrand/config/a/a:hku	Lcom/tencent/mm/plugin/appbrand/config/a/a$d;
    //   420: goto -70 -> 350
    //   423: astore_1
    //   424: aload_0
    //   425: monitorexit
    //   426: ldc_w 435
    //   429: invokestatic 51	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   432: aload_1
    //   433: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	434	0	this	a
    //   0	434	1	paramb	a.b
    //   0	434	2	parama	a.a
    //   198	19	3	bool	boolean
    //   16	388	4	localObject1	Object
    //   284	105	5	localObject2	Object
    //   26	345	6	localb	a.b
    // Exception table:
    //   from	to	target	type
    //   291	313	423	finally
    //   320	350	423	finally
    //   350	352	423	finally
    //   392	405	423	finally
    //   405	420	423	finally
    //   424	426	423	finally
  }
  
  public final void ayL()
  {
    AppMethodBeat.i(141652);
    if (this.hkA != null)
    {
      this.hkA.ayO();
      this.hkA = null;
    }
    AppMethodBeat.o(141652);
  }
  
  public final a.b dQ(boolean paramBoolean)
  {
    AppMethodBeat.i(86920);
    ab.i("MicroMsg.AppBrandDeviceOrientationHandler", "getCurrentOrientation");
    a.b localb = G(this.hkz, paramBoolean);
    AppMethodBeat.o(86920);
    return localb;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.config.a.a
 * JD-Core Version:    0.7.0.1
 */