package com.tencent.mm.plugin.expt.roomexpt;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import com.tencent.mm.plugin.expt.b.a;
import com.tencent.mm.plugin.expt.b.b;

final class RoomExptDebugUI$6
  extends ArrayAdapter
{
  RoomExptDebugUI$6(RoomExptDebugUI paramRoomExptDebugUI, Context paramContext, int paramInt1, int paramInt2)
  {
    super(paramContext, paramInt1, paramInt2);
  }
  
  public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    paramView = super.getView(paramInt, paramView, paramViewGroup);
    paramViewGroup = (TextView)paramView.findViewById(b.b.room_expt_ui_tv);
    if (paramInt % 2 == 0)
    {
      paramViewGroup.setBackgroundResource(b.a.wechat_green);
      return paramView;
    }
    paramViewGroup.setBackgroundResource(b.a.transparent);
    return paramView;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.roomexpt.RoomExptDebugUI.6
 * JD-Core Version:    0.7.0.1
 */