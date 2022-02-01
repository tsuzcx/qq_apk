package com.tencent.mapsdk.internal;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Point;
import android.graphics.Rect;
import android.location.Location;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.Display;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import com.tencent.map.lib.models.GeoPoint;
import com.tencent.map.tools.Callback;
import com.tencent.map.tools.ReturnCallback;
import com.tencent.map.tools.Util;
import com.tencent.mapsdk.engine.jni.models.TappedElement;
import com.tencent.mapsdk.vector.VectorMap;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tencentmap.mapsdk.maps.TencentMap.CancelableCallback;
import com.tencent.tencentmap.mapsdk.maps.TencentMap.OnCameraChangeListener;
import com.tencent.tencentmap.mapsdk.maps.TencentMap.OnCompassClickedListener;
import com.tencent.tencentmap.mapsdk.maps.TencentMap.OnDismissCallback;
import com.tencent.tencentmap.mapsdk.maps.TencentMap.OnIndoorStateChangeListener;
import com.tencent.tencentmap.mapsdk.maps.TencentMap.OnInfoWindowClickListener;
import com.tencent.tencentmap.mapsdk.maps.TencentMap.OnMapClickListener;
import com.tencent.tencentmap.mapsdk.maps.TencentMap.OnMapLongClickListener;
import com.tencent.tencentmap.mapsdk.maps.TencentMap.OnMapPoiClickListener;
import com.tencent.tencentmap.mapsdk.maps.TencentMap.OnMarkerClickListener;
import com.tencent.tencentmap.mapsdk.maps.TencentMap.OnMyLocationClickListener;
import com.tencent.tencentmap.mapsdk.maps.TencentMap.OnPolygonClickListener;
import com.tencent.tencentmap.mapsdk.maps.TencentMap.OnPolylineClickListener;
import com.tencent.tencentmap.mapsdk.maps.TencentMap.OnTrafficEventClickListener;
import com.tencent.tencentmap.mapsdk.maps.TencentMapOptions;
import com.tencent.tencentmap.mapsdk.maps.model.AnimationListener;
import com.tencent.tencentmap.mapsdk.maps.model.CameraPosition;
import com.tencent.tencentmap.mapsdk.maps.model.CameraPosition.Builder;
import com.tencent.tencentmap.mapsdk.maps.model.IndoorBuilding;
import com.tencent.tencentmap.mapsdk.maps.model.IndoorLevel;
import com.tencent.tencentmap.mapsdk.maps.model.IndoorMapPoi;
import com.tencent.tencentmap.mapsdk.maps.model.LatLng;
import com.tencent.tencentmap.mapsdk.maps.model.MapPoi;
import com.tencent.tencentmap.mapsdk.maps.model.Marker;
import com.tencent.tencentmap.mapsdk.maps.model.OverSeaSource;
import com.tencent.tencentmap.mapsdk.maps.model.OverSeaTileProvider;
import com.tencent.tencentmap.mapsdk.maps.model.Polygon;
import com.tencent.tencentmap.mapsdk.maps.model.Polyline;
import com.tencent.tencentmap.mapsdk.maps.model.TencentMapGestureListener;
import com.tencent.tencentmap.mapsdk.maps.model.TencentMapGestureListenerList;
import com.tencent.tencentmap.mapsdk.maps.model.TrafficEvent;
import java.nio.IntBuffer;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

public class sj
  extends sr
  implements TencentMap.OnCameraChangeListener
{
  public TencentMap.OnMapPoiClickListener A;
  public Handler B;
  public TencentMap.CancelableCallback C;
  public TencentMap.OnCompassClickedListener D;
  public bg.a E;
  public TencentMap.OnCameraChangeListener F;
  public TencentMap.OnCameraChangeListener G;
  public Handler H;
  public long I;
  public Bitmap.Config J;
  public int K;
  public int L;
  public int M;
  public int N;
  public float O;
  public float P;
  public float Q;
  public float R;
  public boolean S;
  public boolean T;
  protected boolean U;
  protected boolean V;
  protected boolean W;
  protected boolean X;
  protected boolean Y;
  public int Z;
  private final ba aJ;
  private pn aK;
  private final fd aL;
  private fh aM;
  private no aN;
  private GeoPoint aO;
  private boolean aP;
  private volatile boolean aQ;
  private boolean aR;
  private int aS;
  private int aT;
  private float aU;
  private final es aV;
  private fs aW;
  private pk aX;
  public int aa;
  public boolean ab;
  public boolean ac;
  public LatLng ad;
  public LatLng ae;
  public int af;
  public int ag;
  public int ah;
  public int ai;
  public int aj;
  public int ak;
  public int al;
  public boolean am;
  public an an;
  public boolean ao;
  public ou ap;
  public TencentMap.OnTrafficEventClickListener aq;
  public List<an> ar;
  public List<MapPoi> as;
  public List<bc> at;
  public final byte[] g;
  public String h;
  public boolean i;
  public int j;
  public rj k;
  public qj l;
  public rd m;
  public pt n;
  public aa o;
  public AnimationListener p;
  public List<ey> q;
  public List<fe> r;
  public TencentMap.OnMapClickListener s;
  public bb t;
  public List<TencentMap.OnCameraChangeListener> u;
  public TencentMap.OnMapLongClickListener v;
  public TencentMap.OnDismissCallback w;
  protected TencentMap.OnIndoorStateChangeListener x;
  public TencentMap.OnMarkerClickListener y;
  public TencentMap.OnInfoWindowClickListener z;
  
  public sj(Context paramContext, TencentMapOptions paramTencentMapOptions, ViewGroup paramViewGroup)
  {
    super(paramContext, paramTencentMapOptions, paramViewGroup);
    AppMethodBeat.i(224160);
    this.g = new byte[0];
    this.h = "";
    this.i = false;
    this.j = 22;
    this.k = null;
    this.l = null;
    this.o = null;
    this.p = null;
    this.q = new CopyOnWriteArrayList();
    this.r = null;
    this.s = null;
    this.t = null;
    this.u = new CopyOnWriteArrayList();
    this.v = null;
    this.w = null;
    this.y = null;
    this.z = null;
    this.A = null;
    this.aK = new sd(this);
    this.C = null;
    this.D = null;
    this.E = null;
    this.F = null;
    this.G = null;
    this.J = Bitmap.Config.RGB_565;
    this.K = -2147483648;
    this.L = -2147483648;
    this.M = -2147483648;
    this.N = -2147483648;
    this.O = 0.5F;
    this.P = 0.5F;
    this.Q = 0.5F;
    this.R = 0.5F;
    this.aO = null;
    this.aP = false;
    this.S = true;
    this.aQ = false;
    this.aR = false;
    this.aS = 0;
    this.aT = 0;
    this.T = false;
    this.U = true;
    this.V = true;
    this.W = true;
    this.X = true;
    this.Y = true;
    this.Z = 19;
    this.aa = 3;
    this.aU = 0.0F;
    this.ab = true;
    this.ac = true;
    this.ad = null;
    this.ae = null;
    this.af = 0;
    this.ag = 0;
    this.ah = 0;
    this.ai = 0;
    this.aj = 0;
    this.ak = 0;
    this.al = 0;
    this.am = false;
    this.an = null;
    this.ao = false;
    this.ar = new ArrayList();
    this.as = new ArrayList();
    this.at = new ArrayList();
    this.aL = new so(this);
    this.aV = new sh(this);
    this.aK = new sd(this);
    this.aM = new sf(this);
    this.aJ = new se(this);
    paramContext = (WindowManager)G().getSystemService("window");
    paramTencentMapOptions = new int[2];
    paramViewGroup = new Point();
    paramContext.getDefaultDisplay().getSize(paramViewGroup);
    paramTencentMapOptions[0] = paramViewGroup.x;
    paramTencentMapOptions[1] = paramViewGroup.y;
    this.ak = paramTencentMapOptions[0];
    this.al = paramTencentMapOptions[1];
    AppMethodBeat.o(224160);
  }
  
  private Bitmap a(Bitmap paramBitmap1, Bitmap paramBitmap2)
  {
    AppMethodBeat.i(224286);
    if ((paramBitmap1 == null) || (paramBitmap1.isRecycled()) || (paramBitmap2 == null) || (paramBitmap2.isRecycled()))
    {
      AppMethodBeat.o(224286);
      return null;
    }
    Bitmap localBitmap = Bitmap.createBitmap(paramBitmap1.getWidth(), paramBitmap1.getHeight(), paramBitmap1.getConfig());
    Canvas localCanvas = new Canvas(localBitmap);
    localCanvas.drawBitmap(paramBitmap1, new Matrix(), null);
    localCanvas.drawBitmap(paramBitmap2, this.m.a().left, this.m.a().top, null);
    AppMethodBeat.o(224286);
    return localBitmap;
  }
  
  private void a(Handler paramHandler, GL10 paramGL10)
  {
    AppMethodBeat.i(224242);
    if (this.m != null) {
      this.m.l();
    }
    b(paramHandler, paramGL10);
    if (this.m != null) {
      this.m.m();
    }
    AppMethodBeat.o(224242);
  }
  
  private void a(bc parambc)
  {
    AppMethodBeat.i(224404);
    this.at.remove(parambc);
    this.at.add(parambc);
    AppMethodBeat.o(224404);
  }
  
  private void a(oq paramoq)
  {
    AppMethodBeat.i(224380);
    if (this.ap != null) {
      this.ap.a(paramoq);
    }
    AppMethodBeat.o(224380);
  }
  
  private void a(TencentMap.OnTrafficEventClickListener paramOnTrafficEventClickListener)
  {
    this.aq = paramOnTrafficEventClickListener;
  }
  
  private boolean a(TappedElement paramTappedElement)
  {
    boolean bool2 = false;
    AppMethodBeat.i(224204);
    mk localmk = this.aB;
    if ((localmk == null) || (localmk.A == null))
    {
      AppMethodBeat.o(224204);
      return false;
    }
    paramTappedElement = localmk.A.a((int)paramTappedElement.itemId);
    boolean bool1 = bool2;
    if (this.aq != null)
    {
      bool1 = bool2;
      if (paramTappedElement != null)
      {
        this.aq.onTrafficEventClicked(paramTappedElement);
        bool1 = true;
      }
    }
    AppMethodBeat.o(224204);
    return bool1;
  }
  
  private boolean a(av paramav)
  {
    int i2 = 0;
    AppMethodBeat.i(224464);
    if ((VectorMap)this.e_ == null)
    {
      AppMethodBeat.o(224464);
      return false;
    }
    if (paramav == null)
    {
      b("");
      AppMethodBeat.o(224464);
      return true;
    }
    an localan = paramav.a;
    String str = localan.getId();
    if ((this.y != null) && (this.y.onMarkerClick(paramav)))
    {
      AppMethodBeat.o(224464);
      return true;
    }
    if (!paramav.isInfoWindowEnable())
    {
      AppMethodBeat.o(224464);
      return false;
    }
    if (!this.am)
    {
      if (this.an == null)
      {
        localan.showInfoWindow();
        this.an = localan;
        AppMethodBeat.o(224464);
        return true;
      }
      if (this.an == localan)
      {
        int i1 = i2;
        if (localan.h() != null)
        {
          i1 = i2;
          if (localan.h().c()) {
            i1 = 1;
          }
        }
        if (i1 != 0) {
          localan.hideInfoWindow();
        }
        for (this.an = null;; this.an = localan)
        {
          AppMethodBeat.o(224464);
          return true;
          localan.showInfoWindow();
        }
      }
      this.an.hideInfoWindow();
      localan.showInfoWindow();
      this.an = localan;
      AppMethodBeat.o(224464);
      return true;
    }
    if (localan.h() == null) {
      localan.showInfoWindow();
    }
    for (;;)
    {
      b(str);
      AppMethodBeat.o(224464);
      return true;
      if (localan.isInfoWindowShown())
      {
        localan.hideInfoWindow();
      }
      else
      {
        localan.showInfoWindow();
        this.an = localan;
      }
    }
  }
  
  private boolean a(aw paramaw, float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(224454);
    if ((paramaw.isClickable()) && (this.aH != null))
    {
      this.aH.onPolygonClick(paramaw, ((mk)this.d_).n.fromScreenLocation(new Point((int)paramFloat1, (int)paramFloat2)));
      AppMethodBeat.o(224454);
      return true;
    }
    AppMethodBeat.o(224454);
    return false;
  }
  
  private boolean a(ax paramax, float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(224443);
    if ((paramax.isClickable()) && (this.aG != null))
    {
      this.aG.onPolylineClick(paramax, ((mk)this.d_).n.fromScreenLocation(new Point((int)paramFloat1, (int)paramFloat2)));
      AppMethodBeat.o(224443);
      return true;
    }
    AppMethodBeat.o(224443);
    return false;
  }
  
  private static boolean a(eq parameq, float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(224472);
    if ((parameq == null) || (!parameq.isVisible()) || (!parameq.handleOnTap()))
    {
      AppMethodBeat.o(224472);
      return false;
    }
    boolean bool = parameq.onTap(paramFloat1, paramFloat2);
    AppMethodBeat.o(224472);
    return bool;
  }
  
  public static boolean a(LatLng paramLatLng, ft[] paramArrayOfft)
  {
    AppMethodBeat.i(224335);
    if (paramLatLng == null)
    {
      AppMethodBeat.o(224335);
      return false;
    }
    paramLatLng = x.b(GeoPoint.from(paramLatLng));
    if ((paramLatLng.c >= paramArrayOfft[0].c) && (paramLatLng.c <= paramArrayOfft[1].c) && (paramLatLng.b <= paramArrayOfft[0].b) && (paramLatLng.b >= paramArrayOfft[1].b))
    {
      AppMethodBeat.o(224335);
      return true;
    }
    AppMethodBeat.o(224335);
    return false;
  }
  
  private boolean a(ft[] paramArrayOfft)
  {
    AppMethodBeat.i(224299);
    ft[] arrayOfft = W();
    if ((arrayOfft == null) || (paramArrayOfft == null))
    {
      AppMethodBeat.o(224299);
      return true;
    }
    boolean bool = rg.a(arrayOfft, paramArrayOfft);
    AppMethodBeat.o(224299);
    return bool;
  }
  
  private rj ab()
  {
    return this.k;
  }
  
  private boolean ac()
  {
    return this.k.b.e;
  }
  
  private rd ad()
  {
    return this.m;
  }
  
  private List<an> ae()
  {
    AppMethodBeat.i(224314);
    this.ar.clear();
    Object localObject1 = x.b(((VectorMap)this.e_).v().a(new fl(0.0D, 0.0D)));
    ft localft = x.b(((VectorMap)this.e_).v().a(new fl(X(), Y())));
    Iterator localIterator = this.aB.J.b.iterator();
    while (localIterator.hasNext())
    {
      Object localObject2 = (eq)localIterator.next();
      if ((localObject2 instanceof av))
      {
        localObject2 = ((av)localObject2).a;
        if (a(((an)localObject2).getPosition(), new ft[] { localObject1, localft })) {
          this.ar.add(localObject2);
        }
      }
    }
    localObject1 = this.ar;
    AppMethodBeat.o(224314);
    return localObject1;
  }
  
  private List<MapPoi> af()
  {
    AppMethodBeat.i(224321);
    this.as.clear();
    Object localObject = (VectorMap)this.e_;
    if (((VectorMap)localObject).o == null) {}
    for (localObject = null;; localObject = ((VectorMap)localObject).o.D())
    {
      this.as = ((List)localObject);
      localObject = this.as;
      AppMethodBeat.o(224321);
      return localObject;
    }
  }
  
  private ft[] ag()
  {
    AppMethodBeat.i(224354);
    ft localft1 = x.b(((VectorMap)this.e_).v().a(new fl(0.0D, 0.0D)));
    ft localft2 = x.b(((VectorMap)this.e_).v().a(new fl(X(), Y())));
    AppMethodBeat.o(224354);
    return new ft[] { localft1, localft2 };
  }
  
  private void ah()
  {
    AppMethodBeat.i(224366);
    if (Z())
    {
      if ((this.aE instanceof View))
      {
        if (this.ap == null) {
          this.ap = new ou((View)this.aE, this);
        }
        this.ap.onTalkBackActivate(this.aE.getView());
        AppMethodBeat.o(224366);
      }
    }
    else if (this.ap != null)
    {
      this.ap.onTalkBackDeActivate(this.aE.getView());
      this.ap = null;
    }
    AppMethodBeat.o(224366);
  }
  
  private boolean ai()
  {
    AppMethodBeat.i(224478);
    if ((this.B != null) && (this.B.getLooper().getThread().isAlive()))
    {
      this.B.sendEmptyMessage(0);
      AppMethodBeat.o(224478);
      return true;
    }
    AppMethodBeat.o(224478);
    return false;
  }
  
  private void b(Handler paramHandler, GL10 paramGL10)
  {
    AppMethodBeat.i(224270);
    if ((paramGL10 == null) || (paramHandler == null))
    {
      AppMethodBeat.o(224270);
      return;
    }
    int i3 = this.ak;
    int i4 = this.al;
    int[] arrayOfInt = new int[i3 * i4];
    Object localObject = new int[i3 * i4];
    IntBuffer localIntBuffer = IntBuffer.wrap(arrayOfInt);
    localIntBuffer.position(0);
    paramGL10.glReadPixels(0, 0, i3, i4, 6408, 5121, localIntBuffer);
    int i1 = 0;
    while (i1 < i4)
    {
      int i2 = 0;
      while (i2 < i3)
      {
        int i5 = arrayOfInt[(i1 * i3 + i2)];
        localObject[((i4 - i1 - 1) * i3 + i2)] = (i5 & 0xFF00FF00 | i5 << 16 & 0xFF0000 | i5 >> 16 & 0xFF);
        i2 += 1;
      }
      i1 += 1;
    }
    paramGL10 = null;
    try
    {
      localObject = Bitmap.createBitmap((int[])localObject, i3, i4, this.J);
      paramGL10 = (GL10)localObject;
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      label192:
      break label192;
    }
    localObject = paramGL10;
    if (this.aE != null)
    {
      localObject = paramGL10;
      if (!(this.aE instanceof st))
      {
        localObject = paramGL10;
        if (this.m.k()) {
          localObject = a(paramGL10, this.m.j());
        }
      }
    }
    paramHandler.sendMessage(paramHandler.obtainMessage(0, localObject));
    AppMethodBeat.o(224270);
  }
  
  private void b(bc parambc)
  {
    AppMethodBeat.i(224414);
    this.at.remove(parambc);
    AppMethodBeat.o(224414);
  }
  
  private void b(TencentMap.OnCameraChangeListener paramOnCameraChangeListener)
  {
    this.F = paramOnCameraChangeListener;
  }
  
  private void b(TencentMapOptions paramTencentMapOptions)
  {
    Object localObject2 = null;
    AppMethodBeat.i(224255);
    Object localObject1 = G().getApplicationContext();
    Object localObject3 = S().c;
    this.aN = new sm(this, (String)localObject3);
    this.aN.b();
    pf.a((Context)localObject1, (String)localObject3);
    a(this.aN, qo.c());
    Object localObject4 = (dg)cj.a(dg.class);
    localObject3 = (VectorMap)this.e_;
    localObject1 = new StringBuilder();
    String str = ((dd)localObject4).i();
    if (!TextUtils.isEmpty(str))
    {
      localObject4 = ((dd)localObject4).j();
      if (!TextUtils.isEmpty((CharSequence)localObject4)) {
        ((StringBuilder)localObject1).append((String)localObject4).append("://");
      }
      ((StringBuilder)localObject1).append(str);
    }
    for (localObject1 = ((StringBuilder)localObject1).toString();; localObject1 = null)
    {
      ((VectorMap)localObject3).o.a((String)localObject1);
      localObject3 = (dm)cj.a(dm.class);
      localObject1 = localObject2;
      if (paramTencentMapOptions != null) {
        localObject1 = paramTencentMapOptions.getSatelliteVersion();
      }
      paramTencentMapOptions = (TencentMapOptions)localObject1;
      if (TextUtils.isEmpty((CharSequence)localObject1)) {
        paramTencentMapOptions = "0";
      }
      paramTencentMapOptions = ((cy)((dm)localObject3).h()).satelliteUrl("%d", "%d", "%d", paramTencentMapOptions);
      if ((((dd)localObject3).c) && (!TextUtils.isEmpty(paramTencentMapOptions)))
      {
        kh.c("TDZ", "satelliteUrl = ".concat(String.valueOf(paramTencentMapOptions)));
        ((VectorMap)this.e_).o.b(paramTencentMapOptions);
      }
      AppMethodBeat.o(224255);
      return;
    }
  }
  
  private void b(final GL10 paramGL10)
  {
    AppMethodBeat.i(224186);
    if (this.d_ == null)
    {
      AppMethodBeat.o(224186);
      return;
    }
    bh localbh = ((mk)this.d_).J;
    if (localbh == null)
    {
      AppMethodBeat.o(224186);
      return;
    }
    synchronized (this.g)
    {
      final eq[] arrayOfeq = new eq[1];
      arrayOfeq[0] = null;
      Util.foreach(localbh.b(), new Callback()
      {
        private void a(eq paramAnonymouseq)
        {
          AppMethodBeat.i(224005);
          if ((paramAnonymouseq instanceof au))
          {
            if (TextUtils.equals(paramAnonymouseq.getId(), sj.a(sj.this)))
            {
              if ((!paramAnonymouseq.isVisible()) && (!sj.b(sj.this)))
              {
                paramAnonymouseq.releaseData();
                AppMethodBeat.o(224005);
                return;
              }
              arrayOfeq[0] = paramAnonymouseq;
              AppMethodBeat.o(224005);
              return;
            }
            paramAnonymouseq.a(paramGL10);
          }
          AppMethodBeat.o(224005);
        }
      });
      if (arrayOfeq[0] != null) {
        arrayOfeq[0].a(paramGL10);
      }
      AppMethodBeat.o(224186);
      return;
    }
  }
  
  private void c(TencentMap.OnCameraChangeListener paramOnCameraChangeListener)
  {
    this.G = paramOnCameraChangeListener;
  }
  
  private boolean f(float paramFloat1, float paramFloat2)
  {
    int i2 = 0;
    boolean bool3 = true;
    AppMethodBeat.i(224436);
    Object localObject3 = this.aB.J;
    Object localObject4 = ((bh)localObject3).b;
    int i1 = ((List)localObject4).size() - 1;
    Object localObject2 = null;
    boolean bool2 = false;
    while (i1 >= 0)
    {
      localObject1 = (eq)((List)localObject4).get(i1);
      bool2 = a((eq)localObject1, paramFloat1, paramFloat2);
      if (!bool2)
      {
        i1 -= 1;
        localObject2 = localObject1;
      }
      else
      {
        localObject2 = localObject1;
      }
    }
    boolean bool1 = bool2;
    Object localObject1 = localObject2;
    if (!bool2)
    {
      localObject4 = ((bh)localObject3).c;
      i1 = ((List)localObject4).size() - 1;
      localObject1 = localObject2;
      bool1 = bool2;
      while (i1 >= 0)
      {
        localObject1 = (eq)((List)localObject4).get(i1);
        bool1 = a((eq)localObject1, paramFloat1, paramFloat2);
        if (bool1) {
          break;
        }
        i1 -= 1;
      }
    }
    if (!bool1)
    {
      localObject4 = new ArrayList();
      localObject2 = ((bh)localObject3).a.values().iterator();
      while (((Iterator)localObject2).hasNext())
      {
        eq localeq = (eq)((Iterator)localObject2).next();
        if ((localeq instanceof aw)) {
          ((List)localObject4).add((aw)localeq);
        }
      }
      Collections.sort((List)localObject4, ((bh)localObject3).g);
      i1 = ((List)localObject4).size() - 1;
      while (i1 >= 0)
      {
        localObject2 = (eq)((List)localObject4).get(i1);
        bool2 = a((eq)localObject2, paramFloat1, paramFloat2);
        localObject1 = localObject2;
        bool1 = bool2;
        if (bool2) {
          break;
        }
        i1 -= 1;
        localObject1 = localObject2;
        bool1 = bool2;
      }
    }
    if (bool1) {
      if ((localObject1 instanceof av))
      {
        localObject1 = (av)localObject1;
        if ((VectorMap)this.e_ == null) {
          bool1 = false;
        }
      }
    }
    for (;;)
    {
      AppMethodBeat.o(224436);
      return bool1;
      if (localObject1 == null)
      {
        b("");
        bool1 = true;
      }
      else
      {
        localObject2 = ((av)localObject1).a;
        localObject3 = ((an)localObject2).getId();
        if ((this.y != null) && (this.y.onMarkerClick((Marker)localObject1)))
        {
          bool1 = true;
        }
        else if (!((av)localObject1).isInfoWindowEnable())
        {
          bool1 = false;
        }
        else if (!this.am)
        {
          if (this.an == null)
          {
            ((an)localObject2).showInfoWindow();
            this.an = ((an)localObject2);
            bool1 = true;
          }
          else
          {
            if (this.an == localObject2)
            {
              i1 = i2;
              if (((an)localObject2).h() != null)
              {
                i1 = i2;
                if (((an)localObject2).h().c()) {
                  i1 = 1;
                }
              }
              if (i1 != 0) {
                ((an)localObject2).hideInfoWindow();
              }
              for (this.an = null;; this.an = ((an)localObject2))
              {
                bool1 = true;
                break;
                ((an)localObject2).showInfoWindow();
              }
            }
            this.an.hideInfoWindow();
            ((an)localObject2).showInfoWindow();
            this.an = ((an)localObject2);
            bool1 = true;
          }
        }
        else
        {
          if (((an)localObject2).h() == null) {
            ((an)localObject2).showInfoWindow();
          }
          for (;;)
          {
            b((String)localObject3);
            bool1 = true;
            break;
            if (((an)localObject2).isInfoWindowShown())
            {
              ((an)localObject2).hideInfoWindow();
            }
            else
            {
              ((an)localObject2).showInfoWindow();
              this.an = ((an)localObject2);
            }
          }
          if ((localObject1 instanceof ax))
          {
            localObject1 = (ax)localObject1;
            if ((((ax)localObject1).isClickable()) && (this.aG != null))
            {
              this.aG.onPolylineClick((Polyline)localObject1, ((mk)this.d_).n.fromScreenLocation(new Point((int)paramFloat1, (int)paramFloat2)));
              bool1 = bool3;
            }
            else
            {
              bool1 = false;
            }
          }
          else if ((localObject1 instanceof aw))
          {
            localObject1 = (aw)localObject1;
            if ((((aw)localObject1).isClickable()) && (this.aH != null))
            {
              this.aH.onPolygonClick((Polygon)localObject1, ((mk)this.d_).n.fromScreenLocation(new Point((int)paramFloat1, (int)paramFloat2)));
              bool1 = bool3;
            }
            else
            {
              bool1 = false;
            }
          }
          else
          {
            bool1 = false;
          }
        }
      }
    }
  }
  
  public final boolean A()
  {
    if (this.l == null) {}
    while (this.l.b == null) {
      return false;
    }
    return true;
  }
  
  public final boolean B()
  {
    return this.ao;
  }
  
  public final pk M()
  {
    return this.aX;
  }
  
  public final void O()
  {
    AppMethodBeat.i(224532);
    super.O();
    if (this.f != null)
    {
      this.aP = this.f.isHandDrawMapEnable();
      this.am = this.f.isMultipleInfoWindowEnable();
    }
    AppMethodBeat.o(224532);
  }
  
  public final void P()
  {
    AppMethodBeat.i(224545);
    super.P();
    this.k = new rj(this);
    Object localObject = this.k;
    Context localContext = this.e;
    OverSeaSource localOverSeaSource = OverSeaSource.DEFAULT;
    ((rj)localObject).b = new ri();
    localObject = ((rj)localObject).b;
    if (localContext != null)
    {
      ((ri)localObject).i = localOverSeaSource;
      jw.a(new ri.2((ri)localObject, localContext, localOverSeaSource)).a(Boolean.FALSE, null);
    }
    this.Z = ((VectorMap)this.e_).p();
    this.aa = ((VectorMap)this.e_).o();
    AppMethodBeat.o(224545);
  }
  
  public final void Q()
  {
    AppMethodBeat.i(224553);
    super.Q();
    if (this.aP) {
      y();
    }
    AppMethodBeat.o(224553);
  }
  
  public final void R()
  {
    AppMethodBeat.i(224601);
    ac localac = ((VectorMap)this.e_).o.i;
    localac.o();
    localac.j();
    if (this.D != null) {
      this.D.onCompassClicked();
    }
    AppMethodBeat.o(224601);
  }
  
  public final bm.b S()
  {
    AppMethodBeat.i(224590);
    bm.b localb = ((mk)this.d_).u();
    AppMethodBeat.o(224590);
    return localb;
  }
  
  public final void T()
  {
    AppMethodBeat.i(225352);
    super.T();
    kl.d("VECTOR_RENDER_LOOP");
    AppMethodBeat.o(225352);
  }
  
  public final fs U()
  {
    AppMethodBeat.i(225384);
    Object localObject = W();
    ft localft = x.b(((VectorMap)this.e_).q());
    float f = ((VectorMap)this.e_).r();
    if (this.aW == null) {
      this.aW = new fs(localft, (ft[])localObject, f);
    }
    for (;;)
    {
      localObject = this.aW;
      AppMethodBeat.o(225384);
      return localObject;
      this.aW.a(localft, (ft[])localObject, f);
    }
  }
  
  public final void V()
  {
    AppMethodBeat.i(225405);
    bm localbm = this.d_;
    if (localbm != null)
    {
      rg.a();
      if (a(rg.c("china"))) {
        break label164;
      }
    }
    label164:
    for (boolean bool = true;; bool = false)
    {
      localbm.e = bool;
      if (this.k != null) {
        this.k.b();
      }
      bool = localbm.l();
      if (this.m != null)
      {
        fs localfs = U();
        Object localObject = localfs;
        if (localbm.e)
        {
          localObject = localfs;
          if (!localbm.f)
          {
            rg.a();
            localObject = rg.c("china");
            localObject = new fs(x.b(new GeoPoint(new LatLng(39.908822999999998D, 116.39747D))), (ft[])localObject, 18.0F);
          }
        }
        this.m.a((fs)localObject, bool);
        this.m.a(bool);
      }
      AppMethodBeat.o(225405);
      return;
    }
  }
  
  public final ft[] W()
  {
    AppMethodBeat.i(225417);
    ep localep = ((VectorMap)this.e_).v();
    if (localep == null)
    {
      AppMethodBeat.o(225417);
      return null;
    }
    ft[] arrayOfft = new ft[4];
    float f1 = this.ak;
    float f2 = this.al;
    if ((f1 <= 2.0F) || (f2 <= 2.0F))
    {
      AppMethodBeat.o(225417);
      return null;
    }
    fl localfl1 = new fl(0.0D, 0.0D);
    fl localfl2 = new fl(f1, 0.0D);
    fl localfl3 = new fl(f1, f2);
    fl localfl4 = new fl(0.0D, f2);
    int i1 = 0;
    while (i1 < 4)
    {
      arrayOfft[i1] = x.b(localep.a(new fl[] { localfl1, localfl2, localfl3, localfl4 }[i1]));
      i1 += 1;
    }
    AppMethodBeat.o(225417);
    return arrayOfft;
  }
  
  public final CameraPosition a()
  {
    AppMethodBeat.i(224613);
    Object localObject1 = (VectorMap)this.e_;
    Object localObject2 = ((VectorMap)localObject1).q();
    if ((localObject2 == null) || (((this.u == null) || (this.u.size() <= 0)) && (this.aV == null)))
    {
      AppMethodBeat.o(224613);
      return null;
    }
    localObject2 = jz.a((GeoPoint)localObject2);
    float f2 = ((VectorMap)localObject1).t();
    float f1 = f2;
    if (f2 < 0.0F) {
      f1 = f2 % 360.0F + 360.0F;
    }
    f2 = ((VectorMap)localObject1).u();
    float f3 = ((VectorMap)localObject1).o.t.a();
    localObject1 = CameraPosition.builder().zoom(f3).target((LatLng)localObject2).bearing(f1).tilt(f2).build();
    AppMethodBeat.o(224613);
    return localObject1;
  }
  
  public final void a(float paramFloat)
  {
    AppMethodBeat.i(225029);
    if (this.aU == paramFloat)
    {
      AppMethodBeat.o(225029);
      return;
    }
    this.aU = paramFloat;
    if (!this.q.isEmpty())
    {
      fr localfr = new fr();
      localfr.f = 1;
      localfr.i = ((VectorMap)this.e_).r();
      localfr.j = ((VectorMap)this.e_).v().a(new Point(0, this.al / 2), new Point(this.ak, this.al / 2));
      Iterator localIterator = this.q.iterator();
      while (localIterator.hasNext()) {
        ((ey)localIterator.next()).a(localfr);
      }
    }
    AppMethodBeat.o(225029);
  }
  
  public final void a(int paramInt)
  {
    AppMethodBeat.i(224953);
    this.aT = paramInt;
    a(this.aS, paramInt);
    F();
    AppMethodBeat.o(224953);
  }
  
  public final void a(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(224961);
    this.aS = paramInt1;
    this.aT = paramInt2;
    ((VectorMap)this.e_).c(paramInt1, paramInt2);
    F();
    AppMethodBeat.o(224961);
  }
  
  public final void a(Handler paramHandler, Bitmap.Config paramConfig, int paramInt)
  {
    AppMethodBeat.i(224637);
    this.H = paramHandler;
    this.J = paramConfig;
    if (paramInt > 0) {}
    for (this.I = (System.currentTimeMillis() + paramInt);; this.I = 9223372036854775807L)
    {
      H();
      F();
      AppMethodBeat.o(224637);
      return;
    }
  }
  
  public final void a(bb parambb)
  {
    this.t = parambb;
  }
  
  public final void a(bg.a parama)
  {
    this.E = parama;
  }
  
  public final void a(ey paramey)
  {
    AppMethodBeat.i(225157);
    this.q.remove(paramey);
    this.q.add(paramey);
    AppMethodBeat.o(225157);
  }
  
  public final void a(fe paramfe)
  {
    AppMethodBeat.i(224695);
    if (this.r == null) {
      this.r = new ArrayList();
    }
    if (this.r.contains(paramfe))
    {
      AppMethodBeat.o(224695);
      return;
    }
    this.r.add(paramfe);
    AppMethodBeat.o(224695);
  }
  
  public final void a(pt parampt)
  {
    this.n = parampt;
  }
  
  public final void a(rd paramrd)
  {
    this.m = paramrd;
  }
  
  public final void a(TencentMap.OnCameraChangeListener paramOnCameraChangeListener)
  {
    AppMethodBeat.i(225299);
    if ((this.u != null) && (paramOnCameraChangeListener != null)) {
      this.u.add(paramOnCameraChangeListener);
    }
    if (paramOnCameraChangeListener == null) {}
    for (int i1 = 1; (i1 == 0) || (this.k.b.e); i1 = 0)
    {
      ((VectorMap)this.e_).a(this.aJ);
      AppMethodBeat.o(225299);
      return;
    }
    ((VectorMap)this.e_).a(null);
    AppMethodBeat.o(225299);
  }
  
  public final void a(TencentMap.OnDismissCallback paramOnDismissCallback)
  {
    this.w = paramOnDismissCallback;
  }
  
  public final void a(TencentMap.OnIndoorStateChangeListener paramOnIndoorStateChangeListener)
  {
    this.x = paramOnIndoorStateChangeListener;
  }
  
  public final void a(TencentMap.OnMapPoiClickListener paramOnMapPoiClickListener)
  {
    this.A = paramOnMapPoiClickListener;
  }
  
  public final void a(TencentMapOptions paramTencentMapOptions)
  {
    Object localObject2 = null;
    AppMethodBeat.i(224626);
    Object localObject1 = G().getApplicationContext();
    Object localObject3 = S().c;
    this.aN = new sm(this, (String)localObject3);
    this.aN.b();
    pf.a((Context)localObject1, (String)localObject3);
    a(this.aN, qo.c());
    Object localObject4 = (dg)cj.a(dg.class);
    localObject3 = (VectorMap)this.e_;
    localObject1 = new StringBuilder();
    String str = ((dd)localObject4).i();
    if (!TextUtils.isEmpty(str))
    {
      localObject4 = ((dd)localObject4).j();
      if (!TextUtils.isEmpty((CharSequence)localObject4)) {
        ((StringBuilder)localObject1).append((String)localObject4).append("://");
      }
      ((StringBuilder)localObject1).append(str);
    }
    for (localObject1 = ((StringBuilder)localObject1).toString();; localObject1 = null)
    {
      ((VectorMap)localObject3).o.a((String)localObject1);
      localObject3 = (dm)cj.a(dm.class);
      localObject1 = localObject2;
      if (paramTencentMapOptions != null) {
        localObject1 = paramTencentMapOptions.getSatelliteVersion();
      }
      paramTencentMapOptions = (TencentMapOptions)localObject1;
      if (TextUtils.isEmpty((CharSequence)localObject1)) {
        paramTencentMapOptions = "0";
      }
      paramTencentMapOptions = ((cy)((dm)localObject3).h()).satelliteUrl("%d", "%d", "%d", paramTencentMapOptions);
      if ((((dd)localObject3).c) && (!TextUtils.isEmpty(paramTencentMapOptions)))
      {
        kh.c("TDZ", "satelliteUrl = ".concat(String.valueOf(paramTencentMapOptions)));
        ((VectorMap)this.e_).o.b(paramTencentMapOptions);
      }
      if (((VectorMap)this.e_).o.q) {
        break;
      }
      ((VectorMap)this.e_).setMapStyle(0);
      AppMethodBeat.o(224626);
      return;
    }
    ((VectorMap)this.e_).setMapStyle(5);
    AppMethodBeat.o(224626);
  }
  
  public final void a(OverSeaTileProvider paramOverSeaTileProvider)
  {
    AppMethodBeat.i(225321);
    if (this.k != null)
    {
      rj localrj = this.k;
      if (localrj.c != paramOverSeaTileProvider)
      {
        kh.c("TO", "设置自定义海外图源，old[" + localrj.c + "] to new[" + paramOverSeaTileProvider + "]");
        localrj.c = paramOverSeaTileProvider;
        localrj.e = true;
        localrj.b.k = localrj.c;
        paramOverSeaTileProvider = localrj.b.c();
        if (localrj.a != null) {
          localrj.a.a(false, paramOverSeaTileProvider);
        }
        localrj.a();
      }
    }
    AppMethodBeat.o(225321);
  }
  
  public final void a(TencentMapGestureListener paramTencentMapGestureListener)
  {
    AppMethodBeat.i(224929);
    if (this.av == null) {
      this.av = new TencentMapGestureListenerList();
    }
    this.av.addListener(paramTencentMapGestureListener);
    AppMethodBeat.o(224929);
  }
  
  public final void a(String paramString)
  {
    AppMethodBeat.i(224657);
    b(paramString);
    AppMethodBeat.o(224657);
  }
  
  public final void a(GL10 paramGL10, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(225346);
    super.a(paramGL10, paramInt1, paramInt2);
    this.ak = paramInt1;
    this.al = paramInt2;
    c((int)(this.ak * this.O), (int)(this.al * this.P));
    d((int)(this.ak * this.Q), (int)(this.al * this.R));
    if (this.E != null) {
      this.E.a();
    }
    AppMethodBeat.o(225346);
  }
  
  public final void a(GL10 paramGL10, EGLConfig paramEGLConfig)
  {
    AppMethodBeat.i(225332);
    kl.b("VECTOR_RENDER_LOOP");
    super.a(paramGL10, paramEGLConfig);
    AppMethodBeat.o(225332);
  }
  
  public final void a(boolean paramBoolean)
  {
    this.i = paramBoolean;
  }
  
  public final void a(final boolean paramBoolean, final List<rm> paramList)
  {
    AppMethodBeat.i(225483);
    jw.b(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(223603);
        Iterator localIterator = sj.e(sj.this).iterator();
        while (localIterator.hasNext()) {
          ((bc)localIterator.next()).a(paramBoolean, paramList);
        }
        AppMethodBeat.o(223603);
      }
    });
    AppMethodBeat.o(225483);
  }
  
  public final boolean a(float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(224684);
    Object localObject;
    if (this.t != null)
    {
      localObject = c(paramFloat1, paramFloat2);
      if ((localObject != null) && (((String)localObject).trim().length() != 0))
      {
        this.t.a((String)localObject);
        AppMethodBeat.o(224684);
        return true;
      }
    }
    if ((this.v != null) && (this.aw))
    {
      localObject = new fl(paramFloat1, paramFloat2);
      localObject = jz.a(((VectorMap)this.e_).v().a((fl)localObject));
      this.v.onMapLongClick((LatLng)localObject);
    }
    AppMethodBeat.o(224684);
    return false;
  }
  
  public final boolean a(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(225474);
    if (this.ap != null)
    {
      boolean bool = this.ap.dispatchHoverEvent(paramMotionEvent);
      AppMethodBeat.o(225474);
      return bool;
    }
    AppMethodBeat.o(225474);
    return false;
  }
  
  public final boolean a(GL10 paramGL10)
  {
    AppMethodBeat.i(225364);
    bh localbh;
    if (this.d_ != null)
    {
      localbh = ((mk)this.d_).J;
      if (localbh == null) {}
    }
    for (;;)
    {
      synchronized (this.g)
      {
        eq[] arrayOfeq = new eq[1];
        arrayOfeq[0] = null;
        Util.foreach(localbh.b(), new Callback()
        {
          private void a(eq paramAnonymouseq)
          {
            AppMethodBeat.i(224005);
            if ((paramAnonymouseq instanceof au))
            {
              if (TextUtils.equals(paramAnonymouseq.getId(), sj.a(sj.this)))
              {
                if ((!paramAnonymouseq.isVisible()) && (!sj.b(sj.this)))
                {
                  paramAnonymouseq.releaseData();
                  AppMethodBeat.o(224005);
                  return;
                }
                arrayOfeq[0] = paramAnonymouseq;
                AppMethodBeat.o(224005);
                return;
              }
              paramAnonymouseq.a(paramGL10);
            }
            AppMethodBeat.o(224005);
          }
        });
        if (arrayOfeq[0] != null) {
          arrayOfeq[0].a(paramGL10);
        }
        boolean bool2 = super.a(paramGL10);
        if ((this.H != null) && (System.currentTimeMillis() > this.I))
        {
          kh.b("TDZ", "snapShot : 1");
          a(this.H, paramGL10);
          this.H = null;
        }
        if (((this.H != null) || (!this.ax)) && (this.e_ != null) && (((VectorMap)this.e_).n) && (this.k != null) && (this.k.d))
        {
          if (this.aB == null) {
            break label290;
          }
          ??? = this.aB;
          if (((mk)???).g == null) {
            break label285;
          }
          bool1 = ((mk)???).g.j();
          if (!bool1) {
            break label290;
          }
          i1 = 1;
          if (i1 != 0)
          {
            if (!this.ax) {
              n(true);
            }
            kh.b("TDZ", "snapShot : 2");
            a(this.H, paramGL10);
            this.H = null;
          }
        }
        AppMethodBeat.o(225364);
        return bool2;
      }
      label285:
      boolean bool1 = false;
      continue;
      label290:
      int i1 = 0;
    }
  }
  
  public final void b(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(225083);
    if ((paramInt1 == 0) || (paramInt2 == 0))
    {
      AppMethodBeat.o(225083);
      return;
    }
    if (this.aO == null)
    {
      GeoPoint localGeoPoint = ((VectorMap)this.e_).q();
      this.aO = new GeoPoint(localGeoPoint.getLatitudeE6(), localGeoPoint.getLongitudeE6());
    }
    this.aO.setLatitudeE6(paramInt1);
    this.aO.setLongitudeE6(paramInt2);
    AppMethodBeat.o(225083);
  }
  
  public final void b(ey paramey)
  {
    AppMethodBeat.i(225170);
    this.q.remove(paramey);
    AppMethodBeat.o(225170);
  }
  
  public final void b(TencentMapGestureListener paramTencentMapGestureListener)
  {
    AppMethodBeat.i(224936);
    if (this.av == null)
    {
      AppMethodBeat.o(224936);
      return;
    }
    this.av.removeListener(paramTencentMapGestureListener);
    AppMethodBeat.o(224936);
  }
  
  public final void b(String paramString)
  {
    synchronized (this.g)
    {
      this.h = paramString;
      return;
    }
  }
  
  public final void b(boolean paramBoolean)
  {
    this.V = paramBoolean;
  }
  
  public final boolean b(final float paramFloat1, final float paramFloat2)
  {
    eq localeq = null;
    AppMethodBeat.i(224729);
    Object localObject4;
    boolean bool1;
    Object localObject8;
    Object localObject7;
    boolean bool2;
    synchronized (this.g)
    {
      Object localObject1 = (oq)c(this.h);
      if (localObject1 != null) {}
      for (localObject4 = ((oq)localObject1).F;; localObject4 = null)
      {
        if ((this.h.equals("")) || (localObject1 == null) || (localObject4 == null) || (!((en)localObject4).c())) {
          break label1545;
        }
        bool1 = ((en)localObject4).onTap(paramFloat1, paramFloat2);
        if (!bool1) {
          break label1536;
        }
        localObject8 = localObject1;
        localObject7 = localObject4;
        bool2 = bool1;
        if (!bool1)
        {
          localObject7 = new Object[3];
          localObject7[0] = Boolean.valueOf(bool1);
          localObject7[1] = localObject1;
          localObject7[2] = localObject4;
          Util.where(((mk)this.d_).J.b, new ReturnCallback()
          {
            private Boolean a(eq paramAnonymouseq)
            {
              AppMethodBeat.i(223928);
              if ((paramAnonymouseq instanceof av))
              {
                paramAnonymouseq = (av)paramAnonymouseq;
                en localen = paramAnonymouseq.a.h();
                if ((!paramAnonymouseq.getId().equals(sj.a(sj.this))) && (localen != null) && (localen.c()))
                {
                  boolean bool = localen.onTap(paramFloat1, paramFloat2);
                  this.c[0] = Boolean.valueOf(bool);
                  if (bool)
                  {
                    this.c[1] = paramAnonymouseq;
                    this.c[2] = localen;
                    paramAnonymouseq = Boolean.TRUE;
                    AppMethodBeat.o(223928);
                    return paramAnonymouseq;
                  }
                }
              }
              paramAnonymouseq = Boolean.FALSE;
              AppMethodBeat.o(223928);
              return paramAnonymouseq;
            }
          });
          bool2 = ((Boolean)localObject7[0]).booleanValue();
          localObject8 = (Marker)localObject7[1];
          localObject7 = (en)localObject7[2];
        }
        if (!bool2) {
          break;
        }
        if ((this.e_ != null) && (this.z != null) && (localObject8 != null) && (localObject7 != null) && (((Marker)localObject8).isInfoWindowShown()))
        {
          this.z.onInfoWindowClick((Marker)localObject8);
          localObject1 = ((en)localObject7).getScreenBound(((VectorMap)this.e_).v());
          if (localObject1 != null) {
            this.z.onInfoWindowClickLocation(((Rect)localObject1).width(), ((Rect)localObject1).height(), (int)paramFloat1 - ((Rect)localObject1).left, (int)paramFloat2 - ((Rect)localObject1).top);
          }
        }
        AppMethodBeat.o(224729);
        return true;
      }
      localObject7 = this.aB.J;
      localObject8 = ((bh)localObject7).b;
      i1 = ((List)localObject8).size();
      bool2 = false;
      i1 -= 1;
      for (localObject4 = localeq; i1 >= 0; localObject4 = localObject1)
      {
        localObject1 = (eq)((List)localObject8).get(i1);
        bool2 = a((eq)localObject1, paramFloat1, paramFloat2);
        if (bool2) {
          break label1557;
        }
        i1 -= 1;
      }
      label397:
      bool1 = bool2;
      localObject1 = localObject4;
      if (!bool2)
      {
        localObject8 = ((bh)localObject7).c;
        i1 = ((List)localObject8).size() - 1;
        localObject1 = localObject4;
        bool1 = bool2;
        while (i1 >= 0)
        {
          localObject1 = (eq)((List)localObject8).get(i1);
          bool1 = a((eq)localObject1, paramFloat1, paramFloat2);
          if (bool1) {
            break label1564;
          }
          i1 -= 1;
        }
      }
      label473:
      if (bool1) {
        break label1567;
      }
      localObject8 = new ArrayList();
      localObject4 = ((bh)localObject7).a.values().iterator();
      while (((Iterator)localObject4).hasNext())
      {
        localeq = (eq)((Iterator)localObject4).next();
        if ((localeq instanceof aw)) {
          ((List)localObject8).add((aw)localeq);
        }
      }
    }
    Collections.sort((List)localObject8, ((bh)localObject7).g);
    int i1 = ((List)localObject8).size() - 1;
    while (i1 >= 0)
    {
      localObject4 = (eq)((List)localObject8).get(i1);
      bool2 = a((eq)localObject4, paramFloat1, paramFloat2);
      ??? = localObject4;
      bool1 = bool2;
      if (bool2) {
        break;
      }
      i1 -= 1;
      ??? = localObject4;
      bool1 = bool2;
    }
    label638:
    if (bool1) {
      if ((??? instanceof av))
      {
        ??? = (av)???;
        if ((VectorMap)this.e_ == null) {
          bool1 = false;
        }
      }
    }
    for (;;)
    {
      label671:
      if (bool1)
      {
        AppMethodBeat.o(224729);
        return bool1;
        if (??? == null)
        {
          b("");
          bool1 = true;
          continue;
        }
        localObject4 = ((av)???).a;
        localObject7 = ((an)localObject4).getId();
        if ((this.y != null) && (this.y.onMarkerClick((Marker)???)))
        {
          bool1 = true;
          continue;
        }
        if (!((av)???).isInfoWindowEnable())
        {
          bool1 = false;
          continue;
        }
        if (!this.am)
        {
          if (this.an == null)
          {
            ((an)localObject4).showInfoWindow();
            this.an = ((an)localObject4);
            bool1 = true;
            continue;
          }
          if (this.an == localObject4) {
            if ((((an)localObject4).h() == null) || (!((an)localObject4).h().c())) {
              break label1576;
            }
          }
        }
      }
      label1536:
      label1545:
      label1557:
      label1564:
      label1567:
      label1570:
      label1576:
      for (i1 = 1;; i1 = 0)
      {
        if (i1 != 0)
        {
          ((an)localObject4).hideInfoWindow();
          this.an = null;
        }
        else
        {
          ((an)localObject4).showInfoWindow();
          this.an = ((an)localObject4);
          break label1570;
          this.an.hideInfoWindow();
          ((an)localObject4).showInfoWindow();
          this.an = ((an)localObject4);
          bool1 = true;
          break label671;
          if (((an)localObject4).h() == null) {
            ((an)localObject4).showInfoWindow();
          }
          for (;;)
          {
            b((String)localObject7);
            bool1 = true;
            break;
            if (((an)localObject4).isInfoWindowShown())
            {
              ((an)localObject4).hideInfoWindow();
            }
            else
            {
              ((an)localObject4).showInfoWindow();
              this.an = ((an)localObject4);
            }
          }
          if ((??? instanceof ax))
          {
            ??? = (ax)???;
            if ((!((ax)???).isClickable()) || (this.aG == null)) {
              break label1581;
            }
            this.aG.onPolylineClick((Polyline)???, ((mk)this.d_).n.fromScreenLocation(new Point((int)paramFloat1, (int)paramFloat2)));
            bool1 = true;
            break label671;
          }
          if ((??? instanceof aw))
          {
            ??? = (aw)???;
            if ((((aw)???).isClickable()) && (this.aH != null))
            {
              this.aH.onPolygonClick((Polygon)???, ((mk)this.d_).n.fromScreenLocation(new Point((int)paramFloat1, (int)paramFloat2)));
              bool1 = true;
              break label671;
            }
            bool1 = false;
            break label671;
          }
          bool1 = false;
          break label671;
          if (this.i) {}
          for (;;)
          {
            synchronized (this.g)
            {
              Util.foreach(((mk)this.d_).J.b, new Callback()
              {
                private static void a(eq paramAnonymouseq)
                {
                  AppMethodBeat.i(223960);
                  if ((paramAnonymouseq instanceof av))
                  {
                    paramAnonymouseq = ((av)paramAnonymouseq).a;
                    if (paramAnonymouseq.h() != null) {
                      paramAnonymouseq.hideInfoWindow();
                    }
                  }
                  AppMethodBeat.o(223960);
                }
              });
              localObject4 = ((VectorMap)this.e_).a(paramFloat1, paramFloat2);
              if (localObject4 == null) {
                break label1451;
              }
              switch (((TappedElement)localObject4).type)
              {
              case 2: 
              case 3: 
              case 5: 
              case 6: 
              case 7: 
              default: 
                i1 = 0;
                if (i1 == 0) {
                  break label1456;
                }
                AppMethodBeat.o(224729);
                return true;
              }
            }
            i1 = 0;
            continue;
            if (this.A != null)
            {
              if (localObject5.itemType != 1) {
                break label1371;
              }
              ??? = new IndoorMapPoi();
              ((IndoorMapPoi)???).buildingName = localObject5.buildingName;
              ((IndoorMapPoi)???).buildingId = localObject5.buildingId;
              ((IndoorMapPoi)???).floorName = localObject5.floorName;
            }
            for (;;)
            {
              ((MapPoi)???).name = localObject5.name;
              ((MapPoi)???).position = jz.a(localObject5.pixelX, localObject5.pixelY).toLatLng();
              this.A.onClicked((MapPoi)???);
              i1 = 1;
              break;
              label1371:
              ??? = new MapPoi();
            }
            ??? = this.aB;
            if ((??? == null) || (((mk)???).A == null))
            {
              i1 = 0;
            }
            else
            {
              ??? = ((mk)???).A.a((int)localObject5.itemId);
              if ((this.aq != null) && (??? != null))
              {
                this.aq.onTrafficEventClicked((TrafficEvent)???);
                i1 = 1;
                continue;
                label1451:
                i1 = 0;
                continue;
                label1456:
                if ((this.s != null) && (this.aw))
                {
                  ??? = new fl(paramFloat1, paramFloat2);
                  ??? = jz.a(((VectorMap)this.e_).v().a((fl)???));
                  this.s.onMapClick((LatLng)???);
                }
                F();
                AppMethodBeat.o(224729);
                return false;
              }
              else
              {
                i1 = 0;
              }
            }
          }
          break label671;
          Object localObject6 = null;
          ??? = null;
          break;
          localObject6 = null;
          ??? = null;
          bool1 = false;
          break;
          localObject6 = ???;
          break label397;
          break label473;
          break label638;
        }
        bool1 = true;
        break label671;
      }
      label1581:
      bool1 = false;
    }
  }
  
  public final oo c(String paramString)
  {
    AppMethodBeat.i(224747);
    if (this.d_ != null)
    {
      paramString = ((mk)this.d_).J.a(paramString);
      if ((paramString instanceof au))
      {
        paramString = ((au)paramString).f_();
        if ((paramString instanceof oo))
        {
          paramString = (oo)paramString;
          AppMethodBeat.o(224747);
          return paramString;
        }
      }
    }
    AppMethodBeat.o(224747);
    return null;
  }
  
  public final String c(final float paramFloat1, final float paramFloat2)
  {
    AppMethodBeat.i(224847);
    final String[] arrayOfString = new String[1];
    arrayOfString[0] = null;
    synchronized (this.g)
    {
      Util.where(((mk)this.d_).J.b(), new ReturnCallback()
      {
        private Boolean a(eq paramAnonymouseq)
        {
          AppMethodBeat.i(223628);
          if ((paramAnonymouseq == null) || (!paramAnonymouseq.isVisible()))
          {
            paramAnonymouseq = Boolean.FALSE;
            AppMethodBeat.o(223628);
            return paramAnonymouseq;
          }
          if (!(paramAnonymouseq instanceof av))
          {
            paramAnonymouseq = Boolean.FALSE;
            AppMethodBeat.o(223628);
            return paramAnonymouseq;
          }
          if (!paramAnonymouseq.onTap(paramFloat1, paramFloat2))
          {
            paramAnonymouseq = Boolean.FALSE;
            AppMethodBeat.o(223628);
            return paramAnonymouseq;
          }
          arrayOfString[0] = paramAnonymouseq.getId();
          paramAnonymouseq = Boolean.TRUE;
          AppMethodBeat.o(223628);
          return paramAnonymouseq;
        }
      });
      ??? = arrayOfString[0];
      AppMethodBeat.o(224847);
      return ???;
    }
  }
  
  public final void c(int paramInt1, int paramInt2)
  {
    this.K = paramInt1;
    this.L = paramInt2;
  }
  
  public final void c(boolean paramBoolean)
  {
    this.U = paramBoolean;
  }
  
  public final ri d()
  {
    return this.k.b;
  }
  
  public final void d(int paramInt1, int paramInt2)
  {
    this.M = paramInt1;
    this.N = paramInt2;
  }
  
  public final void d(boolean paramBoolean)
  {
    this.W = paramBoolean;
  }
  
  public final boolean d(float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(224988);
    if (!this.aw)
    {
      AppMethodBeat.o(224988);
      return false;
    }
    Object localObject1 = (VectorMap)this.e_;
    Object localObject2 = ((VectorMap)localObject1).o.k;
    Object localObject3 = ((bi)localObject2).a.f().a(paramFloat1, paramFloat2);
    int i1;
    boolean bool1;
    label151:
    boolean bool2;
    label242:
    ox localox;
    if ((localObject3 != null) && (((TappedElement)localObject3).type == 3))
    {
      if (((bi)localObject2).h != null) {
        ((bi)localObject2).h.R();
      }
      i1 = 1;
      if (i1 == 0)
      {
        if (((VectorMap)localObject1).r == null) {
          break label515;
        }
        localObject2 = ((VectorMap)localObject1).r;
        localObject3 = ((bf)localObject2).g.k.a.f().a(paramFloat1, paramFloat2);
        if ((localObject3 == null) || (((TappedElement)localObject3).type != 6)) {
          break label509;
        }
        bool1 = true;
        bool2 = bool1;
        if (bool1)
        {
          bool2 = bool1;
          if (((bf)localObject2).i != null)
          {
            localObject3 = new LatLng();
            if (((bf)localObject2).e != null)
            {
              ((LatLng)localObject3).setAltitude(((bf)localObject2).e.getAltitude());
              ((LatLng)localObject3).setLongitude(((bf)localObject2).e.getLongitude());
              ((LatLng)localObject3).setLatitude(((bf)localObject2).e.getLatitude());
            }
            bool2 = ((bf)localObject2).i.onMyLocationClicked((LatLng)localObject3);
          }
        }
        if (!bool2)
        {
          localObject3 = ((VectorMap)localObject1).a(paramFloat1, paramFloat2);
          if ((localObject3 == null) || (((VectorMap)localObject1).s == null)) {
            break label532;
          }
          localObject2 = ((VectorMap)localObject1).s;
          if ((((oz)localObject2).c == null) || (localObject3 == null) || (((TappedElement)localObject3).type != 4)) {
            break label527;
          }
          long l1 = ((TappedElement)localObject3).itemId;
          localObject3 = ((oz)localObject2).a.iterator();
          label317:
          if (!((Iterator)localObject3).hasNext()) {
            break label545;
          }
          localox = (ox)((Iterator)localObject3).next();
          if ((localox.b == null) || (localox.b.a == null) || (localox.b.a.j == null)) {
            break label521;
          }
          Iterator localIterator = localox.b.a.j.iterator();
          while (localIterator.hasNext())
          {
            localObject1 = (oy.d)localIterator.next();
            nf localnf = (nf)localox.a.b.k.a(nf.class, ((oy.d)localObject1).a);
            if ((localnf != null) && (localnf.e_() == l1)) {
              label456:
              if (localObject1 == null) {
                break label525;
              }
            }
          }
        }
      }
    }
    label515:
    label521:
    label525:
    label527:
    label532:
    label537:
    label545:
    for (localObject1 = ox.a(localox.getId(), (oy.d)localObject1);; localObject1 = null)
    {
      if (localObject1 != null)
      {
        ((oz)localObject2).c.onClicked((MapPoi)localObject1);
        i1 = 1;
      }
      for (;;)
      {
        if (i1 == 0) {
          break label537;
        }
        AppMethodBeat.o(224988);
        return true;
        i1 = 0;
        break;
        label509:
        bool1 = false;
        break label151;
        bool2 = false;
        break label242;
        localObject1 = null;
        break label456;
        break label317;
        i1 = 0;
        continue;
        i1 = 0;
      }
      AppMethodBeat.o(224988);
      return false;
    }
  }
  
  public final boolean d(String paramString)
  {
    AppMethodBeat.i(224922);
    if (paramString == null)
    {
      AppMethodBeat.o(224922);
      return false;
    }
    bh localbh = this.aB.J;
    paramString = (eq)localbh.a.remove(paramString);
    if (paramString != null)
    {
      localbh.b.remove(paramString);
      localbh.c.remove(paramString);
      localbh.d.remove(paramString);
      if ((paramString instanceof au))
      {
        ao localao = ((au)paramString).f_();
        if (localao != null) {
          localbh.e.remove(localao);
        }
      }
    }
    if (paramString != null) {}
    for (boolean bool = true;; bool = false)
    {
      if (bool) {
        ((VectorMap)this.e_).n();
      }
      AppMethodBeat.o(224922);
      return bool;
    }
  }
  
  public final String e()
  {
    return this.h;
  }
  
  public final void e(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(224577);
    Object localObject;
    if (this.r != null)
    {
      int i2 = this.r.size();
      int i1 = 0;
      while (i1 < i2)
      {
        localObject = (fe)this.r.get(i1);
        if (localObject != null) {
          ((fe)localObject).b(paramInt1, paramInt2);
        }
        i1 += 1;
      }
    }
    if (this.d_ != null)
    {
      localObject = ((mk)this.d_).J.a.values().iterator();
      while (((Iterator)localObject).hasNext()) {
        ((Iterator)localObject).next();
      }
    }
    AppMethodBeat.o(224577);
  }
  
  public final void e(boolean paramBoolean)
  {
    this.X = paramBoolean;
  }
  
  public final boolean e(float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(225205);
    TappedElement localTappedElement = ((VectorMap)this.e_).a(paramFloat1, paramFloat2);
    if (localTappedElement != null)
    {
      switch (localTappedElement.type)
      {
      case 2: 
      case 3: 
      case 5: 
      case 6: 
      case 7: 
      default: 
        AppMethodBeat.o(225205);
        return false;
      case 0: 
        AppMethodBeat.o(225205);
        return false;
      case 1: 
        if (this.A != null)
        {
          if (localTappedElement.itemType != 1) {
            break label201;
          }
          localObject = new IndoorMapPoi();
          ((IndoorMapPoi)localObject).buildingName = localTappedElement.buildingName;
          ((IndoorMapPoi)localObject).buildingId = localTappedElement.buildingId;
          ((IndoorMapPoi)localObject).floorName = localTappedElement.floorName;
        }
      case 8: 
        for (;;)
        {
          ((MapPoi)localObject).name = localTappedElement.name;
          ((MapPoi)localObject).position = jz.a(localTappedElement.pixelX, localTappedElement.pixelY).toLatLng();
          this.A.onClicked((MapPoi)localObject);
          AppMethodBeat.o(225205);
          return true;
          label201:
          localObject = new MapPoi();
        }
      }
      Object localObject = this.aB;
      if ((localObject == null) || (((mk)localObject).A == null))
      {
        AppMethodBeat.o(225205);
        return false;
      }
      localObject = ((mk)localObject).A.a((int)localTappedElement.itemId);
      if ((this.aq == null) || (localObject == null)) {
        break label297;
      }
      this.aq.onTrafficEventClicked((TrafficEvent)localObject);
    }
    label297:
    for (boolean bool = true;; bool = false)
    {
      AppMethodBeat.o(225205);
      return bool;
      AppMethodBeat.o(225205);
      return false;
    }
  }
  
  public final void f(boolean paramBoolean)
  {
    this.Y = paramBoolean;
  }
  
  public final boolean f()
  {
    return this.S;
  }
  
  public final void g(boolean paramBoolean)
  {
    this.aw = paramBoolean;
  }
  
  public final boolean g()
  {
    return this.V;
  }
  
  public final void h(boolean paramBoolean)
  {
    AppMethodBeat.i(224796);
    if (this.S != paramBoolean)
    {
      localObject = new fr();
      ((fr)localObject).f = 2;
      Iterator localIterator = this.q.iterator();
      while (localIterator.hasNext()) {
        ((ey)localIterator.next()).a((fr)localObject);
      }
    }
    this.S = paramBoolean;
    Object localObject = ((VectorMap)this.e_).o.i;
    ((ac)localObject).G = paramBoolean;
    ((ac)localObject).z.f().b(((ac)localObject).G);
    ((VectorMap)this.e_).n();
    AppMethodBeat.o(224796);
  }
  
  public final boolean h()
  {
    return this.W;
  }
  
  public final void i(boolean paramBoolean)
  {
    AppMethodBeat.i(224862);
    if ((!paramBoolean) || (this.k.b.e))
    {
      ((VectorMap)this.e_).a(this.aJ);
      AppMethodBeat.o(224862);
      return;
    }
    ((VectorMap)this.e_).a(null);
    AppMethodBeat.o(224862);
  }
  
  public final boolean i()
  {
    return this.X;
  }
  
  public final void j(boolean paramBoolean)
  {
    this.T = paramBoolean;
  }
  
  public final boolean j()
  {
    return this.Y;
  }
  
  public final void k()
  {
    AppMethodBeat.i(224909);
    if (this.B != null) {
      this.B.removeCallbacksAndMessages(null);
    }
    if (this.H != null) {
      this.H.removeCallbacksAndMessages(null);
    }
    if (this.r != null)
    {
      this.r.clear();
      this.r = null;
    }
    l();
    this.s = null;
    this.z = null;
    this.v = null;
    this.D = null;
    this.p = null;
    AppMethodBeat.o(224909);
  }
  
  public final void k(boolean paramBoolean)
  {
    this.ao = paramBoolean;
  }
  
  public final void l()
  {
    AppMethodBeat.i(225374);
    this.aB.J.a();
    AppMethodBeat.o(225374);
  }
  
  public final void m()
  {
    AppMethodBeat.i(225002);
    int i1 = ((VectorMap)this.e_).r();
    this.ab = true;
    this.ac = true;
    if (i1 <= this.aa) {
      this.ac = false;
    }
    while (!this.q.isEmpty())
    {
      fr localfr = new fr();
      localfr.f = 0;
      localfr.g = this.ab;
      localfr.h = this.ac;
      Iterator localIterator = this.q.iterator();
      while (localIterator.hasNext()) {
        ((ey)localIterator.next()).a(localfr);
      }
      if (i1 >= this.Z) {
        this.ab = false;
      }
    }
    AppMethodBeat.o(225002);
  }
  
  public final void m(boolean paramBoolean)
  {
    AppMethodBeat.i(225393);
    super.m(paramBoolean);
    V();
    AppMethodBeat.o(225393);
  }
  
  public final void n()
  {
    AppMethodBeat.i(225013);
    if (!this.q.isEmpty())
    {
      fr localfr = new fr();
      localfr.f = 0;
      localfr.g = this.ab;
      localfr.h = this.ac;
      Iterator localIterator = this.q.iterator();
      while (localIterator.hasNext()) {
        ((ey)localIterator.next()).a(localfr);
      }
    }
    AppMethodBeat.o(225013);
  }
  
  public final boolean n(boolean paramBoolean)
  {
    AppMethodBeat.i(225492);
    if ((this.B != null) && (this.B.getLooper().getThread().isAlive()))
    {
      kh.b("TDZ", "send onStable Event");
      Handler localHandler = this.B;
      if (paramBoolean) {}
      for (int i1 = 2;; i1 = 1)
      {
        localHandler.sendEmptyMessage(i1);
        AppMethodBeat.o(225492);
        return true;
      }
    }
    AppMethodBeat.o(225492);
    return false;
  }
  
  public final boolean o()
  {
    return this.ab;
  }
  
  public void onCameraChange(final CameraPosition paramCameraPosition)
  {
    AppMethodBeat.i(225456);
    this.ay = false;
    this.az = true;
    jw.a(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(223636);
        if (sj.this.u != null)
        {
          Iterator localIterator = sj.this.u.iterator();
          while (localIterator.hasNext())
          {
            TencentMap.OnCameraChangeListener localOnCameraChangeListener = (TencentMap.OnCameraChangeListener)localIterator.next();
            if (localOnCameraChangeListener != null) {
              localOnCameraChangeListener.onCameraChange(paramCameraPosition);
            }
          }
        }
        if (sj.c(sj.this) != null) {
          sj.c(sj.this).onCameraChange(paramCameraPosition);
        }
        if (sj.d(sj.this) != null) {
          sj.d(sj.this).onCameraChange(paramCameraPosition);
        }
        AppMethodBeat.o(223636);
      }
    });
    AppMethodBeat.o(225456);
  }
  
  public void onCameraChangeFinished(final CameraPosition paramCameraPosition)
  {
    AppMethodBeat.i(225466);
    if ((this.aA != 0) || (!this.ay))
    {
      AppMethodBeat.o(225466);
      return;
    }
    this.az = false;
    jw.a(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(223588);
        if (sj.this.u != null)
        {
          Iterator localIterator = sj.this.u.iterator();
          while (localIterator.hasNext())
          {
            TencentMap.OnCameraChangeListener localOnCameraChangeListener = (TencentMap.OnCameraChangeListener)localIterator.next();
            if (localOnCameraChangeListener != null) {
              localOnCameraChangeListener.onCameraChangeFinished(paramCameraPosition);
            }
          }
        }
        if (sj.c(sj.this) != null) {
          sj.c(sj.this).onCameraChangeFinished(paramCameraPosition);
        }
        if (sj.d(sj.this) != null) {
          sj.d(sj.this).onCameraChangeFinished(paramCameraPosition);
        }
        AppMethodBeat.o(223588);
      }
    });
    AppMethodBeat.o(225466);
  }
  
  public void onCreated()
  {
    AppMethodBeat.i(224565);
    super.onCreated();
    this.B = new sb(this, jw.a("gesture"));
    this.aX = new pk((bd)this.d_);
    ((VectorMap)this.e_).a(this.aK);
    a(this.aV);
    ((VectorMap)this.e_).a(this.aJ);
    ((VectorMap)this.e_).a(this.aM);
    ((VectorMap)this.e_).a(this.aK);
    ((VectorMap)this.e_).a(this.aL);
    ((VectorMap)this.e_).a(this);
    this.o = new aa(this, S().c);
    AppMethodBeat.o(224565);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(224900);
    super.onDestroy();
    ((VectorMap)this.e_).a(null);
    if (this.u != null) {
      this.u.clear();
    }
    if (this.ap != null)
    {
      ou localou = this.ap;
      ((VectorMap)localou.c.e_).b(localou);
      localou.accessibleTouchItems.clear();
      localou.a.clear();
      localou.b.clear();
    }
    this.A = null;
    this.aq = null;
    this.aR = true;
    AppMethodBeat.o(224900);
  }
  
  public boolean onIndoorBuildingDeactivated()
  {
    AppMethodBeat.i(225445);
    boolean bool = ((mk)this.d_).J.a(null);
    AppMethodBeat.o(225445);
    return bool;
  }
  
  public boolean onIndoorBuildingFocused()
  {
    return false;
  }
  
  public boolean onIndoorLevelActivated(IndoorBuilding paramIndoorBuilding)
  {
    AppMethodBeat.i(225435);
    boolean bool = ((mk)this.d_).J.a(paramIndoorBuilding);
    AppMethodBeat.o(225435);
    return bool;
  }
  
  public void onResume()
  {
    AppMethodBeat.i(224890);
    super.onResume();
    this.aA = 0;
    this.az = false;
    if (Z()) {
      if ((this.aE instanceof View))
      {
        if (this.ap == null) {
          this.ap = new ou((View)this.aE, this);
        }
        this.ap.onTalkBackActivate(this.aE.getView());
      }
    }
    while (this.o != null)
    {
      aa localaa = this.o;
      if (localaa.g != null)
      {
        String str = localaa.g.getBuidlingId();
        int i1 = localaa.g.getActiveLevelIndex();
        Object localObject = localaa.g.getLevels();
        if ((localObject == null) || (i1 >= ((List)localObject).size()))
        {
          AppMethodBeat.o(224890);
          return;
          if (this.ap != null)
          {
            this.ap.onTalkBackDeActivate(this.aE.getView());
            this.ap = null;
          }
        }
        else
        {
          localObject = ((IndoorLevel)((List)localObject).get(i1)).getName();
          if ((!gz.a(str)) && (!gz.a((String)localObject))) {
            localaa.e.a(str, (String)localObject);
          }
        }
      }
    }
    AppMethodBeat.o(224890);
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(224879);
    if (this.t != null) {
      this.t.a(paramMotionEvent);
    }
    boolean bool = super.onTouchEvent(paramMotionEvent);
    AppMethodBeat.o(224879);
    return bool;
  }
  
  public final boolean p()
  {
    return this.ac;
  }
  
  public final pt q()
  {
    return this.n;
  }
  
  public final aa r()
  {
    return this.o;
  }
  
  public final GeoPoint s()
  {
    AppMethodBeat.i(225091);
    if (this.aO == null)
    {
      if (this.K == -2147483648) {
        this.K = (this.ak / 2);
      }
      if (this.L == -2147483648) {
        this.L = (this.al / 2);
      }
      localObject = new fl(this.K, this.L);
      this.aO = ((VectorMap)this.e_).v().a((fl)localObject);
    }
    Object localObject = this.aO;
    AppMethodBeat.o(225091);
    return localObject;
  }
  
  public final int t()
  {
    return this.M;
  }
  
  public final int u()
  {
    return this.N;
  }
  
  public final int v()
  {
    return this.K;
  }
  
  public final int w()
  {
    return this.L;
  }
  
  public final boolean x()
  {
    return this.aQ;
  }
  
  public final void y()
  {
    AppMethodBeat.i(225242);
    if (this.l == null) {
      this.l = new qj(this);
    }
    this.l.a();
    AppMethodBeat.o(225242);
  }
  
  public final void z()
  {
    AppMethodBeat.i(225251);
    if (this.l == null)
    {
      AppMethodBeat.o(225251);
      return;
    }
    this.l.b();
    AppMethodBeat.o(225251);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.mapsdk.internal.sj
 * JD-Core Version:    0.7.0.1
 */