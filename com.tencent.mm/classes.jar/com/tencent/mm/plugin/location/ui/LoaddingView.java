package com.tencent.mm.plugin.location.ui;

import android.annotation.TargetApi;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.map.a.a;
import com.tencent.mm.plugin.map.a.e;
import com.tencent.mm.plugin.map.a.f;
import com.tencent.mm.sdk.platformtools.Util;

public class LoaddingView
  extends LinearLayout
  implements c
{
  private TextView Ell;
  private ProgressBar Elm;
  private View Eln;
  private boolean Elo;
  private String Elp;
  private Animation VT;
  
  public LoaddingView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(55802);
    this.Elo = false;
    this.Elp = "";
    init(paramContext);
    AppMethodBeat.o(55802);
  }
  
  @TargetApi(11)
  public LoaddingView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(55801);
    this.Elo = false;
    this.Elp = "";
    init(paramContext);
    AppMethodBeat.o(55801);
  }
  
  private void init(Context paramContext)
  {
    AppMethodBeat.i(55803);
    this.VT = AnimationUtils.loadAnimation(paramContext, a.a.translate_map);
    paramContext = LayoutInflater.from(paramContext).inflate(a.f.location_view, this, true);
    this.Elm = ((ProgressBar)paramContext.findViewById(a.e.location_load_progress));
    this.Ell = ((TextView)paramContext.findViewById(a.e.location_tips));
    this.Eln = paramContext.findViewById(a.e.location_here);
    this.Ell.setText("");
    this.Ell.setVisibility(0);
    this.Elm.setVisibility(0);
    AppMethodBeat.o(55803);
  }
  
  public String getPreText()
  {
    return this.Elp;
  }
  
  public void setPreText(String paramString)
  {
    AppMethodBeat.i(55806);
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(55806);
      return;
    }
    this.Elp = (paramString + "\n");
    AppMethodBeat.o(55806);
  }
  
  public void setProgressAlwaysGone(boolean paramBoolean)
  {
    AppMethodBeat.i(55804);
    this.Elo = paramBoolean;
    this.Elm.setVisibility(8);
    this.Ell.setVisibility(8);
    AppMethodBeat.o(55804);
  }
  
  public void setText(String paramString)
  {
    AppMethodBeat.i(55805);
    if ((this.Ell == null) || (this.Elm == null) || (this.Elo))
    {
      AppMethodBeat.o(55805);
      return;
    }
    if (!Util.isNullOrNil(paramString))
    {
      this.Ell.setText(String.valueOf(paramString));
      this.Elm.setVisibility(8);
      this.Ell.setVisibility(0);
      AppMethodBeat.o(55805);
      return;
    }
    this.Ell.setText("");
    this.Ell.setVisibility(0);
    this.Elm.setVisibility(0);
    AppMethodBeat.o(55805);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.location.ui.LoaddingView
 * JD-Core Version:    0.7.0.1
 */