package com.tencent.mm.plugin.game.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.game.g.e;
import com.tencent.mm.plugin.game.g.f;
import com.tencent.mm.plugin.game.model.e;
import com.tencent.mm.ui.base.preference.Preference;

public class GameRegionPreference
  extends Preference
{
  a CZO;
  
  public GameRegionPreference(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public GameRegionPreference(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public GameRegionPreference(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(42353);
    setLayoutResource(g.f.mm_preference);
    AppMethodBeat.o(42353);
  }
  
  public final void onBindView(View paramView)
  {
    AppMethodBeat.i(42355);
    super.onBindView(paramView);
    TextView localTextView = (TextView)paramView.findViewById(g.e.Clr);
    paramView = (CheckBox)paramView.findViewById(g.e.state_icon);
    if ((localTextView != null) && (paramView != null) && (this.CZO != null))
    {
      localTextView.setText(e.a(this.CZO));
      paramView.setChecked(this.CZO.isSelected);
    }
    AppMethodBeat.o(42355);
  }
  
  public final View onCreateView(ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(42354);
    paramViewGroup = super.onCreateView(paramViewGroup);
    LayoutInflater localLayoutInflater = (LayoutInflater)this.mContext.getSystemService("layout_inflater");
    ViewGroup localViewGroup = (ViewGroup)paramViewGroup.findViewById(g.e.content);
    localViewGroup.removeAllViews();
    localLayoutInflater.inflate(g.f.CnX, localViewGroup);
    AppMethodBeat.o(42354);
    return paramViewGroup;
  }
  
  public static final class a
  {
    public String CZP;
    public String CZQ;
    public String CZR;
    public String hDn;
    public boolean isSelected;
    public boolean lJx;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.game.ui.GameRegionPreference
 * JD-Core Version:    0.7.0.1
 */