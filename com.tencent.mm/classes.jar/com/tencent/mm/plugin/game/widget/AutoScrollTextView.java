package com.tencent.mm.plugin.game.widget;

import android.content.Context;
import android.text.SpannableString;
import android.util.AttributeSet;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.game.g.a;
import com.tencent.mm.pluginsdk.ui.span.l;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack;
import java.util.ArrayList;
import java.util.List;

public class AutoScrollTextView
  extends LinearLayout
{
  private MTimerHandler CSP;
  private ArrayList<String> CUd;
  private Animation CUk;
  private Animation CUl;
  private TextView Def;
  private TextView Deg;
  private int uPV;
  
  public AutoScrollTextView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(42571);
    this.CUd = new ArrayList();
    this.uPV = 0;
    this.CSP = new MTimerHandler(new MTimerHandler.CallBack()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(42570);
        AutoScrollTextView.a(AutoScrollTextView.this);
        AppMethodBeat.o(42570);
        return true;
      }
    }, true);
    this.Def = new TextView(paramContext, paramAttributeSet);
    this.Def.setVisibility(8);
    this.Deg = new TextView(paramContext, paramAttributeSet);
    this.Deg.setVisibility(8);
    addView(this.Def);
    addView(this.Deg);
    setOrientation(1);
    setGravity(17);
    setPadding(0, 0, 0, 0);
    this.CUk = AnimationUtils.loadAnimation(paramContext, g.a.slide_bottom_in);
    this.CUl = AnimationUtils.loadAnimation(paramContext, g.a.slide_top_out);
    AppMethodBeat.o(42571);
  }
  
  private void f(TextView paramTextView, String paramString)
  {
    AppMethodBeat.i(42573);
    paramTextView.setText(new SpannableString(l.b(getContext(), paramString, paramTextView.getTextSize())));
    AppMethodBeat.o(42573);
  }
  
  protected void onDetachedFromWindow()
  {
    AppMethodBeat.i(42574);
    super.onDetachedFromWindow();
    this.CSP.stopTimer();
    AppMethodBeat.o(42574);
  }
  
  public void setText(List<String> paramList)
  {
    AppMethodBeat.i(42572);
    this.CUd.clear();
    this.CSP.stopTimer();
    if ((paramList == null) || (paramList.size() == 0))
    {
      this.Def.setVisibility(8);
      this.Deg.setVisibility(8);
      AppMethodBeat.o(42572);
      return;
    }
    this.CUd.addAll(paramList);
    f(this.Def, (String)this.CUd.get(0));
    this.Def.setVisibility(0);
    this.uPV = 0;
    if (this.CUd.size() == 1)
    {
      AppMethodBeat.o(42572);
      return;
    }
    this.CSP.startTimer(5000L);
    AppMethodBeat.o(42572);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.game.widget.AutoScrollTextView
 * JD-Core Version:    0.7.0.1
 */