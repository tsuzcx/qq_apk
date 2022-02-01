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
  public boolean fxt;
  private TextView jmk;
  public CharSequence jml;
  public CharSequence jmm;
  private LinearLayout jmn;
  private View mView;
  
  public RoomCardPreference(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.fxt = false;
  }
  
  public RoomCardPreference(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(13010);
    this.fxt = false;
    setLayoutResource(a.f.mm_preference);
    AppMethodBeat.o(13010);
  }
  
  public final void onBindView(View paramView)
  {
    AppMethodBeat.i(13012);
    super.onBindView(paramView);
    paramView = (ViewGroup)paramView.findViewById(a.e.content).findViewById(a.e.title_ll);
    if (this.jmn == null) {
      this.jmn = ((LinearLayout)paramView.getChildAt(1));
    }
    if (this.jmk == null) {
      this.jmk = ((TextView)paramView.findViewById(a.e.jdf));
    }
    if (this.fxt)
    {
      this.jmn.setVisibility(0);
      this.jmk.setVisibility(0);
    }
    for (;;)
    {
      if (this.jmm != null) {
        this.jmk.setText(this.jmm);
      }
      AppMethodBeat.o(13012);
      return;
      this.jmn.setVisibility(8);
      this.jmk.setVisibility(8);
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
      View.inflate(this.mContext, a.f.jeh, localViewGroup);
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