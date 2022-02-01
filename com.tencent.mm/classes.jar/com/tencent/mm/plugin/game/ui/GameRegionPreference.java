package com.tencent.mm.plugin.game.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.game.model.e;
import com.tencent.mm.ui.base.preference.Preference;

public class GameRegionPreference
  extends Preference
{
  a slU;
  
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
    setLayoutResource(2131494804);
    AppMethodBeat.o(42353);
  }
  
  public final void onBindView(View paramView)
  {
    AppMethodBeat.i(42355);
    super.onBindView(paramView);
    TextView localTextView = (TextView)paramView.findViewById(2131303961);
    paramView = (CheckBox)paramView.findViewById(2131305186);
    if ((localTextView != null) && (paramView != null) && (this.slU != null))
    {
      localTextView.setText(e.a(this.slU));
      paramView.setChecked(this.slU.ira);
    }
    AppMethodBeat.o(42355);
  }
  
  public final View onCreateView(ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(42354);
    paramViewGroup = super.onCreateView(paramViewGroup);
    LayoutInflater localLayoutInflater = (LayoutInflater)this.mContext.getSystemService("layout_inflater");
    ViewGroup localViewGroup = (ViewGroup)paramViewGroup.findViewById(2131298739);
    localViewGroup.removeAllViews();
    localLayoutInflater.inflate(2131494375, localViewGroup);
    AppMethodBeat.o(42354);
    return paramViewGroup;
  }
  
  public static final class a
  {
    public String evF;
    public boolean ira;
    public boolean isDefault;
    public String slV;
    public String slW;
    public String slX;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.game.ui.GameRegionPreference
 * JD-Core Version:    0.7.0.1
 */