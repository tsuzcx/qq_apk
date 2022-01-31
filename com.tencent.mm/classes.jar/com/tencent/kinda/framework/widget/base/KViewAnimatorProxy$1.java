package com.tencent.kinda.framework.widget.base;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import com.tencent.kinda.framework.widget.tools.ColorUtil;
import com.tencent.kinda.gen.KView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;

class KViewAnimatorProxy$1
  implements ValueAnimator.AnimatorUpdateListener
{
  KViewAnimatorProxy$1(KViewAnimatorProxy paramKViewAnimatorProxy) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    AppMethodBeat.i(144696);
    float f = ((Float)paramValueAnimator.getAnimatedValue()).floatValue();
    KViewAnimatorProxy.access$000(this.this$0).setBackgroundColor(f);
    ab.d("base_MMKView", "已经给背景颜色设置动画KView：" + KViewAnimatorProxy.access$000(this.this$0) + "，value：" + Long.toHexString(ColorUtil.absColor(f)));
    AppMethodBeat.o(144696);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.kinda.framework.widget.base.KViewAnimatorProxy.1
 * JD-Core Version:    0.7.0.1
 */