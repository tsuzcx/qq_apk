package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.view.View;
import android.widget.PopupWindow;
import androidx.appcompat.a.j;
import androidx.core.widget.g;
import com.tencent.matrix.trace.core.AppMethodBeat;

class AppCompatPopupWindow
  extends PopupWindow
{
  private static final boolean qT;
  private boolean qU;
  
  static
  {
    if (Build.VERSION.SDK_INT < 21) {}
    for (boolean bool = true;; bool = false)
    {
      qT = bool;
      return;
    }
  }
  
  public AppCompatPopupWindow(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(240919);
    a(paramContext, paramAttributeSet, paramInt, 0);
    AppMethodBeat.o(240919);
  }
  
  public AppCompatPopupWindow(Context paramContext, AttributeSet paramAttributeSet, int paramInt1, int paramInt2)
  {
    super(paramContext, paramAttributeSet, paramInt1, paramInt2);
    AppMethodBeat.i(240921);
    a(paramContext, paramAttributeSet, paramInt1, paramInt2);
    AppMethodBeat.o(240921);
  }
  
  private void O(boolean paramBoolean)
  {
    AppMethodBeat.i(240928);
    if (qT)
    {
      this.qU = paramBoolean;
      AppMethodBeat.o(240928);
      return;
    }
    g.a(this, paramBoolean);
    AppMethodBeat.o(240928);
  }
  
  private void a(Context paramContext, AttributeSet paramAttributeSet, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(240923);
    paramContext = ac.a(paramContext, paramAttributeSet, a.j.PopupWindow, paramInt1, paramInt2);
    if (paramContext.aC(a.j.PopupWindow_overlapAnchor)) {
      O(paramContext.c(a.j.PopupWindow_overlapAnchor, false));
    }
    setBackgroundDrawable(paramContext.getDrawable(a.j.PopupWindow_android_popupBackground));
    paramContext.wA.recycle();
    AppMethodBeat.o(240923);
  }
  
  public void showAsDropDown(View paramView, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(240924);
    int i = paramInt2;
    if (qT)
    {
      i = paramInt2;
      if (this.qU) {
        i = paramInt2 - paramView.getHeight();
      }
    }
    super.showAsDropDown(paramView, paramInt1, i);
    AppMethodBeat.o(240924);
  }
  
  public void showAsDropDown(View paramView, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(240926);
    int i = paramInt2;
    if (qT)
    {
      i = paramInt2;
      if (this.qU) {
        i = paramInt2 - paramView.getHeight();
      }
    }
    super.showAsDropDown(paramView, paramInt1, i, paramInt3);
    AppMethodBeat.o(240926);
  }
  
  public void update(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(240927);
    if ((qT) && (this.qU)) {
      paramInt2 -= paramView.getHeight();
    }
    for (;;)
    {
      super.update(paramView, paramInt1, paramInt2, paramInt3, paramInt4);
      AppMethodBeat.o(240927);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     androidx.appcompat.widget.AppCompatPopupWindow
 * JD-Core Version:    0.7.0.1
 */