package com.tencent.mm.plugin.location.ui;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.s;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.ui.base.j;
import com.tencent.mm.ui.base.j.a;
import java.util.ArrayList;
import java.util.Iterator;

public final class a
  extends j
{
  private int obJ;
  private ArrayList<String> obK;
  
  public a()
  {
    AppMethodBeat.i(113418);
    this.obJ = 8;
    this.obK = new ArrayList();
    AppMethodBeat.o(113418);
  }
  
  public final void F(ArrayList<String> paramArrayList)
  {
    AppMethodBeat.i(113419);
    this.obK.clear();
    paramArrayList = paramArrayList.iterator();
    while (paramArrayList.hasNext())
    {
      String str = (String)paramArrayList.next();
      this.obK.add(str);
    }
    if (this.zke == null) {}
    for (boolean bool = true;; bool = false)
    {
      ab.i("MicroMsg.MMGridPaperAdapter", "notifyDataSetChange, notifier is null ? %B", new Object[] { Boolean.valueOf(bool) });
      if (this.zke != null) {
        break;
      }
      AppMethodBeat.o(113419);
      return;
    }
    this.zke.aWN();
    AppMethodBeat.o(113419);
  }
  
  public final View d(int paramInt, View paramView)
  {
    AppMethodBeat.i(113421);
    a locala = new a();
    if (paramView == null)
    {
      paramView = View.inflate(ah.getContext(), 2130968796, null);
      locala.gxs = ((ImageView)paramView.findViewById(2131821593));
      locala.obL = ((TextView)paramView.findViewById(2131821594));
      paramView.setTag(locala);
    }
    for (;;)
    {
      Object localObject = (String)this.obK.get(paramInt);
      a.b.c(locala.gxs, (String)localObject);
      String str = s.nE((String)localObject);
      localObject = str;
      if (str.length() > this.obJ) {
        localObject = str.subSequence(0, this.obJ + 1) + "...";
      }
      locala.obL.setText((CharSequence)localObject);
      AppMethodBeat.o(113421);
      return paramView;
      locala = (a)paramView.getTag();
    }
  }
  
  public final int getCount()
  {
    AppMethodBeat.i(113420);
    int i = this.obK.size();
    AppMethodBeat.o(113420);
    return i;
  }
  
  public final Object getItem(int paramInt)
  {
    AppMethodBeat.i(113422);
    Object localObject = this.obK.get(paramInt);
    AppMethodBeat.o(113422);
    return localObject;
  }
  
  public final long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  final class a
  {
    ImageView gxs;
    TextView obL;
    
    a() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.location.ui.a
 * JD-Core Version:    0.7.0.1
 */