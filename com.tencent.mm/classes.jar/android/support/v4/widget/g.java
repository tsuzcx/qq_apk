package android.support.v4.widget;

import android.database.Cursor;
import android.widget.Filter;
import android.widget.Filter.FilterResults;

final class g
  extends Filter
{
  g.a Jz;
  
  g(g.a parama)
  {
    this.Jz = parama;
  }
  
  public final CharSequence convertResultToString(Object paramObject)
  {
    return this.Jz.convertToString((Cursor)paramObject);
  }
  
  protected final Filter.FilterResults performFiltering(CharSequence paramCharSequence)
  {
    paramCharSequence = this.Jz.runQueryOnBackgroundThread(paramCharSequence);
    Filter.FilterResults localFilterResults = new Filter.FilterResults();
    if (paramCharSequence != null)
    {
      localFilterResults.count = paramCharSequence.getCount();
      localFilterResults.values = paramCharSequence;
      return localFilterResults;
    }
    localFilterResults.count = 0;
    localFilterResults.values = null;
    return localFilterResults;
  }
  
  protected final void publishResults(CharSequence paramCharSequence, Filter.FilterResults paramFilterResults)
  {
    paramCharSequence = this.Jz.getCursor();
    if ((paramFilterResults.values != null) && (paramFilterResults.values != paramCharSequence)) {
      this.Jz.changeCursor((Cursor)paramFilterResults.values);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     android.support.v4.widget.g
 * JD-Core Version:    0.7.0.1
 */