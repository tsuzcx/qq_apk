package com.tencent.mm.plugin.location.ui;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.v;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.ui.base.j;
import com.tencent.mm.ui.base.j.a;
import java.util.ArrayList;
import java.util.Iterator;

public final class a
  extends j
{
  private int sQj;
  private ArrayList<String> sQk;
  
  public a()
  {
    AppMethodBeat.i(55794);
    this.sQj = 8;
    this.sQk = new ArrayList();
    AppMethodBeat.o(55794);
  }
  
  public final View e(int paramInt, View paramView)
  {
    AppMethodBeat.i(55797);
    a locala = new a();
    if (paramView == null)
    {
      paramView = View.inflate(aj.getContext(), 2131493125, null);
      locala.ikp = ((ImageView)paramView.findViewById(2131297006));
      locala.sQl = ((TextView)paramView.findViewById(2131306252));
      paramView.setTag(locala);
    }
    for (;;)
    {
      Object localObject = (String)this.sQk.get(paramInt);
      a.b.c(locala.ikp, (String)localObject);
      String str = v.sh((String)localObject);
      localObject = str;
      if (str.length() > this.sQj) {
        localObject = str.subSequence(0, this.sQj + 1) + "...";
      }
      locala.sQl.setText((CharSequence)localObject);
      AppMethodBeat.o(55797);
      return paramView;
      locala = (a)paramView.getTag();
    }
  }
  
  public final int getCount()
  {
    AppMethodBeat.i(55796);
    int i = this.sQk.size();
    AppMethodBeat.o(55796);
    return i;
  }
  
  public final Object getItem(int paramInt)
  {
    AppMethodBeat.i(55798);
    Object localObject = this.sQk.get(paramInt);
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
    this.sQk.clear();
    paramArrayList = paramArrayList.iterator();
    while (paramArrayList.hasNext())
    {
      String str = (String)paramArrayList.next();
      this.sQk.add(str);
    }
    if (this.FXC == null) {}
    for (boolean bool = true;; bool = false)
    {
      ad.i("MicroMsg.MMGridPaperAdapter", "notifyDataSetChange, notifier is null ? %B", new Object[] { Boolean.valueOf(bool) });
      if (this.FXC != null) {
        break;
      }
      AppMethodBeat.o(55795);
      return;
    }
    this.FXC.bCM();
    AppMethodBeat.o(55795);
  }
  
  final class a
  {
    ImageView ikp;
    TextView sQl;
    
    a() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.location.ui.a
 * JD-Core Version:    0.7.0.1
 */