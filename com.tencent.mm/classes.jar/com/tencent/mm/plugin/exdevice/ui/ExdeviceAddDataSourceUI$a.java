package com.tencent.mm.plugin.exdevice.ui;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.R.g;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.as.a.a;
import com.tencent.mm.as.a.a.c;
import com.tencent.mm.as.a.a.c.a;
import com.tencent.mm.as.o;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

final class ExdeviceAddDataSourceUI$a
  extends BaseAdapter
{
  private c jAJ;
  private List<ExdeviceAddDataSourceUI.b> jAv = new LinkedList();
  
  public ExdeviceAddDataSourceUI$a()
  {
    c.a locala = new c.a();
    locala.eru = R.g.exdevice_wechat_sport_default_icon;
    this.jAJ = locala.OV();
  }
  
  public final ExdeviceAddDataSourceUI.b BL(String paramString)
  {
    if (!bk.bl(paramString))
    {
      Iterator localIterator = this.jAv.iterator();
      while (localIterator.hasNext())
      {
        ExdeviceAddDataSourceUI.b localb = (ExdeviceAddDataSourceUI.b)localIterator.next();
        if (paramString.equalsIgnoreCase(localb.mac)) {
          return localb;
        }
      }
    }
    return null;
  }
  
  public final void bc(List<ExdeviceAddDataSourceUI.b> paramList)
  {
    this.jAv.clear();
    if ((paramList == null) || (paramList.size() == 0)) {
      return;
    }
    this.jAv.addAll(paramList);
  }
  
  public final int getCount()
  {
    return this.jAv.size();
  }
  
  public final long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    ExdeviceAddDataSourceUI.b localb = qs(paramInt);
    View localView;
    if (paramView == null)
    {
      paramView = new ExdeviceAddDataSourceUI.a.a((byte)0);
      localView = View.inflate(paramViewGroup.getContext(), R.i.exdevice_add_data_source_item, null);
      paramView.gSx = ((ImageView)localView.findViewById(R.h.iconIV));
      paramView.fhD = ((TextView)localView.findViewById(R.h.nameTV));
      localView.setTag(paramView);
      paramViewGroup = paramView;
    }
    for (;;)
    {
      y.d("MicroMsg.ExdeviceAddDataSourceUI", "position(%s), name(%s), mac(%s).", new Object[] { Integer.valueOf(paramInt), localb.name, localb.mac });
      paramViewGroup.fhD.setText(localb.name);
      o.ON().a(localb.iconUrl, paramViewGroup.gSx, this.jAJ);
      return localView;
      paramViewGroup = (ExdeviceAddDataSourceUI.a.a)paramView.getTag();
      localView = paramView;
    }
  }
  
  public final ExdeviceAddDataSourceUI.b qs(int paramInt)
  {
    return (ExdeviceAddDataSourceUI.b)this.jAv.get(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.ui.ExdeviceAddDataSourceUI.a
 * JD-Core Version:    0.7.0.1
 */