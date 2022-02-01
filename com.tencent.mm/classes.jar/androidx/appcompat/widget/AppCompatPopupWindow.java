package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.view.View;
import android.widget.PopupWindow;
import androidx.appcompat.a.j;
import androidx.core.widget.h;
import com.tencent.matrix.trace.core.AppMethodBeat;

class AppCompatPopupWindow
  extends PopupWindow
{
  private static final boolean rQ;
  private boolean rR;
  
  static
  {
    if (Build.VERSION.SDK_INT < 21) {}
    for (boolean bool = true;; bool = false)
    {
      rQ = bool;
      return;
    }
  }
  
  public AppCompatPopupWindow(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(199687);
    a(paramContext, paramAttributeSet, paramInt, 0);
    AppMethodBeat.o(199687);
  }
  
  public AppCompatPopupWindow(Context paramContext, AttributeSet paramAttributeSet, int paramInt1, int paramInt2)
  {
    super(paramContext, paramAttributeSet, paramInt1, paramInt2);
    AppMethodBeat.i(199701);
    a(paramContext, paramAttributeSet, paramInt1, paramInt2);
    AppMethodBeat.o(199701);
  }
  
  private void S(boolean paramBoolean)
  {
    AppMethodBeat.i(199725);
    if (rQ)
    {
      this.rR = paramBoolean;
      AppMethodBeat.o(199725);
      return;
    }
    h.a(this, paramBoolean);
    AppMethodBeat.o(199725);
  }
  
  private void a(Context paramContext, AttributeSet paramAttributeSet, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(199714);
    paramContext = ac.a(paramContext, paramAttributeSet, a.j.PopupWindow, paramInt1, paramInt2);
    if (paramContext.az(a.j.PopupWindow_overlapAnchor)) {
      S(paramContext.m(a.j.PopupWindow_overlapAnchor, false));
    }
    setBackgroundDrawable(paramContext.getDrawable(a.j.PopupWindow_android_popupBackground));
    paramContext.xv.recycle();
    AppMethodBeat.o(199714);
  }
  
  public void showAsDropDown(View paramView, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(199744);
    int i = paramInt2;
    if (rQ)
    {
      i = paramInt2;
      if (this.rR) {
        i = paramInt2 - paramView.getHeight();
      }
    }
    super.showAsDropDown(paramView, paramInt1, i);
    AppMethodBeat.o(199744);
  }
  
  public void showAsDropDown(View paramView, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(199758);
    int i = paramInt2;
    if (rQ)
    {
      i = paramInt2;
      if (this.rR) {
        i = paramInt2 - paramView.getHeight();
      }
    }
    super.showAsDropDown(paramView, paramInt1, i, paramInt3);
    AppMethodBeat.o(199758);
  }
  
  public void update(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(199772);
    if ((rQ) && (this.rR)) {
      paramInt2 -= paramView.getHeight();
    }
    for (;;)
    {
      super.update(paramView, paramInt1, paramInt2, paramInt3, paramInt4);
      AppMethodBeat.o(199772);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     androidx.appcompat.widget.AppCompatPopupWindow
 * JD-Core Version:    0.7.0.1
 */