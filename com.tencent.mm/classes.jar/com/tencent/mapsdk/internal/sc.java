package com.tencent.mapsdk.internal;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.RectF;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import com.tencent.map.lib.callbacks.TileOverlayCallback;
import com.tencent.map.lib.models.AggregationOverlayInfo;
import com.tencent.map.lib.models.AnnocationText;
import com.tencent.map.lib.models.AnnocationTextResult;
import com.tencent.map.lib.models.ArcLineOverlayInfo;
import com.tencent.map.lib.models.CircleInfo;
import com.tencent.map.lib.models.CityTrafficInfo;
import com.tencent.map.lib.models.DataSource;
import com.tencent.map.lib.models.GeoPoint;
import com.tencent.map.lib.models.GroundOverlayInfo;
import com.tencent.map.lib.models.HeatmapInfo;
import com.tencent.map.lib.models.IntersectionOverlayInfo;
import com.tencent.map.lib.models.MapTileID;
import com.tencent.map.lib.models.MarkerInfo;
import com.tencent.map.lib.models.MaskLayer;
import com.tencent.map.lib.models.PolygonInfo;
import com.tencent.map.lib.models.ScatterPlotInfo;
import com.tencent.map.lib.models.TrailOverlayInfo;
import com.tencent.map.tools.CallbackRunnable;
import com.tencent.mapsdk.engine.jni.JNI;
import com.tencent.mapsdk.engine.jni.models.TappedElement;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tencentmap.mapsdk.maps.model.Language;
import com.tencent.tencentmap.mapsdk.maps.model.LatLng;
import com.tencent.tencentmap.mapsdk.maps.model.MapPoi;
import com.tencent.tencentmap.mapsdk.maps.model.MapRouteSection;
import com.tencent.tencentmap.mapsdk.maps.model.PolylineOptions.Text;
import com.tencent.tencentmap.mapsdk.maps.model.TrafficStyle;
import com.tencent.tencentmap.mapsdk.maps.model.VectorHeatAggregationUnit;
import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.locks.ReentrantLock;
import javax.microedition.khronos.opengles.GL10;

public final class sc
  implements bp, br, nv, nw, oa, oc, oe, of
{
  public static final int a = 0;
  public static final int b = -1;
  public static final int c = -9;
  private static final int n = 256;
  private static final int o = -14803236;
  private static final int p = -13752731;
  private static final int q = -15611905;
  private static final int r = -14650226;
  private static final int s = -11088785;
  private static final int t = -9906011;
  private static final int u = -11635864;
  private static final int v = -16777063;
  private static final int w = -16777063;
  private static boolean y = false;
  private String A;
  public JNI d;
  public volatile long e;
  public ns f;
  public le g;
  public final ld h;
  public oa i;
  public mk j;
  public long k;
  public final Object l;
  public final ReentrantLock m;
  private long x;
  private float z;
  
  public sc(Context paramContext, mk parammk)
  {
    AppMethodBeat.i(223536);
    this.h = new lj()
    {
      public final void a(String paramAnonymousString, byte[] paramAnonymousArrayOfByte)
      {
        AppMethodBeat.i(222430);
        if ((sc.a(sc.this) == 0L) || (TextUtils.isEmpty(paramAnonymousString)))
        {
          AppMethodBeat.o(222430);
          return;
        }
        for (;;)
        {
          synchronized (sc.b(sc.this))
          {
            sc.c(sc.this).nativeWriteMapDataBlock(sc.a(sc.this), paramAnonymousString, paramAnonymousArrayOfByte);
            if (paramAnonymousArrayOfByte != gv.a())
            {
              i = paramAnonymousArrayOfByte.length;
              kl.a("TTO", "data-length", i);
              i = kl.e("TTO", "data-count");
              if (kl.d("TTO", "req-count") == i + kl.d("TTO", "cancel-count")) {
                kl.e("TTO");
              }
              AppMethodBeat.o(222430);
              return;
            }
          }
          int i = 0;
        }
      }
    };
    this.x = 0L;
    this.k = 0L;
    this.z = 1.0F;
    this.A = null;
    this.l = new Object();
    this.m = new ReentrantLock();
    this.d = new JNI();
    this.g = new le();
    this.g.a(this.h);
    this.j = parammk;
    this.z = paramContext.getResources().getDisplayMetrics().density;
    if (y) {
      ke.a(paramContext, "txmapengine");
    }
    AppMethodBeat.o(223536);
  }
  
  private static boolean A()
  {
    return y;
  }
  
  private void B()
  {
    this.j.v = true;
  }
  
  /* Error */
  private void C()
  {
    // Byte code:
    //   0: ldc_w 494
    //   3: invokestatic 425	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_0
    //   7: getfield 445	com/tencent/mapsdk/internal/sc:m	Ljava/util/concurrent/locks/ReentrantLock;
    //   10: invokevirtual 497	java/util/concurrent/locks/ReentrantLock:lock	()V
    //   13: aload_0
    //   14: getfield 455	com/tencent/mapsdk/internal/sc:g	Lcom/tencent/mapsdk/internal/le;
    //   17: ifnull +21 -> 38
    //   20: aload_0
    //   21: getfield 455	com/tencent/mapsdk/internal/sc:g	Lcom/tencent/mapsdk/internal/le;
    //   24: aload_0
    //   25: getfield 430	com/tencent/mapsdk/internal/sc:h	Lcom/tencent/mapsdk/internal/ld;
    //   28: invokevirtual 499	com/tencent/mapsdk/internal/le:b	(Lcom/tencent/mapsdk/internal/ld;)V
    //   31: aload_0
    //   32: getfield 455	com/tencent/mapsdk/internal/sc:g	Lcom/tencent/mapsdk/internal/le;
    //   35: invokevirtual 501	com/tencent/mapsdk/internal/le:a	()V
    //   38: aload_0
    //   39: getfield 503	com/tencent/mapsdk/internal/sc:e	J
    //   42: lconst_0
    //   43: lcmp
    //   44: ifeq +30 -> 74
    //   47: aload_0
    //   48: getfield 503	com/tencent/mapsdk/internal/sc:e	J
    //   51: lstore_1
    //   52: aload_0
    //   53: lconst_0
    //   54: putfield 503	com/tencent/mapsdk/internal/sc:e	J
    //   57: aload_0
    //   58: getfield 440	com/tencent/mapsdk/internal/sc:l	Ljava/lang/Object;
    //   61: astore_3
    //   62: aload_3
    //   63: monitorenter
    //   64: aload_0
    //   65: getfield 450	com/tencent/mapsdk/internal/sc:d	Lcom/tencent/mapsdk/engine/jni/JNI;
    //   68: lload_1
    //   69: invokevirtual 507	com/tencent/mapsdk/engine/jni/JNI:nativeDestroyEngine	(J)V
    //   72: aload_3
    //   73: monitorexit
    //   74: aload_0
    //   75: aconst_null
    //   76: putfield 460	com/tencent/mapsdk/internal/sc:j	Lcom/tencent/mapsdk/internal/mk;
    //   79: aload_0
    //   80: getfield 450	com/tencent/mapsdk/internal/sc:d	Lcom/tencent/mapsdk/engine/jni/JNI;
    //   83: invokevirtual 510	com/tencent/mapsdk/engine/jni/JNI:destory	()V
    //   86: aload_0
    //   87: getfield 445	com/tencent/mapsdk/internal/sc:m	Ljava/util/concurrent/locks/ReentrantLock;
    //   90: invokevirtual 513	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   93: ldc_w 494
    //   96: invokestatic 486	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   99: return
    //   100: astore 4
    //   102: aload_3
    //   103: monitorexit
    //   104: ldc_w 494
    //   107: invokestatic 486	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   110: aload 4
    //   112: athrow
    //   113: astore_3
    //   114: aload_0
    //   115: getfield 445	com/tencent/mapsdk/internal/sc:m	Ljava/util/concurrent/locks/ReentrantLock;
    //   118: invokevirtual 513	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   121: ldc_w 494
    //   124: invokestatic 486	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   127: aload_3
    //   128: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	129	0	this	sc
    //   51	18	1	l1	long
    //   113	15	3	localObject2	Object
    //   100	11	4	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   64	74	100	finally
    //   6	38	113	finally
    //   38	64	113	finally
    //   74	86	113	finally
    //   102	113	113	finally
  }
  
  private boolean D()
  {
    AppMethodBeat.i(223590);
    if (this.e == 0L)
    {
      AppMethodBeat.o(223590);
      return false;
    }
    if (System.currentTimeMillis() - this.k > 560L)
    {
      this.d.nativeClearDownloadURLCache(this.e);
      this.k = System.currentTimeMillis();
    }
    boolean bool = this.d.nativeGenerateTextures(this.e);
    AppMethodBeat.o(223590);
    return bool;
  }
  
  private boolean E()
  {
    AppMethodBeat.i(223596);
    boolean bool = ((Boolean)a(new CallbackRunnable()
    {
      private Boolean a()
      {
        AppMethodBeat.i(222334);
        boolean bool = sc.c(sc.this).nativeDrawFrame(sc.a(sc.this));
        AppMethodBeat.o(222334);
        return Boolean.valueOf(bool);
      }
    }, Boolean.FALSE)).booleanValue();
    AppMethodBeat.o(223596);
    return bool;
  }
  
  private qq[] F()
  {
    AppMethodBeat.i(223638);
    qq[] arrayOfqq = (qq[])a(new CallbackRunnable()
    {
      private qq[] a()
      {
        AppMethodBeat.i(221722);
        if (sc.a(sc.this) == 0L)
        {
          AppMethodBeat.o(221722);
          return null;
        }
        int[] arrayOfInt = sc.c(sc.this).nativeFetchLackedTrafficBlocks(sc.a(sc.this));
        if ((arrayOfInt == null) || (arrayOfInt.length == 0))
        {
          AppMethodBeat.o(221722);
          return null;
        }
        qq[] arrayOfqq = new qq[arrayOfInt.length / 7];
        int i = 0;
        while (i < arrayOfInt.length / 7)
        {
          arrayOfqq[i] = new qq();
          arrayOfqq[i].a = arrayOfInt[(i * 7)];
          arrayOfqq[i].b = arrayOfInt[(i * 7 + 1)];
          arrayOfqq[i].d = arrayOfInt[(i * 7 + 2)];
          arrayOfqq[i].c = arrayOfInt[(i * 7 + 3)];
          arrayOfqq[i].f = arrayOfInt[(i * 7 + 4)];
          arrayOfqq[i].e = arrayOfInt[(i * 7 + 5)];
          arrayOfqq[i].g = arrayOfInt[(i * 7 + 6)];
          i += 1;
        }
        AppMethodBeat.o(221722);
        return arrayOfqq;
      }
    }, null);
    AppMethodBeat.o(223638);
    return arrayOfqq;
  }
  
  private void G()
  {
    AppMethodBeat.i(223770);
    a(new mk.a()
    {
      public final void a(GL10 paramAnonymousGL10)
      {
        AppMethodBeat.i(222779);
        if (sc.a(sc.this) == 0L)
        {
          AppMethodBeat.o(222779);
          return;
        }
        sc.c(sc.this).nativeShowTraffic(sc.a(sc.this));
        AppMethodBeat.o(222779);
      }
    });
    AppMethodBeat.o(223770);
  }
  
  private void H()
  {
    AppMethodBeat.i(223778);
    a(new mk.a()
    {
      public final void a(GL10 paramAnonymousGL10)
      {
        AppMethodBeat.i(222767);
        if (sc.a(sc.this) == 0L)
        {
          AppMethodBeat.o(222767);
          return;
        }
        sc.c(sc.this).nativeHideTraffic(sc.a(sc.this));
        AppMethodBeat.o(222767);
      }
    });
    AppMethodBeat.o(223778);
  }
  
  private long I()
  {
    return this.e;
  }
  
  private void J()
  {
    AppMethodBeat.i(223967);
    if (0L == this.e)
    {
      AppMethodBeat.o(223967);
      return;
    }
    a(new mk.a()
    {
      public final void a(GL10 paramAnonymousGL10)
      {
        AppMethodBeat.i(223089);
        if (sc.a(sc.this) != 0L) {
          sc.c(sc.this).nativeHideCompass(sc.a(sc.this));
        }
        AppMethodBeat.o(223089);
      }
    });
    AppMethodBeat.o(223967);
  }
  
  private int K()
  {
    AppMethodBeat.i(224025);
    int i1 = ((Integer)a(new CallbackRunnable()
    {
      private Integer a()
      {
        AppMethodBeat.i(222660);
        if (0L == sc.a(sc.this))
        {
          AppMethodBeat.o(222660);
          return Integer.valueOf(-1);
        }
        int i = sc.c(sc.this).nativeGetIndoorCurrentFloorId(sc.a(sc.this));
        AppMethodBeat.o(222660);
        return Integer.valueOf(i);
      }
    }, Integer.valueOf(-1))).intValue();
    AppMethodBeat.o(224025);
    return i1;
  }
  
  private String[] M()
  {
    AppMethodBeat.i(224035);
    String[] arrayOfString = (String[])a(new CallbackRunnable()
    {
      private String[] a()
      {
        AppMethodBeat.i(222670);
        if (0L == sc.a(sc.this))
        {
          AppMethodBeat.o(222670);
          return null;
        }
        String[] arrayOfString = sc.c(sc.this).nativeGetIndoorFloorNames(sc.a(sc.this));
        AppMethodBeat.o(222670);
        return arrayOfString;
      }
    }, null);
    AppMethodBeat.o(224035);
    return arrayOfString;
  }
  
  private Rect N()
  {
    AppMethodBeat.i(224055);
    Rect localRect = (Rect)a(new CallbackRunnable()
    {
      private Rect a()
      {
        AppMethodBeat.i(222695);
        if (0L == sc.a(sc.this))
        {
          AppMethodBeat.o(222695);
          return null;
        }
        Rect localRect = sc.c(sc.this).nativeGetIndoorBound(sc.a(sc.this));
        AppMethodBeat.o(222695);
        return localRect;
      }
    }, null);
    AppMethodBeat.o(224055);
    return localRect;
  }
  
  private String O()
  {
    AppMethodBeat.i(224062);
    String str = (String)a(new CallbackRunnable()
    {
      private String a()
      {
        AppMethodBeat.i(222702);
        if (sc.a(sc.this) == 0L)
        {
          AppMethodBeat.o(222702);
          return null;
        }
        String str = sc.c(sc.this).nativeGetActiveIndoorBuildingGUID(sc.a(sc.this));
        AppMethodBeat.o(222702);
        return str;
      }
    }, null);
    AppMethodBeat.o(224062);
    return str;
  }
  
  private void P()
  {
    AppMethodBeat.i(224197);
    if ((0L == this.e) || (this.j == null))
    {
      AppMethodBeat.o(224197);
      return;
    }
    this.j.a(new mk.a()
    {
      public final void a(GL10 paramAnonymousGL10)
      {
        AppMethodBeat.i(221800);
        if (sc.a(sc.this) != 0L) {
          sc.c(sc.this).nativeZoomOut(sc.a(sc.this));
        }
        AppMethodBeat.o(221800);
      }
    });
    AppMethodBeat.o(224197);
  }
  
  private void Q()
  {
    AppMethodBeat.i(224216);
    a(new mk.a()
    {
      public final void a(GL10 paramAnonymousGL10)
      {
        AppMethodBeat.i(221896);
        if (0L == sc.a(sc.this))
        {
          AppMethodBeat.o(221896);
          return;
        }
        long l = System.currentTimeMillis();
        if (sc.e(sc.this) == 0L) {
          sc.c(sc.this).nativeUpdateFrame(sc.a(sc.this), 0.0D);
        }
        for (;;)
        {
          sc.a(sc.this, l);
          AppMethodBeat.o(221896);
          return;
          sc.c(sc.this).nativeUpdateFrame(sc.a(sc.this), l - sc.e(sc.this));
        }
      }
    });
    AppMethodBeat.o(224216);
  }
  
  private boolean R()
  {
    AppMethodBeat.i(224227);
    boolean bool = ((Boolean)a(new CallbackRunnable()
    {
      private Boolean a()
      {
        AppMethodBeat.i(221906);
        if (0L == sc.a(sc.this))
        {
          Boolean localBoolean = Boolean.FALSE;
          AppMethodBeat.o(221906);
          return localBoolean;
        }
        boolean bool = sc.c(sc.this).nativeNeedDispaly(sc.a(sc.this));
        AppMethodBeat.o(221906);
        return Boolean.valueOf(bool);
      }
    }, Boolean.FALSE)).booleanValue();
    AppMethodBeat.o(224227);
    return bool;
  }
  
  private String S()
  {
    AppMethodBeat.i(224409);
    String str = (String)a(new CallbackRunnable()
    {
      private String a()
      {
        AppMethodBeat.i(225400);
        if (sc.a(sc.this) == 0L)
        {
          AppMethodBeat.o(225400);
          return "";
        }
        String str = sc.c(sc.this).nativeGetMapEngineVersion(sc.a(sc.this));
        AppMethodBeat.o(225400);
        return str;
      }
    }, "");
    AppMethodBeat.o(224409);
    return str;
  }
  
  private String T()
  {
    AppMethodBeat.i(224418);
    String str = (String)a(new CallbackRunnable()
    {
      private String a()
      {
        AppMethodBeat.i(225501);
        if (sc.a(sc.this) == 0L)
        {
          AppMethodBeat.o(225501);
          return "";
        }
        String str = sc.c(sc.this).nativeGetDataEngineVersion(sc.a(sc.this));
        AppMethodBeat.o(225501);
        return str;
      }
    }, "");
    AppMethodBeat.o(224418);
    return str;
  }
  
  private String U()
  {
    AppMethodBeat.i(224432);
    String str = (String)a(new CallbackRunnable()
    {
      private String a()
      {
        AppMethodBeat.i(226207);
        if (sc.a(sc.this) == 0L)
        {
          AppMethodBeat.o(226207);
          return null;
        }
        String str = sc.c(sc.this).getMapEngineRenderStatus(sc.a(sc.this));
        AppMethodBeat.o(226207);
        return str;
      }
    }, null);
    AppMethodBeat.o(224432);
    return str;
  }
  
  private void V()
  {
    AppMethodBeat.i(224638);
    this.m.lock();
    AppMethodBeat.o(224638);
  }
  
  private void W()
  {
    AppMethodBeat.i(224649);
    this.m.unlock();
    AppMethodBeat.o(224649);
  }
  
  private float[] X()
  {
    AppMethodBeat.i(224660);
    float[] arrayOfFloat = this.d.nativeGLProjectMatrix();
    AppMethodBeat.o(224660);
    return arrayOfFloat;
  }
  
  private int[] Y()
  {
    AppMethodBeat.i(224677);
    int[] arrayOfInt = this.d.nativeGLViewport();
    AppMethodBeat.o(224677);
    return arrayOfInt;
  }
  
  private float Z()
  {
    AppMethodBeat.i(224688);
    float f1 = this.d.nativeGLViewScaleRatio();
    AppMethodBeat.o(224688);
    return f1;
  }
  
  private int a(final CircleInfo paramCircleInfo)
  {
    AppMethodBeat.i(223659);
    int i1 = ((Integer)a(new CallbackRunnable()
    {
      private Integer a()
      {
        AppMethodBeat.i(223679);
        if ((sc.a(sc.this) == 0L) || (paramCircleInfo == null))
        {
          AppMethodBeat.o(223679);
          return Integer.valueOf(-1);
        }
        int i = sc.c(sc.this).nativeAddCircle(sc.a(sc.this), paramCircleInfo);
        AppMethodBeat.o(223679);
        return Integer.valueOf(i);
      }
    }, Integer.valueOf(-1))).intValue();
    AppMethodBeat.o(223659);
    return i1;
  }
  
  private int a(final MaskLayer paramMaskLayer)
  {
    AppMethodBeat.i(223714);
    int i1 = ((Integer)a(new CallbackRunnable()
    {
      private Integer a()
      {
        AppMethodBeat.i(222320);
        if (sc.a(sc.this) == 0L)
        {
          AppMethodBeat.o(222320);
          return Integer.valueOf(0);
        }
        int i = sc.c(sc.this).nativeAddMaskLayer(sc.a(sc.this), paramMaskLayer);
        AppMethodBeat.o(222320);
        return Integer.valueOf(i);
      }
    }, Integer.valueOf(0))).intValue();
    AppMethodBeat.o(223714);
    return i1;
  }
  
  private int a(final PolygonInfo paramPolygonInfo)
  {
    AppMethodBeat.i(223651);
    int i1 = ((Integer)a(new CallbackRunnable()
    {
      private Integer a()
      {
        AppMethodBeat.i(226169);
        if (sc.a(sc.this) == 0L)
        {
          AppMethodBeat.o(226169);
          return Integer.valueOf(0);
        }
        int i = sc.c(sc.this).nativeAddPolygon(sc.a(sc.this), paramPolygonInfo);
        AppMethodBeat.o(226169);
        return Integer.valueOf(i);
      }
    }, Integer.valueOf(0))).intValue();
    AppMethodBeat.o(223651);
    return i1;
  }
  
  private int a(final oj paramoj)
  {
    AppMethodBeat.i(223975);
    int i1 = ((Integer)a(new CallbackRunnable()
    {
      private Integer a()
      {
        AppMethodBeat.i(224781);
        if (0L == sc.a(sc.this))
        {
          AppMethodBeat.o(224781);
          return Integer.valueOf(0);
        }
        int i = sc.c(sc.this).nativeAddMarker(sc.a(sc.this), paramoj.g, paramoj.i, paramoj.j, paramoj.m, paramoj.n, paramoj.u, paramoj.v, paramoj.t, paramoj.a(), paramoj.x, paramoj.w, paramoj.z, paramoj.A, paramoj.B, paramoj.D, paramoj.C);
        AppMethodBeat.o(224781);
        return Integer.valueOf(i);
      }
    }, Integer.valueOf(0))).intValue();
    AppMethodBeat.o(223975);
    return i1;
  }
  
  private int a(final pv parampv)
  {
    AppMethodBeat.i(223796);
    int i1 = ((Integer)a(new CallbackRunnable()
    {
      private Integer a()
      {
        AppMethodBeat.i(221588);
        if (parampv == null)
        {
          AppMethodBeat.o(221588);
          return Integer.valueOf(-1);
        }
        if (parampv.q != -1)
        {
          i = parampv.q;
          AppMethodBeat.o(221588);
          return Integer.valueOf(i);
        }
        int i = sc.a(sc.this, parampv);
        AppMethodBeat.o(221588);
        return Integer.valueOf(i);
      }
    }, Integer.valueOf(-1))).intValue();
    AppMethodBeat.o(223796);
    return i1;
  }
  
  private int a(final byte[] paramArrayOfByte, final int paramInt)
  {
    AppMethodBeat.i(223617);
    paramInt = ((Integer)a(new CallbackRunnable()
    {
      private Integer a()
      {
        AppMethodBeat.i(221604);
        if (sc.a(sc.this) == 0L)
        {
          AppMethodBeat.o(221604);
          return Integer.valueOf(-1);
        }
        int i = sc.c(sc.this).nativeRefreshTrafficData(sc.a(sc.this), paramArrayOfByte, paramInt, this.c, this.d);
        AppMethodBeat.o(221604);
        return Integer.valueOf(i);
      }
    }, Integer.valueOf(-1))).intValue();
    AppMethodBeat.o(223617);
    return paramInt;
  }
  
  private int a(final GeoPoint[] paramArrayOfGeoPoint, final PolylineOptions.Text paramText)
  {
    AppMethodBeat.i(224449);
    int i1 = ((Integer)a(new CallbackRunnable()
    {
      private Integer a()
      {
        AppMethodBeat.i(226179);
        if (sc.a(sc.this) == 0L)
        {
          AppMethodBeat.o(226179);
          return Integer.valueOf(-1);
        }
        int i = sc.c(sc.this).addLineText(sc.a(sc.this), paramArrayOfGeoPoint, paramText);
        AppMethodBeat.o(226179);
        return Integer.valueOf(i);
      }
    }, Integer.valueOf(-1))).intValue();
    AppMethodBeat.o(224449);
    return i1;
  }
  
  private long a(final AggregationOverlayInfo paramAggregationOverlayInfo)
  {
    AppMethodBeat.i(224491);
    long l1 = ((Long)a(new CallbackRunnable()
    {
      private Long a()
      {
        AppMethodBeat.i(223709);
        if (sc.a(sc.this) == 0L)
        {
          AppMethodBeat.o(223709);
          return Long.valueOf(0L);
        }
        long l = sc.c(sc.this).nativeAddAggregatioinOverlay(sc.a(sc.this), paramAggregationOverlayInfo);
        AppMethodBeat.o(223709);
        return Long.valueOf(l);
      }
    }, Long.valueOf(0L))).longValue();
    AppMethodBeat.o(224491);
    return l1;
  }
  
  private long a(final ArcLineOverlayInfo paramArcLineOverlayInfo)
  {
    AppMethodBeat.i(224537);
    long l1 = ((Long)a(new CallbackRunnable()
    {
      private Long a()
      {
        AppMethodBeat.i(224456);
        if (sc.a(sc.this) == 0L)
        {
          AppMethodBeat.o(224456);
          return Long.valueOf(0L);
        }
        long l = sc.c(sc.this).nativeAddArcLineOverlay(sc.a(sc.this), paramArcLineOverlayInfo);
        AppMethodBeat.o(224456);
        return Long.valueOf(l);
      }
    }, Long.valueOf(0L))).longValue();
    AppMethodBeat.o(224537);
    return l1;
  }
  
  private long a(final GroundOverlayInfo paramGroundOverlayInfo)
  {
    AppMethodBeat.i(224598);
    long l1 = ((Long)a(new CallbackRunnable()
    {
      private Long a()
      {
        AppMethodBeat.i(224167);
        if ((sc.a(sc.this) == 0L) || (paramGroundOverlayInfo == null) || (!paramGroundOverlayInfo.checkValid()))
        {
          AppMethodBeat.o(224167);
          return Long.valueOf(0L);
        }
        long l = sc.c(sc.this).nativeAddGroundOverlay(sc.a(sc.this), paramGroundOverlayInfo);
        AppMethodBeat.o(224167);
        return Long.valueOf(l);
      }
    }, Long.valueOf(0L))).longValue();
    AppMethodBeat.o(224598);
    return l1;
  }
  
  private long a(final HeatmapInfo paramHeatmapInfo)
  {
    AppMethodBeat.i(224510);
    long l1 = ((Long)a(new CallbackRunnable()
    {
      private Long a()
      {
        AppMethodBeat.i(223587);
        if (sc.a(sc.this) == 0L)
        {
          AppMethodBeat.o(223587);
          return Long.valueOf(0L);
        }
        long l = sc.c(sc.this).nativeAddHeatmapOverlay(sc.a(sc.this), paramHeatmapInfo);
        AppMethodBeat.o(223587);
        return Long.valueOf(l);
      }
    }, Long.valueOf(0L))).longValue();
    AppMethodBeat.o(224510);
    return l1;
  }
  
  private long a(final IntersectionOverlayInfo paramIntersectionOverlayInfo)
  {
    AppMethodBeat.i(224620);
    long l1 = ((Long)a(new CallbackRunnable()
    {
      private Long a()
      {
        AppMethodBeat.i(222562);
        if (sc.a(sc.this) == 0L)
        {
          AppMethodBeat.o(222562);
          return Long.valueOf(0L);
        }
        long l = sc.c(sc.this).nativeAddIntersectionOverlay(sc.a(sc.this), paramIntersectionOverlayInfo);
        AppMethodBeat.o(222562);
        return Long.valueOf(l);
      }
    }, Long.valueOf(0L))).longValue();
    AppMethodBeat.o(224620);
    return l1;
  }
  
  private long a(final MarkerInfo paramMarkerInfo)
  {
    AppMethodBeat.i(224466);
    long l1 = ((Long)a(new CallbackRunnable()
    {
      private Long a()
      {
        AppMethodBeat.i(223506);
        if (sc.a(sc.this) == 0L)
        {
          AppMethodBeat.o(223506);
          return Long.valueOf(0L);
        }
        long l = sc.c(sc.this).nativeAddMarker2(sc.a(sc.this), paramMarkerInfo);
        AppMethodBeat.o(223506);
        return Long.valueOf(l);
      }
    }, Long.valueOf(0L))).longValue();
    AppMethodBeat.o(224466);
    return l1;
  }
  
  private long a(final ScatterPlotInfo paramScatterPlotInfo)
  {
    AppMethodBeat.i(224557);
    long l1 = ((Long)a(new CallbackRunnable()
    {
      private Long a()
      {
        AppMethodBeat.i(224490);
        if (sc.a(sc.this) == 0L)
        {
          AppMethodBeat.o(224490);
          return Long.valueOf(0L);
        }
        long l = sc.c(sc.this).nativeAddScatterOverlay(sc.a(sc.this), paramScatterPlotInfo);
        AppMethodBeat.o(224490);
        return Long.valueOf(l);
      }
    }, Long.valueOf(0L))).longValue();
    AppMethodBeat.o(224557);
    return l1;
  }
  
  private long a(final TrailOverlayInfo paramTrailOverlayInfo)
  {
    AppMethodBeat.i(224579);
    long l1 = ((Long)a(new CallbackRunnable()
    {
      private Long a()
      {
        AppMethodBeat.i(225053);
        if (sc.a(sc.this) == 0L)
        {
          AppMethodBeat.o(225053);
          return Long.valueOf(0L);
        }
        long l = sc.c(sc.this).nativeAddTrailOverlay(sc.a(sc.this), paramTrailOverlayInfo);
        AppMethodBeat.o(225053);
        return Long.valueOf(l);
      }
    }, Long.valueOf(0L))).longValue();
    AppMethodBeat.o(224579);
    return l1;
  }
  
  private AnnocationTextResult a(final AnnocationText paramAnnocationText)
  {
    AppMethodBeat.i(224297);
    paramAnnocationText = (AnnocationTextResult)a(new CallbackRunnable()
    {
      private AnnocationTextResult a()
      {
        AppMethodBeat.i(221990);
        if (0L == sc.a(sc.this))
        {
          AppMethodBeat.o(221990);
          return null;
        }
        AnnocationTextResult localAnnocationTextResult = sc.c(sc.this).nativeCreateAnnotationTextBitmap(sc.a(sc.this), paramAnnocationText);
        AppMethodBeat.o(221990);
        return localAnnocationTextResult;
      }
    }, null);
    AppMethodBeat.o(224297);
    return paramAnnocationText;
  }
  
  private GeoPoint a(final byte[] paramArrayOfByte, final float paramFloat1, final float paramFloat2)
  {
    AppMethodBeat.i(223746);
    paramArrayOfByte = (GeoPoint)b(new CallbackRunnable()new GeoPoint
    {
      private GeoPoint a()
      {
        AppMethodBeat.i(223003);
        Object localObject = new double[2];
        sc.c(sc.this).nativeFromScreenLocation(sc.a(sc.this), paramArrayOfByte, paramFloat1, paramFloat2, (double[])localObject);
        int i = (int)(localObject[0] * 1000000.0D);
        localObject = new GeoPoint((int)(localObject[1] * 1000000.0D), i);
        AppMethodBeat.o(223003);
        return localObject;
      }
    }, new GeoPoint());
    AppMethodBeat.o(223746);
    return paramArrayOfByte;
  }
  
  private VectorHeatAggregationUnit a(final long paramLong, LatLng paramLatLng)
  {
    AppMethodBeat.i(224525);
    paramLatLng = (VectorHeatAggregationUnit)a(new CallbackRunnable()
    {
      private VectorHeatAggregationUnit a()
      {
        AppMethodBeat.i(224634);
        if (sc.a(sc.this) == 0L)
        {
          AppMethodBeat.o(224634);
          return null;
        }
        VectorHeatAggregationUnit localVectorHeatAggregationUnit = sc.c(sc.this).getAggregationUnit(sc.a(sc.this), paramLong, this.b);
        AppMethodBeat.o(224634);
        return localVectorHeatAggregationUnit;
      }
    }, null);
    AppMethodBeat.o(224525);
    return paramLatLng;
  }
  
  private List<Integer> a(final Rect paramRect, final int paramInt)
  {
    AppMethodBeat.i(224305);
    paramRect = (List)a(new CallbackRunnable()
    {
      private List<Integer> a()
      {
        AppMethodBeat.i(221731);
        if (0L == sc.a(sc.this))
        {
          AppMethodBeat.o(221731);
          return null;
        }
        int[] arrayOfInt = new int[100];
        int j = sc.c(sc.this).nativeQueryCityCodeList(sc.a(sc.this), paramRect, paramInt, arrayOfInt, 100);
        if (j > 0)
        {
          ArrayList localArrayList = new ArrayList(j);
          int i = 0;
          while (i < j)
          {
            localArrayList.add(Integer.valueOf(arrayOfInt[i]));
            i += 1;
          }
          AppMethodBeat.o(221731);
          return localArrayList;
        }
        AppMethodBeat.o(221731);
        return null;
      }
    }, null);
    AppMethodBeat.o(224305);
    return paramRect;
  }
  
  private void a(final double paramDouble)
  {
    AppMethodBeat.i(224161);
    if ((0L == this.e) || (this.j == null))
    {
      AppMethodBeat.o(224161);
      return;
    }
    this.j.a(new mk.a()
    {
      public final void a(GL10 paramAnonymousGL10)
      {
        AppMethodBeat.i(221591);
        if (sc.a(sc.this) != 0L) {
          sc.c(sc.this).nativeSetScale(sc.a(sc.this), paramDouble, this.b);
        }
        AppMethodBeat.o(221591);
      }
    });
    AppMethodBeat.o(224161);
  }
  
  private void a(final float paramFloat1, final float paramFloat2, final float paramFloat3, final float paramFloat4)
  {
    AppMethodBeat.i(224092);
    if (0L == this.e)
    {
      AppMethodBeat.o(224092);
      return;
    }
    a(new mk.a()
    {
      public final void a(GL10 paramAnonymousGL10)
      {
        AppMethodBeat.i(222964);
        if (sc.a(sc.this) != 0L) {
          sc.c(sc.this).nativeSetIndoorActiveScreenArea(sc.a(sc.this), paramFloat1, paramFloat2, paramFloat3, paramFloat4);
        }
        AppMethodBeat.o(222964);
      }
    });
    AppMethodBeat.o(224092);
  }
  
  private void a(final int paramInt1, final int paramInt2, final int paramInt3, final int paramInt4, final int paramInt5)
  {
    AppMethodBeat.i(223622);
    b(new mk.a()
    {
      public final void a(GL10 paramAnonymousGL10)
      {
        AppMethodBeat.i(222442);
        if (sc.a(sc.this) != 0L) {
          sc.c(sc.this).nativeCheckTrafficBlockCache(sc.a(sc.this), paramInt1, paramInt2, paramInt3, paramInt4, paramInt5);
        }
        AppMethodBeat.o(222442);
      }
    });
    AppMethodBeat.o(223622);
  }
  
  private void a(final int paramInt1, final int paramInt2, final boolean paramBoolean)
  {
    AppMethodBeat.i(223684);
    a(new mk.a()
    {
      public final void a(GL10 paramAnonymousGL10)
      {
        AppMethodBeat.i(222288);
        if ((sc.a(sc.this) == 0L) || (paramInt1 < 0) || (sc.d(sc.this) == null))
        {
          AppMethodBeat.o(222288);
          return;
        }
        sc.c(sc.this).nativeSetPolygonHidden(sc.a(sc.this), paramInt1, paramInt2, paramBoolean);
        AppMethodBeat.o(222288);
      }
    });
    AppMethodBeat.o(223684);
  }
  
  private void a(final int paramInt, final CircleInfo paramCircleInfo)
  {
    AppMethodBeat.i(223667);
    if ((this.e == 0L) || (paramCircleInfo == null))
    {
      AppMethodBeat.o(223667);
      return;
    }
    a(new mk.a()
    {
      public final void a(GL10 paramAnonymousGL10)
      {
        AppMethodBeat.i(224942);
        sc.c(sc.this).nativeUpdateCircle(sc.a(sc.this), paramInt, paramCircleInfo);
        AppMethodBeat.o(224942);
      }
    });
    AppMethodBeat.o(223667);
  }
  
  private void a(final int paramInt, final PolylineOptions.Text paramText)
  {
    AppMethodBeat.i(224457);
    a(new mk.a()
    {
      public final void a(GL10 paramAnonymousGL10)
      {
        AppMethodBeat.i(226183);
        if (sc.a(sc.this) == 0L)
        {
          AppMethodBeat.o(226183);
          return;
        }
        sc.c(sc.this).setLineTextStyle(sc.a(sc.this), paramInt, paramText);
        AppMethodBeat.o(226183);
      }
    });
    AppMethodBeat.o(224457);
  }
  
  private void a(final int paramInt, final boolean paramBoolean)
  {
    AppMethodBeat.i(223845);
    a(new mk.a()
    {
      public final void a(GL10 paramAnonymousGL10)
      {
        AppMethodBeat.i(225862);
        if (paramInt == -1)
        {
          AppMethodBeat.o(225862);
          return;
        }
        sc.c(sc.this).nativeDeleteLine(sc.a(sc.this), paramInt, paramBoolean);
        AppMethodBeat.o(225862);
      }
    });
    AppMethodBeat.o(223845);
  }
  
  private void a(final long paramLong, AggregationOverlayInfo paramAggregationOverlayInfo)
  {
    AppMethodBeat.i(224500);
    a(new mk.a()
    {
      public final void a(GL10 paramAnonymousGL10)
      {
        AppMethodBeat.i(223607);
        if (sc.a(sc.this) == 0L)
        {
          AppMethodBeat.o(223607);
          return;
        }
        sc.c(sc.this).nativeUpdateAggregatioinOverlay(sc.a(sc.this), paramLong, this.b);
        AppMethodBeat.o(223607);
      }
    });
    AppMethodBeat.o(224500);
  }
  
  private void a(final long paramLong, ArcLineOverlayInfo paramArcLineOverlayInfo)
  {
    AppMethodBeat.i(224547);
    a(new mk.a()
    {
      public final void a(GL10 paramAnonymousGL10)
      {
        AppMethodBeat.i(224394);
        if (sc.a(sc.this) == 0L)
        {
          AppMethodBeat.o(224394);
          return;
        }
        sc.c(sc.this).nativeUpdateArcLineOverlay(sc.a(sc.this), paramLong, this.b);
        AppMethodBeat.o(224394);
      }
    });
    AppMethodBeat.o(224547);
  }
  
  private void a(final long paramLong, GroundOverlayInfo paramGroundOverlayInfo)
  {
    AppMethodBeat.i(224608);
    a(new mk.a()
    {
      public final void a(GL10 paramAnonymousGL10)
      {
        AppMethodBeat.i(222569);
        if ((sc.a(sc.this) == 0L) || (paramLong == 0L))
        {
          AppMethodBeat.o(222569);
          return;
        }
        sc.c(sc.this).nativeUpdateGroundOverlay(sc.a(sc.this), paramLong, this.b);
        AppMethodBeat.o(222569);
      }
    });
    AppMethodBeat.o(224608);
  }
  
  private void a(final long paramLong, HeatmapInfo paramHeatmapInfo)
  {
    AppMethodBeat.i(224518);
    a(new mk.a()
    {
      public final void a(GL10 paramAnonymousGL10)
      {
        AppMethodBeat.i(224524);
        if (sc.a(sc.this) == 0L)
        {
          AppMethodBeat.o(224524);
          return;
        }
        sc.c(sc.this).nativeUpdateHeatmapOverlay(sc.a(sc.this), paramLong, this.b);
        AppMethodBeat.o(224524);
      }
    });
    AppMethodBeat.o(224518);
  }
  
  private void a(final long paramLong, IntersectionOverlayInfo paramIntersectionOverlayInfo)
  {
    AppMethodBeat.i(224629);
    a(new mk.a()
    {
      public final void a(GL10 paramAnonymousGL10)
      {
        AppMethodBeat.i(222619);
        if ((sc.a(sc.this) == 0L) || (paramLong == 0L))
        {
          AppMethodBeat.o(222619);
          return;
        }
        sc.c(sc.this).nativeUpdateIntersectionOverlay(paramLong, this.b);
        AppMethodBeat.o(222619);
      }
    });
    AppMethodBeat.o(224629);
  }
  
  private void a(final long paramLong, MarkerInfo paramMarkerInfo)
  {
    AppMethodBeat.i(224475);
    a(new mk.a()
    {
      public final void a(GL10 paramAnonymousGL10)
      {
        AppMethodBeat.i(223524);
        if (sc.a(sc.this) == 0L)
        {
          AppMethodBeat.o(223524);
          return;
        }
        sc.c(sc.this).nativeUpdateMarker(paramLong, this.b);
        AppMethodBeat.o(223524);
      }
    });
    AppMethodBeat.o(224475);
  }
  
  private void a(final long paramLong, ScatterPlotInfo paramScatterPlotInfo)
  {
    AppMethodBeat.i(224568);
    a(new mk.a()
    {
      public final void a(GL10 paramAnonymousGL10)
      {
        AppMethodBeat.i(224471);
        if (sc.a(sc.this) == 0L)
        {
          AppMethodBeat.o(224471);
          return;
        }
        sc.c(sc.this).nativeUpdateScatterPlotOverlay(sc.a(sc.this), paramLong, this.b);
        AppMethodBeat.o(224471);
      }
    });
    AppMethodBeat.o(224568);
  }
  
  private void a(final long paramLong, TrailOverlayInfo paramTrailOverlayInfo)
  {
    AppMethodBeat.i(224587);
    a(new mk.a()
    {
      public final void a(GL10 paramAnonymousGL10)
      {
        AppMethodBeat.i(225167);
        if (sc.a(sc.this) == 0L)
        {
          AppMethodBeat.o(225167);
          return;
        }
        sc.c(sc.this).nativeUpdateTrailOverlay(sc.a(sc.this), paramLong, this.b);
        AppMethodBeat.o(225167);
      }
    });
    AppMethodBeat.o(224587);
  }
  
  private void a(final GeoPoint paramGeoPoint, final RectF paramRectF, final int paramInt1, final int paramInt2, final boolean paramBoolean)
  {
    AppMethodBeat.i(224207);
    if ((0L == this.e) || (this.j == null))
    {
      AppMethodBeat.o(224207);
      return;
    }
    this.j.a(new mk.a()
    {
      public final void a(GL10 paramAnonymousGL10)
      {
        AppMethodBeat.i(221812);
        if (sc.a(sc.this) != 0L)
        {
          sc.c(sc.this).nativeSetFlagOfZoomToSpanForLocation(sc.a(sc.this), paramRectF.top, paramRectF.left, paramRectF.bottom, paramRectF.right);
          sc.c(sc.this).nativeZoomToSpanForNavigation(sc.a(sc.this), paramGeoPoint, paramInt1, paramInt2, paramBoolean);
        }
        AppMethodBeat.o(221812);
      }
    });
    AppMethodBeat.o(224207);
  }
  
  private void a(ns paramns)
  {
    this.f = paramns;
  }
  
  private void a(oa paramoa)
  {
    this.i = paramoa;
  }
  
  private void a(ob paramob)
  {
    AppMethodBeat.i(224261);
    this.d.setMapCallbackGetGLContext(paramob);
    AppMethodBeat.o(224261);
  }
  
  private void a(final String paramString1, final String paramString2, final String paramString3)
  {
    AppMethodBeat.i(224332);
    a(new mk.a()
    {
      public final void a(GL10 paramAnonymousGL10)
      {
        AppMethodBeat.i(221654);
        if (sc.a(sc.this) == 0L)
        {
          AppMethodBeat.o(221654);
          return;
        }
        sc.c(sc.this).nativeResetEnginePath(sc.a(sc.this), paramString1, paramString2, paramString3);
        AppMethodBeat.o(221654);
      }
    });
    AppMethodBeat.o(224332);
  }
  
  private void a(final boolean paramBoolean1, final boolean paramBoolean2, final boolean paramBoolean3, final boolean paramBoolean4)
  {
    AppMethodBeat.i(223948);
    if ((0L == this.e) || (this.j == null))
    {
      AppMethodBeat.o(223948);
      return;
    }
    a(new mk.a()
    {
      public final void a(GL10 paramAnonymousGL10)
      {
        AppMethodBeat.i(223064);
        if (sc.a(sc.this) != 0L) {
          sc.c(sc.this).nativeSetLocationFollow(sc.a(sc.this), paramBoolean1, paramBoolean2, paramBoolean3, paramBoolean4);
        }
        AppMethodBeat.o(223064);
      }
    });
    AppMethodBeat.o(223948);
  }
  
  private static void a(double[] paramArrayOfDouble, double paramDouble1, double paramDouble2)
  {
    int i1 = 0;
    while (i1 < 4)
    {
      int i2 = i1 + 0;
      int i3 = i2 + 12;
      paramArrayOfDouble[i3] += paramArrayOfDouble[i2] * paramDouble1 + paramArrayOfDouble[(i2 + 4)] * paramDouble2 + paramArrayOfDouble[(i2 + 8)] * 0.0D;
      i1 += 1;
    }
  }
  
  private void a(final int[] paramArrayOfInt, final int paramInt, final boolean paramBoolean)
  {
    AppMethodBeat.i(223992);
    a(new mk.a()
    {
      public final void a(GL10 paramAnonymousGL10)
      {
        AppMethodBeat.i(224944);
        if (0L == sc.a(sc.this))
        {
          AppMethodBeat.o(224944);
          return;
        }
        sc.c(sc.this).nativeSetIconsHidden(sc.a(sc.this), paramArrayOfInt, paramInt, paramBoolean);
        AppMethodBeat.o(224944);
      }
    });
    AppMethodBeat.o(223992);
  }
  
  private void a(final String[] paramArrayOfString)
  {
    AppMethodBeat.i(224114);
    if (this.e == 0L)
    {
      AppMethodBeat.o(224114);
      return;
    }
    a(new mk.a()
    {
      public final void a(GL10 paramAnonymousGL10)
      {
        AppMethodBeat.i(222988);
        if (sc.a(sc.this) != 0L) {
          sc.c(sc.this).nativeSetShowIndoorBuildingWhiteList(sc.a(sc.this), paramArrayOfString);
        }
        AppMethodBeat.o(222988);
      }
    });
    AppMethodBeat.o(224114);
  }
  
  private boolean a(final int paramInt, final float paramFloat1, final float paramFloat2)
  {
    AppMethodBeat.i(223855);
    if (paramInt == -1)
    {
      AppMethodBeat.o(223855);
      return false;
    }
    boolean bool = ((Boolean)a(new CallbackRunnable()
    {
      private Boolean a()
      {
        AppMethodBeat.i(225890);
        boolean bool = sc.c(sc.this).nativeOnTapLine(paramInt, paramFloat1, paramFloat2);
        AppMethodBeat.o(225890);
        return Boolean.valueOf(bool);
      }
    }, Boolean.FALSE)).booleanValue();
    AppMethodBeat.o(223855);
    return bool;
  }
  
  private int b(final String paramString)
  {
    AppMethodBeat.i(223605);
    int i1 = ((Integer)a(new CallbackRunnable()
    {
      private Integer a()
      {
        AppMethodBeat.i(222707);
        if (sc.a(sc.this) == 0L)
        {
          AppMethodBeat.o(222707);
          return Integer.valueOf(0);
        }
        int i = sc.c(sc.this).nativeIsCityHasTraffic(sc.a(sc.this), paramString);
        AppMethodBeat.o(222707);
        return Integer.valueOf(i);
      }
    }, Integer.valueOf(0))).intValue();
    AppMethodBeat.o(223605);
    return i1;
  }
  
  private ps b(GeoPoint paramGeoPoint)
  {
    AppMethodBeat.i(224044);
    final GeoPoint localGeoPoint = paramGeoPoint;
    if (paramGeoPoint == null) {
      localGeoPoint = new GeoPoint();
    }
    paramGeoPoint = (ps)a(new CallbackRunnable()
    {
      private ps a()
      {
        AppMethodBeat.i(222689);
        if (0L == sc.a(sc.this))
        {
          AppMethodBeat.o(222689);
          return null;
        }
        Object localObject = sc.c(sc.this).nativeGetActiveIndoorBuildingGUID(sc.a(sc.this));
        String str = sc.c(sc.this).nativeGetCurIndoorName(sc.a(sc.this), localGeoPoint);
        int i = sc.c(sc.this).nativeGetIndoorCurrentFloorId(sc.a(sc.this));
        localObject = new ps((String)localObject, str, sc.c(sc.this).nativeGetIndoorFloorNames(sc.a(sc.this)), i);
        AppMethodBeat.o(222689);
        return localObject;
      }
    }, null);
    AppMethodBeat.o(224044);
    return paramGeoPoint;
  }
  
  private void b(final double paramDouble)
  {
    AppMethodBeat.i(224183);
    a(new mk.a()
    {
      public final void a(GL10 paramAnonymousGL10)
      {
        AppMethodBeat.i(221502);
        if ((0L == sc.a(sc.this)) || (sc.d(sc.this) == null))
        {
          AppMethodBeat.o(221502);
          return;
        }
        sc.c(sc.this).nativeSetScale(sc.a(sc.this), paramDouble, false);
        AppMethodBeat.o(221502);
      }
    });
    AppMethodBeat.o(224183);
  }
  
  private void b(final float paramFloat)
  {
    AppMethodBeat.i(224235);
    a(new mk.a()
    {
      public final void a(GL10 paramAnonymousGL10)
      {
        AppMethodBeat.i(222138);
        if (0L == sc.a(sc.this))
        {
          AppMethodBeat.o(222138);
          return;
        }
        sc.c(sc.this).nativeSetRotate(sc.a(sc.this), paramFloat, false);
        AppMethodBeat.o(222138);
      }
    });
    AppMethodBeat.o(224235);
  }
  
  private void b(final int paramInt1, final int paramInt2, final int paramInt3)
  {
    AppMethodBeat.i(224173);
    if ((0L == this.e) || (this.j == null))
    {
      AppMethodBeat.o(224173);
      return;
    }
    a(new mk.a()
    {
      public final void a(GL10 paramAnonymousGL10)
      {
        AppMethodBeat.i(221597);
        if (sc.a(sc.this) != 0L) {
          sc.c(sc.this).nativeSetMarkerScaleLevelRange(sc.a(sc.this), paramInt1, paramInt2, paramInt3);
        }
        AppMethodBeat.o(221597);
      }
    });
    AppMethodBeat.o(224173);
  }
  
  private void b(final int paramInt1, final int paramInt2, final int paramInt3, final int paramInt4)
  {
    AppMethodBeat.i(224253);
    a(new mk.a()
    {
      public final void a(GL10 paramAnonymousGL10)
      {
        AppMethodBeat.i(221400);
        if (sc.a(sc.this) == 0L)
        {
          AppMethodBeat.o(221400);
          return;
        }
        sc.c(sc.this).nativeSetTrafficColor(sc.a(sc.this), paramInt2, paramInt1, paramInt3, paramInt4);
        AppMethodBeat.o(221400);
      }
    });
    AppMethodBeat.o(224253);
  }
  
  private void b(final int paramInt1, final int paramInt2, final int paramInt3, final int paramInt4, final int paramInt5)
  {
    AppMethodBeat.i(223631);
    b(new mk.a()
    {
      public final void a(GL10 paramAnonymousGL10)
      {
        AppMethodBeat.i(221453);
        if (sc.a(sc.this) != 0L) {
          sc.c(sc.this).nativeCheckTrafficBlockCacheForReplay(sc.a(sc.this), paramInt1, paramInt2, paramInt3, paramInt4, paramInt5);
        }
        AppMethodBeat.o(221453);
      }
    });
    AppMethodBeat.o(223631);
  }
  
  private void b(final PolygonInfo paramPolygonInfo)
  {
    AppMethodBeat.i(223678);
    a(new mk.a()
    {
      public final void a(GL10 paramAnonymousGL10)
      {
        AppMethodBeat.i(222306);
        if (sc.a(sc.this) == 0L)
        {
          AppMethodBeat.o(222306);
          return;
        }
        sc.c(sc.this).nativeUpdatePolygon(sc.a(sc.this), paramPolygonInfo.polygonId, paramPolygonInfo.borderLineId, paramPolygonInfo);
        AppMethodBeat.o(222306);
      }
    });
    AppMethodBeat.o(223678);
  }
  
  private void b(final oj paramoj)
  {
    AppMethodBeat.i(223983);
    if (0L == this.e)
    {
      AppMethodBeat.o(223983);
      return;
    }
    a(new mk.a()
    {
      public final void a(GL10 paramAnonymousGL10)
      {
        AppMethodBeat.i(224886);
        if (sc.a(sc.this) != 0L) {
          sc.c(sc.this).nativeUpdateMarkerInfo(sc.a(sc.this), paramoj.f, paramoj.g, paramoj.i, paramoj.j, paramoj.m, paramoj.n, paramoj.u, paramoj.v, paramoj.t, paramoj.a(), paramoj.x, paramoj.w, paramoj.z, paramoj.A, paramoj.B, paramoj.D, paramoj.C);
        }
        AppMethodBeat.o(224886);
      }
    });
    AppMethodBeat.o(223983);
  }
  
  private void b(final pv parampv)
  {
    AppMethodBeat.i(223807);
    a(new mk.a()
    {
      public final void a(GL10 paramAnonymousGL10)
      {
        AppMethodBeat.i(221575);
        if ((parampv == null) || (parampv.q == -1))
        {
          AppMethodBeat.o(221575);
          return;
        }
        sc.a(sc.this, parampv);
        paramAnonymousGL10 = sc.this;
        pv localpv = parampv;
        if (paramAnonymousGL10.e != 0L) {
          paramAnonymousGL10.a(new sc.106(paramAnonymousGL10, localpv));
        }
        paramAnonymousGL10 = sc.this;
        paramAnonymousGL10.a(new sc.105(paramAnonymousGL10, parampv));
        paramAnonymousGL10 = sc.this;
        localpv = parampv;
        if (paramAnonymousGL10.e != 0L) {
          paramAnonymousGL10.a(new sc.107(paramAnonymousGL10, localpv));
        }
        if (parampv.a.E)
        {
          paramAnonymousGL10 = sc.this;
          localpv = parampv;
          if (paramAnonymousGL10.e != 0L) {
            paramAnonymousGL10.a(new sc.111(paramAnonymousGL10, localpv));
          }
        }
        for (;;)
        {
          paramAnonymousGL10 = sc.this;
          localpv = parampv;
          if (paramAnonymousGL10.e != 0L) {
            paramAnonymousGL10.a(new sc.109(paramAnonymousGL10, localpv));
          }
          if (!gz.a(parampv.a.H))
          {
            paramAnonymousGL10 = sc.this;
            localpv = parampv;
            if (paramAnonymousGL10.e != 0L) {
              paramAnonymousGL10.a(new sc.108(paramAnonymousGL10, localpv));
            }
          }
          paramAnonymousGL10 = sc.this;
          paramAnonymousGL10.a(new sc.30(paramAnonymousGL10, parampv));
          AppMethodBeat.o(221575);
          return;
          paramAnonymousGL10 = sc.this;
          localpv = parampv;
          if (paramAnonymousGL10.e != 0L) {
            paramAnonymousGL10.a(new sc.110(paramAnonymousGL10, localpv));
          }
        }
      }
    });
    AppMethodBeat.o(223807);
  }
  
  private int c(final pv parampv)
  {
    int i3 = 0;
    AppMethodBeat.i(223821);
    final int i1 = parampv.a.C;
    final boolean bool2;
    if (i1 == 3)
    {
      bool2 = true;
      i1 = 0;
    }
    for (;;)
    {
      Object localObject1 = parampv.n;
      final boolean bool1;
      if (localObject1[0] == 33)
      {
        bool1 = false;
        i1 = 2;
      }
      for (;;)
      {
        localObject1 = new int[0];
        Object localObject2;
        int i2;
        if (parampv.a.L != null)
        {
          localObject2 = new int[parampv.a.L.size()];
          i2 = 0;
          for (;;)
          {
            localObject1 = localObject2;
            if (i2 >= parampv.a.L.size()) {
              break;
            }
            localObject2[i2] = ((Integer)parampv.a.L.get(i2)).intValue();
            i2 += 1;
          }
          if (localObject1[0] == 20) {
            bool1 = true;
          }
        }
        else
        {
          localObject2 = new int[0];
          if (parampv.a.t != null)
          {
            int[] arrayOfInt = new int[parampv.a.t.length];
            i2 = i3;
            for (;;)
            {
              localObject2 = arrayOfInt;
              if (i2 >= parampv.a.t.length) {
                break;
              }
              arrayOfInt[i2] = parampv.a.t[i2];
              i2 += 1;
            }
          }
          i1 = ((Integer)c(new CallbackRunnable()
          {
            private Integer a()
            {
              AppMethodBeat.i(226238);
              JNI localJNI = sc.c(sc.this);
              long l = sc.a(sc.this);
              int i = parampv.q;
              int[] arrayOfInt1 = parampv.n;
              int[] arrayOfInt2 = parampv.m;
              GeoPoint[] arrayOfGeoPoint = (GeoPoint[])parampv.a.m.toArray(new GeoPoint[0]);
              Object localObject = parampv;
              float f2;
              int j;
              boolean bool1;
              boolean bool2;
              boolean bool3;
              boolean bool4;
              float f3;
              boolean bool5;
              int[] arrayOfInt3;
              int[] arrayOfInt4;
              float f4;
              int[] arrayOfInt5;
              pv localpv;
              if ((((pv)localObject).a.r != null) && (((pv)localObject).a.r.length > 0)) {
                if (localObject.a.r[0] == 33)
                {
                  localObject = "color_point_texture.png";
                  f2 = parampv.a.x;
                  j = i1;
                  bool1 = bool2;
                  bool2 = bool1;
                  bool3 = parampv.a.B;
                  bool4 = parampv.a.O;
                  f3 = parampv.getZIndex();
                  bool5 = parampv.a.v;
                  arrayOfInt3 = parampv.a.s;
                  arrayOfInt4 = this.e;
                  f4 = parampv.a.u;
                  arrayOfInt5 = this.f;
                  localpv = parampv;
                  if (localpv.a != null) {
                    break label369;
                  }
                }
              }
              label369:
              for (float f1 = 1.0F;; f1 = localpv.a.A)
              {
                i = localJNI.nativeCreateOrUpdateLine(l, i, arrayOfInt1, arrayOfInt2, arrayOfGeoPoint, (String)localObject, f2, j, bool1, bool2, bool3, bool4, f3, bool5, arrayOfInt3, arrayOfInt4, f4, arrayOfInt5, f1, parampv.getLevel(), parampv.isVisible());
                AppMethodBeat.o(226238);
                return Integer.valueOf(i);
                if (localObject.a.r[0] == 20)
                {
                  localObject = "color_texture_line_v2.png";
                  break;
                }
                if (gz.a(((pv)localObject).a.y))
                {
                  localObject = "color_texture_flat_style.png";
                  break;
                }
                localObject = ((pv)localObject).a.y;
                break;
              }
            }
          }, Integer.valueOf(-1))).intValue();
          AppMethodBeat.o(223821);
          return i1;
        }
        bool1 = false;
      }
      bool2 = false;
    }
  }
  
  private CityTrafficInfo c(final String paramString)
  {
    AppMethodBeat.i(223643);
    paramString = (CityTrafficInfo)a(new CallbackRunnable()
    {
      private CityTrafficInfo a()
      {
        AppMethodBeat.i(225749);
        if (sc.a(sc.this) == 0L)
        {
          AppMethodBeat.o(225749);
          return null;
        }
        CityTrafficInfo localCityTrafficInfo = new CityTrafficInfo();
        sc.c(sc.this).nativeGetTrafficCityInfo(sc.a(sc.this), paramString, localCityTrafficInfo);
        AppMethodBeat.o(225749);
        return localCityTrafficInfo;
      }
    }, null);
    AppMethodBeat.o(223643);
    return paramString;
  }
  
  /* Error */
  private <T> T c(CallbackRunnable<T> paramCallbackRunnable, T paramT)
  {
    // Byte code:
    //   0: ldc_w 954
    //   3: invokestatic 425	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_0
    //   7: getfield 460	com/tencent/mapsdk/internal/sc:j	Lcom/tencent/mapsdk/internal/mk;
    //   10: ifnull +12 -> 22
    //   13: aload_0
    //   14: getfield 503	com/tencent/mapsdk/internal/sc:e	J
    //   17: lconst_0
    //   18: lcmp
    //   19: ifne +11 -> 30
    //   22: ldc_w 954
    //   25: invokestatic 486	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   28: aload_2
    //   29: areturn
    //   30: aload_0
    //   31: getfield 445	com/tencent/mapsdk/internal/sc:m	Ljava/util/concurrent/locks/ReentrantLock;
    //   34: invokevirtual 497	java/util/concurrent/locks/ReentrantLock:lock	()V
    //   37: aload_2
    //   38: astore 5
    //   40: aload_0
    //   41: getfield 460	com/tencent/mapsdk/internal/sc:j	Lcom/tencent/mapsdk/internal/mk;
    //   44: ifnull +17 -> 61
    //   47: aload_0
    //   48: getfield 503	com/tencent/mapsdk/internal/sc:e	J
    //   51: lstore_3
    //   52: lload_3
    //   53: lconst_0
    //   54: lcmp
    //   55: ifne +22 -> 77
    //   58: aload_2
    //   59: astore 5
    //   61: aload_0
    //   62: getfield 445	com/tencent/mapsdk/internal/sc:m	Ljava/util/concurrent/locks/ReentrantLock;
    //   65: invokevirtual 513	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   68: ldc_w 954
    //   71: invokestatic 486	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   74: aload 5
    //   76: areturn
    //   77: invokestatic 960	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   80: invokevirtual 963	java/lang/Thread:getName	()Ljava/lang/String;
    //   83: ldc_w 965
    //   86: invokevirtual 969	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   89: ifeq +14 -> 103
    //   92: aload_0
    //   93: aload_1
    //   94: aload_2
    //   95: invokevirtual 770	com/tencent/mapsdk/internal/sc:b	(Lcom/tencent/map/tools/CallbackRunnable;Ljava/lang/Object;)Ljava/lang/Object;
    //   98: astore 5
    //   100: goto -39 -> 61
    //   103: aload_0
    //   104: aload_1
    //   105: aload_2
    //   106: invokespecial 971	com/tencent/mapsdk/internal/sc:e	(Lcom/tencent/map/tools/CallbackRunnable;Ljava/lang/Object;)Ljava/lang/Object;
    //   109: astore 5
    //   111: goto -50 -> 61
    //   114: astore_1
    //   115: ldc_w 973
    //   118: ldc_w 975
    //   121: aload_1
    //   122: invokestatic 980	com/tencent/mapsdk/internal/kh:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   125: aload_0
    //   126: getfield 445	com/tencent/mapsdk/internal/sc:m	Ljava/util/concurrent/locks/ReentrantLock;
    //   129: invokevirtual 513	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   132: ldc_w 954
    //   135: invokestatic 486	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   138: aload_2
    //   139: areturn
    //   140: astore_1
    //   141: aload_0
    //   142: getfield 445	com/tencent/mapsdk/internal/sc:m	Ljava/util/concurrent/locks/ReentrantLock;
    //   145: invokevirtual 513	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   148: ldc_w 954
    //   151: invokestatic 486	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   154: aload_1
    //   155: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	156	0	this	sc
    //   0	156	1	paramCallbackRunnable	CallbackRunnable<T>
    //   0	156	2	paramT	T
    //   51	2	3	l1	long
    //   38	72	5	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   30	37	114	java/lang/Exception
    //   40	52	114	java/lang/Exception
    //   77	100	114	java/lang/Exception
    //   103	111	114	java/lang/Exception
    //   30	37	140	finally
    //   40	52	140	finally
    //   77	100	140	finally
    //   103	111	140	finally
    //   115	125	140	finally
  }
  
  private String c(final GeoPoint paramGeoPoint)
  {
    AppMethodBeat.i(224072);
    paramGeoPoint = (String)a(new CallbackRunnable()
    {
      private String a()
      {
        AppMethodBeat.i(222943);
        if (0L == sc.a(sc.this))
        {
          AppMethodBeat.o(222943);
          return null;
        }
        String str = sc.c(sc.this).nativeGetCurIndoorName(sc.a(sc.this), paramGeoPoint);
        AppMethodBeat.o(222943);
        return str;
      }
    }, null);
    AppMethodBeat.o(224072);
    return paramGeoPoint;
  }
  
  private void c(final float paramFloat)
  {
    AppMethodBeat.i(224243);
    a(new mk.a()
    {
      public final void a(GL10 paramAnonymousGL10)
      {
        AppMethodBeat.i(222155);
        if (0L == sc.a(sc.this))
        {
          AppMethodBeat.o(222155);
          return;
        }
        sc.c(sc.this).nativeSetSkew(sc.a(sc.this), paramFloat, false);
        AppMethodBeat.o(222155);
      }
    });
    AppMethodBeat.o(224243);
  }
  
  private void c(final int paramInt1, final int paramInt2)
  {
    AppMethodBeat.i(223692);
    a(new mk.a()
    {
      public final void a(GL10 paramAnonymousGL10)
      {
        AppMethodBeat.i(222359);
        if ((sc.a(sc.this) == 0L) || (paramInt1 < 0) || (sc.d(sc.this) == null))
        {
          AppMethodBeat.o(222359);
          return;
        }
        sc.c(sc.this).nativeDeletePolygon(sc.a(sc.this), paramInt1, paramInt2);
        AppMethodBeat.o(222359);
      }
    });
    AppMethodBeat.o(223692);
  }
  
  private <T> T d(CallbackRunnable<T> paramCallbackRunnable, T paramT)
  {
    AppMethodBeat.i(224708);
    if ((paramCallbackRunnable == null) || (this.j == null) || (this.e == 0L))
    {
      AppMethodBeat.o(224708);
      return paramT;
    }
    if (Thread.currentThread().getName().contains("tms-gl"))
    {
      paramCallbackRunnable = b(paramCallbackRunnable, paramT);
      AppMethodBeat.o(224708);
      return paramCallbackRunnable;
    }
    paramCallbackRunnable = e(paramCallbackRunnable, paramT);
    AppMethodBeat.o(224708);
    return paramCallbackRunnable;
  }
  
  private void d(final int paramInt1, final int paramInt2)
  {
    AppMethodBeat.i(223723);
    a(new mk.a()
    {
      public final void a(GL10 paramAnonymousGL10)
      {
        AppMethodBeat.i(222968);
        if (sc.a(sc.this) == 0L)
        {
          AppMethodBeat.o(222968);
          return;
        }
        sc.c(sc.this).nativeUpdateMaskLayer(sc.a(sc.this), paramInt1, paramInt2);
        AppMethodBeat.o(222968);
      }
    });
    AppMethodBeat.o(223723);
  }
  
  private void d(final GeoPoint paramGeoPoint)
  {
    AppMethodBeat.i(224151);
    this.j.a(new mk.a()
    {
      public final void a(GL10 paramAnonymousGL10)
      {
        AppMethodBeat.i(221566);
        if ((0L == sc.a(sc.this)) || (sc.d(sc.this) == null))
        {
          AppMethodBeat.o(221566);
          return;
        }
        sc.c(sc.this).nativeSetCenter(sc.a(sc.this), paramGeoPoint, false);
        AppMethodBeat.o(221566);
      }
    });
    AppMethodBeat.o(224151);
  }
  
  private void d(final pv parampv)
  {
    AppMethodBeat.i(223832);
    a(new mk.a()
    {
      public final void a(GL10 paramAnonymousGL10)
      {
        AppMethodBeat.i(225856);
        if (sc.a(sc.this) == 0L)
        {
          AppMethodBeat.o(225856);
          return;
        }
        int i = parampv.q;
        if (i == -1)
        {
          AppMethodBeat.o(225856);
          return;
        }
        sc.c(sc.this).nativeSetLineSelected(sc.a(sc.this), i, parampv.isSelected());
        AppMethodBeat.o(225856);
      }
    });
    AppMethodBeat.o(223832);
  }
  
  private boolean d(final String paramString)
  {
    AppMethodBeat.i(223761);
    boolean bool = ((Boolean)a(new CallbackRunnable()
    {
      private Boolean a()
      {
        AppMethodBeat.i(222941);
        if (sc.a(sc.this) == 0L)
        {
          Boolean localBoolean = Boolean.FALSE;
          AppMethodBeat.o(222941);
          return localBoolean;
        }
        boolean bool = sc.c(sc.this).nativeHasStreetRoad(sc.a(sc.this), paramString);
        AppMethodBeat.o(222941);
        return Boolean.valueOf(bool);
      }
    }, Boolean.FALSE)).booleanValue();
    AppMethodBeat.o(223761);
    return bool;
  }
  
  private <T> T e(final CallbackRunnable<T> paramCallbackRunnable, T paramT)
  {
    AppMethodBeat.i(224717);
    if ((paramCallbackRunnable == null) || (this.j == null) || (this.e == 0L))
    {
      AppMethodBeat.o(224717);
      return paramT;
    }
    this.j.a(new mk.a()
    {
      public final void a(GL10 paramAnonymousGL10)
      {
        AppMethodBeat.i(222543);
        paramCallbackRunnable.run();
        AppMethodBeat.o(222543);
      }
    });
    AppMethodBeat.o(224717);
    return paramT;
  }
  
  private void e(final int paramInt1, final int paramInt2)
  {
    AppMethodBeat.i(224271);
    a(new mk.a()
    {
      public final void a(GL10 paramAnonymousGL10)
      {
        AppMethodBeat.i(221388);
        if (sc.a(sc.this) == 0L)
        {
          AppMethodBeat.o(221388);
          return;
        }
        sc.c(sc.this).nativeBringElementAbove(sc.a(sc.this), paramInt1, paramInt2);
        AppMethodBeat.o(221388);
      }
    });
    AppMethodBeat.o(224271);
  }
  
  private void e(final pv parampv)
  {
    AppMethodBeat.i(223864);
    a(new mk.a()
    {
      public final void a(GL10 paramAnonymousGL10)
      {
        AppMethodBeat.i(225927);
        int i = parampv.q;
        if (i == -1)
        {
          AppMethodBeat.o(225927);
          return;
        }
        paramAnonymousGL10 = parampv.r;
        if (paramAnonymousGL10 == null)
        {
          AppMethodBeat.o(225927);
          return;
        }
        sc.c(sc.this).nativeSetTurnArrow(sc.a(sc.this), i, parampv.a.m, paramAnonymousGL10.a, paramAnonymousGL10.b);
        AppMethodBeat.o(225927);
      }
    });
    AppMethodBeat.o(223864);
  }
  
  private void e(final String paramString)
  {
    AppMethodBeat.i(223787);
    a(new mk.a()
    {
      public final void a(GL10 paramAnonymousGL10)
      {
        AppMethodBeat.i(222781);
        if (sc.a(sc.this) == 0L)
        {
          AppMethodBeat.o(222781);
          return;
        }
        sc.c(sc.this).nativeUpdateMapResource(sc.a(sc.this), paramString);
        AppMethodBeat.o(222781);
      }
    });
    AppMethodBeat.o(223787);
  }
  
  private void f(final int paramInt1, final int paramInt2)
  {
    AppMethodBeat.i(224284);
    a(new mk.a()
    {
      public final void a(GL10 paramAnonymousGL10)
      {
        AppMethodBeat.i(221398);
        if (sc.a(sc.this) == 0L)
        {
          AppMethodBeat.o(221398);
          return;
        }
        sc.c(sc.this).nativeBringElementBelow(sc.a(sc.this), paramInt1, paramInt2);
        AppMethodBeat.o(221398);
      }
    });
    AppMethodBeat.o(224284);
  }
  
  private void f(final pv parampv)
  {
    AppMethodBeat.i(223875);
    if (this.e == 0L)
    {
      AppMethodBeat.o(223875);
      return;
    }
    a(new mk.a()
    {
      public final void a(GL10 paramAnonymousGL10)
      {
        AppMethodBeat.i(225959);
        int i = parampv.q;
        if (i == -1)
        {
          AppMethodBeat.o(225959);
          return;
        }
        paramAnonymousGL10 = parampv;
        int[] arrayOfInt = new int[2];
        arrayOfInt[0] = paramAnonymousGL10.a.J;
        arrayOfInt[1] = paramAnonymousGL10.a.K;
        sc.c(sc.this).nativeSetTurnArrowStyle(sc.a(sc.this), i, arrayOfInt[0], arrayOfInt[1]);
        AppMethodBeat.o(225959);
      }
    });
    AppMethodBeat.o(223875);
  }
  
  private void f(final String paramString)
  {
    AppMethodBeat.i(224001);
    if (0L == this.e)
    {
      AppMethodBeat.o(224001);
      return;
    }
    a(new mk.a()
    {
      public final void a(GL10 paramAnonymousGL10)
      {
        AppMethodBeat.i(225196);
        if (sc.a(sc.this) != 0L) {
          sc.c(sc.this).nativeSetCompassImage(sc.a(sc.this), paramString);
        }
        AppMethodBeat.o(225196);
      }
    });
    AppMethodBeat.o(224001);
  }
  
  private void g(final int paramInt)
  {
    AppMethodBeat.i(223612);
    a(new mk.a()
    {
      public final void a(GL10 paramAnonymousGL10)
      {
        AppMethodBeat.i(223020);
        if (sc.a(sc.this) == 0L)
        {
          AppMethodBeat.o(223020);
          return;
        }
        if (paramInt == 1)
        {
          sc.c(sc.this).nativeSetTrafficColor(sc.a(sc.this), -14803236, -15611905, -9906011, -16777063);
          AppMethodBeat.o(223020);
          return;
        }
        if (paramInt == 2)
        {
          sc.c(sc.this).nativeSetTrafficColor(sc.a(sc.this), -13752731, -14650226, -11635864, -16777063);
          AppMethodBeat.o(223020);
          return;
        }
        sc.c(sc.this).nativeSetTrafficColor(sc.a(sc.this), -14803236, -15611905, -11088785, -16777063);
        AppMethodBeat.o(223020);
      }
    });
    AppMethodBeat.o(223612);
  }
  
  private void g(final int paramInt1, final int paramInt2)
  {
    AppMethodBeat.i(224479);
    a(new mk.a()
    {
      public final void a(GL10 paramAnonymousGL10)
      {
        AppMethodBeat.i(223498);
        if (sc.a(sc.this) == 0L)
        {
          AppMethodBeat.o(223498);
          return;
        }
        sc.c(sc.this).nativeSetMarkerMainSubRelation(sc.a(sc.this), paramInt1, paramInt2);
        AppMethodBeat.o(223498);
      }
    });
    AppMethodBeat.o(224479);
  }
  
  private void g(final pv parampv)
  {
    AppMethodBeat.i(223886);
    if (this.e == 0L)
    {
      AppMethodBeat.o(223886);
      return;
    }
    a(new mk.a()
    {
      public final void a(GL10 paramAnonymousGL10)
      {
        AppMethodBeat.i(225996);
        int i = parampv.q;
        if (i == -1)
        {
          AppMethodBeat.o(225996);
          return;
        }
        sc.c(sc.this).nativeSetLineDrawArrow(sc.a(sc.this), i, parampv.a.w);
        AppMethodBeat.o(225996);
      }
    });
    AppMethodBeat.o(223886);
  }
  
  private void g(final String paramString)
  {
    AppMethodBeat.i(224141);
    if (0L == this.e)
    {
      AppMethodBeat.o(224141);
      return;
    }
    a(new mk.a()
    {
      public final void a(GL10 paramAnonymousGL10)
      {
        AppMethodBeat.i(221539);
        if (sc.a(sc.this) != 0L) {
          sc.c(sc.this).nativeSetLocationCompassMarkerImage(sc.a(sc.this), paramString);
        }
        AppMethodBeat.o(221539);
      }
    });
    AppMethodBeat.o(224141);
  }
  
  private void h(final int paramInt)
  {
    AppMethodBeat.i(223673);
    if ((this.e == 0L) || (paramInt < 0) || (this.j == null))
    {
      AppMethodBeat.o(223673);
      return;
    }
    a(new mk.a()
    {
      public final void a(GL10 paramAnonymousGL10)
      {
        AppMethodBeat.i(222519);
        sc.c(sc.this).nativeDeleteCircle(sc.a(sc.this), paramInt);
        AppMethodBeat.o(222519);
      }
    });
    AppMethodBeat.o(223673);
  }
  
  private void h(final pv parampv)
  {
    AppMethodBeat.i(223899);
    if (this.e == 0L)
    {
      AppMethodBeat.o(223899);
      return;
    }
    a(new mk.a()
    {
      public final void a(GL10 paramAnonymousGL10)
      {
        AppMethodBeat.i(226004);
        int i = parampv.q;
        if (i == -1)
        {
          AppMethodBeat.o(226004);
          return;
        }
        sc.c(sc.this).nativeSetLineDirectionArrowTextureName(sc.a(sc.this), i, parampv.a.H);
        AppMethodBeat.o(226004);
      }
    });
    AppMethodBeat.o(223899);
  }
  
  private void h(final String paramString)
  {
    AppMethodBeat.i(224315);
    a(new mk.a()
    {
      public final void a(GL10 paramAnonymousGL10)
      {
        AppMethodBeat.i(221754);
        if (sc.a(sc.this) == 0L)
        {
          AppMethodBeat.o(221754);
          return;
        }
        sc.c(sc.this).nativeMapLoadKMLFile(sc.a(sc.this), paramString);
        AppMethodBeat.o(221754);
      }
    });
    AppMethodBeat.o(224315);
  }
  
  private void i(final int paramInt)
  {
    AppMethodBeat.i(223734);
    a(new mk.a()
    {
      public final void a(GL10 paramAnonymousGL10)
      {
        AppMethodBeat.i(222972);
        if (sc.a(sc.this) == 0L)
        {
          AppMethodBeat.o(222972);
          return;
        }
        sc.c(sc.this).nativeRemoveMaskLayer(sc.a(sc.this), paramInt);
        AppMethodBeat.o(222972);
      }
    });
    AppMethodBeat.o(223734);
  }
  
  private void i(final pv parampv)
  {
    AppMethodBeat.i(223910);
    if (this.e == 0L)
    {
      AppMethodBeat.o(223910);
      return;
    }
    a(new mk.a()
    {
      public final void a(GL10 paramAnonymousGL10)
      {
        AppMethodBeat.i(226016);
        int i = parampv.q;
        if (i == -1)
        {
          AppMethodBeat.o(226016);
          return;
        }
        sc.c(sc.this).nativeSetDrawCap(sc.a(sc.this), i, parampv.a.z);
        AppMethodBeat.o(226016);
      }
    });
    AppMethodBeat.o(223910);
  }
  
  private void i(final String paramString)
  {
    AppMethodBeat.i(224362);
    if (this.e == 0L)
    {
      AppMethodBeat.o(224362);
      return;
    }
    a(new mk.a()
    {
      public final void a(GL10 paramAnonymousGL10)
      {
        AppMethodBeat.i(225833);
        if (sc.a(sc.this) != 0L) {
          sc.c(sc.this).nativeSetServerHost(sc.a(sc.this), paramString);
        }
        AppMethodBeat.o(225833);
      }
    });
    AppMethodBeat.o(224362);
  }
  
  private void j(final int paramInt)
  {
    AppMethodBeat.i(224010);
    a(new mk.a()
    {
      public final void a(GL10 paramAnonymousGL10)
      {
        AppMethodBeat.i(222622);
        if (sc.a(sc.this) == 0L)
        {
          AppMethodBeat.o(222622);
          return;
        }
        sc.c(sc.this).nativeSetIndoorConfigType(sc.a(sc.this), paramInt);
        AppMethodBeat.o(222622);
      }
    });
    AppMethodBeat.o(224010);
  }
  
  private void j(final pv parampv)
  {
    AppMethodBeat.i(223919);
    if (this.e == 0L)
    {
      AppMethodBeat.o(223919);
      return;
    }
    a(new mk.a()
    {
      public final void a(GL10 paramAnonymousGL10)
      {
        AppMethodBeat.i(223642);
        int i = parampv.q;
        if (i == -1)
        {
          AppMethodBeat.o(223642);
          return;
        }
        paramAnonymousGL10 = parampv.p;
        if (paramAnonymousGL10 == null)
        {
          AppMethodBeat.o(223642);
          return;
        }
        sc.c(sc.this).nativeLineInsertPoint(sc.a(sc.this), i, paramAnonymousGL10, parampv.o);
        AppMethodBeat.o(223642);
      }
    });
    AppMethodBeat.o(223919);
  }
  
  private void j(final String paramString)
  {
    AppMethodBeat.i(224373);
    if (this.e == 0L)
    {
      AppMethodBeat.o(224373);
      return;
    }
    a(new mk.a()
    {
      public final void a(GL10 paramAnonymousGL10)
      {
        AppMethodBeat.i(225720);
        if (sc.a(sc.this) != 0L) {
          sc.c(sc.this).nativeMapSetSatelliteServerFullUrl(sc.a(sc.this), paramString);
        }
        AppMethodBeat.o(225720);
      }
    });
    AppMethodBeat.o(224373);
  }
  
  private static void j(boolean paramBoolean)
  {
    y = paramBoolean;
  }
  
  private int k(final String paramString)
  {
    AppMethodBeat.i(224426);
    int i1 = ((Integer)a(new CallbackRunnable()
    {
      private Integer a()
      {
        AppMethodBeat.i(226102);
        if (sc.a(sc.this) == 0L)
        {
          AppMethodBeat.o(226102);
          return Integer.valueOf(-1);
        }
        int i = sc.c(sc.this).getIndoorOutlineZoom(sc.a(sc.this), paramString);
        AppMethodBeat.o(226102);
        return Integer.valueOf(i);
      }
    }, Integer.valueOf(-1))).intValue();
    AppMethodBeat.o(224426);
    return i1;
  }
  
  private void k(final int paramInt)
  {
    AppMethodBeat.i(224019);
    a(new mk.a()
    {
      public final void a(GL10 paramAnonymousGL10)
      {
        AppMethodBeat.i(222643);
        if ((0L == sc.a(sc.this)) || (sc.d(sc.this) == null))
        {
          AppMethodBeat.o(222643);
          return;
        }
        sc.c(sc.this).nativeSetIndoorFloor(sc.a(sc.this), paramInt);
        AppMethodBeat.o(222643);
      }
    });
    AppMethodBeat.o(224019);
  }
  
  private void k(final pv parampv)
  {
    AppMethodBeat.i(223929);
    if (this.e == 0L)
    {
      AppMethodBeat.o(223929);
      return;
    }
    a(new mk.a()
    {
      public final void a(GL10 paramAnonymousGL10)
      {
        AppMethodBeat.i(223654);
        int i = parampv.q;
        if (i == -1)
        {
          AppMethodBeat.o(223654);
          return;
        }
        paramAnonymousGL10 = parampv.p;
        if (paramAnonymousGL10 == null)
        {
          AppMethodBeat.o(223654);
          return;
        }
        sc.c(sc.this).nativeLineClearPoint(sc.a(sc.this), i, paramAnonymousGL10, parampv.o);
        AppMethodBeat.o(223654);
      }
    });
    AppMethodBeat.o(223929);
  }
  
  private void k(final boolean paramBoolean)
  {
    AppMethodBeat.i(223937);
    a(new mk.a()
    {
      public final void a(GL10 paramAnonymousGL10)
      {
        AppMethodBeat.i(223721);
        if (0L != sc.a(sc.this)) {
          sc.c(sc.this).nativeSetBuilding3DEffect(sc.a(sc.this), paramBoolean);
        }
        AppMethodBeat.o(223721);
      }
    });
    AppMethodBeat.o(223937);
  }
  
  private void l(final int paramInt)
  {
    AppMethodBeat.i(224084);
    if (0L == this.e)
    {
      AppMethodBeat.o(224084);
      return;
    }
    a(new mk.a()
    {
      public final void a(GL10 paramAnonymousGL10)
      {
        AppMethodBeat.i(222955);
        if (sc.a(sc.this) != 0L) {
          sc.c(sc.this).nativeSetIndoorMaskColor(sc.a(sc.this), paramInt);
        }
        AppMethodBeat.o(222955);
      }
    });
    AppMethodBeat.o(224084);
  }
  
  private void l(final pv parampv)
  {
    AppMethodBeat.i(224351);
    a(new mk.a()
    {
      public final void a(GL10 paramAnonymousGL10)
      {
        AppMethodBeat.i(225844);
        if (sc.a(sc.this) == 0L)
        {
          AppMethodBeat.o(225844);
          return;
        }
        int i = parampv.q;
        if (i == -1)
        {
          AppMethodBeat.o(225844);
          return;
        }
        if (parampv.a.I < 0.0F)
        {
          AppMethodBeat.o(225844);
          return;
        }
        int j = parampv.a.C;
        if ((j == 3) || (j == 0))
        {
          sc.c(sc.this).nativeSetLineArrowSpacing(sc.a(sc.this), i, parampv.a.I);
          AppMethodBeat.o(225844);
          return;
        }
        sc.c(sc.this).nativeSetLineFootPrintSpacing(sc.a(sc.this), i, parampv.a.I);
        AppMethodBeat.o(225844);
      }
    });
    AppMethodBeat.o(224351);
  }
  
  private void l(final boolean paramBoolean)
  {
    AppMethodBeat.i(224101);
    if (this.e == 0L)
    {
      AppMethodBeat.o(224101);
      return;
    }
    a(new mk.a()
    {
      public final void a(GL10 paramAnonymousGL10)
      {
        AppMethodBeat.i(222980);
        if (sc.a(sc.this) != 0L) {
          sc.c(sc.this).nativeSetIndoorBuildingPickEnabled(sc.a(sc.this), paramBoolean);
        }
        AppMethodBeat.o(222980);
      }
    });
    AppMethodBeat.o(224101);
  }
  
  private void m(final int paramInt)
  {
    AppMethodBeat.i(224123);
    if (0L == this.e)
    {
      AppMethodBeat.o(224123);
      return;
    }
    a(new mk.a()
    {
      public final void a(GL10 paramAnonymousGL10)
      {
        AppMethodBeat.i(223008);
        if (sc.a(sc.this) != 0L) {
          sc.c(sc.this).nativeSetLocationCircleColor(sc.a(sc.this), paramInt);
        }
        AppMethodBeat.o(223008);
      }
    });
    AppMethodBeat.o(224123);
  }
  
  private void m(final boolean paramBoolean)
  {
    AppMethodBeat.i(224133);
    if (0L == this.e)
    {
      AppMethodBeat.o(224133);
      return;
    }
    a(new mk.a()
    {
      public final void a(GL10 paramAnonymousGL10)
      {
        AppMethodBeat.i(223014);
        if (sc.a(sc.this) != 0L) {
          sc.c(sc.this).nativeSetLocationCircleHidden(sc.a(sc.this), paramBoolean);
        }
        AppMethodBeat.o(223014);
      }
    });
    AppMethodBeat.o(224133);
  }
  
  private void n(final int paramInt)
  {
    AppMethodBeat.i(224191);
    if ((0L == this.e) || (this.j == null))
    {
      AppMethodBeat.o(224191);
      return;
    }
    this.j.a(new mk.a()
    {
      public final void a(GL10 paramAnonymousGL10)
      {
        AppMethodBeat.i(221516);
        if (sc.a(sc.this) != 0L) {
          sc.c(sc.this).nativeSetScaleLevel(sc.a(sc.this), paramInt, this.b);
        }
        AppMethodBeat.o(221516);
      }
    });
    AppMethodBeat.o(224191);
  }
  
  private void n(final boolean paramBoolean)
  {
    AppMethodBeat.i(224340);
    if (this.e == 0L)
    {
      AppMethodBeat.o(224340);
      return;
    }
    a(new mk.a()
    {
      public final void a(GL10 paramAnonymousGL10)
      {
        AppMethodBeat.i(221710);
        if (sc.a(sc.this) != 0L) {
          sc.c(sc.this).nativeReleaseEngineResource(sc.a(sc.this), paramBoolean);
        }
        AppMethodBeat.o(221710);
      }
    });
    AppMethodBeat.o(224340);
  }
  
  private void o(final int paramInt)
  {
    AppMethodBeat.i(224320);
    a(new mk.a()
    {
      public final void a(GL10 paramAnonymousGL10)
      {
        AppMethodBeat.i(221742);
        if (sc.a(sc.this) == 0L)
        {
          AppMethodBeat.o(221742);
          return;
        }
        sc.c(sc.this).nativeSetLanguage(sc.a(sc.this), paramInt);
        AppMethodBeat.o(221742);
      }
    });
    AppMethodBeat.o(224320);
  }
  
  private void o(final boolean paramBoolean)
  {
    AppMethodBeat.i(224385);
    a(new mk.a()
    {
      public final void a(GL10 paramAnonymousGL10)
      {
        AppMethodBeat.i(225764);
        if (sc.a(sc.this) == 0L)
        {
          AppMethodBeat.o(225764);
          return;
        }
        sc.c(sc.this).nativeEnableBaseMap(sc.a(sc.this), paramBoolean);
        AppMethodBeat.o(225764);
      }
    });
    AppMethodBeat.o(224385);
  }
  
  private void p(final boolean paramBoolean)
  {
    AppMethodBeat.i(224397);
    a(new mk.a()
    {
      public final void a(GL10 paramAnonymousGL10)
      {
        AppMethodBeat.i(225460);
        if (sc.a(sc.this) == 0L)
        {
          AppMethodBeat.o(225460);
          return;
        }
        sc.c(sc.this).nativeEnableBuilding(sc.a(sc.this), paramBoolean);
        AppMethodBeat.o(225460);
      }
    });
    AppMethodBeat.o(224397);
  }
  
  private boolean p(final int paramInt)
  {
    AppMethodBeat.i(224440);
    boolean bool = ((Boolean)a(new CallbackRunnable()
    {
      private Boolean a()
      {
        AppMethodBeat.i(226242);
        if (sc.a(sc.this) == 0L)
        {
          Boolean localBoolean = Boolean.FALSE;
          AppMethodBeat.o(226242);
          return localBoolean;
        }
        boolean bool = sc.c(sc.this).checkMapLoadFinishedTask(sc.a(sc.this), paramInt);
        AppMethodBeat.o(226242);
        return Boolean.valueOf(bool);
      }
    }, Boolean.FALSE)).booleanValue();
    AppMethodBeat.o(224440);
    return bool;
  }
  
  private void q(final int paramInt)
  {
    AppMethodBeat.i(224483);
    a(new mk.a()
    {
      public final void a(GL10 paramAnonymousGL10)
      {
        AppMethodBeat.i(223660);
        if (sc.a(sc.this) == 0L)
        {
          AppMethodBeat.o(223660);
          return;
        }
        sc.c(sc.this).nativeSetMapFontSize(sc.a(sc.this), paramInt);
        AppMethodBeat.o(223660);
      }
    });
    AppMethodBeat.o(224483);
  }
  
  public final double a(final Rect paramRect1, final Rect paramRect2)
  {
    AppMethodBeat.i(224989);
    double d1 = ((Double)a(new CallbackRunnable()
    {
      private Double a()
      {
        AppMethodBeat.i(223755);
        if (0L == sc.a(sc.this))
        {
          AppMethodBeat.o(223755);
          return Double.valueOf(1.0D);
        }
        double d = sc.c(sc.this).nativeGetTargetScale(sc.a(sc.this), paramRect1, paramRect2);
        AppMethodBeat.o(223755);
        return Double.valueOf(d);
      }
    }, Double.valueOf(1.0D))).doubleValue();
    AppMethodBeat.o(224989);
    return d1;
  }
  
  public final int a(final long paramLong)
  {
    AppMethodBeat.i(225403);
    int i1 = ((Integer)a(new CallbackRunnable()
    {
      private Integer a()
      {
        AppMethodBeat.i(223431);
        if (sc.a(sc.this) == 0L)
        {
          AppMethodBeat.o(223431);
          return Integer.valueOf(0);
        }
        int i = sc.c(sc.this).nativeGetEngineId(paramLong);
        AppMethodBeat.o(223431);
        return Integer.valueOf(i);
      }
    }, Integer.valueOf(0))).intValue();
    AppMethodBeat.o(225403);
    return i1;
  }
  
  public final int a(final TileOverlayCallback paramTileOverlayCallback, final boolean paramBoolean)
  {
    AppMethodBeat.i(225223);
    int i1 = ((Integer)a(new CallbackRunnable()
    {
      private Integer a()
      {
        AppMethodBeat.i(222109);
        if (sc.a(sc.this) == 0L)
        {
          AppMethodBeat.o(222109);
          return Integer.valueOf(-1);
        }
        int i = sc.c(sc.this).nativeAddTileOverlay(sc.a(sc.this), paramTileOverlayCallback, paramBoolean);
        AppMethodBeat.o(222109);
        return Integer.valueOf(i);
      }
    }, Integer.valueOf(-1))).intValue();
    AppMethodBeat.o(225223);
    return i1;
  }
  
  public final int a(final String paramString, final float paramFloat1, final float paramFloat2)
  {
    AppMethodBeat.i(225031);
    if (0L == this.e)
    {
      AppMethodBeat.o(225031);
      return 0;
    }
    int i1 = ((Integer)a(new CallbackRunnable()
    {
      private Integer a()
      {
        AppMethodBeat.i(222998);
        if (0L == sc.a(sc.this))
        {
          AppMethodBeat.o(222998);
          return Integer.valueOf(0);
        }
        int i = sc.c(sc.this).nativeSetLocationMarkerImage(sc.a(sc.this), paramString, paramFloat1, paramFloat2);
        AppMethodBeat.o(222998);
        return Integer.valueOf(i);
      }
    }, Integer.valueOf(0))).intValue();
    AppMethodBeat.o(225031);
    return i1;
  }
  
  public final PointF a(final double paramDouble1, double paramDouble2)
  {
    AppMethodBeat.i(224853);
    PointF localPointF = (PointF)b(new CallbackRunnable()new PointF
    {
      private PointF a()
      {
        AppMethodBeat.i(222981);
        if (sc.a(sc.this) == 0L)
        {
          localObject = new PointF();
          AppMethodBeat.o(222981);
          return localObject;
        }
        Object localObject = new float[2];
        sc.c(sc.this).nativeToScreenLocation(sc.a(sc.this), this.a, paramDouble1, this.c, (float[])localObject);
        localObject = new PointF(localObject[0], localObject[1]);
        AppMethodBeat.o(222981);
        return localObject;
      }
    }, new PointF());
    AppMethodBeat.o(224853);
    return localPointF;
  }
  
  public final TappedElement a(final float paramFloat1, final float paramFloat2)
  {
    AppMethodBeat.i(224895);
    TappedElement localTappedElement = (TappedElement)a(new CallbackRunnable()
    {
      private TappedElement a()
      {
        AppMethodBeat.i(223683);
        if (sc.a(sc.this) == 0L)
        {
          AppMethodBeat.o(223683);
          return null;
        }
        Object localObject = sc.c(sc.this).nativeOnTap(sc.a(sc.this), paramFloat1, paramFloat2);
        if (localObject == null)
        {
          AppMethodBeat.o(223683);
          return null;
        }
        try
        {
          localObject = TappedElement.fromBytes((byte[])localObject);
          AppMethodBeat.o(223683);
          return localObject;
        }
        catch (Exception localException)
        {
          AppMethodBeat.o(223683);
        }
        return null;
      }
    }, null);
    AppMethodBeat.o(224895);
    return localTappedElement;
  }
  
  public final <T> T a(CallbackRunnable<T> paramCallbackRunnable, T paramT)
  {
    AppMethodBeat.i(225528);
    if ((this.j == null) || (this.e == 0L))
    {
      AppMethodBeat.o(225528);
      return paramT;
    }
    try
    {
      this.m.lock();
      paramCallbackRunnable = b(paramCallbackRunnable, paramT);
      return paramCallbackRunnable;
    }
    catch (Exception paramCallbackRunnable)
    {
      kh.a("TDZ", "safeCallSyncEngine", paramCallbackRunnable);
      return paramT;
    }
    finally
    {
      this.m.unlock();
      AppMethodBeat.o(225528);
    }
  }
  
  public final String a()
  {
    String str = this.A;
    this.A = null;
    return str;
  }
  
  public final String a(final GeoPoint paramGeoPoint)
  {
    AppMethodBeat.i(224888);
    paramGeoPoint = (String)a(new CallbackRunnable()
    {
      private String a()
      {
        AppMethodBeat.i(222809);
        if (sc.a(sc.this) == 0L)
        {
          AppMethodBeat.o(222809);
          return "";
        }
        Object localObject = sc.c(sc.this).nativeGetCityName(sc.a(sc.this), paramGeoPoint);
        if (localObject != null) {
          try
          {
            localObject = new String((byte[])localObject, "GBK").trim();
            AppMethodBeat.o(222809);
            return localObject;
          }
          catch (UnsupportedEncodingException localUnsupportedEncodingException) {}
        }
        AppMethodBeat.o(222809);
        return "";
      }
    }, "");
    AppMethodBeat.o(224888);
    return paramGeoPoint;
  }
  
  public final void a(final float paramFloat)
  {
    AppMethodBeat.i(224924);
    if ((0L == this.e) || (this.j == null))
    {
      AppMethodBeat.o(224924);
      return;
    }
    a(new mk.a()
    {
      public final void a(GL10 paramAnonymousGL10)
      {
        AppMethodBeat.i(223076);
        if (sc.a(sc.this) != 0L) {
          sc.c(sc.this).nativeSetLocationHeading(sc.a(sc.this), paramFloat);
        }
        AppMethodBeat.o(223076);
      }
    });
    AppMethodBeat.o(224924);
  }
  
  public final void a(final float paramFloat1, final float paramFloat2, final boolean paramBoolean)
  {
    AppMethodBeat.i(225133);
    if ((0L == this.e) || (this.j == null))
    {
      AppMethodBeat.o(225133);
      return;
    }
    e(new CallbackRunnable()
    {
      private Boolean a()
      {
        AppMethodBeat.i(221840);
        Object localObject;
        if (sc.a(sc.this) == 0L)
        {
          localObject = Boolean.FALSE;
          AppMethodBeat.o(221840);
          return localObject;
        }
        if (paramBoolean) {
          sc.c(sc.this).nativeSetScreenCenterOffset(sc.a(sc.this), paramFloat1, paramFloat2, true);
        }
        for (;;)
        {
          localObject = Boolean.TRUE;
          AppMethodBeat.o(221840);
          return localObject;
          localObject = sc.d(sc.this).n;
          fl localfl1 = ((ep)localObject).a(sc.this.n());
          sc.c(sc.this).nativeSetScreenCenterOffset(sc.a(sc.this), paramFloat1, paramFloat2, false);
          fl localfl2 = ((ep)localObject).a(sc.this.n());
          double d1 = localfl2.a;
          double d2 = localfl1.a;
          double d3 = localfl2.b;
          double d4 = localfl1.b;
          localObject = ((ep)localObject).a(new fl(d1 - d2 + localfl2.a, d3 - d4 + localfl2.b));
          sc.c(sc.this).nativeSetCenter(sc.a(sc.this), (GeoPoint)localObject, false);
        }
      }
    }, Boolean.FALSE);
    AppMethodBeat.o(225133);
  }
  
  public final void a(final int paramInt)
  {
    AppMethodBeat.i(225171);
    a(new mk.a()
    {
      public final void a(GL10 paramAnonymousGL10)
      {
        AppMethodBeat.i(222371);
        if (0L == sc.a(sc.this))
        {
          AppMethodBeat.o(222371);
          return;
        }
        sc.c(sc.this).nativeSetMaxScaleLevel(sc.a(sc.this), paramInt);
        AppMethodBeat.o(222371);
      }
    });
    AppMethodBeat.o(225171);
  }
  
  public final void a(final int paramInt, final float paramFloat)
  {
    AppMethodBeat.i(225307);
    a(new mk.a()
    {
      public final void a(GL10 paramAnonymousGL10)
      {
        AppMethodBeat.i(221507);
        if (sc.a(sc.this) == 0L)
        {
          AppMethodBeat.o(221507);
          return;
        }
        sc.c(sc.this).nativeSetPriority(sc.a(sc.this), paramInt, paramFloat);
        AppMethodBeat.o(221507);
      }
    });
    AppMethodBeat.o(225307);
  }
  
  public final void a(final int paramInt1, final int paramInt2)
  {
    AppMethodBeat.i(224977);
    if (0L == this.e)
    {
      AppMethodBeat.o(224977);
      return;
    }
    a(new mk.a()
    {
      public final void a(GL10 paramAnonymousGL10)
      {
        AppMethodBeat.i(225040);
        if (sc.a(sc.this) != 0L) {
          sc.c(sc.this).nativeSetCompassPosition(sc.a(sc.this), paramInt1, paramInt2);
        }
        AppMethodBeat.o(225040);
      }
    });
    AppMethodBeat.o(224977);
  }
  
  public final void a(final int paramInt1, final int paramInt2, final int paramInt3)
  {
    AppMethodBeat.i(225238);
    if ((this.e == 0L) || (this.j == null))
    {
      AppMethodBeat.o(225238);
      return;
    }
    a(new mk.a()
    {
      public final void a(GL10 paramAnonymousGL10)
      {
        AppMethodBeat.i(222237);
        if (sc.a(sc.this) != 0L) {
          sc.c(sc.this).nativeSetTileOverlayDataLevelRange(sc.a(sc.this), paramInt1, paramInt2, paramInt3);
        }
        AppMethodBeat.o(222237);
      }
    });
    AppMethodBeat.o(225238);
  }
  
  public final void a(final int paramInt1, final int paramInt2, final int paramInt3, final int paramInt4)
  {
    AppMethodBeat.i(225146);
    if ((0L == this.e) || (this.j == null))
    {
      AppMethodBeat.o(225146);
      return;
    }
    a(new mk.a()
    {
      public final void a(GL10 paramAnonymousGL10)
      {
        AppMethodBeat.i(221852);
        if (sc.a(sc.this) != 0L) {
          sc.c(sc.this).nativeSetViewport(sc.a(sc.this), paramInt1, paramInt2, paramInt3, paramInt4);
        }
        AppMethodBeat.o(221852);
      }
    });
    AppMethodBeat.o(225146);
  }
  
  public final void a(final Rect paramRect1, final Rect paramRect2, final boolean paramBoolean)
  {
    AppMethodBeat.i(225000);
    if ((0L == this.e) || (this.j == null))
    {
      AppMethodBeat.o(225000);
      return;
    }
    a(new mk.a()
    {
      public final void a(GL10 paramAnonymousGL10)
      {
        AppMethodBeat.i(223805);
        if (sc.a(sc.this) != 0L) {
          sc.c(sc.this).nativeZoomToSpan(sc.a(sc.this), paramRect1, paramRect2, paramBoolean);
        }
        AppMethodBeat.o(223805);
      }
    });
    AppMethodBeat.o(225000);
  }
  
  public final void a(final GeoPoint paramGeoPoint, final float paramFloat1, final float paramFloat2, final boolean paramBoolean)
  {
    AppMethodBeat.i(224913);
    if ((0L == this.e) || (this.j == null))
    {
      AppMethodBeat.o(224913);
      return;
    }
    a(new mk.a()
    {
      public final void a(GL10 paramAnonymousGL10)
      {
        AppMethodBeat.i(223068);
        if (sc.a(sc.this) != 0L) {
          sc.c(sc.this).nativeSetLocationInfo(sc.a(sc.this), paramGeoPoint.getLatitudeE6() / 1000000.0D, paramGeoPoint.getLongitudeE6() / 1000000.0D, paramFloat1, paramFloat2, paramBoolean);
        }
        AppMethodBeat.o(223068);
      }
    });
    AppMethodBeat.o(224913);
  }
  
  public final void a(final GeoPoint paramGeoPoint, final int paramInt)
  {
    AppMethodBeat.i(225086);
    if ((0L == this.e) || (this.j == null))
    {
      AppMethodBeat.o(225086);
      return;
    }
    this.j.a(new mk.a()
    {
      public final void a(GL10 paramAnonymousGL10)
      {
        AppMethodBeat.i(221573);
        if (sc.a(sc.this) != 0L) {
          sc.c(sc.this).nativeSetCenterMapPointAndScaleLevel(sc.a(sc.this), paramGeoPoint, paramInt, this.c);
        }
        AppMethodBeat.o(221573);
      }
    });
    AppMethodBeat.o(225086);
  }
  
  public final void a(final GeoPoint paramGeoPoint, final boolean paramBoolean)
  {
    AppMethodBeat.i(225076);
    if ((0L == this.e) || (this.j == null))
    {
      AppMethodBeat.o(225076);
      return;
    }
    this.j.a(new mk.a()
    {
      public final void a(GL10 paramAnonymousGL10)
      {
        AppMethodBeat.i(221567);
        if (sc.a(sc.this) != 0L) {
          sc.c(sc.this).nativeSetCenter(sc.a(sc.this), paramGeoPoint, paramBoolean);
        }
        AppMethodBeat.o(221567);
      }
    });
    AppMethodBeat.o(225076);
  }
  
  public final void a(final mk.a parama)
  {
    AppMethodBeat.i(225512);
    if ((this.j == null) || (this.e == 0L))
    {
      AppMethodBeat.o(225512);
      return;
    }
    c(new CallbackRunnable()
    {
      public final Object run()
      {
        AppMethodBeat.i(222498);
        parama.a(null);
        AppMethodBeat.o(222498);
        return null;
      }
    }, null);
    AppMethodBeat.o(225512);
  }
  
  public final void a(final TrafficStyle paramTrafficStyle)
  {
    AppMethodBeat.i(225443);
    a(new mk.a()
    {
      public final void a(GL10 paramAnonymousGL10)
      {
        AppMethodBeat.i(222595);
        if (sc.a(sc.this) == 0L)
        {
          AppMethodBeat.o(222595);
          return;
        }
        sc.c(sc.this).setTrafficStyle(sc.a(sc.this), paramTrafficStyle);
        AppMethodBeat.o(222595);
      }
    });
    AppMethodBeat.o(225443);
  }
  
  public final void a(String paramString)
  {
    this.A = paramString;
  }
  
  public final void a(String paramString, lb paramlb)
  {
    AppMethodBeat.i(224950);
    Object localObject = DataSource.get(paramlb.b);
    kh.b("TTO", "onCancelDownload DataSource:" + localObject + " uri:" + paramString);
    if (localObject == DataSource.TILE_OVERLAY)
    {
      paramlb = (MapTileID)paramlb.d;
      int i1 = paramlb.getTileTag();
      kh.b("TTO", "onCancelDownload tileOverlayId:".concat(String.valueOf(i1)));
      localObject = this.j.H.a(i1);
      if (localObject != null)
      {
        kh.c("TTO", "onCancelDownload found TileOverlay");
        ((pz)localObject).d().a(paramString);
        kl.e("TTO", "cancel-count");
        kl.e("TTO", "C/" + paramlb.getX() + "-" + paramlb.getY() + "-" + paramlb.getZ());
        AppMethodBeat.o(224950);
        return;
      }
    }
    this.g.a(paramString);
    AppMethodBeat.o(224950);
  }
  
  public final void a(final String paramString1, final String paramString2)
  {
    AppMethodBeat.i(225360);
    a(new mk.a()
    {
      public final void a(GL10 paramAnonymousGL10)
      {
        AppMethodBeat.i(225486);
        if (sc.a(sc.this) == 0L)
        {
          AppMethodBeat.o(225486);
          return;
        }
        sc.c(sc.this).nativeSetBuildingToSpecificFloor(sc.a(sc.this), paramString1, paramString2);
        if (sc.f(sc.this) != null) {
          sc.f(sc.this).c();
        }
        AppMethodBeat.o(225486);
      }
    });
    AppMethodBeat.o(225360);
  }
  
  public final void a(final List<MapRouteSection> paramList, final List<GeoPoint> paramList1)
  {
    AppMethodBeat.i(225320);
    a(new mk.a()
    {
      public final void a(GL10 paramAnonymousGL10)
      {
        AppMethodBeat.i(221963);
        if (0L == sc.a(sc.this))
        {
          AppMethodBeat.o(221963);
          return;
        }
        if ((paramList != null) && (!paramList.isEmpty()) && (paramList1 != null) && (!paramList1.isEmpty()))
        {
          int j = paramList.size();
          paramAnonymousGL10 = new byte[j][];
          int i = 0;
          while (i < j)
          {
            MapRouteSection localMapRouteSection = (MapRouteSection)paramList.get(i);
            if (localMapRouteSection != null) {
              paramAnonymousGL10[i] = localMapRouteSection.toBytes();
            }
            i += 1;
          }
          i = paramList1.size();
          sc.c(sc.this).nativeAddRouteNameSegments(sc.a(sc.this), paramAnonymousGL10, j, (GeoPoint[])paramList1.toArray(new GeoPoint[i]), i);
        }
        AppMethodBeat.o(221963);
      }
    });
    AppMethodBeat.o(225320);
  }
  
  public final void a(final boolean paramBoolean)
  {
    AppMethodBeat.i(224881);
    a(new mk.a()
    {
      public final void a(GL10 paramAnonymousGL10)
      {
        AppMethodBeat.i(222851);
        if (sc.a(sc.this) == 0L)
        {
          AppMethodBeat.o(222851);
          return;
        }
        sc.c(sc.this).nativeSetSatelliteEnabled(sc.a(sc.this), paramBoolean);
        AppMethodBeat.o(222851);
      }
    });
    AppMethodBeat.o(224881);
  }
  
  public final void a(final double[] paramArrayOfDouble1, final double[] paramArrayOfDouble2, final int paramInt)
  {
    AppMethodBeat.i(225376);
    a(new mk.a()
    {
      public final void a(GL10 paramAnonymousGL10)
      {
        AppMethodBeat.i(226221);
        if (sc.a(sc.this) == 0L)
        {
          AppMethodBeat.o(226221);
          return;
        }
        sc.c(sc.this).setRestrictBounds(sc.a(sc.this), paramArrayOfDouble1, paramArrayOfDouble2, paramInt);
        AppMethodBeat.o(226221);
      }
    });
    AppMethodBeat.o(225376);
  }
  
  public final void a(final int[] paramArrayOfInt, final int paramInt)
  {
    AppMethodBeat.i(224960);
    a(new mk.a()
    {
      public final void a(GL10 paramAnonymousGL10)
      {
        AppMethodBeat.i(224910);
        if (0L == sc.a(sc.this))
        {
          AppMethodBeat.o(224910);
          return;
        }
        sc.c(sc.this).nativeDeleteIcons(sc.a(sc.this), paramArrayOfInt, paramInt);
        AppMethodBeat.o(224910);
      }
    });
    AppMethodBeat.o(224960);
  }
  
  public final boolean a(Context paramContext, nr paramnr, w paramw, String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(224806);
    int[] arrayOfInt = new int[1];
    try
    {
      this.m.lock();
      this.d.initCallback(paramnr, paramw, this, this, this, this, this.j.i, this, this, this);
      this.e = this.d.nativeInitEngine(paramString1, paramString2, paramString3, ha.a(paramContext), 256, ha.a(paramContext), arrayOfInt, false, Language.zh.ordinal());
      if (arrayOfInt[0] != 0)
      {
        kh.a("init engine fail:" + arrayOfInt[0]);
        this.e = 0L;
        return false;
      }
      this.d.registerCallback(this.e);
      this.d.nativeSetTrafficColor(this.e, -14803236, -15611905, -11088785, -16777063);
      return true;
    }
    finally
    {
      this.m.unlock();
      AppMethodBeat.o(224806);
    }
  }
  
  public final <T> T b(CallbackRunnable<T> paramCallbackRunnable, T paramT)
  {
    AppMethodBeat.i(225535);
    if ((paramCallbackRunnable == null) || (this.j == null) || (this.e == 0L))
    {
      AppMethodBeat.o(225535);
      return paramT;
    }
    paramCallbackRunnable = paramCallbackRunnable.run();
    AppMethodBeat.o(225535);
    return paramCallbackRunnable;
  }
  
  public final String b()
  {
    AppMethodBeat.i(225394);
    String str = (String)a(new CallbackRunnable()
    {
      private String a()
      {
        AppMethodBeat.i(225963);
        if (sc.a(sc.this) == 0L)
        {
          AppMethodBeat.o(225963);
          return "";
        }
        String str = sc.c(sc.this).nativeGetEngineLogInfo(sc.a(sc.this));
        AppMethodBeat.o(225963);
        return str;
      }
    }, "");
    AppMethodBeat.o(225394);
    return str;
  }
  
  public final void b(final float paramFloat1, final float paramFloat2)
  {
    AppMethodBeat.i(225064);
    if ((0L == this.e) || (this.j == null))
    {
      AppMethodBeat.o(225064);
      return;
    }
    this.j.a(new mk.a()
    {
      public final void a(GL10 paramAnonymousGL10)
      {
        AppMethodBeat.i(221558);
        if (sc.a(sc.this) != 0L) {
          sc.c(sc.this).nativeMoveBy(sc.a(sc.this), paramFloat1, paramFloat2, this.c);
        }
        AppMethodBeat.o(221558);
      }
    });
    AppMethodBeat.o(225064);
  }
  
  public final void b(final int paramInt)
  {
    AppMethodBeat.i(225180);
    a(new mk.a()
    {
      public final void a(GL10 paramAnonymousGL10)
      {
        AppMethodBeat.i(222392);
        if (0L == sc.a(sc.this))
        {
          AppMethodBeat.o(222392);
          return;
        }
        sc.c(sc.this).nativeSetMinScaleLevel(sc.a(sc.this), paramInt);
        AppMethodBeat.o(222392);
      }
    });
    AppMethodBeat.o(225180);
  }
  
  public final void b(final int paramInt1, final int paramInt2)
  {
    AppMethodBeat.i(225232);
    a(new mk.a()
    {
      public final void a(GL10 paramAnonymousGL10)
      {
        AppMethodBeat.i(222125);
        if (sc.a(sc.this) == 0L)
        {
          AppMethodBeat.o(222125);
          return;
        }
        sc.c(sc.this).nativeSetTileOverlayPriority(sc.a(sc.this), paramInt1, paramInt2);
        AppMethodBeat.o(222125);
      }
    });
    AppMethodBeat.o(225232);
  }
  
  public final void b(final long paramLong)
  {
    AppMethodBeat.i(225413);
    a(new mk.a()
    {
      public final void a(GL10 paramAnonymousGL10)
      {
        AppMethodBeat.i(223647);
        if (sc.a(sc.this) == 0L)
        {
          AppMethodBeat.o(223647);
          return;
        }
        sc.c(sc.this).nativeRemoveEngineOverlay(paramLong);
        AppMethodBeat.o(223647);
      }
    });
    AppMethodBeat.o(225413);
  }
  
  public final void b(final mk.a parama)
  {
    AppMethodBeat.i(225519);
    if ((this.j == null) || (this.e == 0L))
    {
      AppMethodBeat.o(225519);
      return;
    }
    a(new CallbackRunnable()
    {
      public final Object run()
      {
        AppMethodBeat.i(222464);
        parama.a(null);
        AppMethodBeat.o(222464);
        return null;
      }
    }, null);
    AppMethodBeat.o(225519);
  }
  
  public final void b(String paramString, lb paramlb)
  {
    AppMethodBeat.i(224935);
    Object localObject = DataSource.get(paramlb.b);
    kh.b("TTO", "onRequestDownload DataSource:" + localObject + " uri:" + paramString);
    if (localObject == DataSource.TILE_OVERLAY)
    {
      localObject = (MapTileID)paramlb.d;
      int i1 = ((MapTileID)localObject).getTileTag();
      kh.b("TTO", "onRequestDownload tileOverlayId:".concat(String.valueOf(i1)));
      pz localpz = this.j.H.a(i1);
      if (localpz != null)
      {
        kh.c("TTO", "onRequestDownload found TileOverlay");
        le localle = localpz.d();
        localle.a(this.h);
        localle.a(paramString, new qd(localpz.o), paramlb.c);
        kl.e("TTO", "req-count");
        kl.e("TTO", "R/" + ((MapTileID)localObject).getX() + "-" + ((MapTileID)localObject).getY() + "-" + ((MapTileID)localObject).getZ());
        AppMethodBeat.o(224935);
        return;
      }
    }
    this.g.a(paramString, this.j.u.d());
    AppMethodBeat.o(224935);
  }
  
  public final void b(final boolean paramBoolean)
  {
    AppMethodBeat.i(224969);
    if (0L == this.e)
    {
      AppMethodBeat.o(224969);
      return;
    }
    a(new mk.a()
    {
      public final void a(GL10 paramAnonymousGL10)
      {
        AppMethodBeat.i(224998);
        if (sc.a(sc.this) != 0L) {
          sc.c(sc.this).nativeSetCompassVisible(sc.a(sc.this), paramBoolean);
        }
        AppMethodBeat.o(224998);
      }
    });
    AppMethodBeat.o(224969);
  }
  
  public final void c()
  {
    AppMethodBeat.i(225298);
    if (this.i != null) {
      this.i.c();
    }
    AppMethodBeat.o(225298);
  }
  
  public final void c(final float paramFloat1, final float paramFloat2)
  {
    AppMethodBeat.i(225124);
    if ((0L == this.e) || (this.j == null))
    {
      AppMethodBeat.o(225124);
      return;
    }
    this.j.a(new mk.a()
    {
      public final void a(GL10 paramAnonymousGL10)
      {
        AppMethodBeat.i(221532);
        if (sc.a(sc.this) != 0L) {
          sc.c(sc.this).nativeZoomIn(sc.a(sc.this), paramFloat1, paramFloat2);
        }
        AppMethodBeat.o(221532);
      }
    });
    AppMethodBeat.o(225124);
  }
  
  public final void c(int paramInt)
  {
    AppMethodBeat.i(225188);
    if (0L == this.e)
    {
      AppMethodBeat.o(225188);
      return;
    }
    this.d.nativeSetMapStyle(this.e, paramInt, false);
    AppMethodBeat.o(225188);
  }
  
  public final void c(final long paramLong)
  {
    AppMethodBeat.i(225419);
    a(new mk.a()
    {
      public final void a(GL10 paramAnonymousGL10)
      {
        AppMethodBeat.i(224690);
        if (sc.a(sc.this) == 0L)
        {
          AppMethodBeat.o(224690);
          return;
        }
        sc.c(sc.this).nativeRemoveGLVisualizationOverlay(sc.a(sc.this), paramLong);
        AppMethodBeat.o(224690);
      }
    });
    AppMethodBeat.o(225419);
  }
  
  public final void c(final boolean paramBoolean)
  {
    AppMethodBeat.i(225010);
    if ((this.e == 0L) || (this.j == null))
    {
      AppMethodBeat.o(225010);
      return;
    }
    a(new mk.a()
    {
      public final void a(GL10 paramAnonymousGL10)
      {
        AppMethodBeat.i(222571);
        if (sc.a(sc.this) != 0L) {
          sc.c(sc.this).nativeIndoorBuildingEnabled(sc.a(sc.this), paramBoolean);
        }
        AppMethodBeat.o(222571);
      }
    });
    AppMethodBeat.o(225010);
  }
  
  public final void d()
  {
    AppMethodBeat.i(224825);
    b(new mk.a()
    {
      public final void a(GL10 paramAnonymousGL10)
      {
        AppMethodBeat.i(225903);
        if (sc.a(sc.this) == 0L)
        {
          AppMethodBeat.o(225903);
          return;
        }
        sc.c(sc.this).nativeLockEngine(sc.a(sc.this));
        AppMethodBeat.o(225903);
      }
    });
    AppMethodBeat.o(224825);
  }
  
  public final void d(final int paramInt)
  {
    AppMethodBeat.i(225249);
    if ((this.e == 0L) || (this.j == null))
    {
      AppMethodBeat.o(225249);
      return;
    }
    a(new mk.a()
    {
      public final void a(GL10 paramAnonymousGL10)
      {
        AppMethodBeat.i(221428);
        if (sc.a(sc.this) != 0L) {
          sc.c(sc.this).nativeRemoveTileOverlay(sc.a(sc.this), paramInt);
        }
        AppMethodBeat.o(221428);
      }
    });
    AppMethodBeat.o(225249);
  }
  
  public final void d(final boolean paramBoolean)
  {
    AppMethodBeat.i(225022);
    if ((0L == this.e) || (this.j == null))
    {
      AppMethodBeat.o(225022);
      return;
    }
    a(new mk.a()
    {
      public final void a(GL10 paramAnonymousGL10)
      {
        AppMethodBeat.i(222599);
        long l;
        if (sc.a(sc.this) != 0L)
        {
          paramAnonymousGL10 = sc.c(sc.this);
          l = sc.a(sc.this);
          if (!paramBoolean) {
            break label54;
          }
        }
        label54:
        for (int i = 1;; i = 0)
        {
          paramAnonymousGL10.nativeSetIndoorBuildingStyle(l, i);
          AppMethodBeat.o(222599);
          return;
        }
      }
    });
    AppMethodBeat.o(225022);
  }
  
  public final int e()
  {
    AppMethodBeat.i(224817);
    int i1 = ((Integer)a(new CallbackRunnable()
    {
      private Integer a()
      {
        AppMethodBeat.i(222766);
        if (sc.a(sc.this) == 0L)
        {
          AppMethodBeat.o(222766);
          return Integer.valueOf(-1);
        }
        int i = sc.c(sc.this).nativeClearCache(sc.a(sc.this));
        AppMethodBeat.o(222766);
        return Integer.valueOf(i);
      }
    }, Integer.valueOf(-1))).intValue();
    AppMethodBeat.o(224817);
    return i1;
  }
  
  public final void e(final int paramInt)
  {
    AppMethodBeat.i(225255);
    if ((this.e == 0L) || (this.j == null))
    {
      AppMethodBeat.o(225255);
      return;
    }
    a(new mk.a()
    {
      public final void a(GL10 paramAnonymousGL10)
      {
        AppMethodBeat.i(221418);
        if (sc.a(sc.this) != 0L) {
          sc.c(sc.this).nativeReloadTileOverlay(sc.a(sc.this), paramInt);
        }
        AppMethodBeat.o(221418);
      }
    });
    AppMethodBeat.o(225255);
  }
  
  public final void e(final boolean paramBoolean)
  {
    AppMethodBeat.i(225044);
    if (0L == this.e)
    {
      AppMethodBeat.o(225044);
      return;
    }
    a(new mk.a()
    {
      public final void a(GL10 paramAnonymousGL10)
      {
        AppMethodBeat.i(223022);
        if (sc.a(sc.this) != 0L) {
          sc.c(sc.this).nativeSetLocationMarkerHidden(sc.a(sc.this), paramBoolean);
        }
        AppMethodBeat.o(223022);
      }
    });
    AppMethodBeat.o(225044);
  }
  
  public final void f()
  {
    AppMethodBeat.i(224835);
    b(new mk.a()
    {
      public final void a(GL10 paramAnonymousGL10)
      {
        AppMethodBeat.i(223052);
        if (sc.a(sc.this) == 0L)
        {
          AppMethodBeat.o(223052);
          return;
        }
        sc.c(sc.this).nativeUnlockEngine(sc.a(sc.this));
        AppMethodBeat.o(223052);
      }
    });
    AppMethodBeat.o(224835);
  }
  
  public final void f(final int paramInt)
  {
    AppMethodBeat.i(225386);
    a(new mk.a()
    {
      public final void a(GL10 paramAnonymousGL10)
      {
        AppMethodBeat.i(226186);
        if (sc.a(sc.this) == 0L)
        {
          AppMethodBeat.o(226186);
          return;
        }
        sc.c(sc.this).removeLineText(sc.a(sc.this), paramInt);
        AppMethodBeat.o(226186);
      }
    });
    AppMethodBeat.o(225386);
  }
  
  public final void f(final boolean paramBoolean)
  {
    AppMethodBeat.i(225054);
    if (0L == this.e)
    {
      AppMethodBeat.o(225054);
      return;
    }
    a(new mk.a()
    {
      public final void a(GL10 paramAnonymousGL10)
      {
        AppMethodBeat.i(221543);
        if (sc.a(sc.this) != 0L) {
          sc.c(sc.this).nativeSetLocationCompassMarkerHidden(sc.a(sc.this), paramBoolean);
        }
        AppMethodBeat.o(221543);
      }
    });
    AppMethodBeat.o(225054);
  }
  
  public final void g()
  {
    AppMethodBeat.i(225287);
    if (this.j != null) {
      a(new mk.a()
      {
        public final void a(GL10 paramAnonymousGL10)
        {
          AppMethodBeat.i(221370);
          int i;
          float f;
          if (this.a != null)
          {
            paramAnonymousGL10 = this.a;
            if (paramAnonymousGL10.o == null)
            {
              AppMethodBeat.o(221370);
              return;
            }
            paramAnonymousGL10.m = paramAnonymousGL10.p.n();
            i = paramAnonymousGL10.p.p();
            f = paramAnonymousGL10.p.o();
            if (i == paramAnonymousGL10.b.q) {
              break label114;
            }
            paramAnonymousGL10.o.i.c(fv.c);
          }
          for (;;)
          {
            if (paramAnonymousGL10.b != null) {
              paramAnonymousGL10.b.a(i, f);
            }
            paramAnonymousGL10.a = paramAnonymousGL10.p.s();
            AppMethodBeat.o(221370);
            return;
            label114:
            if (f != paramAnonymousGL10.b.p) {
              paramAnonymousGL10.o.i.c(fv.b);
            }
          }
        }
      });
    }
    AppMethodBeat.o(225287);
  }
  
  public final void g(final boolean paramBoolean)
  {
    AppMethodBeat.i(225158);
    a(new mk.a()
    {
      public final void a(GL10 paramAnonymousGL10)
      {
        AppMethodBeat.i(221915);
        if (0L == sc.a(sc.this))
        {
          AppMethodBeat.o(221915);
          return;
        }
        sc.c(sc.this).nativeSetNeedDisplay(sc.a(sc.this), paramBoolean);
        AppMethodBeat.o(221915);
      }
    });
    AppMethodBeat.o(225158);
  }
  
  public final void h()
  {
    AppMethodBeat.i(225480);
    if (this.j != null)
    {
      Object localObject = this.j;
      if ((((mk)localObject).I != null) && (!((mk)localObject).I.isEmpty()))
      {
        localObject = ((mk)localObject).I.iterator();
        while (((Iterator)localObject).hasNext()) {
          ((oc)((Iterator)localObject).next()).h();
        }
      }
    }
    AppMethodBeat.o(225480);
  }
  
  public final void h(final boolean paramBoolean)
  {
    AppMethodBeat.i(225278);
    a(new mk.a()
    {
      public final void a(GL10 paramAnonymousGL10)
      {
        AppMethodBeat.i(221376);
        if (sc.a(sc.this) == 0L)
        {
          AppMethodBeat.o(221376);
          return;
        }
        sc.c(sc.this).nativeSetTileOverlayEnabled(sc.a(sc.this), paramBoolean);
        AppMethodBeat.o(221376);
      }
    });
    AppMethodBeat.o(225278);
  }
  
  public final void i()
  {
    AppMethodBeat.i(225491);
    if (this.j != null)
    {
      Object localObject = this.j;
      if ((((mk)localObject).I != null) && (!((mk)localObject).I.isEmpty()))
      {
        localObject = ((mk)localObject).I.iterator();
        while (((Iterator)localObject).hasNext()) {
          ((oc)((Iterator)localObject).next()).i();
        }
      }
    }
    AppMethodBeat.o(225491);
  }
  
  public final void i(final boolean paramBoolean)
  {
    AppMethodBeat.i(225350);
    a(new mk.a()
    {
      public final void a(GL10 paramAnonymousGL10)
      {
        AppMethodBeat.i(225699);
        if (sc.a(sc.this) == 0L)
        {
          AppMethodBeat.o(225699);
          return;
        }
        sc.c(sc.this).nativeEnablePOI(sc.a(sc.this), paramBoolean);
        AppMethodBeat.o(225699);
      }
    });
    AppMethodBeat.o(225350);
  }
  
  @Deprecated
  public final boolean j()
  {
    AppMethodBeat.i(224844);
    boolean bool = ((Boolean)a(new CallbackRunnable()
    {
      private Boolean a()
      {
        AppMethodBeat.i(225113);
        if (sc.a(sc.this) == 0L)
        {
          Boolean localBoolean = Boolean.TRUE;
          AppMethodBeat.o(225113);
          return localBoolean;
        }
        boolean bool = sc.c(sc.this).nativeIsMapDrawFinished(sc.a(sc.this));
        AppMethodBeat.o(225113);
        return Boolean.valueOf(bool);
      }
    }, Boolean.TRUE)).booleanValue();
    AppMethodBeat.o(224844);
    return bool;
  }
  
  public final void k()
  {
    AppMethodBeat.i(224863);
    a(new mk.a()
    {
      public final void a(GL10 paramAnonymousGL10)
      {
        AppMethodBeat.i(222818);
        if (sc.a(sc.this) == 0L)
        {
          AppMethodBeat.o(222818);
          return;
        }
        sc.c(sc.this).nativeShowStreetRoad(sc.a(sc.this));
        AppMethodBeat.o(222818);
      }
    });
    AppMethodBeat.o(224863);
  }
  
  public final void l()
  {
    AppMethodBeat.i(224873);
    a(new mk.a()
    {
      public final void a(GL10 paramAnonymousGL10)
      {
        AppMethodBeat.i(222864);
        if (sc.a(sc.this) != 0L) {
          sc.c(sc.this).nativeHideStreetRoad(sc.a(sc.this));
        }
        AppMethodBeat.o(222864);
      }
    });
    AppMethodBeat.o(224873);
  }
  
  public final boolean m()
  {
    AppMethodBeat.i(224903);
    boolean bool = ((Boolean)a(new CallbackRunnable()
    {
      private Boolean a()
      {
        AppMethodBeat.i(223710);
        if (sc.a(sc.this) != 0L)
        {
          boolean bool = sc.c(sc.this).nativeNeedRedraw(sc.a(sc.this));
          AppMethodBeat.o(223710);
          return Boolean.valueOf(bool);
        }
        Boolean localBoolean = Boolean.FALSE;
        AppMethodBeat.o(223710);
        return localBoolean;
      }
    }, Boolean.FALSE)).booleanValue();
    AppMethodBeat.o(224903);
    return bool;
  }
  
  public final void m_()
  {
    AppMethodBeat.i(225472);
    if (this.j != null)
    {
      mk localmk = this.j;
      if (localmk.G != null) {
        localmk.G.m_();
      }
    }
    AppMethodBeat.o(225472);
  }
  
  public final GeoPoint n()
  {
    AppMethodBeat.i(225095);
    GeoPoint localGeoPoint = (GeoPoint)a(new CallbackRunnable()new GeoPoint
    {
      private GeoPoint a()
      {
        AppMethodBeat.i(221585);
        if (0L == sc.a(sc.this))
        {
          AppMethodBeat.o(221585);
          return null;
        }
        GeoPoint localGeoPoint = new GeoPoint();
        sc.c(sc.this).nativeGetCenterMapPoint(sc.a(sc.this), localGeoPoint);
        AppMethodBeat.o(221585);
        return localGeoPoint;
      }
    }, new GeoPoint());
    AppMethodBeat.o(225095);
    return localGeoPoint;
  }
  
  public final float o()
  {
    AppMethodBeat.i(225103);
    if (0L == this.e)
    {
      AppMethodBeat.o(225103);
      return 1.0F;
    }
    float f1 = (float)this.d.nativeGetScale(this.e);
    AppMethodBeat.o(225103);
    return f1;
  }
  
  public final int p()
  {
    AppMethodBeat.i(225115);
    if (0L == this.e)
    {
      AppMethodBeat.o(225115);
      return 20;
    }
    int i1 = this.d.nativeGetScaleLevel(this.e);
    AppMethodBeat.o(225115);
    return i1;
  }
  
  public final float q()
  {
    AppMethodBeat.i(225198);
    if (0L == this.e)
    {
      AppMethodBeat.o(225198);
      return 0.0F;
    }
    float f1 = this.d.nativeGetSkew(this.e);
    AppMethodBeat.o(225198);
    return f1;
  }
  
  public final float r()
  {
    AppMethodBeat.i(225209);
    if (0L == this.e)
    {
      AppMethodBeat.o(225209);
      return 0.0F;
    }
    float f1 = this.d.nativeGetRotate(this.e);
    AppMethodBeat.o(225209);
    return f1;
  }
  
  public final int s()
  {
    AppMethodBeat.i(225214);
    if (0L == this.e)
    {
      AppMethodBeat.o(225214);
      return 1;
    }
    int i1 = this.d.nativeGetMapStyle(this.e);
    AppMethodBeat.o(225214);
    return i1;
  }
  
  public final boolean t()
  {
    AppMethodBeat.i(225264);
    boolean bool = ((Boolean)a(new CallbackRunnable()
    {
      private Boolean a()
      {
        AppMethodBeat.i(221462);
        if (sc.a(sc.this) == 0L)
        {
          Boolean localBoolean = Boolean.FALSE;
          AppMethodBeat.o(221462);
          return localBoolean;
        }
        boolean bool = sc.c(sc.this).nativeIsTileOverlayEnabled(sc.a(sc.this));
        AppMethodBeat.o(221462);
        return Boolean.valueOf(bool);
      }
    }, Boolean.FALSE)).booleanValue();
    AppMethodBeat.o(225264);
    return bool;
  }
  
  public final void u()
  {
    AppMethodBeat.i(225329);
    a(new mk.a()
    {
      public final void a(GL10 paramAnonymousGL10)
      {
        AppMethodBeat.i(222020);
        if (0L == sc.a(sc.this))
        {
          AppMethodBeat.o(222020);
          return;
        }
        sc.c(sc.this).nativeClearRouteNameSegments(sc.a(sc.this));
        AppMethodBeat.o(222020);
      }
    });
    AppMethodBeat.o(225329);
  }
  
  public final int v()
  {
    AppMethodBeat.i(225342);
    int i1 = ((Integer)a(new CallbackRunnable()
    {
      private Integer a()
      {
        AppMethodBeat.i(221665);
        if (sc.a(sc.this) == 0L)
        {
          AppMethodBeat.o(221665);
          return Integer.valueOf(0);
        }
        int i = sc.c(sc.this).nativeGetLanguage(sc.a(sc.this));
        AppMethodBeat.o(221665);
        return Integer.valueOf(i);
      }
    }, Integer.valueOf(0))).intValue();
    AppMethodBeat.o(225342);
    return i1;
  }
  
  public final ArrayList<MapPoi> w()
  {
    AppMethodBeat.i(225367);
    ArrayList localArrayList = (ArrayList)a(new CallbackRunnable()
    {
      private ArrayList<MapPoi> a()
      {
        AppMethodBeat.i(226189);
        if (sc.a(sc.this) == 0L)
        {
          AppMethodBeat.o(226189);
          return null;
        }
        ArrayList localArrayList = sc.c(sc.this).nativeGetPoisInScreen(sc.a(sc.this));
        AppMethodBeat.o(226189);
        return localArrayList;
      }
    }, null);
    AppMethodBeat.o(225367);
    return localArrayList;
  }
  
  public final boolean x()
  {
    AppMethodBeat.i(225428);
    boolean bool = ((Boolean)a(new CallbackRunnable()
    {
      private Boolean a()
      {
        AppMethodBeat.i(224097);
        if (sc.a(sc.this) == 0L)
        {
          Boolean localBoolean = Boolean.FALSE;
          AppMethodBeat.o(224097);
          return localBoolean;
        }
        boolean bool = sc.c(sc.this).nativeGetAndResetDirty(sc.a(sc.this));
        AppMethodBeat.o(224097);
        return Boolean.valueOf(bool);
      }
    }, Boolean.FALSE)).booleanValue();
    AppMethodBeat.o(225428);
    return bool;
  }
  
  public final float[] y()
  {
    AppMethodBeat.i(225497);
    double[] arrayOfDouble = this.d.nativeGLViewMatrix();
    if ((arrayOfDouble == null) || (arrayOfDouble.length == 0))
    {
      AppMethodBeat.o(225497);
      return null;
    }
    Object localObject = this.j.g.n();
    localObject = this.j.n.a(jz.a((GeoPoint)localObject));
    a(arrayOfDouble, ((PointF)localObject).x, -((PointF)localObject).y);
    localObject = new float[arrayOfDouble.length];
    int i1 = 0;
    while (i1 < arrayOfDouble.length)
    {
      localObject[i1] = new BigDecimal(arrayOfDouble[i1]).floatValue();
      i1 += 1;
    }
    AppMethodBeat.o(225497);
    return localObject;
  }
  
  public final Context z()
  {
    AppMethodBeat.i(225505);
    if (this.j == null)
    {
      AppMethodBeat.o(225505);
      return null;
    }
    Context localContext = this.j.getContext();
    AppMethodBeat.o(225505);
    return localContext;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.mapsdk.internal.sc
 * JD-Core Version:    0.7.0.1
 */