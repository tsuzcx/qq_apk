package com.tencent.mm.plugin.exdevice.ui;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import java.util.ArrayList;

final class ExdeviceBindDeviceGuideUI$a
  extends BaseAdapter
{
  private ArrayList<String> jBf;
  
  public ExdeviceBindDeviceGuideUI$a(ArrayList<String> paramArrayList)
  {
    this.jBf = paramArrayList;
  }
  
  private String ke(int paramInt)
  {
    if ((this.jBf != null) && (this.jBf.size() > 0)) {
      return (String)this.jBf.get(paramInt);
    }
    return null;
  }
  
  public final int getCount()
  {
    if (this.jBf != null) {
      return this.jBf.size();
    }
    return 0;
  }
  
  public final long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    View localView;
    if ((this.jBf == null) || (this.jBf.size() <= 0)) {
      localView = null;
    }
    do
    {
      return localView;
      String str = ke(paramInt);
      if (paramView == null)
      {
        paramView = new ExdeviceBindDeviceGuideUI.a.a((byte)0);
        localView = View.inflate(paramViewGroup.getContext(), R.i.exdevice_bind_device_guide_item, null);
        paramView.jBh = ((TextView)localView.findViewById(R.h.contentTV));
        paramView.jBg = ((TextView)localView.findViewById(R.h.stepTV));
        paramView.jBi = localView.findViewById(R.h.topView);
        paramView.jBj = localView.findViewById(R.h.bottomView);
        localView.setTag(paramView);
        paramViewGroup = paramView;
        paramView = localView;
      }
      for (;;)
      {
        paramViewGroup.jBg.setText(Integer.toString(paramInt + 1));
        paramViewGroup.jBh.setText(str);
        if ((paramInt != 0) || (this.jBf.size() != 1)) {
          break;
        }
        paramViewGroup.jBi.setVisibility(4);
        paramViewGroup.jBj.setVisibility(4);
        return paramView;
        paramViewGroup = (ExdeviceBindDeviceGuideUI.a.a)paramView.getTag();
      }
      if (paramInt == 0)
      {
        paramViewGroup.jBi.setVisibility(4);
        paramViewGroup.jBj.setVisibility(0);
        return paramView;
      }
      localView = paramView;
    } while (paramInt != this.jBf.size() - 1);
    paramViewGroup.jBj.setVisibility(4);
    paramViewGroup.jBi.setVisibility(0);
    return paramView;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.ui.ExdeviceBindDeviceGuideUI.a
 * JD-Core Version:    0.7.0.1
 */