package android.support.v7.widget;

import android.database.Cursor;
import android.support.v4.widget.f;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;

final class SearchView$10
  implements AdapterView.OnItemSelectedListener
{
  SearchView$10(SearchView paramSearchView) {}
  
  public final void onItemSelected(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    paramAdapterView = this.auD;
    if ((paramAdapterView.auf == null) || (!paramAdapterView.auf.ma()))
    {
      paramView = paramAdapterView.atH.getText();
      Object localObject = paramAdapterView.auj.getCursor();
      if (localObject != null)
      {
        if (!((Cursor)localObject).moveToPosition(paramInt)) {
          break label86;
        }
        localObject = paramAdapterView.auj.convertToString((Cursor)localObject);
        if (localObject == null) {
          break label80;
        }
        paramAdapterView.setQuery((CharSequence)localObject);
      }
    }
    return;
    label80:
    paramAdapterView.setQuery(paramView);
    return;
    label86:
    paramAdapterView.setQuery(paramView);
  }
  
  public final void onNothingSelected(AdapterView<?> paramAdapterView) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     android.support.v7.widget.SearchView.10
 * JD-Core Version:    0.7.0.1
 */