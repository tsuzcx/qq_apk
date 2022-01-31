package com.tencent.mm.plugin.account.ui;

import android.widget.Filter;
import android.widget.Filter.FilterResults;
import java.util.ArrayList;
import java.util.List;

final class c$a
  extends Filter
{
  private c$a(c paramc) {}
  
  protected final Filter.FilterResults performFiltering(CharSequence arg1)
  {
    int i = 0;
    Filter.FilterResults localFilterResults = new Filter.FilterResults();
    if (c.a(this.fla) == null) {}
    synchronized (c.b(this.fla))
    {
      c.a(this.fla, new ArrayList(c.c(this.fla)));
      if (??? != null) {
        if (???.length() != 0) {
          break label132;
        }
      }
    }
    synchronized (c.b(this.fla))
    {
      ??? = new ArrayList(c.a(this.fla));
      localFilterResults.values = ???;
      localFilterResults.count = ((ArrayList)???).size();
      return localFilterResults;
      ??? = finally;
      throw ???;
    }
    label132:
    ??? = ???.toString().toLowerCase();
    String str1 = "";
    Object localObject3;
    if ((c.d(this.fla) != null) && (c.d(this.fla).length() > 0))
    {
      localObject3 = ???.split(c.d(this.fla));
      if ((localObject3 != null) && (localObject3.length > 1))
      {
        str1 = localObject3[0] + c.d(this.fla);
        ??? = localObject3[1];
      }
    }
    for (;;)
    {
      localObject3 = c.a(this.fla);
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
      return localFilterResults;
    }
  }
  
  protected final void publishResults(CharSequence paramCharSequence, Filter.FilterResults paramFilterResults)
  {
    c.a(this.fla, (List)paramFilterResults.values);
    if (paramFilterResults.count > 0)
    {
      this.fla.notifyDataSetChanged();
      return;
    }
    this.fla.notifyDataSetInvalidated();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.c.a
 * JD-Core Version:    0.7.0.1
 */