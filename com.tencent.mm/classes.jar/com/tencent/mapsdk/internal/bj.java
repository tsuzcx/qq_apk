package com.tencent.mapsdk.internal;

import android.content.Context;
import android.graphics.Rect;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.ZoomControls;
import com.tencent.mapsdk.vector.VectorMap;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tencentmap.mapsdk.maps.TencentMapOptions;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public final class bj
  implements ak, bc, ey, fe, fi
{
  public static final String a = "key_change_style";
  public ViewGroup b;
  sj c;
  public rf d;
  public rd e;
  pa f;
  pb.a g;
  Bundle h;
  List<el> i;
  public Handler j;
  private TencentMapOptions n;
  private pt o;
  private int p;
  private boolean q;
  
  public bj(bd parambd, ViewGroup paramViewGroup, bt parambt)
  {
    AppMethodBeat.i(224826);
    this.b = null;
    this.i = new CopyOnWriteArrayList();
    this.q = false;
    this.j = new Handler(jw.a("gesture"))
    {
      public final void handleMessage(Message paramAnonymousMessage)
      {
        int j = 0;
        AppMethodBeat.i(221436);
        Object localObject;
        if ((paramAnonymousMessage != null) && (paramAnonymousMessage.obj != null))
        {
          paramAnonymousMessage = (fr)paramAnonymousMessage.obj;
          boolean bool1;
          if (paramAnonymousMessage.f == 0)
          {
            if (bj.this.d != null)
            {
              localObject = bj.this.d;
              bool1 = paramAnonymousMessage.g;
              boolean bool2 = paramAnonymousMessage.h;
              if (((rf)localObject).b != null) {
                jw.a(new rf.4((rf)localObject, bool1, bool2));
              }
              AppMethodBeat.o(221436);
            }
          }
          else if (paramAnonymousMessage.f == 1)
          {
            if (bj.this.e != null)
            {
              localObject = bj.this.e;
              int i = paramAnonymousMessage.i;
              double d = paramAnonymousMessage.j;
              ((rd)localObject).h = i;
              ((rd)localObject).i = d;
              int m = (int)Math.log10(((rd)localObject).n * ((rd)localObject).i);
              i = (int)(rd.e[0] * Math.pow(10.0D, m));
              int k = (int)(i / ((rd)localObject).i);
              if ((k <= 0) || (Double.isNaN(((rd)localObject).i))) {}
              for (;;)
              {
                ((rd)localObject).f();
                AppMethodBeat.o(221436);
                return;
                while (k < ((rd)localObject).n)
                {
                  j += 1;
                  i = rd.e.length;
                  i = (int)(rd.e[(j % i)] * Math.pow(10.0D, j / rd.e.length + m));
                  k = (int)(i / ((rd)localObject).i);
                }
                paramAnonymousMessage = "米";
                j = i;
                if (i >= 1000)
                {
                  j = i / 1000;
                  paramAnonymousMessage = "公里";
                }
                ((rd)localObject).f = (j + paramAnonymousMessage);
                ((rd)localObject).g = k;
                jw.a(new rd.5((rd)localObject));
              }
            }
          }
          else
          {
            if ((paramAnonymousMessage.f == 3) && (gw.i == 1))
            {
              if (TextUtils.equals(ry.c, "wechat"))
              {
                AppMethodBeat.o(221436);
                return;
              }
              if (bj.this.b == null)
              {
                AppMethodBeat.o(221436);
                return;
              }
              if (bj.this.f == null)
              {
                bj.this.f = new pa(bj.this.b.getContext().getApplicationContext(), bj.this.c.d_);
                bj.this.f.b = bj.this.g;
              }
              bj.this.f.a(bj.this.b, null);
              AppMethodBeat.o(221436);
              return;
            }
            if ((paramAnonymousMessage.f == 2) && (bj.this.c.S))
            {
              bool1 = v.b(paramAnonymousMessage.l);
              localObject = (VectorMap)bj.this.c.e_;
              if (!bool1) {
                break label605;
              }
            }
          }
        }
        label605:
        for (paramAnonymousMessage = "compass_dark.png";; paramAnonymousMessage = "compass.png")
        {
          localObject = ((VectorMap)localObject).o;
          if (((mk)localObject).g != null)
          {
            localObject = ((mk)localObject).g;
            if (0L != ((sc)localObject).e) {
              ((sc)localObject).a(new sc.127((sc)localObject, paramAnonymousMessage));
            }
          }
          AppMethodBeat.o(221436);
          return;
        }
      }
    };
    this.b = paramViewGroup;
    if (parambt == null)
    {
      AppMethodBeat.o(224826);
      return;
    }
    this.c = ((sj)parambd.b());
    this.n = this.c.K();
    ((VectorMap)this.c.e_).o.i.a(this);
    if ((parambt instanceof View))
    {
      paramViewGroup = (View)parambt;
      if (this.b.indexOfChild(paramViewGroup) < 0)
      {
        parambt = new FrameLayout.LayoutParams(-1, -1);
        this.b.addView(paramViewGroup, 0, parambt);
        this.b.requestLayout();
      }
    }
    this.e = new rd(this.b.getContext().getApplicationContext(), this.c);
    this.c.m = this.e;
    this.o = new pt(parambd);
    this.e.r = this.o;
    this.c.n = this.o;
    this.d = new rf(this.b.getContext(), this.c);
    this.i.add(this.e);
    this.i.add(this.d);
    this.i.add(this.o);
    this.c.a(this);
    parambd = this.c;
    parambd.at.remove(this);
    parambd.at.add(this);
    this.c.a(this);
    AppMethodBeat.o(224826);
  }
  
  private void a(Bundle paramBundle)
  {
    AppMethodBeat.i(224857);
    Iterator localIterator = this.i.iterator();
    while (localIterator.hasNext()) {
      ((el)localIterator.next()).a(this.b, paramBundle);
    }
    AppMethodBeat.o(224857);
  }
  
  private void a(a parama)
  {
    if (this.d != null) {
      this.d.d = parama;
    }
  }
  
  private void a(rd.c paramc, TencentMapOptions paramTencentMapOptions)
  {
    AppMethodBeat.i(224878);
    if ((paramTencentMapOptions != null) && (paramTencentMapOptions.getExtSurface() != null) && (this.e != null) && (paramTencentMapOptions != null))
    {
      rd localrd = this.e;
      if ((localrd.o != null) && (paramc != null)) {
        localrd.o.add(paramc);
      }
      int k = paramTencentMapOptions.getExtSurfaceWidth();
      int m = paramTencentMapOptions.getExtSurfaceHeight();
      this.b.measure(View.MeasureSpec.makeMeasureSpec(k, 1073741824), View.MeasureSpec.makeMeasureSpec(m, 1073741824));
      b(k, m);
    }
    AppMethodBeat.o(224878);
  }
  
  private void b(boolean paramBoolean, List<rm> paramList)
  {
    AppMethodBeat.i(224869);
    if ((this.e == null) || (this.c == null) || (this.c.e_ == null))
    {
      AppMethodBeat.o(224869);
      return;
    }
    this.e.a(paramList);
    if (paramBoolean) {
      this.e.g();
    }
    this.e.a(this.c.U(), ((mk)this.c.d_).l());
    AppMethodBeat.o(224869);
  }
  
  private void k()
  {
    AppMethodBeat.i(224839);
    Object localObject = this.b;
    sj localsj = this.c;
    if ((localObject == null) || (localsj == null))
    {
      AppMethodBeat.o(224839);
      return;
    }
    if (this.j != null) {
      this.j.removeCallbacksAndMessages(null);
    }
    ((VectorMap)localsj.e_).o.i.b(this);
    localsj.at.remove(this);
    localsj.b(this);
    ((ViewGroup)localObject).removeAllViews();
    localObject = this.i.iterator();
    while (((Iterator)localObject).hasNext()) {
      ((el)((Iterator)localObject).next()).c();
    }
    this.i.clear();
    AppMethodBeat.o(224839);
  }
  
  public final float a(int paramInt)
  {
    AppMethodBeat.i(225207);
    if (this.e != null)
    {
      rd localrd = this.e;
      el.a locala = el.a.a(paramInt);
      float f1 = localrd.c[locala.e];
      AppMethodBeat.o(225207);
      return f1;
    }
    AppMethodBeat.o(225207);
    return 0.0F;
  }
  
  public final void a(float paramFloat)
  {
    float f2 = 1.3F;
    float f1 = 0.7F;
    AppMethodBeat.i(225377);
    rd localrd;
    if (this.e != null)
    {
      localrd = this.e;
      if (paramFloat <= 1.3F) {
        break label74;
      }
      paramFloat = f2;
    }
    label74:
    for (;;)
    {
      if (paramFloat < 0.7F) {
        paramFloat = f1;
      }
      for (;;)
      {
        localrd.d = 0;
        localrd.m = paramFloat;
        localrd.h();
        AppMethodBeat.o(225377);
        return;
      }
    }
  }
  
  public final void a(int paramInt, float paramFloat)
  {
    float f1 = 1.0F;
    float f2 = 0.0F;
    AppMethodBeat.i(225197);
    rd localrd;
    el.a locala;
    if (this.e != null)
    {
      localrd = this.e;
      locala = el.a.a(paramInt);
      if (paramFloat >= 0.0F) {
        break label78;
      }
      paramFloat = f2;
    }
    label78:
    for (;;)
    {
      if (paramFloat > 1.0F) {
        paramFloat = f1;
      }
      for (;;)
      {
        localrd.c[locala.e] = paramFloat;
        localrd.h();
        j();
        AppMethodBeat.o(225197);
        return;
      }
    }
  }
  
  public final void a(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(225324);
    if (this.c != null) {
      this.c.a(paramInt1, paramInt2);
    }
    AppMethodBeat.o(225324);
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    AppMethodBeat.i(225231);
    if (this.e != null)
    {
      this.e.a(el.b.a(paramInt1));
      this.e.a(el.a.d, paramInt2);
      this.e.a(el.a.c, paramInt3);
      this.e.a(el.a.a, paramInt4);
      this.e.a(el.a.b, paramInt5);
      this.e.h();
      j();
    }
    AppMethodBeat.o(225231);
  }
  
  public final void a(int paramInt, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(225243);
    if (this.e != null)
    {
      el.b localb = el.b.a(paramInt);
      this.e.a(localb);
      switch (3.a[localb.ordinal()])
      {
      }
    }
    for (;;)
    {
      this.e.h();
      j();
      AppMethodBeat.o(225243);
      return;
      this.e.a(el.a.d, paramArrayOfInt[0]);
      this.e.a(el.a.a, paramArrayOfInt[1]);
      continue;
      this.e.a(el.a.c, paramArrayOfInt[0]);
      this.e.a(el.a.a, paramArrayOfInt[1]);
      continue;
      this.e.a(el.a.c, paramArrayOfInt[0]);
      this.e.a(el.a.b, paramArrayOfInt[1]);
      continue;
      this.e.a(el.a.d, paramArrayOfInt[0]);
      this.e.a(el.a.b, paramArrayOfInt[1]);
    }
  }
  
  public final void a(fr paramfr)
  {
    AppMethodBeat.i(225301);
    if (paramfr.f != -1)
    {
      paramfr = this.j.obtainMessage(paramfr.f, paramfr);
      this.j.sendMessage(paramfr);
    }
    AppMethodBeat.o(225301);
  }
  
  public final void a(pb.a parama, TencentMapOptions paramTencentMapOptions)
  {
    AppMethodBeat.i(225396);
    if ((paramTencentMapOptions != null) && (paramTencentMapOptions.getExtSurface() != null))
    {
      this.g = parama;
      int k = paramTencentMapOptions.getExtSurfaceWidth();
      int m = paramTencentMapOptions.getExtSurfaceHeight();
      this.b.measure(View.MeasureSpec.makeMeasureSpec(k, 1073741824), View.MeasureSpec.makeMeasureSpec(m, 1073741824));
      b(k, m);
    }
    AppMethodBeat.o(225396);
  }
  
  public final void a(boolean paramBoolean)
  {
    AppMethodBeat.i(224957);
    Object localObject = this.d;
    ((rf)localObject).g = paramBoolean;
    if ((paramBoolean) && (((rf)localObject).b == null)) {
      ((rf)localObject).a(((rf)localObject).a);
    }
    if (((rf)localObject).b != null)
    {
      localObject = ((rf)localObject).b;
      if (!paramBoolean) {
        break label65;
      }
    }
    label65:
    for (int k = 0;; k = 8)
    {
      ((ZoomControls)localObject).setVisibility(k);
      AppMethodBeat.o(224957);
      return;
    }
  }
  
  public final void a(boolean paramBoolean, List<rm> paramList)
  {
    AppMethodBeat.i(225163);
    if ((this.e == null) || (this.c == null) || (this.c.e_ == null))
    {
      AppMethodBeat.o(225163);
      return;
    }
    this.e.a(paramList);
    if (paramBoolean) {
      this.e.g();
    }
    this.e.a(this.c.U(), ((mk)this.c.d_).l());
    AppMethodBeat.o(225163);
  }
  
  public final boolean a()
  {
    AppMethodBeat.i(225047);
    rf localrf = this.d;
    if ((localrf.b != null) && (localrf.b.getVisibility() == 0))
    {
      AppMethodBeat.o(225047);
      return true;
    }
    AppMethodBeat.o(225047);
    return false;
  }
  
  public final void b(int paramInt)
  {
    AppMethodBeat.i(225222);
    if (this.e != null)
    {
      this.e.a(el.b.a(paramInt));
      j();
    }
    AppMethodBeat.o(225222);
  }
  
  public final void b(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(225125);
    this.p = paramInt2;
    Iterator localIterator = this.i.iterator();
    while (localIterator.hasNext()) {
      ((el)localIterator.next()).b(paramInt1, paramInt2);
    }
    j();
    AppMethodBeat.o(225125);
  }
  
  public final void b(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    AppMethodBeat.i(225260);
    if (this.e != null)
    {
      this.e.b(el.b.a(paramInt1));
      this.e.b(el.a.d, paramInt2);
      this.e.b(el.a.c, paramInt3);
      this.e.b(el.a.a, paramInt4);
      this.e.b(el.a.b, paramInt5);
      this.e.i();
      j();
    }
    AppMethodBeat.o(225260);
  }
  
  public final void b(boolean paramBoolean)
  {
    AppMethodBeat.i(224966);
    sj localsj = this.c;
    if (localsj.S != paramBoolean)
    {
      localObject = new fr();
      ((fr)localObject).f = 2;
      Iterator localIterator = localsj.q.iterator();
      while (localIterator.hasNext()) {
        ((ey)localIterator.next()).a((fr)localObject);
      }
    }
    localsj.S = paramBoolean;
    Object localObject = ((VectorMap)localsj.e_).o.i;
    ((ac)localObject).G = paramBoolean;
    ((ac)localObject).z.f().b(((ac)localObject).G);
    ((VectorMap)localsj.e_).o.v = true;
    AppMethodBeat.o(224966);
  }
  
  public final boolean b()
  {
    return this.c.S;
  }
  
  public final void c(int paramInt)
  {
    AppMethodBeat.i(225270);
    if (this.e != null)
    {
      this.e.a(el.a.a, paramInt);
      this.e.h();
      j();
    }
    AppMethodBeat.o(225270);
  }
  
  public final void c(boolean paramBoolean)
  {
    AppMethodBeat.i(224975);
    this.q = paramBoolean;
    Object localObject = this.d;
    ((rf)localObject).f = paramBoolean;
    if ((paramBoolean) && (((rf)localObject).c == null)) {
      ((rf)localObject).b(((rf)localObject).a);
    }
    if (((rf)localObject).c != null)
    {
      localObject = ((rf)localObject).c;
      if (!paramBoolean) {
        break label70;
      }
    }
    label70:
    for (int k = 0;; k = 8)
    {
      ((re)localObject).setVisibility(k);
      AppMethodBeat.o(224975);
      return;
    }
  }
  
  public final boolean c()
  {
    return this.q;
  }
  
  public final void d(int paramInt)
  {
    AppMethodBeat.i(225294);
    if (this.e != null)
    {
      this.e.a(el.a.c, paramInt);
      this.e.h();
      j();
    }
    AppMethodBeat.o(225294);
  }
  
  public final void d(boolean paramBoolean)
  {
    AppMethodBeat.i(224983);
    this.c.b(paramBoolean);
    AppMethodBeat.o(224983);
  }
  
  public final boolean d()
  {
    AppMethodBeat.i(225073);
    boolean bool = this.c.g();
    AppMethodBeat.o(225073);
    return bool;
  }
  
  public final void e(int paramInt)
  {
    AppMethodBeat.i(225252);
    if (this.e != null)
    {
      this.e.b(el.b.a(paramInt));
      j();
    }
    AppMethodBeat.o(225252);
  }
  
  public final void e(boolean paramBoolean)
  {
    AppMethodBeat.i(224993);
    this.c.c(paramBoolean);
    AppMethodBeat.o(224993);
  }
  
  public final boolean e()
  {
    AppMethodBeat.i(225088);
    boolean bool = this.c.h();
    AppMethodBeat.o(225088);
    return bool;
  }
  
  public final void f(int paramInt)
  {
    AppMethodBeat.i(225311);
    if (this.c != null) {
      this.c.a(paramInt);
    }
    AppMethodBeat.o(225311);
  }
  
  public final void f(boolean paramBoolean)
  {
    AppMethodBeat.i(225005);
    this.c.d(paramBoolean);
    AppMethodBeat.o(225005);
  }
  
  public final boolean f()
  {
    AppMethodBeat.i(225097);
    boolean bool = this.c.i();
    AppMethodBeat.o(225097);
    return bool;
  }
  
  public final void g(int paramInt)
  {
    AppMethodBeat.i(225333);
    if (this.e != null)
    {
      rd localrd = this.e;
      localrd.d = paramInt;
      localrd.m = 1.4E-45F;
      localrd.h();
    }
    AppMethodBeat.o(225333);
  }
  
  public final void g(boolean paramBoolean)
  {
    AppMethodBeat.i(225014);
    this.c.e(paramBoolean);
    AppMethodBeat.o(225014);
  }
  
  public final boolean g()
  {
    AppMethodBeat.i(225105);
    boolean bool = this.c.j();
    AppMethodBeat.o(225105);
    return bool;
  }
  
  public final void h(int paramInt)
  {
    AppMethodBeat.i(225348);
    if (this.d != null) {
      this.d.a(el.b.a(paramInt));
    }
    AppMethodBeat.o(225348);
  }
  
  public final void h(boolean paramBoolean)
  {
    AppMethodBeat.i(225025);
    this.c.f(paramBoolean);
    AppMethodBeat.o(225025);
  }
  
  public final boolean h()
  {
    if (this.o != null) {
      return this.o.c;
    }
    return false;
  }
  
  public final void i(int paramInt)
  {
    AppMethodBeat.i(225149);
    if (this.h == null) {
      this.h = new Bundle();
    }
    this.h.putInt("key_change_style", paramInt);
    j();
    fr localfr = new fr();
    localfr.f = 2;
    localfr.l = paramInt;
    a(localfr);
    AppMethodBeat.o(225149);
  }
  
  public final void i(boolean paramBoolean)
  {
    AppMethodBeat.i(225035);
    this.c.aw = paramBoolean;
    d(paramBoolean);
    f(paramBoolean);
    g(paramBoolean);
    h(paramBoolean);
    AppMethodBeat.o(225035);
  }
  
  public final boolean i()
  {
    if (this.e != null) {
      return this.e.j;
    }
    return false;
  }
  
  protected final void j()
  {
    AppMethodBeat.i(225136);
    jw.a(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(221459);
        bj localbj = bj.this;
        Bundle localBundle = bj.this.h;
        Iterator localIterator = localbj.i.iterator();
        while (localIterator.hasNext()) {
          ((el)localIterator.next()).a(localbj.b, localBundle);
        }
        AppMethodBeat.o(221459);
      }
    });
    AppMethodBeat.o(225136);
  }
  
  public final void j(boolean paramBoolean)
  {
    AppMethodBeat.i(225179);
    if (this.e != null)
    {
      rd localrd = this.e;
      if (localrd.j != paramBoolean)
      {
        localrd.j = paramBoolean;
        if (localrd.o != null)
        {
          Iterator localIterator = localrd.o.iterator();
          while (localIterator.hasNext()) {
            ((rd.c)localIterator.next()).b(localrd.l, new Rect(localrd.p, localrd.q, 0, 0), localrd.j);
          }
        }
      }
      localrd.e();
    }
    AppMethodBeat.o(225179);
  }
  
  public final void k(boolean paramBoolean)
  {
    AppMethodBeat.i(225284);
    Object localObject;
    if (this.e != null)
    {
      localObject = this.e;
      ((rd)localObject).b = paramBoolean;
      if (((rd)localObject).a != null)
      {
        localObject = ((rd)localObject).a;
        if (!paramBoolean) {
          break label53;
        }
      }
    }
    label53:
    for (int k = 0;; k = 4)
    {
      ((ImageView)localObject).setVisibility(k);
      AppMethodBeat.o(225284);
      return;
    }
  }
  
  public final void l(boolean paramBoolean)
  {
    if ((this.c != null) && (this.c.e_ != null))
    {
      Object localObject = (VectorMap)this.c.e_;
      if (((VectorMap)localObject).o != null)
      {
        localObject = ((VectorMap)localObject).o;
        if (((mk)localObject).i != null) {
          ((mk)localObject).i.L = paramBoolean;
        }
      }
    }
  }
  
  public final void m(boolean paramBoolean)
  {
    AppMethodBeat.i(225366);
    pt localpt = this.o;
    if ((localpt.b == null) || (localpt.f == null))
    {
      AppMethodBeat.o(225366);
      return;
    }
    if (paramBoolean) {}
    for (localpt.c = true;; localpt.c = false)
    {
      paramBoolean = localpt.c;
      if ((localpt.b != null) && (localpt.f != null)) {
        break;
      }
      AppMethodBeat.o(225366);
      return;
    }
    if (localpt.a == null)
    {
      if (paramBoolean) {
        localpt.e();
      }
    }
    else
    {
      VectorMap localVectorMap = (VectorMap)localpt.f.e_;
      if ((localpt.c) && (paramBoolean) && (localpt.e != null) && (localpt.e.f))
      {
        localpt.a(localVectorMap.q.u());
        AppMethodBeat.o(225366);
        return;
      }
      localpt.a(null);
      if (localpt.a.getVisibility() != 8) {
        localpt.a.setVisibility(8);
      }
    }
    AppMethodBeat.o(225366);
  }
  
  public final void n(boolean paramBoolean)
  {
    AppMethodBeat.i(225387);
    rd localrd;
    if (this.e != null)
    {
      localrd = this.e;
      if (paramBoolean) {
        break label40;
      }
    }
    label40:
    for (paramBoolean = true;; paramBoolean = false)
    {
      localrd.k = paramBoolean;
      localrd.e();
      AppMethodBeat.o(225387);
      return;
    }
  }
  
  public static abstract interface a
  {
    public abstract void a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.mapsdk.internal.bj
 * JD-Core Version:    0.7.0.1
 */