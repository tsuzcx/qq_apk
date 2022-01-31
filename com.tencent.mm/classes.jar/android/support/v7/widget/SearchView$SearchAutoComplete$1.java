package android.support.v7.widget;

import android.content.Context;
import android.view.inputmethod.InputMethodManager;

final class SearchView$SearchAutoComplete$1
  implements Runnable
{
  SearchView$SearchAutoComplete$1(SearchView.SearchAutoComplete paramSearchAutoComplete) {}
  
  public final void run()
  {
    SearchView.SearchAutoComplete localSearchAutoComplete = this.amr;
    if (localSearchAutoComplete.amp)
    {
      ((InputMethodManager)localSearchAutoComplete.getContext().getSystemService("input_method")).showSoftInput(localSearchAutoComplete, 0);
      localSearchAutoComplete.amp = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     android.support.v7.widget.SearchView.SearchAutoComplete.1
 * JD-Core Version:    0.7.0.1
 */