package com.tencent.mm.chatroom.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.base.MaskLayout;
import com.tencent.mm.ui.base.preference.Preference;

public class RoomContributePreference
  extends Preference
{
  private MaskLayout jit;
  private ImageView jiu;
  private String jiv;
  
  public RoomContributePreference(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet, 0);
  }
  
  public RoomContributePreference(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(12728);
    setLayoutResource(a.f.mm_preference);
    auN(a.f.jeg);
    AppMethodBeat.o(12728);
  }
  
  public final void onBindView(View paramView)
  {
    AppMethodBeat.i(12730);
    super.onBindView(paramView);
    if ((this.jiu != null) && (!Util.isNullOrNil(this.jiv))) {
      a.b.c(this.jiu, this.jiv);
    }
    AppMethodBeat.o(12730);
  }
  
  public final View onCreateView(ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(12729);
    paramViewGroup = super.onCreateView(paramViewGroup);
    this.jit = ((MaskLayout)paramViewGroup.findViewById(a.e.image_mask));
    this.jiu = ((ImageView)paramViewGroup.findViewById(a.e.image));
    AppMethodBeat.o(12729);
    return paramViewGroup;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.chatroom.ui.RoomContributePreference
 * JD-Core Version:    0.7.0.1
 */