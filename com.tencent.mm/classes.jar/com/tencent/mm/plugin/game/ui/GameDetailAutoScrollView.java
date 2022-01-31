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
import com.tencent.mm.pluginsdk.ui.d.j;
import com.tencent.mm.sdk.platformtools.ap;
import java.util.ArrayList;
import java.util.List;

public class GameDetailAutoScrollView
  extends LinearLayout
{
  private int lrL;
  private ap nvk;
  private ArrayList<String> nwF;
  private ViewGroup nwG;
  private TextView nwH;
  private TextView nwI;
  private ViewGroup nwJ;
  private TextView nwK;
  private TextView nwL;
  private Animation nwM;
  private Animation nwN;
  
  public GameDetailAutoScrollView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(111807);
    this.nwF = new ArrayList();
    this.lrL = 0;
    this.nvk = new ap(new GameDetailAutoScrollView.1(this), true);
    this.nwG = ((ViewGroup)LayoutInflater.from(paramContext).inflate(2130969727, this, false));
    this.nwH = ((TextView)this.nwG.findViewById(2131824571));
    this.nwI = ((TextView)this.nwG.findViewById(2131824572));
    addView(this.nwG);
    this.nwG.setVisibility(8);
    this.nwJ = ((ViewGroup)LayoutInflater.from(paramContext).inflate(2130969727, this, false));
    this.nwK = ((TextView)this.nwJ.findViewById(2131824571));
    this.nwL = ((TextView)this.nwJ.findViewById(2131824572));
    addView(this.nwJ);
    this.nwJ.setVisibility(8);
    this.nwM = AnimationUtils.loadAnimation(paramContext, 2131034261);
    this.nwN = AnimationUtils.loadAnimation(paramContext, 2131034269);
    AppMethodBeat.o(111807);
  }
  
  protected void onDetachedFromWindow()
  {
    AppMethodBeat.i(111809);
    super.onDetachedFromWindow();
    this.nvk.stopTimer();
    AppMethodBeat.o(111809);
  }
  
  public void setText(List<String> paramList)
  {
    AppMethodBeat.i(111808);
    this.nwF.clear();
    this.nvk.stopTimer();
    if ((paramList == null) || (paramList.size() == 0) || (paramList.size() % 2 != 0))
    {
      this.nwG.setVisibility(8);
      this.nwJ.setVisibility(8);
      AppMethodBeat.o(111808);
      return;
    }
    this.nwF.addAll(paramList);
    this.lrL = 0;
    paramList = j.b(getContext(), (CharSequence)this.nwF.get(0), this.nwH.getTextSize());
    this.nwH.setText(paramList);
    this.nwI.setText((CharSequence)this.nwF.get(1));
    this.nwG.setVisibility(0);
    this.nwJ.setVisibility(8);
    if (this.nwF.size() / 2 == 1)
    {
      AppMethodBeat.o(111808);
      return;
    }
    this.nvk.ag(5000L, 5000L);
    AppMethodBeat.o(111808);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.game.ui.GameDetailAutoScrollView
 * JD-Core Version:    0.7.0.1
 */