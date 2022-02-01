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
  private boolean akW;
  private boolean akX;
  
  public AutoFillListPopupWindowBase$a(Context paramContext, boolean paramBoolean)
  {
    super(paramContext, null, 2130968938);
    AppMethodBeat.i(136649);
    this.akX = paramBoolean;
    setCacheColorHint(0);
    AppMethodBeat.o(136649);
  }
  
  final int ew(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(136654);
    int i = getListPaddingTop();
    int k = getListPaddingBottom();
    getListPaddingLeft();
    getListPaddingRight();
    int j = getDividerHeight();
    Object localObject = getDivider();
    ListAdapter localListAdapter = getAdapter();
    if (localListAdapter == null)
    {
      AppMethodBeat.o(136654);
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
        AppMethodBeat.o(136654);
        return paramInt2;
        j = 0;
        break;
        n = View.MeasureSpec.makeMeasureSpec(0, 0);
        break label166;
      }
      k += 1;
      n = m;
      break label92;
      AppMethodBeat.o(136654);
      return i;
    }
  }
  
  public final boolean hasFocus()
  {
    AppMethodBeat.i(136653);
    if ((this.akX) || (super.hasFocus()))
    {
      AppMethodBeat.o(136653);
      return true;
    }
    AppMethodBeat.o(136653);
    return false;
  }
  
  public final boolean hasWindowFocus()
  {
    AppMethodBeat.i(136651);
    if ((this.akX) || (super.hasWindowFocus()))
    {
      AppMethodBeat.o(136651);
      return true;
    }
    AppMethodBeat.o(136651);
    return false;
  }
  
  public final boolean isFocused()
  {
    AppMethodBeat.i(136652);
    if ((this.akX) || (super.isFocused()))
    {
      AppMethodBeat.o(136652);
      return true;
    }
    AppMethodBeat.o(136652);
    return false;
  }
  
  public final boolean isInTouchMode()
  {
    AppMethodBeat.i(136650);
    if (((this.akX) && (this.akW)) || (super.isInTouchMode()))
    {
      AppMethodBeat.o(136650);
      return true;
    }
    AppMethodBeat.o(136650);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.input.autofill.AutoFillListPopupWindowBase.a
 * JD-Core Version:    0.7.0.1
 */