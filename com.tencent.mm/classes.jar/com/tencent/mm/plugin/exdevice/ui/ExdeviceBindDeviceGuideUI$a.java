package com.tencent.mm.plugin.exdevice.ui;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import java.util.ArrayList;

final class ExdeviceBindDeviceGuideUI$a
  extends BaseAdapter
{
  private ArrayList<String> yyc;
  
  public ExdeviceBindDeviceGuideUI$a(ArrayList<String> paramArrayList)
  {
    this.yyc = paramArrayList;
  }
  
  private String getItem(int paramInt)
  {
    AppMethodBeat.i(23884);
    if ((this.yyc != null) && (this.yyc.size() > 0))
    {
      String str = (String)this.yyc.get(paramInt);
      AppMethodBeat.o(23884);
      return str;
    }
    AppMethodBeat.o(23884);
    return null;
  }
  
  public final int getCount()
  {
    AppMethodBeat.i(23883);
    if (this.yyc != null)
    {
      int i = this.yyc.size();
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
    if ((this.yyc == null) || (this.yyc.size() <= 0))
    {
      AppMethodBeat.o(23885);
      return null;
    }
    String str = getItem(paramInt);
    View localView;
    if (paramView == null)
    {
      paramView = new a((byte)0);
      localView = View.inflate(paramViewGroup.getContext(), R.i.gjc, null);
      paramView.yye = ((TextView)localView.findViewById(R.h.fDv));
      paramView.yyd = ((TextView)localView.findViewById(R.h.fYh));
      paramView.yyf = localView.findViewById(R.h.gaB);
      paramView.yyg = localView.findViewById(R.h.fuO);
      localView.setTag(paramView);
      paramViewGroup = paramView;
      paramViewGroup.yyd.setText(Integer.toString(paramInt + 1));
      paramViewGroup.yye.setText(str);
      if ((paramInt != 0) || (this.yyc.size() != 1)) {
        break label202;
      }
      paramViewGroup.yyf.setVisibility(4);
      paramViewGroup.yyg.setVisibility(4);
    }
    for (;;)
    {
      AppMethodBeat.o(23885);
      return localView;
      paramViewGroup = (a)paramView.getTag();
      localView = paramView;
      break;
      label202:
      if (paramInt == 0)
      {
        paramViewGroup.yyf.setVisibility(4);
        paramViewGroup.yyg.setVisibility(0);
      }
      else if (paramInt == this.yyc.size() - 1)
      {
        paramViewGroup.yyg.setVisibility(4);
        paramViewGroup.yyf.setVisibility(0);
      }
    }
  }
  
  static final class a
  {
    TextView yyd;
    TextView yye;
    View yyf;
    View yyg;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.ui.ExdeviceBindDeviceGuideUI.a
 * JD-Core Version:    0.7.0.1
 */