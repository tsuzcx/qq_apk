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
  public boolean ddw;
  private TextView fxY;
  public CharSequence fxZ;
  public CharSequence fya;
  private LinearLayout fyb;
  private View mView;
  
  public RoomCardPreference(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.ddw = false;
  }
  
  public RoomCardPreference(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(13010);
    this.ddw = false;
    setLayoutResource(2131494804);
    AppMethodBeat.o(13010);
  }
  
  public final void onBindView(View paramView)
  {
    AppMethodBeat.i(13012);
    super.onBindView(paramView);
    paramView = (ViewGroup)paramView.findViewById(2131298739).findViewById(2131305937);
    if (this.fyb == null) {
      this.fyb = ((LinearLayout)paramView.getChildAt(1));
    }
    if (this.fxY == null) {
      this.fxY = ((TextView)paramView.findViewById(2131304215));
    }
    if (this.ddw)
    {
      this.fyb.setVisibility(0);
      this.fxY.setVisibility(0);
    }
    for (;;)
    {
      if (this.fya != null) {
        this.fxY.setText(this.fya);
      }
      AppMethodBeat.o(13012);
      return;
      this.fyb.setVisibility(8);
      this.fxY.setVisibility(8);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.chatroom.ui.preference.RoomCardPreference
 * JD-Core Version:    0.7.0.1
 */