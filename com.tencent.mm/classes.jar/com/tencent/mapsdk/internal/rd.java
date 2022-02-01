package com.tencent.mapsdk.internal;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.text.TextPaint;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.map.tools.net.NetManager;
import com.tencent.map.tools.net.NetRequest.NetRequestBuilder;
import com.tencent.map.tools.net.NetResponse;
import com.tencent.mapsdk.vector.VectorMap;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.File;
import java.io.FileInputStream;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

public final class rd
  extends ej
{
  private static final int ab = 6;
  private static final float ae = 0.7F;
  private static final float af = 1.3F;
  public static final int[] e = { 1, 2, 5 };
  private Context A;
  private Bitmap B;
  private Bitmap C;
  private el.b D;
  private el.b E;
  private ViewGroup F;
  private int[] G;
  private int[] H;
  private int[] I;
  private int[] J;
  private float[] K;
  private float[] L;
  private float[] M;
  private int N;
  private int O;
  private int P;
  private int Q;
  private int R;
  private int S;
  private TextView T;
  private final List<rh> U;
  private final ConcurrentHashMap<String, Bitmap> V;
  private final List<String> W;
  private String X;
  private int Y;
  private float Z;
  public ImageView a;
  private rd.e aa;
  private LinearLayout ac;
  private final int ad;
  private Animation ag;
  private int ah;
  private int ai;
  private jx.a aj;
  private boolean ak;
  public boolean b;
  public float[] c;
  public int d;
  public String f;
  public int g;
  public int h;
  public double i;
  public boolean j;
  public boolean k;
  public LinearLayout l;
  public float m;
  public int n;
  public List<c> o;
  public int p;
  public int q;
  public pt r;
  private final int s;
  private final int t;
  private Bitmap u;
  private Rect v;
  private boolean w;
  private volatile boolean x;
  private fs y;
  private boolean z;
  
  public rd(Context paramContext, final sj paramsj)
  {
    AppMethodBeat.i(223409);
    this.s = 500;
    this.t = 1000;
    this.D = el.b.c;
    this.E = el.b.a;
    this.b = true;
    this.c = new float[] { -1.0F, -1.0F, -1.0F, -1.0F };
    this.G = new int[] { -1, -1, -1, -1 };
    this.H = new int[] { -1, -1, -1, -1 };
    this.I = new int[el.a.values().length];
    this.J = new int[el.a.values().length];
    this.K = new float[] { 0.02F, 0.02F, 0.012F, 0.012F };
    this.L = new float[] { 0.022F, 0.022F, 0.0125F, 0.0125F };
    this.M = new float[] { 0.0185F, 0.0185F, 0.0104F, 0.0104F };
    this.N = 0;
    this.O = 0;
    this.P = 0;
    this.Q = 0;
    this.R = 0;
    this.S = 0;
    this.U = new CopyOnWriteArrayList();
    this.V = new ConcurrentHashMap();
    this.W = new CopyOnWriteArrayList();
    this.X = null;
    this.d = 0;
    this.f = "50米";
    this.Y = 11;
    this.g = 109;
    this.Z = 1.0F;
    this.j = true;
    this.k = false;
    this.ad = 18;
    this.m = 1.4E-45F;
    this.o = new ArrayList();
    this.ah = -1;
    this.ai = -1;
    this.p = -1;
    this.q = -1;
    this.ak = true;
    this.A = paramContext;
    this.Z = paramContext.getResources().getDisplayMetrics().density;
    this.n = ((int)(35.0F * this.Z + 0.5D));
    this.a = new ImageView(paramContext);
    this.aa = new rd.e(this, this.A);
    this.T = new mh(this.A, paramsj.d_);
    this.T.setText(this.f);
    this.T.setContentDescription("地图");
    this.T.setTextSize(12.0F);
    this.T.setTextColor(-16777216);
    this.T.setGravity(1);
    if (this.Z <= 0.0F) {
      this.Z = 1.0F;
    }
    this.ac = new LinearLayout(this.A);
    this.ac.setOrientation(1);
    this.ac.setGravity(16);
    this.ac.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(226224);
        if (rd.a(rd.this) == null) {
          rd.a(rd.this, jx.a(rd.b(rd.this), null, " ", 0));
        }
        kh.a(rd.b(rd.this), rd.a(rd.this));
        AppMethodBeat.o(226224);
      }
    });
    this.ac.setOnLongClickListener(new View.OnLongClickListener()
    {
      public final boolean onLongClick(View paramAnonymousView)
      {
        AppMethodBeat.i(226240);
        boolean bool = gc.a(paramsj.d_);
        AppMethodBeat.o(226240);
        return bool;
      }
    });
    this.l = new LinearLayout(this.A);
    this.l.setOrientation(1);
    this.l.setGravity(16);
    paramContext = new LinearLayout.LayoutParams(-2, -2);
    paramContext.gravity = 3;
    this.l.addView(this.T, paramContext);
    paramContext = new LinearLayout.LayoutParams(-2, -2);
    paramContext.gravity = 3;
    this.l.addView(this.aa, paramContext);
    this.l.setVisibility(8);
    this.ag = new AlphaAnimation(1.0F, 0.0F);
    this.ag.setDuration(1000L);
    this.ag.setStartOffset(500L);
    this.ag.setAnimationListener(new rd.3(this));
    paramContext = new LinearLayout.LayoutParams(-2, -2);
    paramContext.gravity = 3;
    this.ac.addView(this.a, paramContext);
    paramContext = paramsj.k.b;
    if (paramContext != null) {
      a(paramContext.c());
    }
    AppMethodBeat.o(223409);
  }
  
  private float a(el.a parama)
  {
    return this.c[parama.e];
  }
  
  private FrameLayout.LayoutParams a(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(223584);
    FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(-2, -2);
    if ((paramInt1 == 0) || (paramInt2 == 0))
    {
      AppMethodBeat.o(223584);
      return localLayoutParams;
    }
    switch (6.a[this.D.ordinal()])
    {
    default: 
      kh.c("Unknown position:" + this.D);
    }
    for (;;)
    {
      AppMethodBeat.o(223584);
      return localLayoutParams;
      localLayoutParams.gravity = 83;
      localLayoutParams.bottomMargin = this.I[el.a.c.e];
      localLayoutParams.leftMargin = this.I[el.a.a.e];
      this.ai = (this.O - localLayoutParams.bottomMargin - paramInt2);
      this.ah = localLayoutParams.leftMargin;
      continue;
      localLayoutParams.gravity = 81;
      localLayoutParams.bottomMargin = this.I[el.a.c.e];
      this.ai = (this.O - localLayoutParams.bottomMargin - paramInt2);
      this.ah = ((this.N - paramInt1) / 2);
      continue;
      localLayoutParams.gravity = 85;
      localLayoutParams.bottomMargin = this.I[el.a.c.e];
      localLayoutParams.rightMargin = this.I[el.a.b.e];
      pt localpt;
      int i1;
      if ((ry.c.equals("wechat")) && (this.r != null))
      {
        localpt = this.r;
        i1 = paramInt2 * 2 + localLayoutParams.bottomMargin;
        localpt.g = i1;
        if (localpt.a != null) {
          localpt.a.post(new pt.1(localpt));
        }
        if (localpt.b != null) {
          localpt.h = localpt.b.getMeasuredHeight();
        }
        if ((localpt.f != null) && (localpt.f.e_ != null) && (((VectorMap)localpt.f.e_).o.t != null) && (((VectorMap)localpt.f.e_).o.t.q != null)) {
          break label461;
        }
      }
      for (;;)
      {
        this.ai = (this.O - localLayoutParams.bottomMargin - paramInt2);
        this.ah = (this.N - localLayoutParams.rightMargin - paramInt1);
        break;
        label461:
        localpt.h = (((int)((VectorMap)localpt.f.e_).o.t.q.b - i1) * 2);
        localpt.f();
      }
      localLayoutParams.gravity = 51;
      localLayoutParams.topMargin = this.I[el.a.d.e];
      localLayoutParams.leftMargin = this.I[el.a.a.e];
      this.ai = localLayoutParams.topMargin;
      this.ah = localLayoutParams.leftMargin;
      continue;
      localLayoutParams.gravity = 49;
      localLayoutParams.topMargin = this.I[el.a.d.e];
      this.ai = localLayoutParams.topMargin;
      this.ah = ((this.N - paramInt1) / 2);
      continue;
      localLayoutParams.gravity = 53;
      localLayoutParams.topMargin = this.I[el.a.d.e];
      localLayoutParams.rightMargin = this.I[el.a.b.e];
      this.ai = localLayoutParams.topMargin;
      this.ah = (this.N - localLayoutParams.rightMargin - paramInt1);
    }
  }
  
  private String a(String paramString)
  {
    AppMethodBeat.i(223491);
    String str = o();
    kb.a(str);
    paramString = str + "/" + paramString;
    AppMethodBeat.o(223491);
    return paramString;
  }
  
  private void a(float paramFloat)
  {
    float f2 = 1.3F;
    float f1 = 0.7F;
    AppMethodBeat.i(223838);
    if (paramFloat > 1.3F) {
      paramFloat = f2;
    }
    for (;;)
    {
      if (paramFloat < 0.7F) {
        paramFloat = f1;
      }
      for (;;)
      {
        this.d = 0;
        this.m = paramFloat;
        h();
        AppMethodBeat.o(223838);
        return;
      }
    }
  }
  
  @Deprecated
  private void a(int paramInt)
  {
    AppMethodBeat.i(223817);
    this.d = paramInt;
    this.m = 1.4E-45F;
    h();
    AppMethodBeat.o(223817);
  }
  
  private void a(int paramInt, double paramDouble)
  {
    int i2 = 0;
    AppMethodBeat.i(223785);
    this.h = paramInt;
    this.i = paramDouble;
    int i3 = (int)Math.log10(this.n * this.i);
    paramInt = (int)(e[0] * Math.pow(10.0D, i3));
    int i1 = (int)(paramInt / this.i);
    if ((i1 <= 0) || (Double.isNaN(this.i))) {}
    for (;;)
    {
      f();
      AppMethodBeat.o(223785);
      return;
      while (i1 < this.n)
      {
        i2 += 1;
        paramInt = e.length;
        paramInt = (int)(e[(i2 % paramInt)] * Math.pow(10.0D, i2 / e.length + i3));
        i1 = (int)(paramInt / this.i);
      }
      String str = "米";
      i2 = paramInt;
      if (paramInt >= 1000)
      {
        i2 = paramInt / 1000;
        str = "公里";
      }
      this.f = (i2 + str);
      this.g = i1;
      jw.a(new rd.5(this));
    }
  }
  
  private void a(Bitmap paramBitmap)
  {
    AppMethodBeat.i(223534);
    try
    {
      this.B = paramBitmap;
      if (this.B != null)
      {
        this.P = this.B.getWidth();
        this.Q = this.B.getHeight();
        this.x = true;
      }
      h();
      i();
      AppMethodBeat.o(223534);
      return;
    }
    catch (Exception paramBitmap)
    {
      AppMethodBeat.o(223534);
    }
  }
  
  private void a(el.a parama, float paramFloat)
  {
    float f1 = 1.0F;
    float f2 = 0.0F;
    AppMethodBeat.i(223625);
    if (paramFloat < 0.0F) {
      paramFloat = f2;
    }
    for (;;)
    {
      if (paramFloat > 1.0F) {
        paramFloat = f1;
      }
      for (;;)
      {
        this.c[parama.e] = paramFloat;
        h();
        AppMethodBeat.o(223625);
        return;
      }
    }
  }
  
  private void a(pt parampt)
  {
    this.r = parampt;
  }
  
  private void a(c paramc)
  {
    AppMethodBeat.i(223890);
    if ((this.o != null) && (paramc != null)) {
      this.o.add(paramc);
    }
    AppMethodBeat.o(223890);
  }
  
  private void a(String paramString1, String paramString2)
  {
    AppMethodBeat.i(223448);
    if (this.W.contains(paramString2))
    {
      kh.c("TLG", "Logo[" + paramString2 + "] is downloading.");
      AppMethodBeat.o(223448);
      return;
    }
    this.W.add(paramString2);
    kh.c("TLG", "Logo[" + paramString2 + "] start download..");
    jw.a(new a(this, paramString1, paramString2)).a(null, new b(this, paramString2));
    AppMethodBeat.o(223448);
  }
  
  private int b(el.a parama)
  {
    return this.G[parama.e];
  }
  
  private String b(String paramString)
  {
    AppMethodBeat.i(223501);
    paramString = a(paramString) + ".tmp";
    AppMethodBeat.o(223501);
    return paramString;
  }
  
  private void b(boolean paramBoolean)
  {
    AppMethodBeat.i(223666);
    this.b = paramBoolean;
    ImageView localImageView;
    if (this.a != null)
    {
      localImageView = this.a;
      if (!paramBoolean) {
        break label41;
      }
    }
    label41:
    for (int i1 = 0;; i1 = 4)
    {
      localImageView.setVisibility(i1);
      AppMethodBeat.o(223666);
      return;
    }
  }
  
  private int c(el.a parama)
  {
    return this.I[parama.e];
  }
  
  private Bitmap c(String paramString)
  {
    AppMethodBeat.i(223520);
    try
    {
      paramString = new File(a(paramString));
      boolean bool = paramString.exists();
      if (!bool)
      {
        kb.a(null);
        AppMethodBeat.o(223520);
        return null;
      }
      paramString = new FileInputStream(paramString);
      Bitmap localBitmap;
      kb.a(paramString);
    }
    finally
    {
      try
      {
        localBitmap = BitmapFactory.decodeStream(paramString);
        kb.a(paramString);
        AppMethodBeat.o(223520);
        return localBitmap;
      }
      finally
      {
        break label69;
      }
      paramString = finally;
      paramString = null;
    }
    label69:
    AppMethodBeat.o(223520);
    return null;
  }
  
  private void c(boolean paramBoolean)
  {
    AppMethodBeat.i(223711);
    if (this.j != paramBoolean)
    {
      this.j = paramBoolean;
      if (this.o != null)
      {
        Iterator localIterator = this.o.iterator();
        while (localIterator.hasNext()) {
          ((c)localIterator.next()).b(this.l, new Rect(this.p, this.q, 0, 0), this.j);
        }
      }
    }
    e();
    AppMethodBeat.o(223711);
  }
  
  private int[] c(int paramInt1, int paramInt2)
  {
    float f2 = 1.0F;
    float f1;
    if (this.m != 1.4E-45F) {
      f1 = this.m;
    }
    for (;;)
    {
      return new int[] { (int)(paramInt1 * f1), (int)(f1 * paramInt2) };
      f1 = f2;
      switch (this.d)
      {
      case 0: 
      default: 
        f1 = f2;
        break;
      case -3: 
        f1 = 0.7F;
        break;
      case 1: 
        f1 = 1.2F;
        break;
      case -1: 
        f1 = 0.8333333F;
        break;
      case -2: 
        f1 = 0.8F;
      }
    }
  }
  
  private int d(el.a parama)
  {
    return this.H[parama.e];
  }
  
  private void d(boolean paramBoolean)
  {
    AppMethodBeat.i(223735);
    LinearLayout localLinearLayout;
    if (this.l != null)
    {
      localLinearLayout = this.l;
      if (!paramBoolean) {
        break label64;
      }
    }
    label64:
    for (int i1 = 0;; i1 = 8)
    {
      localLinearLayout.setVisibility(i1);
      this.l.requestLayout();
      this.l.invalidate();
      if (this.aa != null) {
        this.aa.invalidate();
      }
      AppMethodBeat.o(223735);
      return;
    }
  }
  
  private void e(boolean paramBoolean)
  {
    AppMethodBeat.i(223854);
    if (!paramBoolean) {}
    for (paramBoolean = true;; paramBoolean = false)
    {
      this.k = paramBoolean;
      e();
      AppMethodBeat.o(223854);
      return;
    }
  }
  
  private void n()
  {
    AppMethodBeat.i(223426);
    this.ag = new AlphaAnimation(1.0F, 0.0F);
    this.ag.setDuration(1000L);
    this.ag.setStartOffset(500L);
    this.ag.setAnimationListener(new rd.3(this));
    AppMethodBeat.o(223426);
  }
  
  private String o()
  {
    AppMethodBeat.i(223461);
    String str = this.A.getFilesDir().getAbsolutePath() + "/tencentMapSdk/logos";
    AppMethodBeat.o(223461);
    return str;
  }
  
  private String p()
  {
    AppMethodBeat.i(223476);
    String str = this.A.getFilesDir().getAbsolutePath() + "/tencentMapSdk/oldLogos";
    AppMethodBeat.o(223476);
    return str;
  }
  
  private void q()
  {
    AppMethodBeat.i(223545);
    this.V.clear();
    AppMethodBeat.o(223545);
  }
  
  private FrameLayout.LayoutParams r()
  {
    AppMethodBeat.i(223604);
    FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(-2, -2);
    if (this.l == null)
    {
      AppMethodBeat.o(223604);
      return localLayoutParams;
    }
    int i1 = this.l.getMeasuredWidth();
    int i2 = this.l.getMeasuredHeight();
    switch (6.a[this.E.ordinal()])
    {
    default: 
      kh.c("Unknown positionScale:" + this.E);
    }
    for (;;)
    {
      AppMethodBeat.o(223604);
      return localLayoutParams;
      localLayoutParams.gravity = 83;
      localLayoutParams.bottomMargin = this.J[el.a.c.e];
      localLayoutParams.leftMargin = this.J[el.a.a.e];
      this.q = (this.O - localLayoutParams.bottomMargin - i2);
      this.p = localLayoutParams.leftMargin;
      continue;
      localLayoutParams.gravity = 81;
      localLayoutParams.bottomMargin = this.J[el.a.c.e];
      this.q = (this.O - localLayoutParams.bottomMargin - i2);
      this.p = ((this.N - i1) / 2);
      continue;
      localLayoutParams.gravity = 85;
      localLayoutParams.bottomMargin = this.J[el.a.c.e];
      localLayoutParams.rightMargin = this.J[el.a.b.e];
      this.q = (this.O - localLayoutParams.bottomMargin - i2);
      this.p = (this.N - localLayoutParams.rightMargin - i1);
      continue;
      localLayoutParams.gravity = 51;
      localLayoutParams.topMargin = this.J[el.a.d.e];
      localLayoutParams.leftMargin = this.J[el.a.a.e];
      this.q = localLayoutParams.topMargin;
      this.p = localLayoutParams.leftMargin;
      continue;
      localLayoutParams.gravity = 49;
      localLayoutParams.topMargin = this.J[el.a.d.e];
      this.q = localLayoutParams.topMargin;
      this.p = ((this.N - i1) / 2);
      continue;
      localLayoutParams.gravity = 53;
      localLayoutParams.topMargin = this.J[el.a.d.e];
      localLayoutParams.rightMargin = this.J[el.a.b.e];
      this.q = localLayoutParams.topMargin;
      this.p = (this.N - localLayoutParams.rightMargin - i1);
    }
  }
  
  private el.b s()
  {
    return this.E;
  }
  
  private void t()
  {
    AppMethodBeat.i(223685);
    h();
    AppMethodBeat.o(223685);
  }
  
  private void u()
  {
    AppMethodBeat.i(223696);
    i();
    AppMethodBeat.o(223696);
  }
  
  private boolean v()
  {
    return this.j;
  }
  
  private void w()
  {
    AppMethodBeat.i(223752);
    x();
    this.l.startAnimation(this.ag);
    AppMethodBeat.o(223752);
  }
  
  private void x()
  {
    AppMethodBeat.i(223766);
    if ((this.l == null) || (this.ag == null))
    {
      AppMethodBeat.o(223766);
      return;
    }
    this.l.clearAnimation();
    this.ag.reset();
    AppMethodBeat.o(223766);
  }
  
  private void y()
  {
    int i3 = 0;
    AppMethodBeat.i(223804);
    int i4 = (int)Math.log10(this.n * this.i);
    int i1 = (int)(e[0] * Math.pow(10.0D, i4));
    int i2 = (int)(i1 / this.i);
    if ((i2 <= 0) || (Double.isNaN(this.i)))
    {
      AppMethodBeat.o(223804);
      return;
    }
    while (i2 < this.n)
    {
      i3 += 1;
      i1 = e.length;
      i1 = (int)(e[(i3 % i1)] * Math.pow(10.0D, i3 / e.length + i4));
      i2 = (int)(i1 / this.i);
    }
    String str = "米";
    i3 = i1;
    if (i1 >= 1000)
    {
      i3 = i1 / 1000;
      str = "公里";
    }
    this.f = (i3 + str);
    this.g = i2;
    jw.a(new rd.5(this));
    AppMethodBeat.o(223804);
  }
  
  public final Rect a()
  {
    AppMethodBeat.i(224410);
    Rect localRect = new Rect();
    if (this.ac != null)
    {
      localRect.left = this.ac.getLeft();
      localRect.bottom = this.ac.getBottom();
      localRect.right = this.ac.getRight();
      localRect.top = this.ac.getTop();
    }
    AppMethodBeat.o(224410);
    return localRect;
  }
  
  public final void a(el.a parama, int paramInt)
  {
    this.G[parama.e] = paramInt;
  }
  
  public final void a(el.b paramb)
  {
    AppMethodBeat.i(224359);
    if (this.D != paramb) {
      f();
    }
    this.D = paramb;
    AppMethodBeat.o(224359);
  }
  
  public final void a(fs paramfs, boolean paramBoolean)
  {
    AppMethodBeat.i(224275);
    if ((this.B != null) && (!paramfs.a(this.y)) && (this.z == paramBoolean))
    {
      AppMethodBeat.o(224275);
      return;
    }
    this.y = paramfs.a();
    this.z = paramBoolean;
    int i1 = (int)paramfs.c;
    if (i1 > 18) {
      i1 = 18;
    }
    for (;;)
    {
      Iterator localIterator = this.U.iterator();
      Object localObject1 = null;
      for (;;)
      {
        Object localObject2;
        String str1;
        String str2;
        if (localIterator.hasNext())
        {
          localObject2 = (rh)localIterator.next();
          if ((i1 >= ((rh)localObject2).a) && (i1 <= ((rh)localObject2).b))
          {
            localObject1 = ((rh)localObject2).a(paramfs, paramBoolean);
            if (localObject1 == null) {
              break label504;
            }
            str1 = (String)localObject1[0];
            str2 = (String)localObject1[1];
            localObject1 = (Bitmap)localObject1[2];
            if (localObject1 != null)
            {
              a((Bitmap)localObject1);
              this.X = str1;
            }
          }
        }
        for (;;)
        {
          if (localObject2 == null)
          {
            if ((this.u == null) || (this.u.isRecycled())) {
              this.u = gv.b(this.A, "default_tencent_map_logo.png");
            }
            if (this.u != null) {
              a(this.u);
            }
          }
          AppMethodBeat.o(224275);
          return;
          if (!gz.a(str1, this.X)) {}
          for (int i2 = 1;; i2 = 0)
          {
            localObject1 = localObject2;
            if (i2 == 0) {
              break label494;
            }
            kh.c("TLG", "Logo[" + str1 + "] changed! old=" + this.X + "|dark=" + paramBoolean + "|level=" + i1);
            paramfs = (Bitmap)this.V.get(str1);
            if (paramfs == null) {
              break label406;
            }
            if (paramfs.isRecycled()) {
              break;
            }
            a(paramfs);
            this.X = str1;
            kh.c("TLG", "Logo[" + str1 + "] set from mem cache");
            AppMethodBeat.o(224275);
            return;
          }
          this.V.remove(str1);
          label406:
          paramfs = c(str1);
          if (paramfs != null)
          {
            this.X = str1;
            this.V.put(this.X, paramfs);
            a(paramfs);
            kh.c("TLG", "Logo[" + str1 + "] set from file cache");
            AppMethodBeat.o(224275);
            return;
          }
          this.X = null;
          a(str2, str1);
          continue;
          label494:
          break;
          localObject2 = localObject1;
        }
        label504:
        localObject1 = localObject2;
      }
    }
  }
  
  public final void a(List<rm> paramList)
  {
    AppMethodBeat.i(224294);
    if ((paramList == null) || (paramList.isEmpty()))
    {
      AppMethodBeat.o(224294);
      return;
    }
    this.U.clear();
    int i1 = 0;
    while (i1 < paramList.size())
    {
      Object localObject = (rm)paramList.get(i1);
      int[] arrayOfInt = ((rm)localObject).a;
      int i2 = arrayOfInt[0];
      int i3 = arrayOfInt[1];
      localObject = ((rm)localObject).b;
      this.U.add(new rh(i2, i3, (List)localObject));
      i1 += 1;
    }
    AppMethodBeat.o(224294);
  }
  
  public final void a(boolean paramBoolean)
  {
    AppMethodBeat.i(224244);
    jw.a(new rd.4(this, paramBoolean));
    AppMethodBeat.o(224244);
  }
  
  public final boolean a(ViewGroup paramViewGroup, Bundle paramBundle)
  {
    AppMethodBeat.i(224205);
    if (paramViewGroup == null)
    {
      AppMethodBeat.o(224205);
      return false;
    }
    this.F = paramViewGroup;
    if (this.x)
    {
      kb.a(new Bitmap[] { this.C });
      this.C = gv.a(this.B, this.A, this.R, this.S);
      this.a.setImageBitmap(this.C);
    }
    int i1 = this.R;
    int i2 = this.S;
    paramBundle = new FrameLayout.LayoutParams(-2, -2);
    if ((i1 == 0) || (i2 == 0))
    {
      if (paramViewGroup.indexOfChild(this.ac) >= 0) {
        break label1286;
      }
      paramViewGroup.addView(this.ac, paramBundle);
      label132:
      paramBundle = new FrameLayout.LayoutParams(-2, -2);
      if (this.l != null)
      {
        i1 = this.l.getMeasuredWidth();
        i2 = this.l.getMeasuredHeight();
      }
      switch (6.a[this.E.ordinal()])
      {
      default: 
        kh.c("Unknown positionScale:" + this.E);
        label243:
        if (paramViewGroup.indexOfChild(this.l) < 0)
        {
          paramViewGroup.addView(this.l, paramBundle);
          if ((this.T != null) && (this.aa != null))
          {
            paramBundle = (LinearLayout.LayoutParams)this.T.getLayoutParams();
            i2 = this.T.getWidth();
            i1 = i2;
            if (i2 == 0) {
              i1 = (int)this.T.getPaint().measureText(this.T.getText().toString());
            }
            float f1 = this.Z;
            paramBundle.leftMargin = ((int)((this.g - i1) / 2 + 6.0F * f1));
            this.l.updateViewLayout(this.T, paramBundle);
            this.l.updateViewLayout(this.aa, this.aa.getLayoutParams());
            e();
          }
          paramBundle = this.a;
          if (!this.b) {
            break label1660;
          }
        }
        label263:
        break;
      }
    }
    label1081:
    label1660:
    for (i1 = 0;; i1 = 4)
    {
      paramBundle.setVisibility(i1);
      if (this.o == null) {
        break label1666;
      }
      this.ac.requestLayout();
      this.l.requestLayout();
      paramBundle = this.o.iterator();
      Object localObject;
      while (paramBundle.hasNext())
      {
        localObject = (c)paramBundle.next();
        if ((this.v == null) || (this.x) || (this.w != this.b) || (this.v.left != this.ah) || (this.v.right != this.ai) || (this.v.top != this.ah + this.ac.getMeasuredWidth()) || (this.v.bottom != this.ai + this.ac.getMeasuredHeight()))
        {
          this.w = this.b;
          this.v = new Rect(this.ah, this.ai, this.ah + this.ac.getMeasuredWidth(), this.ai + this.ac.getMeasuredHeight());
          ((c)localObject).a(this.ac, this.v, this.b);
        }
        ((c)localObject).b(this.l, new Rect(this.p, this.q, 0, 0), this.j);
      }
      switch (6.a[this.D.ordinal()])
      {
      default: 
        kh.c("Unknown position:" + this.D);
      }
      for (;;)
      {
        break;
        paramBundle.gravity = 83;
        paramBundle.bottomMargin = this.I[el.a.c.e];
        paramBundle.leftMargin = this.I[el.a.a.e];
        this.ai = (this.O - paramBundle.bottomMargin - i2);
        this.ah = paramBundle.leftMargin;
        continue;
        paramBundle.gravity = 81;
        paramBundle.bottomMargin = this.I[el.a.c.e];
        this.ai = (this.O - paramBundle.bottomMargin - i2);
        this.ah = ((this.N - i1) / 2);
        continue;
        paramBundle.gravity = 85;
        paramBundle.bottomMargin = this.I[el.a.c.e];
        paramBundle.rightMargin = this.I[el.a.b.e];
        int i3;
        if ((ry.c.equals("wechat")) && (this.r != null))
        {
          localObject = this.r;
          i3 = i2 * 2 + paramBundle.bottomMargin;
          ((pt)localObject).g = i3;
          if (((pt)localObject).a != null) {
            ((pt)localObject).a.post(new pt.1((pt)localObject));
          }
          if (((pt)localObject).b != null) {
            ((pt)localObject).h = ((pt)localObject).b.getMeasuredHeight();
          }
          if ((((pt)localObject).f != null) && (((pt)localObject).f.e_ != null) && (((VectorMap)((pt)localObject).f.e_).o.t != null) && (((VectorMap)((pt)localObject).f.e_).o.t.q != null)) {
            break label1081;
          }
        }
        for (;;)
        {
          this.ai = (this.O - paramBundle.bottomMargin - i2);
          this.ah = (this.N - paramBundle.rightMargin - i1);
          break;
          ((pt)localObject).h = (((int)((VectorMap)((pt)localObject).f.e_).o.t.q.b - i3) * 2);
          ((pt)localObject).f();
        }
        paramBundle.gravity = 51;
        paramBundle.topMargin = this.I[el.a.d.e];
        paramBundle.leftMargin = this.I[el.a.a.e];
        this.ai = paramBundle.topMargin;
        this.ah = paramBundle.leftMargin;
        continue;
        paramBundle.gravity = 49;
        paramBundle.topMargin = this.I[el.a.d.e];
        this.ai = paramBundle.topMargin;
        this.ah = ((this.N - i1) / 2);
        continue;
        paramBundle.gravity = 53;
        paramBundle.topMargin = this.I[el.a.d.e];
        paramBundle.rightMargin = this.I[el.a.b.e];
        this.ai = paramBundle.topMargin;
        this.ah = (this.N - paramBundle.rightMargin - i1);
      }
      paramViewGroup.updateViewLayout(this.ac, paramBundle);
      break label132;
      paramBundle.gravity = 83;
      paramBundle.bottomMargin = this.J[el.a.c.e];
      paramBundle.leftMargin = this.J[el.a.a.e];
      this.q = (this.O - paramBundle.bottomMargin - i2);
      this.p = paramBundle.leftMargin;
      break label243;
      paramBundle.gravity = 81;
      paramBundle.bottomMargin = this.J[el.a.c.e];
      this.q = (this.O - paramBundle.bottomMargin - i2);
      this.p = ((this.N - i1) / 2);
      break label243;
      paramBundle.gravity = 85;
      paramBundle.bottomMargin = this.J[el.a.c.e];
      paramBundle.rightMargin = this.J[el.a.b.e];
      this.q = (this.O - paramBundle.bottomMargin - i2);
      this.p = (this.N - paramBundle.rightMargin - i1);
      break label243;
      paramBundle.gravity = 51;
      paramBundle.topMargin = this.J[el.a.d.e];
      paramBundle.leftMargin = this.J[el.a.a.e];
      this.q = paramBundle.topMargin;
      this.p = paramBundle.leftMargin;
      break label243;
      paramBundle.gravity = 49;
      paramBundle.topMargin = this.J[el.a.d.e];
      this.q = paramBundle.topMargin;
      this.p = ((this.N - i1) / 2);
      break label243;
      paramBundle.gravity = 53;
      paramBundle.topMargin = this.J[el.a.d.e];
      paramBundle.rightMargin = this.J[el.a.b.e];
      this.q = paramBundle.topMargin;
      this.p = (this.N - paramBundle.rightMargin - i1);
      break label243;
      paramViewGroup.updateViewLayout(this.l, paramBundle);
      break label263;
    }
    label1286:
    this.x = false;
    label1666:
    paramViewGroup.requestLayout();
    AppMethodBeat.o(224205);
    return true;
  }
  
  public final void b(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(224324);
    this.N = paramInt1;
    this.O = paramInt2;
    h();
    i();
    AppMethodBeat.o(224324);
  }
  
  public final void b(el.a parama, int paramInt)
  {
    AppMethodBeat.i(224447);
    if (this.ak) {
      this.ak = false;
    }
    this.H[parama.e] = paramInt;
    i();
    AppMethodBeat.o(224447);
  }
  
  public final void b(el.b paramb)
  {
    AppMethodBeat.i(224376);
    if (this.E != paramb) {
      f();
    }
    this.E = paramb;
    AppMethodBeat.o(224376);
  }
  
  public final View[] b()
  {
    return new View[] { this.ac, this.l };
  }
  
  public final void c()
  {
    AppMethodBeat.i(224342);
    Iterator localIterator = this.V.entrySet().iterator();
    while (localIterator.hasNext()) {
      kb.a(new Bitmap[] { (Bitmap)((Map.Entry)localIterator.next()).getValue() });
    }
    kb.a(new Bitmap[] { this.B });
    kb.a(new Bitmap[] { this.C });
    AppMethodBeat.o(224342);
  }
  
  public final el.b d()
  {
    return this.D;
  }
  
  public final void e()
  {
    AppMethodBeat.i(224219);
    if (!this.j)
    {
      d(false);
      AppMethodBeat.o(224219);
      return;
    }
    if (this.k)
    {
      d(true);
      x();
      AppMethodBeat.o(224219);
      return;
    }
    d(true);
    w();
    AppMethodBeat.o(224219);
  }
  
  public final void f()
  {
    AppMethodBeat.i(224234);
    jw.a(new rd.f(this));
    AppMethodBeat.o(224234);
  }
  
  public final void g()
  {
    AppMethodBeat.i(224310);
    kh.c("TLG", "clearLogoCache..");
    this.V.clear();
    this.W.clear();
    try
    {
      File localFile1 = new File(o());
      if (localFile1.exists())
      {
        File localFile2 = new File(p());
        if (localFile1.renameTo(localFile2))
        {
          kb.c(localFile2.getAbsolutePath());
          return;
        }
        kb.c(localFile1.getAbsolutePath());
      }
      return;
    }
    finally
    {
      AppMethodBeat.o(224310);
    }
  }
  
  public final void h()
  {
    AppMethodBeat.i(224473);
    if ((this.N == 0) || (this.O == 0))
    {
      AppMethodBeat.o(224473);
      return;
    }
    int i2 = (int)(this.P * this.Z / 3.0F);
    int i1 = (int)(this.Q * this.Z / 3.0F);
    Object localObject = c(i2, i1);
    if ((this.R != localObject[0]) || (this.S != localObject[1]))
    {
      this.R = localObject[0];
      this.S = localObject[1];
      this.x = true;
    }
    localObject = this.K;
    if (this.N >= 1080) {
      localObject = this.M;
    }
    for (;;)
    {
      int i3 = el.a.a.e;
      float f1 = localObject[i3];
      if (this.c[i3] >= 0.0F) {
        f1 = this.c[i3];
      }
      this.I[i3] = ((int)(f1 * this.N));
      if (this.ak) {
        this.H[el.a.c.e] = i1;
      }
      if ((this.G[i3] >= 0) && (this.G[i3] < this.N - i2)) {
        this.I[i3] = this.G[i3];
      }
      i3 = el.a.b.e;
      f1 = localObject[i3];
      if (this.c[i3] >= 0.0F) {
        f1 = this.c[i3];
      }
      this.I[i3] = ((int)(f1 * this.N));
      if ((this.G[i3] >= 0) && (this.G[i3] < this.N - i2)) {
        this.I[i3] = this.G[i3];
      }
      i2 = el.a.c.e;
      f1 = localObject[i2];
      if (this.c[i2] >= 0.0F) {
        f1 = this.c[i2];
      }
      this.I[i2] = ((int)(f1 * this.O));
      if ((this.G[i2] >= 0) && (this.G[i2] < this.O - i1)) {
        this.I[i2] = this.G[i2];
      }
      i2 = el.a.d.e;
      f1 = localObject[i2];
      if (this.c[i2] >= 0.0F) {
        f1 = this.c[i2];
      }
      this.I[i2] = ((int)(f1 * this.O));
      if ((this.G[i2] >= 0) && (this.G[i2] < this.O - i1)) {
        this.I[i2] = this.G[i2];
      }
      f();
      AppMethodBeat.o(224473);
      return;
      if (this.N >= 720) {
        localObject = this.L;
      }
    }
  }
  
  public final void i()
  {
    AppMethodBeat.i(224492);
    if ((this.N == 0) || (this.O == 0))
    {
      AppMethodBeat.o(224492);
      return;
    }
    int i1 = this.l.getMeasuredHeight();
    int i2 = this.l.getMeasuredWidth();
    float[] arrayOfFloat = this.K;
    if (this.N >= 1080) {
      arrayOfFloat = this.M;
    }
    for (;;)
    {
      int i3 = el.a.a.e;
      float f1 = arrayOfFloat[i3];
      if (this.c[i3] >= 0.0F) {
        f1 = this.c[i3];
      }
      this.J[i3] = ((int)(f1 * this.N));
      if ((this.H[i3] >= 0) && (this.H[i3] < this.N - i2)) {
        this.J[i3] = this.H[i3];
      }
      i3 = el.a.b.e;
      f1 = arrayOfFloat[i3];
      if (this.c[i3] >= 0.0F) {
        f1 = this.c[i3];
      }
      this.J[i3] = ((int)(f1 * this.N));
      if ((this.H[i3] >= 0) && (this.H[i3] < this.N - i2)) {
        this.J[i3] = this.H[i3];
      }
      i2 = el.a.c.e;
      f1 = arrayOfFloat[i2];
      if (this.c[i2] >= 0.0F) {
        f1 = this.c[i2];
      }
      this.J[i2] = ((int)(f1 * this.O));
      if ((this.H[i2] >= 0) && (this.H[i2] < this.O - i1)) {
        this.J[i2] = this.H[i2];
      }
      i2 = el.a.d.e;
      f1 = arrayOfFloat[i2];
      if (this.c[i2] >= 0.0F) {
        f1 = this.c[i2];
      }
      this.J[i2] = ((int)(f1 * this.O));
      if ((this.H[i2] >= 0) && (this.H[i2] < this.O - i1)) {
        this.J[i2] = this.H[i2];
      }
      f();
      AppMethodBeat.o(224492);
      return;
      if (this.N >= 720) {
        arrayOfFloat = this.L;
      }
    }
  }
  
  public final Bitmap j()
  {
    AppMethodBeat.i(224508);
    if (this.a == null)
    {
      AppMethodBeat.o(224508);
      return null;
    }
    Object localObject = this.a.getDrawable();
    if (localObject == null)
    {
      AppMethodBeat.o(224508);
      return null;
    }
    localObject = ((BitmapDrawable)localObject).getBitmap();
    AppMethodBeat.o(224508);
    return localObject;
  }
  
  public final boolean k()
  {
    AppMethodBeat.i(224519);
    if (gz.a(this.X))
    {
      AppMethodBeat.o(224519);
      return true;
    }
    if ((this.X.contains("tencent")) || (this.X.contains("taiwan")))
    {
      AppMethodBeat.o(224519);
      return true;
    }
    AppMethodBeat.o(224519);
    return false;
  }
  
  public final void l()
  {
    AppMethodBeat.i(224536);
    if (this.o != null)
    {
      Iterator localIterator = this.o.iterator();
      while (localIterator.hasNext()) {
        ((c)localIterator.next()).a(this);
      }
    }
    AppMethodBeat.o(224536);
  }
  
  public final void m()
  {
    AppMethodBeat.i(224549);
    if (this.o != null)
    {
      Iterator localIterator = this.o.iterator();
      while (localIterator.hasNext()) {
        ((c)localIterator.next()).c();
      }
    }
    AppMethodBeat.o(224549);
  }
  
  static final class a
    extends jw.g<Bitmap>
  {
    private WeakReference<rd> a;
    private String b;
    private String c;
    
    public a(rd paramrd, String paramString1, String paramString2)
    {
      AppMethodBeat.i(225559);
      this.a = new WeakReference(paramrd);
      this.b = paramString1;
      this.c = paramString2;
      AppMethodBeat.o(225559);
    }
    
    private Bitmap a()
    {
      AppMethodBeat.i(225575);
      rd localrd;
      if (this.a != null)
      {
        localrd = (rd)this.a.get();
        if (localrd != null) {}
      }
      else
      {
        AppMethodBeat.o(225575);
        return null;
      }
      Object localObject = new File(rd.a(localrd, this.c));
      kh.c("TLG", "Logo[" + this.c + "] request url[" + this.b + "]...");
      kh.c("TLG", "Logo[" + this.c + "] save to[" + localObject + "]...");
      localObject = NetManager.getInstance().builder().url(this.b).downloadTo((File)localObject);
      if ((localObject != null) && (((NetResponse)localObject).available()))
      {
        localObject = ((NetResponse)localObject).data;
        int i = localObject.length;
        kh.c("TLG", "Logo[" + this.c + "] request url ok! bitmap size[" + i + "]...");
        localObject = BitmapFactory.decodeByteArray((byte[])localObject, 0, i);
        if (localObject != null) {
          rd.k(localrd).put(this.c, localObject);
        }
      }
      for (;;)
      {
        AppMethodBeat.o(225575);
        return localObject;
        localObject = null;
      }
    }
  }
  
  static final class b
    extends jw.a<Bitmap>
  {
    private WeakReference<rd> a;
    private String b;
    
    public b(rd paramrd, String paramString)
    {
      AppMethodBeat.i(225522);
      this.a = new WeakReference(paramrd);
      this.b = paramString;
      AppMethodBeat.o(225522);
    }
    
    private void a(Bitmap paramBitmap)
    {
      AppMethodBeat.i(225533);
      rd localrd;
      if ((paramBitmap != null) && (this.a != null))
      {
        localrd = (rd)this.a.get();
        if (localrd != null) {}
      }
      else
      {
        AppMethodBeat.o(225533);
        return;
      }
      ka.a(new File(rd.a(localrd, this.b)), new File(rd.b(localrd, this.b)));
      if (this.b.equals(rd.l(localrd)))
      {
        kh.c("TLG", "Logo[" + this.b + "] set from net");
        rd.a(localrd, paramBitmap);
      }
      rd.m(localrd).remove(this.b);
      AppMethodBeat.o(225533);
    }
  }
  
  public static abstract interface c
  {
    public abstract void a(View paramView, Rect paramRect, boolean paramBoolean);
    
    public abstract void a(rd paramrd);
    
    public abstract void b(View paramView, Rect paramRect, boolean paramBoolean);
    
    public abstract void c();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.mapsdk.internal.rd
 * JD-Core Version:    0.7.0.1
 */