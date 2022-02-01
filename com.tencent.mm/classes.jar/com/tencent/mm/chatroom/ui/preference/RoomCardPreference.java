package com.tencent.mm.chatroom.ui.preference;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.chatroom.ui.a.e;
import com.tencent.mm.chatroom.ui.a.f;
import com.tencent.mm.ui.base.preference.Preference;

public class RoomCardPreference
  extends Preference
{
  public boolean hBY;
  private TextView lPi;
  public CharSequence lPj;
  public CharSequence lPk;
  private LinearLayout lPl;
  private View mView;
  
  public RoomCardPreference(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.hBY = false;
  }
  
  public RoomCardPreference(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(13010);
    this.hBY = false;
    setLayoutResource(a.f.mm_preference);
    AppMethodBeat.o(13010);
  }
  
  public final void onBindView(View paramView)
  {
    AppMethodBeat.i(13012);
    super.onBindView(paramView);
    paramView = (ViewGroup)paramView.findViewById(a.e.content).findViewById(a.e.title_ll);
    if (this.lPl == null) {
      this.lPl = ((LinearLayout)paramView.getChildAt(1));
    }
    if (this.lPi == null) {
      this.lPi = ((TextView)paramView.findViewById(a.e.lFn));
    }
    if (this.hBY)
    {
      this.lPl.setVisibility(0);
      this.lPi.setVisibility(0);
    }
    for (;;)
    {
      if (this.lPk != null) {
        this.lPi.setText(this.lPk);
      }
      AppMethodBeat.o(13012);
      return;
      this.lPl.setVisibility(8);
      this.lPi.setVisibility(8);
    }
  }
  
  public final View onCreateView(ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(13011);
    if (this.mView == null)
    {
      paramViewGroup = super.onCreateView(paramViewGroup);
      ViewGroup localViewGroup = (ViewGroup)paramViewGroup.findViewById(a.e.content);
      localViewGroup.removeAllViews();
      View.inflate(this.mContext, a.f.lGr, localViewGroup);
      this.mView = paramViewGroup;
    }
    paramViewGroup = this.mView;
    AppMethodBeat.o(13011);
    return paramViewGroup;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.chatroom.ui.preference.RoomCardPreference
 * JD-Core Version:    0.7.0.1
 */