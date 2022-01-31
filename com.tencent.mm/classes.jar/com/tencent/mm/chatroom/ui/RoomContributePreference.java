package com.tencent.mm.chatroom.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.base.MaskLayout;
import com.tencent.mm.ui.base.preference.Preference;

public class RoomContributePreference
  extends Preference
{
  private MaskLayout ehu;
  private ImageView ehv;
  private String ehw;
  
  public RoomContributePreference(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet, 0);
  }
  
  public RoomContributePreference(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(104179);
    setLayoutResource(2130970179);
    setWidgetLayoutResource(2130970235);
    AppMethodBeat.o(104179);
  }
  
  public final void onBindView(View paramView)
  {
    AppMethodBeat.i(104181);
    super.onBindView(paramView);
    if ((this.ehv != null) && (!bo.isNullOrNil(this.ehw))) {
      a.b.c(this.ehv, this.ehw);
    }
    AppMethodBeat.o(104181);
  }
  
  public final View onCreateView(ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(104180);
    paramViewGroup = super.onCreateView(paramViewGroup);
    this.ehu = ((MaskLayout)paramViewGroup.findViewById(2131826241));
    this.ehv = ((ImageView)paramViewGroup.findViewById(2131820629));
    AppMethodBeat.o(104180);
    return paramViewGroup;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.chatroom.ui.RoomContributePreference
 * JD-Core Version:    0.7.0.1
 */