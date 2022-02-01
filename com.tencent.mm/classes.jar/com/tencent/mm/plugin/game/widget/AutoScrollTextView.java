package com.tencent.mm.plugin.game.widget;

import android.content.Context;
import android.text.SpannableString;
import android.util.AttributeSet;
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

public class AutoScrollTextView
  extends LinearLayout
{
  private int pPf;
  private av ulh;
  private Animation umE;
  private Animation umF;
  private ArrayList<String> umx;
  private TextView uvN;
  private TextView uvO;
  
  public AutoScrollTextView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(42571);
    this.umx = new ArrayList();
    this.pPf = 0;
    this.ulh = new av(new av.a()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(42570);
        AutoScrollTextView.a(AutoScrollTextView.this);
        AppMethodBeat.o(42570);
        return true;
      }
    }, true);
    this.uvN = new TextView(paramContext, paramAttributeSet);
    this.uvN.setVisibility(8);
    this.uvO = new TextView(paramContext, paramAttributeSet);
    this.uvO.setVisibility(8);
    addView(this.uvN);
    addView(this.uvO);
    setOrientation(1);
    setGravity(17);
    setPadding(0, 0, 0, 0);
    this.umE = AnimationUtils.loadAnimation(paramContext, 2130772139);
    this.umF = AnimationUtils.loadAnimation(paramContext, 2130772147);
    AppMethodBeat.o(42571);
  }
  
  private void c(TextView paramTextView, String paramString)
  {
    AppMethodBeat.i(42573);
    paramTextView.setText(new SpannableString(k.b(getContext(), paramString, paramTextView.getTextSize())));
    AppMethodBeat.o(42573);
  }
  
  protected void onDetachedFromWindow()
  {
    AppMethodBeat.i(42574);
    super.onDetachedFromWindow();
    this.ulh.stopTimer();
    AppMethodBeat.o(42574);
  }
  
  public void setText(List<String> paramList)
  {
    AppMethodBeat.i(42572);
    this.umx.clear();
    this.ulh.stopTimer();
    if ((paramList == null) || (paramList.size() == 0))
    {
      this.uvN.setVisibility(8);
      this.uvO.setVisibility(8);
      AppMethodBeat.o(42572);
      return;
    }
    this.umx.addAll(paramList);
    c(this.uvN, (String)this.umx.get(0));
    this.uvN.setVisibility(0);
    this.pPf = 0;
    if (this.umx.size() == 1)
    {
      AppMethodBeat.o(42572);
      return;
    }
    this.ulh.az(5000L, 5000L);
    AppMethodBeat.o(42572);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.game.widget.AutoScrollTextView
 * JD-Core Version:    0.7.0.1
 */