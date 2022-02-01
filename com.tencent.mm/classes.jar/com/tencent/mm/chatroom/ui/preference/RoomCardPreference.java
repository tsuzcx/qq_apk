package com.tencent.mm.chatroom.ui.preference;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.base.preference.Preference;

public class RoomCardPreference
  extends Preference
{
  public boolean daU;
  private TextView fBF;
  public CharSequence fBG;
  public CharSequence fBH;
  private LinearLayout fBI;
  private View mView;
  
  public RoomCardPreference(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.daU = false;
  }
  
  public RoomCardPreference(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(13010);
    this.daU = false;
    setLayoutResource(2131494804);
    AppMethodBeat.o(13010);
  }
  
  public final void onBindView(View paramView)
  {
    AppMethodBeat.i(13012);
    super.onBindView(paramView);
    paramView = (ViewGroup)paramView.findViewById(2131298739).findViewById(2131305937);
    if (this.fBI == null) {
      this.fBI = ((LinearLayout)paramView.getChildAt(1));
    }
    if (this.fBF == null) {
      this.fBF = ((TextView)paramView.findViewById(2131304215));
    }
    if (this.daU)
    {
      this.fBI.setVisibility(0);
      this.fBF.setVisibility(0);
    }
    for (;;)
    {
      if (this.fBH != null) {
        this.fBF.setText(this.fBH);
      }
      AppMethodBeat.o(13012);
      return;
      this.fBI.setVisibility(8);
      this.fBF.setVisibility(8);
    }
  }
  
  public final View onCreateView(ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(13011);
    if (this.mView == null)
    {
      paramViewGroup = super.onCreateView(paramViewGroup);
      ViewGroup localViewGroup = (ViewGroup)paramViewGroup.findViewById(2131298739);
      localViewGroup.removeAllViews();
      View.inflate(this.mContext, 2131494880, localViewGroup);
      this.mView = paramViewGroup;
    }
    paramViewGroup = this.mView;
    AppMethodBeat.o(13011);
    return paramViewGroup;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.chatroom.ui.preference.RoomCardPreference
 * JD-Core Version:    0.7.0.1
 */