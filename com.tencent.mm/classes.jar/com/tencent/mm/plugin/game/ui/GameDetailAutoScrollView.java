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
import com.tencent.mm.pluginsdk.ui.span.l;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack;
import java.util.ArrayList;
import java.util.List;

public class GameDetailAutoScrollView
  extends LinearLayout
{
  private int rmJ;
  private MTimerHandler xOF;
  private ArrayList<String> xPU;
  private ViewGroup xPV;
  private TextView xPW;
  private TextView xPX;
  private ViewGroup xPY;
  private TextView xPZ;
  private TextView xQa;
  private Animation xQb;
  private Animation xQc;
  
  public GameDetailAutoScrollView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(41975);
    this.xPU = new ArrayList();
    this.rmJ = 0;
    this.xOF = new MTimerHandler(new MTimerHandler.CallBack()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(41974);
        GameDetailAutoScrollView.a(GameDetailAutoScrollView.this);
        AppMethodBeat.o(41974);
        return true;
      }
    }, true);
    this.xPV = ((ViewGroup)LayoutInflater.from(paramContext).inflate(2131494842, this, false));
    this.xPW = ((TextView)this.xPV.findViewById(2131301899));
    this.xPX = ((TextView)this.xPV.findViewById(2131301900));
    addView(this.xPV);
    this.xPV.setVisibility(8);
    this.xPY = ((ViewGroup)LayoutInflater.from(paramContext).inflate(2131494842, this, false));
    this.xPZ = ((TextView)this.xPY.findViewById(2131301899));
    this.xQa = ((TextView)this.xPY.findViewById(2131301900));
    addView(this.xPY);
    this.xPY.setVisibility(8);
    this.xQb = AnimationUtils.loadAnimation(paramContext, 2130772164);
    this.xQc = AnimationUtils.loadAnimation(paramContext, 2130772172);
    AppMethodBeat.o(41975);
  }
  
  protected void onDetachedFromWindow()
  {
    AppMethodBeat.i(41977);
    super.onDetachedFromWindow();
    this.xOF.stopTimer();
    AppMethodBeat.o(41977);
  }
  
  public void setText(List<String> paramList)
  {
    AppMethodBeat.i(41976);
    this.xPU.clear();
    this.xOF.stopTimer();
    if ((paramList == null) || (paramList.size() == 0) || (paramList.size() % 2 != 0))
    {
      this.xPV.setVisibility(8);
      this.xPY.setVisibility(8);
      AppMethodBeat.o(41976);
      return;
    }
    this.xPU.addAll(paramList);
    this.rmJ = 0;
    paramList = l.b(getContext(), (CharSequence)this.xPU.get(0), this.xPW.getTextSize());
    this.xPW.setText(paramList);
    this.xPX.setText((CharSequence)this.xPU.get(1));
    this.xPV.setVisibility(0);
    this.xPY.setVisibility(8);
    if (this.xPU.size() / 2 == 1)
    {
      AppMethodBeat.o(41976);
      return;
    }
    this.xOF.startTimer(5000L);
    AppMethodBeat.o(41976);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.game.ui.GameDetailAutoScrollView
 * JD-Core Version:    0.7.0.1
 */