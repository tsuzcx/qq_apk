package androidx.c.a;

import android.database.Cursor;
import android.widget.Filter;
import android.widget.Filter.FilterResults;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class b
  extends Filter
{
  a QX;
  
  b(a parama)
  {
    this.QX = parama;
  }
  
  public final CharSequence convertResultToString(Object paramObject)
  {
    AppMethodBeat.i(218402);
    paramObject = this.QX.d((Cursor)paramObject);
    AppMethodBeat.o(218402);
    return paramObject;
  }
  
  protected final Filter.FilterResults performFiltering(CharSequence paramCharSequence)
  {
    AppMethodBeat.i(218404);
    paramCharSequence = this.QX.g(paramCharSequence);
    Filter.FilterResults localFilterResults = new Filter.FilterResults();
    if (paramCharSequence != null) {
      localFilterResults.count = paramCharSequence.getCount();
    }
    for (localFilterResults.values = paramCharSequence;; localFilterResults.values = null)
    {
      AppMethodBeat.o(218404);
      return localFilterResults;
      localFilterResults.count = 0;
    }
  }
  
  protected final void publishResults(CharSequence paramCharSequence, Filter.FilterResults paramFilterResults)
  {
    AppMethodBeat.i(218405);
    paramCharSequence = this.QX.hK();
    if ((paramFilterResults.values != null) && (paramFilterResults.values != paramCharSequence)) {
      this.QX.c((Cursor)paramFilterResults.values);
    }
    AppMethodBeat.o(218405);
  }
  
  static abstract interface a
  {
    public abstract void c(Cursor paramCursor);
    
    public abstract CharSequence d(Cursor paramCursor);
    
    public abstract Cursor g(CharSequence paramCharSequence);
    
    public abstract Cursor hK();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     androidx.c.a.b
 * JD-Core Version:    0.7.0.1
 */