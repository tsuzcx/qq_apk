package com.tencent.mapsdk.internal;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.ZoomControls;
import com.tencent.mapsdk.vector.VectorMap;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class rf
  extends ej
{
  public Context a;
  public ZoomControls b;
  public re c = null;
  public bj.a d = null;
  sj e;
  public boolean f;
  public boolean g;
  Bitmap h;
  Bitmap i;
  Bitmap j;
  Bitmap k;
  private el.b l = el.b.c;
  private int m = 0;
  private LinearLayout n;
  private ViewGroup o;
  
  public rf(Context paramContext, sj paramsj)
  {
    this.a = paramContext;
    this.e = paramsj;
  }
  
  private void a(bj.a parama)
  {
    this.d = parama;
  }
  
  private void a(boolean paramBoolean)
  {
    AppMethodBeat.i(223305);
    if (this.c == null)
    {
      AppMethodBeat.o(223305);
      return;
    }
    Object localObject;
    label97:
    Bitmap localBitmap;
    if (paramBoolean)
    {
      if ((this.j == null) || (this.j.isRecycled())) {
        this.j = gv.b(gv.b(this.a, "location_state_dark_normal.png"));
      }
      if ((this.k == null) || (this.k.isRecycled())) {
        this.k = gv.b(gv.b(this.a, "location_state_dark_selected.png"));
      }
      if (!paramBoolean) {
        break label215;
      }
      localObject = this.j;
      if (!paramBoolean) {
        break label223;
      }
      localBitmap = this.k;
      label107:
      this.c.a(this.a, (Bitmap)localObject, localBitmap);
      localObject = this.c;
      if (!this.f) {
        break label232;
      }
    }
    label215:
    label223:
    label232:
    for (int i1 = 0;; i1 = 8)
    {
      ((re)localObject).setVisibility(i1);
      AppMethodBeat.o(223305);
      return;
      if ((this.h == null) || (this.h.isRecycled())) {
        this.h = gv.b(gv.b(this.a, "location_state_normal.png"));
      }
      if ((this.i != null) && (!this.i.isRecycled())) {
        break;
      }
      this.i = gv.b(gv.b(this.a, "location_state_selected.png"));
      break;
      localObject = this.h;
      break label97;
      localBitmap = this.i;
      break label107;
    }
  }
  
  private void a(final boolean paramBoolean1, final boolean paramBoolean2)
  {
    AppMethodBeat.i(223320);
    if (this.b != null) {
      jw.a(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(226018);
          rf.this.b.setIsZoomInEnabled(paramBoolean1);
          rf.this.b.setIsZoomOutEnabled(paramBoolean2);
          AppMethodBeat.o(226018);
        }
      });
    }
    AppMethodBeat.o(223320);
  }
  
  private void b(boolean paramBoolean)
  {
    AppMethodBeat.i(223329);
    this.g = paramBoolean;
    if ((paramBoolean) && (this.b == null)) {
      a(this.a);
    }
    ZoomControls localZoomControls;
    if (this.b != null)
    {
      localZoomControls = this.b;
      if (!paramBoolean) {
        break label58;
      }
    }
    label58:
    for (int i1 = 0;; i1 = 8)
    {
      localZoomControls.setVisibility(i1);
      AppMethodBeat.o(223329);
      return;
    }
  }
  
  private void c(boolean paramBoolean)
  {
    AppMethodBeat.i(223347);
    this.f = paramBoolean;
    if ((paramBoolean) && (this.c == null)) {
      b(this.a);
    }
    re localre;
    if (this.c != null)
    {
      localre = this.c;
      if (!paramBoolean) {
        break label58;
      }
    }
    label58:
    for (int i1 = 0;; i1 = 8)
    {
      localre.setVisibility(i1);
      AppMethodBeat.o(223347);
      return;
    }
  }
  
  private void e()
  {
    AppMethodBeat.i(223286);
    if ((this.n != null) && (this.b != null))
    {
      LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-2, -2);
      if (this.n.indexOfChild(this.b) < 0)
      {
        this.n.addView(this.b, localLayoutParams);
        AppMethodBeat.o(223286);
        return;
      }
      this.n.updateViewLayout(this.b, localLayoutParams);
    }
    AppMethodBeat.o(223286);
  }
  
  private void f()
  {
    AppMethodBeat.i(223293);
    if ((this.n != null) && (this.c != null) && (this.e != null) && (this.e.e_ != null))
    {
      a(((mk)this.e.d_).l());
      LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-2, -2);
      if (this.n.indexOfChild(this.c) < 0)
      {
        if ((this.b != null) && (this.n.indexOfChild(this.b) >= 0))
        {
          this.n.removeViewInLayout(this.b);
          this.n.addView(this.c, localLayoutParams);
          this.n.addView(this.b, localLayoutParams);
          AppMethodBeat.o(223293);
          return;
        }
        this.n.addView(this.c, localLayoutParams);
        AppMethodBeat.o(223293);
        return;
      }
      this.n.updateViewLayout(this.c, localLayoutParams);
    }
    AppMethodBeat.o(223293);
  }
  
  private boolean g()
  {
    AppMethodBeat.i(223338);
    if (this.b == null)
    {
      AppMethodBeat.o(223338);
      return false;
    }
    if (this.b.getVisibility() == 0)
    {
      AppMethodBeat.o(223338);
      return true;
    }
    AppMethodBeat.o(223338);
    return false;
  }
  
  private FrameLayout.LayoutParams h()
  {
    AppMethodBeat.i(223359);
    FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(-2, -2);
    int i1 = jt.a(this.a, 5);
    switch (5.a[this.l.ordinal()])
    {
    default: 
      kh.c("Unknown position:" + this.l);
    }
    for (;;)
    {
      AppMethodBeat.o(223359);
      return localLayoutParams;
      localLayoutParams.gravity = 83;
      localLayoutParams.bottomMargin = (i1 * 2);
      localLayoutParams.leftMargin = i1;
      continue;
      localLayoutParams.gravity = 81;
      localLayoutParams.bottomMargin = i1;
      continue;
      localLayoutParams.gravity = 85;
      localLayoutParams.bottomMargin = (i1 * 6);
      localLayoutParams.rightMargin = i1;
      continue;
      localLayoutParams.gravity = 51;
      localLayoutParams.topMargin = i1;
      localLayoutParams.leftMargin = i1;
      continue;
      localLayoutParams.gravity = 49;
      localLayoutParams.topMargin = i1;
      continue;
      localLayoutParams.gravity = 53;
      localLayoutParams.topMargin = i1;
      localLayoutParams.rightMargin = i1;
    }
  }
  
  public final Rect a()
  {
    AppMethodBeat.i(223469);
    Rect localRect = new Rect();
    if ((this.b != null) && (this.c != null))
    {
      localRect.bottom = Math.min(this.b.getBottom(), this.c.getBottom());
      localRect.right = Math.max(this.b.getRight(), this.c.getRight());
      localRect.left = Math.min(this.b.getLeft(), this.c.getLeft());
      localRect.top = Math.min(this.b.getTop(), this.c.getTop());
    }
    AppMethodBeat.o(223469);
    return localRect;
  }
  
  public final void a(Context paramContext)
  {
    AppMethodBeat.i(223444);
    try
    {
      this.b = new ZoomControls(paramContext);
      if (Build.VERSION.SDK_INT >= 17) {
        this.b.setId(View.generateViewId());
      }
      for (;;)
      {
        this.b.setOnZoomInClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(226049);
            ((VectorMap)rf.this.e.e_).o.i.a(null);
            AppMethodBeat.o(226049);
          }
        });
        this.b.setOnZoomOutClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(226067);
            ((VectorMap)rf.this.e.e_).o.i.b(null);
            AppMethodBeat.o(226067);
          }
        });
        e();
        AppMethodBeat.o(223444);
        return;
        this.b.setId(-570425343);
      }
      return;
    }
    catch (Exception paramContext)
    {
      AppMethodBeat.o(223444);
    }
  }
  
  public final void a(el.b paramb)
  {
    AppMethodBeat.i(223423);
    if (this.l != paramb)
    {
      this.l = paramb;
      a(this.o, null);
    }
    AppMethodBeat.o(223423);
  }
  
  public final boolean a(ViewGroup paramViewGroup, Bundle paramBundle)
  {
    int i1 = -1;
    AppMethodBeat.i(223413);
    if (paramViewGroup == null)
    {
      AppMethodBeat.o(223413);
      return false;
    }
    this.o = paramViewGroup;
    if ((this.n == null) || (this.n.getParent() != paramViewGroup))
    {
      this.n = new LinearLayout(this.a);
      this.n.setOrientation(1);
      paramViewGroup.addView(this.n);
    }
    paramViewGroup = new FrameLayout.LayoutParams(-2, -2);
    int i2 = jt.a(this.a, 5);
    switch (5.a[this.l.ordinal()])
    {
    default: 
      kh.c("Unknown position:" + this.l);
      this.n.setGravity(paramViewGroup.gravity);
      this.n.setLayoutParams(paramViewGroup);
      if ((this.g) && (this.b == null))
      {
        a(this.a);
        label207:
        if ((!this.f) || (this.c != null)) {
          break label391;
        }
        b(this.a);
      }
      break;
    }
    for (;;)
    {
      if (paramBundle != null) {
        i1 = paramBundle.getInt("key_change_style", -1);
      }
      a(v.b(i1));
      this.n.requestLayout();
      AppMethodBeat.o(223413);
      return true;
      paramViewGroup.gravity = 83;
      paramViewGroup.bottomMargin = (i2 * 2);
      paramViewGroup.leftMargin = i2;
      break;
      paramViewGroup.gravity = 81;
      paramViewGroup.bottomMargin = i2;
      break;
      paramViewGroup.gravity = 85;
      paramViewGroup.bottomMargin = (i2 * 6);
      paramViewGroup.rightMargin = i2;
      break;
      paramViewGroup.gravity = 51;
      paramViewGroup.topMargin = i2;
      paramViewGroup.leftMargin = i2;
      break;
      paramViewGroup.gravity = 49;
      paramViewGroup.topMargin = i2;
      break;
      paramViewGroup.gravity = 53;
      paramViewGroup.topMargin = i2;
      paramViewGroup.rightMargin = i2;
      break;
      e();
      break label207;
      label391:
      f();
    }
  }
  
  public final void b(int paramInt1, int paramInt2) {}
  
  public final void b(Context paramContext)
  {
    AppMethodBeat.i(223454);
    this.c = new re(paramContext);
    paramContext = gv.b(gv.b(this.a, "location_enable.png"));
    this.c.setScaleType(ImageView.ScaleType.CENTER);
    this.c.setImageBitmap(paramContext);
    this.c.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(226050);
        if (rf.this.d != null) {
          rf.this.d.a();
        }
        AppMethodBeat.o(226050);
      }
    });
    f();
    AppMethodBeat.o(223454);
  }
  
  public final View[] b()
  {
    return new View[] { this.b, this.c };
  }
  
  public final void c()
  {
    AppMethodBeat.i(223395);
    if (this.c != null)
    {
      re localre = this.c;
      localre.setClickable(false);
      Drawable localDrawable = localre.getBackground();
      if (localDrawable != null) {
        localDrawable.setCallback(null);
      }
      localre.setBackgroundDrawable(null);
    }
    AppMethodBeat.o(223395);
  }
  
  public final el.b d()
  {
    return this.l;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.mapsdk.internal.rf
 * JD-Core Version:    0.7.0.1
 */