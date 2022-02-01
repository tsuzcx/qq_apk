package com.tencent.mm.plugin.location.ui;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.w;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.ui.base.j;
import com.tencent.mm.ui.base.j.a;
import java.util.ArrayList;
import java.util.Iterator;

public final class a
  extends j
{
  private int vnq;
  private ArrayList<String> vnr;
  
  public a()
  {
    AppMethodBeat.i(55794);
    this.vnq = 8;
    this.vnr = new ArrayList();
    AppMethodBeat.o(55794);
  }
  
  public final View e(int paramInt, View paramView)
  {
    AppMethodBeat.i(55797);
    a locala = new a();
    if (paramView == null)
    {
      paramView = View.inflate(ak.getContext(), 2131493125, null);
      locala.jgy = ((ImageView)paramView.findViewById(2131297006));
      locala.vns = ((TextView)paramView.findViewById(2131306252));
      paramView.setTag(locala);
    }
    for (;;)
    {
      Object localObject = (String)this.vnr.get(paramInt);
      a.b.c(locala.jgy, (String)localObject);
      String str = w.zP((String)localObject);
      localObject = str;
      if (str.length() > this.vnq) {
        localObject = str.subSequence(0, this.vnq + 1) + "...";
      }
      locala.vns.setText((CharSequence)localObject);
      AppMethodBeat.o(55797);
      return paramView;
      locala = (a)paramView.getTag();
    }
  }
  
  public final int getCount()
  {
    AppMethodBeat.i(55796);
    int i = this.vnr.size();
    AppMethodBeat.o(55796);
    return i;
  }
  
  public final Object getItem(int paramInt)
  {
    AppMethodBeat.i(55798);
    Object localObject = this.vnr.get(paramInt);
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
    this.vnr.clear();
    paramArrayList = paramArrayList.iterator();
    while (paramArrayList.hasNext())
    {
      String str = (String)paramArrayList.next();
      this.vnr.add(str);
    }
    if (this.JFV == null) {}
    for (boolean bool = true;; bool = false)
    {
      ae.i("MicroMsg.MMGridPaperAdapter", "notifyDataSetChange, notifier is null ? %B", new Object[] { Boolean.valueOf(bool) });
      if (this.JFV != null) {
        break;
      }
      AppMethodBeat.o(55795);
      return;
    }
    this.JFV.bPl();
    AppMethodBeat.o(55795);
  }
  
  final class a
  {
    ImageView jgy;
    TextView vns;
    
    a() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.location.ui.a
 * JD-Core Version:    0.7.0.1
 */