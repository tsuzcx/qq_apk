package com.tencent.mm.plugin.exdevice.ui;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aw.a.a;
import com.tencent.mm.aw.a.a.c;
import com.tencent.mm.aw.a.a.c.a;
import com.tencent.mm.aw.q;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

final class ExdeviceAddDataSourceUI$a
  extends BaseAdapter
{
  private c qhI;
  private List<ExdeviceAddDataSourceUI.b> qhu;
  
  public ExdeviceAddDataSourceUI$a()
  {
    AppMethodBeat.i(23856);
    this.qhu = new LinkedList();
    c.a locala = new c.a();
    locala.idD = 2131232115;
    this.qhI = locala.aJc();
    AppMethodBeat.o(23856);
  }
  
  public final ExdeviceAddDataSourceUI.b CE(int paramInt)
  {
    AppMethodBeat.i(23860);
    ExdeviceAddDataSourceUI.b localb = (ExdeviceAddDataSourceUI.b)this.qhu.get(paramInt);
    AppMethodBeat.o(23860);
    return localb;
  }
  
  public final void V(List<ExdeviceAddDataSourceUI.b> paramList)
  {
    AppMethodBeat.i(23857);
    this.qhu.clear();
    if ((paramList == null) || (paramList.size() == 0))
    {
      AppMethodBeat.o(23857);
      return;
    }
    this.qhu.addAll(paramList);
    AppMethodBeat.o(23857);
  }
  
  public final ExdeviceAddDataSourceUI.b acO(String paramString)
  {
    AppMethodBeat.i(23858);
    if (!bt.isNullOrNil(paramString))
    {
      Iterator localIterator = this.qhu.iterator();
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
    int i = this.qhu.size();
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
    ExdeviceAddDataSourceUI.b localb = CE(paramInt);
    View localView;
    if (paramView == null)
    {
      paramView = new a((byte)0);
      localView = View.inflate(paramViewGroup.getContext(), 2131493851, null);
      paramView.lZa = ((ImageView)localView.findViewById(2131300880));
      paramView.jfJ = ((TextView)localView.findViewById(2131302656));
      localView.setTag(paramView);
      paramViewGroup = paramView;
    }
    for (;;)
    {
      ad.d("MicroMsg.ExdeviceAddDataSourceUI", "position(%s), name(%s), mac(%s).", new Object[] { Integer.valueOf(paramInt), localb.name, localb.mac });
      paramViewGroup.jfJ.setText(localb.name);
      q.aIJ().a(localb.iconUrl, paramViewGroup.lZa, this.qhI);
      AppMethodBeat.o(23861);
      return localView;
      paramViewGroup = (a)paramView.getTag();
      localView = paramView;
    }
  }
  
  static final class a
  {
    TextView jfJ;
    ImageView lZa;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.ui.ExdeviceAddDataSourceUI.a
 * JD-Core Version:    0.7.0.1
 */