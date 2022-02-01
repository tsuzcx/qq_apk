package com.tencent.mm.plugin.location.ui;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.v;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.ui.base.j;
import com.tencent.mm.ui.base.j.a;
import java.util.ArrayList;
import java.util.Iterator;

public final class a
  extends j
{
  private int tYw;
  private ArrayList<String> tYx;
  
  public a()
  {
    AppMethodBeat.i(55794);
    this.tYw = 8;
    this.tYx = new ArrayList();
    AppMethodBeat.o(55794);
  }
  
  public final View e(int paramInt, View paramView)
  {
    AppMethodBeat.i(55797);
    a locala = new a();
    if (paramView == null)
    {
      paramView = View.inflate(ai.getContext(), 2131493125, null);
      locala.iKw = ((ImageView)paramView.findViewById(2131297006));
      locala.tYy = ((TextView)paramView.findViewById(2131306252));
      paramView.setTag(locala);
    }
    for (;;)
    {
      Object localObject = (String)this.tYx.get(paramInt);
      a.b.c(locala.iKw, (String)localObject);
      String str = v.wk((String)localObject);
      localObject = str;
      if (str.length() > this.tYw) {
        localObject = str.subSequence(0, this.tYw + 1) + "...";
      }
      locala.tYy.setText((CharSequence)localObject);
      AppMethodBeat.o(55797);
      return paramView;
      locala = (a)paramView.getTag();
    }
  }
  
  public final int getCount()
  {
    AppMethodBeat.i(55796);
    int i = this.tYx.size();
    AppMethodBeat.o(55796);
    return i;
  }
  
  public final Object getItem(int paramInt)
  {
    AppMethodBeat.i(55798);
    Object localObject = this.tYx.get(paramInt);
    AppMethodBeat.o(55798);
    return localObject;
  }
  
  public final long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public final void setData(ArrayList<String> paramArrayList)
  {
    AppMethodBeat.i(55795);
    this.tYx.clear();
    paramArrayList = paramArrayList.iterator();
    while (paramArrayList.hasNext())
    {
      String str = (String)paramArrayList.next();
      this.tYx.add(str);
    }
    if (this.Hxr == null) {}
    for (boolean bool = true;; bool = false)
    {
      ac.i("MicroMsg.MMGridPaperAdapter", "notifyDataSetChange, notifier is null ? %B", new Object[] { Boolean.valueOf(bool) });
      if (this.Hxr != null) {
        break;
      }
      AppMethodBeat.o(55795);
      return;
    }
    this.Hxr.bJU();
    AppMethodBeat.o(55795);
  }
  
  final class a
  {
    ImageView iKw;
    TextView tYy;
    
    a() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.location.ui.a
 * JD-Core Version:    0.7.0.1
 */