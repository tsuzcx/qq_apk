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
import com.tencent.mm.sdk.platformtools.aw;
import com.tencent.mm.sdk.platformtools.aw.a;
import java.util.ArrayList;
import java.util.List;

public class AutoScrollTextView
  extends LinearLayout
{
  private int pVK;
  private TextView uHm;
  private TextView uHn;
  private aw uwE;
  private ArrayList<String> uxU;
  private Animation uyb;
  private Animation uyc;
  
  public AutoScrollTextView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(42571);
    this.uxU = new ArrayList();
    this.pVK = 0;
    this.uwE = new aw(new aw.a()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(42570);
        AutoScrollTextView.a(AutoScrollTextView.this);
        AppMethodBeat.o(42570);
        return true;
      }
    }, true);
    this.uHm = new TextView(paramContext, paramAttributeSet);
    this.uHm.setVisibility(8);
    this.uHn = new TextView(paramContext, paramAttributeSet);
    this.uHn.setVisibility(8);
    addView(this.uHm);
    addView(this.uHn);
    setOrientation(1);
    setGravity(17);
    setPadding(0, 0, 0, 0);
    this.uyb = AnimationUtils.loadAnimation(paramContext, 2130772139);
    this.uyc = AnimationUtils.loadAnimation(paramContext, 2130772147);
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
    this.uwE.stopTimer();
    AppMethodBeat.o(42574);
  }
  
  public void setText(List<String> paramList)
  {
    AppMethodBeat.i(42572);
    this.uxU.clear();
    this.uwE.stopTimer();
    if ((paramList == null) || (paramList.size() == 0))
    {
      this.uHm.setVisibility(8);
      this.uHn.setVisibility(8);
      AppMethodBeat.o(42572);
      return;
    }
    this.uxU.addAll(paramList);
    c(this.uHm, (String)this.uxU.get(0));
    this.uHm.setVisibility(0);
    this.pVK = 0;
    if (this.uxU.size() == 1)
    {
      AppMethodBeat.o(42572);
      return;
    }
    this.uwE.ay(5000L, 5000L);
    AppMethodBeat.o(42572);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.game.widget.AutoScrollTextView
 * JD-Core Version:    0.7.0.1
 */