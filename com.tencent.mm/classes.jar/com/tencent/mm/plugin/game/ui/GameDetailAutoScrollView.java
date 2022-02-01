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
  private int oIf;
  private av seP;
  private ArrayList<String> sgg;
  private ViewGroup sgh;
  private TextView sgi;
  private TextView sgj;
  private ViewGroup sgk;
  private TextView sgl;
  private TextView sgm;
  private Animation sgn;
  private Animation sgo;
  
  public GameDetailAutoScrollView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(41975);
    this.sgg = new ArrayList();
    this.oIf = 0;
    this.seP = new av(new av.a()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(41974);
        GameDetailAutoScrollView.a(GameDetailAutoScrollView.this);
        AppMethodBeat.o(41974);
        return true;
      }
    }, true);
    this.sgh = ((ViewGroup)LayoutInflater.from(paramContext).inflate(2131494280, this, false));
    this.sgi = ((TextView)this.sgh.findViewById(2131300376));
    this.sgj = ((TextView)this.sgh.findViewById(2131300377));
    addView(this.sgh);
    this.sgh.setVisibility(8);
    this.sgk = ((ViewGroup)LayoutInflater.from(paramContext).inflate(2131494280, this, false));
    this.sgl = ((TextView)this.sgk.findViewById(2131300376));
    this.sgm = ((TextView)this.sgk.findViewById(2131300377));
    addView(this.sgk);
    this.sgk.setVisibility(8);
    this.sgn = AnimationUtils.loadAnimation(paramContext, 2130772139);
    this.sgo = AnimationUtils.loadAnimation(paramContext, 2130772147);
    AppMethodBeat.o(41975);
  }
  
  protected void onDetachedFromWindow()
  {
    AppMethodBeat.i(41977);
    super.onDetachedFromWindow();
    this.seP.stopTimer();
    AppMethodBeat.o(41977);
  }
  
  public void setText(List<String> paramList)
  {
    AppMethodBeat.i(41976);
    this.sgg.clear();
    this.seP.stopTimer();
    if ((paramList == null) || (paramList.size() == 0) || (paramList.size() % 2 != 0))
    {
      this.sgh.setVisibility(8);
      this.sgk.setVisibility(8);
      AppMethodBeat.o(41976);
      return;
    }
    this.sgg.addAll(paramList);
    this.oIf = 0;
    paramList = k.b(getContext(), (CharSequence)this.sgg.get(0), this.sgi.getTextSize());
    this.sgi.setText(paramList);
    this.sgj.setText((CharSequence)this.sgg.get(1));
    this.sgh.setVisibility(0);
    this.sgk.setVisibility(8);
    if (this.sgg.size() / 2 == 1)
    {
      AppMethodBeat.o(41976);
      return;
    }
    this.seP.av(5000L, 5000L);
    AppMethodBeat.o(41976);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.game.ui.GameDetailAutoScrollView
 * JD-Core Version:    0.7.0.1
 */