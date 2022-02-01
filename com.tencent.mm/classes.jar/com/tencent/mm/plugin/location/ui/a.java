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
import com.tencent.mm.ui.base.l;
import com.tencent.mm.ui.base.l.a;
import java.util.ArrayList;
import java.util.Iterator;

public final class a
  extends l
{
  private int KdK;
  private ArrayList<String> KdL;
  
  public a()
  {
    AppMethodBeat.i(55794);
    this.KdK = 8;
    this.KdL = new ArrayList();
    AppMethodBeat.o(55794);
  }
  
  public final boolean fUP()
  {
    return false;
  }
  
  public final View g(int paramInt, View paramView)
  {
    AppMethodBeat.i(55797);
    a locala = new a();
    if (paramView == null)
    {
      paramView = View.inflate(MMApplicationContext.getContext(), a.f.avatar_dialog_item, null);
      locala.avatar = ((ImageView)paramView.findViewById(a.e.avatar_img));
      locala.KdM = ((TextView)paramView.findViewById(a.e.username));
      paramView.setTag(locala);
    }
    for (;;)
    {
      Object localObject = (String)this.KdL.get(paramInt);
      a.b.g(locala.avatar, (String)localObject);
      String str = aa.getDisplayName((String)localObject);
      localObject = str;
      if (str.length() > this.KdK) {
        localObject = str.subSequence(0, this.KdK + 1) + "...";
      }
      locala.KdM.setText((CharSequence)localObject);
      AppMethodBeat.o(55797);
      return paramView;
      locala = (a)paramView.getTag();
    }
  }
  
  public final int getCount()
  {
    AppMethodBeat.i(55796);
    int i = this.KdL.size();
    AppMethodBeat.o(55796);
    return i;
  }
  
  public final Object getItem(int paramInt)
  {
    AppMethodBeat.i(55798);
    Object localObject = this.KdL.get(paramInt);
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
    this.KdL.clear();
    paramArrayList = paramArrayList.iterator();
    while (paramArrayList.hasNext())
    {
      String str = (String)paramArrayList.next();
      this.KdL.add(str);
    }
    if (this.adQX == null) {}
    for (boolean bool = true;; bool = false)
    {
      Log.i("MicroMsg.MMGridPaperAdapter", "notifyDataSetChange, notifier is null ? %B", new Object[] { Boolean.valueOf(bool) });
      if (this.adQX != null) {
        this.adQX.dcZ();
      }
      AppMethodBeat.o(55795);
      return;
    }
  }
  
  final class a
  {
    TextView KdM;
    ImageView avatar;
    
    a() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.location.ui.a
 * JD-Core Version:    0.7.0.1
 */