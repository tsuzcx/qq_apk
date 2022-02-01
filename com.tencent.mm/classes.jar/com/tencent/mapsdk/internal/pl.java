package com.tencent.mapsdk.internal;

import android.graphics.PointF;
import android.graphics.Rect;
import android.view.GestureDetector;
import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.ref.WeakReference;
import java.lang.reflect.Method;

public final class pl
  implements View.OnTouchListener
{
  private static final int G = 50;
  private static final int b = 255;
  private static final int c = 5;
  private static final int d = 6;
  private static final double e = 2.5D;
  private static final double f = 0.5D;
  private static final double g = 0.003D;
  private static final double h = 0.001D;
  private static final double i = 0.1D;
  private static final double j = 0.5D;
  private static final int k = 0;
  private static final int l = 1;
  private static final int m = 2;
  private static final int n = 4;
  private static final int o = 8;
  private static final float p;
  private static final int q = 10;
  private final PointF A;
  private long B;
  private final GestureDetector C;
  private final bd D;
  private final WeakReference<sr> E;
  private final a F;
  private Method H;
  private Method I;
  public final pm a;
  private boolean r;
  private boolean s;
  private int t;
  private final PointF u;
  private final PointF v;
  private final PointF w;
  private final PointF x;
  private final PointF y;
  private final PointF z;
  
  static
  {
    AppMethodBeat.i(225424);
    p = (float)Math.cos(0.001745329278001762D);
    AppMethodBeat.o(225424);
  }
  
  public pl(sr paramsr)
  {
    AppMethodBeat.i(225263);
    this.t = 0;
    this.u = new PointF();
    this.v = new PointF();
    this.w = new PointF();
    this.x = new PointF();
    this.y = new PointF();
    this.z = new PointF();
    this.A = new PointF();
    this.B = 0L;
    this.F = new a((byte)0);
    this.E = new WeakReference(paramsr);
    this.C = new GestureDetector(paramsr.G(), this.F);
    this.a = new pm();
    this.D = ((bd)paramsr.d_);
    this.C.setOnDoubleTapListener(this.F);
    AppMethodBeat.o(225263);
  }
  
  private void a()
  {
    AppMethodBeat.i(225316);
    float f3 = this.u.x - this.w.x;
    float f1 = this.u.y - this.w.y;
    float f4 = this.v.x - this.x.x;
    float f2 = this.v.y - this.x.y;
    int i1;
    int i2;
    label159:
    int i3;
    label202:
    int i4;
    label245:
    boolean bool5;
    label258:
    boolean bool6;
    label271:
    int i5;
    label302:
    double d1;
    label311:
    double d2;
    label331:
    double d3;
    label352:
    boolean bool2;
    label370:
    boolean bool1;
    label393:
    boolean bool7;
    label416:
    double d5;
    double d6;
    boolean bool8;
    label605:
    label618:
    boolean bool3;
    label651:
    label668:
    boolean bool4;
    label695:
    Object localObject;
    label1216:
    PointF localPointF1;
    PointF localPointF2;
    PointF localPointF3;
    if ((Math.abs(f1) > Math.abs(f3) * 1.5D) && (Math.abs(f2) > Math.abs(f4) * 1.5D))
    {
      i1 = 1;
      if ((Math.abs(f1) <= Math.abs(f3) * 1.5D) || (Math.abs(f2) <= Math.abs(f4) * 1.5D)) {
        break label1565;
      }
      i2 = 1;
      if ((Math.abs(f3) <= Math.abs(f1) * 1.5D) || (Math.abs(f4) <= Math.abs(f2) * 1.5D)) {
        break label1571;
      }
      i3 = 1;
      if ((Math.abs(f3) <= Math.abs(f1) * 1.5D) || (Math.abs(f4) <= Math.abs(f2) * 1.5D)) {
        break label1577;
      }
      i4 = 1;
      if (f3 * f4 <= 0.0F) {
        break label1583;
      }
      bool5 = true;
      if (f1 * f2 <= 0.0F) {
        break label1589;
      }
      bool6 = true;
      if (((this.t & 0x8) == 0) && ((this.t & 0x1) == 0) && ((this.t & 0x4) == 0)) {
        break label1595;
      }
      i5 = 1;
      if (i5 == 0) {
        break label1601;
      }
      d1 = 0.1D;
      if (f3 * f4 <= 0.0F) {
        break label1608;
      }
      d2 = Math.abs(f3 + f4);
      if (f1 * f2 <= 0.0F) {
        break label1626;
      }
      d3 = Math.abs(f1 + f2);
      double d4 = Math.max(d2, d3);
      if (d4 <= d1) {
        break label1645;
      }
      bool2 = true;
      if ((!bool2) || (!bool5) || ((i3 == 0) && (i4 == 0))) {
        break label1651;
      }
      bool1 = true;
      if ((!bool2) || (!bool6) || ((i1 == 0) && (i2 == 0))) {
        break label1657;
      }
      bool7 = true;
      d3 = this.x.x - this.w.x;
      double d7 = this.x.y - this.w.y;
      double d8 = this.v.x - this.u.x;
      double d9 = this.v.y - this.u.y;
      d5 = Math.sqrt(d3 * d3 + d7 * d7);
      d6 = Math.sqrt(d8 * d8 + d9 * d9);
      d2 = 180.0D * Math.acos((d3 * d8 + d7 * d9) / (d5 * d6)) / 3.141592653589793D;
      d1 = d2;
      if (d3 * d9 - d7 * d8 < 0.0D) {
        d1 = -d2;
      }
      d7 = (d3 * d8 + d7 * d9) / (d5 * d6);
      if (Math.abs(d7) >= p) {
        break label1663;
      }
      bool8 = true;
      if ((this.t & 0x2) != 0) {
        break label1669;
      }
      d2 = 2.5D;
      d8 = Math.abs(d1);
      if ((d5 * d6 <= 0.0D) || (!bool8) || (Math.abs(d1) <= d2)) {
        break label1676;
      }
      bool3 = true;
      d9 = d6 / d5;
      if (i5 == 0) {
        break label1682;
      }
      d3 = 0.001D;
      double d10 = Math.abs(d9 - 1.0D);
      if ((d5 <= 0.0D) || (d10 <= d3)) {
        break label1690;
      }
      bool4 = true;
      kl.f("GD").a(new Object[] { "trace-gesture", "began:" + bool2 + ":" + bool4 + ":" + bool3, "value:" + d4 + ":" + d10 + ":" + d8 });
      if (bool3)
      {
        bool2 = false;
        bool4 = false;
      }
      if (bool7)
      {
        bool1 = false;
        bool3 = false;
        bool4 = false;
      }
      kl.f("GD").a(new Object[] { "beganMove:".concat(String.valueOf(bool2)), "vertical:".concat(String.valueOf(bool6)), "horizontal:".concat(String.valueOf(bool5)), "verticalMove:".concat(String.valueOf(bool7)), "horizontalMove:".concat(String.valueOf(bool1)) });
      kl.f("GD").a(new Object[] { "beganRotate:".concat(String.valueOf(bool3)), "cosValue : ".concat(String.valueOf(d7)), "cosAngle : ".concat(String.valueOf(bool8)), "angle:".concat(String.valueOf(d1)), "rotateJudge : ".concat(String.valueOf(d2)) });
      kl.f("GD").a(new Object[] { "beganScale:".concat(String.valueOf(bool4)), "d1:".concat(String.valueOf(d5)), "scale - 1 = " + Math.abs(d9 - 1.0D), "scaleJudge : ".concat(String.valueOf(d3)) });
      if (bool2)
      {
        if (bool1)
        {
          this.t |= 0x8;
          kl.f("GD").a(new Object[] { "MT_INTENT_MOVE" });
          f3 = (f3 + f4) / 2.0F;
          f4 = (f1 + f2) / 2.0F;
          this.a.d(f3, f4);
        }
        if (bool7)
        {
          this.t |= 0x1;
          kl.f("GD").a(new Object[] { "MT_INTENT_MOVE_VERTICAL" });
          this.w.set(this.u.x, this.u.y);
          this.x.set(this.v.x, this.v.y);
          localObject = this.a;
          if (Math.abs(f1) <= Math.abs(f2)) {
            break label1696;
          }
          ((pm)localObject).a(f1);
        }
      }
      if (bool3)
      {
        this.t |= 0x2;
        kl.f("GD").a(new Object[] { "MT_INTENT_ROTATE" });
        localObject = this.x;
        localPointF1 = this.w;
        localPointF2 = this.v;
        localPointF3 = this.u;
        if ((localPointF1.x != ((PointF)localObject).x) && (localPointF3.x != localPointF2.x)) {
          break label1703;
        }
        localObject = null;
        label1312:
        if (localObject != null) {
          break label1876;
        }
        bool1 = false;
        label1320:
        if (!bool1) {
          break label1933;
        }
        if (this.D != null) {
          break label1895;
        }
        i1 = 0;
        label1335:
        if (this.D != null) {
          break label1914;
        }
        i2 = 0;
        label1345:
        this.A.set(i1, i2);
        this.a.a(this.A, this.A, (float)d1);
      }
    }
    for (;;)
    {
      if (bool4)
      {
        this.t |= 0x4;
        kl.f("GD").a(new Object[] { "MT_INTENT_SCALE" });
        this.y.set((this.w.x + this.x.x) / 2.0F, (this.w.y + this.x.y) / 2.0F);
        this.z.set((this.u.x + this.v.x) / 2.0F, (this.u.y + this.v.y) / 2.0F);
        this.a.a(this.y, this.z, d5, d6);
      }
      this.w.set(this.u.x, this.u.y);
      this.x.set(this.v.x, this.v.y);
      AppMethodBeat.o(225316);
      return;
      i1 = 0;
      break;
      label1565:
      i2 = 0;
      break label159;
      label1571:
      i3 = 0;
      break label202;
      label1577:
      i4 = 0;
      break label245;
      label1583:
      bool5 = false;
      break label258;
      label1589:
      bool6 = false;
      break label271;
      label1595:
      i5 = 0;
      break label302;
      label1601:
      d1 = 0.5D;
      break label311;
      label1608:
      d2 = Math.max(Math.abs(f3), Math.abs(f4));
      break label331;
      label1626:
      d3 = Math.max(Math.abs(f1), Math.abs(f2));
      break label352;
      label1645:
      bool2 = false;
      break label370;
      label1651:
      bool1 = false;
      break label393;
      label1657:
      bool7 = false;
      break label416;
      label1663:
      bool8 = false;
      break label605;
      label1669:
      d2 = 0.5D;
      break label618;
      label1676:
      bool3 = false;
      break label651;
      label1682:
      d3 = 0.003D;
      break label668;
      label1690:
      bool4 = false;
      break label695;
      label1696:
      f1 = f2;
      break label1216;
      label1703:
      f3 = (localPointF1.y - ((PointF)localObject).y) / (localPointF1.x - ((PointF)localObject).x);
      f1 = (localPointF3.y - localPointF2.y) / (localPointF3.x - localPointF2.x);
      if (f3 == f1)
      {
        localObject = null;
        break label1312;
      }
      f4 = (((PointF)localObject).y * localPointF1.x - localPointF1.y * ((PointF)localObject).x) / (localPointF1.x - ((PointF)localObject).x);
      f2 = (localPointF2.y * localPointF3.x - localPointF3.y * localPointF2.x) / (localPointF3.x - localPointF2.x);
      f3 = (f2 - f4) / (f3 - f1);
      localObject = new PointF(f3, f2 + f1 * f3);
      break label1312;
      label1876:
      bool1 = a(((PointF)localObject).x, ((PointF)localObject).y);
      break label1320;
      label1895:
      i1 = this.D.g().width() / 2;
      break label1335;
      label1914:
      i2 = this.D.g().height() / 2;
      break label1345;
      label1933:
      this.y.set((this.w.x + this.x.x) / 2.0F, (this.w.y + this.x.y) / 2.0F);
      this.z.set((this.u.x + this.v.x) / 2.0F, (this.u.y + this.v.y) / 2.0F);
      this.a.a(this.y, this.z, (float)d1);
    }
  }
  
  private static void a(PointF paramPointF1, PointF paramPointF2, MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(225380);
    try
    {
      float f1 = paramMotionEvent.getX(0);
      float f2 = paramMotionEvent.getX(1);
      float f3 = paramMotionEvent.getY(0);
      float f4 = paramMotionEvent.getY(1);
      paramPointF1.set(f1, f3);
      paramPointF2.set(f2, f4);
      AppMethodBeat.o(225380);
      return;
    }
    catch (Exception paramPointF1)
    {
      AppMethodBeat.o(225380);
    }
  }
  
  private boolean a(float paramFloat1, float paramFloat2)
  {
    float f2 = 0.0F;
    AppMethodBeat.i(225345);
    int i1;
    int i2;
    label29:
    float f1;
    if (this.D == null)
    {
      i1 = 0;
      if (this.D != null) {
        break label99;
      }
      i2 = 0;
      if (this.D != null) {
        break label118;
      }
      f1 = 0.0F;
      label38:
      if (this.D != null) {
        break label139;
      }
    }
    for (;;)
    {
      if ((Math.abs(paramFloat1 - i1) >= f1) || (Math.abs(paramFloat2 - i2) >= f2)) {
        break label161;
      }
      AppMethodBeat.o(225345);
      return true;
      i1 = this.D.g().width() / 2;
      break;
      label99:
      i2 = this.D.g().height() / 2;
      break label29;
      label118:
      f1 = this.D.g().width() / 3.0F;
      break label38;
      label139:
      f2 = this.D.g().height() / 3.0F;
    }
    label161:
    AppMethodBeat.o(225345);
    return false;
  }
  
  private void b(es parames)
  {
    AppMethodBeat.i(225277);
    synchronized (this.a)
    {
      this.a.b(parames);
      AppMethodBeat.o(225277);
      return;
    }
  }
  
  private boolean b()
  {
    Object localObject2 = null;
    AppMethodBeat.i(225330);
    PointF localPointF1 = this.x;
    PointF localPointF2 = this.w;
    PointF localPointF3 = this.v;
    PointF localPointF4 = this.u;
    Object localObject1 = localObject2;
    if (localPointF2.x != localPointF1.x)
    {
      if (localPointF4.x != localPointF3.x) {
        break label82;
      }
      localObject1 = localObject2;
    }
    while (localObject1 == null)
    {
      AppMethodBeat.o(225330);
      return false;
      label82:
      float f3 = (localPointF2.y - localPointF1.y) / (localPointF2.x - localPointF1.x);
      float f1 = (localPointF4.y - localPointF3.y) / (localPointF4.x - localPointF3.x);
      localObject1 = localObject2;
      if (f3 != f1)
      {
        float f4 = (localPointF1.y * localPointF2.x - localPointF2.y * localPointF1.x) / (localPointF2.x - localPointF1.x);
        float f2 = (localPointF3.y * localPointF4.x - localPointF4.y * localPointF3.x) / (localPointF4.x - localPointF3.x);
        f3 = (f2 - f4) / (f3 - f1);
        localObject1 = new PointF(f3, f2 + f1 * f3);
      }
    }
    boolean bool = a(((PointF)localObject1).x, ((PointF)localObject1).y);
    AppMethodBeat.o(225330);
    return bool;
  }
  
  private boolean b(float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(225351);
    boolean bool = a(paramFloat1, paramFloat2);
    AppMethodBeat.o(225351);
    return bool;
  }
  
  private boolean c()
  {
    double d1 = this.w.x - this.x.x;
    double d2 = this.w.y - this.x.y;
    return d1 * d1 + d2 * d2 > 2500.0D;
  }
  
  public final void a(es parames)
  {
    AppMethodBeat.i(225434);
    synchronized (this.a)
    {
      this.a.a(parames);
      AppMethodBeat.o(225434);
      return;
    }
  }
  
  public final boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(225477);
    switch (paramMotionEvent.getAction() & 0xFF)
    {
    }
    for (;;)
    {
      if (!this.r) {
        this.C.onTouchEvent(paramMotionEvent);
      }
      AppMethodBeat.o(225477);
      return true;
      this.B = 0L;
      this.r = false;
      this.a.i(paramMotionEvent.getX(), paramMotionEvent.getY());
      continue;
      this.B = System.currentTimeMillis();
      this.t = 0;
      this.r = true;
      this.s = false;
      a(this.w, this.x, paramMotionEvent);
      this.a.c();
      AppMethodBeat.o(225477);
      return true;
      long l1 = System.currentTimeMillis() - this.B;
      double d1;
      double d2;
      if ((this.t == 0) && (l1 > 0L) && (l1 < 200L))
      {
        d1 = this.w.x - this.x.x;
        d2 = this.w.y - this.x.y;
        if (d1 * d1 + d2 * d2 <= 2500.0D) {
          break label278;
        }
      }
      label278:
      for (int i1 = 1;; i1 = 0)
      {
        if (i1 != 0) {
          this.a.b();
        }
        this.a.j(paramMotionEvent.getX(), paramMotionEvent.getY());
        break;
      }
      if (!this.s)
      {
        this.s = true;
        this.a.d();
        AppMethodBeat.o(225477);
        return true;
        if ((this.r) && (!this.s))
        {
          a(this.u, this.v, paramMotionEvent);
          float f3 = this.u.x - this.w.x;
          float f1 = this.u.y - this.w.y;
          float f4 = this.v.x - this.x.x;
          float f2 = this.v.y - this.x.y;
          int i2;
          label492:
          int i3;
          label535:
          int i4;
          label578:
          boolean bool5;
          label591:
          boolean bool6;
          label604:
          int i5;
          label635:
          double d3;
          label644:
          label665:
          label686:
          boolean bool2;
          label705:
          boolean bool1;
          label728:
          boolean bool7;
          label751:
          double d5;
          double d6;
          boolean bool8;
          label943:
          label957:
          boolean bool3;
          label991:
          label1008:
          boolean bool4;
          label1035:
          label1556:
          PointF localPointF1;
          PointF localPointF2;
          if ((Math.abs(f1) > Math.abs(f3) * 1.5D) && (Math.abs(f2) > Math.abs(f4) * 1.5D))
          {
            i1 = 1;
            if ((Math.abs(f1) <= Math.abs(f3) * 1.5D) || (Math.abs(f2) <= Math.abs(f4) * 1.5D)) {
              break label1900;
            }
            i2 = 1;
            if ((Math.abs(f3) <= Math.abs(f1) * 1.5D) || (Math.abs(f4) <= Math.abs(f2) * 1.5D)) {
              break label1906;
            }
            i3 = 1;
            if ((Math.abs(f3) <= Math.abs(f1) * 1.5D) || (Math.abs(f4) <= Math.abs(f2) * 1.5D)) {
              break label1912;
            }
            i4 = 1;
            if (f3 * f4 <= 0.0F) {
              break label1918;
            }
            bool5 = true;
            if (f1 * f2 <= 0.0F) {
              break label1924;
            }
            bool6 = true;
            if (((this.t & 0x8) == 0) && ((this.t & 0x1) == 0) && ((this.t & 0x4) == 0)) {
              break label1930;
            }
            i5 = 1;
            if (i5 == 0) {
              break label1936;
            }
            d1 = 0.1D;
            if (f3 * f4 <= 0.0F) {
              break label1943;
            }
            d2 = Math.abs(f3 + f4);
            if (f1 * f2 <= 0.0F) {
              break label1962;
            }
            d3 = Math.abs(f1 + f2);
            double d4 = Math.max(d2, d3);
            if (d4 <= d1) {
              break label1981;
            }
            bool2 = true;
            if ((!bool2) || (!bool5) || ((i3 == 0) && (i4 == 0))) {
              break label1987;
            }
            bool1 = true;
            if ((!bool2) || (!bool6) || ((i1 == 0) && (i2 == 0))) {
              break label1993;
            }
            bool7 = true;
            d3 = this.x.x - this.w.x;
            double d7 = this.x.y - this.w.y;
            double d8 = this.v.x - this.u.x;
            double d9 = this.v.y - this.u.y;
            d5 = Math.sqrt(d3 * d3 + d7 * d7);
            d6 = Math.sqrt(d8 * d8 + d9 * d9);
            d2 = 180.0D * Math.acos((d3 * d8 + d7 * d9) / (d5 * d6)) / 3.141592653589793D;
            d1 = d2;
            if (d3 * d9 - d7 * d8 < 0.0D) {
              d1 = -d2;
            }
            d7 = (d3 * d8 + d7 * d9) / (d5 * d6);
            if (Math.abs(d7) >= p) {
              break label1999;
            }
            bool8 = true;
            if ((this.t & 0x2) != 0) {
              break label2005;
            }
            d2 = 2.5D;
            d8 = Math.abs(d1);
            if ((d5 * d6 <= 0.0D) || (!bool8) || (Math.abs(d1) <= d2)) {
              break label2013;
            }
            bool3 = true;
            d9 = d6 / d5;
            if (i5 == 0) {
              break label2019;
            }
            d3 = 0.001D;
            double d10 = Math.abs(d9 - 1.0D);
            if ((d5 <= 0.0D) || (d10 <= d3)) {
              break label2027;
            }
            bool4 = true;
            kl.f("GD").a(new Object[] { "trace-gesture", "began:" + bool2 + ":" + bool4 + ":" + bool3, "value:" + d4 + ":" + d10 + ":" + d8 });
            if (bool3)
            {
              bool2 = false;
              bool4 = false;
            }
            if (bool7)
            {
              bool1 = false;
              bool3 = false;
              bool4 = false;
            }
            kl.f("GD").a(new Object[] { "beganMove:".concat(String.valueOf(bool2)), "vertical:".concat(String.valueOf(bool6)), "horizontal:".concat(String.valueOf(bool5)), "verticalMove:".concat(String.valueOf(bool7)), "horizontalMove:".concat(String.valueOf(bool1)) });
            kl.f("GD").a(new Object[] { "beganRotate:".concat(String.valueOf(bool3)), "cosValue : ".concat(String.valueOf(d7)), "cosAngle : ".concat(String.valueOf(bool8)), "angle:".concat(String.valueOf(d1)), "rotateJudge : ".concat(String.valueOf(d2)) });
            kl.f("GD").a(new Object[] { "beganScale:".concat(String.valueOf(bool4)), "d1:".concat(String.valueOf(d5)), "scale - 1 = " + Math.abs(d9 - 1.0D), "scaleJudge : ".concat(String.valueOf(d3)) });
            if (bool2)
            {
              if (bool1)
              {
                this.t |= 0x8;
                kl.f("GD").a(new Object[] { "MT_INTENT_MOVE" });
                f3 = (f3 + f4) / 2.0F;
                f4 = (f1 + f2) / 2.0F;
                this.a.d(f3, f4);
              }
              if (bool7)
              {
                this.t |= 0x1;
                kl.f("GD").a(new Object[] { "MT_INTENT_MOVE_VERTICAL" });
                this.w.set(this.u.x, this.u.y);
                this.x.set(this.v.x, this.v.y);
                paramView = this.a;
                if (Math.abs(f1) <= Math.abs(f2)) {
                  break label2033;
                }
                paramView.a(f1);
              }
            }
            if (bool3)
            {
              this.t |= 0x2;
              kl.f("GD").a(new Object[] { "MT_INTENT_ROTATE" });
              paramView = this.x;
              paramMotionEvent = this.w;
              localPointF1 = this.v;
              localPointF2 = this.u;
              if ((paramMotionEvent.x != paramView.x) && (localPointF2.x != localPointF1.x)) {
                break label2040;
              }
              paramView = null;
              label1646:
              if (paramView != null) {
                break label2201;
              }
              bool1 = false;
              label1653:
              if (!bool1) {
                break label2256;
              }
              if (this.D != null) {
                break label2218;
              }
              i1 = 0;
              label1668:
              if (this.D != null) {
                break label2237;
              }
              i2 = 0;
              label1678:
              this.A.set(i1, i2);
              this.a.a(this.A, this.A, (float)d1);
            }
          }
          for (;;)
          {
            if (bool4)
            {
              this.t |= 0x4;
              kl.f("GD").a(new Object[] { "MT_INTENT_SCALE" });
              this.y.set((this.w.x + this.x.x) / 2.0F, (this.w.y + this.x.y) / 2.0F);
              this.z.set((this.u.x + this.v.x) / 2.0F, (this.u.y + this.v.y) / 2.0F);
              this.a.a(this.y, this.z, d5, d6);
            }
            this.w.set(this.u.x, this.u.y);
            this.x.set(this.v.x, this.v.y);
            AppMethodBeat.o(225477);
            return true;
            i1 = 0;
            break;
            label1900:
            i2 = 0;
            break label492;
            label1906:
            i3 = 0;
            break label535;
            label1912:
            i4 = 0;
            break label578;
            label1918:
            bool5 = false;
            break label591;
            label1924:
            bool6 = false;
            break label604;
            label1930:
            i5 = 0;
            break label635;
            label1936:
            d1 = 0.5D;
            break label644;
            label1943:
            d2 = Math.max(Math.abs(f3), Math.abs(f4));
            break label665;
            label1962:
            d3 = Math.max(Math.abs(f1), Math.abs(f2));
            break label686;
            label1981:
            bool2 = false;
            break label705;
            label1987:
            bool1 = false;
            break label728;
            label1993:
            bool7 = false;
            break label751;
            label1999:
            bool8 = false;
            break label943;
            label2005:
            d2 = 0.5D;
            break label957;
            label2013:
            bool3 = false;
            break label991;
            label2019:
            d3 = 0.003D;
            break label1008;
            label2027:
            bool4 = false;
            break label1035;
            label2033:
            f1 = f2;
            break label1556;
            label2040:
            f3 = (paramMotionEvent.y - paramView.y) / (paramMotionEvent.x - paramView.x);
            f1 = (localPointF2.y - localPointF1.y) / (localPointF2.x - localPointF1.x);
            if (f3 == f1)
            {
              paramView = null;
              break label1646;
            }
            f4 = (paramView.y * paramMotionEvent.x - paramMotionEvent.y * paramView.x) / (paramMotionEvent.x - paramView.x);
            f2 = (localPointF1.y * localPointF2.x - localPointF2.y * localPointF1.x) / (localPointF2.x - localPointF1.x);
            f3 = (f2 - f4) / (f3 - f1);
            paramView = new PointF(f3, f2 + f1 * f3);
            break label1646;
            label2201:
            bool1 = a(paramView.x, paramView.y);
            break label1653;
            label2218:
            i1 = this.D.g().width() / 2;
            break label1668;
            label2237:
            i2 = this.D.g().height() / 2;
            break label1678;
            label2256:
            this.y.set((this.w.x + this.x.x) / 2.0F, (this.w.y + this.x.y) / 2.0F);
            this.z.set((this.u.x + this.v.x) / 2.0F, (this.u.y + this.v.y) / 2.0F);
            this.a.a(this.y, this.z, (float)d1);
          }
        }
        this.a.k(paramMotionEvent.getX(), paramMotionEvent.getY());
      }
    }
  }
  
  final class a
    extends GestureDetector.SimpleOnGestureListener
  {
    private PointF b;
    private boolean c;
    
    private a()
    {
      AppMethodBeat.i(221525);
      this.b = new PointF();
      this.c = true;
      AppMethodBeat.o(221525);
    }
    
    public final boolean onDoubleTap(MotionEvent paramMotionEvent)
    {
      return false;
    }
    
    public final boolean onDoubleTapEvent(MotionEvent paramMotionEvent)
    {
      AppMethodBeat.i(221574);
      float f1 = paramMotionEvent.getX();
      float f2 = paramMotionEvent.getY();
      switch (paramMotionEvent.getAction() & 0xFF)
      {
      }
      for (;;)
      {
        AppMethodBeat.o(221574);
        return true;
        this.c = true;
        pl.d(pl.this).setIsLongpressEnabled(false);
        this.b.set(paramMotionEvent.getX(), paramMotionEvent.getY());
        pl.a(pl.this).f(f1, f2);
        continue;
        if (this.c) {
          pl.a(pl.this).a(f1, f2);
        }
        this.b.set(0.0F, 0.0F);
        pl.d(pl.this).setIsLongpressEnabled(true);
        pl.a(pl.this).h(f1, f2);
        continue;
        float f3 = this.b.x;
        float f4 = this.b.y;
        if ((Math.abs(f1 - f3) > 10.0F) || (Math.abs(f2 - f4) > 10.0F))
        {
          this.c = false;
          pl.a(pl.this).g(f1, f2);
        }
        pl.d(pl.this).setIsLongpressEnabled(true);
      }
    }
    
    public final boolean onFling(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
    {
      AppMethodBeat.i(221547);
      pl.a(pl.this).c(paramFloat1, paramFloat2);
      AppMethodBeat.o(221547);
      return true;
    }
    
    public final void onLongPress(MotionEvent paramMotionEvent)
    {
      AppMethodBeat.i(221565);
      if (!pl.c(pl.this)) {
        pl.a(pl.this).e(paramMotionEvent.getX(), paramMotionEvent.getY());
      }
      AppMethodBeat.o(221565);
    }
    
    public final boolean onScroll(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
    {
      AppMethodBeat.i(221555);
      if ((pl.b(pl.this) != null) && (pl.b(pl.this).get() != null) && (((sr)pl.b(pl.this).get()).Z()))
      {
        double d = Math.sqrt(paramFloat1 * paramFloat1 + paramFloat2 * paramFloat2);
        if (((paramMotionEvent1 != null) && ((paramMotionEvent1.getX() < 0.0F) || (paramMotionEvent1.getY() < 0.0F))) || ((paramMotionEvent2 != null) && ((paramMotionEvent2.getX() < 0.0F) || (paramMotionEvent2.getY() < 0.0F))) || (d > 50.0D))
        {
          AppMethodBeat.o(221555);
          return true;
        }
      }
      pl.a(pl.this).d(-paramFloat1, -paramFloat2);
      AppMethodBeat.o(221555);
      return true;
    }
    
    public final boolean onSingleTapConfirmed(MotionEvent paramMotionEvent)
    {
      AppMethodBeat.i(221538);
      float f1 = paramMotionEvent.getX();
      float f2 = paramMotionEvent.getY();
      pl.a(pl.this).b(f1, f2);
      AppMethodBeat.o(221538);
      return true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.mapsdk.internal.pl
 * JD-Core Version:    0.7.0.1
 */