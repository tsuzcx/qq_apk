package com.tencent.luggage.sdk.b.a.e;

import com.tencent.mars.smc.IDKey;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.libwxaudio.WxAudioNative;
import com.tencent.mm.libwxaudio.WxAudioNative.NativeAudioPcmCallback;
import com.tencent.mm.libwxaudio.WxAudioNative.NativeCallBackInterface;
import com.tencent.mm.plugin.appbrand.af.n;
import com.tencent.mm.plugin.appbrand.appstorage.w;
import com.tencent.mm.plugin.appbrand.jsapi.f;
import com.tencent.mm.plugin.appbrand.k;
import com.tencent.mm.plugin.appbrand.k.c;
import com.tencent.mm.plugin.appbrand.k.d;
import com.tencent.mm.plugin.appbrand.media.a.g;
import com.tencent.mm.plugin.appbrand.n.m;
import com.tencent.mm.plugin.appbrand.n.m.a;
import com.tencent.mm.plugin.appbrand.n.q;
import com.tencent.mm.plugin.appbrand.n.v;
import com.tencent.mm.plugin.music.b.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.vfs.ah;
import com.tencent.mm.vfs.u;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Vector;

public class b
{
  private static Vector<String> etb;
  private boolean eqZ;
  protected WxAudioNative esZ;
  private boolean eta;
  private boolean etc;
  private boolean etd;
  private a ete;
  private final a etf;
  private com.tencent.mm.plugin.music.b.a.a etg;
  private WxAudioNative.NativeAudioPcmCallback eth;
  
  static
  {
    AppMethodBeat.i(220441);
    etb = new Vector();
    AppMethodBeat.o(220441);
  }
  
  public b()
  {
    AppMethodBeat.i(220361);
    this.eqZ = true;
    this.eta = false;
    this.etc = false;
    this.etd = false;
    this.ete = null;
    this.etf = new a(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(220347);
        synchronized (b.this)
        {
          if (b.this.esZ != null)
          {
            Log.i("Luggage.WxAudioNativeInstallHelper", "DestroyTask destroy wxAudioNative");
            b.this.esZ.destroyWebAudioContext();
            b.this.esZ = null;
            AppMethodBeat.o(220347);
            return;
          }
          Log.i("Luggage.WxAudioNativeInstallHelper", "DestroyTask wxAudioNative is null");
        }
      }
    });
    this.etg = new com.tencent.mm.plugin.music.b.a.a(3, "wx_webaudio_mix_audio_buffer");
    this.eth = new WxAudioNative.NativeAudioPcmCallback()
    {
      public final void onPcmCallback(byte[] paramAnonymousArrayOfByte, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3, int paramAnonymousInt4)
      {
        AppMethodBeat.i(220343);
        if (b.c(b.this) != null)
        {
          if (!b.d(b.this))
          {
            b.c(b.this).a(b.e(b.this));
            b.f(b.this);
          }
          b.c(b.this).a(b.e(b.this), paramAnonymousInt2, paramAnonymousInt3, paramAnonymousArrayOfByte);
        }
        AppMethodBeat.o(220343);
      }
    };
    AppMethodBeat.o(220361);
  }
  
  private boolean b(f paramf)
  {
    AppMethodBeat.i(220369);
    paramf = (b)paramf.T(b.class);
    if (paramf != null) {}
    for (boolean bool = paramf.arS();; bool = false)
    {
      Log.i("Luggage.WxAudioNativeInstallHelper", "isSupportWebAudio:%b ", new Object[] { Boolean.valueOf(bool) });
      this.eta = bool;
      AppMethodBeat.o(220369);
      return bool;
    }
  }
  
  private static void h(ArrayList<IDKey> paramArrayList)
  {
    AppMethodBeat.i(220382);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("idkeyGroupStat:  id:1702");
    paramArrayList = paramArrayList.iterator();
    while (paramArrayList.hasNext())
    {
      IDKey localIDKey = (IDKey)paramArrayList.next();
      localStringBuilder.append(", key:" + localIDKey.GetKey() + " value:" + localIDKey.GetValue());
    }
    Log.d("Luggage.WxAudioNativeInstallHelper", localStringBuilder.toString());
    AppMethodBeat.o(220382);
  }
  
  public final void a(a parama)
  {
    AppMethodBeat.i(220496);
    this.ete = parama;
    if (!this.eta)
    {
      Log.e("Luggage.WxAudioNativeInstallHelper", "listenLifeCycle now is not support webaudio");
      AppMethodBeat.o(220496);
      return;
    }
    if (!this.etc)
    {
      Log.e("Luggage.WxAudioNativeInstallHelper", "listenLifeCycle so load fail ");
      AppMethodBeat.o(220496);
      return;
    }
    if ((this.esZ != null) && (parama != null)) {
      this.esZ.registerAudioPcmCallback(this.eth);
    }
    this.etd = false;
    AppMethodBeat.o(220496);
  }
  
  public final void arQ()
  {
    AppMethodBeat.i(220503);
    this.ete = null;
    if (!this.eta)
    {
      Log.e("Luggage.WxAudioNativeInstallHelper", "listenLifeCycle now is not support webaudio");
      AppMethodBeat.o(220503);
      return;
    }
    if (!this.etc)
    {
      Log.e("Luggage.WxAudioNativeInstallHelper", "listenLifeCycle so load fail ");
      AppMethodBeat.o(220503);
      return;
    }
    if (this.esZ != null) {
      this.esZ.unregisterAudioPcmCallback();
    }
    AppMethodBeat.o(220503);
  }
  
  public final void c(final f paramf)
  {
    AppMethodBeat.i(220481);
    if (!this.eta)
    {
      Log.e("Luggage.WxAudioNativeInstallHelper", "listenLifeCycle now is not support webaudio");
      AppMethodBeat.o(220481);
      return;
    }
    if (!this.etc)
    {
      Log.e("Luggage.WxAudioNativeInstallHelper", "listenLifeCycle so load fail ");
      AppMethodBeat.o(220481);
      return;
    }
    paramf = paramf.getAppId();
    k.c local5 = new k.c()
    {
      public final void a(k.d paramAnonymousd)
      {
        AppMethodBeat.i(220353);
        Log.i("Luggage.WxAudioNativeInstallHelper", "onPause, appId:%s", new Object[] { paramf });
        if (b.this.esZ != null) {
          b.this.esZ.forcePauseAllPlayer();
        }
        com.tencent.mm.plugin.music.b.i.glV().cyG();
        AppMethodBeat.o(220353);
      }
      
      public final void onCreate()
      {
        AppMethodBeat.i(220349);
        Log.i("Luggage.WxAudioNativeInstallHelper", "onCreate, appId:%s", new Object[] { paramf });
        com.tencent.mm.plugin.music.b.i.glV().gmc();
        AppMethodBeat.o(220349);
      }
      
      public final void onDestroy()
      {
        AppMethodBeat.i(220356);
        Log.i("Luggage.WxAudioNativeInstallHelper", "onDestroy, appId:%s", new Object[] { paramf });
        b.arR().remove(paramf);
        com.tencent.mm.plugin.music.b.i.glV().cyG();
        b.this.arQ();
        AppMethodBeat.o(220356);
      }
      
      public final void onResume()
      {
        AppMethodBeat.i(220351);
        Log.i("Luggage.WxAudioNativeInstallHelper", "onResume, appId:%s", new Object[] { paramf });
        com.tencent.mm.plugin.music.b.i.glV().gmc();
        AppMethodBeat.o(220351);
      }
    };
    Log.i("Luggage.WxAudioNativeInstallHelper", "listenLifeCycle appId:%s", new Object[] { paramf });
    if (!etb.contains(paramf))
    {
      k.a(paramf, local5);
      etb.add(paramf);
    }
    AppMethodBeat.o(220481);
  }
  
  /* Error */
  public final void c(final com.tencent.mm.plugin.appbrand.n.i parami, final f paramf)
  {
    // Byte code:
    //   0: ldc 234
    //   2: invokestatic 51	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: ldc 111
    //   7: ldc 236
    //   9: invokestatic 238	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   12: aload_1
    //   13: ifnonnull +16 -> 29
    //   16: ldc 111
    //   18: ldc 240
    //   20: invokestatic 191	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   23: ldc 234
    //   25: invokestatic 61	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   28: return
    //   29: aload_0
    //   30: aload_2
    //   31: invokespecial 242	com/tencent/luggage/sdk/b/a/e/b:b	(Lcom/tencent/mm/plugin/appbrand/jsapi/f;)Z
    //   34: ifne +16 -> 50
    //   37: ldc 111
    //   39: ldc 244
    //   41: invokestatic 191	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   44: ldc 234
    //   46: invokestatic 61	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   49: return
    //   50: new 144	java/util/ArrayList
    //   53: dup
    //   54: invokespecial 245	java/util/ArrayList:<init>	()V
    //   57: astore_3
    //   58: new 159	com/tencent/mars/smc/IDKey
    //   61: dup
    //   62: invokespecial 246	com/tencent/mars/smc/IDKey:<init>	()V
    //   65: astore 4
    //   67: aload 4
    //   69: sipush 1702
    //   72: invokevirtual 249	com/tencent/mars/smc/IDKey:SetID	(I)V
    //   75: aload 4
    //   77: iconst_0
    //   78: invokevirtual 252	com/tencent/mars/smc/IDKey:SetKey	(I)V
    //   81: aload 4
    //   83: lconst_1
    //   84: invokevirtual 256	com/tencent/mars/smc/IDKey:SetValue	(J)V
    //   87: aload_3
    //   88: aload 4
    //   90: invokevirtual 257	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   93: pop
    //   94: new 159	com/tencent/mars/smc/IDKey
    //   97: dup
    //   98: invokespecial 246	com/tencent/mars/smc/IDKey:<init>	()V
    //   101: astore 4
    //   103: aload 4
    //   105: sipush 1702
    //   108: invokevirtual 249	com/tencent/mars/smc/IDKey:SetID	(I)V
    //   111: aload 4
    //   113: lconst_1
    //   114: invokevirtual 256	com/tencent/mars/smc/IDKey:SetValue	(J)V
    //   117: aload_3
    //   118: aload 4
    //   120: invokevirtual 257	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   123: pop
    //   124: new 159	com/tencent/mars/smc/IDKey
    //   127: dup
    //   128: invokespecial 246	com/tencent/mars/smc/IDKey:<init>	()V
    //   131: astore 5
    //   133: aload 5
    //   135: sipush 1702
    //   138: invokevirtual 249	com/tencent/mars/smc/IDKey:SetID	(I)V
    //   141: aload 5
    //   143: lconst_1
    //   144: invokevirtual 256	com/tencent/mars/smc/IDKey:SetValue	(J)V
    //   147: aload_2
    //   148: ldc 23
    //   150: invokeinterface 105 2 0
    //   155: checkcast 23	com/tencent/luggage/sdk/b/a/e/b$b
    //   158: astore 6
    //   160: getstatic 262	com/tencent/mm/sdk/platformtools/BuildInfo:DEBUG	Z
    //   163: ifeq +90 -> 253
    //   166: ldc 111
    //   168: ldc_w 264
    //   171: invokestatic 238	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   174: new 6	com/tencent/luggage/sdk/b/a/e/b$1
    //   177: dup
    //   178: aload_0
    //   179: invokespecial 265	com/tencent/luggage/sdk/b/a/e/b$1:<init>	(Lcom/tencent/luggage/sdk/b/a/e/b;)V
    //   182: invokestatic 270	com/tencent/mm/libwxaudio/a:a	(Lcom/tencent/mm/libwxaudio/a$a;)V
    //   185: invokestatic 273	com/tencent/mm/libwxaudio/a:loadLibraries	()V
    //   188: aload_0
    //   189: iconst_1
    //   190: putfield 70	com/tencent/luggage/sdk/b/a/e/b:etc	Z
    //   193: aload 4
    //   195: iconst_3
    //   196: invokevirtual 252	com/tencent/mars/smc/IDKey:SetKey	(I)V
    //   199: aload_0
    //   200: getfield 70	com/tencent/luggage/sdk/b/a/e/b:etc	Z
    //   203: ifne +10 -> 213
    //   206: aload 5
    //   208: bipush 6
    //   210: invokevirtual 252	com/tencent/mars/smc/IDKey:SetKey	(I)V
    //   213: aload_0
    //   214: getfield 70	com/tencent/luggage/sdk/b/a/e/b:etc	Z
    //   217: ifne +384 -> 601
    //   220: ldc 111
    //   222: ldc_w 275
    //   225: invokestatic 191	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   228: aload_3
    //   229: aload 5
    //   231: invokevirtual 257	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   234: pop
    //   235: getstatic 281	com/tencent/mm/plugin/report/service/h:OAn	Lcom/tencent/mm/plugin/report/service/h;
    //   238: aload_3
    //   239: iconst_1
    //   240: invokevirtual 284	com/tencent/mm/plugin/report/service/h:b	(Ljava/util/ArrayList;Z)V
    //   243: aload_3
    //   244: invokestatic 286	com/tencent/luggage/sdk/b/a/e/b:h	(Ljava/util/ArrayList;)V
    //   247: ldc 234
    //   249: invokestatic 61	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   252: return
    //   253: ldc 111
    //   255: ldc_w 288
    //   258: invokestatic 238	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   261: new 290	com/tencent/mm/hellhoundlib/b/a
    //   264: dup
    //   265: invokespecial 291	com/tencent/mm/hellhoundlib/b/a:<init>	()V
    //   268: ldc_w 293
    //   271: invokevirtual 297	com/tencent/mm/hellhoundlib/b/a:cG	(Ljava/lang/Object;)Lcom/tencent/mm/hellhoundlib/b/a;
    //   274: astore 7
    //   276: new 4	java/lang/Object
    //   279: dup
    //   280: invokespecial 63	java/lang/Object:<init>	()V
    //   283: astore 8
    //   285: aload 8
    //   287: aload 7
    //   289: invokevirtual 301	com/tencent/mm/hellhoundlib/b/a:aYi	()[Ljava/lang/Object;
    //   292: ldc_w 303
    //   295: ldc 236
    //   297: ldc_w 305
    //   300: ldc_w 307
    //   303: ldc_w 309
    //   306: ldc_w 310
    //   309: invokestatic 315	com/tencent/mm/hellhoundlib/a/a:b	(Ljava/lang/Object;[Ljava/lang/Object;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   312: aload 7
    //   314: iconst_0
    //   315: invokevirtual 319	com/tencent/mm/hellhoundlib/b/a:sb	(I)Ljava/lang/Object;
    //   318: checkcast 321	java/lang/String
    //   321: invokestatic 325	java/lang/System:loadLibrary	(Ljava/lang/String;)V
    //   324: aload 8
    //   326: ldc_w 303
    //   329: ldc 236
    //   331: ldc_w 305
    //   334: ldc_w 307
    //   337: ldc_w 309
    //   340: ldc_w 310
    //   343: invokestatic 328	com/tencent/mm/hellhoundlib/a/a:c	(Ljava/lang/Object;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   346: new 290	com/tencent/mm/hellhoundlib/b/a
    //   349: dup
    //   350: invokespecial 291	com/tencent/mm/hellhoundlib/b/a:<init>	()V
    //   353: ldc_w 330
    //   356: invokevirtual 297	com/tencent/mm/hellhoundlib/b/a:cG	(Ljava/lang/Object;)Lcom/tencent/mm/hellhoundlib/b/a;
    //   359: astore 7
    //   361: new 4	java/lang/Object
    //   364: dup
    //   365: invokespecial 63	java/lang/Object:<init>	()V
    //   368: astore 8
    //   370: aload 8
    //   372: aload 7
    //   374: invokevirtual 301	com/tencent/mm/hellhoundlib/b/a:aYi	()[Ljava/lang/Object;
    //   377: ldc_w 303
    //   380: ldc 236
    //   382: ldc_w 305
    //   385: ldc_w 307
    //   388: ldc_w 309
    //   391: ldc_w 310
    //   394: invokestatic 315	com/tencent/mm/hellhoundlib/a/a:b	(Ljava/lang/Object;[Ljava/lang/Object;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   397: aload 7
    //   399: iconst_0
    //   400: invokevirtual 319	com/tencent/mm/hellhoundlib/b/a:sb	(I)Ljava/lang/Object;
    //   403: checkcast 321	java/lang/String
    //   406: invokestatic 325	java/lang/System:loadLibrary	(Ljava/lang/String;)V
    //   409: aload 8
    //   411: ldc_w 303
    //   414: ldc 236
    //   416: ldc_w 305
    //   419: ldc_w 307
    //   422: ldc_w 309
    //   425: ldc_w 310
    //   428: invokestatic 328	com/tencent/mm/hellhoundlib/a/a:c	(Ljava/lang/Object;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   431: getstatic 336	android/os/Build$VERSION:SDK_INT	I
    //   434: bipush 22
    //   436: if_icmpeq +11 -> 447
    //   439: getstatic 336	android/os/Build$VERSION:SDK_INT	I
    //   442: bipush 21
    //   444: if_icmpne +113 -> 557
    //   447: ldc 111
    //   449: ldc_w 338
    //   452: invokestatic 191	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   455: aload_0
    //   456: iconst_0
    //   457: putfield 70	com/tencent/luggage/sdk/b/a/e/b:etc	Z
    //   460: aload 4
    //   462: iconst_1
    //   463: invokevirtual 252	com/tencent/mars/smc/IDKey:SetKey	(I)V
    //   466: aload_0
    //   467: getfield 70	com/tencent/luggage/sdk/b/a/e/b:etc	Z
    //   470: ifne -257 -> 213
    //   473: aload 5
    //   475: iconst_4
    //   476: invokevirtual 252	com/tencent/mars/smc/IDKey:SetKey	(I)V
    //   479: goto -266 -> 213
    //   482: astore 7
    //   484: ldc 111
    //   486: aload 7
    //   488: ldc_w 340
    //   491: iconst_1
    //   492: anewarray 4	java/lang/Object
    //   495: dup
    //   496: iconst_0
    //   497: ldc_w 293
    //   500: aastore
    //   501: invokestatic 344	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   504: goto -73 -> 431
    //   507: astore 7
    //   509: ldc 111
    //   511: aload 7
    //   513: ldc_w 340
    //   516: iconst_1
    //   517: anewarray 4	java/lang/Object
    //   520: dup
    //   521: iconst_0
    //   522: ldc_w 293
    //   525: aastore
    //   526: invokestatic 344	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   529: goto -98 -> 431
    //   532: astore 7
    //   534: ldc 111
    //   536: aload 7
    //   538: ldc_w 340
    //   541: iconst_1
    //   542: anewarray 4	java/lang/Object
    //   545: dup
    //   546: iconst_0
    //   547: ldc_w 293
    //   550: aastore
    //   551: invokestatic 344	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   554: goto -123 -> 431
    //   557: aload_0
    //   558: aload_2
    //   559: invokeinterface 348 1 0
    //   564: invokestatic 354	com/tencent/luggage/sdk/b/a/e/a:bp	(Landroid/content/Context;)Z
    //   567: putfield 70	com/tencent/luggage/sdk/b/a/e/b:etc	Z
    //   570: aload_0
    //   571: getfield 70	com/tencent/luggage/sdk/b/a/e/b:etc	Z
    //   574: ifne -114 -> 460
    //   577: aload 6
    //   579: ifnull -119 -> 460
    //   582: ldc 111
    //   584: ldc_w 356
    //   587: invokestatic 238	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   590: aload 6
    //   592: invokeinterface 359 1 0
    //   597: pop
    //   598: goto -138 -> 460
    //   601: getstatic 281	com/tencent/mm/plugin/report/service/h:OAn	Lcom/tencent/mm/plugin/report/service/h;
    //   604: aload_3
    //   605: iconst_1
    //   606: invokevirtual 284	com/tencent/mm/plugin/report/service/h:b	(Ljava/util/ArrayList;Z)V
    //   609: aload_3
    //   610: invokestatic 286	com/tencent/luggage/sdk/b/a/e/b:h	(Ljava/util/ArrayList;)V
    //   613: aload_2
    //   614: invokeinterface 348 1 0
    //   619: invokevirtual 365	android/content/Context:getAssets	()Landroid/content/res/AssetManager;
    //   622: invokestatic 369	com/tencent/mm/libwxaudio/WxAudioNative:initAndroidAssetMgr	(Landroid/content/res/AssetManager;)V
    //   625: aload_1
    //   626: ldc_w 371
    //   629: invokeinterface 376 2 0
    //   634: checkcast 371	com/tencent/mm/plugin/appbrand/n/q
    //   637: astore_3
    //   638: aload_3
    //   639: ifnonnull +17 -> 656
    //   642: ldc 111
    //   644: ldc_w 378
    //   647: invokestatic 191	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   650: ldc 234
    //   652: invokestatic 61	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   655: return
    //   656: aload_2
    //   657: ldc_w 380
    //   660: invokeinterface 105 2 0
    //   665: checkcast 380	com/tencent/luggage/sdk/b/a/b/b
    //   668: astore 4
    //   670: aload 4
    //   672: ifnull +36 -> 708
    //   675: aload_0
    //   676: aload 4
    //   678: invokeinterface 383 1 0
    //   683: putfield 66	com/tencent/luggage/sdk/b/a/e/b:eqZ	Z
    //   686: ldc 111
    //   688: ldc_w 385
    //   691: iconst_1
    //   692: anewarray 4	java/lang/Object
    //   695: dup
    //   696: iconst_0
    //   697: aload_0
    //   698: getfield 66	com/tencent/luggage/sdk/b/a/e/b:eqZ	Z
    //   701: invokestatic 119	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   704: aastore
    //   705: invokestatic 124	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   708: aload_3
    //   709: new 12	com/tencent/luggage/sdk/b/a/e/b$3
    //   712: dup
    //   713: aload_0
    //   714: aload_1
    //   715: new 8	com/tencent/luggage/sdk/b/a/e/b$2
    //   718: dup
    //   719: aload_0
    //   720: new 387	java/lang/ref/WeakReference
    //   723: dup
    //   724: aload_3
    //   725: invokespecial 390	java/lang/ref/WeakReference:<init>	(Ljava/lang/Object;)V
    //   728: aload_2
    //   729: invokespecial 393	com/tencent/luggage/sdk/b/a/e/b$2:<init>	(Lcom/tencent/luggage/sdk/b/a/e/b;Ljava/lang/ref/WeakReference;Lcom/tencent/mm/plugin/appbrand/jsapi/f;)V
    //   732: invokespecial 396	com/tencent/luggage/sdk/b/a/e/b$3:<init>	(Lcom/tencent/luggage/sdk/b/a/e/b;Lcom/tencent/mm/plugin/appbrand/n/i;Lcom/tencent/mm/libwxaudio/WxAudioNative$NativeCallBackInterface;)V
    //   735: invokeinterface 400 2 0
    //   740: ldc 234
    //   742: invokestatic 61	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   745: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	746	0	this	b
    //   0	746	1	parami	com.tencent.mm.plugin.appbrand.n.i
    //   0	746	2	paramf	f
    //   57	668	3	localObject1	Object
    //   65	612	4	localObject2	Object
    //   131	343	5	localIDKey	IDKey
    //   158	433	6	localb	b
    //   274	124	7	locala	com.tencent.mm.hellhoundlib.b.a
    //   482	5	7	localUnsatisfiedLinkError	java.lang.UnsatisfiedLinkError
    //   507	5	7	localSecurityException	java.lang.SecurityException
    //   532	5	7	localThrowable	java.lang.Throwable
    //   283	127	8	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   261	431	482	java/lang/UnsatisfiedLinkError
    //   261	431	507	java/lang/SecurityException
    //   261	431	532	finally
  }
  
  public final void d(com.tencent.mm.plugin.appbrand.n.i parami)
  {
    AppMethodBeat.i(220476);
    Log.i("Luggage.WxAudioNativeInstallHelper", "destroyWxAudioBinding");
    if (parami == null)
    {
      Log.e("Luggage.WxAudioNativeInstallHelper", "destroyWxAudioBinding jsruntime is null");
      AppMethodBeat.o(220476);
      return;
    }
    ((m)parami.Z(m.class)).a(this.etf);
    AppMethodBeat.o(220476);
  }
  
  final class a
    extends n
    implements m.a
  {
    a(Runnable paramRunnable)
    {
      super();
    }
    
    public final void onDestroy()
    {
      AppMethodBeat.i(220348);
      run();
      AppMethodBeat.o(220348);
    }
  }
  
  public static abstract interface b
    extends com.tencent.luggage.a.b
  {
    public abstract boolean arS();
    
    public abstract boolean arT();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.luggage.sdk.b.a.e.b
 * JD-Core Version:    0.7.0.1
 */