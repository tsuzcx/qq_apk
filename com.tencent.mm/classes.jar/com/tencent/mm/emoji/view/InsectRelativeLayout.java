package com.tencent.mm.emoji.view;

import a.f.a.b;
import a.f.b.j;
import a.l;
import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.widget.RelativeLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/emoji/view/InsectRelativeLayout;", "Landroid/widget/RelativeLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "(Landroid/content/Context;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "TAG", "", "insectCallback", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "bottom", "", "getInsectCallback", "()Lkotlin/jvm/functions/Function1;", "setInsectCallback", "(Lkotlin/jvm/functions/Function1;)V", "positionInWindow", "", "visibleRect", "Landroid/graphics/Rect;", "insectBottom", "onLayout", "", "changed", "left", "top", "right", "plugin-emojisdk_release"})
public class InsectRelativeLayout
  extends RelativeLayout
{
  private final String TAG;
  private Rect eyx;
  private int[] eyy;
  private b<? super Integer, Boolean> eyz;
  
  public InsectRelativeLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
    AppMethodBeat.i(63324);
    AppMethodBeat.o(63324);
  }
  
  public InsectRelativeLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(63323);
    this.TAG = "MicroMsg.InsectLayout";
    this.eyx = new Rect();
    this.eyy = new int[2];
    AppMethodBeat.o(63323);
  }
  
  public final b<Integer, Boolean> getInsectCallback()
  {
    return this.eyz;
  }
  
  public boolean jk(int paramInt)
  {
    return false;
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(63322);
    ab.i(this.TAG, "InsectRelativeLayout onLayout");
    getWindowVisibleDisplayFrame(this.eyx);
    getLocationOnScreen(this.eyy);
    final int i = paramInt4 - paramInt2 + this.eyy[1] - this.eyx.bottom;
    boolean bool2 = jk(i);
    boolean bool1 = bool2;
    if (!bool2)
    {
      bool1 = bool2;
      if (this.eyz != null)
      {
        b localb = this.eyz;
        if (localb == null) {
          j.ebi();
        }
        bool1 = ((Boolean)localb.S(Integer.valueOf(i))).booleanValue();
      }
    }
    if ((!bool1) && (getPaddingBottom() != i)) {
      post((Runnable)new a(this, i));
    }
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    AppMethodBeat.o(63322);
  }
  
  public final void setInsectCallback(b<? super Integer, Boolean> paramb)
  {
    this.eyz = paramb;
  }
  
  @l(eaO={1, 1, 13}, eaP={""}, eaQ={"<anonymous>", "", "run"})
  static final class a
    implements Runnable
  {
    a(InsectRelativeLayout paramInsectRelativeLayout, int paramInt) {}
    
    public final void run()
    {
      AppMethodBeat.i(63321);
      this.eyC.setPadding(this.eyC.getPaddingLeft(), this.eyC.getPaddingTop(), this.eyC.getPaddingRight(), i);
      this.eyC.requestLayout();
      AppMethodBeat.o(63321);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.emoji.view.InsectRelativeLayout
 * JD-Core Version:    0.7.0.1
 */