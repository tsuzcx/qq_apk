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
  public boolean dEF;
  private TextView gCe;
  public CharSequence gCf;
  public CharSequence gCg;
  private LinearLayout gCh;
  private View mView;
  
  public RoomCardPreference(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.dEF = false;
  }
  
  public RoomCardPreference(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(13010);
    this.dEF = false;
    setLayoutResource(2131495538);
    AppMethodBeat.o(13010);
  }
  
  public final void onBindView(View paramView)
  {
    AppMethodBeat.i(13012);
    super.onBindView(paramView);
    paramView = (ViewGroup)paramView.findViewById(2131299180).findViewById(2131309235);
    if (this.gCh == null) {
      this.gCh = ((LinearLayout)paramView.getChildAt(1));
    }
    if (this.gCe == null) {
      this.gCe = ((TextView)paramView.findViewById(2131307133));
    }
    if (this.dEF)
    {
      this.gCh.setVisibility(0);
      this.gCe.setVisibility(0);
    }
    for (;;)
    {
      if (this.gCg != null) {
        this.gCe.setText(this.gCg);
      }
      AppMethodBeat.o(13012);
      return;
      this.gCh.setVisibility(8);
      this.gCe.setVisibility(8);
    }
  }
  
  public final View onCreateView(ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(13011);
    if (this.mView == null)
    {
      paramViewGroup = super.onCreateView(paramViewGroup);
      ViewGroup localViewGroup = (ViewGroup)paramViewGroup.findViewById(2131299180);
      localViewGroup.removeAllViews();
      View.inflate(this.mContext, 2131495617, localViewGroup);
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