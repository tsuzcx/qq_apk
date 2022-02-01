package androidx.d.a;

import android.database.Cursor;
import android.widget.Filter;
import android.widget.Filter.FilterResults;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class b
  extends Filter
{
  a bxo;
  
  b(a parama)
  {
    this.bxo = parama;
  }
  
  public final CharSequence convertResultToString(Object paramObject)
  {
    AppMethodBeat.i(192830);
    paramObject = this.bxo.d((Cursor)paramObject);
    AppMethodBeat.o(192830);
    return paramObject;
  }
  
  protected final Filter.FilterResults performFiltering(CharSequence paramCharSequence)
  {
    AppMethodBeat.i(192837);
    paramCharSequence = this.bxo.g(paramCharSequence);
    Filter.FilterResults localFilterResults = new Filter.FilterResults();
    if (paramCharSequence != null) {
      localFilterResults.count = paramCharSequence.getCount();
    }
    for (localFilterResults.values = paramCharSequence;; localFilterResults.values = null)
    {
      AppMethodBeat.o(192837);
      return localFilterResults;
      localFilterResults.count = 0;
    }
  }
  
  protected final void publishResults(CharSequence paramCharSequence, Filter.FilterResults paramFilterResults)
  {
    AppMethodBeat.i(192845);
    paramCharSequence = this.bxo.Fv();
    if ((paramFilterResults.values != null) && (paramFilterResults.values != paramCharSequence)) {
      this.bxo.c((Cursor)paramFilterResults.values);
    }
    AppMethodBeat.o(192845);
  }
  
  static abstract interface a
  {
    public abstract Cursor Fv();
    
    public abstract void c(Cursor paramCursor);
    
    public abstract CharSequence d(Cursor paramCursor);
    
    public abstract Cursor g(CharSequence paramCharSequence);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     androidx.d.a.b
 * JD-Core Version:    0.7.0.1
 */