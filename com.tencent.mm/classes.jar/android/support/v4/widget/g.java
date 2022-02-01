package android.support.v4.widget;

import android.database.Cursor;
import android.widget.Filter;
import android.widget.Filter.FilterResults;

final class g
  extends Filter
{
  a Tv;
  
  g(a parama)
  {
    this.Tv = parama;
  }
  
  public final CharSequence convertResultToString(Object paramObject)
  {
    return this.Tv.convertToString((Cursor)paramObject);
  }
  
  protected final Filter.FilterResults performFiltering(CharSequence paramCharSequence)
  {
    paramCharSequence = this.Tv.runQueryOnBackgroundThread(paramCharSequence);
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
    paramCharSequence = this.Tv.getCursor();
    if ((paramFilterResults.values != null) && (paramFilterResults.values != paramCharSequence)) {
      this.Tv.changeCursor((Cursor)paramFilterResults.values);
    }
  }
  
  static abstract interface a
  {
    public abstract void changeCursor(Cursor paramCursor);
    
    public abstract CharSequence convertToString(Cursor paramCursor);
    
    public abstract Cursor getCursor();
    
    public abstract Cursor runQueryOnBackgroundThread(CharSequence paramCharSequence);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     android.support.v4.widget.g
 * JD-Core Version:    0.7.0.1
 */