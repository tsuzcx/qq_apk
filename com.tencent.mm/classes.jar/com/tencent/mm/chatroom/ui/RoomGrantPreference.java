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
  TextView fTl;
  String fTm;
  
  public RoomGrantPreference(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.fTl = null;
    this.fTm = "";
  }
  
  public RoomGrantPreference(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(12731);
    this.fTl = null;
    this.fTm = "";
    setLayoutResource(2131494804);
    setWidgetLayoutResource(2131494884);
    AppMethodBeat.o(12731);
  }
  
  public final void onBindView(View paramView)
  {
    AppMethodBeat.i(12733);
    if (this.fTl == null) {
      this.fTl = ((TextView)paramView.findViewById(2131298778));
    }
    this.fTl.setText(this.fTm);
    super.onBindView(paramView);
    AppMethodBeat.o(12733);
  }
  
  public final View onCreateView(ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(12732);
    paramViewGroup = super.onCreateView(paramViewGroup);
    ViewGroup localViewGroup = (ViewGroup)paramViewGroup.findViewById(2131298739);
    localViewGroup.removeAllViews();
    View.inflate(this.mContext, 2131494845, localViewGroup);
    AppMethodBeat.o(12732);
    return paramViewGroup;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.chatroom.ui.RoomGrantPreference
 * JD-Core Version:    0.7.0.1
 */