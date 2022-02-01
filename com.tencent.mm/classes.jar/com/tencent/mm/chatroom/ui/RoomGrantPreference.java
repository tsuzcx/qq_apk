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
  TextView lKQ;
  String num;
  
  public RoomGrantPreference(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.lKQ = null;
    this.num = "";
  }
  
  public RoomGrantPreference(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(12731);
    this.lKQ = null;
    this.num = "";
    setLayoutResource(a.f.mm_preference);
    aBp(a.f.mm_preference_submenu);
    AppMethodBeat.o(12731);
  }
  
  public final void onBindView(View paramView)
  {
    AppMethodBeat.i(12733);
    if (this.lKQ == null) {
      this.lKQ = ((TextView)paramView.findViewById(a.e.content_tv));
    }
    this.lKQ.setText(this.num);
    super.onBindView(paramView);
    AppMethodBeat.o(12733);
  }
  
  public final View onCreateView(ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(12732);
    paramViewGroup = super.onCreateView(paramViewGroup);
    ViewGroup localViewGroup = (ViewGroup)paramViewGroup.findViewById(a.e.content);
    localViewGroup.removeAllViews();
    View.inflate(this.mContext, a.f.lGo, localViewGroup);
    AppMethodBeat.o(12732);
    return paramViewGroup;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.chatroom.ui.RoomGrantPreference
 * JD-Core Version:    0.7.0.1
 */