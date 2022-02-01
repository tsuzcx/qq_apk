package com.tencent.mapsdk.internal;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.FrameLayout.LayoutParams;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mapsdk.vector.VectorMap;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tencentmap.mapsdk.maps.model.IndoorBuilding;
import com.tencent.tencentmap.mapsdk.maps.model.IndoorLevel;
import java.util.ArrayList;
import java.util.List;

public final class pt
  extends ej
  implements AbsListView.OnScrollListener, AdapterView.OnItemClickListener, pu.a
{
  private static final int A;
  private static final String l = "VIEW_TAG_HEADER";
  private static final String m = "VIEW_TAG_FOOTER";
  private static final float n = 2.7F;
  private static final float o = 44.0F;
  private static final float p = 13.0F;
  private static final float q = 26.0F;
  private static final float r = 9.5F;
  private static final float s = 37.0F;
  private static final float t = 4.0F;
  private static final float u = 45.0F;
  private static final float v = 15.0F;
  private static final int x = -1;
  private static final int y;
  private static final int z = -1;
  private pt.a B;
  private Context C;
  private int D;
  private int E;
  private IndoorBuilding F;
  private String G;
  private boolean H;
  private boolean I;
  private pp J;
  private pp K;
  private pt.a.a L;
  public pr a;
  public ViewGroup b;
  public boolean c;
  public boolean d;
  public aa e;
  public sj f;
  public int g;
  public int h;
  private pu i;
  private pq j;
  private float k;
  private int w;
  
  static
  {
    AppMethodBeat.i(226055);
    y = Color.parseColor("#333333");
    A = Color.parseColor("#979797");
    AppMethodBeat.o(226055);
  }
  
  public pt(bd parambd)
  {
    AppMethodBeat.i(225707);
    this.k = 1.0F;
    this.w = 0;
    this.D = -1;
    this.E = 0;
    this.c = false;
    this.d = false;
    this.H = false;
    this.L = null;
    this.f = ((sj)parambd.b());
    this.b = this.f.d;
    this.I = parambd.l();
    this.C = this.b.getContext().getApplicationContext();
    this.c = true;
    AppMethodBeat.o(225707);
  }
  
  private int a(Adapter paramAdapter)
  {
    AppMethodBeat.i(225930);
    int i1 = (int)(44.5D * this.k);
    int i4 = paramAdapter.getCount();
    int i2 = 0;
    View localView = null;
    if (i2 < i4)
    {
      localView = paramAdapter.getView(i2, localView, this.i);
      localView.measure(0, 0);
      int i3 = localView.getMeasuredWidth();
      if (i3 <= i1) {
        break label87;
      }
      i1 = i3;
    }
    label87:
    for (;;)
    {
      i2 += 1;
      break;
      AppMethodBeat.o(225930);
      return i1;
    }
  }
  
  private void a(int paramInt)
  {
    AppMethodBeat.i(225859);
    this.g = paramInt;
    if (this.a != null) {
      this.a.post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(221489);
          ViewGroup.MarginLayoutParams localMarginLayoutParams = (ViewGroup.MarginLayoutParams)pt.a(pt.this).getLayoutParams();
          localMarginLayoutParams.bottomMargin = pt.b(pt.this);
          pt.a(pt.this).setLayoutParams(localMarginLayoutParams);
          AppMethodBeat.o(221489);
        }
      });
    }
    if (this.b != null) {
      this.h = this.b.getMeasuredHeight();
    }
    if ((this.f == null) || (this.f.e_ == null) || (((VectorMap)this.f.e_).o.t == null) || (((VectorMap)this.f.e_).o.t.q == null))
    {
      AppMethodBeat.o(225859);
      return;
    }
    this.h = (((int)((VectorMap)this.f.e_).o.t.q.b - paramInt) * 2);
    f();
    AppMethodBeat.o(225859);
  }
  
  private void a(Context paramContext)
  {
    AppMethodBeat.i(225718);
    this.k = paramContext.getApplicationContext().getResources().getDisplayMetrics().density;
    AppMethodBeat.o(225718);
  }
  
  private void a(Context paramContext, pt.a parama)
  {
    AppMethodBeat.i(225759);
    b(paramContext);
    c(paramContext);
    b(paramContext, parama);
    d(paramContext);
    a(this.b, null);
    this.a.setVisibility(8);
    AppMethodBeat.o(225759);
  }
  
  private void a(List<IndoorLevel> paramList)
  {
    AppMethodBeat.i(225869);
    if (this.b == null)
    {
      AppMethodBeat.o(225869);
      return;
    }
    f();
    if (this.B != null) {
      this.B.a(paramList);
    }
    AppMethodBeat.o(225869);
  }
  
  private void a(boolean paramBoolean)
  {
    AppMethodBeat.i(225745);
    if ((this.b == null) || (this.f == null))
    {
      AppMethodBeat.o(225745);
      return;
    }
    if (paramBoolean) {}
    for (this.c = true;; this.c = false)
    {
      paramBoolean = this.c;
      if ((this.b != null) && (this.f != null)) {
        break;
      }
      AppMethodBeat.o(225745);
      return;
    }
    if (this.a == null)
    {
      if (paramBoolean) {
        e();
      }
    }
    else
    {
      VectorMap localVectorMap = (VectorMap)this.f.e_;
      if ((this.c) && (paramBoolean) && (this.e != null) && (this.e.f))
      {
        a(localVectorMap.q.u());
        AppMethodBeat.o(225745);
        return;
      }
      a(null);
      if (this.a.getVisibility() != 8) {
        this.a.setVisibility(8);
      }
    }
    AppMethodBeat.o(225745);
  }
  
  private void b(Context paramContext)
  {
    AppMethodBeat.i(225776);
    this.a = new pr(paramContext);
    paramContext = new FrameLayout.LayoutParams(-2, -2);
    paramContext.gravity = 83;
    paramContext.leftMargin = ((int)(15.0F * this.k));
    paramContext.bottomMargin = this.g;
    this.a.setDarkStyle(this.I);
    this.a.setLayoutParams(paramContext);
    this.a.setWillNotDraw(false);
    this.a.setOrientation(1);
    this.a.setGravity(1);
    this.a.setVisibility(8);
    AppMethodBeat.o(225776);
  }
  
  private void b(Context paramContext, pt.a parama)
  {
    AppMethodBeat.i(225810);
    this.i = new pu(paramContext);
    paramContext = new LinearLayout.LayoutParams(-1, -2);
    this.i.setLayoutParams(paramContext);
    this.i.setChoiceMode(1);
    this.i.setAdapter(parama);
    this.i.setOnItemClickListener(this);
    this.i.setVerticalScrollBarEnabled(false);
    this.i.setHorizontalScrollBarEnabled(false);
    this.i.setOverScrollMode(2);
    this.i.setDivider(null);
    this.i.setDividerHeight(0);
    this.i.setOnDataChangedListener(this);
    this.a.addView(this.i);
    this.i.setOnScrollListener(this);
    AppMethodBeat.o(225810);
  }
  
  private void b(boolean paramBoolean)
  {
    AppMethodBeat.i(225848);
    if ((this.b == null) || (this.f == null))
    {
      AppMethodBeat.o(225848);
      return;
    }
    if (this.a == null)
    {
      if (!paramBoolean)
      {
        AppMethodBeat.o(225848);
        return;
      }
      e();
    }
    VectorMap localVectorMap = (VectorMap)this.f.e_;
    if ((this.c) && (paramBoolean) && (this.e != null) && (this.e.f))
    {
      a(localVectorMap.q.u());
      AppMethodBeat.o(225848);
      return;
    }
    a(null);
    if (this.a.getVisibility() != 8) {
      this.a.setVisibility(8);
    }
    AppMethodBeat.o(225848);
  }
  
  private void c(Context paramContext)
  {
    AppMethodBeat.i(225791);
    this.J = new pp(paramContext);
    this.J.setDarkStyle(this.I);
    this.J.setTag("VIEW_TAG_HEADER");
    int i1 = (int)(5.900000095367432D * this.k);
    paramContext = new LinearLayout.LayoutParams(i1, (int)(3.200000047683716D * this.k));
    paramContext.setMargins(0, i1, 0, i1);
    this.J.setLayoutParams(paramContext);
    this.a.addView(this.J);
    AppMethodBeat.o(225791);
  }
  
  private void d(Context paramContext)
  {
    AppMethodBeat.i(225821);
    this.K = new pp(paramContext);
    this.K.setDarkStyle(this.I);
    this.K.setTag("VIEW_TAG_FOOTER");
    this.K.setRotation(180.0F);
    int i1 = (int)(5.900000095367432D * this.k);
    paramContext = new LinearLayout.LayoutParams(i1, (int)(3.200000047683716D * this.k));
    paramContext.setMargins(0, i1, 0, i1);
    this.K.setLayoutParams(paramContext);
    this.a.addView(this.K);
    AppMethodBeat.o(225821);
  }
  
  private boolean j()
  {
    return this.c;
  }
  
  private void k()
  {
    AppMethodBeat.i(225834);
    boolean bool = this.f.aB.l();
    kh.b("TDZ", "updateIndoorStyle isDark: cur[" + bool + "]|old[" + this.I + "]");
    if (bool != this.I)
    {
      this.a.setDarkStyle(bool);
      this.J.setDarkStyle(bool);
      this.K.setDarkStyle(bool);
      this.B.notifyDataSetChanged();
      this.I = bool;
    }
    AppMethodBeat.o(225834);
  }
  
  private void l()
  {
    AppMethodBeat.i(225886);
    if (this.F == null)
    {
      AppMethodBeat.o(225886);
      return;
    }
    int i1 = this.F.getActiveLevelIndex();
    List localList = this.F.getLevels();
    if ((localList == null) || (i1 >= localList.size()) || (i1 == -1))
    {
      AppMethodBeat.o(225886);
      return;
    }
    if ((IndoorLevel)localList.get(i1) == null)
    {
      AppMethodBeat.o(225886);
      return;
    }
    if ((this.G != null) && (this.d) && (this.G.equals(this.F.getBuidlingId())))
    {
      this.i.setItemChecked(i1, true);
      this.d = false;
    }
    for (;;)
    {
      this.D = i1;
      this.G = this.F.getBuidlingId();
      AppMethodBeat.o(225886);
      return;
      this.i.setSelectionFromTop(i1, (int)(37.0F * this.k + 0.5D) * 2);
    }
  }
  
  private void m()
  {
    AppMethodBeat.i(225899);
    if (this.i != null)
    {
      this.i.getLayoutParams().width = a(this.B);
      this.i.requestLayout();
    }
    AppMethodBeat.o(225899);
  }
  
  private void n()
  {
    AppMethodBeat.i(225916);
    if ((this.b == null) || (this.a == null))
    {
      AppMethodBeat.o(225916);
      return;
    }
    int i2 = this.g * 2 + (int)(this.k * 16.700000762939453D);
    int i1 = i2;
    if (ry.c.equals("wechat"))
    {
      i1 = i2;
      if (this.b.getMeasuredHeight() > this.h) {
        i1 = this.b.getMeasuredHeight() - this.h - this.g + this.g + (int)(this.k * 16.700000762939453D);
      }
    }
    if (this.E >= 4.0F)
    {
      this.w = ((int)(148.5D * this.k));
      if (this.b.getMeasuredHeight() > this.w + i1)
      {
        this.H = false;
        AppMethodBeat.o(225916);
        return;
      }
      this.w = ((int)(111.5D * this.k));
      if (this.b.getMeasuredHeight() > i1 + this.w)
      {
        this.H = false;
        AppMethodBeat.o(225916);
      }
    }
    else
    {
      this.w = ((int)((this.E * 37.0F + 0.5D) * this.k));
      if (this.b.getMeasuredHeight() > i1 + this.w)
      {
        this.H = false;
        AppMethodBeat.o(225916);
        return;
      }
    }
    this.H = true;
    AppMethodBeat.o(225916);
  }
  
  public final void a(el.b paramb) {}
  
  public final void a(IndoorBuilding paramIndoorBuilding)
  {
    AppMethodBeat.i(226080);
    if (paramIndoorBuilding == null)
    {
      this.F = paramIndoorBuilding;
      this.E = 0;
      f();
      AppMethodBeat.o(226080);
      return;
    }
    if (this.a == null) {
      e();
    }
    if ((this.F != null) && (this.F.getBuidlingId().equals(paramIndoorBuilding.getBuidlingId())) && (this.F.getActiveLevelIndex() == paramIndoorBuilding.getActiveLevelIndex()))
    {
      AppMethodBeat.o(226080);
      return;
    }
    this.F = paramIndoorBuilding;
    this.E = this.F.getLevels().size();
    a(paramIndoorBuilding.getLevels());
    AppMethodBeat.o(226080);
  }
  
  public final boolean a(ViewGroup paramViewGroup, Bundle paramBundle)
  {
    AppMethodBeat.i(226105);
    if (this.a == null)
    {
      AppMethodBeat.o(226105);
      return false;
    }
    if (paramViewGroup.indexOfChild(this.a) < 0) {
      paramViewGroup.addView(this.a);
    }
    k();
    m();
    AppMethodBeat.o(226105);
    return true;
  }
  
  public final void b(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(226089);
    if ((this.a == null) || (this.i == null))
    {
      AppMethodBeat.o(226089);
      return;
    }
    f();
    AppMethodBeat.o(226089);
  }
  
  public final View[] b()
  {
    return new View[] { this.a };
  }
  
  public final void c() {}
  
  public final el.b d()
  {
    return null;
  }
  
  public final void e()
  {
    AppMethodBeat.i(226071);
    if (this.a == null)
    {
      this.B = new pt.a(this, this.C, new ArrayList());
      a(this.C);
      this.g = ((int)(45.0F * this.k));
      a(this.C, this.B);
      if (this.f != null) {
        this.e = this.f.o;
      }
    }
    AppMethodBeat.o(226071);
  }
  
  public final void f()
  {
    AppMethodBeat.i(226160);
    n();
    if ((this.a == null) || (this.i == null))
    {
      AppMethodBeat.o(226160);
      return;
    }
    if ((!this.c) || (this.H) || (this.E <= 0))
    {
      this.a.post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(221472);
          if ((pt.a(pt.this) == null) || (pt.a(pt.this).getVisibility() != 0))
          {
            AppMethodBeat.o(221472);
            return;
          }
          pt.a(pt.this).setVisibility(8);
          AppMethodBeat.o(221472);
        }
      });
      AppMethodBeat.o(226160);
      return;
    }
    this.a.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(221484);
        if ((pt.a(pt.this) == null) || (pt.c(pt.this) == null))
        {
          AppMethodBeat.o(221484);
          return;
        }
        ViewGroup.LayoutParams localLayoutParams = pt.c(pt.this).getLayoutParams();
        if (localLayoutParams.height != pt.d(pt.this))
        {
          localLayoutParams.height = pt.d(pt.this);
          pt.c(pt.this).setLayoutParams(localLayoutParams);
        }
        if (pt.a(pt.this).getVisibility() != 0) {
          pt.a(pt.this).setVisibility(0);
        }
        AppMethodBeat.o(221484);
      }
    });
    AppMethodBeat.o(226160);
  }
  
  public final void g()
  {
    AppMethodBeat.i(226172);
    m();
    int i1;
    if (this.F != null)
    {
      i1 = this.F.getActiveLevelIndex();
      List localList = this.F.getLevels();
      if ((localList == null) || (i1 >= localList.size()) || (i1 == -1))
      {
        AppMethodBeat.o(226172);
        return;
      }
      if ((IndoorLevel)localList.get(i1) != null)
      {
        if ((this.G == null) || (!this.d) || (!this.G.equals(this.F.getBuidlingId()))) {
          break label140;
        }
        this.i.setItemChecked(i1, true);
        this.d = false;
      }
    }
    for (;;)
    {
      this.D = i1;
      this.G = this.F.getBuidlingId();
      AppMethodBeat.o(226172);
      return;
      label140:
      this.i.setSelectionFromTop(i1, (int)(37.0F * this.k + 0.5D) * 2);
    }
  }
  
  public final void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    AppMethodBeat.i(226144);
    paramAdapterView = this.f.e_;
    if (paramAdapterView == null)
    {
      AppMethodBeat.o(226144);
      return;
    }
    if (this.L != null)
    {
      this.L.a.setTextColor(-16777216);
      this.L.b.setVisibility(4);
    }
    paramView = (pt.a.a)paramView.getTag();
    paramView.a.setTextColor(-1);
    paramView.b.setVisibility(0);
    this.L = paramView;
    this.D = paramInt;
    this.d = true;
    paramAdapterView.setIndoorFloor(paramInt);
    AppMethodBeat.o(226144);
  }
  
  public final void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(226193);
    if (this.a == null)
    {
      AppMethodBeat.o(226193);
      return;
    }
    paramAbsListView = (pp)this.a.findViewWithTag("VIEW_TAG_HEADER");
    pp localpp = (pp)this.a.findViewWithTag("VIEW_TAG_FOOTER");
    if ((paramAbsListView == null) || (localpp == null))
    {
      AppMethodBeat.o(226193);
      return;
    }
    if (paramInt2 == paramInt3) {
      paramAbsListView.setActivate(false);
    }
    for (;;)
    {
      localpp.setActivate(false);
      AppMethodBeat.o(226193);
      return;
      if (paramInt1 == 0) {
        paramAbsListView.setActivate(false);
      }
      while (paramInt1 + paramInt2 < paramInt3)
      {
        localpp.setActivate(true);
        AppMethodBeat.o(226193);
        return;
        paramAbsListView.setActivate(true);
      }
    }
  }
  
  public final void onScrollStateChanged(AbsListView paramAbsListView, int paramInt) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.mapsdk.internal.pt
 * JD-Core Version:    0.7.0.1
 */