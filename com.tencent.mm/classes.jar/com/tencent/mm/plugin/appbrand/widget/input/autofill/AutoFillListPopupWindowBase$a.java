package com.tencent.mm.plugin.appbrand.widget.input.autofill;

import android.content.Context;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup.LayoutParams;
import android.widget.ListAdapter;
import android.widget.ListView;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class AutoFillListPopupWindowBase$a
  extends ListView
{
  private boolean acV;
  private boolean acW;
  
  public AutoFillListPopupWindowBase$a(Context paramContext, boolean paramBoolean)
  {
    super(paramContext, null, 2130772197);
    AppMethodBeat.i(123909);
    this.acW = paramBoolean;
    setCacheColorHint(0);
    AppMethodBeat.o(123909);
  }
  
  final int dy(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(123914);
    int i = getListPaddingTop();
    int k = getListPaddingBottom();
    getListPaddingLeft();
    getListPaddingRight();
    int j = getDividerHeight();
    Object localObject = getDivider();
    ListAdapter localListAdapter = getAdapter();
    if (localListAdapter == null)
    {
      AppMethodBeat.o(123914);
      return i + k;
    }
    i = k + i;
    int n;
    label92:
    int m;
    if ((j > 0) && (localObject != null))
    {
      int i2 = localListAdapter.getCount();
      k = 0;
      n = 0;
      localObject = null;
      if (k >= i2) {
        break label233;
      }
      int i1 = localListAdapter.getItemViewType(k);
      m = n;
      if (i1 != n)
      {
        m = i1;
        localObject = null;
      }
      localObject = localListAdapter.getView(k, (View)localObject, this);
      n = ((View)localObject).getLayoutParams().height;
      if (n <= 0) {
        break label210;
      }
      n = View.MeasureSpec.makeMeasureSpec(n, 1073741824);
      label166:
      ((View)localObject).measure(paramInt1, n);
      if (k <= 0) {
        break label240;
      }
      i += j;
    }
    label210:
    label233:
    label240:
    for (;;)
    {
      i = ((View)localObject).getMeasuredHeight() + i;
      if (i >= paramInt2)
      {
        AppMethodBeat.o(123914);
        return paramInt2;
        j = 0;
        break;
        n = View.MeasureSpec.makeMeasureSpec(0, 0);
        break label166;
      }
      k += 1;
      n = m;
      break label92;
      AppMethodBeat.o(123914);
      return i;
    }
  }
  
  public final boolean hasFocus()
  {
    AppMethodBeat.i(123913);
    if ((this.acW) || (super.hasFocus()))
    {
      AppMethodBeat.o(123913);
      return true;
    }
    AppMethodBeat.o(123913);
    return false;
  }
  
  public final boolean hasWindowFocus()
  {
    AppMethodBeat.i(123911);
    if ((this.acW) || (super.hasWindowFocus()))
    {
      AppMethodBeat.o(123911);
      return true;
    }
    AppMethodBeat.o(123911);
    return false;
  }
  
  public final boolean isFocused()
  {
    AppMethodBeat.i(123912);
    if ((this.acW) || (super.isFocused()))
    {
      AppMethodBeat.o(123912);
      return true;
    }
    AppMethodBeat.o(123912);
    return false;
  }
  
  public final boolean isInTouchMode()
  {
    AppMethodBeat.i(123910);
    if (((this.acW) && (this.acV)) || (super.isInTouchMode()))
    {
      AppMethodBeat.o(123910);
      return true;
    }
    AppMethodBeat.o(123910);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.input.autofill.AutoFillListPopupWindowBase.a
 * JD-Core Version:    0.7.0.1
 */