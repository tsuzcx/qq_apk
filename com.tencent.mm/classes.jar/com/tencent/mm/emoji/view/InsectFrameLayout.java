package com.tencent.mm.emoji.view;

import a.f.a.b;
import a.f.b.j;
import a.l;
import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/emoji/view/InsectFrameLayout;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "(Landroid/content/Context;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "TAG", "", "insectCallback", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "bottom", "", "getInsectCallback", "()Lkotlin/jvm/functions/Function1;", "setInsectCallback", "(Lkotlin/jvm/functions/Function1;)V", "positionInWindow", "", "visibleRect", "Landroid/graphics/Rect;", "insectBottom", "onLayout", "", "changed", "left", "top", "right", "plugin-emojisdk_release"})
public class InsectFrameLayout
  extends FrameLayout
{
  private final String TAG;
  private Rect eyx;
  private int[] eyy;
  private b<? super Integer, Boolean> eyz;
  
  public InsectFrameLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
    AppMethodBeat.i(63320);
    AppMethodBeat.o(63320);
  }
  
  public InsectFrameLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(63319);
    this.TAG = "MicroMsg.InsectLayout";
    this.eyx = new Rect();
    this.eyy = new int[2];
    AppMethodBeat.o(63319);
  }
  
  public final b<Integer, Boolean> getInsectCallback()
  {
    return this.eyz;
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(63318);
    ab.i(this.TAG, "InsectFrameLayout onLayout");
    getWindowVisibleDisplayFrame(this.eyx);
    getLocationOnScreen(this.eyy);
    int i = paramInt4 - paramInt2 + this.eyy[1] - this.eyx.bottom;
    boolean bool = false;
    if (this.eyz != null)
    {
      b localb = this.eyz;
      if (localb == null) {
        j.ebi();
      }
      bool = ((Boolean)localb.S(Integer.valueOf(i))).booleanValue();
    }
    if ((!bool) && (getPaddingBottom() != i)) {
      post((Runnable)new InsectFrameLayout.a(this, i));
    }
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    AppMethodBeat.o(63318);
  }
  
  public final void setInsectCallback(b<? super Integer, Boolean> paramb)
  {
    this.eyz = paramb;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.emoji.view.InsectFrameLayout
 * JD-Core Version:    0.7.0.1
 */