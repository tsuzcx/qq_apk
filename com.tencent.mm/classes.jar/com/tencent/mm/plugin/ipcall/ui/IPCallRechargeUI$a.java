package com.tencent.mm.plugin.ipcall.ui;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.ipcall.b.a;
import com.tencent.mm.protocal.protobuf.asf;
import com.tencent.mm.protocal.protobuf.cuw;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.List;
import junit.framework.Assert;

final class IPCallRechargeUI$a
  extends BaseAdapter
{
  private IPCallRechargeUI nUY;
  asf nUZ;
  List<cuw> nxh;
  
  public IPCallRechargeUI$a(IPCallRechargeUI paramIPCallRechargeUI)
  {
    AppMethodBeat.i(22264);
    this.nxh = null;
    this.nUY = null;
    this.nUZ = null;
    Assert.assertTrue(true);
    this.nUY = paramIPCallRechargeUI;
    AppMethodBeat.o(22264);
  }
  
  public final int getCount()
  {
    AppMethodBeat.i(22265);
    if (this.nxh == null)
    {
      AppMethodBeat.o(22265);
      return 0;
    }
    int i = this.nxh.size();
    AppMethodBeat.o(22265);
    return i;
  }
  
  public final Object getItem(int paramInt)
  {
    AppMethodBeat.i(22266);
    if (this.nxh != null)
    {
      Object localObject = this.nxh.get(paramInt);
      AppMethodBeat.o(22266);
      return localObject;
    }
    AppMethodBeat.o(22266);
    return null;
  }
  
  public final long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(22267);
    if (paramView == null)
    {
      paramView = ((LayoutInflater)this.nUY.getSystemService("layout_inflater")).inflate(2130969945, paramViewGroup, false);
      paramViewGroup = new IPCallRechargeUI.a.a(this, (byte)0);
      paramViewGroup.nUe = ((TextView)paramView.findViewById(2131825316));
      paramViewGroup.nVb = ((TextView)paramView.findViewById(2131825317));
      paramViewGroup.nVc = ((TextView)paramView.findViewById(2131825319));
      paramViewGroup.nVd = ((TextView)paramView.findViewById(2131825318));
      paramViewGroup.nVe = ((Button)paramView.findViewById(2131825314));
      paramView.setTag(paramViewGroup);
    }
    cuw localcuw;
    for (;;)
    {
      localcuw = (cuw)getItem(paramInt);
      if (localcuw != null) {
        break;
      }
      AppMethodBeat.o(22267);
      return paramView;
      paramViewGroup = (IPCallRechargeUI.a.a)paramView.getTag();
    }
    paramViewGroup.nUe.setText(localcuw.xBK);
    paramViewGroup.nVb.setText(localcuw.ydC);
    paramViewGroup.nVc.setText(localcuw.ydD);
    if (bo.isNullOrNil(localcuw.ydD)) {
      paramViewGroup.nVc.setVisibility(8);
    }
    for (;;)
    {
      if (this.nUZ != null) {
        paramViewGroup.nVd.setText(String.format(this.nUY.getString(2131300878), new Object[] { a.Rz(this.nUZ.xhg), String.valueOf(localcuw.ydA) }));
      }
      paramViewGroup.nVe.setTag(Integer.valueOf(paramInt));
      paramViewGroup.nVe.setOnClickListener(new IPCallRechargeUI.a.1(this));
      AppMethodBeat.o(22267);
      return paramView;
      paramViewGroup.nVc.setVisibility(0);
    }
  }
  
  public final int getViewTypeCount()
  {
    return 2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.ipcall.ui.IPCallRechargeUI.a
 * JD-Core Version:    0.7.0.1
 */