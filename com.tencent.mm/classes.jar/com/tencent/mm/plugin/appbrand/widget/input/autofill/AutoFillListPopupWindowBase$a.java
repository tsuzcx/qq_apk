package com.tencent.mm.plugin.appbrand.widget.input.autofill;

import android.content.Context;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup.LayoutParams;
import android.widget.ListAdapter;
import android.widget.ListView;
import com.tencent.luggage.l.a.a.b;

final class AutoFillListPopupWindowBase$a
  extends ListView
{
  private boolean acj;
  private boolean ack;
  
  public AutoFillListPopupWindowBase$a(Context paramContext, boolean paramBoolean)
  {
    super(paramContext, null, a.b.dropDownListViewStyle);
    this.ack = paramBoolean;
    setCacheColorHint(0);
  }
  
  final int ck(int paramInt1, int paramInt2)
  {
    int i = getListPaddingTop();
    int k = getListPaddingBottom();
    getListPaddingLeft();
    getListPaddingRight();
    int j = getDividerHeight();
    Object localObject = getDivider();
    ListAdapter localListAdapter = getAdapter();
    if (localListAdapter == null)
    {
      i += k;
      return i;
    }
    i = k + i;
    label66:
    int n;
    label84:
    int m;
    if ((j > 0) && (localObject != null))
    {
      int i2 = localListAdapter.getCount();
      k = 0;
      n = 0;
      localObject = null;
      if (k >= i2) {
        break label225;
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
        break label215;
      }
      n = View.MeasureSpec.makeMeasureSpec(n, 1073741824);
      label158:
      ((View)localObject).measure(paramInt1, n);
      if (k <= 0) {
        break label227;
      }
      i += j;
    }
    label215:
    label225:
    label227:
    for (;;)
    {
      n = ((View)localObject).getMeasuredHeight() + i;
      i = paramInt2;
      if (n >= paramInt2) {
        break;
      }
      k += 1;
      i = n;
      n = m;
      break label84;
      j = 0;
      break label66;
      n = View.MeasureSpec.makeMeasureSpec(0, 0);
      break label158;
      return i;
    }
  }
  
  public final boolean hasFocus()
  {
    return (this.ack) || (super.hasFocus());
  }
  
  public final boolean hasWindowFocus()
  {
    return (this.ack) || (super.hasWindowFocus());
  }
  
  public final boolean isFocused()
  {
    return (this.ack) || (super.isFocused());
  }
  
  public final boolean isInTouchMode()
  {
    return ((this.ack) && (this.acj)) || (super.isInTouchMode());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.input.autofill.AutoFillListPopupWindowBase.a
 * JD-Core Version:    0.7.0.1
 */