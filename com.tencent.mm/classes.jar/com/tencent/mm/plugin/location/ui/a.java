package com.tencent.mm.plugin.location.ui;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.aa;
import com.tencent.mm.plugin.map.a.e;
import com.tencent.mm.plugin.map.a.f;
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
  private int Elb;
  private ArrayList<String> Elc;
  
  public a()
  {
    AppMethodBeat.i(55794);
    this.Elb = 8;
    this.Elc = new ArrayList();
    AppMethodBeat.o(55794);
  }
  
  public final View e(int paramInt, View paramView)
  {
    AppMethodBeat.i(55797);
    a locala = new a();
    if (paramView == null)
    {
      paramView = View.inflate(MMApplicationContext.getContext(), a.f.avatar_dialog_item, null);
      locala.mWb = ((ImageView)paramView.findViewById(a.e.avatar_img));
      locala.Eld = ((TextView)paramView.findViewById(a.e.username));
      paramView.setTag(locala);
    }
    for (;;)
    {
      Object localObject = (String)this.Elc.get(paramInt);
      a.b.c(locala.mWb, (String)localObject);
      String str = aa.PJ((String)localObject);
      localObject = str;
      if (str.length() > this.Elb) {
        localObject = str.subSequence(0, this.Elb + 1) + "...";
      }
      locala.Eld.setText((CharSequence)localObject);
      AppMethodBeat.o(55797);
      return paramView;
      locala = (a)paramView.getTag();
    }
  }
  
  public final int getCount()
  {
    AppMethodBeat.i(55796);
    int i = this.Elc.size();
    AppMethodBeat.o(55796);
    return i;
  }
  
  public final Object getItem(int paramInt)
  {
    AppMethodBeat.i(55798);
    Object localObject = this.Elc.get(paramInt);
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
    this.Elc.clear();
    paramArrayList = paramArrayList.iterator();
    while (paramArrayList.hasNext())
    {
      String str = (String)paramArrayList.next();
      this.Elc.add(str);
    }
    if (this.WjU == null) {}
    for (boolean bool = true;; bool = false)
    {
      Log.i("MicroMsg.MMGridPaperAdapter", "notifyDataSetChange, notifier is null ? %B", new Object[] { Boolean.valueOf(bool) });
      if (this.WjU != null) {
        this.WjU.cAe();
      }
      AppMethodBeat.o(55795);
      return;
    }
  }
  
  final class a
  {
    TextView Eld;
    ImageView mWb;
    
    a() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.location.ui.a
 * JD-Core Version:    0.7.0.1
 */