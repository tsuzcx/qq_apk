package android.support.v7.widget;

import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnKeyListener;

final class SearchView$7
  implements View.OnKeyListener
{
  SearchView$7(SearchView paramSearchView) {}
  
  public final boolean onKey(View paramView, int paramInt, KeyEvent paramKeyEvent)
  {
    if (this.amj.alZ == null) {}
    for (;;)
    {
      return false;
      if ((this.amj.aln.isPopupShowing()) && (this.amj.aln.getListSelection() != -1)) {
        return this.amj.b(paramInt, paramKeyEvent);
      }
      if (TextUtils.getTrimmedLength(this.amj.aln.getText()) == 0) {}
      for (int i = 1; (i == 0) && (paramKeyEvent.hasNoModifiers()) && (paramKeyEvent.getAction() == 1) && (paramInt == 66); i = 0)
      {
        paramView.cancelLongPress();
        this.amj.T(this.amj.aln.getText().toString());
        return true;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     android.support.v7.widget.SearchView.7
 * JD-Core Version:    0.7.0.1
 */