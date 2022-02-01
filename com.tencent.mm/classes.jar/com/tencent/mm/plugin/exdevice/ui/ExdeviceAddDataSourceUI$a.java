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
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

final class ExdeviceAddDataSourceUI$a
  extends BaseAdapter
{
  private List<ExdeviceAddDataSourceUI.b> rFg;
  private c rFu;
  
  public ExdeviceAddDataSourceUI$a()
  {
    AppMethodBeat.i(23856);
    this.rFg = new LinkedList();
    c.a locala = new c.a();
    locala.jbq = 2131232219;
    this.rFu = locala.bdv();
    AppMethodBeat.o(23856);
  }
  
  public final ExdeviceAddDataSourceUI.b GB(int paramInt)
  {
    AppMethodBeat.i(23860);
    ExdeviceAddDataSourceUI.b localb = (ExdeviceAddDataSourceUI.b)this.rFg.get(paramInt);
    AppMethodBeat.o(23860);
    return localb;
  }
  
  public final void ad(List<ExdeviceAddDataSourceUI.b> paramList)
  {
    AppMethodBeat.i(23857);
    this.rFg.clear();
    if ((paramList == null) || (paramList.size() == 0))
    {
      AppMethodBeat.o(23857);
      return;
    }
    this.rFg.addAll(paramList);
    AppMethodBeat.o(23857);
  }
  
  public final ExdeviceAddDataSourceUI.b anO(String paramString)
  {
    AppMethodBeat.i(23858);
    if (!Util.isNullOrNil(paramString))
    {
      Iterator localIterator = this.rFg.iterator();
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
    int i = this.rFg.size();
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
    ExdeviceAddDataSourceUI.b localb = GB(paramInt);
    View localView;
    if (paramView == null)
    {
      paramView = new a((byte)0);
      localView = View.inflate(paramViewGroup.getContext(), 2131494006, null);
      paramView.nnL = ((ImageView)localView.findViewById(2131302475));
      paramView.kgE = ((TextView)localView.findViewById(2131305210));
      localView.setTag(paramView);
      paramViewGroup = paramView;
    }
    for (;;)
    {
      Log.d("MicroMsg.ExdeviceAddDataSourceUI", "position(%s), name(%s), mac(%s).", new Object[] { Integer.valueOf(paramInt), localb.name, localb.mac });
      paramViewGroup.kgE.setText(localb.name);
      q.bcV().a(localb.iconUrl, paramViewGroup.nnL, this.rFu);
      AppMethodBeat.o(23861);
      return localView;
      paramViewGroup = (a)paramView.getTag();
      localView = paramView;
    }
  }
  
  static final class a
  {
    TextView kgE;
    ImageView nnL;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.ui.ExdeviceAddDataSourceUI.a
 * JD-Core Version:    0.7.0.1
 */