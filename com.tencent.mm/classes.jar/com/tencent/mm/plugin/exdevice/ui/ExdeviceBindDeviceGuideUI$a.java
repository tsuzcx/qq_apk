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
  private ArrayList<String> pbo;
  
  public ExdeviceBindDeviceGuideUI$a(ArrayList<String> paramArrayList)
  {
    this.pbo = paramArrayList;
  }
  
  private String getItem(int paramInt)
  {
    AppMethodBeat.i(23884);
    if ((this.pbo != null) && (this.pbo.size() > 0))
    {
      String str = (String)this.pbo.get(paramInt);
      AppMethodBeat.o(23884);
      return str;
    }
    AppMethodBeat.o(23884);
    return null;
  }
  
  public final int getCount()
  {
    AppMethodBeat.i(23883);
    if (this.pbo != null)
    {
      int i = this.pbo.size();
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
    if ((this.pbo == null) || (this.pbo.size() <= 0))
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
      paramView.pbq = ((TextView)localView.findViewById(2131298744));
      paramView.pbp = ((TextView)localView.findViewById(2131305215));
      paramView.pbr = localView.findViewById(2131305995);
      paramView.pbs = localView.findViewById(2131297431);
      localView.setTag(paramView);
      paramViewGroup = paramView;
      paramViewGroup.pbp.setText(Integer.toString(paramInt + 1));
      paramViewGroup.pbq.setText(str);
      if ((paramInt != 0) || (this.pbo.size() != 1)) {
        break label197;
      }
      paramViewGroup.pbr.setVisibility(4);
      paramViewGroup.pbs.setVisibility(4);
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
        paramViewGroup.pbr.setVisibility(4);
        paramViewGroup.pbs.setVisibility(0);
      }
      else if (paramInt == this.pbo.size() - 1)
      {
        paramViewGroup.pbs.setVisibility(4);
        paramViewGroup.pbr.setVisibility(0);
      }
    }
  }
  
  static final class a
  {
    TextView pbp;
    TextView pbq;
    View pbr;
    View pbs;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.ui.ExdeviceBindDeviceGuideUI.a
 * JD-Core Version:    0.7.0.1
 */