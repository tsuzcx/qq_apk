package com.tencent.mm.plugin.ipcall.ui;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pluginsdk.ui.applet.CdnImageView;
import com.tencent.mm.protocal.protobuf.cva;
import java.util.List;

final class IPCallPackageUI$a
  extends BaseAdapter
{
  private IPCallPackageUI nUt = null;
  List<cva> nxh = null;
  
  public IPCallPackageUI$a(IPCallPackageUI paramIPCallPackageUI)
  {
    this.nUt = paramIPCallPackageUI;
  }
  
  public final int getCount()
  {
    AppMethodBeat.i(22227);
    if (this.nxh == null)
    {
      AppMethodBeat.o(22227);
      return 0;
    }
    int i = this.nxh.size();
    AppMethodBeat.o(22227);
    return i;
  }
  
  public final Object getItem(int paramInt)
  {
    AppMethodBeat.i(22228);
    if (this.nxh != null)
    {
      Object localObject = this.nxh.get(paramInt);
      AppMethodBeat.o(22228);
      return localObject;
    }
    AppMethodBeat.o(22228);
    return null;
  }
  
  public final long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(22229);
    if (paramView == null)
    {
      paramView = ((LayoutInflater)this.nUt.getSystemService("layout_inflater")).inflate(2130969942, paramViewGroup, false);
      paramViewGroup = new IPCallPackageUI.a.a(this, (byte)0);
      paramViewGroup.nUx = ((CdnImageView)paramView.findViewById(2131825303));
      paramViewGroup.gve = ((TextView)paramView.findViewById(2131825304));
      paramViewGroup.nUy = ((TextView)paramView.findViewById(2131825309));
      paramViewGroup.nUz = ((TextView)paramView.findViewById(2131825310));
      paramViewGroup.hsI = ((TextView)paramView.findViewById(2131825185));
      paramViewGroup.nUA = ((Button)paramView.findViewById(2131825307));
      paramView.setTag(paramViewGroup);
    }
    cva localcva;
    for (;;)
    {
      localcva = (cva)getItem(paramInt);
      if (localcva != null) {
        break;
      }
      AppMethodBeat.o(22229);
      return paramView;
      paramViewGroup = (IPCallPackageUI.a.a)paramView.getTag();
    }
    paramViewGroup.gve.setText(localcva.Title);
    paramViewGroup.nUy.setText(localcva.xBK);
    paramViewGroup.hsI.setText(localcva.Desc);
    paramViewGroup.nUz.setText(localcva.nQe);
    paramViewGroup.nUx.setVisibility(0);
    paramViewGroup.nUx.setUrl(localcva.ydJ);
    if (localcva.woE == 0) {
      paramViewGroup.nUA.setEnabled(true);
    }
    for (;;)
    {
      paramViewGroup.nUA.setTag(Integer.valueOf(paramInt));
      paramViewGroup.nUA.setOnClickListener(new IPCallPackageUI.a.1(this));
      AppMethodBeat.o(22229);
      return paramView;
      paramViewGroup.nUA.setEnabled(false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.ipcall.ui.IPCallPackageUI.a
 * JD-Core Version:    0.7.0.1
 */