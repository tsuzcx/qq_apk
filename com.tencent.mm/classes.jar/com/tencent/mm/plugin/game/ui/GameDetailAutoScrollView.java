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
import com.tencent.mm.sdk.platformtools.av;
import com.tencent.mm.sdk.platformtools.av.a;
import java.util.ArrayList;
import java.util.List;

public class GameDetailAutoScrollView
  extends LinearLayout
{
  private int pPf;
  private av ulh;
  private TextView umA;
  private ViewGroup umB;
  private TextView umC;
  private TextView umD;
  private Animation umE;
  private Animation umF;
  private ArrayList<String> umx;
  private ViewGroup umy;
  private TextView umz;
  
  public GameDetailAutoScrollView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(41975);
    this.umx = new ArrayList();
    this.pPf = 0;
    this.ulh = new av(new av.a()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(41974);
        GameDetailAutoScrollView.a(GameDetailAutoScrollView.this);
        AppMethodBeat.o(41974);
        return true;
      }
    }, true);
    this.umy = ((ViewGroup)LayoutInflater.from(paramContext).inflate(2131494280, this, false));
    this.umz = ((TextView)this.umy.findViewById(2131300376));
    this.umA = ((TextView)this.umy.findViewById(2131300377));
    addView(this.umy);
    this.umy.setVisibility(8);
    this.umB = ((ViewGroup)LayoutInflater.from(paramContext).inflate(2131494280, this, false));
    this.umC = ((TextView)this.umB.findViewById(2131300376));
    this.umD = ((TextView)this.umB.findViewById(2131300377));
    addView(this.umB);
    this.umB.setVisibility(8);
    this.umE = AnimationUtils.loadAnimation(paramContext, 2130772139);
    this.umF = AnimationUtils.loadAnimation(paramContext, 2130772147);
    AppMethodBeat.o(41975);
  }
  
  protected void onDetachedFromWindow()
  {
    AppMethodBeat.i(41977);
    super.onDetachedFromWindow();
    this.ulh.stopTimer();
    AppMethodBeat.o(41977);
  }
  
  public void setText(List<String> paramList)
  {
    AppMethodBeat.i(41976);
    this.umx.clear();
    this.ulh.stopTimer();
    if ((paramList == null) || (paramList.size() == 0) || (paramList.size() % 2 != 0))
    {
      this.umy.setVisibility(8);
      this.umB.setVisibility(8);
      AppMethodBeat.o(41976);
      return;
    }
    this.umx.addAll(paramList);
    this.pPf = 0;
    paramList = k.b(getContext(), (CharSequence)this.umx.get(0), this.umz.getTextSize());
    this.umz.setText(paramList);
    this.umA.setText((CharSequence)this.umx.get(1));
    this.umy.setVisibility(0);
    this.umB.setVisibility(8);
    if (this.umx.size() / 2 == 1)
    {
      AppMethodBeat.o(41976);
      return;
    }
    this.ulh.az(5000L, 5000L);
    AppMethodBeat.o(41976);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.game.ui.GameDetailAutoScrollView
 * JD-Core Version:    0.7.0.1
 */