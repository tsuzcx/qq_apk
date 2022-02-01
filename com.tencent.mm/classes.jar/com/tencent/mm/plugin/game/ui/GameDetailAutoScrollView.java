package com.tencent.mm.plugin.game.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pluginsdk.ui.span.k;
import com.tencent.mm.sdk.platformtools.au;
import com.tencent.mm.sdk.platformtools.au.a;
import java.util.ArrayList;
import java.util.List;

public class GameDetailAutoScrollView
  extends LinearLayout
{
  private int plF;
  private au tmI;
  private ArrayList<String> tnZ;
  private ViewGroup toa;
  private TextView tob;
  private TextView toc;
  private ViewGroup tod;
  private TextView toe;
  private TextView tof;
  private Animation tog;
  private Animation toh;
  
  public GameDetailAutoScrollView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(41975);
    this.tnZ = new ArrayList();
    this.plF = 0;
    this.tmI = new au(new au.a()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(41974);
        GameDetailAutoScrollView.a(GameDetailAutoScrollView.this);
        AppMethodBeat.o(41974);
        return true;
      }
    }, true);
    this.toa = ((ViewGroup)LayoutInflater.from(paramContext).inflate(2131494280, this, false));
    this.tob = ((TextView)this.toa.findViewById(2131300376));
    this.toc = ((TextView)this.toa.findViewById(2131300377));
    addView(this.toa);
    this.toa.setVisibility(8);
    this.tod = ((ViewGroup)LayoutInflater.from(paramContext).inflate(2131494280, this, false));
    this.toe = ((TextView)this.tod.findViewById(2131300376));
    this.tof = ((TextView)this.tod.findViewById(2131300377));
    addView(this.tod);
    this.tod.setVisibility(8);
    this.tog = AnimationUtils.loadAnimation(paramContext, 2130772139);
    this.toh = AnimationUtils.loadAnimation(paramContext, 2130772147);
    AppMethodBeat.o(41975);
  }
  
  protected void onDetachedFromWindow()
  {
    AppMethodBeat.i(41977);
    super.onDetachedFromWindow();
    this.tmI.stopTimer();
    AppMethodBeat.o(41977);
  }
  
  public void setText(List<String> paramList)
  {
    AppMethodBeat.i(41976);
    this.tnZ.clear();
    this.tmI.stopTimer();
    if ((paramList == null) || (paramList.size() == 0) || (paramList.size() % 2 != 0))
    {
      this.toa.setVisibility(8);
      this.tod.setVisibility(8);
      AppMethodBeat.o(41976);
      return;
    }
    this.tnZ.addAll(paramList);
    this.plF = 0;
    paramList = k.b(getContext(), (CharSequence)this.tnZ.get(0), this.tob.getTextSize());
    this.tob.setText(paramList);
    this.toc.setText((CharSequence)this.tnZ.get(1));
    this.toa.setVisibility(0);
    this.tod.setVisibility(8);
    if (this.tnZ.size() / 2 == 1)
    {
      AppMethodBeat.o(41976);
      return;
    }
    this.tmI.au(5000L, 5000L);
    AppMethodBeat.o(41976);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.game.ui.GameDetailAutoScrollView
 * JD-Core Version:    0.7.0.1
 */