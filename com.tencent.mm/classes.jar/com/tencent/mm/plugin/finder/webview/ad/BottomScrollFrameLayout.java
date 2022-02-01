package com.tencent.mm.plugin.finder.webview.ad;

import android.content.Context;
import android.util.AttributeSet;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.widget.a.i;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/webview/ad/BottomScrollFrameLayout;", "Lcom/tencent/mm/plugin/finder/webview/ad/ScrollFrameLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attributeSet", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "dialog", "Lcom/tencent/mm/ui/widget/dialog/MMDialog;", "getDialog", "()Lcom/tencent/mm/ui/widget/dialog/MMDialog;", "setDialog", "(Lcom/tencent/mm/ui/widget/dialog/MMDialog;)V", "isReachTop", "", "peekHeight", "getPeekHeight", "()I", "setPeekHeight", "(I)V", "scrollPeekDownLimit", "", "getScrollPeekDownLimit", "()F", "setScrollPeekDownLimit", "(F)V", "scrollToTopListener", "Lcom/tencent/mm/plugin/finder/webview/ad/IScrollToTopListener;", "getScrollToTopListener", "()Lcom/tencent/mm/plugin/finder/webview/ad/IScrollToTopListener;", "setScrollToTopListener", "(Lcom/tencent/mm/plugin/finder/webview/ad/IScrollToTopListener;)V", "animateDismiss", "", "clear", "dismiss", "initStateScroll", "distance", "interceptVertical", "distanceX", "distanceY", "velocityX", "velocityY", "onActionCancel", "onActionUp", "scroll", "setInitPosition", "setPosition", "setTopPosition", "topStateScroll", "Companion", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class BottomScrollFrameLayout
  extends ScrollFrameLayout
{
  public static final BottomScrollFrameLayout.a GYx;
  private c GYA;
  private i GYB;
  private boolean GYy;
  private float GYz;
  private int dqv;
  
  static
  {
    AppMethodBeat.i(334750);
    GYx = new BottomScrollFrameLayout.a((byte)0);
    AppMethodBeat.o(334750);
  }
  
  public BottomScrollFrameLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
    AppMethodBeat.i(334626);
    AppMethodBeat.o(334626);
  }
  
  public BottomScrollFrameLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(334638);
    setAllowVerticalIntercept(true);
    AppMethodBeat.o(334638);
  }
  
  private static final void a(BottomScrollFrameLayout paramBottomScrollFrameLayout)
  {
    AppMethodBeat.i(334706);
    s.u(paramBottomScrollFrameLayout, "this$0");
    paramBottomScrollFrameLayout.dismiss();
    AppMethodBeat.o(334706);
  }
  
  private static final void b(BottomScrollFrameLayout paramBottomScrollFrameLayout)
  {
    AppMethodBeat.i(334724);
    s.u(paramBottomScrollFrameLayout, "this$0");
    paramBottomScrollFrameLayout.dismiss();
    AppMethodBeat.o(334724);
  }
  
  private static final void c(BottomScrollFrameLayout paramBottomScrollFrameLayout)
  {
    AppMethodBeat.i(334734);
    s.u(paramBottomScrollFrameLayout, "this$0");
    paramBottomScrollFrameLayout.dismiss();
    AppMethodBeat.o(334734);
  }
  
  private void dismiss()
  {
    AppMethodBeat.i(334649);
    i locali = this.GYB;
    if (locali != null) {
      locali.dismiss();
    }
    AppMethodBeat.o(334649);
  }
  
  private final void fqn()
  {
    AppMethodBeat.i(334664);
    if (!this.GYy)
    {
      fqo();
      AppMethodBeat.o(334664);
      return;
    }
    if (this.GYy) {
      fqp();
    }
    AppMethodBeat.o(334664);
  }
  
  private final void fqo()
  {
    AppMethodBeat.i(334679);
    if ((getMPointerTranslateY() < 0.0F) && (getMPointerTranslateY() <= -getScrollUpLimit() / 2.0F))
    {
      if ((getMPointerTranslateY() <= -getScrollUpLimit() / 2.0F) && (getMPointerTranslateY() >= -getScrollUpLimit()))
      {
        ScrollFrameLayout.a((ScrollFrameLayout)this, -getScrollUpLimit(), false, 0, null, 14);
        this.GYy = true;
        c localc = this.GYA;
        if (localc != null)
        {
          localc.dSq();
          AppMethodBeat.o(334679);
        }
      }
    }
    else {
      ScrollFrameLayout.a((ScrollFrameLayout)this, 0.0F, false, 0, null, 15);
    }
    AppMethodBeat.o(334679);
  }
  
  private final void fqp()
  {
    AppMethodBeat.i(334692);
    if (getMPointerTranslateY() > 0.0F)
    {
      if (getMPointerTranslateY() < getScrollDownLimit())
      {
        ScrollFrameLayout.a((ScrollFrameLayout)this, -getScrollUpLimit(), false, 0, null, 14);
        AppMethodBeat.o(334692);
        return;
      }
      ScrollFrameLayout.a((ScrollFrameLayout)this, this.dqv, false, 0, new BottomScrollFrameLayout..ExternalSyntheticLambda1(this), 6);
    }
    AppMethodBeat.o(334692);
  }
  
  private static final void setTopPosition$lambda-1(BottomScrollFrameLayout paramBottomScrollFrameLayout)
  {
    AppMethodBeat.i(334717);
    s.u(paramBottomScrollFrameLayout, "this$0");
    paramBottomScrollFrameLayout.dismiss();
    AppMethodBeat.o(334717);
  }
  
  public final boolean c(float paramFloat1, float paramFloat2, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(334916);
    Log.i("Finder.WebViewFrameLayout", "distanceY:" + paramFloat2 + " velocityY:" + paramInt2);
    if ((Math.abs(paramFloat2) >= 10.0F) && (Math.abs(paramInt2) > Math.abs(paramInt1)) && (Math.abs(paramFloat2) > Math.abs(paramFloat1)))
    {
      AppMethodBeat.o(334916);
      return true;
    }
    AppMethodBeat.o(334916);
    return false;
  }
  
  public final void clear()
  {
    AppMethodBeat.i(334883);
    super.clear();
    if (!this.GYy) {
      setAllowVerticalIntercept(true);
    }
    setMPointerTranslateY(0.0F);
    AppMethodBeat.o(334883);
  }
  
  public final void ct(float paramFloat)
  {
    AppMethodBeat.i(334903);
    float f;
    if (!this.GYy)
    {
      if (getMPointerTranslateY() + paramFloat > this.GYz) {
        ScrollFrameLayout.a((ScrollFrameLayout)this, this.dqv, false, 0, new BottomScrollFrameLayout..ExternalSyntheticLambda0(this), 6);
      }
      for (;;)
      {
        f = getMPointerTranslateY();
        setTranslationY(f);
        Log.i("Finder.WebViewFrameLayout", "translationY :" + getTranslationY() + " offsetY:" + paramFloat);
        AppMethodBeat.o(334903);
        return;
        if (getMPointerTranslateY() + paramFloat <= -getScrollUpLimit()) {
          setMPointerTranslateY(-getScrollUpLimit());
        } else {
          setMPointerTranslateY(getMPointerTranslateY() + paramFloat);
        }
      }
    }
    if (getMPointerTranslateY() + paramFloat < 0.0F) {
      setMPointerTranslateY(0.0F);
    }
    for (;;)
    {
      f = -getScrollUpLimit() + getMPointerTranslateY();
      break;
      setMPointerTranslateY(getMPointerTranslateY() + paramFloat);
    }
  }
  
  public final void fql()
  {
    AppMethodBeat.i(334864);
    fqn();
    clear();
    AppMethodBeat.o(334864);
  }
  
  public final void fqm()
  {
    AppMethodBeat.i(334873);
    fqn();
    clear();
    AppMethodBeat.o(334873);
  }
  
  public final void fqq()
  {
    AppMethodBeat.i(334923);
    if (this.GYy)
    {
      a(this.dqv, false, 300, new BottomScrollFrameLayout..ExternalSyntheticLambda2(this));
      AppMethodBeat.o(334923);
      return;
    }
    ScrollFrameLayout.a((ScrollFrameLayout)this, this.dqv, false, 0, new BottomScrollFrameLayout..ExternalSyntheticLambda3(this), 4);
    AppMethodBeat.o(334923);
  }
  
  public final i getDialog()
  {
    return this.GYB;
  }
  
  public final int getPeekHeight()
  {
    return this.dqv;
  }
  
  public final float getScrollPeekDownLimit()
  {
    return this.GYz;
  }
  
  public final c getScrollToTopListener()
  {
    return this.GYA;
  }
  
  public final void setDialog(i parami)
  {
    this.GYB = parami;
  }
  
  public final void setPeekHeight(int paramInt)
  {
    this.dqv = paramInt;
  }
  
  public final void setScrollPeekDownLimit(float paramFloat)
  {
    this.GYz = paramFloat;
  }
  
  public final void setScrollToTopListener(c paramc)
  {
    this.GYA = paramc;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.webview.ad.BottomScrollFrameLayout
 * JD-Core Version:    0.7.0.1
 */