package android.support.v7.widget;

import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnKeyListener;

final class SearchView$7
  implements View.OnKeyListener
{
  SearchView$7(SearchView paramSearchView) {}
  
  public final boolean onKey(View paramView, int paramInt, KeyEvent paramKeyEvent)
  {
    if (this.ajT.ajJ == null) {}
    do
    {
      return false;
      if ((this.ajT.aiX.isPopupShowing()) && (this.ajT.aiX.getListSelection() != -1)) {
        return this.ajT.b(paramInt, paramKeyEvent);
      }
    } while ((SearchView.SearchAutoComplete.a(this.ajT.aiX)) || (!paramKeyEvent.hasNoModifiers()) || (paramKeyEvent.getAction() != 1) || (paramInt != 66));
    paramView.cancelLongPress();
    this.ajT.R(this.ajT.aiX.getText().toString());
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     android.support.v7.widget.SearchView.7
 * JD-Core Version:    0.7.0.1
 */