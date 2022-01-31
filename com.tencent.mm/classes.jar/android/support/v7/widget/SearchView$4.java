package android.support.v7.widget;

import android.view.View;
import android.view.View.OnFocusChangeListener;

final class SearchView$4
  implements View.OnFocusChangeListener
{
  SearchView$4(SearchView paramSearchView) {}
  
  public final void onFocusChange(View paramView, boolean paramBoolean)
  {
    if (this.ajT.aju != null) {
      this.ajT.aju.onFocusChange(this.ajT, paramBoolean);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     android.support.v7.widget.SearchView.4
 * JD-Core Version:    0.7.0.1
 */