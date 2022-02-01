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
  private ArrayList<String> rFQ;
  
  public ExdeviceBindDeviceGuideUI$a(ArrayList<String> paramArrayList)
  {
    this.rFQ = paramArrayList;
  }
  
  private String getItem(int paramInt)
  {
    AppMethodBeat.i(23884);
    if ((this.rFQ != null) && (this.rFQ.size() > 0))
    {
      String str = (String)this.rFQ.get(paramInt);
      AppMethodBeat.o(23884);
      return str;
    }
    AppMethodBeat.o(23884);
    return null;
  }
  
  public final int getCount()
  {
    AppMethodBeat.i(23883);
    if (this.rFQ != null)
    {
      int i = this.rFQ.size();
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
    if ((this.rFQ == null) || (this.rFQ.size() <= 0))
    {
      AppMethodBeat.o(23885);
      return null;
    }
    String str = getItem(paramInt);
    View localView;
    if (paramView == null)
    {
      paramView = new a((byte)0);
      localView = View.inflate(paramViewGroup.getContext(), 2131494011, null);
      paramView.rFS = ((TextView)localView.findViewById(2131299186));
      paramView.rFR = ((TextView)localView.findViewById(2131308412));
      paramView.rFT = localView.findViewById(2131309302);
      paramView.rFU = localView.findViewById(2131297660);
      localView.setTag(paramView);
      paramViewGroup = paramView;
      paramViewGroup.rFR.setText(Integer.toString(paramInt + 1));
      paramViewGroup.rFS.setText(str);
      if ((paramInt != 0) || (this.rFQ.size() != 1)) {
        break label197;
      }
      paramViewGroup.rFT.setVisibility(4);
      paramViewGroup.rFU.setVisibility(4);
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
        paramViewGroup.rFT.setVisibility(4);
        paramViewGroup.rFU.setVisibility(0);
      }
      else if (paramInt == this.rFQ.size() - 1)
      {
        paramViewGroup.rFU.setVisibility(4);
        paramViewGroup.rFT.setVisibility(0);
      }
    }
  }
  
  static final class a
  {
    TextView rFR;
    TextView rFS;
    View rFT;
    View rFU;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.ui.ExdeviceBindDeviceGuideUI.a
 * JD-Core Version:    0.7.0.1
 */