package com.tencent.mm.plugin.location.ui;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.aa;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.ui.base.j;
import com.tencent.mm.ui.base.j.a;
import java.util.ArrayList;
import java.util.Iterator;

public final class a
  extends j
{
  private int yHh;
  private ArrayList<String> yHi;
  
  public a()
  {
    AppMethodBeat.i(55794);
    this.yHh = 8;
    this.yHi = new ArrayList();
    AppMethodBeat.o(55794);
  }
  
  public final View e(int paramInt, View paramView)
  {
    AppMethodBeat.i(55797);
    a locala = new a();
    if (paramView == null)
    {
      paramView = View.inflate(MMApplicationContext.getContext(), 2131493168, null);
      locala.keC = ((ImageView)paramView.findViewById(2131297132));
      locala.yHj = ((TextView)paramView.findViewById(2131309651));
      paramView.setTag(locala);
    }
    for (;;)
    {
      Object localObject = (String)this.yHi.get(paramInt);
      a.b.c(locala.keC, (String)localObject);
      String str = aa.getDisplayName((String)localObject);
      localObject = str;
      if (str.length() > this.yHh) {
        localObject = str.subSequence(0, this.yHh + 1) + "...";
      }
      locala.yHj.setText((CharSequence)localObject);
      AppMethodBeat.o(55797);
      return paramView;
      locala = (a)paramView.getTag();
    }
  }
  
  public final int getCount()
  {
    AppMethodBeat.i(55796);
    int i = this.yHi.size();
    AppMethodBeat.o(55796);
    return i;
  }
  
  public final Object getItem(int paramInt)
  {
    AppMethodBeat.i(55798);
    Object localObject = this.yHi.get(paramInt);
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
    this.yHi.clear();
    paramArrayList = paramArrayList.iterator();
    while (paramArrayList.hasNext())
    {
      String str = (String)paramArrayList.next();
      this.yHi.add(str);
    }
    if (this.OQN == null) {}
    for (boolean bool = true;; bool = false)
    {
      Log.i("MicroMsg.MMGridPaperAdapter", "notifyDataSetChange, notifier is null ? %B", new Object[] { Boolean.valueOf(bool) });
      if (this.OQN != null) {
        break;
      }
      AppMethodBeat.o(55795);
      return;
    }
    this.OQN.cmy();
    AppMethodBeat.o(55795);
  }
  
  final class a
  {
    ImageView keC;
    TextView yHj;
    
    a() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.location.ui.a
 * JD-Core Version:    0.7.0.1
 */