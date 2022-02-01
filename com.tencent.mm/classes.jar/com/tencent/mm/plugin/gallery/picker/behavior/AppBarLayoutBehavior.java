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
  private AppBarLayout HJa;
  private boolean HJt;
  private int HJu;
  private boolean HJv;
  private boolean HJw;
  private boolean HJx;
  private Rect rect;
  private View tss;
  
  public AppBarLayoutBehavior()
  {
    AppMethodBeat.i(164777);
    this.HJt = false;
    this.HJu = ((int)MMApplicationContext.getContext().getResources().getDimension(b.c.Edge_6A));
    this.rect = new Rect();
    this.HJv = true;
    this.HJw = false;
    this.HJx = false;
    init();
    AppMethodBeat.o(164777);
  }
  
  public AppBarLayoutBehavior(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(164778);
    this.HJt = false;
    this.HJu = ((int)MMApplicationContext.getContext().getResources().getDimension(b.c.Edge_6A));
    this.rect = new Rect();
    this.HJv = true;
    this.HJw = false;
    this.HJx = false;
    init();
    AppMethodBeat.o(164778);
  }
  
  private void init()
  {
    AppMethodBeat.i(164779);
    a(new AppBarLayout.Behavior.a()
    {
      public final boolean Vw()
      {
        AppMethodBeat.i(289322);
        if ((AppBarLayoutBehavior.a(AppBarLayoutBehavior.this)) || (AppBarLayoutBehavior.b(AppBarLayoutBehavior.this)))
        {
          AppMethodBeat.o(289322);
          return true;
        }
        AppMethodBeat.o(289322);
        return false;
      }
    });
    AppMethodBeat.o(164779);
  }
  
  public final void a(CoordinatorLayout paramCoordinatorLayout, AppBarLayout paramAppBarLayout, View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    AppMethodBeat.i(289344);
    if ((paramInt5 == 1) && (this.HJw))
    {
      AppMethodBeat.o(289344);
      return;
    }
    if (this.HJt) {
      super.a(paramCoordinatorLayout, paramAppBarLayout, paramView, paramInt1, paramInt2, paramInt3, paramInt4, paramInt5);
    }
    AppMethodBeat.o(289344);
  }
  
  public final void a(CoordinatorLayout paramCoordinatorLayout, AppBarLayout paramAppBarLayout, View paramView, int paramInt1, int paramInt2, int[] paramArrayOfInt, int paramInt3)
  {
    AppMethodBeat.i(289341);
    if ((paramInt3 == 1) && (this.HJw))
    {
      AppMethodBeat.o(289341);
      return;
    }
    if (this.HJt)
    {
      super.a(paramCoordinatorLayout, paramAppBarLayout, paramView, paramInt1, paramInt2, paramArrayOfInt, paramInt3);
      if (this.HJv)
      {
        if (paramArrayOfInt[1] == 0) {
          super.a(paramCoordinatorLayout, paramAppBarLayout, paramView, 0, 0, 0, paramInt2, paramInt3);
        }
        paramArrayOfInt[1] = paramInt2;
      }
    }
    AppMethodBeat.o(289341);
  }
  
  public final boolean a(CoordinatorLayout paramCoordinatorLayout, AppBarLayout paramAppBarLayout, View paramView1, View paramView2, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(289338);
    super.a(paramCoordinatorLayout, paramAppBarLayout, paramView1, paramView2, paramInt1, paramInt2);
    AppMethodBeat.o(289338);
    return true;
  }
  
  public final boolean b(CoordinatorLayout paramCoordinatorLayout, AppBarLayout paramAppBarLayout, int paramInt)
  {
    AppMethodBeat.i(289333);
    this.HJa = paramAppBarLayout;
    this.tss = paramAppBarLayout.findViewById(b.e.folder_select_layout);
    if ((paramCoordinatorLayout instanceof TouchCoordinatorLayout)) {
      ((TouchCoordinatorLayout)paramCoordinatorLayout).setTouchListener(this);
    }
    boolean bool = super.b(paramCoordinatorLayout, paramAppBarLayout, paramInt);
    AppMethodBeat.o(289333);
    return bool;
  }
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(164784);
    if (paramMotionEvent.getAction() == 0)
    {
      this.HJt = false;
      this.HJx = false;
      if (Math.abs(Vx()) > 0) {
        break label228;
      }
      bool = true;
      this.HJv = bool;
      int i = Vx();
      if (this.HJa.getTotalScrollRange() != Math.abs(i)) {
        break label234;
      }
    }
    label228:
    label234:
    for (boolean bool = true;; bool = false)
    {
      this.HJw = bool;
      new StringBuilder("isFromSnapOfBottom=").append(this.HJv).append(" isFromSnapOfTop=").append(this.HJw);
      if (this.HJv)
      {
        this.tss.getGlobalVisibleRect(this.rect);
        if (this.rect.contains((int)paramMotionEvent.getRawX(), (int)paramMotionEvent.getRawY()))
        {
          this.HJt = true;
          this.HJx = true;
        }
      }
      if (this.HJw) {
        this.HJt = true;
      }
      if (!this.HJt)
      {
        this.HJa.getGlobalVisibleRect(this.rect);
        paramView = this.rect;
        paramView.bottom -= this.HJu;
        if (this.rect.contains((int)paramMotionEvent.getRawX(), (int)paramMotionEvent.getRawY())) {
          this.HJt = true;
        }
      }
      AppMethodBeat.o(164784);
      return false;
      bool = false;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.gallery.picker.behavior.AppBarLayoutBehavior
 * JD-Core Version:    0.7.0.1
 */