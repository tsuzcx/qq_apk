package com.tencent.mapsdk.internal;

import android.content.Context;
import android.graphics.Rect;
import android.os.Build.VERSION;
import android.util.Log;
import android.view.MotionEvent;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityManager;
import com.tencent.map.lib.models.GeoPoint;
import com.tencent.mapsdk.vector.VectorMap;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tencentmap.mapsdk.maps.CustomRender;
import com.tencent.tencentmap.mapsdk.maps.TencentMap.InfoWindowAdapter;
import com.tencent.tencentmap.mapsdk.maps.TencentMap.OnMapLoadedCallback;
import com.tencent.tencentmap.mapsdk.maps.TencentMap.OnPolygonClickListener;
import com.tencent.tencentmap.mapsdk.maps.TencentMap.OnPolylineClickListener;
import com.tencent.tencentmap.mapsdk.maps.TencentMapOptions;
import com.tencent.tencentmap.mapsdk.maps.model.GeometryConstants;
import com.tencent.tencentmap.mapsdk.maps.model.TencentMapGestureListenerList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.egl.EGLContext;
import javax.microedition.khronos.opengles.GL10;

public abstract class sr
  extends bn<mk, VectorMap>
  implements az, nr, oe
{
  private static final int j = 10;
  private static final int k = 16;
  public int aA = 0;
  public mk aB;
  public float aC = 0.5F;
  public int aD = 0;
  protected bt aE = null;
  public volatile boolean aF;
  protected TencentMap.OnPolylineClickListener aG;
  protected TencentMap.OnPolygonClickListener aH;
  public TencentMap.InfoWindowAdapter aI;
  public List<TencentMap.OnMapLoadedCallback> au = new CopyOnWriteArrayList();
  public TencentMapGestureListenerList av = null;
  public boolean aw = true;
  protected volatile boolean ax = false;
  public volatile boolean ay = false;
  public volatile boolean az = false;
  private pl g;
  private ml h;
  private volatile boolean i;
  private boolean l;
  
  public sr(Context paramContext, TencentMapOptions paramTencentMapOptions, ViewGroup paramViewGroup)
  {
    super(paramContext, paramTencentMapOptions, paramViewGroup);
  }
  
  private void S()
  {
    if (this.aE != null) {
      this.aE.d();
    }
  }
  
  private void U()
  {
    if (this.h != null) {
      while (!this.h.b) {
        try
        {
          this.h.a = true;
          this.h.a();
          this.h.join();
        }
        catch (InterruptedException localInterruptedException)
        {
          kh.a(Log.getStackTraceString(localInterruptedException));
          Thread.currentThread().interrupt();
        }
      }
    }
    this.h = null;
    this.i = false;
  }
  
  private void V()
  {
    long l1 = System.currentTimeMillis();
    gq localgq = ((mk)this.d_).d;
    if (localgq != null) {
      localgq.a().a(true, l1);
    }
    this.aF = false;
  }
  
  private void W()
  {
    this.aF = true;
  }
  
  private bt a(mk parammk, ViewGroup paramViewGroup)
  {
    switch (3.a[this.d_.a.getMapViewType().ordinal()])
    {
    default: 
      parammk = new sv(parammk);
    }
    for (;;)
    {
      if (paramViewGroup != null) {
        paramViewGroup.addView(parammk.getView());
      }
      return parammk;
      parammk = new su(parammk);
      continue;
      parammk = new st(parammk);
    }
  }
  
  private void a(float paramFloat1, float paramFloat2, boolean paramBoolean)
  {
    this.aB.i.b(paramFloat1, paramFloat2, paramBoolean);
  }
  
  private void a(TencentMap.InfoWindowAdapter paramInfoWindowAdapter)
  {
    this.aI = paramInfoWindowAdapter;
  }
  
  private TencentMap.InfoWindowAdapter ab()
  {
    return this.aI;
  }
  
  private void ac()
  {
    this.ay = true;
    if ((this.av != null) && (this.aw)) {
      this.av.onMapStable();
    }
  }
  
  public static float b(float paramFloat)
  {
    int m = (int)paramFloat;
    paramFloat = (float)Math.pow(2.0D, paramFloat - m);
    return (1 << m - 3) * 3.051758E-005F * paramFloat;
  }
  
  private mk b(Context paramContext, TencentMapOptions paramTencentMapOptions)
  {
    this.aB = new mk(paramContext, paramTencentMapOptions, this);
    return this.aB;
  }
  
  private void n(boolean paramBoolean)
  {
    if (this.aE != null) {
      this.aE.setZOrderMediaOverlay(paramBoolean);
    }
  }
  
  public final no C()
  {
    if (this.aB == null) {
      return null;
    }
    return this.aB.u;
  }
  
  public final void D()
  {
    if ((this.h == null) && (this.aB != null)) {
      this.h = new ml(this.aB);
    }
    if (!this.i) {}
    try
    {
      this.h.start();
      this.i = true;
      return;
    }
    catch (Exception localException)
    {
      kh.a("startTextureCreatorIfNeed failed", localException);
    }
  }
  
  public final void E()
  {
    U();
    if (this.aB != null)
    {
      getEGLContextHash();
      this.aB.z();
    }
  }
  
  public final void F()
  {
    if (this.aE != null) {
      this.aE.d();
    }
    if (this.aB != null) {
      this.aB.v = true;
    }
  }
  
  public final Context G()
  {
    return this.e;
  }
  
  public final void H()
  {
    if (this.aB != null) {
      this.aB.v = true;
    }
  }
  
  public final boolean I()
  {
    boolean bool3 = false;
    boolean bool2 = bool3;
    mk localmk;
    if (this.aB != null)
    {
      localmk = this.aB;
      if (localmk.g == null) {
        break label44;
      }
    }
    label44:
    for (boolean bool1 = localmk.g.j();; bool1 = false)
    {
      bool2 = bool3;
      if (bool1) {
        bool2 = true;
      }
      return bool2;
    }
  }
  
  public final boolean J()
  {
    if (this.aB == null) {
      return false;
    }
    return this.aB.E();
  }
  
  public final TencentMapOptions K()
  {
    return this.f;
  }
  
  public final boolean N()
  {
    return this.ax;
  }
  
  public void P()
  {
    super.P();
    a(this.f);
  }
  
  public void T() {}
  
  public final int X()
  {
    if (this.aE != null) {
      return this.aE.getWidth();
    }
    return 2147483647;
  }
  
  public final int Y()
  {
    if (this.aE != null) {
      return this.aE.getHeight();
    }
    return 2147483647;
  }
  
  public final boolean Z()
  {
    Object localObject = this.e;
    if (localObject == null) {
      return false;
    }
    localObject = (AccessibilityManager)((Context)localObject).getSystemService("accessibility");
    boolean bool1 = ((AccessibilityManager)localObject).isEnabled();
    if (Build.VERSION.SDK_INT < 14) {
      return bool1;
    }
    boolean bool2 = ((AccessibilityManager)localObject).isTouchExplorationEnabled();
    return (bool1) && (bool2);
  }
  
  protected VectorMap a(mk parammk)
  {
    return new VectorMap(parammk);
  }
  
  public final void a(final float paramFloat1, final float paramFloat2, final float paramFloat3)
  {
    final float f2;
    if (this.aB != null)
    {
      float f1 = this.aB.i.A.b.p;
      f2 = b(paramFloat3);
      if (Math.abs(f1 - f2) <= 0.0001D) {
        break label84;
      }
    }
    label84:
    for (final boolean bool = true;; bool = false)
    {
      this.aD = 0;
      jw.a(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(222985);
          sr.a(sr.this, sr.a(sr.this) + this.a);
          sr.a(sr.this, paramFloat1, sr.a(sr.this));
          if (sr.b(sr.this) < 10)
          {
            jw.a(this, 16L);
            AppMethodBeat.o(222985);
            return;
          }
          sr.a(sr.this, paramFloat1, paramFloat2);
          if ((paramFloat3 >= 3.0F) && (paramFloat3 <= 20.0F))
          {
            if (bool)
            {
              Runnable local1 = new Runnable()
              {
                public final void run()
                {
                  AppMethodBeat.i(226171);
                  sr.c(sr.this).i.a(sr.1.this.f);
                  AppMethodBeat.o(226171);
                }
              };
              sr.c(sr.this).i.a((int)paramFloat3, local1);
              AppMethodBeat.o(222985);
              return;
            }
            sr.c(sr.this).i.a(f2);
          }
          AppMethodBeat.o(222985);
        }
      });
      return;
    }
  }
  
  public final void a(es parames)
  {
    this.g.a(parames);
  }
  
  public final void a(no paramno, lc paramlc)
  {
    if (this.aB.a(this.e.getApplicationContext(), paramno, paramlc, this))
    {
      paramno = this.aB.i;
      paramlc = new GeoPoint(ac.n, ac.m);
      v localv = paramno.A;
      Rect localRect = paramno.z.g();
      int m = paramlc.getLatitudeE6();
      int n = paramlc.getLongitudeE6();
      localv.n = localRect;
      localv.c = GeometryConstants.BOUNDARY_WORLD;
      localv.c(13);
      localv.a(0);
      localv.a(m, n, false);
      paramno.c();
      paramno.z.f().b(paramno.G);
    }
  }
  
  public final void a(nt paramnt)
  {
    this.aB.a(paramnt);
  }
  
  public final void a(TencentMap.OnPolygonClickListener paramOnPolygonClickListener)
  {
    this.aH = paramOnPolygonClickListener;
  }
  
  public final void a(TencentMap.OnPolylineClickListener paramOnPolylineClickListener)
  {
    this.aG = paramOnPolylineClickListener;
  }
  
  public void a(GL10 paramGL10, int paramInt1, int paramInt2)
  {
    paramGL10 = this.aB;
    if (paramGL10.g != null)
    {
      paramGL10.v = true;
      paramGL10.o.set(0, 0, paramInt1, paramInt2);
      paramGL10.a(0, 0, paramInt1, paramInt2, false);
      paramGL10.i.n();
    }
  }
  
  public void a(GL10 paramGL10, EGLConfig paramEGLConfig)
  {
    paramGL10 = this.aB;
    if ((paramGL10.g != null) && (paramGL10.h != null)) {
      paramGL10.h.a();
    }
  }
  
  public boolean a(GL10 paramGL10)
  {
    return this.aB.a(paramGL10);
  }
  
  public final void aa()
  {
    if (!this.ax) {
      jw.a(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(222994);
          Iterator localIterator = sr.this.au.iterator();
          while (localIterator.hasNext())
          {
            TencentMap.OnMapLoadedCallback localOnMapLoadedCallback = (TencentMap.OnMapLoadedCallback)localIterator.next();
            if (localOnMapLoadedCallback != null) {
              localOnMapLoadedCallback.onMapLoaded();
            }
          }
          AppMethodBeat.o(222994);
        }
      });
    }
    this.ax = true;
  }
  
  public final mk b()
  {
    return this.aB;
  }
  
  public final void b(es parames)
  {
    pl localpl = this.g;
    synchronized (localpl.a)
    {
      localpl.a.b(parames);
      return;
    }
  }
  
  public final boolean b(int paramInt)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (this.aB != null)
    {
      mk localmk = this.aB;
      bool1 = bool2;
      if (paramInt == mk.b.f.g)
      {
        bool1 = bool2;
        if (localmk.F != null)
        {
          localmk.F.onDrawFrame();
          bool1 = true;
        }
      }
    }
    return bool1;
  }
  
  public final mj c()
  {
    return this.aB.l;
  }
  
  public int getEGLContextHash()
  {
    Object localObject = (EGL10)EGLContext.getEGL();
    if (localObject != null)
    {
      localObject = ((EGL10)localObject).eglGetCurrentContext();
      if (localObject != null) {
        return localObject.hashCode();
      }
    }
    return 0;
  }
  
  public final void l(boolean paramBoolean)
  {
    this.aB.g.g(paramBoolean);
  }
  
  public final void m_()
  {
    if (this.aF)
    {
      long l1 = System.currentTimeMillis();
      gq localgq = ((mk)this.d_).d;
      if (localgq != null) {
        localgq.a().a(true, l1);
      }
      this.aF = false;
    }
  }
  
  public void onCreated()
  {
    super.onCreated();
    this.aE = getMapRenderView();
    this.g = new pl(this);
    this.aF = true;
    VectorMap localVectorMap = (VectorMap)this.e_;
    if (localVectorMap.o != null) {
      localVectorMap.o.G = this;
    }
  }
  
  public void onDestroy()
  {
    super.onDestroy();
  }
  
  public void onPause()
  {
    super.onPause();
    if (this.h != null) {
      this.h.a = true;
    }
    mk localmk = this.aB;
    if (localmk.g != null)
    {
      localmk.v = false;
      localmk.B = false;
      if (localmk.A != null) {
        localmk.A.g = true;
      }
      ac localac = localmk.i;
      if (localac.o != null) {
        localac.o.a();
      }
      localmk.g.l();
      if ((localmk.q) && (localmk.j != null)) {
        localmk.j.a();
      }
    }
  }
  
  /* Error */
  public void onResume()
  {
    // Byte code:
    //   0: aload_0
    //   1: invokespecial 585	com/tencent/mapsdk/internal/bn:onResume	()V
    //   4: aload_0
    //   5: getfield 97	com/tencent/mapsdk/internal/sr:h	Lcom/tencent/mapsdk/internal/ml;
    //   8: ifnull +21 -> 29
    //   11: aload_0
    //   12: getfield 97	com/tencent/mapsdk/internal/sr:h	Lcom/tencent/mapsdk/internal/ml;
    //   15: astore_1
    //   16: aload_1
    //   17: iconst_0
    //   18: putfield 105	com/tencent/mapsdk/internal/ml:a	Z
    //   21: aload_1
    //   22: monitorenter
    //   23: aload_1
    //   24: invokevirtual 588	java/lang/Object:notifyAll	()V
    //   27: aload_1
    //   28: monitorexit
    //   29: aload_0
    //   30: getfield 208	com/tencent/mapsdk/internal/sr:aB	Lcom/tencent/mapsdk/internal/mk;
    //   33: astore_1
    //   34: aload_1
    //   35: getfield 292	com/tencent/mapsdk/internal/mk:g	Lcom/tencent/mapsdk/internal/sc;
    //   38: ifnull +155 -> 193
    //   41: aload_1
    //   42: iconst_1
    //   43: putfield 281	com/tencent/mapsdk/internal/mk:v	Z
    //   46: aload_1
    //   47: iconst_1
    //   48: putfield 558	com/tencent/mapsdk/internal/mk:B	Z
    //   51: aload_1
    //   52: getfield 591	com/tencent/mapsdk/internal/mk:w	Z
    //   55: ifeq +144 -> 199
    //   58: aload_1
    //   59: getfield 211	com/tencent/mapsdk/internal/mk:i	Lcom/tencent/mapsdk/internal/ac;
    //   62: getfield 568	com/tencent/mapsdk/internal/ac:o	Lcom/tencent/mapsdk/internal/y;
    //   65: astore_2
    //   66: aload_2
    //   67: getfield 594	com/tencent/mapsdk/internal/y:d	Lcom/tencent/mapsdk/internal/y$a;
    //   70: ifnull +10 -> 80
    //   73: aload_2
    //   74: getfield 594	com/tencent/mapsdk/internal/y:d	Lcom/tencent/mapsdk/internal/y$a;
    //   77: invokevirtual 599	com/tencent/mapsdk/internal/y$a:destroy	()V
    //   80: aload_2
    //   81: new 596	com/tencent/mapsdk/internal/y$a
    //   84: dup
    //   85: aload_2
    //   86: invokespecial 602	com/tencent/mapsdk/internal/y$a:<init>	(Lcom/tencent/mapsdk/internal/y;)V
    //   89: putfield 594	com/tencent/mapsdk/internal/y:d	Lcom/tencent/mapsdk/internal/y$a;
    //   92: aload_2
    //   93: getfield 594	com/tencent/mapsdk/internal/y:d	Lcom/tencent/mapsdk/internal/y$a;
    //   96: invokevirtual 603	com/tencent/mapsdk/internal/y$a:start	()V
    //   99: aload_1
    //   100: iconst_0
    //   101: putfield 591	com/tencent/mapsdk/internal/mk:w	Z
    //   104: aload_1
    //   105: getfield 606	com/tencent/mapsdk/internal/mk:m	Lcom/tencent/mapsdk/internal/az;
    //   108: ifnull +17 -> 125
    //   111: aload_1
    //   112: getfield 606	com/tencent/mapsdk/internal/mk:m	Lcom/tencent/mapsdk/internal/az;
    //   115: invokeinterface 607 1 0
    //   120: invokeinterface 92 1 0
    //   125: aload_1
    //   126: getfield 609	com/tencent/mapsdk/internal/mk:p	Z
    //   129: ifeq +10 -> 139
    //   132: aload_1
    //   133: getfield 292	com/tencent/mapsdk/internal/mk:g	Lcom/tencent/mapsdk/internal/sc;
    //   136: invokevirtual 611	com/tencent/mapsdk/internal/sc:k	()V
    //   139: aload_1
    //   140: getfield 576	com/tencent/mapsdk/internal/mk:q	Z
    //   143: ifeq +17 -> 160
    //   146: aload_1
    //   147: getfield 579	com/tencent/mapsdk/internal/mk:j	Lcom/tencent/mapsdk/internal/qs;
    //   150: ifnull +10 -> 160
    //   153: aload_1
    //   154: getfield 579	com/tencent/mapsdk/internal/mk:j	Lcom/tencent/mapsdk/internal/qs;
    //   157: invokevirtual 613	com/tencent/mapsdk/internal/qs:b	()V
    //   160: aload_1
    //   161: getfield 561	com/tencent/mapsdk/internal/mk:A	Lcom/tencent/mapsdk/internal/qw;
    //   164: ifnull +29 -> 193
    //   167: aload_1
    //   168: getfield 561	com/tencent/mapsdk/internal/mk:A	Lcom/tencent/mapsdk/internal/qw;
    //   171: astore_2
    //   172: aload_2
    //   173: iconst_0
    //   174: putfield 565	com/tencent/mapsdk/internal/qw:g	Z
    //   177: aload_2
    //   178: getfield 616	com/tencent/mapsdk/internal/qw:j	Lcom/tencent/mapsdk/internal/qw$a;
    //   181: astore_1
    //   182: aload_1
    //   183: monitorenter
    //   184: aload_2
    //   185: getfield 616	com/tencent/mapsdk/internal/qw:j	Lcom/tencent/mapsdk/internal/qw$a;
    //   188: invokevirtual 588	java/lang/Object:notifyAll	()V
    //   191: aload_1
    //   192: monitorexit
    //   193: return
    //   194: astore_2
    //   195: aload_1
    //   196: monitorexit
    //   197: aload_2
    //   198: athrow
    //   199: aload_1
    //   200: getfield 211	com/tencent/mapsdk/internal/mk:i	Lcom/tencent/mapsdk/internal/ac;
    //   203: astore_2
    //   204: aload_2
    //   205: getfield 568	com/tencent/mapsdk/internal/ac:o	Lcom/tencent/mapsdk/internal/y;
    //   208: ifnull -104 -> 104
    //   211: aload_2
    //   212: getfield 568	com/tencent/mapsdk/internal/ac:o	Lcom/tencent/mapsdk/internal/y;
    //   215: invokevirtual 617	com/tencent/mapsdk/internal/y:b	()V
    //   218: goto -114 -> 104
    //   221: astore_2
    //   222: aload_1
    //   223: monitorexit
    //   224: aload_2
    //   225: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	226	0	this	sr
    //   65	120	2	localObject2	Object
    //   194	4	2	localObject3	Object
    //   203	9	2	localac	ac
    //   221	4	2	localObject4	Object
    // Exception table:
    //   from	to	target	type
    //   23	29	194	finally
    //   184	193	221	finally
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    if (this.g != null) {
      return this.g.onTouch(null, paramMotionEvent);
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.mapsdk.internal.sr
 * JD-Core Version:    0.7.0.1
 */