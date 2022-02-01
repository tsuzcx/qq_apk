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
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.gallery.picker.view.TouchCoordinatorLayout;
import com.tencent.mm.sdk.platformtools.aj;

public class AppBarLayoutBehavior
  extends AppBarLayout.Behavior
  implements View.OnTouchListener
{
  private Rect rect;
  private boolean tII;
  private View tIJ;
  private int tIK;
  private boolean tIL;
  private boolean tIM;
  private boolean tIN;
  private AppBarLayout tId;
  
  public AppBarLayoutBehavior()
  {
    AppMethodBeat.i(164777);
    this.tII = false;
    this.tIK = ((int)aj.getContext().getResources().getDimension(2131165298));
    this.rect = new Rect();
    this.tIL = true;
    this.tIM = false;
    this.tIN = false;
    init();
    AppMethodBeat.o(164777);
  }
  
  public AppBarLayoutBehavior(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(164778);
    this.tII = false;
    this.tIK = ((int)aj.getContext().getResources().getDimension(2131165298));
    this.rect = new Rect();
    this.tIL = true;
    this.tIM = false;
    this.tIN = false;
    init();
    AppMethodBeat.o(164778);
  }
  
  private void init()
  {
    AppMethodBeat.i(164779);
    a(new AppBarLayout.Behavior.a()
    {
      public final boolean bQ()
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
    if ((paramInt5 == 1) && (this.tIM))
    {
      AppMethodBeat.o(164783);
      return;
    }
    if (this.tII) {
      super.a(paramCoordinatorLayout, paramAppBarLayout, paramView, paramInt1, paramInt2, paramInt3, paramInt4, paramInt5);
    }
    AppMethodBeat.o(164783);
  }
  
  public final void a(CoordinatorLayout paramCoordinatorLayout, AppBarLayout paramAppBarLayout, View paramView, int paramInt1, int paramInt2, int[] paramArrayOfInt, int paramInt3)
  {
    AppMethodBeat.i(164782);
    if ((paramInt3 == 1) && (this.tIM))
    {
      AppMethodBeat.o(164782);
      return;
    }
    if (this.tII)
    {
      super.a(paramCoordinatorLayout, paramAppBarLayout, paramView, paramInt1, paramInt2, paramArrayOfInt, paramInt3);
      if (this.tIL)
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
    this.tId = paramAppBarLayout;
    this.tIJ = paramAppBarLayout.findViewById(2131300185);
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
    b localb = new b();
    localb.bd(paramView);
    localb.bd(paramMotionEvent);
    a.b("com/tencent/mm/plugin/gallery/picker/behavior/AppBarLayoutBehavior", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z", this, localb.ahq());
    if (paramMotionEvent.getAction() == 0)
    {
      this.tII = false;
      this.tIN = false;
      if (Math.abs(bR()) > 0) {
        break label279;
      }
      bool = true;
      this.tIL = bool;
      int i = bR();
      if (this.tId.getTotalScrollRange() != Math.abs(i)) {
        break label285;
      }
    }
    label279:
    label285:
    for (boolean bool = true;; bool = false)
    {
      this.tIM = bool;
      new StringBuilder("isFromSnapOfBottom=").append(this.tIL).append(" isFromSnapOfTop=").append(this.tIM);
      if (this.tIL)
      {
        this.tIJ.getGlobalVisibleRect(this.rect);
        if (this.rect.contains((int)paramMotionEvent.getRawX(), (int)paramMotionEvent.getRawY()))
        {
          this.tII = true;
          this.tIN = true;
        }
      }
      if (this.tIM) {
        this.tII = true;
      }
      if (!this.tII)
      {
        this.tId.getGlobalVisibleRect(this.rect);
        paramView = this.rect;
        paramView.bottom -= this.tIK;
        if (this.rect.contains((int)paramMotionEvent.getRawX(), (int)paramMotionEvent.getRawY())) {
          this.tII = true;
        }
      }
      a.a(false, this, "com/tencent/mm/plugin/gallery/picker/behavior/AppBarLayoutBehavior", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z");
      AppMethodBeat.o(164784);
      return false;
      bool = false;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.gallery.picker.behavior.AppBarLayoutBehavior
 * JD-Core Version:    0.7.0.1
 */