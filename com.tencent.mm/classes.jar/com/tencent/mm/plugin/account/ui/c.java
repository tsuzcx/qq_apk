package com.tencent.mm.plugin.account.ui;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public final class c
  extends BaseAdapter
  implements Filterable
{
  private List<String> gCn;
  private ArrayList<String> gCo;
  private c.a gCp;
  private String gCq;
  private Context mContext;
  private final Object mLock;
  
  public c(Context paramContext, String[] paramArrayOfString, String paramString)
  {
    AppMethodBeat.i(124719);
    this.mLock = new Object();
    this.mContext = paramContext;
    this.gCn = Arrays.asList(paramArrayOfString);
    this.gCq = paramString;
    AppMethodBeat.o(124719);
  }
  
  private String getItem(int paramInt)
  {
    AppMethodBeat.i(124721);
    String str = (String)this.gCn.get(paramInt);
    AppMethodBeat.o(124721);
    return str;
  }
  
  public final int getCount()
  {
    AppMethodBeat.i(124720);
    int i = this.gCn.size();
    AppMethodBeat.o(124720);
    return i;
  }
  
  public final Filter getFilter()
  {
    AppMethodBeat.i(124723);
    if (this.gCp == null) {
      this.gCp = new c.a(this, (byte)0);
    }
    c.a locala = this.gCp;
    AppMethodBeat.o(124723);
    return locala;
  }
  
  public final long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(124722);
    if (paramView == null)
    {
      paramView = View.inflate(this.mContext, 2130968794, null);
      paramViewGroup = new c.b();
      paramViewGroup.euY = ((TextView)paramView.findViewById(2131821592));
      paramView.setTag(paramViewGroup);
    }
    for (;;)
    {
      String str = getItem(paramInt);
      paramViewGroup.euY.setText(str);
      paramView.setBackgroundResource(2130838445);
      AppMethodBeat.o(124722);
      return paramView;
      paramViewGroup = (c.b)paramView.getTag();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.c
 * JD-Core Version:    0.7.0.1
 */