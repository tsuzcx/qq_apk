package com.tencent.mm.chatroom.ui.preference;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mm.chatroom.ui.a.e;
import com.tencent.mm.chatroom.ui.a.f;
import com.tencent.mm.ui.base.preference.Preference;

public class RoomCardPreference
  extends Preference
{
  public boolean bHj = false;
  private TextView dtC;
  public CharSequence dtD;
  public CharSequence dtE;
  private LinearLayout dtF;
  private View mView;
  
  public RoomCardPreference(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public RoomCardPreference(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    setLayoutResource(a.f.mm_preference);
  }
  
  protected final void onBindView(View paramView)
  {
    super.onBindView(paramView);
    paramView = (ViewGroup)paramView.findViewById(a.e.content).findViewById(a.e.real_content);
    if (this.dtF == null) {
      this.dtF = ((LinearLayout)paramView.getChildAt(1));
    }
    if (this.dtC == null) {
      this.dtC = ((TextView)paramView.findViewById(a.e.room_info_notice));
    }
    if (this.bHj)
    {
      this.dtF.setVisibility(0);
      this.dtC.setVisibility(0);
    }
    for (;;)
    {
      if (this.dtE != null) {
        this.dtC.setText(this.dtE);
      }
      return;
      this.dtF.setVisibility(8);
      this.dtC.setVisibility(8);
    }
  }
  
  protected final View onCreateView(ViewGroup paramViewGroup)
  {
    if (this.mView == null)
    {
      paramViewGroup = super.onCreateView(paramViewGroup);
      ViewGroup localViewGroup = (ViewGroup)paramViewGroup.findViewById(a.e.content);
      localViewGroup.removeAllViews();
      localViewGroup.setPadding(0, 0, 0, 0);
      View.inflate(this.mContext, a.f.mm_preference_roominfo, localViewGroup);
      this.mView = paramViewGroup;
    }
    return this.mView;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.chatroom.ui.preference.RoomCardPreference
 * JD-Core Version:    0.7.0.1
 */