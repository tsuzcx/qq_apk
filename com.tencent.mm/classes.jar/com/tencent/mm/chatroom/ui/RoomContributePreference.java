package com.tencent.mm.chatroom.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.base.MaskLayout;
import com.tencent.mm.ui.base.preference.Preference;

public class RoomContributePreference
  extends Preference
{
  private MaskLayout fui;
  private ImageView fuj;
  private String fuk;
  
  public RoomContributePreference(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet, 0);
  }
  
  public RoomContributePreference(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(12728);
    setLayoutResource(2131494804);
    setWidgetLayoutResource(2131494862);
    AppMethodBeat.o(12728);
  }
  
  public final void onBindView(View paramView)
  {
    AppMethodBeat.i(12730);
    super.onBindView(paramView);
    if ((this.fuj != null) && (!bt.isNullOrNil(this.fuk))) {
      a.b.c(this.fuj, this.fuk);
    }
    AppMethodBeat.o(12730);
  }
  
  public final View onCreateView(ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(12729);
    paramViewGroup = super.onCreateView(paramViewGroup);
    this.fui = ((MaskLayout)paramViewGroup.findViewById(2131300952));
    this.fuj = ((ImageView)paramViewGroup.findViewById(2131300914));
    AppMethodBeat.o(12729);
    return paramViewGroup;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.chatroom.ui.RoomContributePreference
 * JD-Core Version:    0.7.0.1
 */