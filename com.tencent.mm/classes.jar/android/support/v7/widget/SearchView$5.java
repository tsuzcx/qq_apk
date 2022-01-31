package android.support.v7.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.support.v7.a.a.d;
import android.view.View;
import android.view.View.OnLayoutChangeListener;

final class SearchView$5
  implements View.OnLayoutChangeListener
{
  SearchView$5(SearchView paramSearchView) {}
  
  public final void onLayoutChange(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8)
  {
    paramView = this.ajT;
    Rect localRect;
    if (paramView.ajf.getWidth() > 1)
    {
      Resources localResources = paramView.getContext().getResources();
      paramInt3 = paramView.aiZ.getPaddingLeft();
      localRect = new Rect();
      boolean bool = bf.bF(paramView);
      if (!paramView.ajx) {
        break label151;
      }
      paramInt1 = localResources.getDimensionPixelSize(a.d.abc_dropdownitem_icon_width);
      paramInt1 = localResources.getDimensionPixelSize(a.d.abc_dropdownitem_text_padding_left) + paramInt1;
      paramView.aiX.getDropDownBackground().getPadding(localRect);
      if (!bool) {
        break label156;
      }
    }
    label151:
    label156:
    for (paramInt2 = -localRect.left;; paramInt2 = paramInt3 - (localRect.left + paramInt1))
    {
      paramView.aiX.setDropDownHorizontalOffset(paramInt2);
      paramInt2 = paramView.ajf.getWidth();
      paramInt4 = localRect.left;
      paramInt5 = localRect.right;
      paramView.aiX.setDropDownWidth(paramInt1 + (paramInt2 + paramInt4 + paramInt5) - paramInt3);
      return;
      paramInt1 = 0;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     android.support.v7.widget.SearchView.5
 * JD-Core Version:    0.7.0.1
 */