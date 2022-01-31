package com.tencent.mm.plugin.account.ui;

import android.widget.Filter;
import android.widget.Filter.FilterResults;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.List;

final class c$a
  extends Filter
{
  private c$a(c paramc) {}
  
  protected final Filter.FilterResults performFiltering(CharSequence arg1)
  {
    int i = 0;
    AppMethodBeat.i(124717);
    Filter.FilterResults localFilterResults = new Filter.FilterResults();
    if (c.a(this.gCr) == null) {}
    synchronized (c.b(this.gCr))
    {
      c.a(this.gCr, new ArrayList(c.c(this.gCr)));
      if (??? != null) {
        if (???.length() != 0) {
          break label152;
        }
      }
    }
    synchronized (c.b(this.gCr))
    {
      ??? = new ArrayList(c.a(this.gCr));
      localFilterResults.values = ???;
      localFilterResults.count = ((ArrayList)???).size();
      AppMethodBeat.o(124717);
      return localFilterResults;
      ??? = finally;
      AppMethodBeat.o(124717);
      throw ???;
    }
    label152:
    ??? = ???.toString().toLowerCase();
    String str1 = "";
    Object localObject3;
    if ((c.d(this.gCr) != null) && (c.d(this.gCr).length() > 0))
    {
      localObject3 = ???.split(c.d(this.gCr));
      if ((localObject3 != null) && (localObject3.length > 1))
      {
        str1 = localObject3[0] + c.d(this.gCr);
        ??? = localObject3[1];
      }
    }
    for (;;)
    {
      localObject3 = c.a(this.gCr);
      int j = ((ArrayList)localObject3).size();
      ArrayList localArrayList = new ArrayList(j);
      while (i < j)
      {
        String str2 = (String)((ArrayList)localObject3).get(i);
        if (str2.toString().toLowerCase().startsWith(???)) {
          localArrayList.add(str1 + str2);
        }
        i += 1;
      }
      localFilterResults.values = localArrayList;
      localFilterResults.count = localArrayList.size();
      break;
    }
  }
  
  protected final void publishResults(CharSequence paramCharSequence, Filter.FilterResults paramFilterResults)
  {
    AppMethodBeat.i(124718);
    c.a(this.gCr, (List)paramFilterResults.values);
    if (paramFilterResults.count > 0)
    {
      this.gCr.notifyDataSetChanged();
      AppMethodBeat.o(124718);
      return;
    }
    this.gCr.notifyDataSetInvalidated();
    AppMethodBeat.o(124718);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.c.a
 * JD-Core Version:    0.7.0.1
 */