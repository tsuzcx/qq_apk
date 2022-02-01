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
import com.tencent.mm.plugin.game.h.a;
import com.tencent.mm.plugin.game.h.e;
import com.tencent.mm.plugin.game.h.f;
import com.tencent.mm.pluginsdk.ui.span.p;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack;
import java.util.ArrayList;
import java.util.List;

public class GameDetailAutoScrollView
  extends LinearLayout
{
  private MTimerHandler INf;
  private TextView IOA;
  private Animation IOB;
  private Animation IOC;
  private ArrayList<String> IOu;
  private ViewGroup IOv;
  private TextView IOw;
  private TextView IOx;
  private ViewGroup IOy;
  private TextView IOz;
  private int xYG;
  
  public GameDetailAutoScrollView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(41975);
    this.IOu = new ArrayList();
    this.xYG = 0;
    this.INf = new MTimerHandler(new MTimerHandler.CallBack()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(41974);
        GameDetailAutoScrollView.a(GameDetailAutoScrollView.this);
        AppMethodBeat.o(41974);
        return true;
      }
    }, true);
    this.IOv = ((ViewGroup)LayoutInflater.from(paramContext).inflate(h.f.HYV, this, false));
    this.IOw = ((TextView)this.IOv.findViewById(h.e.HUm));
    this.IOx = ((TextView)this.IOv.findViewById(h.e.HUn));
    addView(this.IOv);
    this.IOv.setVisibility(8);
    this.IOy = ((ViewGroup)LayoutInflater.from(paramContext).inflate(h.f.HYV, this, false));
    this.IOz = ((TextView)this.IOy.findViewById(h.e.HUm));
    this.IOA = ((TextView)this.IOy.findViewById(h.e.HUn));
    addView(this.IOy);
    this.IOy.setVisibility(8);
    this.IOB = AnimationUtils.loadAnimation(paramContext, h.a.slide_bottom_in);
    this.IOC = AnimationUtils.loadAnimation(paramContext, h.a.slide_top_out);
    AppMethodBeat.o(41975);
  }
  
  protected void onDetachedFromWindow()
  {
    AppMethodBeat.i(41977);
    super.onDetachedFromWindow();
    this.INf.stopTimer();
    AppMethodBeat.o(41977);
  }
  
  public void setText(List<String> paramList)
  {
    AppMethodBeat.i(41976);
    this.IOu.clear();
    this.INf.stopTimer();
    if ((paramList == null) || (paramList.size() == 0) || (paramList.size() % 2 != 0))
    {
      this.IOv.setVisibility(8);
      this.IOy.setVisibility(8);
      AppMethodBeat.o(41976);
      return;
    }
    this.IOu.addAll(paramList);
    this.xYG = 0;
    paramList = p.b(getContext(), (CharSequence)this.IOu.get(0), this.IOw.getTextSize());
    this.IOw.setText(paramList);
    this.IOx.setText((CharSequence)this.IOu.get(1));
    this.IOv.setVisibility(0);
    this.IOy.setVisibility(8);
    if (this.IOu.size() / 2 == 1)
    {
      AppMethodBeat.o(41976);
      return;
    }
    this.INf.startTimer(5000L);
    AppMethodBeat.o(41976);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.game.ui.GameDetailAutoScrollView
 * JD-Core Version:    0.7.0.1
 */