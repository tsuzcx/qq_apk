package com.tencent.mm.plugin.location.ui;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.model.r;
import com.tencent.mm.plugin.map.a.e;
import com.tencent.mm.plugin.map.a.f;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.base.j;
import com.tencent.mm.ui.base.j.a;
import java.util.ArrayList;
import java.util.Iterator;

public final class a
  extends j
{
  private int lEw = 8;
  private ArrayList<String> lEx = new ArrayList();
  
  public final void E(ArrayList<String> paramArrayList)
  {
    this.lEx.clear();
    paramArrayList = paramArrayList.iterator();
    while (paramArrayList.hasNext())
    {
      String str = (String)paramArrayList.next();
      this.lEx.add(str);
    }
    if (this.uVL == null) {}
    for (boolean bool = true;; bool = false)
    {
      y.i("MicroMsg.MMGridPaperAdapter", "notifyDataSetChange, notifier is null ? %B", new Object[] { Boolean.valueOf(bool) });
      if (this.uVL != null) {
        break;
      }
      return;
    }
    this.uVL.axW();
  }
  
  public final View c(int paramInt, View paramView)
  {
    a locala = new a();
    if (paramView == null)
    {
      paramView = View.inflate(ae.getContext(), a.f.avatar_dialog_item, null);
      locala.ffK = ((ImageView)paramView.findViewById(a.e.avatar_img));
      locala.lEy = ((TextView)paramView.findViewById(a.e.username));
      paramView.setTag(locala);
    }
    for (;;)
    {
      Object localObject = (String)this.lEx.get(paramInt);
      a.b.a(locala.ffK, (String)localObject);
      String str = r.gV((String)localObject);
      localObject = str;
      if (str.length() > this.lEw) {
        localObject = str.subSequence(0, this.lEw + 1) + "...";
      }
      locala.lEy.setText((CharSequence)localObject);
      return paramView;
      locala = (a)paramView.getTag();
    }
  }
  
  public final int getCount()
  {
    return this.lEx.size();
  }
  
  public final Object getItem(int paramInt)
  {
    return this.lEx.get(paramInt);
  }
  
  public final long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  final class a
  {
    ImageView ffK;
    TextView lEy;
    
    a() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.location.ui.a
 * JD-Core Version:    0.7.0.1
 */