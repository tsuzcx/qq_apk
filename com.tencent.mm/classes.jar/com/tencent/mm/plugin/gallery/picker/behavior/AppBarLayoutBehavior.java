package com.tencent.mm.plugin.gallery.picker.behavior;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.appbar.AppBarLayout.Behavior;
import com.google.android.material.appbar.AppBarLayout.Behavior.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.gallery.b.c;
import com.tencent.mm.plugin.gallery.b.e;
import com.tencent.mm.plugin.gallery.picker.view.TouchCoordinatorLayout;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;

public class AppBarLayoutBehavior
  extends AppBarLayout.Behavior
  implements View.OnTouchListener
{
  private AppBarLayout BWB;
  private boolean BXg;
  private int BXh;
  private boolean BXi;
  private boolean BXj;
  private boolean BXk;
  private Rect byG;
  private View qnL;
  
  public AppBarLayoutBehavior()
  {
    AppMethodBeat.i(164777);
    this.BXg = false;
    this.BXh = ((int)MMApplicationContext.getContext().getResources().getDimension(b.c.Edge_6A));
    this.byG = new Rect();
    this.BXi = true;
    this.BXj = false;
    this.BXk = false;
    init();
    AppMethodBeat.o(164777);
  }
  
  public AppBarLayoutBehavior(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(164778);
    this.BXg = false;
    this.BXh = ((int)MMApplicationContext.getContext().getResources().getDimension(b.c.Edge_6A));
    this.byG = new Rect();
    this.BXi = true;
    this.BXj = false;
    this.BXk = false;
    init();
    AppMethodBeat.o(164778);
  }
  
  private void init()
  {
    AppMethodBeat.i(164779);
    a(new AppBarLayout.Behavior.a()
    {
      public final boolean vX()
      {
        AppMethodBeat.i(243958);
        if ((AppBarLayoutBehavior.a(AppBarLayoutBehavior.this)) || (AppBarLayoutBehavior.b(AppBarLayoutBehavior.this)))
        {
          AppMethodBeat.o(243958);
          return true;
        }
        AppMethodBeat.o(243958);
        return false;
      }
    });
    AppMethodBeat.o(164779);
  }
  
  public final void a(CoordinatorLayout paramCoordinatorLayout, AppBarLayout paramAppBarLayout, View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    AppMethodBeat.i(242656);
    if ((paramInt5 == 1) && (this.BXj))
    {
      AppMethodBeat.o(242656);
      return;
    }
    if (this.BXg) {
      super.a(paramCoordinatorLayout, paramAppBarLayout, paramView, paramInt1, paramInt2, paramInt3, paramInt4, paramInt5);
    }
    AppMethodBeat.o(242656);
  }
  
  public final void a(CoordinatorLayout paramCoordinatorLayout, AppBarLayout paramAppBarLayout, View paramView, int paramInt1, int paramInt2, int[] paramArrayOfInt, int paramInt3)
  {
    AppMethodBeat.i(242655);
    if ((paramInt3 == 1) && (this.BXj))
    {
      AppMethodBeat.o(242655);
      return;
    }
    if (this.BXg)
    {
      super.a(paramCoordinatorLayout, paramAppBarLayout, paramView, paramInt1, paramInt2, paramArrayOfInt, paramInt3);
      if (this.BXi)
      {
        if (paramArrayOfInt[1] == 0) {
          super.a(paramCoordinatorLayout, paramAppBarLayout, paramView, 0, 0, 0, paramInt2, paramInt3);
        }
        paramArrayOfInt[1] = paramInt2;
      }
    }
    AppMethodBeat.o(242655);
  }
  
  public final boolean a(CoordinatorLayout paramCoordinatorLayout, AppBarLayout paramAppBarLayout, View paramView1, View paramView2, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(242653);
    super.a(paramCoordinatorLayout, paramAppBarLayout, paramView1, paramView2, paramInt1, paramInt2);
    AppMethodBeat.o(242653);
    return true;
  }
  
  public final boolean b(CoordinatorLayout paramCoordinatorLayout, AppBarLayout paramAppBarLayout, int paramInt)
  {
    AppMethodBeat.i(242652);
    this.BWB = paramAppBarLayout;
    this.qnL = paramAppBarLayout.findViewById(b.e.folder_select_layout);
    if ((paramCoordinatorLayout instanceof TouchCoordinatorLayout)) {
      ((TouchCoordinatorLayout)paramCoordinatorLayout).setTouchListener(this);
    }
    boolean bool = super.b(paramCoordinatorLayout, paramAppBarLayout, paramInt);
    AppMethodBeat.o(242652);
    return bool;
  }
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(164784);
    if (paramMotionEvent.getAction() == 0)
    {
      this.BXg = false;
      this.BXk = false;
      if (Math.abs(vY()) > 0) {
        break label228;
      }
      bool = true;
      this.BXi = bool;
      int i = vY();
      if (this.BWB.getTotalScrollRange() != Math.abs(i)) {
        break label234;
      }
    }
    label228:
    label234:
    for (boolean bool = true;; bool = false)
    {
      this.BXj = bool;
      new StringBuilder("isFromSnapOfBottom=").append(this.BXi).append(" isFromSnapOfTop=").append(this.BXj);
      if (this.BXi)
      {
        this.qnL.getGlobalVisibleRect(this.byG);
        if (this.byG.contains((int)paramMotionEvent.getRawX(), (int)paramMotionEvent.getRawY()))
        {
          this.BXg = true;
          this.BXk = true;
        }
      }
      if (this.BXj) {
        this.BXg = true;
      }
      if (!this.BXg)
      {
        this.BWB.getGlobalVisibleRect(this.byG);
        paramView = this.byG;
        paramView.bottom -= this.BXh;
        if (this.byG.contains((int)paramMotionEvent.getRawX(), (int)paramMotionEvent.getRawY())) {
          this.BXg = true;
        }
      }
      AppMethodBeat.o(164784);
      return false;
      bool = false;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.gallery.picker.behavior.AppBarLayoutBehavior
 * JD-Core Version:    0.7.0.1
 */