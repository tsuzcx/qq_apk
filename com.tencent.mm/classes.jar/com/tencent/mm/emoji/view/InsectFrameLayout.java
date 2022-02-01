package com.tencent.mm.emoji.view;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;
import d.g.a.b;
import d.g.b.k;
import d.l;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/emoji/view/InsectFrameLayout;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "(Landroid/content/Context;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "TAG", "", "insectCallback", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "bottom", "", "getInsectCallback", "()Lkotlin/jvm/functions/Function1;", "setInsectCallback", "(Lkotlin/jvm/functions/Function1;)V", "positionInWindow", "", "visibleRect", "Landroid/graphics/Rect;", "insectBottom", "onLayout", "", "changed", "left", "top", "right", "plugin-emojisdk_release"})
public class InsectFrameLayout
  extends FrameLayout
{
  private final String TAG;
  private Rect fTd;
  private int[] fTe;
  private b<? super Integer, Boolean> fTf;
  
  public InsectFrameLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
    AppMethodBeat.i(105808);
    AppMethodBeat.o(105808);
  }
  
  public InsectFrameLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(105807);
    this.TAG = "MicroMsg.InsectLayout";
    this.fTd = new Rect();
    this.fTe = new int[2];
    AppMethodBeat.o(105807);
  }
  
  public boolean cco()
  {
    return false;
  }
  
  public final b<Integer, Boolean> getInsectCallback()
  {
    return this.fTf;
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(105806);
    ad.i(this.TAG, "InsectFrameLayout onLayout");
    getWindowVisibleDisplayFrame(this.fTd);
    getLocationOnScreen(this.fTe);
    final int i = paramInt4 - paramInt2 + this.fTe[1] - this.fTd.bottom;
    boolean bool2 = cco();
    boolean bool1 = bool2;
    if (!bool2)
    {
      bool1 = bool2;
      if (this.fTf != null)
      {
        b localb = this.fTf;
        if (localb == null) {
          k.fvU();
        }
        bool1 = ((Boolean)localb.aA(Integer.valueOf(i))).booleanValue();
      }
    }
    if ((!bool1) && (getPaddingBottom() != i)) {
      post((Runnable)new a(this, i));
    }
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    AppMethodBeat.o(105806);
  }
  
  public final void setInsectCallback(b<? super Integer, Boolean> paramb)
  {
    this.fTf = paramb;
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "run"})
  static final class a
    implements Runnable
  {
    a(InsectFrameLayout paramInsectFrameLayout, int paramInt) {}
    
    public final void run()
    {
      AppMethodBeat.i(105805);
      this.fTg.setPadding(this.fTg.getPaddingLeft(), this.fTg.getPaddingTop(), this.fTg.getPaddingRight(), i);
      this.fTg.requestLayout();
      AppMethodBeat.o(105805);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.emoji.view.InsectFrameLayout
 * JD-Core Version:    0.7.0.1
 */