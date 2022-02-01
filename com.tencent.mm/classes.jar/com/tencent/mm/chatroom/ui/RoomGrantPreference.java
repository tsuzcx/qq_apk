package com.tencent.mm.chatroom.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.base.preference.Preference;

public class RoomGrantPreference
  extends Preference
{
  TextView gyt;
  String num;
  
  public RoomGrantPreference(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.gyt = null;
    this.num = "";
  }
  
  public RoomGrantPreference(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(12731);
    this.gyt = null;
    this.num = "";
    setLayoutResource(2131495538);
    setWidgetLayoutResource(2131495622);
    AppMethodBeat.o(12731);
  }
  
  public final void onBindView(View paramView)
  {
    AppMethodBeat.i(12733);
    if (this.gyt == null) {
      this.gyt = ((TextView)paramView.findViewById(2131299223));
    }
    this.gyt.setText(this.num);
    super.onBindView(paramView);
    AppMethodBeat.o(12733);
  }
  
  public final View onCreateView(ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(12732);
    paramViewGroup = super.onCreateView(paramViewGroup);
    ViewGroup localViewGroup = (ViewGroup)paramViewGroup.findViewById(2131299180);
    localViewGroup.removeAllViews();
    View.inflate(this.mContext, 2131495580, localViewGroup);
    AppMethodBeat.o(12732);
    return paramViewGroup;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.chatroom.ui.RoomGrantPreference
 * JD-Core Version:    0.7.0.1
 */