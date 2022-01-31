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
  TextView ehx;
  String ehy;
  
  public RoomGrantPreference(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.ehx = null;
    this.ehy = "";
  }
  
  public RoomGrantPreference(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(104182);
    this.ehx = null;
    this.ehy = "";
    setLayoutResource(2130970179);
    setWidgetLayoutResource(2130970254);
    AppMethodBeat.o(104182);
  }
  
  public final void onBindView(View paramView)
  {
    AppMethodBeat.i(104184);
    if (this.ehx == null) {
      this.ehx = ((TextView)paramView.findViewById(2131823022));
    }
    this.ehx.setText(this.ehy);
    super.onBindView(paramView);
    AppMethodBeat.o(104184);
  }
  
  public final View onCreateView(ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(104183);
    paramViewGroup = super.onCreateView(paramViewGroup);
    ViewGroup localViewGroup = (ViewGroup)paramViewGroup.findViewById(2131820946);
    localViewGroup.removeAllViews();
    View.inflate(this.mContext, 2130970218, localViewGroup);
    AppMethodBeat.o(104183);
    return paramViewGroup;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.chatroom.ui.RoomGrantPreference
 * JD-Core Version:    0.7.0.1
 */