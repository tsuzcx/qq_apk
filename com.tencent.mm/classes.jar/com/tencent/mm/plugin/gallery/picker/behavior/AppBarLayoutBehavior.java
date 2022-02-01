package com.tencent.mm.plugin.gallery.picker.behavior;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.AppBarLayout.Behavior;
import android.support.design.widget.AppBarLayout.Behavior.a;
import android.support.design.widget.CoordinatorLayout;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.gallery.picker.view.TouchCoordinatorLayout;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;

public class AppBarLayoutBehavior
  extends AppBarLayout.Behavior
  implements View.OnTouchListener
{
  private View nmd;
  private Rect rect;
  private boolean xkM;
  private int xkN;
  private boolean xkO;
  private boolean xkP;
  private boolean xkQ;
  private AppBarLayout xkh;
  
  public AppBarLayoutBehavior()
  {
    AppMethodBeat.i(164777);
    this.xkM = false;
    this.xkN = ((int)MMApplicationContext.getContext().getResources().getDimension(2131165308));
    this.rect = new Rect();
    this.xkO = true;
    this.xkP = false;
    this.xkQ = false;
    init();
    AppMethodBeat.o(164777);
  }
  
  public AppBarLayoutBehavior(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(164778);
    this.xkM = false;
    this.xkN = ((int)MMApplicationContext.getContext().getResources().getDimension(2131165308));
    this.rect = new Rect();
    this.xkO = true;
    this.xkP = false;
    this.xkQ = false;
    init();
    AppMethodBeat.o(164778);
  }
  
  private void init()
  {
    AppMethodBeat.i(164779);
    a(new AppBarLayout.Behavior.a()
    {
      public final boolean bS()
      {
        AppMethodBeat.i(164776);
        if ((AppBarLayoutBehavior.a(AppBarLayoutBehavior.this)) || (AppBarLayoutBehavior.b(AppBarLayoutBehavior.this)))
        {
          AppMethodBeat.o(164776);
          return true;
        }
        AppMethodBeat.o(164776);
        return false;
      }
    });
    AppMethodBeat.o(164779);
  }
  
  public final void a(CoordinatorLayout paramCoordinatorLayout, AppBarLayout paramAppBarLayout, View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    AppMethodBeat.i(164783);
    if ((paramInt5 == 1) && (this.xkP))
    {
      AppMethodBeat.o(164783);
      return;
    }
    if (this.xkM) {
      super.a(paramCoordinatorLayout, paramAppBarLayout, paramView, paramInt1, paramInt2, paramInt3, paramInt4, paramInt5);
    }
    AppMethodBeat.o(164783);
  }
  
  public final void a(CoordinatorLayout paramCoordinatorLayout, AppBarLayout paramAppBarLayout, View paramView, int paramInt1, int paramInt2, int[] paramArrayOfInt, int paramInt3)
  {
    AppMethodBeat.i(164782);
    if ((paramInt3 == 1) && (this.xkP))
    {
      AppMethodBeat.o(164782);
      return;
    }
    if (this.xkM)
    {
      super.a(paramCoordinatorLayout, paramAppBarLayout, paramView, paramInt1, paramInt2, paramArrayOfInt, paramInt3);
      if (this.xkO)
      {
        if (paramArrayOfInt[1] == 0) {
          super.a(paramCoordinatorLayout, paramAppBarLayout, paramView, 0, 0, 0, paramInt2, paramInt3);
        }
        paramArrayOfInt[1] = paramInt2;
      }
    }
    AppMethodBeat.o(164782);
  }
  
  public final boolean a(CoordinatorLayout paramCoordinatorLayout, AppBarLayout paramAppBarLayout, View paramView1, View paramView2, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(164781);
    super.a(paramCoordinatorLayout, paramAppBarLayout, paramView1, paramView2, paramInt1, paramInt2);
    AppMethodBeat.o(164781);
    return true;
  }
  
  public final boolean b(CoordinatorLayout paramCoordinatorLayout, AppBarLayout paramAppBarLayout, int paramInt)
  {
    AppMethodBeat.i(164780);
    this.xkh = paramAppBarLayout;
    this.nmd = paramAppBarLayout.findViewById(2131301641);
    if ((paramCoordinatorLayout instanceof TouchCoordinatorLayout)) {
      ((TouchCoordinatorLayout)paramCoordinatorLayout).setTouchListener(this);
    }
    boolean bool = super.b(paramCoordinatorLayout, paramAppBarLayout, paramInt);
    AppMethodBeat.o(164780);
    return bool;
  }
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(164784);
    if (paramMotionEvent.getAction() == 0)
    {
      this.xkM = false;
      this.xkQ = false;
      if (Math.abs(bT()) > 0) {
        break label228;
      }
      bool = true;
      this.xkO = bool;
      int i = bT();
      if (this.xkh.getTotalScrollRange() != Math.abs(i)) {
        break label234;
      }
    }
    label228:
    label234:
    for (boolean bool = true;; bool = false)
    {
      this.xkP = bool;
      new StringBuilder("isFromSnapOfBottom=").append(this.xkO).append(" isFromSnapOfTop=").append(this.xkP);
      if (this.xkO)
      {
        this.nmd.getGlobalVisibleRect(this.rect);
        if (this.rect.contains((int)paramMotionEvent.getRawX(), (int)paramMotionEvent.getRawY()))
        {
          this.xkM = true;
          this.xkQ = true;
        }
      }
      if (this.xkP) {
        this.xkM = true;
      }
      if (!this.xkM)
      {
        this.xkh.getGlobalVisibleRect(this.rect);
        paramView = this.rect;
        paramView.bottom -= this.xkN;
        if (this.rect.contains((int)paramMotionEvent.getRawX(), (int)paramMotionEvent.getRawY())) {
          this.xkM = true;
        }
      }
      AppMethodBeat.o(164784);
      return false;
      bool = false;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.gallery.picker.behavior.AppBarLayoutBehavior
 * JD-Core Version:    0.7.0.1
 */