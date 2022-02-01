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
  private ArrayList<String> qie;
  
  public ExdeviceBindDeviceGuideUI$a(ArrayList<String> paramArrayList)
  {
    this.qie = paramArrayList;
  }
  
  private String getItem(int paramInt)
  {
    AppMethodBeat.i(23884);
    if ((this.qie != null) && (this.qie.size() > 0))
    {
      String str = (String)this.qie.get(paramInt);
      AppMethodBeat.o(23884);
      return str;
    }
    AppMethodBeat.o(23884);
    return null;
  }
  
  public final int getCount()
  {
    AppMethodBeat.i(23883);
    if (this.qie != null)
    {
      int i = this.qie.size();
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
    if ((this.qie == null) || (this.qie.size() <= 0))
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
      paramView.qig = ((TextView)localView.findViewById(2131298744));
      paramView.qif = ((TextView)localView.findViewById(2131305215));
      paramView.qih = localView.findViewById(2131305995);
      paramView.qii = localView.findViewById(2131297431);
      localView.setTag(paramView);
      paramViewGroup = paramView;
      paramViewGroup.qif.setText(Integer.toString(paramInt + 1));
      paramViewGroup.qig.setText(str);
      if ((paramInt != 0) || (this.qie.size() != 1)) {
        break label197;
      }
      paramViewGroup.qih.setVisibility(4);
      paramViewGroup.qii.setVisibility(4);
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
        paramViewGroup.qih.setVisibility(4);
        paramViewGroup.qii.setVisibility(0);
      }
      else if (paramInt == this.qie.size() - 1)
      {
        paramViewGroup.qii.setVisibility(4);
        paramViewGroup.qih.setVisibility(0);
      }
    }
  }
  
  static final class a
  {
    TextView qif;
    TextView qig;
    View qih;
    View qii;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.ui.ExdeviceBindDeviceGuideUI.a
 * JD-Core Version:    0.7.0.1
 */