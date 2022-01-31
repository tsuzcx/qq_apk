package com.tencent.mm.chatroom.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.ui.base.MaskLayout;
import com.tencent.mm.ui.base.preference.Preference;

public class RoomContributePreference
  extends Preference
{
  private MaskLayout dpX;
  private ImageView dpY;
  private String dpZ;
  
  public RoomContributePreference(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet, 0);
  }
  
  public RoomContributePreference(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    setLayoutResource(a.f.mm_preference);
    setWidgetLayoutResource(a.f.mm_preference_image_right);
  }
  
  protected final void onBindView(View paramView)
  {
    super.onBindView(paramView);
    if ((this.dpY != null) && (!bk.bl(this.dpZ))) {
      a.b.a(this.dpY, this.dpZ);
    }
  }
  
  protected final View onCreateView(ViewGroup paramViewGroup)
  {
    paramViewGroup = super.onCreateView(paramViewGroup);
    this.dpX = ((MaskLayout)paramViewGroup.findViewById(a.e.image_mask));
    this.dpY = ((ImageView)paramViewGroup.findViewById(a.e.image));
    return paramViewGroup;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.chatroom.ui.RoomContributePreference
 * JD-Core Version:    0.7.0.1
 */