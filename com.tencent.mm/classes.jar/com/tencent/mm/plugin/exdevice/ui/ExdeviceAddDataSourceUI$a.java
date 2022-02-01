package com.tencent.mm.plugin.exdevice.ui;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.av.a.a;
import com.tencent.mm.av.a.a.c;
import com.tencent.mm.av.a.a.c.a;
import com.tencent.mm.av.q;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

final class ExdeviceAddDataSourceUI$a
  extends BaseAdapter
{
  private List<ExdeviceAddDataSourceUI.b> qnZ;
  private c qon;
  
  public ExdeviceAddDataSourceUI$a()
  {
    AppMethodBeat.i(23856);
    this.qnZ = new LinkedList();
    c.a locala = new c.a();
    locala.igv = 2131232115;
    this.qon = locala.aJu();
    AppMethodBeat.o(23856);
  }
  
  public final ExdeviceAddDataSourceUI.b CQ(int paramInt)
  {
    AppMethodBeat.i(23860);
    ExdeviceAddDataSourceUI.b localb = (ExdeviceAddDataSourceUI.b)this.qnZ.get(paramInt);
    AppMethodBeat.o(23860);
    return localb;
  }
  
  public final void V(List<ExdeviceAddDataSourceUI.b> paramList)
  {
    AppMethodBeat.i(23857);
    this.qnZ.clear();
    if ((paramList == null) || (paramList.size() == 0))
    {
      AppMethodBeat.o(23857);
      return;
    }
    this.qnZ.addAll(paramList);
    AppMethodBeat.o(23857);
  }
  
  public final ExdeviceAddDataSourceUI.b adF(String paramString)
  {
    AppMethodBeat.i(23858);
    if (!bu.isNullOrNil(paramString))
    {
      Iterator localIterator = this.qnZ.iterator();
      while (localIterator.hasNext())
      {
        ExdeviceAddDataSourceUI.b localb = (ExdeviceAddDataSourceUI.b)localIterator.next();
        if (paramString.equalsIgnoreCase(localb.mac))
        {
          AppMethodBeat.o(23858);
          return localb;
        }
      }
    }
    AppMethodBeat.o(23858);
    return null;
  }
  
  public final int getCount()
  {
    AppMethodBeat.i(23859);
    int i = this.qnZ.size();
    AppMethodBeat.o(23859);
    return i;
  }
  
  public final long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(23861);
    ExdeviceAddDataSourceUI.b localb = CQ(paramInt);
    View localView;
    if (paramView == null)
    {
      paramView = new a((byte)0);
      localView = View.inflate(paramViewGroup.getContext(), 2131493851, null);
      paramView.mdt = ((ImageView)localView.findViewById(2131300880));
      paramView.jiC = ((TextView)localView.findViewById(2131302656));
      localView.setTag(paramView);
      paramViewGroup = paramView;
    }
    for (;;)
    {
      ae.d("MicroMsg.ExdeviceAddDataSourceUI", "position(%s), name(%s), mac(%s).", new Object[] { Integer.valueOf(paramInt), localb.name, localb.mac });
      paramViewGroup.jiC.setText(localb.name);
      q.aJb().a(localb.iconUrl, paramViewGroup.mdt, this.qon);
      AppMethodBeat.o(23861);
      return localView;
      paramViewGroup = (a)paramView.getTag();
      localView = paramView;
    }
  }
  
  static final class a
  {
    TextView jiC;
    ImageView mdt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.ui.ExdeviceAddDataSourceUI.a
 * JD-Core Version:    0.7.0.1
 */