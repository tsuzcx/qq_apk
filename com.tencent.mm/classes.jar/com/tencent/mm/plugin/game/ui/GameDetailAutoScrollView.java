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
import com.tencent.mm.plugin.game.g.a;
import com.tencent.mm.plugin.game.g.e;
import com.tencent.mm.plugin.game.g.f;
import com.tencent.mm.pluginsdk.ui.span.l;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack;
import java.util.ArrayList;
import java.util.List;

public class GameDetailAutoScrollView
  extends LinearLayout
{
  private MTimerHandler CSP;
  private ArrayList<String> CUd;
  private ViewGroup CUe;
  private TextView CUf;
  private TextView CUg;
  private ViewGroup CUh;
  private TextView CUi;
  private TextView CUj;
  private Animation CUk;
  private Animation CUl;
  private int uPV;
  
  public GameDetailAutoScrollView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(41975);
    this.CUd = new ArrayList();
    this.uPV = 0;
    this.CSP = new MTimerHandler(new MTimerHandler.CallBack()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(41974);
        GameDetailAutoScrollView.a(GameDetailAutoScrollView.this);
        AppMethodBeat.o(41974);
        return true;
      }
    }, true);
    this.CUe = ((ViewGroup)LayoutInflater.from(paramContext).inflate(g.f.CmN, this, false));
    this.CUf = ((TextView)this.CUe.findViewById(g.e.Cie));
    this.CUg = ((TextView)this.CUe.findViewById(g.e.Cif));
    addView(this.CUe);
    this.CUe.setVisibility(8);
    this.CUh = ((ViewGroup)LayoutInflater.from(paramContext).inflate(g.f.CmN, this, false));
    this.CUi = ((TextView)this.CUh.findViewById(g.e.Cie));
    this.CUj = ((TextView)this.CUh.findViewById(g.e.Cif));
    addView(this.CUh);
    this.CUh.setVisibility(8);
    this.CUk = AnimationUtils.loadAnimation(paramContext, g.a.slide_bottom_in);
    this.CUl = AnimationUtils.loadAnimation(paramContext, g.a.slide_top_out);
    AppMethodBeat.o(41975);
  }
  
  protected void onDetachedFromWindow()
  {
    AppMethodBeat.i(41977);
    super.onDetachedFromWindow();
    this.CSP.stopTimer();
    AppMethodBeat.o(41977);
  }
  
  public void setText(List<String> paramList)
  {
    AppMethodBeat.i(41976);
    this.CUd.clear();
    this.CSP.stopTimer();
    if ((paramList == null) || (paramList.size() == 0) || (paramList.size() % 2 != 0))
    {
      this.CUe.setVisibility(8);
      this.CUh.setVisibility(8);
      AppMethodBeat.o(41976);
      return;
    }
    this.CUd.addAll(paramList);
    this.uPV = 0;
    paramList = l.b(getContext(), (CharSequence)this.CUd.get(0), this.CUf.getTextSize());
    this.CUf.setText(paramList);
    this.CUg.setText((CharSequence)this.CUd.get(1));
    this.CUe.setVisibility(0);
    this.CUh.setVisibility(8);
    if (this.CUd.size() / 2 == 1)
    {
      AppMethodBeat.o(41976);
      return;
    }
    this.CSP.startTimer(5000L);
    AppMethodBeat.o(41976);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.game.ui.GameDetailAutoScrollView
 * JD-Core Version:    0.7.0.1
 */