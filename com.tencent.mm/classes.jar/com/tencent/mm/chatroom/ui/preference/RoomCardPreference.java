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
  public boolean coy;
  private TextView elg;
  public CharSequence elh;
  public CharSequence eli;
  private LinearLayout elj;
  private View mView;
  
  public RoomCardPreference(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.coy = false;
  }
  
  public RoomCardPreference(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(104468);
    this.coy = false;
    setLayoutResource(2130970179);
    AppMethodBeat.o(104468);
  }
  
  public final void onBindView(View paramView)
  {
    AppMethodBeat.i(104470);
    super.onBindView(paramView);
    paramView = (ViewGroup)paramView.findViewById(2131820946).findViewById(2131820997);
    if (this.elj == null) {
      this.elj = ((LinearLayout)paramView.getChildAt(1));
    }
    if (this.elg == null) {
      this.elg = ((TextView)paramView.findViewById(2131826256));
    }
    if (this.coy)
    {
      this.elj.setVisibility(0);
      this.elg.setVisibility(0);
    }
    for (;;)
    {
      if (this.eli != null) {
        this.elg.setText(this.eli);
      }
      AppMethodBeat.o(104470);
      return;
      this.elj.setVisibility(8);
      this.elg.setVisibility(8);
    }
  }
  
  public final View onCreateView(ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(104469);
    if (this.mView == null)
    {
      paramViewGroup = super.onCreateView(paramViewGroup);
      ViewGroup localViewGroup = (ViewGroup)paramViewGroup.findViewById(2131820946);
      localViewGroup.removeAllViews();
      View.inflate(this.mContext, 2130970251, localViewGroup);
      this.mView = paramViewGroup;
    }
    paramViewGroup = this.mView;
    AppMethodBeat.o(104469);
    return paramViewGroup;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.chatroom.ui.preference.RoomCardPreference
 * JD-Core Version:    0.7.0.1
 */