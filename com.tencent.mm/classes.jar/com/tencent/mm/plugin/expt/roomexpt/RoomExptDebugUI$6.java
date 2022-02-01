package com.tencent.mm.plugin.expt.roomexpt;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class RoomExptDebugUI$6
  extends ArrayAdapter
{
  RoomExptDebugUI$6(RoomExptDebugUI paramRoomExptDebugUI, Context paramContext)
  {
    super(paramContext, 2131496123, 2131307128);
  }
  
  public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(122434);
    paramView = super.getView(paramInt, paramView, paramViewGroup);
    paramViewGroup = (TextView)paramView.findViewById(2131307128);
    if (paramInt % 2 == 0) {
      paramViewGroup.setBackgroundResource(2131101414);
    }
    for (;;)
    {
      AppMethodBeat.o(122434);
      return paramView;
      paramViewGroup.setBackgroundResource(2131101287);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.roomexpt.RoomExptDebugUI.6
 * JD-Core Version:    0.7.0.1
 */