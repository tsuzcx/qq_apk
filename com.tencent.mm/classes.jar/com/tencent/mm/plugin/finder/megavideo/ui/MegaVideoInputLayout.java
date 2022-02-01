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
import com.tencent.mm.ui.aw;
import com.tencent.mm.ui.bf;
import com.tencent.mm.ui.tools.h;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.a.m;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/megavideo/ui/MegaVideoInputLayout;", "Landroid/widget/LinearLayout;", "Lcom/tencent/mm/ui/tools/KeyboardHeightObserver;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "hasNavigationBar", "", "isShowKeyboard", "()Z", "setShowKeyboard", "(Z)V", "listenKeyBoardChange", "getListenKeyBoardChange", "setListenKeyBoardChange", "nestedAnimButton", "Landroid/view/View;", "getNestedAnimButton", "()Landroid/view/View;", "setNestedAnimButton", "(Landroid/view/View;)V", "nestedAnimVideoView", "getNestedAnimVideoView", "setNestedAnimVideoView", "onKeyboardChange", "Lkotlin/Function2;", "", "getOnKeyboardChange", "()Lkotlin/jvm/functions/Function2;", "setOnKeyboardChange", "(Lkotlin/jvm/functions/Function2;)V", "animViews", "height", "onKeyboardHeightChanged", "isResized", "reset", "restoreViews", "Companion", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class MegaVideoInputLayout
  extends LinearLayout
  implements h
{
  public static final a EBl;
  private boolean EBm;
  private final boolean EBn;
  private boolean EBo;
  private View EBp;
  private View EBq;
  private m<? super Boolean, ? super Integer, ah> EBr;
  
  static
  {
    AppMethodBeat.i(341988);
    EBl = new a((byte)0);
    AppMethodBeat.o(341988);
  }
  
  public MegaVideoInputLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(341975);
    this.EBn = bf.bg(getContext());
    AppMethodBeat.o(341975);
  }
  
  public MegaVideoInputLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(341983);
    this.EBn = bf.bg(getContext());
    AppMethodBeat.o(341983);
  }
  
  public final void eCW()
  {
    AppMethodBeat.i(342056);
    Log.i("MegaVideoInputLayout", "restoreViews: return to original");
    Object localObject = this.EBp;
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
    localObject = this.EBq;
    int i;
    if (localObject != null)
    {
      if (Float.compare(((View)localObject).getTranslationY(), 0.0F) == 0) {
        break label147;
      }
      i = 1;
      if (i == 0) {
        break label152;
      }
    }
    for (;;)
    {
      if (localObject != null)
      {
        localObject = ((View)localObject).animate();
        if (localObject != null)
        {
          localObject = ((ViewPropertyAnimator)localObject).setDuration(180L);
          if (localObject != null)
          {
            localObject = ((ViewPropertyAnimator)localObject).translationY(0.0F);
            if (localObject != null) {
              ((ViewPropertyAnimator)localObject).start();
            }
          }
        }
      }
      AppMethodBeat.o(342056);
      return;
      label147:
      i = 0;
      break;
      label152:
      localObject = null;
    }
  }
  
  public final boolean getListenKeyBoardChange()
  {
    return this.EBo;
  }
  
  public final View getNestedAnimButton()
  {
    return this.EBq;
  }
  
  public final View getNestedAnimVideoView()
  {
    return this.EBp;
  }
  
  public final m<Boolean, Integer, ah> getOnKeyboardChange()
  {
    return this.EBr;
  }
  
  public final void onKeyboardHeightChanged(int paramInt, boolean paramBoolean)
  {
    int k = 1;
    AppMethodBeat.i(342048);
    if (!this.EBo)
    {
      Log.i("MegaVideoInputLayout", s.X("onKeyboardHeightChanged: listenKeyBoardChange = ", Boolean.valueOf(this.EBo)));
      AppMethodBeat.o(342048);
      return;
    }
    int i;
    label66:
    boolean bool;
    label86:
    Object localObject1;
    int j;
    label162:
    label174:
    float f;
    if (paramInt > 0)
    {
      paramBoolean = true;
      if (paramBoolean)
      {
        if (!this.EBn) {
          break label501;
        }
        i = bf.bk(getContext()) + paramInt;
        if (getContext().getResources().getConfiguration().orientation != 2) {
          break label507;
        }
        bool = true;
        Log.i("MegaVideoInputLayout", "animViews: footer isLand = " + bool + ", translateY = " + i);
        if (!bool)
        {
          localObject1 = this.EBp;
          if (localObject1 != null)
          {
            Object localObject2 = aw.bf(getContext());
            if ((((Point)localObject2).x == 0) || (((Point)localObject2).y == 0)) {
              break label513;
            }
            j = 1;
            if (j == 0) {
              break label519;
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
            localObject1 = getNestedAnimButton();
            if (localObject1 != null)
            {
              if (((View)localObject1).getVisibility() != 0) {
                break label537;
              }
              i = k;
              label341:
              if (i == 0) {
                break label543;
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
      localObject1 = this.EBr;
      if (localObject1 != null) {
        ((m)localObject1).invoke(Boolean.valueOf(paramBoolean), Integer.valueOf(paramInt));
      }
      AppMethodBeat.o(342048);
      return;
      paramBoolean = false;
      break;
      label501:
      i = paramInt;
      break label66;
      label507:
      bool = false;
      break label86;
      label513:
      j = 0;
      break label162;
      label519:
      j = getContext().getResources().getDisplayMetrics().heightPixels;
      break label174;
      label537:
      i = 0;
      break label341;
      label543:
      localObject1 = null;
    }
  }
  
  public final void reset()
  {
    this.EBp = null;
    this.EBq = null;
    this.EBo = false;
    this.EBr = null;
  }
  
  public final void setListenKeyBoardChange(boolean paramBoolean)
  {
    this.EBo = paramBoolean;
  }
  
  public final void setNestedAnimButton(View paramView)
  {
    this.EBq = paramView;
  }
  
  public final void setNestedAnimVideoView(View paramView)
  {
    this.EBp = paramView;
  }
  
  public final void setOnKeyboardChange(m<? super Boolean, ? super Integer, ah> paramm)
  {
    this.EBr = paramm;
  }
  
  public final void setShowKeyboard(boolean paramBoolean)
  {
    this.EBm = paramBoolean;
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/megavideo/ui/MegaVideoInputLayout$Companion;", "", "()V", "TAG", "", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.megavideo.ui.MegaVideoInputLayout
 * JD-Core Version:    0.7.0.1
 */