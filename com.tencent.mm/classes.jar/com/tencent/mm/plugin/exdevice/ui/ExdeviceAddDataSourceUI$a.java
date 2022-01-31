package com.tencent.mm.plugin.exdevice.ui;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.at.a.a;
import com.tencent.mm.at.a.a.c;
import com.tencent.mm.at.a.a.c.a;
import com.tencent.mm.at.o;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

final class ExdeviceAddDataSourceUI$a
  extends BaseAdapter
{
  private List<ExdeviceAddDataSourceUI.b> lJU;
  private c lKi;
  
  public ExdeviceAddDataSourceUI$a()
  {
    AppMethodBeat.i(19788);
    this.lJU = new LinkedList();
    c.a locala = new c.a();
    locala.eNY = 2130838674;
    this.lKi = locala.ahY();
    AppMethodBeat.o(19788);
  }
  
  public final ExdeviceAddDataSourceUI.b LN(String paramString)
  {
    AppMethodBeat.i(19790);
    if (!bo.isNullOrNil(paramString))
    {
      Iterator localIterator = this.lJU.iterator();
      while (localIterator.hasNext())
      {
        ExdeviceAddDataSourceUI.b localb = (ExdeviceAddDataSourceUI.b)localIterator.next();
        if (paramString.equalsIgnoreCase(localb.mac))
        {
          AppMethodBeat.o(19790);
          return localb;
        }
      }
    }
    AppMethodBeat.o(19790);
    return null;
  }
  
  public final void bt(List<ExdeviceAddDataSourceUI.b> paramList)
  {
    AppMethodBeat.i(19789);
    this.lJU.clear();
    if ((paramList == null) || (paramList.size() == 0))
    {
      AppMethodBeat.o(19789);
      return;
    }
    this.lJU.addAll(paramList);
    AppMethodBeat.o(19789);
  }
  
  public final int getCount()
  {
    AppMethodBeat.i(19791);
    int i = this.lJU.size();
    AppMethodBeat.o(19791);
    return i;
  }
  
  public final long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(19793);
    ExdeviceAddDataSourceUI.b localb = uZ(paramInt);
    View localView;
    if (paramView == null)
    {
      paramView = new ExdeviceAddDataSourceUI.a.a((byte)0);
      localView = View.inflate(paramViewGroup.getContext(), 2130969439, null);
      paramView.ivs = ((ImageView)localView.findViewById(2131823740));
      paramView.gzk = ((TextView)localView.findViewById(2131823741));
      localView.setTag(paramView);
      paramViewGroup = paramView;
    }
    for (;;)
    {
      ab.d("MicroMsg.ExdeviceAddDataSourceUI", "position(%s), name(%s), mac(%s).", new Object[] { Integer.valueOf(paramInt), localb.name, localb.mac });
      paramViewGroup.gzk.setText(localb.name);
      o.ahG().a(localb.iconUrl, paramViewGroup.ivs, this.lKi);
      AppMethodBeat.o(19793);
      return localView;
      paramViewGroup = (ExdeviceAddDataSourceUI.a.a)paramView.getTag();
      localView = paramView;
    }
  }
  
  public final ExdeviceAddDataSourceUI.b uZ(int paramInt)
  {
    AppMethodBeat.i(19792);
    ExdeviceAddDataSourceUI.b localb = (ExdeviceAddDataSourceUI.b)this.lJU.get(paramInt);
    AppMethodBeat.o(19792);
    return localb;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.ui.ExdeviceAddDataSourceUI.a
 * JD-Core Version:    0.7.0.1
 */