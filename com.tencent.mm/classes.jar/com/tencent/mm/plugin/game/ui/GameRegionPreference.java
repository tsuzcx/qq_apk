package com.tencent.mm.plugin.game.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.game.h.e;
import com.tencent.mm.plugin.game.h.f;
import com.tencent.mm.plugin.game.model.e;
import com.tencent.mm.ui.base.preference.Preference;

public class GameRegionPreference
  extends Preference
{
  a IUe;
  
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
    setLayoutResource(h.f.mm_preference);
    AppMethodBeat.o(42353);
  }
  
  public final void onBindView(View paramView)
  {
    AppMethodBeat.i(42355);
    super.onBindView(paramView);
    TextView localTextView = (TextView)paramView.findViewById(h.e.HXz);
    paramView = (CheckBox)paramView.findViewById(h.e.state_icon);
    if ((localTextView != null) && (paramView != null) && (this.IUe != null))
    {
      localTextView.setText(e.a(this.IUe));
      paramView.setChecked(this.IUe.isSelected);
    }
    AppMethodBeat.o(42355);
  }
  
  public final View onCreateView(ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(42354);
    paramViewGroup = super.onCreateView(paramViewGroup);
    LayoutInflater localLayoutInflater = (LayoutInflater)this.mContext.getSystemService("layout_inflater");
    ViewGroup localViewGroup = (ViewGroup)paramViewGroup.findViewById(h.e.content);
    localViewGroup.removeAllViews();
    localLayoutInflater.inflate(h.f.Iaf, localViewGroup);
    AppMethodBeat.o(42354);
    return paramViewGroup;
  }
  
  public static final class a
  {
    public String IUf;
    public String IUg;
    public String IUh;
    public boolean isSelected;
    public String kaj;
    public boolean oBZ;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.game.ui.GameRegionPreference
 * JD-Core Version:    0.7.0.1
 */