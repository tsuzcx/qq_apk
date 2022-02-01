package com.tencent.mm.plugin.exdevice.ui;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;

final class ExdeviceBindDeviceGuideUI$a
  extends BaseAdapter
{
  private ArrayList<String> qoJ;
  
  public ExdeviceBindDeviceGuideUI$a(ArrayList<String> paramArrayList)
  {
    this.qoJ = paramArrayList;
  }
  
  private String getItem(int paramInt)
  {
    AppMethodBeat.i(23884);
    if ((this.qoJ != null) && (this.qoJ.size() > 0))
    {
      String str = (String)this.qoJ.get(paramInt);
      AppMethodBeat.o(23884);
      return str;
    }
    AppMethodBeat.o(23884);
    return null;
  }
  
  public final int getCount()
  {
    AppMethodBeat.i(23883);
    if (this.qoJ != null)
    {
      int i = this.qoJ.size();
      AppMethodBeat.o(23883);
      return i;
    }
    AppMethodBeat.o(23883);
    return 0;
  }
  
  public final long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(23885);
    if ((this.qoJ == null) || (this.qoJ.size() <= 0))
    {
      AppMethodBeat.o(23885);
      return null;
    }
    String str = getItem(paramInt);
    View localView;
    if (paramView == null)
    {
      paramView = new a((byte)0);
      localView = View.inflate(paramViewGroup.getContext(), 2131493855, null);
      paramView.qoL = ((TextView)localView.findViewById(2131298744));
      paramView.qoK = ((TextView)localView.findViewById(2131305215));
      paramView.qoM = localView.findViewById(2131305995);
      paramView.qoN = localView.findViewById(2131297431);
      localView.setTag(paramView);
      paramViewGroup = paramView;
      paramViewGroup.qoK.setText(Integer.toString(paramInt + 1));
      paramViewGroup.qoL.setText(str);
      if ((paramInt != 0) || (this.qoJ.size() != 1)) {
        break label197;
      }
      paramViewGroup.qoM.setVisibility(4);
      paramViewGroup.qoN.setVisibility(4);
    }
    for (;;)
    {
      AppMethodBeat.o(23885);
      return localView;
      paramViewGroup = (a)paramView.getTag();
      localView = paramView;
      break;
      label197:
      if (paramInt == 0)
      {
        paramViewGroup.qoM.setVisibility(4);
        paramViewGroup.qoN.setVisibility(0);
      }
      else if (paramInt == this.qoJ.size() - 1)
      {
        paramViewGroup.qoN.setVisibility(4);
        paramViewGroup.qoM.setVisibility(0);
      }
    }
  }
  
  static final class a
  {
    TextView qoK;
    TextView qoL;
    View qoM;
    View qoN;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.ui.ExdeviceBindDeviceGuideUI.a
 * JD-Core Version:    0.7.0.1
 */