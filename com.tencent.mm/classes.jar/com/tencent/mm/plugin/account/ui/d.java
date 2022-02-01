package com.tencent.mm.plugin.account.ui;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Filter;
import android.widget.Filter.FilterResults;
import android.widget.Filterable;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public final class d
  extends BaseAdapter
  implements Filterable
{
  private Context mContext;
  private final Object mLock;
  private List<String> pYV;
  private ArrayList<String> pYW;
  private a pYX;
  private String pYY;
  
  public d(Context paramContext, String[] paramArrayOfString, String paramString)
  {
    AppMethodBeat.i(127871);
    this.mLock = new Object();
    this.mContext = paramContext;
    this.pYV = Arrays.asList(paramArrayOfString);
    this.pYY = paramString;
    AppMethodBeat.o(127871);
  }
  
  private String getItem(int paramInt)
  {
    AppMethodBeat.i(127873);
    String str = (String)this.pYV.get(paramInt);
    AppMethodBeat.o(127873);
    return str;
  }
  
  public final int getCount()
  {
    AppMethodBeat.i(127872);
    int i = this.pYV.size();
    AppMethodBeat.o(127872);
    return i;
  }
  
  public final Filter getFilter()
  {
    AppMethodBeat.i(127875);
    if (this.pYX == null) {
      this.pYX = new a((byte)0);
    }
    a locala = this.pYX;
    AppMethodBeat.o(127875);
    return locala;
  }
  
  public final long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(127874);
    if (paramView == null)
    {
      paramView = View.inflate(this.mContext, r.g.auto_complete_dropdown_item, null);
      paramViewGroup = new b();
      paramViewGroup.dyR = ((TextView)paramView.findViewById(r.f.textview1));
      paramView.setTag(paramViewGroup);
    }
    for (;;)
    {
      String str = getItem(paramInt);
      paramViewGroup.dyR.setText(str);
      paramView.setBackgroundResource(r.e.comm_list_item_selector);
      AppMethodBeat.o(127874);
      return paramView;
      paramViewGroup = (b)paramView.getTag();
    }
  }
  
  final class a
    extends Filter
  {
    private a() {}
    
    protected final Filter.FilterResults performFiltering(CharSequence arg1)
    {
      int i = 0;
      AppMethodBeat.i(127869);
      Filter.FilterResults localFilterResults = new Filter.FilterResults();
      if (d.a(d.this) == null) {}
      synchronized (d.b(d.this))
      {
        d.a(d.this, new ArrayList(d.c(d.this)));
        if (??? != null) {
          if (???.length() != 0) {
            break label152;
          }
        }
      }
      synchronized (d.b(d.this))
      {
        ??? = new ArrayList(d.a(d.this));
        localFilterResults.values = ???;
        localFilterResults.count = ((ArrayList)???).size();
        AppMethodBeat.o(127869);
        return localFilterResults;
        ??? = finally;
        AppMethodBeat.o(127869);
        throw ???;
      }
      label152:
      ??? = ???.toString().toLowerCase();
      String str1 = "";
      Object localObject3;
      if ((d.d(d.this) != null) && (d.d(d.this).length() > 0))
      {
        localObject3 = ???.split(d.d(d.this));
        if ((localObject3 != null) && (localObject3.length > 1))
        {
          str1 = localObject3[0] + d.d(d.this);
          ??? = localObject3[1];
        }
      }
      for (;;)
      {
        localObject3 = d.a(d.this);
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
      AppMethodBeat.i(127870);
      d.a(d.this, (List)paramFilterResults.values);
      if (paramFilterResults.count > 0)
      {
        d.this.notifyDataSetChanged();
        AppMethodBeat.o(127870);
        return;
      }
      d.this.notifyDataSetInvalidated();
      AppMethodBeat.o(127870);
    }
  }
  
  static final class b
  {
    public TextView dyR;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.d
 * JD-Core Version:    0.7.0.1
 */