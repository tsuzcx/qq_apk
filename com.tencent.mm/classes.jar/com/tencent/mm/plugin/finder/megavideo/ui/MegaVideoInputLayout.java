package com.tencent.mm.plugin.finder.megavideo.ui;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Point;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewPropertyAnimator;
import android.widget.LinearLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.ar;
import com.tencent.mm.ui.ax;
import com.tencent.mm.ui.tools.h;
import kotlin.g.a.m;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.x;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/megavideo/ui/MegaVideoInputLayout;", "Landroid/widget/LinearLayout;", "Lcom/tencent/mm/ui/tools/KeyboardHeightObserver;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "hasNavigationBar", "", "isShowKeyboard", "()Z", "setShowKeyboard", "(Z)V", "listenKeyBoardChange", "getListenKeyBoardChange", "setListenKeyBoardChange", "nestedAnimButton", "Landroid/view/View;", "getNestedAnimButton", "()Landroid/view/View;", "setNestedAnimButton", "(Landroid/view/View;)V", "nestedAnimVideoView", "getNestedAnimVideoView", "setNestedAnimVideoView", "onKeyboardChange", "Lkotlin/Function2;", "", "getOnKeyboardChange", "()Lkotlin/jvm/functions/Function2;", "setOnKeyboardChange", "(Lkotlin/jvm/functions/Function2;)V", "animViews", "height", "onKeyboardHeightChanged", "isResized", "reset", "restoreViews", "Companion", "plugin-finder_release"})
public final class MegaVideoInputLayout
  extends LinearLayout
  implements h
{
  public static final a zyz;
  private boolean zyt;
  private final boolean zyu;
  public boolean zyv;
  public View zyw;
  public View zyx;
  public m<? super Boolean, ? super Integer, x> zyy;
  
  static
  {
    AppMethodBeat.i(274210);
    zyz = new a((byte)0);
    AppMethodBeat.o(274210);
  }
  
  public MegaVideoInputLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(274208);
    this.zyu = ax.av(getContext());
    AppMethodBeat.o(274208);
  }
  
  public MegaVideoInputLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(274209);
    this.zyu = ax.av(getContext());
    AppMethodBeat.o(274209);
  }
  
  public final void A(int paramInt, boolean paramBoolean)
  {
    int k = 1;
    AppMethodBeat.i(274206);
    if (!this.zyv)
    {
      Log.i("MegaVideoInputLayout", "onKeyboardHeightChanged: listenKeyBoardChange = " + this.zyv);
      AppMethodBeat.o(274206);
      return;
    }
    int i;
    label73:
    Object localObject1;
    boolean bool;
    label115:
    Object localObject2;
    int j;
    label191:
    label203:
    float f;
    if (paramInt > 0)
    {
      paramBoolean = true;
      if (paramBoolean)
      {
        if (!this.zyu) {
          break label526;
        }
        i = ax.aB(getContext()) + paramInt;
        localObject1 = getContext();
        p.j(localObject1, "context");
        localObject1 = ((Context)localObject1).getResources();
        p.j(localObject1, "context.resources");
        if (((Resources)localObject1).getConfiguration().orientation != 2) {
          break label532;
        }
        bool = true;
        Log.i("MegaVideoInputLayout", "animViews: footer isLand = " + bool + ", translateY = " + i);
        if (!bool)
        {
          localObject1 = this.zyw;
          if (localObject1 != null)
          {
            localObject2 = ar.au(getContext());
            if ((((Point)localObject2).x == 0) || (((Point)localObject2).y == 0)) {
              break label538;
            }
            j = 1;
            if (j == 0) {
              break label544;
            }
            j = ((Point)localObject2).y;
            j -= i;
            localObject2 = new int[2];
            ((View)localObject1).getLocationInWindow((int[])localObject2);
            int m = ((View)localObject1).getHeight();
            f = 1.0F;
            i = m;
            if (m > j)
            {
              f = j / m;
              i = j;
            }
            j = (j - i) / 2 - localObject2[1];
            ((View)localObject1).setPivotY(0.0F);
            localObject1 = ((View)localObject1).animate();
            if (localObject1 != null)
            {
              localObject1 = ((ViewPropertyAnimator)localObject1).setDuration(90L);
              if (localObject1 != null)
              {
                localObject1 = ((ViewPropertyAnimator)localObject1).translationY(j);
                if (localObject1 != null)
                {
                  localObject1 = ((ViewPropertyAnimator)localObject1).scaleX(f);
                  if (localObject1 != null)
                  {
                    localObject1 = ((ViewPropertyAnimator)localObject1).scaleY(f);
                    if (localObject1 != null) {
                      ((ViewPropertyAnimator)localObject1).start();
                    }
                  }
                }
              }
            }
            localObject1 = this.zyx;
            if (localObject1 != null)
            {
              if (((View)localObject1).getVisibility() != 0) {
                break label584;
              }
              i = k;
              label370:
              if (i == 0) {
                break label590;
              }
            }
          }
        }
      }
    }
    for (;;)
    {
      if (localObject1 != null)
      {
        localObject1 = ((View)localObject1).animate();
        if (localObject1 != null)
        {
          localObject1 = ((ViewPropertyAnimator)localObject1).setDuration(90L);
          if (localObject1 != null)
          {
            localObject1 = ((ViewPropertyAnimator)localObject1).translationY(j);
            if (localObject1 != null) {
              ((ViewPropertyAnimator)localObject1).start();
            }
          }
        }
      }
      Log.i("MegaVideoInputLayout", "animViews: video view translateY = " + j + ", scale = " + f);
      Log.i("MegaVideoInputLayout", "onKeyboardHeightChanged: isShow = " + paramBoolean + ", height = " + paramInt);
      localObject1 = this.zyy;
      if (localObject1 == null) {
        break label596;
      }
      ((m)localObject1).invoke(Boolean.valueOf(paramBoolean), Integer.valueOf(paramInt));
      AppMethodBeat.o(274206);
      return;
      paramBoolean = false;
      break;
      label526:
      i = paramInt;
      break label73;
      label532:
      bool = false;
      break label115;
      label538:
      j = 0;
      break label191;
      label544:
      localObject2 = getContext();
      p.j(localObject2, "context");
      localObject2 = ((Context)localObject2).getResources();
      p.j(localObject2, "context.resources");
      j = ((Resources)localObject2).getDisplayMetrics().heightPixels;
      break label203;
      label584:
      i = 0;
      break label370;
      label590:
      localObject1 = null;
    }
    label596:
    AppMethodBeat.o(274206);
  }
  
  public final void dKj()
  {
    AppMethodBeat.i(274207);
    Log.i("MegaVideoInputLayout", "restoreViews: return to original");
    Object localObject = this.zyw;
    if (localObject != null)
    {
      localObject = ((View)localObject).animate();
      if (localObject != null)
      {
        localObject = ((ViewPropertyAnimator)localObject).setDuration(180L);
        if (localObject != null)
        {
          localObject = ((ViewPropertyAnimator)localObject).translationY(0.0F);
          if (localObject != null)
          {
            localObject = ((ViewPropertyAnimator)localObject).scaleX(1.0F);
            if (localObject != null)
            {
              localObject = ((ViewPropertyAnimator)localObject).scaleY(1.0F);
              if (localObject != null) {
                ((ViewPropertyAnimator)localObject).start();
              }
            }
          }
        }
      }
    }
    localObject = this.zyx;
    if (localObject != null)
    {
      int i;
      if (Float.compare(((View)localObject).getTranslationY(), 0.0F) != 0)
      {
        i = 1;
        if (i == 0) {
          break label155;
        }
      }
      for (;;)
      {
        if (localObject == null) {
          break label160;
        }
        localObject = ((View)localObject).animate();
        if (localObject == null) {
          break label160;
        }
        localObject = ((ViewPropertyAnimator)localObject).setDuration(180L);
        if (localObject == null) {
          break label160;
        }
        localObject = ((ViewPropertyAnimator)localObject).translationY(0.0F);
        if (localObject == null) {
          break label160;
        }
        ((ViewPropertyAnimator)localObject).start();
        AppMethodBeat.o(274207);
        return;
        i = 0;
        break;
        label155:
        localObject = null;
      }
    }
    label160:
    AppMethodBeat.o(274207);
  }
  
  public final boolean getListenKeyBoardChange()
  {
    return this.zyv;
  }
  
  public final View getNestedAnimButton()
  {
    return this.zyx;
  }
  
  public final View getNestedAnimVideoView()
  {
    return this.zyw;
  }
  
  public final m<Boolean, Integer, x> getOnKeyboardChange()
  {
    return this.zyy;
  }
  
  public final void setListenKeyBoardChange(boolean paramBoolean)
  {
    this.zyv = paramBoolean;
  }
  
  public final void setNestedAnimButton(View paramView)
  {
    this.zyx = paramView;
  }
  
  public final void setNestedAnimVideoView(View paramView)
  {
    this.zyw = paramView;
  }
  
  public final void setOnKeyboardChange(m<? super Boolean, ? super Integer, x> paramm)
  {
    this.zyy = paramm;
  }
  
  public final void setShowKeyboard(boolean paramBoolean)
  {
    this.zyt = paramBoolean;
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/megavideo/ui/MegaVideoInputLayout$Companion;", "", "()V", "TAG", "", "plugin-finder_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.megavideo.ui.MegaVideoInputLayout
 * JD-Core Version:    0.7.0.1
 */