package com.tencent.mm.plugin.finder.megavideo.ui;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Point;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewPropertyAnimator;
import android.widget.LinearLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.ao;
import com.tencent.mm.ui.au;
import kotlin.f;
import kotlin.g.a.a;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/megavideo/ui/MegaVideoTLFooterLayout;", "Landroid/widget/LinearLayout;", "Lcom/tencent/mm/ui/tools/KeyboardHeightObserver;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "hasNavigationBar", "", "isShowKeyboard", "()Z", "setShowKeyboard", "(Z)V", "listenKeyBoardChange", "getListenKeyBoardChange", "setListenKeyBoardChange", "marginBottomOffset", "getMarginBottomOffset", "()I", "marginBottomOffset$delegate", "Lkotlin/Lazy;", "nestedAnimButton", "Landroid/view/View;", "getNestedAnimButton", "()Landroid/view/View;", "setNestedAnimButton", "(Landroid/view/View;)V", "nestedAnimVideoView", "getNestedAnimVideoView", "setNestedAnimVideoView", "onKeyboardHeightChanged", "", "height", "isResized", "reset", "Companion", "plugin-finder_release"})
public final class MegaVideoTLFooterLayout
  extends LinearLayout
  implements com.tencent.mm.ui.tools.g
{
  public static final a uMJ;
  private boolean uMD;
  private final f uME;
  private final boolean uMF;
  public boolean uMG;
  public View uMH;
  public View uMI;
  
  static
  {
    AppMethodBeat.i(248607);
    uMJ = new a((byte)0);
    AppMethodBeat.o(248607);
  }
  
  public MegaVideoTLFooterLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(248605);
    this.uME = kotlin.g.ah((a)new b(this));
    this.uMF = au.aA(getContext());
    AppMethodBeat.o(248605);
  }
  
  public MegaVideoTLFooterLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(248606);
    this.uME = kotlin.g.ah((a)new b(this));
    this.uMF = au.aA(getContext());
    AppMethodBeat.o(248606);
  }
  
  private final int getMarginBottomOffset()
  {
    AppMethodBeat.i(248603);
    int i = ((Number)this.uME.getValue()).intValue();
    AppMethodBeat.o(248603);
    return i;
  }
  
  public final boolean getListenKeyBoardChange()
  {
    return this.uMG;
  }
  
  public final View getNestedAnimButton()
  {
    return this.uMI;
  }
  
  public final View getNestedAnimVideoView()
  {
    return this.uMH;
  }
  
  public final void setListenKeyBoardChange(boolean paramBoolean)
  {
    this.uMG = paramBoolean;
  }
  
  public final void setNestedAnimButton(View paramView)
  {
    this.uMI = paramView;
  }
  
  public final void setNestedAnimVideoView(View paramView)
  {
    this.uMH = paramView;
  }
  
  public final void setShowKeyboard(boolean paramBoolean)
  {
    this.uMD = paramBoolean;
  }
  
  public final void y(int paramInt, boolean paramBoolean)
  {
    int i = 1;
    int j = 1;
    AppMethodBeat.i(248604);
    if (!this.uMG)
    {
      Log.i("MegaVideoTLFooterLayout", "onKeyboardHeightChanged: listenKeyBoardChange = " + this.uMG);
      AppMethodBeat.o(248604);
      return;
    }
    Object localObject1;
    Object localObject2;
    label182:
    label192:
    float f;
    if (paramInt > 0)
    {
      paramBoolean = true;
      if (this.uMD == paramBoolean) {
        break label726;
      }
      this.uMD = paramBoolean;
      if ((!paramBoolean) || (Float.compare(getTranslationY(), 0.0F) != 0)) {
        break label507;
      }
      i = paramInt;
      if (this.uMF) {
        i = paramInt + au.aD(getContext());
      }
      paramInt = i - getMarginBottomOffset();
      animate().setDuration(90L).translationY(-paramInt).start();
      Log.i("MegaVideoTLFooterLayout", "onKeyboardHeightChanged: footer translateY = ".concat(String.valueOf(paramInt)));
      localObject1 = this.uMH;
      if (localObject1 == null) {
        break label501;
      }
      localObject2 = ao.az(getContext());
      if ((((Point)localObject2).x == 0) || (((Point)localObject2).y == 0)) {
        break label444;
      }
      paramInt = 1;
      if (paramInt == 0) {
        break label449;
      }
      paramInt = ((Point)localObject2).y;
      i = paramInt - i;
      localObject2 = new int[2];
      ((View)localObject1).getLocationInWindow((int[])localObject2);
      paramInt = ((View)localObject1).getHeight();
      if (paramInt <= i) {
        break label732;
      }
      f = i / paramInt;
      paramInt = i;
    }
    for (;;)
    {
      i = (i - paramInt) / 2 - localObject2[1];
      ((View)localObject1).setPivotY(0.0F);
      localObject1 = ((View)localObject1).animate();
      if (localObject1 != null)
      {
        localObject1 = ((ViewPropertyAnimator)localObject1).setDuration(90L);
        if (localObject1 != null)
        {
          localObject1 = ((ViewPropertyAnimator)localObject1).translationY(i);
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
      localObject1 = this.uMI;
      if (localObject1 != null)
      {
        if (((View)localObject1).getVisibility() != 0) {
          break label490;
        }
        paramInt = j;
        label346:
        if (paramInt == 0) {
          break label495;
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
              localObject1 = ((ViewPropertyAnimator)localObject1).translationY(i);
              if (localObject1 != null) {
                ((ViewPropertyAnimator)localObject1).start();
              }
            }
          }
        }
        Log.e("MegaVideoTLFooterLayout", "onKeyboardHeightChanged: video view translateY = " + i + ", scale = " + f);
        AppMethodBeat.o(248604);
        return;
        paramBoolean = false;
        break;
        label444:
        paramInt = 0;
        break label182;
        label449:
        localObject2 = getContext();
        p.g(localObject2, "context");
        localObject2 = ((Context)localObject2).getResources();
        p.g(localObject2, "context.resources");
        paramInt = ((Resources)localObject2).getDisplayMetrics().heightPixels;
        break label192;
        label490:
        paramInt = 0;
        break label346;
        label495:
        localObject1 = null;
      }
      label501:
      AppMethodBeat.o(248604);
      return;
      label507:
      if ((!paramBoolean) && (Float.compare(getTranslationY(), 0.0F) != 0))
      {
        Log.i("MegaVideoTLFooterLayout", "onKeyboardHeightChanged: return to original");
        animate().setDuration(180L).translationY(0.0F).start();
        localObject1 = this.uMH;
        if (localObject1 != null)
        {
          localObject1 = ((View)localObject1).animate();
          if (localObject1 != null)
          {
            localObject1 = ((ViewPropertyAnimator)localObject1).setDuration(180L);
            if (localObject1 != null)
            {
              localObject1 = ((ViewPropertyAnimator)localObject1).translationY(0.0F);
              if (localObject1 != null)
              {
                localObject1 = ((ViewPropertyAnimator)localObject1).scaleX(1.0F);
                if (localObject1 != null)
                {
                  localObject1 = ((ViewPropertyAnimator)localObject1).scaleY(1.0F);
                  if (localObject1 != null) {
                    ((ViewPropertyAnimator)localObject1).start();
                  }
                }
              }
            }
          }
        }
        localObject1 = this.uMI;
        if (localObject1 != null)
        {
          if (Float.compare(((View)localObject1).getTranslationY(), 0.0F) != 0)
          {
            paramInt = i;
            if (paramInt == 0) {
              break label720;
            }
          }
          for (;;)
          {
            if (localObject1 == null) {
              break label726;
            }
            localObject1 = ((View)localObject1).animate();
            if (localObject1 == null) {
              break label726;
            }
            localObject1 = ((ViewPropertyAnimator)localObject1).setDuration(180L);
            if (localObject1 == null) {
              break label726;
            }
            localObject1 = ((ViewPropertyAnimator)localObject1).translationY(0.0F);
            if (localObject1 == null) {
              break label726;
            }
            ((ViewPropertyAnimator)localObject1).start();
            AppMethodBeat.o(248604);
            return;
            paramInt = 0;
            break;
            localObject1 = null;
          }
        }
      }
      label720:
      label726:
      AppMethodBeat.o(248604);
      return;
      label732:
      f = 1.0F;
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/megavideo/ui/MegaVideoTLFooterLayout$Companion;", "", "()V", "TAG", "", "plugin-finder_release"})
  public static final class a {}
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
  static final class b
    extends q
    implements a<Integer>
  {
    b(MegaVideoTLFooterLayout paramMegaVideoTLFooterLayout)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.megavideo.ui.MegaVideoTLFooterLayout
 * JD-Core Version:    0.7.0.1
 */