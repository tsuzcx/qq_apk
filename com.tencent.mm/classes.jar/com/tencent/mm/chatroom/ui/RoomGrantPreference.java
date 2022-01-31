package com.tencent.mm.chatroom.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.mm.ui.base.preference.Preference;

public class RoomGrantPreference
  extends Preference
{
  TextView dqa = null;
  String dqb = "";
  
  public RoomGrantPreference(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public RoomGrantPreference(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    setLayoutResource(a.f.mm_preference);
    setWidgetLayoutResource(a.f.mm_preference_submenu);
  }
  
  public final void onBindView(View paramView)
  {
    if (this.dqa == null) {
      this.dqa = ((TextView)paramView.findViewById(a.e.content_tv));
    }
    this.dqa.setText(this.dqb);
    super.onBindView(paramView);
  }
  
  public final View onCreateView(ViewGroup paramViewGroup)
  {
    paramViewGroup = super.onCreateView(paramViewGroup);
    ViewGroup localViewGroup = (ViewGroup)paramViewGroup.findViewById(a.e.content);
    localViewGroup.removeAllViews();
    View.inflate(this.mContext, a.f.mm_preference_content_room, localViewGroup);
    return paramViewGroup;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.chatroom.ui.RoomGrantPreference
 * JD-Core Version:    0.7.0.1
 */